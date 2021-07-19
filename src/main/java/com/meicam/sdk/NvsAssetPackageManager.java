/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsAssetPackageManager$ARSceneBeautyPreset;
import com.meicam.sdk.NvsAssetPackageManager$ARSceneShapeBeautificationPreset;
import com.meicam.sdk.NvsAssetPackageManager$AssetPackageManagerCallback;
import com.meicam.sdk.NvsAssetPackageManager$GenerateTemplateCallback;
import com.meicam.sdk.NvsUtils;
import java.util.List;

public class NvsAssetPackageManager {
    public static final int ASSET_PACKAGE_ASPECT_RATIO_16v9 = 1;
    public static final int ASSET_PACKAGE_ASPECT_RATIO_18v9 = 32;
    public static final int ASSET_PACKAGE_ASPECT_RATIO_1v1 = 2;
    public static final int ASSET_PACKAGE_ASPECT_RATIO_3v4 = 16;
    public static final int ASSET_PACKAGE_ASPECT_RATIO_4v3 = 8;
    public static final int ASSET_PACKAGE_ASPECT_RATIO_9v16 = 4;
    public static final int ASSET_PACKAGE_ASPECT_RATIO_9v18 = 64;
    public static final int ASSET_PACKAGE_MANAGER_ERROR_ALREADY_INSTALLED = 2;
    public static final int ASSET_PACKAGE_MANAGER_ERROR_ASSET_TYPE = 8;
    public static final int ASSET_PACKAGE_MANAGER_ERROR_DECOMPRESSION = 6;
    public static final int ASSET_PACKAGE_MANAGER_ERROR_IMPROPER_STATUS = 5;
    public static final int ASSET_PACKAGE_MANAGER_ERROR_INVALID_PACKAGE = 7;
    public static final int ASSET_PACKAGE_MANAGER_ERROR_IO = 13;
    public static final int ASSET_PACKAGE_MANAGER_ERROR_META_CONTENT = 10;
    public static final int ASSET_PACKAGE_MANAGER_ERROR_NAME = 1;
    public static final int ASSET_PACKAGE_MANAGER_ERROR_NOT_INSTALLED = 4;
    public static final int ASSET_PACKAGE_MANAGER_ERROR_NO_ERROR = 0;
    public static final int ASSET_PACKAGE_MANAGER_ERROR_PERMISSION = 9;
    public static final int ASSET_PACKAGE_MANAGER_ERROR_RESOURCE = 14;
    public static final int ASSET_PACKAGE_MANAGER_ERROR_SDK_VERSION = 11;
    public static final int ASSET_PACKAGE_MANAGER_ERROR_UPGRADE_VERSION = 12;
    public static final int ASSET_PACKAGE_MANAGER_ERROR_WORKING_INPROGRESS = 3;
    public static final int ASSET_PACKAGE_STATUS_INSTALLING = 1;
    public static final int ASSET_PACKAGE_STATUS_NOTINSTALLED = 0;
    public static final int ASSET_PACKAGE_STATUS_READY = 2;
    public static final int ASSET_PACKAGE_STATUS_UPGRADING = 3;
    public static final int ASSET_PACKAGE_TYPE_ANIMATEDSTICKER = 3;
    public static final int ASSET_PACKAGE_TYPE_ANIMATEDSTICKER_ANIMATION = 16;
    public static final int ASSET_PACKAGE_TYPE_ANIMATEDSTICKER_IN_ANIMATION = 17;
    public static final int ASSET_PACKAGE_TYPE_ANIMATEDSTICKER_OUT_ANIMATION = 18;
    public static final int ASSET_PACKAGE_TYPE_ARSCENE = 6;
    public static final int ASSET_PACKAGE_TYPE_AVATAR_MATERIAL = 15;
    public static final int ASSET_PACKAGE_TYPE_AVATAR_MODEL = 14;
    public static final int ASSET_PACKAGE_TYPE_CAPTIONSTYLE = 2;
    public static final int ASSET_PACKAGE_TYPE_CAPTION_ANIMATION = 10;
    public static final int ASSET_PACKAGE_TYPE_CAPTION_CONTEXT = 8;
    public static final int ASSET_PACKAGE_TYPE_CAPTION_IN_ANIMATION = 11;
    public static final int ASSET_PACKAGE_TYPE_CAPTION_OUT_ANIMATION = 12;
    public static final int ASSET_PACKAGE_TYPE_CAPTION_RENDERER = 9;
    public static final int ASSET_PACKAGE_TYPE_CAPTURESCENE = 5;
    public static final int ASSET_PACKAGE_TYPE_COMPOUND_CAPTION = 7;
    public static final int ASSET_PACKAGE_TYPE_MAKEUP = 19;
    public static final int ASSET_PACKAGE_TYPE_TEMPLATE = 13;
    public static final int ASSET_PACKAGE_TYPE_THEME = 4;
    public static final int ASSET_PACKAGE_TYPE_VIDEOFX = 0;
    public static final int ASSET_PACKAGE_TYPE_VIDEOTRANSITION = 1;
    public static final int TEIMPLATE_FOOTAGE_TYPE_AUDIO = 3;
    public static final int TEIMPLATE_FOOTAGE_TYPE_FREEZE_FRAME = 4;
    public static final int TEIMPLATE_FOOTAGE_TYPE_IMAGE = 2;
    public static final int TEIMPLATE_FOOTAGE_TYPE_VIDEO = 1;
    public static final int TEIMPLATE_FOOTAGE_TYPE_VIDEO_IMAGE;
    public NvsAssetPackageManager$AssetPackageManagerCallback m_callback;
    public NvsAssetPackageManager$GenerateTemplateCallback m_generateTemplateCallback;
    public long m_internalCallbackObject;
    public long m_internalObject;
    public long m_internalTemplateCallbackObject;

