

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
//import javax.sound.midi.Receiver;
import javax.sound.midi.Receiver;
import javax.sound.midi.Transmitter;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Synthesizer;

/**
 *
 * @author KB9AGT
 */
public class DirectSynth  {

    /**
     * @param args the command line arguments
     * @throws InvalidMidiDataException
     * @throws MidiUnavailableException 
     */
    public static void main(String[] args) throws InvalidMidiDataException, MidiUnavailableException {
        // TODO code application logic here

        ShortMessage myMsg = new ShortMessage();
        // Play the note Middle C (60) moderately loud
        // (velocity = 93)on channel 4 (zero-based).
        myMsg.setMessage(ShortMessage.NOTE_ON, 0, 60, 93);
        //System.out.println(MidiSystem.);
        Synthesizer synth = MidiSystem.getSynthesizer();
        synth.open();
        Receiver synthRcvr = synth.getReceiver();
        //Transmitter synthTrans = synth.getTransmitter();
        synthRcvr.send(myMsg, -1); // -1 means no time stamp
        //synthTrans.
//        synth.close();
    }
    
}
