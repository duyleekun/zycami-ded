/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.graphics.Bitmap
 *  android.graphics.Color
 *  android.graphics.Matrix
 *  android.graphics.RectF
 *  android.graphics.SurfaceTexture
 *  android.os.Build$VERSION
 *  android.util.Log
 *  dalvik.system.DexFile
 *  dalvik.system.PathClassLoader
 */
package com.meicam.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.util.Log;
import com.cdv.io.NvAndroidVirtualCameraSurfaceTexture;
import com.meicam.sdk.NvsAVFileInfo;
import com.meicam.sdk.NvsAssetPackageManager;
import com.meicam.sdk.NvsAudioResolution;
import com.meicam.sdk.NvsCaptureAnimatedSticker;
import com.meicam.sdk.NvsCaptureAudioFx;
import com.meicam.sdk.NvsCaptureCaption;
import com.meicam.sdk.NvsCaptureCompoundCaption;
import com.meicam.sdk.NvsCaptureVideoFx;
import com.meicam.sdk.NvsCheckExpirationOnline;
import com.meicam.sdk.NvsColor;
import com.meicam.sdk.NvsCustomVideoFx$Renderer;
import com.meicam.sdk.NvsFxDescription;
import com.meicam.sdk.NvsHumanDetectionHandle;
import com.meicam.sdk.NvsLiveWindow;
import com.meicam.sdk.NvsLiveWindowExt;
import com.meicam.sdk.NvsRational;
import com.meicam.sdk.NvsSize;
import com.meicam.sdk.NvsStatisticsSender;
import com.meicam.sdk.NvsStreamingContext$AudioOutputCallback;
import com.meicam.sdk.NvsStreamingContext$CaptureDeviceCallback;
import com.meicam.sdk.NvsStreamingContext$CaptureDeviceCapability;
import com.meicam.sdk.NvsStreamingContext$CaptureRecordingDurationCallback;
import com.meicam.sdk.NvsStreamingContext$CaptureRecordingFrameReachedCallback;
import com.meicam.sdk.NvsStreamingContext$CaptureRecordingStartedCallback;
import com.meicam.sdk.NvsStreamingContext$CapturedPictureCallback;
import com.meicam.sdk.NvsStreamingContext$CapturedVideoFrameGrabberCallback;
import com.meicam.sdk.NvsStreamingContext$CompileCallback;
import com.meicam.sdk.NvsStreamingContext$CompileCallback2;
import com.meicam.sdk.NvsStreamingContext$CompileCallback3;
import com.meicam.sdk.NvsStreamingContext$CompileFloatProgressCallback;
import com.meicam.sdk.NvsStreamingContext$HardwareErrorCallback;
import com.meicam.sdk.NvsStreamingContext$ImageGrabberCallback;
import com.meicam.sdk.NvsStreamingContext$PlaybackCallback;
import com.meicam.sdk.NvsStreamingContext$PlaybackCallback2;
import com.meicam.sdk.NvsStreamingContext$PlaybackDelayCallback;
import com.meicam.sdk.NvsStreamingContext$PlaybackExceptionCallback;
import com.meicam.sdk.NvsStreamingContext$SdkVersion;
import com.meicam.sdk.NvsStreamingContext$SeekingCallback;
import com.meicam.sdk.NvsStreamingContext$StreamingEngineCallback;
import com.meicam.sdk.NvsStreamingContext$TimelineTimestampCallback;
import com.meicam.sdk.NvsStreamingContext$VerifyLicenseResult;
import com.meicam.sdk.NvsSystemVariableManager;
import com.meicam.sdk.NvsTimeline;
import com.meicam.sdk.NvsUtils;
import com.meicam.sdk.NvsVideoFrameRetriever;
import com.meicam.sdk.NvsVideoKeyFrameRetriever;
import com.meicam.sdk.NvsVideoResolution;
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
import java.util.Hashtable;
import java.util.List;

