/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3sample;

import assignment3sample.procssor.CreateJPanelProcessor;
import assignment3sample.procssor.SearchJPanelProcessor;
import assignment3sample.procssor.UpdateJPanelProcessor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author tusiyu
 */
@SuppressWarnings("all")
public class MainFrame_2 extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    private JSplitPane jSplitPanel;

    private CreateJPanelProcessor createJPanelProcessor = new CreateJPanelProcessor();
    private SearchJPanelProcessor searchJPanelProcessor = new SearchJPanelProcessor();
    private UpdateJPanelProcessor updateJPanelProcessor = new UpdateJPanelProcessor();
    private Button createBtn;
    private Button searchBtn;
    private Button updateBtn;

    public MainFrame_2() {
        initComponents();
    }

    private void initComponents() {

        JPanel rightJPanel = initRightJPanel();
        jSplitPanel = new JSplitPane();
        jSplitPanel.setRightComponent(rightJPanel);
        jSplitPanel.setLeftComponent(initLeftJPanel(rightJPanel));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jSplitPanel)
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jSplitPanel)
                                .addContainerGap())
        );

        pack();
    }

    private JPanel initLeftJPanel(JPanel rightJPanel) {
        JPanel leftJPanel = new JPanel();
        createBtn = new Button("create");
        searchBtn = new Button("search");
        updateBtn = new Button("update");

        createBtn.addActionListener((ActionEvent e)->{
                rightJPanel.setVisible(false);
                JPanel jPanel = createJPanelProcessor.playCreateJPanel();
                jSplitPanel.setRightComponent(jPanel);
                return;
        });

        searchBtn.addActionListener((ActionEvent e)->{
                rightJPanel.setVisible(false);
                JPanel jPanel = searchJPanelProcessor.playSearchQuestionJPanel(jSplitPanel);
                jSplitPanel.setRightComponent(jPanel);
                return;
        });

        updateBtn.addActionListener((ActionEvent e)-> {
                rightJPanel.setVisible(false);
                JPanel jPanel = updateJPanelProcessor.playSearchJPanel(jSplitPanel);
                jSplitPanel.setRightComponent(jPanel);
                return;
        });

        GroupLayout jPanel2Layout = new GroupLayout(leftJPanel);
        jPanel2Layout.setAutoCreateGaps(true);
        leftJPanel.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(100)
                        .addComponent(createBtn)
                        .addComponent(searchBtn)
                        .addComponent(updateBtn)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createSequentialGroup()
                        .addGap(300)
                        .addComponent(createBtn)
                        .addComponent(searchBtn)
                        .addComponent(updateBtn)
        );
        return leftJPanel;
    }

    private JPanel initRightJPanel() {
        JPanel rightJPanel = new JPanel();
        GridLayout gridLayout = new GridLayout(5, 1);
        rightJPanel.setLayout(gridLayout);

        rightJPanel.add(new JLabel());
        JLabel title = new JLabel("                    Welcome to ASSIGNMENT 3                    ");
        title.setFont(new Font("Tahoma", Font.PLAIN, 20));
        rightJPanel.add(title, BorderLayout.CENTER);
        return rightJPanel;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame_2().setVisible(true);
            }
        });
    }

}
