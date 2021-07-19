/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.camera.CameraFragment;
import com.zhiyun.cama.camera.data.CameraSet$Theme;

public final class m5
implements Observer {
    public static final /* synthetic */ m5 a;

    static {
        m5 m52;
        a = m52 = new m5();
    }

    public final void onChanged(Object object) {
        CameraFragment.D3((CameraSet$Theme)((Object)object));
    }
}

