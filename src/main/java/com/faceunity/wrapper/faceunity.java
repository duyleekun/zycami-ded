/*
 * Decompiled with CFR 0.151.
 */
package com.faceunity.wrapper;

import com.faceunity.wrapper.faceunity$AvatarInfo;
import com.faceunity.wrapper.faceunity$RotatedImage;
import com.faceunity.wrapper.faceunity$SplitViewInfo;

public class faceunity {
    public static final int FUAITYPE_BACKGROUNDSEGMENTATION = 2;
    public static final int FUAITYPE_BACKGROUNDSEGMENTATION_GREEN = 512;
    public static final int FUAITYPE_DDE = 1;
    public static final int FUAITYPE_FACELANDMARKS209 = 64;
    public static final int FUAITYPE_FACELANDMARKS239 = 128;
    public static final int FUAITYPE_FACELANDMARKS75 = 32;
    public static final int FUAITYPE_FACEPROCESSOR = 1024;
    public static final int FUAITYPE_FACEPROCESSOR_FACECAPTURE = 2048;
    public static final int FUAITYPE_FACEPROCESSOR_FACECAPTURE_TONGUETRACKING = 4096;
    public static final int FUAITYPE_FACEPROCESSOR_HAIRSEGMENTATION = 8192;
    public static final int FUAITYPE_FACEPROCESSOR_HEADSEGMENTATION = 16384;
    public static final int FUAITYPE_HAIRSEGMENTATION = 4;
    public static final int FUAITYPE_HANDGESTURE = 8;
    public static final int FUAITYPE_HUMANPOSE2D = 256;
    public static final int FUAITYPE_HUMAN_PROCESSOR = 32768;
    public static final int FUAITYPE_HUMAN_PROCESSOR_2D_DANCE = 262144;
    public static final int FUAITYPE_HUMAN_PROCESSOR_2D_SELFIE = 131072;
    public static final int FUAITYPE_HUMAN_PROCESSOR_3D_DANCE = 0x100000;
    public static final int FUAITYPE_HUMAN_PROCESSOR_3D_SELFIE = 524288;
    public static final int FUAITYPE_HUMAN_PROCESSOR_DETECT = 65536;
    public static final int FUAITYPE_HUMAN_PROCESSOR_SEGMENTATION = 0x200000;
    public static final int FUAITYPE_TONGUETRACKING = 16;
    public static final int FU_ADM_FLAG_ENABLE_READBACK = 2;
    public static final int FU_ADM_FLAG_EXTERNAL_OES_TEXTURE = 1;
    public static final int FU_ADM_FLAG_FLIP_X = 32;
    public static final int FU_ADM_FLAG_FLIP_Y = 64;
    public static final int FU_ADM_FLAG_I420_BUFFER = 16;
    public static final int FU_ADM_FLAG_I420_TEXTURE = 8;
    public static final int FU_ADM_FLAG_NV21_TEXTURE = 4;
    public static final int FU_ADM_FLAG_RGBA_BUFFER = 128;
    public static final int FU_ADM_FLAG_TEXTURE_AND_READBACK_BUFFER_OPPOSITE_X = 256;
    public static final int FU_ADM_FLAG_TEXTURE_AND_READBACK_BUFFER_OPPOSITE_Y = 512;
    public static final int FU_ADM_FLAG_TEXTURE_AND_READBACK_BUFFER_ROTATE_180 = 2048;
    public static final int FU_ADM_FLAG_TEXTURE_AND_READBACK_BUFFER_ROTATE_270 = 4096;
    public static final int FU_ADM_FLAG_TEXTURE_AND_READBACK_BUFFER_ROTATE_90 = 1024;
    public static final int FU_ADM_FLAG_TEXTURE_ROTATE_180 = 16384;
    public static final int FU_ADM_FLAG_TEXTURE_ROTATE_270 = 32768;
    public static final int FU_ADM_FLAG_TEXTURE_ROTATE_90 = 8192;
    public static final int FU_FORMAT_GL_CURRENT_FRAMEBUFFER = 3;
    public static final int FU_FORMAT_I420_BUFFER = 13;
    public static final int FU_FORMAT_NV12_BUFFER = 8;
    public static final int FU_FORMAT_NV21_BUFFER = 2;
    public static final int FU_FORMAT_RGBA_BUFFER = 4;
    public static final int FU_FORMAT_RGBA_TEXTURE = 1;
    public static final int FU_NOCLEAR_CURRENT_FRAMEBUFFER = 65536;
    public static final int FU_ROTATION_MODE_0 = 0;
    public static final int FU_ROTATION_MODE_180 = 2;
    public static final int FU_ROTATION_MODE_270 = 3;
    public static final int FU_ROTATION_MODE_90 = 1;

