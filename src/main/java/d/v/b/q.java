/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Point
 */
package d.v.b;

import android.graphics.Point;
import com.zhiyun.android.CameraYun;
import d.v.b.c0.e$a;

public final class q
implements e$a {
    public final /* synthetic */ CameraYun a;

    public /* synthetic */ q(CameraYun cameraYun) {
        this.a = cameraYun;
    }

    public final void a(Object object, int n10) {
        CameraYun cameraYun = this.a;
        object = (Point)object;
        cameraYun.M((Point)object, n10);
    }
}

