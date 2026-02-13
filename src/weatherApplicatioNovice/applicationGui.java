package weatherApplicatioNovice;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import org.json.simple.JSONObject;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class applicationGui extends JFrame {
    
    applicationGui() {
        super("weather app");   
        
        //frame
        setSize(300,580);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // gui
        guiComponents();
        setVisible(true);
    }
    
    
    private void guiComponents() {
    	
    	int frameWidth = getWidth(); 

    	
    	//search text field or stf
        JTextField stf = new JTextField();
        stf.setBounds(10,10,230,38);
        stf.setFont(new Font("Dialog",Font.PLAIN,24));
        add(stf);

        //seachButton
        JButton srB = new JButton(loadImage("C:/editor/weatherApplicatioNovice/src/resources/searched.png"));
        srB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        srB.setBounds(245,10,38,38);
        add(srB);
        
        //windSpeed png
        ImageIcon originalIcon = loadImage("C:/editor/weatherApplicatioNovice/src/resources/windspeed.png");
        Image resizedImage = originalIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JLabel img = new JLabel(new ImageIcon(resizedImage));
        img.setBounds(50, 410, 80, 80);
        add(img);

        // Humidity png
        ImageIcon humidityIcon = loadImage("C:/editor/weatherApplicatioNovice/src/resources/humidity.png");
        Image humidityIcon1 = humidityIcon.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        JLabel img2 = new JLabel(new ImageIcon(humidityIcon1));
        img2.setBounds(180, 420, 70, 70);
        add(img2);
        
        //MAIN PICTURE
        ImageIcon originalIc = loadImage("C:/editor/weatherApplicatioNovice/src/resources/titleIcon.png");
        Image resizedIma = originalIc.getImage().getScaledInstance(210, 210, Image.SCALE_SMOOTH);
        ImageIcon scaledI = new ImageIcon(resizedIma);
        JLabel w =new JLabel(scaledI);
        w.setBounds( -10, 48, 300, 300);
        add(w);        
     
        
        // THE TEXTS
        JLabel wind = new JLabel("Wind Speed:");
        wind.setBounds(30,480,300,20);
        wind.setFont(new Font("Dialog",Font.PLAIN,20));
        add(wind);

        JLabel wind2 = new JLabel("");
        wind2.setBounds(30,510,300,20);
        wind2.setFont(new Font("Dialog",Font.PLAIN,20));
        add(wind2);

        JLabel location = new JLabel("");
        location.setBounds(0,57,300,38); 
        location.setHorizontalAlignment(SwingConstants.CENTER); 
        location.setFont(new Font("Dialog",Font.BOLD,30));
        add(location);
        
        JLabel hum2 = new JLabel("Humidity");
        hum2.setBounds(175,480,300,20);
        hum2.setFont(new Font("Dialog",Font.PLAIN,20));
        add(hum2);
        
        JLabel hum = new JLabel("");
        hum.setBounds(185,510,300,20);
        hum.setFont(new Font("Dialog",Font.PLAIN,20));
        add(hum);

        JLabel text = new JLabel("City");
        text.setBounds(0, 365, frameWidth, 40);
        text.setHorizontalAlignment(SwingConstants.CENTER);
        text.setFont(new Font("Dialog",Font.PLAIN,35));
        add(text);
        
        JLabel temps = new JLabel("Search");
    	temps.setBounds(0, 328, frameWidth, 40);
    	temps.setHorizontalAlignment(SwingConstants.CENTER);
    	temps.setFont(new Font("Dialog", Font.BOLD, 40));
    	add(temps);

    	
    	//ACTION WHEN THE BUTTON IS CLICKED
        srB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String userInput = stf.getText();
                if (userInput.replaceAll("\\s", "").length() <= 0) {
                	return;             }
                
                location.setText(userInput);
                
                JSONObject data = apIBackend.wedData(userInput);
                
                String weatherCondition = (String) data.get("weather");
                
                System.out.println(weatherCondition);
                
            	switch (weatherCondition) {
  
                case "Clear":
                	ImageIcon originalIcon = loadImage("C:/editor/weatherApplicatioNovice/src/resources/cloudy.png");
                    Image resizedImage = originalIcon.getImage().getScaledInstance(210, 210, Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon = new ImageIcon(resizedImage);
                    w.setIcon(scaledIcon);
                    text.setText("Clear");
                    break;

                case "Cloudy":
                	ImageIcon originalIcon1 = loadImage("C:/editor/weatherApplicatioNovice/src/resources/clear.png");
                    Image resizedImage1 = originalIcon1.getImage().getScaledInstance(210, 210, Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon1 = new ImageIcon(resizedImage1);
                    w.setIcon(scaledIcon1);
                    text.setText("Cloudy");
                     break;

                case "Foggy":
                	ImageIcon originalIcon2 = loadImage("C:/editor/weatherApplicatioNovice/src/resources/foggy.png");
                    Image resizedImage2 = originalIcon2.getImage().getScaledInstance(210, 210, Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon2 = new ImageIcon(resizedImage2);
                    w.setIcon(scaledIcon2);
                    text.setText("Foggy");
                    break;
                    
                case "Rainy":	
                	ImageIcon originalIcon3 = loadImage("C:/editor/weatherApplicatioNovice/src/resources/rainy.png");
                    Image resizedImage3 = originalIcon3.getImage().getScaledInstance(210, 210, Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon3 = new ImageIcon(resizedImage3);
                    w.setIcon(scaledIcon3);
                    text.setText("Rainy");
                    break;

                case "Thunderstorm":	
                	ImageIcon originalIcon4 = loadImage("C:/editor/weatherApplicatioNovice/src/resources/thunderstorm.png");
                    Image resizedImage4 = originalIcon4.getImage().getScaledInstance(210, 210, Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon4 = new ImageIcon(resizedImage4);
                    w.setIcon(scaledIcon4);
                    text.setText("Thunderstorm");              
                    break;

                case "Snowy":    
                	ImageIcon originalIcon5 = loadImage("C:/editor/weatherApplicatioNovice/src/resources/snowwy.png");
                    Image resizedImage5 = originalIcon5.getImage().getScaledInstance(210, 210, Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon5 = new ImageIcon(resizedImage5);
                    w.setIcon(scaledIcon5);
                    text.setText("Snowy");             
                    break;
            	}
            	
            	
            	double tempData = (double) data.get("temps");
            	temps.setText(tempData + "C" );
            	
            	Long humidityData = (long) ((Long) data.get("humidity")).intValue();
            	hum.setText(humidityData + "");
            	
            	double	windSpeedData = (double) data.get("windSpeed");
            	wind2.setText(windSpeedData + "");
            	revalidate();
            	repaint();
            } 
        });
   
    }

    private ImageIcon loadImage(String img) {
        try {
            BufferedImage image = ImageIO.read(new File(img));
            return new ImageIcon(image);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
