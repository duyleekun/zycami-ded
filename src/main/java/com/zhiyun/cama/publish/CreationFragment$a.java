/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.zhiyun.cama.publish;

import android.content.Context;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import com.zhiyun.cama.data.me.remote.KWaiManager;
import com.zhiyun.cama.publish.CreationFragment;
import d.v.a.f.c.b;
import d.v.c.n1.g2;
import d.v.c.n1.g2$b;
import d.v.e.f;
import d.v.e.l.b2;
import d.v.e.l.n2;
import d.v.f.i.g;

public class CreationFragment$a {
    public final /* synthetic */ CreationFragment a;

    public CreationFragment$a(CreationFragment creationFragment) {
        this.a = creationFragment;
    }

    public void a() {
        this.a.requireActivity().onBackPressed();
    }

    public void b() {
        NavController navController = NavHostFragment.findNavController(this.a);
        g2$b g2$b = g2.a().c("autoEdit");
        navController.navigate(g2$b);
    }

    public void c() {
        boolean bl2;
        int n10;
        Object object = b.N();
        boolean n11 = ((b)object).s();
        if (!n11) {
            object = this.a;
            n10 = 1;
            CreationFragment.j((CreationFragment)object, n10 != 0);
        }
        if (!(bl2 = b2.m((Context)(object = f.a().c())))) {
            n2.e(g.m(this.a.requireContext(), 2131951841));
            return;
        }
        object = this.a.requireContext();
        boolean bl3 = d.v.c.m1.b.b((Context)object);
        if (bl3) {
            int n12 = b.N().i().getId();
            CreationFragment creationFragment = this.a;
            CreationFragment.k(creationFragment, n12);
            object = NavHostFragment.findNavController(this.a);
            n10 = 2131361896;
            ((NavController)object).navigate(n10);
        }
    }

    public void d() {
        NavController navController = NavHostFragment.findNavController(this.a);
        g2$b g2$b = g2.a().c("editor").d(9);
        navController.navigate(g2$b);
    }

    public void e() {
        NavHostFragment.findNavController(this.a).navigate(2131361894);
    }

    public void f() {
        Object object;
        Object object2 = KWaiManager.getInstance();
        boolean bl2 = ((KWaiManager)object2).isKwaiInstall((Context)(object = this.a.requireContext()));
        if (!bl2) {
            n2.e(g.m(this.a.requireContext(), 2131953271));
            return;
        }
        object2 = NavHostFragment.findNavController(this.a);
        object = g2.a().c("kwai").d(31);
        ((NavController)object2).navigate((NavDirections)object);
    }

    public void g() {
        NavHostFragment.findNavController(this.a).navigate(2131361895);
    }

    public void h() {
        NavHostFragment.findNavController(this.a).navigate(2131361898);
    }
}

