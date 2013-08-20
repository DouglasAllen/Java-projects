import java.io.File;
import javax.sound.midi.*;
import javax.swing.JOptionPane;

/**
 * 
 */
public class MidiPlayer {

	// =============================================
	private File mFile;				
	private Sequencer mSequencer;	
	private boolean mReady = false; 

	//  =============================================

	/**
	 * 
	 */
	public MidiPlayer()
	{
		// 
		init();
	}

	/**
	 * ファイナライザ
	 */
	protected void finalize() throws Throwable {

		// 
		if ( mSequencer.isOpen() )
		{
			mSequencer.close();
		}

		super.finalize();
	}

	//  =============================================

	/**
	 * 
	 */
	public void play()
	{
		//

		// 
		if ( mReady )
		{
			mSequencer.start();
		}
	}

	/**
	 * 
	 */
	public void stop()
	{
		// 
		if ( ( mReady ) && ( mSequencer.isRunning() ) )
		{
			mSequencer.stop();
		}
	}

	/**
	 * 
	 * @return boolean true
	 */
	public boolean isReady()
	{
		return mReady;
	}

	/**
	 * 
	 * @return boolean �true
	 */
	public boolean isPlay()
	{
		return mSequencer.isRunning();
	}

	/**
	 * 
	 */
	public void setFile( File file )
	{
		// 
		mReady = false;

		// 
		if ( file != null )
		{
			// 
			if ( mSequencer.isRunning() )
			{
				mSequencer.stop();
			}

			// 
			mFile = file;

			try
			{
				// 
				Sequence s = MidiSystem.getSequence( mFile );
				mSequencer.setSequence( s );
			}
			catch( Exception e )
			{
				JOptionPane.showMessageDialog(
							null,
							"",
							"",
							JOptionPane.ERROR_MESSAGE
						);
			}

			// ON
			mReady = true;
		}
	}



	//  ==============================================
	/**
	 * MIDI
	 */
	private void init()
	{
		try
		{
			// 
			mSequencer = MidiSystem.getSequencer();
			mSequencer.open();

			// 
			setFile( mFile );
		}
		catch( Exception e )
		{
			JOptionPane.showMessageDialog(
						null,
						"",
						"",
						JOptionPane.ERROR_MESSAGE
					);
		}
	}

}
