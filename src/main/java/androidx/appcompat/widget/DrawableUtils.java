/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Insets
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.DrawableContainer
 *  android.graphics.drawable.DrawableContainer$DrawableContainerState
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.InsetDrawable
 *  android.graphics.drawable.LayerDrawable
 *  android.graphics.drawable.ScaleDrawable
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package androidx.appcompat.widget;

import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import android.util.Log;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.WrappedDrawable;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;

public class DrawableUtils {
    private static final int[] CHECKED_STATE_SET;
    private static final int[] EMPTY_STATE_SET;
    public static final Rect INSETS_NONE;
    private static final String TAG = "DrawableUtils";
    private static final String VECTOR_DRAWABLE_CLAZZ_NAME = "android.graphics.drawable.VectorDrawable";
    private static Class sInsetsClazz;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Rect rect;
        int[] nArray = new int[]{0x10100A0};
        CHECKED_STATE_SET = nArray;
        EMPTY_STATE_SET = new int[0];
        INSETS_NONE = rect = new Rect();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 < n11) return;
        String string2 = "android.graphics.Insets";
        try {
            Class<?> clazz;
            sInsetsClazz = clazz = Class.forName(string2);
            return;
        }
        catch (ClassNotFoundException classNotFoundException) {
            return;
        }
    }

    private DrawableUtils() {
    }

    public static boolean canSafelyMutateDrawable(Drawable drawableArray) {
        boolean bl2;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 15;
        if (n10 < n11 && (bl2 = drawableArray instanceof InsetDrawable)) {
            return false;
        }
        if (n10 < n11 && (n11 = drawableArray instanceof GradientDrawable) != 0) {
            return false;
        }
        n11 = 17;
        if (n10 < n11 && (n10 = drawableArray instanceof LayerDrawable) != 0) {
            return false;
        }
        n10 = drawableArray instanceof DrawableContainer;
        if (n10 != 0) {
            n10 = (drawableArray = drawableArray.getConstantState()) instanceof DrawableContainer.DrawableContainerState;
            if (n10 != 0) {
                for (Drawable drawable2 : ((DrawableContainer.DrawableContainerState)drawableArray).getChildren()) {
                    bl2 = DrawableUtils.canSafelyMutateDrawable(drawable2);
                    if (bl2) continue;
                    return false;
                }
            }
        } else {
            n10 = drawableArray instanceof WrappedDrawable;
            if (n10 != 0) {
                return DrawableUtils.canSafelyMutateDrawable(((WrappedDrawable)drawableArray).getWrappedDrawable());
            }
            n10 = drawableArray instanceof DrawableWrapper;
            if (n10 != 0) {
                return DrawableUtils.canSafelyMutateDrawable(((DrawableWrapper)drawableArray).getWrappedDrawable());
            }
            n10 = drawableArray instanceof ScaleDrawable;
            if (n10 != 0) {
                return DrawableUtils.canSafelyMutateDrawable(((ScaleDrawable)drawableArray).getDrawable());
            }
        }
        return true;
    }

    public static void fixDrawable(Drawable drawable2) {
        String string2;
        String string3;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 == n11 && (n10 = (int)((string3 = VECTOR_DRAWABLE_CLAZZ_NAME).equals(string2 = drawable2.getClass().getName()) ? 1 : 0)) != 0) {
            DrawableUtils.fixVectorDrawableTinting(drawable2);
        }
    }

    private static void fixVectorDrawableTinting(Drawable drawable2) {
        int n10;
        int[] nArray = drawable2.getState();
        if (nArray != null && (n10 = nArray.length) != 0) {
            int[] nArray2 = EMPTY_STATE_SET;
            drawable2.setState(nArray2);
        } else {
            int[] nArray3 = CHECKED_STATE_SET;
            drawable2.setState(nArray3);
        }
        drawable2.setState(nArray);
    }

    /*
     * WARNING - bad return control flow
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Rect getOpticalBounds(Drawable object) {
        int n10;
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 29;
        if (n11 >= n12) {
            int n13;
            object = object.getOpticalInsets();
            Rect rect = new Rect();
            rect.left = n12 = ((Insets)object).left;
            rect.right = n12 = ((Insets)object).right;
            rect.top = n12 = ((Insets)object).top;
            rect.bottom = n13 = ((Insets)object).bottom;
            return rect;
        }
        GenericDeclaration genericDeclaration = sInsetsClazz;
        if (genericDeclaration == null) return INSETS_NONE;
        object = DrawableCompat.unwrap((Drawable)object);
        genericDeclaration = object.getClass();
        Object object2 = "getOpticalInsets";
        Class[] classArray = new Class[]{};
        genericDeclaration = ((Class)genericDeclaration).getMethod((String)object2, classArray);
        object2 = new Object[]{};
        object = ((Method)genericDeclaration).invoke(object, (Object[])object2);
        if (object == null) return INSETS_NONE;
        genericDeclaration = new Rect();
        object2 = sInsetsClazz;
        object2 = ((Class)object2).getFields();
        try {
            n10 = ((Object)object2).length;
        }
        catch (Exception exception) {
            object = TAG;
            genericDeclaration = "Couldn't obtain the optical insets. Ignoring.";
            Log.e((String)object, genericDeclaration);
        }
        for (int i10 = 0; i10 < n10; ++i10) {
            int n14;
            Object object3 = object2[i10];
            String string2 = ((Field)object3).getName();
            int n15 = -1;
            int n16 = string2.hashCode();
            int n17 = 3;
            int n18 = 2;
            int n19 = 1;
            switch (n16) {
                default: {
                    break;
                }
                case 108511772: {
                    String string3 = "right";
                    boolean bl2 = string2.equals(string3);
                    if (!bl2) break;
                    n15 = n18;
                    break;
                }
                case 3317767: {
                    String string3 = "left";
                    boolean bl2 = string2.equals(string3);
                    if (!bl2) break;
                    n15 = 0;
                    break;
                }
                case 115029: {
                    String string3 = "top";
                    boolean bl2 = string2.equals(string3);
                    if (!bl2) break;
                    n15 = n19;
                    break;
                }
                case -1383228885: {
                    String string3 = "bottom";
                    boolean bl2 = string2.equals(string3);
                    if (!bl2) break;
                    n15 = n17;
                }
            }
            if (n15 != 0) {
                if (n15 != n19) {
                    if (n15 != n18) {
                        if (n15 != n17) continue;
                        n14 = ((Field)object3).getInt(object);
                        ((Rect)genericDeclaration).bottom = n14;
                        continue;
                    }
                    n14 = ((Field)object3).getInt(object);
                    ((Rect)genericDeclaration).right = n14;
                    continue;
                }
                n14 = ((Field)object3).getInt(object);
                ((Rect)genericDeclaration).top = n14;
                continue;
            }
            n14 = ((Field)object3).getInt(object);
            ((Rect)genericDeclaration).left = n14;
        }
        return genericDeclaration;
        return INSETS_NONE;
    }

    public static PorterDuff.Mode parseTintMode(int n10, PorterDuff.Mode mode) {
        int n11 = 3;
        if (n10 != n11) {
            n11 = 5;
            if (n10 != n11) {
                n11 = 9;
                if (n10 != n11) {
                    switch (n10) {
                        default: {
                            return mode;
                        }
                        case 16: {
                            return PorterDuff.Mode.ADD;
                        }
                        case 15: {
                            return PorterDuff.Mode.SCREEN;
                        }
                        case 14: 
                    }
                    return PorterDuff.Mode.MULTIPLY;
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }
}

