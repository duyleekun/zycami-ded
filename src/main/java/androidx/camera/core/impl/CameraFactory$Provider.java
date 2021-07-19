/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package androidx.camera.core.impl;

import android.content.Context;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.impl.CameraFactory;
import androidx.camera.core.impl.CameraThreadConfig;

public interface CameraFactory$Provider {
    public CameraFactory newInstance(Context var1, CameraThreadConfig var2, CameraSelector var3);
}

