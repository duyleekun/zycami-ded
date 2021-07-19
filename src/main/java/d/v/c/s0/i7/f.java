/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnScrollChangeListener
 */
package d.v.c.s0.i7;

import android.view.View;
import com.zhiyun.cama.camera.widget.ModeSwitch;

public final class f
implements View.OnScrollChangeListener {
    public final /* synthetic */ ModeSwitch a;

    public /* synthetic */ f(ModeSwitch modeSwitch) {
        this.a = modeSwitch;
    }

    public final void onScrollChange(View view, int n10, int n11, int n12, int n13) {
        this.a.s(view, n10, n11, n12, n13);
    }
}

