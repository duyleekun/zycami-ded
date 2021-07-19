/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.CameraFragment;

public final class w3
implements Observer {
    public static final /* synthetic */ w3 a;

    static {
        w3 w32;
        a = w32 = new w3();
    }

    public final void onChanged(Object object) {
        CameraFragment.A1((Boolean)object);
    }
}

