/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.c.a.o.k.z;

import android.text.TextUtils;
import d.c.a.o.k.z.a;
import d.c.a.o.k.z.a$b;
import d.c.a.o.k.z.a$c;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class a$a {
    public static final long g;
    private final boolean a;
    private int b;
    private int c;
    private a$c d;
    private String e;
    private long f;

    public a$a(boolean bl2) {
        a$c a$c;
        this.d = a$c = a$c.d;
        this.a = bl2;
    }

    public a a() {
        Object object = this.e;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            int n10 = this.b;
            int n11 = this.c;
            long l10 = this.f;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            PriorityBlockingQueue<Runnable> priorityBlockingQueue = new PriorityBlockingQueue<Runnable>();
            Object object2 = this.e;
            a$c a$c = this.d;
            boolean bl3 = this.a;
            a$b a$b = new a$b((String)object2, a$c, bl3);
            object2 = object;
            object = new ThreadPoolExecutor(n10, n11, l10, timeUnit, priorityBlockingQueue, a$b);
            long l11 = this.f;
            long l12 = 0L;
            long l13 = l11 - l12;
            Object object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object3 != false) {
                object3 = 1;
                ((ThreadPoolExecutor)object).allowCoreThreadTimeOut((boolean)object3);
            }
            object2 = new a((ExecutorService)object);
            return object2;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Name must be non-null and non-empty, but given: ");
        String string2 = this.e;
        charSequence.append(string2);
        charSequence = charSequence.toString();
        object = new IllegalArgumentException((String)charSequence);
        throw object;
    }

    public a$a b(String string2) {
        this.e = string2;
        return this;
    }

    public a$a c(int n10) {
        this.b = n10;
        this.c = n10;
        return this;
    }

    public a$a d(long l10) {
        this.f = l10;
        return this;
    }

    public a$a e(a$c a$c) {
        this.d = a$c;
        return this;
    }
}

