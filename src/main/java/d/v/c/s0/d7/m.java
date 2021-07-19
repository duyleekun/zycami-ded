/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.d7;

import androidx.lifecycle.Observer;
import d.v.c.s0.d7.u;

public final class m
implements Observer {
    public final /* synthetic */ u a;

    public /* synthetic */ m(u u10) {
        this.a = u10;
    }

    public final void onChanged(Object reStreamChannelArray) {
        u u10 = this.a;
        reStreamChannelArray = reStreamChannelArray;
        u10.t(reStreamChannelArray);
    }
}

