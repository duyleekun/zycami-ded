/*
 * Decompiled with CFR 0.151.
 */
package i.d.u;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class d
implements ThreadFactory {
    private final ThreadFactory a;
    private final AtomicInteger b;
    private final String c;

    public d(String string2) {
        Object object = Executors.defaultThreadFactory();
        this.a = object;
        this.b = object = new AtomicInteger(1);
        this.c = string2;
    }

    public Thread newThread(Runnable runnable) {
        runnable = this.a.newThread(runnable);
        CharSequence charSequence = new StringBuilder();
        Object object = this.c;
        charSequence.append((String)object);
        charSequence.append("-");
        object = this.b;
        charSequence.append(object);
        charSequence = charSequence.toString();
        ((Thread)runnable).setName((String)charSequence);
        return runnable;
    }
}

