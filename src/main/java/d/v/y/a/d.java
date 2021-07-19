/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.a;

import d.v.y.a.b;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class d
extends b {
    public d() {
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        super(1024, byteOrder);
    }

    public void c() {
        boolean bl2;
        int n10;
        while ((n10 = this.d()) != 0 && (bl2 = this.e(n10 = 7))) {
            byte[] byArray = new byte[n10];
            ByteBuffer byteBuffer = this.a;
            byteBuffer.get(byArray);
            this.b(byArray);
        }
        return;
    }
}

