/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.tencent.liteav.beauty;

import android.content.Context;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;

public class a {
    private static boolean A = false;
    private static boolean B = false;
    private static boolean C = false;
    private static boolean D = false;
    private static boolean E = false;
    private static a a;
    private static Context b;
    private static boolean c = false;
    private static boolean d = false;
    private static boolean e = false;
    private static boolean f = false;
    private static boolean g = false;
    private static boolean h = false;
    private static boolean i = false;
    private static boolean j = false;
    private static boolean k = false;
    private static boolean l = false;
    private static boolean m = false;
    private static boolean n = false;
    private static boolean o = false;
    private static boolean p = false;
    private static boolean q = false;
    private static boolean r = false;
    private static boolean s = false;
    private static boolean t = false;
    private static boolean u = false;
    private static boolean v = false;
    private static boolean w = false;
    private static boolean x = false;
    private static boolean y = false;
    private static boolean z = false;
    private String F = "ReportDuaManage";

    public static a a() {
        a a10 = a;
        if (a10 == null) {
            a = a10 = new a();
        }
        return a;
    }

    private void h() {
        TXCLog.i(this.F, "resetReportState");
        c = false;
        d = false;
        e = false;
        f = false;
        g = false;
        h = false;
        i = false;
        j = false;
        k = false;
        l = false;
        m = false;
        n = false;
        C = false;
        o = false;
        p = false;
        q = false;
        r = false;
        s = false;
        t = false;
        u = false;
        v = false;
        w = false;
        x = false;
        y = false;
        z = false;
        A = false;
        B = false;
        D = false;
        E = false;
    }

    public void a(Context object) {
        this.h();
        b = object = object.getApplicationContext();
        boolean bl2 = c;
        if (!bl2) {
            object = this.F;
            String string2 = "reportSDKInit";
            TXCLog.i((String)object, string2);
            object = b;
            int n10 = 1201;
            String string3 = "reportSDKInit!";
            TXCDRApi.txReportDAU(object, n10, 0, string3);
        }
        c = true;
    }

    public void b() {
        boolean bl2 = d;
        if (!bl2) {
            String string2 = this.F;
            String string3 = "reportBeautyDua";
            TXCLog.i(string2, string3);
            string2 = b;
            int n10 = 1202;
            TXCDRApi.txReportDAU((Context)string2, n10, 0, string3);
        }
        d = true;
    }

    public void c() {
        boolean bl2 = e;
        if (!bl2) {
            String string2 = this.F;
            String string3 = "reportWhiteDua";
            TXCLog.i(string2, string3);
            string2 = b;
            int n10 = 1203;
            TXCDRApi.txReportDAU((Context)string2, n10, 0, string3);
        }
        e = true;
    }

    public void d() {
        boolean bl2 = f;
        if (!bl2) {
            String string2 = this.F;
            String string3 = "reportRuddyDua";
            TXCLog.i(string2, string3);
            string2 = b;
            int n10 = 1204;
            TXCDRApi.txReportDAU((Context)string2, n10, 0, string3);
        }
        f = true;
    }

    public void e() {
        boolean bl2 = j;
        if (!bl2) {
            String string2 = this.F;
            String string3 = "reportFilterImageDua";
            TXCLog.i(string2, string3);
            string2 = b;
            int n10 = 1208;
            TXCDRApi.txReportDAU((Context)string2, n10, 0, string3);
        }
        j = true;
    }

    public void f() {
        boolean bl2 = l;
        if (!bl2) {
            String string2 = this.F;
            String string3 = "reportSharpDua";
            TXCLog.i(string2, string3);
            string2 = b;
            int n10 = 1210;
            TXCDRApi.txReportDAU((Context)string2, n10, 0, string3);
        }
        l = true;
    }

    public void g() {
        boolean bl2 = n;
        if (!bl2) {
            String string2 = this.F;
            String string3 = "reportWarterMarkDua";
            TXCLog.i(string2, string3);
            string2 = b;
            int n10 = 1212;
            TXCDRApi.txReportDAU((Context)string2, n10, 0, string3);
        }
        n = true;
    }
}

