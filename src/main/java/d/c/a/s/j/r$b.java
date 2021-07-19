/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Point
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  android.view.WindowManager
 */
package d.c.a.s.j;

import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import d.c.a.s.j.o;
import d.c.a.s.j.r$b$a;
import d.c.a.u.k;
import java.util.ArrayList;
import java.util.List;

public final class r$b {
    private static final int e;
    public static Integer f;
    private final View a;
    private final List b;
    public boolean c;
    private r$b$a d;

    public r$b(View view) {
        ArrayList arrayList;
        this.b = arrayList = new ArrayList();
        this.a = view;
    }

    private static int c(Context object) {
        Integer n10 = f;
        if (n10 == null) {
            object = ((WindowManager)k.d((WindowManager)object.getSystemService("window"))).getDefaultDisplay();
            n10 = new Point();
            object.getSize((Point)n10);
            int n11 = ((Point)n10).x;
            int n12 = ((Point)n10).y;
            n11 = Math.max(n11, n12);
            object = n11;
            f = object;
        }
        return f;
    }

    private int e(int n10, int n11, int n12) {
        View view;
        int n13 = n11 - n12;
        if (n13 > 0) {
            return n13;
        }
        n13 = (int)(this.c ? 1 : 0);
        if (n13 != 0 && (n13 = (int)((view = this.a).isLayoutRequested() ? 1 : 0)) != 0) {
            return 0;
        }
        if ((n10 -= n12) > 0) {
            return n10;
        }
        Object object = this.a;
        n10 = (int)(object.isLayoutRequested() ? 1 : 0);
        if (n10 == 0 && n11 == (n10 = -2)) {
            String string2 = "ViewTarget";
            n10 = (int)(Log.isLoggable((String)string2, (int)4) ? 1 : 0);
            if (n10 != 0) {
                object = "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.";
                Log.i((String)string2, (String)object);
            }
            return r$b.c(this.a.getContext());
        }
        return 0;
    }

    private int f() {
        View view = this.a;
        int n10 = view.getPaddingTop();
        int n11 = this.a.getPaddingBottom();
        n10 += n11;
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        if (layoutParams != null) {
            n11 = layoutParams.height;
        } else {
            n11 = 0;
            layoutParams = null;
        }
        int n12 = this.a.getHeight();
        return this.e(n12, n11, n10);
    }

    private int g() {
        View view = this.a;
        int n10 = view.getPaddingLeft();
        int n11 = this.a.getPaddingRight();
        n10 += n11;
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        if (layoutParams != null) {
            n11 = layoutParams.width;
        } else {
            n11 = 0;
            layoutParams = null;
        }
        int n12 = this.a.getWidth();
        return this.e(n12, n11, n10);
    }

    private boolean h(int n10) {
        int n11;
        n10 = n10 <= 0 && n10 != (n11 = -1 << -1) ? 0 : 1;
        return n10 != 0;
    }

    private boolean i(int n10, int n11) {
        n10 = (n10 = (int)(this.h(n10) ? 1 : 0)) != 0 && (n10 = (int)(this.h(n11) ? 1 : 0)) != 0 ? 1 : 0;
        return n10 != 0;
    }

    private void j(int n10, int n11) {
        boolean bl2;
        Object object = this.b;
        Object object2 = new ArrayList(object);
        object2 = ((ArrayList)object2).iterator();
        while (bl2 = object2.hasNext()) {
            object = (o)object2.next();
            object.d(n10, n11);
        }
    }

    public void a() {
        int n10;
        List list = this.b;
        int n11 = list.isEmpty();
        if (n11 != 0) {
            return;
        }
        n11 = this.g();
        boolean bl2 = this.i(n11, n10 = this.f());
        if (!bl2) {
            return;
        }
        this.j(n11, n10);
        this.b();
    }

    public void b() {
        ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
        boolean bl2 = viewTreeObserver.isAlive();
        if (bl2) {
            r$b$a r$b$a = this.d;
            viewTreeObserver.removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)r$b$a);
        }
        this.d = null;
        this.b.clear();
    }

    public void d(o object) {
        int n10;
        int n11 = this.g();
        boolean bl2 = this.i(n11, n10 = this.f());
        if (bl2) {
            object.d(n11, n10);
            return;
        }
        Object object2 = this.b;
        n11 = (int)(object2.contains(object) ? 1 : 0);
        if (n11 == 0) {
            object2 = this.b;
            object2.add(object);
        }
        if ((object = this.d) == null) {
            object = this.a.getViewTreeObserver();
            this.d = object2 = new r$b$a(this);
            object.addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)object2);
        }
    }

    public void k(o o10) {
        this.b.remove(o10);
    }
}

