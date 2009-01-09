package net.sourceforge.fenixedu.presentationTier.Action.resourceAllocationManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sourceforge.fenixedu.applicationTier.Filtro.exception.FenixFilterException;
import net.sourceforge.fenixedu.applicationTier.Servico.exceptions.FenixServiceException;
import net.sourceforge.fenixedu.applicationTier.Servico.exceptions.FenixServiceMultipleException;
import net.sourceforge.fenixedu.applicationTier.Servico.resourceAllocationManager.CriarTurno;
import net.sourceforge.fenixedu.applicationTier.Servico.resourceAllocationManager.DeleteShift;
import net.sourceforge.fenixedu.applicationTier.Servico.resourceAllocationManager.DeleteShifts;
import net.sourceforge.fenixedu.applicationTier.Servico.resourceAllocationManager.ReadShiftsByExecutionPeriodAndExecutionDegreeAndCurricularYear;
import net.sourceforge.fenixedu.dataTransferObject.InfoCurricularYear;
import net.sourceforge.fenixedu.dataTransferObject.InfoExecutionCourse;
import net.sourceforge.fenixedu.dataTransferObject.InfoExecutionDegree;
import net.sourceforge.fenixedu.dataTransferObject.InfoShift;
import net.sourceforge.fenixedu.dataTransferObject.InfoShiftEditor;
import net.sourceforge.fenixedu.dataTransferObject.resourceAllocationManager.ContextSelectionBean;
import net.sourceforge.fenixedu.domain.ShiftType;
import net.sourceforge.fenixedu.domain.exceptions.DomainException;
import net.sourceforge.fenixedu.presentationTier.Action.resourceAllocationManager.base.FenixExecutionDegreeAndCurricularYearContextDispatchAction;
import net.sourceforge.fenixedu.presentationTier.Action.resourceAllocationManager.utils.RequestUtils;
import net.sourceforge.fenixedu.presentationTier.Action.resourceAllocationManager.utils.SessionConstants;
import net.sourceforge.fenixedu.presentationTier.Action.resourceAllocationManager.utils.SessionUtils;
import net.sourceforge.fenixedu.presentationTier.Action.utils.ContextUtils;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.util.LabelValueBean;

/**
 * @author Luis Cruz & Sara Ribeiro
 * 
 */
public class ManageShiftsDA extends FenixExecutionDegreeAndCurricularYearContextDispatchAction {

    public ActionForward listShifts(ActionMapping mapping, ActionForm form, HttpServletRequest request,
	    HttpServletResponse response) throws Exception {

	readAndSetInfoToManageShifts(request);
	return mapping.findForward("ShowShiftList");
    }

    public ActionForward listExecutionCourseCourseLoads(ActionMapping mapping, ActionForm form, HttpServletRequest request,
	    HttpServletResponse response) throws Exception {

	readAndSetInfoToManageShifts(request);

	DynaActionForm createShiftForm = (DynaActionForm) form;
	InfoExecutionCourse infoExecutionCourse = RequestUtils.getExecutionCourseBySigla(request, (String) createShiftForm
		.get("courseInitials"));

	if (infoExecutionCourse != null) {
	    final List<LabelValueBean> tiposAula = new ArrayList<LabelValueBean>();
	    final ResourceBundle bundle = ResourceBundle.getBundle("resources.EnumerationResources", request.getLocale());

	    for (final ShiftType shiftType : infoExecutionCourse.getExecutionCourse().getShiftTypes()) {
		tiposAula.add(new LabelValueBean(bundle.getString(shiftType.getName()), shiftType.name()));
	    }

	    request.setAttribute("tiposAula", tiposAula);
	}

	return mapping.findForward("ShowShiftList");
    }

