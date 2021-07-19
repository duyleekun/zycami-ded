/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.view.View
 */
package d.v.a.i.a;

import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.LiveData;
import com.zhiyun.account.R$string;
import com.zhiyun.account.data.database.model.UserInfo;
import d.v.a.f.b.a;
import d.v.a.i.a.m0;
import d.v.e.i.j;
import d.v.f.i.g;

public class m0$k
extends a {
    public final /* synthetic */ View a;
    public final /* synthetic */ m0 b;

    public m0$k(m0 m02, View view) {
        this.b = m02;
        this.a = view;
    }

    public void onError(Throwable object, int n10, String string2) {
        object = this.b.b;
        boolean bl2 = ((LiveData)object).hasObservers();
        if (bl2) {
            object = this.b.v;
            Boolean bl3 = Boolean.FALSE;
            ((j)object).setValue(bl3);
            object = this.b;
            m0.c((m0)object, string2);
        }
    }

    public void onSuccess(UserInfo object) {
        Boolean bl2 = Boolean.TRUE;
        Object object2 = this.b.b;
        boolean bl3 = ((LiveData)object2).hasObservers();
        if (bl3) {
            boolean bl4;
            object2 = this.b.v;
            Boolean bl5 = Boolean.FALSE;
            ((j)object2).setValue(bl5);
            object2 = ((UserInfo)object).getMobile();
            bl3 = TextUtils.isEmpty((CharSequence)object2);
            if (bl3 && (bl4 = TextUtils.isEmpty((CharSequence)(object = ((UserInfo)object).getMail())))) {
                object = this.b.w;
                ((j)object).setValue(bl2);
            } else {
                object = this.b;
                object2 = this.a;
                int n10 = R$string.me_login_success;
                object2 = g.q((View)object2, n10);
                m0.b((m0)object, (String)object2);
                object = this.b.C;
                ((j)object).setValue(bl2);
            }
        }
    }
}

