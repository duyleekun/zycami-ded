/*
 * Decompiled with CFR 0.151.
 */
package b.a.d;

import androidx.camera.view.ForwardingLiveData;
import androidx.lifecycle.Observer;

public final class a
implements Observer {
    public final /* synthetic */ ForwardingLiveData a;

    public /* synthetic */ a(ForwardingLiveData forwardingLiveData) {
        this.a = forwardingLiveData;
    }

    public final void onChanged(Object object) {
        this.a.setValue(object);
    }
}

