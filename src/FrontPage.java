package src;

import java.awt.*;

import javax.swing.*;



import src.utils.BackgroundPanel;
import src.utils.Fonts;

public class FrontPage {
    public JButton loginAsArtist;
    public JButton loginAsAdmin;
    public JButton registerArtist;
    public JButton guest;
    public JButton exit;

    private Fonts font;
    public JFrame frame;




    public FrontPage() {
        ImageIcon image = new ImageIcon("images/logo.png");

        JFrame frame = new JFrame("Front");
        frame.setIconImage(image.getImage());
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

    void prepareHeading(JFrame frame) {
        String heading = "Art Gallery";
        JLabel headingLabel = new JLabel(heading);
        headingLabel.setBounds(108, 150, 352, 80);
        headingLabel.setForeground(Color.WHITE);
        headingLabel.setFont(new Font("Poppins Medium",Font.PLAIN,60));
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
        this.prepareLoginAsArtist(frame);
        this.prepareLoginAsAdmin(frame);
        this.prepareRegisterArtist(frame);
        this.prepareGuest(frame);
        this.prepareExit(frame);
    }

    private void prepareLoginAsArtist(JFrame frame) {
        JButton login = new JButton("Login as Artist");
        login.setBackground(new Color(0x502779));
        login.setBounds(90, 289, 352, 57);
        login.setFont(new Font("Poppins Medium",Font.PLAIN,36));
//        login.setBorder(new RoundedBorder(10));
        login.setForeground(Color.WHITE);
        frame.add(login);

        this.font.setFontOnButtons(login);
        this.loginAsArtist = login;

        this.loginAsArtist.addActionListener(e -> {
            new LoginAsArtist("Login as Artist");
            frame.dispose();
        });
    }

    private void prepareLoginAsAdmin(JFrame frame) {
        JButton login = new JButton("Login as Admin");
        login.setBackground(new Color(0x502779));
        login.setBounds(90, 376, 352, 57);
        login.setFont(new Font("Poppins Medium",Font.PLAIN,36));
        login.setForeground(Color.WHITE);
        frame.add(login);

        this.font.setFontOnButtons(login);
        this.loginAsAdmin = login;

        this.loginAsAdmin.addActionListener(e -> {
            new AdminPage();
            frame.dispose();
        });
    }

    private void prepareRegisterArtist(JFrame frame) {
        JButton register = new JButton("Register");
        register.setBackground(new Color(0x502779));
        register.setBounds(90, 457, 352, 57);
        register.setFont(new Font("Poppins Medium",Font.PLAIN,36));
        register.setForeground(Color.WHITE);
        frame.add(register);

        this.font.setFontOnButtons(register);

        this.registerArtist = register;

        this.registerArtist.addActionListener(e -> {
            try {
                new Register();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

            frame.dispose();
        });
    }

    private void prepareGuest(JFrame frame) {
        JButton guest = new JButton("Visitor");
        guest.setBackground(new Color(0x502779));
        guest.setBounds(90, 540, 352, 57);
        guest.setFont(new Font("Poppins Medium",Font.PLAIN,36));
        guest.setForeground(Color.WHITE);
        frame.add(guest);

        this.font.setFontOnButtons(guest);
    }

    private void prepareExit(JFrame frame) {
        JButton exit = new JButton("Exit");
        exit.setBackground(new Color(0));
        exit.setBounds(90, 620, 352, 57);
        exit.setFont(new Font("Poppins Medium",Font.PLAIN,36));
        exit.setForeground(Color.WHITE);
        frame.add(exit);

        exit.addActionListener(e -> {
            frame.dispose();
        });

        this.font.setFontOnButtons(exit);
    }
}
