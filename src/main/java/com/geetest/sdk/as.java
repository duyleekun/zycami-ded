/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.Context
 *  android.graphics.Rect
 *  android.os.Bundle
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup
 */
package com.geetest.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.geetest.sdk.utils.l;
import com.geetest.sdk.views.CoverFrameLayout;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class as
implements Application.ActivityLifecycleCallbacks {
    private List a;
    private final List b;
    private Map c;
    private long d;
    private boolean e;

    public as() {
        Cloneable cloneable;
        this.a = cloneable = new Cloneable();
        this.b = cloneable = new Cloneable();
        this.c = cloneable;
        this.e = true;
    }

    private CoverFrameLayout a(Activity activity, ViewGroup viewGroup) {
        CoverFrameLayout coverFrameLayout = new CoverFrameLayout((Context)activity, viewGroup, this);
        return coverFrameLayout;
    }

    private String a(View view, MotionEvent object) {
        object = new StringBuilder();
        int n10 = view.getId();
        ((StringBuilder)object).append(n10);
        String string2 = ",";
        ((StringBuilder)object).append(string2);
        int n11 = view.getTop();
        ((StringBuilder)object).append(n11);
        String string3 = "/";
        ((StringBuilder)object).append(string3);
        int n12 = view.getRight();
        ((StringBuilder)object).append(n12);
        ((StringBuilder)object).append(string3);
        n12 = view.getBottom();
        ((StringBuilder)object).append(n12);
        ((StringBuilder)object).append(string3);
        n12 = view.getLeft();
        ((StringBuilder)object).append(n12);
        ((StringBuilder)object).append(string2);
        n10 = view.getWidth();
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(string3);
        int n13 = view.getHeight();
        ((StringBuilder)object).append(n13);
        return ((StringBuilder)object).toString();
    }

    private void a(View view) {
        int n10 = this.e;
        if (n10 != 0) {
            List list;
            int n11 = view instanceof ViewGroup;
            if (n11 != 0) {
                view = (ViewGroup)view;
                n10 = view.getChildCount();
                for (n11 = 0; n11 < n10; ++n11) {
                    View view2 = view.getChildAt(n11);
                    this.a(view2);
                }
            } else if (n10 != 0 && (list = this.a) != null) {
                list.add(view);
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private View c(MotionEvent object) {
        Object object2;
        int[] nArray;
        String string2;
        block24: {
            block23: {
                string2 = "GT3MotionEvent";
                int n10 = 2;
                nArray = new int[n10];
                object2 = this.a;
                if (object2 != null) break block23;
                object = "viewArrayList is null";
                l.d(string2, (String)object);
                return null;
            }
            int n11 = object2.size();
            if (n11 != 0) break block24;
            object = "viewArrayList size is 0 !";
            l.d(string2, (String)object);
            return null;
        }
        object2 = this.a;
        try {
            object2 = object2.iterator();
        }
        catch (Exception exception) {
            object = exception.toString();
            l.b(string2, (String)object);
        }
        while (true) {
            boolean bl2 = object2.hasNext();
            if (!bl2) return null;
            Object object3 = object2.next();
            if ((object3 = (View)object3) == null) continue;
            boolean bl3 = object3.isShown();
            if (!bl3) continue;
            object3.getLocationOnScreen(nArray);
            Rect rect = new Rect();
            object3.getGlobalVisibleRect(rect);
            float f10 = object.getX();
            int n12 = (int)f10;
            float f11 = object.getY();
            int n13 = (int)f11;
            bl3 = rect.contains(n12, n13);
            CharSequence charSequence = new StringBuilder();
            String string3 = "contains: ";
            charSequence.append(string3);
            charSequence.append(bl3);
            charSequence = charSequence.toString();
            l.d(string2, (String)charSequence);
            if (bl3) return object3;
            continue;
            break;
        }
        return null;
    }

    public View a(MotionEvent object) {
        boolean bl2;
        View view = this.c((MotionEvent)object);
        Object object2 = view == null ? "view is null" : view.toString();
        CharSequence charSequence = "GT3MotionEvent";
        l.d((String)charSequence, (String)object2);
        if (view != null && (bl2 = this.e)) {
            long l10;
            this.c.clear();
            this.d = l10 = System.currentTimeMillis();
            object2 = this.c;
            charSequence = new StringBuilder();
            double d10 = object.getRawX();
            Object object3 = new BigDecimal(d10);
            int n10 = 4;
            object3 = ((BigDecimal)object3).setScale(0, n10);
            ((StringBuilder)charSequence).append(object3);
            object3 = ",";
            ((StringBuilder)charSequence).append((String)object3);
            float f10 = object.getRawY();
            double d11 = f10;
            BigDecimal bigDecimal = new BigDecimal(d11);
            object = bigDecimal.setScale(0, n10);
            ((StringBuilder)charSequence).append(object);
            ((StringBuilder)charSequence).append((String)object3);
            ((StringBuilder)charSequence).append(0);
            object = ((StringBuilder)charSequence).toString();
            charSequence = "d";
            object2.put(charSequence, object);
        }
        return view;
    }

    public void a() {
        this.b.clear();
        this.e = false;
        List list = this.a;
        if (list != null) {
            list.clear();
        }
    }

    public View b(MotionEvent object) {
        int n10;
        View view = this.c((MotionEvent)object);
        Object object2 = view == null ? "view is null" : view.toString();
        CharSequence charSequence = "GT3MotionEvent";
        l.d((String)charSequence, (String)object2);
        if (view != null && (n10 = this.e) != 0) {
            object2 = this.c;
            charSequence = new StringBuilder();
            double d10 = object.getRawX();
            Object object3 = new BigDecimal(d10);
            int n11 = 4;
            object3 = ((BigDecimal)object3).setScale(0, n11);
            ((StringBuilder)charSequence).append(object3);
            object3 = ",";
            ((StringBuilder)charSequence).append((String)object3);
            float f10 = object.getRawY();
            double d11 = f10;
            BigDecimal bigDecimal = new BigDecimal(d11);
            BigDecimal bigDecimal2 = bigDecimal.setScale(0, n11);
            ((StringBuilder)charSequence).append(bigDecimal2);
            ((StringBuilder)charSequence).append((String)object3);
            long l10 = System.currentTimeMillis();
            long l11 = this.d;
            ((StringBuilder)charSequence).append(l10 -= l11);
            charSequence = ((StringBuilder)charSequence).toString();
            object3 = "u";
            object2.put(object3, charSequence);
            object2 = this.c;
            object = this.a(view, (MotionEvent)object);
            charSequence = "v";
            object2.put(charSequence, object);
            object = this.b;
            object2 = this.c.toString();
            object.add(object2);
            object = this.b;
            int n12 = object.size();
            n10 = 20;
            if (n12 > n10) {
                object = this.b;
                object.remove(0);
            }
        }
        return view;
    }

    public String b() {
        CharSequence charSequence = this.b.toString();
        if (charSequence == null) {
            return null;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("stringList: ");
        String string2 = this.b.toString();
        ((StringBuilder)charSequence).append(string2);
        charSequence = ((StringBuilder)charSequence).toString();
        string2 = "GT3MotionEvent";
        l.d(string2, (String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("stringList.size()-->");
        int n10 = this.b.size();
        ((StringBuilder)charSequence).append(n10);
        charSequence = ((StringBuilder)charSequence).toString();
        l.d(string2, (String)charSequence);
        return this.b.toString();
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("onActivityDestroyed-->");
        String string2 = activity.toString();
        charSequence.append(string2);
        charSequence = charSequence.toString();
        l.b("GT3MotionEvent", (String)charSequence);
        ((Application)activity.getApplicationContext()).unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this);
    }

    public void onActivityPaused(Activity activity) {
        this.e = false;
        List list = this.a;
        if (list != null) {
            list.clear();
        }
        this.b.clear();
        ((Application)activity.getApplicationContext()).unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this);
    }

    public void onActivityResumed(Activity activity) {
        View view;
        this.a = view = new ArrayList();
        view = activity.getWindow().getDecorView();
        List list = this.a;
        if (list != null) {
            list.clear();
        }
        list = this.b;
        list.clear();
        this.a(view);
        int n10 = view instanceof ViewGroup;
        if (n10 != 0 && (n10 = (view = (ViewGroup)view).getChildCount()) != 0 && (n10 = (list = view.getChildAt(0)) instanceof CoverFrameLayout) == 0) {
            this.a(activity, (ViewGroup)view);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}

