package weatherApplicatioNovice;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JButton;



public class applicationGui extends JFrame {
	applicationGui() {
	super("weather app");
		setSize(300,550);
	     setLayout(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	    setResizable(false); 
	     src();
	     imageDis("cloudy");
	     temps();
	     loc();
	    setVisible(true);
       
	}
	private void src() {

	//search field
    JTextField stf = new JTextField();
    stf.setBounds(10,10,230,38);
    stf.setFont(new Font("Dialog",Font.PLAIN , 24));
	add(stf);
	
	
	//button
	JButton srB = new JButton(loadImage("C:/editor/weatherApplicatioNovice/src/resources/searched.png"));
    srB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    srB.setBounds(245,10,38,38);
    add(srB);	
	}	
	
	private JLabel imageDis(String weathertype) {
		ImageIcon originalIcon = loadImage("C:/editor/weatherApplicatioNovice/src/resources/cloudy.png");
		// Resize
		Image resizedImage = originalIcon.getImage().getScaledInstance(340, 350, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(resizedImage);
		// pic
		if (weathertype.equalsIgnoreCase("cloudy")) {
			JLabel img = new JLabel(scaledIcon);
		
		img.setBounds(-55, 20, 400, 400);
		add(img); 	
		JLabel type = new JLabel("Cloudy");
		 type.setBounds(105,350,230,38);
		 type.setFont(new Font("Dialog",Font.BOLD , 25));
		 add(type);
		

		return img;
		} else if (weathertype.equalsIgnoreCase("rainy")) {
			
		}
		return null;
	}
	
	private void temps() {
	JLabel temps = new JLabel("10°C ");
	 temps.setBounds(100,310,230,38);
	 temps.setFont(new Font("Dialog",Font.BOLD , 40));
	 add(temps);
	}
	

	private void loc() {
		JLabel loc = new JLabel("Manila");
		 loc.setBounds(95,70,230,38);
		 loc.setFont(new Font("Dialog",Font.BOLD , 30));
		 add(loc);
		}

      
	private ImageIcon loadImage (String img) {
		try {
			BufferedImage image = ImageIO.read(new File(img));
			return new ImageIcon(image);
		}catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	}