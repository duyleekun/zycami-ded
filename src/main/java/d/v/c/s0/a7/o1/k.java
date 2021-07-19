/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 */
package d.v.c.s0.a7.o1;

import android.widget.CompoundButton;
import com.zhiyun.cama.camera.dialog.more.SetStabilizerFragment;

public final class k
implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ SetStabilizerFragment a;

    public /* synthetic */ k(SetStabilizerFragment setStabilizerFragment) {
        this.a = setStabilizerFragment;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean bl2) {
        this.a.P(compoundButton, bl2);
    }
}

