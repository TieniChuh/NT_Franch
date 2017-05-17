/*
 * Creation : Dec 29, 2016
 */
package com.psa.main.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class HorizontalScrollingPanel extends JPanel implements Runnable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String text = null;

    private Thread thread = null;

    private int current = 0;

    private int width = 0, height = 0;

    public HorizontalScrollingPanel(String text) {
        super();
        this.text = text;
        this.setFont(new Font("Calibri", Font.PLAIN, 20));
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
        g.fillRect(0, 0, width = this.getWidth(), height = this.getHeight());
        g.setColor(this.getForeground());
        g.setFont(this.getFont());

        g.drawString(text, current, height - 1);
        System.out.println("X:" + current + "**** Y:" + (height - 1) + "####" + this.getWidth() + "****" + this.getHeight());
    }

    public void run() {
        // current = this.getWidth();
        // while (true) {
        // current -= 1;
        // if (current < 0) {
        // current = width;
        // }
        // this.repaint();
        // try {
        // Thread.sleep(15);// 间隔绘制 毫秒
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }
        // }
    }

}