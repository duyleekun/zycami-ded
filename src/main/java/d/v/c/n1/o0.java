/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.n1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.publish.PublishFragment$f;

public final class o0
implements Observer {
    public final /* synthetic */ PublishFragment$f a;

    public /* synthetic */ o0(PublishFragment$f publishFragment$f) {
        this.a = publishFragment$f;
    }

    public final void onChanged(Object object) {
        PublishFragment$f publishFragment$f = this.a;
        object = (String)object;
        publishFragment$f.g((String)object);
    }
}

