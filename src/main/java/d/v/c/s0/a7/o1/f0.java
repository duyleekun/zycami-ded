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

public final class f0
implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ SetVideoFragment a;

    public /* synthetic */ f0(SetVideoFragment setVideoFragment) {
        this.a = setVideoFragment;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean bl2) {
        this.a.w(compoundButton, bl2);
    }
}

