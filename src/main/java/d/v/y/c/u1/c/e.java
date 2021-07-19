/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.u1.c;

import com.zhiyun.protocol.message.usb.command.CmdType;
import d.v.y.c.u1.c.b;
import d.v.y.d.a;

public class e
extends b {
    private byte c;
    private byte d;
    private int e;
    private int f;

    public byte[] a() {
        int by2;
        int n10;
        long l10 = System.nanoTime();
        long l11 = 1000000000L;
        this.e = n10 = (int)(l10 / l11);
        this.f = by2 = (int)(l10 % l11);
        byte by3 = 16;
        this.c = by3;
        byte by4 = 2;
        this.d = by4;
        byte by5 = this.b();
        byte by6 = d.v.y.d.b.m(by3, by4, by5 != 0);
        by5 = (byte)CmdType.toValue(this.b);
        int n11 = this.e;
        n10 = (int)(this.b() ? 1 : 0);
        byte[] byArray = d.v.y.d.b.s(n11, n10 != 0);
        n10 = this.f;
        boolean bl2 = this.b();
        byte[] byArray2 = d.v.y.d.b.s(n10, bl2);
        int n12 = 1;
        byte[] byArray3 = new byte[n12];
        byArray3[0] = by5;
        byte[][] byArrayArray = new byte[3][];
        byte[] byArray4 = new byte[n12];
        byArray4[0] = by6;
        byArrayArray[0] = byArray4;
        byArrayArray[n12] = byArray;
        byArrayArray[by4] = byArray2;
        return a.a(byArray3, byArrayArray);
    }

    public void clear() {
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
    }

    public int f() {
        return this.e;
    }

    public int g() {
        return this.f;
    }

    public boolean h() {
        byte by2 = this.d;
        byte by3 = 1;
        if (by2 != by3) {
            by3 = 0;
        }
        return by3 != 0;
    }

    public boolean parseFrom(byte[] byArray) {
        block22: {
            boolean bl2;
            try {
                bl2 = byArray[0];
            }
            catch (Exception exception) {}
            CmdType cmdType = CmdType.toType((int)(bl2 ? 1 : 0));
            this.b = cmdType;
            CmdType cmdType2 = CmdType.PING;
            if (cmdType != cmdType2) break block22;
            bl2 = true;
            int by2 = byArray[bl2] & 0xF0;
            byte by3 = 4;
            byte by4 = (byte)(by2 >>> by3);
            this.c = by4;
            byte by5 = (byte)(byArray[bl2] & 0xF);
            this.d = by5;
            int n10 = 2;
            byte by6 = byArray[n10];
            byte by7 = 3;
            by7 = byArray[by7];
            by3 = byArray[by3];
            int n11 = 5;
            byte by8 = byArray[n11];
            boolean bl3 = this.b();
            int n12 = d.v.y.d.b.u(by6, by7, by3, by8, bl3);
            this.e = n12;
            int n13 = 6;
            byte by9 = byArray[n13];
            by3 = 7;
            by3 = byArray[by3];
            by7 = 8;
            by7 = byArray[by7];
            int n14 = 9;
            int n15 = byArray[n14];
            boolean bl4 = this.b();
            n15 = d.v.y.d.b.u(by9, by3, by7, (byte)n15, bl4);
            this.f = n15;
            return bl2;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Ping{sender=");
        int n10 = this.c;
        stringBuilder.append(n10);
        stringBuilder.append(", answer=");
        n10 = this.d;
        stringBuilder.append(n10);
        stringBuilder.append(", sec=");
        n10 = this.e;
        stringBuilder.append(n10);
        stringBuilder.append(", usec=");
        n10 = this.f;
        stringBuilder.append(n10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

