/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.PopupWindow$OnDismissListener
 */
package d.v.c.n1;

import android.widget.PopupWindow;
import com.zhiyun.cama.publish.ComposeFragment;

public final class l
implements PopupWindow.OnDismissListener {
    public final /* synthetic */ ComposeFragment a;

    public /* synthetic */ l(ComposeFragment composeFragment) {
        this.a = composeFragment;
    }

    public final void onDismiss() {
        ComposeFragment.p(this.a);
    }
}

