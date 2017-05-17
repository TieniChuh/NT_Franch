/*
 * Creation : Nov 7, 2016
 */
package com.psa.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.apache.commons.lang3.StringUtils;

import com.psa.dto.SwingInputDto;
import com.psa.main.label.CurrentStatusLabel;
import com.psa.main.panel.HorizontalScrollingPanel;
import com.psa.main.panel.VerticalScrollingPanel;
import com.psa.service.ICreateJavaBeanService;
import com.psa.service.impl.CreateMySqlJavaBeanService;
import com.psa.utils.CommonUtils;

/**
 * lblNewLabel_4 * * * * * * * * * * * * * * * * * * * * * * * * * * * * txtLocalhost textField textField_1 txtComyourcom textField_3 textField_4
 * txtRoot checkBox * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * 
 * @author E466414
 */
public class BaseCodeCreation extends JFrame {
    private static final long serialVersionUID = 1L;
    Properties propertyFile = new Properties();
    String configFile = "config.ini";
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private CurrentStatusLabel labelInformation = new CurrentStatusLabel();
    private JTextField strIPValue;
    private JTextField strDataBaseValue;
    private JTextField strTableNameValue;
    private JTextField strPackageNameValue;
    private JTextField strOutputPathValue;
    private JTextField strPasswordValue;
    private JTextField strUserNameValue;
    private JCheckBox checkBox;

    // size
    int windowWidth, windowHeight;
    int labelWidth = 80;
    int labelHeigth = 15;
    int labelTextWidth = 150;
    int labelTextHeigth = 20;
    int labelCommentWidth = 180;
    int labelCommentHeigth = 15;
    int checkBoxWidth = 180;
    int checkBoxHeigth = 25;

    SwingInputDto swingInputDto;

