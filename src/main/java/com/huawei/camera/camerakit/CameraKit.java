/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Handler
 *  android.os.Process
 *  android.util.Log
 *  com.huawei.camerakit.api.CameraDeviceCallback
 *  com.huawei.camerakit.api.CameraInfoInterface
 *  com.huawei.camerakit.api.ModeCharacteristicsInterface
 *  com.huawei.camerakit.api.ModeInterface
 *  com.huawei.camerakit.api.ModeStateCallback
 *  com.huawei.camerakit.api.VersionInfoInterface
 *  com.huawei.camerakit.impl.ModeManager
 */
package com.huawei.camera.camerakit;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.util.Log;
import com.huawei.camera.camerakit.CameraDeviceCallback;
import com.huawei.camera.camerakit.CameraDeviceCallback$CameraDeviceCallbackWrapper;
import com.huawei.camera.camerakit.CameraInfo;
import com.huawei.camera.camerakit.Mode;
import com.huawei.camera.camerakit.ModeCharacteristics;
import com.huawei.camera.camerakit.ModeStateCallback;
import com.huawei.camera.camerakit.VersionInfo;
import com.huawei.camerakit.api.CameraInfoInterface;
import com.huawei.camerakit.api.ModeCharacteristicsInterface;
import com.huawei.camerakit.api.ModeInterface;
import com.huawei.camerakit.api.VersionInfoInterface;
import com.huawei.camerakit.impl.ModeManager;
import java.util.Objects;

public final class CameraKit {
    private static final String BLACKLIST_VERSION_NAME = "1.1.2";
    private static final String ERROR_VERSION_NAME = "-1.-1.-1";
    private static final String[] OLD_SUPPORT_PRODUCTS = new String[]{"HMA", "LYA", "EVR", "PCT", "VOG", "ELE", "TAS", "LIO", "AMZ", "NLE", "WLZ", "OXF", "WIN", "ORE"};
    private static final String OLD_VERSION_NAME = "1.0.0";
    private static final String[] PERMISSIONS_ARRAY = new String[]{"android.permission.CAMERA"};
    private static final String TAG = "CameraKit";
    private static int apiLevel = 255;
    private static CameraKit instance;
    private static boolean isGetInstanceSuccessed = false;
    private static ModeManager manager;

    private CameraKit(ModeManager modeManager) {
        manager = modeManager;
    }

