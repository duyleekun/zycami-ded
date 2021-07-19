/*
 * Decompiled with CFR 0.151.
 */
package b.a.a.e;

import androidx.camera.camera2.interop.CaptureRequestOptions$Builder;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Config$Option;
import androidx.camera.core.impl.Config$OptionMatcher;

public final class j
implements Config$OptionMatcher {
    public final /* synthetic */ CaptureRequestOptions$Builder a;
    public final /* synthetic */ Config b;

    public /* synthetic */ j(CaptureRequestOptions$Builder captureRequestOptions$Builder, Config config) {
        this.a = captureRequestOptions$Builder;
        this.b = config;
    }

    public final boolean onOptionMatched(Config$Option config$Option) {
        CaptureRequestOptions$Builder captureRequestOptions$Builder = this.a;
        Config config = this.b;
        return CaptureRequestOptions$Builder.a(captureRequestOptions$Builder, config, config$Option);
    }
}

