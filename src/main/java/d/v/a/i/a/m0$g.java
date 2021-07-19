/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.a.i.a;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.zhiyun.account.me.account.getcode.GetCodeStatus;
import com.zhiyun.net.BaseEntity;
import d.v.a.f.b.a;
import d.v.a.i.a.m0;
import d.v.e.i.j;

public class m0$g
extends a {
    public final /* synthetic */ GetCodeStatus a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ String c;
    public final /* synthetic */ m0 d;

    public m0$g(m0 m02, GetCodeStatus getCodeStatus, Context context, String string2) {
        this.d = m02;
        this.a = getCodeStatus;
        this.b = context;
        this.c = string2;
    }

    public void onError(Throwable object, int n10, String string2) {
        Object object2;
        object = this.d.i;
        boolean bl2 = ((LiveData)object).hasObservers();
        if (bl2 && (object = this.a) == (object2 = this.d.l.getValue())) {
            object = this.d.D;
            object2 = Boolean.FALSE;
            ((j)object).setValue(object2);
            object = this.b;
            String string3 = d.v.a.f.b.a.fromErrCodeToMessage((Context)object, n10, string2);
            object2 = this.d;
            Context context = this.b;
            GetCodeStatus getCodeStatus = this.a;
            String string4 = this.c;
            m0.d((m0)object2, context, getCodeStatus, string4, n10, string3);
        }
    }

    public void onSuccess(BaseEntity baseEntity) {
    }
}

