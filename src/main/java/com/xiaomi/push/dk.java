/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.al$b;
import com.xiaomi.push.di;
import com.xiaomi.push.di$b;
import java.util.concurrent.ConcurrentLinkedQueue;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class dk
extends al$b {
    public al$b a;
    public final /* synthetic */ di a;

    public dk(di di2) {
        this.a = di2;
    }

    public void b() {
        boolean bl2;
        al$b al$b = (di$b)di.a(this.a).peek();
        if (al$b != null && (bl2 = ((di$b)al$b).a())) {
            ConcurrentLinkedQueue concurrentLinkedQueue = di.a(this.a);
            bl2 = concurrentLinkedQueue.remove(al$b);
            if (bl2) {
                this.a = al$b;
            }
            if ((al$b = this.a) != null) {
                al$b.b();
            }
        }
    }

    public void c() {
        al$b al$b = this.a;
        if (al$b != null) {
            al$b.c();
        }
    }
}

