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
import com.geetest.sdk.g;

public class g$d
implements DialogInterface.OnDismissListener {
    public final /* synthetic */ g a;

    public g$d(g g10) {
        this.a = g10;
    }

    public void onDismiss(DialogInterface object) {
        block10: {
            object = this.a;
            object = g.b((g)object);
            if (object == null) break block10;
            object = this.a;
            object = g.b((g)object);
            object = ((GT3ConfigBean)object).getListener();
            if (object == null) break block10;
            object = this.a;
            object = g.b((g)object);
            object = ((GT3ConfigBean)object).getListener();
            String string2 = "";
            try {
                object.onSuccess(string2);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}

