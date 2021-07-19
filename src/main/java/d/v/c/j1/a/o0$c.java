/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c.j1.a;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.data.api.entity.ProductVersionEntity;
import com.zhiyun.net.DataListEntity;
import d.v.a.f.b.a;
import d.v.c.j1.a.o0;
import d.v.e.i.j;
import d.v.f.i.g;
import java.util.ArrayList;

public class o0$c
extends a {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ o0 c;

    public o0$c(o0 o02, boolean bl2, Context context) {
        this.c = o02;
        this.a = bl2;
        this.b = context;
    }

    public void a(DataListEntity object) {
        int n10;
        Object object2;
        if (object != null && (object2 = ((DataListEntity)object).list) != null && (n10 = ((ArrayList)object2).size()) > 0) {
            object2 = this.c.x;
            boolean bl2 = false;
            ((MutableLiveData)object2).setValue(null);
            this.c.y.clear();
            object2 = this.c.x;
            Object object3 = ((DataListEntity)object).list;
            ((MutableLiveData)object2).setValue(object3);
            object = ((DataListEntity)object).list.iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                object2 = (ProductVersionEntity)object.next();
                object3 = this.c.y;
                object2 = ((ProductVersionEntity)object2).version;
                object3.add(object2);
            }
            object = this.c.s.getValue();
            if (object != null) {
                int n11 = -1;
                object2 = (ProductVersionEntity)this.c.s.getValue();
                n10 = ((ProductVersionEntity)object2).id;
                if (n11 == n10) {
                    object = this.c;
                    object2 = ((o0)object).s;
                    object3 = ((ProductVersionEntity)object2.getValue()).version;
                    object = o0.c((o0)object, (String)object3);
                    ((MutableLiveData)object2).setValue(object);
                }
            }
        } else {
            boolean bl3 = this.a;
            if (!bl3) {
                object = this.c.l;
                object2 = this.b;
                int n12 = 2131952296;
                object2 = g.m((Context)object2, n12);
                ((j)object).setValue(object2);
            }
        }
    }

    public void onError(Throwable object, int n10, String string2) {
        boolean bl2 = this.a;
        if (!bl2) {
            object = this.c.l;
            Object object2 = this.b;
            int n11 = 2131952827;
            object2 = g.m(object2, n11);
            ((j)object).setValue(object2);
        }
    }
}

