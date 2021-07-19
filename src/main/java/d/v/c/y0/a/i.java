/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 */
package d.v.c.y0.a;

import android.widget.CompoundButton;
import com.zhiyun.cama.device.active.ActivationPrepareFragment;

public final class i
implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ ActivationPrepareFragment a;

    public /* synthetic */ i(ActivationPrepareFragment activationPrepareFragment) {
        this.a = activationPrepareFragment;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean bl2) {
        this.a.s(compoundButton, bl2);
    }
}

