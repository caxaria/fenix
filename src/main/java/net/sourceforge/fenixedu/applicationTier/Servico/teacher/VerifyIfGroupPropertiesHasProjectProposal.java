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
package net.sourceforge.fenixedu.applicationTier.Servico.teacher;

import net.sourceforge.fenixedu.applicationTier.Filtro.ExecutionCourseLecturingTeacherAuthorizationFilter;
import net.sourceforge.fenixedu.applicationTier.Servico.exceptions.NotAuthorizedException;
import net.sourceforge.fenixedu.domain.ExecutionCourse;
import net.sourceforge.fenixedu.domain.Grouping;
import pt.ist.fenixframework.Atomic;
import pt.ist.fenixframework.FenixFramework;

public class VerifyIfGroupPropertiesHasProjectProposal {

    protected Boolean run(String executionCourseId, String groupPropertiesId) {
        final ExecutionCourse executionCourse = FenixFramework.getDomainObject(executionCourseId);
        final Grouping grouping = FenixFramework.getDomainObject(groupPropertiesId);
        return executionCourse.hasExportGrouping(grouping);
    }

    // Service Invokers migrated from Berserk

    private static final VerifyIfGroupPropertiesHasProjectProposal serviceInstance =
            new VerifyIfGroupPropertiesHasProjectProposal();

    @Atomic
    public static Boolean runVerifyIfGroupPropertiesHasProjectProposal(String executionCourseId, String groupPropertiesId)
            throws NotAuthorizedException {
        ExecutionCourseLecturingTeacherAuthorizationFilter.instance.execute(executionCourseId);
        return serviceInstance.run(executionCourseId, groupPropertiesId);
    }

}