/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.c.j1.b;

import android.view.View;
import com.zhiyun.cama.data.database.model.MessageLike;
import com.zhiyun.cama.me.message.MessageLikeFragment;
import d.v.f.f.b;

public final class g
implements b {
    public final /* synthetic */ MessageLikeFragment a;

    public /* synthetic */ g(MessageLikeFragment messageLikeFragment) {
        this.a = messageLikeFragment;
    }

    public final void a(View view, int n10, Object object) {
        MessageLikeFragment messageLikeFragment = this.a;
        object = (MessageLike)object;
        messageLikeFragment.Q(view, n10, (MessageLike)object);
    }
}

