/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.c.j1.b;

import android.view.View;
import com.zhiyun.cama.data.database.model.MessageSystem;
import com.zhiyun.cama.me.message.MessageSystemFragment;
import d.v.f.f.b;

public final class i
implements b {
    public final /* synthetic */ MessageSystemFragment a;

    public /* synthetic */ i(MessageSystemFragment messageSystemFragment) {
        this.a = messageSystemFragment;
    }

    public final void a(View view, int n10, Object object) {
        MessageSystemFragment messageSystemFragment = this.a;
        object = (MessageSystem)object;
        messageSystemFragment.P(view, n10, (MessageSystem)object);
    }
}

