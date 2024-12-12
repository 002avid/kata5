package es.ulpgc.is2.control;

import es.ulpgc.is2.view.ImageDisplay;

public class PreviousCommand implements Command{
    private final ImageDisplay imageDisplay;

    public PreviousCommand(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }

    @Override
    public void execute() {
        imageDisplay.show(imageDisplay.image().prev());
    }
}
