/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c.q1;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.net.BaseEntity;
import d.v.a.f.b.a;
import d.v.c.q1.g0;

public class g0$a
extends a {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ g0 c;

    public g0$a(g0 g02, boolean bl2, Context context) {
        this.c = g02;
        this.a = bl2;
        this.b = context;
    }

    public void onError(Throwable object, int n10, String string2) {
        object = g0.b(this.c);
        Boolean bl2 = this.a ^ true;
        ((MutableLiveData)object).setValue(bl2);
        object = d.v.a.f.b.a.fromErrCodeToMessage(this.b, n10, string2);
        g0.c(this.c).setValue(object);
    }

    public void onSuccess(BaseEntity object) {
        object = g0.b(this.c);
        Boolean bl2 = this.a;
        ((MutableLiveData)object).setValue(bl2);
    }
}

