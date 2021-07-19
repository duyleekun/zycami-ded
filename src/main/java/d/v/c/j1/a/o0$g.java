/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c.j1.a;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.net.BaseEntity;
import d.v.a.f.b.a;
import d.v.c.j1.a.o0;
import d.v.e.i.j;
import d.v.f.i.g;

public class o0$g
extends a {
    public final /* synthetic */ Context a;
    public final /* synthetic */ o0 b;

    public o0$g(o0 o02, Context context) {
        this.b = o02;
        this.a = context;
    }

    public void onError(Throwable object, int n10, String object2) {
        object = this.b.h;
        boolean n11 = ((LiveData)object).hasObservers();
        if (n11) {
            object = this.b.j;
            object2 = Boolean.FALSE;
            ((j)object).setValue(object2);
            int n12 = 10502;
            if (n12 == n10) {
                object = this.b.l;
                Object object4 = this.a;
                int n13 = 2131952290;
                object4 = g.m(object4, n13);
                ((j)object).setValue(object4);
            } else {
                object = this.b.l;
                Object object3 = this.a;
                int n13 = 2131952827;
                object3 = g.m(object3, n13);
                ((j)object).setValue(object3);
            }
        }
    }

    public void onSuccess(BaseEntity object) {
        object = this.b.h;
        boolean bl2 = ((LiveData)object).hasObservers();
        if (bl2) {
            object = this.b.j;
            Object object2 = Boolean.FALSE;
            ((j)object).setValue(object2);
            object = this.b.f;
            object2 = ((LiveData)object).getValue();
            ((MutableLiveData)object).setValue(object2);
        }
    }
}

