package es.ulpgc.is2.control;

import com.google.gson.Gson;
import es.ulpgc.is2.control.pojo.RandomUserMeResponse;
import es.ulpgc.is2.model.User;
import org.jsoup.Jsoup;

import java.io.IOException;

public class RandomUserProvider implements UserProvider {
    private static final String RANDOM_USER_URL = "https://randomuser.me/api";

    @Override
    public User provideNew() throws IOException {
        String text = Jsoup.connect(RANDOM_USER_URL).ignoreContentType(true).get().text();
        RandomUserMeResponse response = new Gson().fromJson(text, RandomUserMeResponse.class);
        return new RandomUserMeAdapter().adapt(response)
    }
}
