<%--

    Copyright © 2002 Instituto Superior Técnico

    This file is part of FenixEdu Core.

    FenixEdu Core is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    FenixEdu Core is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with FenixEdu Core.  If not, see <http://www.gnu.org/licenses/>.

--%>
<%@ page language="java" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://fenix-ashes.ist.utl.pt/fenix-renderers" prefix="fr" %>
<html:xhtml/>

<!-- validateIdentityRequestResult.jsp -->

<logic:present role="role(OPERATOR)">

	<h2><bean:message key="alumni.validate.identity.request" bundle="MANAGER_RESOURCES"/></h2>

	<bean:define id="message" name="identityRequestResult" type="java.lang.String"/>
	<p>
		<bean:message key="<%= message %>" bundle="MANAGER_RESOURCES"/>
	</p>
	
	<html:link page="/alumni.do?method=prepareIdentityRequestsList">
		<bean:message key="label.back" bundle="MANAGER_RESOURCES"/>
	</html:link>
	
</logic:present>
