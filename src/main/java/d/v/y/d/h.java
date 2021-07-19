/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.d;

import com.zhiyun.protocol.constants.Model;
import com.zhiyun.protocol.message.bl.other.UpgradeLink;
import d.v.y.d.h$a;

public class h {
    public static int a(int n10) {
        return n10 >>> 8 & 0xF;
    }

    public static int b(Model model) {
        int[] nArray = h$a.a;
        int n10 = model.ordinal();
        n10 = nArray[n10];
        switch (n10) {
            default: {
                return 1;
            }
            case 18: {
                return 4;
            }
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: {
                return 3;
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
        }
        return 2;
    }

    public static int c(int n10) {
        return n10 >>> 8 & 0xF0;
    }

    public static int d(int n10) {
        return n10 & 0xFF;
    }

    public static int e(int n10) {
        return n10 >> 8;
    }

    public static UpgradeLink f(int n10) {
        n10 = (byte)(n10 & 0xFF);
        int n11 = 1;
        if ((n10 &= n11) == n11) {
            return UpgradeLink.BLE;
        }
        return UpgradeLink.WIFI;
    }

    public static String g(Model model) {
        int[] nArray = h$a.a;
        int n10 = model.ordinal();
        int n11 = 9;
        if ((n10 = nArray[n10]) != n11) {
            n11 = 15;
            if (n10 != n11) {
                return "";
            }
            return "udp://192.168.2.1:6000";
        }
        return "http://192.168.2.1:80/vlc.sdp";
    }

    public static int h(int n10, int n11, int n12) {
        n10 = n10 >> 4 << 12;
        n11 = (n11 & 0xF) << 8;
        return n10 | n11 | n12;
    }
}

