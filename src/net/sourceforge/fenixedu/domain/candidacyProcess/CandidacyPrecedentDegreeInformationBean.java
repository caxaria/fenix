package net.sourceforge.fenixedu.domain.candidacyProcess;

import java.io.Serializable;
import java.math.BigDecimal;

import net.sourceforge.fenixedu.domain.Country;
import net.sourceforge.fenixedu.domain.RootDomainObject;
import net.sourceforge.fenixedu.domain.StudentCurricularPlan;
import net.sourceforge.fenixedu.domain.degreeStructure.CycleType;
import net.sourceforge.fenixedu.domain.organizationalStructure.Unit;
import net.sourceforge.fenixedu.domain.organizationalStructure.UnitName;
import net.sourceforge.fenixedu.domain.student.curriculum.AverageType;
import net.sourceforge.fenixedu.domain.student.curriculum.Curriculum;

import org.joda.time.LocalDate;

public class CandidacyPrecedentDegreeInformationBean implements Serializable {
    private CandidacyPrecedentDegreeInformation precedentDegreeInformation;
    private String degreeDesignation;
    private LocalDate conclusionDate;
    private Unit institution;
    private String institutionName;
    private String conclusionGrade;
    private Integer numberOfEnroledCurricularCourses;
    private Integer numberOfApprovedCurricularCourses;
    private BigDecimal gradeSum;
    private BigDecimal approvedEcts;
    private BigDecimal enroledEcts;
    private Country country;

    public CandidacyPrecedentDegreeInformationBean() {
    }

    public CandidacyPrecedentDegreeInformationBean(final CandidacyPrecedentDegreeInformation precedentDegreeInformation) {
	setPrecedentDegreeInformation(precedentDegreeInformation);
	setDegreeDesignation(precedentDegreeInformation.getDegreeDesignation());
	setConclusionDate(precedentDegreeInformation.getConclusionDate());
	setConclusionGrade(precedentDegreeInformation.getConclusionGrade());
	setInstitutionValue(precedentDegreeInformation);
	setInstitutionName(precedentDegreeInformation.getInstitution().getName());
	setCountry(precedentDegreeInformation.getCountry());
    }

    public CandidacyPrecedentDegreeInformationBean(final StudentCurricularPlan studentCurricularPlan) {
	if (studentCurricularPlan.isBolonhaDegree()
		|| !studentCurricularPlan.getRegistration().isRegistrationConclusionProcessed()) {
	    throw new IllegalArgumentException("error.studentCurricularPlan.must.be.pre.bolonha.and.concluded");
	}

	setDegreeDesignation(studentCurricularPlan.getName());
	setConclusionDate(new LocalDate(studentCurricularPlan.getRegistration().getConclusionDate()));
	setConclusionGrade(studentCurricularPlan.getRegistration().getFinalAverage());
	setInstitutionUnitName(RootDomainObject.getInstance().getInstitutionUnit().getUnitName());
    }

    public CandidacyPrecedentDegreeInformationBean(final StudentCurricularPlan studentCurricularPlan, final CycleType cycleType) {
	if (!studentCurricularPlan.isBolonhaDegree() || cycleType == null) {
	    throw new IllegalArgumentException();
	}

	setDegreeDesignation(studentCurricularPlan.getName());
	setInstitutionUnitName(RootDomainObject.getInstance().getInstitutionUnit().getUnitName());

	if (studentCurricularPlan.getConclusionDate(cycleType) != null) {
	    setConclusionDate(new LocalDate(studentCurricularPlan.getConclusionDate(cycleType)));
	}
	if (studentCurricularPlan.getFinalAverage(cycleType) != null) {
	    setConclusionGrade(studentCurricularPlan.getFinalAverage(cycleType));
	}
    }

    public void initCurricularCoursesInformation(final CandidacyPrecedentDegreeInformation precedentDegreeInformation) {
	setNumberOfEnroledCurricularCourses(precedentDegreeInformation.getNumberOfEnroledCurricularCourses());
	setNumberOfApprovedCurricularCourses(precedentDegreeInformation.getNumberOfApprovedCurricularCourses());
	setGradeSum(precedentDegreeInformation.getGradeSum());
	setApprovedEcts(precedentDegreeInformation.getApprovedEcts());
	setEnroledEcts(precedentDegreeInformation.getEnroledEcts());
    }

