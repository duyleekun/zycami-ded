/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.tencent.liteav.network;

import android.content.Context;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.datareport.TXCDRExtInfo;
import com.tencent.liteav.basic.datareport.a;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.network.m;
import java.util.regex.Pattern;

public class n {
    private Context a;
    private String b;
    private String c;
    private String d;
    private String e;
    private long f;
    private long g;
    private String h;
    private long i;
    private long j;
    private long k;
    private long l;
    private long m;
    private long n;
    private long o;
    private long p;
    private long q;
    private long r;
    private long s;
    private long t;
    private long u;
    private long v;
    private boolean w = true;

    public n(Context object) {
        object = object.getApplicationContext();
        this.a = object;
        object = com.tencent.liteav.basic.util.g.b((Context)object);
        this.b = object;
        this.d = "Android";
        object = com.tencent.liteav.network.m.a();
        Context context = this.a;
        ((m)object).a(context);
        this.a();
    }

    private boolean b(String string2) {
        int n10;
        return string2 == null || (n10 = string2.length()) == 0;
        {
        }
    }

    private boolean c(String string2) {
        return Pattern.compile("[0-9]*").matcher(string2).matches();
    }

    private void e() {
        long l10 = this.p;
        long l11 = this.q;
        this.a();
        this.n = l10;
        this.o = l11;
    }

