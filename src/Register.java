package src;

import java.awt.Color;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import src.utils.BackgroundPanel;
import src.utils.Fonts;

public class Register {
    public JTextField nameField;
    public JPasswordField passwordField;
    public JPasswordField confirmPasswordField;

    public JButton registerButton;
    public JButton backButton;

    private Fonts font;
    public JFrame frame;

    public Register() {
        JFrame frame = new JFrame("Front");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.buildBackground(frame);
        this.font = new Fonts(25);
        this.prepareButtons(frame);

        frame.setSize(1280, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        frame.setLayout(null);
        frame.setVisible(true);

        this.frame = frame;
    }

    void buildBackground(JFrame frame) {
        ImageIcon background = new ImageIcon("images/3.png");
        Image backgroundImage = background.getImage();
        BackgroundPanel panel = new BackgroundPanel(backgroundImage);

        frame.setContentPane(panel);

        this.buildBlocksImage(frame);
    }

    void buildBlocksImage(JFrame frame) {
        ImageIcon blocks = new ImageIcon("images/4.png");
        JLabel blocksLabel = new JLabel(blocks);
        blocksLabel.setBounds(627, 78, blocks.getIconWidth(), blocks.getIconHeight());

        frame.add(blocksLabel);
    }

    void prepareButtons(JFrame frame) {
        this.prepareHeading(frame);
        this.prepareUsernameField(frame);
        this.preparePasswordField(frame);
        this.prepareConfirmPassowrdField(frame);
        this.prepareRegisterButton(frame);
        this.prepareBackButton(frame);
    }

    void prepareHeading(JFrame frame) {
        String heading = "Register as Artist";
        JLabel headingLabel = new JLabel(heading);
        headingLabel.setBounds(96, 80, 345, 80);
        headingLabel.setForeground(Color.WHITE);
        headingLabel.setFont(new Fonts(60).getFont());
        frame.add(headingLabel);
    }

    void prepareUsernameField(JFrame frame) {
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(91, 171, 150, 22);
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setFont(new Fonts(14).getFont());
        frame.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(90, 206, 352, 57);
        usernameField.setFont(new Fonts(14).getFont());
        usernameField.setMargin(new Insets(10, 10, 10, 10));
        frame.add(usernameField);

        this.nameField = usernameField;
    }

    void preparePasswordField(JFrame frame) {
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(91, 271, 150, 22);
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Fonts(14).getFont());
        frame.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(90, 306, 352, 57);
        passwordField.setFont(this.font.getFont());
        passwordField.setMargin(new Insets(10, 10, 10, 10));
        frame.add(passwordField);

        this.passwordField = passwordField;
    }

    void prepareConfirmPassowrdField(JFrame frame) {
        JLabel confirmPasswordLabel = new JLabel("Confirm Password");
        confirmPasswordLabel.setBounds(91, 371, 150, 22);
        confirmPasswordLabel.setForeground(Color.WHITE);
        confirmPasswordLabel.setFont(new Fonts(14).getFont());
        frame.add(confirmPasswordLabel);

        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(90, 406, 352, 57);
        confirmPasswordField.setFont(this.font.getFont());
        confirmPasswordField.setMargin(new Insets(10, 10, 10, 10));
        frame.add(confirmPasswordField);

        this.confirmPasswordField = confirmPasswordField;
    }

    void prepareRegisterButton(JFrame frame) {
        JButton register = new JButton("Register");
        register.setBackground(new Color(502779));
        register.setBounds(90, 541, 352, 57);
        register.setForeground(Color.WHITE);
        frame.add(register);

        this.font.setFontOnButtons(register);
        this.registerButton = register;
    }

    void prepareBackButton(JFrame frame) {
        JButton back = new JButton("Back");
        back.setBackground(new Color(502779));
        back.setBounds(90, 640, 352, 57);
        back.setForeground(Color.WHITE);
        frame.add(back);

        this.font.setFontOnButtons(back);
        this.backButton = back;

        this.backButton.addActionListener(e -> {
            new FrontPage();
            frame.dispose();
        });
    }
}
