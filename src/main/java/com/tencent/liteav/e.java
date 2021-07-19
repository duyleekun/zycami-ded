/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.text.TextUtils
 */
package com.tencent.liteav;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.liteav.basic.c.c;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.datareport.TXCDRExtInfo;
import com.tencent.liteav.basic.datareport.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.e$1;
import com.tencent.liteav.e$a;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class e {
    private static HashMap D;
    private static String a = "TXCDataReport";
    private long A;
    private int B;
    private String C;
    private String E;
    private String F;
    private HashMap b;
    private String c;
    private int d;
    private int e;
    private int f;
    private int g;
    private Context h;
    private String i;
    private long j;
    private long k;
    private long l;
    private long m;
    private long n;
    private long o;
    private boolean p;
    private long q;
    private int r;
    private long s;
    private long t;
    private boolean u;
    private long v;
    private long w;
    private long x;
    private long y;
    private long z;

    static {
        HashMap hashMap;
        D = hashMap = new HashMap();
    }

    public e(Context object) {
        long l10;
        this.s = l10 = 0L;
        this.t = l10;
        this.u = false;
        this.v = l10;
        this.w = l10;
        this.x = l10;
        this.y = l10;
        this.z = l10;
        this.A = l10;
        this.B = 0;
        HashMap hashMap = "";
        this.E = hashMap;
        this.F = hashMap;
        this.b = hashMap = new HashMap(100);
        this.h = object = object.getApplicationContext();
        object = TXCCommonUtil.getAppVersion();
        this.i = object;
        this.r = 5000;
        this.z = l10;
    }

    private void a(int n10, String string2) {
        String string3;
        Object object = TXCStatus.b(this.E, 7121);
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            object = string2;
        }
        Object object2 = this.b;
        String string4 = "str_session_id";
        ((HashMap)object2).put(string4, object);
        object = this.b;
        object2 = this.E;
        int n11 = 7110;
        object2 = TXCStatus.b((String)object2, n11);
        String string5 = "u32_server_ip";
        ((HashMap)object).put(string5, object2);
        boolean bl3 = this.u;
        object2 = "str_stream_url";
        if (bl3) {
            object = this.b;
            string3 = this.E;
            int n12 = 7116;
            string3 = TXCStatus.b(string3, n12);
            ((HashMap)object).put(object2, string3);
            object = (String)this.b.get(object2);
            this.f((String)object);
        } else {
            object = this.b;
            string3 = this.E;
            int n13 = 7119;
            string3 = TXCStatus.b(string3, n13);
            ((HashMap)object).put(object2, string3);
        }
        object = this.b;
        string3 = "str_user_id";
        object = (String)((HashMap)object).get(string3);
        TXCDRApi.txSetEventValue(string2, n10, string3, (String)object);
        object = this.b;
        string3 = "dev_uuid";
        object = (String)((HashMap)object).get(string3);
        TXCDRApi.txSetEventValue(string2, n10, string3, (String)object);
        object = (String)this.b.get(string4);
        TXCDRApi.txSetEventValue(string2, n10, string4, (String)object);
        object = this.b;
        string4 = "str_device_type";
        object = (String)((HashMap)object).get(string4);
        TXCDRApi.txSetEventValue(string2, n10, string4, (String)object);
        object = this.b;
        string4 = "str_os_info";
        object = (String)((HashMap)object).get(string4);
        TXCDRApi.txSetEventValue(string2, n10, string4, (String)object);
        object = this.b;
        string4 = "str_package_name";
        object = (String)((HashMap)object).get(string4);
        TXCDRApi.txSetEventValue(string2, n10, string4, (String)object);
        object = "u32_network_type";
        long l10 = this.g((String)object);
        TXCDRApi.txSetEventIntValue(string2, n10, (String)object, l10);
        object = (String)this.b.get(string5);
        TXCDRApi.txSetEventValue(string2, n10, string5, (String)object);
        object = (String)this.b.get(object2);
        TXCDRApi.txSetEventValue(string2, n10, (String)object2, (String)object);
    }

    private void c(int n10) {
        long l10;
        long l11;
        long l12;
        long l13;
        long l14;
        long l15;
        String string2;
        e e10 = this;
        int n11 = n10;
        Object object = new TXCDRExtInfo();
        ((TXCDRExtInfo)object).url = string2 = this.c;
        ((TXCDRExtInfo)object).report_common = false;
        ((TXCDRExtInfo)object).report_status = false;
        string2 = (String)this.b.get("token");
        Object object2 = this.h;
        int n12 = com.tencent.liteav.basic.datareport.a.an;
        TXCDRApi.InitEvent(object2, string2, n10, n12, (TXCDRExtInfo)object);
        this.a(n10, string2);
        object = this.b;
        object2 = "u64_timestamp";
        long l16 = (Long)((HashMap)object).get(object2);
        TXCDRApi.txSetEventIntValue(string2, n10, (String)object2, l16);
        object = this.E;
        n12 = 7107;
        l16 = TXCStatus.a((String)object, n12);
        object = this.E;
        int n13 = 7108;
        long l17 = TXCStatus.a((String)object, n13);
        long l18 = -1;
        long l19 = l17 == l18 ? 0 : (l17 < l18 ? -1 : 1);
        if (l19 != false) {
            l17 -= l16;
        }
        long l20 = (l19 = (l15 = l17 - (l14 = 0L)) == 0L ? 0 : (l15 < 0L ? -1 : 1)) < 0 ? l18 : l17;
        object = "u32_dns_time";
        TXCDRApi.txSetEventIntValue(string2, n11, (String)object, l20);
        String string3 = e10.E;
        int n14 = 7109;
        l20 = TXCStatus.a(string3, n14);
        long l21 = l20 == l18 ? 0 : (l20 < l18 ? -1 : 1);
        if (l21 != false) {
            l20 -= l16;
        }
        if ((l21 = l20 == l14 ? 0 : (l20 < l14 ? -1 : 1)) >= 0) {
            l18 = l20;
        }
        String string4 = "u32_connect_server_time";
        TXCDRApi.txSetEventIntValue(string2, n11, string4, l18);
        String string5 = e10.E;
        int n15 = 5004;
        int n16 = TXCStatus.c(string5, n15);
        l14 = n16;
        String string6 = "u32_video_decode_type";
        TXCDRApi.txSetEventIntValue(string2, n11, string6, l14);
        String string7 = e10.E;
        int n17 = 6001;
        e10.j = l14 = TXCStatus.a(string7, n17) - l16;
        long l22 = 0L;
        long l23 = l14 == l22 ? 0 : (l14 < l22 ? -1 : 1);
        if (l23 < 0) {
            l23 = n16;
            l14 = -1;
        } else {
            l23 = n16;
        }
        string5 = "u32_first_i_frame";
        TXCDRApi.txSetEventIntValue(string2, n11, string5, l14);
        string7 = e10.E;
        n17 = 7103;
        l14 = TXCStatus.a(string7, n17) - l16;
        long l24 = l14 == l22 ? 0 : (l14 < l22 ? -1 : 1);
        String string8 = string5;
        if (l24 < 0) {
            l13 = l14;
            l14 = -1;
        } else {
            l13 = l14;
        }
        string5 = "u32_first_frame_down";
        TXCDRApi.txSetEventIntValue(string2, n11, string5, l14);
        string7 = e10.E;
        n17 = 5005;
        l14 = TXCStatus.a(string7, n17) - l16;
        long l25 = l14 == l22 ? 0 : (l14 < l22 ? -1 : 1);
        String string9 = string5;
        if (l25 < 0) {
            l12 = l14;
            l14 = -1;
        } else {
            l12 = l14;
        }
        string5 = "u32_first_video_decode_time";
        TXCDRApi.txSetEventIntValue(string2, n11, string5, l14);
        string7 = e10.E;
        n17 = 7104;
        l14 = TXCStatus.a(string7, n17) - l16;
        long l26 = l14 == l22 ? 0 : (l14 < l22 ? -1 : 1);
        String string10 = string5;
        if (l26 < 0) {
            l11 = l14;
            l14 = -1;
        } else {
            l11 = l14;
        }
        string5 = "u32_first_audio_frame_down";
        TXCDRApi.txSetEventIntValue(string2, n11, string5, l14);
        string7 = e10.E;
        n17 = 2033;
        l14 = TXCStatus.a(string7, n17) - l16;
        n12 = (int)(l14 == l22 ? 0 : (l14 < l22 ? -1 : 1));
        if (n12 < 0) {
            l10 = l14;
            l16 = -1;
        } else {
            l16 = l14;
            l10 = l14;
        }
        string7 = "u32_first_audio_render_time";
        TXCDRApi.txSetEventIntValue(string2, n11, string7, l16);
        n12 = TXCStatus.c(e10.E, 7105);
        CharSequence charSequence = string7;
        l14 = n12;
        int n18 = n12;
        String string11 = "u64_err_code";
        TXCDRApi.txSetEventIntValue(string2, n11, string11, l14);
        int n19 = TXCStatus.c(e10.E, 7106);
        String string12 = string11;
        String string13 = charSequence;
        l16 = n19;
        string7 = "str_err_info";
        TXCDRApi.txSetEventIntValue(string2, n11, string7, l16);
        n12 = TXCStatus.c(e10.E, 7112);
        charSequence = String.valueOf(n12);
        int n20 = n12;
        string11 = "u32_link_type";
        TXCDRApi.txSetEventValue(string2, n11, string11, (String)charSequence);
        charSequence = e10.E;
        String string14 = string11;
        n12 = TXCStatus.c((String)charSequence, 7111);
        charSequence = String.valueOf(n12);
        string11 = "u32_channel_type";
        TXCDRApi.txSetEventValue(string2, n11, string11, (String)charSequence);
        charSequence = e10.i;
        String string15 = string11;
        string11 = "str_app_version";
        TXCDRApi.txSetEventValue(string2, n11, string11, (String)charSequence);
        TXCDRApi.nativeReportEvent(string2, n11);
        String string16 = a;
        charSequence = new StringBuilder();
        String string17 = string11;
        ((StringBuilder)charSequence).append("report evt ");
        ((StringBuilder)charSequence).append(n11);
        ((StringBuilder)charSequence).append(": token=");
        ((StringBuilder)charSequence).append(string2);
        String string18 = "\n";
        ((StringBuilder)charSequence).append(string18);
        string2 = "str_user_id";
        ((StringBuilder)charSequence).append(string2);
        string11 = "=";
        ((StringBuilder)charSequence).append(string11);
        String string19 = string7;
        string2 = e10.b.get(string2);
        ((StringBuilder)charSequence).append((Object)string2);
        ((StringBuilder)charSequence).append(string18);
        string2 = "dev_uuid";
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(string11);
        string2 = e10.b.get(string2);
        ((StringBuilder)charSequence).append((Object)string2);
        ((StringBuilder)charSequence).append(string18);
        string2 = "str_session_id";
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(string11);
        string2 = e10.b.get(string2);
        ((StringBuilder)charSequence).append((Object)string2);
        ((StringBuilder)charSequence).append(string18);
        ((StringBuilder)charSequence).append("str_device_type");
        ((StringBuilder)charSequence).append(string11);
        string2 = e10.b.get("str_device_type");
        ((StringBuilder)charSequence).append((Object)string2);
        ((StringBuilder)charSequence).append(string18);
        ((StringBuilder)charSequence).append("str_os_info");
        ((StringBuilder)charSequence).append(string11);
        string2 = e10.b.get("str_os_info");
        ((StringBuilder)charSequence).append((Object)string2);
        ((StringBuilder)charSequence).append(string18);
        ((StringBuilder)charSequence).append("str_package_name");
        ((StringBuilder)charSequence).append(string11);
        string2 = e10.b.get("str_package_name");
        ((StringBuilder)charSequence).append((Object)string2);
        ((StringBuilder)charSequence).append(string18);
        ((StringBuilder)charSequence).append("u32_network_type");
        ((StringBuilder)charSequence).append(string11);
        string2 = e10.b.get("u32_network_type");
        ((StringBuilder)charSequence).append((Object)string2);
        ((StringBuilder)charSequence).append(string18);
        ((StringBuilder)charSequence).append("u32_server_ip");
        ((StringBuilder)charSequence).append(string11);
        string2 = e10.b.get("u32_server_ip");
        ((StringBuilder)charSequence).append((Object)string2);
        ((StringBuilder)charSequence).append(string18);
        ((StringBuilder)charSequence).append("str_stream_url");
        ((StringBuilder)charSequence).append(string11);
        string2 = e10.b.get("str_stream_url");
        ((StringBuilder)charSequence).append((Object)string2);
        ((StringBuilder)charSequence).append(string18);
        ((StringBuilder)charSequence).append((String)object2);
        ((StringBuilder)charSequence).append(string11);
        string2 = e10.b.get(object2);
        ((StringBuilder)charSequence).append((Object)string2);
        ((StringBuilder)charSequence).append(string18);
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(string11);
        ((StringBuilder)charSequence).append(l17);
        ((StringBuilder)charSequence).append(string18);
        ((StringBuilder)charSequence).append(string4);
        ((StringBuilder)charSequence).append(string11);
        ((StringBuilder)charSequence).append(l20);
        ((StringBuilder)charSequence).append(string18);
        ((StringBuilder)charSequence).append(string6);
        ((StringBuilder)charSequence).append(string11);
        l19 = l23;
        ((StringBuilder)charSequence).append((int)l23);
        ((StringBuilder)charSequence).append(string18);
        object = string9;
        ((StringBuilder)charSequence).append(string9);
        ((StringBuilder)charSequence).append(string11);
        long l27 = l13;
        ((StringBuilder)charSequence).append(l13);
        ((StringBuilder)charSequence).append(string18);
        object = string10;
        ((StringBuilder)charSequence).append(string10);
        ((StringBuilder)charSequence).append(string11);
        l27 = l12;
        ((StringBuilder)charSequence).append(l12);
        ((StringBuilder)charSequence).append(string18);
        object = string8;
        ((StringBuilder)charSequence).append(string8);
        ((StringBuilder)charSequence).append(string11);
        l27 = e10.j;
        ((StringBuilder)charSequence).append(l27);
        ((StringBuilder)charSequence).append(string18);
        ((StringBuilder)charSequence).append(string5);
        ((StringBuilder)charSequence).append(string11);
        l27 = l11;
        ((StringBuilder)charSequence).append(l11);
        ((StringBuilder)charSequence).append(string18);
        ((StringBuilder)charSequence).append(string13);
        ((StringBuilder)charSequence).append(string11);
        l14 = l10;
        ((StringBuilder)charSequence).append(l10);
        ((StringBuilder)charSequence).append(string18);
        object = string12;
        ((StringBuilder)charSequence).append(string12);
        ((StringBuilder)charSequence).append(string11);
        l19 = n18;
        ((StringBuilder)charSequence).append(n18);
        ((StringBuilder)charSequence).append(string18);
        object = string19;
        ((StringBuilder)charSequence).append(string19);
        ((StringBuilder)charSequence).append(string11);
        l19 = n19;
        ((StringBuilder)charSequence).append(n19);
        ((StringBuilder)charSequence).append(string18);
        object = string14;
        ((StringBuilder)charSequence).append(string14);
        ((StringBuilder)charSequence).append(string11);
        l19 = n20;
        ((StringBuilder)charSequence).append(n20);
        ((StringBuilder)charSequence).append(string18);
        object = string15;
        ((StringBuilder)charSequence).append(string15);
        ((StringBuilder)charSequence).append(string11);
        l19 = n12;
        ((StringBuilder)charSequence).append(n12);
        ((StringBuilder)charSequence).append(string18);
        string18 = string17;
        ((StringBuilder)charSequence).append(string17);
        ((StringBuilder)charSequence).append(string11);
        string18 = e10.i;
        ((StringBuilder)charSequence).append(string18);
        string18 = ((StringBuilder)charSequence).toString();
        object = string16;
        TXCLog.d(string16, string18);
    }

    public static boolean c(String string2) {
        String string3;
        boolean bl2;
        if (string2 != null && (bl2 = string2.contains(string3 = "myqcloud"))) {
            return true;
        }
        return com.tencent.liteav.basic.c.c.a().a(string2);
    }

    private void d(int n10) {
        String string2;
        e e10 = this;
        int n11 = n10;
        Object object = new TXCDRExtInfo();
        ((TXCDRExtInfo)object).url = string2 = this.c;
        ((TXCDRExtInfo)object).report_common = false;
        ((TXCDRExtInfo)object).report_status = false;
        string2 = (String)this.b.get("token");
        Object object2 = this.h;
        int n12 = com.tencent.liteav.basic.datareport.a.an;
        TXCDRApi.InitEvent(object2, string2, n10, n12, (TXCDRExtInfo)object);
        this.a(n10, string2);
        long l10 = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(string2, n10, "u64_end_timestamp", l10);
        object = "u64_timestamp";
        TXCDRApi.txSetEventIntValue(string2, n10, (String)object, l10);
        object2 = this.E;
        n12 = 9002;
        double d10 = TXCStatus.d((String)object2, n12);
        String string3 = String.valueOf(d10);
        String string4 = "u32_avg_cpu_usage";
        TXCDRApi.txSetEventValue(string2, n10, string4, string3);
        string3 = this.E;
        int n13 = 9005;
        double d11 = TXCStatus.d(string3, n13);
        string3 = String.valueOf(d11);
        String string5 = "u32_avg_memory";
        TXCDRApi.txSetEventValue(string2, n10, string5, string3);
        long l11 = this.z;
        string3 = String.valueOf(l11);
        String string6 = "u64_begin_timestamp";
        TXCDRApi.txSetEventValue(string2, n10, string6, string3);
        String string7 = this.E;
        int n14 = 7107;
        long l12 = TXCStatus.a(string7, n14);
        long l13 = (TXCTimeUtil.getTimeTick() - l12) / 1000L;
        l12 = 0L;
        long l14 = l13 == l12 ? 0 : (l13 < l12 ? -1 : 1);
        long l15 = -1;
        double d12 = 0.0 / 0.0;
        String string8 = string3;
        l12 = l14 < 0 ? l15 : l13;
        string3 = "u64_playtime";
        TXCDRApi.txSetEventIntValue(string2, n11, string3, l12);
        l12 = l14 < 0 ? l15 : l13;
        string3 = "u32_result";
        TXCDRApi.txSetEventIntValue(string2, n11, string3, l12);
        int n15 = TXCStatus.c(e10.E, 7105);
        long l16 = l13;
        long l17 = n15;
        String string9 = "u64_err_code";
        TXCDRApi.txSetEventIntValue(string2, n11, string9, l17);
        CharSequence charSequence = e10.E;
        int n16 = 2004;
        n14 = TXCStatus.c((String)charSequence, n16);
        Object object3 = string6;
        l14 = n15;
        l11 = n14;
        String string10 = string6;
        object3 = "u32_speed_cnt";
        TXCDRApi.txSetEventIntValue(string2, n11, (String)object3, l11);
        int n17 = TXCStatus.c(e10.E, 2008);
        int n18 = n14;
        l12 = n17;
        String string11 = string9;
        TXCDRApi.txSetEventIntValue(string2, n11, "u64_audio_cache_avg", l12);
        string9 = "u32_avg_cache_time";
        TXCDRApi.txSetEventIntValue(string2, n11, string9, l12);
        n15 = TXCStatus.c(e10.E, 2003);
        l12 = n15;
        String string12 = string3;
        string3 = String.valueOf(l12);
        long l18 = l12;
        string7 = "u32_max_load";
        TXCDRApi.txSetEventValue(string2, n11, string7, string3);
        string3 = e10.E;
        n14 = 2001;
        int n19 = TXCStatus.c(string3, n14);
        String string13 = string7;
        l12 = n19;
        string3 = String.valueOf(l12);
        int n20 = n17;
        string6 = "u32_avg_load";
        TXCDRApi.txSetEventValue(string2, n11, string6, string3);
        string3 = e10.E;
        String string14 = string6;
        n19 = TXCStatus.c(string3, 2002);
        string6 = object3;
        String string15 = string9;
        l13 = n19;
        string3 = String.valueOf(l13);
        String string16 = object3;
        string6 = "u32_load_cnt";
        TXCDRApi.txSetEventValue(string2, n11, string6, string3);
        string3 = e10.E;
        String string17 = string6;
        n17 = 2005;
        n19 = TXCStatus.c(string3, n17);
        double d13 = d11;
        long l19 = n19;
        string6 = "u32_nodata_cnt";
        TXCDRApi.txSetEventIntValue(string2, n11, string6, l19);
        l19 = l12 * l13;
        long l20 = l13;
        object3 = "u32_audio_block_time";
        TXCDRApi.txSetEventIntValue(string2, n11, (String)object3, l19);
        long l21 = l19;
        l19 = e10.j;
        long l22 = 0L;
        long l23 = l19 == l22 ? 0 : (l19 < l22 ? -1 : 1);
        if (l23 < 0) {
            l19 = l15;
            d11 = d12;
        }
        string9 = "u32_first_i_frame";
        TXCDRApi.txSetEventIntValue(string2, n11, string9, l19);
        String string18 = e10.E;
        int n21 = 17021;
        n13 = TXCStatus.c(string18, n21);
        l15 = l12;
        l12 = n13;
        String string19 = "u32_video_width";
        TXCDRApi.txSetEventIntValue(string2, n11, string19, l12);
        string7 = e10.E;
        n14 = 17022;
        n15 = TXCStatus.c(string7, n14);
        String string20 = object3;
        l17 = n15;
        int n22 = n19;
        string3 = "u32_video_height";
        TXCDRApi.txSetEventIntValue(string2, n11, string3, l17);
        double d14 = TXCStatus.d(e10.E, 6017);
        String string21 = string6;
        string6 = String.valueOf(d14);
        double d15 = d14;
        charSequence = "u32_video_avg_fps";
        TXCDRApi.txSetEventValue(string2, n11, (String)charSequence, string6);
        string6 = e10.E;
        n16 = 6003;
        String string22 = charSequence;
        l17 = TXCStatus.a(string6, n16);
        string6 = e10.E;
        int n23 = n15;
        n15 = 6005;
        l11 = TXCStatus.a(string6, n15);
        String string23 = string3;
        string3 = e10.E;
        int n24 = n13;
        n13 = 6006;
        String string24 = string19;
        l19 = TXCStatus.a(string3, n13);
        l22 = 0L;
        n19 = (int)(l17 == l22 ? 0 : (l17 < l22 ? -1 : 1));
        if (n19 > 0) {
            l22 = l19 / l17;
        }
        l10 = l22;
        TXCDRApi.txSetEventIntValue(string2, n11, "u64_block_duration_avg", l22);
        TXCDRApi.txSetEventIntValue(string2, n11, "u32_avg_block_time", l22);
        TXCDRApi.txSetEventIntValue(string2, n11, "u64_block_count", l17);
        TXCDRApi.txSetEventIntValue(string2, n11, "u32_video_block_time", l19);
        TXCDRApi.txSetEventIntValue(string2, n11, "u64_block_duration_max", l11);
        l11 = TXCStatus.a(e10.E, 6009);
        TXCDRApi.txSetEventIntValue(string2, n11, "u64_jitter_cache_max", l11);
        string3 = e10.E;
        l22 = l11;
        l11 = TXCStatus.a(string3, 6008);
        TXCDRApi.txSetEventIntValue(string2, n11, "u64_jitter_cache_avg", l11);
        string3 = String.valueOf(TXCStatus.c(e10.E, 7112));
        TXCDRApi.txSetEventValue(string2, n11, "u32_link_type", string3);
        n19 = TXCStatus.c(e10.E, 7111);
        string6 = String.valueOf(n19);
        TXCDRApi.txSetEventValue(string2, n11, "u32_channel_type", string6);
        n17 = TXCStatus.c(e10.E, 7113);
        string7 = String.valueOf(n17);
        long l24 = l17;
        TXCDRApi.txSetEventValue(string2, n11, "u32_ip_count_quic", string7);
        n15 = TXCStatus.c(e10.E, 7114);
        charSequence = String.valueOf(n15);
        TXCDRApi.txSetEventValue(string2, n11, "u32_connect_count_quic", (String)charSequence);
        n14 = TXCStatus.c(e10.E, 7115);
        object3 = String.valueOf(n14);
        int n25 = n14;
        TXCDRApi.txSetEventValue(string2, n11, "u32_connect_count_tcp", (String)object3);
        charSequence = e10.i;
        TXCDRApi.txSetEventValue(string2, n11, "str_app_version", (String)charSequence);
        l17 = (long)e10.u;
        TXCDRApi.txSetEventIntValue(string2, n11, "u32_is_real_time", l17);
        l12 = TXCStatus.a(e10.E, 9009);
        TXCDRApi.txSetEventIntValue(string2, n11, "u32_first_frame_black", l12);
        TXCDRApi.nativeReportEvent(string2, n11);
        string7 = a;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("report evt ");
        ((StringBuilder)charSequence).append(n11);
        ((StringBuilder)charSequence).append(": token=");
        ((StringBuilder)charSequence).append(string2);
        String string25 = "\n";
        ((StringBuilder)charSequence).append(string25);
        ((StringBuilder)charSequence).append("str_user_id");
        string2 = "=";
        ((StringBuilder)charSequence).append(string2);
        object3 = e10.b;
        String string26 = string7;
        string7 = ((HashMap)object3).get("str_user_id");
        ((StringBuilder)charSequence).append((Object)string7);
        ((StringBuilder)charSequence).append(string25);
        ((StringBuilder)charSequence).append("dev_uuid");
        ((StringBuilder)charSequence).append(string2);
        string7 = e10.b.get("dev_uuid");
        ((StringBuilder)charSequence).append((Object)string7);
        ((StringBuilder)charSequence).append(string25);
        ((StringBuilder)charSequence).append("str_session_id");
        ((StringBuilder)charSequence).append(string2);
        string7 = e10.b.get("str_session_id");
        ((StringBuilder)charSequence).append((Object)string7);
        ((StringBuilder)charSequence).append(string25);
        ((StringBuilder)charSequence).append("str_device_type");
        ((StringBuilder)charSequence).append(string2);
        string7 = e10.b.get("str_device_type");
        ((StringBuilder)charSequence).append((Object)string7);
        ((StringBuilder)charSequence).append(string25);
        ((StringBuilder)charSequence).append("str_os_info");
        ((StringBuilder)charSequence).append(string2);
        string7 = e10.b.get("str_os_info");
        ((StringBuilder)charSequence).append((Object)string7);
        ((StringBuilder)charSequence).append(string25);
        ((StringBuilder)charSequence).append("str_package_name");
        ((StringBuilder)charSequence).append(string2);
        string7 = e10.b.get("str_package_name");
        ((StringBuilder)charSequence).append((Object)string7);
        ((StringBuilder)charSequence).append(string25);
        ((StringBuilder)charSequence).append("u32_network_type");
        ((StringBuilder)charSequence).append(string2);
        string7 = e10.b.get("u32_network_type");
        ((StringBuilder)charSequence).append((Object)string7);
        ((StringBuilder)charSequence).append(string25);
        ((StringBuilder)charSequence).append("u32_server_ip");
        ((StringBuilder)charSequence).append(string2);
        string7 = e10.b.get("u32_server_ip");
        ((StringBuilder)charSequence).append((Object)string7);
        ((StringBuilder)charSequence).append(string25);
        ((StringBuilder)charSequence).append("str_stream_url");
        ((StringBuilder)charSequence).append(string2);
        string7 = e10.b.get("str_stream_url");
        ((StringBuilder)charSequence).append((Object)string7);
        ((StringBuilder)charSequence).append(string25);
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(string2);
        object = e10.b.get(object);
        ((StringBuilder)charSequence).append(object);
        ((StringBuilder)charSequence).append(string25);
        ((StringBuilder)charSequence).append(string4);
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(d10);
        ((StringBuilder)charSequence).append(string25);
        ((StringBuilder)charSequence).append(string5);
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(d13);
        ((StringBuilder)charSequence).append(string25);
        ((StringBuilder)charSequence).append(string9);
        ((StringBuilder)charSequence).append(string2);
        long l25 = e10.j;
        ((StringBuilder)charSequence).append(l25);
        ((StringBuilder)charSequence).append(string25);
        string4 = string24;
        ((StringBuilder)charSequence).append(string24);
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(n24);
        ((StringBuilder)charSequence).append(string25);
        string4 = string23;
        ((StringBuilder)charSequence).append(string23);
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(n23);
        ((StringBuilder)charSequence).append(string25);
        string4 = string22;
        ((StringBuilder)charSequence).append(string22);
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(d15);
        ((StringBuilder)charSequence).append(string25);
        string4 = string16;
        ((StringBuilder)charSequence).append(string16);
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(n18);
        ((StringBuilder)charSequence).append(string25);
        string4 = string21;
        ((StringBuilder)charSequence).append(string21);
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(n22);
        ((StringBuilder)charSequence).append(string25);
        string4 = string15;
        ((StringBuilder)charSequence).append(string15);
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(n20);
        ((StringBuilder)charSequence).append(string25);
        ((StringBuilder)charSequence).append("u32_avg_block_time");
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(l10);
        ((StringBuilder)charSequence).append(string25);
        object2 = string14;
        ((StringBuilder)charSequence).append(string14);
        ((StringBuilder)charSequence).append(string2);
        l10 = l15;
        ((StringBuilder)charSequence).append(l15);
        ((StringBuilder)charSequence).append(string25);
        object2 = string13;
        ((StringBuilder)charSequence).append(string13);
        ((StringBuilder)charSequence).append(string2);
        l10 = l18;
        ((StringBuilder)charSequence).append(l18);
        ((StringBuilder)charSequence).append(string25);
        ((StringBuilder)charSequence).append("u32_video_block_time");
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(l19);
        ((StringBuilder)charSequence).append(string25);
        object2 = string20;
        ((StringBuilder)charSequence).append(string20);
        ((StringBuilder)charSequence).append(string2);
        l10 = l21;
        ((StringBuilder)charSequence).append(l21);
        ((StringBuilder)charSequence).append(string25);
        object2 = string17;
        ((StringBuilder)charSequence).append(string17);
        ((StringBuilder)charSequence).append(string2);
        l10 = l20;
        ((StringBuilder)charSequence).append(l20);
        ((StringBuilder)charSequence).append(string25);
        object2 = string12;
        ((StringBuilder)charSequence).append(string12);
        ((StringBuilder)charSequence).append(string2);
        l13 = l16;
        ((StringBuilder)charSequence).append(l16);
        ((StringBuilder)charSequence).append(string25);
        object2 = string11;
        ((StringBuilder)charSequence).append(string11);
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append((int)l14);
        ((StringBuilder)charSequence).append(string25);
        ((StringBuilder)charSequence).append("u32_channel_type");
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(n19);
        ((StringBuilder)charSequence).append(string25);
        ((StringBuilder)charSequence).append("u32_ip_count_quic");
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(n17);
        ((StringBuilder)charSequence).append(string25);
        ((StringBuilder)charSequence).append("u32_connect_count_quic");
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(n15);
        ((StringBuilder)charSequence).append(string25);
        ((StringBuilder)charSequence).append("u32_connect_count_tcp");
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(n25);
        ((StringBuilder)charSequence).append(string25);
        ((StringBuilder)charSequence).append("u64_block_count");
        ((StringBuilder)charSequence).append(string2);
        l10 = l24;
        ((StringBuilder)charSequence).append(l24);
        ((StringBuilder)charSequence).append(string25);
        ((StringBuilder)charSequence).append("u64_jitter_cache_max");
        ((StringBuilder)charSequence).append(string2);
        l10 = l22;
        ((StringBuilder)charSequence).append(l22);
        ((StringBuilder)charSequence).append(string25);
        ((StringBuilder)charSequence).append("u64_jitter_cache_avg");
        ((StringBuilder)charSequence).append(string2);
        l10 = l11;
        ((StringBuilder)charSequence).append(l11);
        ((StringBuilder)charSequence).append(string25);
        object = string10;
        ((StringBuilder)charSequence).append(string10);
        ((StringBuilder)charSequence).append(string2);
        object = string8;
        ((StringBuilder)charSequence).append(string8);
        ((StringBuilder)charSequence).append(string25);
        ((StringBuilder)charSequence).append("u32_is_real_time");
        ((StringBuilder)charSequence).append(string2);
        l10 = TXCStatus.a(e10.E, 2009);
        ((StringBuilder)charSequence).append(l10);
        ((StringBuilder)charSequence).append(string25);
        ((StringBuilder)charSequence).append("str_app_version");
        ((StringBuilder)charSequence).append(string2);
        string25 = e10.i;
        ((StringBuilder)charSequence).append(string25);
        string25 = ((StringBuilder)charSequence).toString();
        object = string26;
        TXCLog.d(string26, string25);
    }

    private void e(int n10) {
        String string2;
        Object object = new TXCDRExtInfo();
        ((TXCDRExtInfo)object).url = string2 = this.c;
        ((TXCDRExtInfo)object).report_common = false;
        int n11 = 1;
        ((TXCDRExtInfo)object).report_status = n11;
        String string3 = (String)this.b.get("token");
        Object object2 = this.h;
        int n12 = com.tencent.liteav.basic.datareport.a.an;
        TXCDRApi.InitEvent(object2, string3, n10, n12, (TXCDRExtInfo)object);
        this.a(n10, string3);
        long l10 = TXCTimeUtil.getUtcTimeTick();
        TXCDRApi.txSetEventIntValue(string3, n10, "u64_timestamp", l10);
        object = com.tencent.liteav.basic.util.g.a();
        l10 = (long)object[n11];
        String string4 = "u32_cpu_usage";
        TXCDRApi.txSetEventIntValue(string3, n10, string4, l10);
        long l11 = (long)object[0];
        object2 = "u32_app_cpu_usage";
        TXCDRApi.txSetEventIntValue(string3, n10, (String)object2, l11);
        object = String.valueOf(TXCStatus.d(this.E, 9002));
        TXCDRApi.txSetEventValue(string3, n10, "u32_avg_cpu_usage", (String)object);
        double d10 = TXCStatus.d(this.E, 9005);
        object = String.valueOf(d10);
        TXCDRApi.txSetEventValue(string3, n10, "u32_avg_memory", (String)object);
        object = this.E;
        int n13 = 2;
        l11 = TXCStatus.a((String)object, 6014, n13);
        TXCDRApi.txSetEventIntValue(string3, n10, "u32_recv_av_diff_time", l11);
        l11 = TXCStatus.a(this.E, 6013, n13);
        String string5 = "u32_play_av_diff_time";
        TXCDRApi.txSetEventIntValue(string3, n10, string5, l11);
        l11 = TXCTimeUtil.getUtcTimeTick();
        long l12 = this.z;
        l11 -= l12;
        l12 = 1000L;
        object = String.valueOf(l11 /= l12);
        string2 = "u64_playtime";
        TXCDRApi.txSetEventValue(string3, n10, string2, (String)object);
        object = this.E;
        int n14 = 2015;
        int n15 = TXCStatus.c((String)object, n14);
        if (n15 == 0) {
            n11 = n13;
        }
        l11 = n11;
        Object object3 = "u32_audio_decode_type";
        TXCDRApi.txSetEventIntValue(string3, n10, (String)object3, l11);
        object = this.E;
        n14 = 2002;
        l11 = TXCStatus.a((String)object, n14);
        l10 = this.o;
        long l13 = -1;
        n11 = (int)(l10 == l13 ? 0 : (l10 < l13 ? -1 : 1));
        String string6 = "u32_audio_block_count";
        long l14 = 0L;
        if (n11 == 0) {
            object3 = l14;
            l10 = (Long)object3;
            TXCDRApi.txSetEventIntValue(string3, n10, string6, l10);
        } else {
            n11 = (int)(l11 == l10 ? 0 : (l11 < l10 ? -1 : 1));
            if (n11 >= 0) {
                l10 = l11 - l10;
                TXCDRApi.txSetEventIntValue(string3, n10, string6, l10);
            } else {
                object3 = l13;
                l10 = (Long)object3;
                TXCDRApi.txSetEventIntValue(string3, n10, string6, l10);
            }
        }
        this.o = l11;
        l11 = TXCStatus.c(this.E, 2010);
        TXCDRApi.txSetEventIntValue(string3, n10, "u32_audio_cache_time", l11);
        l11 = TXCStatus.c(this.E, 2014);
        TXCDRApi.txSetEventIntValue(string3, n10, "u32_audio_drop", l11);
        l11 = TXCStatus.c(this.E, 5004);
        TXCDRApi.txSetEventIntValue(string3, n10, "u32_video_decode_type", l11);
        l11 = this.j();
        TXCDRApi.txSetEventIntValue(string3, n10, "u32_video_recv_fps", l11);
        d10 = TXCStatus.d(this.E, 6002);
        l11 = (int)d10;
        TXCDRApi.txSetEventIntValue(string3, n10, "u32_fps", l11);
        n15 = TXCStatus.c(this.E, 6007);
        l11 = n15;
        TXCDRApi.txSetEventIntValue(string3, n10, "u32_video_cache_time", l11);
        object = this.E;
        n14 = 6008;
        l11 = TXCStatus.a((String)object, n14);
        TXCDRApi.txSetEventIntValue(string3, n10, "u32_video_cache_count", l11);
        TXCDRApi.txSetEventIntValue(string3, n10, "u32_avg_cache_count", l11);
        object3 = this.E;
        n13 = 6004;
        l10 = TXCStatus.a((String)object3, n13);
        long l15 = this.k;
        n11 = (int)(l15 == l13 ? 0 : (l15 < l13 ? -1 : 1));
        string4 = "u32_video_block_count";
        if (n11 == 0) {
            TXCDRApi.txSetEventIntValue(string3, n10, string4, l14);
        } else {
            n11 = (int)(l10 == l15 ? 0 : (l10 < l15 ? -1 : 1));
            if (n11 >= 0) {
                long l16 = l10 - l15;
                TXCDRApi.txSetEventIntValue(string3, n10, string4, l16);
            } else {
                TXCDRApi.txSetEventIntValue(string3, n10, string4, l14);
            }
        }
        this.k = l10;
        n11 = TXCStatus.c(this.E, 7102);
        n13 = TXCStatus.c(this.E, 7101);
        n12 = n11 + n13;
        l12 = n12;
        TXCDRApi.txSetEventIntValue(string3, n10, "u32_net_speed", l12);
        String string7 = "u32_avg_net_speed";
        TXCDRApi.txSetEventIntValue(string3, n10, string7, l12);
        l12 = n11;
        TXCDRApi.txSetEventIntValue(string3, n10, "u32_avg_audio_bitrate", l12);
        l10 = n13;
        TXCDRApi.txSetEventIntValue(string3, n10, "u32_avg_video_bitrate", l10);
        object3 = String.valueOf(TXCStatus.c(this.E, 7112));
        TXCDRApi.txSetEventValue(string3, n10, "u32_link_type", (String)object3);
        object3 = String.valueOf(TXCStatus.c(this.E, 7111));
        TXCDRApi.txSetEventValue(string3, n10, "u32_channel_type", (String)object3);
        object3 = this.i;
        object2 = "str_app_version";
        TXCDRApi.txSetEventValue(string3, n10, (String)object2, (String)object3);
        object3 = this.E;
        n13 = 6021;
        l10 = TXCStatus.a((String)object3, n13);
        l13 = this.l;
        n11 = (int)(l10 == l13 ? 0 : (l10 < l13 ? -1 : 1));
        string6 = "u32_video_light_block_count";
        if (n11 > 0) {
            l13 = l10 - l13;
            TXCDRApi.txSetEventIntValue(string3, n10, string6, l13);
        } else {
            TXCDRApi.txSetEventIntValue(string3, n10, string6, l14);
        }
        this.l = l10;
        object3 = this.E;
        n13 = 6003;
        l10 = TXCStatus.a((String)object3, n13);
        l13 = this.m;
        n11 = (int)(l10 == l13 ? 0 : (l10 < l13 ? -1 : 1));
        string6 = "u32_video_large_block_count";
        if (n11 > 0) {
            l13 = l10 - l13;
            TXCDRApi.txSetEventIntValue(string3, n10, string6, l13);
        } else {
            TXCDRApi.txSetEventIntValue(string3, n10, string6, l14);
        }
        this.m = l10;
        object3 = this.E;
        n13 = 2034;
        l10 = TXCStatus.c((String)object3, n13);
        l13 = this.n;
        n11 = (int)(l10 == l13 ? 0 : (l10 < l13 ? -1 : 1));
        string6 = "u32_audio_jitter_60ms_count";
        if (n11 > 0) {
            l13 = l10 - l13;
            TXCDRApi.txSetEventIntValue(string3, n10, string6, l13);
        } else {
            TXCDRApi.txSetEventIntValue(string3, n10, string6, l14);
        }
        this.n = l10;
        l10 = TXCStatus.c(this.E, 9007);
        TXCDRApi.txSetEventIntValue(string3, n10, "u32_video_decode_fail", l10);
        object3 = this.E;
        n13 = 2035;
        n11 = TXCStatus.c((String)object3, n13);
        l10 = n11;
        object3 = "u32_audio_decode_fail";
        TXCDRApi.txSetEventIntValue(string3, n10, (String)object3, l10);
        TXCDRApi.nativeReportEvent(string3, n10);
        n10 = (int)(this.u ? 1 : 0);
        if (n10 != 0) {
            long l17 = this.y;
            l10 = 1L;
            this.y = l17 += l10;
            this.x = l17 = this.x + l11;
            l17 = this.w;
            long l18 = l11 - l17;
            n10 = (int)(l18 == 0L ? 0 : (l18 < 0L ? -1 : 1));
            if (n10 > 0) {
                this.w = l11;
            }
        }
    }

    private void f(String object) {
        String string2;
        int n10 = TextUtils.isEmpty((CharSequence)object);
        if (n10 == 0 && (n10 = ((String)object).startsWith(string2 = "room://")) != 0) {
            object = ((String)object).split("/");
            n10 = ((String[])object).length + -1;
            object = object[n10];
            string2 = "_";
            ((String)object).split(string2);
            object = this.E;
            n10 = 7112;
            long l10 = 3;
            Long l11 = l10;
            TXCStatus.a((String)object, n10, l11);
        }
    }

    private int g(String object) {
        HashMap hashMap = this.b;
        if ((object = (Number)hashMap.get(object)) != null) {
            return ((Number)object).intValue();
        }
        return 0;
    }

    public static /* synthetic */ HashMap g() {
        return D;
    }

    public static /* synthetic */ String h() {
        return a;
    }

    private void i() {
        this.a(6002, 6017, 6018);
        Object object = com.tencent.liteav.basic.util.g.a();
        Object object2 = this.E;
        object = object[0];
        int n10 = 9001;
        TXCStatus.a((String)object2, n10, object);
        this.a(n10, 9002, 9003);
        object = this.E;
        object2 = com.tencent.liteav.basic.util.g.b();
        n10 = 9004;
        TXCStatus.a((String)object, n10, object2);
        this.a(n10, 9005, 9006);
    }

    private int j() {
        int n10;
        long l10 = TXCTimeUtil.getTimeTick();
        String string2 = this.E;
        int n11 = 6019;
        int n12 = TXCStatus.c(string2, n11);
        long l11 = n12;
        long l12 = this.s;
        long l13 = 0L;
        long l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        long l15 = 1000L;
        if (l14 != false) {
            l12 = l10 - l12;
            long l16 = this.t;
            l16 = (l11 - l16) * l15 / l12;
            n10 = (int)l16;
        } else {
            l12 = this.A;
            l12 = l10 - l12;
            l15 = l15 * l11 / l12;
            n10 = (int)l15;
        }
        this.s = l10;
        this.t = l11;
        return n10;
    }

    private void k() {
        Object object = new HashMap();
        String string2 = TXCStatus.b(this.E, 7116);
        String string3 = this.E;
        int n10 = 7117;
        string3 = TXCStatus.b(string3, n10);
        Object object2 = TXCStatus.b(this.E, 7118);
        Object object3 = this.E;
        int n11 = 7105;
        int n12 = TXCStatus.c((String)object3, n11);
        Object object4 = TXCStatus.b(this.E, 7106);
        Object object5 = this.E;
        int n13 = 7111;
        int n14 = TXCStatus.c((String)object5, n13);
        object.put("stream_url", string2);
        object.put("stream_id", string3);
        object.put("bizid", object2);
        string2 = String.valueOf(n12);
        object.put("err_code", string2);
        object.put("err_info", object4);
        string2 = String.valueOf(n14);
        object.put("channel_type", string2);
        long l10 = System.currentTimeMillis();
        long l11 = this.v;
        l11 = l10 - l11;
        object5 = "yyyy-MM-dd HH:mm:ss:SSS";
        object4 = new SimpleDateFormat((String)object5);
        long l12 = this.v;
        Object object6 = new Date(l12);
        object4 = ((DateFormat)object4).format((Date)object6);
        object6 = "start_time";
        object.put(object6, object4);
        object4 = new SimpleDateFormat((String)object5);
        object5 = new Date(l10);
        string2 = ((DateFormat)object4).format((Date)object5);
        object.put("end_time", string2);
        string2 = String.valueOf(l11);
        string3 = "total_time";
        object.put(string3, string2);
        string2 = this.E;
        int n15 = 6003;
        l10 = TXCStatus.a(string2, n15);
        object2 = this.E;
        n12 = 6006;
        l11 = TXCStatus.a((String)object2, n12);
        object4 = this.E;
        n14 = 6005;
        long l13 = TXCStatus.a((String)object4, n14);
        long l14 = 0L;
        long l15 = l10 == l14 ? 0 : (l10 < l14 ? -1 : 1);
        l11 = l15 != false ? (l11 /= l10) : l14;
        string2 = String.valueOf(l10);
        object.put("block_count", string2);
        string2 = String.valueOf(l13);
        object.put("block_duration_max", string2);
        string2 = String.valueOf(l11);
        string3 = "block_duration_avg";
        object.put(string3, string2);
        l10 = this.y;
        n10 = (int)(l10 == l14 ? 0 : (l10 < l14 ? -1 : 1));
        l11 = n10 != 0 ? this.x / l10 : l14;
        l10 = this.w;
        string2 = String.valueOf(l10);
        object.put("jitter_cache_max", string2);
        string2 = String.valueOf(l11);
        string3 = "jitter_cache_avg";
        object.put(string3, string2);
        string2 = TXCDRApi.txCreateToken();
        n15 = com.tencent.liteav.basic.datareport.a.ag;
        n10 = com.tencent.liteav.basic.datareport.a.am;
        object3 = new TXCDRExtInfo();
        ((TXCDRExtInfo)object3).command_id_comment = "LINKMIC";
        TXCDRApi.InitEvent(this.h, string2, n15, n10, (TXCDRExtInfo)object3);
        object2 = a;
        object3 = new StringBuilder();
        object4 = "report evt 40402: token=";
        ((StringBuilder)object3).append((String)object4);
        ((StringBuilder)object3).append(string2);
        object3 = ((StringBuilder)object3).toString();
        TXCLog.d((String)object2, (String)object3);
        object = object.entrySet().iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            object2 = (Map.Entry)object.next();
            object3 = (String)object2.getKey();
            object2 = (String)object2.getValue();
            object4 = a;
            object5 = new StringBuilder();
            ((StringBuilder)object5).append("RealTimePlayStatisticInfo: ");
            ((StringBuilder)object5).append((String)object3);
            String string4 = " = ";
            ((StringBuilder)object5).append(string4);
            ((StringBuilder)object5).append((String)object2);
            object5 = ((StringBuilder)object5).toString();
            TXCLog.e((String)object4, (String)object5);
            if (object3 == null || (n11 = ((String)object3).length()) <= 0 || object2 == null) continue;
            TXCDRApi.txSetEventValue(string2, n15, (String)object3, (String)object2);
        }
        TXCDRApi.nativeReportEvent(string2, n15);
        this.u = false;
        this.v = l14;
        this.y = l14;
        this.x = l14;
        this.w = l14;
    }

    private void l() {
        Object object = new TXCDRExtInfo();
        ((TXCDRExtInfo)object).report_common = false;
        ((TXCDRExtInfo)object).report_status = false;
        Object object2 = this.c;
        ((TXCDRExtInfo)object).url = object2;
        long l10 = TXCStatus.a(this.E, 7013);
        String string2 = (String)this.b.get("token");
        Object object3 = this.h;
        int n10 = com.tencent.liteav.basic.datareport.a.P;
        int n11 = com.tencent.liteav.basic.datareport.a.am;
        TXCDRApi.InitEvent(object3, string2, n10, n11, (TXCDRExtInfo)object);
        long l11 = TXCTimeUtil.getUtcTimeTick();
        int n12 = com.tencent.liteav.basic.datareport.a.P;
        long l12 = TXCTimeUtil.getUtcTimeTick();
        String string3 = "u64_timestamp";
        TXCDRApi.txSetEventIntValue(string2, n12, string3, l12);
        n12 = com.tencent.liteav.basic.datareport.a.P;
        Object object4 = this.b;
        String string4 = "str_device_type";
        object4 = (String)((HashMap)object4).get(string4);
        TXCDRApi.txSetEventValue(string2, n12, string4, (String)object4);
        n12 = com.tencent.liteav.basic.datareport.a.P;
        object4 = "u32_network_type";
        long l13 = this.g((String)object4);
        TXCDRApi.txSetEventIntValue(string2, n12, (String)object4, l13);
        n12 = com.tencent.liteav.basic.datareport.a.P;
        String string5 = "u32_dns_time";
        long l14 = -1;
        TXCDRApi.txSetEventIntValue(string2, n12, string5, l14);
        n12 = com.tencent.liteav.basic.datareport.a.P;
        String string6 = "u32_connect_server_time";
        TXCDRApi.txSetEventIntValue(string2, n12, string6, l14);
        n12 = com.tencent.liteav.basic.datareport.a.P;
        String string7 = "u32_server_ip";
        TXCDRApi.txSetEventValue(string2, n12, string7, "");
        n12 = com.tencent.liteav.basic.datareport.a.P;
        int n13 = this.d << 16;
        int n14 = this.e;
        long l15 = n13 | n14;
        String string8 = "u32_video_resolution";
        TXCDRApi.txSetEventIntValue(string2, n12, string8, l15);
        n12 = com.tencent.liteav.basic.datareport.a.P;
        l15 = this.g;
        String string9 = string8;
        string8 = "u32_audio_samplerate";
        TXCDRApi.txSetEventIntValue(string2, n12, string8, l15);
        n12 = com.tencent.liteav.basic.datareport.a.P;
        l15 = this.f;
        String string10 = string8;
        string8 = "u32_video_bitrate";
        TXCDRApi.txSetEventIntValue(string2, n12, string8, l15);
        n12 = com.tencent.liteav.basic.datareport.a.P;
        Object object5 = this.b;
        String string11 = "str_user_id";
        object5 = (String)((HashMap)object5).get(string11);
        TXCDRApi.txSetEventValue(string2, n12, string11, (String)object5);
        n12 = com.tencent.liteav.basic.datareport.a.P;
        object5 = this.b;
        String string12 = string11;
        string11 = "str_package_name";
        object5 = (String)((HashMap)object5).get(string11);
        TXCDRApi.txSetEventValue(string2, n12, string11, (String)object5);
        n12 = com.tencent.liteav.basic.datareport.a.P;
        object5 = "u32_channel_type";
        TXCDRApi.txSetEventIntValue(string2, n12, (String)object5, l10);
        n12 = com.tencent.liteav.basic.datareport.a.P;
        object2 = this.i;
        Object object6 = "str_app_version";
        TXCDRApi.txSetEventValue(string2, n12, (String)object6, (String)object2);
        n12 = com.tencent.liteav.basic.datareport.a.P;
        object2 = this.b;
        String string13 = object6;
        object6 = "dev_uuid";
        object2 = (String)((HashMap)object2).get(object6);
        TXCDRApi.txSetEventValue(string2, n12, (String)object6, (String)object2);
        n12 = com.tencent.liteav.basic.datareport.a.P;
        TXCDRApi.nativeReportEvent(string2, n12);
        object = a;
        object2 = new StringBuilder();
        Object object7 = object;
        ((StringBuilder)object2).append("report evt 40001: token=");
        ((StringBuilder)object2).append(string2);
        object = " ";
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append("str_stream_url");
        string2 = "=";
        ((StringBuilder)object2).append(string2);
        String string14 = object6;
        object6 = this.c;
        ((StringBuilder)object2).append((String)object6);
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append(string3);
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(l11);
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append(string4);
        ((StringBuilder)object2).append(string2);
        object6 = this.b.get(string4);
        ((StringBuilder)object2).append(object6);
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append((String)object4);
        ((StringBuilder)object2).append(string2);
        int n15 = this.g((String)object4);
        ((StringBuilder)object2).append(n15);
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append(string5);
        object6 = "=-1 ";
        ((StringBuilder)object2).append((String)object6);
        ((StringBuilder)object2).append(string6);
        ((StringBuilder)object2).append((String)object6);
        ((StringBuilder)object2).append(string7);
        ((StringBuilder)object2).append("= ");
        object6 = string9;
        ((StringBuilder)object2).append(string9);
        ((StringBuilder)object2).append(string2);
        n15 = this.d << 16;
        int n16 = this.e;
        ((StringBuilder)object2).append(n15 |= n16);
        ((StringBuilder)object2).append((String)object);
        object6 = string10;
        ((StringBuilder)object2).append(string10);
        ((StringBuilder)object2).append(string2);
        n15 = this.g;
        ((StringBuilder)object2).append(n15);
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append(string8);
        ((StringBuilder)object2).append(string2);
        n15 = this.f;
        ((StringBuilder)object2).append(n15);
        ((StringBuilder)object2).append((String)object);
        object6 = string12;
        ((StringBuilder)object2).append(string12);
        ((StringBuilder)object2).append(string2);
        object6 = this.b.get(string12);
        ((StringBuilder)object2).append(object6);
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append(string11);
        ((StringBuilder)object2).append(string2);
        object6 = this.b.get(string11);
        ((StringBuilder)object2).append(object6);
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append((String)object5);
        ((StringBuilder)object2).append(string2);
        l11 = l10;
        ((StringBuilder)object2).append(l10);
        ((StringBuilder)object2).append((String)object);
        object6 = string13;
        ((StringBuilder)object2).append(string13);
        ((StringBuilder)object2).append(string2);
        object6 = this.b;
        object3 = string14;
        object6 = ((HashMap)object6).get(string14);
        ((StringBuilder)object2).append(object6);
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append(string14);
        ((StringBuilder)object2).append(string2);
        n12 = this.g("u32_max_load");
        ((StringBuilder)object2).append(n12);
        object = ((StringBuilder)object2).toString();
        object2 = object7;
        TXCLog.d((String)object7, (String)object);
    }

    private void m() {
        int n10;
        Object object;
        long l10;
        long l11;
        long l12;
        long l13;
        e e10 = this;
        Object object2 = new TXCDRExtInfo();
        int n11 = 0;
        ((TXCDRExtInfo)object2).report_common = false;
        ((TXCDRExtInfo)object2).report_status = false;
        Object object3 = this.c;
        ((TXCDRExtInfo)object2).url = object3;
        object3 = this.E;
        int n12 = 7012;
        object3 = TXCStatus.b((String)object3, n12);
        Object object4 = this.E;
        int n13 = 7009;
        long l14 = TXCStatus.a((String)object4, n13);
        String string2 = this.E;
        int n14 = 7010;
        long l15 = TXCStatus.a(string2, n14);
        long l16 = l15 - (l13 = (long)-1);
        Object object5 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object5 != false) {
            l15 -= l14;
        }
        if ((l12 = (l11 = (l10 = TXCStatus.a((String)(object = e10.E), n10 = 7011)) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false) {
            l10 -= l14;
        }
        l14 = TXCStatus.a(e10.E, 7013);
        String string3 = (String)e10.b.get("token");
        Object object6 = e10.h;
        int n15 = com.tencent.liteav.basic.datareport.a.P;
        int n16 = com.tencent.liteav.basic.datareport.a.am;
        TXCDRApi.InitEvent(object6, string3, n15, n16, (TXCDRExtInfo)object2);
        long l17 = TXCTimeUtil.getUtcTimeTick();
        int n17 = com.tencent.liteav.basic.datareport.a.P;
        object6 = "u64_timestamp";
        TXCDRApi.txSetEventIntValue(string3, n17, (String)object6, l17);
        n17 = com.tencent.liteav.basic.datareport.a.P;
        Object object7 = e10.b;
        String string4 = "str_device_type";
        object7 = (String)((HashMap)object7).get(string4);
        TXCDRApi.txSetEventValue(string3, n17, string4, (String)object7);
        n17 = com.tencent.liteav.basic.datareport.a.P;
        object7 = "u32_network_type";
        int n18 = e10.g((String)object7);
        String string5 = string4;
        long l18 = n18;
        TXCDRApi.txSetEventIntValue(string3, n17, (String)object7, l18);
        n17 = com.tencent.liteav.basic.datareport.a.P;
        string4 = "u32_dns_time";
        TXCDRApi.txSetEventIntValue(string3, n17, string4, l15);
        n17 = com.tencent.liteav.basic.datareport.a.P;
        String string6 = "u32_connect_server_time";
        TXCDRApi.txSetEventIntValue(string3, n17, string6, l10);
        n17 = com.tencent.liteav.basic.datareport.a.P;
        long l19 = l10;
        object = "u32_server_ip";
        TXCDRApi.txSetEventValue(string3, n17, (String)object, (String)object3);
        n17 = com.tencent.liteav.basic.datareport.a.P;
        n10 = e10.d << 16;
        String string7 = object3;
        n11 = e10.e | n10;
        String string8 = object;
        l10 = n11;
        object3 = "u32_video_resolution";
        TXCDRApi.txSetEventIntValue(string3, n17, (String)object3, l10);
        n17 = com.tencent.liteav.basic.datareport.a.P;
        l10 = e10.g;
        String string9 = object3;
        object3 = "u32_audio_samplerate";
        TXCDRApi.txSetEventIntValue(string3, n17, (String)object3, l10);
        n17 = com.tencent.liteav.basic.datareport.a.P;
        l10 = e10.f;
        String string10 = object3;
        object3 = "u32_video_bitrate";
        TXCDRApi.txSetEventIntValue(string3, n17, (String)object3, l10);
        n17 = com.tencent.liteav.basic.datareport.a.P;
        object = e10.b;
        String string11 = "str_user_id";
        object = (String)((HashMap)object).get(string11);
        TXCDRApi.txSetEventValue(string3, n17, string11, (String)object);
        n17 = com.tencent.liteav.basic.datareport.a.P;
        object = e10.b;
        String string12 = string11;
        string11 = "str_package_name";
        object = (String)((HashMap)object).get(string11);
        TXCDRApi.txSetEventValue(string3, n17, string11, (String)object);
        n17 = com.tencent.liteav.basic.datareport.a.P;
        object = "u32_channel_type";
        TXCDRApi.txSetEventIntValue(string3, n17, (String)object, l14);
        n17 = com.tencent.liteav.basic.datareport.a.P;
        object4 = e10.i;
        String string13 = "str_app_version";
        TXCDRApi.txSetEventValue(string3, n17, string13, (String)object4);
        n17 = com.tencent.liteav.basic.datareport.a.P;
        object4 = e10.b;
        String string14 = string13;
        string13 = "dev_uuid";
        object4 = (String)((HashMap)object4).get(string13);
        TXCDRApi.txSetEventValue(string3, n17, string13, (String)object4);
        object2 = TXCStatus.b(e10.E, 7019);
        n12 = com.tencent.liteav.basic.datareport.a.P;
        String string15 = string13;
        TXCDRApi.txSetEventValue(string3, n12, "str_nearest_ip_list", (String)object2);
        n17 = com.tencent.liteav.basic.datareport.a.P;
        TXCDRApi.nativeReportEvent(string3, n17);
        object2 = a;
        object4 = new StringBuilder();
        ((StringBuilder)object4).append("report evt 40001: token=");
        ((StringBuilder)object4).append(string3);
        string13 = " ";
        ((StringBuilder)object4).append(string13);
        ((StringBuilder)object4).append("str_stream_url");
        string3 = "=";
        ((StringBuilder)object4).append(string3);
        Object object8 = object2;
        object2 = e10.c;
        ((StringBuilder)object4).append((String)object2);
        ((StringBuilder)object4).append(string13);
        ((StringBuilder)object4).append((String)object6);
        ((StringBuilder)object4).append(string3);
        ((StringBuilder)object4).append(l17);
        ((StringBuilder)object4).append(string13);
        object2 = string5;
        ((StringBuilder)object4).append(string5);
        ((StringBuilder)object4).append(string3);
        object2 = e10.b.get(string5);
        ((StringBuilder)object4).append(object2);
        ((StringBuilder)object4).append(string13);
        ((StringBuilder)object4).append((String)object7);
        ((StringBuilder)object4).append(string3);
        n17 = e10.g((String)object7);
        ((StringBuilder)object4).append(n17);
        ((StringBuilder)object4).append(string13);
        ((StringBuilder)object4).append(string4);
        ((StringBuilder)object4).append(string3);
        ((StringBuilder)object4).append(l15);
        ((StringBuilder)object4).append(string13);
        ((StringBuilder)object4).append(string6);
        ((StringBuilder)object4).append(string3);
        l15 = l19;
        ((StringBuilder)object4).append(l19);
        ((StringBuilder)object4).append(string13);
        object2 = string8;
        ((StringBuilder)object4).append(string8);
        ((StringBuilder)object4).append(string3);
        object2 = string7;
        ((StringBuilder)object4).append(string7);
        ((StringBuilder)object4).append(string13);
        object2 = string9;
        ((StringBuilder)object4).append(string9);
        ((StringBuilder)object4).append(string3);
        n17 = e10.d << 16;
        int n19 = e10.e;
        ((StringBuilder)object4).append(n17 |= n19);
        ((StringBuilder)object4).append(string13);
        object2 = string10;
        ((StringBuilder)object4).append(string10);
        ((StringBuilder)object4).append(string3);
        n17 = e10.g;
        ((StringBuilder)object4).append(n17);
        ((StringBuilder)object4).append(string13);
        ((StringBuilder)object4).append((String)object3);
        ((StringBuilder)object4).append(string3);
        n17 = e10.f;
        ((StringBuilder)object4).append(n17);
        ((StringBuilder)object4).append(string13);
        object2 = string12;
        ((StringBuilder)object4).append(string12);
        ((StringBuilder)object4).append(string3);
        object2 = e10.b.get(string12);
        ((StringBuilder)object4).append(object2);
        ((StringBuilder)object4).append(string13);
        ((StringBuilder)object4).append(string11);
        ((StringBuilder)object4).append(string3);
        object2 = e10.b.get(string11);
        ((StringBuilder)object4).append(object2);
        ((StringBuilder)object4).append(string13);
        ((StringBuilder)object4).append((String)object);
        ((StringBuilder)object4).append(string3);
        ((StringBuilder)object4).append(l14);
        ((StringBuilder)object4).append(string13);
        object2 = string14;
        ((StringBuilder)object4).append(string14);
        ((StringBuilder)object4).append(string3);
        object2 = e10.b;
        object3 = string15;
        object2 = ((HashMap)object2).get(string15);
        ((StringBuilder)object4).append(object2);
        ((StringBuilder)object4).append(string13);
        ((StringBuilder)object4).append(string15);
        ((StringBuilder)object4).append(string3);
        n17 = e10.g("u32_max_load");
        ((StringBuilder)object4).append(n17);
        object2 = ((StringBuilder)object4).toString();
        object3 = object8;
        TXCLog.d((String)object8, (String)object2);
    }

    private void n() {
        Object object = new TXCDRExtInfo();
        ((TXCDRExtInfo)object).report_common = false;
        ((TXCDRExtInfo)object).report_status = false;
        Object object2 = this.c;
        ((TXCDRExtInfo)object).url = object2;
        long l10 = TXCStatus.a(this.E, 7009);
        long l11 = TXCStatus.a(this.E, 7013);
        String string2 = (String)this.b.get("token");
        Context context = this.h;
        int n10 = com.tencent.liteav.basic.datareport.a.R;
        int n11 = com.tencent.liteav.basic.datareport.a.am;
        TXCDRApi.InitEvent(context, string2, n10, n11, (TXCDRExtInfo)object);
        long l12 = TXCTimeUtil.getUtcTimeTick();
        int n12 = com.tencent.liteav.basic.datareport.a.R;
        String string3 = "u64_timestamp";
        TXCDRApi.txSetEventIntValue(string2, n12, string3, l12);
        long l13 = (TXCTimeUtil.getTimeTick() - l10) / 1000L;
        n12 = com.tencent.liteav.basic.datareport.a.R;
        object2 = "u32_result";
        TXCDRApi.txSetEventIntValue(string2, n12, (String)object2, l13);
        n12 = com.tencent.liteav.basic.datareport.a.R;
        Object object3 = this.b;
        String string4 = "str_user_id";
        object3 = (String)((HashMap)object3).get(string4);
        TXCDRApi.txSetEventValue(string2, n12, string4, (String)object3);
        n12 = com.tencent.liteav.basic.datareport.a.R;
        object3 = this.b;
        String string5 = "str_package_name";
        object3 = (String)((HashMap)object3).get(string5);
        TXCDRApi.txSetEventValue(string2, n12, string5, (String)object3);
        n12 = com.tencent.liteav.basic.datareport.a.R;
        object3 = "u32_channel_type";
        TXCDRApi.txSetEventIntValue(string2, n12, (String)object3, l11);
        n12 = com.tencent.liteav.basic.datareport.a.R;
        Object object4 = this.i;
        String string6 = "str_app_version";
        TXCDRApi.txSetEventValue(string2, n12, string6, (String)object4);
        n12 = com.tencent.liteav.basic.datareport.a.R;
        object4 = this.b;
        String string7 = string6;
        string6 = "dev_uuid";
        object4 = (String)((HashMap)object4).get(string6);
        TXCDRApi.txSetEventValue(string2, n12, string6, (String)object4);
        n12 = TXCStatus.c(this.E, 7016);
        int n13 = com.tencent.liteav.basic.datareport.a.R;
        object = String.valueOf(n12);
        String string8 = string6;
        TXCDRApi.txSetEventValue(string2, n13, "u32_ip_count_quic", (String)object);
        n12 = TXCStatus.c(this.E, 7017);
        n13 = com.tencent.liteav.basic.datareport.a.R;
        object = String.valueOf(n12);
        TXCDRApi.txSetEventValue(string2, n13, "u32_connect_count_quic", (String)object);
        n12 = TXCStatus.c(this.E, 7018);
        n13 = com.tencent.liteav.basic.datareport.a.R;
        object = String.valueOf(n12);
        TXCDRApi.txSetEventValue(string2, n13, "u32_connect_count_tcp", (String)object);
        n12 = com.tencent.liteav.basic.datareport.a.R;
        TXCDRApi.nativeReportEvent(string2, n12);
        object = a;
        object4 = new StringBuilder();
        ((StringBuilder)object4).append("report evt 40002: token=");
        ((StringBuilder)object4).append(string2);
        string2 = " ";
        ((StringBuilder)object4).append(string2);
        ((StringBuilder)object4).append("str_stream_url");
        string6 = "=";
        ((StringBuilder)object4).append(string6);
        Object object5 = object;
        object = this.c;
        ((StringBuilder)object4).append((String)object);
        ((StringBuilder)object4).append(string2);
        ((StringBuilder)object4).append(string3);
        ((StringBuilder)object4).append(string6);
        ((StringBuilder)object4).append(l12);
        ((StringBuilder)object4).append(string2);
        ((StringBuilder)object4).append((String)object2);
        ((StringBuilder)object4).append(string6);
        ((StringBuilder)object4).append(l13);
        ((StringBuilder)object4).append(string2);
        ((StringBuilder)object4).append(string4);
        ((StringBuilder)object4).append(string6);
        object = this.b.get(string4);
        ((StringBuilder)object4).append(object);
        ((StringBuilder)object4).append(string2);
        ((StringBuilder)object4).append(string5);
        ((StringBuilder)object4).append(string6);
        object = this.b.get(string5);
        ((StringBuilder)object4).append(object);
        ((StringBuilder)object4).append(string2);
        ((StringBuilder)object4).append((String)object3);
        ((StringBuilder)object4).append(string6);
        ((StringBuilder)object4).append(l11);
        ((StringBuilder)object4).append(string2);
        object = string7;
        ((StringBuilder)object4).append(string7);
        ((StringBuilder)object4).append(string6);
        object = this.i;
        ((StringBuilder)object4).append((String)object);
        ((StringBuilder)object4).append(string2);
        object = string8;
        ((StringBuilder)object4).append(string8);
        ((StringBuilder)object4).append(string6);
        object = this.b.get(string8);
        ((StringBuilder)object4).append(object);
        object = ((StringBuilder)object4).toString();
        object2 = object5;
        TXCLog.d((String)object5, (String)object);
    }

    private void o() {
        Object object = new TXCDRExtInfo();
        ((TXCDRExtInfo)object).report_common = false;
        Object object2 = 1;
        ((TXCDRExtInfo)object).report_status = object2;
        Object object3 = this.c;
        ((TXCDRExtInfo)object).url = object3;
        object3 = com.tencent.liteav.basic.util.g.a();
        Object object4 = object3[0];
        object2 = object3[object2];
        int n10 = com.tencent.liteav.basic.util.g.b();
        long l10 = TXCStatus.a(this.E, 7013);
        int n11 = TXCStatus.c(this.E, 7004);
        int n12 = TXCStatus.c(this.E, 7003);
        double d10 = TXCStatus.d(this.E, 4001);
        int n13 = TXCStatus.c(this.E, 7005);
        int n14 = TXCStatus.c(this.E, 7002);
        int n15 = TXCStatus.c(this.E, 7001);
        int n16 = TXCStatus.c(this.E, 4007);
        String string2 = this.E;
        int n17 = n16;
        String string3 = TXCStatus.b(string2, 7012);
        string2 = this.E;
        String string4 = string3;
        string3 = TXCStatus.b(string2, 7014);
        string2 = this.E;
        String string5 = string3;
        string3 = TXCStatus.b(string2, 7015);
        string2 = this.E;
        String string6 = string3;
        string3 = TXCStatus.b(string2, 3001);
        string2 = this.E;
        String string7 = string3;
        long l11 = TXCStatus.a(string2, 3002);
        double d11 = TXCStatus.d(this.E, 3003);
        n16 = TXCStatus.c(this.E, 7020);
        string3 = (String)this.b.get("token");
        string2 = this.h;
        int n18 = com.tencent.liteav.basic.datareport.a.Q;
        long l12 = l10;
        int n19 = com.tencent.liteav.basic.datareport.a.am;
        TXCDRApi.InitEvent((Context)string2, string3, n18, n19, (TXCDRExtInfo)object);
        n18 = com.tencent.liteav.basic.datareport.a.Q;
        l10 = n14;
        TXCDRApi.txSetEventIntValue(string3, n18, "u32_avg_audio_bitrate", l10);
        n18 = com.tencent.liteav.basic.datareport.a.Q;
        l10 = n15;
        TXCDRApi.txSetEventIntValue(string3, n18, "u32_avg_video_bitrate", l10);
        n18 = com.tencent.liteav.basic.datareport.a.Q;
        l10 = n12 + n11;
        TXCDRApi.txSetEventIntValue(string3, n18, "u32_avg_net_speed", l10);
        n18 = com.tencent.liteav.basic.datareport.a.Q;
        l10 = (int)d10;
        TXCDRApi.txSetEventIntValue(string3, n18, "u32_fps", l10);
        n18 = com.tencent.liteav.basic.datareport.a.Q;
        l10 = n13;
        TXCDRApi.txSetEventIntValue(string3, n18, "u32_avg_cache_size", l10);
        n18 = com.tencent.liteav.basic.datareport.a.Q;
        l10 = object2;
        TXCDRApi.txSetEventIntValue(string3, n18, "u32_cpu_usage", l10);
        n18 = com.tencent.liteav.basic.datareport.a.Q;
        long l13 = (long)object4;
        TXCDRApi.txSetEventIntValue(string3, n18, "u32_app_cpu_usage", l13);
        n18 = com.tencent.liteav.basic.datareport.a.Q;
        l13 = n10;
        TXCDRApi.txSetEventIntValue(string3, n18, "u32_avg_memory", l13);
        n18 = com.tencent.liteav.basic.datareport.a.Q;
        long l14 = l12;
        TXCDRApi.txSetEventIntValue(string3, n18, "u32_channel_type", l12);
        n18 = com.tencent.liteav.basic.datareport.a.Q;
        object = this;
        Object object5 = this.i;
        TXCDRApi.txSetEventValue(string3, n18, "str_app_version", (String)object5);
        n18 = com.tencent.liteav.basic.datareport.a.Q;
        object5 = this.b;
        String string8 = "str_device_type";
        object5 = (String)((HashMap)object5).get(string8);
        TXCDRApi.txSetEventValue(string3, n18, string8, (String)object5);
        n18 = com.tencent.liteav.basic.datareport.a.Q;
        object4 = n17;
        l14 = n17;
        TXCDRApi.txSetEventIntValue(string3, n18, "u32_hw_enc", l14);
        n18 = com.tencent.liteav.basic.datareport.a.Q;
        string8 = string4;
        TXCDRApi.txSetEventValue(string3, n18, "str_server_ip", string4);
        n18 = com.tencent.liteav.basic.datareport.a.Q;
        string8 = string5;
        TXCDRApi.txSetEventValue(string3, n18, "str_quic_connection_id", string5);
        n18 = com.tencent.liteav.basic.datareport.a.Q;
        string8 = string6;
        TXCDRApi.txSetEventValue(string3, n18, "str_quic_connection_stats", string6);
        n18 = com.tencent.liteav.basic.datareport.a.Q;
        string8 = string7;
        TXCDRApi.txSetEventValue(string3, n18, "str_beauty_stats", string7);
        n18 = com.tencent.liteav.basic.datareport.a.Q;
        object4 = n16;
        l14 = n16;
        TXCDRApi.txSetEventIntValue(string3, n18, "u32_send_strategy", l14);
        n18 = com.tencent.liteav.basic.datareport.a.Q;
        TXCDRApi.txSetEventIntValue(string3, n18, "u32_preprocess_timecost", l11);
        n18 = com.tencent.liteav.basic.datareport.a.Q;
        l14 = (int)d11;
        TXCDRApi.txSetEventIntValue(string3, n18, "u32_preprocess_fps_out", l14);
        n18 = com.tencent.liteav.basic.datareport.a.Q;
        TXCDRApi.nativeReportEvent(string3, n18);
    }

    private void p() {
        long l10;
        long l11;
        this.p = false;
        this.q = l11 = 0L;
        this.B = 0;
        Object object = this.F;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            object = TXCCommonUtil.getUserId();
        }
        if (bl2 = TextUtils.isEmpty((CharSequence)object)) {
            object = com.tencent.liteav.basic.util.g.b(this.h);
        }
        this.b.put("str_user_id", object);
        object = this.b;
        Object object2 = com.tencent.liteav.basic.util.g.c();
        Object object3 = "str_device_type";
        ((HashMap)object).put(object3, object2);
        object = this.b;
        object2 = com.tencent.liteav.basic.util.g.c();
        ((HashMap)object).put(object3, object2);
        object = this.b;
        object2 = com.tencent.liteav.basic.util.g.d(this.h);
        ((HashMap)object).put("u32_network_type", object2);
        object = this.b;
        object2 = com.tencent.liteav.basic.util.g.e();
        ((HashMap)object).put("token", object2);
        object = this.b;
        object2 = com.tencent.liteav.basic.util.g.c(this.h);
        ((HashMap)object).put("str_package_name", object2);
        object = this.b;
        object2 = com.tencent.liteav.basic.util.g.e(this.h);
        ((HashMap)object).put("dev_uuid", object2);
        object = this.b;
        object2 = com.tencent.liteav.basic.util.g.d();
        ((HashMap)object).put("str_os_info", object2);
        this.z = l10 = TXCTimeUtil.getUtcTimeTick();
        object3 = this.b;
        object = l10;
        ((HashMap)object3).put("u64_timestamp", object);
        this.A = l10 = TXCTimeUtil.getTimeTick();
    }

    public void a() {
        long l10;
        this.p();
        this.k = l10 = (long)-1;
        this.o = l10;
        this.l = l10 = 0L;
        this.m = l10;
        this.n = l10;
        this.v = l10 = System.currentTimeMillis();
    }

    public void a(int n10) {
        this.f = n10;
    }

    public void a(int n10, int n11) {
        this.d = n10;
        this.e = n11;
    }

    public void a(int n10, int n11, int n12) {
        double d10 = 0.001;
        int n13 = 6002;
        if (n10 == n13) {
            String string2 = this.E;
            double d11 = TXCStatus.d(string2, n10);
            double d12 = d11 - d10;
            if ((n10 = (int)(d12 == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1))) < 0) {
                return;
            }
            d10 = TXCStatus.d(this.E, n11);
            n10 = TXCStatus.c(this.E, n12) + 1;
            d11 -= d10;
            double d13 = n10;
            string2 = this.E;
            Double d14 = d10 += (d11 /= d13);
            TXCStatus.a(string2, n11, d14);
            String string3 = this.E;
            Integer n14 = n10;
            TXCStatus.a(string3, n12, n14);
        } else {
            String string4 = this.E;
            double d15 = TXCStatus.c(string4, n10);
            double d16 = d15 - d10;
            if ((n10 = (int)(d16 == 0.0 ? 0 : (d16 < 0.0 ? -1 : 1))) < 0) {
                return;
            }
            d10 = TXCStatus.d(this.E, n11);
            n10 = TXCStatus.c(this.E, n12) + 1;
            d15 -= d10;
            double d17 = n10;
            string4 = this.E;
            Double d18 = d10 += (d15 /= d17);
            TXCStatus.a(string4, n11, d18);
            String string5 = this.E;
            Integer n15 = n10;
            TXCStatus.a(string5, n12, n15);
        }
    }

    public void a(String string2) {
        this.c = string2;
        this.b(string2);
    }

    public void a(boolean bl2) {
        this.u = bl2;
    }

    public void b() {
        boolean bl2 = this.p;
        if (bl2) {
            this.n();
        } else {
            String string2 = a;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("push ");
            String string3 = this.c;
            charSequence.append(string3);
            string3 = " failed!";
            charSequence.append(string3);
            charSequence = charSequence.toString();
            TXCLog.e(string2, (String)charSequence);
            this.l();
        }
    }

    public void b(int n10) {
        this.g = n10;
    }

    public void b(String string2) {
        if (string2 == null) {
            return;
        }
        this.C = string2;
    }

    public void c() {
        Object object;
        Object object2;
        int n10 = this.p;
        if (n10 != 0) {
            n10 = this.u;
            if (n10 != 0) {
                n10 = com.tencent.liteav.basic.datareport.a.Y;
                this.e(n10);
            } else {
                e$a e$a;
                object2 = this.d();
                if (object2 != (e$a = e$a.c)) {
                    n10 = com.tencent.liteav.basic.datareport.a.V;
                    this.e(n10);
                }
            }
            n10 = (int)(this.u ? 1 : 0);
            if (n10 != 0) {
                n10 = com.tencent.liteav.basic.datareport.a.Z;
                this.d(n10);
            } else {
                n10 = com.tencent.liteav.basic.datareport.a.W;
                this.d(n10);
            }
        } else {
            object2 = a;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("play ");
            object = this.c;
            charSequence.append((String)object);
            object = " failed";
            charSequence.append((String)object);
            charSequence = charSequence.toString();
            TXCLog.e(object2, (String)charSequence);
            n10 = (int)(this.u ? 1 : 0);
            if (n10 != 0) {
                n10 = com.tencent.liteav.basic.datareport.a.X;
                this.c(n10);
            } else {
                n10 = com.tencent.liteav.basic.datareport.a.U;
                this.c(n10);
            }
        }
        n10 = (int)(this.u ? 1 : 0);
        if (n10 != 0) {
            this.k();
        }
        object2 = this.E;
        long l10 = 0L;
        Long l11 = l10;
        TXCStatus.a(object2, 7107, l11);
        object2 = this.E;
        l11 = l10;
        TXCStatus.a(object2, 2033, l11);
        object2 = this.E;
        l11 = l10;
        TXCStatus.a(object2, 6001, l11);
        object2 = this.E;
        l11 = l10;
        TXCStatus.a(object2, 7104, l11);
        object2 = this.E;
        object = l10;
        TXCStatus.a(object2, 7108, object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public e$a d() {
        try {
            boolean bl2;
            Object object = this.C;
            object = Uri.parse((String)object);
            if (object == null) {
                return e$a.a;
            }
            String string2 = object.getHost();
            boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
            if (bl3) {
                return e$a.a;
            }
            String string3 = object.getScheme();
            if (string3 == null) {
                return e$a.a;
            }
            String string4 = "rtmp";
            boolean bl4 = string3.equals(string4);
            if (!(bl4 || (bl4 = string3.equals(string4 = "http")) || (bl3 = string3.equals(string4 = "https")))) {
                return e$a.a;
            }
            bl3 = com.tencent.liteav.e.c(string2);
            if (bl3) {
                return e$a.b;
            }
            if ((object = object.getQueryParameterNames()) != null) {
                String string5 = "bizid";
                bl3 = object.contains(string5);
                if (bl3) return e$a.b;
                String string6 = "txTime";
                bl3 = object.contains(string6);
                if (bl3) return e$a.b;
                String string7 = "txSecret";
                bl2 = object.contains(string7);
                if (bl2) {
                    return e$a.b;
                }
            }
            if (bl2 = ((HashMap)(object = D)).containsKey(string2)) {
                object = D;
                object = ((HashMap)object).get(string2);
                return (e$a)((Object)object);
            }
            object = D;
            e$a e$a = e$a.a;
            ((HashMap)object).put(string2, e$a);
            e$1 e$1 = new e$1(this, string2);
            object = new Thread(e$1);
            ((Thread)object).start();
            return e$a.a;
        }
        catch (Exception exception) {
            String string8 = a;
            String string9 = "check stream failed.";
            TXCLog.e(string8, string9, exception);
        }
        return e$a.a;
    }

    public void d(String string2) {
        this.E = string2;
    }

    public void e() {
        long l10;
        long l11;
        long l12;
        int n10 = this.p;
        if (n10 == 0) {
            String string2 = this.E;
            int n11 = 7012;
            n10 = (int)(TextUtils.isEmpty((CharSequence)(string2 = TXCStatus.b(string2, n11))) ? 1 : 0);
            if (n10 == 0) {
                this.m();
                n10 = 1;
                this.p = n10;
            }
        }
        if ((n10 = (l12 = (l11 = this.q) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) <= 0) {
            this.q = l11 = TXCTimeUtil.getTimeTick();
        }
        if ((n10 = (int)(this.p ? 1 : 0)) != 0) {
            l11 = TXCTimeUtil.getTimeTick();
            l10 = this.q;
            long l13 = (l11 -= l10) - (l10 = 5000L);
            n10 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
            if (n10 > 0) {
                this.o();
                this.q = l11 = TXCTimeUtil.getTimeTick();
            }
        }
    }

    public void e(String string2) {
        this.F = string2;
    }

    public void f() {
        long l10;
        int n10;
        Object object;
        this.i();
        int n11 = this.p;
        int n12 = 1;
        int n13 = 5000;
        long l11 = 0L;
        if (n11 == 0) {
            object = this.E;
            n10 = 6001;
            l10 = TXCStatus.a(object, n10);
            object = this.E;
            int n14 = 7104;
            long l12 = TXCStatus.a(object, n14);
            object = this.E;
            int n15 = 2033;
            long l13 = TXCStatus.a(object, n15);
            object = this.E;
            int n16 = 7108;
            long l14 = TXCStatus.a(object, n16);
            n11 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
            if (n11 > 0 && (n11 = (int)(l12 == l11 ? 0 : (l12 < l11 ? -1 : 1))) > 0 && (n11 = (int)(l14 == l11 ? 0 : (l14 < l11 ? -1 : 1))) > 0 && (n11 = (int)(l13 == l11 ? 0 : (l13 < l11 ? -1 : 1))) > 0) {
                n11 = (int)(this.u ? 1 : 0);
                n11 = n11 != 0 ? com.tencent.liteav.basic.datareport.a.X : com.tencent.liteav.basic.datareport.a.U;
                this.c(n11);
                this.r = n13;
                this.p = n12;
            }
            object = this.E;
            n10 = 7119;
            if ((object = TXCStatus.b(object, n10)) != null) {
                this.b((String)object);
            }
        }
        if ((n11 = this.B) >= (n10 = 3) && (n11 = (int)(this.p ? 1 : 0)) == 0) {
            n11 = (int)(this.u ? 1 : 0);
            n11 = n11 != 0 ? com.tencent.liteav.basic.datareport.a.X : com.tencent.liteav.basic.datareport.a.U;
            this.c(n11);
            this.r = n13;
            this.p = n12;
        }
        this.B = n11 = this.B + n12;
        long l15 = this.q;
        long l16 = l15 - l11;
        n11 = (int)(l16 == 0L ? 0 : (l16 < 0L ? -1 : 1));
        if (n11 <= 0) {
            this.q = l15 = TXCTimeUtil.getTimeTick();
        }
        l15 = TXCTimeUtil.getTimeTick();
        l11 = this.q;
        n10 = this.r;
        l10 = n10;
        long l17 = l15 - (l11 += l10);
        n11 = (int)(l17 == 0L ? 0 : (l17 < 0L ? -1 : 1));
        if (n11 > 0) {
            n11 = (int)(this.u ? 1 : 0);
            if (n11 != 0) {
                n11 = com.tencent.liteav.basic.datareport.a.Y;
                this.e(n11);
                this.r = n13;
            } else {
                e$a e$a;
                object = this.d();
                if (object == (e$a = e$a.c)) {
                    return;
                }
                n11 = com.tencent.liteav.basic.datareport.a.V;
                this.e(n11);
                this.r = n11 = TXCDRApi.getStatusReportInterval();
                if (n11 < n13) {
                    this.r = n13;
                }
                if ((n11 = this.r) > (n12 = 300000)) {
                    this.r = n12;
                }
            }
            this.k = l15 = TXCStatus.a(this.E, 6004);
            object = this.E;
            n12 = 2002;
            n11 = TXCStatus.c(object, n12);
            this.o = l15 = (long)n11;
            this.q = l15 = TXCTimeUtil.getTimeTick();
        }
    }
}

