/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.PixelCopy$OnPixelCopyFinishedListener
 */
package b.a.d;

import android.view.PixelCopy;
import androidx.camera.view.SurfaceViewImplementation;

public final class m
implements PixelCopy.OnPixelCopyFinishedListener {
    public static final /* synthetic */ m a;

    static {
        m m10;
        a = m10 = new m();
    }

    public final void onPixelCopyFinished(int n10) {
        SurfaceViewImplementation.a(n10);
    }
}

