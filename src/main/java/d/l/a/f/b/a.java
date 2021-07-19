/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 */
package d.l.a.f.b;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.kwai.auth.common.InternalRequest;
import com.kwai.auth.login.kwailogin.applogin.LoginRequest;
import com.kwai.auth.login.kwailogin.h5login.H5LoginRequest;
import d.l.a.c;
import d.l.a.f.b.a$a;

public class a {
    private static final String h = "GameKwaiLoginRequest";
    private InternalRequest a;
    private String b;
    private String c;
    private String d;
    private String e;
    private int f;
    private String[] g;

    private a() {
    }

    public /* synthetic */ a(a$a a$a) {
        this();
    }

    public static /* synthetic */ InternalRequest a(a a10) {
        return a10.a;
    }

    public static /* synthetic */ void b(a a10, Activity activity, Bundle bundle) {
        a10.o(activity, bundle);
    }

    public static /* synthetic */ String c(a a10, String string2) {
        a10.b = string2;
        return string2;
    }

    public static /* synthetic */ String d(a a10, String string2) {
        a10.c = string2;
        return string2;
    }

    public static /* synthetic */ void e(a a10) {
        a10.f();
    }

    private void f() {
        InternalRequest internalRequest;
        String string2;
        int n10 = this.f;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 == n11) {
                string2 = this.c;
                String string3 = this.d;
                String string4 = this.e;
                this.a = internalRequest = new H5LoginRequest(string2, string3, string4);
            }
        } else {
            string2 = this.c;
            String string5 = this.d;
            String string6 = this.e;
            this.a = internalRequest = new LoginRequest(string2, string5, string6);
        }
        internalRequest = this.a;
        string2 = this.b;
        internalRequest.setAppId(string2);
    }

    private void o(Activity activity, Bundle bundle) {
        InternalRequest internalRequest = this.a;
        String string2 = activity.getPackageName();
        internalRequest.setPackageName(string2);
        internalRequest = this.a;
        activity = activity.getApplicationContext();
        internalRequest.toBundle((Context)activity, bundle);
    }

    public boolean g(c c10, Activity activity, String string2) {
        boolean bl2;
        if (activity != null && !(bl2 = activity.isFinishing())) {
            a$a a$a = new a$a(this, activity, string2, c10);
            activity.runOnUiThread((Runnable)a$a);
            return true;
        }
        return false;
    }

    public int h() {
        return this.f;
    }

    public String[] i() {
        return this.g;
    }

    public String j() {
        return this.d;
    }

    public void k(String string2) {
        this.e = string2;
    }

    public void l(int n10) {
        this.f = n10;
    }

    public void m(String[] stringArray) {
        this.g = stringArray;
    }

    public void n(String string2) {
        this.d = string2;
    }
}

