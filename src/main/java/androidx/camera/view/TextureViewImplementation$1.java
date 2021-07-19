/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.view.TextureView$SurfaceTextureListener
 */
package androidx.camera.view;

import android.graphics.SurfaceTexture;
import android.view.TextureView;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.view.TextureViewImplementation;
import androidx.camera.view.TextureViewImplementation$1$1;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

public class TextureViewImplementation$1
implements TextureView.SurfaceTextureListener {
    public final /* synthetic */ TextureViewImplementation this$0;

    public TextureViewImplementation$1(TextureViewImplementation textureViewImplementation) {
        this.this$0 = textureViewImplementation;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture object, int n10, int n11) {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "SurfaceTexture available. Size: ";
        stringBuilder.append(string2);
        stringBuilder.append(n10);
        stringBuilder.append("x");
        stringBuilder.append(n11);
        Object object2 = stringBuilder.toString();
        String string3 = "TextureViewImpl";
        Logger.d(string3, (String)object2);
        object2 = this.this$0;
        ((TextureViewImplementation)object2).mSurfaceTexture = object;
        object = ((TextureViewImplementation)object2).mSurfaceReleaseFuture;
        if (object != null) {
            Preconditions.checkNotNull(((TextureViewImplementation)object2).mSurfaceRequest);
            object = new StringBuilder();
            ((StringBuilder)object).append("Surface invalidated ");
            object2 = this.this$0.mSurfaceRequest;
            ((StringBuilder)object).append(object2);
            object = ((StringBuilder)object).toString();
            Logger.d(string3, (String)object);
            object = this.this$0.mSurfaceRequest.getDeferrableSurface();
            ((DeferrableSurface)object).close();
        } else {
            ((TextureViewImplementation)object2).tryToProvidePreviewSurface();
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        Object object = this.this$0;
        TextureViewImplementation$1$1 textureViewImplementation$1$1 = null;
        ((TextureViewImplementation)object).mSurfaceTexture = null;
        object = ((TextureViewImplementation)object).mSurfaceReleaseFuture;
        if (object != null) {
            textureViewImplementation$1$1 = new TextureViewImplementation$1$1(this, surfaceTexture);
            Executor executor = ContextCompat.getMainExecutor(this.this$0.mTextureView.getContext());
            Futures.addCallback((ListenableFuture)object, textureViewImplementation$1$1, executor);
            this.this$0.mDetachedSurfaceTexture = surfaceTexture;
            return false;
        }
        Logger.d("TextureViewImpl", "SurfaceTexture about to be destroyed");
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture object, int n10, int n11) {
        object = new StringBuilder();
        ((StringBuilder)object).append("SurfaceTexture size changed: ");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append("x");
        ((StringBuilder)object).append(n11);
        object = ((StringBuilder)object).toString();
        Logger.d("TextureViewImpl", (String)object);
    }

    public void onSurfaceTextureUpdated(SurfaceTexture object) {
        object = this.this$0.mNextFrameCompleter.getAndSet(null);
        if (object != null) {
            ((CallbackToFutureAdapter$Completer)object).set(null);
        }
    }
}

