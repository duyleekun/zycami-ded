/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 */
package d.v.a.i.a;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LiveData;
import com.zhiyun.account.R$string;
import com.zhiyun.net.BaseEntity;
import d.v.a.f.b.a;
import d.v.a.i.a.m0;
import d.v.e.i.j;
import d.v.f.i.g;

public class m0$e
extends a {
    public final /* synthetic */ View a;
    public final /* synthetic */ m0 b;

    public m0$e(m0 m02, View view) {
        this.b = m02;
        this.a = view;
    }

    public void onError(Throwable object, int n10, String string2) {
        object = this.b.f;
        boolean bl2 = ((LiveData)object).hasObservers();
        if (bl2) {
            object = this.b.v;
            Boolean bl3 = Boolean.FALSE;
            ((j)object).setValue(bl3);
            object = this.b;
            bl3 = this.a.getContext();
            String string3 = d.v.a.f.b.a.fromErrCodeToMessage((Context)bl3, n10, string2);
            m0.c((m0)object, string3);
        }
    }

    public void onSuccess(BaseEntity object) {
        object = this.b.f;
        boolean bl2 = ((LiveData)object).hasObservers();
        if (bl2) {
            object = this.b.v;
            Object object2 = Boolean.FALSE;
            ((j)object).setValue(object2);
            object = this.b;
            object2 = this.a;
            int n10 = R$string.me_login_success;
            object2 = g.q((View)object2, n10);
            m0.b((m0)object, (String)object2);
            object = this.b.C;
            object2 = Boolean.TRUE;
            ((j)object).setValue(object2);
        }
    }
}

