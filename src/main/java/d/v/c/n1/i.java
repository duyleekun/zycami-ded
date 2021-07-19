/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.PopupWindow$OnDismissListener
 */
package d.v.c.n1;

import android.widget.PopupWindow;
import com.zhiyun.cama.publish.ComposeFragment;

public final class i
implements PopupWindow.OnDismissListener {
    public static final /* synthetic */ i a;

    static {
        i i10;
        a = i10 = new i();
    }

    public final void onDismiss() {
        ComposeFragment.G();
    }
}

