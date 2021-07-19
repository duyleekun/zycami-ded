/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera
 *  android.hardware.Camera$AutoFocusCallback
 */
package d.v.d.g.c;

import android.hardware.Camera;
import d.v.d.g.c.s;

public final class i
implements Camera.AutoFocusCallback {
    public final /* synthetic */ s a;

    public /* synthetic */ i(s s10) {
        this.a = s10;
    }

    public final void onAutoFocus(boolean bl2, Camera camera) {
        this.a.R(bl2, camera);
    }
}

