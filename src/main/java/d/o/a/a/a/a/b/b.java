/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.o.a.a.a.a.b;

import android.content.Context;
import com.quvideo.mobile.external.component.cloudcomposite.core.OooO0o;
import com.quvideo.mobile.external.component.cloudcomposite.core.OooOO0;
import com.quvideo.mobile.external.component.cloudcomposite.model.CompositeFinishResponse;
import com.quvideo.mobile.external.component.cloudcomposite.model.CompositePreResponse;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.ICompositeTask;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.OnCompositeListener;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.OnCompositeListener$State;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.OooO00o;
import com.quvideo.mobile.external.component.cloudengine.model.RequestError;
import com.quvideo.mobile.external.platform.api.cloudengine.OooO0O0;
import com.quvideo.mobile.external.platform.api.cloudengine.model.CloudCompositeMakeResponse;
import com.quvideo.mobile.external.platform.api.cloudengine.model.CloudCompositeQueryResponse;
import d.o.a.a.a.a.b.a;
import d.o.a.a.a.a.b.b$a;
import d.o.a.a.a.a.b.b$b;
import d.o.a.a.a.a.b.b$c;
import d.o.a.a.a.a.b.b$d;
import d.o.a.a.a.a.b.b$e;
import d.o.a.a.a.a.b.b$f;
import d.o.a.a.a.a.b.b$g;
import e.a.g0;
import e.a.h0;
import e.a.v0.o;
import e.a.v0.r;
import e.a.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class b
implements ICompositeTask {
    private OnCompositeListener$State a;
    private OooO0o b;
    private OnCompositeListener c;
    private CloudCompositeMakeResponse d;
    private CloudCompositeQueryResponse e;
    private Context f;
    private volatile boolean g = false;
    private volatile ArrayList h;

    public b(Context object, OooO0o oooO0o, OnCompositeListener onCompositeListener) {
        ArrayList arrayList;
        this.h = arrayList = new ArrayList();
        this.f = object;
        this.b = oooO0o;
        this.c = onCompositeListener;
        object = OnCompositeListener$State.IDEL;
        this.a = object;
        int n10 = oooO0o.OooO0o0();
        int n11 = -1;
        if (n10 != n11) {
            this.c();
        } else {
            this.s();
        }
    }

    public static /* synthetic */ OooO0o a(b b10) {
        return b10.b;
    }

    public static /* synthetic */ CloudCompositeQueryResponse b(b b10, CloudCompositeQueryResponse cloudCompositeQueryResponse) {
        b10.e = cloudCompositeQueryResponse;
        return cloudCompositeQueryResponse;
    }

    private void c() {
        z z10 = z.t3(this.b.OooO0Oo().OooO00o());
        Object object = e.a.c1.b.d();
        z10 = z10.i4((h0)object);
        object = new b$b(this);
        z10 = z10.H3((o)object);
        object = e.a.q0.c.a.c();
        z10 = z10.i4((h0)object);
        object = new b$a(this);
        z10.subscribe((g0)object);
    }

    public static /* synthetic */ void d(b b10, OnCompositeListener$State onCompositeListener$State) {
        b10.h(onCompositeListener$State);
    }

    public static /* synthetic */ void e(b b10, CloudCompositeMakeResponse cloudCompositeMakeResponse) {
        b10.i(cloudCompositeMakeResponse);
    }

    public static /* synthetic */ void f(b b10, String string2, int n10, boolean bl2) {
        b10.k(string2, n10, bl2);
    }

    public static /* synthetic */ void g(b b10, boolean bl2) {
        b10.m(bl2);
    }

    private void h(OnCompositeListener$State object) {
        this.a = object;
        Object object2 = this.c;
        if (object2 != null) {
            object2.onNext(this, (OnCompositeListener$State)((Object)object));
        }
        object2 = OooOO0.OooO0oO;
        Object object3 = object.toString();
        object3 = Collections.singletonMap("state", object3);
        this.l((String)object2, (Map)object3);
        object2 = com.quvideo.mobile.external.component.cloudcomposite.core.OooO0O0.OooO0o;
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("update state to ");
        ((StringBuilder)object3).append(object);
        object = ((StringBuilder)object3).toString();
        com.quvideo.mobile.external.platform.log.OooO00o.OooO00o((String)object2, (String)object);
    }

    private void i(CloudCompositeMakeResponse cloudCompositeMakeResponse) {
        OnCompositeListener onCompositeListener = this.c;
        if (onCompositeListener == null) {
            return;
        }
        CompositePreResponse compositePreResponse = new CompositePreResponse(cloudCompositeMakeResponse);
        onCompositeListener.onPreComposite(this, compositePreResponse);
    }

    private void j(CloudCompositeQueryResponse cloudCompositeQueryResponse) {
        OnCompositeListener onCompositeListener = this.c;
        if (onCompositeListener == null) {
            return;
        }
        CompositeFinishResponse compositeFinishResponse = new CompositeFinishResponse(cloudCompositeQueryResponse);
        onCompositeListener.onSuccess(this, compositeFinishResponse);
    }

    private void k(String object, int n10, boolean bl2) {
        OnCompositeListener onCompositeListener = this.c;
        if (onCompositeListener == null) {
            return;
        }
        RequestError requestError = new RequestError((String)object, n10);
        object = this.a;
        onCompositeListener.onFailure(this, requestError, (OnCompositeListener$State)((Object)object), bl2);
    }

    private void l(String string2, Map map) {
        com.quvideo.mobile.external.component.cloudcomposite.core.OooO0O0.OooO0O0().OooO0Oo().OooO00o(string2, map);
    }

    private void m(boolean bl2) {
        Object object = OnCompositeListener$State.COMPOSITE;
        this.h((OnCompositeListener$State)((Object)object));
        object = this.b;
        if (object != null && (object = ((OooO0o)object).OooO0Oo()) != null) {
            z z10 = OooO0O0.OooO00o(this.b.OooO0Oo().OooO00o(bl2));
            object = e.a.c1.b.d();
            z10 = z10.L5((h0)object);
            object = e.a.q0.c.a.c();
            z10 = z10.i4((h0)object);
            object = new b$e(this);
            z10.subscribe((g0)object);
        }
    }

    private /* synthetic */ boolean n(Long object) {
        long l10 = (Long)object;
        object = this.b;
        long l11 = ((OooO0o)object).OooO0O0();
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        boolean bl2 = false;
        if (l12 < 0) {
            object = this.a;
            OnCompositeListener$State onCompositeListener$State = OnCompositeListener$State.QUERY;
            if (object == onCompositeListener$State) {
                bl2 = true;
            }
            return bl2;
        }
        object = OnCompositeListener$State.TIMEOUT;
        this.h((OnCompositeListener$State)((Object)object));
        return false;
    }

    public static /* synthetic */ CloudCompositeMakeResponse o(b b10, CloudCompositeMakeResponse cloudCompositeMakeResponse) {
        b10.d = cloudCompositeMakeResponse;
        return cloudCompositeMakeResponse;
    }

    private void p() {
        Object object = OnCompositeListener$State.QUERY;
        this.h((OnCompositeListener$State)((Object)object));
        long l10 = this.b.OooO0OO();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        object = z.n3(l10, timeUnit);
        Object object2 = new a(this);
        object = ((z)object).p6((r)object2);
        object2 = e.a.c1.b.d();
        object = ((z)object).L5((h0)object2);
        object2 = new b$g(this);
        object = ((z)object).s2((o)object2);
        object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((h0)object2);
        object2 = new b$f(this);
        ((z)object).subscribe((g0)object2);
    }

    public static /* synthetic */ void q(b b10) {
        b10.s();
    }

    public static /* synthetic */ void r(b b10, CloudCompositeQueryResponse cloudCompositeQueryResponse) {
        b10.j(cloudCompositeQueryResponse);
    }

    private void s() {
        Object object = OnCompositeListener$State.UPLOAD;
        this.h((OnCompositeListener$State)((Object)object));
        object = z.t3(this.b.OooO0Oo().OooO00o());
        Object object2 = e.a.c1.b.d();
        object = ((z)object).L5((h0)object2);
        object2 = e.a.q0.c.a.c();
        object = ((z)object).i4((h0)object2);
        object2 = new b$d(this);
        object = ((z)object).s2((o)object2);
        object2 = new b$c(this);
        ((z)object).subscribe((g0)object2);
    }

    public static /* synthetic */ void t(b b10) {
        b10.p();
    }

    public static /* synthetic */ Context u(b b10) {
        return b10.f;
    }

    public static /* synthetic */ OnCompositeListener v(b b10) {
        return b10.c;
    }

    public static /* synthetic */ boolean w(b b10) {
        return b10.g;
    }

    public static /* synthetic */ ArrayList x(b b10) {
        return b10.h;
    }

    public static /* synthetic */ CloudCompositeMakeResponse y(b b10) {
        return b10.d;
    }

    public static /* synthetic */ boolean z(b b10, Long l10) {
        return b10.n(l10);
    }

    public int cancelUpload() {
        boolean bl2;
        boolean bl3;
        Object object = this.a;
        Object object2 = OnCompositeListener$State.UPLOAD;
        if (object != object2) {
            return OooOO0.OooO0o;
        }
        this.g = bl3 = true;
        object = this.h.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (String)object.next();
            OooO00o oooO00o = com.quvideo.mobile.external.component.cloudcomposite.core.OooO0O0.OooO0O0().OooO0OO();
            oooO00o.OooO00o((String)object2);
        }
        object = OnCompositeListener$State.CANCEL;
        this.h((OnCompositeListener$State)((Object)object));
        return 0;
    }

    public void forceMake() {
        int n10;
        int n11;
        Object object = this.a;
        OnCompositeListener$State onCompositeListener$State = OnCompositeListener$State.FAILURE_FORCEMAKE;
        if (object == onCompositeListener$State && (object = this.e) != null && (n11 = OooOO0.OooO0O0) == (n10 = ((com.quvideo.mobile.external.platform.httpcore.OooO00o)object).code) && (object = this.b) != null && (object = ((OooO0o)object).OooO0Oo()) != null) {
            n10 = 1;
            this.m(n10 != 0);
        }
    }

    public OnCompositeListener$State getState() {
        return this.a;
    }

    public void release() {
        OnCompositeListener$State onCompositeListener$State = OnCompositeListener$State.RELEASE;
        this.h(onCompositeListener$State);
        this.c = null;
        com.quvideo.mobile.external.component.cloudcomposite.core.OooO0O0.OooO0O0().OooO00o(this);
    }
}

