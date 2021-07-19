/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 */
package b.a.b;

import android.util.Size;
import androidx.camera.core.Preview;
import androidx.camera.core.impl.PreviewConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionConfig$ErrorListener;
import androidx.camera.core.impl.SessionConfig$SessionError;

public final class u0
implements SessionConfig$ErrorListener {
    public final /* synthetic */ Preview a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PreviewConfig c;
    public final /* synthetic */ Size d;

    public /* synthetic */ u0(Preview preview, String string2, PreviewConfig previewConfig, Size size) {
        this.a = preview;
        this.b = string2;
        this.c = previewConfig;
        this.d = size;
    }

    public final void onError(SessionConfig sessionConfig, SessionConfig$SessionError sessionConfig$SessionError) {
        Preview preview = this.a;
        String string2 = this.b;
        PreviewConfig previewConfig = this.c;
        Size size = this.d;
        preview.b(string2, previewConfig, size, sessionConfig, sessionConfig$SessionError);
    }
}

