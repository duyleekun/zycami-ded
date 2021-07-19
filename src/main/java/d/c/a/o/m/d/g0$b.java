/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.m.d;

import d.c.a.o.e$b;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class g0$b
implements e$b {
    private final ByteBuffer a;

    public g0$b() {
        ByteBuffer byteBuffer;
        this.a = byteBuffer = ByteBuffer.allocate(4);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(byte[] object, Integer object2, MessageDigest messageDigest) {
        if (object2 == null) {
            return;
        }
        messageDigest.update((byte[])object);
        object = this.a;
        synchronized (object) {
            ByteBuffer byteBuffer = this.a;
            byteBuffer.position(0);
            byteBuffer = this.a;
            int n10 = (Integer)object2;
            object2 = byteBuffer.putInt(n10);
            object2 = ((ByteBuffer)object2).array();
            messageDigest.update((byte[])object2);
            return;
        }
    }
}

