/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.View$OnKeyListener
 */
package d.v.c.n1;

import android.view.KeyEvent;
import android.view.View;
import com.zhiyun.cama.publish.PublishFragment;

public final class v0
implements View.OnKeyListener {
    public static final /* synthetic */ v0 a;

    static {
        v0 v02;
        a = v02 = new v0();
    }

    public final boolean onKey(View view, int n10, KeyEvent keyEvent) {
        return PublishFragment.A0(view, n10, keyEvent);
    }
}

