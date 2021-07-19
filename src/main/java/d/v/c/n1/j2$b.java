/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.n1;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.data.PagingRequestHelper$Status;
import com.zhiyun.net.DataListEntity;
import d.v.a.f.b.a;
import d.v.c.n1.c2;
import d.v.c.n1.j2;
import java.util.List;
import java.util.stream.Collectors;

public class j2$b
extends a {
    public final /* synthetic */ String a;
    public final /* synthetic */ j2 b;

    public j2$b(j2 j22, String string2) {
        this.b = j22;
        this.a = string2;
    }

    public void a(DataListEntity object) {
        if (object == null) {
            return;
        }
        Object object2 = this.b;
        object = ((DataListEntity)object).list.stream();
        Object object3 = c2.a;
        object = object.map(object3);
        object3 = Collectors.toList();
        object = (List)object.collect(object3);
        j2.e((j2)object2, (List)object);
        object = j2.g(this.b);
        object2 = this.b;
        object3 = j2.d((j2)object2);
        String string2 = this.a;
        object2 = j2.f((j2)object2, (List)object3, string2);
        ((MutableLiveData)object).setValue(object2);
        object = j2.b(this.b);
        object2 = PagingRequestHelper$Status.SUCCESS;
        ((MutableLiveData)object).setValue(object2);
    }

    public void onError(Throwable object, int n10, String string2) {
        object = j2.b(this.b);
        PagingRequestHelper$Status pagingRequestHelper$Status = PagingRequestHelper$Status.FAILED;
        ((MutableLiveData)object).setValue((Object)pagingRequestHelper$Status);
    }
}

