/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.zhiyun.zysocket.util;

import android.text.TextUtils;
import com.zhiyun.zysocket.util.SocketUtil$SocketType;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.SortedSet;
import m.a.a;

public class SocketUtil {
    public static final int a = 7030;
    public static final int b = 65535;
    private static final Random c;

    static {
        Random random;
        long l10 = System.nanoTime();
        c = random = new Random(l10);
    }

    public static /* synthetic */ Random a() {
        return c;
    }

    public static int b(int n10, int n11, String string2) {
        return SocketUtil$SocketType.TCP.findAvailablePort(n10, n11, string2);
    }

    public static int c(int n10, String string2) {
        return SocketUtil.b(n10, (char)-1, string2);
    }

    public static int d(String string2) {
        return SocketUtil.c(7030, string2);
    }

    public static SortedSet e(int n10, int n11, int n12, String string2) {
        return SocketUtil$SocketType.TCP.findAvailablePorts(n10, n11, n12, string2);
    }

    public static SortedSet f(int n10, String string2) {
        return SocketUtil.e(n10, 7030, (char)-1, string2);
    }

    public static int g(int n10, int n11, String string2) {
        return SocketUtil$SocketType.UDP.findAvailablePort(n10, n11, string2);
    }

    public static int h(int n10, String string2) {
        return SocketUtil.g(n10, (char)-1, string2);
    }

    public static int i(String string2) {
        return SocketUtil.h(7030, string2);
    }

    public static SortedSet j(int n10, int n11, int n12, String string2) {
        return SocketUtil$SocketType.UDP.findAvailablePorts(n10, n11, n12, string2);
    }

    public static SortedSet k(int n10, String string2) {
        return SocketUtil.j(n10, 7030, (char)-1, string2);
    }

    /*
     * Unable to fully structure code
     */
    public static List l() {
        var0 = new ArrayList<Object>();
        try {
            var1_1 = NetworkInterface.getNetworkInterfaces();
        }
lbl37:
        // 13 sources

        catch (SocketException var1_2) {
            var1_2.printStackTrace();
        }
        block14: while (true) {
            var2_3 = var1_1.hasMoreElements();
            if (!var2_3) break;
            var3_4 = var1_1.nextElement();
            ** try [egrp 3[TRYBLOCK] [3 : 30->34)] { 
lbl12:
            // 2 sources

            var4_5 = var3_4.getName();
            var5_6 = "wlan";
            var6_7 = var4_5.contains(var5_6);
            if (!var6_7) continue;
            var3_4 = var3_4.getInetAddresses();
            while (true) {
                var6_7 = var3_4.hasMoreElements();
                if (var6_7) ** break;
                continue block14;
                var4_5 = var3_4.nextElement();
                var4_5 = (InetAddress)var4_5;
                ** try [egrp 10[TRYBLOCK] [10 : 92->97)] { 
lbl29:
                // 1 sources

                var7_8 = var4_5.isLoopbackAddress();
                if (var7_8 || !(var7_8 = var4_5 instanceof Inet4Address)) continue;
                var4_5 = ((InetAddress)var4_5).getHostAddress();
                var0.add(var4_5);
                continue;
                break;
            }
            break;
        }
        return var0;
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static InterfaceAddress m(String var0) {
        try {
            var1_2 = NetworkInterface.getNetworkInterfaces();
        }
lbl42:
        // 15 sources

        catch (SocketException var0_1) {
            var1_2 = new Object[]{};
            var3_4 = "find equal address error";
            m.a.a.k(var0_1, (String)var3_4, var1_2);
        }
        block16: while (true) {
            var2_3 = var1_2.hasMoreElements();
            if (!var2_3) return null;
            var3_4 = var1_2.nextElement();
            var3_4 = (NetworkInterface)var3_4;
            var4_5 = var3_4.isLoopback();
            if (var4_5) continue;
            var3_4 = var3_4.getInterfaceAddresses();
            var3_4 = var3_4.iterator();
            while (true) {
                var4_5 = var3_4.hasNext();
                if (var4_5) ** break;
                continue block16;
                var5_6 = var3_4.next();
                var5_6 = (InterfaceAddress)var5_6;
                ** try [egrp 10[TRYBLOCK] [10 : 78->83)] { 
lbl28:
                // 1 sources

                var6_7 = var5_6.getBroadcast();
                var7_8 = var6_7 instanceof Inet4Address;
                if (!var7_8) continue;
                var6_7 = var5_6.getAddress();
                var6_7 = var6_7.getHostAddress();
                var8_9 = TextUtils.isEmpty((CharSequence)var6_7);
                if (var8_9) continue;
                var7_8 = var6_7.equals(var0);
                if (var7_8) return var5_6;
                continue;
                break;
            }
            break;
        }
        return null;
    }
}

