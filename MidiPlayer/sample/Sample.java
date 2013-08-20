import java.io.*;
import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.midi.*;

public class Sample extends JFrame implements ActionListener{
	JFrame jframe;
	Container gcp;
	AudioClip ac=null;
	Button btp,bte;
	public Sample(){
		jframe = new JFrame("test");
		gcp = jframe.getContentPane();
		
		jframe.setDefaultCloseOperation(jframe.DO_NOTHING_ON_CLOSE);
		jframe.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				System.exit(0);
			}
		});
		Insets insets = jframe.getInsets();
		//サイズ
		jframe.setSize(300 + insets.left + insets.right,100 + insets.top + insets.bottom);
		jframe.setLocationRelativeTo(null);
		//レイアウト
		gcp.setLayout(new FlowLayout());
		//ボタン
		btp = new Button("play");
		gcp.add(btp);
		btp.addActionListener(this);
	/*	bte = new Button("end");
		gcp.add(bte);
		bte.addActionListener(this);
	*/	
		jframe.setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == btp){
				FileDialog fd=new FileDialog(this,null,FileDialog.LOAD);
			fd.show();
			if (ac!=null)
				ac.stop();
			ac=java.applet.Applet.newAudioClip
			  (Sample.class.getResource(fd.getFile()));
			ac.play();
		}
	//	if(e.getSource() == bte){
	//		System.exit(1);}
	}
	public static void main(String [] args){
		Sample s = new Sample();
	}
}