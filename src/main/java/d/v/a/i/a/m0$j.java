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
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.account.R$string;
import com.zhiyun.account.me.account.getcode.GetCodeStatus;
import com.zhiyun.net.BaseEntity;
import d.v.a.f.b.a;
import d.v.a.i.a.m0;
import d.v.a.i.a.m0$b;
import d.v.e.i.j;
import d.v.f.i.g;

public class m0$j
extends a {
    public final /* synthetic */ GetCodeStatus a;
    public final /* synthetic */ View b;
    public final /* synthetic */ m0 c;

    public m0$j(m0 m02, GetCodeStatus getCodeStatus, View view) {
        this.c = m02;
        this.a = getCodeStatus;
        this.b = view;
    }

    public void onError(Throwable object, int n10, String string2) {
        Object object2;
        object = this.c.j;
        boolean bl2 = ((LiveData)object).hasObservers();
        if (bl2 && (object = this.a) == (object2 = this.c.l.getValue())) {
            object = this.c.v;
            object2 = Boolean.FALSE;
            ((j)object).setValue(object2);
            object = this.c;
            object2 = this.b.getContext();
            String string3 = d.v.a.f.b.a.fromErrCodeToMessage((Context)object2, n10, string2);
            m0.c((m0)object, string3);
        }
    }

    public void onSuccess(BaseEntity object) {
        Object object2;
        object = Boolean.TRUE;
        Object object3 = this.c.j;
        boolean n10 = ((LiveData)object3).hasObservers();
        if (n10 && (object3 = this.a) == (object2 = this.c.l.getValue())) {
            object3 = this.c.v;
            object2 = Boolean.FALSE;
            ((j)object3).setValue(object2);
            object3 = m0$b.a;
            object2 = this.a;
            int n11 = ((Enum)object2).ordinal();
            MutableLiveData mutableLiveData = object3[n11];
            n11 = 1;
            if (mutableLiveData != n11) {
                n11 = 2;
                if (mutableLiveData != n11) {
                    int n12 = 3;
                    if (mutableLiveData == n12) {
                        object = this.c;
                        object3 = this.b;
                        object2 = this.a;
                        m0.f((m0)object, (View)object3, (GetCodeStatus)((Object)object2));
                    }
                } else {
                    object3 = this.c;
                    object2 = this.b;
                    int n13 = R$string.me_login_success;
                    object2 = g.q((View)object2, n13);
                    m0.b((m0)object3, (String)object2);
                    object3 = this.c.C;
                    ((j)object3).setValue(object);
                }
            } else {
                object3 = this.c.w;
                ((j)object3).setValue(object);
            }
        }
    }
}

