/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 */
package d.v.c.s0.a7.o1;

import android.widget.CompoundButton;
import com.zhiyun.cama.camera.dialog.more.SetGeneralFragment;

public final class e
implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ SetGeneralFragment a;

    public /* synthetic */ e(SetGeneralFragment setGeneralFragment) {
        this.a = setGeneralFragment;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean bl2) {
        this.a.s(compoundButton, bl2);
    }
}

