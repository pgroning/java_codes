import javax.swing.*;

public class FahrToCel {
    
    public static void main(String[] args) {
        String fahrString;
        Double fahr, cel;
	
        fahrString =
	    JOptionPane.showInputDialog("Enter the temperature in Fahrenheit");
        fahr = new Double(fahrString);
        cel = (fahr - 32) * 5.0/9.0;

	cel = Double.parseDouble(String.format("%.1f", cel));
	
        JOptionPane.showMessageDialog(null,"The temperature in Celsius is, " + cel);
    }
    
}
