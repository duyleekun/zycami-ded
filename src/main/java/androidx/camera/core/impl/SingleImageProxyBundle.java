/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.ImageProxyBundle;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.List;

public final class SingleImageProxyBundle
implements ImageProxyBundle {
    private final int mCaptureId;
    private final ImageProxy mImageProxy;

    public SingleImageProxyBundle(ImageProxy imageProxy, int n10) {
        this.mCaptureId = n10;
        this.mImageProxy = imageProxy;
    }

    public SingleImageProxyBundle(ImageProxy object, String object2) {
        Object object3 = object.getImageInfo();
        if (object3 != null) {
            object2 = ((TagBundle)(object3 = object3.getTagBundle())).getTag((String)object2);
            if (object2 != null) {
                int n10;
                this.mCaptureId = n10 = ((Integer)object2).intValue();
                this.mImageProxy = object;
                return;
            }
            object = new IllegalArgumentException("ImageProxy has no associated tag");
            throw object;
        }
        object = new IllegalArgumentException("ImageProxy has no associated ImageInfo");
        throw object;
    }

    public void close() {
        this.mImageProxy.close();
    }

    public List getCaptureIds() {
        return Collections.singletonList(this.mCaptureId);
    }

    public ListenableFuture getImageProxy(int n10) {
        int n11 = this.mCaptureId;
        if (n10 != n11) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Capture id does not exist in the bundle");
            return Futures.immediateFailedFuture(illegalArgumentException);
        }
        return Futures.immediateFuture(this.mImageProxy);
    }
}

