/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 */
package d.v.c.n1;

import android.widget.CompoundButton;
import com.zhiyun.cama.publish.PublishFragment;

public final class a1
implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ PublishFragment a;

    public /* synthetic */ a1(PublishFragment publishFragment) {
        this.a = publishFragment;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean bl2) {
        this.a.r0(compoundButton, bl2);
    }
}

