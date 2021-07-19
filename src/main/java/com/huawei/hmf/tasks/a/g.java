/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Fragment
 *  android.app.FragmentManager
 *  android.util.Log
 */
package com.huawei.hmf.tasks.a;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.util.Log;
import d.j.d.a.e;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

public final class g
extends Fragment {
    private static final WeakHashMap b;
    private final List a;

    static {
        WeakHashMap weakHashMap;
        b = weakHashMap = new WeakHashMap();
    }

    public g() {
        ArrayList arrayList;
        this.a = arrayList = new ArrayList();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static g a(Activity object) {
        Object object2;
        Object object4;
        Object object3;
        block8: {
            block9: {
                Object object5;
                block7: {
                    object3 = b;
                    object4 = (WeakReference)((WeakHashMap)object3).get(object);
                    if (object4 != null && (object2 = object4.get()) != null) {
                        return (g)((Object)object4.get());
                    }
                    object4 = object.getFragmentManager();
                    object2 = null;
                    object5 = "com.huawei.hmf.tasks.lifecycle_fragment_tag";
                    try {
                        object5 = object4.findFragmentByTag(object5);
                        object5 = (g)((Object)object5);
                        if (object5 != null) break block7;
                    }
                    catch (ClassCastException classCastException) {
                        object4 = null;
                        break block8;
                    }
                    try {
                        object4 = g.b((FragmentManager)object4);
                        break block9;
                    }
                    catch (ClassCastException classCastException) {
                        object4 = object5;
                        break block8;
                    }
                }
                object4 = object5;
            }
            try {
                object2 = new Object((WeakReference)object4);
                ((WeakHashMap)object3).put(object, object2);
                return object4;
            }
            catch (ClassCastException classCastException) {}
        }
        object2 = "found LifecycleCallbackFragment but the type do not match. ";
        object3 = new StringBuilder((String)object2);
        object = ((Throwable)object).getMessage();
        ((StringBuilder)object3).append((String)object);
        object = ((StringBuilder)object3).toString();
        object3 = "LifecycleCallbackFrg";
        Log.e((String)object3, (String)object);
        return object4;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static g b(FragmentManager fragmentManager) {
        String string2;
        Object object;
        Object object2;
        block4: {
            object2 = null;
            try {
                object = new g();
            }
            catch (Exception exception) {
                // empty catch block
                break block4;
            }
            try {
                fragmentManager = fragmentManager.beginTransaction();
                object2 = "com.huawei.hmf.tasks.lifecycle_fragment_tag";
                fragmentManager = fragmentManager.add((Fragment)object, (String)object2);
                fragmentManager.commitAllowingStateLoss();
                return object;
            }
            catch (Exception exception) {
                object2 = object;
            }
        }
        String string3 = "create fragment failed.";
        object = new StringBuilder(string3);
        string2 = ((Throwable)((Object)string2)).getMessage();
        ((StringBuilder)object).append(string2);
        string2 = ((StringBuilder)object).toString();
        Log.e((String)"LifecycleCallbackFrg", (String)string2);
        return object2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void c(Activity object, e e10) {
        if ((object = g.a((Activity)object)) != null) {
            List list = ((g)object).a;
            synchronized (list) {
                object = ((g)object).a;
                WeakReference<e> weakReference = new WeakReference<e>(e10);
                object.add(weakReference);
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onStop() {
        super.onStop();
        List list = this.a;
        synchronized (list) {
            Object object = this.a;
            object = object.iterator();
            while (true) {
                boolean bl2;
                if (!(bl2 = object.hasNext())) {
                    object = this.a;
                    object.clear();
                    return;
                }
                Object object2 = object.next();
                object2 = (WeakReference)object2;
                object2 = ((Reference)object2).get();
                if ((object2 = (e)object2) == null) continue;
                object2.cancel();
            }
        }
    }
}

