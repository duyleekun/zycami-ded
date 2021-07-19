/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.IBinder
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.view.inputmethod.InputMethodManager
 *  android.widget.EditText
 */
package d.v.e.l;

import android.app.Activity;
import android.content.Context;
import android.os.IBinder;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.lifecycle.LifecycleOwner;
import d.v.e.l.a;
import d.v.e.l.m2;
import d.v.e.l.v1$a;
import d.v.e.l.v1$b;

public class v1 {
    public static final String a = "v1";
    private static boolean b = false;

    public static /* synthetic */ boolean a() {
        return b;
    }

    public static /* synthetic */ boolean b(boolean bl2) {
        b = bl2;
        return bl2;
    }

    public static void c(Activity activity, v1$b v1$b) {
        Object object = activity.toString();
        Object[] objectArray = new Object[]{object, object = v1$b.toString()};
        m.a.a.b("addOnSoftKeyBoardVisibleListener, activity : %s, listener : %s", objectArray);
        activity = activity.getWindow().getDecorView();
        b = false;
        objectArray = activity.getViewTreeObserver();
        object = new v1$a((View)activity, v1$b);
        objectArray.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)object);
    }

    public static void d(Context context, View view) {
        if (context != null && view != null) {
            context = (InputMethodManager)context.getSystemService("input_method");
            view = view.getWindowToken();
            context.hideSoftInputFromWindow((IBinder)view, 0);
        }
    }

    public static boolean e(Context context) {
        if (context != null) {
            return ((InputMethodManager)context.getSystemService("input_method")).isActive();
        }
        return false;
    }

    private static boolean f(View view, MotionEvent motionEvent, boolean bl2) {
        int n10 = view instanceof EditText;
        if (n10 != 0) {
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            float f16;
            float f17;
            n10 = 2;
            int[] nArray = new int[n10];
            nArray[0] = 0;
            nArray[1] = 0;
            view.getLocationInWindow(nArray);
            int n11 = nArray[0];
            int n12 = 1;
            int n13 = nArray[n12];
            int n14 = view.getHeight() + n13;
            int n15 = view.getWidth() + n11;
            if (bl2) {
                n11 = nArray[0];
                int n16 = nArray[n12];
                n13 = view.getWidth();
                n13 = n16 - n13;
                n14 = nArray[n12];
                f17 = view.getHeight();
                n15 = n11 + f17;
            }
            if ((f17 = (f16 = (f15 = motionEvent.getRawX()) - (f14 = (float)n11)) == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1)) > 0 && (f17 = (f13 = (f15 = motionEvent.getRawX()) - (f14 = (float)n15)) == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1)) < 0 && (f17 = (f12 = (f15 = motionEvent.getRawY()) - (f14 = (float)n13)) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1)) > 0 && (f17 = (f11 = (f15 = motionEvent.getRawY()) - (f10 = (float)n14)) == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1)) < 0) {
                return false;
            }
            return n12 != 0;
        }
        return false;
    }

    public static /* synthetic */ void g(Activity activity, View view) {
        boolean bl2;
        boolean bl3;
        if ((activity = activity.getCurrentFocus()) != null && !(bl3 = view.equals(activity)) && (bl2 = activity instanceof EditText)) {
            return;
        }
        v1.d(view.getContext(), view);
    }

    public static void h(Context context, View view) {
        if (context != null) {
            String string2 = "input_method";
            context = (InputMethodManager)context.getSystemService(string2);
            int n10 = 2;
            context.showSoftInput(view, n10);
        }
    }

    public static void i(Context context) {
        if (context != null) {
            context = (InputMethodManager)context.getSystemService("input_method");
            int n10 = 2;
            context.toggleSoftInput(0, n10);
        }
    }

    public static void j(Activity activity, MotionEvent motionEvent, boolean bl2) {
        View view;
        boolean bl3;
        int n10 = motionEvent.getAction();
        if (n10 == 0 && (bl3 = v1.f(view = activity.getCurrentFocus(), motionEvent, bl2)) && (bl3 = activity instanceof LifecycleOwner)) {
            long l10 = 100;
            Object object = activity;
            object = (LifecycleOwner)activity;
            a a10 = new a(activity, view);
            m2.X(l10, (LifecycleOwner)object, a10);
        }
    }
}