    private void f() {
        String string2;
        n n10 = this;
        long l10 = this.f;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false && (object = (Object)this.b(string2 = this.b)) == false && (object = (Object)this.b(string2 = this.e)) == false) {
            long l13;
            float f10;
            float f11;
            float f12;
            float f13;
            long l14;
            String string3;
            long l15;
            string2 = TXCCommonUtil.getStreamIDByStreamUrl(this.e);
            long l16 = System.currentTimeMillis();
            long l17 = this.f;
            long l18 = l16 - l17;
            l16 = this.p;
            l17 = this.n;
            long l19 = l16 - l17;
            Object object2 = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
            l16 = object2 > 0 ? (l16 -= l17) : l11;
            l17 = n10.q;
            long l20 = n10.o;
            object2 = l17 == l20 ? 0 : (l17 < l20 ? -1 : 1);
            l17 = object2 > 0 ? (l17 -= l20) : l11;
            l20 = n10.v;
            object2 = l20 == l11 ? 0 : (l20 < l11 ? -1 : 1);
            if (object2 > 0) {
                l15 = n10.r / l20;
                l11 = n10.s / l20;
            } else {
                l11 = 0L;
                l15 = 0L;
            }
            String string4 = TXCDRApi.txCreateToken();
            Object object3 = new TXCDRExtInfo();
            ((TXCDRExtInfo)object3).report_common = false;
            ((TXCDRExtInfo)object3).report_status = false;
            ((TXCDRExtInfo)object3).url = string3 = n10.e;
            string3 = n10.a;
            int n11 = com.tencent.liteav.basic.datareport.a.T;
            long l21 = l11;
            int n12 = com.tencent.liteav.basic.datareport.a.am;
            TXCDRApi.InitEvent((Context)string3, string4, n11, n12, (TXCDRExtInfo)object3);
            n12 = com.tencent.liteav.basic.datareport.a.T;
            String string5 = n10.b;
            TXCDRApi.txSetEventValue(string4, n12, "str_user_id", string5);
            n12 = com.tencent.liteav.basic.datareport.a.T;
            TXCDRApi.txSetEventValue(string4, n12, "str_stream_id", string2);
            object = com.tencent.liteav.basic.datareport.a.T;
            String string6 = n10.c;
            TXCDRApi.txSetEventValue(string4, (int)object, "str_access_id", string6);
            object = com.tencent.liteav.basic.datareport.a.T;
            string6 = n10.d;
            TXCDRApi.txSetEventValue(string4, (int)object, "str_platform", string6);
            object = com.tencent.liteav.basic.datareport.a.T;
            l11 = n10.g;
            TXCDRApi.txSetEventIntValue(string4, (int)object, "u32_server_type", l11);
            object = com.tencent.liteav.basic.datareport.a.T;
            string6 = n10.h;
            TXCDRApi.txSetEventValue(string4, (int)object, "str_server_addr", string6);
            object = com.tencent.liteav.basic.datareport.a.T;
            l11 = n10.i;
            TXCDRApi.txSetEventIntValue(string4, (int)object, "u32_dns_timecost", l11);
            object = com.tencent.liteav.basic.datareport.a.T;
            l11 = n10.j;
            TXCDRApi.txSetEventIntValue(string4, (int)object, "u32_connect_timecost", l11);
            object = com.tencent.liteav.basic.datareport.a.T;
            l11 = n10.k;
            TXCDRApi.txSetEventIntValue(string4, (int)object, "u32_handshake_timecost", l11);
            object = com.tencent.liteav.basic.datareport.a.T;
            l11 = n10.l;
            TXCDRApi.txSetEventIntValue(string4, (int)object, "u32_push_type", l11);
            object = com.tencent.liteav.basic.datareport.a.T;
            TXCDRApi.txSetEventIntValue(string4, (int)object, "u32_totaltime", l18);
            object = com.tencent.liteav.basic.datareport.a.T;
            l11 = n10.m;
            object3 = "u32_block_count";
            TXCDRApi.txSetEventIntValue(string4, (int)object, (String)object3, l11);
            object = com.tencent.liteav.basic.datareport.a.T;
            TXCDRApi.txSetEventIntValue(string4, (int)object, "u32_video_drop", l16);
            object = com.tencent.liteav.basic.datareport.a.T;
            TXCDRApi.txSetEventIntValue(string4, (int)object, "u32_audio_drop", l17);
            object = com.tencent.liteav.basic.datareport.a.T;
            TXCDRApi.txSetEventIntValue(string4, (int)object, "u32_video_que_avg", l15);
            object = com.tencent.liteav.basic.datareport.a.T;
            string6 = "u32_audio_que_avg";
            TXCDRApi.txSetEventIntValue(string4, (int)object, string6, l21);
            object = com.tencent.liteav.basic.datareport.a.T;
            l11 = n10.t;
            TXCDRApi.txSetEventIntValue(string4, (int)object, "u32_video_que_max", l11);
            object = com.tencent.liteav.basic.datareport.a.T;
            l11 = n10.u;
            String string7 = "u32_audio_que_max";
            TXCDRApi.txSetEventIntValue(string4, (int)object, string7, l11);
            object = com.tencent.liteav.basic.datareport.a.T;
            TXCDRApi.nativeReportEvent(string4, (int)object);
            l10 = 0L;
            n12 = (int)(l18 == l10 ? 0 : (l18 < l10 ? -1 : 1));
            string5 = null;
            if (n12 > 0 && (n12 = (int)((l14 = (l16 = n10.m) - l10) == 0L ? 0 : (l14 < 0L ? -1 : 1))) != 0) {
                f13 = (float)l16 * 60000.0f;
                float f14 = l18;
                f12 = f13 /= f14;
            } else {
                f12 = 0.0f;
            }
            l16 = n10.v;
            n12 = (int)(l16 == l10 ? 0 : (l16 < l10 ? -1 : 1));
            if (n12 > 0) {
                l17 = n10.r;
                long l22 = l17 - l10;
                n12 = (int)(l22 == 0L ? 0 : (l22 < 0L ? -1 : 1));
                if (n12 == 0) {
                    n12 = 0;
                    string6 = null;
                    f13 = 0.0f;
                } else {
                    f13 = l17;
                    float f15 = l16;
                    f13 /= f15;
                }
                l17 = n10.s;
                object = l17 == l10 ? 0 : (l17 < l10 ? -1 : 1);
                if (object == false) {
                    f11 = f13;
                    f10 = 0.0f;
                } else {
                    float f16 = l17;
                    float f17 = l16;
                    f10 = f16 /= f17;
                    f11 = f13;
                }
            } else {
                f11 = 0.0f;
                f10 = 0.0f;
            }
            object = n10.w;
            if (object != false && (object = (Object)n10.b(string2 = n10.c)) == false && (object = (l13 = (l10 = n10.k) - (l11 = (long)-1)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) {
                object3 = com.tencent.liteav.network.m.a();
                string3 = n10.c;
                l15 = n10.g;
                l10 = n10.k;
                ((m)object3).a(string3, l15, l18, l10, f12, f11, f10);
            }
        }
    }

    public void a() {
        long l10;
        long l11;
        String string2;
        this.c = string2 = "";
        this.f = l11 = 0L;
        this.g = l10 = (long)-1;
        this.h = string2;
        this.i = l10;
        this.j = l10;
        this.k = l10;
        this.l = l10;
        this.e = string2;
        this.m = l11;
        this.n = l11;
        this.o = l11;
        this.p = l11;
        this.q = l11;
        this.r = l11;
        this.s = l11;
        this.t = l11;
        this.u = l11;
        this.v = l11;
        this.w = true;
    }

    public void a(long l10, long l11) {
        this.p = l10;
        this.q = l11;
    }

    public void a(long l10, long l11, long l12) {
        this.i = l10;
        this.j = l11;
        this.k = l12;
    }

    public void a(String string2) {
        this.e = string2;
    }

    public void a(boolean bl2) {
        long l10 = bl2 ? (long)2 : 1L;
        this.l = l10;
        if (bl2) {
            bl2 = false;
            this.w = false;
        }
    }

    public void a(boolean n10, String string2) {
        this.h = string2;
        if (n10 != 0) {
            long l10;
            this.g = l10 = 1L;
        } else if (string2 != null) {
            String[] stringArray = ":";
            n10 = string2.indexOf((String)stringArray);
            int n11 = -1;
            int n12 = 0;
            if (n10 != n11) {
                string2 = string2.substring(0, n10);
            }
            if (string2 != null) {
                long l11;
                stringArray = string2.split("[.]");
                int n13 = stringArray.length;
                while (n12 < n13) {
                    String string3 = stringArray[n12];
                    n11 = (int)(this.c(string3) ? 1 : 0);
                    if (n11 == 0) {
                        this.g = 3;
                        return;
                    }
                    ++n12;
                }
                this.g = l11 = (long)2;
            }
        }
    }

    public void b() {
        String string2;
        long l10;
        this.f = l10 = System.currentTimeMillis();
        this.c = string2 = com.tencent.liteav.network.m.a().b();
    }

    public void b(long l10, long l11) {
        long l12;
        long l13;
        long l14 = this.v;
        long l15 = 1L;
        this.v = l14 += l15;
        this.r = l14 = this.r + l10;
        this.s = l14 = this.s + l11;
        l14 = this.t;
        long l16 = l10 - l14;
        Object object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object > 0) {
            this.t = l10;
        }
        if ((l13 = (l12 = l11 - (l10 = this.u)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
            this.u = l11;
        }
    }

    public void c() {
        this.f();
        this.e();
    }

    public void d() {
        long l10;
        this.m = l10 = this.m + 1L;
    }
}

