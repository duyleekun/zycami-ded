/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.n1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.publish.PublishFragment;

public final class k1
implements Observer {
    public final /* synthetic */ PublishFragment a;

    public /* synthetic */ k1(PublishFragment publishFragment) {
        this.a = publishFragment;
    }

    public final void onChanged(Object object) {
        PublishFragment publishFragment = this.a;
        object = (String)object;
        publishFragment.p0((String)object);
    }
}

