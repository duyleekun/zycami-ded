/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 */
package com.geetest.sdk;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.geetest.sdk.dialog.views.GtWebView;
import com.geetest.sdk.dialog.views.a;
import com.geetest.sdk.utils.l;
import com.geetest.sdk.utils.o;

public abstract class d
extends Dialog {
    private static final String c = d.class.getSimpleName();
    private View a;
    private Context b;

    public d(Context context) {
        int n10 = o.f(context, "gt3_dialog_style");
        super(context, n10);
        this.b = context;
    }

    public abstract View a(LayoutInflater var1);

    public abstract void a();

    public void a(View view) {
    }

    public void b(View view) {
        this.a = view;
    }

    public void dismiss() {
        boolean bl2 = this.isShowing();
        if (bl2) {
            Context context = this.b;
            int n10 = context instanceof Activity;
            if (n10 != 0) {
                n10 = Build.VERSION.SDK_INT;
                int n11 = 17;
                if (n10 >= n11) {
                    bl2 = (context = (Activity)context).isFinishing();
                    if (!bl2 && !(bl2 = (context = (Activity)this.b).isDestroyed())) {
                        super.dismiss();
                    }
                } else {
                    bl2 = (context = (Activity)context).isFinishing();
                    if (!bl2) {
                        super.dismiss();
                    }
                }
            } else {
                super.dismiss();
            }
        }
    }

    public void onCreate(Bundle object) {
        String string2;
        super.onCreate(object);
        object = this.getWindow();
        if (object != null) {
            int n10 = 0x1000000;
            object.setLayout(n10, n10);
        } else {
            object = c;
            string2 = "getWindow\u4e3anull\uff0c\u786c\u4ef6\u52a0\u901f\u5f00\u542f\u5931\u8d25\uff01";
            l.d((String)object, string2);
        }
        object = LayoutInflater.from((Context)this.getContext());
        object = this.a((LayoutInflater)object);
        string2 = this.a;
        this.setContentView((View)string2);
        string2 = this.a;
        int n11 = string2 instanceof GtWebView;
        if (n11 != 0 && string2 != null && (string2 = ((View)string2).getLayoutParams()) != null) {
            string2 = this.a.getLayoutParams();
            ((ViewGroup.LayoutParams)string2).width = n11 = com.geetest.sdk.dialog.views.a.n;
            ((ViewGroup.LayoutParams)string2).height = n11 = com.geetest.sdk.dialog.views.a.o;
            View view = this.a;
            view.setLayoutParams((ViewGroup.LayoutParams)string2);
        }
        this.a((View)object);
    }

    public void show() {
        try {
            super.show();
            this.a();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

