/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package d.v.b;

import android.graphics.Bitmap;
import com.zhiyun.android.CameraYun;

public final class n
implements Runnable {
    public final /* synthetic */ CameraYun a;
    public final /* synthetic */ Bitmap b;

    public /* synthetic */ n(CameraYun cameraYun, Bitmap bitmap) {
        this.a = cameraYun;
        this.b = bitmap;
    }

    public final void run() {
        CameraYun cameraYun = this.a;
        Bitmap bitmap = this.b;
        cameraYun.u0(bitmap);
    }
}