public class NvsStreamingContext {
    public static final int ASSET_PACKAGE_ASPECT_RATIO_16v9 = 1;
    public static final int ASSET_PACKAGE_ASPECT_RATIO_18v9 = 32;
    public static final int ASSET_PACKAGE_ASPECT_RATIO_1v1 = 2;
    public static final int ASSET_PACKAGE_ASPECT_RATIO_3v4 = 16;
    public static final int ASSET_PACKAGE_ASPECT_RATIO_4v3 = 8;
    public static final int ASSET_PACKAGE_ASPECT_RATIO_9v16 = 4;
    public static final int ASSET_PACKAGE_ASPECT_RATIO_9v18 = 64;
    public static final int AV_FILEINFO_EXTRA_INFO = 1;
    public static final int AV_FILEINFO_EXTRA_NULL = 0;
    public static final int AV_FILEINFO_EXTRA_PIXELFORMAT = 1;
    public static final int AV_FILEINFO_EXTRA_VIDEO_CODEC_ID = 2;
    public static final int BUFFER_IMAGE_ROTATION_0 = 0;
    public static final int BUFFER_IMAGE_ROTATION_180 = 2;
    public static final int BUFFER_IMAGE_ROTATION_270 = 3;
    public static final int BUFFER_IMAGE_ROTATION_90 = 1;
    public static final int CAMERA_FLASH_MODE_AUTO = 4;
    public static final int CAMERA_FLASH_MODE_OFF = 1;
    public static final int CAMERA_FLASH_MODE_ON = 2;
    public static final int CAMERA_FLASH_MODE_TORCH = 8;
    public static final int CAPTURE_DEVICE_ERROR_SERVER_DIED = 2;
    public static final int CAPTURE_DEVICE_ERROR_UNKNOWN = 1;
    public static final int CLEAR_CACHE_FLAG_AVFILE_INFO = 8;
    public static final int CLEAR_CACHE_FLAG_AVFILE_KEYFRAME_INFO = 16;
    public static final int CLEAR_CACHE_FLAG_CAPTION_FONT_INFO = 32;
    public static final int CLEAR_CACHE_FLAG_ICON_ENGINE = 2;
    public static final int CLEAR_CACHE_FLAG_STREAMING_ENGINE = 1;
    public static final int CLEAR_CACHE_FLAG_WAVEFORM_ENGINE = 4;
    public static final String COMPILE_AUDIO_BITRATE = "audio bitrate";
    public static final String COMPILE_AUDIO_ENCODER_NAME = "audio encoder name";
    public static final String COMPILE_BITRATE = "bitrate";
    public static final int COMPILE_BITRATE_GRADE_HIGH = 2;
    public static final int COMPILE_BITRATE_GRADE_LOW = 0;
    public static final int COMPILE_BITRATE_GRADE_MEDIUM = 1;
    public static final String COMPILE_CREATION_TIME = "creation time";
    public static final int COMPILE_ENCODE_PROFILE_BASELINE = 1;
    public static final int COMPILE_ENCODE_PROFILE_HIGH = 3;
    public static final int COMPILE_ENCODE_PROFILE_MAIN = 2;
    public static final int COMPILE_ERROR_TYPE_Cancelation = 1;
    public static final int COMPILE_ERROR_TYPE_NO_ERROR = 0;
    public static final int COMPILE_ERROR_TYPE_VIDEO_DECODING_ERROR = 4;
    public static final int COMPILE_ERROR_TYPE_VIDEO_ENCODER_SETUP_ERROR = 2;
    public static final int COMPILE_ERROR_TYPE_VIDEO_ENCODING_ERROR = 3;
    public static final String COMPILE_FPS = "fps";
    public static final String COMPILE_GOP_SIZE = "gopsize";
    public static final String COMPILE_LOSSLESS_AUDIO = "lossless audio";
    public static final String COMPILE_OPTIMIZE_FOR_NETWORK_USE = "optimize-for-network-use";
    public static final String COMPILE_SOFTWARE_ENCODER_CRF = "software encorder crf";
    public static final String COMPILE_SOFTWARE_ENCODER_CRF_BITRATE_MAX = "software encorder crf bitrate max";
    public static final String COMPILE_SOFTWARE_ENCODER_MODE = "software encorder mode";
    public static final String COMPILE_SOFTWARE_ENCODER_PRESET = "software encorder preset";
    public static final String COMPILE_USE_OPERATING_RATE = "use operating rate";
    public static final String COMPILE_VIDEO_ENCODER_NAME = "video encoder name";
    public static final String COMPILE_VIDEO_ENCODER_PROFILE = "encorder profile";
    public static final String COMPILE_VIDEO_HDR_COLOR_TRANSFER = "encorder color transfer";
    public static final int COMPILE_VIDEO_RESOLUTION_GRADE_1080 = 3;
    public static final int COMPILE_VIDEO_RESOLUTION_GRADE_2160 = 4;
    public static final int COMPILE_VIDEO_RESOLUTION_GRADE_360 = 0;
    public static final int COMPILE_VIDEO_RESOLUTION_GRADE_480 = 1;
    public static final int COMPILE_VIDEO_RESOLUTION_GRADE_720 = 2;
    public static final int COMPILE_VIDEO_RESOLUTION_GRADE_CUSTOM = 256;
    public static final int CREATE_TIMELINE_FLAG_LONGEST_DURATION_CONSIDER_ALL_TRACKS = 1;
    public static final int CREATE_TIMELINE_FLAG_SYANC_AUDIO_VIDEO_TRANS_ON_VIDEO_TRACK = 2;
    public static final int DEBUG_LEVEL_DEBUG = 3;
    public static final int DEBUG_LEVEL_ERROR = 1;
    public static final int DEBUG_LEVEL_NONE = 0;
    public static final int DEBUG_LEVEL_WARNING = 2;
    public static final int HDR_CAPABILITY_FLAG_SUPPORTED_BY_EDITING = 2;
    public static final int HDR_CAPABILITY_FLAG_SUPPORTED_BY_EXPORTER = 4;
    public static final int HDR_CAPABILITY_FLAG_SUPPORTED_BY_IMPORTER = 1;
    public static final int HDR_CAPABILITY_FLAG_SUPPORTED_BY_LIVEWINDOW = 8;
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
    public static final String RECORD_BITRATE = "bitrate";
    public static final String RECORD_GOP_SIZE = "gopsize";
    public static final int STREAMING_CONTEXT_FLAG_ASYNC_ENGINE_STATE = 16;
    public static final int STREAMING_CONTEXT_FLAG_ASYNC_INITIALIZED = 64;
    public static final int STREAMING_CONTEXT_FLAG_COMPACT_MEMORY_MODE = 2;
    public static final int STREAMING_CONTEXT_FLAG_DISABLE_CAPTURE = 2048;
    public static final int STREAMING_CONTEXT_FLAG_ENABLE_HDR_DISPLAY_WHEN_SUPPORTED = 65536;
    public static final int STREAMING_CONTEXT_FLAG_ENABLE_MAX_CACHE_CAPTION_LIMIT = 1024;
    public static final int STREAMING_CONTEXT_FLAG_NEED_GIF_MOTION = 8192;
    public static final int STREAMING_CONTEXT_FLAG_NO_HARDWARE_VIDEO_READER = 8;
    public static final int STREAMING_CONTEXT_FLAG_PLAYBACK_DROP_FRAME_MODE = 4096;
    public static final int STREAMING_CONTEXT_FLAG_SUPPORT_16K_EDIT = 128;
    public static final int STREAMING_CONTEXT_FLAG_SUPPORT_4K_EDIT = 1;
    public static final int STREAMING_CONTEXT_FLAG_SUPPORT_8K_EDIT = 4;
    public static final int STREAMING_CONTEXT_FLAG_USE_SYSTEM_IMAGE_READER = 512;
    public static final int STREAMING_CONTEXT_VIDEO_DECODER_WITHOUT_SURFACE_TEXTURE = 32;
    public static final int STREAMING_ENGINE_CAPTURE_FLAG_CAPTURE_BUDDY_HOST_VIDEO_FRAME = 32;
    public static final int STREAMING_ENGINE_CAPTURE_FLAG_DISABLE_FLIP_FOR_FRONT_CAMERA = 2048;
    public static final int STREAMING_ENGINE_CAPTURE_FLAG_DONT_CAPTURE_AUDIO = 16;
    public static final int STREAMING_ENGINE_CAPTURE_FLAG_DONT_USE_SYSTEM_RECORDER = 4;
    public static final int STREAMING_ENGINE_CAPTURE_FLAG_ENABLE_TAKE_PICTURE = 8192;
    public static final int STREAMING_ENGINE_CAPTURE_FLAG_FACE_ACTION_WITH_PARTICLE = 256;
    public static final int STREAMING_ENGINE_CAPTURE_FLAG_GRAB_CAPTURED_VIDEO_FRAME = 1;
    public static final int STREAMING_ENGINE_CAPTURE_FLAG_INPUT_ASPECT_RATIO_USED = 4096;
    public static final int STREAMING_ENGINE_CAPTURE_FLAG_LOW_PIPELINE_SIZE = 512;
    public static final int STREAMING_ENGINE_CAPTURE_FLAG_STRICT_PREVIEW_VIDEO_SIZE = 8;
    public static final int STREAMING_ENGINE_COMPILE_FLAG_BUDDY_HOST_VIDEO_FRAME = 32;
    public static final int STREAMING_ENGINE_COMPILE_FLAG_DISABLE_ALIGN_VIDEO_SIZE = 256;
    public static final int STREAMING_ENGINE_COMPILE_FLAG_DISABLE_HARDWARE_ENCODER = 1;
    public static final int STREAMING_ENGINE_COMPILE_FLAG_DISABLE_MEDIA_MUXER = 16;
    public static final int STREAMING_ENGINE_COMPILE_FLAG_DISABLE_PRELOADER_ON_SOURCE = 64;
    public static final int STREAMING_ENGINE_COMPILE_FLAG_DONT_USE_INPUT_SURFACE = 2;
    public static final int STREAMING_ENGINE_COMPILE_FLAG_IGNORE_TIMELINE_VIDEO_SIZE = 2048;
    public static final int STREAMING_ENGINE_COMPILE_FLAG_LOW_PIPELINE_SIZE = 4096;
    public static final int STREAMING_ENGINE_COMPILE_FLAG_ONLY_AUDIO = 8;
    public static final int STREAMING_ENGINE_COMPILE_FLAG_ONLY_VIDEO = 4;
    public static final int STREAMING_ENGINE_COMPILE_FLAG_TRUNCATE_AUDIO_STREAM = 128;
    public static final int STREAMING_ENGINE_COMPILE_FLAG_USE_SOFTWARE_AUDIO_ENCODER = 1024;
    public static final int STREAMING_ENGINE_HARDWARE_ERROR_TYPE_VIDEO_DECODER_SETUP_ERROR = 2;
    public static final int STREAMING_ENGINE_HARDWARE_ERROR_TYPE_VIDEO_DECODING_ERROR = 3;
    public static final int STREAMING_ENGINE_HARDWARE_ERROR_TYPE_VIDEO_ENCODER_SETUP_ERROR = 0;
    public static final int STREAMING_ENGINE_HARDWARE_ERROR_TYPE_VIDEO_ENCODING_ERROR = 1;
    public static final int STREAMING_ENGINE_INTERRUPT_STOP = 4;
    public static final int STREAMING_ENGINE_PLAYBACK_EXCEPTION_TYPE_MEDIA_FILE_ERROR = 0;
    public static final int STREAMING_ENGINE_PLAYBACK_FLAG_AUTO_CACHE_ALL_CAF_FRAMES = 128;
    public static final int STREAMING_ENGINE_PLAYBACK_FLAG_BUDDY_HOST_VIDEO_FRAME = 32;
    public static final int STREAMING_ENGINE_PLAYBACK_FLAG_DISABLE_FIXED_PREROLL_TIME = 16;
    public static final int STREAMING_ENGINE_PLAYBACK_FLAG_DISABLE_PRELOADER_ON_SOURCE = 64;
    public static final int STREAMING_ENGINE_PLAYBACK_FLAG_LOW_PIPELINE_SIZE = 8;
    public static final int STREAMING_ENGINE_PLAYBACK_FLAG_SPEED_COMP_MODE = 512;
    public static final int STREAMING_ENGINE_RECORDING_FLAG_DISABLE_HARDWARE_ENCODER = 4;
    public static final int STREAMING_ENGINE_RECORDING_FLAG_DISABLE_MEDIA_MUXER = 128;
    public static final int STREAMING_ENGINE_RECORDING_FLAG_DONT_USE_INPUT_SURFACE = 64;
    public static final int STREAMING_ENGINE_RECORDING_FLAG_FLIP_HORIZONTALLY = 512;
    public static final int STREAMING_ENGINE_RECORDING_FLAG_IGNORE_VIDEO_ROTATION = 32;
    public static final int STREAMING_ENGINE_RECORDING_FLAG_ONLY_RECORD_VIDEO = 16;
    public static final int STREAMING_ENGINE_RECORDING_FLAG_RECORDING_WITHOUT_FX = 256;
    public static final int STREAMING_ENGINE_RECORDING_FLAG_SOFTWARE_VIDEO_INTRA_FRAME_ONLY_FAST_STOP = 8;
    public static final int STREAMING_ENGINE_RECORDING_FLAG_VIDEO_INTRA_FRAME_ONLY = 2;
    public static final int STREAMING_ENGINE_SEEK_FLAG_BUDDY_HOST_VIDEO_FRAME = 16;
    public static final int STREAMING_ENGINE_SEEK_FLAG_NOT_CONNECT_TO_LIVEWINDOW = 128;
    public static final int STREAMING_ENGINE_SEEK_FLAG_SHOW_ANIMATED_STICKER_POSTER = 4;
    public static final int STREAMING_ENGINE_SEEK_FLAG_SHOW_CAPTION_POSTER = 2;
    public static final int STREAMING_ENGINE_SEND_BUFFER_FLAG_ONLY_FOR_BUDDY = 2;
    public static final int STREAMING_ENGINE_SEND_BUFFER_FLAG_ONLY_FOR_GRAB = 1;
    public static final int STREAMING_ENGINE_STATE_CAPTUREPREVIEW = 1;
    public static final int STREAMING_ENGINE_STATE_CAPTURERECORDING = 2;
    public static final int STREAMING_ENGINE_STATE_COMPILE = 5;
    public static final int STREAMING_ENGINE_STATE_PLAYBACK = 3;
    public static final int STREAMING_ENGINE_STATE_SEEKING = 4;
    public static final int STREAMING_ENGINE_STATE_STOPPED = 0;
    public static final int STREAMING_ENGINE_STOP_FLAG_ASYNC = 2;
    public static final int STREAMING_ENGINE_STOP_FLAG_FORCE_STOP_COMPILATION = 1;
    private static final String TAG = "Meicam";
    public static final int VIDEO_CAPTURE_RESOLUTION_GRADE_EXTREMELY_HIGH = 4;
    public static final int VIDEO_CAPTURE_RESOLUTION_GRADE_HIGH = 2;
    public static final int VIDEO_CAPTURE_RESOLUTION_GRADE_LOW = 0;
    public static final int VIDEO_CAPTURE_RESOLUTION_GRADE_MEDIUM = 1;
    public static final int VIDEO_CAPTURE_RESOLUTION_GRADE_SUPER_HIGH = 3;
    public static final int VIDEO_PREVIEW_SIZEMODE_FULLSIZE = 0;
    public static final int VIDEO_PREVIEW_SIZEMODE_LIVEWINDOW_SIZE = 1;
    public static final int VIDEO_STABILIZATION_MODE_AUTO = 1;
    public static final int VIDEO_STABILIZATION_MODE_OFF = 0;
    public static final int VIDEO_STABILIZATION_MODE_STANDARD = 2;
    public static final int VIDEO_STABILIZATION_MODE_SUPER = 3;
    private static AssetManager m_assetManager;
    private static ClassLoader m_classLoader;
    private static Context m_context;
    private static boolean m_customNativeLibraryDirPath = false;
    private static int m_debugLevel = 3;
    private static boolean m_faceDetectionLibLoaded = false;
    private static List m_fxPluginBundlePathList;
    private static int m_iconSize = 0;
    private static boolean m_initializedOnce = false;
    private static NvsStreamingContext m_instance;
    public static String m_logFilePath;
    private static int m_maxAudioReaderCount = 0;
    private static int m_maxIconReader = 0;
    private static int m_maxImageReaderCount = 0;
    private static int m_maxReaderCount = 0;
    private static String m_nativeLibraryDirPath;
    private static boolean m_saveDebugMessagesToFile = false;
    private static int m_streamingPoolSizeInByte;
    private NvsAssetPackageManager m_assetPackageManager = null;
    private NvsStreamingContext$AudioOutputCallback m_audioOutputCallback;
    private NvsStreamingContext$CaptureRecordingDurationCallback m_captureRecordingDurationCallback;
    private NvsStreamingContext$CaptureRecordingFrameReachedCallback m_captureRecordingFrameReachedCallback;
    private NvsStreamingContext$CaptureRecordingStartedCallback m_captureRecordingStartedCallback;
    private NvsStreamingContext$CaptureDeviceCallback m_catpureDeviceCallback;
    private NvsStreamingContext$CapturedPictureCallback m_catpuredPictureCallback;
    private NvsStreamingContext$CapturedVideoFrameGrabberCallback m_catpuredVideoFrameGrabberCallback;
    private NvsStreamingContext$CompileCallback m_compileCallback;
    private NvsStreamingContext$CompileCallback2 m_compileCallback2;
    private NvsStreamingContext$CompileCallback3 m_compileCallback3;
    private Hashtable m_compileConfigurations;
    private NvsStreamingContext$CompileFloatProgressCallback m_compileFloatProgressCallback;
    private float m_compileVideoBitrateMultiplier;
    private NvsStreamingContext$HardwareErrorCallback m_hardwareErrorCallback;
    private long m_internalObject;
    private boolean m_isAuxiliaryContext;
    private NvsStreamingContext$PlaybackCallback m_playbackCallback;
    private NvsStreamingContext$PlaybackCallback2 m_playbackCallback2;
    private NvsStreamingContext$PlaybackDelayCallback m_playbackDelayCallback;
    private NvsStreamingContext$PlaybackExceptionCallback m_playbackExceptionCallback;
    private float m_recordVideoBitrateMultiplier;
    private NvsStreamingContext$SeekingCallback m_seekingCallback;
    private NvsStreamingContext$StreamingEngineCallback m_streamingEngineCallback;
    private NvsStreamingContext$TimelineTimestampCallback m_timelineTimestampCallback;

    private NvsStreamingContext(Context context, boolean bl2) {
        Hashtable hashtable;
        float f10;
        long l10;
        this.m_internalObject = l10 = 0L;
        this.m_isAuxiliaryContext = false;
        this.m_compileVideoBitrateMultiplier = f10 = 1.0f;
        this.m_recordVideoBitrateMultiplier = f10;
        this.m_compileConfigurations = hashtable = new Hashtable();
        if (bl2) {
            NvsAssetPackageManager nvsAssetPackageManager;
            this.m_assetPackageManager = nvsAssetPackageManager = new NvsAssetPackageManager(false);
            l10 = this.nativeGetAssetPackageManager();
            nvsAssetPackageManager.setInternalObject(l10);
            this.nativeDetectPackageName(context);
        }
    }

