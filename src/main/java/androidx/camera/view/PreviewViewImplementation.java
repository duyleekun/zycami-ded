/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.util.Size
 *  android.view.View
 *  android.widget.FrameLayout
 */
package androidx.camera.view;

import android.graphics.Bitmap;
import android.util.Size;
import android.view.View;
import android.widget.FrameLayout;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.PreviewTransformation;
import androidx.camera.view.PreviewViewImplementation$OnSurfaceNotInUseListener;
import com.google.common.util.concurrent.ListenableFuture;

public abstract class PreviewViewImplementation {
    public FrameLayout mParent;
    private final PreviewTransformation mPreviewTransform;
    public Size mResolution;

    public PreviewViewImplementation(FrameLayout frameLayout, PreviewTransformation previewTransformation) {
        this.mParent = frameLayout;
        this.mPreviewTransform = previewTransformation;
    }

    public Bitmap getBitmap() {
        Bitmap bitmap = this.getPreviewBitmap();
        if (bitmap == null) {
            return null;
        }
        PreviewTransformation previewTransformation = this.mPreviewTransform;
        int n10 = this.mParent.getWidth();
        int n11 = this.mParent.getHeight();
        Size size = new Size(n10, n11);
        n10 = this.mParent.getLayoutDirection();
        return previewTransformation.createTransformedBitmap(bitmap, size, n10);
    }

    public abstract View getPreview();

    public abstract Bitmap getPreviewBitmap();

    public abstract void initializePreview();

    public abstract void onAttachedToWindow();

    public abstract void onDetachedFromWindow();

    public void onSurfaceProvided() {
        this.redrawPreview();
    }

    public abstract void onSurfaceRequested(SurfaceRequest var1, PreviewViewImplementation$OnSurfaceNotInUseListener var2);

    public void redrawPreview() {
        View view = this.getPreview();
        if (view == null) {
            return;
        }
        PreviewTransformation previewTransformation = this.mPreviewTransform;
        int n10 = this.mParent.getWidth();
        int n11 = this.mParent.getHeight();
        Size size = new Size(n10, n11);
        n10 = this.mParent.getLayoutDirection();
        previewTransformation.transformView(size, n10, view);
    }

    public abstract ListenableFuture waitForNextFrame();
}

