/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 */
package androidx.core.view;

import android.os.Build;
import android.view.View;
import androidx.core.view.ViewCompat;

public abstract class ViewCompat$AccessibilityViewProperty {
    private final int mContentChangeType;
    private final int mFrameworkMinimumSdk;
    private final int mTagKey;
    private final Class mType;

    public ViewCompat$AccessibilityViewProperty(int n10, Class clazz, int n11) {
        this(n10, clazz, 0, n11);
    }

    public ViewCompat$AccessibilityViewProperty(int n10, Class clazz, int n11, int n12) {
        this.mTagKey = n10;
        this.mType = clazz;
        this.mContentChangeType = n11;
        this.mFrameworkMinimumSdk = n12;
    }

    private boolean extrasAvailable() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        n10 = n10 >= n11 ? 1 : 0;
        return n10 != 0;
    }

    private boolean frameworkAvailable() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = this.mFrameworkMinimumSdk;
        n10 = n10 >= n11 ? 1 : 0;
        return n10 != 0;
    }

    public boolean booleanNullToFalseEquals(Boolean bl2, Boolean bl3) {
        boolean bl4;
        boolean bl5;
        boolean bl6 = false;
        if (bl2 == null) {
            bl5 = false;
            bl2 = null;
        } else {
            bl5 = bl2;
        }
        if (bl3 == null) {
            bl4 = false;
            bl3 = null;
        } else {
            bl4 = bl3;
        }
        if (bl5 == bl4) {
            bl6 = true;
        }
        return bl6;
    }

    public abstract Object frameworkGet(View var1);

    public abstract void frameworkSet(View var1, Object var2);

    public Object get(View object) {
        int n10 = this.frameworkAvailable();
        if (n10 != 0) {
            return this.frameworkGet((View)object);
        }
        n10 = this.extrasAvailable();
        if (n10 != 0) {
            n10 = this.mTagKey;
            Class clazz = this.mType;
            if ((n10 = (int)(clazz.isInstance(object = object.getTag(n10)) ? 1 : 0)) != 0) {
                return object;
            }
        }
        return null;
    }

    public void set(View view, Object object) {
        int n10 = this.frameworkAvailable();
        if (n10 != 0) {
            this.frameworkSet(view, object);
        } else {
            Object object2;
            n10 = this.extrasAvailable();
            if (n10 != 0 && (n10 = this.shouldUpdate(object2 = this.get(view), object)) != 0) {
                ViewCompat.getOrCreateAccessibilityDelegateCompat(view);
                n10 = this.mTagKey;
                view.setTag(n10, object);
                int n11 = this.mContentChangeType;
                ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, n11);
            }
        }
    }

    public boolean shouldUpdate(Object object, Object object2) {
        return object2.equals(object) ^ true;
    }
}