    public NvsAssetPackageManager(boolean bl2) {
        long l10;
        this.m_internalObject = l10 = 0L;
        this.m_internalCallbackObject = l10;
        this.m_internalTemplateCallbackObject = l10;
        this.m_callback = null;
        this.m_generateTemplateCallback = null;
        this.nativeSetInternalCallbackObject(bl2);
        this.nativeSetTemplateInternalCallbackObject();
    }

    private native boolean nativeChangeTemplateAspectRatio(long var1, String var3, int var4);

    private native String nativeDecodeFile(long var1, String var3, String var4, boolean var5);

    private native NvsAssetPackageManager$ARSceneBeautyPreset nativeGetARSceneAssetPackageBeautyPreset(long var1, String var3);

    private native String nativeGetARSceneAssetPackagePrompt(long var1, String var3);

    private native NvsAssetPackageManager$ARSceneShapeBeautificationPreset nativeGetARSceneAssetPackageShapeBeautificationPreset(long var1, String var3);

    private native String nativeGetAssetPackageIdFromAssetPackageFilePath(long var1, String var3);

    private native List nativeGetAssetPackageListOfType(long var1, int var3);

    private native int nativeGetAssetPackageStatus(long var1, String var3, int var4);

    private native int nativeGetAssetPackageSupportedAspectRatio(long var1, String var3, int var4);

    private native int nativeGetAssetPackageVersion(long var1, String var3, int var4);

    private native int nativeGetAssetPackageVersionFromAssetPackageFilePath(long var1, String var3);

    private native List nativeGetTemplateCaptions(long var1, String var3);

    private native List nativeGetTemplateCompoundCaptions(long var1, String var3);

    private native int nativeGetTemplateCurrentAspectRatio(long var1, String var3);

    private native int nativeGetTemplateDefaultAspectRatio(long var1, String var3);

    private native List nativeGetTemplateFootages(long var1, String var3);

    private native String nativeGetVideoFxAssetPackageDescription(long var1, String var3);

    private native int nativeInstallAssetPackage(long var1, String var3, String var4, int var5, boolean var6, StringBuilder var7);

    private native boolean nativeIsCustomAnimatedSticker(long var1, String var3);

    private native boolean nativeIsParticleFX(long var1, String var3);

    private native boolean nativeIsThemeContainMusic(long var1, String var3);

    private native void nativeSetCallbackInterface(NvsAssetPackageManager$AssetPackageManagerCallback var1);

    private native void nativeSetInternalCallbackObject(boolean var1);

    private native void nativeSetTemplateCallbackInterface(NvsAssetPackageManager$GenerateTemplateCallback var1);

    private native void nativeSetTemplateInternalCallbackObject();

    private native int nativeUninstallAssetPackage(long var1, String var3, int var4);

