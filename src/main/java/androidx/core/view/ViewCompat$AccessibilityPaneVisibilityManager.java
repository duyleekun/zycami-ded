/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 */
package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;
import java.util.Iterator;
import java.util.WeakHashMap;

public class ViewCompat$AccessibilityPaneVisibilityManager
implements ViewTreeObserver.OnGlobalLayoutListener,
View.OnAttachStateChangeListener {
    private WeakHashMap mPanesToVisible;

    public ViewCompat$AccessibilityPaneVisibilityManager() {
        WeakHashMap weakHashMap;
        this.mPanesToVisible = weakHashMap = new WeakHashMap();
    }

    private void checkPaneVisibility(View view, boolean n10) {
        Boolean bl2;
        int n11 = view.getVisibility();
        if (!n11) {
            n11 = 1;
        } else {
            n11 = 0;
            bl2 = null;
        }
        if (n10 != n11) {
            n10 = n11 != 0 ? 16 : 32;
            ViewCompat.notifyViewAccessibilityStateChangedIfNeeded(view, n10);
            WeakHashMap weakHashMap = this.mPanesToVisible;
            bl2 = n11 != 0;
            weakHashMap.put(view, bl2);
        }
    }

    private void registerForLayoutCallback(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
    }

    private void unregisterForLayoutCallback(View view) {
        view.getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
    }

    public void addAccessibilityPane(View view) {
        Boolean bl2;
        WeakHashMap weakHashMap = this.mPanesToVisible;
        int n10 = view.getVisibility();
        if (!n10) {
            n10 = 1;
        } else {
            n10 = 0;
            bl2 = null;
        }
        bl2 = n10 != 0;
        weakHashMap.put(view, bl2);
        view.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
        boolean bl3 = view.isAttachedToWindow();
        if (bl3) {
            this.registerForLayoutCallback(view);
        }
    }

    public void onGlobalLayout() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 < n11) {
            Iterator iterator2 = this.mPanesToVisible.entrySet().iterator();
            while (n11 = (int)(iterator2.hasNext() ? 1 : 0)) {
                Object object = iterator2.next();
                View view = (View)object.getKey();
                object = (Boolean)object.getValue();
                n11 = (int)(((Boolean)object).booleanValue() ? 1 : 0);
                this.checkPaneVisibility(view, n11 != 0);
            }
        }
    }

    public void onViewAttachedToWindow(View view) {
        this.registerForLayoutCallback(view);
    }

    public void onViewDetachedFromWindow(View view) {
    }

    public void removeAccessibilityPane(View view) {
        this.mPanesToVisible.remove(view);
        view.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
        this.unregisterForLayoutCallback(view);
    }
}

