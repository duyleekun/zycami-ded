/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Color
 *  android.graphics.Rect
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.View$OnSystemUiVisibilityChangeListener
 *  android.view.Window
 *  android.view.WindowManager$LayoutParams
 *  android.widget.ImageView
 */
package com.zhiyun.common.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.core.graphics.ColorUtils;
import d.v.e.l.b;
import d.v.e.l.c;
import d.v.e.l.d;
import d.v.e.l.e;
import d.v.e.l.f;
import d.v.e.l.g;
import d.v.e.l.h;
import d.v.e.l.h2;
import d.v.e.l.i;
import d.v.e.l.j;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StatusBarUtil {
    private static int a;
    private static int b;

    public static void A(Activity activity, int n10) {
        int n11 = 0;
        int n12 = 1;
        if (n10 == n12) {
            StatusBarUtil.setMIUIStatusBarLightMode(activity, false, n12 != 0);
        } else {
            n12 = 2;
            if (n10 == n12) {
                activity = activity.getWindow();
                StatusBarUtil.u((Window)activity, false);
            } else {
                n11 = 3;
                if (n10 == n11) {
                    activity = activity.getWindow().getDecorView();
                    n10 = 1024;
                    activity.setSystemUiVisibility(n10);
                }
            }
        }
    }

    public static int B(Activity activity) {
        return StatusBarUtil.C(activity, true);
    }

    /*
     * WARNING - void declaration
     */
    public static int C(Activity activity, boolean bl2) {
        StatusBarUtil.I(activity, bl2);
        int n10 = 1;
        int n11 = StatusBarUtil.setMIUIStatusBarLightMode(activity, n10 != 0, bl2);
        if (n11 == 0) {
            Window window = activity.getWindow();
            n10 = StatusBarUtil.u(window, n10 != 0);
            if (n10 != 0) {
                n10 = 2;
            } else {
                n10 = Build.VERSION.SDK_INT;
                n11 = 23;
                if (n10 >= n11) {
                    void var1_4;
                    if (bl2) {
                        int n12 = 9216;
                    } else {
                        int n13 = 8192;
                    }
                    activity = activity.getWindow().getDecorView();
                    activity.setSystemUiVisibility((int)var1_4);
                    n10 = 3;
                } else {
                    n10 = 0;
                }
            }
        }
        return n10;
    }

    public static void D(Activity activity, int n10) {
        int n11 = 1;
        if (n10 == n11) {
            StatusBarUtil.setMIUIStatusBarLightMode(activity, n11 != 0, n11 != 0);
        } else {
            int n12 = 2;
            if (n10 == n12) {
                activity = activity.getWindow();
                StatusBarUtil.u((Window)activity, n11 != 0);
            } else {
                n11 = 3;
                if (n10 == n11) {
                    activity = activity.getWindow().getDecorView();
                    n10 = 9216;
                    activity.setSystemUiVisibility(n10);
                }
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    public static void E(Window window, boolean bl2) {
        void var1_4;
        if (window == null) {
            return;
        }
        window = window.getDecorView();
        int n10 = window.getSystemUiVisibility();
        if (bl2) {
            int n11 = n10 | 0x2000;
        } else {
            int n12 = n10 & 0xFFFFDFFF;
        }
        window.setSystemUiVisibility((int)var1_4);
    }

    public static void F(Window window, ImageView object, Context object2) {
        boolean bl2;
        Object object3;
        int n10;
        Integer n12;
        int n13;
        if (window == null) {
            return;
        }
        object = StatusBarUtil.a(((BitmapDrawable)object.getDrawable()).getBitmap(), (Context)object2);
        object2 = new HashMap();
        object = ((ArrayList)object).iterator();
        while ((n13 = object.hasNext()) != 0) {
            n12 = (Integer)object.next();
            int n11 = ((HashMap)object2).containsKey(n12);
            n10 = 1;
            if (n11 != 0) {
                n11 = (Integer)((HashMap)object2).get(n12) + n10;
                object3 = n11;
                ((HashMap)object2).remove(n12);
                ((HashMap)object2).put(n12, object3);
                continue;
            }
            object3 = n10;
            ((HashMap)object2).put(n12, object3);
        }
        object = ((HashMap)object2).entrySet().iterator();
        int n11 = 0;
        object2 = null;
        n13 = 0;
        n12 = null;
        while (bl2 = object.hasNext()) {
            object3 = (Map.Entry)object.next();
            Integer n14 = (Integer)object3.getValue();
            n10 = n14;
            if (n13 >= n10) continue;
            object2 = (Integer)object3.getKey();
            n11 = (Integer)object2;
            n13 = n10;
        }
        if (n11 == 0) {
            return;
        }
        boolean bl3 = StatusBarUtil.i(n11);
        StatusBarUtil.E(window, bl3);
    }

    public static void G(Window window, boolean bl2) {
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            layoutParams.layoutInDisplayCutoutMode = n10 = 1;
            window.setAttributes(layoutParams);
        }
        int n12 = 5638;
        window.getDecorView().setSystemUiVisibility(n12);
        View view = window.getDecorView();
        d d10 = new d(window, n12);
        view.setOnSystemUiVisibilityChangeListener((View.OnSystemUiVisibilityChangeListener)d10);
        window.clearFlags(0x4000000);
        window.addFlags(-1 << -1);
        window.setStatusBarColor(0);
    }

    public static void H(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(5890);
    }

    private static void I(Activity activity, boolean n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 0x4000000;
        int n13 = 21;
        if (n11 >= n13) {
            View view;
            activity = activity.getWindow();
            activity.clearFlags(n12);
            if (n10 != 0) {
                n10 = 1280;
                n11 = 0;
                view = null;
                activity.setStatusBarColor(0);
            } else {
                n10 = 256;
                n11 = -1;
                activity.setStatusBarColor(n11);
            }
            view = activity.getDecorView();
            view.setSystemUiVisibility(n10);
            n10 = -1 << -1;
            activity.addFlags(n10);
        } else {
            n10 = 19;
            if (n11 >= n10) {
                activity = activity.getWindow();
                activity.setFlags(n12, n12);
            }
        }
    }

    public static ArrayList a(Bitmap object, Context context) {
        int n10 = object.getWidth();
        int n11 = StatusBarUtil.b(context);
        int n12 = n10 * n11;
        int[] nArray = new int[n12];
        int n13 = 0;
        Object object2 = nArray;
        int n14 = n10;
        object.getPixels(nArray, 0, n10, 0, 0, n10, n11);
        object = new ArrayList();
        for (int i10 = 0; i10 < n12; ++i10) {
            int n15 = nArray[i10];
            n13 = (0xFF0000 & n15) >> 16;
            n14 = (0xFF00 & n15) >> 8;
            n15 &= 0xFF;
            if ((n15 = Color.rgb((int)n13, (int)n14, (int)n15)) == (n13 = -1) || n15 == (n13 = -16777216)) continue;
            object2 = n15;
            ((ArrayList)object).add(object2);
        }
        return object;
    }

    public static int b(Context context) {
        int n10;
        String string2;
        String string3;
        String string4;
        Resources resources;
        int n11 = a;
        if (n11 <= 0 && (n11 = (resources = context.getResources()).getIdentifier(string4 = "status_bar_height", string3 = "dimen", string2 = "android")) > 0) {
            context = context.getResources();
            a = n10 = context.getDimensionPixelSize(n11);
        }
        if ((n10 = a) <= 0) {
            float f10 = 25.0f;
            a = n10 = h2.b(f10);
        }
        return a;
    }

    public static int c(Activity activity) {
        int n10 = b;
        if (n10 == 0) {
            int n11;
            Rect rect = new Rect();
            activity = activity.getWindow().getDecorView();
            activity.getWindowVisibleDisplayFrame(rect);
            b = n11 = rect.top;
        }
        return b;
    }

    public static void d(Window window, int n10) {
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 28;
        if (n11 >= n12) {
            layoutParams.layoutInDisplayCutoutMode = n11 = 1;
            window.setAttributes(layoutParams);
        }
        layoutParams = window.getDecorView();
        n11 = 4358;
        layoutParams.setSystemUiVisibility(n11);
        layoutParams.setBackgroundColor(n10);
        window = window.getDecorView();
        h h10 = new h((View)layoutParams, n11);
        window.setOnSystemUiVisibilityChangeListener((View.OnSystemUiVisibilityChangeListener)h10);
    }

    public static void e(Window window) {
        if (window == null) {
            return;
        }
        window.getDecorView().setSystemUiVisibility(6);
    }

    public static void f(Window window, int n10) {
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 28;
        if (n11 >= n12) {
            layoutParams.layoutInDisplayCutoutMode = n11 = 1;
            window.setAttributes(layoutParams);
        }
        window = window.getDecorView();
        int n13 = 4354;
        window.setSystemUiVisibility(n13);
        window.setBackgroundColor(n10);
        i i10 = new i((View)window, n13);
        window.setOnSystemUiVisibilityChangeListener((View.OnSystemUiVisibilityChangeListener)i10);
    }

    public static void g(Window window) {
        if (window == null) {
            return;
        }
        window.getDecorView().setSystemUiVisibility(5894);
    }

    public static int getStatusHeightNew(Context context) {
        int n10 = b;
        if (n10 != 0) {
            return n10;
        }
        n10 = 38;
        Object object = "com.android.internal.R$dimen";
        object = Class.forName((String)object);
        Object object2 = null;
        Object object3 = new Class[]{};
        object3 = ((Class)object).getDeclaredConstructor((Class<?>)object3);
        object2 = new Object[]{};
        object2 = ((Constructor)object3).newInstance(object2);
        object3 = "status_bar_height";
        object = ((Class)object).getField((String)object3);
        object = ((Field)object).get(object2);
        object = object.toString();
        int n11 = Integer.parseInt((String)object);
        context = context.getResources();
        try {
            n10 = context.getDimensionPixelSize(n11);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        b = n10;
        return n10;
    }

    public static void h(Window window, int n10) {
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 28;
        if (n11 >= n12) {
            layoutParams.layoutInDisplayCutoutMode = n11 = 1;
            window.setAttributes(layoutParams);
        }
        window = window.getDecorView();
        int n13 = 4356;
        window.setSystemUiVisibility(n13);
        window.setBackgroundColor(n10);
        f f10 = new f((View)window, n13);
        window.setOnSystemUiVisibilityChangeListener((View.OnSystemUiVisibilityChangeListener)f10);
    }

    public static boolean i(int n10) {
        double d10;
        double d11 = ColorUtils.calculateLuminance(n10);
        double d12 = d11 - (d10 = 0.5);
        n10 = (n10 = (int)(d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1))) >= 0 ? 1 : 0;
        return n10 != 0;
    }

    public static /* synthetic */ void j(View view, int n10, int n11) {
        if ((n11 &= 4) == 0) {
            view.setSystemUiVisibility(n10);
        }
    }

    public static /* synthetic */ void k(View view, int n10, int n11) {
        if ((n11 &= 4) == 0) {
            view.setSystemUiVisibility(n10);
        }
    }

    public static /* synthetic */ void l(View view, int n10, int n11) {
        if ((n11 &= 4) == 0) {
            view.setSystemUiVisibility(n10);
        }
    }

    public static /* synthetic */ void m(View view, int n10, int n11) {
        if ((n11 &= 4) == 0) {
            view.setSystemUiVisibility(n10);
        }
    }

    public static /* synthetic */ void n(View view, int n10, int n11) {
        if ((n11 &= 4) == 0) {
            view.setSystemUiVisibility(n10);
        }
    }

    public static /* synthetic */ void o(Window window, int n10, int n11) {
        if ((n11 &= 4) == 0) {
            window = window.getDecorView();
            window.setSystemUiVisibility(n10);
        }
    }

    public static /* synthetic */ void p(View view, int n10, Window window, ImageView imageView, Context context, int n11) {
        if ((n11 &= 4) == 0) {
            view.setSystemUiVisibility(n10);
            view = null;
            StatusBarUtil.z(window, 0);
            StatusBarUtil.F(window, imageView, context);
        }
    }

    public static /* synthetic */ void q(View view, int n10, Window window, ColorDrawable colorDrawable, View view2, Context context, int n11) {
        if ((n11 &= 4) == 0) {
            view.setSystemUiVisibility(n10);
            view = null;
            StatusBarUtil.z(window, 0);
            n10 = (int)(StatusBarUtil.i(colorDrawable.getColor()) ? 1 : 0);
            StatusBarUtil.E(window, n10 != 0);
            n10 = StatusBarUtil.b(context);
            view2.setPadding(0, n10, 0, 0);
        }
    }

    public static /* synthetic */ void r(Window window, int n10, int n11) {
        if ((n11 &= 4) == 0) {
            window = window.getDecorView();
            window.setSystemUiVisibility(n10);
        }
    }

    public static void s(Window window) {
        if (window == null) {
            return;
        }
        window = window.getDecorView();
        int n10 = 4866;
        window.setSystemUiVisibility(n10);
        j j10 = new j((View)window, n10);
        window.setOnSystemUiVisibilityChangeListener((View.OnSystemUiVisibilityChangeListener)j10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean setMIUIStatusBarLightMode(Activity activity, boolean bl2, boolean bl3) {
        int n10;
        int n11;
        block6: {
            Window window = activity.getWindow();
            n11 = 1;
            n10 = 0;
            if (window == null) return 0 != 0;
            GenericDeclaration genericDeclaration = window.getClass();
            Object object = "android.view.MiuiWindowManager$LayoutParams";
            try {
                Class<Integer> clazz;
                object = Class.forName((String)object);
                Object[] objectArray = "EXTRA_FLAG_STATUS_BAR_DARK_MODE";
                objectArray = ((Class)object).getField((String)objectArray);
                int n12 = objectArray.getInt(object);
                objectArray = "setExtraFlags";
                int n13 = 2;
                Class[] classArray = new Class[n13];
                classArray[0] = clazz = Integer.TYPE;
                classArray[n11] = clazz;
                genericDeclaration = ((Class)genericDeclaration).getMethod((String)objectArray, classArray);
                if (bl2) {
                    objectArray = new Object[n13];
                    Integer n14 = n12;
                    objectArray[0] = n14;
                    objectArray[n11] = object = Integer.valueOf(n12);
                    ((Method)genericDeclaration).invoke(window, objectArray);
                    break block6;
                }
                objectArray = new Object[n13];
                Integer n15 = 0;
                objectArray[0] = n15;
                objectArray[n11] = object = Integer.valueOf(n12);
                ((Method)genericDeclaration).invoke(window, objectArray);
            }
            catch (Exception exception) {}
        }
        try {
            int n16 = Build.VERSION.SDK_INT;
            int n17 = 23;
            if (n16 < n17) return n11 != 0;
            if (bl2) {
                n10 = bl3 ? 9216 : 8192;
            }
            activity = activity.getWindow();
            activity = activity.getDecorView();
            activity.setSystemUiVisibility(n10);
            return n11 != 0;
        }
        catch (Exception exception) {
            return n11 != 0;
        }
        return 0 != 0;
    }

    public static void t(Window window) {
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            layoutParams.layoutInDisplayCutoutMode = n10 = 1;
            window.setAttributes(layoutParams);
        }
        window = window.getDecorView();
        int n12 = 5380;
        window.setSystemUiVisibility(n12);
        c c10 = new c((View)window, n12);
        window.setOnSystemUiVisibilityChangeListener((View.OnSystemUiVisibilityChangeListener)c10);
    }

    public static boolean u(Window window, boolean bl2) {
        return false;
    }

    public static void v(Window window) {
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            layoutParams.layoutInDisplayCutoutMode = n10 = 1;
            window.setAttributes(layoutParams);
        }
        int n12 = 5894;
        window.getDecorView().setSystemUiVisibility(n12);
        View view = window.getDecorView();
        b b10 = new b(window, n12);
        view.setOnSystemUiVisibilityChangeListener((View.OnSystemUiVisibilityChangeListener)b10);
    }

    public static void w(Window window, ImageView imageView, Context context) {
        if (window == null) {
            return;
        }
        View view = window.getDecorView();
        view.setSystemUiVisibility(5890);
        StatusBarUtil.z(window, 0);
        StatusBarUtil.F(window, imageView, context);
        g g10 = new g(view, 5890, window, imageView, context);
        view.setOnSystemUiVisibilityChangeListener((View.OnSystemUiVisibilityChangeListener)g10);
    }

    public static void x(View view, Window window, Context context) {
        Drawable drawable2;
        if (window == null) {
            return;
        }
        View view2 = window.getDecorView();
        view2.setSystemUiVisibility(5890);
        StatusBarUtil.z(window, 0);
        Drawable drawable3 = drawable2 = view.getBackground();
        drawable3 = (ColorDrawable)drawable2;
        int n10 = StatusBarUtil.i(drawable3.getColor());
        StatusBarUtil.E(window, n10 != 0);
        n10 = StatusBarUtil.b(context);
        view.setPadding(0, n10, 0, 0);
        drawable2 = view2;
        e e10 = new e(view2, 5890, window, (ColorDrawable)drawable3, view, context);
        view2.setOnSystemUiVisibilityChangeListener((View.OnSystemUiVisibilityChangeListener)e10);
    }

    public static void y(Window window, int n10) {
        if (window == null) {
            return;
        }
        window.setNavigationBarColor(n10);
    }

    public static void z(Window window, int n10) {
        if (window == null) {
            return;
        }
        window.setStatusBarColor(n10);
    }
}

