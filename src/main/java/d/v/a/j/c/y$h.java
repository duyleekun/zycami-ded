/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 */
package d.v.a.j.c;

import android.content.res.Resources;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.account.R$string;
import com.zhiyun.account.data.api.entity.BindThirdEntity;
import com.zhiyun.account.data.me.ThirdPlatform;
import com.zhiyun.net.BaseEntity;
import d.v.a.f.b.a;
import d.v.a.j.c.y;
import d.v.a.j.c.y$i;
import d.v.f.i.g;

public class y$h
extends a {
    public final /* synthetic */ ThirdPlatform a;
    public final /* synthetic */ Resources b;
    public final /* synthetic */ y c;

    public y$h(y y10, ThirdPlatform thirdPlatform, Resources resources) {
        this.c = y10;
        this.a = thirdPlatform;
        this.b = resources;
    }

    public void onError(Throwable object, int n10, String string2) {
        object = this.c;
        string2 = this.b;
        int n11 = R$string.set_remove_bind_failed;
        string2 = g.o((Resources)string2, n11);
        y.f((y)object, n10, string2);
    }

    public void onSuccess(BaseEntity object) {
        object = new BindThirdEntity();
        Object object2 = y$i.b;
        ThirdPlatform thirdPlatform = this.a;
        int n10 = thirdPlatform.ordinal();
        int n11 = object2[n10];
        if (n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 != n10) {
                n10 = 3;
                if (n11 != n10) {
                    n10 = 4;
                    if (n11 == n10) {
                        object2 = this.c.n;
                        ((MutableLiveData)object2).setValue(object);
                    }
                } else {
                    object2 = this.c.m;
                    ((MutableLiveData)object2).setValue(object);
                }
            } else {
                object2 = this.c.l;
                ((MutableLiveData)object2).setValue(object);
            }
        } else {
            object2 = this.c.k;
            ((MutableLiveData)object2).setValue(object);
        }
        object = this.c;
        object2 = this.b;
        n10 = R$string.set_remove_bind_success;
        object2 = g.o((Resources)object2, n10);
        y.e((y)object, (String)object2);
    }
}

