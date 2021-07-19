/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.n1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.data.PagingRequestHelper$Status;
import com.zhiyun.cama.publish.PublishFragment;

public final class c1
implements Observer {
    public final /* synthetic */ PublishFragment a;

    public /* synthetic */ c1(PublishFragment publishFragment) {
        this.a = publishFragment;
    }

    public final void onChanged(Object object) {
        PublishFragment publishFragment = this.a;
        object = (PagingRequestHelper$Status)((Object)object);
        publishFragment.v0((PagingRequestHelper$Status)((Object)object));
    }
}

