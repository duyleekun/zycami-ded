/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.Chronometer
 *  android.widget.Chronometer$OnChronometerTickListener
 */
package d.v.c.s0;

import android.widget.Chronometer;
import com.zhiyun.cama.camera.CameraFragment;

public final class v4
implements Chronometer.OnChronometerTickListener {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ v4(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final void onChronometerTick(Chronometer chronometer) {
        this.a.H5(chronometer);
    }
}

