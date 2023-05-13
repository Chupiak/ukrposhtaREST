package org.ukrposhtarest.service;

import java.util.List;
import java.util.Optional;

public interface GenericService<T> {

    T create(T element);

    void delete (Long elementId);

    List<T> getAll();

    Optional<T> getById(Long elementId);

    T update(Long id, T element);
}
