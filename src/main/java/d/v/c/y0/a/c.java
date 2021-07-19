/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y0.a;

import androidx.fragment.app.DialogFragment;
import com.zhiyun.cama.device.active.ActivationPrepareFragment;
import d.v.f.f.a;

public final class c
implements a {
    public final /* synthetic */ ActivationPrepareFragment a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ c(ActivationPrepareFragment activationPrepareFragment, boolean bl2) {
        this.a = activationPrepareFragment;
        this.b = bl2;
    }

    public final void a(DialogFragment dialogFragment) {
        ActivationPrepareFragment activationPrepareFragment = this.a;
        boolean bl2 = this.b;
        activationPrepareFragment.E(bl2, dialogFragment);
    }
}

