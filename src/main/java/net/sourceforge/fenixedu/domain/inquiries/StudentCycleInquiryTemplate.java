/**
 * Copyright © 2002 Instituto Superior Técnico
 *
 * This file is part of FenixEdu Core.
 *
 * FenixEdu Core is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * FenixEdu Core is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with FenixEdu Core.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.sourceforge.fenixedu.domain.inquiries;

import net.sourceforge.fenixedu.domain.ExecutionYear;
import net.sourceforge.fenixedu.domain.degreeStructure.CycleType;
import net.sourceforge.fenixedu.domain.phd.PhdIndividualProgramProcess;
import net.sourceforge.fenixedu.domain.student.Registration;

public abstract class StudentCycleInquiryTemplate extends StudentCycleInquiryTemplate_Base {

    public StudentCycleInquiryTemplate() {
        super();
    }

    public static StudentCycleInquiryTemplate getStudentCycleInquiryTemplate(Registration registration) {
        CycleType cycleType = registration.getCycleType(ExecutionYear.readCurrentExecutionYear());
        if (cycleType == null) {
            cycleType = registration.getDegree().getDegreeType().getLastOrderedCycleType();
        }
        switch (cycleType) {
        case FIRST_CYCLE:
            return Student1rstCycleInquiryTemplate.getCurrentTemplate();
        case SECOND_CYCLE:
            return Student2ndCycleInquiryTemplate.getCurrentTemplate();
        default:
            return StudentOtherCycleInquiryTemplate.getCurrentTemplate();
        }
    }

    public static StudentCycleInquiryTemplate getStudentCycleInquiryTemplate(PhdIndividualProgramProcess phdProcess) {
        return StudentOtherCycleInquiryTemplate.getCurrentTemplate();
    }
}
