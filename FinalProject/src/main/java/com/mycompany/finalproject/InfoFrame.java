
package com.mycompany.finalproject;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class InfoFrame extends JFrame {

    public InfoFrame() throws IOException {
        //fostonoume tin eikona
        JLabel infoLbl = new JLabel();
        BufferedImage bufferedImage = ImageIO.read(new File("projectLogo.jpg"));
        //dinw to megethos pou thelw na einai to logo mou
        Image image = bufferedImage.getScaledInstance(200, 200, Image.SCALE_DEFAULT);

        ImageIcon icon = new ImageIcon(image);
        JLabel logoLbl = new JLabel(icon);

        JButton exitBtn = new JButton("Exit Info");
        infoLbl.setBorder(new EmptyBorder(0, 150, 0, 100));//apo pou tha grafei sto border apostasi diladi
        //vazoume html kai br gia na allakoume grammi
        infoLbl.setText("<html>This app was created By <br>" + "SURAJ SHARMA<br>"
                + "ice20390277<br>" + "App Name: Final Project<br>" + "Developed: 04/06/2022-07/06/2022<html>");
        this.add(logoLbl, BorderLayout.CENTER);
        this.add(infoLbl, BorderLayout.PAGE_START);
        this.add(exitBtn, BorderLayout.PAGE_END);
        exitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        //energopoioume to frame
        this.setSize(500, 500);
        this.setResizable(true);
        this.setLocationRelativeTo(null);
        this.setTitle("Information");
        this.setAlwaysOnTop(true);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setVisible(true);
    }
}
