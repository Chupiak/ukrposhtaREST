package org.ukrposhtarest.service.manager;

import org.ukrposhtarest.model.manager.Manager;
import org.ukrposhtarest.service.GenericServiceForCreateUpdate;
import org.ukrposhtarest.service.GenericServiceForDeleteGetGetAll;

public interface ManagerService
    extends GenericServiceForDeleteGetGetAll<Manager>, GenericServiceForCreateUpdate<Manager> {

}
