package net.sourceforge.fenixedu.dataTransferObject.assiduousness;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.sourceforge.fenixedu.domain.Employee;
import net.sourceforge.fenixedu.domain.assiduousness.Schedule;
import net.sourceforge.fenixedu.domain.assiduousness.WorkSchedule;
import net.sourceforge.fenixedu.domain.assiduousness.WorkScheduleType;
import net.sourceforge.fenixedu.domain.organizationalStructure.Contract;
import net.sourceforge.fenixedu.domain.util.FactoryExecutor;

import org.apache.commons.beanutils.BeanComparator;
import org.joda.time.LocalDate;

public class EmployeeScheduleFactory implements Serializable, FactoryExecutor {

    WorkScheduleType choosenWorkSchedule;

    Employee employee;

    Employee modifiedBy;

    Schedule schedule;

    LocalDate beginDate;

    LocalDate endDate;

    boolean differencesInWorkSchedules;

    boolean differencesInDates;

    boolean toDeleteDays;

    List<EmployeeWorkWeekScheduleBean> employeeWorkWeekScheduleList = new ArrayList<EmployeeWorkWeekScheduleBean>();

    public EmployeeScheduleFactory(Schedule schedule, Employee modifiedBy) {
	init(schedule.getAssiduousness().getEmployee(), modifiedBy, schedule, schedule.getBeginDate(), schedule.getEndDate());
    }

    public EmployeeScheduleFactory(Employee employee, Employee modifiedBy) {
	LocalDate beginDate = null;
	Schedule schedule = employee.getAssiduousness() != null ? employee.getAssiduousness().getLastSchedule() : null;
	if (schedule != null) {
	    beginDate = schedule.getEndDate() != null ? schedule.getEndDate().plusDays(1) : null;
	} else {
	    Contract currentContract = employee.getCurrentWorkingContract();
	    if (currentContract != null) {
		beginDate = currentContract.getBeginDate().toLocalDate();
	    }
	}
	init(employee, modifiedBy, null, beginDate, null);
    }

    public EmployeeScheduleFactory(Employee employee, Employee modifiedBy, Schedule schedule) {
	LocalDate beginDate = null;
	LocalDate endDate = null;
	if (schedule == null) {
	    schedule = employee.getAssiduousness() != null ? employee.getAssiduousness().getCurrentSchedule() : null;
	}
	if (schedule != null) {
	    beginDate = schedule.getBeginDate();
	    endDate = schedule.getEndDate();
	} else {
	    Contract currentContract = employee.getCurrentWorkingContract();
	    if (currentContract != null) {
		beginDate = currentContract.getBeginDate().toLocalDate();
	    }
	}
	init(employee, modifiedBy, schedule, beginDate, endDate);
    }

    protected void init(Employee employee, Employee modifiedBy, Schedule schedule, LocalDate beginDate, LocalDate endDate) {
	setModifiedBy(modifiedBy);
	setEmployee(employee);
	setSchedule(schedule);
	if (schedule != null) {
	    setEmployeeWorkWeekScheduleList(schedule, this);
	} else {
	    addEmployeeWorkWeekSchedule();
	}
	setBeginDate(beginDate);
	setEndDate(endDate);
    }

    public Object execute() {
	Schedule schedule = getSchedule();
	removeAllEmptyWorkWeekSchedules();
	if (isToDeleteDays()) {
	    schedule = schedule.deleteDays(this);
	} else {
	    if (schedule == null) {
		schedule = new Schedule(this);
	    } else {
		schedule = schedule.edit(this);
	    }
	}
	return schedule;
    }

    public void setEmployee(Employee employee) {
	if (employee != null) {
	    this.employee = employee;
	} else {
	    this.employee = null;
	}
    }

    public Employee getEmployee() {
	return employee;
    }

    public List<EmployeeWorkWeekScheduleBean> getEmployeeWorkWeekScheduleList() {
	return employeeWorkWeekScheduleList;
    }

    public void setEmployeeWorkWeekScheduleList(Schedule schedule, EmployeeScheduleFactory employeeScheduleFactory) {
	for (WorkSchedule workSchedule : schedule.getWorkSchedules()) {
	    EmployeeWorkWeekScheduleBean employeeWorkWeekScheduleBean = getEmployeeWorkWeekScheduleByWeek(workSchedule
		    .getPeriodicity().getWorkWeekNumber());
	    if (employeeWorkWeekScheduleBean != null) {
		employeeWorkWeekScheduleBean.edit(workSchedule);
	    } else {
		this.employeeWorkWeekScheduleList.add(new EmployeeWorkWeekScheduleBean(workSchedule, employeeScheduleFactory));
	    }
	}
	Collections.sort(getEmployeeWorkWeekScheduleList(), new BeanComparator("workWeekNumber"));
    }

