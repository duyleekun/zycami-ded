/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.e;

import androidx.camera.camera2.interop.Camera2CameraFilter;
import androidx.camera.camera2.interop.Camera2CameraFilter$Camera2Filter;
import androidx.camera.core.CameraFilter;
import java.util.List;

public final class i
implements CameraFilter {
    public final /* synthetic */ Camera2CameraFilter$Camera2Filter a;

    public /* synthetic */ i(Camera2CameraFilter$Camera2Filter camera2CameraFilter$Camera2Filter) {
        this.a = camera2CameraFilter$Camera2Filter;
    }

    public final List filter(List list) {
        return Camera2CameraFilter.a(this.a, list);
    }
}

