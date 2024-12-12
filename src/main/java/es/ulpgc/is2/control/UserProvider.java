package es.ulpgc.is2.control;

import es.ulpgc.is2.model.User;

import java.io.IOException;

public interface UserProvider {
    User provideNew() throws IOException;
}
