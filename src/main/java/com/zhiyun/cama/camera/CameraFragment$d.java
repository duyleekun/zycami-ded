/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera;

import androidx.activity.OnBackPressedCallback;
import com.zhiyun.cama.camera.CameraFragment;
import com.zhiyun.cama.camera.data.CameraSet$Mode;
import d.v.c.s0.d7.z;

public class CameraFragment$d
extends OnBackPressedCallback {
    public final /* synthetic */ CameraFragment a;

    public CameraFragment$d(CameraFragment cameraFragment, boolean bl2) {
        this.a = cameraFragment;
        super(bl2);
    }

    public void handleOnBackPressed() {
        int n10;
        int n11;
        CameraSet$Mode cameraSet$Mode;
        Object object = CameraFragment.H(this.a).I();
        if (object == (cameraSet$Mode = CameraSet$Mode.live) && (n11 = ((z)(object = CameraFragment.Q(this.a))).b0()) == (n10 = 1)) {
            CameraFragment.l(this.a).X(7);
            return;
        }
        this.setEnabled(false);
        this.a.requireActivity().onBackPressed();
    }
}

