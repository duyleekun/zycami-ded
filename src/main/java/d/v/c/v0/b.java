/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.data.PagingRequestHelper;
import com.zhiyun.cama.data.PagingRequestHelper$a;
import com.zhiyun.cama.data.PagingRequestHelper$f;

public final class b
implements PagingRequestHelper$a {
    public final /* synthetic */ MutableLiveData a;

    public /* synthetic */ b(MutableLiveData mutableLiveData) {
        this.a = mutableLiveData;
    }

    public final void a(PagingRequestHelper$f pagingRequestHelper$f) {
        PagingRequestHelper.e(this.a, pagingRequestHelper$f);
    }
}

