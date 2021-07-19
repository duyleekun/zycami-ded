/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.n.a.d;

import d.c.a.o.c;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class o$e
implements c {
    private final c c;
    private final int d;

    public o$e(c c10, int n10) {
        this.c = c10;
        this.d = n10;
    }

    public void b(MessageDigest messageDigest) {
        Object object = ByteBuffer.allocate(12);
        int n10 = this.d;
        object = ((ByteBuffer)object).putInt(n10).array();
        messageDigest.update((byte[])object);
        this.c.b(messageDigest);
    }

    public boolean equals(Object object) {
        int n10 = object instanceof o$e;
        boolean bl2 = false;
        if (n10 != 0) {
            int n11;
            object = (o$e)object;
            c c10 = this.c;
            c c11 = ((o$e)object).c;
            n10 = c10.equals(c11);
            if (n10 != 0 && (n10 = this.d) == (n11 = ((o$e)object).d)) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public int hashCode() {
        int n10 = this.c.hashCode() * 31;
        int n11 = this.d;
        return n10 + n11;
    }
}

