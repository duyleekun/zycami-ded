/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c.j1.a;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.zhiyun.net.BaseEntity;
import d.v.a.f.b.a;
import d.v.c.j1.a.o0;
import d.v.e.i.j;
import d.v.f.i.g;

public class o0$h
extends a {
    public final /* synthetic */ Context a;
    public final /* synthetic */ o0 b;

    public o0$h(o0 o02, Context context) {
        this.b = o02;
        this.a = context;
    }

    public void onError(Throwable object, int n10, String object2) {
        object = this.b.n;
        boolean n11 = ((LiveData)object).hasObservers();
        if (n11) {
            object = this.b.j;
            object2 = Boolean.FALSE;
            ((j)object).setValue(object2);
            int n12 = -1;
            if (n12 == n10) {
                object = this.b.l;
                Object object5 = this.a;
                int n14 = 2131952827;
                object5 = g.m(object5, n14);
                ((j)object).setValue(object5);
            } else {
                int n13 = 10504;
                if (n13 == n10) {
                    object = this.b.l;
                    Object object3 = this.a;
                    int n14 = 2131952290;
                    object3 = g.m(object3, n14);
                    ((j)object).setValue(object3);
                } else {
                    object = this.b.l;
                    Object object4 = this.a;
                    int n15 = 2131952271;
                    object4 = g.m(object4, n15);
                    ((j)object).setValue(object4);
                }
            }
        }
    }

    public void onSuccess(BaseEntity object) {
        object = this.b.n;
        boolean bl2 = ((LiveData)object).hasObservers();
        if (bl2) {
            object = this.b.j;
            Object object2 = Boolean.FALSE;
            ((j)object).setValue(object2);
            object = this.b.l;
            object2 = this.a;
            int n10 = 2131952274;
            object2 = g.m((Context)object2, n10);
            ((j)object).setValue(object2);
            object = this.b.m;
            object2 = Boolean.TRUE;
            ((j)object).setValue(object2);
        }
    }
}

