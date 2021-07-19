/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.a;

import d.v.y.a.b;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class a
extends b {
    private static final int c = 2;
    private static final int d = 2;
    private static final int e = 4;
    private static final int f = 2;
    private static final int g = 15908;
    private static final int h = 15396;

    public a() {
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        super(5120, byteOrder);
    }

    public void c() {
        while (true) {
            Object object;
            ByteBuffer byteBuffer;
            int n10;
            block9: {
                block6: {
                    int n11;
                    ByteBuffer byteBuffer2;
                    int n12;
                    block8: {
                        block7: {
                            ByteBuffer byteBuffer3;
                            int n13;
                            if ((n12 = this.d()) == 0 || (n10 = this.e(n12 = 4)) == 0) break block6;
                            this.a.mark();
                            n10 = 0;
                            byteBuffer = null;
                            byteBuffer2 = this.a;
                            n11 = byteBuffer2.position();
                            while ((n13 = (byteBuffer3 = this.a).remaining()) > n12) {
                                this.a.get();
                                byteBuffer3 = this.a;
                                n13 = byteBuffer3.getShort(n11);
                                int n14 = 15908;
                                if (n13 != n14 && n13 != (n14 = 15396)) {
                                    ++n11;
                                    continue;
                                }
                                n10 = 1;
                                break;
                            }
                            byteBuffer2 = this.a;
                            byteBuffer2.get();
                            if (n10 != 0) break block7;
                            this.a.reset();
                            object = this.a;
                            ((ByteBuffer)object).compact();
                            break block6;
                        }
                        byteBuffer = this.a;
                        n10 = byteBuffer.remaining();
                        if (n10 >= (n11 = 2)) break block8;
                        this.a.reset();
                        object = this.a;
                        ((ByteBuffer)object).compact();
                        break block6;
                    }
                    byteBuffer = this.a;
                    n10 = byteBuffer.getShort() + n12 + n11;
                    byteBuffer2 = this.a;
                    n11 = byteBuffer2.position() - n12;
                    this.a.position(n11);
                    object = this.a;
                    n12 = ((Buffer)object).remaining();
                    if (n12 >= n10) break block9;
                    this.a.reset();
                    object = this.a;
                    ((ByteBuffer)object).compact();
                }
                return;
            }
            object = new byte[n10];
            byteBuffer = this.a;
            byteBuffer.get((byte[])object);
            this.b((byte[])object);
        }
    }
}

