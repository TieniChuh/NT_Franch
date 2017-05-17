/*
 * Creation : Feb 28, 2017
 */
package keyPress.dto;

public class ConfigDto {

    private int keyQtime;
    private int keyWtime;
    private int keyEtime;
    private int keyRtime;
    private int keyTtime;

    public int getKeyQtime() {
        return keyQtime;
    }

    public void setKeyQtime(int keyQtime) {
        this.keyQtime = keyQtime;
    }

    public int getKeyWtime() {
        return keyWtime;
    }

    public void setKeyWtime(int keyWtime) {
        this.keyWtime = keyWtime;
    }

    public int getKeyEtime() {
        return keyEtime;
    }

    public void setKeyEtime(int keyEtime) {
        this.keyEtime = keyEtime;
    }

    public int getKeyRtime() {
        return keyRtime;
    }

    public void setKeyRtime(int keyRtime) {
        this.keyRtime = keyRtime;
    }

    public int getKeyTtime() {
        return keyTtime;
    }

    public void setKeyTtime(int keyTtime) {
        this.keyTtime = keyTtime;
    }

    public String toString() {
        return "keyQtime:" + keyQtime + " keyWtime:" + keyWtime + " keyEtime:" + keyEtime + " keyRtime:" + keyRtime + " keyTtime:" + keyTtime;
    }
}
