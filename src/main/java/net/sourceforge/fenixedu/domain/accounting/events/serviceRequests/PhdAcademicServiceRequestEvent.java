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
package net.sourceforge.fenixedu.domain.accounting.events.serviceRequests;

import net.sourceforge.fenixedu.domain.Person;
import net.sourceforge.fenixedu.domain.accounting.EventType;
import net.sourceforge.fenixedu.domain.administrativeOffice.AdministrativeOffice;
import net.sourceforge.fenixedu.domain.exceptions.DomainException;
import net.sourceforge.fenixedu.domain.serviceRequests.AcademicServiceRequest;

abstract public class PhdAcademicServiceRequestEvent extends PhdAcademicServiceRequestEvent_Base {

    protected PhdAcademicServiceRequestEvent() {
        super();
    }

    @Override
    protected void init(final AdministrativeOffice administrativeOffice, final EventType eventType, final Person person,
            final AcademicServiceRequest academicServiceRequest) {
        if (!academicServiceRequest.isRequestForPhd()) {
            throw new DomainException("PhdAcademicServiceRequestEvent.request.is.not.for.phd");
        }

        super.init(administrativeOffice, eventType, person, academicServiceRequest);
    }

}
