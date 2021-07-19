/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.PopupWindow$OnDismissListener
 */
package d.v.c.k1.a;

import android.widget.PopupWindow;
import com.zhiyun.cama.mediacontent.media.AddVideoFragment;

public final class h
implements PopupWindow.OnDismissListener {
    public final /* synthetic */ AddVideoFragment a;

    public /* synthetic */ h(AddVideoFragment addVideoFragment) {
        this.a = addVideoFragment;
    }

    public final void onDismiss() {
        AddVideoFragment.J(this.a);
    }
}

