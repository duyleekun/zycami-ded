/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package d.v.a.i.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import com.zhiyun.account.data.api.entity.GetCodeEntity;
import com.zhiyun.account.me.account.getcode.GetCodeStatus;
import d.v.a.f.b.a;
import d.v.a.i.a.m0;
import d.v.e.i.j;

public class m0$h
extends a {
    public final /* synthetic */ GetCodeStatus a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ String c;
    public final /* synthetic */ m0 d;

    public m0$h(m0 m02, GetCodeStatus getCodeStatus, Context context, String string2) {
        this.d = m02;
        this.a = getCodeStatus;
        this.b = context;
        this.c = string2;
    }

    public void a(GetCodeEntity object) {
        Object object2;
        Object object3 = this.d.i;
        boolean bl2 = object3.hasObservers();
        if (bl2 && (object3 = this.a) == (object2 = this.d.l.getValue())) {
            if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object3 = ((GetCodeEntity)object).vtoken))) && (object3 = GetCodeStatus.THIRD_BIND) != (object2 = this.a)) {
                object3 = this.d;
                object = ((GetCodeEntity)object).vtoken;
                m0.e((m0)object3, (String)object);
            }
            object = this.d.v;
            object3 = Boolean.FALSE;
            ((j)object).setValue(object3);
            object = this.d.w;
            object3 = Boolean.TRUE;
            ((j)object).setValue(object3);
        }
    }

    public void onError(Throwable object, int n10, String string2) {
        Object object2;
        object = this.d.i;
        boolean bl2 = ((LiveData)object).hasObservers();
        if (bl2 && (object = this.a) == (object2 = this.d.l.getValue())) {
            object = this.d.v;
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
}

