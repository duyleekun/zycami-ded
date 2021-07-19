/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 */
package d.v.a.j.c;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LiveData;
import com.zhiyun.account.R$string;
import com.zhiyun.net.BaseEntity;
import d.v.a.f.b.a;
import d.v.a.j.c.y;
import d.v.e.i.j;
import d.v.f.i.g;

public class y$d
extends a {
    public final /* synthetic */ View a;
    public final /* synthetic */ y b;

    public y$d(y y10, View view) {
        this.b = y10;
        this.a = view;
    }

    public void onError(Throwable object, int n10, String string2) {
        object = this.b.c;
        boolean bl2 = ((LiveData)object).hasObservers();
        if (bl2) {
            object = this.b.o;
            Boolean bl3 = Boolean.FALSE;
            ((j)object).setValue(bl3);
            object = this.b;
            bl3 = this.a.getContext();
            String string3 = d.v.a.f.b.a.fromErrCodeToMessage((Context)bl3, n10, string2);
            y.b((y)object, string3);
        }
    }

    public void onSuccess(BaseEntity object) {
        object = this.b.c;
        boolean bl2 = ((LiveData)object).hasObservers();
        if (bl2) {
            object = this.b.o;
            Object object2 = Boolean.FALSE;
            ((j)object).setValue(object2);
            object = this.b;
            object2 = this.a;
            int n10 = R$string.set_private_set_new_pass_success;
            object2 = g.q((View)object2, n10);
            y.d((y)object, (String)object2);
            object = this.b.t;
            object2 = Boolean.TRUE;
            ((j)object).setValue(object2);
        }
    }
}

