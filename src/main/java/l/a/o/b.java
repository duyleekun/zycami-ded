/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 */
package l.a.o;

import android.graphics.drawable.Drawable;
import java.lang.reflect.Method;
import l.a.o.f;

public final class b {
    private static final String a = "SkinCompatUtils";
    private static Class b;
    private static Method c;
    private static Method d;
    private static Class e;
    private static Method f;
    private static Method g;
    private static Class h;
    private static Method i;
    private static Method j;

    static {
        block11: {
            boolean bl2;
            Object object;
            String string2;
            block10: {
                block9: {
                    string2 = a;
                    object = "androidx.core.graphics.drawable.WrappedDrawable";
                    object = Class.forName((String)object);
                    try {
                        e = object;
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        bl2 = l.a.o.f.a;
                        if (!bl2) break block9;
                        object = "hasV4WrappedDrawable = false";
                        l.a.o.f.b(string2, (String)object);
                    }
                }
                object = "androidx.core.graphics.drawable.DrawableWrapper";
                object = Class.forName((String)object);
                try {
                    b = object;
                }
                catch (ClassNotFoundException classNotFoundException) {
                    bl2 = l.a.o.f.a;
                    if (!bl2) break block10;
                    object = "hasV4DrawableWrapper = false";
                    l.a.o.f.b(string2, (String)object);
                }
            }
            object = "androidx.appcompat.graphics.drawable.DrawableWrapper";
            object = Class.forName((String)object);
            try {
                h = object;
            }
            catch (ClassNotFoundException classNotFoundException) {
                bl2 = l.a.o.f.a;
                if (!bl2) break block11;
                object = "hasV7DrawableWrapper = false";
                l.a.o.f.b(string2, (String)object);
            }
        }
    }

    public static Drawable a(Drawable drawable2) {
        block13: {
            Object object = b;
            if (object != null) {
                boolean bl2;
                String string2;
                String string3;
                Object object2;
                block12: {
                    object2 = c;
                    string3 = a;
                    string2 = null;
                    if (object2 == null) {
                        object2 = "getWrappedDrawable";
                        Class[] classArray = new Class[]{};
                        object = ((Class)object).getDeclaredMethod((String)object2, classArray);
                        c = object;
                        bl2 = true;
                        try {
                            ((Method)object).setAccessible(bl2);
                        }
                        catch (Exception exception) {
                            boolean bl3 = l.a.o.f.a;
                            if (!bl3) break block12;
                            object = "getV4DrawableWrapperWrappedDrawable No Such Method";
                            l.a.o.f.b(string3, (String)object);
                        }
                    }
                }
                if ((object = c) != null) {
                    object2 = new Object[]{};
                    object = ((Method)object).invoke(drawable2, (Object[])object2);
                    try {
                        return (Drawable)object;
                    }
                    catch (Exception exception) {
                        bl2 = l.a.o.f.a;
                        if (!bl2) break block13;
                        object2 = new StringBuilder();
                        string2 = "getV4DrawableWrapperWrappedDrawable invoke error: ";
                        ((StringBuilder)object2).append(string2);
                        ((StringBuilder)object2).append(exception);
                        String string4 = ((StringBuilder)object2).toString();
                        l.a.o.f.b(string3, string4);
                    }
                }
            }
        }
        return drawable2;
    }

    public static Drawable b(Drawable drawable2) {
        block13: {
            Object object = e;
            if (object != null) {
                boolean bl2;
                String string2;
                String string3;
                Object object2;
                block12: {
                    object2 = f;
                    string3 = a;
                    string2 = null;
                    if (object2 == null) {
                        object2 = "getWrappedDrawable";
                        Class[] classArray = new Class[]{};
                        object = ((Class)object).getDeclaredMethod((String)object2, classArray);
                        f = object;
                        bl2 = true;
                        try {
                            ((Method)object).setAccessible(bl2);
                        }
                        catch (Exception exception) {
                            boolean bl3 = l.a.o.f.a;
                            if (!bl3) break block12;
                            object = "getV4WrappedDrawableWrappedDrawable No Such Method";
                            l.a.o.f.b(string3, (String)object);
                        }
                    }
                }
                if ((object = f) != null) {
                    object2 = new Object[]{};
                    object = ((Method)object).invoke(drawable2, (Object[])object2);
                    try {
                        return (Drawable)object;
                    }
                    catch (Exception exception) {
                        bl2 = l.a.o.f.a;
                        if (!bl2) break block13;
                        object2 = new StringBuilder();
                        string2 = "getV4WrappedDrawableWrappedDrawable invoke error: ";
                        ((StringBuilder)object2).append(string2);
                        ((StringBuilder)object2).append(exception);
                        String string4 = ((StringBuilder)object2).toString();
                        l.a.o.f.b(string3, string4);
                    }
                }
            }
        }
        return drawable2;
    }

