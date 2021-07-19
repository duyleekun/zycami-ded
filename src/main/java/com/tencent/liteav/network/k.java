/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 */
package com.tencent.liteav.network;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.basic.c.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.network.k$1;
import com.tencent.liteav.network.k$2;
import com.tencent.liteav.network.k$a;

public class k {
    private final int a;
    private final int b;
    private String c;
    private String d;
    private int e;
    private String f;
    private Handler g;

    public k(Context context) {
        String string2;
        int n10;
        this.a = 5;
        this.b = n10 = 2;
        this.c = string2 = "";
        this.d = string2;
        this.e = 0;
        this.f = string2;
        if (context != null) {
            context = context.getMainLooper();
            super((Looper)context);
            this.g = string2;
        }
    }

    public static /* synthetic */ int a(k k10, int n10) {
        k10.e = n10;
        return n10;
    }

    public static /* synthetic */ long a(k k10) {
        return k10.e();
    }

    public static /* synthetic */ String a(k k10, String string2) {
        k10.c = string2;
        return string2;
    }

    private String a(String string2, String stringArray) {
        int n10;
        if (string2 != null && (n10 = string2.length()) != 0 && stringArray != null && (n10 = stringArray.length()) != 0) {
            string2 = string2.toLowerCase();
            String string3 = "[?&]";
            for (String string4 : stringArray.split(string3)) {
                String[] stringArray2;
                int n11;
                String string5 = "=";
                int n12 = string4.indexOf(string5);
                if (n12 == (n11 = -1) || (n12 = (stringArray2 = string4.split(string5 = "[=]")).length) != (n11 = 2)) continue;
                string5 = stringArray2[0];
                n11 = 1;
                String string6 = stringArray2[n11];
                if (string5 == null || (n12 = (int)((string5 = string5.toLowerCase()).equalsIgnoreCase(string2) ? 1 : 0)) == 0) continue;
                return string6;
            }
            return "";
        }
        return null;
    }

    private void a(String string2, String string3, String string4, String string5, int n10, k$a k$a) {
        k$2 k$2 = new k$2(this, "getRTMPAccUrl", string3, string5, string4, string2, n10, k$a);
        k$2.start();
    }

    public static /* synthetic */ boolean a(k k10, boolean bl2, String string2, String string3, String string4) {
        return k10.a(bl2, string2, string3, string4);
    }

    private boolean a(boolean bl2, String string2, String string3, String string4) {
        boolean bl3 = true;
        if (bl2) {
            if (string2 == null || (bl2 = string2.isEmpty()) || string3 == null || (bl2 = string3.isEmpty()) || string4 == null || (bl2 = string4.isEmpty())) {
                bl3 = false;
            }
            return bl3;
        }
        if (string2 == null || string3 == null || string4 == null) {
            bl3 = false;
        }
        return bl3;
    }

    public static /* synthetic */ Handler b(k k10) {
        return k10.g;
    }

    public static /* synthetic */ String b(k k10, String string2) {
        k10.d = string2;
        return string2;
    }

    public static /* synthetic */ String c(k k10, String string2) {
        k10.f = string2;
        return string2;
    }

    private long e() {
        return com.tencent.liteav.basic.c.c.a().a("Network", "AccRetryCountWithoutSecret");
    }

    public int a(String string2, int n10, k$a k$a) {
        boolean bl2;
        String string3;
        this.c = string3 = "";
        this.d = string3;
        this.e = 0;
        this.f = string3;
        string3 = "TXRTMPAccUrlFetcher";
        if (string2 != null && !(bl2 = string2.isEmpty())) {
            boolean bl3;
            String string4 = TXCCommonUtil.getStreamIDByStreamUrl(string2);
            if (string4 != null && !(bl3 = string4.isEmpty())) {
                k$1 k$1;
                string3 = this.a("bizid", string2);
                String string5 = this.a("txSecret", string2);
                Object object = "txTime";
                bl3 = this.a(true, string3, string2 = this.a((String)object, string2), string5);
                if (!bl3) {
                    return -3;
                }
                object = k$1;
                k$1 = new k$1(this, string4, string3, string5, string2, k$a);
                object = this;
                this.a(string4, string3, string5, string2, n10, k$1);
                return 0;
            }
            TXCLog.i(string3, "getAccerateStreamPlayUrl streamID is empty");
            return -2;
        }
        TXCLog.i(string3, "getAccerateStreamPlayUrl input playUrl is empty");
        return -1;
    }

    public String a() {
        return this.c;
    }

    public String b() {
        return this.d;
    }

    public int c() {
        return this.e;
    }

    public String d() {
        return this.f;
    }
}

