package assignment3sample.page;

import assignment3sample.Business.Car;
import assignment3sample.Business.CarInfoProcess;
import assignment3sample.Interface.MainFrame_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Endstart
 * Date: 2019-10-05
 * Time: 20:27
 */
public class CreatePage {
    private JPanel jPanel = new JPanel();

    private JTextField brand = new JTextField();
    private JTextField manufacturedYear = new JTextField();
    private JTextField minSeats = new JTextField();
    private JTextField maxSeats = new JTextField();
    private JTextField serialNum = new JTextField();
    private JTextField modelNum = new JTextField();
    private JTextField availableCity = new JTextField();
    private JRadioButton available = new JRadioButton("available");
    private JRadioButton maintenanceCertificate = new JRadioButton("maintenance certificate");

    private JButton createBtn;

    public JPanel playCreateJPanel() {
//        brand.setSize(20, 5);
        brand.setPreferredSize(new Dimension(5,5));
        manufacturedYear.setColumns(50);

        createBtn = new JButton("create");
        createBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Car car = getInputCarInfo();
                if (car == null) {
                    MainFrame_1.alertError("Input error!");
                    return;
                }
                if (CarInfoProcess.getSerialNumMap().containsKey(car.getSerial_num())) {
                    MainFrame_1.alertError("Serial num cat is exist.");
                    return;
                }
                CarInfoProcess.addNewCar(car);
                clearInput();
                MainFrame_1.alertSuc("Success");
            }
        });

        available.setSelected(true);
        maintenanceCertificate.setSelected(true);

        jPanel.setSize(500, 400);

        JLabel brandLabel = new JLabel("brand:");
        JLabel manufactured_yearLabel = new JLabel("manufactured year:");
        JLabel min_seatsLabel = new JLabel("min seats:");
        JLabel max_seatsLabel = new JLabel("max seats:");
        JLabel serial_numLabel = new JLabel("serial num:");
        JLabel model_numLabel = new JLabel("model num:");
        JLabel available_cityLabel = new JLabel("available city:");

        // 为指定的 Container 创建 GroupLayout
        GroupLayout layout = new GroupLayout(jPanel);
        jPanel.setLayout(layout);

        //创建GroupLayout的水平连续组，越先加入的ParallelGroup，优先级级别越高。
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGap(5);//添加间隔
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(brandLabel)
                .addComponent(manufactured_yearLabel)
                .addComponent(min_seatsLabel)
                .addComponent(max_seatsLabel)
                .addComponent(serial_numLabel)
                .addComponent(available_cityLabel)
                .addComponent(model_numLabel));
        hGroup.addGap(5);
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(brand)
                .addComponent(manufacturedYear)
                .addComponent(minSeats)
                .addComponent(maxSeats)
                .addComponent(serialNum)
                .addComponent(modelNum)
                .addComponent(availableCity)
                .addComponent(available)
                .addComponent(maintenanceCertificate)
                .addComponent(createBtn));
        hGroup.addGap(5);
        layout.setHorizontalGroup(hGroup);

        //创建GroupLayout的垂直连续组，越先加入的ParallelGroup，优先级级别越高。
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGap(10);
        vGroup.addGroup(layout.createParallelGroup().addComponent(brand).addComponent(brandLabel,GroupLayout.Alignment.CENTER));
        vGroup.addGap(10);
        vGroup.addGroup(layout.createParallelGroup().addComponent(manufacturedYear).addComponent(manufactured_yearLabel,GroupLayout.Alignment.CENTER));
        vGroup.addGap(10);
        vGroup.addGroup(layout.createParallelGroup().addComponent(minSeats).addComponent(min_seatsLabel,GroupLayout.Alignment.CENTER));
        vGroup.addGap(10);
        vGroup.addGroup(layout.createParallelGroup().addComponent(maxSeats).addComponent(max_seatsLabel,GroupLayout.Alignment.CENTER));
        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(serialNum).addComponent(serial_numLabel,GroupLayout.Alignment.CENTER));
        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(modelNum).addComponent(model_numLabel,GroupLayout.Alignment.CENTER));
        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(availableCity).addComponent(available_cityLabel,GroupLayout.Alignment.CENTER));
        vGroup.addGap(5);

        vGroup.addGroup(layout.createParallelGroup().addComponent(available));
        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(maintenanceCertificate));
        vGroup.addGap(20);

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(createBtn));
        vGroup.addGap(10);
        //设置垂直组
        layout.setVerticalGroup(vGroup);

        jPanel.setVisible(true);
        return jPanel;
    }

    private Car getInputCarInfo() {
        try {
            String brandValue = brand.getText();
            int manufacturedYearValue = Integer.parseInt(manufacturedYear.getText());
            int minSeatsValue = Integer.parseInt(minSeats.getText());
            int maxSeatsValue = Integer.parseInt(maxSeats.getText());
            int serialNumValue = Integer.parseInt(serialNum.getText());
            String modelNumValue = modelNum.getText();
            String availableCityValue = availableCity.getText();
            boolean availableValue = available.isSelected();
            boolean maintenanceCertificateValue = maintenanceCertificate.isSelected();

            brandValue = brandValue == null ? "" : brandValue.trim();
            modelNumValue = modelNumValue == null ? "" : modelNumValue.trim();
            availableCityValue = availableCityValue == null ? "" : availableCityValue.trim();
            if (brandValue.length() == 0 || modelNumValue.length() == 0 || availableCityValue.length() == 0 ||
                    minSeatsValue <= 0 || minSeatsValue > maxSeatsValue || manufacturedYearValue <= 0) {
                return null;
            }

            return new Car(availableValue, brandValue, manufacturedYearValue, minSeatsValue, maxSeatsValue,
                    serialNumValue, modelNumValue, availableCityValue, maintenanceCertificateValue);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void clearInput() {
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
}
