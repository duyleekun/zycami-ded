/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.PointF
 *  android.util.Size
 */
package androidx.camera.view;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.util.Size;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.view.PreviewTransformation;

public class PreviewViewMeteringPointFactory
extends MeteringPointFactory {
    public static final PointF INVALID_POINT;
    private Matrix mMatrix;
    private final PreviewTransformation mPreviewTransformation;

    static {
        PointF pointF;
        float f10 = 2.0f;
        INVALID_POINT = pointF = new PointF(f10, f10);
    }

    public PreviewViewMeteringPointFactory(PreviewTransformation previewTransformation) {
        this.mPreviewTransformation = previewTransformation;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public PointF convertPoint(float f10, float f11) {
        int n10 = 2;
        float[] fArray = new float[n10];
        float f12 = 0.0f;
        fArray[0] = f10;
        int n11 = 1;
        f10 = Float.MIN_VALUE;
        fArray[n11] = f11;
        synchronized (this) {
            Matrix matrix = this.mMatrix;
            if (matrix == null) {
                return INVALID_POINT;
            }
            matrix.mapPoints(fArray);
        }
        f12 = fArray[0];
        f10 = fArray[n11];
        return new PointF(f12, f10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void recalculate(Size size, int n10) {
        Threads.checkMainThread();
        synchronized (this) {
            int n11 = size.getWidth();
            if (n11 != 0 && (n11 = size.getHeight()) != 0) {
                PreviewTransformation previewTransformation = this.mPreviewTransformation;
                size = previewTransformation.getPreviewViewToNormalizedSurfaceMatrix(size, n10);
                this.mMatrix = size;
                return;
            }
            size = null;
            this.mMatrix = null;
            return;
        }
    }
}

