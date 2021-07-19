/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.os.Build$VERSION
 */
package com.tencent.liteav;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.datareport.TXCDRExtInfo;
import com.tencent.liteav.basic.datareport.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.l;

public class k {
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private float F;
    private int G;
    private String H;
    private String I;
    private String J;
    private String K;
    private final String a;
    private final String b;
    private Context c;
    private String d = null;
    private long e;
    private long f;
    private long g;
    private boolean h;
    private boolean i;
    private int j;
    private int k;
    private int l;
    private long m;
    private int n;
    private int o;
    private int p;
    private int q;
    private String r;
    private boolean s;
    private boolean t;
    private int u;
    private int v;
    private String w;
    private String x;
    private int y;
    private String z;

    public k(Context object) {
        String string2;
        long l10;
        this.a = "TXCVodPlayCollection";
        this.b = "1";
        this.e = l10 = 0L;
        this.f = l10;
        this.g = l10;
        this.h = false;
        this.i = true;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = l10;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.s = false;
        this.t = false;
        this.u = 0;
        this.v = 0;
        this.w = "0";
        this.x = string2 = "";
        this.z = string2;
        this.A = -1;
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.F = 1.0f;
        this.K = string2;
        this.c = object;
        object = TXCCommonUtil.getAppVersion();
        this.r = object;
        object = com.tencent.liteav.basic.util.g.e();
        this.J = object;
    }

