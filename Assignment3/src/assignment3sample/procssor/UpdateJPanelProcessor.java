package assignment3sample.procssor;

import assignment3sample.Business.Car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static assignment3sample.procssor.CarProcessor.QUES_6;
import static assignment3sample.procssor.CommonComponentUtil.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Endstart
 * Date: 2019-10-06
 * Time: 8:22
 */
public class UpdateJPanelProcessor {

    private JPanel searchJPanel = new JPanel();
    private JPanel updateJPanel = new JPanel();

    private JTextField searchField = new JTextField();

    private JButton searchBtn;
    private JButton submitBtn;

    private int previewSerialNum = 0;

    public JPanel playSearchJPanel(JSplitPane jSplitPanel) {
        searchBtn = new JButton("search");
        submitBtn = new JButton("submit");

        searchBtn.addActionListener((ActionEvent e) -> {
            String serialNum = searchField.getText();
            serialNum = serialNum == null ? "" : serialNum.trim();
            if (serialNum.length() == 0) {
                return;
            }
            int serialNumInt = 0;
            try {
                serialNumInt = Integer.parseInt(serialNum);
            } catch (Exception ignore) {
                alertError("Serial num is error.");
                return;
            }

            Car car = (Car) CarProcessor.filter(QUES_6, serialNumInt);
            if (car == null) {
                alertError("Serial num car is non-exist.");
                return;
            }
            previewSerialNum = serialNumInt;
            playUpdateJPanel(car, jSplitPanel);
        });


        searchJPanel.setSize(500, 400);

        JLabel searchLable = new JLabel("serial number:    ");

        // 为指定的 Container 创建 GroupLayout
        GroupLayout layout = new GroupLayout(searchJPanel);
        searchJPanel.setLayout(layout);

        //创建GroupLayout的水平连续组，越先加入的ParallelGroup，优先级级别越高。
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGap(5);//添加间隔
        hGroup.addGroup(layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup().addComponent(searchLable).addComponent(searchField))
                .addComponent(searchBtn));
        layout.setHorizontalGroup(hGroup);

        //创建GroupLayout的垂直连续组，越先加入的ParallelGroup，优先级级别越高。
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGap(10);
        vGroup.addGroup(layout.createParallelGroup().addGroup(layout.createParallelGroup().addComponent(searchLable).addComponent(searchField)));
        vGroup.addGap(10);
        vGroup.addGroup(layout.createParallelGroup().addComponent(searchBtn, GroupLayout.Alignment.CENTER));

        vGroup.addGap(10);

        // 设置垂直方向的指定组件的长度一致
        layout.linkSize(SwingConstants.VERTICAL, new Component[]{searchLable, searchField});

        //设置垂直组
        layout.setVerticalGroup(vGroup);

        searchJPanel.setVisible(true);
        return searchJPanel;
    }

    public JPanel playUpdateJPanel(Car car, JSplitPane jSplitPanel) {

        submitBtn.addActionListener((ActionEvent e) -> {
            Car carTmp = getInputCarInfo();
            if (carTmp == null) {
                alertError("Input error!");
                return;
            }
            if (carTmp.getSerial_num() != previewSerialNum) {
                Car tmp = (Car) CarProcessor.filter(QUES_6, carTmp.getSerial_num());
                if (tmp != null) {
                    alertError("new serial cat is exist.");
                }
            }
            int index = CarProcessor.removeCarBySerialNum(previewSerialNum);
            if (index >= 0) {
                CarProcessor.addCar(carTmp, index);
            } else {
                CarProcessor.addCar(carTmp);
            }

            alertSuc("Success");
        });

        brand.setText(car.getBrand());
        manufacturedYear.setText(car.getManufactured_year() + "");
        minSeats.setText(car.getMin_seats() + "");
        maxSeats.setText(car.getMax_seats() + "");
        serialNum.setText(car.getSerial_num() + "");
        modelNum.setText(car.getModel_num());
        availableCity.setText(car.getAvailable_city());
        available.setSelected(car.isAvailable());
        maintenanceCertificate.setSelected(car.isMaintenance_certificate());

        // 为指定的 Container 创建 GroupLayout
        GroupLayout layout = new GroupLayout(updateJPanel);
        updateJPanel.setLayout(layout);

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
                .addComponent(submitBtn));
        hGroup.addGap(5);
        layout.setHorizontalGroup(hGroup);

        //创建GroupLayout的垂直连续组，越先加入的ParallelGroup，优先级级别越高。
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGap(10);
        vGroup.addGroup(layout.createParallelGroup().addComponent(brand).addComponent(brandLabel, GroupLayout.Alignment.CENTER));
        vGroup.addGap(10);
        vGroup.addGroup(layout.createParallelGroup().addComponent(manufacturedYear).addComponent(manufactured_yearLabel, GroupLayout.Alignment.CENTER));
        vGroup.addGap(10);
        vGroup.addGroup(layout.createParallelGroup().addComponent(minSeats).addComponent(min_seatsLabel, GroupLayout.Alignment.CENTER));
        vGroup.addGap(10);
        vGroup.addGroup(layout.createParallelGroup().addComponent(maxSeats).addComponent(max_seatsLabel, GroupLayout.Alignment.CENTER));
        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(serialNum).addComponent(serial_numLabel, GroupLayout.Alignment.CENTER));
        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(modelNum).addComponent(model_numLabel, GroupLayout.Alignment.CENTER));
        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(availableCity).addComponent(available_cityLabel, GroupLayout.Alignment.CENTER));
        vGroup.addGap(5);

        vGroup.addGroup(layout.createParallelGroup().addComponent(available));
        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(maintenanceCertificate));
        vGroup.addGap(20);

        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(submitBtn));
        vGroup.addGap(10);
        //设置垂直组
        layout.setVerticalGroup(vGroup);

        updateJPanel.setVisible(true);
        jSplitPanel.setRightComponent(updateJPanel);

        return searchJPanel;
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
