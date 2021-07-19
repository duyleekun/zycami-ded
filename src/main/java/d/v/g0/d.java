/*
 * Decompiled with CFR 0.151.
 */
package d.v.g0;

import com.zhiyun.ui.FixedPopupWindow;
import d.v.g0.n;

public final class d
implements Runnable {
    public final /* synthetic */ n a;
    public final /* synthetic */ FixedPopupWindow b;

    public /* synthetic */ d(n n10, FixedPopupWindow fixedPopupWindow) {
        this.a = n10;
        this.b = fixedPopupWindow;
    }

    public final void run() {
        n n10 = this.a;
        FixedPopupWindow fixedPopupWindow = this.b;
        n10.i(fixedPopupWindow);
    }
}