    private boolean checkCameraPermission() {
        int n10 = Build.VERSION.SDK_INT;
        boolean bl2 = true;
        int n11 = 23;
        if (n10 < n11) {
            return bl2;
        }
        Context context = m_context;
        String string2 = "android.permission.CAMERA";
        n10 = context.checkSelfPermission(string2);
        if (n10 != 0) {
            Log.e((String)TAG, (String)"CAMERA permission has not been granted!");
            return false;
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
        object = NvsCheckExpirationOnline.instance();
        if (object != null) {
            ((NvsCheckExpirationOnline)object).release();
        }
        if ((object = NvsStatisticsSender.getInstance()) != null) {
            ((NvsStatisticsSender)object).release();
        }
        if ((object = m_instance.getAssetPackageManager()) != null) {
            ((NvsAssetPackageManager)object).setCallbackInterface(null);
            long l10 = 0L;
            ((NvsAssetPackageManager)object).setInternalObject(l10);
        }
        m_instance.setCaptureDeviceCallback(null);
        m_instance.setCapturedVideoFrameGrabberCallback(null);
        m_instance.setCaptureRecordingStartedCallback(null);
        m_instance.setCaptureRecordingDurationCallback(null);
        m_instance.setPlaybackCallback(null);
        m_instance.setCompileCallback(null);
        m_instance.setStreamingEngineCallback(null);
        m_instance.setTimelineTimestampCallback(null);
        m_instance.setCompileCallback2(null);
        m_instance.setCompileFloatProgressCallback(null);
        m_instance.setCompileCallback3(null);
        m_instance.setPlaybackCallback2(null);
        m_instance.setPlaybackDelayCallback(null);
        m_instance.setPlaybackExceptionCallback(null);
        m_instance.setHardwareErrorCallback(null);
        m_instance = null;
        m_context = null;
        m_classLoader = null;
        NvsStreamingContext.nativeSetAssetManager(null);
        m_assetManager = null;
        NvsStreamingContext.nativeClose();
    }

    public static void closeHumanDetection() {
        NvsStreamingContext.nativeCloseHumanDetection();
    }

    private static void createNewNativeDirAboveEqualApiLevel14(Context object, String string2) {
        object = NvsStreamingContext.getPathList((PathClassLoader)object.getClassLoader());
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
        object = NvsStreamingContext.getPathList((PathClassLoader)object.getClassLoader());
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
        return NvsStreamingContext.nativeFunctionalityAuthorised(string2);
    }

    public static NvsAVFileInfo getAVInfoFromFile(String string2, int n10) {
        return NvsStreamingContext.nativeGetAVInfoFromFile(string2, n10);
    }

    private double getAverage(double[] dArray, int n10) {
        int n11 = dArray.length;
        double d10 = 0.0;
        for (int i10 = 0; i10 < n11; ++i10) {
            double d11 = dArray[i10];
            d10 += d11;
        }
        double d12 = n10;
        return d10 / d12;
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

    public static NvsStreamingContext getInstance() {
        NvsUtils.checkFunctionInMainThread();
        return m_instance;
    }

    private static Object getPathList(Object object) {
        Class<?> clazz = Class.forName("dalvik.system.BaseDexClassLoader");
        return NvsStreamingContext.getField(object, clazz, "pathList");
    }

    private double getVariance(double[] dArray, int n10, double d10) {
        int n11 = dArray.length;
        double d11 = 0.0;
        for (int i10 = 0; i10 < n11; ++i10) {
            double d12 = dArray[i10] - d10;
            d12 *= d12;
            d11 += d12;
        }
        double d13 = n10;
        return d11 / d13;
    }

    public static int hasARModule() {
        NvsUtils.checkFunctionInMainThread();
        return NvsStreamingContext.nativeHasARModule();
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

    public static NvsStreamingContext init(Activity activity, String string2) {
        NvsUtils.checkFunctionInMainThread();
        return NvsStreamingContext.init(activity, string2, 0);
    }

    public static NvsStreamingContext init(Activity activity, String string2, int n10) {
        NvsUtils.checkFunctionInMainThread();
        return NvsStreamingContext.init((Context)activity, string2, n10);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static NvsStreamingContext init(Context var0, String var1_2, int var2_3) {
        block47: {
            block52: {
                block51: {
                    block50: {
                        block49: {
                            block48: {
                                block46: {
                                    NvsUtils.checkFunctionInMainThread();
                                    var3_4 = NvsStreamingContext.m_instance;
                                    if (var3_4 != null) {
                                        return var3_4;
                                    }
                                    var3_4 = var0.getApplicationInfo();
                                    var4_5 = NvsStreamingContext.m_nativeLibraryDirPath;
                                    if (var4_5 == null) {
                                        var4_5 = new StringBuilder();
                                        var3_4 = var3_4.nativeLibraryDir;
                                        var4_5.append((String)var3_4);
                                        var4_5.append("/");
                                        NvsStreamingContext.m_nativeLibraryDirPath = var3_4 = var4_5.toString();
                                    }
                                    var3_4 = new StringBuilder();
                                    var3_4.append("HOME=");
                                    var4_5 = var0.getFilesDir().getAbsolutePath();
                                    var3_4.append((String)var4_5);
                                    var3_4 = var3_4.toString();
                                    var4_5 = new StringBuilder();
                                    var4_5.append((String)var3_4);
                                    var4_5.append("\tTMPDIR=");
                                    var3_4 = var0.getFilesDir().getAbsolutePath();
                                    var4_5.append((String)var3_4);
                                    var3_4 = var4_5.toString();
                                    var4_5 = null;
                                    try {
                                        var5_6 /* !! */  = var0.getAssets();
                                    }
                                    catch (Exception var0_1) {
                                        var1_2 = new StringBuilder();
                                        var1_2.append("");
                                        var11_12 = var0_1.getMessage();
                                        var1_2.append(var11_12);
                                        var1_2 = var1_2.toString();
                                        Log.e((String)"Meicam", (String)var1_2);
                                        var0_1.printStackTrace();
                                        NvsStreamingContext.m_context = null;
                                        NvsStreamingContext.m_classLoader = null;
                                        NvsStreamingContext.m_assetManager = null;
                                        return null;
                                    }
                                    NvsStreamingContext.m_assetManager = var5_6 /* !! */ ;
                                    var5_6 /* !! */  = var0.getApplicationContext();
                                    NvsStreamingContext.m_context = var5_6 /* !! */ ;
                                    var5_6 /* !! */  = var5_6 /* !! */ .getClassLoader();
                                    NvsStreamingContext.m_classLoader = var5_6 /* !! */ ;
                                    var6_7 = NvsStreamingContext.m_initializedOnce;
                                    var7_8 = 0;
                                    var8_9 = 1;
                                    if (var6_7 != 0) ** GOTO lbl93
                                    var6_7 = NvsStreamingContext.m_customNativeLibraryDirPath;
                                    if (var6_7 == 0) break block46;
                                    var5_6 /* !! */  = NvsStreamingContext.m_nativeLibraryDirPath;
                                    NvsStreamingContext.initNativeLibraryDirPath((Context)var0, (String)var5_6 /* !! */ );
                                }
                                var5_6 /* !! */  = "com.meicam.sdk.NvsLazyLoadingIndicator";
                                try {
                                    Class.forName((String)var5_6 /* !! */ );
                                    var6_7 = var8_9;
                                }
                                catch (Exception v0) {
                                    var6_7 = 0;
                                    var5_6 /* !! */  = null;
                                }
                                if (var6_7 == 0) {
                                    NvsStreamingContext.tryLoadFaceDetectionLibrary();
                                }
                                var5_6 /* !! */  = "aiEngine";
                                NvsStreamingContext.tryLoadNativeLibrary((String)var5_6 /* !! */ );
                                var5_6 /* !! */  = "aiEngine_g";
                                NvsStreamingContext.tryLoadNativeLibrary((String)var5_6 /* !! */ );
                                var5_6 /* !! */  = "NvStreamingSdkCore";
                                NvsStreamingContext.loadNativeLibrary((String)var5_6 /* !! */ );
lbl93:
                                // 2 sources

                                var5_6 /* !! */  = NvsStreamingContext.m_context;
                                var6_7 = NvsStreamingContext.nativeInitJNI((Context)var5_6 /* !! */ );
                                if (var6_7 == 0) break block47;
                                var5_6 /* !! */  = NvsStreamingContext.m_assetManager;
                                NvsStreamingContext.nativeSetAssetManager(var5_6 /* !! */ );
                                var6_7 = NvsStreamingContext.m_maxReaderCount;
                                if (var6_7 <= 0) ** GOTO lbl105
                                NvsStreamingContext.nativeSetMaxReaderCount(var6_7);
lbl105:
                                // 2 sources

                                if ((var6_7 = NvsStreamingContext.m_iconSize) <= 0) ** GOTO lbl108
                                NvsStreamingContext.nativeSetIconSize(var6_7);
lbl108:
                                // 2 sources

                                if ((var6_7 = NvsStreamingContext.m_maxIconReader) <= 0) ** GOTO lbl111
                                NvsStreamingContext.nativeSetMaxIconReader(var6_7);
lbl111:
                                // 2 sources

                                if ((var6_7 = NvsStreamingContext.m_maxAudioReaderCount) <= 0) ** GOTO lbl114
                                NvsStreamingContext.nativeSetMaxAudioReaderCount(var6_7);
lbl114:
                                // 2 sources

                                if ((var6_7 = NvsStreamingContext.m_maxImageReaderCount) <= 0) ** GOTO lbl117
                                NvsStreamingContext.nativeSetImageReaderCount(var6_7);
lbl117:
                                // 2 sources

                                if ((var6_7 = NvsStreamingContext.m_streamingPoolSizeInByte) <= 0) ** GOTO lbl120
                                NvsStreamingContext.nativeSetStreamingPoolSizeInByte(var6_7);
lbl120:
                                // 2 sources

                                var6_7 = NvsStreamingContext.m_debugLevel;
                                NvsStreamingContext.nativeSetDebugLevel(var6_7);
                                var6_7 = (int)NvsStreamingContext.m_saveDebugMessagesToFile;
                                NvsStreamingContext.nativeSetSaveDebugMessagesToFile((boolean)var6_7);
                                var5_6 /* !! */  = "isExpired";
                                var6_7 = NvsSystemVariableManager.getSystemVariableInt((Context)var0, (String)var5_6 /* !! */ );
                                if (var6_7 != var8_9) break block48;
                                var7_8 = var8_9;
                            }
                            var5_6 /* !! */  = new NvsStreamingContext$VerifyLicenseResult();
                            var9_10 = NvsStreamingContext.m_initializedOnce;
                            if (var9_10) break block49;
                            var5_6 /* !! */  = NvsStreamingContext.nativeVerifySdkLicenseFile((Context)var0, (String)var1_2, (boolean)var7_8);
                        }
                        var10_11 = var5_6 /* !! */ .needCheckExpiration;
                        if (var10_11 == 0) break block50;
                        var1_2 = NvsCheckExpirationOnline.init((Context)var0);
                        if (var1_2 == null) break block50;
                        var5_6 /* !! */  = var5_6 /* !! */ .licenseServerHost;
                        var1_2.startCheck((String)var5_6 /* !! */ );
                    }
                    var10_11 = NvsStreamingContext.nativeInit((String)var3_4, var2_3);
                    if (var10_11 != 0) break block51;
                    return null;
                }
                var1_2 = NvsStreamingContext.m_logFilePath;
                if (var1_2 == null) break block52;
                NvsStreamingContext.nativeSetLogFilePath((String)var1_2);
            }
            NvsStreamingContext.m_instance = var1_2 = new NvsStreamingContext((Context)var0, (boolean)var8_9);
            NvsStreamingContext.m_initializedOnce = var8_9;
            var10_11 = var1_2.isSdkAuthorised();
            if (var10_11 == 0) ** GOTO lbl177
            var10_11 = NvsStreamingContext.nativeIsNeedCheckExpiration();
            if (var10_11 == 0) ** GOTO lbl177
            var10_11 = NvsStreamingContext.nativeGetStatisticsFrequency();
            var2_3 = (int)NvsStreamingContext.nativeIsStatisticsPrivateInfo();
            var0 = NvsStatisticsSender.init((Context)var0);
            var0.sendStatistics(var10_11, (boolean)var2_3);
lbl177:
            // 3 sources

            return NvsStreamingContext.m_instance;
        }
        var1_2 = "nativeInitJNI() failed!";
        var0 = new Exception((String)var1_2);
        throw var0;
    }

    public static boolean initHumanDetection(Context context, String string2, String string3, int n10) {
        NvsStreamingContext.tryLoadFaceDetectionLibrary();
        boolean bl2 = m_faceDetectionLibLoaded;
        if (!bl2) {
            return false;
        }
        return NvsStreamingContext.nativeInitHumanDetection(context, string2, string3, n10);
    }

    public static boolean initHumanDetectionExt(Context context, String string2, String string3, int n10) {
        return NvsStreamingContext.nativeInitHumanDetectionExt(context, string2, string3, n10);
    }

    /*
     * Loose catch block
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void initNativeLibraryDirPath(Context context, String string2) {
        boolean bl2 = NvsStreamingContext.hasDexClassLoader();
        if (bl2) {
            try {
                NvsStreamingContext.createNewNativeDirAboveEqualApiLevel14(context, string2);
                return;
            }
            catch (Exception exception) {
                NvsStreamingContext.createNewNativeDirAboveEqualApiLevel21(context, string2);
            }
            return;
        }
        NvsStreamingContext.createNewNativeDirBelowApiLevel14(context, string2);
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

    private native boolean nativeApplyCaptureScene(String var1);

    private native long nativeCalcDurationAfterCurvesVariableSpeed(String var1);

    private native boolean nativeCanDecodeVideoStreamBySoftware(String var1);

    private native void nativeCancelAutoFocus();

    private native boolean nativeCheckDontSetCameraParamOnRecordingWithSystemRecorder();

    private native void nativeClearCachedResources(boolean var1);

    private native void nativeClearCachedResourcesFlags(boolean var1, int var2);

    private native NvsTimeline nativeCloneTimeline(NvsTimeline var1);

    private static native void nativeClose();

    private static native void nativeCloseHumanDetection();

    private native boolean nativeCompileTimeline(NvsTimeline var1, long var2, long var4, String var6, int var7, int var8, float var9, Hashtable var10, int var11);

    private native boolean nativeConnectCapturePreviewWithLiveWindow(Object var1);

    private native boolean nativeConnectCapturePreviewWithSurfaceTexture(SurfaceTexture var1);

    private native boolean nativeConnectTimelineWithLiveWindow(NvsTimeline var1, Object var2);

    private native boolean nativeConnectTimelineWithSurfaceTexture(NvsTimeline var1, SurfaceTexture var2, NvsRational var3);

    private native boolean nativeCreateAuxiliaryStreamingContext(NvsStreamingContext var1, int var2);

    private static native NvsHumanDetectionHandle nativeCreateHumanDetectionHandle(String var0, String var1, long var2);

    private native NvsTimeline nativeCreateTemplateTimeline(String var1, List var2, int var3);

    private native NvsTimeline nativeCreateTimeline(NvsVideoResolution var1, NvsRational var2, NvsAudioResolution var3, int var4);

    private native void nativeDestoryAuxiliaryStreamingContext(NvsStreamingContext var1);

    private static native boolean nativeDestroyHumanDetectionHandle(NvsHumanDetectionHandle var0);

    private native float nativeDetectEngineRenderFramePerSecond();

    private native void nativeDetectPackageName(Context var1);

    private native int nativeDetectVideoFileKeyframeInterval(String var1);

    private native boolean nativeExportTemplateInfo(String var1, NvsTimeline var2, int var3);

    private static native boolean nativeExtendHumanDetectionHandle(NvsHumanDetectionHandle var0, String var1, String var2, long var3);

    private static native boolean nativeFunctionalityAuthorised(String var0);

    private native boolean nativeGenerateTemplatePackage(String var1, String var2, String var3);

    private native NvsAVFileInfo nativeGetAVFileInfo(String var1, int var2, StringBuilder var3);

    private static native NvsAVFileInfo nativeGetAVInfoFromFile(String var0, int var1);

    private native List nativeGetAllBuiltinAudioFxNames();

    private native List nativeGetAllBuiltinCaptureAudioFxNames();

    private native List nativeGetAllBuiltinCaptureVideoFxNames();

    private native List nativeGetAllBuiltinVideoFxNames();

    private native List nativeGetAllBuiltinVideoTransitionNames();

    private native long nativeGetAssetPackageManager();

    private native NvsFxDescription nativeGetAudioFxDescription(String var1);

    private native int nativeGetAudioStreamCountInMediaFile(String var1);

    private native String nativeGetBeautyVideoFxName();

    private native NvsCaptureAnimatedSticker nativeGetCaptureAnimatedStickerByIndex(int var1);

    private native int nativeGetCaptureAnimatedStickerCount();

    private native NvsCaptureAudioFx nativeGetCaptureAudioFxByIndex(int var1);

    private native int nativeGetCaptureAudioFxCount();

    private native NvsCaptureCaption nativeGetCaptureCaptionByIndex(int var1);

    private native int nativeGetCaptureCaptionCount();

    private native NvsCaptureCompoundCaption nativeGetCaptureCompoundCaptionByIndex(int var1);

    private native int nativeGetCaptureCompoundCaptionCount();

    private native NvsStreamingContext$CaptureDeviceCapability nativeGetCaptureDeviceCapability(int var1);

    private native int nativeGetCaptureDeviceCount();

    private native NvsSize nativeGetCapturePreviewVideoSize(int var1);

    private native NvsCaptureVideoFx nativeGetCaptureVideoFxByIndex(int var1);

    private native int nativeGetCaptureVideoFxCount();

    private native String nativeGetCurrentCaptureSceneId();

    private native int nativeGetCustomCompileVideoHeight();

    private native String nativeGetDefaultThemeEndingLogoImageFilePath();

    private native String nativeGetDefaultVideoTransitionName();

    private native int nativeGetEngineHDRCaps();

    private native int nativeGetExposureCompensation();

    private native int nativeGetFlashMode();

    private native List nativeGetFontInfoByFilePath(String var1);

    private native NvsStreamingContext$SdkVersion nativeGetSdkVersion();

    private static native int nativeGetStatisticsFrequency();

    private native int nativeGetStreamingEngineState();

    private native long nativeGetTimelineCurrentPosition(NvsTimeline var1);

    private native NvsFxDescription nativeGetVideoFxDescription(String var1);

    private native int nativeGetVideoStabilization();

    private native int nativeGetZoom();

    private native Bitmap nativeGrabImageFromTimeline(NvsTimeline var1, long var2, NvsRational var4, int var5);

    private native boolean nativeGrabImageFromTimelineAsyncMode(NvsTimeline var1, long var2, NvsRational var4, int var5);

    private static native int nativeHasARModule();

    private static native boolean nativeInit(String var0, int var1);

    private static native boolean nativeInitHumanDetection(Context var0, String var1, String var2, int var3);

    private static native boolean nativeInitHumanDetectionExt(Context var0, String var1, String var2, int var3);

    private static native boolean nativeInitJNI(Context var0);

    private native NvsCaptureAudioFx nativeInsertBuiltinCaptureAudioFx(String var1, int var2);

    private native NvsCaptureVideoFx nativeInsertBuiltinCaptureVideoFx(String var1, int var2);

    private native NvsCaptureAnimatedSticker nativeInsertCaptureAnimatedSticker(long var1, long var3, String var5, int var6);

    private native NvsCaptureCaption nativeInsertCaptureCaption(String var1, long var2, long var4, String var6, int var7);

    private native NvsCaptureCompoundCaption nativeInsertCaptureCompoundCaption(long var1, long var3, String var5, int var6);

    private native NvsCaptureCaption nativeInsertCaptureModularCaption(String var1, long var2, long var4, int var6);

    private native NvsCaptureVideoFx nativeInsertCustomCaptureVideoFx(NvsCustomVideoFx$Renderer var1, int var2);

    private native NvsCaptureVideoFx nativeInsertPackagedCaptureVideoFx(String var1, int var2);

    private native boolean nativeIsCaptureDeviceBackFacing(int var1);

    private native boolean nativeIsCompilingPaused();

    private native boolean nativeIsDefaultCaptionFade();

    private static native boolean nativeIsNeedCheckExpiration();

    private native boolean nativeIsPlaybackPaused();

    private native boolean nativeIsRecordingPaused();

    private native boolean nativeIsSdkAuthorised();

    private static native boolean nativeIsStatisticsPrivateInfo();

    private native boolean nativePauseResumeCompiling(boolean var1);

    private native boolean nativePauseResumePlayback(boolean var1);

    private native boolean nativePauseResumeRecording(boolean var1);

    private native boolean nativePlaybackTimeline(NvsTimeline var1, long var2, long var4, int var6, boolean var7, int var8);

    private native boolean nativePlaybackTimelineWithProxyScale(NvsTimeline var1, long var2, long var4, NvsRational var6, boolean var7, int var8);

    private native boolean nativePreloadEffectResources();

    private native String nativeRegisterFontByFilePath(String var1);

    private native void nativeRemoveAllCaptureAnimatedSticker();

    private native void nativeRemoveAllCaptureAudioFx();

    private native void nativeRemoveAllCaptureCaption();

    private native void nativeRemoveAllCaptureCompoundCaption();

    private native void nativeRemoveAllCaptureVideoFx();

    private native boolean nativeRemoveCaptureAnimatedSticker(int var1);

    private native boolean nativeRemoveCaptureAudioFx(int var1);

    private native boolean nativeRemoveCaptureCaption(int var1);

    private native boolean nativeRemoveCaptureCompoundCaption(int var1);

    private native boolean nativeRemoveCaptureVideoFx(int var1);

    private native void nativeRemoveCurrentCaptureScene();

    private native boolean nativeRemoveTimeline(NvsTimeline var1);

    private native NvsColor nativeSampleColorFromCapturedVideoFrame(RectF var1);

    private native boolean nativeSeekTimeline(NvsTimeline var1, long var2, int var4, int var5);

    private native boolean nativeSeekTimelineWithProxyScale(NvsTimeline var1, long var2, NvsRational var4, int var5);

    private native boolean nativeSendBufferToCapturePreview(byte[] var1, long var2, int var4);

    private static native void nativeSetAssetManager(AssetManager var0);

    private native void nativeSetAudioOutputCallback(NvsStreamingContext$AudioOutputCallback var1);

    private native void nativeSetAudioOutputDeviceVolume(float var1);

    private native void nativeSetAutoExposureRect(RectF var1);

    private static native void nativeSetCaptureDeviceCallback(NvsStreamingContext$CaptureDeviceCallback var0);

    private native void nativeSetCaptureFps(int var1);

    private static native void nativeSetCaptureRecordingDurationCallback(NvsStreamingContext$CaptureRecordingDurationCallback var0);

    private static native void nativeSetCaptureRecordingFrameReachedCallback(NvsStreamingContext$CaptureRecordingFrameReachedCallback var0);

    private static native void nativeSetCaptureRecordingStartedCallback(NvsStreamingContext$CaptureRecordingStartedCallback var0);

    private static native void nativeSetCapturedPictureCallback(NvsStreamingContext$CapturedPictureCallback var0);

    private static native void nativeSetCapturedVideoFrameGrabberCallback(NvsStreamingContext$CapturedVideoFrameGrabberCallback var0);

    private native void nativeSetCompileCallback(NvsStreamingContext$CompileCallback var1);

    private native void nativeSetCompileCallback2(NvsStreamingContext$CompileCallback2 var1);

    private native void nativeSetCompileCallback3(NvsStreamingContext$CompileCallback3 var1);

    private native void nativeSetCompileFloatProgressCallback(NvsStreamingContext$CompileFloatProgressCallback var1);

    private native void nativeSetCustomCompileVideoHeight(int var1);

    private static native void nativeSetDebugLevel(int var0);

    private native void nativeSetDefaultAudioTransitionName(String var1);

    private native void nativeSetDefaultCaptionFade(boolean var1);

    private native boolean nativeSetDefaultThemeEndingLogoImageFilePath(String var1);

    private native void nativeSetExposureCompensation(int var1);

    private native void nativeSetHardwareErrorCallback(NvsStreamingContext$HardwareErrorCallback var1);

    private static native void nativeSetIconSize(int var0);

    private native void nativeSetImageGrabberCallback(NvsStreamingContext$ImageGrabberCallback var1);

    private static native void nativeSetImageReaderCount(int var0);

    private static native void nativeSetLogFilePath(String var0);

    private static native void nativeSetMaxAudioReaderCount(int var0);

    private static native void nativeSetMaxCafCacheMemorySize(int var0);

    private static native void nativeSetMaxIconReader(int var0);

    private static native void nativeSetMaxReaderCount(int var0);

    private native void nativeSetMediaCodecIconReaderEnabled(String var1, boolean var2);

    private native void nativeSetMediaCodecVideoDecodingOperatingRate(String var1, int var2);

    private native void nativeSetPlaybackCallback(NvsStreamingContext$PlaybackCallback var1);

    private native void nativeSetPlaybackCallback2(NvsStreamingContext$PlaybackCallback2 var1);

    private native void nativeSetPlaybackDelayCallback(NvsStreamingContext$PlaybackDelayCallback var1);

    private native void nativeSetPlaybackExceptionCallback(NvsStreamingContext$PlaybackExceptionCallback var1);

    private static native void nativeSetSaveDebugMessagesToFile(boolean var0);

    private native void nativeSetSeekingCallback(NvsStreamingContext$SeekingCallback var1);

    private native void nativeSetStreamingEngineCallback(NvsStreamingContext$StreamingEngineCallback var1);

    private static native void nativeSetStreamingPoolSizeInByte(int var0);

    private native boolean nativeSetThemeEndingEnabled(boolean var1);

    private native void nativeSetUserWatermarkForCapture(String var1, int var2, int var3, float var4, int var5, int var6, int var7);

    private native void nativeSetVideoStabilization(int var1);

    private native void nativeSetZoom(int var1);

    private static native boolean nativeSetupHumanDetectionData(int var0, String var1);

    private native void nativeStartAutoFocus(RectF var1);

    private native boolean nativeStartBufferCapturePreview(int var1, int var2, NvsRational var3, int var4, boolean var5);

    private native boolean nativeStartCapturePreview(int var1, int var2, int var3, NvsRational var4);

    private native boolean nativeStartCapturePreviewWithSpecialSize(int var1, int var2, int var3, NvsSize var4);

    private native void nativeStartContinuousFocus();

    private native boolean nativeStartDualBufferCapturePreview(int var1, int var2, int var3, int var4, int var5, boolean var6, int var7, NvsRational var8, int var9, NvAndroidVirtualCameraSurfaceTexture var10);

    private native boolean nativeStartRecording(String var1, float var2, int var3, int var4, int var5);

    private native void nativeStop(int var1);

    private native void nativeStopRecording(boolean var1);

    private native boolean nativeTakePicture(int var1);

    private native void nativeToggleFlashMode(int var1);

    private static native NvsStreamingContext$VerifyLicenseResult nativeVerifySdkLicenseFile(Context var0, String var1, boolean var2);

    public static void openMainThreadChecker(boolean bl2) {
        NvsUtils.setCheckEnable(bl2);
    }

    private Bitmap scaleBitmap(Bitmap bitmap, int n10) {
        int n11;
        int n12 = bitmap.getWidth();
        int n13 = Math.min(n12, n11 = bitmap.getHeight());
        if (n13 > n10) {
            float f10 = (float)n10 * 1.0f;
            float f11 = n13;
            Matrix matrix = new Matrix();
            matrix.preScale(f10 /= f11, f10);
            Bitmap bitmap2 = Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)n12, (int)n11, (Matrix)matrix, (boolean)false);
            n13 = (int)(bitmap.isRecycled() ? 1 : 0);
            if (n13 == 0) {
                bitmap.recycle();
            }
            return bitmap2;
        }
        return bitmap;
    }

    public static void setDebugLevel(int n10) {
        NvsUtils.checkFunctionInMainThread();
        int n11 = m_debugLevel;
        if (n10 == n11) {
            return;
        }
        m_debugLevel = n10;
        NvsStreamingContext nvsStreamingContext = m_instance;
        if (nvsStreamingContext != null) {
            NvsStreamingContext.nativeSetDebugLevel(n10);
        }
    }

    public static void setFxPluginBundlePathList(List list) {
        NvsUtils.checkFunctionInMainThread();
        m_fxPluginBundlePathList = list;
    }

    public static void setIconSize(int n10) {
        NvsUtils.checkFunctionInMainThread();
        m_iconSize = n10;
    }

    public static void setLoadPluginFromAssets(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
    }

    public static void setLogFilePath(String string2) {
        NvsUtils.checkFunctionInMainThread();
        if (string2 == null) {
            return;
        }
        Object object = "/";
        int n11 = string2.endsWith((String)object);
        if (n11 != 0) {
            n11 = string2.length() + -2;
            if (n11 <= 0) {
                return;
            }
            n11 = 0;
            object = null;
            int n10 = string2.length() + -2;
            string2 = string2.substring(0, n10);
        }
        if ((n11 = string2.isEmpty()) != 0) {
            return;
        }
        object = new File(string2);
        boolean bl2 = ((File)object).exists();
        if (!bl2) {
            ((File)object).mkdirs();
        }
        if ((n11 = (int)(((File)object).isDirectory() ? 1 : 0)) == 0) {
            return;
        }
        m_logFilePath = string2;
        object = m_instance;
        if (object != null) {
            NvsStreamingContext.nativeSetLogFilePath(string2);
        }
    }

    public static void setMaxAudioReaderCount(int n10) {
        NvsUtils.checkFunctionInMainThread();
        m_maxAudioReaderCount = n10;
    }

    public static void setMaxCafCacheMemorySize(int n10) {
        NvsUtils.checkFunctionInMainThread();
        NvsStreamingContext.nativeSetMaxCafCacheMemorySize(n10);
    }

    public static void setMaxIconReader(int n10) {
        NvsUtils.checkFunctionInMainThread();
        m_maxIconReader = n10;
    }

    public static void setMaxImageReaderCount(int n10) {
        NvsUtils.checkFunctionInMainThread();
        m_maxImageReaderCount = n10;
    }

    public static void setMaxReaderCount(int n10) {
        NvsUtils.checkFunctionInMainThread();
        m_maxReaderCount = n10;
    }

    public static void setNativeLibraryDirPath(String string2) {
        NvsUtils.checkFunctionInMainThread();
        m_nativeLibraryDirPath = string2;
        if (string2 != null) {
            boolean bl2;
            m_customNativeLibraryDirPath = bl2 = true;
        }
    }

    public static void setPluginDirPath(String string2) {
        NvsUtils.checkFunctionInMainThread();
    }

    public static void setSaveDebugMessagesToFile(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        boolean bl3 = m_saveDebugMessagesToFile;
        if (bl2 == bl3) {
            return;
        }
        m_saveDebugMessagesToFile = bl2;
        NvsStreamingContext nvsStreamingContext = m_instance;
        if (nvsStreamingContext != null) {
            NvsStreamingContext.nativeSetSaveDebugMessagesToFile(bl2);
        }
    }

    public static void setStreamingPoolSizeInByte(int n10) {
        NvsUtils.checkFunctionInMainThread();
        m_streamingPoolSizeInByte = n10;
    }

    public static boolean setupHumanDetectionData(int n10, String string2) {
        return NvsStreamingContext.nativeSetupHumanDetectionData(n10, string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void tryLoadFaceDetectionLibrary() {
        boolean bl2;
        boolean bl3 = m_faceDetectionLibLoaded;
        if (bl3) {
            return;
        }
        bl3 = false;
        boolean bl4 = true;
        String string2 = "com.meicam.sdk.NvsBEFFaceEffectDetector";
        try {
            Class.forName(string2);
            bl2 = bl4;
        }
        catch (Exception exception) {
            bl2 = false;
            string2 = null;
        }
        if (bl2 && !(bl2 = NvsStreamingContext.tryLoadNativeLibrary(string2 = "effect"))) {
            return;
        }
        string2 = "com.meicam.sdk.NvsMGFaceEffectDetector";
        try {
            Class.forName(string2);
            bl2 = bl4;
        }
        catch (Exception exception) {
            bl2 = false;
            string2 = null;
        }
        if (!(!bl2 || (bl2 = NvsStreamingContext.tryLoadNativeLibrary(string2 = "megface-new")) && (bl2 = NvsStreamingContext.tryLoadNativeLibrary(string2 = "MegviiFacepp")))) {
            return;
        }
        string2 = "com.meicam.sdk.NvsSTFaceEffectDetector";
        try {
            Class.forName(string2);
            bl2 = bl4;
        }
        catch (Exception exception) {
            bl2 = false;
            string2 = null;
        }
        String string3 = "st_mobile";
        if (bl2 && !(bl2 = NvsStreamingContext.tryLoadNativeLibrary(string3))) {
            return;
        }
        string2 = "com.meicam.sdk.NvsFaceEffectV1Detector";
        try {
            Class.forName(string2);
            bl2 = bl4;
        }
        catch (Exception exception) {
            bl2 = false;
            string2 = null;
        }
        String string4 = "com.meicam.sdk.NvsFUFaceEffectDetector";
        try {
            Class.forName(string4);
            bl2 = bl4;
        }
        catch (Exception exception) {}
        if (bl2) {
            string2 = "fuai";
            bl2 = NvsStreamingContext.tryLoadNativeLibrary(string2);
            if (!bl2) {
                return;
            }
            string2 = "CNamaSDK";
            bl2 = NvsStreamingContext.tryLoadNativeLibrary(string2);
            if (!bl2) {
                return;
            }
        }
        string2 = "com.meicam.sdk.NvsFaceEffect2Init";
        try {
            Class.forName(string2);
            bl3 = bl4;
        }
        catch (Exception exception) {}
        if (bl3 && !(bl3 = NvsStreamingContext.tryLoadNativeLibrary(string3))) {
            return;
        }
        m_faceDetectionLibLoaded = bl4;
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

    public void StartContinuousFocus() {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return;
        }
        NvsUtils.checkFunctionInMainThread();
        this.nativeStartContinuousFocus();
    }

    public NvsCaptureVideoFx appendBeautyCaptureVideoFx() {
        int n10 = this.m_isAuxiliaryContext;
        if (n10 != 0) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        n10 = this.getCaptureVideoFxCount();
        return this.insertBeautyCaptureVideoFx(n10);
    }

    public NvsCaptureAudioFx appendBuiltinCaptureAudioFx(String string2) {
        int n10 = this.m_isAuxiliaryContext;
        if (n10 != 0) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        n10 = this.getCaptureAudioFxCount();
        return this.insertBuiltinCaptureAudioFx(string2, n10);
    }

    public NvsCaptureVideoFx appendBuiltinCaptureVideoFx(String string2) {
        int n10 = this.m_isAuxiliaryContext;
        if (n10 != 0) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        n10 = this.getCaptureVideoFxCount();
        return this.insertBuiltinCaptureVideoFx(string2, n10);
    }

    public NvsCaptureAnimatedSticker appendCaptureAnimatedSticker(long l10, long l11, String string2) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        int n10 = this.getCaptureAnimatedStickerCount();
        return this.insertCaptureAnimatedSticker(l10, l11, string2, n10);
    }

    public NvsCaptureCaption appendCaptureCaption(String string2, long l10, long l11, String string3) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        int n10 = this.getCaptureCaptionCount();
        return this.insertCaptureCaption(string2, l10, l11, string3, n10);
    }

    public NvsCaptureCompoundCaption appendCaptureCompoundCaption(long l10, long l11, String string2) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        int n10 = this.getCaptureCompoundCaptionCount();
        return this.insertCaptureCompoundCaption(l10, l11, string2, n10);
    }

    public NvsCaptureCaption appendCaptureModularCaption(String string2, long l10, long l11) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        int n10 = this.getCaptureCaptionCount();
        return this.insertCaptureModularCaption(string2, l10, l11, n10);
    }

    public NvsCaptureVideoFx appendCustomCaptureVideoFx(NvsCustomVideoFx$Renderer nvsCustomVideoFx$Renderer) {
        int n10 = this.m_isAuxiliaryContext;
        if (n10 != 0) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        n10 = this.getCaptureVideoFxCount();
        return this.nativeInsertCustomCaptureVideoFx(nvsCustomVideoFx$Renderer, n10);
    }

    public NvsCaptureVideoFx appendPackagedCaptureVideoFx(String string2) {
        int n10 = this.m_isAuxiliaryContext;
        if (n10 != 0) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        n10 = this.getCaptureVideoFxCount();
        return this.insertPackagedCaptureVideoFx(string2, n10);
    }

    public boolean applyCaptureScene(String string2) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeApplyCaptureScene(string2);
    }

    public long calcDurationAfterCurvesVariableSpeed(String string2) {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeCalcDurationAfterCurvesVariableSpeed(string2);
    }

    public boolean canDecodeVideoStreamBySoftware(String string2) {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeCanDecodeVideoStreamBySoftware(string2);
    }

    public void cancelAutoFocus() {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return;
        }
        NvsUtils.checkFunctionInMainThread();
        this.nativeCancelAutoFocus();
    }

    public boolean checkDontSetCameraParamOnRecordingWithSystemRecorder() {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeCheckDontSetCameraParamOnRecordingWithSystemRecorder();
    }

    public void clearCachedResources(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        this.nativeClearCachedResources(bl2);
    }

    public void clearCachedResources(boolean bl2, int n10) {
        NvsUtils.checkFunctionInMainThread();
        this.nativeClearCachedResourcesFlags(bl2, n10);
    }

    public boolean compileTimeline(NvsTimeline nvsTimeline, long l10, long l11, String string2, int n10, int n11, int n12) {
        NvsUtils.checkFunctionInMainThread();
        float f10 = this.m_compileVideoBitrateMultiplier;
        Hashtable hashtable = this.m_compileConfigurations;
        return this.nativeCompileTimeline(nvsTimeline, l10, l11, string2, n10, n11, f10, hashtable, n12);
    }

    public boolean connectCapturePreviewWithLiveWindow(NvsLiveWindow nvsLiveWindow) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeConnectCapturePreviewWithLiveWindow((Object)nvsLiveWindow);
    }

    public boolean connectCapturePreviewWithLiveWindowExt(NvsLiveWindowExt nvsLiveWindowExt) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeConnectCapturePreviewWithLiveWindow((Object)nvsLiveWindowExt);
    }

    public boolean connectCapturePreviewWithSurfaceTexture(SurfaceTexture surfaceTexture) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeConnectCapturePreviewWithSurfaceTexture(surfaceTexture);
    }

    public boolean connectTimelineWithLiveWindow(NvsTimeline nvsTimeline, NvsLiveWindow nvsLiveWindow) {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeConnectTimelineWithLiveWindow(nvsTimeline, (Object)nvsLiveWindow);
    }

    public boolean connectTimelineWithLiveWindowExt(NvsTimeline nvsTimeline, NvsLiveWindowExt nvsLiveWindowExt) {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeConnectTimelineWithLiveWindow(nvsTimeline, (Object)nvsLiveWindowExt);
    }

    public boolean connectTimelineWithSurfaceTexture(NvsTimeline nvsTimeline, SurfaceTexture surfaceTexture) {
        NvsUtils.checkFunctionInMainThread();
        int n10 = 1;
        NvsRational nvsRational = new NvsRational(n10, n10);
        return this.nativeConnectTimelineWithSurfaceTexture(nvsTimeline, surfaceTexture, nvsRational);
    }

    public boolean connectTimelineWithSurfaceTexture(NvsTimeline nvsTimeline, SurfaceTexture surfaceTexture, NvsRational nvsRational) {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeConnectTimelineWithSurfaceTexture(nvsTimeline, surfaceTexture, nvsRational);
    }

    public NvsStreamingContext createAuxiliaryStreamingContext(int n10) {
        NvsUtils.checkFunctionInMainThread();
        Context context = m_context;
        if (context == null) {
            return null;
        }
        NvsStreamingContext nvsStreamingContext = new NvsStreamingContext(context, false);
        if ((n10 = (int)(this.nativeCreateAuxiliaryStreamingContext(nvsStreamingContext, n10) ? 1 : 0)) == 0) {
            return null;
        }
        nvsStreamingContext.m_isAuxiliaryContext = true;
        return nvsStreamingContext;
    }

    public NvsHumanDetectionHandle createHumanDetectionHandle(String string2, String string3, long l10) {
        NvsUtils.checkFunctionInMainThread();
        return NvsStreamingContext.nativeCreateHumanDetectionHandle(string2, string3, l10);
    }

    public NvsTimeline createTimeline(NvsVideoResolution nvsVideoResolution, NvsRational nvsRational, NvsAudioResolution nvsAudioResolution) {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeCreateTimeline(nvsVideoResolution, nvsRational, nvsAudioResolution, 0);
    }

    public NvsTimeline createTimeline(NvsVideoResolution nvsVideoResolution, NvsRational nvsRational, NvsAudioResolution nvsAudioResolution, int n10) {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeCreateTimeline(nvsVideoResolution, nvsRational, nvsAudioResolution, n10);
    }

    public NvsTimeline createTimeline(String string2, List list) {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeCreateTemplateTimeline(string2, list, 0);
    }

    public NvsTimeline createTimeline(String string2, List list, int n10) {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeCreateTemplateTimeline(string2, list, n10);
    }

    public NvsVideoFrameRetriever createVideoFrameRetriever(String string2) {
        NvsVideoFrameRetriever nvsVideoFrameRetriever = new NvsVideoFrameRetriever(string2);
        return nvsVideoFrameRetriever;
    }

    public NvsVideoKeyFrameRetriever createVideoKeyFrameRetriever(String string2, int n10, boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        NvsVideoKeyFrameRetriever nvsVideoKeyFrameRetriever = new NvsVideoKeyFrameRetriever(string2, n10, bl2);
        return nvsVideoKeyFrameRetriever;
    }

    public void destoryAuxiliaryStreamingContext(NvsStreamingContext nvsStreamingContext) {
        if (nvsStreamingContext == null) {
            return;
        }
        this.nativeDestoryAuxiliaryStreamingContext(nvsStreamingContext);
    }

    public boolean destroyHumanDetectionHandle(NvsHumanDetectionHandle nvsHumanDetectionHandle) {
        NvsUtils.checkFunctionInMainThread();
        return NvsStreamingContext.nativeDestroyHumanDetectionHandle(nvsHumanDetectionHandle);
    }

    public float detectEngineRenderFramePerSecond() {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeDetectEngineRenderFramePerSecond();
    }

    public int detectVideoFileKeyframeInterval(String string2) {
        return this.nativeDetectVideoFileKeyframeInterval(string2);
    }

    public boolean exportTemplateInfo(String string2, NvsTimeline nvsTimeline, int n10) {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeExportTemplateInfo(string2, nvsTimeline, n10);
    }

    public boolean extendHumanDetectionHandle(NvsHumanDetectionHandle nvsHumanDetectionHandle, String string2, String string3, long l10) {
        NvsUtils.checkFunctionInMainThread();
        return NvsStreamingContext.nativeExtendHumanDetectionHandle(nvsHumanDetectionHandle, string2, string3, l10);
    }

    public boolean generateTemplatePackage(String string2, String string3, String string4) {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGenerateTemplatePackage(string2, string3, string4);
    }

    public NvsAVFileInfo getAVFileInfo(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        return this.nativeGetAVFileInfo(string2, 0, stringBuilder);
    }

    public NvsAVFileInfo getAVFileInfo(String string2, int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        return this.nativeGetAVFileInfo(string2, n10, stringBuilder);
    }

    public NvsAVFileInfo getAVFileInfoWithError(String string2, int n10, StringBuilder stringBuilder) {
        return this.nativeGetAVFileInfo(string2, n10, stringBuilder);
    }

    public List getAllBuiltinAudioFxNames() {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetAllBuiltinAudioFxNames();
    }

    public List getAllBuiltinCaptureAudioFxNames() {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetAllBuiltinCaptureAudioFxNames();
    }

    public List getAllBuiltinCaptureVideoFxNames() {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetAllBuiltinCaptureVideoFxNames();
    }

    public List getAllBuiltinVideoFxNames() {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetAllBuiltinVideoFxNames();
    }

    public List getAllBuiltinVideoTransitionNames() {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetAllBuiltinVideoTransitionNames();
    }

    public NvsAssetPackageManager getAssetPackageManager() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_assetPackageManager;
    }

    public NvsFxDescription getAudioFxDescription(String string2) {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetAudioFxDescription(string2);
    }

    public int getAudioStreamCountInMediaFile(String string2) {
        return this.nativeGetAudioStreamCountInMediaFile(string2);
    }

    public String getBeautyVideoFxName() {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetBeautyVideoFxName();
    }

    public NvsCaptureAnimatedSticker getCaptureAnimatedStickerByIndex(int n10) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetCaptureAnimatedStickerByIndex(n10);
    }

    public int getCaptureAnimatedStickerCount() {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return 0;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetCaptureAnimatedStickerCount();
    }

    public NvsCaptureAudioFx getCaptureAudioFxByIndex(int n10) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetCaptureAudioFxByIndex(n10);
    }

    public int getCaptureAudioFxCount() {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return 0;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetCaptureAudioFxCount();
    }

    public NvsCaptureCaption getCaptureCaptionByIndex(int n10) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetCaptureCaptionByIndex(n10);
    }

    public int getCaptureCaptionCount() {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return 0;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetCaptureCaptionCount();
    }

    public NvsCaptureCompoundCaption getCaptureCompoundCaptionByIndex(int n10) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetCaptureCompoundCaptionByIndex(n10);
    }

    public int getCaptureCompoundCaptionCount() {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return 0;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetCaptureCompoundCaptionCount();
    }

    public NvsStreamingContext$CaptureDeviceCapability getCaptureDeviceCapability(int n10) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetCaptureDeviceCapability(n10);
    }

    public int getCaptureDeviceCount() {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return 0;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetCaptureDeviceCount();
    }

    public NvsSize getCapturePreviewVideoSize(int n10) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            NvsSize nvsSize = new NvsSize(0, 0);
            return nvsSize;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetCapturePreviewVideoSize(n10);
    }

    public NvsCaptureVideoFx getCaptureVideoFxByIndex(int n10) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetCaptureVideoFxByIndex(n10);
    }

    public int getCaptureVideoFxCount() {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return 0;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetCaptureVideoFxCount();
    }

    public Hashtable getCompileConfigurations() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_compileConfigurations;
    }

    public float getCompileVideoBitrateMultiplier() {
        NvsUtils.checkFunctionInMainThread();
        return this.m_compileVideoBitrateMultiplier;
    }

    public String getCurrentCaptureSceneId() {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetCurrentCaptureSceneId();
    }

    public int getCustomCompileVideoHeight() {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetCustomCompileVideoHeight();
    }

    public String getDefaultThemeEndingLogoImageFilePath() {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetDefaultThemeEndingLogoImageFilePath();
    }

    public String getDefaultVideoTransitionName() {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetDefaultVideoTransitionName();
    }

    public int getEngineHDRCaps() {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetEngineHDRCaps();
    }

    public int getExposureCompensation() {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return 0;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetExposureCompensation();
    }

    public int getFlashMode() {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return 1;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetFlashMode();
    }

    public List getFontInfoByFilePath(String string2) {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetFontInfoByFilePath(string2);
    }

    public long getInternalObject() {
        return this.m_internalObject;
    }

    public float getRecordVideoBitrateMultiplier() {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return 1.0f;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.m_recordVideoBitrateMultiplier;
    }

    public NvsStreamingContext$SdkVersion getSdkVersion() {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetSdkVersion();
    }

    public int getStreamingEngineState() {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetStreamingEngineState();
    }

    public long getTimelineCurrentPosition(NvsTimeline nvsTimeline) {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetTimelineCurrentPosition(nvsTimeline);
    }

    public NvsFxDescription getVideoFxDescription(String string2) {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetVideoFxDescription(string2);
    }

    public int getVideoStabilization() {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return 0;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetVideoStabilization();
    }

    public int getZoom() {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return 1;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGetZoom();
    }

    public Bitmap grabImageFromTimeline(NvsTimeline nvsTimeline, long l10, NvsRational nvsRational) {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGrabImageFromTimeline(nvsTimeline, l10, nvsRational, 0);
    }

    public Bitmap grabImageFromTimeline(NvsTimeline nvsTimeline, long l10, NvsRational nvsRational, int n10) {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGrabImageFromTimeline(nvsTimeline, l10, nvsRational, n10);
    }

    public boolean grabImageFromTimelineAsync(NvsTimeline nvsTimeline, long l10, NvsRational nvsRational, int n10) {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeGrabImageFromTimelineAsyncMode(nvsTimeline, l10, nvsRational, n10);
    }

    public NvsCaptureVideoFx insertBeautyCaptureVideoFx(int n10) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        String string2 = this.getBeautyVideoFxName();
        return this.insertBuiltinCaptureVideoFx(string2, n10);
    }

    public NvsCaptureAudioFx insertBuiltinCaptureAudioFx(String string2, int n10) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeInsertBuiltinCaptureAudioFx(string2, n10);
    }

    public NvsCaptureVideoFx insertBuiltinCaptureVideoFx(String string2, int n10) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeInsertBuiltinCaptureVideoFx(string2, n10);
    }

    public NvsCaptureAnimatedSticker insertCaptureAnimatedSticker(long l10, long l11, String string2, int n10) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeInsertCaptureAnimatedSticker(l10, l11, string2, n10);
    }

    public NvsCaptureCaption insertCaptureCaption(String string2, long l10, long l11, String string3, int n10) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeInsertCaptureCaption(string2, l10, l11, string3, n10);
    }

    public NvsCaptureCompoundCaption insertCaptureCompoundCaption(long l10, long l11, String string2, int n10) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeInsertCaptureCompoundCaption(l10, l11, string2, n10);
    }

    public NvsCaptureCaption insertCaptureModularCaption(String string2, long l10, long l11, int n10) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeInsertCaptureModularCaption(string2, l10, l11, n10);
    }

    public NvsCaptureVideoFx insertCustomCaptureVideoFx(NvsCustomVideoFx$Renderer nvsCustomVideoFx$Renderer, int n10) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeInsertCustomCaptureVideoFx(nvsCustomVideoFx$Renderer, n10);
    }

    public NvsCaptureVideoFx insertPackagedCaptureVideoFx(String string2, int n10) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return null;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeInsertPackagedCaptureVideoFx(string2, n10);
    }

    public boolean isAuxiliaryContext() {
        return this.m_isAuxiliaryContext;
    }

    public boolean isBlackFrame(Bitmap bitmap) {
        double d10;
        double d11;
        Object object;
        Object object2;
        if (bitmap == null) {
            object2 = "Meicam";
            object = "isBlackFrame: The bitmap is null!!";
            Log.e((String)object2, (String)object);
        }
        int n10 = 480;
        object = this.scaleBitmap(bitmap, n10);
        int n11 = object.getWidth();
        int n12 = object.getHeight();
        int n13 = n11 * n12;
        object2 = new int[n13];
        int n14 = 0;
        int n15 = 0;
        Object object3 = n11;
        object.getPixels((int[])object2, 0, n11, 0, 0, n11, n12);
        object = new double[n13];
        boolean bl2 = false;
        for (int i10 = 0; i10 < n13; ++i10) {
            object3 = object2[i10];
            n14 = Color.red((int)object3);
            n15 = Color.green((int)object3);
            n11 = Color.blue((int)object3);
            object3 = Color.alpha((int)object3);
            n14 = n14 + n15 + n11;
            d11 = n14;
            double d12 = (double)object3 * 1.0 / 255.0;
            d11 *= d12;
            double d13 = 3.0;
            object[i10] = d11 /= d13;
        }
        double d14 = this.getAverage((double[])object, n13);
        double d15 = this.getVariance((double[])object, n13, d14);
        d11 = 26.0;
        double d16 = d14 - d11;
        n13 = (int)(d16 == 0.0 ? 0 : (d16 < 0.0 ? -1 : 1));
        if (n13 <= 0 && (n13 = (int)((d10 = d15 - (d14 = 100.0)) == 0.0 ? 0 : (d10 < 0.0 ? -1 : 1))) <= 0) {
            bl2 = true;
        }
        return bl2;
    }

    public boolean isCaptureDeviceBackFacing(int n10) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeIsCaptureDeviceBackFacing(n10);
    }

    public boolean isCompilingPaused() {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeIsCompilingPaused();
    }

    public boolean isDefaultCaptionFade() {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeIsDefaultCaptionFade();
    }

    public boolean isFlashOn() {
        int n10 = this.m_isAuxiliaryContext;
        if (n10 != 0) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        n10 = this.nativeGetFlashMode();
        int n11 = 8;
        return n10 == n11;
    }

    public boolean isPlaybackPaused() {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeIsPlaybackPaused();
    }

    public boolean isRecordingPaused() {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeIsRecordingPaused();
    }

    public boolean isSdkAuthorised() {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeIsSdkAuthorised();
    }

    public boolean pauseCompiling() {
        NvsUtils.checkFunctionInMainThread();
        return this.nativePauseResumeCompiling(true);
    }

    public boolean pausePlayback() {
        NvsUtils.checkFunctionInMainThread();
        return this.nativePauseResumePlayback(true);
    }

    public boolean pauseRecording() {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativePauseResumeRecording(true);
    }

    public boolean playbackTimeline(NvsTimeline nvsTimeline, long l10, long l11, int n10, boolean bl2, int n11) {
        long l12;
        long l13;
        long l14;
        NvsUtils.checkFunctionInMainThread();
        if (nvsTimeline == null) {
            return false;
        }
        long l15 = 0L;
        long l16 = l10 - l15;
        Object object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object >= 0 && (object = (l14 = l10 - (l13 = nvsTimeline.getDuration())) == 0L ? 0 : (l14 < 0L ? -1 : 1)) < 0 && ((l12 = l11 == l15 ? 0 : (l11 < l15 ? -1 : 1)) < 0 || (l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1)) < 0)) {
            return this.nativePlaybackTimeline(nvsTimeline, l10, l11, n10, bl2, n11);
        }
        NvsStreamingContext$TimelineTimestampCallback nvsStreamingContext$TimelineTimestampCallback = this.m_timelineTimestampCallback;
        if (nvsStreamingContext$TimelineTimestampCallback != null) {
            nvsStreamingContext$TimelineTimestampCallback.onTimestampOutOfRange(nvsTimeline);
        }
        return false;
    }

    public boolean playbackTimeline(NvsTimeline nvsTimeline, long l10, long l11, NvsRational nvsRational, boolean bl2, int n10) {
        long l12;
        long l13;
        long l14;
        NvsUtils.checkFunctionInMainThread();
        if (nvsTimeline == null) {
            return false;
        }
        long l15 = 0L;
        long l16 = l10 - l15;
        Object object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object >= 0 && (object = (l14 = l10 - (l13 = nvsTimeline.getDuration())) == 0L ? 0 : (l14 < 0L ? -1 : 1)) < 0 && ((l12 = l11 == l15 ? 0 : (l11 < l15 ? -1 : 1)) < 0 || (l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1)) < 0)) {
            return this.nativePlaybackTimelineWithProxyScale(nvsTimeline, l10, l11, nvsRational, bl2, n10);
        }
        NvsStreamingContext$TimelineTimestampCallback nvsStreamingContext$TimelineTimestampCallback = this.m_timelineTimestampCallback;
        if (nvsStreamingContext$TimelineTimestampCallback != null) {
            nvsStreamingContext$TimelineTimestampCallback.onTimestampOutOfRange(nvsTimeline);
        }
        return false;
    }

    public boolean preloadEffectResources() {
        NvsUtils.checkFunctionInMainThread();
        return this.nativePreloadEffectResources();
    }

    public String registerFontByFilePath(String string2) {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeRegisterFontByFilePath(string2);
    }

    public void removeAllCaptureAnimatedSticker() {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return;
        }
        NvsUtils.checkFunctionInMainThread();
        this.nativeRemoveAllCaptureAnimatedSticker();
    }

    public void removeAllCaptureAudioFx() {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return;
        }
        NvsUtils.checkFunctionInMainThread();
        this.nativeRemoveAllCaptureAudioFx();
    }

    public void removeAllCaptureCaption() {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return;
        }
        NvsUtils.checkFunctionInMainThread();
        this.nativeRemoveAllCaptureCaption();
    }

    public void removeAllCaptureCompoundCaption() {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return;
        }
        NvsUtils.checkFunctionInMainThread();
        this.nativeRemoveAllCaptureCompoundCaption();
    }

    public void removeAllCaptureVideoFx() {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return;
        }
        NvsUtils.checkFunctionInMainThread();
        this.nativeRemoveAllCaptureVideoFx();
    }

    public boolean removeCaptureAnimatedSticker(int n10) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeRemoveCaptureAnimatedSticker(n10);
    }

    public boolean removeCaptureAudioFx(int n10) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeRemoveCaptureAudioFx(n10);
    }

    public boolean removeCaptureCaption(int n10) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeRemoveCaptureCaption(n10);
    }

    public boolean removeCaptureCompoundCaption(int n10) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeRemoveCaptureCompoundCaption(n10);
    }

    public boolean removeCaptureVideoFx(int n10) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeRemoveCaptureVideoFx(n10);
    }

    public void removeCurrentCaptureScene() {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return;
        }
        NvsUtils.checkFunctionInMainThread();
        this.nativeRemoveCurrentCaptureScene();
    }

    public boolean removeTimeline(NvsTimeline nvsTimeline) {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeRemoveTimeline(nvsTimeline);
    }

    public void removeUserWatermarkForCapture() {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return;
        }
        NvsUtils.checkFunctionInMainThread();
        this.nativeSetUserWatermarkForCapture(null, 0, 0, 0.0f, 0, 0, 0);
    }

    public boolean resumeCompiling() {
        NvsUtils.checkFunctionInMainThread();
        return this.nativePauseResumeCompiling(false);
    }

    public boolean resumePlayback() {
        NvsUtils.checkFunctionInMainThread();
        return this.nativePauseResumePlayback(false);
    }

    public boolean resumeRecording() {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativePauseResumeRecording(false);
    }

    public NvsColor sampleColorFromCapturedVideoFrame(RectF rectF) {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeSampleColorFromCapturedVideoFrame(rectF);
    }

    public boolean seekTimeline(NvsTimeline nvsTimeline, long l10, int n10, int n11) {
        long l11;
        NvsUtils.checkFunctionInMainThread();
        if (nvsTimeline == null) {
            return false;
        }
        long l12 = 0L;
        long l13 = l10 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object >= 0 && (object = (l11 = l10 - (l12 = nvsTimeline.getDuration())) == 0L ? 0 : (l11 < 0L ? -1 : 1)) < 0) {
            return this.nativeSeekTimeline(nvsTimeline, l10, n10, n11);
        }
        NvsStreamingContext$TimelineTimestampCallback nvsStreamingContext$TimelineTimestampCallback = this.m_timelineTimestampCallback;
        if (nvsStreamingContext$TimelineTimestampCallback != null) {
            nvsStreamingContext$TimelineTimestampCallback.onTimestampOutOfRange(nvsTimeline);
        }
        return false;
    }

    public boolean seekTimeline(NvsTimeline nvsTimeline, long l10, NvsRational nvsRational, int n10) {
        long l11;
        NvsUtils.checkFunctionInMainThread();
        if (nvsTimeline == null) {
            return false;
        }
        long l12 = 0L;
        long l13 = l10 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object >= 0 && (object = (l11 = l10 - (l12 = nvsTimeline.getDuration())) == 0L ? 0 : (l11 < 0L ? -1 : 1)) < 0) {
            return this.nativeSeekTimelineWithProxyScale(nvsTimeline, l10, nvsRational, n10);
        }
        NvsStreamingContext$TimelineTimestampCallback nvsStreamingContext$TimelineTimestampCallback = this.m_timelineTimestampCallback;
        if (nvsStreamingContext$TimelineTimestampCallback != null) {
            nvsStreamingContext$TimelineTimestampCallback.onTimestampOutOfRange(nvsTimeline);
        }
        return false;
    }

    public boolean sendBufferToCapturePreview(byte[] byArray, long l10) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return false;
        }
        return this.sendBufferToCapturePreview(byArray, l10, 0);
    }

    public boolean sendBufferToCapturePreview(byte[] byArray, long l10, int n10) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return false;
        }
        return this.nativeSendBufferToCapturePreview(byArray, l10, n10);
    }

    public void setAudioOutputCallback(NvsStreamingContext$AudioOutputCallback nvsStreamingContext$AudioOutputCallback) {
        NvsUtils.checkFunctionInMainThread();
        this.m_audioOutputCallback = nvsStreamingContext$AudioOutputCallback;
        this.nativeSetAudioOutputCallback(nvsStreamingContext$AudioOutputCallback);
    }

    public void setAudioOutputDeviceVolume(float f10) {
        NvsUtils.checkFunctionInMainThread();
        this.nativeSetAudioOutputDeviceVolume(f10);
    }

    public void setAutoExposureRect(RectF rectF) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return;
        }
        NvsUtils.checkFunctionInMainThread();
        this.nativeSetAutoExposureRect(rectF);
    }

    public void setCaptureDeviceCallback(NvsStreamingContext$CaptureDeviceCallback nvsStreamingContext$CaptureDeviceCallback) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return;
        }
        NvsUtils.checkFunctionInMainThread();
        this.m_catpureDeviceCallback = nvsStreamingContext$CaptureDeviceCallback;
        NvsStreamingContext.nativeSetCaptureDeviceCallback(nvsStreamingContext$CaptureDeviceCallback);
    }

    public void setCaptureFps(int n10) {
        NvsUtils.checkFunctionInMainThread();
        this.nativeSetCaptureFps(n10);
    }

    public void setCaptureRecordingDurationCallback(NvsStreamingContext$CaptureRecordingDurationCallback nvsStreamingContext$CaptureRecordingDurationCallback) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return;
        }
        NvsUtils.checkFunctionInMainThread();
        this.m_captureRecordingDurationCallback = nvsStreamingContext$CaptureRecordingDurationCallback;
        NvsStreamingContext.nativeSetCaptureRecordingDurationCallback(nvsStreamingContext$CaptureRecordingDurationCallback);
    }

    public void setCaptureRecordingFrameReachedCallback(NvsStreamingContext$CaptureRecordingFrameReachedCallback nvsStreamingContext$CaptureRecordingFrameReachedCallback) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return;
        }
        NvsUtils.checkFunctionInMainThread();
        this.m_captureRecordingFrameReachedCallback = nvsStreamingContext$CaptureRecordingFrameReachedCallback;
        NvsStreamingContext.nativeSetCaptureRecordingFrameReachedCallback(nvsStreamingContext$CaptureRecordingFrameReachedCallback);
    }

    public void setCaptureRecordingStartedCallback(NvsStreamingContext$CaptureRecordingStartedCallback nvsStreamingContext$CaptureRecordingStartedCallback) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return;
        }
        NvsUtils.checkFunctionInMainThread();
        this.m_captureRecordingStartedCallback = nvsStreamingContext$CaptureRecordingStartedCallback;
        NvsStreamingContext.nativeSetCaptureRecordingStartedCallback(nvsStreamingContext$CaptureRecordingStartedCallback);
    }

    public void setCapturedPictureCallback(NvsStreamingContext$CapturedPictureCallback nvsStreamingContext$CapturedPictureCallback) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return;
        }
        NvsUtils.checkFunctionInMainThread();
        this.m_catpuredPictureCallback = nvsStreamingContext$CapturedPictureCallback;
        NvsStreamingContext.nativeSetCapturedPictureCallback(nvsStreamingContext$CapturedPictureCallback);
    }

    public void setCapturedVideoFrameGrabberCallback(NvsStreamingContext$CapturedVideoFrameGrabberCallback nvsStreamingContext$CapturedVideoFrameGrabberCallback) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return;
        }
        NvsUtils.checkFunctionInMainThread();
        this.m_catpuredVideoFrameGrabberCallback = nvsStreamingContext$CapturedVideoFrameGrabberCallback;
        NvsStreamingContext.nativeSetCapturedVideoFrameGrabberCallback(nvsStreamingContext$CapturedVideoFrameGrabberCallback);
    }

    public void setCompileCallback(NvsStreamingContext$CompileCallback nvsStreamingContext$CompileCallback) {
        NvsUtils.checkFunctionInMainThread();
        this.m_compileCallback = nvsStreamingContext$CompileCallback;
        this.nativeSetCompileCallback(nvsStreamingContext$CompileCallback);
    }

    public void setCompileCallback2(NvsStreamingContext$CompileCallback2 nvsStreamingContext$CompileCallback2) {
        NvsUtils.checkFunctionInMainThread();
        this.m_compileCallback2 = nvsStreamingContext$CompileCallback2;
        this.nativeSetCompileCallback2(nvsStreamingContext$CompileCallback2);
    }

    public void setCompileCallback3(NvsStreamingContext$CompileCallback3 nvsStreamingContext$CompileCallback3) {
        NvsUtils.checkFunctionInMainThread();
        this.m_compileCallback3 = nvsStreamingContext$CompileCallback3;
        this.nativeSetCompileCallback3(nvsStreamingContext$CompileCallback3);
    }

    public void setCompileConfigurations(Hashtable hashtable) {
        NvsUtils.checkFunctionInMainThread();
        this.m_compileConfigurations = hashtable;
    }

    public void setCompileFloatProgressCallback(NvsStreamingContext$CompileFloatProgressCallback nvsStreamingContext$CompileFloatProgressCallback) {
        NvsUtils.checkFunctionInMainThread();
        this.m_compileFloatProgressCallback = nvsStreamingContext$CompileFloatProgressCallback;
        this.nativeSetCompileFloatProgressCallback(nvsStreamingContext$CompileFloatProgressCallback);
    }

    public void setCompileVideoBitrateMultiplier(float f10) {
        NvsUtils.checkFunctionInMainThread();
        float f11 = f10 - 0.0f;
        float f12 = f11 == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1);
        if (f12 <= 0) {
            return;
        }
        this.m_compileVideoBitrateMultiplier = f10;
    }

    public void setCustomCompileVideoHeight(int n10) {
        NvsUtils.checkFunctionInMainThread();
        this.nativeSetCustomCompileVideoHeight(n10);
    }

    public void setDefaultAudioTransitionName(String string2) {
        NvsUtils.checkFunctionInMainThread();
        this.nativeSetDefaultAudioTransitionName(string2);
    }

    public void setDefaultCaptionFade(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        this.nativeSetDefaultCaptionFade(bl2);
    }

    public boolean setDefaultThemeEndingLogoImageFilePath(String string2) {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeSetDefaultThemeEndingLogoImageFilePath(string2);
    }

    public void setExposureCompensation(int n10) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return;
        }
        NvsUtils.checkFunctionInMainThread();
        this.nativeSetExposureCompensation(n10);
    }

    public void setHardwareErrorCallback(NvsStreamingContext$HardwareErrorCallback nvsStreamingContext$HardwareErrorCallback) {
        NvsUtils.checkFunctionInMainThread();
        this.m_hardwareErrorCallback = nvsStreamingContext$HardwareErrorCallback;
        this.nativeSetHardwareErrorCallback(nvsStreamingContext$HardwareErrorCallback);
    }

    public void setImageGrabberCallback(NvsStreamingContext$ImageGrabberCallback nvsStreamingContext$ImageGrabberCallback) {
        NvsUtils.checkFunctionInMainThread();
        this.nativeSetImageGrabberCallback(nvsStreamingContext$ImageGrabberCallback);
    }

    public void setImageReaderCount(int n10) {
        NvsUtils.checkFunctionInMainThread();
        NvsStreamingContext.nativeSetImageReaderCount(n10);
    }

    public void setInternalObject(long l10) {
        this.m_internalObject = l10;
    }

    public void setMediaCodecIconReaderEnabled(String string2, boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        this.nativeSetMediaCodecIconReaderEnabled(string2, bl2);
    }

    public void setMediaCodecVideoDecodingOperatingRate(String string2, int n10) {
        NvsUtils.checkFunctionInMainThread();
        this.nativeSetMediaCodecVideoDecodingOperatingRate(string2, n10);
    }

    public void setPlaybackCallback(NvsStreamingContext$PlaybackCallback nvsStreamingContext$PlaybackCallback) {
        NvsUtils.checkFunctionInMainThread();
        this.m_playbackCallback = nvsStreamingContext$PlaybackCallback;
        this.nativeSetPlaybackCallback(nvsStreamingContext$PlaybackCallback);
    }

    public void setPlaybackCallback2(NvsStreamingContext$PlaybackCallback2 nvsStreamingContext$PlaybackCallback2) {
        NvsUtils.checkFunctionInMainThread();
        this.m_playbackCallback2 = nvsStreamingContext$PlaybackCallback2;
        this.nativeSetPlaybackCallback2(nvsStreamingContext$PlaybackCallback2);
    }

    public void setPlaybackDelayCallback(NvsStreamingContext$PlaybackDelayCallback nvsStreamingContext$PlaybackDelayCallback) {
        NvsUtils.checkFunctionInMainThread();
        this.m_playbackDelayCallback = nvsStreamingContext$PlaybackDelayCallback;
        this.nativeSetPlaybackDelayCallback(nvsStreamingContext$PlaybackDelayCallback);
    }

    public void setPlaybackExceptionCallback(NvsStreamingContext$PlaybackExceptionCallback nvsStreamingContext$PlaybackExceptionCallback) {
        NvsUtils.checkFunctionInMainThread();
        this.m_playbackExceptionCallback = nvsStreamingContext$PlaybackExceptionCallback;
        this.nativeSetPlaybackExceptionCallback(nvsStreamingContext$PlaybackExceptionCallback);
    }

    public void setRecordVideoBitrateMultiplier(float f10) {
        int n10 = this.m_isAuxiliaryContext;
        if (n10 != 0) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return;
        }
        NvsUtils.checkFunctionInMainThread();
        float f11 = f10 - 0.0f;
        n10 = f11 == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1);
        if (n10 <= 0) {
            return;
        }
        this.m_recordVideoBitrateMultiplier = f10;
    }

    public void setSeekingCallback(NvsStreamingContext$SeekingCallback nvsStreamingContext$SeekingCallback) {
        NvsUtils.checkFunctionInMainThread();
        this.m_seekingCallback = nvsStreamingContext$SeekingCallback;
        this.nativeSetSeekingCallback(nvsStreamingContext$SeekingCallback);
    }

    public void setStreamingEngineCallback(NvsStreamingContext$StreamingEngineCallback nvsStreamingContext$StreamingEngineCallback) {
        NvsUtils.checkFunctionInMainThread();
        this.m_streamingEngineCallback = nvsStreamingContext$StreamingEngineCallback;
        this.nativeSetStreamingEngineCallback(nvsStreamingContext$StreamingEngineCallback);
    }

    public boolean setThemeEndingEnabled(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        return this.nativeSetThemeEndingEnabled(bl2);
    }

    public void setTimelineTimestampCallback(NvsStreamingContext$TimelineTimestampCallback nvsStreamingContext$TimelineTimestampCallback) {
        NvsUtils.checkFunctionInMainThread();
        this.m_timelineTimestampCallback = nvsStreamingContext$TimelineTimestampCallback;
    }

    public void setUserWatermarkForCapture(String string2, int n10, int n11, float f10, int n12, int n13, int n14) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return;
        }
        NvsUtils.checkFunctionInMainThread();
        this.nativeSetUserWatermarkForCapture(string2, n10, n11, f10, n12, n13, n14);
    }

    public void setVideoStabilization(int n10) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return;
        }
        NvsUtils.checkFunctionInMainThread();
        this.nativeSetVideoStabilization(n10);
    }

    public void setZoom(int n10) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return;
        }
        NvsUtils.checkFunctionInMainThread();
        this.nativeSetZoom(n10);
    }

    public void startAutoFocus(RectF rectF) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return;
        }
        NvsUtils.checkFunctionInMainThread();
        this.nativeStartAutoFocus(rectF);
    }

    public boolean startBufferCapturePreview(int n10, int n11, NvsRational nvsRational, int n12, boolean bl2) {
        boolean bl3 = this.m_isAuxiliaryContext;
        if (bl3) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeStartBufferCapturePreview(n10, n11, nvsRational, n12, bl2);
    }

    public boolean startCapturePreview(int n10, int n11, int n12, NvsRational nvsRational) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        bl2 = this.checkCameraPermission();
        if (!bl2) {
            return false;
        }
        return this.nativeStartCapturePreview(n10, n11, n12, nvsRational);
    }

    public boolean startCapturePreviewForLiveStreaming(int n10, int n11, int n12, NvsRational nvsRational, String string2) {
        return false;
    }

    public boolean startCapturePreviewWithSpecialSize(int n10, int n11, int n12, NvsSize nvsSize) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        bl2 = this.checkCameraPermission();
        if (!bl2) {
            return false;
        }
        return this.nativeStartCapturePreviewWithSpecialSize(n10, n11, n12, nvsSize);
    }

    public boolean startDualBufferCapturePreview(SurfaceTexture surfaceTexture, int n10, int n11, int n12, int n13, int n14, boolean bl2, int n15, NvsRational nvsRational, int n16) {
        int n17 = this.m_isAuxiliaryContext;
        if (n17 != 0) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        if (surfaceTexture == null) {
            return false;
        }
        NvAndroidVirtualCameraSurfaceTexture nvAndroidVirtualCameraSurfaceTexture = new NvAndroidVirtualCameraSurfaceTexture(surfaceTexture);
        n17 = n10;
        boolean bl3 = this.nativeStartDualBufferCapturePreview(n10, n11, n12, n13, n14, bl2, n15, nvsRational, n16, nvAndroidVirtualCameraSurfaceTexture);
        if (!bl3) {
            nvAndroidVirtualCameraSurfaceTexture.release();
            return false;
        }
        return true;
    }

    public boolean startRecording(String string2) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        bl2 = this.checkCameraPermission();
        if (!bl2) {
            return false;
        }
        float f10 = this.m_recordVideoBitrateMultiplier;
        return this.nativeStartRecording(string2, f10, 0, 0, 0);
    }

    public boolean startRecording(String string2, int n10) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        bl2 = this.checkCameraPermission();
        if (!bl2) {
            return false;
        }
        float f10 = this.m_recordVideoBitrateMultiplier;
        return this.nativeStartRecording(string2, f10, 0, 0, n10);
    }

    public boolean startRecording(String string2, int n10, Hashtable serializable) {
        int n11;
        int n12;
        Object object;
        int n13 = this.m_isAuxiliaryContext;
        int n14 = 0;
        if (n13 != 0) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        n13 = this.checkCameraPermission();
        if (n13 == 0) {
            return false;
        }
        if (serializable != null) {
            Number number = (Number)((Hashtable)serializable).get("bitrate");
            if (number != null) {
                n13 = number.intValue();
            } else {
                n13 = 0;
                number = null;
            }
            object = "gopsize";
            serializable = (Number)((Hashtable)serializable).get(object);
            if (serializable != null) {
                n14 = ((Number)serializable).intValue();
            }
            n12 = n13;
            n11 = n14;
        } else {
            n12 = 0;
            n11 = 0;
        }
        float f10 = this.m_recordVideoBitrateMultiplier;
        object = this;
        return this.nativeStartRecording(string2, f10, n12, n11, n10);
    }

    public void stop() {
        NvsUtils.checkFunctionInMainThread();
        this.nativeStop(0);
    }

    public void stop(int n10) {
        NvsUtils.checkFunctionInMainThread();
        this.nativeStop(n10);
    }

    public void stopRecording() {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return;
        }
        NvsUtils.checkFunctionInMainThread();
        this.nativeStopRecording(true);
    }

    public void stopRecording(boolean bl2) {
        NvsUtils.checkFunctionInMainThread();
        this.nativeStopRecording(bl2);
    }

    public boolean takePicture(int n10) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return false;
        }
        NvsUtils.checkFunctionInMainThread();
        return this.nativeTakePicture(n10);
    }

    public void toggleFlash(boolean bl2) {
        boolean bl3 = this.m_isAuxiliaryContext;
        if (bl3) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return;
        }
        NvsUtils.checkFunctionInMainThread();
        if (bl2) {
            int n10 = 8;
            this.nativeToggleFlashMode(n10);
        } else {
            int n11 = 1;
            this.nativeToggleFlashMode(n11);
        }
    }

    public void toggleFlashMode(int n10) {
        boolean bl2 = this.m_isAuxiliaryContext;
        if (bl2) {
            Log.e((String)"Meicam", (String)"The auxiliary streaming context can not support capture!!");
            return;
        }
        NvsUtils.checkFunctionInMainThread();
        this.nativeToggleFlashMode(n10);
    }
}

