/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package androidx.camera.camera2.internal.compat;

import android.os.Handler;
import java.util.HashMap;
import java.util.Map;

public final class CameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21 {
    public final Handler mCompatHandler;
    public final Map mWrapperMap;

    public CameraManagerCompatBaseImpl$CameraManagerCompatParamsApi21(Handler handler) {
        HashMap hashMap;
        this.mWrapperMap = hashMap = new HashMap();
        this.mCompatHandler = handler;
    }
}

