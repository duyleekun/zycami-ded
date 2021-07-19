/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.j1.b;

import android.view.View;
import com.zhiyun.cama.data.database.model.MessageSystem;
import com.zhiyun.cama.me.message.MessageSystemFragment$a;

public final class n
implements View.OnClickListener {
    public final /* synthetic */ MessageSystemFragment$a a;
    public final /* synthetic */ int b;
    public final /* synthetic */ MessageSystem c;

    public /* synthetic */ n(MessageSystemFragment$a messageSystemFragment$a, int n10, MessageSystem messageSystem) {
        this.a = messageSystemFragment$a;
        this.b = n10;
        this.c = messageSystem;
    }

    public final void onClick(View view) {
        MessageSystemFragment$a messageSystemFragment$a = this.a;
        int n10 = this.b;
        MessageSystem messageSystem = this.c;
        messageSystemFragment$a.r(n10, messageSystem, view);
    }
}

