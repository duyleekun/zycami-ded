/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.j1.b;

import android.view.View;
import com.zhiyun.cama.data.database.model.MessageViolation;
import com.zhiyun.cama.me.message.MessageViolationFragment$a;

public final class f0
implements View.OnClickListener {
    public final /* synthetic */ MessageViolationFragment$a a;
    public final /* synthetic */ int b;
    public final /* synthetic */ MessageViolation c;

    public /* synthetic */ f0(MessageViolationFragment$a messageViolationFragment$a, int n10, MessageViolation messageViolation) {
        this.a = messageViolationFragment$a;
        this.b = n10;
        this.c = messageViolation;
    }

    public final void onClick(View view) {
        MessageViolationFragment$a messageViolationFragment$a = this.a;
        int n10 = this.b;
        MessageViolation messageViolation = this.c;
        messageViolationFragment$a.v(n10, messageViolation, view);
    }
}

