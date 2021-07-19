/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.XmlResourceParser
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  android.util.TypedValue
 */
package l.a.j.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import java.util.ArrayList;
import java.util.List;
import l.a.c;
import l.a.c$c;
import l.a.j.a.f;
import l.a.j.a.i;

public class d {
    private static volatile d g;
    private Resources a;
    private String b;
    private String c;
    private c$c d;
    private boolean e;
    private List f;

    private d() {
        ArrayList arrayList = "";
        this.b = arrayList;
        this.c = arrayList;
        this.e = true;
        this.f = arrayList = new ArrayList();
    }

    public static int c(Context context, int n10) {
        return l.a.j.a.d.h().i(context, n10);
    }

    public static ColorStateList e(Context context, int n10) {
        return l.a.j.a.d.h().j(context, n10);
    }

    public static Drawable g(Context context, int n10) {
        return l.a.j.a.d.h().k(context, n10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static d h() {
        Object object = g;
        if (object != null) return g;
        object = d.class;
        synchronized (object) {
            d d10 = g;
            if (d10 != null) return g;
            g = d10 = new d();
            return g;
        }
    }

    private int i(Context context, int n10) {
        int n11;
        String string2;
        Object object = l.a.j.a.f.n();
        boolean n112 = ((f)object).x();
        if (!n112 && (object = l.a.j.a.f.n().s(n10)) != null) {
            return object.getDefaultColor();
        }
        object = this.d;
        if (object != null && (object = object.d(context, string2 = this.c, n10)) != null) {
            return object.getDefaultColor();
        }
        boolean bl2 = this.e;
        if (!bl2 && (n11 = this.r(context, n10)) != 0) {
            return this.a.getColor(n11);
        }
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 23;
        if (n12 >= n13) {
            object = context.getResources();
            context = context.getTheme();
            return object.getColor(n10, (Resources.Theme)context);
        }
        return context.getResources().getColor(n10);
    }

    private ColorStateList j(Context context, int n10) {
        int n11;
        String string2;
        Object object = l.a.j.a.f.n();
        boolean n112 = ((f)object).x();
        if (!n112 && (object = l.a.j.a.f.n().s(n10)) != null) {
            return object;
        }
        object = this.d;
        if (object != null && (object = object.e(context, string2 = this.c, n10)) != null) {
            return object;
        }
        boolean bl2 = this.e;
        if (!bl2 && (n11 = this.r(context, n10)) != 0) {
            return this.a.getColorStateList(n11);
        }
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 23;
        if (n12 >= n13) {
            object = context.getResources();
            context = context.getTheme();
            return object.getColorStateList(n10, (Resources.Theme)context);
        }
        return context.getResources().getColorStateList(n10);
    }

    private Drawable k(Context context, int n10) {
        int n11;
        String string2;
        Object object = l.a.j.a.f.n();
        boolean n112 = ((f)object).x();
        if (!n112 && (object = l.a.j.a.f.n().s(n10)) != null) {
            n10 = object.getDefaultColor();
            context = new ColorDrawable(n10);
            return context;
        }
        object = l.a.j.a.f.n();
        boolean bl2 = ((f)object).y();
        if (!bl2 && (object = l.a.j.a.f.n().t(n10)) != null) {
            return object;
        }
        object = this.d;
        if (object != null && (object = object.a(context, string2 = this.c, n10)) != null) {
            return object;
        }
        boolean bl3 = this.e;
        if (!bl3 && (n11 = this.r(context, n10)) != 0) {
            return this.a.getDrawable(n11);
        }
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 21;
        if (n12 >= n13) {
            object = context.getResources();
            context = context.getTheme();
            return object.getDrawable(n10, (Resources.Theme)context);
        }
        return context.getResources().getDrawable(n10);
    }

    private void n(Context context, int n10, TypedValue typedValue, boolean bl2) {
        int n11 = this.e;
        if (n11 == 0 && (n11 = this.r(context, n10)) != 0) {
            this.a.getValue(n11, typedValue, bl2);
            return;
        }
        context.getResources().getValue(n10, typedValue, bl2);
    }

    private XmlResourceParser o(Context context, int n10) {
        int n11 = this.e;
        if (n11 == 0 && (n11 = this.r(context, n10)) != 0) {
            return this.a.getXml(n11);
        }
        return context.getResources().getXml(n10);
    }

    public static void s(Context context, int n10, TypedValue typedValue, boolean bl2) {
        l.a.j.a.d.h().n(context, n10, typedValue, bl2);
    }

    public static XmlResourceParser t(Context context, int n10) {
        return l.a.j.a.d.h().o(context, n10);
    }

    public void a(i i10) {
        this.f.add(i10);
    }

    public int b(int n10) {
        return l.a.j.a.d.c(l.a.c.r().n(), n10);
    }

    public ColorStateList d(int n10) {
        return l.a.j.a.d.e(l.a.c.r().n(), n10);
    }

    public Drawable f(int n10) {
        return l.a.j.a.d.g(l.a.c.r().n(), n10);
    }

    public String l() {
        return this.b;
    }

    public Resources m() {
        return this.a;
    }

    public c$c p() {
        return this.d;
    }

    public Drawable q(Context context, int n10) {
        c$c c$c = this.d;
        if (c$c != null) {
            String string2 = this.c;
            return c$c.a(context, string2, n10);
        }
        return null;
    }

    public int r(Context object, int n10) {
        Object object2;
        String string2;
        block13: {
            block12: {
                string2 = null;
                try {
                    object2 = this.d;
                    if (object2 == null) break block12;
                }
                catch (Exception exception) {
                    return 0;
                }
                string2 = this.c;
                string2 = object2.c((Context)object, string2, n10);
            }
            boolean bl2 = TextUtils.isEmpty(string2);
            if (!bl2) break block13;
            string2 = object.getResources();
            string2 = string2.getResourceEntryName(n10);
        }
        object = object.getResources();
        object = object.getResourceTypeName(n10);
        Resources resources = this.a;
        object2 = this.b;
        return resources.getIdentifier(string2, (String)object, (String)object2);
    }

    public boolean u() {
        return this.e;
    }

    public void v() {
        c$c c$c = (c$c)l.a.c.r().u().get(-1);
        this.w(c$c);
    }

    public void w(c$c object) {
        boolean bl2;
        boolean bl3;
        Object object2 = l.a.c.r().n().getResources();
        this.a = object2;
        object2 = "";
        this.b = object2;
        this.c = object2;
        this.d = object;
        this.e = bl3 = true;
        l.a.j.a.f.n().i();
        object = this.f.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (i)object.next();
            object2.clear();
        }
    }

    public void x(Resources object, String object2, String string2, c$c c$c) {
        boolean bl2;
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)object2)) && !(bl2 = TextUtils.isEmpty((CharSequence)string2))) {
            boolean bl3;
            this.a = object;
            this.b = object2;
            this.c = string2;
            this.d = c$c;
            this.e = false;
            l.a.j.a.f.n().i();
            object = this.f.iterator();
            while (bl3 = object.hasNext()) {
                object2 = (i)object.next();
                object2.clear();
            }
            return;
        }
        this.w(c$c);
    }
}

