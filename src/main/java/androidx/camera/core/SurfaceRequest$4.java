/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 */
package androidx.camera.core;

import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.SurfaceRequest$RequestCancelledException;
import androidx.camera.core.SurfaceRequest$Result;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;

public class SurfaceRequest$4
implements FutureCallback {
    public final /* synthetic */ SurfaceRequest this$0;
    public final /* synthetic */ Consumer val$resultListener;
    public final /* synthetic */ Surface val$surface;

    public SurfaceRequest$4(SurfaceRequest surfaceRequest, Consumer consumer, Surface surface) {
        this.this$0 = surfaceRequest;
        this.val$resultListener = consumer;
        this.val$surface = surface;
    }

    public void onFailure(Throwable object) {
        boolean bl2 = object instanceof SurfaceRequest$RequestCancelledException;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Camera surface session should only fail with request cancellation. Instead failed due to:\n");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        Preconditions.checkState(bl2, (String)object);
        object = this.val$resultListener;
        Object object2 = this.val$surface;
        object2 = SurfaceRequest$Result.of(1, object2);
        object.accept(object2);
    }

    public void onSuccess(Void object) {
        object = this.val$resultListener;
        Object object2 = this.val$surface;
        object2 = SurfaceRequest$Result.of(0, object2);
        object.accept(object2);
    }
}

