/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  android.graphics.RectF
 *  android.net.Uri
 *  android.view.View
 */
package d.v.c.s0;

import android.app.Application;
import android.content.Context;
import android.graphics.RectF;
import android.net.Uri;
import android.view.View;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.data.CameraSet$Guide;
import com.zhiyun.cama.camera.data.CameraSet$Mode;
import com.zhiyun.protocol.constants.Model;
import d.v.c.s0.t6;
import d.v.c.s0.u5;
import d.v.c.s0.v5;
import d.v.c.s0.w5;
import d.v.c.s0.x5;
import d.v.c.v0.n.d;
import d.v.c.v0.u.z;
import d.v.e.i.h;
import d.v.e.l.m2;
import d.v.e.l.m2$b;
import d.v.e.l.m2$d;
import d.v.e.l.s1;
import e.a.q;
import e.a.s0.a;
import e.a.s0.b;

public class s6
extends AndroidViewModel {
    private m2$d A;
    private m2$d B;
    private boolean C;
    public final MutableLiveData a;
    public final MutableLiveData b;
    public int c;
    public int d;
    public final MutableLiveData e;
    public final MutableLiveData f;
    public final MutableLiveData g;
    public final MutableLiveData h;
    public final MutableLiveData i;
    public final MutableLiveData j;
    public final MutableLiveData k;
    public final MutableLiveData l;
    public final MutableLiveData m;
    public final MutableLiveData n;
    public final MutableLiveData o;
    public final MutableLiveData p;
    public final MutableLiveData q;
    private a r;
    public final MutableLiveData s;
    public final MutableLiveData t;
    public final MutableLiveData u;
    public final MutableLiveData v;
    public final MutableLiveData w;
    public final MutableLiveData x;
    private final MutableLiveData y;
    private final MutableLiveData z;

    public s6(Application object) {
        super((Application)object);
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        super();
        this.a = object;
        super();
        this.b = object;
        super();
        this.e = object;
        super();
        this.f = object;
        super();
        this.g = object;
        super();
        this.h = object;
        super();
        this.i = object;
        Boolean bl2 = Boolean.TRUE;
        super(bl2);
        this.j = object;
        super();
        this.k = object;
        super();
        this.l = object;
        super();
        this.m = object;
        this.n = mutableLiveData2 = new MutableLiveData();
        this.o = mutableLiveData = new MutableLiveData();
        this.p = mutableLiveData = new MutableLiveData();
        Object object2 = new MutableLiveData();
        this.q = object2;
        this.r = object2 = new a();
        this.s = object2 = new MutableLiveData();
        this.t = object2 = new MutableLiveData();
        this.u = object2 = new MutableLiveData();
        this.v = object2 = new MutableLiveData();
        Integer n10 = 0;
        this.w = object2 = new MutableLiveData(n10);
        this.x = object2 = new MutableLiveData(n10);
        this.y = object2 = new MutableLiveData();
        this.z = object2 = new MutableLiveData();
        this.C = false;
        mutableLiveData.setValue(bl2);
        ((MutableLiveData)object).setValue(bl2);
        object = Boolean.FALSE;
        mutableLiveData2.setValue(object);
    }

    private /* synthetic */ void A() {
        this.a0(false);
    }

    private /* synthetic */ void G() {
        this.Z(false);
    }

    public static RectF o(View view) {
        float f10 = view.getX();
        float f11 = view.getY();
        float f12 = view.getMeasuredWidth();
        float f13 = view.getMeasuredHeight();
        RectF rectF = new RectF();
        rectF.left = f10;
        rectF.top = f11;
        rectF.right = f10 += f12;
        rectF.bottom = f11 += f13;
        f13 = 50.0f;
        rectF.offset(f13, f13);
        return rectF;
    }

    private /* synthetic */ void w(String string2) {
        string2 = s1.H(string2);
        this.f0(false, string2);
    }

    private /* synthetic */ void y(Throwable throwable) {
        this.f0(false, null);
    }

    public /* synthetic */ void F() {
        this.A();
    }

    public /* synthetic */ void H() {
        this.G();
    }

    public void I() {
        Object object = t6.q((Context)this.getApplication());
        w5 w52 = new w5(this);
        v5 v52 = new v5(this);
        object = ((q)object).c(w52, v52);
        this.r.b((b)object);
    }

    public void J() {
        Object object;
        Object object2 = this.o.getValue();
        if (object2 != null) {
            object2 = this.o;
            object = ((LiveData)object2).getValue();
            ((MutableLiveData)object2).setValue(object);
        }
        if ((object2 = this.q.getValue()) != null) {
            object2 = this.q;
            object = ((LiveData)object2).getValue();
            ((MutableLiveData)object2).setValue(object);
        }
    }

    public void K(boolean bl2) {
        MutableLiveData mutableLiveData = this.v;
        Boolean bl3 = bl2;
        mutableLiveData.setValue(bl3);
    }

    public void L(boolean bl2) {
        d.v.c.v0.u.z.m().G(bl2);
    }

    public void M(Model model) {
        d.v.c.v0.n.d.s().d0(model);
    }

    public void N(int n10) {
        MutableLiveData mutableLiveData = this.u;
        Integer n11 = n10;
        mutableLiveData.setValue(n11);
    }

    public void P(int n10) {
        MutableLiveData mutableLiveData = this.w;
        Integer n11 = n10;
        mutableLiveData.setValue(n11);
    }

    public void Q(boolean bl2) {
        d.v.c.v0.u.z.m().K(bl2);
    }

    public void R(int n10) {
        MutableLiveData mutableLiveData = this.x;
        Integer n11 = n10;
        mutableLiveData.setValue(n11);
    }

    public void S(boolean bl2) {
        d.v.c.v0.u.z.m().L(bl2);
    }

    public void T(int n10) {
        MutableLiveData mutableLiveData = this.t;
        Integer n11 = n10;
        mutableLiveData.setValue(n11);
    }

    public void U(int n10) {
        MutableLiveData mutableLiveData = this.s;
        Integer n11 = n10;
        mutableLiveData.setValue(n11);
    }

    public void V(boolean bl2) {
        d.v.c.v0.u.z.m().Q(bl2);
    }

    public void W(boolean bl2) {
        d.v.c.v0.u.z.m().R(bl2);
    }

    public void X(boolean bl2) {
        d.v.c.v0.u.z.m().W(bl2);
    }

    public void Y(boolean bl2) {
        d.v.c.v0.u.z.m().X(bl2);
    }

    public void Z(boolean bl2) {
        MutableLiveData mutableLiveData = this.z;
        Boolean bl3 = bl2;
        d.v.e.i.h.e(mutableLiveData, bl3);
    }

    public void a0(boolean bl2) {
        MutableLiveData mutableLiveData = this.y;
        Boolean bl3 = bl2;
        d.v.e.i.h.e(mutableLiveData, bl3);
    }

    public void b() {
        m2.a(this.A);
        m2.a(this.B);
    }

    public void b0() {
        Object object = d.v.c.v0.u.z.m();
        boolean bl2 = ((z)object).t();
        if (!bl2) {
            object = this.o;
            CameraSet$Guide cameraSet$Guide = CameraSet$Guide.STORY_CUSTOM_ONE;
            ((MutableLiveData)object).setValue((Object)cameraSet$Guide);
        }
    }

    public void c(boolean bl2, CameraSet$Mode cameraSet$Mode, float f10) {
        Object object;
        if (!bl2 && !(bl2 = this.C) && cameraSet$Mode != (object = CameraSet$Mode.dolly_zoom)) {
            m2.a(this.A);
            object = this.B;
            m2.a((m2$d)object);
            bl2 = true;
            this.a0(bl2);
            this.Z(bl2);
            this.e0();
        }
    }

    public void c0() {
        Object object = d.v.c.v0.u.z.m();
        boolean bl2 = ((z)object).u();
        if (!bl2) {
            object = this.o;
            CameraSet$Guide cameraSet$Guide = CameraSet$Guide.STORY_MORE;
            ((MutableLiveData)object).setValue((Object)cameraSet$Guide);
        }
    }

    public void d() {
        MutableLiveData mutableLiveData = this.f;
        boolean bl2 = mutableLiveData.hasActiveObservers();
        if (bl2) {
            mutableLiveData = this.f;
            Boolean bl3 = Boolean.TRUE;
            mutableLiveData.setValue(bl3);
        }
    }

    public void d0() {
        boolean bl2;
        this.C = bl2 = true;
        m2.a(this.A);
        m2.a(this.B);
        this.a0(bl2);
        this.Z(bl2);
    }

    public MutableLiveData e() {
        return this.v;
    }

    public void e0() {
        this.C = false;
        Object object = new u5(this);
        this.A = object = m2.Y(1000L, (m2$b)object);
        object = new x5(this);
        this.B = object = m2.Y(2000L, (m2$b)object);
    }

    public boolean f() {
        return d.v.c.v0.u.z.m().e();
    }

    public void f0(boolean bl2, String string2) {
        if (bl2 && (bl2 = s1.q(string2))) {
            Application application = this.getApplication();
            t6.b((Context)application, string2);
        }
        this.k.postValue(string2);
    }

    public boolean g() {
        return d.v.c.v0.u.z.m().f();
    }

    public void g0(boolean bl2, Uri object) {
        t6.a((Context)this.getApplication(), object);
        MutableLiveData mutableLiveData = this.k;
        object = s1.G(object);
        mutableLiveData.postValue(object);
    }

    public MutableLiveData i() {
        return this.u;
    }

    public MutableLiveData j() {
        return this.w;
    }

    public boolean k() {
        return d.v.c.v0.u.z.m().k();
    }

    public MutableLiveData l() {
        return this.x;
    }

    public boolean m() {
        return d.v.c.v0.u.z.m().l();
    }

    public MutableLiveData n() {
        return this.t;
    }

    public void onCleared() {
        this.r.e();
        this.a.setValue(null);
        super.onCleared();
    }

    public Integer p() {
        return (Integer)this.s.getValue();
    }

    public boolean r() {
        return d.v.c.v0.u.z.m().z();
    }

    public boolean s() {
        return d.v.c.v0.u.z.m().A();
    }

    public MutableLiveData t() {
        return this.z;
    }

    public MutableLiveData u() {
        return this.y;
    }

    public void v() {
        Object object = this.l.getValue();
        if (object == null) {
            object = this.l;
            Boolean bl2 = Boolean.TRUE;
            ((MutableLiveData)object).setValue(bl2);
        }
    }

    public /* synthetic */ void x(String string2) {
        this.w(string2);
    }

    public /* synthetic */ void z(Throwable throwable) {
        this.y(throwable);
    }
}

