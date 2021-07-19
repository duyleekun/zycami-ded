/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.c.j1.b;

import android.view.View;
import com.zhiyun.cama.data.database.model.MessageViolation;
import com.zhiyun.cama.me.message.MessageViolationFragment;
import d.v.f.f.b;

public final class i0
implements b {
    public final /* synthetic */ MessageViolationFragment a;

    public /* synthetic */ i0(MessageViolationFragment messageViolationFragment) {
        this.a = messageViolationFragment;
    }

    public final void a(View view, int n10, Object object) {
        MessageViolationFragment messageViolationFragment = this.a;
        object = (MessageViolation)object;
        messageViolationFragment.N(view, n10, (MessageViolation)object);
    }
}

