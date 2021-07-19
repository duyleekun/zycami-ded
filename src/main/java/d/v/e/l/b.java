/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View$OnSystemUiVisibilityChangeListener
 *  android.view.Window
 */
package d.v.e.l;

import android.view.View;
import android.view.Window;
import com.zhiyun.common.util.StatusBarUtil;

public final class b
implements View.OnSystemUiVisibilityChangeListener {
    public final /* synthetic */ Window a;
    public final /* synthetic */ int b;

    public /* synthetic */ b(Window window, int n10) {
        this.a = window;
        this.b = n10;
    }

    public final void onSystemUiVisibilityChange(int n10) {
        Window window = this.a;
        int n11 = this.b;
        StatusBarUtil.o(window, n11, n10);
    }
}

