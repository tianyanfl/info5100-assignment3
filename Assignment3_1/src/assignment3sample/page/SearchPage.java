package assignment3sample.page;

import assignment3sample.Business.Car;
import assignment3sample.Business.CarInfoProcess;
import assignment3sample.Interface.MainFrame_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Endstart
 * Date: 2019-10-05
 * Time: 21:37
 */
public class SearchPage {

    private JPanel questionJPanel ;
    private JPanel resultJPanel ;
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

    public SearchPage() {
        questionJPanel = new JPanel();
        resultJPanel = new JPanel();
        resultArea = new JTextArea();
        initResultJPanel();
    }


    public JPanel playSearchQuestionJPanel(JSplitPane jSplitPanel) {

        questionJPanel.setSize(500, 400);

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

        // 为指定的 Container 创建 GroupLayout
        GroupLayout layout = new GroupLayout(questionJPanel);
//        layout.setAutoCreateGaps(true); // 自动创建组件之间的间隙
//        layout.setAutoCreateContainerGaps(false); // 自动创建容器与触到容器边框的组件之间的间隙
        questionJPanel.setLayout(layout);

        //创建GroupLayout的水平连续组，越先加入的ParallelGroup，优先级级别越高。
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();


        // hGroup.addGap(5);//添加间隔
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
        vGroup.addGroup(layout.createParallelGroup().addComponent(quesOneLabel,GroupLayout.Alignment.CENTER).addComponent(quesOneInput).addComponent(quesOneBtn));
        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(quesTwoLabel,GroupLayout.Alignment.CENTER).addComponent(quesTwoInput).addComponent(quesTwoBtn));
        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(quesThreeLabel,GroupLayout.Alignment.CENTER).addComponent(quesThreeInput).addComponent(quesThreeBtn));
        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(quesFourLabel,GroupLayout.Alignment.CENTER).addComponent(quesFourInput).addComponent(quesFourBtn));
        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(quesFiveLabel,GroupLayout.Alignment.CENTER).addGroup(layout.createParallelGroup().addComponent(quesFiveInputMin).addComponent(quesFiveInputMax)).addComponent(quesFiveBtn));

        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(quesSixLabel,GroupLayout.Alignment.CENTER).addComponent(quesSixInput).addComponent(quesSixBtn));

        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(quesSevenLabel,GroupLayout.Alignment.CENTER).addComponent(quesSevenInput).addComponent(quesSevenBtn));

        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(quesEightLabel,GroupLayout.Alignment.CENTER).addComponent(quesEightInput).addComponent(quesEightBtn));

        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(quesNineLabel,GroupLayout.Alignment.CENTER).addComponent(quesNineInput).addComponent(quesNineBtn));

        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(quesTenLabel,GroupLayout.Alignment.CENTER).addComponent(quesTenInput).addComponent(quesTenBtn));

        vGroup.addGap(5);
        vGroup.addGroup(layout.createParallelGroup().addComponent(quesElevenLabel,GroupLayout.Alignment.CENTER).addComponent(quesElevenInput).addComponent(quesElevenBtn));

        vGroup.addGap(5);
        // 设置垂直方向的指定组件的长度一致
        layout.linkSize(SwingConstants.VERTICAL, new Component[]{quesTwoInput, quesThreeInput, quesFourInput, quesFiveInputMin, quesFiveInputMax, quesSixInput, quesSevenInput, quesTenInput});
        //设置垂直组
        layout.setVerticalGroup(vGroup);

        questionJPanel.setVisible(true);
        return questionJPanel;
    }

    private void initBtnAction(JSplitPane jSplitPanel) {
        quesOneBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playResultJPanel(CarInfoProcess.QUES_1);
                jSplitPanel.setRightComponent(resultJPanel);
            }
        });
        quesTwoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playResultJPanel(CarInfoProcess.QUES_2);
                jSplitPanel.setRightComponent(resultJPanel);
            }
        });
        quesThreeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playResultJPanel(CarInfoProcess.QUES_3);
                jSplitPanel.setRightComponent(resultJPanel);
            }
        });
        quesFourBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playResultJPanel(CarInfoProcess.QUES_4);
                jSplitPanel.setRightComponent(resultJPanel);
            }
        });
        quesFiveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playResultJPanel(CarInfoProcess.QUES_5);
                jSplitPanel.setRightComponent(resultJPanel);
            }
        });
        quesSixBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playResultJPanel(CarInfoProcess.QUES_6);
                jSplitPanel.setRightComponent(resultJPanel);
            }
        });
        quesSevenBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playResultJPanel(CarInfoProcess.QUES_7);
                jSplitPanel.setRightComponent(resultJPanel);
            }
        });
        quesEightBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playResultJPanel(CarInfoProcess.QUES_8);
                jSplitPanel.setRightComponent(resultJPanel);
            }
        });
        quesNineBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playResultJPanel(CarInfoProcess.QUES_9);
                jSplitPanel.setRightComponent(resultJPanel);
            }
        });
        quesTenBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playResultJPanel(CarInfoProcess.QUES_10);
                jSplitPanel.setRightComponent(resultJPanel);
            }
        });
        quesElevenBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playResultJPanel(CarInfoProcess.QUES_11);
                jSplitPanel.setRightComponent(resultJPanel);
            }
        });
    }

    private void playResultJPanel(int quesNum) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            if (quesNum == CarInfoProcess.QUES_1) {
                Car car = (Car) CarInfoProcess.filter(quesNum);
                stringBuffer.append("serial num: ").append("\r\n");
                if (car != null) {
                    stringBuffer.append(car.getSerial_num()).append("\r\n");
                }
            } else if (quesNum == CarInfoProcess.QUES_2) {
                int count = (Integer) CarInfoProcess.filter(quesNum);
                stringBuffer.append("available count: ").append(count).append("\r\n");
                stringBuffer.append("in-available count: ").append(CarInfoProcess.getCarList().size() - count).append("\r\n");
            } else if (quesNum == CarInfoProcess.QUES_3) {
                java.util.List<Car> carList = (java.util.List) CarInfoProcess.filter(quesNum, quesThreeInput.getText());
                stringBuffer.append("cars made in ").append(quesThreeInput.getText()).append(": \r\n");
                for (Car car : carList) {
                    stringBuffer.append(car.toString()).append("\r\n");
                }
            } else if (quesNum == CarInfoProcess.QUES_4) {
                java.util.List<Car> carList = (java.util.List) CarInfoProcess.filter(quesNum, quesFourInput.getText());
                stringBuffer.append("cars made in year ").append(quesFourInput.getText()).append(": \r\n");
                for (Car car : carList) {
                    stringBuffer.append(car.toString()).append("\r\n");
                }
            } else if (quesNum == CarInfoProcess.QUES_5) {
                Car car = (Car) CarInfoProcess.filter(quesNum, Integer.parseInt(quesFiveInputMin.getText()), Integer.parseInt(quesFiveInputMax.getText()));
                stringBuffer.append("car").append(": \r\n");
                stringBuffer.append(car.toString()).append("\r\n");
            } else if (quesNum == CarInfoProcess.QUES_6) {
                Car car = (Car) CarInfoProcess.filter(quesNum, Integer.parseInt(quesSixInput.getText()));
                stringBuffer.append("car with serial num ").append(quesSixInput.getText()).append(": \r\n");
                stringBuffer.append(car.toString()).append("\r\n");
            } else if (quesNum == CarInfoProcess.QUES_7) {
                java.util.List<Car> carList = (java.util.List) CarInfoProcess.filter(quesNum, quesSevenInput.getText());
                stringBuffer.append("cars with model ").append(quesSevenInput.getText()).append(": \r\n");
                for (Car car : carList) {
                    stringBuffer.append(car.toString()).append("\r\n");
                }
            } else if (quesNum == CarInfoProcess.QUES_8) {
                java.util.Set<String> strings = (java.util.Set) CarInfoProcess.filter(quesNum, quesEightInput.getText());
                stringBuffer.append("manufacturers of cars").append(quesEightInput.getText()).append(": \r\n");
                for (String string : strings) {
                    stringBuffer.append(string).append("\r\n");
                }
            } else if (quesNum == CarInfoProcess.QUES_9) {
                Long time = (Long) CarInfoProcess.filter(quesNum);
                stringBuffer.append("last time of catalog updated").append(": \r\n");
                stringBuffer.append(new Date(time)).append("\r\n");
            } else if (quesNum == CarInfoProcess.QUES_10) {
                java.util.List<Car> carList = (java.util.List) CarInfoProcess.filter(quesNum, quesTenInput.getText());
                stringBuffer.append("available cars in ").append(quesTenInput.getText()).append(": \r\n");
                for (Car car : carList) {
                    stringBuffer.append(car.toString()).append("\r\n");
                }
            } else if (quesNum == CarInfoProcess.QUES_11) {
                java.util.List<Car> carList = (java.util.List) CarInfoProcess.filter(quesNum);
                stringBuffer.append("cars with expired maintenance certificate").append(": \r\n");
                for (Car car : carList) {
                    stringBuffer.append(car.toString()).append("\r\n");
                }
            }
            resultArea.setText(stringBuffer.toString());
        } catch (Exception e) {
            MainFrame_1.alertError("error!");
        }
    }


    private JPanel initResultJPanel() {
        resultJPanel.setSize(500, 400);
        resultArea.setLineWrap(true);

        GroupLayout layout = new GroupLayout(resultJPanel);
        resultJPanel.setLayout(layout);

        //创建GroupLayout的水平连续组，越先加入的ParallelGroup，优先级级别越高。
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGap(5);//添加间隔
        hGroup.addGroup(layout.createParallelGroup().addComponent(resultArea));
        layout.setHorizontalGroup(hGroup);

        //创建GroupLayout的垂直连续组，越先加入的ParallelGroup，优先级级别越高。
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGap(10);
        vGroup.addGroup(layout.createParallelGroup().addComponent(resultArea,GroupLayout.Alignment.CENTER));

        vGroup.addGap(10);

        // 设置垂直方向的指定组件的长度一致
//        layout.linkSize(SwingConstants.VERTICAL, new Component[]{searchLable, searchField});

        //设置垂直组
        layout.setVerticalGroup(vGroup);

        resultJPanel.setVisible(true);
        return resultJPanel;
    }
}
