/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.a.i.a;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.net.BaseEntity;
import d.v.a.f.b.a;
import d.v.a.i.a.m0;
import d.v.e.i.j;

public class m0$f
extends a {
    public final /* synthetic */ Context a;
    public final /* synthetic */ m0 b;

    public m0$f(m0 m02, Context context) {
        this.b = m02;
        this.a = context;
    }

    public void onError(Throwable object, int n10, String string2) {
        object = this.b.f;
        boolean bl2 = ((LiveData)object).hasObservers();
        if (bl2) {
            object = this.b.v;
            Boolean bl3 = Boolean.FALSE;
            ((j)object).setValue(bl3);
            object = this.b;
            bl3 = this.a;
            String string3 = d.v.a.f.b.a.fromErrCodeToMessage((Context)bl3, n10, string2);
            m0.b((m0)object, string3);
        }
    }

    public void onSuccess(BaseEntity object) {
        object = this.b.f;
        boolean bl2 = ((LiveData)object).hasObservers();
        if (bl2) {
            object = this.b.v;
            Boolean bl3 = Boolean.FALSE;
            ((j)object).setValue(bl3);
            object = this.b.g;
            bl3 = Boolean.TRUE;
            ((MutableLiveData)object).setValue(bl3);
        }
    }
}

