/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 *  android.text.TextUtils
 */
package com.tencent.liteav;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.j$1;
import com.tencent.liteav.j$a;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class j {
    private String a;
    private String b;
    private int c;
    private String d;
    private String e;
    private long f;

    public j() {
        String string2;
        this.a = string2 = "";
        this.b = string2;
        this.c = 0;
        this.d = string2;
        this.e = string2;
        this.f = 0L;
    }

    public static /* synthetic */ int a(j j10, int n10) {
        j10.c = n10;
        return n10;
    }

    public static /* synthetic */ long a(j j10, long l10) {
        j10.f = l10;
        return l10;
    }

    public static /* synthetic */ String a(j j10) {
        return j10.e;
    }

    public static /* synthetic */ String a(j j10, String string2) {
        j10.b = string2;
        return string2;
    }

    private String a(String string2) {
        String string3 = "#EXT-TX-TS-START-TIME";
        int n10 = string2.contains(string3);
        if (n10 != 0 && (n10 = string2.indexOf(string3 = "#EXT-TX-TS-START-TIME:") + 22) > 0 && (n10 = (string2 = string2.substring(n10)).indexOf(string3 = "#")) > 0) {
            return string2.substring(0, n10).replaceAll("\r\n", "");
        }
        return null;
    }

    public static /* synthetic */ int b(j j10) {
        return j10.c;
    }

    public static /* synthetic */ String b(j j10, String string2) {
        j10.a = string2;
        return string2;
    }

    public static /* synthetic */ String c(j j10) {
        return j10.a;
    }

    public static /* synthetic */ String c(j j10, String string2) {
        j10.e = string2;
        return string2;
    }

    public static /* synthetic */ String d(j j10) {
        return j10.b;
    }

    public static /* synthetic */ String d(j j10, String string2) {
        return j10.a(string2);
    }

    public static /* synthetic */ String e(j j10) {
        return j10.d;
    }

    public static /* synthetic */ long f(j j10) {
        return j10.f;
    }

    public int a(String string2, String string3, int n10, j$a j$a) {
        boolean bl2;
        if (string2 != null && !(bl2 = string2.isEmpty())) {
            j$1 j$1;
            Object object = TXCCommonUtil.getAppID();
            this.d = object;
            bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2) {
                return -2;
            }
            object = j$1;
            j$1 = new j$1(this, n10, string3, string2, j$a);
            AsyncTask.execute((Runnable)j$1);
            return 0;
        }
        return -1;
    }

    public long a() {
        long l10 = System.currentTimeMillis();
        long l11 = this.f;
        return l10 - l11;
    }

    public String a(long l10) {
        Object object;
        Object object2 = new SimpleDateFormat("yyyyMMddHHmmss");
        long l11 = this.f;
        long l12 = 1000L;
        long l13 = l10 * l12;
        Date date = new Date(l11 += l13);
        object2 = ((DateFormat)object2).format(date);
        int n10 = this.c;
        int n11 = 4;
        int n12 = 3;
        int n13 = 2;
        int n14 = 1;
        if (n10 < 0) {
            Object object3;
            long l14 = System.currentTimeMillis();
            long l15 = this.f;
            l14 = (l14 - l15 - l10) / l12;
            object = new Object[n11];
            object[0] = object3 = this.a;
            object[n14] = object3 = this.e;
            object[n13] = object3 = this.b;
            object[n12] = object3 = Long.valueOf(l14);
            object3 = "http://%s/timeshift/%s/%s/timeshift.m3u8?delay=%d";
            object = String.format((String)object3, object);
        } else {
            Object object4;
            int n15 = 5;
            object = new Object[n15];
            object[0] = object4 = this.a;
            object[n14] = object4 = Integer.valueOf(n10);
            object[n13] = object4 = this.b;
            object[n12] = object2;
            object[n11] = object4 = this.d;
            object4 = "http://%s/%s/%s/timeshift.m3u8?starttime=%s&appid=%s&txKbps=0";
            object = String.format((String)object4, object);
        }
        return object;
    }
}

