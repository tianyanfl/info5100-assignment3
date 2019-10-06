package assignment3sample.procssor;

import assignment3sample.Business.Car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static assignment3sample.procssor.CommonComponentUtil.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Endstart
 * Date: 2019-10-05
 * Time: 20:27
 */
public class CreateJPanelProcessor {
    private JPanel jPanel = new JPanel();

    private JButton createBtn;

    public JPanel playCreateJPanel() {
        brand.setPreferredSize(new Dimension(5,5));
        manufacturedYear.setColumns(50);

        createBtn = new JButton("create");
        createBtn.addActionListener((ActionEvent e) -> {
            Car car = getInputCarInfo();
            if (car == null) {
                alertError("Input error!");
                return;
            }
            if (CarProcessor.getSerialNumMap().containsKey(car.getSerial_num())) {
                alertError("Serial num cat is exist.");
                return;
            }
            CarProcessor.addCar(car);
            clearInput();
            alertSuc("Success");
        });


        available.setSelected(true);
        maintenanceCertificate.setSelected(true);

        jPanel.setSize(500, 400);

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
}
