/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.RadioGroup
 *  android.widget.RadioGroup$OnCheckedChangeListener
 */
package d.v.c.s0.a7.o1;

import android.widget.RadioGroup;
import com.zhiyun.cama.camera.dialog.more.SetVideoFragment;

public final class k0
implements RadioGroup.OnCheckedChangeListener {
    public final /* synthetic */ SetVideoFragment a;

    public /* synthetic */ k0(SetVideoFragment setVideoFragment) {
        this.a = setVideoFragment;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int n10) {
        this.a.G(radioGroup, n10);
    }
}

