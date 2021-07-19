/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Typeface
 *  android.os.CancellationSignal
 *  android.os.ParcelFileDescriptor
 *  android.system.ErrnoException
 *  android.system.Os
 *  android.system.OsConstants
 *  android.system.StructStat
 *  android.util.Log
 */
package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import android.util.Log;
import androidx.core.content.res.FontResourcesParserCompat$FontFamilyFilesResourceEntry;
import androidx.core.content.res.FontResourcesParserCompat$FontFileResourceEntry;
import androidx.core.graphics.TypefaceCompatBaseImpl;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.provider.FontsContractCompat$FontInfo;
import java.io.File;
import java.lang.constant.Constable;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TypefaceCompatApi21Impl
extends TypefaceCompatBaseImpl {
    private static final String ADD_FONT_WEIGHT_STYLE_METHOD = "addFontWeightStyle";
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
    private static final String TAG = "TypefaceCompatApi21Impl";
    private static Method sAddFontWeightStyle;
    private static Method sCreateFromFamiliesWithDefault;
    private static Class sFontFamily;
    private static Constructor sFontFamilyCtor;
    private static boolean sHasInitBeenCalled = false;

    /*
     * WARNING - void declaration
     */
    private static boolean addFontWeightStyle(Object object, String object2, int n10, boolean bl2) {
        void var0_3;
        TypefaceCompatApi21Impl.init();
        Method method = sAddFontWeightStyle;
        int n11 = 3;
        Object[] objectArray = new Object[n11];
        objectArray[0] = object2;
        int n12 = 1;
        Constable constable = n10;
        objectArray[n12] = constable;
        n12 = 2;
        constable = Boolean.valueOf(bl2);
        objectArray[n12] = constable;
        object = method.invoke(object, objectArray);
        object = (Boolean)object;
        try {
            return (Boolean)object;
        }
        catch (InvocationTargetException invocationTargetException) {
        }
        catch (IllegalAccessException illegalAccessException) {
            // empty catch block
        }
        object2 = new RuntimeException((Throwable)var0_3);
        throw object2;
    }

    /*
     * WARNING - void declaration
     */
    private static Typeface createFromFamiliesWithDefault(Object object) {
        void var0_3;
        TypefaceCompatApi21Impl.init();
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
        catch (InvocationTargetException invocationTargetException) {
        }
        catch (IllegalAccessException illegalAccessException) {
            // empty catch block
        }
        object2 = new RuntimeException((Throwable)var0_3);
        throw object2;
    }

    private File getFile(ParcelFileDescriptor object) {
        block11: {
            String string2;
            Comparable<StringBuilder> comparable;
            try {
                comparable = new StringBuilder();
                string2 = "/proc/self/fd/";
            }
            catch (ErrnoException errnoException) {}
            comparable.append(string2);
            int n10 = object.getFd();
            comparable.append(n10);
            object = comparable.toString();
            object = Os.readlink((String)object);
            comparable = Os.stat((String)object);
            int n11 = ((StructStat)comparable).st_mode;
            n11 = (int)(OsConstants.S_ISREG((int)n11) ? 1 : 0);
            if (n11 == 0) break block11;
            comparable = new File((String)object);
            return comparable;
        }
        return null;
    }

    private static void init() {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        block17: {
            int n10 = (int)(sHasInitBeenCalled ? 1 : 0);
            if (n10 != 0) {
                return;
            }
            n10 = 1;
            sHasInitBeenCalled = n10;
            object4 = null;
            object3 = FONT_FAMILY_CLASS;
            object3 = Class.forName((String)object3);
            String string2 = null;
            Object object5 = new Class[]{};
            object5 = ((Class)object3).getConstructor((Class<?>)object5);
            object2 = ADD_FONT_WEIGHT_STYLE_METHOD;
            int n11 = 3;
            Object object6 = new Class[n11];
            Class clazz = String.class;
            object6[0] = clazz;
            clazz = Integer.TYPE;
            object6[n10] = clazz;
            int n12 = 2;
            Object object7 = Boolean.TYPE;
            object6[n12] = object7;
            object2 = ((Class)object3).getMethod((String)object2, (Class<?>)object6);
            object6 = Array.newInstance(object3, n10);
            clazz = Typeface.class;
            object7 = CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD;
            object = new Class[n10];
            object6 = object6.getClass();
            object[0] = object6;
            try {
                object = clazz.getMethod((String)object7, (Class<?>)object);
                object4 = object5;
                break block17;
            }
            catch (NoSuchMethodException noSuchMethodException) {
            }
            catch (ClassNotFoundException classNotFoundException) {
                // empty catch block
            }
            object3 = object.getClass().getName();
            string2 = TAG;
            Log.e((String)string2, (String)object3, (Throwable)object);
            n10 = 0;
            object = null;
            object3 = null;
            object2 = null;
        }
        sFontFamilyCtor = object4;
        sFontFamily = object3;
        sAddFontWeightStyle = object2;
        sCreateFromFamiliesWithDefault = object;
    }

    /*
     * WARNING - void declaration
     */
    private static Object newFamily() {
        void var0_4;
        TypefaceCompatApi21Impl.init();
        Constructor constructor = sFontFamilyCtor;
        Object[] objectArray = null;
        objectArray = new Object[]{};
        try {
            return constructor.newInstance(objectArray);
        }
        catch (InvocationTargetException invocationTargetException) {
        }
        catch (InstantiationException instantiationException) {
        }
        catch (IllegalAccessException illegalAccessException) {
            // empty catch block
        }
        objectArray = new RuntimeException((Throwable)var0_4);
        throw objectArray;
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat$FontFamilyFilesResourceEntry fontResourcesParserCompat$FontFileResourceEntryArray, Resources resources, int n10) {
        Object object = TypefaceCompatApi21Impl.newFamily();
        for (FontResourcesParserCompat$FontFileResourceEntry fontResourcesParserCompat$FontFileResourceEntry : fontResourcesParserCompat$FontFileResourceEntryArray.getEntries()) {
            File file;
            block11: {
                block10: {
                    file = TypefaceCompatUtil.getTempFile(context);
                    if (file == null) {
                        return null;
                    }
                    int n11 = fontResourcesParserCompat$FontFileResourceEntry.getResourceId();
                    n11 = (int)(TypefaceCompatUtil.copyToFile(file, resources, n11) ? 1 : 0);
                    if (n11 != 0) break block10;
                    file.delete();
                    return null;
                }
                String string2 = file.getPath();
                int n12 = fontResourcesParserCompat$FontFileResourceEntry.getWeight();
                boolean bl2 = fontResourcesParserCompat$FontFileResourceEntry.isItalic();
                try {
                    bl2 = TypefaceCompatApi21Impl.addFontWeightStyle(object, string2, n12, bl2);
                    if (bl2) break block11;
                }
                catch (Throwable throwable) {
                    file.delete();
                    throw throwable;
                }
                catch (RuntimeException runtimeException) {
                    file.delete();
                    return null;
                }
                file.delete();
                return null;
            }
            file.delete();
        }
        return TypefaceCompatApi21Impl.createFromFamiliesWithDefault(object);
    }

    /*
     * Exception decompiling
     */
    public Typeface createFromFontInfo(Context var1_1, CancellationSignal var2_4, FontsContractCompat$FontInfo[] var3_6, int var4_8) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 4 blocks at once
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
}

