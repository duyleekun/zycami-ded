/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 */
package d.v.c.q1;

import android.widget.CompoundButton;
import com.zhiyun.cama.set.SetPrivateFragment;

public final class v
implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ SetPrivateFragment a;

    public /* synthetic */ v(SetPrivateFragment setPrivateFragment) {
        this.a = setPrivateFragment;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean bl2) {
        this.a.o(compoundButton, bl2);
    }
}

