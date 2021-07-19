/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.t;

import d.c.a.o.c;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.MessageDigest;

public class d
implements c {
    private final String c;
    private final long d;
    private final int e;

    public d(String string2, long l10, int n10) {
        if (string2 == null) {
            string2 = "";
        }
        this.c = string2;
        this.d = l10;
        this.e = n10;
    }

    public void b(MessageDigest messageDigest) {
        Object object = ByteBuffer.allocate(12);
        long l10 = this.d;
        object = ((ByteBuffer)object).putLong(l10);
        int n10 = this.e;
        object = ((ByteBuffer)object).putInt(n10).array();
        messageDigest.update((byte[])object);
        object = this.c;
        Charset charset = d.c.a.o.c.b;
        object = ((String)object).getBytes(charset);
        messageDigest.update((byte[])object);
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Object object2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (object2 = this.getClass()) == (clazz = object.getClass())) {
            object = (d)object;
            long l10 = this.d;
            long l11 = ((d)object).d;
            long l12 = l10 - l11;
            Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object3 != false) {
                return false;
            }
            object3 = this.e;
            int n10 = ((d)object).e;
            if (object3 != n10) {
                return false;
            }
            object2 = this.c;
            object = ((d)object).c;
            boolean bl3 = ((String)object2).equals(object);
            if (!bl3) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.c.hashCode() * 31;
        long l10 = this.d;
        long l11 = l10 >>> 32;
        int n11 = (int)(l10 ^ l11);
        n10 = (n10 + n11) * 31;
        n11 = this.e;
        return n10 + n11;
    }
}

