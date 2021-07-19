/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.RadioGroup
 *  android.widget.RadioGroup$OnCheckedChangeListener
 */
package d.v.c.s0.a7.o1;

import android.widget.RadioGroup;
import com.zhiyun.cama.camera.dialog.more.SetGeneralFragment;

public final class b
implements RadioGroup.OnCheckedChangeListener {
    public final /* synthetic */ SetGeneralFragment a;

    public /* synthetic */ b(SetGeneralFragment setGeneralFragment) {
        this.a = setGeneralFragment;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int n10) {
        this.a.y(radioGroup, n10);
    }
}

