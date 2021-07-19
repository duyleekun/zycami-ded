/*
 * Decompiled with CFR 0.151.
 */
package d.h.b.a;

import com.google.mediapipe.components.ExternalTextureConverter;

public final class d
implements Runnable {
    public final /* synthetic */ ExternalTextureConverter a;

    public /* synthetic */ d(ExternalTextureConverter externalTextureConverter) {
        this.a = externalTextureConverter;
    }

    public final void run() {
        this.a.b();
    }
}

