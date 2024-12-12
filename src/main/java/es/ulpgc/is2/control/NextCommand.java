package es.ulpgc.is2.control;

import es.ulpgc.is2.view.ImageDisplay;

public class NextCommand implements Command{
    private final ImageDisplay imageDisplay;

    public NextCommand(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }

    @Override
    public void execute() {
        imageDisplay.show(imageDisplay.image().next());
    }
}
