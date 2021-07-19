/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.a0;

import android.text.TextUtils;
import com.zhiyun.proto.ZYEnumDefine$ConnectAction;
import com.zhiyun.proto.ZYEnumDefine$EventTypeAction;
import d.v.a0.d1$a;
import d.v.a0.f1;
import d.v.a0.j1;
import d.v.a0.n1.c;
import d.v.a0.n1.f;
import d.v.a0.n1.g.v;
import d.v.a0.n1.h.a;
import d.v.z.l.e;
import d.v.z.l.i;

public class d1
extends j1 {
    private e d;

    public static d1 n() {
        return d1$a.a();
    }

    public void i() {
        super.i();
        this.d = null;
    }

    public void j(v v10) {
        boolean bl2 = this.a();
        if (bl2) {
            return;
        }
        this.a.f(v10);
    }

    public void k() {
        boolean bl2 = this.a();
        if (bl2) {
            return;
        }
        f1 f12 = this.a;
        ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction = ZYEnumDefine$ConnectAction.ConnectActionCanecl;
        f12.c(zYEnumDefine$ConnectAction);
    }

    public void l(e object) {
        int n10;
        Object object2;
        int n11 = this.a();
        if (n11 == 0 && (n11 = TextUtils.isEmpty((CharSequence)(object2 = ((e)object).n()))) == 0 && (n11 = ((e)object).o()) != (n10 = -1)) {
            this.d = object;
            object2 = this.a;
            n10 = ((e)object).o();
            object = ((e)object).n();
            object2.y(n10, (String)object);
        }
    }

    public void m() {
        boolean bl2 = this.a();
        if (!bl2 && (bl2 = this.p())) {
            f1 f12 = this.a;
            ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction = ZYEnumDefine$ConnectAction.ConnectActionDisconnect;
            f12.c(zYEnumDefine$ConnectAction);
        }
    }

    public e o() {
        return this.d;
    }

    public boolean p() {
        f1 f12;
        boolean bl2 = this.a();
        if (!bl2 && (bl2 = (f12 = this.a).isConnected())) {
            bl2 = true;
        } else {
            bl2 = false;
            f12 = null;
        }
        return bl2;
    }

    public boolean q() {
        f1 f12;
        boolean bl2 = this.a();
        if (!bl2 && (bl2 = (f12 = this.a).m())) {
            bl2 = true;
        } else {
            bl2 = false;
            f12 = null;
        }
        return bl2;
    }

    public void r(i i10, a a10) {
        boolean bl2 = this.a();
        if (!bl2 && (bl2 = this.p())) {
            if (i10 == null) {
                i10 = new i();
                i10.W();
            }
            Object object = ZYEnumDefine$EventTypeAction.EventTypeActionRead;
            i10.Z((ZYEnumDefine$EventTypeAction)object);
            object = this.a;
            object.x(i10, false, a10);
        }
    }

    public void s(v v10) {
        boolean bl2 = this.a();
        if (bl2) {
            return;
        }
        this.a.w(v10);
    }

    public void t(int n10, f f10) {
        boolean bl2 = this.a();
        if (bl2) {
            return;
        }
        this.a.u(6060, n10, false, f10);
    }

    public void u(d.v.z.l.f f10, c c10) {
        boolean bl2 = this.a();
        if (!bl2 && (bl2 = this.p())) {
            f1 f12 = this.a;
            f12.d(f10, c10);
        }
    }

    public void v(a a10) {
        boolean bl2 = this.a();
        if (bl2) {
            return;
        }
        this.a.k(a10);
    }

    public void w() {
        boolean bl2 = this.a();
        if (bl2) {
            return;
        }
        this.a.z();
    }

    public void x(i i10, a a10) {
        boolean bl2 = this.a();
        if (!bl2 && (bl2 = this.p())) {
            Object object = ZYEnumDefine$EventTypeAction.EventTypeActionWrite;
            i10.Z((ZYEnumDefine$EventTypeAction)object);
            object = this.a;
            object.x(i10, false, a10);
        }
    }
}

