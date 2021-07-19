/*
 * Decompiled with CFR 0.151.
 */
package i.h;

import i.h.e;
import i.h.e$a;
import java.io.Closeable;

public class e$b
implements Closeable {
    private final String a;

    private e$b(String string2) {
        this.a = string2;
    }

    public /* synthetic */ e$b(String string2, e$a e$a) {
        this(string2);
    }

    public void close() {
        e.h(this.a);
    }
}

