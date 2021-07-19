/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnSystemUiVisibilityChangeListener
 */
package d.v.e.l;

import android.view.View;
import com.zhiyun.common.util.StatusBarUtil;

public final class j
implements View.OnSystemUiVisibilityChangeListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ int b;

    public /* synthetic */ j(View view, int n10) {
        this.a = view;
        this.b = n10;
    }

    public final void onSystemUiVisibilityChange(int n10) {
        View view = this.a;
        int n11 = this.b;
        StatusBarUtil.m(view, n11, n10);
    }
}

