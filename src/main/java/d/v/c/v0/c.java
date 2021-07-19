/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.data.PagingRequestHelper;
import com.zhiyun.cama.data.PagingRequestHelper$f;
import d.v.e.l.m2$c;

public final class c
implements m2$c {
    public final /* synthetic */ PagingRequestHelper$f a;
    public final /* synthetic */ MutableLiveData b;

    public /* synthetic */ c(PagingRequestHelper$f pagingRequestHelper$f, MutableLiveData mutableLiveData) {
        this.a = pagingRequestHelper$f;
        this.b = mutableLiveData;
    }

    public final void onComplete() {
        PagingRequestHelper$f pagingRequestHelper$f = this.a;
        MutableLiveData mutableLiveData = this.b;
        PagingRequestHelper.f(pagingRequestHelper$f, mutableLiveData);
    }
}

