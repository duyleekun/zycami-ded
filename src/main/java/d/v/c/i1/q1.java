/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.PopupWindow$OnDismissListener
 */
package d.v.c.i1;

import android.widget.PopupWindow;
import com.zhiyun.cama.main.MainFragment;

public final class q1
implements PopupWindow.OnDismissListener {
    public final /* synthetic */ MainFragment a;
    public final /* synthetic */ int[] b;

    public /* synthetic */ q1(MainFragment mainFragment, int[] nArray) {
        this.a = mainFragment;
        this.b = nArray;
    }

    public final void onDismiss() {
        MainFragment mainFragment = this.a;
        int[] nArray = this.b;
        mainFragment.P(nArray);
    }
}

