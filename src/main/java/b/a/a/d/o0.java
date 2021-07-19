/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.d;

import androidx.camera.camera2.internal.FocusMeteringControl;

public final class o0
implements Runnable {
    public final /* synthetic */ FocusMeteringControl a;
    public final /* synthetic */ long b;

    public /* synthetic */ o0(FocusMeteringControl focusMeteringControl, long l10) {
        this.a = focusMeteringControl;
        this.b = l10;
    }

    public final void run() {
        FocusMeteringControl focusMeteringControl = this.a;
        long l10 = this.b;
        focusMeteringControl.j(l10);
    }
}

