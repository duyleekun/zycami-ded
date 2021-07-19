/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.View
 *  android.view.WindowInsets
 */
package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import androidx.core.graphics.Insets;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsCompat$Builder;
import androidx.core.view.WindowInsetsCompat$Impl;
import androidx.core.view.WindowInsetsCompat$Type;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

public class WindowInsetsCompat$Impl20
extends WindowInsetsCompat$Impl {
    private static Class sAttachInfoClass;
    private static Field sAttachInfoField;
    private static Method sGetViewRootImplMethod;
    private static Class sViewRootImplClass;
    private static Field sVisibleInsetsField;
    private static boolean sVisibleRectReflectionFetched = false;
    private Insets[] mOverriddenInsets;
    public final WindowInsets mPlatformInsets;
    public Insets mRootViewVisibleInsets;
    private WindowInsetsCompat mRootWindowInsets;
    private Insets mSystemWindowInsets;

    public WindowInsetsCompat$Impl20(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
        super(windowInsetsCompat);
        this.mSystemWindowInsets = null;
        this.mPlatformInsets = windowInsets;
    }

    public WindowInsetsCompat$Impl20(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat$Impl20 windowInsetsCompat$Impl20) {
        windowInsetsCompat$Impl20 = windowInsetsCompat$Impl20.mPlatformInsets;
        WindowInsets windowInsets = new WindowInsets((WindowInsets)windowInsetsCompat$Impl20);
        this(windowInsetsCompat, windowInsets);
    }

    private Insets getInsets(int n10, boolean bl2) {
        int n11;
        Insets insets = Insets.NONE;
        for (int i10 = 1; i10 <= (n11 = 256); i10 <<= 1) {
            n11 = n10 & i10;
            if (n11 == 0) continue;
            Insets insets2 = this.getInsetsForType(i10, bl2);
            insets = Insets.max(insets, insets2);
        }
        return insets;
    }

    private Insets getRootStableInsets() {
        WindowInsetsCompat windowInsetsCompat = this.mRootWindowInsets;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat.getStableInsets();
        }
        return Insets.NONE;
    }

    private Insets getVisibleInsets(View object) {
        String string2 = "WindowInsetsCompat";
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 30;
        if (n10 < n11) {
            Object object2;
            n10 = (int)(sVisibleRectReflectionFetched ? 1 : 0);
            if (n10 == 0) {
                WindowInsetsCompat$Impl20.loadReflectionField();
            }
            Object object3 = sGetViewRootImplMethod;
            n11 = 0;
            Insets insets = null;
            if (object3 != null && (object2 = sAttachInfoClass) != null && (object2 = sVisibleInsetsField) != null) {
                block16: {
                    block15: {
                        object2 = null;
                        object2 = new Object[]{};
                        object = ((Method)object3).invoke(object, object2);
                        if (object != null) break block15;
                        object = "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden";
                        object3 = new NullPointerException();
                        Log.w((String)string2, (String)object, (Throwable)object3);
                        return null;
                    }
                    object3 = sAttachInfoField;
                    object = ((Field)object3).get(object);
                    object3 = sVisibleInsetsField;
                    object = ((Field)object3).get(object);
                    object = (Rect)object;
                    if (object == null) break block16;
                    try {
                        insets = Insets.of((Rect)object);
                    }
                    catch (ReflectiveOperationException reflectiveOperationException) {
                        object3 = new StringBuilder();
                        ((StringBuilder)object3).append("Failed to get visible insets. (Reflection error). ");
                        object2 = reflectiveOperationException.getMessage();
                        ((StringBuilder)object3).append((String)object2);
                        object3 = ((StringBuilder)object3).toString();
                        Log.e((String)string2, (String)object3, (Throwable)reflectiveOperationException);
                    }
                }
                return insets;
            }
            return null;
        }
        object = new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        throw object;
    }

    private static void loadReflectionField() {
        boolean bl2 = true;
        AnnotatedElement annotatedElement = View.class;
        CharSequence charSequence = "getViewRootImpl";
        Object object = null;
        object = new Class[]{};
        annotatedElement = ((Class)annotatedElement).getDeclaredMethod((String)charSequence, (Class<?>)object);
        sGetViewRootImplMethod = annotatedElement;
        annotatedElement = "android.view.ViewRootImpl";
        annotatedElement = Class.forName((String)((Object)annotatedElement));
        sViewRootImplClass = annotatedElement;
        annotatedElement = "android.view.View$AttachInfo";
        annotatedElement = Class.forName((String)((Object)annotatedElement));
        sAttachInfoClass = annotatedElement;
        charSequence = "mVisibleInsets";
        annotatedElement = ((Class)annotatedElement).getDeclaredField((String)charSequence);
        sVisibleInsetsField = annotatedElement;
        annotatedElement = sViewRootImplClass;
        charSequence = "mAttachInfo";
        annotatedElement = ((Class)annotatedElement).getDeclaredField((String)charSequence);
        sAttachInfoField = annotatedElement;
        annotatedElement = sVisibleInsetsField;
        ((Field)annotatedElement).setAccessible(bl2);
        annotatedElement = sAttachInfoField;
        try {
            ((Field)annotatedElement).setAccessible(bl2);
        }
        catch (ReflectiveOperationException reflectiveOperationException) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("Failed to get visible insets. (Reflection error). ");
            object = reflectiveOperationException.getMessage();
            ((StringBuilder)charSequence).append((String)object);
            charSequence = ((StringBuilder)charSequence).toString();
            object = "WindowInsetsCompat";
            Log.e((String)object, (String)charSequence, (Throwable)reflectiveOperationException);
        }
        sVisibleRectReflectionFetched = bl2;
    }

    public void copyRootViewBounds(View object) {
        if ((object = this.getVisibleInsets((View)object)) == null) {
            object = Insets.NONE;
        }
        this.setRootViewData((Insets)object);
    }

    public void copyWindowDataInto(WindowInsetsCompat windowInsetsCompat) {
        Object object = this.mRootWindowInsets;
        windowInsetsCompat.setRootWindowInsets((WindowInsetsCompat)object);
        object = this.mRootViewVisibleInsets;
        windowInsetsCompat.setRootViewData((Insets)object);
    }

    public boolean equals(Object object) {
        boolean bl2 = super.equals(object);
        if (!bl2) {
            return false;
        }
        object = (WindowInsetsCompat$Impl20)object;
        Insets insets = this.mRootViewVisibleInsets;
        object = ((WindowInsetsCompat$Impl20)object).mRootViewVisibleInsets;
        return Objects.equals(insets, object);
    }

    public Insets getInsets(int n10) {
        return this.getInsets(n10, false);
    }

    public Insets getInsetsForType(int n10, boolean n11) {
        int n12 = 1;
        int n13 = 0;
        if (n10 != n12) {
            n12 = 2;
            int n14 = 0;
            Insets insets = null;
            if (n10 != n12) {
                Insets insets2;
                n11 = 8;
                if (n10 != n11) {
                    n11 = 16;
                    if (n10 != n11) {
                        n11 = 32;
                        if (n10 != n11) {
                            n11 = 64;
                            if (n10 != n11) {
                                n11 = 128;
                                if (n10 != n11) {
                                    return Insets.NONE;
                                }
                                Object object = this.mRootWindowInsets;
                                object = object != null ? ((WindowInsetsCompat)object).getDisplayCutout() : this.getDisplayCutout();
                                if (object != null) {
                                    n11 = ((DisplayCutoutCompat)object).getSafeInsetLeft();
                                    n12 = ((DisplayCutoutCompat)object).getSafeInsetTop();
                                    n13 = ((DisplayCutoutCompat)object).getSafeInsetRight();
                                    n10 = ((DisplayCutoutCompat)object).getSafeInsetBottom();
                                    return Insets.of(n11, n12, n13, n10);
                                }
                                return Insets.NONE;
                            }
                            return this.getTappableElementInsets();
                        }
                        return this.getMandatorySystemGestureInsets();
                    }
                    return this.getSystemGestureInsets();
                }
                Object object = this.mOverriddenInsets;
                if (object != null) {
                    n11 = WindowInsetsCompat$Type.indexOf(n11);
                    insets = object[n11];
                }
                if (insets != null) {
                    return insets;
                }
                object = this.getSystemWindowInsets();
                Insets insets3 = this.getRootStableInsets();
                n10 = ((Insets)object).bottom;
                n12 = insets3.bottom;
                if (n10 > n12) {
                    return Insets.of(0, 0, 0, n10);
                }
                object = this.mRootViewVisibleInsets;
                if (object != null && (n10 = (int)(((Insets)object).equals(insets2 = Insets.NONE) ? 1 : 0)) == 0) {
                    object = this.mRootViewVisibleInsets;
                    n10 = ((Insets)object).bottom;
                    n11 = insets3.bottom;
                    if (n10 > n11) {
                        return Insets.of(0, 0, 0, n10);
                    }
                }
                return Insets.NONE;
            }
            if (n11 != 0) {
                Insets insets4 = this.getRootStableInsets();
                Insets insets5 = this.getStableInsets();
                n12 = insets4.left;
                n14 = insets5.left;
                n12 = Math.max(n12, n14);
                n14 = insets4.right;
                int n15 = insets5.right;
                n14 = Math.max(n14, n15);
                n10 = insets4.bottom;
                n11 = insets5.bottom;
                n10 = Math.max(n10, n11);
                return Insets.of(n12, 0, n14, n10);
            }
            Insets insets6 = this.getSystemWindowInsets();
            WindowInsetsCompat windowInsetsCompat = this.mRootWindowInsets;
            if (windowInsetsCompat != null) {
                insets = windowInsetsCompat.getStableInsets();
            }
            n11 = insets6.bottom;
            if (insets != null) {
                n12 = insets.bottom;
                n11 = Math.min(n11, n12);
            }
            n12 = insets6.left;
            n10 = insets6.right;
            return Insets.of(n12, 0, n10, n11);
        }
        if (n11 != 0) {
            n10 = this.getRootStableInsets().top;
            n11 = this.getSystemWindowInsets().top;
            n10 = Math.max(n10, n11);
            return Insets.of(0, n10, 0, 0);
        }
        n10 = this.getSystemWindowInsets().top;
        return Insets.of(0, n10, 0, 0);
    }

    public Insets getInsetsIgnoringVisibility(int n10) {
        return this.getInsets(n10, true);
    }

    public final Insets getSystemWindowInsets() {
        Insets insets = this.mSystemWindowInsets;
        if (insets == null) {
            int n10 = this.mPlatformInsets.getSystemWindowInsetLeft();
            WindowInsets windowInsets = this.mPlatformInsets;
            int n11 = windowInsets.getSystemWindowInsetTop();
            WindowInsets windowInsets2 = this.mPlatformInsets;
            int n12 = windowInsets2.getSystemWindowInsetRight();
            WindowInsets windowInsets3 = this.mPlatformInsets;
            int n13 = windowInsets3.getSystemWindowInsetBottom();
            this.mSystemWindowInsets = insets = Insets.of(n10, n11, n12, n13);
        }
        return this.mSystemWindowInsets;
    }

    public WindowInsetsCompat inset(int n10, int n11, int n12, int n13) {
        Object object = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets);
        WindowInsetsCompat$Builder windowInsetsCompat$Builder = new WindowInsetsCompat$Builder((WindowInsetsCompat)object);
        object = WindowInsetsCompat.insetInsets(this.getSystemWindowInsets(), n10, n11, n12, n13);
        windowInsetsCompat$Builder.setSystemWindowInsets((Insets)object);
        Insets insets = WindowInsetsCompat.insetInsets(this.getStableInsets(), n10, n11, n12, n13);
        windowInsetsCompat$Builder.setStableInsets(insets);
        return windowInsetsCompat$Builder.build();
    }

    public boolean isRound() {
        return this.mPlatformInsets.isRound();
    }

    public boolean isTypeVisible(int n10) {
        int n11;
        Insets insets = null;
        int n12 = 1;
        if (n10 != n12 && n10 != (n11 = 2)) {
            n11 = 4;
            if (n10 != n11) {
                n11 = 8;
                if (n10 != n11 && n10 != (n11 = 128)) {
                    return n12 != 0;
                }
            } else {
                return false;
            }
        }
        Insets insets2 = this.getInsetsForType(n10, false);
        insets = Insets.NONE;
        return (insets2.equals(insets) ^ n12) != 0;
    }

    public boolean isVisible(int n10) {
        int n11;
        int n12;
        for (int i10 = n11 = 1; i10 <= (n12 = 256); i10 <<= 1) {
            n12 = n10 & i10;
            if (n12 == 0 || (n12 = (int)(this.isTypeVisible(i10) ? 1 : 0)) != 0) continue;
            return false;
        }
        return n11 != 0;
    }

    public void setOverriddenInsets(Insets[] insetsArray) {
        this.mOverriddenInsets = insetsArray;
    }

    public void setRootViewData(Insets insets) {
        this.mRootViewVisibleInsets = insets;
    }

    public void setRootWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        this.mRootWindowInsets = windowInsetsCompat;
    }
}

