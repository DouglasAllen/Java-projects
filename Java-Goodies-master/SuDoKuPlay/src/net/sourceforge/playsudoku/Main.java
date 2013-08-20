package net.sourceforge.playsudoku;

import java.awt.*;
import javax.swing.*;

public class Main extends JApplet{

    boolean isStandalone = false;
    BorderLayout borderLayout1 = new BorderLayout();

    //Get a parameter value
    public String getParameter(String key, String def) {
        return isStandalone ? System.getProperty(key, def) :
                (getParameter(key) != null ? getParameter(key) : def);
    }

    @Override
    public void init() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setSize(new Dimension(400, 300));
        this.getContentPane().setLayout(borderLayout1);

        net.sourceforge.playsudoku.gui.SudokuMainFrame f =
        new net.sourceforge.playsudoku.gui.SudokuMainFrame();
        f.setVisible(true);

    }


    public static void main(String[] args) {
        
       Applet here = new Applet();
       here.init();

    }

}
