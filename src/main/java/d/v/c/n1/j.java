/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.RadioButton
 */
package d.v.c.n1;

import android.widget.RadioButton;
import androidx.fragment.app.DialogFragment;
import com.zhiyun.cama.publish.ComposeFragment;
import d.v.f.f.a;

public final class j
implements a {
    public final /* synthetic */ ComposeFragment a;
    public final /* synthetic */ RadioButton b;

    public /* synthetic */ j(ComposeFragment composeFragment, RadioButton radioButton) {
        this.a = composeFragment;
        this.b = radioButton;
    }

    public final void a(DialogFragment dialogFragment) {
        ComposeFragment composeFragment = this.a;
        RadioButton radioButton = this.b;
        composeFragment.D(radioButton, dialogFragment);
    }
}

