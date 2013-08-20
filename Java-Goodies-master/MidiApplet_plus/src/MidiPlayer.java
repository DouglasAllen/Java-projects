// MidiPlayer.java
//

//**********************************************
//  MidiPlayer.class will loop a *.mid file    *
//  entered on the command line aa an argument.*
//  Ex: java MidiPlayer your.mid               *
//  Just use Enter key to stop sequencing.     *
//  Side effects may be navigating away,       *
//  or typing anything and using Enter key     *
//  while in the same command window.          *
//**********************************************

import java.io.File;
import java.net.URL;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.sound.midi.*;
import javax.swing.JFileChooser;

public class MidiPlayer {

    public static URL fileName;    

    public MidiPlayer() {
    }

    public MidiPlayer(URL midiName) {
        fileName = midiName;
    }

    //***Note: Not used except for single
    // Method to get the MIDI file as a URL.
    public static URL getMidiFileURL(String fileName) {
        ClassLoader cl = MidiPlayer.class.getClassLoader();
        URL resourceURL = cl.getResource(fileName);
        System.out.println("URL: " + resourceURL.toString());
        return resourceURL;
    }


// Main entry point.
    public static void main(String[] args)
            throws InvalidMidiDataException,
            IOException,
            MidiUnavailableException,
            Throwable {

        JFileChooser chooser = new JFileChooser();

        if (chooser.showOpenDialog(null)
                == JFileChooser.APPROVE_OPTION) {
                File selectedFile = chooser.getSelectedFile();

                try {
                    fileName = new URL("file", "",
                            selectedFile.getAbsolutePath());
                } catch (MalformedURLException ex) {
                    System.out.println(ex);
                }

            }

//        fileName = args[0];
//        MidiPlayer myMidiPlayer = new MidiPlayer(fileName);

//        System.out.println(clip);

        // Set up the sequencer and load the MIDI file in.
        Sequence mySeq = MidiSystem.getSequence(fileName);

        // Get default sequencer.
        Sequencer mySequencer = MidiSystem.getSequencer();

        if (mySequencer == null) {
            // Error -- sequencer device is not supported.
            // Inform user and return...
        } else {
            // Acquire resources and make operational.

            mySequencer.open();
            mySequencer.setLoopCount(0);
            mySequencer.setSequence(mySeq);
            mySequencer.start();
//            System.out.println(mySequencer.getMicrosecondLength());
//            System.out.println(mySequencer.getTickLength());

            int counter;
            for (counter = 0; counter < mySequencer.getTickLength();) {
                
                if (mySequencer.getTickPosition() == mySequencer.getTickLength()) {

                    mySequencer.stop();
                    mySequencer.close();
                }                
            }
//            
//            // Create BufferedReader object from Standard input device.
//            // Standard input device is typically a keyboard.
//            // This will be used to enter stop signal.
//            BufferedReader dataIn = new BufferedReader(new InputStreamReader(System.in));
//            System.out.println("Press Enter key to stop playing.");
//            // Read entered data into play variable
//            String play = "play";
//            try {
//                play = dataIn.readLine();
//                if (play.isEmpty() == true) {
//                    mySequencer.stop();
//                    mySequencer.close();
//                }
//            } catch (IOException e) {
//                System.out.println("Error!");
//            }

        }
    }
}

//End MidiPlayer.java