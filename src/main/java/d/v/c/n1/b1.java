/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.PopupWindow$OnDismissListener
 */
package d.v.c.n1;

import android.widget.PopupWindow;
import com.zhiyun.cama.publish.PublishFragment;

public final class b1
implements PopupWindow.OnDismissListener {
    public final /* synthetic */ PublishFragment a;

    public /* synthetic */ b1(PublishFragment publishFragment) {
        this.a = publishFragment;
    }

    public final void onDismiss() {
        this.a.g0();
    }
}

