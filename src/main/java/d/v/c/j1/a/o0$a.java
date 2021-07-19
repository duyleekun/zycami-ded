/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.j1.a;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.net.DataListEntity;
import d.v.a.f.b.a;
import d.v.c.j1.a.o0;

public class o0$a
extends a {
    public final /* synthetic */ o0 a;

    public o0$a(o0 o02) {
        this.a = o02;
    }

    public void a(DataListEntity object) {
        MutableLiveData mutableLiveData = this.a.o;
        int n10 = ((DataListEntity)object).count;
        if (n10 > 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        object = n10 != 0;
        mutableLiveData.setValue(object);
    }

    public void onError(Throwable object, int n10, String string2) {
        object = this.a.o;
        Boolean bl2 = Boolean.FALSE;
        ((MutableLiveData)object).setValue(bl2);
    }
}

