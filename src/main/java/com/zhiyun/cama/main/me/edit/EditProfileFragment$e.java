/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.view.View
 */
package com.zhiyun.cama.main.me.edit;

import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.zhiyun.account.me.country.CountryChooseActivity;
import com.zhiyun.cama.main.me.edit.EditProfileFragment;
import d.v.c.i1.t2.i0;
import d.v.c.i1.t2.p0.b;
import d.v.c.i1.t2.p0.c;
import d.v.c.x1.l;
import d.v.e.l.o1;
import d.v.e.l.s1;
import d.v.f.i.g;
import d.v.g0.i;
import d.v.g0.i$c;
import d.v.g0.o;
import java.util.ArrayList;
import java.util.List;

public class EditProfileFragment$e {
    public final /* synthetic */ EditProfileFragment a;

    public EditProfileFragment$e(EditProfileFragment editProfileFragment) {
        this.a = editProfileFragment;
    }

    private /* synthetic */ void f(int n10) {
        if (n10 == 0) {
            EditProfileFragment editProfileFragment = this.a;
            editProfileFragment.H();
        } else {
            int n11 = 1;
            if (n11 == n10) {
                EditProfileFragment editProfileFragment = this.a;
                editProfileFragment.G();
            }
        }
    }

    private /* synthetic */ void h(List object, int n10) {
        i0 i02 = EditProfileFragment.m(this.a);
        int n11 = n10 + 1;
        i02.K(n11);
        i02 = EditProfileFragment.j((EditProfileFragment)this.a).m;
        object = ((o)object.get(n10)).b();
        i02.setText((CharSequence)object);
    }

    public void a(View object) {
        object = new ArrayList();
        int n10 = o1.a(this.a.requireContext(), 2131099739);
        String string2 = g.m(this.a.requireContext(), 2131952498);
        Object object2 = new o(string2, n10);
        object.add(object2);
        string2 = g.m(this.a.requireContext(), 2131952497);
        object2 = new o(string2, n10);
        object.add(object2);
        object = i.w(false).B((List)object);
        Object object3 = new c(this);
        object = ((i)object).D((i$c)object3);
        object3 = this.a.getChildFragmentManager();
        object2 = i.class.getName();
        ((DialogFragment)object).show((FragmentManager)object3, (String)object2);
    }

    public void b(View view) {
        CountryChooseActivity.q(this.a.requireActivity(), false);
    }

    public void c(View object) {
        object = new ArrayList();
        int n10 = o1.a(this.a.requireContext(), 2131099739);
        String string2 = g.m(this.a.requireContext(), 2131952542);
        Object object2 = new o(string2, n10);
        object.add(object2);
        string2 = g.m(this.a.requireContext(), 2131952575);
        object2 = new o(string2, n10);
        object.add(object2);
        string2 = g.m(this.a.requireContext(), 2131952573);
        object2 = new o(string2, n10);
        object.add(object2);
        Object object3 = i.w(false).B((List)object);
        object2 = new b(this, (List)object);
        object = ((i)object3).D((i$c)object2);
        object3 = this.a.getChildFragmentManager();
        object2 = i.class.getName();
        ((DialogFragment)object).show((FragmentManager)object3, (String)object2);
    }

    public void d(View object) {
        String string2 = EditProfileFragment.j((EditProfileFragment)this.a).b.getText().toString();
        String string3 = EditProfileFragment.j((EditProfileFragment)this.a).g.getText().toString();
        int n10 = EditProfileFragment.m(this.a).j();
        object = EditProfileFragment.j((EditProfileFragment)this.a).a.getText();
        String string4 = object.toString();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            object = this.a;
            Object object2 = ((Fragment)object).requireContext();
            int n11 = 2131952550;
            object2 = g.m(object2, n11);
            EditProfileFragment.k((EditProfileFragment)object, (String)object2);
        } else {
            object = EditProfileFragment.m(this.a).b();
            object = object == null ? "" : s1.G(EditProfileFragment.m(this.a).b());
            EditProfileFragment editProfileFragment = this.a;
            EditProfileFragment.n(editProfileFragment, (String)object, string2, n10, string3, string4);
        }
    }

    public void e(View view) {
        l.g(view);
    }

    public /* synthetic */ void g(int n10) {
        this.f(n10);
    }

    public /* synthetic */ void i(List list, int n10) {
        this.h(list, n10);
    }
}

