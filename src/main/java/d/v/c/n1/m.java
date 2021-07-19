/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.RadioGroup
 *  android.widget.RadioGroup$OnCheckedChangeListener
 */
package d.v.c.n1;

import android.widget.RadioGroup;
import com.zhiyun.cama.publish.ComposeFragment;

public final class m
implements RadioGroup.OnCheckedChangeListener {
    public final /* synthetic */ ComposeFragment a;

    public /* synthetic */ m(ComposeFragment composeFragment) {
        this.a = composeFragment;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int n10) {
        this.a.z(radioGroup, n10);
    }
}

