/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.a.j.c;

import android.content.Context;
import com.zhiyun.account.R$string;
import com.zhiyun.net.BaseEntity;
import d.v.a.f.b.a;
import d.v.a.j.c.y;
import d.v.e.i.j;
import d.v.f.i.g;

public class y$e
extends a {
    public final /* synthetic */ Context a;
    public final /* synthetic */ y b;

    public y$e(y y10, Context context) {
        this.b = y10;
        this.a = context;
    }

    public void onError(Throwable object, int n10, String string2) {
        object = this.b.o;
        Object object2 = Boolean.FALSE;
        ((j)object).setValue(object2);
        object = this.b;
        object2 = this.a;
        int n11 = R$string.set_remove_bind_failed;
        object2 = g.m((Context)object2, n11);
        y.d((y)object, (String)object2);
    }

    public void onSuccess(BaseEntity object) {
        object = this.b.o;
        Object object2 = Boolean.FALSE;
        ((j)object).setValue(object2);
        object = this.b;
        object2 = this.a;
        int n10 = R$string.set_remove_bind_success;
        object2 = g.m((Context)object2, n10);
        y.d((y)object, (String)object2);
    }
}

