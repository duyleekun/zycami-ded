/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c;

import com.zhiyun.protocol.core.entities.ErrorStatus;
import d.v.y.c.p;
import d.v.y.c.s1.j.i;
import d.v.y.c.s1.j.j;

public class m
extends p {
    public static final int d = 0;
    private static final int e = 1;
    public static final int f = 2;

    public m() {
        j j10 = new j();
        i i10 = new i();
        super(j10, i10);
    }

    public int n() {
        return ((i)this.f()).d();
    }

    public ErrorStatus o() {
        return ((i)this.f()).e();
    }

    public boolean p() {
        return ((i)this.f()).f();
    }

    public void q(int n10) {
        ((i)this.f()).h(n10);
    }
}

