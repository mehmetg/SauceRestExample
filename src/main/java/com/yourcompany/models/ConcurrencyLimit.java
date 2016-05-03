package com.yourcompany.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by mehmetg on 4/7/16.
 */
public class ConcurrencyLimit  implements Serializable {
    @JsonProperty("mac")
    private int mac;

    @JsonProperty("scout")
    private int scout;

    @JsonProperty("overall")
    private int overall;

    @JsonProperty("real_device")
    private int realDevice;

    public int getMac() {
        return mac;
    }

    public void setMac(int mac) {
        this.mac = mac;
    }

    public int getScout() {
        return scout;
    }

    public void setScout(int scout) {
        this.scout = scout;
    }

    public int getOverall() {
        return overall;
    }

    public void setOverall(int overall) {
        this.overall = overall;
    }

    public int getRealDevice() {
        return realDevice;
    }

    public void setRealDevice(int realDevice) {
        this.realDevice = realDevice;
    }
}