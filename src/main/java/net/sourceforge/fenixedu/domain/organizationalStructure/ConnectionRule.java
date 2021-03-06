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
package net.sourceforge.fenixedu.domain.organizationalStructure;

import org.fenixedu.bennu.core.domain.Bennu;

public class ConnectionRule extends ConnectionRule_Base {

    public ConnectionRule() {
        super();
        setRootDomainObject(Bennu.getInstance());
    }

    public ConnectionRule(PartyType allowedParentPartyType, PartyType allowedChildPartyType, AccountabilityType accountabilityType) {
        this();
        setAllowedParentPartyType(allowedParentPartyType);
        setAllowedChildPartyType(allowedChildPartyType);
        setAccountabilityType(accountabilityType);
    }

    public void delete() {
        setAccountabilityType(null);
        setAllowedChildPartyType(null);
        setAllowedParentPartyType(null);
        setRootDomainObject(null);
        deleteDomainObject();
    }

    @Deprecated
    public boolean hasAccountabilityType() {
        return getAccountabilityType() != null;
    }

    @Deprecated
    public boolean hasBennu() {
        return getRootDomainObject() != null;
    }

    @Deprecated
    public boolean hasAllowedParentPartyType() {
        return getAllowedParentPartyType() != null;
    }

    @Deprecated
    public boolean hasAllowedChildPartyType() {
        return getAllowedChildPartyType() != null;
    }

}
