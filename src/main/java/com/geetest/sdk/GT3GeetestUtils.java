/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.geetest.sdk;

import android.content.Context;
import com.geetest.sdk.GT3ConfigBean;
import com.geetest.sdk.a;

public class GT3GeetestUtils {
    private a holder;

    public GT3GeetestUtils(Context context) {
        a a10;
        this.holder = a10 = new a(context);
    }

    public static String getVersion() {
        return "4.3.3";
    }

    public void changeDialogLayout() {
        this.holder.a();
    }

    public void destory() {
        this.holder.b();
    }

    public void dismissGeetestDialog() {
        this.holder.c();
    }

    public void getGeetest() {
        this.holder.e();
    }

    public a getHolder() {
        return this.holder;
    }

    public void init(GT3ConfigBean gT3ConfigBean) {
        this.holder.a(gT3ConfigBean);
    }

    public void showFailedDialog() {
        this.holder.f();
    }

    public void showSuccessDialog() {
        this.holder.g();
    }

    public void startCustomFlow() {
        this.holder.h();
    }
}

