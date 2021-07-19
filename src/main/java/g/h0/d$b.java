/*
 * Decompiled with CFR 0.151.
 */
package g.h0;

import java.util.concurrent.ThreadFactory;

public final class d$b
implements ThreadFactory {
    public final /* synthetic */ String a;
    public final /* synthetic */ boolean b;

    public d$b(String string2, boolean bl2) {
        this.a = string2;
        this.b = bl2;
    }

    public final Thread newThread(Runnable runnable) {
        String string2 = this.a;
        Thread thread = new Thread(runnable, string2);
        boolean bl2 = this.b;
        thread.setDaemon(bl2);
        return thread;
    }
}

