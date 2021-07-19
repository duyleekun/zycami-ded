/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.DrawableContainer
 *  android.graphics.drawable.DrawableContainer$DrawableContainerState
 *  android.graphics.drawable.InsetDrawable
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Log
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.graphics.drawable.WrappedDrawable;
import androidx.core.graphics.drawable.WrappedDrawableApi14;
import androidx.core.graphics.drawable.WrappedDrawableApi21;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;

public final class DrawableCompat {
    private static final String TAG = "DrawableCompat";
    private static Method sGetLayoutDirectionMethod;
    private static boolean sGetLayoutDirectionMethodFetched;
    private static Method sSetLayoutDirectionMethod;
    private static boolean sSetLayoutDirectionMethodFetched;

    private DrawableCompat() {
    }

    public static void applyTheme(Drawable drawable2, Resources.Theme theme) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            drawable2.applyTheme(theme);
        }
    }

    public static boolean canApplyTheme(Drawable drawable2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return drawable2.canApplyTheme();
        }
        return false;
    }

    public static void clearColorFilter(Drawable drawable2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            drawable2.clearColorFilter();
        } else {
            n11 = 21;
            if (n10 >= n11) {
                drawable2.clearColorFilter();
                n10 = drawable2 instanceof InsetDrawable;
                if (n10 != 0) {
                    drawable2 = ((InsetDrawable)drawable2).getDrawable();
                    DrawableCompat.clearColorFilter(drawable2);
                } else {
                    n10 = drawable2 instanceof WrappedDrawable;
                    if (n10 != 0) {
                        drawable2 = ((WrappedDrawable)drawable2).getWrappedDrawable();
                        DrawableCompat.clearColorFilter(drawable2);
                    } else {
                        n10 = drawable2 instanceof DrawableContainer;
                        if (n10 != 0 && (drawable2 = (DrawableContainer.DrawableContainerState)((DrawableContainer)drawable2).getConstantState()) != null) {
                            n11 = drawable2.getChildCount();
                            for (n10 = 0; n10 < n11; ++n10) {
                                Drawable drawable3 = drawable2.getChild(n10);
                                if (drawable3 == null) continue;
                                DrawableCompat.clearColorFilter(drawable3);
                            }
                        }
                    }
                }
            } else {
                drawable2.clearColorFilter();
            }
        }
    }

    public static int getAlpha(Drawable drawable2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return drawable2.getAlpha();
        }
        return 0;
    }

    public static ColorFilter getColorFilter(Drawable drawable2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return drawable2.getColorFilter();
        }
        return null;
    }

    public static int getLayoutDirection(Drawable object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            return object.getLayoutDirection();
        }
        n11 = 17;
        if (n10 >= n11) {
            Object object2;
            Object object3;
            n10 = (int)(sGetLayoutDirectionMethodFetched ? 1 : 0);
            String string2 = TAG;
            if (!n10) {
                n10 = 1;
                object3 = Drawable.class;
                String string3 = "getLayoutDirection";
                Class[] classArray = new Class[]{};
                object3 = ((Class)object3).getDeclaredMethod(string3, classArray);
                sGetLayoutDirectionMethod = object3;
                try {
                    ((Method)object3).setAccessible(n10 != 0);
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    string3 = "Failed to retrieve getLayoutDirection() method";
                    Log.i((String)string2, (String)string3, (Throwable)noSuchMethodException);
                }
                sGetLayoutDirectionMethodFetched = n10;
            }
            if ((object2 = sGetLayoutDirectionMethod) != null) {
                object3 = new Object[]{};
                object = ((Method)object2).invoke(object, (Object[])object3);
                object = (Integer)object;
                try {
                    return (Integer)object;
                }
                catch (Exception exception) {
                    object2 = "Failed to invoke getLayoutDirection() via reflection";
                    Log.i((String)string2, (String)object2, (Throwable)exception);
                    Object var0_2 = null;
                    sGetLayoutDirectionMethod = null;
                }
            }
        }
        return 0;
    }

    public static void inflate(Drawable drawable2, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            drawable2.inflate(resources, xmlPullParser, attributeSet, theme);
        } else {
            drawable2.inflate(resources, xmlPullParser, attributeSet);
        }
    }

    public static boolean isAutoMirrored(Drawable drawable2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return drawable2.isAutoMirrored();
        }
        return false;
    }

    public static void jumpToCurrentState(Drawable drawable2) {
        drawable2.jumpToCurrentState();
    }

    public static void setAutoMirrored(Drawable drawable2, boolean bl2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            drawable2.setAutoMirrored(bl2);
        }
    }

    public static void setHotspot(Drawable drawable2, float f10, float f11) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            drawable2.setHotspot(f10, f11);
        }
    }

    public static void setHotspotBounds(Drawable drawable2, int n10, int n11, int n12, int n13) {
        int n14 = Build.VERSION.SDK_INT;
        int n15 = 21;
        if (n14 >= n15) {
            drawable2.setHotspotBounds(n10, n11, n12, n13);
        }
    }

    public static boolean setLayoutDirection(Drawable drawable2, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 23;
        if (n11 >= n12) {
            return drawable2.setLayoutDirection(n10);
        }
        n12 = 17;
        if (n11 >= n12) {
            Object[] objectArray;
            Object object;
            n11 = (int)(sSetLayoutDirectionMethodFetched ? 1 : 0);
            String string2 = TAG;
            boolean bl2 = true;
            if (n11 == 0) {
                object = Drawable.class;
                objectArray = "setLayoutDirection";
                Class[] classArray = new Class[bl2];
                Class<Integer> clazz = Integer.TYPE;
                classArray[0] = clazz;
                object = ((Class)object).getDeclaredMethod((String)objectArray, classArray);
                sSetLayoutDirectionMethod = object;
                try {
                    ((Method)object).setAccessible(bl2);
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    objectArray = "Failed to retrieve setLayoutDirection(int) method";
                    Log.i((String)string2, (String)objectArray, (Throwable)noSuchMethodException);
                }
                sSetLayoutDirectionMethodFetched = bl2;
            }
            if ((object = sSetLayoutDirectionMethod) != null) {
                objectArray = new Object[bl2];
                Object object2 = n10;
                objectArray[0] = object2;
                try {
                    ((Method)object).invoke(drawable2, objectArray);
                    return bl2;
                }
                catch (Exception exception) {
                    object2 = "Failed to invoke setLayoutDirection(int) via reflection";
                    Log.i((String)string2, (String)object2, (Throwable)exception);
                    Object var0_2 = null;
                    sSetLayoutDirectionMethod = null;
                }
            }
        }
        return false;
    }

    public static void setTint(Drawable object, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 21;
        if (n11 >= n12) {
            object.setTint(n10);
        } else {
            n11 = object instanceof TintAwareDrawable;
            if (n11 != 0) {
                object = (TintAwareDrawable)object;
                object.setTint(n10);
            }
        }
    }

    public static void setTintList(Drawable object, ColorStateList colorStateList) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            object.setTintList(colorStateList);
        } else {
            n10 = object instanceof TintAwareDrawable;
            if (n10 != 0) {
                object = (TintAwareDrawable)object;
                object.setTintList(colorStateList);
            }
        }
    }

    public static void setTintMode(Drawable object, PorterDuff.Mode mode) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            object.setTintMode(mode);
        } else {
            n10 = object instanceof TintAwareDrawable;
            if (n10 != 0) {
                object = (TintAwareDrawable)object;
                object.setTintMode(mode);
            }
        }
    }

    public static Drawable unwrap(Drawable drawable2) {
        boolean bl2 = drawable2 instanceof WrappedDrawable;
        if (bl2) {
            drawable2 = ((WrappedDrawable)drawable2).getWrappedDrawable();
        }
        return drawable2;
    }

    public static Drawable wrap(Drawable drawable2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            return drawable2;
        }
        n11 = 21;
        if (n10 >= n11) {
            n10 = drawable2 instanceof TintAwareDrawable;
            if (n10 == 0) {
                WrappedDrawableApi21 wrappedDrawableApi21 = new WrappedDrawableApi21(drawable2);
                return wrappedDrawableApi21;
            }
            return drawable2;
        }
        n10 = drawable2 instanceof TintAwareDrawable;
        if (n10 == 0) {
            WrappedDrawableApi14 wrappedDrawableApi14 = new WrappedDrawableApi14(drawable2);
            return wrappedDrawableApi14;
        }
        return drawable2;
    }
}

