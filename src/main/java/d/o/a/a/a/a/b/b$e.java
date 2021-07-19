/*
 * Decompiled with CFR 0.151.
 */
package d.o.a.a.a.a.b;

import com.google.gson.Gson;
import com.quvideo.mobile.external.component.cloudcomposite.core.OooO0O0;
import com.quvideo.mobile.external.component.cloudcomposite.core.OooOO0;
import com.quvideo.mobile.external.component.cloudcomposite.protocal.OnCompositeListener$State;
import com.quvideo.mobile.external.platform.api.cloudengine.model.CloudCompositeMakeResponse;
import com.quvideo.mobile.external.platform.log.OooO00o;
import d.o.a.a.a.a.b.b;
import e.a.g0;

public class b$e
implements g0 {
    public final /* synthetic */ b a;

    public b$e(b b10) {
        this.a = b10;
    }

    public void a(CloudCompositeMakeResponse object) {
        Object object2 = OooO0O0.OooO0o;
        Object object3 = new Gson();
        object3 = ((Gson)object3).toJson(object);
        OooO00o.OooO00o((String)object2, (String)object3);
        object2 = this.a;
        b.o((b)object2, (CloudCompositeMakeResponse)object);
        boolean bl2 = ((com.quvideo.mobile.external.platform.httpcore.OooO00o)object).success;
        if (bl2) {
            object2 = this.a;
            b.e((b)object2, (CloudCompositeMakeResponse)object);
            object = this.a;
            b.t((b)object);
        } else {
            object2 = this.a;
            object3 = ((com.quvideo.mobile.external.platform.httpcore.OooO00o)object).message;
            int n10 = ((com.quvideo.mobile.external.platform.httpcore.OooO00o)object).code;
            b.f((b)object2, (String)object3, n10, false);
            object = this.a;
            object2 = OnCompositeListener$State.FAILURE;
            b.d((b)object, (OnCompositeListener$State)((Object)object2));
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

