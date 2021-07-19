/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.n;

import androidx.arch.core.util.Function;
import com.zhiyun.cama.camera.data.CameraSet$Mode;
import com.zhiyun.cama.data.database.model.CameraParam;
import d.v.c.v0.n.d;

public final class b
implements Function {
    public final /* synthetic */ d a;
    public final /* synthetic */ int b;
    public final /* synthetic */ CameraSet$Mode c;

    public /* synthetic */ b(d d10, int n10, CameraSet$Mode cameraSet$Mode) {
        this.a = d10;
        this.b = n10;
        this.c = cameraSet$Mode;
    }

    public final Object apply(Object object) {
        d d10 = this.a;
        int n10 = this.b;
        CameraSet$Mode cameraSet$Mode = this.c;
        object = (CameraParam)object;
        return d10.O(n10, cameraSet$Mode, (CameraParam)object);
    }
}

