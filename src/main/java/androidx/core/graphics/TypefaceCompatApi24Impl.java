/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.net.Uri
 *  android.os.CancellationSignal
 *  android.util.Log
 */
package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$FontFileResourceEntry;
import androidx.core.graphics.TypefaceCompatBaseImpl;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.provider.FontsContractCompat$FontInfo;
import java.lang.constant.Constable;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

public class TypefaceCompatApi24Impl
extends TypefaceCompatBaseImpl {
    private static final String ADD_FONT_WEIGHT_STYLE_METHOD = "addFontWeightStyle";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String TAG = "TypefaceCompatApi24Impl";
    private static final Method sAddFontWeightStyle;
    private static final Method sCreateFromFamiliesWithDefault;
    private static final Class sFontFamily;
    private static final Constructor sFontFamilyCtor;

    static {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        block18: {
            object4 = null;
            object3 = FONT_FAMILY_CLASS;
            object3 = Class.forName((String)object3);
            object2 = null;
            Object object5 = new Class[]{};
            object5 = ((Class)object3).getConstructor((Class<?>)object5);
            object = ADD_FONT_WEIGHT_STYLE_METHOD;
            int n10 = 5;
            Object object6 = new Class[n10];
            Class clazz = ByteBuffer.class;
            object6[0] = clazz;
            clazz = Integer.TYPE;
            int n11 = 1;
            object6[n11] = clazz;
            int n12 = 2;
            Class<List> clazz2 = List.class;
            object6[n12] = clazz2;
            n12 = 3;
            object6[n12] = clazz;
            int n13 = 4;
            Object object7 = Boolean.TYPE;
            object6[n13] = object7;
            object = ((Class)object3).getMethod((String)object, (Class<?>)object6);
            object6 = Array.newInstance(object3, n11);
            clazz = Typeface.class;
            object7 = CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD;
            Class[] classArray = new Class[n11];
            object6 = object6.getClass();
            classArray[0] = object6;
            try {
                object2 = clazz.getMethod((String)object7, classArray);
                object4 = object5;
                break block18;
            }
            catch (NoSuchMethodException noSuchMethodException) {
            }
            catch (ClassNotFoundException classNotFoundException) {
                // empty catch block
            }
            object2 = object3.getClass().getName();
            object5 = "TypefaceCompatApi24Impl";
            Log.e((String)object5, (String)object2, (Throwable)object3);
            object3 = null;
            object2 = null;
            object = null;
        }
        sFontFamilyCtor = object4;
        sFontFamily = object3;
        sAddFontWeightStyle = object;
        sCreateFromFamiliesWithDefault = object2;
    }

    private static boolean addFontWeightStyle(Object object, ByteBuffer byteBuffer, int n10, int n11, boolean bl2) {
        Method method = sAddFontWeightStyle;
        int n12 = 5;
        Object[] objectArray = new Object[n12];
        objectArray[0] = byteBuffer;
        int n13 = 1;
        Constable constable = n10;
        objectArray[n13] = constable;
        n13 = 2;
        n10 = 0;
        constable = null;
        objectArray[n13] = null;
        n13 = 3;
        constable = n11;
        objectArray[n13] = constable;
        n13 = 4;
        constable = Boolean.valueOf(bl2);
        objectArray[n13] = constable;
        object = method.invoke(object, objectArray);
        object = (Boolean)object;
        try {
            return (Boolean)object;
        }
        catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {
            return false;
        }
    }

    private static Typeface createFromFamiliesWithDefault(Object object) {
        Object object2 = sFontFamily;
        int n10 = 1;
        object2 = Array.newInstance(object2, n10);
        Array.set(object2, 0, object);
        object = sCreateFromFamiliesWithDefault;
        Object[] objectArray = new Object[n10];
        objectArray[0] = object2;
        object = ((Method)object).invoke(null, objectArray);
        try {
            return (Typeface)object;
        }
        catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {
            return null;
        }
    }

    public static boolean isUsable() {
        boolean bl2;
        Method method = sAddFontWeightStyle;
        if (method == null) {
            String string2 = TAG;
            String string3 = "Unable to collect necessary private methods.Fallback to legacy implementation.";
            Log.w((String)string2, (String)string3);
        }
        if (method != null) {
            bl2 = true;
        } else {
            bl2 = false;
            method = null;
        }
        return bl2;
    }

    private static Object newFamily() {
        Constructor constructor = sFontFamilyCtor;
        Object[] objectArray = null;
        objectArray = new Object[]{};
        try {
            return constructor.newInstance(objectArray);
        }
        catch (IllegalAccessException | InstantiationException | InvocationTargetException reflectiveOperationException) {
            return null;
        }
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat$FontFamilyFilesResourceEntry fontResourcesParserCompat$FontFileResourceEntryArray, Resources resources, int n10) {
        Object object = TypefaceCompatApi24Impl.newFamily();
        if (object == null) {
            return null;
        }
        for (FontResourcesParserCompat$FontFileResourceEntry fontResourcesParserCompat$FontFileResourceEntry : fontResourcesParserCompat$FontFileResourceEntryArray.getEntries()) {
            int n11 = fontResourcesParserCompat$FontFileResourceEntry.getResourceId();
            ByteBuffer byteBuffer = TypefaceCompatUtil.copyToDirectBuffer(context, resources, n11);
            if (byteBuffer == null) {
                return null;
            }
            int n12 = fontResourcesParserCompat$FontFileResourceEntry.getTtcIndex();
            int n13 = fontResourcesParserCompat$FontFileResourceEntry.getWeight();
            boolean bl2 = fontResourcesParserCompat$FontFileResourceEntry.isItalic();
            if (bl2 = TypefaceCompatApi24Impl.addFontWeightStyle(object, byteBuffer, n12, n13, bl2)) continue;
            return null;
        }
        return TypefaceCompatApi24Impl.createFromFamiliesWithDefault(object);
    }

    public Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArray, int n10) {
        Object object = TypefaceCompatApi24Impl.newFamily();
        if (object == null) {
            return null;
        }
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
        for (FontsContractCompat$FontInfo fontsContractCompat$FontInfo : fontsContractCompat$FontInfoArray) {
            Uri uri = fontsContractCompat$FontInfo.getUri();
            ByteBuffer byteBuffer = (ByteBuffer)simpleArrayMap.get(uri);
            if (byteBuffer == null) {
                byteBuffer = TypefaceCompatUtil.mmap(context, cancellationSignal, uri);
                simpleArrayMap.put(uri, byteBuffer);
            }
            if (byteBuffer == null) {
                return null;
            }
            int n11 = fontsContractCompat$FontInfo.getTtcIndex();
            int n12 = fontsContractCompat$FontInfo.getWeight();
            boolean bl2 = fontsContractCompat$FontInfo.isItalic();
            if (bl2 = TypefaceCompatApi24Impl.addFontWeightStyle(object, byteBuffer, n11, n12, bl2)) continue;
            return null;
        }
        context = TypefaceCompatApi24Impl.createFromFamiliesWithDefault(object);
        if (context == null) {
            return null;
        }
        return Typeface.create((Typeface)context, (int)n10);
    }
}

