/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.WindowManager$LayoutParams
 */
package com.geetest.sdk;

import android.content.Context;
import android.view.WindowManager;
import com.geetest.sdk.utils.d;
import com.geetest.sdk.utils.g;
import com.geetest.sdk.utils.l;

public abstract class e
extends com.geetest.sdk.d {
    private Context d;
    private int e;

    public e(Context context) {
        super(context);
        this.d = context;
    }

    private void c() {
        Context context;
        Context context2 = this.d;
        if (context2 == null) {
            l.b("BaseScreenDialog", "The context is unexpectedly empty !");
            return;
        }
        context2 = this.getWindow();
        int n10 = 1280;
        context2.addFlags(n10);
        WindowManager.LayoutParams layoutParams = context2.getAttributes();
        int n11 = com.geetest.sdk.utils.d.a;
        if (n11 != 0) {
            layoutParams.width = n11 = -2;
            layoutParams.height = n11;
        } else {
            layoutParams.width = n11 = g.b(this.d);
            context = this.d;
            layoutParams.height = n11 = g.a(context);
        }
        layoutParams.gravity = 17;
        context = this.d;
        float f10 = this.b();
        layoutParams.y = n11 = g.a(context, f10);
        context2.setAttributes(layoutParams);
    }

    public void a() {
        this.c();
    }

    public void a(int n10) {
        this.e = n10;
    }

    public int b() {
        return this.e;
    }
}

