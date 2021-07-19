/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c;

import d.v.y.c.e0;
import d.v.y.c.r0;
import d.v.y.c.y;
import java.nio.ByteBuffer;

public abstract class a
implements r0 {
    private e0 a;
    private y b;
    private boolean c;

    public a(e0 e02, y y10) {
        this.a = e02;
        this.b = y10;
    }

    private void i(ByteBuffer byteBuffer) {
        int n10 = byteBuffer.position();
        byteBuffer.reset();
        byteBuffer.position(n10);
    }

    private int j() {
        return this.g().c();
    }

    private int k() {
        return this.g().e();
    }

    private boolean l(ByteBuffer byteBuffer) {
        int n10;
        int n11 = byteBuffer.remaining();
        if (n11 >= (n10 = this.j())) {
            byteBuffer.mark();
            byte[] byArray = new byte[this.j()];
            byteBuffer.get(byArray);
            y y10 = this.b;
            n11 = (int)(y10.parseFrom(byArray) ? 1 : 0);
            if (n11 != 0) {
                this.i(byteBuffer);
                return true;
            }
            byteBuffer.reset();
        }
        return false;
    }

    private boolean m(ByteBuffer byteBuffer) {
        int n10;
        int n11 = byteBuffer.remaining();
        if (n11 >= (n10 = this.k())) {
            byteBuffer.mark();
            byte[] byArray = new byte[this.k()];
            byteBuffer.get(byArray);
            e0 e02 = this.a;
            n11 = (int)(e02.parseFrom(byArray) ? 1 : 0);
            if (n11 != 0) {
                this.i(byteBuffer);
                return true;
            }
            byteBuffer.reset();
        }
        return false;
    }

    public byte[] a() {
        byte[] byArray = this.b.a();
        Object object = this.a;
        int n10 = byArray.length;
        int n11 = 2;
        object.b(n10 += n11);
        object = this.a.a();
        byte[] byArray2 = this.h((byte[])object, byArray);
        byte[][] byArrayArray = new byte[n11][];
        byArrayArray[0] = byArray;
        byArrayArray[1] = byArray2;
        return d.v.y.d.a.a((byte[])object, byArrayArray);
    }

    public boolean b() {
        return this.c;
    }

    public void c(boolean bl2) {
        this.c = bl2;
    }

    public void clear() {
        this.f().clear();
        this.g().clear();
    }

    public void d(e0 e02) {
        this.a = e02;
    }

    public void e(y y10) {
        this.b = y10;
    }

    public y f() {
        return this.b;
    }

    public e0 g() {
        return this.a;
    }

    public int getLength() {
        int n10 = this.a.e();
        int n11 = this.a.c();
        return n10 + n11 + 2;
    }

    public abstract byte[] h(byte[] var1, byte[] var2);

    public boolean parseFrom(ByteBuffer byteBuffer) {
        boolean bl2 = this.m(byteBuffer);
        if (bl2 && (bl2 = this.l(byteBuffer))) {
            byteBuffer.getShort();
            return true;
        }
        return false;
    }

    public boolean parseFrom(byte[] byArray) {
        block12: {
            int n10;
            e0 e02;
            block11: {
                try {
                    e02 = this.a;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    return false;
                }
                n10 = e02.parseFrom(byArray);
                if (n10 != 0) break block11;
                return false;
            }
            e02 = this.a;
            n10 = e02.e();
            e0 e03 = this.a;
            int n11 = e03.c();
            if (byArray == null) break block12;
            int n12 = byArray.length;
            int n13 = n10 + n11;
            if (n12 < n13) break block12;
            y y10 = this.b;
            byArray = d.v.y.d.a.e(byArray, n10, n11);
            return y10.parseFrom(byArray);
        }
        return false;
    }
}

