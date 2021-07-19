/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.u;

import java.io.FilterInputStream;
import java.io.InputStream;

public class i
extends FilterInputStream {
    private static final int b = Integer.MIN_VALUE;
    private static final int c = 255;
    private int a = -1 << -1;

    public i(InputStream inputStream) {
        super(inputStream);
    }

    private long a(long l10) {
        long l11;
        long l12;
        int n10 = this.a;
        if (n10 == 0) {
            return -1;
        }
        int n11 = -1 << -1;
        if (n10 != n11 && (n11 = (int)((l12 = l10 - (l11 = (long)n10)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) > 0) {
            l10 = n10;
        }
        return l10;
    }

    private void h(long l10) {
        long l11;
        long l12;
        int n10 = this.a;
        int n11 = -1 << -1;
        if (n10 != n11 && (n11 = (int)((l12 = l10 - (l11 = (long)-1)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) != 0) {
            int n12;
            long l13 = (long)n10 - l10;
            this.a = n12 = (int)l13;
        }
    }

    public int available() {
        int n10 = this.a;
        int n11 = -1 << -1;
        if (n10 == n11) {
            n10 = super.available();
        } else {
            n11 = super.available();
            n10 = Math.min(n10, n11);
        }
        return n10;
    }

    public void mark(int n10) {
        synchronized (this) {
            super.mark(n10);
            this.a = n10;
            return;
        }
    }

    public int read() {
        long l10;
        long l11 = 1L;
        long l12 = this.a(l11);
        long l13 = l12 - (l10 = (long)-1);
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object == false) {
            return -1;
        }
        object = super.read();
        this.h(l11);
        return (int)object;
    }

    public int read(byte[] byArray, int n10, int n11) {
        int n12;
        long l10 = n11;
        n11 = (int)(l10 = this.a(l10));
        if (n11 == (n12 = -1)) {
            return n12;
        }
        int n13 = super.read(byArray, n10, n11);
        long l11 = n13;
        this.h(l11);
        return n13;
    }

    public void reset() {
        synchronized (this) {
            super.reset();
            int n10 = -1 << -1;
            this.a = n10;
            return;
        }
    }

    public long skip(long l10) {
        long l11;
        long l12 = (l10 = this.a(l10)) - (l11 = (long)-1);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            return 0L;
        }
        l10 = super.skip(l10);
        this.h(l10);
        return l10;
    }
}

