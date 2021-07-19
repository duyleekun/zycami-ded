/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 */
package d.v.c.s0.a7.o1;

import android.widget.CompoundButton;
import com.zhiyun.cama.camera.dialog.more.SetVideoFragment;

public final class h0
implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ SetVideoFragment a;

    public /* synthetic */ h0(SetVideoFragment setVideoFragment) {
        this.a = setVideoFragment;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean bl2) {
        this.a.M(compoundButton, bl2);
    }
}

