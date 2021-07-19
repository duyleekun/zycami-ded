/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.n1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.publish.PublishFragment;

public final class g0
implements Observer {
    public final /* synthetic */ PublishFragment a;

    public /* synthetic */ g0(PublishFragment publishFragment) {
        this.a = publishFragment;
    }

    public final void onChanged(Object object) {
        PublishFragment publishFragment = this.a;
        object = (String)object;
        publishFragment.k0((String)object);
    }
}

