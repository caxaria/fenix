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
package net.sourceforge.fenixedu.domain.phd.individualProcess.activities;

import net.sourceforge.fenixedu.dataTransferObject.person.PersonBean;
import net.sourceforge.fenixedu.domain.Person;
import net.sourceforge.fenixedu.domain.phd.PhdIndividualProgramProcess;

import org.fenixedu.bennu.core.domain.User;

public class EditPersonalInformation extends PhdIndividualProgramProcessActivity {

    @Override
    protected void activityPreConditions(PhdIndividualProgramProcess arg0, User arg1) {
        // no precondition to check
    }

    @Override
    protected PhdIndividualProgramProcess executeActivity(PhdIndividualProgramProcess process, User userView, Object object) {

        final Person person = process.getPerson();
        if (process.isAllowedToManageProcess(userView)) {
            person.edit((PersonBean) object);
        } else if (!person.hasAnyPersonRoles() && !person.hasUser() && !person.hasStudent()
                && process.getCandidacyProcess().isPublicCandidacy()) {
            // assuming public candidacy
            person.editPersonWithExternalData((PersonBean) object, true);
        }
        return process;
    }
}
