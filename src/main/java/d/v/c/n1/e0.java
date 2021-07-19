/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.n1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.data.me.remote.data.KwaiTokenInfo;
import com.zhiyun.cama.publish.PublishFragment;

public final class e0
implements Observer {
    public final /* synthetic */ PublishFragment a;

    public /* synthetic */ e0(PublishFragment publishFragment) {
        this.a = publishFragment;
    }

    public final void onChanged(Object object) {
        PublishFragment publishFragment = this.a;
        object = (KwaiTokenInfo)object;
        publishFragment.t0((KwaiTokenInfo)object);
    }
}

