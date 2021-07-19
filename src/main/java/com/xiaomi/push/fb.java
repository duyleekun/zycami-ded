/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.data.a;
import com.xiaomi.clientreport.manager.ClientReportClient;
import com.xiaomi.push.fa;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class fb {
    private static volatile fb a;
    private Context a;

    private fb(Context context) {
        this.a = context;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static fb a(Context context) {
        Object object = a;
        if (object != null) return a;
        object = fb.class;
        synchronized (object) {
            fb fb2 = a;
            if (fb2 != null) return a;
            a = fb2 = new fb(context);
            return a;
        }
    }

    private void a(a a10) {
        boolean bl2 = a10 instanceof PerfClientReport;
        if (bl2) {
            Context context = this.a;
            a10 = (PerfClientReport)a10;
            ClientReportClient.reportPerf(context, (PerfClientReport)a10);
        } else {
            bl2 = a10 instanceof EventClientReport;
            if (bl2) {
                Context context = this.a;
                a10 = (EventClientReport)a10;
                ClientReportClient.reportEvent(context, (EventClientReport)a10);
            }
        }
    }

    public void a(String string2, int n10, long l10, long l11) {
        long l12;
        long l13;
        long l14;
        long l15;
        if (n10 >= 0 && (l15 = (l14 = l11 - (l13 = 0L)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) >= 0 && (l12 = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1)) > 0) {
            Context context = this.a;
            l15 = n10;
            PerfClientReport perfClientReport = fa.a(context, n10, l10, l11);
            perfClientReport.setAppPackageName(string2);
            string2 = "3_7_5";
            perfClientReport.setSdkVersion(string2);
            this.a(perfClientReport);
        }
    }

    public void a(String string2, Intent intent, int n10, String string3) {
        if (intent == null) {
            return;
        }
        String string4 = intent.getStringExtra("messageId");
        String string5 = fa.a(intent.getIntExtra("eventMessageType", -1));
        long l10 = System.currentTimeMillis();
        this.a(string2, string5, string4, n10, l10, string3);
    }

    public void a(String string2, Intent intent, String string3) {
        if (intent == null) {
            return;
        }
        String string4 = intent.getStringExtra("messageId");
        String string5 = fa.a(intent.getIntExtra("eventMessageType", -1));
        long l10 = System.currentTimeMillis();
        this.a(string2, string5, string4, 5001, l10, string3);
    }

    public void a(String string2, String object, String string3, int n10, long l10, String string4) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)string3))) {
            Context context = this.a;
            object = fa.a(context, (String)object, string3, n10, l10, string4);
            ((a)object).setAppPackageName(string2);
            string2 = "3_7_5";
            ((a)object).setSdkVersion(string2);
            this.a((a)object);
        }
    }

    public void a(String string2, String string3, String string4, int n10, String string5) {
        long l10 = System.currentTimeMillis();
        this.a(string2, string3, string4, n10, l10, string5);
    }

    public void a(String string2, String string3, String string4, String string5) {
        long l10 = System.currentTimeMillis();
        this.a(string2, string3, string4, 5002, l10, string5);
    }

    public void b(String string2, String string3, String string4, String string5) {
        long l10 = System.currentTimeMillis();
        this.a(string2, string3, string4, 5001, l10, string5);
    }

    public void c(String string2, String string3, String string4, String string5) {
        long l10 = System.currentTimeMillis();
        this.a(string2, string3, string4, 4002, l10, string5);
    }
}

