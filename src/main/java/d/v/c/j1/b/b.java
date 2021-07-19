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

public final class b
implements d.v.f.f.b {
    public static final /* synthetic */ b a;

    static {
        b b10;
        a = b10 = new b();
    }

    public final void a(View view, int n10, Object object) {
        object = (MessageLike)object;
        MessageLikeFragment.M(view, n10, (MessageLike)object);
    }
}

