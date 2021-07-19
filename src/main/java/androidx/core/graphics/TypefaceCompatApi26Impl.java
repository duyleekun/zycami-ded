/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.graphics.fonts.FontVariationAxis
 *  android.os.CancellationSignal
 *  android.util.Log
 */
package androidx.core.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$FontFileResourceEntry;
import androidx.core.graphics.TypefaceCompatApi21Impl;
import androidx.core.provider.FontsContractCompat$FontInfo;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public class TypefaceCompatApi26Impl
extends TypefaceCompatApi21Impl {
    private static final String ABORT_CREATION_METHOD = "abortCreation";
    private static final String ADD_FONT_FROM_ASSET_MANAGER_METHOD = "addFontFromAssetManager";
    private static final String ADD_FONT_FROM_BUFFER_METHOD = "addFontFromBuffer";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String FREEZE_METHOD = "freeze";
    private static final int RESOLVE_BY_FONT_TABLE = 255;
    private static final String TAG = "TypefaceCompatApi26Impl";
    public final Method mAbortCreation;
    public final Method mAddFontFromAssetManager;
    public final Method mAddFontFromBuffer;
    public final Method mCreateFromFamiliesWithDefault;
    public final Class mFontFamily;
    public final Constructor mFontFamilyCtor;
    public final Method mFreeze;

    public TypefaceCompatApi26Impl() {
        Method method;
        Method method2;
        Method method3;
        Object object;
        Object object2;
        GenericDeclaration genericDeclaration;
        GenericDeclaration genericDeclaration2;
        block9: {
            genericDeclaration2 = null;
            genericDeclaration = this.obtainFontFamily();
            object2 = this.obtainFontFamilyCtor((Class)genericDeclaration);
            object = this.obtainAddFontFromAssetManagerMethod((Class)genericDeclaration);
            method3 = this.obtainAddFontFromBufferMethod((Class)genericDeclaration);
            method2 = this.obtainFreezeMethod((Class)genericDeclaration);
            method = this.obtainAbortCreationMethod((Class)genericDeclaration);
            try {
                genericDeclaration2 = this.obtainCreateFromFamiliesWithDefaultMethod((Class)genericDeclaration);
                Class clazz = genericDeclaration;
                genericDeclaration = genericDeclaration2;
                genericDeclaration2 = clazz;
                break block9;
            }
            catch (NoSuchMethodException noSuchMethodException) {
            }
            catch (ClassNotFoundException classNotFoundException) {
                // empty catch block
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Unable to collect necessary methods for class ");
            object = genericDeclaration.getClass().getName();
            ((StringBuilder)object2).append((String)object);
            object2 = ((StringBuilder)object2).toString();
            Log.e((String)TAG, (String)object2, (Throwable)((Object)genericDeclaration));
            genericDeclaration = null;
            object2 = null;
            object = null;
            method3 = null;
            method2 = null;
            method = null;
        }
        this.mFontFamily = genericDeclaration2;
        this.mFontFamilyCtor = object2;
        this.mAddFontFromAssetManager = object;
        this.mAddFontFromBuffer = method3;
        this.mFreeze = method2;
        this.mAbortCreation = method;
        this.mCreateFromFamiliesWithDefault = genericDeclaration;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void abortCreation(Object object) {
        Method method = this.mAbortCreation;
        Object[] objectArray = null;
        objectArray = new Object[]{};
        try {
            method.invoke(object, objectArray);
            return;
        }
        catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {
            return;
        }
    }

    private boolean addFontFromAssetManager(Context object, Object object2, String object3, int n10, int n11, int n12, FontVariationAxis[] fontVariationAxisArray) {
        Method method = this.mAddFontFromAssetManager;
        int n13 = 8;
        Object[] objectArray = new Object[n13];
        object = object.getAssets();
        objectArray[0] = object;
        int n14 = 1;
        objectArray[n14] = object3;
        n14 = 2;
        object3 = 0;
        objectArray[n14] = object3;
        n14 = 3;
        object3 = Boolean.FALSE;
        objectArray[n14] = object3;
        n14 = 4;
        object3 = n10;
        objectArray[n14] = object3;
        n14 = 5;
        object3 = n11;
        objectArray[n14] = object3;
        n14 = 6;
        object3 = n12;
        objectArray[n14] = object3;
        n14 = 7;
        objectArray[n14] = fontVariationAxisArray;
        object = method.invoke(object2, objectArray);
        object = (Boolean)object;
        try {
            return (Boolean)object;
        }
        catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {
            return false;
        }
    }

    private boolean addFontFromBuffer(Object object, ByteBuffer byteBuffer, int n10, int n11, int n12) {
        Method method = this.mAddFontFromBuffer;
        int n13 = 5;
        Object[] objectArray = new Object[n13];
        objectArray[0] = byteBuffer;
        int n14 = 1;
        Integer n15 = n10;
        objectArray[n14] = n15;
        n14 = 2;
        n10 = 0;
        n15 = null;
        objectArray[n14] = null;
        n14 = 3;
        n15 = n11;
        objectArray[n14] = n15;
        n14 = 4;
        n15 = n12;
        objectArray[n14] = n15;
        object = method.invoke(object, objectArray);
        object = (Boolean)object;
        try {
            return (Boolean)object;
        }
        catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {
            return false;
        }
    }

    private boolean freeze(Object object) {
        Method method = this.mFreeze;
        Object[] objectArray = new Object[]{};
        object = method.invoke(object, objectArray);
        object = (Boolean)object;
        try {
            return (Boolean)object;
        }
        catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {
            return false;
        }
    }

    private boolean isFontFamilyPrivateAPIAvailable() {
        boolean bl2;
        Object object = this.mAddFontFromAssetManager;
        if (object == null) {
            object = TAG;
            String string2 = "Unable to collect necessary private methods. Fallback to legacy implementation.";
            Log.w((String)object, (String)string2);
        }
        if ((object = this.mAddFontFromAssetManager) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    private Object newFamily() {
        Constructor constructor = this.mFontFamilyCtor;
        Object[] objectArray = null;
        objectArray = new Object[]{};
        try {
            return constructor.newInstance(objectArray);
        }
        catch (IllegalAccessException | InstantiationException | InvocationTargetException reflectiveOperationException) {
            return null;
        }
    }

    public Typeface createFromFamiliesWithDefault(Object object) {
        Object object2 = this.mFontFamily;
        int n10 = 1;
        object2 = Array.newInstance(object2, n10);
        Integer n11 = null;
        Array.set(object2, 0, object);
        object = this.mCreateFromFamiliesWithDefault;
        int n12 = 3;
        Object[] objectArray = new Object[n12];
        objectArray[0] = object2;
        int n13 = -1;
        n11 = n13;
        objectArray[n10] = n11;
        n10 = 2;
        object2 = n13;
        objectArray[n10] = object2;
        object = ((Method)object).invoke(null, objectArray);
        try {
            return (Typeface)object;
        }
        catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {
            return null;
        }
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat$FontFamilyFilesResourceEntry fontResourcesParserCompat$FontFileResourceEntryArray, Resources object, int n10) {
        boolean bl2 = this.isFontFamilyPrivateAPIAvailable();
        if (!bl2) {
            return super.createFromFontFamilyFilesResourceEntry(context, (FontResourcesParserCompat$FontFamilyFilesResourceEntry)fontResourcesParserCompat$FontFileResourceEntryArray, (Resources)object, n10);
        }
        object = this.newFamily();
        n10 = 0;
        if (object == null) {
            return null;
        }
        fontResourcesParserCompat$FontFileResourceEntryArray = fontResourcesParserCompat$FontFileResourceEntryArray.getEntries();
        int n11 = fontResourcesParserCompat$FontFileResourceEntryArray.length;
        bl2 = false;
        Object object2 = null;
        for (int i10 = 0; i10 < n11; ++i10) {
            object2 = fontResourcesParserCompat$FontFileResourceEntryArray[i10];
            String string2 = ((FontResourcesParserCompat$FontFileResourceEntry)object2).getFileName();
            int n12 = ((FontResourcesParserCompat$FontFileResourceEntry)object2).getTtcIndex();
            int n13 = ((FontResourcesParserCompat$FontFileResourceEntry)object2).getWeight();
            int n14 = ((FontResourcesParserCompat$FontFileResourceEntry)object2).isItalic();
            FontVariationAxis[] fontVariationAxisArray = FontVariationAxis.fromFontVariationSettings((String)((FontResourcesParserCompat$FontFileResourceEntry)object2).getVariationSettings());
            object2 = this;
            bl2 = this.addFontFromAssetManager(context, object, string2, n12, n13, n14, fontVariationAxisArray);
            if (bl2) continue;
            this.abortCreation(object);
            return null;
        }
        boolean bl3 = this.freeze(object);
        if (!bl3) {
            return null;
        }
        return this.createFromFamiliesWithDefault(object);
    }

    /*
     * Exception decompiling
     */
    public Typeface createFromFontInfo(Context var1_1, CancellationSignal var2_3, FontsContractCompat$FontInfo[] var3_5, int var4_6) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public Typeface createFromResourcesFontFile(Context context, Resources object, int n10, String string2, int n11) {
        boolean bl2 = this.isFontFamilyPrivateAPIAvailable();
        if (!bl2) {
            return super.createFromResourcesFontFile(context, (Resources)object, n10, string2, n11);
        }
        object = this.newFamily();
        n10 = 0;
        if (object == null) {
            return null;
        }
        int n12 = -1;
        int n13 = -1;
        boolean bl3 = this.addFontFromAssetManager(context, object, string2, 0, n12, n13, null);
        if (!bl3) {
            this.abortCreation(object);
            return null;
        }
        bl3 = this.freeze(object);
        if (!bl3) {
            return null;
        }
        return this.createFromFamiliesWithDefault(object);
    }

    public Method obtainAbortCreationMethod(Class clazz) {
        Class[] classArray = new Class[]{};
        return clazz.getMethod(ABORT_CREATION_METHOD, classArray);
    }

    public Method obtainAddFontFromAssetManagerMethod(Class clazz) {
        Class<Integer> clazz2 = Integer.TYPE;
        Class<Boolean> clazz3 = Boolean.TYPE;
        Class[] classArray = new Class[]{AssetManager.class, String.class, clazz2, clazz3, clazz2, clazz2, clazz2, FontVariationAxis[].class};
        return clazz.getMethod(ADD_FONT_FROM_ASSET_MANAGER_METHOD, classArray);
    }

    public Method obtainAddFontFromBufferMethod(Class clazz) {
        Class<Integer> clazz2 = Integer.TYPE;
        Class[] classArray = new Class[]{ByteBuffer.class, clazz2, FontVariationAxis[].class, clazz2, clazz2};
        return clazz.getMethod(ADD_FONT_FROM_BUFFER_METHOD, classArray);
    }

    public Method obtainCreateFromFamiliesWithDefaultMethod(Class genericDeclaration) {
        boolean bl2 = true;
        genericDeclaration = Array.newInstance(genericDeclaration, (int)(bl2 ? 1 : 0));
        Class[] classArray = new Class[3];
        genericDeclaration = genericDeclaration.getClass();
        classArray[0] = genericDeclaration;
        genericDeclaration = Integer.TYPE;
        classArray[bl2] = genericDeclaration;
        classArray[2] = genericDeclaration;
        genericDeclaration = Typeface.class.getDeclaredMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, classArray);
        ((Method)genericDeclaration).setAccessible(bl2);
        return genericDeclaration;
    }

    public Class obtainFontFamily() {
        return Class.forName(FONT_FAMILY_CLASS);
    }

    public Constructor obtainFontFamilyCtor(Class clazz) {
        Class[] classArray = new Class[]{};
        return clazz.getConstructor(classArray);
    }

    public Method obtainFreezeMethod(Class clazz) {
        Class[] classArray = new Class[]{};
        return clazz.getMethod(FREEZE_METHOD, classArray);
    }
}

