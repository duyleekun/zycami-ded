/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 */
package androidx.camera.core.impl;

import android.util.Size;
import androidx.camera.core.impl.SurfaceConfig;
import java.util.List;
import java.util.Map;

public interface CameraDeviceSurfaceManager {
    public boolean checkSupported(String var1, List var2);

    public Map getSuggestedResolutions(String var1, List var2, List var3);

    public SurfaceConfig transformSurfaceConfig(String var1, int var2, Size var3);
}