    private void m() {
        float f10;
        CharSequence charSequence;
        CharSequence charSequence2;
        CharSequence charSequence3;
        String string2;
        k k10 = this;
        Object object = new TXCDRExtInfo();
        int n10 = 0;
        CharSequence charSequence4 = null;
        ((TXCDRExtInfo)object).report_common = false;
        ((TXCDRExtInfo)object).report_status = false;
        ((TXCDRExtInfo)object).url = string2 = this.d;
        string2 = this.c;
        String string3 = this.J;
        int n11 = com.tencent.liteav.basic.datareport.a.ad;
        int n12 = com.tencent.liteav.basic.datareport.a.at;
        TXCDRApi.InitEvent((Context)string2, string3, n11, n12, (TXCDRExtInfo)object);
        object = com.tencent.liteav.basic.util.g.c();
        string2 = this.J;
        int n13 = com.tencent.liteav.basic.datareport.a.ad;
        String string4 = "str_device_type";
        TXCDRApi.txSetEventValue(string2, n13, string4, (String)object);
        string2 = this.c;
        int n14 = com.tencent.liteav.basic.util.g.d((Context)string2);
        string3 = this.J;
        n12 = com.tencent.liteav.basic.datareport.a.ad;
        long l10 = n14;
        String string5 = "u32_network_type";
        TXCDRApi.txSetEventIntValue(string3, n12, string5, l10);
        string3 = com.tencent.liteav.basic.util.g.e(this.c);
        String string6 = this.J;
        int n15 = com.tencent.liteav.basic.datareport.a.ad;
        String string7 = "dev_uuid";
        TXCDRApi.txSetEventValue(string6, n15, string7, string3);
        string6 = this.J;
        n15 = com.tencent.liteav.basic.datareport.a.ad;
        String string8 = this.r;
        String string9 = "str_app_version";
        TXCDRApi.txSetEventValue(string6, n15, string9, string8);
        string6 = this.a();
        CharSequence charSequence5 = this.J;
        int n16 = com.tencent.liteav.basic.datareport.a.ad;
        String string10 = "str_app_name";
        TXCDRApi.txSetEventValue((String)charSequence5, n16, string10, string6);
        charSequence5 = this.J;
        n16 = com.tencent.liteav.basic.datareport.a.ad;
        String string11 = com.tencent.liteav.basic.datareport.a.l;
        int n17 = Build.VERSION.SDK_INT;
        String string12 = String.valueOf(n17);
        TXCDRApi.txSetEventValue((String)charSequence5, n16, string11, string12);
        charSequence5 = this.J;
        n16 = com.tencent.liteav.basic.datareport.a.ad;
        string11 = this.d;
        string12 = "str_stream_url";
        TXCDRApi.txSetEventValue((String)charSequence5, n16, string12, string11);
        charSequence5 = this.J;
        n16 = com.tencent.liteav.basic.datareport.a.ad;
        string11 = "token";
        TXCDRApi.txSetEventValue((String)charSequence5, n16, string11, (String)charSequence5);
        charSequence5 = TXCCommonUtil.getUserId();
        if (charSequence5 == null || (n16 = (int)(((String)charSequence5).isEmpty() ? 1 : 0)) != 0) {
            charSequence5 = new StringBuilder();
            string8 = "_";
            ((StringBuilder)charSequence5).append(string8);
            ((StringBuilder)charSequence5).append(string3);
            charSequence5 = ((StringBuilder)charSequence5).toString();
        }
        string3 = k10.J;
        n16 = com.tencent.liteav.basic.datareport.a.ad;
        string11 = "str_user_id";
        TXCDRApi.txSetEventValue(string3, n16, string11, (String)charSequence5);
        string3 = com.tencent.liteav.basic.util.g.c(k10.c);
        string8 = k10.J;
        n10 = com.tencent.liteav.basic.datareport.a.ad;
        CharSequence charSequence6 = charSequence5;
        charSequence5 = "str_package_name";
        TXCDRApi.txSetEventValue(string8, n10, (String)charSequence5, string3);
        charSequence4 = k10.J;
        n16 = com.tencent.liteav.basic.datareport.a.ad;
        String string13 = string3;
        string3 = k10.K;
        CharSequence charSequence7 = charSequence5;
        charSequence5 = "u32_app_id";
        TXCDRApi.txSetEventValue((String)charSequence4, n16, (String)charSequence5, string3);
        charSequence4 = k10.J;
        n13 = com.tencent.liteav.basic.datareport.a.ad;
        n16 = k10.l;
        String string14 = string11;
        int n18 = n17;
        long l11 = n16;
        string8 = "u32_timeuse";
        TXCDRApi.txSetEventIntValue((String)charSequence4, n13, string8, l11);
        charSequence4 = k10.J;
        n13 = com.tencent.liteav.basic.datareport.a.ad;
        l11 = k10.j;
        CharSequence charSequence8 = charSequence5;
        charSequence5 = "u32_videotime";
        TXCDRApi.txSetEventIntValue((String)charSequence4, n13, (String)charSequence5, l11);
        charSequence4 = k10.J;
        n13 = com.tencent.liteav.basic.datareport.a.ad;
        int n19 = k10.o;
        if (n19 == 0) {
            l11 = 0L;
        } else {
            n17 = k10.p / n19;
            l11 = n17;
        }
        CharSequence charSequence9 = charSequence5;
        charSequence5 = "u32_avg_load";
        TXCDRApi.txSetEventIntValue((String)charSequence4, n13, (String)charSequence5, l11);
        charSequence4 = k10.J;
        n13 = com.tencent.liteav.basic.datareport.a.ad;
        l11 = k10.o;
        CharSequence charSequence10 = charSequence5;
        charSequence5 = "u32_load_cnt";
        TXCDRApi.txSetEventIntValue((String)charSequence4, n13, (String)charSequence5, l11);
        charSequence4 = k10.J;
        n13 = com.tencent.liteav.basic.datareport.a.ad;
        l11 = k10.q;
        CharSequence charSequence11 = charSequence5;
        charSequence5 = "u32_max_load";
        TXCDRApi.txSetEventIntValue((String)charSequence4, n13, (String)charSequence5, l11);
        charSequence4 = k10.J;
        n13 = com.tencent.liteav.basic.datareport.a.ad;
        l11 = k10.p;
        CharSequence charSequence12 = charSequence5;
        charSequence5 = "u32_avg_block_time";
        TXCDRApi.txSetEventIntValue((String)charSequence4, n13, (String)charSequence5, l11);
        charSequence4 = k10.J;
        n13 = com.tencent.liteav.basic.datareport.a.ad;
        l11 = k10.v;
        CharSequence charSequence13 = charSequence5;
        charSequence5 = "u32_player_type";
        TXCDRApi.txSetEventIntValue((String)charSequence4, n13, (String)charSequence5, l11);
        charSequence4 = k10.J;
        n13 = com.tencent.liteav.basic.datareport.a.ad;
        n19 = k10.C;
        long l12 = -1;
        if (n19 > 0) {
            l11 = n19;
            charSequence3 = charSequence5;
        } else {
            charSequence3 = charSequence5;
            l11 = l12;
        }
        charSequence5 = "u32_dns_time";
        TXCDRApi.txSetEventIntValue((String)charSequence4, n13, (String)charSequence5, l11);
        charSequence4 = k10.J;
        n13 = com.tencent.liteav.basic.datareport.a.ad;
        n19 = k10.B;
        if (n19 > 0) {
            l11 = n19;
            charSequence2 = charSequence5;
        } else {
            charSequence2 = charSequence5;
            l11 = l12;
        }
        charSequence5 = "u32_tcp_did_connect";
        TXCDRApi.txSetEventIntValue((String)charSequence4, n13, (String)charSequence5, l11);
        charSequence4 = k10.J;
        n13 = com.tencent.liteav.basic.datareport.a.ad;
        n19 = k10.D;
        if (n19 > 0) {
            l11 = n19;
            charSequence = charSequence5;
        } else {
            charSequence = charSequence5;
            l11 = l12;
        }
        charSequence5 = "u32_first_video_packet";
        TXCDRApi.txSetEventIntValue((String)charSequence4, n13, (String)charSequence5, l11);
        charSequence4 = k10.J;
        n13 = com.tencent.liteav.basic.datareport.a.ad;
        n15 = k10.n;
        l11 = n15 > 0 ? (long)n15 : l12;
        TXCDRApi.txSetEventIntValue((String)charSequence4, n13, "u32_first_i_frame", l11);
        charSequence4 = k10.J;
        n13 = com.tencent.liteav.basic.datareport.a.ad;
        charSequence5 = k10.H;
        TXCDRApi.txSetEventValue((String)charSequence4, n13, "u32_server_ip", (String)charSequence5);
        charSequence4 = k10.J;
        n13 = com.tencent.liteav.basic.datareport.a.ad;
        charSequence5 = k10.I;
        TXCDRApi.txSetEventValue((String)charSequence4, n13, "u32_drm_type", (String)charSequence5);
        charSequence4 = k10.J;
        n13 = com.tencent.liteav.basic.datareport.a.ad;
        charSequence5 = k10.x;
        TXCDRApi.txSetEventValue((String)charSequence4, n13, "str_fileid", (String)charSequence5);
        charSequence4 = k10.J;
        n13 = com.tencent.liteav.basic.datareport.a.ad;
        charSequence5 = k10.w;
        TXCDRApi.txSetEventValue((String)charSequence4, n13, "u32_playmode", (String)charSequence5);
        charSequence4 = k10.J;
        n13 = com.tencent.liteav.basic.datareport.a.ad;
        l11 = k10.y;
        TXCDRApi.txSetEventIntValue((String)charSequence4, n13, "u64_err_code", l11);
        charSequence4 = k10.J;
        n13 = com.tencent.liteav.basic.datareport.a.ad;
        charSequence5 = k10.z;
        string11 = "str_err_info";
        TXCDRApi.txSetEventValue((String)charSequence4, n13, string11, (String)charSequence5);
        charSequence4 = k10.J;
        n13 = com.tencent.liteav.basic.datareport.a.ad;
        l11 = k10.A;
        TXCDRApi.txSetEventIntValue((String)charSequence4, n13, "u32_video_decode_type", l11);
        charSequence4 = k10.J;
        n13 = com.tencent.liteav.basic.datareport.a.ad;
        float f11 = k10.F;
        n19 = 1120403456;
        float f12 = 100.0f;
        n15 = (int)(f11 *= f12);
        l11 = n15;
        TXCDRApi.txSetEventIntValue((String)charSequence4, n13, "u32_speed", l11);
        charSequence4 = k10.J;
        n13 = com.tencent.liteav.basic.datareport.a.ad;
        TXCDRApi.nativeReportEvent((String)charSequence4, n13);
        charSequence4 = new StringBuilder();
        ((StringBuilder)charSequence4).append("report evt 40301: token=");
        string3 = k10.J;
        ((StringBuilder)charSequence4).append(string3);
        string3 = " ,";
        ((StringBuilder)charSequence4).append(string3);
        ((StringBuilder)charSequence4).append(string4);
        string4 = "=";
        ((StringBuilder)charSequence4).append(string4);
        ((StringBuilder)charSequence4).append((String)object);
        ((StringBuilder)charSequence4).append(string3);
        ((StringBuilder)charSequence4).append(string5);
        ((StringBuilder)charSequence4).append(string4);
        ((StringBuilder)charSequence4).append(n14);
        ((StringBuilder)charSequence4).append(string3);
        ((StringBuilder)charSequence4).append(string7);
        ((StringBuilder)charSequence4).append(string4);
        object = com.tencent.liteav.basic.util.g.e(k10.c);
        ((StringBuilder)charSequence4).append((String)object);
        ((StringBuilder)charSequence4).append(string3);
        ((StringBuilder)charSequence4).append(string9);
        ((StringBuilder)charSequence4).append(string4);
        object = k10.r;
        ((StringBuilder)charSequence4).append((String)object);
        ((StringBuilder)charSequence4).append(string3);
        ((StringBuilder)charSequence4).append(string10);
        ((StringBuilder)charSequence4).append(string4);
        ((StringBuilder)charSequence4).append(string6);
        ((StringBuilder)charSequence4).append(string3);
        object = com.tencent.liteav.basic.datareport.a.l;
        ((StringBuilder)charSequence4).append((String)object);
        ((StringBuilder)charSequence4).append(string4);
        int n20 = n18;
        ((StringBuilder)charSequence4).append(n18);
        ((StringBuilder)charSequence4).append(string3);
        ((StringBuilder)charSequence4).append(string12);
        ((StringBuilder)charSequence4).append(string4);
        object = k10.d;
        ((StringBuilder)charSequence4).append((String)object);
        ((StringBuilder)charSequence4).append(string3);
        object = string14;
        ((StringBuilder)charSequence4).append(string14);
        ((StringBuilder)charSequence4).append(string4);
        charSequence5 = charSequence6;
        ((StringBuilder)charSequence4).append((String)charSequence6);
        ((StringBuilder)charSequence4).append(string3);
        object = charSequence7;
        ((StringBuilder)charSequence4).append((String)charSequence7);
        ((StringBuilder)charSequence4).append(string4);
        object = string13;
        ((StringBuilder)charSequence4).append(string13);
        ((StringBuilder)charSequence4).append(string3);
        ((StringBuilder)charSequence4).append(string8);
        ((StringBuilder)charSequence4).append(string4);
        n20 = k10.l;
        ((StringBuilder)charSequence4).append(n20);
        ((StringBuilder)charSequence4).append(string3);
        object = charSequence9;
        ((StringBuilder)charSequence4).append((String)charSequence9);
        ((StringBuilder)charSequence4).append(string4);
        n20 = k10.j;
        ((StringBuilder)charSequence4).append(n20);
        ((StringBuilder)charSequence4).append(string3);
        object = charSequence10;
        ((StringBuilder)charSequence4).append((String)charSequence10);
        ((StringBuilder)charSequence4).append(string4);
        n20 = k10.o;
        if (n20 == 0) {
            n20 = 0;
            f10 = 0.0f;
            object = null;
        } else {
            n14 = k10.p;
            n20 = n14 / n20;
        }
        ((StringBuilder)charSequence4).append(n20);
        ((StringBuilder)charSequence4).append(string3);
        object = charSequence11;
        ((StringBuilder)charSequence4).append((String)charSequence11);
        ((StringBuilder)charSequence4).append(string4);
        n20 = k10.o;
        ((StringBuilder)charSequence4).append(n20);
        ((StringBuilder)charSequence4).append(string3);
        object = charSequence12;
        ((StringBuilder)charSequence4).append((String)charSequence12);
        ((StringBuilder)charSequence4).append(string4);
        n20 = k10.q;
        ((StringBuilder)charSequence4).append(n20);
        ((StringBuilder)charSequence4).append(string3);
        object = charSequence13;
        ((StringBuilder)charSequence4).append((String)charSequence13);
        ((StringBuilder)charSequence4).append(string4);
        n20 = k10.p;
        ((StringBuilder)charSequence4).append(n20);
        ((StringBuilder)charSequence4).append(string3);
        object = charSequence3;
        ((StringBuilder)charSequence4).append((String)charSequence3);
        ((StringBuilder)charSequence4).append(string4);
        n20 = k10.v;
        ((StringBuilder)charSequence4).append(n20);
        ((StringBuilder)charSequence4).append(string3);
        object = charSequence2;
        ((StringBuilder)charSequence4).append((String)charSequence2);
        ((StringBuilder)charSequence4).append(string4);
        n20 = k10.C;
        ((StringBuilder)charSequence4).append(n20);
        ((StringBuilder)charSequence4).append(string3);
        object = charSequence;
        ((StringBuilder)charSequence4).append((String)charSequence);
        ((StringBuilder)charSequence4).append(string4);
        n20 = k10.B;
        if (n20 <= 0) {
            n20 = -1;
            f10 = 0.0f / 0.0f;
        }
        ((StringBuilder)charSequence4).append(n20);
        ((StringBuilder)charSequence4).append(string3);
        object = "u32_first_video_packet";
        ((StringBuilder)charSequence4).append((String)object);
        ((StringBuilder)charSequence4).append(string4);
        n20 = k10.D;
        if (n20 <= 0) {
            n20 = -1;
            f10 = 0.0f / 0.0f;
        }
        ((StringBuilder)charSequence4).append(n20);
        ((StringBuilder)charSequence4).append(string3);
        ((StringBuilder)charSequence4).append("u32_first_i_frame");
        ((StringBuilder)charSequence4).append(string4);
        n20 = k10.n;
        ((StringBuilder)charSequence4).append(n20);
        ((StringBuilder)charSequence4).append(string3);
        ((StringBuilder)charSequence4).append("u32_server_ip");
        ((StringBuilder)charSequence4).append(string4);
        object = k10.H;
        ((StringBuilder)charSequence4).append((String)object);
        ((StringBuilder)charSequence4).append(string3);
        ((StringBuilder)charSequence4).append("u32_drm_type");
        ((StringBuilder)charSequence4).append(string4);
        object = k10.I;
        ((StringBuilder)charSequence4).append((String)object);
        ((StringBuilder)charSequence4).append(string3);
        ((StringBuilder)charSequence4).append("str_fileid");
        ((StringBuilder)charSequence4).append(string4);
        object = k10.x;
        ((StringBuilder)charSequence4).append((String)object);
        ((StringBuilder)charSequence4).append(string3);
        ((StringBuilder)charSequence4).append("u32_playmode");
        ((StringBuilder)charSequence4).append(string4);
        object = k10.w;
        ((StringBuilder)charSequence4).append((String)object);
        ((StringBuilder)charSequence4).append(string3);
        ((StringBuilder)charSequence4).append("u64_err_code");
        ((StringBuilder)charSequence4).append(string4);
        n20 = k10.y;
        ((StringBuilder)charSequence4).append(n20);
        ((StringBuilder)charSequence4).append(string3);
        ((StringBuilder)charSequence4).append("str_err_info");
        ((StringBuilder)charSequence4).append(string4);
        object = k10.z;
        ((StringBuilder)charSequence4).append((String)object);
        ((StringBuilder)charSequence4).append(string3);
        ((StringBuilder)charSequence4).append("u32_speed");
        ((StringBuilder)charSequence4).append(string4);
        f10 = k10.F * 100.0f;
        ((StringBuilder)charSequence4).append(f10);
        ((StringBuilder)charSequence4).append(string3);
        object = charSequence8;
        ((StringBuilder)charSequence4).append((String)charSequence8);
        ((StringBuilder)charSequence4).append(string4);
        object = TXCCommonUtil.getAppID();
        ((StringBuilder)charSequence4).append((String)object);
        ((StringBuilder)charSequence4).append(string3);
        ((StringBuilder)charSequence4).append("u32_video_decode_type");
        ((StringBuilder)charSequence4).append(string4);
        n20 = k10.A;
        ((StringBuilder)charSequence4).append(n20);
        object = ((StringBuilder)charSequence4).toString();
        TXCLog.i("TXCVodPlayCollection", (String)object);
    }

