/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k.y;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class c$a {
    public final Lock a;
    public int b;

    public c$a() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.a = reentrantLock;
    }
}

