/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 */
package androidx.camera.core.impl;

import android.util.Size;
import java.util.List;

public interface ImageOutputConfig$Builder {
    public Object setDefaultResolution(Size var1);

    public Object setMaxResolution(Size var1);

    public Object setSupportedResolutions(List var1);

    public Object setTargetAspectRatio(int var1);

    public Object setTargetResolution(Size var1);

    public Object setTargetRotation(int var1);
}

