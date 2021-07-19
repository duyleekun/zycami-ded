/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 */
package d.v.c.q0;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import com.zhiyun.cama.main.EditorMainActivity;
import com.zhiyun.cama.template.edit.EditorTemplateEditActivity;
import d.v.c.m1.b;
import d.v.c.m1.d.l;
import d.v.c.m1.d.l$b;
import d.v.c.q0.c$a;
import d.v.f.h.a;

public abstract class c
extends a {
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    public int b;
    public boolean c;

    public void j() {
    }

    public void k() {
    }

    public void l(int n10) {
        this.m(n10, null);
    }

    public void m(int n10, Bundle bundle) {
        this.n(this, n10, bundle);
    }

    public void n(Fragment fragment, int n10, Bundle bundle) {
        NavHostFragment.findNavController(fragment).navigate(n10, bundle);
    }

    public void o(Fragment fragment, NavDirections navDirections, Bundle bundle) {
        if (navDirections == null) {
            return;
        }
        int n10 = navDirections.getActionId();
        this.n(fragment, n10, bundle);
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        super.onActivityResult(n10, n11, intent);
        n11 = 4097;
        if (n10 == n11 && (n10 = (int)(d.v.c.m1.b.a() ? 1 : 0)) != 0) {
            this.j();
            FragmentActivity fragmentActivity = this.requireActivity();
            n11 = this.b;
            int n12 = 1;
            if (n11 != n12) {
                int n13 = 2;
                if (n11 == n13 && (n11 = fragmentActivity instanceof EditorMainActivity) != 0) {
                    fragmentActivity = (EditorMainActivity)fragmentActivity;
                    ((EditorMainActivity)fragmentActivity).N(n12 != 0);
                }
            } else {
                n11 = fragmentActivity instanceof EditorMainActivity;
                if (n11 != 0) {
                    fragmentActivity = (EditorMainActivity)fragmentActivity;
                    ((EditorMainActivity)fragmentActivity).K();
                } else {
                    n11 = fragmentActivity instanceof EditorTemplateEditActivity;
                    if (n11 != 0) {
                        fragmentActivity = (EditorTemplateEditActivity)fragmentActivity;
                        ((EditorTemplateEditActivity)fragmentActivity).r();
                    }
                }
            }
        }
    }

    public void p(NavDirections navDirections) {
        this.q(navDirections, null);
    }

    public void q(NavDirections navDirections, Bundle bundle) {
        this.o(this, navDirections, bundle);
    }

    public void r() {
        NavHostFragment.findNavController(this).navigateUp();
    }

    public boolean s(int n10) {
        return true;
    }

    public void t() {
        int n10 = this.b;
        int n11 = 1;
        if (n10 != n11) {
            int n12 = 2;
            if (n10 == n12) {
                n11 = 5;
            }
        } else {
            n11 = 4;
        }
        l l10 = l.y(n11);
        Object object = new c$a(this);
        l10 = l10.z((l$b)object);
        object = this.getChildFragmentManager();
        l10.q((FragmentManager)object);
    }
}

