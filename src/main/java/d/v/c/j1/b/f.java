/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.j1.b;

import android.view.View;
import com.zhiyun.cama.data.database.model.MessageLike;
import com.zhiyun.cama.me.message.MessageLikeFragment$a;

public final class f
implements View.OnClickListener {
    public final /* synthetic */ MessageLikeFragment$a a;
    public final /* synthetic */ int b;
    public final /* synthetic */ MessageLike c;

    public /* synthetic */ f(MessageLikeFragment$a messageLikeFragment$a, int n10, MessageLike messageLike) {
        this.a = messageLikeFragment$a;
        this.b = n10;
        this.c = messageLike;
    }

    public final void onClick(View view) {
        MessageLikeFragment$a messageLikeFragment$a = this.a;
        int n10 = this.b;
        MessageLike messageLike = this.c;
        messageLikeFragment$a.p(n10, messageLike, view);
    }
}

