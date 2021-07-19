/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.p0;

import d.n.a.p0.b$a;
import e.a.j;
import i.g.d;
import java.nio.ByteBuffer;

public class b
extends j {
    public final ByteBuffer b;
    public final int c;

    public b(byte[] object, int n10) {
        if (n10 > 0) {
            object = ByteBuffer.wrap(object);
            this.b = object;
            this.c = n10;
            return;
        }
        object = new IllegalArgumentException;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("maxBatchSize must be > 0 but found: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        super(string2);
        throw object;
    }

    public void m6(d d10) {
        b$a b$a = new b$a(this);
        j.g3(b$a).subscribe(d10);
    }
}

