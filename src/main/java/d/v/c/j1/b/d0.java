/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnLongClickListener
 */
package d.v.c.j1.b;

import android.view.View;
import com.zhiyun.cama.me.message.MessageViolationFragment$a;

public final class d0
implements View.OnLongClickListener {
    public final /* synthetic */ MessageViolationFragment$a a;
    public final /* synthetic */ int b;

    public /* synthetic */ d0(MessageViolationFragment$a messageViolationFragment$a, int n10) {
        this.a = messageViolationFragment$a;
        this.b = n10;
    }

    public final boolean onLongClick(View view) {
        MessageViolationFragment$a messageViolationFragment$a = this.a;
        int n10 = this.b;
        return messageViolationFragment$a.p(n10, view);
    }
}

