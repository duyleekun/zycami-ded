/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnLongClickListener
 */
package d.v.c.j1.b;

import android.view.View;
import com.zhiyun.cama.data.database.model.MessageSystem;
import com.zhiyun.cama.me.message.MessageSystemFragment$a;

public final class k
implements View.OnLongClickListener {
    public final /* synthetic */ MessageSystemFragment$a a;
    public final /* synthetic */ int b;
    public final /* synthetic */ MessageSystem c;

    public /* synthetic */ k(MessageSystemFragment$a a10, int n10, MessageSystem messageSystem) {
        this.a = a10;
        this.b = n10;
        this.c = messageSystem;
    }

    public final boolean onLongClick(View view) {
        MessageSystemFragment$a messageSystemFragment$a = this.a;
        int n10 = this.b;
        MessageSystem messageSystem = this.c;
        return messageSystemFragment$a.v(n10, messageSystem, view);
    }
}

