/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  android.util.Log
 *  dalvik.system.DexFile
 *  dalvik.system.PathClassLoader
 */
package com.meicam.effect.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.meicam.effect.sdk.NvsEffectRenderCore;
import com.meicam.effect.sdk.NvsEffectSdkContext$SdkVersion;
import com.meicam.effect.sdk.NvsEffectSdkContext$VerifyLicenseResult;
import com.meicam.effect.sdk.NvsVideoEffect;
import com.meicam.effect.sdk.NvsVideoEffectAnimatedSticker;
import com.meicam.effect.sdk.NvsVideoEffectCaption;
import com.meicam.effect.sdk.NvsVideoEffectCompoundCaption;
import com.meicam.effect.sdk.NvsVideoEffectTransition;
import com.meicam.sdk.NvsAssetPackageManager;
import com.meicam.sdk.NvsHumanDetectionHandle;
import com.meicam.sdk.NvsRational;
import com.meicam.sdk.NvsSystemVariableManager;
import com.meicam.sdk.NvsTimeUtil;
import com.meicam.sdk.NvsUtils;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class NvsEffectSdkContext {
    public static final int DEBUG_LEVEL_DEBUG = 3;
    public static final int DEBUG_LEVEL_ERROR = 1;
    public static final int DEBUG_LEVEL_NONE = 0;
    public static final int DEBUG_LEVEL_WARNING = 2;
    public static final int HUMAN_DETECTION_DATA_TYPE_CUSTOM_AVATAR = 5;
    public static final int HUMAN_DETECTION_DATA_TYPE_FAKE_FACE = 0;
    public static final int HUMAN_DETECTION_DATA_TYPE_MAKEUP = 1;
    public static final int HUMAN_DETECTION_DATA_TYPE_PE106 = 3;
    public static final int HUMAN_DETECTION_DATA_TYPE_PE240 = 4;
    public static final int HUMAN_DETECTION_DATA_TYPE_SKIN_COLOR = 2;
    public static final int HUMAN_DETECTION_FEATURE_AVATAR_EXPRESSION = 4;
    public static final int HUMAN_DETECTION_FEATURE_EXTRA = 128;
    public static final int HUMAN_DETECTION_FEATURE_EYEBALL_LANDMARK = 4096;
    public static final int HUMAN_DETECTION_FEATURE_FACE_ACTION = 2;
    public static final int HUMAN_DETECTION_FEATURE_FACE_LANDMARK = 1;
    public static final int HUMAN_DETECTION_FEATURE_HAND_ACTION = 1024;
    public static final int HUMAN_DETECTION_FEATURE_HAND_BONE = 2048;
    public static final int HUMAN_DETECTION_FEATURE_HAND_LANDMARK = 512;
    public static final int HUMAN_DETECTION_FEATURE_IMAGE_MODE = 16;
    public static final int HUMAN_DETECTION_FEATURE_MULTI_DETECT = 8192;
    public static final int HUMAN_DETECTION_FEATURE_MULTI_THREAD = 32;
    public static final int HUMAN_DETECTION_FEATURE_SEGMENTATION_BACKGROUND = 256;
    public static final int HUMAN_DETECTION_FEATURE_SINGLE_THREAD = 64;
    public static final int HUMAN_DETECTION_FEATURE_VIDEO_MODE = 8;
    private static final String TAG = "Meicam";
    private static AssetManager m_assetManager;
    private static Thread m_checkExpirationThread;
    private static ClassLoader m_classLoader;
    private static Context m_context;
    private static boolean m_customNativeLibraryDirPath = false;
    private static int m_debugLevel = 3;
    private static boolean m_faceDetectionLibLoaded = false;
    private static boolean m_initializedOnce = false;
    private static NvsEffectSdkContext m_instance;
    private static String m_nativeLibraryDirPath;
    private static boolean m_saveDebugMessagesToFile = false;
    private NvsAssetPackageManager m_assetPackageManager = null;

    private NvsEffectSdkContext(Context context) {
        NvsAssetPackageManager nvsAssetPackageManager;
        this.m_assetPackageManager = nvsAssetPackageManager = new NvsAssetPackageManager(true);
        long l10 = this.nativeGetAssetPackageManager();
        nvsAssetPackageManager.setInternalObject(l10);
        this.nativeDetectPackageName(context);
    }

    private boolean checkCameraPermission() {
        int n10 = Build.VERSION.SDK_INT;
        boolean bl2 = true;
        int n11 = 23;
        if (n10 < n11) {
            // empty if block
        }
        return bl2;
    }

    private boolean checkInternetPermission() {
        int n10 = Build.VERSION.SDK_INT;
        boolean bl2 = true;
        int n11 = 23;
        if (n10 < n11) {
            return bl2;
        }
        Context context = m_context;
        String string2 = "android.permission.INTERNET";
        n10 = context.checkSelfPermission(string2);
        if (n10 != 0) {
            Log.e((String)TAG, (String)"INTERNET permission has not been granted!");
            return false;
        }
        return bl2;
    }

    public static void close() {
        NvsUtils.checkFunctionInMainThread();
        Object object = m_instance;
        if (object == null) {
            return;
        }
        if ((object = ((NvsEffectSdkContext)object).getAssetPackageManager()) != null) {
            ((NvsAssetPackageManager)object).setCallbackInterface(null);
        }
        m_instance = null;
        m_context = null;
        NvsEffectSdkContext.nativeSetAssetManager(null);
        m_assetManager = null;
        m_classLoader = null;
        NvsEffectSdkContext.nativeClose();
    }

    public static void closeHumanDetection() {
        NvsUtils.checkFunctionInMainThread();
        NvsEffectSdkContext.nativeCloseHumanDetection();
    }

    private static void createNewNativeDirAboveEqualApiLevel14(Context object, String string2) {
        object = NvsEffectSdkContext.getPathList((PathClassLoader)object.getClassLoader());
        AnnotatedElement annotatedElement = object.getClass();
        String string3 = "nativeLibraryDirectories";
        annotatedElement = ((Class)annotatedElement).getDeclaredField(string3);
        int n10 = 1;
        ((Field)annotatedElement).setAccessible(n10 != 0);
        File[] fileArray = (File[])((Field)annotatedElement).get(object);
        int n11 = fileArray.length + n10;
        Object object2 = Array.newInstance(File.class, n11);
        File file = new File(string2);
        string2 = null;
        Array.set(object2, 0, file);
        for (int i10 = n10; i10 < (n11 = fileArray.length + n10); ++i10) {
            n11 = i10 + -1;
            file = fileArray[n11];
            Array.set(object2, i10, file);
        }
        ((Field)annotatedElement).set(object, object2);
    }

    private static void createNewNativeDirAboveEqualApiLevel21(Context object, String object2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 < n11) {
            return;
        }
        object = NvsEffectSdkContext.getPathList((PathClassLoader)object.getClassLoader());
        Object object3 = object.getClass();
        String string2 = "systemNativeLibraryDirectories";
        object3 = ((Class)object3).getDeclaredField(string2);
        n11 = 1;
        ((Field)object3).setAccessible(n11 != 0);
        List list = (List)((Field)object3).get(object);
        Object object4 = new File((String)object2);
        list.add(object4);
        ((Field)object3).set(object, list);
        object3 = object.getClass().getDeclaredField("nativeLibraryDirectories");
        ((Field)object3).setAccessible(n11 != 0);
        list = (ArrayList)((Field)object3).get(object);
        object4 = new File((String)object2);
        list.add(object4);
        ((Field)object3).set(object, list);
        object3 = Class.forName("dalvik.system.DexPathList$Element");
        int n12 = 4;
        Object object5 = new Class[n12];
        object5[0] = File.class;
        AnnotatedElement annotatedElement = Boolean.TYPE;
        object5[n11] = annotatedElement;
        int n13 = 2;
        object5[n13] = File.class;
        int n14 = 3;
        object5[n14] = DexFile.class;
        object5 = ((Class)object3).getConstructor((Class<?>)object5);
        annotatedElement = object.getClass();
        String string3 = "nativeLibraryPathElements";
        annotatedElement = ((Class)annotatedElement).getDeclaredField(string3);
        ((Field)annotatedElement).setAccessible(n11 != 0);
        Object[] objectArray = (Object[])((Field)annotatedElement).get(object);
        int n15 = objectArray.length + n11;
        object3 = Array.newInstance(object3, n15);
        if (object5 != null) {
            n15 = 0;
            object4 = new Object[n12];
            File file = new File((String)object2);
            object4[0] = file;
            object2 = Boolean.TRUE;
            object4[n11] = object2;
            object4[n13] = null;
            object4[n14] = null;
            object2 = ((Constructor)object5).newInstance(object4);
            Array.set(object3, 0, object2);
            int n16 = n11;
            while (true) {
                n12 = objectArray.length + n11;
                if (n16 >= n12) break;
                n12 = n16 + -1;
                object4 = objectArray[n12];
                Array.set(object3, n16, object4);
                ++n16;
                continue;
                break;
            }
            try {
                ((Field)annotatedElement).set(object, object3);
            }
            catch (InvocationTargetException invocationTargetException) {
                invocationTargetException.printStackTrace();
            }
            catch (InstantiationException instantiationException) {
                instantiationException.printStackTrace();
            }
            catch (IllegalArgumentException illegalArgumentException) {
                object2 = object.getClass();
                object3 = new Class[n11];
                object3[0] = List.class;
                object4 = "makePathElements";
                object2 = ((Class)object2).getDeclaredMethod((String)object4, (Class<?>)object3);
                ((Method)object2).setAccessible(n11 != 0);
                object3 = new Object[n11];
                object3[0] = list;
                object2 = ((Method)object2).invoke(null, (Object[])object3);
                object3 = object.getClass().getDeclaredField(string3);
                ((Field)object3).setAccessible(n11 != 0);
                ((Field)object3).set(object, object2);
            }
        }
    }

    private static void createNewNativeDirBelowApiLevel14(Context context, String string2) {
        context = (PathClassLoader)context.getClassLoader();
        AnnotatedElement annotatedElement = context.getClass();
        String string3 = "mLibPaths";
        annotatedElement = ((Class)annotatedElement).getDeclaredField(string3);
        int n10 = 1;
        ((Field)annotatedElement).setAccessible(n10 != 0);
        String[] stringArray = (String[])((Field)annotatedElement).get(context);
        int n11 = stringArray.length + n10;
        Object object = Array.newInstance(String.class, n11);
        n11 = 0;
        String string4 = null;
        Array.set(object, 0, string2);
        for (int i10 = n10; i10 < (n11 = stringArray.length + n10); ++i10) {
            n11 = i10 + -1;
            string4 = stringArray[n11];
            Array.set(object, i10, string4);
        }
        ((Field)annotatedElement).set(context, object);
    }

    public static boolean functionalityAuthorised(String string2) {
        NvsUtils.checkFunctionInMainThread();
        return NvsEffectSdkContext.nativeFunctionalityAuthorised(string2);
    }

    public static ClassLoader getClassLoader() {
        NvsUtils.checkFunctionInMainThread();
        return m_classLoader;
    }

    public static Context getContext() {
        NvsUtils.checkFunctionInMainThread();
        return m_context;
    }

    private static Object getField(Object object, Class annotatedElement, String string2) {
        annotatedElement = ((Class)annotatedElement).getDeclaredField(string2);
        ((Field)annotatedElement).setAccessible(true);
        return ((Field)annotatedElement).get(object);
    }

    public static NvsEffectSdkContext getInstance() {
        NvsUtils.checkFunctionInMainThread();
        return m_instance;
    }

    private static Object getPathList(Object object) {
        Class<?> clazz = Class.forName("dalvik.system.BaseDexClassLoader");
        return NvsEffectSdkContext.getField(object, clazz, "pathList");
    }

    public static int hasARModule() {
        NvsUtils.checkFunctionInMainThread();
        return NvsEffectSdkContext.nativeHasARModule();
    }

    private static boolean hasDexClassLoader() {
        String string2 = "dalvik.system.BaseDexClassLoader";
        try {
            Class.forName(string2);
            return true;
        }
        catch (ClassNotFoundException classNotFoundException) {
            return false;
        }
    }

    public static NvsEffectSdkContext init(Activity activity, String string2) {
        NvsUtils.checkFunctionInMainThread();
        return NvsEffectSdkContext.init(activity, string2, 0);
    }

    public static NvsEffectSdkContext init(Activity activity, String string2, int n10) {
        NvsUtils.checkFunctionInMainThread();
        return NvsEffectSdkContext.init((Context)activity, string2, n10);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static NvsEffectSdkContext init(Context var0, String var1_2, int var2_3) {
        block33: {
            block37: {
                block36: {
                    block35: {
                        block34: {
                            NvsUtils.checkFunctionInMainThread();
                            var3_4 = NvsEffectSdkContext.m_instance;
                            if (var3_4 != null) {
                                return var3_4;
                            }
                            var3_4 = var0 /* !! */ .getApplicationInfo();
                            var4_5 = NvsEffectSdkContext.m_nativeLibraryDirPath;
                            if (var4_5 == null) {
                                var4_5 = new StringBuilder();
                                var3_4 = var3_4.nativeLibraryDir;
                                var4_5.append((String)var3_4);
                                var4_5.append("/");
                                NvsEffectSdkContext.m_nativeLibraryDirPath = var3_4 = var4_5.toString();
                            }
                            var3_4 = new StringBuilder();
                            var3_4.append("HOME=");
                            var4_5 = var0 /* !! */ .getFilesDir().getAbsolutePath();
                            var3_4.append((String)var4_5);
                            var3_4 = var3_4.toString();
                            var4_5 = new StringBuilder();
                            var4_5.append((String)var3_4);
                            var4_5.append("\tTMPDIR=");
                            var3_4 = var0 /* !! */ .getFilesDir().getAbsolutePath();
                            var4_5.append((String)var3_4);
                            var3_4 = var4_5.toString();
                            var4_5 = null;
                            try {
                                var5_6 /* !! */  = var0 /* !! */ .getAssets();
                            }
                            catch (Exception var0_1) {
                                var1_2 = new StringBuilder();
                                var1_2.append("");
                                var12_13 = var0_1.getMessage();
                                var1_2.append(var12_13);
                                var1_2 = var1_2.toString();
                                Log.e((String)"Meicam", (String)var1_2);
                                var0_1.printStackTrace();
                                NvsEffectSdkContext.m_context = null;
                                NvsEffectSdkContext.m_classLoader = null;
                                NvsEffectSdkContext.m_assetManager = null;
                                return null;
                            }
                            NvsEffectSdkContext.m_assetManager = var5_6 /* !! */ ;
                            var5_6 /* !! */  = var0 /* !! */ .getApplicationContext();
                            NvsEffectSdkContext.m_context = var5_6 /* !! */ ;
                            var5_6 /* !! */  = var5_6 /* !! */ .getClassLoader();
                            NvsEffectSdkContext.m_classLoader = var5_6 /* !! */ ;
                            var6_7 = NvsEffectSdkContext.m_initializedOnce;
                            var7_8 = 0;
                            var8_9 = 1;
                            if (var6_7 != 0) ** GOTO lbl84
                            var6_7 = NvsEffectSdkContext.m_customNativeLibraryDirPath;
                            if (var6_7 == 0) ** GOTO lbl69
                            var5_6 /* !! */  = NvsEffectSdkContext.m_nativeLibraryDirPath;
                            NvsEffectSdkContext.initNativeLibraryDirPath(var0 /* !! */ , (String)var5_6 /* !! */ );
lbl69:
                            // 2 sources

                            NvsEffectSdkContext.tryLoadFaceDetectionLibrary();
                            var5_6 /* !! */  = "com.meicam.sdk.NvsStreamingContext";
                            try {
                                Class.forName((String)var5_6 /* !! */ );
                                var6_7 = 0;
                                var5_6 /* !! */  = null;
                            }
                            catch (Exception v0) {
                                var6_7 = var8_9;
                            }
                            var9_10 = "NvStreamingSdkCore";
                            if (var6_7 != 0) {
                                var9_10 = "NvEffectSdkCore";
                            }
                            NvsEffectSdkContext.loadNativeLibrary(var9_10);
lbl84:
                            // 2 sources

                            var5_6 /* !! */  = NvsEffectSdkContext.m_context;
                            var6_7 = NvsEffectSdkContext.nativeInitJNI((Context)var5_6 /* !! */ );
                            if (var6_7 == 0) break block33;
                            var5_6 /* !! */  = NvsEffectSdkContext.m_assetManager;
                            NvsEffectSdkContext.nativeSetAssetManager(var5_6 /* !! */ );
                            var6_7 = NvsEffectSdkContext.m_debugLevel;
                            NvsEffectSdkContext.nativeSetDebugLevel(var6_7);
                            var6_7 = (int)NvsEffectSdkContext.m_saveDebugMessagesToFile;
                            NvsEffectSdkContext.nativeSetSaveDebugMessagesToFile((boolean)var6_7);
                            var5_6 /* !! */  = "isExpired";
                            var6_7 = NvsSystemVariableManager.getSystemVariableInt(var0 /* !! */ , (String)var5_6 /* !! */ );
                            if (var6_7 != var8_9) break block34;
                            var7_8 = var8_9;
                        }
                        var5_6 /* !! */  = new NvsEffectSdkContext$VerifyLicenseResult();
                        var10_11 = NvsEffectSdkContext.m_initializedOnce;
                        if (var10_11) break block35;
                        var5_6 /* !! */  = NvsEffectSdkContext.nativeVerifySdkLicenseFile(var0 /* !! */ , (String)var1_2, (boolean)var7_8);
                    }
                    var11_12 = var5_6 /* !! */ .needCheckExpiration;
                    if (var11_12 == 0) break block36;
                    var1_2 = "lastTime";
                    var1_2 = NvsSystemVariableManager.getSystemVariableString(var0 /* !! */ , (String)var1_2);
                    var6_7 = (int)TextUtils.isEmpty((CharSequence)var1_2);
                    if (var6_7 != 0) break block36;
                    var5_6 /* !! */  = NvsTimeUtil.getCurrentTime();
                    var11_12 = NvsTimeUtil.getHourRange((String)var1_2, (String)var5_6 /* !! */ );
                    if (var11_12 < 0) break block36;
                    var6_7 = 24;
                }
                var11_12 = NvsEffectSdkContext.nativeInit((String)var3_4, var2_3);
                if (var11_12 != 0) break block37;
                return null;
            }
            NvsEffectSdkContext.m_instance = var1_2 = new NvsEffectSdkContext(var0 /* !! */ );
            NvsEffectSdkContext.m_initializedOnce = var8_9;
            return var1_2;
        }
        var1_2 = "nativeInitJNI() failed!";
        var0 /* !! */  = new Exception((String)var1_2);
        throw var0 /* !! */ ;
    }

    public static boolean initHumanDetection(Context context, String string2, String string3, int n10) {
        NvsUtils.checkFunctionInMainThread();
        NvsEffectSdkContext.tryLoadFaceDetectionLibrary();
        boolean bl2 = m_faceDetectionLibLoaded;
        if (!bl2) {
            return false;
        }
        return NvsEffectSdkContext.nativeInitHumanDetection(context, string2, string3, n10);
    }

    public static boolean initHumanDetectionExt(Context context, String string2, String string3, int n10) {
        return NvsEffectSdkContext.nativeInitHumanDetectionExt(context, string2, string3, n10);
    }

    /*
     * Loose catch block
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void initNativeLibraryDirPath(Context context, String string2) {
        boolean bl2 = NvsEffectSdkContext.hasDexClassLoader();
        if (bl2) {
            try {
                NvsEffectSdkContext.createNewNativeDirAboveEqualApiLevel14(context, string2);
                return;
            }
            catch (Exception exception) {
                NvsEffectSdkContext.createNewNativeDirAboveEqualApiLevel21(context, string2);
            }
            return;
        }
        NvsEffectSdkContext.createNewNativeDirBelowApiLevel14(context, string2);
        return;
        {
            catch (Exception exception) {
                return;
            }
        }
    }

    private static void loadNativeLibrary(String string2) {
        System.loadLibrary(string2);
    }

    private static native void nativeClose();

    private static native void nativeCloseHumanDetection();

    private native NvsVideoEffectAnimatedSticker nativeCreateAnimatedSticker(long var1, long var3, boolean var5, String var6, NvsRational var7);

    private native NvsVideoEffectCaption nativeCreateCaption(String var1, long var2, long var4, String var6, boolean var7, NvsRational var8);

    private native NvsVideoEffectCompoundCaption nativeCreateCompoundCaption(long var1, long var3, String var5, NvsRational var6);

    private native NvsEffectRenderCore nativeCreateEffectRenderCore();

    private static native NvsHumanDetectionHandle nativeCreateHumanDetectionHandle(String var0, String var1, long var2);

    private native NvsVideoEffectCaption nativeCreateModularCaption(String var1, long var2, long var4, NvsRational var6);

    private native NvsVideoEffect nativeCreateVideoEffect(String var1, NvsRational var2, boolean var3);

    private native NvsVideoEffectTransition nativeCreateVideoTransition(String var1, NvsRational var2);

    private static native boolean nativeDestroyHumanDetectionHandle(NvsHumanDetectionHandle var0);

    private native void nativeDetectPackageName(Context var1);

    private static native boolean nativeExtendHumanDetectionHandle(NvsHumanDetectionHandle var0, String var1, String var2, long var3);

    private static native boolean nativeFunctionalityAuthorised(String var0);

    private native List nativeGetAllBuiltinVideoFxNames();

    private native long nativeGetAssetPackageManager();

    private native NvsEffectSdkContext$SdkVersion nativeGetSdkVersion();

    private static native int nativeHasARModule();

    private static native boolean nativeInit(String var0, int var1);

    private static native boolean nativeInitHumanDetection(Context var0, String var1, String var2, int var3);

    private static native boolean nativeInitHumanDetectionExt(Context var0, String var1, String var2, int var3);

    private static native boolean nativeInitJNI(Context var0);

    private native boolean nativeIsEffectSdkAuthorised();

    private static native void nativeSetAssetManager(AssetManager var0);

    private static native void nativeSetDebugLevel(int var0);

    private static native void nativeSetSaveDebugMessagesToFile(boolean var0);

    private static native boolean nativeSetupHumanDetectionData(int var0, String var1);

    private static native NvsEffectSdkContext$VerifyLicenseResult nativeVerifySdkLicenseFile(Context var0, String var1, boolean var2);

    public static void setDebugLevel(int n10) {
        NvsUtils.checkFunctionInMainThread();
        int n11 = m_debugLevel;
        if (n10 == n11) {
            return;
        }
        m_debugLevel = n10;
        NvsEffectSdkContext nvsEffectSdkContext = m_instance;
        if (nvsEffectSdkContext != null) {
            NvsEffectSdkContext.nativeSetDebugLevel(n10);
        }
    }

    public static void setNativeLibraryDirPath(String string2) {
        NvsUtils.checkFunctionInMainThread();
        m_nativeLibraryDirPath = string2;
        if (string2 != null) {
            boolean bl2;
            m_customNativeLibraryDirPath = bl2 = true;
        }
    }

    public static void setSaveDebugMessagesToFile(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        boolean bl3 = m_saveDebugMessagesToFile;
        if (bl2 == bl3) {
            return;
        }
        m_saveDebugMessagesToFile = bl2;
        NvsEffectSdkContext nvsEffectSdkContext = m_instance;
        if (nvsEffectSdkContext != null) {
            NvsEffectSdkContext.nativeSetSaveDebugMessagesToFile(bl2);
        }
    }

    public static boolean setupHumanDetectionData(int n10, String string2) {
        return NvsEffectSdkContext.nativeSetupHumanDetectionData(n10, string2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void tryLoadFaceDetectionLibrary() {
        var0 = NvsEffectSdkContext.m_faceDetectionLibLoaded;
        if (var0) {
            return;
        }
        var0 = false;
        var1_1 = null;
        var2_2 = true;
        var3_3 = "com.meicam.effect.sdk.NvsBEFFaceEffectDetector";
        try {
            Class.forName(var3_3);
            ** GOTO lbl17
        }
        catch (Exception v0) {
            var3_3 = "com.meicam.sdk.NvsBEFFaceEffectDetector";
            try {
                Class.forName(var3_3);
            }
            catch (Exception v1) {
                var4_4 = false;
                var3_3 = null;
            }
lbl17:
            // 2 sources

            var4_4 = var2_2;
        }
        if (var4_4 && !(var4_4 = NvsEffectSdkContext.tryLoadNativeLibrary(var3_3 = "effect"))) {
            return;
        }
        var3_3 = "com.meicam.effect.sdk.NvsMGFaceEffectDetector";
        try {
            Class.forName(var3_3);
            ** GOTO lbl34
        }
        catch (Exception v2) {
            var3_3 = "com.meicam.sdk.NvsMGFaceEffectDetector";
            try {
                Class.forName(var3_3);
            }
            catch (Exception v3) {
                var4_4 = false;
                var3_3 = null;
            }
lbl34:
            // 2 sources

            var4_4 = var2_2;
        }
        if (!(!var4_4 || (var4_4 = NvsEffectSdkContext.tryLoadNativeLibrary(var3_3 = "megface-new")) && (var4_4 = NvsEffectSdkContext.tryLoadNativeLibrary(var3_3 = "MegviiFacepp")))) {
            return;
        }
        var3_3 = "com.meicam.effect.sdk.NvsSTFaceEffectDetector";
        try {
            Class.forName(var3_3);
            ** GOTO lbl51
        }
        catch (Exception v4) {
            var3_3 = "com.meicam.sdk.NvsSTFaceEffectDetector";
            try {
                Class.forName(var3_3);
            }
            catch (Exception v5) {
                var4_4 = false;
                var3_3 = null;
            }
lbl51:
            // 2 sources

            var4_4 = var2_2;
        }
        if (var4_4 && !(var4_4 = NvsEffectSdkContext.tryLoadNativeLibrary(var3_3 = "st_mobile"))) {
            return;
        }
        var3_3 = "com.meicam.effect.sdk.NvsFUFaceEffectDetector";
        try {
            Class.forName(var3_3);
        }
        catch (Exception v6) {
            var3_3 = "com.meicam.sdk.NvsFUFaceEffectDetector";
            try {
                Class.forName(var3_3);
            }
            catch (Exception v7) {}
        }
        var0 = var2_2;
        if (var0) {
            var1_1 = "fuai";
            var0 = NvsEffectSdkContext.tryLoadNativeLibrary(var1_1);
            if (!var0) {
                return;
            }
            var1_1 = "nama";
            var0 = NvsEffectSdkContext.tryLoadNativeLibrary(var1_1);
            if (!var0) {
                return;
            }
        }
        NvsEffectSdkContext.m_faceDetectionLibLoaded = var2_2;
    }

    private static boolean tryLoadNativeLibrary(String string2) {
        try {
            System.loadLibrary(string2);
            return true;
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    public NvsVideoEffectCaption CreatePanoramicCaption(String string2, long l10, long l11, String string3, NvsRational nvsRational) {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeCreateCaption(string2, l10, l11, string3, true, nvsRational);
    }

    public NvsVideoEffectAnimatedSticker createAnimatedSticker(long l10, long l11, boolean bl2, String string2, NvsRational nvsRational) {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeCreateAnimatedSticker(l10, l11, bl2, string2, nvsRational);
    }

    public NvsVideoEffectCaption createCaption(String string2, long l10, long l11, String string3, NvsRational nvsRational) {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeCreateCaption(string2, l10, l11, string3, false, nvsRational);
    }

    public NvsVideoEffectCompoundCaption createCompoundCaption(long l10, long l11, String string2, NvsRational nvsRational) {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeCreateCompoundCaption(l10, l11, string2, nvsRational);
    }

    public NvsEffectRenderCore createEffectRenderCore() {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeCreateEffectRenderCore();
    }

    public NvsHumanDetectionHandle createHumanDetectionHandle(String string2, String string3, long l10) {
        NvsUtils.checkFunctionInMainThread();
        return NvsEffectSdkContext.nativeCreateHumanDetectionHandle(string2, string3, l10);
    }

    public NvsVideoEffectCaption createModularCaption(String string2, long l10, long l11, NvsRational nvsRational) {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeCreateModularCaption(string2, l10, l11, nvsRational);
    }

    public NvsVideoEffect createVideoEffect(String string2, NvsRational nvsRational) {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeCreateVideoEffect(string2, nvsRational, true);
    }

    public NvsVideoEffect createVideoEffect(String string2, NvsRational nvsRational, boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeCreateVideoEffect(string2, nvsRational, bl2);
    }

    public NvsVideoEffectTransition createVideoTransition(String string2, NvsRational nvsRational) {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeCreateVideoTransition(string2, nvsRational);
    }

    public boolean destroyHumanDetectionHandle(NvsHumanDetectionHandle nvsHumanDetectionHandle) {
        NvsUtils.checkFunctionInMainThread();
        return NvsEffectSdkContext.nativeDestroyHumanDetectionHandle(nvsHumanDetectionHandle);
    }

    public boolean extendHumanDetectionHandle(NvsHumanDetectionHandle nvsHumanDetectionHandle, String string2, String string3, long l10) {
        NvsUtils.checkFunctionInMainThread();
        return NvsEffectSdkContext.nativeExtendHumanDetectionHandle(nvsHumanDetectionHandle, string2, string3, l10);
    }

    public List getAllBuiltinVideoFxNames() {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetAllBuiltinVideoFxNames();
    }

    public NvsAssetPackageManager getAssetPackageManager() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_assetPackageManager;
    }

    public NvsEffectSdkContext$SdkVersion getSdkVersion() {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetSdkVersion();
    }

    public boolean isSdkAuthorised() {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeIsEffectSdkAuthorised();
    }
}

