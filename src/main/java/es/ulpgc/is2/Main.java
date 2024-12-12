package es.ulpgc.is2;

import es.ulpgc.is2.control.LoadRandomUserCommand;
import es.ulpgc.is2.control.NextCommand;
import es.ulpgc.is2.control.PreviousCommand;
import es.ulpgc.is2.control.UserImageLoader;
import es.ulpgc.is2.model.Image;
import es.ulpgc.is2.model.User;
import es.ulpgc.is2.view.MainFrame;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LoadRandomUserCommand command = new LoadRandomUserCommand(100);
        command.execute();
        List<byte[]> photos = new ArrayList<byte[]>();
        for (User user : command.getUsers()){
            photos.add(user.getPhoto());
        }
        MainFrame mainFrame = new MainFrame();
        Image image = new UserImageLoader(photos).load();
        mainFrame.imageDisplay().show(image);
        mainFrame.add("Anterior", new PreviousCommand(mainFrame.imageDisplay()))
                .add("Siguiente", new NextCommand(mainFrame.imageDisplay()));
        mainFrame.setVisible(true);
    }
}
