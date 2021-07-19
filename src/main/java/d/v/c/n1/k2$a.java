/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.n1;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.live.data.api.entity.LiveKwaiUserInfo;
import d.v.c.n1.k2;
import d.v.e.i.h;
import k.d;
import k.f;
import k.r;

public class k2$a
implements f {
    public final /* synthetic */ String a;
    public final /* synthetic */ k2 b;

    public k2$a(k2 k22, String string2) {
        this.b = k22;
        this.a = string2;
    }

    public void onFailure(d d10, Throwable throwable) {
        k2.b(this.b).a();
    }

    public void onResponse(d object, r object2) {
        int n10;
        int n11;
        object = (LiveKwaiUserInfo)((r)object2).a();
        if (object != null && (n11 = ((LiveKwaiUserInfo)object).result) == (n10 = 1)) {
            object = k2.a(this.b).x();
            object2 = this.a;
            h.g((MutableLiveData)object, object2);
        } else {
            object = k2.b(this.b);
            object.a();
        }
    }
}

