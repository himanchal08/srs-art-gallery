package src;

import javax.swing.*;

import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.CompoundBorder;

import src.utils.BackgroundPanel;
import src.utils.Fonts;

public class AdminPage {
    public JPasswordField passwordField;
    public JButton login;
    public JButton backToFront;

    public JFrame frame;
    public String title;

    public AdminPage() {
        JFrame frame = new JFrame("Admin page");
        frame.setSize(1280, 800);
        buildBackground(frame);
        this.frame = frame;
        this.frame.setResizable(false);
        topLabel();
        submitBtn();
        Title();
        loginL();
        String[][] data = {
                {"Kundan Kumar Jha", "4031", "CSE"},
                {"Anand Jha", "6014", "IT"}
        };
        String[] columnNames = {"Name", "Roll Number", "Department"};
        Table(data, columnNames);
        this.frame.setVisible(true);


    }

    void buildBackground(JFrame frame) {
        ImageIcon background = new ImageIcon("images/2.png");
        Image backgroundImage = background.getImage();
        BackgroundPanel panel = new BackgroundPanel(backgroundImage);

        frame.setContentPane(panel);

    }

    void Title() {
        JLabel lab = new JLabel("ADMIN PAGE");
        lab.setBounds(500, 40, 700, 35);
        lab.setForeground(Color.WHITE);
        lab.setFont(new Font("poppins medium", Font.PLAIN, 36));
        lab.setFont(new Fonts(40).getFont());
        lab.setBackground(Color.white);
        this.frame.add(lab);

    }

    void topLabel() {
        JTextField ad = new JTextField();
        ad.setBounds(150, 100, 700, 35);
        ad.setForeground(Color.black);
        ad.setFont(new Font("poppins medium", Font.PLAIN, 36));

        ad.setFont(new Fonts(14).getFont());
        ad.setBackground(Color.white);
        this.frame.add(ad);
    }

    void submitBtn() {
        JButton btn = new JButton("SUBMIT");
        btn.setBounds(1000, 100, 130, 35);
        btn.setFont(new Font("poppins medium", Font.PLAIN, 36));
        btn.setFont(new Fonts(14).getFont());
        btn.setBackground(new Color(0x502779));

        btn.setForeground(Color.WHITE);
        this.frame.add(btn);

    }

    void loginL() {
        JLabel lab = new JLabel("LOGIN AS ROOT");
        lab.setBounds(1000, 40, 200, 40);
        lab.setBorder(new CompoundBorder(
                BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        lab.setForeground(Color.WHITE);
        lab.setFont(new Font("poppins medium", Font.PLAIN, 20));
        lab.setBackground(new Color(0x502779));
        this.frame.add(lab);
    }

    void Table(String[][] data, String[] columnNames) {
        JTable jT = new JTable(data, columnNames);
        jT.setBounds(200, 300, 700, 300);
        this.frame.add(jT);
    }

    public static void main(String[] args) {
        new AdminPage();

    }

}