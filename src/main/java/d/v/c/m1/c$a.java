/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.m1;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.data.me.remote.PrimeManager;
import com.zhiyun.cama.prime.model.PrimeInfo;
import com.zhiyun.net.BaseEntity;
import d.v.a.f.b.a;
import d.v.a.f.c.b;
import d.v.c.m1.c;
import d.v.e.i.h;

public class c$a
extends a {
    public final /* synthetic */ c a;

    public c$a(c c10) {
        this.a = c10;
    }

    public void onError(Throwable object, int n10, String string2) {
        object = (PrimeInfo)c.b(this.a).getValue();
        if (object != null) {
            ((BaseEntity)object).errcode = n10;
            MutableLiveData mutableLiveData = c.b(this.a);
            mutableLiveData.postValue(object);
        }
    }

    public void onSuccess(PrimeInfo object) {
        int n10;
        int n11;
        int n12 = ((PrimeInfo)object).getUserId();
        Object object2 = PrimeManager.getLocalPrimeInfo(n12);
        if (object2 != null && (n11 = ((PrimeInfo)object2).getUserId()) == (n10 = ((PrimeInfo)object).getUserId())) {
            n12 = (int)(((PrimeInfo)object2).getIsShowDialog() ? 1 : 0);
            ((PrimeInfo)object).setIsShowDialog(n12 != 0);
        }
        PrimeManager.savePrimeInfo((PrimeInfo)object);
        c.b(this.a).postValue(object);
        object2 = c.c(this.a);
        n11 = (int)(c.d(this.a, (PrimeInfo)object) ? 1 : 0);
        Boolean bl2 = n11 != 0;
        h.g((MutableLiveData)object2, bl2);
        object2 = c.f(this.a);
        boolean bl3 = ((PrimeInfo)object).getIsShowDialog();
        if (!bl3 && (bl3 = ((c)(object = this.a)).p()) && !(bl3 = c.e((c)(object = this.a))) && !(bl3 = ((b)(object = b.N())).j())) {
            bl3 = true;
        } else {
            bl3 = false;
            object = null;
        }
        object = bl3;
        ((MutableLiveData)object2).postValue(object);
    }
}

