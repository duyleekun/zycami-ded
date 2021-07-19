/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c.j1.a;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.zhiyun.cama.data.database.model.Feedback;
import com.zhiyun.net.BaseEntity;
import d.v.a.f.b.a;
import d.v.c.j1.a.o0;
import d.v.e.i.j;
import d.v.f.i.g;

public class o0$e
extends a {
    public final /* synthetic */ Context a;
    public final /* synthetic */ Feedback b;
    public final /* synthetic */ o0 c;

    public o0$e(o0 o02, Context context, Feedback feedback) {
        this.c = o02;
        this.a = context;
        this.b = feedback;
    }

    public void onError(Throwable object, int n10, String object2) {
        ((Throwable)object).printStackTrace();
        object = this.c.p;
        boolean n11 = ((LiveData)object).hasObservers();
        if (n11) {
            object = this.c.j;
            object2 = Boolean.FALSE;
            ((j)object).setValue(object2);
            int n12 = 10501;
            if (n12 == n10) {
                object = this.c.l;
                Object object6 = this.a;
                int n15 = 2131952272;
                object6 = g.m(object6, n15);
                ((j)object).setValue(object6);
            } else {
                int n13 = -1;
                if (n13 == n10) {
                    object = this.c.l;
                    Object object3 = this.a;
                    int n14 = 2131952827;
                    object3 = g.m(object3, n14);
                    ((j)object).setValue(object3);
                } else {
                    int n15;
                    object = this.b;
                    if (object != null && (n15 = 10505) == n10) {
                        object = this.c.l;
                        Object object4 = this.a;
                        int n16 = 2131952290;
                        object4 = g.m(object4, n16);
                        ((j)object).setValue(object4);
                    } else {
                        object = this.c.l;
                        Object object5 = this.a;
                        int n17 = 2131952271;
                        object5 = g.m(object5, n17);
                        ((j)object).setValue(object5);
                    }
                }
            }
        }
    }

    public void onSuccess(BaseEntity object) {
        object = this.c.p;
        boolean bl2 = ((LiveData)object).hasObservers();
        if (bl2) {
            object = this.c.j;
            Object object2 = Boolean.FALSE;
            ((j)object).setValue(object2);
            object = this.c.l;
            object2 = this.a;
            int n10 = 2131952274;
            object2 = g.m((Context)object2, n10);
            ((j)object).setValue(object2);
            object = this.c.m;
            object2 = Boolean.TRUE;
            ((j)object).setValue(object2);
        }
    }
}

