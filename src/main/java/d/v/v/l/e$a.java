/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.l;

import com.meicam.sdk.NvsStreamingContext$StreamingEngineCallback;
import com.meicam.sdk.NvsTimeline;
import d.v.h.h.b;
import d.v.v.l.e;

public class e$a
implements NvsStreamingContext$StreamingEngineCallback {
    public final /* synthetic */ e a;

    public e$a(e e10) {
        this.a = e10;
    }

    public void onFirstVideoFramePresented(NvsTimeline object) {
        object = this.a;
        boolean bl2 = e.j((e)object);
        if (bl2 && (object = e.q(this.a)) != null) {
            object = this.a;
            b b10 = e.q((e)object);
            ((e)object).d(b10);
            object = this.a;
            b10 = null;
            e.k((e)object, false);
        }
    }

    public void onStreamingEngineStateChanged(int n10) {
    }
}

