/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Size
 */
package androidx.camera.camera2.internal;

import android.content.Context;
import android.util.Size;
import androidx.camera.camera2.internal.CamcorderProfileHelper;
import androidx.camera.camera2.internal.SupportedSurfaceCombination;
import androidx.camera.camera2.internal.compat.CameraManagerCompat;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.core.util.Preconditions;
import b.a.a.d.k0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class Camera2DeviceSurfaceManager
implements CameraDeviceSurfaceManager {
    private static final String TAG = "Camera2DeviceSurfaceManager";
    private final CamcorderProfileHelper mCamcorderProfileHelper;
    private final Map mCameraSupportedSurfaceCombinationMap;

    public Camera2DeviceSurfaceManager(Context context, CamcorderProfileHelper camcorderProfileHelper, Object object, Set set) {
        HashMap hashMap;
        this.mCameraSupportedSurfaceCombinationMap = hashMap = new HashMap();
        Preconditions.checkNotNull(camcorderProfileHelper);
        this.mCamcorderProfileHelper = camcorderProfileHelper;
        boolean bl2 = object instanceof CameraManagerCompat;
        object = bl2 ? (CameraManagerCompat)object : CameraManagerCompat.from(context);
        this.init(context, (CameraManagerCompat)object, set);
    }

    public Camera2DeviceSurfaceManager(Context context, Object object, Set set) {
        k0 k02 = k0.a;
        this(context, k02, object, set);
    }

    private void init(Context context, CameraManagerCompat cameraManagerCompat, Set object) {
        boolean bl2;
        Preconditions.checkNotNull(context);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            String string2 = (String)object.next();
            Map map = this.mCameraSupportedSurfaceCombinationMap;
            CamcorderProfileHelper camcorderProfileHelper = this.mCamcorderProfileHelper;
            SupportedSurfaceCombination supportedSurfaceCombination = new SupportedSurfaceCombination(context, string2, cameraManagerCompat, camcorderProfileHelper);
            map.put(string2, supportedSurfaceCombination);
        }
    }

    public boolean checkSupported(String object, List list) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            object = (SupportedSurfaceCombination)this.mCameraSupportedSurfaceCombinationMap.get(object);
            bl2 = false;
            if (object != null) {
                bl2 = ((SupportedSurfaceCombination)object).checkSupported(list);
            }
            return bl2;
        }
        return true;
    }

    public Map getSuggestedResolutions(String string2, List object, List object2) {
        int n10;
        boolean bl2 = object2.isEmpty() ^ true;
        Preconditions.checkArgument(bl2, "No new use cases to be bound.");
        Serializable serializable = new ArrayList(object);
        Object object3 = object2.iterator();
        while ((n10 = object3.hasNext()) != 0) {
            n10 = ((UseCaseConfig)object3.next()).getInputFormat();
            int n11 = 640;
            int n12 = 480;
            Size size = new Size(n11, n12);
            SurfaceConfig surfaceConfig = this.transformSurfaceConfig(string2, n10, size);
            serializable.add(surfaceConfig);
        }
        object3 = (SupportedSurfaceCombination)this.mCameraSupportedSurfaceCombinationMap.get(string2);
        if (object3 != null) {
            bl2 = ((SupportedSurfaceCombination)object3).checkSupported((List)((Object)serializable));
            if (bl2) {
                return ((SupportedSurfaceCombination)object3).getSuggestedResolutions((List)object, (List)object2);
            }
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("No supported surface combination is found for camera device - Id : ");
            ((StringBuilder)object3).append(string2);
            ((StringBuilder)object3).append(".  May be attempting to bind too many use cases. Existing surfaces: ");
            ((StringBuilder)object3).append(object);
            ((StringBuilder)object3).append(" New configs: ");
            ((StringBuilder)object3).append(object2);
            string2 = ((StringBuilder)object3).toString();
            serializable = new IllegalArgumentException(string2);
            throw serializable;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("No such camera id in supported combination list: ");
        ((StringBuilder)object2).append(string2);
        string2 = ((StringBuilder)object2).toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public SurfaceConfig transformSurfaceConfig(String object, int n10, Size size) {
        Map map = this.mCameraSupportedSurfaceCombinationMap;
        object = (object = (SupportedSurfaceCombination)map.get(object)) != null ? ((SupportedSurfaceCombination)object).transformSurfaceConfig(n10, size) : null;
        return object;
    }
}

