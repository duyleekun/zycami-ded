/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionConfig$ErrorListener;

public final class s
implements Runnable {
    public final /* synthetic */ SessionConfig$ErrorListener a;
    public final /* synthetic */ SessionConfig b;

    public /* synthetic */ s(SessionConfig$ErrorListener sessionConfig$ErrorListener, SessionConfig sessionConfig) {
        this.a = sessionConfig$ErrorListener;
        this.b = sessionConfig;
    }

    public final void run() {
        SessionConfig$ErrorListener sessionConfig$ErrorListener = this.a;
        SessionConfig sessionConfig = this.b;
        Camera2CameraImpl.x(sessionConfig$ErrorListener, sessionConfig);
    }
}

