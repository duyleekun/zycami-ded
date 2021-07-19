/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package b.a.a;

import android.content.Context;
import androidx.camera.camera2.Camera2Config;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraDeviceSurfaceManager$Provider;
import java.util.Set;

public final class b
implements CameraDeviceSurfaceManager$Provider {
    public static final /* synthetic */ b a;

    static {
        b b10;
        a = b10 = new b();
    }

    public final CameraDeviceSurfaceManager newInstance(Context context, Object object, Set set) {
        return Camera2Config.a(context, object, set);
    }
}

