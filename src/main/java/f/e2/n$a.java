/*
 * Decompiled with CFR 0.151.
 */
package f.e2;

import f.e2.n;
import f.h2.t.f0;
import f.h2.t.x0.a;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class n$a
implements Iterator,
a {
    private String a;
    private boolean b;
    public final /* synthetic */ n c;

    public n$a(n n10) {
        this.c = n10;
    }

    public String b() {
        boolean bl2 = this.hasNext();
        if (bl2) {
            String string2 = this.a;
            this.a = null;
            f0.m(string2);
            return string2;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public boolean hasNext() {
        boolean bl2;
        String string2 = this.a;
        boolean bl3 = true;
        if (string2 == null && !(bl2 = this.b)) {
            this.a = string2 = n.c(this.c).readLine();
            if (string2 == null) {
                this.b = bl3;
            }
        }
        if ((string2 = this.a) == null) {
            bl3 = false;
        }
        return bl3;
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }
}

