/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.j1.a;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.data.PagingRequestHelper$Status;
import com.zhiyun.cama.data.PagingRequestHelper$b;
import com.zhiyun.cama.data.database.model.Feedback;
import d.v.a.f.b.a;
import d.v.c.j1.a.o0;

public class o0$d
extends a {
    public final /* synthetic */ o0 a;

    public o0$d(o0 o02) {
        this.a = o02;
    }

    public void a(Feedback object) {
        if (object != null) {
            int n10;
            Object object2 = this.a.h;
            ((MutableLiveData)object2).setValue(object);
            object = ((Feedback)object).getExtras();
            if (object != null && (n10 = object.size()) > 0) {
                object2 = this.a.i;
                ((MutableLiveData)object2).setValue(object);
            }
            object = this.a.g;
            PagingRequestHelper$Status pagingRequestHelper$Status = PagingRequestHelper$Status.SUCCESS;
            object2 = new PagingRequestHelper$b(pagingRequestHelper$Status);
            ((MutableLiveData)object).setValue(object2);
        } else {
            String string2 = "";
            object = new Throwable(string2);
            int n11 = -1;
            this.onError((Throwable)object, n11, string2);
        }
    }

    public void onError(Throwable object, int n10, String object2) {
        this.a.h.setValue(null);
        this.a.i.setValue(null);
        object = this.a.g;
        object2 = PagingRequestHelper$Status.FAILED;
        PagingRequestHelper$b pagingRequestHelper$b = new PagingRequestHelper$b((PagingRequestHelper$Status)((Object)object2));
        ((MutableLiveData)object).setValue(pagingRequestHelper$b);
    }
}

