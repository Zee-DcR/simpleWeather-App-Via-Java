package weatherApplicatioNovice;
import org.json.simple.JSONObject;
import javax.swing.*;

public class MainLauncher {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                // Test location: Mindanao
                JSONObject data = apIBackend.wedData("kabacan");

                if (data != null) {

                    System.out.println("Temperature: " + data.get("temps") + " °C");
                    System.out.println("Humidity: " + data.get("humidity") + " %");
                    System.out.println("Wind Speed: " + data.get("windSpeed") + " m/s");
//                    System.out.println(data.get("weather"));

                    String wet = (String) data.get("weather");
                    System.out.println(wet);

                } else {
                    System.out.println("No data returned.");
                }

                applicationGui w = new applicationGui();

            }
        });
    }
}
