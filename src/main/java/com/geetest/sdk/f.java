/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.WindowManager$LayoutParams
 */
package com.geetest.sdk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.geetest.sdk.dialog.views.GtWebView;
import com.geetest.sdk.dialog.views.a;
import com.geetest.sdk.e;
import com.geetest.sdk.utils.g;
import com.geetest.sdk.utils.i;
import com.geetest.sdk.utils.l;

public class f
extends e {
    private Context f;

    public f(Context context) {
        super(context);
        this.f = context;
    }

    public View a(LayoutInflater layoutInflater) {
        return null;
    }

    public void a(View view) {
        super.a(view);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void c(View var1_1) {
        block22: {
            var2_3 /* !! */  = this.f;
            if (var2_3 /* !! */  != null) ** GOTO lbl9
            var1_1 /* !! */  = "BaseStatusDialog";
            var2_3 /* !! */  = "The context is unexpectedly empty !";
            l.b((String)var1_1 /* !! */ , (String)var2_3 /* !! */ );
            return;
lbl9:
            // 1 sources

            i.a(var2_3 /* !! */ );
            var2_3 /* !! */  = this.f;
            i.b(var2_3 /* !! */ );
            this.setContentView(var1_1 /* !! */ );
            var3_4 = var1_1 /* !! */  instanceof GtWebView;
            if (!var3_4) ** GOTO lbl46
            if (var1_1 /* !! */  == null) break block22;
            var2_3 /* !! */  = var1_1 /* !! */ .getLayoutParams();
            if (var2_3 /* !! */  == null) break block22;
            var2_3 /* !! */  = var1_1 /* !! */ .getLayoutParams();
            var4_5 = a.n;
            var2_3 /* !! */ .width = var4_5;
            var4_5 = a.o;
            var2_3 /* !! */ .height = var4_5;
            var5_7 = this.getWindow();
            var6_9 = var5_7.getAttributes();
            var7_10 = a.n;
            var6_9.width = var7_10;
            var7_10 = a.o;
            var6_9.height = var7_10;
            var5_7.setAttributes(var6_9);
            var1_1 /* !! */ .setLayoutParams((ViewGroup.LayoutParams)var2_3 /* !! */ );
            break block22;
lbl46:
            // 1 sources

            var1_1 /* !! */  = this.getWindow();
            var2_3 /* !! */  = var1_1 /* !! */ .getAttributes();
            var5_8 = this.f;
            var4_6 = g.b(var5_8);
            var2_3 /* !! */ .width = var4_6;
            var5_8 = this.f;
            var4_6 = g.a(var5_8);
            var2_3 /* !! */ .height = var4_6;
            try {
                var1_1 /* !! */ .setAttributes((WindowManager.LayoutParams)var2_3 /* !! */ );
            }
            catch (Exception var1_2) {
                var1_2.printStackTrace();
            }
        }
    }
}