    private EmployeeWorkWeekScheduleBean getEmployeeWorkWeekScheduleByWeek(Integer workWeekNumber) {
	for (EmployeeWorkWeekScheduleBean workWeekScheduleBean : getEmployeeWorkWeekScheduleList()) {
	    if (workWeekScheduleBean.getWorkWeekNumber().equals(workWeekNumber)) {
		return workWeekScheduleBean;
	    }
	}
	return null;
    }

    public void addEmployeeWorkWeekSchedule() {
	Integer maxWeek = 0;
	for (EmployeeWorkWeekScheduleBean employeeWorkWeekScheduleBean : getEmployeeWorkWeekScheduleList()) {
	    if (employeeWorkWeekScheduleBean.getWorkWeekNumber() > maxWeek) {
		maxWeek = employeeWorkWeekScheduleBean.getWorkWeekNumber();
	    }
	}
	getEmployeeWorkWeekScheduleList().add(new EmployeeWorkWeekScheduleBean(maxWeek + 1, this));
	Collections.sort(getEmployeeWorkWeekScheduleList(), new BeanComparator("workWeekNumber"));
    }

    public Employee getModifiedBy() {
	return modifiedBy;
    }

    public void setModifiedBy(Employee modifiedBy) {
	if (modifiedBy != null) {
	    this.modifiedBy = modifiedBy;
	} else {
	    this.modifiedBy = null;
	}
    }

    public LocalDate getBeginDate() {
	return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
	this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
	return endDate;
    }

    public void setEndDate(LocalDate endDate) {
	this.endDate = endDate;
    }

    public WorkScheduleType getChoosenWorkSchedule() {
	return choosenWorkSchedule;
    }

    public void setChoosenWorkSchedule(WorkScheduleType choosenWorkSchedule) {
	if (choosenWorkSchedule != null) {
	    this.choosenWorkSchedule = choosenWorkSchedule;
	} else {
	    this.choosenWorkSchedule = null;
	}
    }

    public boolean equalDates(Schedule schedule) {
	if (getBeginDate().isEqual(schedule.getBeginDate())
		&& ((getEndDate() == null && schedule.getEndDate() == null) || (getEndDate() != null
			&& schedule.getEndDate() != null && getEndDate().isEqual(schedule.getEndDate())))) {
	    return true;
	}
	return false;
    }

    public boolean isDifferencesInWorkSchedules() {
	return differencesInWorkSchedules;
    }

    public void setDifferencesInWorkSchedules(boolean differencesInWorkSchedules) {
	this.differencesInWorkSchedules = differencesInWorkSchedules;
    }

    public boolean isDifferencesInDates() {
	return differencesInDates;
    }

    public void setDifferencesInDates(boolean differencesInDates) {
	this.differencesInDates = differencesInDates;
    }

    public void removeEmployeeWorkWeekSchedule() {
	int subtract = 0;
	EmployeeWorkWeekScheduleBean workWeekScheduleBeanToRemove = null;
	for (EmployeeWorkWeekScheduleBean workWeekScheduleBean : getEmployeeWorkWeekScheduleList()) {
	    if (workWeekScheduleBean.getIsEmptyWeek() && workWeekScheduleBeanToRemove == null) {
		workWeekScheduleBeanToRemove = workWeekScheduleBean;
		subtract = 1;
	    }
	    workWeekScheduleBean.setWorkWeekNumber(workWeekScheduleBean.getWorkWeekNumber() - subtract);
	}
	getEmployeeWorkWeekScheduleList().remove(workWeekScheduleBeanToRemove);
    }

    public void removeAllEmptyWorkWeekSchedules() {
	int subtract = 0;
	List<EmployeeWorkWeekScheduleBean> workWeekScheduleBeansToRemove = new ArrayList<EmployeeWorkWeekScheduleBean>();
	for (EmployeeWorkWeekScheduleBean workWeekScheduleBean : getEmployeeWorkWeekScheduleList()) {
	    if (!workWeekScheduleBean.isAnyDayChecked() && workWeekScheduleBean.getIsEmptyWeek()) {
		workWeekScheduleBeansToRemove.add(workWeekScheduleBean);
		subtract++;
	    } else {
		workWeekScheduleBean.setWorkWeekNumber(workWeekScheduleBean.getWorkWeekNumber() - subtract);
	    }
	}
	getEmployeeWorkWeekScheduleList().removeAll(workWeekScheduleBeansToRemove);
    }

    public void selectAllCheckBoxes(Integer workWeek) {
	for (EmployeeWorkWeekScheduleBean workWeekScheduleBean : getEmployeeWorkWeekScheduleList()) {
	    if (workWeekScheduleBean.getWorkWeekNumber().equals(workWeek)) {
		workWeekScheduleBean.checkAllWeek();
		break;
	    }
	}
    }

    public boolean isToDeleteDays() {
	return toDeleteDays;
    }

    public void setToDeleteDays(boolean toDeleteDays) {
	this.toDeleteDays = toDeleteDays;
    }

    public Schedule getSchedule() {
	return schedule;
    }

    public void setSchedule(Schedule schedule) {
	if (schedule != null) {
	    this.schedule = schedule;
	}
    }
}
