/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Fragment
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Looper
 */
package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.api.internal.zza;
import com.google.android.gms.internal.common.zzi;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public final class zzb
extends Fragment
implements LifecycleFragment {
    private static WeakHashMap zza;
    private Map zzb;
    private int zzc;
    private Bundle zzd;

    static {
        WeakHashMap weakHashMap;
        zza = weakHashMap = new WeakHashMap();
    }

    public zzb() {
        Map map = new ArrayMap();
        map = Collections.synchronizedMap(map);
        this.zzb = map;
        this.zzc = 0;
    }

    public static /* synthetic */ int zza(zzb zzb2) {
        return zzb2.zzc;
    }

    public static zzb zza(Activity activity) {
        Object object;
        boolean bl2;
        Object object2 = "LifecycleFragmentImpl";
        Object object3 = (WeakReference)zza.get(activity);
        if (object3 != null && (object3 = (zzb)((Reference)object3).get()) != null) {
            return object3;
        }
        try {
            object3 = activity.getFragmentManager();
        }
        catch (ClassCastException classCastException) {
            object2 = new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", classCastException);
            throw object2;
        }
        object3 = object3.findFragmentByTag((String)object2);
        object3 = (zzb)object3;
        if (object3 == null || (bl2 = object3.isRemoving())) {
            object3 = new zzb();
            object = activity.getFragmentManager().beginTransaction();
            object2 = object.add((Fragment)object3, (String)object2);
            object2.commitAllowingStateLoss();
        }
        object2 = zza;
        object = new WeakReference(object3);
        ((WeakHashMap)object2).put(activity, object);
        return object3;
    }

    public static /* synthetic */ Bundle zzb(zzb zzb2) {
        return zzb2.zzd;
    }

    public final void addCallback(String string2, LifecycleCallback object) {
        Object object2 = this.zzb;
        int n10 = object2.containsKey(string2);
        if (n10 == 0) {
            object2 = this.zzb;
            object2.put(string2, object);
            n10 = this.zzc;
            if (n10 > 0) {
                Object object3 = Looper.getMainLooper();
                object2 = new zzi((Looper)object3);
                object3 = new zza(this, (LifecycleCallback)object, string2);
                object2.post((Runnable)object3);
            }
            return;
        }
        n10 = String.valueOf(string2).length() + 59;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append("LifecycleCallback with tag ");
        stringBuilder.append(string2);
        stringBuilder.append(" already added to this fragment.");
        string2 = stringBuilder.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public final void dump(String string2, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] stringArray) {
        boolean bl2;
        super.dump(string2, fileDescriptor, printWriter, stringArray);
        Iterator iterator2 = this.zzb.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            LifecycleCallback lifecycleCallback = (LifecycleCallback)iterator2.next();
            lifecycleCallback.dump(string2, fileDescriptor, printWriter, stringArray);
        }
    }

    public final LifecycleCallback getCallbackOrNull(String string2, Class clazz) {
        string2 = this.zzb.get(string2);
        return (LifecycleCallback)clazz.cast(string2);
    }

    public final Activity getLifecycleActivity() {
        return this.getActivity();
    }

    public final boolean isCreated() {
        int n10 = this.zzc;
        return n10 > 0;
    }

    public final boolean isStarted() {
        int n10 = this.zzc;
        int n11 = 2;
        return n10 >= n11;
    }

    public final void onActivityResult(int n10, int n11, Intent intent) {
        boolean bl2;
        super.onActivityResult(n10, n11, intent);
        Iterator iterator2 = this.zzb.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            LifecycleCallback lifecycleCallback = (LifecycleCallback)iterator2.next();
            lifecycleCallback.onActivityResult(n10, n11, intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        boolean bl2;
        int n10;
        super.onCreate(bundle);
        this.zzc = n10 = 1;
        this.zzd = bundle;
        Iterator iterator2 = this.zzb.entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = iterator2.next();
            LifecycleCallback lifecycleCallback = (LifecycleCallback)object.getValue();
            if (bundle != null) {
                object = (String)object.getKey();
                object = bundle.getBundle((String)object);
            } else {
                bl2 = false;
                object = null;
            }
            lifecycleCallback.onCreate((Bundle)object);
        }
    }

    public final void onDestroy() {
        boolean bl2;
        int n10;
        super.onDestroy();
        this.zzc = n10 = 5;
        Iterator iterator2 = this.zzb.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            LifecycleCallback lifecycleCallback = (LifecycleCallback)iterator2.next();
            lifecycleCallback.onDestroy();
        }
    }

    public final void onResume() {
        boolean bl2;
        int n10;
        super.onResume();
        this.zzc = n10 = 3;
        Iterator iterator2 = this.zzb.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            LifecycleCallback lifecycleCallback = (LifecycleCallback)iterator2.next();
            lifecycleCallback.onResume();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        boolean bl2;
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        Iterator iterator2 = this.zzb.entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = iterator2.next();
            Bundle bundle2 = new Bundle();
            LifecycleCallback lifecycleCallback = (LifecycleCallback)object.getValue();
            lifecycleCallback.onSaveInstanceState(bundle2);
            object = (String)object.getKey();
            bundle.putBundle((String)object, bundle2);
        }
    }

    public final void onStart() {
        boolean bl2;
        int n10;
        super.onStart();
        this.zzc = n10 = 2;
        Iterator iterator2 = this.zzb.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            LifecycleCallback lifecycleCallback = (LifecycleCallback)iterator2.next();
            lifecycleCallback.onStart();
        }
    }

    public final void onStop() {
        boolean bl2;
        int n10;
        super.onStop();
        this.zzc = n10 = 4;
        Iterator iterator2 = this.zzb.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            LifecycleCallback lifecycleCallback = (LifecycleCallback)iterator2.next();
            lifecycleCallback.onStop();
        }
    }
}

