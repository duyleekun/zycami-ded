/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.n1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.publish.ComposeFragment;

public final class g
implements Observer {
    public final /* synthetic */ ComposeFragment a;

    public /* synthetic */ g(ComposeFragment composeFragment) {
        this.a = composeFragment;
    }

    public final void onChanged(Object object) {
        ComposeFragment composeFragment = this.a;
        object = (String)object;
        composeFragment.r((String)object);
    }
}

