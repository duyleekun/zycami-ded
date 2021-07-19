/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.view.View
 */
package d.v.f.i;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.fragment.NavHostFragment;
import d.v.e.l.o1;
import d.v.f.i.b;
import d.v.f.i.c;
import d.v.f.i.d;
import d.v.f.i.e;
import d.v.f.i.g$a;
import java.util.stream.Stream;
import l.a.c$b;
import l.a.i.d.a;
import l.a.o.f;
import l.a.q.g0.p;
import l.a.q.g0.q$a;
import l.a.q.g0.s;
import l.a.q.j;
import l.a.q.z;

public class g {
    public static /* synthetic */ boolean A(Fragment fragment) {
        return fragment instanceof z;
    }

    public static /* synthetic */ void B(Fragment fragment) {
        ((z)((Object)fragment)).e();
    }

    public static /* synthetic */ boolean C(Fragment object) {
        boolean bl2;
        boolean bl3 = object instanceof NavHostFragment;
        if (bl3 && (object = ((Fragment)object).getHost()) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static /* synthetic */ Stream D(Fragment fragment) {
        return fragment.getChildFragmentManager().getFragments().stream();
    }

    public static void E(String string2, c$b c$b) {
        l.a.c c10 = l.a.c.r();
        g$a g$a = new g$a(c$b);
        c10.F(string2, g$a, 1);
    }

    public static void F() {
        l.a.c.r().H();
    }

    private static void a(Stream stream) {
        Object object = e.a;
        stream = stream.filter(object);
        object = d.a;
        stream.forEach(object);
    }

    public static void b(FragmentManager object) {
        if (object == null) {
            return;
        }
        object = ((FragmentManager)object).getFragments();
        Stream stream = object.stream();
        Object object2 = c.a;
        stream = stream.filter(object2);
        object2 = b.a;
        g.a(stream.flatMap(object2));
        g.a(object.stream());
    }

    public static int c(Context context, int n10) {
        Resources resources = context.getResources();
        int n11 = o1.c(resources, n10);
        if ((n10 = j.b(n10)) != 0) {
            n11 = l.a.j.a.d.c(context, n10);
        }
        return n11;
    }

    public static int d(View view, int n10) {
        return g.c(view.getContext(), n10);
    }

    public static int e(Fragment fragment, int n10) {
        return g.c(fragment.requireContext(), n10);
    }

    public static Drawable f(Context context, int n10) {
        Drawable drawable2 = o1.o(context.getResources(), n10);
        if ((n10 = j.b(n10)) != 0) {
            drawable2 = l.a.j.a.d.g(context, n10);
        }
        return drawable2;
    }

    public static Drawable g(View view, int n10) {
        return g.f(view.getContext(), n10);
    }

    public static Drawable h(Fragment fragment, int n10) {
        return g.f(fragment.requireContext(), n10);
    }

    public static String i(Context context, int n10, int ... nArray) {
        int n11;
        context = o1.J(context);
        if (nArray != null && (n11 = nArray.length) != 0) {
            int n12;
            n11 = nArray.length;
            Object[] objectArray = new String[n11];
            for (int i10 = 0; i10 < (n12 = nArray.length); ++i10) {
                n12 = nArray[i10];
                String string2 = p.h((Resources)context, n12);
                objectArray[i10] = string2;
            }
            return p.i((Resources)context, n10, objectArray);
        }
        return p.h((Resources)context, n10);
    }

    public static String j(View view, int n10, int ... nArray) {
        return g.i(view.getContext(), n10, nArray);
    }

    public static String k(Fragment fragment, int n10, int ... nArray) {
        return g.i(fragment.requireContext(), n10, nArray);
    }

    public static int l(Context context, int n10) {
        l.a.j.a.d d10 = l.a.j.a.d.h();
        boolean bl2 = d10.u();
        if (bl2) {
            return n10;
        }
        if ((n10 = j.b(n10)) != 0) {
            d10 = l.a.j.a.d.h();
            n10 = d10.r(context, n10);
        }
        return n10;
    }

    public static String m(Context context, int n10) {
        return g.o(o1.J(context), n10);
    }

    public static String n(Context context, int n10, Object ... objectArray) {
        return g.p(o1.J(context), n10, objectArray);
    }

    public static String o(Resources resources, int n10) {
        return p.h(resources, n10);
    }

    public static String p(Resources resources, int n10, Object ... objectArray) {
        return p.i(resources, n10, objectArray);
    }

    public static String q(View view, int n10) {
        return g.m(view.getContext(), n10);
    }

    public static String r(View view, int n10, Object ... objectArray) {
        return g.n(view.getContext(), n10, objectArray);
    }

    public static String s(Fragment fragment, int n10) {
        return g.m(fragment.requireContext(), n10);
    }

    public static String t(Fragment fragment, int n10, Object ... objectArray) {
        return g.n(fragment.requireContext(), n10, objectArray);
    }

    public static String[] u(Context context, int n10) {
        return g.v(o1.J(context), n10);
    }

    public static String[] v(Resources resources, int n10) {
        return p.j(resources, n10);
    }

    public static String[] w(View view, int n10) {
        return g.u(view.getContext(), n10);
    }

    public static String[] x(Fragment fragment, int n10) {
        return g.u(fragment.requireContext(), n10);
    }

    public static void y(Application object) {
        f.a = false;
        object = l.a.c.L((Application)object);
        l.a.e.g g10 = new l.a.e.b();
        object = ((l.a.c)object).l(g10);
        g10 = new l.a.k.c.a();
        object = ((l.a.c)object).l(g10);
        g10 = new a();
        object = ((l.a.c)object).l(g10);
        g10 = new l.a.e.c();
        object = ((l.a.c)object).l(g10);
        boolean bl2 = true;
        ((l.a.c)object).J(bl2).I(false).B();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(bl2);
    }

    public static void z(Context context, String string2, String string3, q$a q$a) {
        s.a().b(context, string2, q$a);
        s.a().c(string3);
    }
}

