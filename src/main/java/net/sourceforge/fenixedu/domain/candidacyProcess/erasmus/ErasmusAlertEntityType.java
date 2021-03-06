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
package net.sourceforge.fenixedu.domain.candidacyProcess.erasmus;

import java.util.Locale;

import net.sourceforge.fenixedu.util.Bundle;

import org.fenixedu.bennu.core.i18n.BundleUtil;

public enum ErasmusAlertEntityType {
    GRI, ACADEMIC_OFFICE, COORDINATOR;

    public String getName() {
        return name();
    }

    public String getQualifiedName() {
        return ErasmusAlertEntityType.class.getSimpleName() + "." + getName();
    }

    public String getFullyQualifiedName() {
        return ErasmusAlertEntityType.class.getName() + "." + getName();
    }

    public String getDescription() {
        return getDescription(Locale.getDefault());
    }

    public String getDescription(final Locale locale) {
        return BundleUtil.getString(Bundle.ENUMERATION, locale, getFullyQualifiedName());
    }
}