    private void n() {
        long l10 = this.f;
        long l11 = 0L;
        long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        Object object = "TXCVodPlayCollection";
        if (l12 == false) {
            TXCLog.i((String)object, "calculateSegmentPlayTime mBeginPlayTS == 0");
            return;
        }
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("calculateSegmentPlayTime mCurIndexPlayTime= ");
        l11 = this.m;
        ((StringBuilder)object2).append(l11);
        String string2 = ", mBeginPlayTS=";
        ((StringBuilder)object2).append(string2);
        l11 = this.f;
        ((StringBuilder)object2).append(l11);
        object2 = ((StringBuilder)object2).toString();
        TXCLog.i((String)object, (String)object2);
        l10 = this.m;
        l11 = System.currentTimeMillis();
        long l13 = this.f;
        int n10 = (int)(l11 - l13);
        l11 = n10;
        this.m = l10 += l11;
        this.f = l10 = System.currentTimeMillis();
        object2 = this.w;
        object = "1";
        l12 = (long)((String)object2).equals(object);
        if (l12 != false) {
            boolean bl2;
            object2 = com.tencent.liteav.l.a(this.c);
            l12 = (long)((l)object2).b((String)(object = this.K));
            if (l12 == false) {
                object = com.tencent.liteav.l.a(this.c);
                string2 = this.K;
                ((l)object).c(string2);
            }
            if ((bl2 = this.h) && l12 != false) {
                this.o();
            }
            l10 = this.l;
            l11 = this.m;
            l13 = 1000L;
            long l14 = l11 / l13;
            l12 = (int)(l10 += l14);
            this.l = (int)l12;
            this.m = l11 %= l13;
        }
    }

