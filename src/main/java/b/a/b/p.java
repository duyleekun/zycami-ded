/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 */
package b.a.b;

import android.util.Size;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.impl.ImageAnalysisConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionConfig$ErrorListener;
import androidx.camera.core.impl.SessionConfig$SessionError;

public final class p
implements SessionConfig$ErrorListener {
    public final /* synthetic */ ImageAnalysis a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ImageAnalysisConfig c;
    public final /* synthetic */ Size d;

    public /* synthetic */ p(ImageAnalysis imageAnalysis, String string2, ImageAnalysisConfig imageAnalysisConfig, Size size) {
        this.a = imageAnalysis;
        this.b = string2;
        this.c = imageAnalysisConfig;
        this.d = size;
    }

    public final void onError(SessionConfig sessionConfig, SessionConfig$SessionError sessionConfig$SessionError) {
        ImageAnalysis imageAnalysis = this.a;
        String string2 = this.b;
        ImageAnalysisConfig imageAnalysisConfig = this.c;
        Size size = this.d;
        imageAnalysis.b(string2, imageAnalysisConfig, size, sessionConfig, sessionConfig$SessionError);
    }
}

