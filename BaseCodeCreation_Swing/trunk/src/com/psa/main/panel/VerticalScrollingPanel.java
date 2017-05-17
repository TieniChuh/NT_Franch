/*
 * Creation : Dec 29, 2016
 */
package com.psa.main.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

public class VerticalScrollingPanel extends JPanel implements Runnable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Thread thread = null;

    private int currentHeight = this.getHeight();

    private int panelWidth = 0, panelHeight = 0;

    private List<String> textListTemp = null;
    private int printTimes = 0;

    public VerticalScrollingPanel(List<String> textList) {//
        super();
        textListTemp = textList;
        this.setFont(new Font("Calibri", Font.BOLD, 15));
        this.setForeground(Color.BLACK);
        this.setIgnoreRepaint(false);
        thread = new Thread(this);
        thread.start();
    }

    public void update(Graphics g) {
        paint(g);
    }

    /*
     * 绘制
     */
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.setColor(this.getBackground());
        g.fillRect(0, 0, panelWidth = this.getWidth(), panelHeight = this.getHeight());
        g.setColor(this.getForeground());
        g.setFont(this.getFont());
        for (int i = 0; i < textListTemp.size(); i++) {
            if (currentHeight < this.getHeight() - 20 * i) {
                String strTemp = textListTemp.get(i);
                g.drawString(strTemp, this.getWidth() / 2 - strTemp.length() * 3, currentHeight + 20 * i);
            }
        }
        System.out.println("X:" + currentHeight + "width:" + this.getWidth() + "**heigth:" + this.getHeight() + "####printTimes：" + printTimes
                + "##textListTemp.size():" + textListTemp.size());

    }

    public void run() {
        while (true) {
            currentHeight -= 1;
            if (currentHeight < -textListTemp.size() * 20) {
                currentHeight = panelHeight;
            }
            this.repaint();
            try {
                Thread.sleep(16);// 间隔绘制16毫秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}