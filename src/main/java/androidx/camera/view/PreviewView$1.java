/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 *  android.widget.FrameLayout
 */
package androidx.camera.view;

import android.util.Size;
import android.widget.FrameLayout;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview$SurfaceProvider;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.SurfaceRequest$TransformationInfo;
import androidx.camera.core.SurfaceRequest$TransformationInfoListener;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Observable$Observer;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.view.PreviewStreamStateObserver;
import androidx.camera.view.PreviewTransformation;
import androidx.camera.view.PreviewView;
import androidx.camera.view.PreviewView$ImplementationMode;
import androidx.camera.view.PreviewView$StreamState;
import androidx.camera.view.PreviewViewImplementation;
import androidx.camera.view.PreviewViewImplementation$OnSurfaceNotInUseListener;
import androidx.camera.view.SurfaceViewImplementation;
import androidx.camera.view.TextureViewImplementation;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.MutableLiveData;
import b.a.d.h;
import b.a.d.i;
import b.a.d.j;
import java.util.concurrent.Executor;

public class PreviewView$1
implements Preview$SurfaceProvider {
    public final /* synthetic */ PreviewView this$0;

    public PreviewView$1(PreviewView previewView) {
        this.this$0 = previewView;
    }

    private /* synthetic */ void a(SurfaceRequest surfaceRequest) {
        this.this$0.mSurfaceProvider.onSurfaceRequested(surfaceRequest);
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void c(CameraInternal object, SurfaceRequest surfaceRequest, SurfaceRequest$TransformationInfo surfaceRequest$TransformationInfo) {
        void var6_9;
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("Preview transformation info updated. ");
        ((StringBuilder)object2).append(surfaceRequest$TransformationInfo);
        object2 = ((StringBuilder)object2).toString();
        String string2 = "PreviewView";
        Logger.d(string2, (String)object2);
        object = object.getCameraInfoInternal().getLensFacing();
        int bl2 = (Integer)object;
        if (bl2 == 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            object = null;
        }
        object2 = this.this$0.mPreviewTransform;
        surfaceRequest = surfaceRequest.getResolution();
        ((PreviewTransformation)object2).setTransformationInfo(surfaceRequest$TransformationInfo, (Size)surfaceRequest, (boolean)var6_9);
        this.this$0.redrawPreview();
    }

    private /* synthetic */ void e(PreviewStreamStateObserver previewStreamStateObserver, CameraInternal cameraInternal) {
        Object object = this.this$0.mActiveStreamStateObserver;
        boolean bl2 = object.compareAndSet(previewStreamStateObserver, null);
        if (bl2) {
            object = PreviewView$StreamState.IDLE;
            previewStreamStateObserver.updatePreviewStreamState((PreviewView$StreamState)((Object)object));
        }
        previewStreamStateObserver.clear();
        cameraInternal.getCameraState().removeObserver(previewStreamStateObserver);
    }

    public /* synthetic */ void b(SurfaceRequest surfaceRequest) {
        this.a(surfaceRequest);
    }

    public /* synthetic */ void d(CameraInternal cameraInternal, SurfaceRequest surfaceRequest, SurfaceRequest$TransformationInfo surfaceRequest$TransformationInfo) {
        this.c(cameraInternal, surfaceRequest, surfaceRequest$TransformationInfo);
    }

    public /* synthetic */ void f(PreviewStreamStateObserver previewStreamStateObserver, CameraInternal cameraInternal) {
        this.e(previewStreamStateObserver, cameraInternal);
    }

    public void onSurfaceRequested(SurfaceRequest surfaceRequest) {
        Object object;
        Object object2;
        boolean bl2 = Threads.isMainThread();
        if (!bl2) {
            Executor executor = ContextCompat.getMainExecutor(this.this$0.getContext());
            j j10 = new j(this, surfaceRequest);
            executor.execute(j10);
            return;
        }
        Logger.d("PreviewView", "Surface requested by Preview.");
        CameraInternal cameraInternal = surfaceRequest.getCamera();
        Object object3 = ContextCompat.getMainExecutor(this.this$0.getContext());
        Object object4 = new i(this, cameraInternal, surfaceRequest);
        surfaceRequest.setTransformationInfoListener((Executor)object3, (SurfaceRequest$TransformationInfoListener)object4);
        object3 = this.this$0;
        object4 = ((PreviewView)object3).mImplementationMode;
        boolean bl3 = ((PreviewView)((Object)object3)).shouldUseTextureView(surfaceRequest, (PreviewView$ImplementationMode)((Object)object4));
        if (bl3) {
            object2 = this.this$0;
            object = object2.mPreviewTransform;
            object4 = new TextureViewImplementation((FrameLayout)object2, (PreviewTransformation)object);
        } else {
            object2 = this.this$0;
            object = object2.mPreviewTransform;
            object4 = new SurfaceViewImplementation((FrameLayout)object2, (PreviewTransformation)object);
        }
        ((PreviewView)object3).mImplementation = object4;
        object4 = (CameraInfoInternal)cameraInternal.getCameraInfo();
        object2 = this.this$0;
        object = object2.mPreviewStreamStateLiveData;
        object2 = object2.mImplementation;
        object3 = new PreviewStreamStateObserver((CameraInfoInternal)object4, (MutableLiveData)object, (PreviewViewImplementation)object2);
        this.this$0.mActiveStreamStateObserver.set(object3);
        object4 = cameraInternal.getCameraState();
        object2 = ContextCompat.getMainExecutor(this.this$0.getContext());
        object4.addObserver((Executor)object2, (Observable$Observer)object3);
        object4 = this.this$0.mImplementation;
        object2 = new h(this, (PreviewStreamStateObserver)object3, cameraInternal);
        ((PreviewViewImplementation)object4).onSurfaceRequested(surfaceRequest, (PreviewViewImplementation$OnSurfaceNotInUseListener)object2);
    }
}

