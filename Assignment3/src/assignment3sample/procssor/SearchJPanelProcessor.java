package assignment3sample.procssor;

import assignment3sample.Business.Car;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Endstart
 * Date: 2019-10-05
 * Time: 21:37
 */
public class SearchJPanelProcessor {

    private JPanel questionJPanel;
    private JPanel resultJPanel;
    private JTextArea resultArea;

    private JLabel quesOneInput = new JLabel();
    private JButton quesOneBtn = new JButton("search");

    private JLabel quesTwoInput = new JLabel();
    private JButton quesTwoBtn = new JButton("search");

    private JTextField quesThreeInput = new JTextField();
    private JButton quesThreeBtn = new JButton("search");

    private JTextField quesFourInput = new JTextField(10);
    private JButton quesFourBtn = new JButton("search");

    private JTextField quesFiveInputMin = new JTextField("min");
    private JTextField quesFiveInputMax = new JTextField("max");
    private JButton quesFiveBtn = new JButton("search");

    private JTextField quesSixInput = new JTextField("serial num");
    private JButton quesSixBtn = new JButton("search");

    private JTextField quesSevenInput = new JTextField("model num");
    private JButton quesSevenBtn = new JButton("search");

    private JLabel quesEightInput = new JLabel();
    private JButton quesEightBtn = new JButton("search");

    private JLabel quesNineInput = new JLabel();
    private JButton quesNineBtn = new JButton("search");

    private JTextField quesTenInput = new JTextField("city");
    private JButton quesTenBtn = new JButton("search");

    private JLabel quesElevenInput = new JLabel();
    private JButton quesElevenBtn = new JButton("search");

    public SearchJPanelProcessor() {
        questionJPanel = new JPanel();
        resultJPanel = new JPanel();
        resultArea = new JTextArea();
        initResultJPanel();
    }


    public JPanel playSearchQuestionJPanel(JSplitPane jSplitPanel) {

        JLabel quesOneLabel = new JLabel("1. first available car");
        JLabel quesTwoLabel = new JLabel("2. current available cars and not");
        JLabel quesThreeLabel = new JLabel("3. cars made by");
        JLabel quesFourLabel = new JLabel("4. cars made in year");
        JLabel quesFiveLabel = new JLabel("5. available car with seat number");
        JLabel quesSixLabel = new JLabel("6. a car with serial number");
        JLabel quesSevenLabel = new JLabel("7. cars with given model number");
        JLabel quesEightLabel = new JLabel("8. manufacturers of cars used in Uber");
        JLabel quesNineLabel = new JLabel("9. last time of catalog updated");
        JLabel quesTenLabel = new JLabel("10. available cars in given city");
        JLabel quesElevenLabel = new JLabel("11. cars with expired maintenance certificate");

        initBtnAction(jSplitPanel);

        GroupLayout layout = new GroupLayout(questionJPanel);
        questionJPanel.setLayout(layout);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(quesOneLabel)
                .addComponent(quesTwoLabel)
                .addComponent(quesThreeLabel)
                .addComponent(quesFourLabel)
                .addComponent(quesFiveLabel)
                .addComponent(quesSixLabel)
                .addComponent(quesSevenLabel)
                .addComponent(quesEightLabel)
                .addComponent(quesNineLabel)
                .addComponent(quesTenLabel)
                .addComponent(quesElevenLabel));

