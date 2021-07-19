/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.RadioGroup
 *  android.widget.RadioGroup$OnCheckedChangeListener
 */
package d.v.c.i1.t2;

import android.widget.RadioGroup;
import com.zhiyun.cama.main.me.MeFragment;

public final class e
implements RadioGroup.OnCheckedChangeListener {
    public final /* synthetic */ MeFragment a;

    public /* synthetic */ e(MeFragment meFragment) {
        this.a = meFragment;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int n10) {
        MeFragment.x(this.a, radioGroup, n10);
    }
}

