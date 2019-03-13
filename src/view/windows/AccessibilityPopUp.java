package view.windows;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.IOException;

import managers.SettingsManager;
import managers.WindowManager;



public class AccessibilityPopUp {
	
	private SettingsManager sm = SettingsManager.getInstance();
	private WindowManager wm = WindowManager.getInstance();
	
	private JFrame accPopUp = new JFrame("Visual Accessibility Options");
	
	public AccessibilityPopUp() {
		
		accPopUp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		accPopUp.setBounds(0,0, 830, 500);
		Container cont = accPopUp.getContentPane();
		cont.setLayout(null);
		
		JLabel top = new JLabel("<html><div style='text-align: center;'>Would you like to activate Visual Accessibility Options?</div></html>");
		top.setBounds(0, 50, 800, 50);
		top.setFont(new Font("SansSerif", Font.PLAIN, 30));
		top.setHorizontalAlignment(JLabel.CENTER);
		
		JPanel buttons = new JPanel(new GridLayout(1,2));
	    buttons.setBounds(50, 150, 700, 100);
		
		JButton yes = new JButton("Yes");
	    yes.setToolTipText("Go to Accessibility Options menu");
	    yes.setFont(new Font("SansSerif", Font.PLAIN, 30));
	    yes.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          OptionsWindow opt = wm.getOptionsWindow();
	          accPopUp.dispose();
	          opt.showAcc();
	        }
	      }); 
		
	    JButton no = new JButton("No");
	    no.setToolTipText("Continue with default settings");
	    no.setFont(new Font("SansSerif", Font.PLAIN, 30));
	    no.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	          accPopUp.dispose();
	        }
	      });
	    
	    JButton magnify = new JButton("<html><div style='text-align: center;'>Open<br/>Magnifier</div></html>");
	    magnify.setToolTipText("Opens Windows Magnifier Tool");
	    magnify.setFont(new Font("SansSerif", Font.PLAIN, 30));
	    magnify.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	try {
	        		Process p = Runtime.getRuntime().exec("cmd /c magnify.exe");
	        	} 
				catch (IOException e1) {
	        		e1.printStackTrace();
	        	}
	        }
	    });
	    
	    
	    
	    JLabel bottom = new JLabel("<html><div style='text-align: center;'>You can also change Accessibility Options later<br/>from the Options menu.</div></html>");
		bottom.setBounds(0, 100, 800, 400);
		bottom.setFont(new Font("SansSerif", Font.PLAIN, 24));
		bottom.setHorizontalAlignment(JLabel.CENTER);
		
	    buttons.add(yes);
	    buttons.add(no);
	    buttons.add(magnify);
		
	    cont.add(top);
		cont.add(buttons);
		cont.add(bottom);
		centre(accPopUp);
		accPopUp.setVisible(true);
	}

	public void centre(JFrame f) {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int h = f.getSize().height;
		int w = f.getSize().width;
		int x = (d.width - w) / 2;
		int y = (d.height - h) / 2;
		f.setLocation(x, y);
	}
	
}
