/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.view.View
 */
package d.v.a.j.c;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.LiveData;
import com.zhiyun.account.R$string;
import com.zhiyun.account.data.api.entity.GetCodeEntity;
import com.zhiyun.account.set.privacy.getcode.PrivateGetCodeStatus;
import d.v.a.f.b.a;
import d.v.a.j.c.y;
import d.v.e.i.j;
import d.v.f.i.g;

public class y$b
extends a {
    public final /* synthetic */ PrivateGetCodeStatus a;
    public final /* synthetic */ View b;
    public final /* synthetic */ y c;

    public y$b(y y10, PrivateGetCodeStatus privateGetCodeStatus, View view) {
        this.c = y10;
        this.a = privateGetCodeStatus;
        this.b = view;
    }

    public void a(GetCodeEntity object) {
        Object object2;
        Object object3 = this.c.b;
        boolean bl2 = object3.hasObservers();
        if (bl2 && (object3 = this.a) == (object2 = this.c.f.getValue())) {
            if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object3 = ((GetCodeEntity)object).vtoken))) && (object3 = PrivateGetCodeStatus.MODIFY_PASS) == (object2 = this.a)) {
                object3 = this.c;
                object = ((GetCodeEntity)object).vtoken;
                y.c((y)object3, (String)object);
            }
            if ((object = this.a) == (object3 = PrivateGetCodeStatus.CHANGE_BIND_SECOND)) {
                object = this.c;
                object3 = this.b;
                int n10 = R$string.set_bind_change_success;
                object3 = g.q((View)object3, n10);
                y.d((y)object, (String)object3);
            }
            object = this.c.o;
            object3 = Boolean.FALSE;
            ((j)object).setValue(object3);
            object = this.c.p;
            object3 = Boolean.TRUE;
            ((j)object).setValue(object3);
        }
    }

    public void onError(Throwable object, int n10, String string2) {
        Object object2;
        object = this.c.b;
        boolean bl2 = ((LiveData)object).hasObservers();
        if (bl2 && (object = this.a) == (object2 = this.c.f.getValue())) {
            object = this.c.o;
            object2 = Boolean.FALSE;
            ((j)object).setValue(object2);
            object = this.c;
            object2 = this.b.getContext();
            String string3 = d.v.a.f.b.a.fromErrCodeToMessage((Context)object2, n10, string2);
            y.b((y)object, string3);
        }
    }
}

