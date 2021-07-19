/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.CountDownTimer
 */
package com.zhiyun.cama.camera.widget;

import android.os.CountDownTimer;
import com.zhiyun.cama.camera.widget.MutiNodeProgress;

public class MutiNodeProgress$a
extends CountDownTimer {
    public final /* synthetic */ MutiNodeProgress a;

    public MutiNodeProgress$a(MutiNodeProgress mutiNodeProgress, long l10, long l11) {
        this.a = mutiNodeProgress;
        super(l10, l11);
    }

    public void onFinish() {
        MutiNodeProgress.a(this.a, 100);
        this.a.invalidate();
    }

    public void onTick(long l10) {
        MutiNodeProgress.b(this.a);
        this.a.invalidate();
    }
}

