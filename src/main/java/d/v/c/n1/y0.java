/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.PopupWindow$OnDismissListener
 */
package d.v.c.n1;

import android.widget.PopupWindow;
import com.zhiyun.cama.publish.PublishFragment;

public final class y0
implements PopupWindow.OnDismissListener {
    public final /* synthetic */ PublishFragment a;
    public final /* synthetic */ int[] b;

    public /* synthetic */ y0(PublishFragment publishFragment, int[] nArray) {
        this.a = publishFragment;
        this.b = nArray;
    }

    public final void onDismiss() {
        PublishFragment publishFragment = this.a;
        int[] nArray = this.b;
        publishFragment.E0(nArray);
    }
}