    public static Drawable c(Drawable drawable2) {
        block13: {
            Object object = h;
            if (object != null) {
                boolean bl2;
                String string2;
                String string3;
                Object object2;
                block12: {
                    object2 = i;
                    string3 = a;
                    string2 = null;
                    if (object2 == null) {
                        object2 = "getWrappedDrawable";
                        Class[] classArray = new Class[]{};
                        object = ((Class)object).getDeclaredMethod((String)object2, classArray);
                        i = object;
                        bl2 = true;
                        try {
                            ((Method)object).setAccessible(bl2);
                        }
                        catch (Exception exception) {
                            boolean bl3 = l.a.o.f.a;
                            if (!bl3) break block12;
                            object = "getV7DrawableWrapperWrappedDrawable No Such Method";
                            l.a.o.f.b(string3, (String)object);
                        }
                    }
                }
                if ((object = i) != null) {
                    object2 = new Object[]{};
                    object = ((Method)object).invoke(drawable2, (Object[])object2);
                    try {
                        return (Drawable)object;
                    }
                    catch (Exception exception) {
                        bl2 = l.a.o.f.a;
                        if (!bl2) break block13;
                        object2 = new StringBuilder();
                        string2 = "getV7DrawableWrapperWrappedDrawable invoke error: ";
                        ((StringBuilder)object2).append(string2);
                        ((StringBuilder)object2).append(exception);
                        String string4 = ((StringBuilder)object2).toString();
                        l.a.o.f.b(string3, string4);
                    }
                }
            }
        }
        return drawable2;
    }

    public static boolean d() {
        boolean bl2;
        Class clazz = b;
        if (clazz != null) {
            bl2 = true;
        } else {
            bl2 = false;
            clazz = null;
        }
        return bl2;
    }

    public static boolean e() {
        boolean bl2;
        Class clazz = e;
        if (clazz != null) {
            bl2 = true;
        } else {
            bl2 = false;
            clazz = null;
        }
        return bl2;
    }

    public static boolean f() {
        boolean bl2;
        Class clazz = h;
        if (clazz != null) {
            bl2 = true;
        } else {
            bl2 = false;
            clazz = null;
        }
        return bl2;
    }

