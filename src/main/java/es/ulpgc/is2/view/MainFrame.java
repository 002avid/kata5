package es.ulpgc.is2.view;

import es.ulpgc.is2.control.Command;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MainFrame extends JFrame {
    private ImageDisplay imageDisplay;
    private final Map<String, Command> commands;

    public MainFrame() {
        this.commands = new HashMap<>();
        setTitle("Image-Viewer");
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(300, 250);
        setLayout(new BorderLayout());
        add(createImageDiplay());
        add(createToolBar(), BorderLayout.SOUTH);
        setLocationRelativeTo(null);
    }

    private Component createToolBar() {
        JPanel panel = new JPanel();
        panel.add(createButton("Anterior"));
        panel.add(createButton("Siguiente"));
        panel.setBackground(Color.BLACK);
        return panel;
    }

    private Component createButton(String label) {
        JButton button = new JButton(label);
        button.addActionListener(e -> commands.get(label).execute());
        button.setForeground(Color.BLACK);
        return button;
    }

    private Component createImageDiplay(){
        SwingImageDisplay display = new SwingImageDisplay();
        this.imageDisplay = display;
        return display;
    }

    public MainFrame add(String name, Command command){
        commands.put(name, command);
        return this;
    }

    public ImageDisplay imageDisplay(){
        return imageDisplay;
    }
}
