/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.n1;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.data.PagingRequestHelper$Status;
import com.zhiyun.net.DataListEntity;
import d.v.a.f.b.a;
import d.v.c.n1.j2;

public class j2$a
extends a {
    public final /* synthetic */ j2 a;

    public j2$a(j2 j22) {
        this.a = j22;
    }

    public void a(DataListEntity object) {
        MutableLiveData mutableLiveData = j2.b(this.a);
        PagingRequestHelper$Status pagingRequestHelper$Status = PagingRequestHelper$Status.SUCCESS;
        mutableLiveData.setValue((Object)pagingRequestHelper$Status);
        if (object != null) {
            mutableLiveData = j2.c(this.a);
            object = ((DataListEntity)object).list;
            mutableLiveData.setValue(object);
        }
    }

    public void onError(Throwable object, int n10, String string2) {
        object = j2.b(this.a);
        PagingRequestHelper$Status pagingRequestHelper$Status = PagingRequestHelper$Status.FAILED;
        ((MutableLiveData)object).setValue((Object)pagingRequestHelper$Status);
    }
}

