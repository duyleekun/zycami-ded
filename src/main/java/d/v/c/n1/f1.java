/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.n1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.publish.PublishFragment;

public final class f1
implements Observer {
    public final /* synthetic */ PublishFragment a;

    public /* synthetic */ f1(PublishFragment publishFragment) {
        this.a = publishFragment;
    }

    public final void onChanged(Object object) {
        PublishFragment publishFragment = this.a;
        object = (Integer)object;
        publishFragment.G0((Integer)object);
    }
}

