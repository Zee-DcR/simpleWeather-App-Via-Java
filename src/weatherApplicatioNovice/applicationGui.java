package weatherApplicatioNovice;
import org.json.simple.JSONObject;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JButton;



public class applicationGui extends JFrame {
	JSONObject data = apIBackend.wedData("kabacan");
	  String wet = (String) data.get("weather");		
	applicationGui() {
	super("weather app");
		setSize(300,550);
	     setLayout(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    getContentPane().setBackground(Color.WHITE);
	    setLocationRelativeTo(null);
	    setResizable(false); 
	     src();
	     imageDis(wet);
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
		
		
		
		
		// pic
		switch (weathertype) {
		
		
		case "Clear":
			
			
			ImageIcon originalIcon = loadImage("C:/editor/weatherApplicatioNovice/src/resources/clear.png");
			// Resize
			Image resizedImage = originalIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
			ImageIcon scaledIcon = new ImageIcon(resizedImage);

			JLabel img = new JLabel(scaledIcon);
			img.setBounds(-55, 15, 400, 400);
			add(img); 	
			JLabel type = new JLabel("Clear");
			type.setBounds(105,350,230,38);
			type.setFont(new Font("Dialog",Font.BOLD , 25));
			add(type);
		
			return img;
		case "Cloudy":
			
			ImageIcon originalIcon1 = loadImage("C:/editor/weatherApplicatioNovice/src/resources/cloudy.png");
			// Resize
			Image resizedImage1 = originalIcon1.getImage().getScaledInstance(380, 380, Image.SCALE_SMOOTH);
			ImageIcon scaledIcon1 = new ImageIcon(resizedImage1);

			JLabel img1 = new JLabel(scaledIcon1);
			img1.setBounds(-55, 20, 400, 400);
			add(img1); 	
			JLabel type1 = new JLabel("Cloudy");
			type1.setBounds(105,350,230,38);
			type1.setFont(new Font("Dialog",Font.BOLD , 25));
			add(type1);
		
			return img1;

			
		case "foggy":
			
			ImageIcon originalIcon2 = loadImage("C:/editor/weatherApplicatioNovice/src/resources/foggy.png");
			// Resize
			Image resizedImage2 = originalIcon2.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
			ImageIcon scaledIcon2 = new ImageIcon(resizedImage2);

			JLabel img2 = new JLabel(scaledIcon2);
			img2.setBounds(-55, 15, 400, 400);
			add(img2); 	
			JLabel type2 = new JLabel("Foggy");
			type2.setBounds(105,350,230,38);
			type2.setFont(new Font("Dialog",Font.BOLD , 25));
			add(type2);
		
			return img2;

			 
		
		
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