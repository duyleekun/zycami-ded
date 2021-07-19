/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.d7;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.live.data.LivePlatform;
import com.zhiyun.live.data.api.entity.ReStreamChannel;
import d.v.c.s0.d7.a0;
import d.v.c.s0.d7.z;
import d.v.n.i$g;
import d.v.n.l.d;

public class z$a
implements i$g {
    public final /* synthetic */ z a;

    public z$a(z z10) {
        this.a = z10;
    }

    public void a(ReStreamChannel[] reStreamChannelArray) {
        MutableLiveData mutableLiveData = this.a.L();
        Boolean bl2 = Boolean.FALSE;
        mutableLiveData.postValue(bl2);
        z.c(this.a).postValue(reStreamChannelArray);
    }

    public void b(String object) {
        z.b(this.a, (String)object);
        object = this.a.a0();
        Integer n10 = 3;
        ((MutableLiveData)object).setValue(n10);
    }

    public void c(int n10) {
        Object object = this.a.L();
        Object object2 = Boolean.FALSE;
        object.postValue(object2);
        int n11 = 20001;
        if (n10 == n11) {
            object = z.g(this.a);
            if (object == (object2 = LivePlatform.RESTREAM)) {
                d d10 = d.i();
                object = z.g(this.a);
                object2 = z.i((z)this.a).openid;
                d10.t((LivePlatform)((Object)object), (String)object2);
                return;
            }
            object = a0.e();
            object2 = z.g(this.a).getPlatformName();
            ((a0)object).b((String)object2);
            object = this.a;
            int n12 = 1;
            ((z)object).y0(n12);
        }
        object = z.k(this.a);
        Object object3 = n10;
        object.postValue(object3);
        object3 = this.a.a0();
        object = 0;
        ((MutableLiveData)object3).postValue(object);
    }
}

