package es.ulpgc.is2.control;

import es.ulpgc.is2.model.User;

public interface UserAdapter<T> {
    User adapt(T t);
}
