package net.sourceforge.fenixedu.dataTransferObject.assiduousness;

import java.io.Serializable;

import net.sourceforge.fenixedu.domain.Employee;
import net.sourceforge.fenixedu.domain.assiduousness.EmployeeExtraWorkAuthorization;
import net.sourceforge.fenixedu.domain.assiduousness.ExtraWorkAuthorization;

public class EmployeeExtraWorkAuthorizationBean implements Serializable {
    Boolean delete;

    Boolean normalExtraWork;

    Boolean normalExtraWorkPlusTwoHours;

    Boolean normalExtraWorkPlusOneHundredHours;

    Boolean nightExtraWork;

    Boolean weeklyRestExtraWork;

    Boolean auxiliarPersonel;

    Boolean executiveAuxiliarPersonel;

    String employeeNumber;

    Employee employee;

    ExtraWorkAuthorization extraWorkAuthorization;

    EmployeeExtraWorkAuthorization employeeExtraWorkAuthorization;

    Employee modifiedBy;

    public EmployeeExtraWorkAuthorizationBean(ExtraWorkAuthorization extraWorkAuthorization,
	    EmployeeExtraWorkAuthorization employeeExtraWorkAuthorization) {
	setExtraWorkAuthorization(extraWorkAuthorization);
	setEmployeeExtraWorkAuthorization(employeeExtraWorkAuthorization);
	setEmployee(employeeExtraWorkAuthorization.getAssiduousness().getEmployee());
	setModifiedBy(employeeExtraWorkAuthorization.getModifiedBy());
	setNormalExtraWork(employeeExtraWorkAuthorization.getNormalExtraWork());
	setNormalExtraWorkPlusTwoHours(employeeExtraWorkAuthorization.getNormalExtraWorkPlusTwoHours());
	setNormalExtraWorkPlusOneHundredHours(employeeExtraWorkAuthorization.getNormalExtraWorkPlusOneHundredHours());
	setNightExtraWork(employeeExtraWorkAuthorization.getNightExtraWork());
	setWeeklyRestExtraWork(employeeExtraWorkAuthorization.getWeeklyRestExtraWork());
	setAuxiliarPersonel(employeeExtraWorkAuthorization.getAuxiliarPersonel());
	setExecutiveAuxiliarPersonel(employeeExtraWorkAuthorization.getExecutiveAuxiliarPersonel());
	setDelete(false);
    }

    public EmployeeExtraWorkAuthorizationBean(Employee modifiedBy) {
	setModifiedBy(modifiedBy);
    }

    public Employee getEmployee() {
	return employee;
    }

    public void setEmployee(Employee employee) {
	if (employee != null) {
	    this.employee = employee;
	} else {
	    this.employee = null;
	}
    }

    public EmployeeExtraWorkAuthorization getEmployeeExtraWorkAuthorization() {
	return employeeExtraWorkAuthorization;
    }

    public void setEmployeeExtraWorkAuthorization(EmployeeExtraWorkAuthorization employeeExtraWorkAuthorization) {
	if (employeeExtraWorkAuthorization != null) {
	    this.employeeExtraWorkAuthorization = employeeExtraWorkAuthorization;
	} else {
	    this.employeeExtraWorkAuthorization = null;
	}
    }

    public ExtraWorkAuthorization getExtraWorkAuthorization() {
	return extraWorkAuthorization;
    }

    public void setExtraWorkAuthorization(ExtraWorkAuthorization extraWorkAuthorization) {
	if (extraWorkAuthorization != null) {
	    this.extraWorkAuthorization = extraWorkAuthorization;
	} else {
	    this.extraWorkAuthorization = null;
	}
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

    public Boolean getExecutiveAuxiliarPersonel() {
	return executiveAuxiliarPersonel;
    }

    public void setExecutiveAuxiliarPersonel(Boolean executiveAuxiliarPersonel) {
	this.executiveAuxiliarPersonel = executiveAuxiliarPersonel;
    }

    public Boolean getAuxiliarPersonel() {
	return auxiliarPersonel;
    }

    public void setAuxiliarPersonel(Boolean auxiliarPersonel) {
	this.auxiliarPersonel = auxiliarPersonel;
    }

    public Boolean getNightExtraWork() {
	return nightExtraWork;
    }

    public void setNightExtraWork(Boolean nightExtraWork) {
	this.nightExtraWork = nightExtraWork;
    }

    public Boolean getNormalExtraWork() {
	return normalExtraWork;
    }

    public void setNormalExtraWork(Boolean normalExtraWork) {
	this.normalExtraWork = normalExtraWork;
    }

    public Boolean getNormalExtraWorkPlusOneHundredHours() {
	return normalExtraWorkPlusOneHundredHours;
    }

    public void setNormalExtraWorkPlusOneHundredHours(Boolean normalExtraWorkPlusOneHundredHours) {
	this.normalExtraWorkPlusOneHundredHours = normalExtraWorkPlusOneHundredHours;
    }

    public Boolean getNormalExtraWorkPlusTwoHours() {
	return normalExtraWorkPlusTwoHours;
    }

    public void setNormalExtraWorkPlusTwoHours(Boolean normalExtraWorkPlusTwoHours) {
	this.normalExtraWorkPlusTwoHours = normalExtraWorkPlusTwoHours;
    }

    public Boolean getWeeklyRestExtraWork() {
	return weeklyRestExtraWork;
    }

    public void setWeeklyRestExtraWork(Boolean weeklyRestExtraWork) {
	this.weeklyRestExtraWork = weeklyRestExtraWork;
    }

    public String getEmployeeNumber() {
	return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
	this.employeeNumber = employeeNumber;
    }

    public Boolean getDelete() {
	return delete;
    }

    public void setDelete(Boolean delete) {
	this.delete = delete;
    }
}
