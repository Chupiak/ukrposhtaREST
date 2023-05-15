package org.ukrposhtarest.service;

public interface GenericServiceForCreateUpdate<T> {
    T create(T element);

    T update(Long id, T element);
}