    public static boolean g(Drawable object) {
        boolean bl2;
        Class clazz = b;
        if (clazz != null && (bl2 = clazz.isAssignableFrom((Class<?>)(object = object.getClass())))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static boolean h(Drawable object) {
        boolean bl2;
        Class clazz = e;
        if (clazz != null && (bl2 = clazz.isAssignableFrom((Class<?>)(object = object.getClass())))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static boolean i(Drawable object) {
        boolean bl2;
        Class clazz = h;
        if (clazz != null && (bl2 = clazz.isAssignableFrom((Class<?>)(object = object.getClass())))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static void j(Drawable drawable2, Drawable object) {
        block14: {
            Object object2 = b;
            if (object2 != null) {
                boolean bl2;
                String string2;
                Object[] objectArray;
                block13: {
                    objectArray = d;
                    string2 = a;
                    bl2 = true;
                    if (objectArray == null) {
                        objectArray = "setWrappedDrawable";
                        Class[] classArray = new Class[bl2];
                        Class<Drawable> clazz = Drawable.class;
                        classArray[0] = clazz;
                        object2 = ((Class)object2).getDeclaredMethod((String)objectArray, classArray);
                        d = object2;
                        try {
                            ((Method)object2).setAccessible(bl2);
                        }
                        catch (Exception exception) {
                            boolean bl3 = l.a.o.f.a;
                            if (!bl3) break block13;
                            object2 = "setV4DrawableWrapperWrappedDrawable No Such Method";
                            l.a.o.f.b(string2, (String)object2);
                        }
                    }
                }
                if ((object2 = d) != null) {
                    objectArray = new Object[bl2];
                    objectArray[0] = object;
                    try {
                        ((Method)object2).invoke(drawable2, objectArray);
                    }
                    catch (Exception exception) {
                        boolean bl4 = l.a.o.f.a;
                        if (!bl4) break block14;
                        object = new StringBuilder();
                        object2 = "setV4DrawableWrapperWrappedDrawable invoke error: ";
                        ((StringBuilder)object).append((String)object2);
                        ((StringBuilder)object).append(exception);
                        String string3 = ((StringBuilder)object).toString();
                        l.a.o.f.b(string2, string3);
                    }
                }
            }
        }
    }

    public static void k(Drawable drawable2, Drawable object) {
        block14: {
            Object object2 = e;
            if (object2 != null) {
                boolean bl2;
                String string2;
                Object[] objectArray;
                block13: {
                    objectArray = g;
                    string2 = a;
                    bl2 = true;
                    if (objectArray == null) {
                        objectArray = "setWrappedDrawable";
                        Class[] classArray = new Class[bl2];
                        Class<Drawable> clazz = Drawable.class;
                        classArray[0] = clazz;
                        object2 = ((Class)object2).getDeclaredMethod((String)objectArray, classArray);
                        g = object2;
                        try {
                            ((Method)object2).setAccessible(bl2);
                        }
                        catch (Exception exception) {
                            boolean bl3 = l.a.o.f.a;
                            if (!bl3) break block13;
                            object2 = "setV4WrappedDrawableWrappedDrawable No Such Method";
                            l.a.o.f.b(string2, (String)object2);
                        }
                    }
                }
                if ((object2 = g) != null) {
                    objectArray = new Object[bl2];
                    objectArray[0] = object;
                    try {
                        ((Method)object2).invoke(drawable2, objectArray);
                    }
                    catch (Exception exception) {
                        boolean bl4 = l.a.o.f.a;
                        if (!bl4) break block14;
                        object = new StringBuilder();
                        object2 = "setV4WrappedDrawableWrappedDrawable invoke error: ";
                        ((StringBuilder)object).append((String)object2);
                        ((StringBuilder)object).append(exception);
                        String string3 = ((StringBuilder)object).toString();
                        l.a.o.f.b(string2, string3);
                    }
                }
            }
        }
    }

    public static void l(Drawable drawable2, Drawable object) {
        block14: {
            Object object2 = h;
            if (object2 != null) {
                boolean bl2;
                String string2;
                Object[] objectArray;
                block13: {
                    objectArray = j;
                    string2 = a;
                    bl2 = true;
                    if (objectArray == null) {
                        objectArray = "setWrappedDrawable";
                        Class[] classArray = new Class[bl2];
                        Class<Drawable> clazz = Drawable.class;
                        classArray[0] = clazz;
                        object2 = ((Class)object2).getDeclaredMethod((String)objectArray, classArray);
                        j = object2;
                        try {
                            ((Method)object2).setAccessible(bl2);
                        }
                        catch (Exception exception) {
                            boolean bl3 = l.a.o.f.a;
                            if (!bl3) break block13;
                            object2 = "setV7DrawableWrapperWrappedDrawable No Such Method";
                            l.a.o.f.b(string2, (String)object2);
                        }
                    }
                }
                if ((object2 = j) != null) {
                    objectArray = new Object[bl2];
                    objectArray[0] = object;
                    try {
                        ((Method)object2).invoke(drawable2, objectArray);
                    }
                    catch (Exception exception) {
                        boolean bl4 = l.a.o.f.a;
                        if (!bl4) break block14;
                        object = new StringBuilder();
                        object2 = "setV7DrawableWrapperWrappedDrawable invoke error: ";
                        ((StringBuilder)object).append((String)object2);
                        ((StringBuilder)object).append(exception);
                        String string3 = ((StringBuilder)object).toString();
                        l.a.o.f.b(string2, string3);
                    }
                }
            }
        }
    }
}

