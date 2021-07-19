/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.q1.i0;

import android.view.View;
import com.zhiyun.cama.set.server.ServersFragment;

public final class d
implements View.OnClickListener {
    public final /* synthetic */ ServersFragment a;

    public /* synthetic */ d(ServersFragment serversFragment) {
        this.a = serversFragment;
    }

    public final void onClick(View view) {
        this.a.u(view);
    }
}

