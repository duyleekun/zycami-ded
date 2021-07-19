/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.util.Size
 */
package androidx.camera.core;

import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Size;
import androidx.camera.core.Preview$1;
import androidx.camera.core.Preview$Builder;
import androidx.camera.core.Preview$Defaults;
import androidx.camera.core.Preview$SurfaceProvider;
import androidx.camera.core.ProcessingSurface;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.SurfaceRequest$TransformationInfo;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.core.impl.CaptureStage$DefaultCaptureStage;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageInfoProcessor;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.PreviewConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionConfig$Builder;
import androidx.camera.core.impl.SessionConfig$ErrorListener;
import androidx.camera.core.impl.SessionConfig$SessionError;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfig$Builder;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.UseCaseConfigFactory$CaptureType;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import b.a.b.a;
import b.a.b.u0;
import b.a.b.v0;
import java.util.concurrent.Executor;

public final class Preview
extends UseCase {
    public static final Preview$Defaults DEFAULT_CONFIG;
    private static final Executor DEFAULT_SURFACE_PROVIDER_EXECUTOR;
    private static final String TAG = "Preview";
    public SurfaceRequest mCurrentSurfaceRequest;
    private boolean mHasUnsentSurfaceRequest;
    private DeferrableSurface mSessionDeferrableSurface;
    private Preview$SurfaceProvider mSurfaceProvider;
    private Executor mSurfaceProviderExecutor;
    private Size mSurfaceSize;

    static {
        Preview$Defaults preview$Defaults;
        DEFAULT_CONFIG = preview$Defaults = new Preview$Defaults();
        DEFAULT_SURFACE_PROVIDER_EXECUTOR = CameraXExecutors.mainThreadExecutor();
    }

    public Preview(PreviewConfig object) {
        super((UseCaseConfig)object);
        this.mSurfaceProviderExecutor = object = DEFAULT_SURFACE_PROVIDER_EXECUTOR;
        this.mHasUnsentSurfaceRequest = false;
    }

    private /* synthetic */ void a(String object, PreviewConfig previewConfig, Size size, SessionConfig sessionConfig, SessionConfig$SessionError sessionConfig$SessionError) {
        boolean bl2 = this.isCurrentCamera((String)object);
        if (bl2) {
            object = this.createPipeline((String)object, previewConfig, size).build();
            this.updateSessionConfig((SessionConfig)object);
            this.notifyReset();
        }
    }

    public static /* synthetic */ void c(Preview$SurfaceProvider preview$SurfaceProvider, SurfaceRequest surfaceRequest) {
        preview$SurfaceProvider.onSurfaceRequested(surfaceRequest);
    }

    private Rect getCropRect(Size size) {
        Rect rect = this.getViewPortCropRect();
        if (rect != null) {
            return this.getViewPortCropRect();
        }
        if (size != null) {
            int n10 = size.getWidth();
            int n11 = size.getHeight();
            rect = new Rect(0, 0, n10, n11);
            return rect;
        }
        return null;
    }

    private boolean sendSurfaceRequestIfReady() {
        SurfaceRequest surfaceRequest = this.mCurrentSurfaceRequest;
        Preview$SurfaceProvider preview$SurfaceProvider = this.mSurfaceProvider;
        if (preview$SurfaceProvider != null && surfaceRequest != null) {
            Executor executor = this.mSurfaceProviderExecutor;
            v0 v02 = new v0(preview$SurfaceProvider, surfaceRequest);
            executor.execute(v02);
            return true;
        }
        return false;
    }

    private void sendTransformationInfoIfReady() {
        Object object = this.getCamera();
        Preview$SurfaceProvider preview$SurfaceProvider = this.mSurfaceProvider;
        Size size = this.mSurfaceSize;
        size = this.getCropRect(size);
        SurfaceRequest surfaceRequest = this.mCurrentSurfaceRequest;
        if (object != null && preview$SurfaceProvider != null && size != null) {
            int n10 = this.getRelativeRotation((CameraInternal)object);
            int n11 = this.getTargetRotation();
            object = SurfaceRequest$TransformationInfo.of((Rect)size, n10, n11);
            surfaceRequest.updateTransformationInfo((SurfaceRequest$TransformationInfo)object);
        }
    }

    private void updateConfigAndOutput(String object, PreviewConfig previewConfig, Size size) {
        object = this.createPipeline((String)object, previewConfig, size).build();
        this.updateSessionConfig((SessionConfig)object);
    }

    public /* synthetic */ void b(String string2, PreviewConfig previewConfig, Size size, SessionConfig sessionConfig, SessionConfig$SessionError sessionConfig$SessionError) {
        this.a(string2, previewConfig, size, sessionConfig, sessionConfig$SessionError);
    }

    public SessionConfig$Builder createPipeline(String string2, PreviewConfig previewConfig, Size size) {
        Preview preview = this;
        PreviewConfig previewConfig2 = previewConfig;
        Size size2 = size;
        Threads.checkMainThread();
        SessionConfig$Builder sessionConfig$Builder = SessionConfig$Builder.createFrom(previewConfig);
        int n10 = 0;
        Object object = null;
        CaptureProcessor captureProcessor = previewConfig.getCaptureProcessor(null);
        Object object2 = this.mSessionDeferrableSurface;
        if (object2 != null) {
            ((DeferrableSurface)object2).close();
        }
        Object object3 = this.getCamera();
        int n11 = 1;
        int n12 = captureProcessor != null ? n11 : 0;
        preview.mCurrentSurfaceRequest = object2 = new SurfaceRequest(size2, (CameraInternal)object3, n12 != 0);
        int n13 = this.sendSurfaceRequestIfReady();
        if (n13 != 0) {
            this.sendTransformationInfoIfReady();
        } else {
            preview.mHasUnsentSurfaceRequest = n11;
        }
        if (captureProcessor != null) {
            String string3;
            object = new CaptureStage$DefaultCaptureStage();
            HandlerThread handlerThread = new HandlerThread("CameraX-preview_processing");
            handlerThread.start();
            String string4 = Integer.toString(object.hashCode());
            n13 = size.getWidth();
            n11 = size.getHeight();
            n12 = previewConfig.getInputFormat();
            Object object4 = handlerThread.getLooper();
            Handler handler = new Handler(object4);
            DeferrableSurface deferrableSurface = ((SurfaceRequest)object2).getDeferrableSurface();
            object2 = string3;
            object4 = object;
            ProcessingSurface processingSurface = string3;
            string3 = string4;
            object2 = new ProcessingSurface(n13, n11, n12, handler, (CaptureStage)object, captureProcessor, deferrableSurface, string4);
            object2 = ((ProcessingSurface)object2).getCameraCaptureCallback();
            sessionConfig$Builder.addCameraCaptureCallback((CameraCaptureCallback)object2);
            object2 = processingSurface.getTerminationFuture();
            object3 = new a(handlerThread);
            Executor executor = CameraXExecutors.directExecutor();
            object2.addListener((Runnable)object3, executor);
            object2 = processingSurface;
            preview.mSessionDeferrableSurface = processingSurface;
            n10 = object.getId();
            object = n10;
            sessionConfig$Builder.addTag(string4, (Integer)object);
        } else {
            object = previewConfig2.getImageInfoProcessor(null);
            if (object != null) {
                object3 = new Preview$1(preview, (ImageInfoProcessor)object);
                sessionConfig$Builder.addCameraCaptureCallback((CameraCaptureCallback)object3);
            }
            preview.mSessionDeferrableSurface = object = ((SurfaceRequest)object2).getDeferrableSurface();
        }
        object = preview.mSessionDeferrableSurface;
        sessionConfig$Builder.addSurface((DeferrableSurface)object);
        object2 = string2;
        object = new u0(preview, string2, previewConfig2, size2);
        sessionConfig$Builder.addErrorListener((SessionConfig$ErrorListener)object);
        return sessionConfig$Builder;
    }

    public UseCaseConfig getDefaultConfig(boolean bl2, UseCaseConfigFactory object) {
        Config config;
        UseCaseConfigFactory$CaptureType useCaseConfigFactory$CaptureType = UseCaseConfigFactory$CaptureType.PREVIEW;
        object = object.getConfig(useCaseConfigFactory$CaptureType);
        if (bl2) {
            config = DEFAULT_CONFIG.getConfig();
            object = Config.mergeConfigs((Config)object, config);
        }
        if (object == null) {
            bl2 = false;
            config = null;
        } else {
            config = this.getUseCaseConfigBuilder((Config)object).getUseCaseConfig();
        }
        return config;
    }

    public int getTargetRotation() {
        return this.getTargetRotationInternal();
    }

    public UseCaseConfig$Builder getUseCaseConfigBuilder(Config config) {
        return Preview$Builder.fromConfig(config);
    }

    public void onDetached() {
        DeferrableSurface deferrableSurface = this.mSessionDeferrableSurface;
        if (deferrableSurface != null) {
            deferrableSurface.close();
        }
        this.mCurrentSurfaceRequest = null;
    }

    public UseCaseConfig onMergeConfig(CameraInfoInternal object, UseCaseConfig$Builder useCaseConfig$Builder) {
        object = useCaseConfig$Builder.getMutableConfig();
        Config$Option config$Option = PreviewConfig.OPTION_PREVIEW_CAPTURE_PROCESSOR;
        int n10 = 0;
        Integer n11 = null;
        if ((object = object.retrieveOption(config$Option, null)) != null) {
            object = useCaseConfig$Builder.getMutableConfig();
            config$Option = ImageInputConfig.OPTION_INPUT_FORMAT;
            n10 = 35;
            n11 = n10;
            object.insertOption(config$Option, n11);
        } else {
            object = useCaseConfig$Builder.getMutableConfig();
            config$Option = ImageInputConfig.OPTION_INPUT_FORMAT;
            n10 = 34;
            n11 = n10;
            object.insertOption(config$Option, n11);
        }
        return useCaseConfig$Builder.getUseCaseConfig();
    }

    public Size onSuggestedResolutionUpdated(Size size) {
        this.mSurfaceSize = size;
        String string2 = this.getCameraId();
        PreviewConfig previewConfig = (PreviewConfig)this.getCurrentConfig();
        Size size2 = this.mSurfaceSize;
        this.updateConfigAndOutput(string2, previewConfig, size2);
        return size;
    }

    public void setSurfaceProvider(Preview$SurfaceProvider preview$SurfaceProvider) {
        Executor executor = DEFAULT_SURFACE_PROVIDER_EXECUTOR;
        this.setSurfaceProvider(executor, preview$SurfaceProvider);
    }

    public void setSurfaceProvider(Executor object, Preview$SurfaceProvider object2) {
        Threads.checkMainThread();
        if (object2 == null) {
            boolean bl2 = false;
            object = null;
            this.mSurfaceProvider = null;
            this.notifyInactive();
        } else {
            this.mSurfaceProvider = object2;
            this.mSurfaceProviderExecutor = object;
            this.notifyActive();
            boolean bl3 = this.mHasUnsentSurfaceRequest;
            if (bl3) {
                bl3 = this.sendSurfaceRequestIfReady();
                if (bl3) {
                    this.sendTransformationInfoIfReady();
                    bl3 = false;
                    object = null;
                    this.mHasUnsentSurfaceRequest = false;
                }
            } else {
                object = this.getAttachedSurfaceResolution();
                if (object != null) {
                    object = this.getCameraId();
                    object2 = (PreviewConfig)this.getCurrentConfig();
                    Size size = this.getAttachedSurfaceResolution();
                    this.updateConfigAndOutput((String)object, (PreviewConfig)object2, size);
                    this.notifyReset();
                }
            }
        }
    }

    public void setTargetRotation(int n10) {
        if ((n10 = (int)(this.setTargetRotationInternal(n10) ? 1 : 0)) != 0) {
            this.sendTransformationInfoIfReady();
        }
    }

    public void setViewPortCropRect(Rect rect) {
        super.setViewPortCropRect(rect);
        this.sendTransformationInfoIfReady();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Preview:");
        String string2 = this.getName();
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