    static {
        System.loadLibrary("CNamaSDK");
    }

    public static native long fu3DBodyTrackerCreate(byte[] var0);

    public static native void fu3DBodyTrackerDestroy(long var0);

    public static native int fu3DBodyTrackerRun(long var0, int var2, byte[] var3, int var4, int var5, int var6, int var7);

    public static native int fuAuthCountWithAPIName(String var0);

    public static native int fuAvatarBindItems(int var0, int[] var1, int[] var2);

    public static native int fuAvatarToCurrentFBO(float[] var0, float[] var1, float[] var2, float[] var3, float[] var4, int var5, int var6, int var7, int var8, int[] var9, int var10, int var11);

    public static native int fuAvatarToImage(float[] var0, float[] var1, float[] var2, float[] var3, int var4, int var5, int var6, int var7, int[] var8, int var9, int var10, int var11, byte[] var12);

    public static native int fuAvatarToImage(float[] var0, float[] var1, float[] var2, float[] var3, float[] var4, int var5, int var6, int var7, int var8, int[] var9, int var10, int var11, int var12, byte[] var13);

    public static native int fuAvatarToTexture(float[] var0, float[] var1, float[] var2, float[] var3, int var4, int var5, int var6, int var7, int[] var8, int var9);

    public static native int fuAvatarToTexture(float[] var0, float[] var1, float[] var2, float[] var3, float[] var4, int var5, int var6, int var7, int var8, int[] var9, int var10);

    public static native int fuAvatarToTextureWithTrans(float[] var0, float[] var1, float[] var2, float[] var3, float[] var4, int var5, int var6, int var7, int var8, int[] var9, int var10);

    public static native int fuAvatarUnbindItems(int var0, int[] var1);

    public static native int fuBeautifyImage(int var0, int var1, int var2, int var3, int var4, int[] var5);

    public static native int fuBindItems(int var0, int[] var1);

    public static native int fuCheckDebugItem(byte[] var0);

    public static native int fuClearReadbackRelated();

    public static native void fuCreateEGLContext();

    public static native int fuCreateItemFromPackage(byte[] var0);

    public static native int fuCreateTexForItem(int var0, String var1, byte[] var2, int var3, int var4);

    public static native int fuDeleteTexForItem(int var0, String var1);

    public static native void fuDestroyAllItems();

    public static native void fuDestroyItem(int var0);

    public static native void fuDestroyLibData();

    public static native void fuDisableBoostWithEGLImage();

    public static native void fuDone();

    public static native void fuDualInputToFBO(byte[] var0, int var1, int var2, int var3, int var4, int var5, int[] var6, int var7);

    public static native int fuDualInputToTexture(long var0, int var2, int var3, int var4, int var5, int var6, int[] var7);

    public static native int fuDualInputToTexture(byte[] var0, int var1, int var2, int var3, int var4, int var5, int[] var6);

    public static native int fuDualInputToTexture(byte[] var0, int var1, int var2, int var3, int var4, int var5, int[] var6, int var7, int var8, byte[] var9);

    public static native int fuDualInputToTexture(byte[] var0, int var1, int var2, int var3, int var4, int var5, int[] var6, int var7, int var8, byte[] var9, int var10, int var11);

    public static native int fuDualInputToTextureMasked(byte[] var0, int var1, int var2, int var3, int var4, int var5, int[] var6, int[] var7);

    public static native long fuFaceCaptureCreate(byte[] var0);

    public static native void fuFaceCaptureDestory(long var0);

