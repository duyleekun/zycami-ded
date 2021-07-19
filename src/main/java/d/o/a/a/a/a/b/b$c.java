/*
 * Decompiled with CFR 0.151.
 */
package d.o.a.a.a.a.b;

import com.quvideo.mobile.external.component.cloudcomposite.core.OooO00o;
import com.quvideo.mobile.external.component.cloudcomposite.core.OooO0OO;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.OnCompositeListener$State;
import d.o.a.a.a.a.b.b;
import e.a.g0;

public class b$c
implements g0 {
    public final /* synthetic */ b a;

    public b$c(b b10) {
        this.a = b10;
    }

    public void a(Boolean object) {
        object = this.a;
        boolean bl2 = b.w((b)object);
        if (bl2) {
            return;
        }
        object = b.a(this.a).OooO0Oo();
        bl2 = ((OooO0OO)object).OooO0O0();
        if (bl2) {
            object = this.a;
            b.g((b)object, false);
            this.onComplete();
        }
    }

    public void onComplete() {
    }

    public void onError(Throwable object) {
        Object object2 = this.a;
        boolean bl2 = b.w(object2);
        if (bl2) {
            return;
        }
        bl2 = object instanceof OooO00o;
        if (bl2) {
            object = (OooO00o)object;
            object2 = this.a;
            String string2 = ((OooO00o)object).getMessage();
            int n10 = ((OooO00o)object).OooO00o();
            b.f(object2, string2, n10, false);
        }
        object = this.a;
        object2 = OnCompositeListener$State.FAILURE;
        b.d((b)object, (OnCompositeListener$State)((Object)object2));
    }

    public void onSubscribe(e.a.s0.b b10) {
    }
}

