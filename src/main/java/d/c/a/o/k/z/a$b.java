/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k.z;

import d.c.a.o.k.z.a$b$a;
import d.c.a.o.k.z.a$c;
import java.util.concurrent.ThreadFactory;

public final class a$b
implements ThreadFactory {
    private static final int e = 9;
    private final String a;
    public final a$c b;
    public final boolean c;
    private int d;

    public a$b(String string2, a$c a$c, boolean bl2) {
        this.a = string2;
        this.b = a$c;
        this.c = bl2;
    }

    public Thread newThread(Runnable runnable) {
        synchronized (this) {
            CharSequence charSequence = new StringBuilder();
            String string2 = "glide-";
            charSequence.append(string2);
            string2 = this.a;
            charSequence.append(string2);
            string2 = "-thread-";
            charSequence.append(string2);
            int n10 = this.d;
            charSequence.append(n10);
            charSequence = charSequence.toString();
            a$b$a a$b$a = new a$b$a(this, runnable, (String)charSequence);
            int n11 = this.d + 1;
            this.d = n11;
            return a$b$a;
        }
    }
}

