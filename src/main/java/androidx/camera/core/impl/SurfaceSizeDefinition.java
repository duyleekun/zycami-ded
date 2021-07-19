/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 */
package androidx.camera.core.impl;

import android.util.Size;
import androidx.camera.core.impl.AutoValue_SurfaceSizeDefinition;

public abstract class SurfaceSizeDefinition {
    public static SurfaceSizeDefinition create(Size size, Size size2, Size size3) {
        AutoValue_SurfaceSizeDefinition autoValue_SurfaceSizeDefinition = new AutoValue_SurfaceSizeDefinition(size, size2, size3);
        return autoValue_SurfaceSizeDefinition;
    }

    public abstract Size getAnalysisSize();

    public abstract Size getPreviewSize();

    public abstract Size getRecordSize();
}

