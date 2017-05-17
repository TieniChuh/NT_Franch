/*
 * Creation : Dec 29, 2016
 */
package com;

import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

import com.psa.main.panel.HorizontalScrollingPanel;

public class TempClass extends JFrame {

    public TempClass() {

        super("Test", GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration());
        HorizontalScrollingPanel label = new HorizontalScrollingPanel("123\n\t555");
        this.add(label);

        // TempClass.removeListener(this);

        this.setIgnoreRepaint(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 300);
        this.setVisible(true);
    }

    public static void main(String args[]) {

        new TempClass();
        // System.getProperties().list(System.out);
    }

}
