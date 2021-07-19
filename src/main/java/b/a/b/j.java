/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package b.a.b;

import android.content.Context;
import androidx.camera.core.CameraX;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;

public final class j
implements AsyncFunction {
    public final /* synthetic */ CameraX a;
    public final /* synthetic */ Context b;

    public /* synthetic */ j(CameraX cameraX, Context context) {
        this.a = cameraX;
        this.b = context;
    }

    public final ListenableFuture apply(Object object) {
        CameraX cameraX = this.a;
        Context context = this.b;
        object = (Void)object;
        return CameraX.j(cameraX, context, (Void)object);
    }
}

