/*
 * Decompiled with CFR 0.151.
 */
package d.v.a0;

import com.zhiyun.proto.ZYEnumDefine$ConnectAction;
import com.zhiyun.proto.ZYEnumDefine$EventTypeAction;
import d.v.a0.f1;
import d.v.a0.h1;
import d.v.a0.j1;
import d.v.a0.m1$a;
import d.v.a0.n1.c;
import d.v.a0.n1.g.w;
import d.v.a0.n1.h.b;
import d.v.z.l.i;
import java.util.Collections;
import java.util.Map;

public class m1
extends j1 {
    public static m1 o() {
        return m1$a.a();
    }

    public void A() {
        boolean bl2 = this.a();
        if (bl2) {
            return;
        }
        this.a.i();
    }

    public void j(w w10) {
        boolean bl2 = this.a();
        if (bl2) {
            return;
        }
        this.a.o(w10);
    }

    public void k(String string2) {
        boolean bl2 = this.a();
        if (bl2) {
            return;
        }
        f1 f12 = this.a;
        ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction = ZYEnumDefine$ConnectAction.ConnectActionAgree;
        f12.b(string2, zYEnumDefine$ConnectAction, null);
    }

    public void l(int n10, d.v.a0.n1.b b10) {
        boolean bl2 = this.a();
        if (bl2) {
            return;
        }
        this.a.n(6060, n10, false, b10);
    }

    public void m(String string2) {
        boolean bl2 = this.a();
        if (!bl2 && (bl2 = this.q(string2))) {
            f1 f12 = this.a;
            ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction = ZYEnumDefine$ConnectAction.ConnectActionDisconnect;
            f12.b(string2, zYEnumDefine$ConnectAction, null);
        }
    }

    public Map n() {
        boolean bl2 = this.a();
        Map map = bl2 ? Collections.emptyMap() : this.a.e();
        return map;
    }

    public boolean p() {
        f1 f12;
        boolean bl2 = this.a();
        if (!bl2 && (bl2 = (f12 = this.a).h())) {
            bl2 = true;
        } else {
            bl2 = false;
            f12 = null;
        }
        return bl2;
    }

    public boolean q(String string2) {
        f1 f12;
        boolean bl2;
        boolean bl3 = this.a();
        if (!bl3 && (bl2 = (f12 = this.a).a(string2))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public void r(String string2, i i10) {
        boolean bl2 = this.a();
        if (!bl2 && (bl2 = this.q(string2))) {
            ZYEnumDefine$EventTypeAction zYEnumDefine$EventTypeAction = ZYEnumDefine$EventTypeAction.EventTypeActionNoti;
            i10.Z(zYEnumDefine$EventTypeAction);
            f1 f12 = this.a;
            f12.g(string2, i10, false, null, null);
        }
    }

    public void s(String string2, String string3) {
        boolean bl2 = this.a();
        if (bl2) {
            return;
        }
        f1 f12 = this.a;
        ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction = ZYEnumDefine$ConnectAction.ConnectActionReject;
        f12.b(string2, zYEnumDefine$ConnectAction, string3);
    }

    public void t(w w10) {
        boolean bl2 = this.a();
        if (bl2) {
            return;
        }
        this.a.A(w10);
    }

    public void u(String string2, h1 h12, i i10) {
        boolean bl2 = this.a();
        if (!bl2 && (bl2 = this.q(string2))) {
            ZYEnumDefine$EventTypeAction zYEnumDefine$EventTypeAction = ZYEnumDefine$EventTypeAction.EventTypeActionRead;
            i10.Z(zYEnumDefine$EventTypeAction);
            f1 f12 = this.a;
            boolean bl3 = true;
            f12.g(string2, i10, bl3, h12, null);
        }
    }

    public void v(String string2, h1 h12, i i10) {
        boolean bl2 = this.a();
        if (!bl2 && (bl2 = this.q(string2))) {
            ZYEnumDefine$EventTypeAction zYEnumDefine$EventTypeAction = ZYEnumDefine$EventTypeAction.EventTypeActionWrite;
            i10.Z(zYEnumDefine$EventTypeAction);
            f1 f12 = this.a;
            boolean bl3 = true;
            f12.g(string2, i10, bl3, h12, null);
        }
    }

    public void w(c c10) {
        boolean bl2 = this.a();
        if (bl2) {
            return;
        }
        this.a.q(c10);
    }

    public void x(b b10) {
        boolean bl2 = this.a();
        if (bl2) {
            return;
        }
        this.a.r(b10);
    }

    public void y() {
        boolean bl2 = this.a();
        if (bl2) {
            return;
        }
        this.a.j();
    }

    public void z() {
        boolean bl2 = this.a();
        if (bl2) {
            return;
        }
        this.a.v();
    }
}

