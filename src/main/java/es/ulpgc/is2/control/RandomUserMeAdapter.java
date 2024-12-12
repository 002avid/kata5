package es.ulpgc.is2.control;

import es.ulpgc.is2.control.pojo.RandomUser;
import es.ulpgc.is2.control.pojo.RandomUserMeResponse;
import es.ulpgc.is2.model.User;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLConnection;

public class RandomUserMeAdapter implements UserAdapter<RandomUserMeResponse> {
    @Override
    public User adapt(RandomUserMeResponse response) {
        RandomUser user = response.getResults().getFirst();
        User usuario = adapt(user);
        usuario.setPhoto(downloadPhoto(user.getPicture().large()));
        return usuario;
    }

    private byte[] downloadPhoto(String url) {
        try {
            URLConnection conn = new URI(url).toURL().openConnection();
            return conn.getInputStream().readAllBytes();
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private User adapt(RandomUser user){
        User usuario = new User(user.getName().first(),
                user.getName().last(),
                user.getEmail(),
                User.Gender.valueOf(firstUpperCase(user.getGender())));
        return usuario;
    }

    private String firstUpperCase(String gender){
        return gender.substring(0, 1).toUpperCase() + gender.substring(1);
    }

}
