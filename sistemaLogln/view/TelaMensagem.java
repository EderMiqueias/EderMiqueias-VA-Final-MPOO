package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TelaMensagem extends JOptionPane{
	private static final long serialVersionUID = 1L;
	
	public TelaMensagem(String msg, String title, int operation) {
		showMessageDialog(new JFrame(),
				msg,
				title,
				operation
		);
		
	}

}
