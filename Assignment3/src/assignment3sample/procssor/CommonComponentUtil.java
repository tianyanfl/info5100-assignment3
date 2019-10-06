package assignment3sample.procssor;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Endstart
 * Date: 2019-10-06
 * Time: 10:37
 */
public class CommonComponentUtil {

    public static JTextField brand = new JTextField();
    public static JTextField manufacturedYear = new JTextField();
    public static JTextField minSeats = new JTextField();
    public static JTextField maxSeats = new JTextField();
    public static JTextField serialNum = new JTextField();
    public static JTextField modelNum = new JTextField();
    public static JTextField availableCity = new JTextField();
    public static JRadioButton available = new JRadioButton("available");
    public static JRadioButton maintenanceCertificate = new JRadioButton("maintenance certificate");

    public static  JLabel brandLabel = new JLabel("brand:");
    public static  JLabel manufactured_yearLabel = new JLabel("manufactured year:");
    public static  JLabel min_seatsLabel = new JLabel("min seats:");
    public static  JLabel max_seatsLabel = new JLabel("max seats:");
    public static  JLabel serial_numLabel = new JLabel("serial num:");
    public static  JLabel model_numLabel = new JLabel("model num:");
    public static  JLabel available_cityLabel = new JLabel("available city:");

    public static void clearInput() {
        brand.setText("");
        manufacturedYear.setText("");
        minSeats.setText("");
        maxSeats.setText("");
        serialNum.setText("");
        modelNum.setText("");
        availableCity.setText("");
        available.setSelected(true);
        maintenanceCertificate.setSelected(true);
    }

    public static void alertError(String errorMsg) {
        alert("ERROR", errorMsg);
    }

    public static void alertSuc(String msg) {
        alert("SUCCESS", msg);
    }

    public static void alert(String title, String errorMsg) {
        Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screen.width;
        int screenHeight = screen.height;
        int jFrameWidth = 300;
        int jFrameHeight = 150;

        JFrame alertJFrame = new JFrame();
        alertJFrame.setBounds((screenWidth - jFrameWidth) / 2, (screenHeight - jFrameHeight) / 2, jFrameWidth, jFrameHeight);
        alertJFrame.setTitle(title);
        JLabel errorMsgLabel = new JLabel(errorMsg, JLabel.CENTER);
        errorMsgLabel.setFont(new Font("微软雅黑", Font.PLAIN, 13));
        alertJFrame.getContentPane().add(errorMsgLabel);
        alertJFrame.setVisible(true);
    }
}