    public static native int fuFaceCaptureGetResultExpression(long var0, int var2, float[] var3);

    public static native int fuFaceCaptureGetResultEyesRotation(long var0, int var2, float[] var3);

    public static native int fuFaceCaptureGetResultFaceBbox(long var0, int var2, float[] var3);

    public static native int fuFaceCaptureGetResultFaceID(long var0, int var2);

    public static native int fuFaceCaptureGetResultFaceNum(long var0);

    public static native float fuFaceCaptureGetResultFaceScore(long var0, int var2);

    public static native float fuFaceCaptureGetResultFocalLength(long var0);

    public static native int fuFaceCaptureGetResultIdentity(long var0, int var2, float[] var3);

    public static native int fuFaceCaptureGetResultIsFace(long var0, int var2);

    public static native int fuFaceCaptureGetResultLandmarks(long var0, int var2, float[] var3);

    public static native int fuFaceCaptureGetResultRotation(long var0, int var2, float[] var3);

    public static native int fuFaceCaptureGetResultTongueClass(long var0, int var2);

    public static native int fuFaceCaptureGetResultTongueExp(long var0, int var2, float[] var3);

    public static native float fuFaceCaptureGetResultTongueScore(long var0, int var2);

    public static native int fuFaceCaptureGetResultTranslation(long var0, int var2, float[] var3);

    public static native int fuFaceCaptureProcessFrame(long var0, byte[] var2, int var3, int var4, int var5, int var6);

    public static native void fuFaceCaptureReset(long var0);

    public static native void fuFaceCaptureSetBBOX(long var0, int var2, int var3, int var4, int var5);

    public static native void fuFaceCaptureSetScene(long var0, int var2);

    public static native int fuFaceProcessorGetResultHairMask(int var0, float[] var1);

    public static native int fuFaceProcessorGetResultHairMaskHeight(int var0);

    public static native int fuFaceProcessorGetResultHairMaskWidth(int var0);

    public static native int fuFaceProcessorGetResultHeadMask(int var0, float[] var1);

    public static native int fuFaceProcessorGetResultHeadMaskHeight(int var0);

    public static native int fuFaceProcessorGetResultHeadMaskWidth(int var0);

    public static native void fuFaceProcessorSetMinFaceRatio(float var0);

    public static native int fuGetCurrentRotationMode();

    public static native int fuGetFaceIdentifier(int var0);

    public static native int fuGetFaceInfo(int var0, String var1, float[] var2);

    public static native int fuGetFaceInfo(int var0, String var1, int[] var2);

    public static native float fuGetFaceProcessorFov();

    public static native int fuGetLogLevel();

    public static native int fuGetModuleCode(int var0);

    public static native int fuGetSystemError();

    public static native String fuGetSystemErrorString(int var0);

    public static native String fuGetVersion();

    public static native int fuHandDetectorGetResultGestureType(int var0);

    public static native int fuHandDetectorGetResultHandRect(int var0, float[] var1);

    public static native float fuHandDetectorGetResultHandScore(int var0);

    public static native int fuHandDetectorGetResultNumHands();

    public static native int fuHasFace();

    public static native void fuHexagonInitWithPath(String var0);

    public static native void fuHexagonTearDown();

    public static native float fuHumanActionMatchDistance(float[] var0, float[] var1);

    public static native float fuHumanProcessorGetFov();

    public static native int fuHumanProcessorGetNumResults();

    public static native float fuHumanProcessorGetResultActionScore(int var0);

    public static native int fuHumanProcessorGetResultActionType(int var0);

    public static native int fuHumanProcessorGetResultHumanMask(int var0, float[] var1);

    public static native int fuHumanProcessorGetResultHumanMaskHeight(int var0);

    public static native int fuHumanProcessorGetResultHumanMaskWidth(int var0);

    public static native int fuHumanProcessorGetResultJoint2ds(int var0, float[] var1);

    public static native int fuHumanProcessorGetResultJoint3ds(int var0, float[] var1);

    public static native void fuHumanProcessorGetResultModelMatrix(int var0, float[] var1);

    public static native int fuHumanProcessorGetResultRect(int var0, float[] var1);