        hGroup.addGap(2);
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(quesOneInput)
                .addComponent(quesTwoInput)
                .addComponent(quesThreeInput)
                .addComponent(quesFourInput)
                .addGroup(layout.createSequentialGroup().addComponent(quesFiveInputMin).addComponent(quesFiveInputMax))
                .addComponent(quesSixInput)
                .addComponent(quesSevenInput)
                .addComponent(quesEightInput)
                .addComponent(quesNineInput)
                .addComponent(quesTenInput)
                .addComponent(quesElevenInput));

        hGroup.addGap(5);
        hGroup.addGroup(layout.createParallelGroup()
                .addComponent(quesOneBtn)
                .addComponent(quesTwoBtn)
                .addComponent(quesThreeBtn)
                .addComponent(quesFourBtn)
                .addComponent(quesFiveBtn)
                .addComponent(quesSixBtn)
                .addComponent(quesSevenBtn)
                .addComponent(quesEightBtn)
                .addComponent(quesNineBtn)
                .addComponent(quesTenBtn)
                .addComponent(quesElevenBtn));

        hGroup.addGap(5);

        layout.setHorizontalGroup(hGroup);

        //创建GroupLayout的垂直连续组，越先加入的ParallelGroup，优先级级别越高。
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(quesOneLabel, GroupLayout.Alignment.CENTER).addComponent(quesOneInput).addComponent(quesOneBtn));
        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(quesTwoLabel, GroupLayout.Alignment.CENTER).addComponent(quesTwoInput).addComponent(quesTwoBtn));
        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(quesThreeLabel, GroupLayout.Alignment.CENTER).addComponent(quesThreeInput).addComponent(quesThreeBtn));
        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(quesFourLabel, GroupLayout.Alignment.CENTER).addComponent(quesFourInput).addComponent(quesFourBtn));
        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(quesFiveLabel, GroupLayout.Alignment.CENTER).addGroup(layout.createParallelGroup().addComponent(quesFiveInputMin).addComponent(quesFiveInputMax)).addComponent(quesFiveBtn));

        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(quesSixLabel, GroupLayout.Alignment.CENTER).addComponent(quesSixInput).addComponent(quesSixBtn));

        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(quesSevenLabel, GroupLayout.Alignment.CENTER).addComponent(quesSevenInput).addComponent(quesSevenBtn));

        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(quesEightLabel, GroupLayout.Alignment.CENTER).addComponent(quesEightInput).addComponent(quesEightBtn));

        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(quesNineLabel, GroupLayout.Alignment.CENTER).addComponent(quesNineInput).addComponent(quesNineBtn));

        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(quesTenLabel, GroupLayout.Alignment.CENTER).addComponent(quesTenInput).addComponent(quesTenBtn));

        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(quesElevenLabel, GroupLayout.Alignment.CENTER).addComponent(quesElevenInput).addComponent(quesElevenBtn));

        vGroup.addGap(5);
        // 设置垂直方向的指定组件的长度一致
        layout.linkSize(SwingConstants.VERTICAL, new Component[]{quesTwoInput, quesThreeInput, quesFourInput, quesFiveInputMin, quesFiveInputMax, quesSixInput, quesSevenInput, quesTenInput});
        //设置垂直组
        layout.setVerticalGroup(vGroup);

        questionJPanel.setVisible(true);
        return questionJPanel;
    }

    private void initBtnAction(JSplitPane jSplitPanel) {
        quesOneBtn.addActionListener((ActionEvent e) -> {
            playResultJPanel(CarProcessor.QUES_1);
            jSplitPanel.setRightComponent(resultJPanel);
        });


        quesTwoBtn.addActionListener((ActionEvent e) -> {
            playResultJPanel(CarProcessor.QUES_2);
            jSplitPanel.setRightComponent(resultJPanel);
        });
        quesThreeBtn.addActionListener((ActionEvent e) -> {
            playResultJPanel(CarProcessor.QUES_3);
            jSplitPanel.setRightComponent(resultJPanel);
        });
        quesFourBtn.addActionListener((ActionEvent e) -> {
            playResultJPanel(CarProcessor.QUES_4);
            jSplitPanel.setRightComponent(resultJPanel);
        });
        quesFiveBtn.addActionListener((ActionEvent e)-> {
                playResultJPanel(CarProcessor.QUES_5);
                jSplitPanel.setRightComponent(resultJPanel);
        });
        quesSixBtn.addActionListener((ActionEvent e) -> {
            playResultJPanel(CarProcessor.QUES_6);
            jSplitPanel.setRightComponent(resultJPanel);
        });
        quesSevenBtn.addActionListener((ActionEvent e) -> {
            playResultJPanel(CarProcessor.QUES_7);
            jSplitPanel.setRightComponent(resultJPanel);
        });
        quesEightBtn.addActionListener((ActionEvent e)-> {
                playResultJPanel(CarProcessor.QUES_8);
                jSplitPanel.setRightComponent(resultJPanel);
        });
        quesNineBtn.addActionListener((ActionEvent e) -> {
            playResultJPanel(CarProcessor.QUES_9);
            jSplitPanel.setRightComponent(resultJPanel);
        });
        quesTenBtn.addActionListener((ActionEvent e) -> {
            playResultJPanel(CarProcessor.QUES_10);
            jSplitPanel.setRightComponent(resultJPanel);
        });
        quesElevenBtn.addActionListener((ActionEvent e) -> {
            playResultJPanel(CarProcessor.QUES_11);
            jSplitPanel.setRightComponent(resultJPanel);
        });
    }

    private void playResultJPanel(int quesNum) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            if (quesNum == CarProcessor.QUES_1) {
                Car car = (Car) CarProcessor.filter(quesNum);
                stringBuffer.append("serial num: ").append("\r\n");
                if (car != null) {
                    stringBuffer.append(car.getSerial_num()).append("\r\n");
                }
            } else if (quesNum == CarProcessor.QUES_2) {
                int count = (Integer) CarProcessor.filter(quesNum);
                stringBuffer.append("available count: ").append(count).append("\r\n");
                stringBuffer.append("in-available count: ").append(CarProcessor.getCarList().size() - count).append("\r\n");
            } else if (quesNum == CarProcessor.QUES_3) {
                java.util.List<Car> carList = (java.util.List) CarProcessor.filter(quesNum, quesThreeInput.getText());
                stringBuffer.append("cars made in ").append(quesThreeInput.getText()).append(": \r\n");
                for (Car car : carList) {
                    stringBuffer.append(car.toString()).append("\r\n");
                }
            } else if (quesNum == CarProcessor.QUES_4) {
                java.util.List<Car> carList = (java.util.List) CarProcessor.filter(quesNum, quesFourInput.getText());
                stringBuffer.append("cars made in year ").append(quesFourInput.getText()).append(": \r\n");
                for (Car car : carList) {
                    stringBuffer.append(car.toString()).append("\r\n");
                }
            } else if (quesNum == CarProcessor.QUES_5) {
                Car car = (Car) CarProcessor.filter(quesNum, Integer.parseInt(quesFiveInputMin.getText()), Integer.parseInt(quesFiveInputMax.getText()));
                stringBuffer.append("car").append(": \r\n");
                stringBuffer.append(car.toString()).append("\r\n");
            } else if (quesNum == CarProcessor.QUES_6) {
                Car car = (Car) CarProcessor.filter(quesNum, Integer.parseInt(quesSixInput.getText()));
                stringBuffer.append("car with serial num ").append(quesSixInput.getText()).append(": \r\n");
                stringBuffer.append(car.toString()).append("\r\n");
            } else if (quesNum == CarProcessor.QUES_7) {
                java.util.List<Car> carList = (java.util.List) CarProcessor.filter(quesNum, quesSevenInput.getText());
                stringBuffer.append("cars with model ").append(quesSevenInput.getText()).append(": \r\n");
                for (Car car : carList) {
                    stringBuffer.append(car.toString()).append("\r\n");
                }
            } else if (quesNum == CarProcessor.QUES_8) {
                java.util.Set<String> strings = (java.util.Set) CarProcessor.filter(quesNum, quesEightInput.getText());
                stringBuffer.append("manufacturers of cars").append(quesEightInput.getText()).append(": \r\n");
                for (String string : strings) {
                    stringBuffer.append(string).append("\r\n");
                }
            } else if (quesNum == CarProcessor.QUES_9) {
                Long time = (Long) CarProcessor.filter(quesNum);
                stringBuffer.append("last time of catalog updated").append(": \r\n");
                stringBuffer.append(new Date(time)).append("\r\n");
            } else if (quesNum == CarProcessor.QUES_10) {
                java.util.List<Car> carList = (java.util.List) CarProcessor.filter(quesNum, quesTenInput.getText());
                stringBuffer.append("available cars in ").append(quesTenInput.getText()).append(": \r\n");
                for (Car car : carList) {
                    stringBuffer.append(car.toString()).append("\r\n");
                }
            } else if (quesNum == CarProcessor.QUES_11) {
                java.util.List<Car> carList = (java.util.List) CarProcessor.filter(quesNum);
                stringBuffer.append("cars with expired maintenance certificate").append(": \r\n");
                for (Car car : carList) {
                    stringBuffer.append(car.toString()).append("\r\n");
                }
            }
            resultArea.setText(stringBuffer.toString());
        } catch (Exception e) {
            CommonComponentUtil.alertError("error!");
        }
    }

    private JPanel initResultJPanel() {
        resultJPanel.setSize(500, 400);
        resultArea.setLineWrap(true);

        GroupLayout layout = new GroupLayout(resultJPanel);
        resultJPanel.setLayout(layout);

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGap(10);//添加间隔
        hGroup.addGroup(layout.createParallelGroup().addComponent(resultArea));
        layout.setHorizontalGroup(hGroup);

        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGap(20);
        vGroup.addGroup(layout.createParallelGroup().addComponent(resultArea, GroupLayout.Alignment.CENTER));
        //设置垂直组
        layout.setVerticalGroup(vGroup);

        resultJPanel.setVisible(true);
        return resultJPanel;
    }
}
