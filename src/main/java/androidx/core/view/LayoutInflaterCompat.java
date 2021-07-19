/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.LayoutInflater$Factory
 *  android.view.LayoutInflater$Factory2
 */
package androidx.core.view;

import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import androidx.core.view.LayoutInflaterCompat$Factory2Wrapper;
import androidx.core.view.LayoutInflaterFactory;
import java.lang.reflect.Field;

public final class LayoutInflaterCompat {
    private static final String TAG = "LayoutInflaterCompatHC";
    private static boolean sCheckedField;
    private static Field sLayoutInflaterFactory2Field;

    private LayoutInflaterCompat() {
    }

    private static void forceSetFactory2(LayoutInflater object, LayoutInflater.Factory2 factory2) {
        Object object2;
        Object object3;
        boolean bl2 = sCheckedField;
        String string2 = "; inflation may have unexpected results.";
        String string3 = TAG;
        if (!bl2) {
            bl2 = true;
            object3 = LayoutInflater.class;
            CharSequence charSequence = "mFactory2";
            object3 = ((Class)object3).getDeclaredField((String)charSequence);
            sLayoutInflaterFactory2Field = object3;
            try {
                ((Field)object3).setAccessible(bl2);
            }
            catch (NoSuchFieldException noSuchFieldException) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("forceSetFactory2 Could not find field 'mFactory2' on class ");
                String string4 = LayoutInflater.class.getName();
                ((StringBuilder)charSequence).append(string4);
                ((StringBuilder)charSequence).append(string2);
                charSequence = ((StringBuilder)charSequence).toString();
                Log.e((String)string3, (String)charSequence, (Throwable)noSuchFieldException);
            }
            sCheckedField = bl2;
        }
        if ((object2 = sLayoutInflaterFactory2Field) != null) {
            try {
                ((Field)object2).set(object, factory2);
            }
            catch (IllegalAccessException illegalAccessException) {
                object2 = new StringBuilder();
                object3 = "forceSetFactory2 could not set the Factory2 on LayoutInflater ";
                ((StringBuilder)object2).append((String)object3);
                ((StringBuilder)object2).append(object);
                ((StringBuilder)object2).append(string2);
                object = ((StringBuilder)object2).toString();
                Log.e((String)string3, (String)object, (Throwable)illegalAccessException);
            }
        }
    }

    public static LayoutInflaterFactory getFactory(LayoutInflater layoutInflater) {
        boolean bl2 = (layoutInflater = layoutInflater.getFactory()) instanceof LayoutInflaterCompat$Factory2Wrapper;
        if (bl2) {
            return ((LayoutInflaterCompat$Factory2Wrapper)layoutInflater).mDelegateFactory;
        }
        return null;
    }

    public static void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
        int n10 = Build.VERSION.SDK_INT;
        LayoutInflaterCompat$Factory2Wrapper layoutInflaterCompat$Factory2Wrapper = null;
        int n11 = 21;
        if (n10 >= n11) {
            if (layoutInflaterFactory != null) {
                layoutInflaterCompat$Factory2Wrapper = new LayoutInflaterCompat$Factory2Wrapper(layoutInflaterFactory);
            }
            layoutInflater.setFactory2((LayoutInflater.Factory2)layoutInflaterCompat$Factory2Wrapper);
        } else {
            if (layoutInflaterFactory != null) {
                layoutInflaterCompat$Factory2Wrapper = new LayoutInflaterCompat$Factory2Wrapper(layoutInflaterFactory);
            }
            layoutInflater.setFactory2((LayoutInflater.Factory2)layoutInflaterCompat$Factory2Wrapper);
            layoutInflaterFactory = layoutInflater.getFactory();
            n10 = layoutInflaterFactory instanceof LayoutInflater.Factory2;
            if (n10 != 0) {
                layoutInflaterFactory = (LayoutInflater.Factory2)layoutInflaterFactory;
                LayoutInflaterCompat.forceSetFactory2(layoutInflater, (LayoutInflater.Factory2)layoutInflaterFactory);
            } else {
                LayoutInflaterCompat.forceSetFactory2(layoutInflater, layoutInflaterCompat$Factory2Wrapper);
            }
        }
    }

    public static void setFactory2(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 < n11) {
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            n11 = factory instanceof LayoutInflater.Factory2;
            if (n11 != 0) {
                factory = (LayoutInflater.Factory2)factory;
                LayoutInflaterCompat.forceSetFactory2(layoutInflater, (LayoutInflater.Factory2)factory);
            } else {
                LayoutInflaterCompat.forceSetFactory2(layoutInflater, factory2);
            }
        }
    }
}

