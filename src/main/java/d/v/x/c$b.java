/*
 * Decompiled with CFR 0.151.
 */
package d.v.x;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.zhiyun.permission.Permission;
import d.v.x.b;
import d.v.x.c;

public class c$b {
    private final String a;
    private final Permission b;
    private b c;

    public c$b(Permission permission) {
        this(permission, null);
    }

    public c$b(Permission permission, String string2) {
        this.a = string2;
        this.b = permission;
    }

    public c$b a(b b10) {
        this.c = b10;
        return this;
    }

    public void b(FragmentManager object) {
        boolean bl2 = ((FragmentManager)object).isDestroyed();
        if (bl2) {
            return;
        }
        String string2 = "permission_helper";
        Fragment fragment = ((FragmentManager)object).findFragmentByTag(string2);
        if (fragment != null) {
            fragment = (c)fragment;
            object = this.a;
            d.v.x.c.h((c)fragment, (String)object);
            object = this.b;
            d.v.x.c.i((c)fragment, (Permission)((Object)object));
            object = this.c;
            d.v.x.c.j((c)fragment, (b)object);
            d.v.x.c.k((c)fragment);
        } else {
            fragment = new c();
            Object object2 = this.a;
            d.v.x.c.h((c)fragment, object2);
            object2 = this.b;
            d.v.x.c.i((c)fragment, (Permission)((Object)object2));
            object2 = this.c;
            d.v.x.c.j((c)fragment, (b)object2);
            object = ((FragmentManager)object).beginTransaction().add(fragment, string2);
            ((FragmentTransaction)object).commitAllowingStateLoss();
        }
    }
}

