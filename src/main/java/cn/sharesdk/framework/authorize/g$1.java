/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package cn.sharesdk.framework.authorize;

import android.view.View;
import cn.sharesdk.framework.authorize.g;
import cn.sharesdk.framework.authorize.g$1$1;

public class g$1
implements View.OnClickListener {
    public final /* synthetic */ g a;

    public g$1(g g10) {
        this.a = g10;
    }

    public void onClick(View object) {
        object = new g$1$1(this);
        ((Thread)object).start();
    }
}

