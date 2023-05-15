package org.ukrposhtarest.service.programmer;

import org.ukrposhtarest.model.programmer.Programmer;
import org.ukrposhtarest.service.GenericServiceForCreateUpdate;
import org.ukrposhtarest.service.GenericServiceForDeleteGetGetAll;

public interface ProgrammerService
    extends GenericServiceForDeleteGetGetAll<Programmer>, GenericServiceForCreateUpdate<Programmer> {
}
