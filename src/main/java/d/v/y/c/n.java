/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c;

import com.zhiyun.protocol.message.bl.keyfunc.KeyFunc;
import d.v.y.c.p;
import d.v.y.c.s1.i.a;
import d.v.y.c.s1.i.c;

public class n
extends p {
    public n() {
        c c10 = new c();
        a a10 = new a();
        super(c10, a10);
    }

    public d.v.y.b.a n() {
        return ((a)this.f()).d();
    }

    public KeyFunc o() {
        return ((a)this.f()).e();
    }

    public KeyFunc[] p() {
        return ((a)this.f()).f();
    }

    public void q(d.v.y.b.a a10) {
        ((a)this.f()).g(a10);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BlKeyFuncDefineGetMessage{");
        String string2 = ((a)this.f()).toString();
        stringBuilder.append(string2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