    private void o() {
        String string2;
        k k10 = this;
        CharSequence charSequence = "TXCVodPlayCollection";
        TXCLog.i((String)charSequence, "onSegmentReport");
        Object object = new TXCDRExtInfo();
        ((TXCDRExtInfo)object).report_common = false;
        ((TXCDRExtInfo)object).report_status = false;
        ((TXCDRExtInfo)object).url = string2 = this.d;
        string2 = this.c;
        String string3 = this.J;
        int n10 = com.tencent.liteav.basic.datareport.a.ae;
        int n11 = com.tencent.liteav.basic.datareport.a.at;
        TXCDRApi.InitEvent((Context)string2, string3, n10, n11, (TXCDRExtInfo)object);
        object = com.tencent.liteav.basic.util.g.c();
        string2 = this.J;
        int n12 = com.tencent.liteav.basic.datareport.a.ae;
        String string4 = "str_device_type";
        TXCDRApi.txSetEventValue(string2, n12, string4, (String)object);
        string2 = this.c;
        int n13 = com.tencent.liteav.basic.util.g.d((Context)string2);
        string3 = this.J;
        n11 = com.tencent.liteav.basic.datareport.a.ae;
        long l10 = n13;
        String string5 = "u32_network_type";
        TXCDRApi.txSetEventIntValue(string3, n11, string5, l10);
        string3 = com.tencent.liteav.basic.util.g.e(this.c);
        String string6 = this.J;
        int n14 = com.tencent.liteav.basic.datareport.a.ae;
        String string7 = "dev_uuid";
        TXCDRApi.txSetEventValue(string6, n14, string7, string3);
        string6 = this.J;
        n14 = com.tencent.liteav.basic.datareport.a.ae;
        String string8 = this.r;
        String string9 = "str_app_version";
        TXCDRApi.txSetEventValue(string6, n14, string9, string8);
        string6 = this.a();
        Object object2 = this.J;
        int n15 = com.tencent.liteav.basic.datareport.a.ae;
        String string10 = "str_app_name";
        TXCDRApi.txSetEventValue((String)object2, n15, string10, string6);
        object2 = this.J;
        n15 = com.tencent.liteav.basic.datareport.a.ae;
        String string11 = com.tencent.liteav.basic.datareport.a.l;
        int n16 = Build.VERSION.SDK_INT;
        String string12 = String.valueOf(n16);
        TXCDRApi.txSetEventValue((String)object2, n15, string11, string12);
        object2 = this.J;
        n15 = com.tencent.liteav.basic.datareport.a.ae;
        string11 = this.d;
        string12 = "str_stream_url";
        TXCDRApi.txSetEventValue((String)object2, n15, string12, string11);
        object2 = this.J;
        n15 = com.tencent.liteav.basic.datareport.a.ae;
        string11 = "token";
        TXCDRApi.txSetEventValue((String)object2, n15, string11, (String)object2);
        object2 = TXCCommonUtil.getUserId();
        if (object2 == null || (n15 = (int)(((String)object2).isEmpty() ? 1 : 0)) != 0) {
            object2 = new StringBuilder();
            string8 = "_";
            ((StringBuilder)object2).append(string8);
            ((StringBuilder)object2).append(string3);
            object2 = ((StringBuilder)object2).toString();
        }
        string3 = k10.J;
        n15 = com.tencent.liteav.basic.datareport.a.ae;
        string11 = "str_user_id";
        TXCDRApi.txSetEventValue(string3, n15, string11, (String)object2);
        string3 = com.tencent.liteav.basic.util.g.c(k10.c);
        string8 = k10.J;
        String string13 = charSequence;
        int n17 = com.tencent.liteav.basic.datareport.a.ae;
        CharSequence charSequence2 = object2;
        object2 = "str_package_name";
        TXCDRApi.txSetEventValue(string8, n17, (String)object2, string3);
        charSequence = k10.J;
        n15 = com.tencent.liteav.basic.datareport.a.ad;
        String string14 = string3;
        string3 = k10.K;
        CharSequence charSequence3 = object2;
        object2 = "u32_app_id";
        TXCDRApi.txSetEventValue((String)charSequence, n15, (String)object2, string3);
        charSequence = k10.J;
        n12 = com.tencent.liteav.basic.datareport.a.ae;
        n15 = k10.j;
        String string15 = string11;
        long l11 = n15;
        string8 = "u32_videotime";
        TXCDRApi.txSetEventIntValue((String)charSequence, n12, string8, l11);
        charSequence = k10.J;
        n12 = com.tencent.liteav.basic.datareport.a.ae;
        l11 = k10.v;
        CharSequence charSequence4 = object2;
        object2 = "u32_player_type";
        TXCDRApi.txSetEventIntValue((String)charSequence, n12, (String)object2, l11);
        charSequence = k10.J;
        n12 = com.tencent.liteav.basic.datareport.a.ae;
        string11 = k10.H;
        String string16 = "u32_server_ip";
        TXCDRApi.txSetEventValue((String)charSequence, n12, string16, string11);
        charSequence = k10.J;
        n12 = com.tencent.liteav.basic.datareport.a.ae;
        string11 = k10.I;
        String string17 = string16;
        string16 = "u32_drm_type";
        TXCDRApi.txSetEventValue((String)charSequence, n12, string16, string11);
        charSequence = k10.J;
        n12 = com.tencent.liteav.basic.datareport.a.ae;
        string11 = k10.x;
        String string18 = string16;
        string16 = "str_fileid";
        TXCDRApi.txSetEventValue((String)charSequence, n12, string16, string11);
        charSequence = k10.J;
        n12 = com.tencent.liteav.basic.datareport.a.ae;
        string11 = k10.w;
        String string19 = string16;
        string16 = "u32_playmode";
        TXCDRApi.txSetEventValue((String)charSequence, n12, string16, string11);
        charSequence = k10.J;
        n12 = com.tencent.liteav.basic.datareport.a.ae;
        l11 = k10.k;
        CharSequence charSequence5 = object2;
        object2 = "u32_videoindex";
        TXCDRApi.txSetEventIntValue((String)charSequence, n12, (String)object2, l11);
        charSequence = k10.J;
        n12 = com.tencent.liteav.basic.datareport.a.ae;
        l11 = k10.m;
        long l12 = 1000L;
        CharSequence charSequence6 = object2;
        object2 = "u32_realplaytime";
        TXCDRApi.txSetEventIntValue((String)charSequence, n12, (String)object2, l11 /= l12);
        charSequence = k10.J;
        n12 = com.tencent.liteav.basic.datareport.a.ae;
        l11 = System.currentTimeMillis();
        CharSequence charSequence7 = object2;
        TXCDRApi.txSetEventIntValue((String)charSequence, n12, "u64_timestamp", l11);
        charSequence = k10.J;
        n12 = com.tencent.liteav.basic.datareport.a.ae;
        l11 = (int)(k10.F * 100.0f);
        TXCDRApi.txSetEventIntValue((String)charSequence, n12, "u32_speed", l11);
        charSequence = k10.J;
        n12 = com.tencent.liteav.basic.datareport.a.ae;
        object2 = com.tencent.liteav.l.a(k10.c);
        string11 = k10.K;
        l11 = ((l)object2).a(string11);
        TXCDRApi.txSetEventIntValue((String)charSequence, n12, "u32_segment_duration", l11);
        charSequence = k10.J;
        n12 = com.tencent.liteav.basic.datareport.a.ae;
        TXCDRApi.nativeReportEvent((String)charSequence, n12);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("report evt 40302: token=");
        string3 = k10.J;
        ((StringBuilder)charSequence).append(string3);
        string3 = " ,";
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append(string4);
        string4 = "=";
        ((StringBuilder)charSequence).append(string4);
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append(string5);
        ((StringBuilder)charSequence).append(string4);
        ((StringBuilder)charSequence).append(n13);
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append(string7);
        ((StringBuilder)charSequence).append(string4);
        object = com.tencent.liteav.basic.util.g.e(k10.c);
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append(string9);
        ((StringBuilder)charSequence).append(string4);
        object = k10.r;
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append(string10);
        ((StringBuilder)charSequence).append(string4);
        ((StringBuilder)charSequence).append(string6);
        ((StringBuilder)charSequence).append(string3);
        object = com.tencent.liteav.basic.datareport.a.l;
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(string4);
        int n18 = n16;
        ((StringBuilder)charSequence).append(n16);
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append(string12);
        ((StringBuilder)charSequence).append(string4);
        object = k10.d;
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(string3);
        object = string15;
        ((StringBuilder)charSequence).append(string15);
        ((StringBuilder)charSequence).append(string4);
        object2 = charSequence2;
        ((StringBuilder)charSequence).append((String)charSequence2);
        ((StringBuilder)charSequence).append(string3);
        object = charSequence3;
        ((StringBuilder)charSequence).append((String)charSequence3);
        ((StringBuilder)charSequence).append(string4);
        object = string14;
        ((StringBuilder)charSequence).append(string14);
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append(string8);
        ((StringBuilder)charSequence).append(string4);
        n18 = k10.j;
        ((StringBuilder)charSequence).append(n18);
        ((StringBuilder)charSequence).append(string3);
        object = charSequence5;
        ((StringBuilder)charSequence).append((String)charSequence5);
        ((StringBuilder)charSequence).append(string4);
        n18 = k10.v;
        ((StringBuilder)charSequence).append(n18);
        ((StringBuilder)charSequence).append(string3);
        object = string17;
        ((StringBuilder)charSequence).append(string17);
        ((StringBuilder)charSequence).append(string4);
        object = k10.H;
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(string3);
        object = string18;
        ((StringBuilder)charSequence).append(string18);
        ((StringBuilder)charSequence).append(string4);
        object = k10.I;
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(string3);
        object = string19;
        ((StringBuilder)charSequence).append(string19);
        ((StringBuilder)charSequence).append(string4);
        object = k10.x;
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(string3);
        object = string16;
        ((StringBuilder)charSequence).append(string16);
        ((StringBuilder)charSequence).append(string4);
        object = k10.w;
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(string3);
        object = charSequence6;
        ((StringBuilder)charSequence).append((String)charSequence6);
        ((StringBuilder)charSequence).append(string4);
        n18 = k10.k;
        ((StringBuilder)charSequence).append(n18);
        ((StringBuilder)charSequence).append(string3);
        object = charSequence7;
        ((StringBuilder)charSequence).append((String)charSequence7);
        ((StringBuilder)charSequence).append(string4);
        long l13 = k10.m / l12;
        ((StringBuilder)charSequence).append(l13);
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append("u32_speed");
        ((StringBuilder)charSequence).append(string4);
        float f10 = k10.F * 100.0f;
        ((StringBuilder)charSequence).append(f10);
        ((StringBuilder)charSequence).append(string3);
        object = charSequence4;
        ((StringBuilder)charSequence).append((String)charSequence4);
        ((StringBuilder)charSequence).append(string4);
        object = TXCCommonUtil.getAppID();
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append("u64_timestamp");
        ((StringBuilder)charSequence).append(string4);
        l13 = System.currentTimeMillis();
        ((StringBuilder)charSequence).append(l13);
        charSequence = ((StringBuilder)charSequence).toString();
        object = string13;
        TXCLog.i(string13, (String)charSequence);
    }

