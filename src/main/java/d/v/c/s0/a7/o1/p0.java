/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.RadioGroup
 *  android.widget.RadioGroup$OnCheckedChangeListener
 */
package d.v.c.s0.a7.o1;

import android.widget.RadioGroup;
import com.zhiyun.cama.camera.dialog.more.WhiteBalanceFragment;

public final class p0
implements RadioGroup.OnCheckedChangeListener {
    public final /* synthetic */ WhiteBalanceFragment a;

    public /* synthetic */ p0(WhiteBalanceFragment whiteBalanceFragment) {
        this.a = whiteBalanceFragment;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int n10) {
        this.a.s(radioGroup, n10);
    }
}

