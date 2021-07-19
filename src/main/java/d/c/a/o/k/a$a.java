/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k;

import d.c.a.o.k.a$a$a;
import java.util.concurrent.ThreadFactory;

public class a$a
implements ThreadFactory {
    public Thread newThread(Runnable runnable) {
        a$a$a a$a$a = new a$a$a(this, runnable);
        Thread thread = new Thread((Runnable)a$a$a, "glide-active-resources");
        return thread;
    }
}

