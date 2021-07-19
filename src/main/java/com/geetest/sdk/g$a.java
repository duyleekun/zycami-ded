/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 */
package com.geetest.sdk;

import android.content.DialogInterface;
import com.geetest.sdk.GT3ConfigBean;
import com.geetest.sdk.g;

public class g$a
implements DialogInterface.OnCancelListener {
    public final /* synthetic */ GT3ConfigBean a;
    public final /* synthetic */ g b;

    public g$a(g g10, GT3ConfigBean gT3ConfigBean) {
        this.b = g10;
        this.a = gT3ConfigBean;
    }

    public void onCancel(DialogInterface object) {
        object = g.a(this.b);
        if (object != null) {
            object = g.a(this.b);
            object.h();
        }
        if ((object = this.a.getListener()) != null) {
            object = this.a.getListener();
            int n10 = 2;
            object.onClosed(n10);
        }
    }
}

