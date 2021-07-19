/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.c.a.t;

import android.content.Context;
import d.c.a.o.c;
import d.c.a.t.b;
import d.c.a.u.m;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class a
implements c {
    private final int c;
    private final c d;

    private a(int n10, c c10) {
        this.c = n10;
        this.d = c10;
    }

    public static c c(Context context) {
        c c10 = b.c(context);
        int n10 = context.getResources().getConfiguration().uiMode & 0x30;
        a a10 = new a(n10, c10);
        return a10;
    }

    public void b(MessageDigest messageDigest) {
        this.d.b(messageDigest);
        Object object = ByteBuffer.allocate(4);
        int n10 = this.c;
        object = ((ByteBuffer)object).putInt(n10).array();
        messageDigest.update((byte[])object);
    }

    public boolean equals(Object object) {
        int n10 = object instanceof a;
        boolean bl2 = false;
        if (n10 != 0) {
            c c10;
            boolean bl3;
            object = (a)object;
            n10 = this.c;
            int n11 = ((a)object).c;
            if (n10 == n11 && (bl3 = (c10 = this.d).equals(object = ((a)object).d))) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public int hashCode() {
        c c10 = this.d;
        int n10 = this.c;
        return m.p(c10, n10);
    }
}

