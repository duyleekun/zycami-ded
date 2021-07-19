/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.TextView
 */
package com.zhiyun.cama.publish;

import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentTransaction;
import com.zhiyun.cama.publish.ComposeFragment;
import d.v.c.n1.e;
import d.v.c.n1.h2;
import d.v.c.u0.l;
import d.v.c.u0.m;
import d.v.e.i.j;
import d.v.e.l.s1;
import d.v.f.h.a;
import d.v.i0.b;

public class ComposeFragment$b {
    public final /* synthetic */ ComposeFragment a;

    public ComposeFragment$b(ComposeFragment composeFragment) {
        this.a = composeFragment;
    }

    private /* synthetic */ void d(String string2) {
        boolean bl2 = s1.q(string2);
        if (bl2) {
            l l10 = ComposeFragment.j(this.a);
            l10.M(string2);
        }
    }

    public void a(View object) {
        int n10;
        object = (Integer)ComposeFragment.j(this.a).t().getValue();
        if (object == null) {
            return;
        }
        int n11 = (Integer)object;
        if (n11 == (n10 = 2)) {
            d.v.c.x1.l.d(this.a, 2131362203);
            return;
        }
        object = ComposeFragment.k((ComposeFragment)this.a).q;
        n10 = ComposeFragment.k((ComposeFragment)this.a).q.getCheckedRadioButtonId();
        object = ((TextView)object.findViewById(n10)).getText().toString();
        Object object2 = ComposeFragment.k((ComposeFragment)this.a).p;
        int n12 = ComposeFragment.k((ComposeFragment)this.a).p.getCheckedRadioButtonId();
        object2 = ((TextView)object2.findViewById(n12)).getText().toString();
        ComposeFragment.j(this.a).N((String)object, (String)object2);
    }

    public void b(View view) {
        this.a.requireActivity().finish();
    }

    public void c(View object) {
        object = this.a.getChildFragmentManager().beginTransaction().setCustomAnimations(2130771992, 2130771991);
        a a10 = h2.s(ComposeFragment.j(this.a).v());
        ((FragmentTransaction)object).add(2131362470, a10).commit();
        object = ((m)b.c(this.a.requireActivity()).get(m.class)).d();
        a10 = this.a;
        e e10 = new e(this);
        ((j)object).observe(a10, e10);
    }

    public /* synthetic */ void e(String string2) {
        this.d(string2);
    }
}

