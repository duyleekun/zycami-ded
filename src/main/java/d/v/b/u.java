/*
 * Decompiled with CFR 0.151.
 */
package d.v.b;

import com.zhiyun.android.CameraView;

public final class u
implements Runnable {
    public final /* synthetic */ CameraView a;

    public /* synthetic */ u(CameraView cameraView) {
        this.a = cameraView;
    }

    public final void run() {
        this.a.requestLayout();
    }
}

