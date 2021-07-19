/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.m.d;

import d.c.a.o.e$b;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class g0$a
implements e$b {
    private final ByteBuffer a;

    public g0$a() {
        ByteBuffer byteBuffer;
        this.a = byteBuffer = ByteBuffer.allocate(8);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(byte[] object, Long object2, MessageDigest messageDigest) {
        messageDigest.update((byte[])object);
        object = this.a;
        synchronized (object) {
            ByteBuffer byteBuffer = this.a;
            byteBuffer.position(0);
            byteBuffer = this.a;
            long l10 = (Long)object2;
            object2 = byteBuffer.putLong(l10);
            object2 = ((ByteBuffer)object2).array();
            messageDigest.update((byte[])object2);
            return;
        }
    }
}

