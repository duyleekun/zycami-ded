/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 */
package d.v.b;

import android.util.Size;
import com.zhiyun.android.CameraYun;
import d.v.d.i.a.c$a;

public final class c
implements c$a {
    public final /* synthetic */ CameraYun a;

    public /* synthetic */ c(CameraYun cameraYun) {
        this.a = cameraYun;
    }

    public final void a(Object object, int n10) {
        CameraYun cameraYun = this.a;
        object = (Size)object;
        cameraYun.a0((Size)object, n10);
    }
}

