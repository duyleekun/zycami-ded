/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnDismissListener
 */
package com.geetest.sdk;

import android.content.DialogInterface;
import com.geetest.sdk.GT3ConfigBean;
import com.geetest.sdk.GT3ErrorBean;
import com.geetest.sdk.g;

public class g$c
implements DialogInterface.OnDismissListener {
    public final /* synthetic */ GT3ErrorBean a;
    public final /* synthetic */ g b;

    public g$c(g g10, GT3ErrorBean gT3ErrorBean) {
        this.b = g10;
        this.a = gT3ErrorBean;
    }

    public void onDismiss(DialogInterface object) {
        block11: {
            object = this.b;
            object = g.b((g)object);
            if (object == null) break block11;
            object = this.b;
            object = g.b((g)object);
            object = ((GT3ConfigBean)object).getListener();
            if (object == null) break block11;
            object = this.b;
            object = g.b((g)object);
            object = ((GT3ConfigBean)object).getListener();
            GT3ErrorBean gT3ErrorBean = this.a;
            try {
                object.onFailed(gT3ErrorBean);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}

