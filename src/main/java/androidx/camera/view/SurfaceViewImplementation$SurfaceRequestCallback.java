/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 *  android.view.Surface
 *  android.view.SurfaceHolder
 *  android.view.SurfaceHolder$Callback
 */
package androidx.camera.view;

import android.util.Size;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.SurfaceRequest$Result;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.view.SurfaceViewImplementation;
import androidx.core.content.ContextCompat;
import b.a.d.n;
import java.util.concurrent.Executor;

public class SurfaceViewImplementation$SurfaceRequestCallback
implements SurfaceHolder.Callback {
    private Size mCurrentSurfaceSize;
    private SurfaceRequest mSurfaceRequest;
    private Size mTargetSize;
    private boolean mWasSurfaceProvided = false;
    public final /* synthetic */ SurfaceViewImplementation this$0;

    public SurfaceViewImplementation$SurfaceRequestCallback(SurfaceViewImplementation surfaceViewImplementation) {
        this.this$0 = surfaceViewImplementation;
    }

    private /* synthetic */ void a(SurfaceRequest$Result surfaceRequest$Result) {
        Logger.d("SurfaceViewImpl", "Safe to release surface.");
        this.this$0.notifySurfaceNotInUse();
    }

    private boolean canProvideSurface() {
        Size size;
        SurfaceRequest surfaceRequest;
        boolean bl2 = this.mWasSurfaceProvided;
        if (!bl2 && (surfaceRequest = this.mSurfaceRequest) != null && (surfaceRequest = this.mTargetSize) != null && (bl2 = surfaceRequest.equals(size = this.mCurrentSurfaceSize))) {
            bl2 = true;
        } else {
            bl2 = false;
            surfaceRequest = null;
        }
        return bl2;
    }

    private void cancelPreviousRequest() {
        Object object = this.mSurfaceRequest;
        if (object != null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Request canceled: ");
            Object object2 = this.mSurfaceRequest;
            ((StringBuilder)object).append(object2);
            object = ((StringBuilder)object).toString();
            object2 = "SurfaceViewImpl";
            Logger.d((String)object2, (String)object);
            object = this.mSurfaceRequest;
            ((SurfaceRequest)object).willNotProvideSurface();
        }
    }

    private void invalidateSurface() {
        Object object = this.mSurfaceRequest;
        if (object != null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Surface invalidated ");
            Object object2 = this.mSurfaceRequest;
            ((StringBuilder)object).append(object2);
            object = ((StringBuilder)object).toString();
            object2 = "SurfaceViewImpl";
            Logger.d((String)object2, (String)object);
            object = this.mSurfaceRequest.getDeferrableSurface();
            ((DeferrableSurface)object).close();
        }
    }

    private boolean tryToComplete() {
        Surface surface = this.this$0.mSurfaceView.getHolder().getSurface();
        boolean bl2 = this.canProvideSurface();
        if (bl2) {
            boolean bl3;
            Logger.d("SurfaceViewImpl", "Surface set on Preview.");
            SurfaceRequest surfaceRequest = this.mSurfaceRequest;
            Executor executor = ContextCompat.getMainExecutor(this.this$0.mSurfaceView.getContext());
            n n10 = new n(this);
            surfaceRequest.provideSurface(surface, executor, n10);
            this.mWasSurfaceProvided = bl3 = true;
            this.this$0.onSurfaceProvided();
            return bl3;
        }
        return false;
    }

    public /* synthetic */ void b(SurfaceRequest$Result surfaceRequest$Result) {
        this.a(surfaceRequest$Result);
    }

    public void setSurfaceRequest(SurfaceRequest surfaceRequest) {
        this.cancelPreviousRequest();
        this.mSurfaceRequest = surfaceRequest;
        surfaceRequest = surfaceRequest.getResolution();
        this.mTargetSize = surfaceRequest;
        SurfaceHolder surfaceHolder = null;
        this.mWasSurfaceProvided = false;
        boolean bl2 = this.tryToComplete();
        if (!bl2) {
            String string2 = "Wait for new Surface creation.";
            Logger.d("SurfaceViewImpl", string2);
            surfaceHolder = this.this$0.mSurfaceView.getHolder();
            int n10 = surfaceRequest.getWidth();
            int n11 = surfaceRequest.getHeight();
            surfaceHolder.setFixedSize(n10, n11);
        }
    }

    public void surfaceChanged(SurfaceHolder object, int n10, int n11, int n12) {
        object = new StringBuilder();
        ((StringBuilder)object).append("Surface changed. Size: ");
        ((StringBuilder)object).append(n11);
        ((StringBuilder)object).append("x");
        ((StringBuilder)object).append(n12);
        object = ((StringBuilder)object).toString();
        Logger.d("SurfaceViewImpl", (String)object);
        object = new Size(n11, n12);
        this.mCurrentSurfaceSize = object;
        this.tryToComplete();
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Logger.d("SurfaceViewImpl", "Surface created.");
    }

    public void surfaceDestroyed(SurfaceHolder object) {
        object = "SurfaceViewImpl";
        String string2 = "Surface destroyed.";
        Logger.d((String)object, string2);
        boolean bl2 = this.mWasSurfaceProvided;
        if (bl2) {
            this.invalidateSurface();
        } else {
            this.cancelPreviousRequest();
        }
        this.mWasSurfaceProvided = false;
        this.mSurfaceRequest = null;
        this.mCurrentSurfaceSize = null;
        this.mTargetSize = null;
    }
}

