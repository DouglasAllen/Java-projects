import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

/**
 *
 */
public class MainWindow extends WindowAdapter implements ActionListener
{
	// =============================================

	// 
	private String mWindowTitle = "MIDI Player";

	private String mOpenButtonLabel = "Open";
	private String mPlayButtonLabel = "Play";
	private String mStopButtonLabel = "Pause";

	private Dimension mButtonSize = new Dimension( 200, 80 ); 

	private JFrame mJFrame;			
	private Container mContainer;	
	private Button mPlayButton;		
	private Button mStopButton;		


	private MidiPlayer mMidiPlayer; 


	//  =============================================
	/**
	 * 
	 */
	public MainWindow()
	{
		// 
		initComponent();

		// MIDI
		mMidiPlayer = new MidiPlayer();
	}


	// ==============================================
	/**
	 * 
	 *
	 * @param event 
	 */
	public void windowClosing( WindowEvent event ) {
		// 
		System.exit(0);
	}


	/**
	 * 
	 *
	 * @param event 
	 */
	public void actionPerformed( ActionEvent event ) {

		// 
		Object trigger = event.getSource();

		if ( trigger == mPlayButton )
		{
			// 
			playButtonOnDown( event );
		}
		else if ( trigger == mStopButton )
		{
			// 
			stopButtonOnDown( event );
		}

	}


	//  =============================================

	/**
	 * 
	 */
	public void show()
	{
		// 
		mJFrame.setVisible( true );
	}

	//  ==============================================
	/**
	 * 
	 */
	private void initComponent()
	{
		mJFrame = new JFrame( mWindowTitle );

		// 
		mContainer = mJFrame.getContentPane();

		// 
		mJFrame.setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );
		// 
		mJFrame.addWindowListener( this );

		// 
		Insets insets = mJFrame.getInsets();

		//
		mJFrame.setSize(
					320 + insets.left + insets.right,
					240 + insets.top + insets.bottom
				);

		// 
		mJFrame.setLocationRelativeTo( null );

		// 
		mContainer.setLayout( new FlowLayout() );

		// 
		mPlayButton = new Button( mOpenButtonLabel );
		mPlayButton.setPreferredSize( mButtonSize );
		mPlayButton.addActionListener( this );

		// 
		mStopButton = new Button( mStopButtonLabel );
		mStopButton.setPreferredSize( mButtonSize );
		mStopButton.addActionListener( this );
		mStopButton.setEnabled( false );

		// 
		mContainer.add( mPlayButton );
		mContainer.add( mStopButton );
	}

	/**
	 * 
	 */
	private void playButtonOnDown( ActionEvent event )
	{
		// 
		FileDialog dialog = new FileDialog(
									mJFrame,		//
									null,			//
									FileDialog.LOAD // 
								);

		// 
		dialog.setVisible( true );

		// 
		if ( dialog.getFile() != null )
		{
			// 
			String fileName = dialog.getDirectory() + dialog.getFile();

			// 
			File file = new File( fileName );

			// 
			mMidiPlayer.setFile( file );

			// 
			if ( mMidiPlayer.isReady() )
			{
				// 
				mMidiPlayer.play();
				// 
				mStopButton.setLabel( mStopButtonLabel );
				mStopButton.setEnabled( true );
			}
		}
	}

	/**
	 * 
	 */
	private void stopButtonOnDown( ActionEvent event )
	{
		// 
		if ( mMidiPlayer.isPlay() )
		{
			// 
			mMidiPlayer.stop();
			mStopButton.setLabel( mPlayButtonLabel );
		}
		else
		{
			//
			mMidiPlayer.play();
			mStopButton.setLabel( mStopButtonLabel );
		}
	}


}