    public static native int fuHumanProcessorGetResultTrackId(int var0);

    public static native void fuHumanProcessorGetResultTransformArray(int var0, float[] var1);

    public static native void fuHumanProcessorReset();

    public static native void fuHumanProcessorSetBonemap(byte[] var0);

    public static native void fuHumanProcessorSetFov(float var0);

    public static native void fuHumanProcessorSetMaxHumans(int var0);

    public static native int fuIsAIModelLoaded(int var0);

    public static native int fuIsLibraryInit();

    public static native int fuIsTracking();

    public static native double fuItemGetParam(int var0, String var1);

    public static native String fuItemGetParamString(int var0, String var1);

    public static native double[] fuItemGetParamdv(int var0, String var1);

    public static native float[] fuItemGetParamfv(int var0, String var1);

    public static native byte[] fuItemGetParamu8v(int var0, String var1);

    public static native int fuItemSetParam(int var0, String var1, double var2);

    public static native int fuItemSetParam(int var0, String var1, String var2);

    public static native int fuItemSetParam(int var0, String var1, double[] var2);

    public static native int fuItemSetParamu64(int var0, String var1, long var2);

    public static native int fuItemSetParamu8v(int var0, String var1, byte[] var2, int var3);

    public static native int fuLoadAIModelFromPackage(byte[] var0, int var1);

    public static native int fuLoadTongueModel(byte[] var0);

    public static native void fuOnCameraChange();

    public static native void fuOnDeviceLost();

    public static native void fuOnDeviceLostSafe();

    public static native int fuOpenFileLog(String var0, int var1, int var2);

    public static native int fuProfileGetNumTimers();

    public static native long fuProfileGetTimerAverage(int var0);

    public static native long fuProfileGetTimerCount(int var0);

    public static native long fuProfileGetTimerMax(int var0);

    public static native long fuProfileGetTimerMin(int var0);

    public static native String fuProfileGetTimerName(int var0);

    public static native int fuProfileResetAllTimers();

    public static native void fuReadPixelsRGBA2NV21(int var0, int var1, int var2, int var3, byte[] var4);

    public static native int fuReleaseAIModel(int var0);

    public static native void fuReleaseEGLContext();

    public static native int fuRenderBundles(faceunity$AvatarInfo var0, int var1, int var2, int var3, int var4, int[] var5);

    public static native int fuRenderBundlesSplitView(faceunity$AvatarInfo var0, int var1, int var2, int var3, int var4, int[] var5, faceunity$SplitViewInfo var6);

    public static native int fuRenderBundlesToCurrentFBO(faceunity$AvatarInfo var0, int var1, int var2, int var3, int var4, int[] var5, int var6);

    public static native int fuRenderBundlesWithCamera(byte[] var0, int var1, int var2, int var3, int var4, int var5, int[] var6);

    public static native int fuRenderBundlesWithCamera(byte[] var0, int var1, int var2, int var3, int[] var4);

    public static native int fuRenderI420ImageToTexture(byte[] var0, int var1, int var2, int var3, int[] var4);

    public static native int fuRenderNV21ImageToTexture(byte[] var0, int var1, int var2, int var3, int[] var4);

    public static native int fuRenderToI420Image(long var0, int var2, int var3, int var4, int[] var5, int var6);

    public static native int fuRenderToI420Image(byte[] var0, int var1, int var2, int var3, int[] var4);

    public static native int fuRenderToI420Image(byte[] var0, int var1, int var2, int var3, int[] var4, int var5);

    public static native int fuRenderToI420Image(byte[] var0, int var1, int var2, int var3, int[] var4, int var5, int var6, int var7, byte[] var8);

    public static native int fuRenderToI420Image(byte[] var0, int var1, int var2, int var3, int[] var4, int var5, int var6, int var7, byte[] var8, int var9, int var10);

    public static native int fuRenderToI420ImageMasked(byte[] var0, int var1, int var2, int var3, int[] var4, int[] var5);

    public static native int fuRenderToNV21Image(long var0, int var2, int var3, int var4, int[] var5, int var6);

