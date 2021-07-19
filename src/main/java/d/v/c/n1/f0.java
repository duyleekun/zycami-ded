/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.n1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.data.database.model.PublishWorks;
import com.zhiyun.cama.publish.PublishFragment;

public final class f0
implements Observer {
    public final /* synthetic */ PublishFragment a;

    public /* synthetic */ f0(PublishFragment publishFragment) {
        this.a = publishFragment;
    }

    public final void onChanged(Object object) {
        PublishFragment publishFragment = this.a;
        object = (PublishWorks)object;
        publishFragment.x0((PublishWorks)object);
    }
}

