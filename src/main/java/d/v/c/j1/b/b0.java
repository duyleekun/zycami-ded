/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package d.v.c.j1.b;

import android.view.View;
import com.zhiyun.cama.me.message.MessageViolationFragment$a;

public final class b0
implements View.OnClickListener {
    public final /* synthetic */ MessageViolationFragment$a a;
    public final /* synthetic */ int b;

    public /* synthetic */ b0(MessageViolationFragment$a a10, int n10) {
        this.a = a10;
        this.b = n10;
    }

    public final void onClick(View view) {
        MessageViolationFragment$a messageViolationFragment$a = this.a;
        int n10 = this.b;
        messageViolationFragment$a.r(n10, view);
    }
}

