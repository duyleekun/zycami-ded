/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package b.a.a;

import android.content.Context;
import androidx.camera.camera2.Camera2Config;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.UseCaseConfigFactory$Provider;

public final class a
implements UseCaseConfigFactory$Provider {
    public static final /* synthetic */ a a;

    static {
        a a10;
        a = a10 = new a();
    }

    public final UseCaseConfigFactory newInstance(Context context) {
        return Camera2Config.b(context);
    }
}

