/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.j1.b;

import com.zhiyun.cama.data.database.model.MessageLike;
import com.zhiyun.cama.me.message.MessageLikeFragment;
import d.v.g0.i$c;

public final class c
implements i$c {
    public final /* synthetic */ MessageLikeFragment a;
    public final /* synthetic */ MessageLike b;

    public /* synthetic */ c(MessageLikeFragment messageLikeFragment, MessageLike messageLike) {
        this.a = messageLikeFragment;
        this.b = messageLike;
    }

    public final void a(int n10) {
        MessageLikeFragment messageLikeFragment = this.a;
        MessageLike messageLike = this.b;
        messageLikeFragment.S(messageLike, n10);
    }
}

