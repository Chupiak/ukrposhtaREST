package org.ukrposhtarest.service.profession;

import org.ukrposhtarest.model.profession.Profession;
import org.ukrposhtarest.service.GenericServiceForCreateUpdate;
import org.ukrposhtarest.service.GenericServiceForDeleteGetGetAll;

public interface ProfessionService
    extends GenericServiceForDeleteGetGetAll<Profession>, GenericServiceForCreateUpdate<Profession> {
}
