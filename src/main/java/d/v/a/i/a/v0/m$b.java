/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 */
package d.v.a.i.a.v0;

import android.content.Context;
import android.view.View;
import com.zhiyun.account.me.account.getcode.GetCodeStatus;
import d.v.a.i.a.m0;
import d.v.a.i.a.v0.m;
import d.v.a.k.a;

public class m$b {
    public final /* synthetic */ m a;

    public m$b(m m10) {
        this.a = m10;
    }

    public void a(View view) {
        m0 m02 = m.k(this.a);
        Context context = view.getContext();
        GetCodeStatus getCodeStatus = this.a.a();
        String string2 = m.l((m)this.a).f.getCountryCode();
        String string3 = m.l((m)this.a).f.getName();
        String string4 = m.l((m)this.a).g.getCode();
        m02.k(context, getCodeStatus, string2, string3, string4);
    }

    public void b(View object) {
        boolean bl2 = d.v.a.k.a.g(object);
        if (!bl2) {
            object = this.a.requireActivity();
            object.finishAfterTransition();
        }
    }

    public void c(View view) {
        this.a.o(view);
    }
}

