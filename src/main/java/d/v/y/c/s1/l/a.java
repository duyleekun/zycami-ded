/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.l;

import com.zhiyun.protocol.constants.ExpandInterface;
import com.zhiyun.protocol.constants.ParamType;
import com.zhiyun.protocol.constants.VID;
import com.zhiyun.protocol.constants.WorkingMode;
import d.v.y.c.s1.l.c;
import d.v.y.c.s1.l.c$a;
import java.nio.ByteBuffer;

public class a
extends d.v.y.c.s1.a {
    private c b;

    public a() {
        c c10;
        this.b = c10 = new c();
    }

    private static boolean d(int n10, int n11) {
        n10 >>>= n11;
        n11 = 1;
        if ((n10 &= n11) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    private void e(int n10) {
    }

    private void f(short s10) {
        int n10 = s10 & 0xF;
        int n11 = (s10 & 0xF0) >>> 4;
        int n12 = (0xF000 & s10) >>> 12;
        int bl2 = 9;
        a.d(s10, bl2);
        boolean bl3 = a.d(s10, bl2);
        boolean bl4 = a.d(s10, 10);
        s10 = (short)(a.d(s10, 11) ? 1 : 0);
        c c10 = this.b;
        Object object = ParamType.from(n10);
        c10.z((ParamType)((Object)object));
        object = this.b;
        Enum enum_ = VID.from(n11);
        ((c)object).D((VID)enum_);
        object = this.b;
        enum_ = ExpandInterface.from(n12);
        ((c)object).y((ExpandInterface)enum_);
        this.b.B(bl3);
        this.b.A(bl4);
        this.b.x(s10 != 0);
    }

    private void g(short s10) {
        WorkingMode workingMode = WorkingMode.from(s10 & 0xF);
        this.b.E(workingMode);
    }

    private void h(short s10) {
        boolean bl2 = a.d(s10, 0);
        boolean bl3 = a.d(s10, 1);
        boolean bl4 = a.d(s10, 2);
        boolean bl5 = a.d(s10, 3);
        boolean bl6 = a.d(s10, 4);
        boolean bl7 = a.d(s10, 5);
        boolean bl8 = a.d(s10, 6);
        boolean bl9 = a.d(s10, 7);
        boolean bl10 = a.d(s10, 8);
        boolean bl11 = a.d(s10, 9);
        boolean bl12 = a.d(s10, 10);
        boolean bl13 = a.d(s10, 11);
        boolean bl14 = a.d(s10, 12);
        boolean bl15 = a.d(s10, 13);
        boolean bl16 = a.d(s10, 14);
        boolean bl17 = a.d(s10, 15);
        c$a c$a = new c$a(bl2, bl3, bl4, bl5, bl6, bl7, bl8, bl9, bl10, bl11, bl12, bl13, bl14, bl15, bl16, bl17);
        this.b.C(c$a);
    }

    public byte[] a() {
        return new byte[0];
    }

    public void clear() {
        c c10;
        this.b = c10 = new c();
    }

    public c i() {
        return this.b;
    }

    public boolean parseFrom(byte[] object) {
        short s10 = ((byte[])object).length;
        short s11 = 10;
        if (s10 >= s11) {
            s10 = (short)(this.b() ? 1 : 0);
            object = d.v.y.d.c.b((byte[])object, s10 != 0);
            s10 = ((ByteBuffer)object).getShort();
            s11 = ((ByteBuffer)object).getShort();
            short s12 = ((ByteBuffer)object).getShort();
            int n10 = ((ByteBuffer)object).getInt();
            this.h(s10);
            this.g(s11);
            this.f(s12);
            this.e(n10);
            return true;
        }
        return false;
    }
}

