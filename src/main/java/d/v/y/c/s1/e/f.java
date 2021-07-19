/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.e;

import com.zhiyun.protocol.message.bl.active.ActiveState;
import d.v.y.c.s1.a;
import d.v.y.c.s1.e.c;
import d.v.y.d.b;
import d.v.y.d.d;
import java.io.PrintStream;

public class f
extends a {
    private ActiveState b;
    private int c;
    private int d;
    private byte[] e;
    private c f;

    public f() {
        Object object;
        this.b = object = ActiveState.INACTIVATED;
        object = new byte[11];
        this.e = (byte[])object;
    }

    public byte[] a() {
        byte by2;
        int n10 = 1;
        byte[] byArray = new byte[n10];
        byArray[0] = 20;
        int n11 = this.c % 2000 << 9;
        int n12 = this.d;
        n11 |= n12;
        n12 = (int)(this.b() ? 1 : 0);
        int n13 = 2;
        byte[] byArray2 = d.v.y.d.b.r(n11, n13, n12 != 0);
        Object object = new byte[n10];
        object[0] = by2 = (byte)this.b.code;
        Object object2 = new byte[n13][];
        Object object3 = this.e;
        object2[0] = object3;
        object2[n10] = byArray2;
        byArray2 = d.v.y.d.a.a((byte[])object, (byte[][])object2);
        n12 = this.b();
        byArray2 = d.v.y.d.d.c(byArray2, n12 != 0);
        object = System.out;
        object2 = new StringBuilder;
        ((StringBuilder)object2)();
        ((StringBuilder)object2).append("crc = ");
        object3 = d.v.y.d.a.h(byArray2);
        ((StringBuilder)object2).append((String)object3);
        object2 = ((StringBuilder)object2).toString();
        ((PrintStream)object).println((String)object2);
        byte[][] byArrayArray = new byte[n10][];
        byArray2 = this.f.a(byArray2);
        byArrayArray[0] = byArray2;
        return d.v.y.d.a.a(byArray, byArrayArray);
    }

    public void clear() {
        this.c = 0;
        this.d = 0;
        Object object = new byte[11];
        this.e = object;
        object = (Object)ActiveState.INACTIVATED;
        this.b = (ActiveState)((Object)object);
    }

    public ActiveState d() {
        return this.b;
    }

    public void e(int n10) {
        this.d = n10;
    }

    public void f(c c10) {
        this.f = c10;
    }

    public void g(byte[] byArray) {
        this.e = byArray;
    }

    public void h(ActiveState activeState) {
        this.b = activeState;
    }

    public void i(int n10) {
        this.c = n10;
    }

    public boolean parseFrom(byte[] object) {
        boolean bl2 = false;
        byte by2 = object[0];
        byte by3 = 20;
        if (by2 != by3) {
            return false;
        }
        bl2 = true;
        object = (Object)ActiveState.from(object[bl2]);
        this.b = (ActiveState)((Object)object);
        return bl2;
    }
}

