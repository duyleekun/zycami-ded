/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.s0.i7;

import android.view.View;
import com.zhiyun.cama.camera.widget.ModeSwitch;
import l.a.q.c0;

public final class c
implements View.OnClickListener {
    public final /* synthetic */ ModeSwitch a;
    public final /* synthetic */ c0 b;

    public /* synthetic */ c(ModeSwitch modeSwitch, c0 c02) {
        this.a = modeSwitch;
        this.b = c02;
    }

    public final void onClick(View view) {
        ModeSwitch modeSwitch = this.a;
        c0 c02 = this.b;
        modeSwitch.y(c02, view);
    }
}

