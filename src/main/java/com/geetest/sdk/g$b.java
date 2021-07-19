/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnKeyListener
 *  android.view.KeyEvent
 */
package com.geetest.sdk;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.geetest.sdk.GT3ConfigBean;
import com.geetest.sdk.g;

public class g$b
implements DialogInterface.OnKeyListener {
    public final /* synthetic */ GT3ConfigBean a;
    public final /* synthetic */ g b;

    public g$b(g g10, GT3ConfigBean gT3ConfigBean) {
        this.b = g10;
        this.a = gT3ConfigBean;
    }

    public boolean onKey(DialogInterface dialogInterface, int n10, KeyEvent keyEvent) {
        Object object;
        int n11 = 1;
        int n12 = 4;
        if (n10 == n12 && (n10 = keyEvent.getRepeatCount()) == 0 && (n10 = keyEvent.getAction()) == n11 && (n10 = (int)(((GT3ConfigBean)(object = this.a)).isUnCanceledOnTouchKeyCodeBack() ? 1 : 0)) == 0) {
            object = g.a(this.b);
            if (object != null) {
                object = g.a(this.b);
                object.h();
            }
            if ((object = this.a.getListener()) != null) {
                object = this.a.getListener();
                int n13 = 3;
                object.onClosed(n13);
            }
            object = this.b;
            ((g)object).b();
        }
        return n11 != 0;
    }
}

