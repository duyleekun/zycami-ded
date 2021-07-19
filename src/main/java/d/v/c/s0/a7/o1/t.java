/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.RadioGroup
 *  android.widget.RadioGroup$OnCheckedChangeListener
 */
package d.v.c.s0.a7.o1;

import android.widget.RadioGroup;
import com.zhiyun.cama.camera.dialog.more.SetStabilizerFragment;

public final class t
implements RadioGroup.OnCheckedChangeListener {
    public final /* synthetic */ SetStabilizerFragment a;

    public /* synthetic */ t(SetStabilizerFragment setStabilizerFragment) {
        this.a = setStabilizerFragment;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int n10) {
        this.a.L(radioGroup, n10);
    }
}

