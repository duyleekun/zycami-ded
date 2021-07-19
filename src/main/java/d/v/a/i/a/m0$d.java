/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.view.View
 */
package d.v.a.i.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.LiveData;
import com.zhiyun.account.R$string;
import com.zhiyun.net.BaseEntity;
import d.v.a.f.b.a;
import d.v.a.i.a.m0;
import d.v.e.i.j;
import d.v.f.i.g;

public class m0$d
extends a {
    public final /* synthetic */ View a;
    public final /* synthetic */ String b;
    public final /* synthetic */ m0 c;

    public m0$d(m0 m02, View view, String string2) {
        this.c = m02;
        this.a = view;
        this.b = string2;
    }

    /*
     * WARNING - void declaration
     */
    public void onError(Throwable object, int n10, String string2) {
        object = this.c.c;
        boolean n11 = ((LiveData)object).hasObservers();
        if (n11) {
            object = this.c.v;
            Boolean bl2 = Boolean.FALSE;
            ((j)object).setValue(bl2);
            int n12 = 211;
            if (n12 == n10) {
                void var4_9;
                object = this.b;
                boolean bl3 = TextUtils.isEmpty((CharSequence)object);
                if (bl3) {
                    int n13 = R$string.me_email_not_register;
                } else {
                    int n14 = R$string.me_phone_not_register;
                }
                j j10 = this.c.z;
                string2 = this.a;
                object = g.q((View)string2, (int)var4_9);
                j10.setValue(object);
            } else {
                object = this.c;
                bl2 = this.a.getContext();
                String string3 = d.v.a.f.b.a.fromErrCodeToMessage((Context)bl2, n10, string2);
                m0.c((m0)object, string3);
            }
        }
    }

    public void onSuccess(BaseEntity object) {
        object = this.c.c;
        boolean bl2 = ((LiveData)object).hasObservers();
        if (bl2) {
            object = this.c.v;
            Object object2 = Boolean.FALSE;
            ((j)object).setValue(object2);
            object = this.c;
            object2 = this.a;
            int n10 = R$string.me_login_success;
            object2 = g.q((View)object2, n10);
            m0.b((m0)object, (String)object2);
            object = this.c.C;
            object2 = Boolean.TRUE;
            ((j)object).setValue(object2);
        }
    }
}

