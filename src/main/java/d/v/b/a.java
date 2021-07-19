/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 */
package d.v.b;

import android.util.Size;
import com.zhiyun.android.CameraView;
import d.v.b.c0.e$a;

public final class a
implements e$a {
    public final /* synthetic */ CameraView a;

    public /* synthetic */ a(CameraView cameraView) {
        this.a = cameraView;
    }

    public final void a(Object object, int n10) {
        CameraView cameraView = this.a;
        object = (Size)object;
        cameraView.h((Size)object, n10);
    }
}

