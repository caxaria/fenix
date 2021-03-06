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
package net.sourceforge.fenixedu.domain.serviceRequests.documentRequests;

import java.util.Collections;
import java.util.Set;

import net.sourceforge.fenixedu.dataTransferObject.serviceRequests.DocumentRequestCreateBean;
import net.sourceforge.fenixedu.domain.Enrolment;
import net.sourceforge.fenixedu.domain.accounting.EventType;
import net.sourceforge.fenixedu.domain.exceptions.DomainException;

public class ExternalCourseLoadRequest extends ExternalCourseLoadRequest_Base {

    protected ExternalCourseLoadRequest() {
        super();
    }

    public ExternalCourseLoadRequest(final DocumentRequestCreateBean bean) {
        this();
        super.init(bean);

        checkParameters(bean);
        super.setNumberOfCourseLoads(bean.getNumberOfCourseLoads());
        super.setInstitution(bean.getInstitution());
    }

    @Override
    protected void checkParameters(final DocumentRequestCreateBean bean) {
        if (bean.getNumberOfCourseLoads() == null || bean.getNumberOfCourseLoads().intValue() == 0) {
            throw new DomainException("error.ExternalCourseLoadRequest.invalid.numberOfCourseLoads");
        }
        if (bean.getInstitution() == null) {
            throw new DomainException("error.ExternalCourseLoadRequest.invalid.institution");
        }
    }

    @Override
    public Set<Enrolment> getEnrolmentsSet() {
        return Collections.unmodifiableSet(super.getEnrolmentsSet());
    }

    @Override
    public void addEnrolments(Enrolment enrolments) {
        throw new DomainException("error.ExternalCourseLoadRequest.cannot.add.enrolments");
    }

    @Override
    public void removeEnrolments(Enrolment enrolments) {
        throw new DomainException("error.ExternalCourseLoadRequest.cannot.remove.enrolments");
    }

    @Override
    public DocumentRequestType getDocumentRequestType() {
        return DocumentRequestType.EXTERNAL_COURSE_LOAD;
    }

    @Override
    public EventType getEventType() {
        return EventType.EXTERNAL_COURSE_LOAD_REQUEST;
    }

    @Override
    protected void disconnect() {
        super.setInstitution(null);
        super.disconnect();
    }

    @Deprecated
    public boolean hasNumberOfCourseLoads() {
        return getNumberOfCourseLoads() != null;
    }

    @Deprecated
    public boolean hasInstitution() {
        return getInstitution() != null;
    }

}
