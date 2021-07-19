/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.camera2.interop;

import androidx.camera.camera2.interop.Camera2CameraFilter$Camera2Filter;
import androidx.camera.camera2.interop.Camera2CameraInfo;
import androidx.camera.core.CameraFilter;
import androidx.camera.core.CameraInfo;
import b.a.a.e.i;
import java.util.Collections;
import java.util.List;

public final class Camera2CameraFilter {
    private Camera2CameraFilter() {
    }

    public static /* synthetic */ List a(Camera2CameraFilter$Camera2Filter object, List object2) {
        boolean bl2;
        Camera2CameraInfo camera2CameraInfo;
        boolean bl3;
        List<Object> list = new List<Object>();
        Object object3 = object2.iterator();
        while (bl3 = object3.hasNext()) {
            camera2CameraInfo = Camera2CameraInfo.from((CameraInfo)object3.next());
            list.add(camera2CameraInfo);
        }
        list = Collections.unmodifiableList(list);
        object = object.filter(list);
        list = new List<Object>();
        object2 = object2.iterator();
        while (bl2 = object2.hasNext()) {
            object3 = (CameraInfo)object2.next();
            camera2CameraInfo = Camera2CameraInfo.from((CameraInfo)object3);
            bl3 = object.contains(camera2CameraInfo);
            if (!bl3) continue;
            list.add(object3);
        }
        return list;
    }

    public static CameraFilter createCameraFilter(Camera2CameraFilter$Camera2Filter camera2CameraFilter$Camera2Filter) {
        i i10 = new i(camera2CameraFilter$Camera2Filter);
        return i10;
    }
}

