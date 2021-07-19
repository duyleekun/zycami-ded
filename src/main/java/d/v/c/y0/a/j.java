/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y0.a;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.device.active.ActivationStateFragment;

public final class j
implements Observer {
    public static final /* synthetic */ j a;

    static {
        j j10;
        a = j10 = new j();
    }

    public final void onChanged(Object object) {
        ActivationStateFragment.o((String)object);
    }
}

