package src.utils;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;
import java.io.File;

import src.db.MySQL;

import java.sql.*;
import java.util.concurrent.atomic.AtomicReference;

public class ArtistUploadPage {
    private final String username, password;
    private final Connection connection;

    public ArtistUploadPage(String username, String password) throws Exception {
        this.username = username;
        this.password = password;

        JFrame frame = new JFrame("Upload");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.buildBackground(frame);

        frame.setSize(1280, 800);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        MySQL sql = new MySQL();
        this.connection = sql.connection;
        this.prepareButton(frame);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    void buildBackground(JFrame frame) {
        ImageIcon background = new ImageIcon("images/2.png");
        Image backgroundImage = background.getImage();
        BackgroundPanel panel = new BackgroundPanel(backgroundImage);
        frame.setContentPane(panel);

        this.buildWhiteImage(frame);
    }

    void prepareButton(JFrame frame) {
        this.addNameLabel(frame);
        this.addFileChooser(frame);
    }

    void buildWhiteImage(JFrame frame) {
        ImageIcon blocks = new ImageIcon("images/10.png");
        JLabel blocksLabel = new JLabel(blocks);
        blocksLabel.setBounds(0, 78, blocks.getIconWidth(), blocks.getIconHeight());

        frame.add(blocksLabel);
    }

    void addFileChooser(JFrame frame) {
        JButton button = new JButton("Upload");
        button.setBounds(70, 120, 200, 50);
        button.setFont(new Fonts(25).getFont());
        button.setBackground(new Color(502779));

        JFileChooser fc = new JFileChooser();

        frame.add(button);
        frame.add(fc);

        JLabel uploaded = new JLabel();
        AtomicReference<String> filePath = new AtomicReference<>();
        uploaded.setBounds(200, 300, 500, 50);
        uploaded.setFont(new Fonts(23).getFont());
        uploaded.setForeground(Color.BLACK);

        frame.add(uploaded);
        button.addActionListener(e -> {
            fc.showOpenDialog(frame);
            File selFile = fc.getSelectedFile();
            filePath.set(selFile.getPath());
            uploaded.setText("File recorded" + filePath);
            System.out.println(filePath);
        });
    }

    void addNameLabel(JFrame frame) {
        JLabel name = new JLabel("Logged in as " + this.username);
        name.setBounds(900, 13, 280, 56);
        name.setFont(new Fonts(25).getFont());

        name.setBorder(new CompoundBorder(
                BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK),
                BorderFactory.createEmptyBorder(5, 5, 5, 5))
        );
        frame.add(name);
    }
}
