/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 */
package d.v.c.q1;

import android.widget.CompoundButton;
import com.zhiyun.cama.set.SetFragment;

public final class u
implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ SetFragment a;

    public /* synthetic */ u(SetFragment setFragment) {
        this.a = setFragment;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean bl2) {
        this.a.r(compoundButton, bl2);
    }
}

