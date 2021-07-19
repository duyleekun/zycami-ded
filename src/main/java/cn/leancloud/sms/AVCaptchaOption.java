/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.sms;

import java.util.HashMap;
import java.util.Map;

public class AVCaptchaOption {
    private int height = 0;
    private int width = 0;

    public int getHeight() {
        return this.height;
    }

    public Map getRequestParam() {
        HashMap<String, String> hashMap = new HashMap<String, String>(2);
        String string2 = String.valueOf(this.height);
        hashMap.put("height", string2);
        string2 = String.valueOf(this.width);
        hashMap.put("width", string2);
        return hashMap;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int n10) {
        this.height = n10;
    }

    public void setWidth(int n10) {
        this.width = n10;
    }
}

