/*
   Rich Perilli
    Final Project - MIDI Player
    Mr. Hanley Period 9
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.Font;
import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.URL;
import java.net.*;


public class midiframe extends JFrame implements ActionListener {



    public midiframe() {
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    Image image1; //image variable
    AudioClip clip; //audio variable
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == aboutMENU) { //String for the About Menu Item

            JOptionPane.showMessageDialog(null,
                                          "Programmed by Rich Perilli. Assistance provided by Chis Senez and Mr. Hanley. Version 1.0",
                                          "JAVA MIDI player v1.0",
                                          JOptionPane.
                                          INFORMATION_MESSAGE);

        }
        if (e.getSource() == playBUT) { //String for the Play Button

            if (loopCHECK.isSelected() == (true)) { //this asks if the check box is checked
                clip.loop();
                statusLBL.setText("Status: Playing (Repeat On)");
            } else {
                clip.play();
                statusLBL.setText("Status: Playing");
            }
            playBUT.setEnabled(false);
            stopBUT.setEnabled(true);
            openMENU.setEnabled(false);

        }

        if (e.getSource() == stopBUT) { //String for the Stop Button

            clip.stop();
            statusLBL.setText("Status: Stopped");
            stopBUT.setEnabled(false);
            playBUT.setEnabled(true);
            openMENU.setEnabled(true);
        }

        if (e.getSource() == openMENU) { //String for the Open Menu Item

            JFileChooser chooser = new JFileChooser();

            if (chooser.showOpenDialog(null)
                == JFileChooser.APPROVE_OPTION) {
                File selectedFile = chooser.getSelectedFile();

                try {
                    clip = Applet.newAudioClip(new URL("file", "",
                            selectedFile.getAbsolutePath()));
                } catch (MalformedURLException ex) {
                    System.out.println(ex);
                }

            }
            playBUT.setEnabled(true);
            statusLBL.setText("Status: Stopped");
        }
        if (e.getSource() == exitMENU) { //String for the Exit Menu Item
            System.exit(0);

        }

    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout(null);
        stopBUT.setBounds(new Rectangle(44, 85, 75, 29));
        stopBUT.setEnabled(false);
        stopBUT.setFont(new java.awt.Font("Dialog", Font.BOLD, 11));
        stopBUT.setText("Stop");
        playBUT.setBounds(new Rectangle(133, 85, 75, 29));
        playBUT.setEnabled(false);
        playBUT.setFont(new java.awt.Font("Dialog", Font.BOLD, 11));
        playBUT.setText("Play");
        this.setJMenuBar(MENU);
        openMENU.setText("Open");
        fileBAR.setText("File");
        exitMENU.setText("Exit");
        helpBAR.setText("Help");
        aboutMENU.setText("About");
        loopCHECK.setFont(new java.awt.Font("Dialog", Font.BOLD, 11));
        loopCHECK.setText("Repeat");
        loopCHECK.setBounds(new Rectangle(213, 90, 109, 20));
        statusLBL.setFont(new java.awt.Font("Dialog", Font.BOLD, 15));
        statusLBL.setHorizontalAlignment(SwingConstants.TRAILING);
        statusLBL.setText("Status: File Not Loaded Yet");
        statusLBL.setBounds(new Rectangle(96, 41, 244, 35));
        this.getContentPane().add(stopBUT);
        this.getContentPane().add(playBUT);
        this.getContentPane().add(loopCHECK);
        this.getContentPane().add(statusLBL);
        MENU.add(fileBAR);
        MENU.add(helpBAR);
        fileBAR.add(openMENU);
        helpBAR.add(aboutMENU);
        fileBAR.add(exitMENU);
        //Forces the app to pay attention to which button is pressed
        playBUT.addActionListener(this);
        stopBUT.addActionListener(this);
        openMENU.addActionListener(this);
        exitMENU.addActionListener(this);
        aboutMENU.addActionListener(this);
        loopCHECK.addActionListener(this);
        //image files
        image1 = Toolkit.getDefaultToolkit().getImage(java.net.URLClassLoader
                .getSystemResource( //This will
                        "images/x.jpg")); //load the image file
        setIconImage(image1); //this sets the icon

    }

    JButton stopBUT = new JButton();
    JButton playBUT = new JButton();
    JMenuBar MENU = new JMenuBar();
    JMenu fileBAR = new JMenu();
    JMenuItem openMENU = new JMenuItem();
    JMenuItem exitMENU = new JMenuItem();
    JMenu helpBAR = new JMenu();
    JMenuItem aboutMENU = new JMenuItem();
    JCheckBox loopCHECK = new JCheckBox();
    JLabel statusLBL = new JLabel();
    public void jButton1_actionPerformed(ActionEvent e) {

    }
}


class midiframe_jButton1_actionAdapter implements ActionListener {
    private midiframe adaptee;
    midiframe_jButton1_actionAdapter(midiframe adaptee) {
        this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
        adaptee.jButton1_actionPerformed(e);
    }


}
