package org.ukrposhtarest.service;

import java.util.List;
import java.util.Optional;

public interface GenericServiceForDeleteGetGetAll<T> {

    void delete (Long elementId);

    List<T> getAll();

    Optional<T> getById(Long elementId);

}
