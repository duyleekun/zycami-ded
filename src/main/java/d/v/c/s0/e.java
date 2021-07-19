/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 */
package d.v.c.s0;

import android.widget.CompoundButton;
import com.zhiyun.cama.camera.CameraFragment;

public final class e
implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ CameraFragment a;

    public /* synthetic */ e(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean bl2) {
        this.a.N0(compoundButton, bl2);
    }
}