    private native int nativeUpgradeAssetPackage(long var1, String var3, String var4, int var5, boolean var6, StringBuilder var7);

    public boolean changeTemplateAspectRatio(String string2, int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeChangeTemplateAspectRatio(l10, string2, n10);
    }

    public String decodeFile(String string2, String string3, boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeDecodeFile(l10, string2, string3, bl2);
    }

    public NvsAssetPackageManager$ARSceneBeautyPreset getARSceneAssetPackageBeautyPreset(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetARSceneAssetPackageBeautyPreset(l10, string2);
    }

    public String getARSceneAssetPackagePrompt(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetARSceneAssetPackagePrompt(l10, string2);
    }

    public NvsAssetPackageManager$ARSceneShapeBeautificationPreset getARSceneAssetPackageShapeBeautificationPreset(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetARSceneAssetPackageShapeBeautificationPreset(l10, string2);
    }

    public String getAssetPackageIdFromAssetPackageFilePath(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetAssetPackageIdFromAssetPackageFilePath(l10, string2);
    }

    public List getAssetPackageListOfType(int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetAssetPackageListOfType(l10, n10);
    }

    public int getAssetPackageStatus(String string2, int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetAssetPackageStatus(l10, string2, n10);
    }

    public int getAssetPackageSupportedAspectRatio(String string2, int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetAssetPackageSupportedAspectRatio(l10, string2, n10);
    }

    public int getAssetPackageVersion(String string2, int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetAssetPackageVersion(l10, string2, n10);
    }

    public int getAssetPackageVersionFromAssetPackageFilePath(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetAssetPackageVersionFromAssetPackageFilePath(l10, string2);
    }

    public List getTemplateCaptions(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetTemplateCaptions(l10, string2);
    }

    public List getTemplateCompoundCaptions(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetTemplateCompoundCaptions(l10, string2);
    }

    public int getTemplateCurrentAspectRatio(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetTemplateCurrentAspectRatio(l10, string2);
    }

    public int getTemplateDefaultAspectRatio(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetTemplateDefaultAspectRatio(l10, string2);
    }

    public List getTemplateFootages(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetTemplateFootages(l10, string2);
    }

    public String getVideoFxAssetPackageDescription(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeGetVideoFxAssetPackageDescription(l10, string2);
    }

    public int installAssetPackage(String string2, String string3, int n10, boolean bl2, StringBuilder stringBuilder) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeInstallAssetPackage(l10, string2, string3, n10, bl2, stringBuilder);
    }

    public boolean isCustomAnimatedSticker(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeIsCustomAnimatedSticker(l10, string2);
    }

    public boolean isParticleFX(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeIsParticleFX(l10, string2);
    }

    public boolean isThemeContainMusic(String string2) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeIsThemeContainMusic(l10, string2);
    }

    public void setCallbackInterface(NvsAssetPackageManager$AssetPackageManagerCallback nvsAssetPackageManager$AssetPackageManagerCallback) {
        NvsUtils.checkFunctionInMainThread();
        this.m_callback = nvsAssetPackageManager$AssetPackageManagerCallback;
        this.nativeSetCallbackInterface(nvsAssetPackageManager$AssetPackageManagerCallback);
    }

    public void setGenerateTemplateCallbackInterface(NvsAssetPackageManager$GenerateTemplateCallback nvsAssetPackageManager$GenerateTemplateCallback) {
        NvsUtils.checkFunctionInMainThread();
        this.m_generateTemplateCallback = nvsAssetPackageManager$GenerateTemplateCallback;
        this.nativeSetTemplateCallbackInterface(nvsAssetPackageManager$GenerateTemplateCallback);
    }

    public void setInternalObject(long l10) {
        long l11 = this.m_internalObject;
        long l12 = 0L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object != false) {
            object = 0;
            this.setCallbackInterface(null);
        }
        this.m_internalObject = l10;
    }

    public int uninstallAssetPackage(String string2, int n10) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeUninstallAssetPackage(l10, string2, n10);
    }

    public int upgradeAssetPackage(String string2, String string3, int n10, boolean bl2, StringBuilder stringBuilder) {
        NvsUtils.checkFunctionInMainThread();
        long l10 = this.m_internalObject;
        return this.nativeUpgradeAssetPackage(l10, string2, string3, n10, bl2, stringBuilder);
    }
}

