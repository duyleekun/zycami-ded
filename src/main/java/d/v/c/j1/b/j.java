/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.j1.b;

import com.zhiyun.cama.data.database.model.MessageSystem;
import com.zhiyun.cama.me.message.MessageSystemFragment;
import d.v.g0.i$c;

public final class j
implements i$c {
    public final /* synthetic */ MessageSystemFragment a;
    public final /* synthetic */ MessageSystem b;

    public /* synthetic */ j(MessageSystemFragment messageSystemFragment, MessageSystem messageSystem) {
        this.a = messageSystemFragment;
        this.b = messageSystem;
    }

    public final void a(int n10) {
        MessageSystemFragment messageSystemFragment = this.a;
        MessageSystem messageSystem = this.b;
        messageSystemFragment.T(messageSystem, n10);
    }
}

