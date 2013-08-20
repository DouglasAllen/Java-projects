
import java.applet.Applet;
import java.awt.Graphics;
import java.io.IOException;

import java.net.URL;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

/**
 *
 * @author KB9AGT
 */
public class MidiApplet extends Applet {

    Sequencer sequencer = null;
    Sequence sequence = null;
    // MIDI file loader.    
    public static URL getMidiFileURL(String fileName) {
        ClassLoader cl = MidiApplet.class.getClassLoader();
        URL resourceURL = cl.getResource(fileName);
        return resourceURL;
    }

    @Override
    public void init() {

        String filename = getParameter("MIDIFILE");

        try {
            sequence = MidiSystem.getSequence(getMidiFileURL(filename));
        } catch (InvalidMidiDataException ex) {
            Logger.getLogger(MidiApplet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MidiApplet.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            sequencer = MidiSystem.getSequencer();
        } catch (MidiUnavailableException ex) {
            Logger.getLogger(MidiApplet.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (sequencer == null) {
            // Error -- sequencer device is not supported.
            // Inform user and return...
            getParameterInfo();
            return;
        } else {
            try {  // Acquire resources and make operational.
                sequencer.open();
            } catch (MidiUnavailableException ex) {
                Logger.getLogger(MidiApplet.class.getName()).log(Level.SEVERE, null, ex);
            }
            sequencer.setLoopCount(0);
            try {
                sequencer.setSequence(sequence);
            } catch (InvalidMidiDataException ex) {
                Logger.getLogger(MidiApplet.class.getName()).log(Level.SEVERE, null, ex);
            }
//            sequencer.start();
        }
    }

    @Override
    public void paint(Graphics g) {
        //Draw a Rectangle around the applet's display area.
        g.drawRect(0, 0,
                getWidth() - 1,
                getHeight() - 1);

        g.drawString("Now playing " + getParameter("MIDIFILE"), 5, 35);
        //g.drawString("The source may be found in F# that is /files/midis", 5, 49);

    }

    @Override
    public void start() {
        sequencer.start();
        
    }

    @Override
    public void stop() {
//        sequencer.stop();
    }

    @Override
    public void destroy() {
    }

    @Override
    public String[][] getParameterInfo() {
        String[][] info = {
            {"MIDIFILE", "URL", "MIDI file URL"}
        };
        return info;
    }

    public void run() {
        init();
    }
//    public static void main(String[] args) {
//
//       Applet here = new Applet();
//       here.init();
//
//    }
}