    public BaseCodeCreation() {
        windowWidth = this.getWidth();
        windowHeight = this.getHeight();
        System.out.println("windowWidth:" + windowWidth + "**windowHeight:" + windowHeight);
        setResizable(false);

        setTitle("DataBase_To_JavaBean v1.0");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setSize(484, 270);
        panel.setLayout(null);

        // 1st line
        JLabel labelIP = new JLabel("IP:");
        labelIP.setBounds(50, 13, labelWidth, labelHeigth);
        panel.add(labelIP);

        strIPValue = new JTextField();
        strIPValue.setText("localhost");
        strIPValue.setBounds(146, 10, labelTextWidth, labelTextHeigth);
        panel.add(strIPValue);
        strIPValue.setColumns(10);
        // 2nd line
        JLabel labelDataBase = new JLabel("DataBase:");
        labelDataBase.setBounds(50, 42, labelWidth, labelHeigth);
        panel.add(labelDataBase);

        strDataBaseValue = new JTextField();
        strDataBaseValue.setBounds(146, 39, labelTextWidth, labelTextHeigth);
        panel.add(strDataBaseValue);
        strDataBaseValue.setColumns(10);

        JLabel labelDataBaseComment = new JLabel("* DataBase Name");
        labelDataBaseComment.setForeground(Color.RED);
        labelDataBaseComment.setBounds(303, 42, labelCommentWidth, labelCommentHeigth);
        panel.add(labelDataBaseComment);
        // 3rd line
        JLabel labelUserName = new JLabel("UserName:");
        labelUserName.setBounds(50, 69, labelWidth, labelHeigth);
        panel.add(labelUserName);

        strUserNameValue = new JTextField();
        strUserNameValue.setText("root");
        strUserNameValue.setBounds(145, 66, labelTextWidth, labelTextHeigth);
        panel.add(strUserNameValue);
        strUserNameValue.setColumns(10);
        // 4th line
        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setBounds(50, 96, labelWidth, labelHeigth);
        panel.add(labelPassword);

        strPasswordValue = new JTextField();
        strPasswordValue.setText("123456");
        strPasswordValue.setBounds(145, 93, labelTextWidth, labelTextHeigth);
        panel.add(strPasswordValue);
        strPasswordValue.setColumns(10);
        // 5th line
        JLabel labelTableName = new JLabel("Table Name:");
        labelTableName.setBounds(50, 127, labelWidth, labelHeigth);
        panel.add(labelTableName);

        strTableNameValue = new JTextField();
        strTableNameValue.setBounds(146, 124, labelTextWidth, labelTextHeigth);
        panel.add(strTableNameValue);
        strTableNameValue.setColumns(10);

        JLabel labelTableNameComment = new JLabel("can be null");
        labelTableNameComment.setBounds(303, 127, labelCommentWidth, labelCommentHeigth);
        panel.add(labelTableNameComment);

        // 6th line
        JLabel labelPackageName = new JLabel("Package Name:");
        labelPackageName.setBounds(50, 156, labelWidth, labelHeigth);
        panel.add(labelPackageName);

        strPackageNameValue = new JTextField();
        strPackageNameValue.setText("com.psa.yourProjectName.db");
        strPackageNameValue.setBounds(146, 155, labelTextWidth, labelTextHeigth);
        panel.add(strPackageNameValue);
        strPackageNameValue.setColumns(10);

        JLabel labelPackageNameComment = new JLabel("* package structure");
        labelPackageNameComment.setForeground(Color.RED);
        labelPackageNameComment.setBounds(303, 158, labelCommentWidth, labelCommentHeigth);
        panel.add(labelPackageNameComment);
        // 7th line
        JLabel labelOutputPath = new JLabel("Output Path：");
        labelOutputPath.setBounds(50, 190, labelWidth, labelHeigth);
        panel.add(labelOutputPath);

        strOutputPathValue = new JTextField();
        strOutputPathValue.setBounds(146, 186, labelTextWidth, labelTextHeigth);
        panel.add(strOutputPathValue);
        strOutputPathValue.setColumns(10);
        // 8 th line
        checkBox = new JCheckBox("create package structure path");
        checkBox.setSelected(true);
        checkBox.setBounds(145, 213, checkBoxWidth, checkBoxHeigth);
        panel.add(checkBox);

        // config SwingInputDto Begin
        swingInputDto = new SwingInputDto();
        swingInputDto.setLabelInformation(labelInformation);
        swingInputDto.setStrIPValue(strIPValue);
        swingInputDto.setStrDataBaseValue(strDataBaseValue);
        swingInputDto.setStrTableNameValue(strTableNameValue);
        swingInputDto.setStrPackageNameValue(strPackageNameValue);
        swingInputDto.setStrOutputPathValue(strOutputPathValue);
        swingInputDto.setStrPasswordValue(strPasswordValue);
        swingInputDto.setStrUserNameValue(strUserNameValue);
        swingInputDto.setCheckBox(checkBox);
        // config SwingInputDto End

        // 9 th line
        JButton buttonCreate = new JButton("Create");
        buttonCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // ToDo add validate Oracle or MySql
                ICreateJavaBeanService createService = new CreateMySqlJavaBeanService();
                if (createService.validateInputParameters(swingInputDto)) {

                    createService.prepareCreation(swingInputDto);

                    createService.createModelCode(swingInputDto);

                    createService.createDaoCode(swingInputDto);

                    createService.createServiceCode(swingInputDto);

                    swingInputDto.getLabelInformation().setText("");
                }
                System.out.println("####" + swingInputDto.getLabelInformation().getText());
                if (StringUtils.equals("", swingInputDto.getLabelInformation().getText())) {
                    // System.exit(0);
                }
            }
        });
        buttonCreate.setBounds(145, 242, 93, 23);
        panel.add(buttonCreate);

        panel.setBorder(BorderFactory.createLineBorder(Color.red));// 设置面板边框颜色

        List<String> verticalTextList = new ArrayList();
        verticalTextList.add("##Vertical##");
        verticalTextList.add("sleni clek");
        verticalTextList.add("line 1 sleni clek");
        verticalTextList.add("line 2 sleni clek");
        verticalTextList.add("line 3 sleni clek");
        verticalTextList.add("line 4 sleni clek");
        verticalTextList.add("line 5 sleni clek");
        verticalTextList.add("line 6 sleni clek");
        verticalTextList.add("line 7 sleni clek");
        verticalTextList.add("line 8 sleni clek");
        verticalTextList.add("line 9 sleni clek");
        verticalTextList.add("line 0 sleni clek");
        verticalTextList.add("line 11 sleni clek");

        VerticalScrollingPanel verticalScrollingLabel = new VerticalScrollingPanel(verticalTextList);
        verticalScrollingLabel.setBorder(BorderFactory.createLineBorder(Color.green));// 设置面板边框颜色

        HorizontalScrollingPanel hScrollingPanel = new HorizontalScrollingPanel("123\n\t555");
        hScrollingPanel.setBorder(BorderFactory.createLineBorder(Color.blue));// 设置面板边框颜色
        JScrollPane jsPanel = new JScrollPane();
        labelInformation.setText("This is start");
        labelInformation.setNewText("setNewText");
        labelInformation.setForeground(Color.RED);
        labelInformation.setBounds(2, 264, 449, 22);
        jsPanel.setForeground(Color.DARK_GRAY);
        jsPanel.setBounds(1, 265, 449, 33);
        jsPanel.setViewportView(labelInformation);

        panel.add(jsPanel);

        // GridBagConstraints s = new GridBagConstraints();// 定义一个GridBagConstraints，
        // // 是用来控制添加进的组件的显示位置
        // s.fill = GridBagConstraints.BOTH;
        // s.gridwidth = 1;// 该方法是设置组件水平所占用的格子数，如果为0，就说明该组件是该行的最后一个
        // s.weightx = 1;// 该方法设置组件水平的拉伸幅度，如果为0就说明不拉伸，不为0就随着窗口增大进行拉伸，0到1之间
        // s.weighty = 1;// 该方法设置组件垂直的拉伸幅度，如果为0就说明不拉伸，不为0就随着窗口增大进行拉伸，0到1之间
        // layout.setConstraints(panel, s);

        Dimension dimensionPanel = new Dimension(450, 300);
        panel.setPreferredSize(dimensionPanel);
        panel.setMinimumSize(dimensionPanel);
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;

        add(panel, gbc);
        // gbc.gridx++;
        // Dimension dimensionVertical = new Dimension(150, 300);
        // verticalScrollingLabel.setPreferredSize(dimensionVertical);
        // verticalScrollingLabel.setMinimumSize(dimensionVertical);
        // add(verticalScrollingLabel, gbc);
        // gbc.gridwidth = 2;
        // gbc.gridx = 0;
        // gbc.gridy = 1;
        // Dimension dimensionHorizontal = new Dimension(600, 30);
        // hScrollingPanel.setPreferredSize(dimensionHorizontal);
        // hScrollingPanel.setMinimumSize(dimensionHorizontal);
        // add(hScrollingPanel, gbc);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                CommonUtils.exportUserSetting(propertyFile, configFile, swingInputDto);
                System.exit(0);
            }

        });

        CommonUtils.importDefaultSetting(propertyFile, configFile, swingInputDto);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        } catch (InstantiationException e) {

            e.printStackTrace();
        } catch (IllegalAccessException e) {

            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {

            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BaseCodeCreation frame = new BaseCodeCreation();
                    frame.setSize(603, 380);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    frame.setResizable(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
