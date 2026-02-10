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

//    private String loc = (String) "Manila";
//
//    JSONObject data = apIBackend.wedData(loc);
//
//    
//    private double tempData;
//    private int humidityData;
//    private double windSpeedData;
//    private String weatherFData;

	private	JSONObject weatherDate;
protected ImageIcon ororiginalIcon1;

    
    applicationGui() {
        super("weather app");
        
        
        setSize(300,580);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setResizable(false);
        guiComponents();
        temps();
        windSpeed();
        humidity();
        loc("manila");
  

        setVisible(true);
    }
   
    
//    private void fetchWeather(String location) {
//    	
//    	
//    	if (data != null) {
//    		tempData = (double) data.get("temps");
//    		humidityData = ((Long) data.get("humidity")).intValue();
//    		windSpeedData = (double) data.get("windSpeed");
//    		weatherFData = (String) data.get("weather");
//    	}
//    }
    
    
    
    private void guiComponents() {

        JTextField stf = new JTextField();
        stf.setBounds(10,10,230,38);
        stf.setFont(new Font("Dialog",Font.PLAIN,24));
        add(stf);

        JButton srB = new JButton(loadImage("C:/editor/weatherApplicatioNovice/src/resources/searched.png"));
        srB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        srB.setBounds(245,10,38,38);
        add(srB);

        ImageIcon originalIcon = loadImage("C:/editor/weatherApplicatioNovice/src/resources/windspeeds.png");
        Image resizedImage = originalIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        JLabel img = new JLabel(new ImageIcon(resizedImage));
        img.setBounds(50, 390, 80, 80);
        add(img);

        ImageIcon humidityIcon = loadImage("C:/editor/weatherApplicatioNovice/src/resources/huumidity.png");
        Image humidityIcon1 = humidityIcon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        JLabel img2 = new JLabel(new ImageIcon(humidityIcon1));
        img2.setBounds(180, 390, 70, 70);
        add(img2);
        
        
        

        ImageIcon originalIc = loadImage("C:/editor/weatherApplicatioNovice/src/resources/foggy.png");
        // Resize
        Image resizedIma = originalIc.getImage().getScaledInstance(210, 210, Image.SCALE_SMOOTH);
        ImageIcon scaledI = new ImageIcon(resizedIma);

        JLabel w =new JLabel(scaledI);
        w.setBounds( 0, 50, 300, 300);
        
        add(w);

        // cloud
        
        
        srB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String userInput = stf.getText();
                if (userInput.replaceAll("\\s", "").length() <= 0) {
                	return;
                }

//                JSONObject data = apIBackend.wedData(userInput);
//                
//                String weatherCondition = (String) data.get("weather");
//                
//                System.out.println(weatherCondition);
                
                String x = userInput;
            	switch (x) {
                case "Clear":
                	ImageIcon originalIcon = loadImage("C:/editor/weatherApplicatioNovice/src/resources/cloudy.png");
                    Image resizedImage = originalIcon.getImage().getScaledInstance(280, 280, Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon = new ImageIcon(resizedImage);
                    w.setIcon(scaledIcon);
                  
                    JLabel type = new JLabel("Cloudy");
                    type.setBounds(105,350,230,38);
                    type.setFont(new Font("Dialog",Font.BOLD , 25));
                    add(type);
                   
                    
                    break;

                case "Cloudy":
                	
                	
                	
                	
                    ImageIcon originalIcon1 = loadImage("C:/editor/weatherApplicatioNovice/src/resources/cloudy.png");
                    // Resize
                    Image resizedImage1 = originalIcon1.getImage().getScaledInstance(380, 380, Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon1 = new ImageIcon(resizedImage1);
                    
                    JLabel type1 = new JLabel("Cloudy");
                    type1.setBounds(105,350,230,38);
                    type1.setFont(new Font("Dialog",Font.BOLD , 25));
                    add(type1);
                    break;

                case "Foggy":
                	
                	
                	
                	
                	
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
                    break;
                    
                case "Rainy":
                	
                	
                	
                	
                	
                    ImageIcon originalIcon3 = loadImage("C:/editor/weatherApplicatioNovice/src/resources/rainy.png");
                    // Resize
                    Image resizedImage3 = originalIcon3.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                    ImageIcon scaledIcon3 = new ImageIcon(resizedImage3);
                    JLabel img3 = new JLabel(scaledIcon3);
                    img3.setBounds(-55, 10, 400, 400);
                    add(img3);
                    JLabel type3 = new JLabel("Rainy");
                    type3.setBounds(110,350,235,38);
                    type3.setFont(new Font("Dialog",Font.BOLD , 25));
                    add(type3);
                    break;

                case "Thunderstorm":
                	
                	
                	
                	
                	
                	
                	
                	
                	
                    ImageIcon Icon = loadImage("C:/editor/weatherApplicatioNovice/src/resources/thunderstorm.png");
                    // Resize
                    Image resizedImg = Icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                    ImageIcon scaledIco = new ImageIcon(resizedImg);
                    JLabel imge = new JLabel(scaledIco);
                    imge.setBounds(-55, 15, 400, 400);
                    add(imge);
                    JLabel typee = new JLabel("Thunderstorm");
                    typee.setBounds(65,350,230,38);
                    typee.setFont(new Font("Dialog",Font.BOLD , 25));
                    add(typee);
                    break;

                case "Snowy":
                	
                	
                	
                	
                	
                	
                	
                	
//                	ororiginalIcon1.setIcon(loadImage("C:/editor/weatherApplicatioNovice/src/resources/snowwy.png").getImage());

                    
                	JLabel type4 = new JLabel("Snowwy");
                    type4.setBounds(100,350,230,38);
                    type4.setFont(new Font("Dialog",Font.BOLD , 25));
                    add(type4);
                    break;
            
              
            	}
            

//                double temps = (double) data.get("temps");          
                

                
                
            } 
        });

   
    }

    private JLabel locLabel;   // ADD this field at top with other variables

    void loc(String location) {
        if(locLabel == null){   // create once
            locLabel = new JLabel(location);
            locLabel.setBounds(0,70,300,38); // full width, fixed vertical position
            locLabel.setHorizontalAlignment(SwingConstants.CENTER); // center text horizontally
            locLabel.setFont(new Font("Dialog",Font.BOLD,30));
            add(locLabel);
        } else {                // update text when button clicked
            locLabel.setText(location);
        }
    }


           
     
    

    private void temps() {
        JLabel temps = new JLabel("10°C");
        temps.setBounds(90,300,200,40);
        temps.setFont(new Font("Dialog",Font.BOLD,40));
        add(temps);
    }

    private JLabel windSpeed() {
        JLabel wind = new JLabel("Wind Speed:");
        wind.setBounds(30,470,300,20);
        wind.setFont(new Font("Dialog",Font.PLAIN,20));
        add(wind);
        return wind;
    }

    private JLabel humidity() {
        JLabel hum = new JLabel("Humidity");
        hum.setBounds(175,470,300,20);
        hum.setFont(new Font("Dialog",Font.PLAIN,20));
        add(hum);
        return hum;
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
