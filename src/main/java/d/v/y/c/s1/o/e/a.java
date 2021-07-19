/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.o.e;

import com.zhiyun.protocol.message.bl.wifi.WifiDevice;

public class a {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static byte a(int n10, WifiDevice wifiDevice, boolean bl2) {
        byte by2 = WifiDevice.toDeviceCode(wifiDevice);
        if (bl2) {
            n10 |= by2;
            return (byte)n10;
        }
        n10 |= by2;
        return (byte)n10;
    }

    public static byte[] b(byte by2, boolean bl2) {
        byte by3 = (byte)(by2 & 0xF0);
        by2 = (byte)(by2 & 0xF);
        int n10 = 2;
        byte[] byArray = new byte[n10];
        int n11 = 1;
        if (bl2) {
            byArray[0] = by3;
            byArray[n11] = by2;
        } else {
            byArray[0] = by2;
            byArray[n11] = by3;
        }
        return byArray;
    }
}