    public static int getApiLevel() {
        return apiLevel;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static CameraKit getInstance(Context object) {
        Class<CameraKit> clazz = CameraKit.class;
        synchronized (clazz) {
            boolean bl2;
            CameraKit cameraKit = null;
            if (object == null) {
                return null;
            }
            Object object2 = instance;
            if (object2 != null && (bl2 = isGetInstanceSuccessed)) {
                return object2;
            }
            instance = null;
            int n10 = CameraKit.isKitRuntimeAvailable(object);
            if (n10 != 0 && (n10 = CameraKit.isKitHasPermission(object)) != 0) {
                block9: {
                    boolean bl3;
                    try {
                        String string2;
                        String string3;
                        object2 = CameraKit.getVersionInfo(object);
                        if (object2 == null || !(bl2 = ((VersionInfo)object2).isAllCompatible()) || (bl2 = (string3 = BLACKLIST_VERSION_NAME).equals(string2 = CameraKit.getKitVersion(object)))) break block9;
                        apiLevel = n10 = ((VersionInfo)object2).getApiLevel();
                    }
                    catch (NoSuchMethodError noSuchMethodError) {
                        String string4 = TAG;
                        object2 = "this version camerakit does not contain VersionInfoInterface";
                        Log.w((String)string4, (String)object2);
                        return null;
                    }
                    object2 = new ModeManager(object);
                    instance = cameraKit = new CameraKit((ModeManager)object2);
                    isGetInstanceSuccessed = bl3 = true;
                    return cameraKit;
                }
                return null;
            }
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String getKitVersion(Context object) {
        Class<CameraKit> clazz = CameraKit.class;
        synchronized (clazz) {
            if (object == null) {
                object = TAG;
                String string2 = "context is null";
                Log.e((String)object, (String)string2);
                return ERROR_VERSION_NAME;
            }
            boolean bl2 = CameraKit.isKitRuntimeAvailable((Context)object);
            if (!bl2) {
                return ERROR_VERSION_NAME;
            }
            String string3 = ERROR_VERSION_NAME;
            try {
                boolean bl3;
                object = ModeManager.getVersion((Context)object);
                if (object != null && (bl3 = object.isDeviceCompatible())) {
                    string3 = object.getVersionName();
                    object = TAG;
                    CharSequence charSequence = new StringBuilder();
                    String string4 = "KitVersion :";
                    charSequence.append(string4);
                    charSequence.append(string3);
                    charSequence = charSequence.toString();
                    Log.i((String)object, (String)charSequence);
                }
            }
            catch (NoSuchMethodError noSuchMethodError) {
                object = TAG;
                CharSequence charSequence = new StringBuilder();
                String string5 = "KitModle :";
                charSequence.append(string5);
                string5 = Build.MODEL;
                charSequence.append(string5);
                charSequence = charSequence.toString();
                Log.i((String)object, (String)charSequence);
                object = OLD_SUPPORT_PRODUCTS;
                int n10 = ((Object)object).length;
                string5 = null;
                for (int i10 = 0; i10 < n10; ++i10) {
                    String string6 = Build.MODEL;
                    Object object2 = object[i10];
                    boolean bl4 = string6.contains((CharSequence)object2);
                    if (!bl4) continue;
                    object = TAG;
                    string3 = "KitVersion :1.0.0";
                    Log.i((String)object, (String)string3);
                    return OLD_VERSION_NAME;
                }
            }
            return string3;
        }
    }

    private static VersionInfo getVersionInfo(Context context) {
        if ((context = ModeManager.getVersion((Context)context)) != null) {
            VersionInfo versionInfo = new VersionInfo((VersionInfoInterface)context);
            return versionInfo;
        }
        return null;
    }

    private static boolean isKitHasPermission(Context context) {
        for (String string2 : PERMISSIONS_ARRAY) {
            int n10;
            int n11 = Process.myPid();
            int n12 = context.checkPermission(string2, n11, n10 = Process.myUid());
            if (n12 == 0) continue;
            return false;
        }
        return true;
    }

    private static boolean isKitRuntimeAvailable(Context context) {
        boolean bl2;
        boolean bl3 = VersionInfo.isKitRuntimeAvailable(context);
        if (bl3 == (bl2 = true)) {
            return bl2;
        }
        return false;
    }

    public void changeMode(Mode mode, int n10, ModeStateCallback object) {
        Objects.requireNonNull(mode, "Error in mode implementation!");
        Objects.requireNonNull(object, "Mode callback should not be null!");
        ModeManager modeManager = manager;
        mode = mode.getModeImpl();
        object = ModeStateCallback.obtain(object);
        modeManager.changeMode((ModeInterface)mode, n10, (com.huawei.camerakit.api.ModeStateCallback)object);
    }

    public void createMode(String string2, int n10, ModeStateCallback object, Handler handler) {
        Objects.requireNonNull(string2, "Camera id should not be null!");
        Objects.requireNonNull(object, "Mode callback should not be null!");
        Objects.requireNonNull(handler, "Mode callback handler should not be null!");
        ModeManager modeManager = manager;
        object = ModeStateCallback.obtain(object);
        modeManager.createMode(string2, n10, (com.huawei.camerakit.api.ModeStateCallback)object, handler);
    }

    public String[] getCameraIdList() {
        return manager.getCameraIdList();
    }

    public CameraInfo getCameraInfo(String string2) {
        Object object = manager;
        if ((string2 = object.getCameraInfo(string2)) != null) {
            object = new CameraInfo((CameraInfoInterface)string2);
            return object;
        }
        return null;
    }

    public ModeCharacteristics getModeCharacteristics(String string2, int n10) {
        ModeManager modeManager = manager;
        if ((string2 = modeManager.getModeCharacteristics(string2, n10)) != null) {
            ModeCharacteristics modeCharacteristics = new ModeCharacteristics((ModeCharacteristicsInterface)string2);
            return modeCharacteristics;
        }
        return null;
    }

    public int[] getSupportedModes(String string2) {
        return manager.getSupportedModes(string2);
    }

    public String getVersionName() {
        VersionInfoInterface versionInfoInterface = manager.getVersionInfo();
        if (versionInfoInterface != null) {
            return versionInfoInterface.getVersionName();
        }
        return null;
    }

    public void registerCameraDeviceCallback(CameraDeviceCallback object, Handler handler) {
        Objects.requireNonNull(object, "CameraDeviceCallback should not be null!!");
        ModeManager modeManager = manager;
        object = CameraDeviceCallback.obtain(object);
        modeManager.registerCameraCallback((com.huawei.camerakit.api.CameraDeviceCallback)object, handler);
    }

    public void unregisterCameraDeviceCallback(CameraDeviceCallback cameraDeviceCallback) {
        Objects.requireNonNull(cameraDeviceCallback, "CameraDeviceCallback should not be null!!");
        CameraDeviceCallback$CameraDeviceCallbackWrapper cameraDeviceCallback$CameraDeviceCallbackWrapper = CameraDeviceCallback.query(cameraDeviceCallback);
        if (cameraDeviceCallback$CameraDeviceCallbackWrapper != null) {
            ModeManager modeManager = manager;
            modeManager.unregisterCameraCallback((com.huawei.camerakit.api.CameraDeviceCallback)cameraDeviceCallback$CameraDeviceCallbackWrapper);
            CameraDeviceCallback.release(cameraDeviceCallback);
        }
    }
}

