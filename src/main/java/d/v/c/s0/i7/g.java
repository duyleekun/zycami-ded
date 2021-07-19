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
import l.a.q.m;

public final class g
implements View.OnClickListener {
    public final /* synthetic */ ModeSwitch a;
    public final /* synthetic */ m b;

    public /* synthetic */ g(ModeSwitch modeSwitch, m m10) {
        this.a = modeSwitch;
        this.b = m10;
    }

    public final void onClick(View view) {
        ModeSwitch modeSwitch = this.a;
        m m10 = this.b;
        modeSwitch.w(m10, view);
    }
}

