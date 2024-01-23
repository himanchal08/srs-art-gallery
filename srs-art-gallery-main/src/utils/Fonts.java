package src.utils;

import java.awt.Font;

import javax.swing.JButton;

public class Fonts {
    private static final String FONT_PATH = "ubuntu-nerd-fonts/UbuntuNerdFont-%s.ttf";
    private int fontSize = 20;
    private Font font;

    Fonts(String path, int fontSize) {
        this.font = new Font(path, Font.PLAIN, fontSize);
        setFontSize(fontSize);
    }

    public Fonts(int fontSize) {
        this(String.format(FONT_PATH, "Regular"), fontSize);
    }

    Fonts() {
        this(String.format(FONT_PATH, "Regular"), 20);
    }

    public Font getFont() {
        return this.font;
    }

    public void setFontOnButtons(JButton... buttons) {
        for (JButton button : buttons) {
            button.setFont(this.font);
        }
    }

    void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    void setFont(String name) {
        this.switchFont(name);
    }

    private void switchFont(String name) {
        switch (name) {
            case "bold":
                this.font = new Font(String.format(FONT_PATH, "Bold"), Font.BOLD, this.fontSize);
                break;
            case "italic":
                this.font = new Font(String.format(FONT_PATH, "Italic"), Font.ITALIC, this.fontSize);
                break;
            case "regular":
                this.font = new Font(String.format(FONT_PATH, "Regular"), Font.PLAIN, this.fontSize);
                break;
            case "bold-italic":
                this.font = new Font(String.format(FONT_PATH, "BoldItalic"), Font.BOLD | Font.ITALIC, this.fontSize);
                break;
            case "medium":
                this.font = new Font(String.format(FONT_PATH, "Medium"), Font.PLAIN, this.fontSize);
                break;
            default:
                break;
        }
    }
}
