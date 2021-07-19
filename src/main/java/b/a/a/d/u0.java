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
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;

public final class u0
implements CallbackToFutureAdapter$Resolver {
    public final /* synthetic */ FocusMeteringControl a;
    public final /* synthetic */ FocusMeteringAction b;
    public final /* synthetic */ Rational c;

    public /* synthetic */ u0(FocusMeteringControl focusMeteringControl, FocusMeteringAction focusMeteringAction, Rational rational) {
        this.a = focusMeteringControl;
        this.b = focusMeteringAction;
        this.c = rational;
    }

    public final Object attachCompleter(CallbackToFutureAdapter$Completer callbackToFutureAdapter$Completer) {
        FocusMeteringControl focusMeteringControl = this.a;
        FocusMeteringAction focusMeteringAction = this.b;
        Rational rational = this.c;
        return focusMeteringControl.p(focusMeteringAction, rational, callbackToFutureAdapter$Completer);
    }
}

