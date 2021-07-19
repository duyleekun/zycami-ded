/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Rational
 */
package b.a.a.d;

import android.util.Rational;
import androidx.camera.camera2.internal.FocusMeteringControl;
import androidx.camera.core.FocusMeteringAction;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;

public final class v0
implements Runnable {
    public final /* synthetic */ FocusMeteringControl a;
    public final /* synthetic */ CallbackToFutureAdapter$Completer b;
    public final /* synthetic */ FocusMeteringAction c;
    public final /* synthetic */ Rational d;

    public /* synthetic */ v0(FocusMeteringControl focusMeteringControl, CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer, FocusMeteringAction focusMeteringAction, Rational rational) {
        this.a = focusMeteringControl;
        this.b = callbackToFutureAdapter$Completer;
        this.c = focusMeteringAction;
        this.d = rational;
    }

    public final void run() {
        FocusMeteringControl focusMeteringControl = this.a;
        CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer = this.b;
        FocusMeteringAction focusMeteringAction = this.c;
        Rational rational = this.d;
        focusMeteringControl.n(callbackToFutureAdapter$Completer, focusMeteringAction, rational);
    }
}