    public static native int fuRenderToNV21Image(byte[] var0, int var1, int var2, int var3, int[] var4);

    public static native int fuRenderToNV21Image(byte[] var0, int var1, int var2, int var3, int[] var4, int var5);

    public static native int fuRenderToNV21Image(byte[] var0, int var1, int var2, int var3, int[] var4, int var5, int var6, int var7, byte[] var8);

    public static native int fuRenderToNV21Image(byte[] var0, int var1, int var2, int var3, int[] var4, int var5, int var6, int var7, byte[] var8, int var9, int var10);

    public static native int fuRenderToNV21ImageMasked(byte[] var0, int var1, int var2, int var3, int[] var4, int[] var5);

    public static native int fuRenderToRgbaImage(long var0, int var2, int var3, int var4, int[] var5, int var6);

    public static native int fuRenderToRgbaImage(byte[] var0, int var1, int var2, int var3, int[] var4);

    public static native int fuRenderToRgbaImage(byte[] var0, int var1, int var2, int var3, int[] var4, int var5);

    public static native int fuRenderToRgbaImage(byte[] var0, int var1, int var2, int var3, int[] var4, int var5, int var6, int var7, byte[] var8);

    public static native int fuRenderToRgbaImage(byte[] var0, int var1, int var2, int var3, int[] var4, int var5, int var6, int var7, byte[] var8, int var9, int var10);

    public static native int fuRenderToTexture(int var0, int var1, int var2, int var3, int[] var4, int var5);

    public static native int fuRenderToTexture(int var0, int var1, int var2, int var3, int[] var4, int var5, byte[] var6, int var7, int var8);

    public static native int fuRenderToTexture(int var0, int var1, int var2, int var3, int[] var4, int var5, byte[] var6, int var7, int var8, int var9, int var10);

    public static native int fuRenderToYUVImage(long var0, long var2, long var4, int var6, int var7, int var8, int var9, int var10, int var11, int[] var12);

    public static native int fuRenderToYUVImage(byte[] var0, byte[] var1, byte[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int[] var9);

    public static native int fuRenderToYUVImage(byte[] var0, byte[] var1, byte[] var2, int var3, int var4, int var5, int var6, int var7, int var8, int[] var9, int var10);

    public static native int fuRotateImage(faceunity$RotatedImage var0, byte[] var1, int var2, int var3, int var4, int var5, int var6, int var7);

    public static native int fuSetAsyncTrackFace(int var0);

    public static native int fuSetCropFreePixel(int var0, int var1, int var2, int var3);

    public static native int fuSetCropState(int var0);

    public static native void fuSetDefaultRotationMode(int var0);

    public static native void fuSetDeviceOrientation(int var0);

    public static native int fuSetFaceDetParam(String var0, float var1);

    public static native int fuSetFaceProcessorDetectMode(int var0);

    public static native int fuSetFaceProcessorFov(float var0);

    public static native int fuSetFaceTrackParam(String var0, float var1);

    public static native void fuSetInputCameraMatrix(int var0, int var1, int var2);

    public static native int fuSetLoadQuality(int var0);

    public static native int fuSetLogLevel(int var0);

    public static native int fuSetMaxFaces(int var0);

    public static native int fuSetMultiSamples(int var0);

    public static native void fuSetOutputResolution(int var0, int var1);

    public static native void fuSetQualityTradeoff(float var0);

    public static native void fuSetStrictTracking(int var0);

    public static native int fuSetTongueTracking(int var0);

    public static native void fuSetTrackFaceAIType(int var0);

    public static native int fuSetUseTexAsync(int var0);

    public static native int fuSetup(byte[] var0, byte[] var1);

    public static native int fuSetup(byte[] var0, byte[] var1, byte[] var2);

    public static native byte[] fuSetupLocal(byte[] var0, byte[] var1, byte[] var2);

    public static native int fuTrackFace(byte[] var0, int var1, int var2, int var3);

    public static native int fuTrackFaceWithTongue(byte[] var0, int var1, int var2, int var3);

    public static native int fuUnBindItems(int var0, int[] var1);

    public static native int fuUnbindAllItems(int var0);
}

