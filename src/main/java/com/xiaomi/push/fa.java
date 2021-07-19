/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.Config$Builder;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.manager.ClientReportClient;
import com.xiaomi.push.ey;
import com.xiaomi.push.ez;
import com.xiaomi.push.fa$a;
import com.xiaomi.push.fg;
import com.xiaomi.push.hm;
import com.xiaomi.push.hq;
import com.xiaomi.push.hr;
import com.xiaomi.push.hw;
import com.xiaomi.push.service.ak;
import com.xiaomi.push.service.bi;
import com.xiaomi.push.service.bj;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class fa {
    private static fa$a a;
    private static Map a;

    public static int a(int n10) {
        n10 = n10 > 0 ? (n10 += 1000) : -1;
        return n10;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int a(Enum enum_) {
        if (enum_ == null) return -1;
        boolean bl2 = enum_ instanceof hm;
        if (bl2) {
            return enum_.ordinal() + 1001;
        }
        bl2 = enum_ instanceof hw;
        if (bl2) {
            return enum_.ordinal() + 2001;
        }
        bl2 = enum_ instanceof fg;
        if (!bl2) return -1;
        return enum_.ordinal() + 3001;
    }

    public static Config a(Context context) {
        Object object = ak.a(context);
        int bl2 = hr.aA.a();
        boolean bl3 = ((ak)object).a(bl2, false);
        Object object2 = ak.a(context);
        int n10 = hr.aU.a();
        boolean bl4 = ((ak)object2).a(n10, false);
        ak ak2 = ak.a(context);
        n10 = hr.aC.a();
        int n11 = 86400;
        int n12 = ak2.a(n10, n11);
        ak ak3 = ak.a(context);
        int n13 = hr.aB.a();
        n10 = ak3.a(n13, n11);
        object2 = Config.getBuilder().setEventUploadSwitchOpen(bl4);
        long l10 = n10;
        object = ((Config$Builder)object2).setEventUploadFrequency(l10).setPerfUploadSwitchOpen(bl3);
        long l11 = n12;
        return ((Config$Builder)object).setPerfUploadFrequency(l11).build(context);
    }

    public static EventClientReport a(Context object, String string2, String string3, int n10, long l10, String string4) {
        object = fa.a(string2);
        object.eventId = string3;
        object.eventType = n10;
        object.eventTime = l10;
        object.eventContent = string4;
        return object;
    }

    public static EventClientReport a(String string2) {
        EventClientReport eventClientReport = new EventClientReport();
        eventClientReport.production = 1000;
        eventClientReport.reportType = 1001;
        eventClientReport.clientInterfaceId = string2;
        return eventClientReport;
    }

    public static PerfClientReport a() {
        int n10;
        PerfClientReport perfClientReport = new PerfClientReport();
        perfClientReport.production = n10 = 1000;
        perfClientReport.reportType = n10;
        perfClientReport.clientInterfaceId = "P100000";
        return perfClientReport;
    }

    public static PerfClientReport a(Context object, int n10, long l10, long l11) {
        object = fa.a();
        object.code = n10;
        object.perfCounts = l10;
        object.perfLatencies = l11;
        return object;
    }

    public static hq a(Context object, String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return null;
        }
        hq hq2 = new hq();
        hq2.d("category_client_report_data");
        hq2.a("push_sdk_channel");
        hq2.a(1L);
        hq2.b(string2);
        hq2.a(true);
        long l10 = System.currentTimeMillis();
        hq2.b(l10);
        object = object.getPackageName();
        hq2.g((String)object);
        hq2.e("com.xiaomi.xmsf");
        object = bi.a();
        hq2.f((String)object);
        hq2.c("quality_support");
        return hq2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static hw a(String object) {
        Object object2 = a;
        if (object2 == null) {
            object2 = hw.class;
            synchronized (object2) {
                hw[] hwArray = a;
                if (hwArray == null) {
                    String string2;
                    a = hwArray = new HashMap();
                    hwArray = hw.values();
                    int n10 = hwArray.length;
                    for (int n11 = 0; n11 < n10; string2 = string2.toLowerCase(), ++n11) {
                        hw hw2 = hwArray[n11];
                        Map map = a;
                        string2 = hw2.a;
                        map.put(string2, hw2);
                    }
                }
            }
        }
        object2 = a;
        object = object.toLowerCase();
        if ((object = (hw)((Object)object2.get(object))) == null) return hw.a;
        return object;
    }

    public static String a(int n10) {
        int n11 = 1000;
        if (n10 == n11) {
            return "E100000";
        }
        n11 = 3000;
        if (n10 == n11) {
            return "E100002";
        }
        n11 = 2000;
        if (n10 == n11) {
            return "E100001";
        }
        n11 = 6000;
        if (n10 == n11) {
            return "E100003";
        }
        return "";
    }

    public static void a(Context context) {
        Config config = fa.a(context);
        ClientReportClient.updateConfig(context, config);
    }

    public static void a(Context context, Config config) {
        ey ey2 = new ey(context);
        ez ez2 = new ez(context);
        ClientReportClient.init(context, config, ey2, ez2);
    }

    private static void a(Context context, hq hq2) {
        Object object = context.getApplicationContext();
        boolean bl2 = fa.a((Context)object);
        if (bl2) {
            context = context.getApplicationContext();
            bj.a(context, hq2);
        } else {
            object = a;
            if (object != null) {
                object.uploader(context, hq2);
            }
        }
    }

    public static void a(Context object, List object2) {
        if (object2 == null) {
            return;
        }
        try {
            object2 = object2.iterator();
        }
        catch (Throwable throwable) {
            object = throwable.getMessage();
            b.d((String)object);
        }
        while (true) {
            boolean bl2 = object2.hasNext();
            if (!bl2) break;
            Object object3 = object2.next();
            object3 = (String)object3;
            object3 = fa.a(object, object3);
            boolean bl3 = false;
            bl3 = bi.a(object3, false);
            if (bl3) continue;
            fa.a(object, object3);
            continue;
            break;
        }
    }

    public static void a(fa$a fa$a) {
        a = fa$a;
    }

    public static boolean a(Context object) {
        boolean bl2;
        String string2;
        boolean bl3;
        if (object != null && !(bl3 = TextUtils.isEmpty((CharSequence)(string2 = object.getPackageName()))) && (bl2 = (string2 = "com.xiaomi.xmsf").equals(object = object.getPackageName()))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }
}

