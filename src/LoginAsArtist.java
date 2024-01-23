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

import src.utils.ArtistUploadPage;
import src.utils.BackgroundPanel;
import src.utils.Fonts;
import src.db.MySQL;


public class LoginAsArtist {
    public JTextField loginField;
    public JPasswordField passwordField;
    public JButton login;
    public JButton backToFront;

    public JFrame frame;
    public String title;

    public LoginAsArtist(String title) {
        this.title = title;

        JFrame frame = new JFrame("Login");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.buildBackground(frame);
        this.prepareButtons(frame);

        frame.setSize(1280, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        frame.setLayout(null);
        frame.setVisible(true);

        this.frame = frame;
    }

    void prepareHeading(JFrame frame) {
        JLabel headingLabel = new JLabel(this.title);
        headingLabel.setBounds(95, 150, 355, 75);
        headingLabel.setForeground(Color.WHITE);
        headingLabel.setFont(new Fonts(45).getFont());
        frame.add(headingLabel);
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
        this.prepareLoginField(frame);
        this.preparePasswordField(frame);
        this.prepareLoginButton(frame);
        this.prepareBackToFront(frame);
    }

    void prepareLoginField(JFrame frame) {
        JLabel loginLabel = new JLabel("Username");
        loginLabel.setBounds(93, 251, 149, 22);
        loginLabel.setForeground(Color.WHITE);
        loginLabel.setFont(new Fonts(14).getFont());
        frame.add(loginLabel);

        JTextField loginField = new JTextField();
        loginField.setBounds(93, 283, 352, 57);
        loginField.setFont(new Fonts(25).getFont());
        loginField.setMargin(new Insets(10, 10, 10, 10));

        frame.add(loginField);
        this.loginField = loginField;
    }

    void preparePasswordField(JFrame frame) {
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(93, 364, 160, 22);
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Fonts(14).getFont());
        frame.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(93, 394, 352, 57);
        passwordField.setFont(new Fonts(25).getFont());
        passwordField.setMargin(new Insets(10, 10, 10, 10));

        frame.add(passwordField);
        this.passwordField = passwordField;
    }

    void prepareLoginButton(JFrame frame) {
        JButton login = new JButton("Login");
        login.setBackground(new Color(502779));
        login.setBounds(93, 541, 352, 57);
        login.setForeground(Color.WHITE);
        frame.add(login);

        Fonts font = new Fonts(25);
        font.setFontOnButtons(login);
        this.login = login;

        JLabel incorrect = new JLabel();
        incorrect.setBounds(93, 501, 352, 57);
        incorrect.setForeground(Color.WHITE);
        frame.add(incorrect);

        this.login.addActionListener(e -> {
            String username = this.loginField.getText();
            String password = new String(this.passwordField.getPassword());

            try {
                MySQL sql = new MySQL();
                boolean result = sql.checkUser(username, password);

                if (!result) {
                    incorrect.setText("Incorrect Password");
                } else {
                    new ArtistUploadPage(username, password);
                    frame.dispose();
                }
            } catch (Exception ignored) {

            }
        });
    }

    void prepareBackToFront(JFrame frame) {
        JButton backToFront = new JButton("Back");
        backToFront.setBackground(new Color(502779));
        backToFront.setBounds(93, 640, 352, 57);
        backToFront.setForeground(Color.WHITE);
        frame.add(backToFront);

        Fonts font = new Fonts(25);

        font.setFontOnButtons(backToFront);
        this.backToFront = backToFront;

        this.backToFront.addActionListener(e -> {
            new FrontPage();
            frame.dispose();
        });
    }
}
