/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.provider.Settings$Secure
 *  android.telephony.TelephonyManager
 *  android.util.DisplayMetrics
 *  android.view.WindowManager
 */
package com.xiaomi.push;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.xiaomi.push.ed;
import com.xiaomi.push.ho;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class ef
extends ed {
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;

    public ef(Context context, int n10, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        super(context, n10);
        this.a = bl2;
        this.b = bl3;
        this.c = bl4;
        this.d = bl5;
        this.e = bl6;
    }

    private String b() {
        String string2;
        Object object;
        DisplayMetrics displayMetrics;
        int n10 = this.a;
        if (n10 == 0) {
            return "off";
        }
        try {
            displayMetrics = new DisplayMetrics();
            object = ((ed)this).a;
            string2 = "window";
        }
        catch (Throwable throwable) {
            return "";
        }
        object = object.getSystemService(string2);
        object = (WindowManager)object;
        object = object.getDefaultDisplay();
        object.getMetrics(displayMetrics);
        object = new StringBuilder();
        int n11 = displayMetrics.heightPixels;
        ((StringBuilder)object).append(n11);
        string2 = ",";
        ((StringBuilder)object).append(string2);
        n10 = displayMetrics.widthPixels;
        ((StringBuilder)object).append(n10);
        return ((StringBuilder)object).toString();
    }

    private String c() {
        boolean bl2 = this.b;
        if (!bl2) {
            return "off";
        }
        try {
            return Build.VERSION.RELEASE;
        }
        catch (Throwable throwable) {
            return "";
        }
    }

    private String d() {
        int n10 = this.c;
        if (n10 == 0) {
            return "off";
        }
        try {
            n10 = Build.VERSION.SDK_INT;
        }
        catch (Throwable throwable) {
            return "";
        }
        return String.valueOf(n10);
    }

    private String e() {
        Context context;
        boolean bl2 = this.d;
        if (!bl2) {
            return "off";
        }
        try {
            context = ((ed)this).a;
        }
        catch (Throwable throwable) {
            return "";
        }
        context = context.getContentResolver();
        String string2 = "android_id";
        return Settings.Secure.getString((ContentResolver)context, (String)string2);
    }

    private String f() {
        String string2;
        Object object;
        boolean bl2 = this.e;
        if (!bl2) {
            return "off";
        }
        try {
            object = ((ed)this).a;
            string2 = "phone";
        }
        catch (Throwable throwable) {
            return "";
        }
        object = object.getSystemService(string2);
        object = (TelephonyManager)object;
        return object.getSimOperator();
    }

    public int a() {
        return 3;
    }

    public ho a() {
        return ho.u;
    }

    public String a() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.b();
        stringBuilder.append(string2);
        string2 = "|";
        stringBuilder.append(string2);
        String string3 = this.c();
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        string3 = this.d();
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        string3 = this.e();
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        string2 = this.f();
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

