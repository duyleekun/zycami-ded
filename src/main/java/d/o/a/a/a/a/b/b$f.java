/*
 * Decompiled with CFR 0.151.
 */
package d.o.a.a.a.a.b;

import com.google.gson.Gson;
import com.quvideo.mobile.external.component.cloudcomposite.core.OooO0O0;
import com.quvideo.mobile.external.component.cloudcomposite.core.OooOO0;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.OnCompositeListener$State;
import com.quvideo.mobile.external.platform.api.cloudengine.model.CloudCompositeQueryResponse;
import com.quvideo.mobile.external.platform.log.OooO00o;
import d.o.a.a.a.a.b.b;
import e.a.g0;

public class b$f
implements g0 {
    public final /* synthetic */ b a;

    public b$f(b b10) {
        this.a = b10;
    }

    public void a(CloudCompositeQueryResponse object) {
        int n10;
        Object object2 = OooO0O0.OooO0o;
        Object object3 = new Gson();
        object3 = ((Gson)object3).toJson(object);
        OooO00o.OooO00o((String)object2, (String)object3);
        object2 = this.a;
        b.b((b)object2, (CloudCompositeQueryResponse)object);
        int n11 = ((com.quvideo.mobile.external.platform.httpcore.OooO00o)object).success;
        if (n11 != 0 && (n11 = ((com.quvideo.mobile.external.platform.httpcore.OooO00o)object).code) == (n10 = OooOO0.OooO00o)) {
            object2 = this.a;
            object3 = OnCompositeListener$State.SUCCESS;
            b.d((b)object2, (OnCompositeListener$State)((Object)object3));
            object2 = this.a;
            b.r((b)object2, (CloudCompositeQueryResponse)object);
        } else {
            n11 = ((com.quvideo.mobile.external.platform.httpcore.OooO00o)object).code;
            n10 = OooOO0.OooO0OO;
            if (n11 != n10) {
                n10 = OooOO0.OooO0O0;
                if (n11 == n10) {
                    n10 = 1;
                } else {
                    n10 = 0;
                    object3 = null;
                }
                b b10 = this.a;
                object = ((com.quvideo.mobile.external.platform.httpcore.OooO00o)object).message;
                b.f(b10, (String)object, n11, n10 != 0);
                object = this.a;
                object2 = n10 != 0 ? OnCompositeListener$State.FAILURE_FORCEMAKE : OnCompositeListener$State.FAILURE;
                b.d((b)object, (OnCompositeListener$State)((Object)object2));
            }
        }
    }

    public void onComplete() {
    }

    public void onError(Throwable object) {
        object = this.a;
        Object object2 = OooOO0.OooO0o0;
        int n10 = OooOO0.OooO0Oo;
        b.f((b)object, object2, n10, false);
        object = this.a;
        object2 = OnCompositeListener$State.FAILURE;
        b.d((b)object, (OnCompositeListener$State)((Object)object2));
    }

    public void onSubscribe(e.a.s0.b b10) {
    }
}

