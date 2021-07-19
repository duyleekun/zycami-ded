/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.a.j.c;

import android.content.Context;
import androidx.lifecycle.LiveData;
import com.zhiyun.account.R$string;
import com.zhiyun.account.set.privacy.getcode.PrivateGetCodeStatus;
import com.zhiyun.net.BaseEntity;
import d.v.a.f.b.a;
import d.v.a.j.c.y;
import d.v.e.i.j;
import d.v.f.i.g;

public class y$a
extends a {
    public final /* synthetic */ PrivateGetCodeStatus a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ y c;

    public y$a(y y10, PrivateGetCodeStatus privateGetCodeStatus, Context context) {
        this.c = y10;
        this.a = privateGetCodeStatus;
        this.b = context;
    }

    public void onError(Throwable object, int n10, String string2) {
        Object object2;
        object = this.c.b;
        boolean n11 = ((LiveData)object).hasObservers();
        if (n11 && (object = this.a) == (object2 = this.c.f.getValue())) {
            object = this.c.u;
            object2 = Boolean.FALSE;
            ((j)object).setValue(object2);
            int n12 = 202;
            if (n12 == n10 && ((object = PrivateGetCodeStatus.BIND) == (object2 = this.a) || (object = PrivateGetCodeStatus.CHANGE_BIND_SECOND) == object2)) {
                object = this.c;
                Object string3 = this.b;
                int n13 = R$string.set_account_bound_retry;
                string3 = g.m(string3, n13);
                y.b((y)object, (String)string3);
            } else {
                object = this.c;
                object2 = this.b;
                String string3 = d.v.a.f.b.a.fromErrCodeToMessage((Context)object2, n10, string2);
                y.b((y)object, string3);
            }
        }
    }

    public void onSuccess(BaseEntity baseEntity) {
    }
}

