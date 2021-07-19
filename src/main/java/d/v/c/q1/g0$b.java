/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c.q1;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.data.api.entity.VersionInfo;
import com.zhiyun.cama.data.me.remote.UpdateManager$OnUpdateVersionCallback;
import d.v.c.q1.g0;
import d.v.e.i.j;
import d.v.f.i.g;

public class g0$b
implements UpdateManager$OnUpdateVersionCallback {
    public final /* synthetic */ Context a;
    public final /* synthetic */ g0 b;

    public g0$b(g0 g02, Context context) {
        this.b = g02;
        this.a = context;
    }

    public void onError() {
        MutableLiveData mutableLiveData = this.b.q;
        boolean bl2 = mutableLiveData.hasActiveObservers();
        if (bl2) {
            mutableLiveData = g0.c(this.b);
            Object object = this.a;
            int n10 = 2131952827;
            object = g.m(object, n10);
            mutableLiveData.setValue(object);
        }
    }

    public void onVersionInfo(VersionInfo object) {
        Object object2 = this.b.q;
        boolean bl2 = ((LiveData)object2).hasActiveObservers();
        if (bl2) {
            if (object != null && (bl2 = ((VersionInfo)object).isValid())) {
                object2 = this.b.q;
                ((j)object2).setValue(object);
            } else {
                object = g0.c(this.b);
                object2 = this.a;
                int n10 = 2131953198;
                object2 = g.m((Context)object2, n10);
                ((MutableLiveData)object).setValue(object2);
            }
        }
    }
}

