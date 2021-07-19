/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.PopupWindow$OnDismissListener
 */
package d.v.c.i1;

import android.widget.PopupWindow;
import com.zhiyun.cama.main.MainFragment;

public final class t1
implements PopupWindow.OnDismissListener {
    public final /* synthetic */ MainFragment a;

    public /* synthetic */ t1(MainFragment mainFragment) {
        this.a = mainFragment;
    }

    public final void onDismiss() {
        this.a.L();
    }
}

