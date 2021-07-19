/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.j1.b;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.me.message.MessageFragment;
import d.v.j.e.h.k;

public final class a
implements Observer {
    public final /* synthetic */ MessageFragment a;

    public /* synthetic */ a(MessageFragment messageFragment) {
        this.a = messageFragment;
    }

    public final void onChanged(Object object) {
        MessageFragment messageFragment = this.a;
        object = (k)object;
        messageFragment.l((k)object);
    }
}

