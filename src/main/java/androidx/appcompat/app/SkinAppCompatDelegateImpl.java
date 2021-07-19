/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.view.Window
 */
package androidx.appcompat.app;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import androidx.appcompat.app.AppCompatCallback;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.AppCompatDelegateImpl;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public class SkinAppCompatDelegateImpl
extends AppCompatDelegateImpl {
    private static Map sDelegateMap;

    static {
        WeakHashMap weakHashMap;
        sDelegateMap = weakHashMap = new WeakHashMap();
    }

    private SkinAppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback) {
        super(context, window, appCompatCallback);
    }

    public static AppCompatDelegate get(Activity activity, AppCompatCallback object) {
        Object object2 = (WeakReference)sDelegateMap.get(activity);
        object2 = object2 == null ? null : (AppCompatDelegate)((Reference)object2).get();
        if (object2 == null) {
            Object object3 = activity.getWindow();
            object2 = new SkinAppCompatDelegateImpl((Context)activity, (Window)object3, (AppCompatCallback)object);
            object = sDelegateMap;
            object3 = new WeakReference(object2);
            object.put(activity, object3);
        }
        return object2;
    }

    public void installViewFactory() {
    }
}

