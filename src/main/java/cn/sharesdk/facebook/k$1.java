/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package cn.sharesdk.facebook;

import android.view.View;
import cn.sharesdk.facebook.k;
import cn.sharesdk.facebook.k$1$1;

public class k$1
implements View.OnClickListener {
    public final /* synthetic */ k a;

    public k$1(k k10) {
        this.a = k10;
    }

    public void onClick(View object) {
        object = new k$1$1(this);
        ((Thread)object).start();
    }
}

