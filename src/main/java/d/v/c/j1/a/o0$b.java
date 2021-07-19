/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c.j1.a;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.data.api.entity.ProductEntity;
import com.zhiyun.cama.data.api.entity.ProductVersionEntity;
import com.zhiyun.net.DataListEntity;
import d.v.a.f.b.a;
import d.v.c.j1.a.o0;
import d.v.e.i.j;
import d.v.f.i.g;
import java.util.ArrayList;

public class o0$b
extends a {
    public final /* synthetic */ Context a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ o0 c;

    public o0$b(o0 o02, Context context, boolean bl2) {
        this.c = o02;
        this.a = context;
        this.b = bl2;
    }

    public void a(DataListEntity object) {
        int n10;
        Object object2;
        boolean bl2 = false;
        Object object3 = null;
        int n11 = -1;
        if (object != null && (object2 = ((DataListEntity)object).list) != null && (n10 = ((ArrayList)object2).size()) > 0) {
            int n12;
            this.c.v.setValue(null);
            this.c.w.clear();
            object3 = this.c.v;
            object2 = ((DataListEntity)object).list;
            ((MutableLiveData)object3).setValue(object2);
            object = ((DataListEntity)object).list.iterator();
            while (bl2 = object.hasNext()) {
                object3 = (ProductEntity)object.next();
                object2 = this.c.w;
                object3 = ((ProductEntity)object3).title;
                object2.add(object3);
            }
            object = this.c.r.getValue();
            if (object != null) {
                object = (ProductEntity)this.c.r.getValue();
                n12 = ((ProductEntity)object).id;
                if (n11 == n12) {
                    object = this.c;
                    object3 = ((o0)object).r;
                    object2 = ((ProductEntity)object3.getValue()).title;
                    object = o0.b((o0)object, (String)object2);
                    ((MutableLiveData)object3).setValue(object);
                }
            }
            if ((object = this.c.s.getValue()) != null) {
                object = (ProductVersionEntity)this.c.s.getValue();
                n12 = ((ProductVersionEntity)object).id;
                if (n11 == n12) {
                    object = this.c;
                    object3 = this.a;
                    n11 = (int)(this.b ? 1 : 0);
                    ((o0)object).H((Context)object3, n11 != 0);
                }
            }
        } else {
            object = "";
            this.onError(null, n11, (String)object);
        }
    }

    public void onError(Throwable object, int n10, String string2) {
        boolean bl2 = this.b;
        if (!bl2) {
            object = this.c.l;
            Object object2 = this.a;
            int n11 = 2131952827;
            object2 = g.m(object2, n11);
            ((j)object).setValue(object2);
        }
    }
}

