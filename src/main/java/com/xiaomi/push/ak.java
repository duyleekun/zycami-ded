/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.ai;
import com.xiaomi.push.ai$a;
import com.xiaomi.push.ai$b;

public class ak
extends ai$b {
    public final /* synthetic */ ai a;

    public ak(ai ai2, ai$a ai$a) {
        this.a = ai2;
        super(ai$a);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        Object object = ai.a(this.a);
        synchronized (object) {
            ai ai2 = this.a;
            ai2 = ai.a(ai2);
            ai$a ai$a = ((ai$b)this).a;
            int n10 = ai$a.a();
            ai2.remove(n10);
            return;
        }
    }
}

