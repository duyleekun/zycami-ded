/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.PopupWindow$OnDismissListener
 */
package d.v.c.k1.a;

import android.widget.PopupWindow;
import com.zhiyun.cama.mediacontent.media.AddVideoFragment;

public final class d
implements PopupWindow.OnDismissListener {
    public static final /* synthetic */ d a;

    static {
        d d10;
        a = d10 = new d();
    }

    public final void onDismiss() {
        AddVideoFragment.c0();
    }
}

