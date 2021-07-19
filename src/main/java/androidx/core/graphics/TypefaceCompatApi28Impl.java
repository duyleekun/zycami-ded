/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 */
package androidx.core.graphics;

import android.graphics.Typeface;
import androidx.core.graphics.TypefaceCompatApi26Impl;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TypefaceCompatApi28Impl
extends TypefaceCompatApi26Impl {
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String DEFAULT_FAMILY = "sans-serif";
    private static final int RESOLVE_BY_FONT_TABLE = 255;

    /*
     * WARNING - void declaration
     */
    public Typeface createFromFamiliesWithDefault(Object object) {
        void var1_4;
        Object object2 = this.mFontFamily;
        int n10 = 1;
        object2 = Array.newInstance(object2, n10);
        Integer n11 = null;
        Array.set(object2, 0, object);
        object = this.mCreateFromFamiliesWithDefault;
        int n12 = 4;
        Object[] objectArray = new Object[n12];
        objectArray[0] = object2;
        object2 = DEFAULT_FAMILY;
        objectArray[n10] = object2;
        int n13 = 2;
        n10 = -1;
        n11 = n10;
        objectArray[n13] = n11;
        n13 = 3;
        Integer n14 = n10;
        objectArray[n13] = n14;
        object = ((Method)object).invoke(null, objectArray);
        try {
            return (Typeface)object;
        }
        catch (InvocationTargetException invocationTargetException) {
        }
        catch (IllegalAccessException illegalAccessException) {
            // empty catch block
        }
        object2 = new RuntimeException((Throwable)var1_4);
        throw object2;
    }

    public Method obtainCreateFromFamiliesWithDefaultMethod(Class genericDeclaration) {
        boolean bl2 = true;
        genericDeclaration = Array.newInstance(genericDeclaration, (int)(bl2 ? 1 : 0));
        Class[] classArray = new Class[4];
        genericDeclaration = genericDeclaration.getClass();
        classArray[0] = genericDeclaration;
        classArray[bl2] = String.class;
        genericDeclaration = Integer.TYPE;
        classArray[2] = genericDeclaration;
        classArray[3] = genericDeclaration;
        genericDeclaration = Typeface.class.getDeclaredMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, classArray);
        ((Method)genericDeclaration).setAccessible(bl2);
        return genericDeclaration;
    }
}

