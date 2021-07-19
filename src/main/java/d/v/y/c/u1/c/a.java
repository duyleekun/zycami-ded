/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.u1.c;

import com.zhiyun.protocol.message.usb.command.CmdType;
import d.v.y.c.p;
import d.v.y.c.u1.c.b;

public class a
extends b {
    private p c;

    public byte[] a() {
        byte by2 = (byte)CmdType.toValue(this.b);
        int n10 = 1;
        byte[] byArray = new byte[n10];
        byArray[0] = by2;
        byte[][] byArrayArray = new byte[n10][];
        byte[] byArray2 = this.c.a();
        byArrayArray[0] = byArray2;
        return d.v.y.d.a.a(byArray, byArrayArray);
    }

    public void clear() {
        p p10 = this.c;
        if (p10 != null) {
            p10.clear();
        }
    }

    public p f() {
        return this.c;
    }

    public void g(p p10) {
        this.c = p10;
    }

    public boolean parseFrom(byte[] byArray) {
        boolean bl2;
        int n10 = 0;
        byte by2 = byArray[0];
        Object object = CmdType.toType(by2);
        this.b = object;
        int n11 = byArray.length;
        int n12 = 1;
        CmdType cmdType = CmdType.ZYBL;
        if (object == cmdType && (bl2 = ((d.v.y.c.a)(object = this.c)).parseFrom(byArray = d.v.y.d.a.e(byArray, n12, n11 -= n12)))) {
            n10 = n12;
        }
        return n10 != 0;
    }
}

