/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.k;

import com.zhiyun.protocol.message.bl.otherevent.MoveLineStatus;
import d.v.y.c.s1.k.e;
import d.v.y.d.a;

public class d
extends e {
    private MoveLineStatus b;

    public d() {
        MoveLineStatus moveLineStatus;
        this.b = moveLineStatus = MoveLineStatus.QUERY;
    }

    public byte[] a() {
        byte by2;
        int n10 = 1;
        byte[] byArray = new byte[n10];
        byArray[0] = 10;
        byte[] byArray2 = new byte[n10];
        byArray2[0] = by2 = (byte)this.b.value;
        byte[][] byArrayArray = new byte[n10][];
        byArrayArray[0] = byArray2;
        return a.a(byArray, byArrayArray);
    }

    public void clear() {
        MoveLineStatus moveLineStatus;
        this.b = moveLineStatus = MoveLineStatus.STARTED;
    }

    public MoveLineStatus d() {
        return this.b;
    }

    public void e(MoveLineStatus moveLineStatus) {
        this.b = moveLineStatus;
    }

    public boolean parseFrom(byte[] object) {
        int n10 = 0;
        byte by2 = 10;
        byte by3 = object[0];
        if (by2 == by3) {
            n10 = 1;
            byte by4 = object[n10];
            object = (Object)MoveLineStatus.toMoveLineStatus(by4);
            this.b = (MoveLineStatus)((Object)object);
        }
        return n10 != 0;
    }
}

