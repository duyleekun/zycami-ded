/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 */
package d.v.c.i1.t2;

import android.widget.CompoundButton;
import com.zhiyun.cama.main.me.MeFragment;

public final class j
implements CompoundButton.OnCheckedChangeListener {
    public static final /* synthetic */ j a;

    static {
        j j10;
        a = j10 = new j();
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean bl2) {
        MeFragment.K(compoundButton, bl2);
    }
}

