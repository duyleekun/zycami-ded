/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.n1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.publish.ComposeFragment$b;

public final class e
implements Observer {
    public final /* synthetic */ ComposeFragment$b a;

    public /* synthetic */ e(ComposeFragment$b composeFragment$b) {
        this.a = composeFragment$b;
    }

    public final void onChanged(Object object) {
        ComposeFragment$b composeFragment$b = this.a;
        object = (String)object;
        composeFragment$b.e((String)object);
    }
}

