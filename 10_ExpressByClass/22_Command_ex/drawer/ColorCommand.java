package drawer;

import command.Command;

import java.awt.Color;

public class ColorCommand implements Command {
    protected Drawable drawable;

    private Color color;

    public ColorCommand(Drawable drawable, Color color) {
        this.drawable = drawable;
        this.color = color;
    }

    @Override
    public void execute() {
        drawable.setColor(color);
    }
}
