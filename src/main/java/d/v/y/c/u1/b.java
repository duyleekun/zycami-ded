/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.u1;

import com.zhiyun.protocol.message.usb.DataType;
import com.zhiyun.protocol.message.usb.LenType;
import d.v.y.c.e0;
import d.v.y.c.u1.b$a;
import d.v.y.d.a;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class b
implements e0 {
    private boolean a;
    private DataType b;
    private LenType c;
    private int d;
    private int e;
    private int f;
    private int g;
    private boolean h;
    private int i;
    private int j;
    private int k;

    private byte[] m() {
        int n10 = this.g;
        boolean bl2 = this.k();
        return d.v.y.d.b.r(n10, 2, bl2);
    }

    private byte[] n() {
        Object[] objectArray = b$a.a;
        int bl2 = this.c.ordinal();
        int n10 = objectArray[bl2];
        boolean bl3 = false;
        int n11 = 1;
        if (n10 != n11) {
            int n12 = 2;
            if (n10 != n12) {
                int n13 = 3;
                if (n10 != n13) {
                    return new byte[0];
                }
                n10 = this.k;
                boolean bl4 = this.k();
                return d.v.y.d.b.r(n10, 4, bl4);
            }
            n10 = this.k;
            boolean bl5 = this.k();
            return d.v.y.d.b.r(n10, n12, bl5);
        }
        objectArray = new byte[n11];
        byte by2 = (byte)this.k;
        objectArray[0] = by2;
        return objectArray;
    }

    private byte[] o() {
        int n10 = this.f;
        boolean bl2 = this.k();
        return d.v.y.d.b.r(n10, 2, bl2);
    }

    private byte[] p() {
        int n10 = this.a;
        int n11 = 1;
        n10 = n10 != 0 ? n11 : 0;
        n11 = DataType.toValue(this.b) << 1;
        n10 |= n11;
        n11 = LenType.toValue(this.c) << 3;
        boolean bl2 = this.k();
        return d.v.y.d.b.r(n10 |= n11, 2, bl2);
    }

    private boolean w(byte[] byArray) {
        byte bl2 = byArray.length;
        byte bl3 = 6;
        if (bl2 >= bl3) {
            bl2 = byArray[4];
            int n10 = byArray[5];
            boolean bl4 = this.k();
            this.g = n10 = d.v.y.d.b.w(bl2, (byte)n10, bl4);
            return true;
        }
        return false;
    }

    private boolean x(byte[] object) {
        int n10;
        int n11;
        int n12;
        Object object2 = this.c;
        LenType lenType = LenType.BIT_1;
        int n13 = 7;
        boolean bl2 = true;
        int n14 = 6;
        if (object2 == lenType && (n12 = ((byte[])object).length) >= n13) {
            int n15;
            this.k = n15 = object[n14];
            return bl2;
        }
        lenType = LenType.BIT_2;
        if (object2 == lenType && (n12 = ((byte[])object).length) >= (n11 = 8)) {
            int n16 = object[n14];
            n12 = object[n13];
            n13 = (int)(this.k() ? 1 : 0);
            this.k = n16 = d.v.y.d.b.m((byte)n16, (byte)n12, n13 != 0);
            object = ByteBuffer.wrap((byte[])object);
            n16 = (int)(this.k() ? 1 : 0);
            object2 = n16 != 0 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN;
            ((ByteBuffer)object).order((ByteOrder)object2);
            ((ByteBuffer)object).position(n14);
            short s10 = ((ByteBuffer)object).getShort();
            this.k = s10;
            return bl2;
        }
        lenType = LenType.BIT_4;
        if (object2 == lenType && (n10 = ((byte[])object).length) >= (n12 = 10)) {
            int n17;
            object = ByteBuffer.wrap((byte[])object);
            n10 = (int)(this.k() ? 1 : 0);
            object2 = n10 != 0 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN;
            ((ByteBuffer)object).order((ByteOrder)object2);
            ((ByteBuffer)object).position(n14);
            this.k = n17 = ((ByteBuffer)object).getInt();
            return bl2;
        }
        return false;
    }

    private boolean y(byte[] byArray) {
        byte bl2 = byArray.length;
        byte bl3 = 4;
        if (bl2 >= bl3) {
            bl2 = byArray[2];
            int n10 = byArray[3];
            boolean bl4 = this.k();
            this.f = n10 = d.v.y.d.b.w(bl2, (byte)n10, bl4);
            return true;
        }
        return false;
    }

    private boolean z(byte[] object) {
        int n10 = ((byte[])object).length;
        int n11 = 0;
        int n12 = 2;
        if (n10 >= n12) {
            Enum enum_;
            n10 = object[0];
            n12 = 1;
            int n13 = object[n12];
            boolean bl2 = this.k();
            if ((n10 = (n13 = d.v.y.d.b.w((byte)n10, (byte)n13, bl2)) & 1) == n12) {
                n10 = n12;
            } else {
                n10 = 0;
                enum_ = null;
            }
            this.a = n10;
            n10 = n13 >>> 1 & 3;
            enum_ = DataType.toType(n10);
            this.b = enum_;
            n13 = n13 >>> 3 & 3;
            object = (Object)LenType.toType(n13);
            this.c = (LenType)((Object)object);
            enum_ = this.b;
            DataType dataType = DataType.UNKNOWN;
            if (enum_ != dataType && object != (enum_ = LenType.UNKNOWN)) {
                n11 = n12;
            }
        }
        return n11 != 0;
    }

    public byte[] a() {
        byte[] byArray = this.p();
        byte[] byArray2 = this.o();
        byte[] byArray3 = this.m();
        byte[] byArray4 = this.n();
        byte[][] byArrayArray = new byte[][]{byArray2, byArray3, byArray4};
        return d.v.y.d.a.a(byArray, byArrayArray);
    }

    public void b(int n10) {
        this.k = n10;
    }

    public int c() {
        return this.k;
    }

    public void clear() {
        this.a = false;
        Enum enum_ = DataType.UNKNOWN;
        this.b = enum_;
        this.c = enum_ = LenType.UNKNOWN;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.k = 0;
    }

    public void d(int n10) {
        this.i = n10;
    }

    public int e() {
        return this.i;
    }

    public int f() {
        return this.g;
    }

    public DataType g() {
        return this.b;
    }

    public int h() {
        return this.d;
    }

    public LenType i() {
        return this.c;
    }

    public int j() {
        return this.f;
    }

    public boolean k() {
        return this.h;
    }

    public boolean l() {
        return this.a;
    }

    public boolean parseFrom(byte[] byArray) {
        boolean bl2 = this.z(byArray);
        boolean bl3 = this.y(byArray);
        boolean bl4 = this.w(byArray);
        boolean bl5 = this.x(byArray);
        if (bl2 && bl3 && bl4 && bl5) {
            bl5 = true;
        } else {
            bl5 = false;
            byArray = null;
        }
        return bl5;
    }

    public void q(boolean bl2) {
        this.h = bl2;
    }

    public void r(int n10) {
        this.g = n10;
    }

    public void s(DataType dataType) {
        this.b = dataType;
    }

    public void t(boolean bl2) {
        this.a = bl2;
    }

    public void u(LenType lenType) {
        this.c = lenType;
    }

    public void v(int n10) {
        this.f = n10;
    }
}

