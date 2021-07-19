/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.l;

import com.zhiyun.protocol.constants.ExpandInterface;
import com.zhiyun.protocol.constants.ParamType;
import com.zhiyun.protocol.constants.VID;
import com.zhiyun.protocol.constants.WorkingMode;
import d.v.y.c.s1.l.c$a;

public class c {
    private c$a a;
    private ParamType b;
    private VID c;
    private WorkingMode d;
    private ExpandInterface e;
    private boolean f;
    private boolean g;
    private boolean h;

    public void A(boolean bl2) {
        this.g = bl2;
    }

    public void B(boolean bl2) {
        this.f = bl2;
    }

    public void C(c$a c$a) {
        this.a = c$a;
    }

    public void D(VID vID) {
        this.c = vID;
    }

    public void E(WorkingMode workingMode) {
        this.d = workingMode;
    }

    public ExpandInterface a() {
        return this.e;
    }

    public ParamType b() {
        return this.b;
    }

    public VID c() {
        return this.c;
    }

    public WorkingMode d() {
        return this.d;
    }

    public boolean e() {
        return c$a.l(this.a);
    }

    public boolean f() {
        return c$a.i(this.a);
    }

    public boolean g() {
        return c$a.m(this.a);
    }

    public boolean h() {
        return this.h;
    }

    public boolean i() {
        return c$a.n(this.a);
    }

    public boolean j() {
        return c$a.b(this.a);
    }

    public boolean k() {
        return c$a.e(this.a);
    }

    public boolean l() {
        return c$a.o(this.a);
    }

    public boolean m() {
        return c$a.j(this.a);
    }

    public boolean n() {
        return c$a.p(this.a);
    }

    public boolean o() {
        return c$a.c(this.a);
    }

    public boolean p() {
        return c$a.d(this.a);
    }

    public boolean q() {
        return c$a.g(this.a);
    }

    public boolean r() {
        return c$a.k(this.a);
    }

    public boolean s() {
        return this.g;
    }

    public boolean t() {
        return this.f;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RdisParams{");
        Object object = this.a.toString();
        stringBuilder.append((String)object);
        stringBuilder.append(", paramType=");
        object = this.b;
        stringBuilder.append(object);
        stringBuilder.append(", vid=");
        object = this.c;
        stringBuilder.append(object);
        stringBuilder.append(", workingMode=");
        object = this.d;
        stringBuilder.append(object);
        stringBuilder.append(", expandInterface=");
        object = this.e;
        stringBuilder.append(object);
        stringBuilder.append(", recording=");
        boolean bl2 = this.f;
        stringBuilder.append(bl2);
        stringBuilder.append(", preview=");
        bl2 = this.g;
        stringBuilder.append(bl2);
        stringBuilder.append(", cameraConnected=");
        bl2 = this.h;
        stringBuilder.append(bl2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public boolean u() {
        return c$a.a(this.a);
    }

    public boolean v() {
        return c$a.f(this.a);
    }

    public boolean w() {
        return c$a.h(this.a);
    }

    public void x(boolean bl2) {
        this.h = bl2;
    }

    public void y(ExpandInterface expandInterface) {
        this.e = expandInterface;
    }

    public void z(ParamType paramType) {
        this.b = paramType;
    }
}

