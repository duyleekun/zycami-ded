/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.CameraFragment;
import d.v.e.i.j;
import d.v.e.l.m2$b;
import e.a.s0.b;

public class CameraFragment$g
implements m2$b {
    public final /* synthetic */ CameraFragment a;

    public CameraFragment$g(CameraFragment cameraFragment) {
        this.a = cameraFragment;
    }

    public void a(Long object) {
        long l10;
        long l11;
        long l12 = (Long)object;
        long l13 = l12 - (l11 = (long)3);
        Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object2 <= 0 && (object2 = (l10 = (l12 = ((Long)object).longValue()) - (l11 = 0L)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) > 0) {
            CameraFragment cameraFragment = this.a;
            object = String.valueOf(object);
            CameraFragment.r(cameraFragment, (String)object);
        }
    }

    public void onComplete() {
        MutableLiveData mutableLiveData = CameraFragment.s((CameraFragment)this.a).d;
        Comparable<Boolean> comparable = Boolean.FALSE;
        mutableLiveData.setValue(comparable);
        mutableLiveData = CameraFragment.s((CameraFragment)this.a).c;
        comparable = Boolean.TRUE;
        mutableLiveData.setValue(comparable);
        mutableLiveData = CameraFragment.s((CameraFragment)this.a).e;
        comparable = 2131951812;
        ((j)mutableLiveData).setValue(comparable);
        CameraFragment.t(this.a, null);
    }

    public void onError(Throwable throwable) {
    }

    public void onSubscribe(b b10) {
    }
}