    public String a() {
        Object object = this.c;
        ApplicationInfo applicationInfo = object.getApplicationInfo();
        int n10 = applicationInfo.labelRes;
        object = n10 == 0 ? applicationInfo.nonLocalizedLabel.toString() : object.getString(n10);
        return object;
    }

    public void a(float f10) {
        this.F = f10;
        Object object = this.c;
        int n10 = com.tencent.liteav.basic.datareport.a.bA;
        TXCDRApi.txReportDAU((Context)object, n10);
        object = new StringBuilder();
        ((StringBuilder)object).append("mSpeed = ");
        float f11 = this.F;
        ((StringBuilder)object).append(f11);
        object = ((StringBuilder)object).toString();
        TXCLog.i("TXCVodPlayCollection", (String)object);
    }

    public void a(int n10) {
        this.v = n10;
    }

    public void a(int n10, int n11) {
        this.j = n10;
        l l10 = com.tencent.liteav.l.a(this.c);
        String string2 = this.K;
        n10 = l10.a(string2);
        if ((n11 /= n10) != (n10 = this.k)) {
            this.k = n11;
            this.n();
        }
    }

    public void a(int n10, String string2) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("errorCode= ");
        charSequence.append(n10);
        charSequence.append(" \uff0cerrorInfo= ");
        charSequence.append(string2);
        charSequence = charSequence.toString();
        String string3 = "TXCVodPlayCollection";
        TXCLog.i(string3, (String)charSequence);
        int n11 = this.n;
        if (n11 == 0) {
            this.y = n10;
            this.z = string2;
            if (string2 == null) {
                String string4;
                this.z = string4 = "";
            }
        }
    }

    public void a(String string2) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("setUrl: ");
        charSequence.append(string2);
        charSequence = charSequence.toString();
        TXCLog.i("TXCVodPlayCollection", (String)charSequence);
        this.d = string2;
    }

    public void a(boolean bl2) {
        long l10;
        long l11;
        this.h = true;
        this.f = l11 = System.currentTimeMillis();
        this.e = l11;
        boolean bl3 = false;
        this.l = 0;
        this.m = l10 = 0L;
        this.k = 0;
        this.g = l10;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        if (bl2) {
            this.i = false;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("start ");
        l11 = this.f;
        charSequence.append(l11);
        charSequence.append(", mIsPaused = ");
        bl3 = this.i;
        charSequence.append(bl3);
        charSequence = charSequence.toString();
        TXCLog.i("TXCVodPlayCollection", (String)charSequence);
    }

    public void b() {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("stop ");
        long l10 = this.m;
        charSequence.append(l10);
        charSequence = charSequence.toString();
        String string2 = "TXCVodPlayCollection";
        TXCLog.i(string2, (String)charSequence);
        int n10 = this.i;
        if (n10 != 0) {
            long l11;
            this.f = l11 = System.currentTimeMillis();
        }
        n10 = this.h;
        string2 = null;
        if (n10 != 0) {
            this.n();
            long l12 = this.l;
            long l13 = this.m;
            long l14 = 1000L;
            this.l = n10 = (int)(l12 + (l13 /= l14));
            this.m = l12 = 0L;
            this.m();
            this.h = false;
        }
        this.s = false;
        this.t = false;
        this.i = false;
    }

    public void b(int n10) {
        this.A = n10;
    }

    public void b(String string2) {
        this.w = string2;
    }

    public void b(boolean bl2) {
        int n10;
        Object object;
        if (bl2) {
            bl2 = true;
            this.E = (int)(bl2 ? 1 : 0);
            object = this.c;
            n10 = com.tencent.liteav.basic.datareport.a.bB;
            TXCDRApi.txReportDAU((Context)object, n10);
        } else {
            bl2 = false;
            object = null;
            this.E = 0;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("mIsMirror= ");
        n10 = this.E;
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        TXCLog.i("TXCVodPlayCollection", (String)object);
    }

    public void c() {
        long l10;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("pause ");
        long l11 = this.m;
        charSequence.append(l11);
        charSequence = charSequence.toString();
        String string2 = "TXCVodPlayCollection";
        TXCLog.i(string2, (String)charSequence);
        boolean bl2 = this.i;
        if (!bl2) {
            l10 = this.m;
            long l12 = System.currentTimeMillis();
            long l13 = this.f;
            this.m = l10 += (l12 -= l13);
        }
        this.i = true;
        this.f = l10 = System.currentTimeMillis();
    }

    public void c(String string2) {
        this.I = string2;
    }

    public void d() {
        long l10;
        this.f = l10 = System.currentTimeMillis();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("resume ");
        long l11 = this.f;
        charSequence.append(l11);
        charSequence = charSequence.toString();
        TXCLog.i("TXCVodPlayCollection", (String)charSequence);
        this.i = false;
    }

    public void d(String string2) {
        this.x = string2;
    }

    public void e() {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("setLoadEnd mFirstFrame=");
        int bl2 = this.n;
        charSequence.append(bl2);
        charSequence.append(" , mIsLoading = ");
        boolean bl3 = this.t;
        charSequence.append(bl3);
        charSequence.append(",mBeginLoadTS = ");
        long l10 = this.g;
        charSequence.append(l10);
        charSequence = charSequence.toString();
        TXCLog.i("TXCVodPlayCollection", (String)charSequence);
        int n10 = this.n;
        boolean bl4 = false;
        if (n10 != 0 && (n10 = (int)(this.t ? 1 : 0)) != 0) {
            int n11;
            long l11 = System.currentTimeMillis();
            long l12 = this.g;
            n10 = (int)(l11 -= l12);
            this.p = n11 = this.p + n10;
            this.o = n11 = this.o + 1;
            n11 = this.q;
            if (n11 < n10) {
                this.q = n10;
            }
            this.t = false;
        }
        if ((n10 = (int)(this.s ? 1 : 0)) != 0) {
            this.s = false;
        }
    }

    public void e(String string2) {
        this.H = string2;
        if (string2 == null) {
            this.H = string2 = "";
        }
    }

    public void f() {
        String string2 = "TXCVodPlayCollection";
        String string3 = "renderStart";
        TXCLog.i(string2, string3);
        int n10 = this.n;
        if (n10 == 0) {
            long l10 = System.currentTimeMillis();
            long l11 = this.e;
            this.n = n10 = (int)(l10 -= l11);
        }
    }

    public void f(String string2) {
        this.K = string2;
    }

    public void g() {
        int n10 = this.B;
        if (n10 == 0) {
            long l10 = System.currentTimeMillis();
            long l11 = this.e;
            this.B = n10 = (int)(l10 -= l11);
            CharSequence charSequence = new StringBuilder();
            charSequence.append("mTcpConnectTS = ");
            int n11 = this.B;
            charSequence.append(n11);
            charSequence.append(", mOriginBeginPlayTS = ");
            long l12 = this.e;
            charSequence.append(l12);
            charSequence.append(", ");
            l12 = System.currentTimeMillis();
            charSequence.append(l12);
            charSequence = charSequence.toString();
            String string2 = "TXCVodPlayCollection";
            TXCLog.i(string2, (String)charSequence);
        }
    }

    public void h() {
        int n10 = this.C;
        if (n10 == 0) {
            long l10 = System.currentTimeMillis();
            long l11 = this.e;
            this.C = n10 = (int)(l10 -= l11);
        }
    }

    public void i() {
        int n10 = this.D;
        if (n10 == 0) {
            long l10 = System.currentTimeMillis();
            long l11 = this.e;
            this.D = n10 = (int)(l10 -= l11);
        }
    }

    public void j() {
        long l10;
        this.g = l10 = System.currentTimeMillis();
        this.t = true;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("setLoadBegin mBeginLoadTS= ");
        long l11 = this.g;
        charSequence.append(l11);
        charSequence = charSequence.toString();
        TXCLog.i("TXCVodPlayCollection", (String)charSequence);
    }

    public void k() {
        int n10;
        int n11 = 1;
        this.s = n11;
        this.u = n10 = this.u + n11;
        Object object = this.c;
        n10 = com.tencent.liteav.basic.datareport.a.bz;
        TXCDRApi.txReportDAU((Context)object, n10);
        object = new StringBuilder();
        ((StringBuilder)object).append("mSeekCnt= ");
        n10 = this.u;
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        TXCLog.d("TXCVodPlayCollection", (String)object);
    }

    public void l() {
        int n10;
        this.G = n10 = this.G + 1;
        Object object = this.c;
        int n11 = com.tencent.liteav.basic.datareport.a.bC;
        TXCDRApi.txReportDAU((Context)object, n11);
        object = new StringBuilder();
        ((StringBuilder)object).append("mSetBitrateIndexCnt= ");
        n11 = this.G;
        ((StringBuilder)object).append(n11);
        object = ((StringBuilder)object).toString();
        TXCLog.d("TXCVodPlayCollection", (String)object);
    }
}

