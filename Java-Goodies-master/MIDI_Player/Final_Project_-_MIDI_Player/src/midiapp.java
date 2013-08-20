/*
   Rich Perilli
    Final Project - MIDI Player
    Mr. Hanley Period 9
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.awt.*;
import javax.swing.*;

public class midiapp {
    public static void main(String args[]) {
        midiframe f = new midiframe();
        f.setSize(400,200);
        f.setResizable(false);
        f.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        f.setTitle("Rich's MIDI Player");
        f.setVisible(true);
    }
}
