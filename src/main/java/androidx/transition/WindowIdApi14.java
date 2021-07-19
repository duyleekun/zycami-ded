/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 */
package androidx.transition;

import android.os.IBinder;
import androidx.transition.WindowIdImpl;

public class WindowIdApi14
implements WindowIdImpl {
    private final IBinder mToken;

    public WindowIdApi14(IBinder iBinder) {
        this.mToken = iBinder;
    }

    public boolean equals(Object object) {
        IBinder iBinder;
        boolean bl2;
        boolean bl3 = object instanceof WindowIdApi14;
        if (bl3 && (bl2 = (object = ((WindowIdApi14)object).mToken).equals(iBinder = this.mToken))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public int hashCode() {
        return this.mToken.hashCode();
    }
}

