/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 */
package l.a.j.a;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.content.res.AppCompatResources;
import l.a.j.a.b;
import l.a.j.a.d;
import l.a.j.a.f;
import l.a.j.a.i;

public class h
implements i {
    private static h a;

    private h() {
        d.h().a(this);
    }

    public static Drawable a(Context context, int n10) {
        return h.b().c(context, n10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static h b() {
        Object object = a;
        if (object != null) return a;
        object = h.class;
        synchronized (object) {
            h h10 = a;
            if (h10 != null) return a;
            a = h10 = new h();
            return a;
        }
    }

    private Drawable c(Context context, int n10) {
        int n11;
        boolean n112 = AppCompatDelegate.isCompatVectorFromResourcesEnabled();
        if (n112) {
            boolean bl2;
            Object object = d.h();
            boolean bl3 = ((d)object).u();
            if (!bl3) {
                object = b.o();
                try {
                    return ((b)object).q(context, n10);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            if (!(bl2 = ((f)(object = f.n())).x()) && (object = f.n().s(n10)) != null) {
                n10 = object.getDefaultColor();
                context = new ColorDrawable(n10);
                return context;
            }
            object = f.n();
            boolean bl4 = ((f)object).y();
            if (!bl4 && (object = f.n().t(n10)) != null) {
                return object;
            }
            object = d.h().q(context, n10);
            if (object != null) {
                return object;
            }
            return AppCompatResources.getDrawable(context, n10);
        }
        Object object = f.n();
        boolean bl5 = ((f)object).x();
        if (!bl5 && (object = f.n().s(n10)) != null) {
            n10 = object.getDefaultColor();
            context = new ColorDrawable(n10);
            return context;
        }
        object = f.n();
        boolean bl6 = ((f)object).y();
        if (!bl6 && (object = f.n().t(n10)) != null) {
            return object;
        }
        object = d.h().q(context, n10);
        if (object != null) {
            return object;
        }
        object = d.h();
        boolean bl7 = ((d)object).u();
        if (!bl7 && (n11 = ((d)(object = d.h())).r(context, n10)) != 0) {
            return d.h().m().getDrawable(n11);
        }
        return AppCompatResources.getDrawable(context, n10);
    }

    public void clear() {
        b.o().f();
    }
}

