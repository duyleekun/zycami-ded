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
import d.v.a.j.c.y$g;
import d.v.f.i.g;

public class y$g$a
extends a {
    public final /* synthetic */ y$g a;

    public y$g$a(y$g y$g) {
        this.a = y$g;
    }

    public void onError(Throwable object, int n10, String object2) {
        int n11 = 208;
        if (n11 == n10) {
            object = this.a;
            object2 = ((y$g)object).b;
            object = ((y$g)object).a;
            int n12 = R$string.set_bind_already_failed;
            object = g.m((Context)object, n12);
            y.f((y)object2, n10, (String)object);
        } else {
            object = this.a;
            object2 = ((y$g)object).b;
            object = ((y$g)object).a;
            int n13 = R$string.set_bind_failed;
            object = g.m((Context)object, n13);
            y.f((y)object2, n10, (String)object);
        }
    }

    public void onSuccess(BaseEntity object) {
        this.a.b.m(false);
        object = this.a;
        y y10 = ((y$g)object).b;
        object = ((y$g)object).a;
        int n10 = R$string.set_bind_success;
        object = g.m((Context)object, n10);
        y.e(y10, (String)object);
    }
}

