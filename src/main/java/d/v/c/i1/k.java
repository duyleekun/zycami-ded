/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.PopupWindow$OnDismissListener
 */
package d.v.c.i1;

import android.widget.PopupWindow;
import com.zhiyun.cama.main.EditorMainActivity;

public final class k
implements PopupWindow.OnDismissListener {
    public static final /* synthetic */ k a;

    static {
        k k10;
        a = k10 = new k();
    }

    public final void onDismiss() {
        EditorMainActivity.I();
    }
}