    public ActionForward createShift(ActionMapping mapping, ActionForm form, HttpServletRequest request,
	    HttpServletResponse response) throws Exception {

	DynaActionForm createShiftForm = (DynaActionForm) form;

	InfoShiftEditor infoShift = new InfoShiftEditor();
	infoShift.setAvailabilityFinal(new Integer(0));
	InfoExecutionCourse infoExecutionCourse = RequestUtils.getExecutionCourseBySigla(request, (String) createShiftForm
		.get("courseInitials"));
	infoShift.setInfoDisciplinaExecucao(infoExecutionCourse);
	infoShift.setInfoLessons(null);
	infoShift.setLotacao((Integer) createShiftForm.get("lotacao"));
	infoShift.setNome((String) createShiftForm.get("nome"));

	String[] selectedShiftTypes = (String[]) createShiftForm.get("shiftTiposAula");
	if (selectedShiftTypes.length == 0) {
	    ActionErrors actionErrors = new ActionErrors();
	    actionErrors.add("errors.shift.types.notSelected", new ActionError("errors.shift.types.notSelected"));
	    saveErrors(request, actionErrors);
	    return mapping.getInputForward();
	}

	final List<ShiftType> shiftTypes = new ArrayList<ShiftType>();
	for (int i = 0; i < selectedShiftTypes.length; i++) {
	    shiftTypes.add(ShiftType.valueOf(selectedShiftTypes[i].toString()));
	}

	infoShift.setTipos(shiftTypes);

	// try {
	final InfoShift newInfoShift = CriarTurno.run(infoShift);
	request.setAttribute(SessionConstants.SHIFT, newInfoShift);

	// } catch (ExistingServiceException ex) {
	// throw new ExistingActionException("O Shift", ex);
	// }

	request.setAttribute(SessionConstants.EXECUTION_COURSE, infoExecutionCourse);

	return mapping.findForward("EditShift");
    }

    public ActionForward deleteShift(ActionMapping mapping, ActionForm form, HttpServletRequest request,
	    HttpServletResponse response) throws Exception {

	ContextUtils.setShiftContext(request);

	InfoShift infoShiftToDelete = (InfoShift) request.getAttribute(SessionConstants.SHIFT);

	try {
	    DeleteShift.run(infoShiftToDelete);
	} catch (FenixServiceException exception) {
	    ActionErrors actionErrors = new ActionErrors();
	    if (exception.getMessage() != null && exception.getMessage().length() > 0) {
		actionErrors.add("errors.deleteshift", new ActionError(exception.getMessage(), exception.getArgs()));
	    } else {
		actionErrors.add("errors.deleteshift", new ActionError("error.deleteShift"));
	    }
	    saveErrors(request, actionErrors);
	    return mapping.getInputForward();
	}

	return listShifts(mapping, form, request, response);
    }

    public ActionForward deleteShifts(ActionMapping mapping, ActionForm form, HttpServletRequest request,
	    HttpServletResponse response) throws Exception {
	DynaActionForm deleteShiftsForm = (DynaActionForm) form;
	String[] selectedShifts = (String[]) deleteShiftsForm.get("selectedItems");

	if (selectedShifts.length == 0) {
	    ActionErrors actionErrors = new ActionErrors();
	    actionErrors.add("errors.shifts.notSelected", new ActionError("errors.shifts.notSelected"));
	    saveErrors(request, actionErrors);
	    return mapping.getInputForward();
	}

	final List<Integer> shiftOIDs = new ArrayList<Integer>();
	for (int i = 0; i < selectedShifts.length; i++) {
	    shiftOIDs.add(Integer.valueOf(selectedShifts[i]));
	}

	try {
	    DeleteShifts.run(shiftOIDs);
	} catch (FenixServiceMultipleException e) {
	    final ActionErrors actionErrors = new ActionErrors();

	    for (final DomainException domainException : e.getExceptionList()) {
		actionErrors.add(domainException.getMessage(), new ActionError(domainException.getMessage(), domainException
			.getArgs()));
	    }
	    saveErrors(request, actionErrors);

	    return mapping.getInputForward();
	}

	return mapping.findForward("ShowShiftList");
    }

    private void readAndSetInfoToManageShifts(HttpServletRequest request) throws FenixServiceException, FenixFilterException,
	    Exception {
	ContextSelectionBean context = (ContextSelectionBean) request.getAttribute(SessionConstants.CONTEXT_SELECTION_BEAN);

	List<InfoShift> infoShifts = ReadShiftsByExecutionPeriodAndExecutionDegreeAndCurricularYear.run(context
		.getAcademicInterval(), new InfoExecutionDegree(context.getExecutionDegree()), new InfoCurricularYear(context
		.getCurricularYear()));

	Collections.sort(infoShifts, InfoShift.SHIFT_COMPARATOR_BY_TYPE_AND_ORDERED_LESSONS);

	if (infoShifts != null && !infoShifts.isEmpty()) {
	    request.setAttribute(SessionConstants.SHIFTS, infoShifts);
	}

	SessionUtils.getExecutionCourses(request);
    }
}