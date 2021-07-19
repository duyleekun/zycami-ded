/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.view.View
 */
package d.v.c.n1;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import d.v.c.n1.i2;
import d.v.e.l.n2;
import d.v.f.i.g;

public class i2$b {
    public final /* synthetic */ i2 a;

    public i2$b(i2 i22) {
        this.a = i22;
    }

    public void a(View object) {
        object = i2.v((i2)this.a).a.getText().toString().trim();
        int n10 = TextUtils.isEmpty((CharSequence)object);
        if (n10 != 0) {
            object = this.a.requireContext();
            n10 = 2131952784;
            object = g.m((Context)object, n10);
            n2.e((String)object);
        } else {
            i2 i22 = this.a;
            i2.w(i22, (String)object);
        }
    }

    public void b(View view) {
        i2.x(this.a);
    }
}

