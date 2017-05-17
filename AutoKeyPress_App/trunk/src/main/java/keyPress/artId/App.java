package keyPress.artId;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

import keyPress.dto.ConfigDto;
import keyPress.utils.CommonUtils;

/**
 * Hello world!
 */
public class App {

    static class MyTask extends java.util.TimerTask {
        private int keyEvent;

        public int getKeyEvent() {
            return keyEvent;
        }

        public void setKeyEvent(int keyEvent) {
            this.keyEvent = keyEvent;
        }

        public MyTask(int keyEvent) {
            this.keyEvent = keyEvent;
        }

        @Override
        public void run() {
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");

            System.out.println(formatter.format(new Date()));
            System.out.println("按下:" + keyEvent);
            Robot robot;
            try {
                robot = new Robot();
                robot.keyPress(keyEvent);
                robot.keyRelease(keyEvent);
            } catch (AWTException e) {
                e.printStackTrace();
            }

        }
    }

    public App() {
        String configFile = "config.ini";
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");

        ConfigDto configDto = CommonUtils.importDefaultSetting(configFile);
        System.out.println(configDto.toString());
        System.out.println("START:" + formatter.format(new Date()));
        Timer timer = new Timer();
        if (0 != configDto.getKeyQtime())
            timer.schedule(new MyTask(KeyEvent.VK_Q), 1000, configDto.getKeyQtime() * 1000);
        if (0 != configDto.getKeyWtime())
            timer.schedule(new MyTask(KeyEvent.VK_W), 1000, configDto.getKeyWtime() * 1000);
        if (0 != configDto.getKeyEtime())
            timer.schedule(new MyTask(KeyEvent.VK_E), 1000, configDto.getKeyEtime() * 1000);
        if (0 != configDto.getKeyRtime())
            timer.schedule(new MyTask(KeyEvent.VK_R), 1000, configDto.getKeyRtime() * 1000);
        if (0 != configDto.getKeyTtime())
            timer.schedule(new MyTask(KeyEvent.VK_T), 1000, configDto.getKeyTtime() * 1000);

        while (true) {
            try {
                int ch = System.in.read();
                if (ch - 'c' == 0) {
                    timer.cancel();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        App app = new App();
    }
}