    public void initCurricularCoursesInformation(final StudentCurricularPlan studentCurricularPlan) {
	setNumberOfEnroledCurricularCourses(studentCurricularPlan.getRoot().getNumberOfAllEnroledCurriculumLines());
	setNumberOfApprovedCurricularCourses(studentCurricularPlan.getRoot().getNumberOfAllApprovedCurriculumLines());
	setApprovedEcts(BigDecimal.valueOf(studentCurricularPlan.getRoot().getAprovedEctsCredits()));
	setEnroledEcts(BigDecimal.valueOf(studentCurricularPlan.getRoot().getEctsCredits()));

	final Curriculum curriculum = studentCurricularPlan.getRoot().getCurriculum();
	curriculum.setAverageType(AverageType.SIMPLE);
	setGradeSum(curriculum.getSumPiCi());
    }

    private void setInstitutionValue(final CandidacyPrecedentDegreeInformation precedentDegreeInformation) {
	institution = precedentDegreeInformation.hasInstitution() ? precedentDegreeInformation.getInstitution() : null;
    }

    public String getDegreeDesignation() {
	return degreeDesignation;
    }

    public void setDegreeDesignation(String degreeDesignation) {
	this.degreeDesignation = degreeDesignation;
    }

    public LocalDate getConclusionDate() {
	return conclusionDate;
    }

    public void setConclusionDate(LocalDate conclusionDate) {
	this.conclusionDate = conclusionDate;
    }

    public UnitName getInstitutionUnitName() {
	return (institution == null) ? null : institution.getUnitName();
    }

    public void setInstitutionUnitName(UnitName institutionUnitName) {
	this.institution = (institutionUnitName == null) ? null : institutionUnitName.getUnit();
    }

    public String getInstitutionName() {
	return institutionName;
    }

    public Unit getInstitution() {
	return getInstitutionUnitName() != null ? getInstitutionUnitName().getUnit() : null;
    }

    public void setInstitutionName(String institutionName) {
	this.institutionName = institutionName;
    }

    public String getConclusionGrade() {
	return conclusionGrade;
    }

    public void setConclusionGrade(String conclusionGrade) {
	this.conclusionGrade = conclusionGrade;
    }

    public void setConclusionGrade(final Integer conclusionGrade) {
	this.conclusionGrade = String.valueOf(conclusionGrade);
    }

    public CandidacyPrecedentDegreeInformation getPrecedentDegreeInformation() {
	return this.precedentDegreeInformation;
    }

    public void setPrecedentDegreeInformation(final CandidacyPrecedentDegreeInformation precedentDegreeInformation) {
	this.precedentDegreeInformation = precedentDegreeInformation;
    }

    public Integer getNumberOfEnroledCurricularCourses() {
	return numberOfEnroledCurricularCourses;
    }

    public void setNumberOfEnroledCurricularCourses(Integer numberOfEnroledCurricularCourses) {
	this.numberOfEnroledCurricularCourses = numberOfEnroledCurricularCourses;
    }

    public Integer getNumberOfApprovedCurricularCourses() {
	return numberOfApprovedCurricularCourses;
    }

    public void setNumberOfApprovedCurricularCourses(Integer numberOfApprovedCurricularCourses) {
	this.numberOfApprovedCurricularCourses = numberOfApprovedCurricularCourses;
    }

    public BigDecimal getGradeSum() {
	return gradeSum;
    }

    public void setGradeSum(BigDecimal gradeSum) {
	this.gradeSum = gradeSum;
    }

    public BigDecimal getApprovedEcts() {
	return approvedEcts;
    }

    public void setApprovedEcts(BigDecimal approvedEcts) {
	this.approvedEcts = approvedEcts;
    }

    public BigDecimal getEnroledEcts() {
	return enroledEcts;
    }

    public void setEnroledEcts(BigDecimal enroledEcts) {
	this.enroledEcts = enroledEcts;
    }

    public Country getCountry() {
	return this.country;
    }

    public void setCountry(Country country) {
	this.country = country;
    }
}
