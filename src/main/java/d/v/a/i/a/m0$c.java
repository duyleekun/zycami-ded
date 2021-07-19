/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.a.i.a;

import android.view.View;
import androidx.lifecycle.LiveData;
import com.zhiyun.account.R$string;
import com.zhiyun.account.me.account.getcode.GetCodeStatus;
import com.zhiyun.net.BaseEntity;
import d.v.a.f.b.a;
import d.v.a.i.a.m0;
import d.v.e.i.j;
import d.v.f.i.g;

public class m0$c
extends a {
    public final /* synthetic */ GetCodeStatus a;
    public final /* synthetic */ View b;
    public final /* synthetic */ m0 c;

    public m0$c(m0 m02, GetCodeStatus getCodeStatus, View view) {
        this.c = m02;
        this.a = getCodeStatus;
        this.b = view;
    }

    public void onError(Throwable object, int n10, String string2) {
        Object object2;
        object = this.c.j;
        boolean bl2 = ((LiveData)object).hasObservers();
        if (bl2 && (object = this.a) != null && object == (object2 = this.c.l.getValue())) {
            object = this.c.E;
            object2 = Boolean.FALSE;
            ((j)object).setValue(object2);
            object = this.c.y;
            object2 = this.b;
            int n11 = R$string.me_self_login_failed;
            object2 = g.q((View)object2, n11);
            ((j)object).setValue(object2);
        }
    }

    public void onSuccess(BaseEntity object) {
        Object object2;
        object = this.c.j;
        boolean bl2 = ((LiveData)object).hasObservers();
        if (bl2 && (object = this.a) != null && object == (object2 = this.c.l.getValue())) {
            object = this.c.E;
            object2 = Boolean.FALSE;
            ((j)object).setValue(object2);
            object = this.c;
            object2 = this.b;
            int n10 = R$string.me_login_success;
            object2 = g.q((View)object2, n10);
            m0.b((m0)object, (String)object2);
            object = this.c.C;
            object2 = Boolean.TRUE;
            ((j)object).setValue(object2);
        }
    }
}

