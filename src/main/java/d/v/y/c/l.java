/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c;

import com.zhiyun.protocol.message.bl.file.Direction;
import com.zhiyun.protocol.message.bl.file.FileType;
import d.v.y.c.p;
import d.v.y.c.s1.h.a;
import d.v.y.c.s1.h.b;

public class l
extends p {
    public l() {
        b b10 = new b();
        a a10 = new a();
        super(b10, a10);
    }

    public String n() {
        return ((a)this.f()).f();
    }

    public Direction o() {
        return ((a)this.f()).g();
    }

    public int p() {
        return ((a)this.f()).h();
    }

    public FileType q() {
        return ((a)this.f()).j();
    }

    public int r() {
        return ((a)this.f()).k();
    }

    public void s(String string2) {
        ((a)this.f()).l(string2);
    }

    public void t(Direction direction) {
        ((a)this.f()).m(direction);
    }

    public void u(int n10) {
        ((a)this.f()).n(n10);
    }

    public void v(FileType fileType) {
        ((a)this.f()).o(fileType);
    }

    public void w(int n10) {
        ((a)this.f()).p(n10);
    }
}

