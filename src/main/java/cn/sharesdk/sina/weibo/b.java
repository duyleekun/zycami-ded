/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.sina.weibo;

import cn.sharesdk.sina.weibo.b$1;
import com.mob.MobCommunicator;
import com.mob.MobSDK;

public class b {
    private static volatile b a;
    private MobCommunicator b;
    private String c;

    public b() {
        String string2;
        this.c = string2 = MobSDK.getAppkey();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static b a() {
        Class<b> clazz = b.class;
        // MONITORENTER : clazz
        b b10 = a;
        if (b10 == null) {
            // MONITORENTER : clazz
            b10 = a;
            if (b10 == null) {
                a = b10 = new b();
            }
            // MONITOREXIT : clazz
        }
        // MONITOREXIT : clazz
        return a;
    }

    public static /* synthetic */ String a(b b10) {
        return b10.c;
    }

    public static /* synthetic */ long b(b b10) {
        return b10.c();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private MobCommunicator b() {
        synchronized (this) {
            MobCommunicator mobCommunicator = this.b;
            if (mobCommunicator != null) return this.b;
            int n10 = 1021;
            String string2 = "009cbd92ccef123be840deec0c6ed0547194c1e471d11b6f375e56038458fb18833e5bab2e1206b261495d7e2d1d9e5aa859e6d4b671a8ca5d78efede48e291a3f";
            String string3 = "1dfd1d615cb891ce9a76f42d036af7fce5f8b8efaa11b2f42590ecc4ea4cff28f5f6b0726aeb76254ab5b02a58c1d5b486c39d9da1a58fa6ba2f22196493b3a4cbc283dcf749bf63679ee24d185de70c8dfe05605886c9b53e9f569082eabdf98c4fb0dcf07eb9bb3e647903489ff0b5d933bd004af5be4a1022fdda41f347f1";
            this.b = mobCommunicator = new MobCommunicator(n10, string2, string3);
            return this.b;
        }
    }

    private long c() {
        return System.currentTimeMillis();
    }

    public static /* synthetic */ MobCommunicator c(b b10) {
        return b10.b();
    }

    public void a(int n10) {
        b$1 b$1 = new b$1(this, n10);
        b$1.start();
    }
}

