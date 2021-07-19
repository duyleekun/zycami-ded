/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package cn.sharesdk.tencent.qzone;

import android.view.View;
import cn.sharesdk.tencent.qzone.d;
import cn.sharesdk.tencent.qzone.d$1$1;

public class d$1
implements View.OnClickListener {
    public final /* synthetic */ d a;

    public d$1(d d10) {
        this.a = d10;
    }

    public void onClick(View object) {
        object = new d$1$1(this);
        ((Thread)object).start();
    }
}

