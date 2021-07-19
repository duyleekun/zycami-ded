/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.q;

import com.meicam.sdk.NvsStreamingContext$CompileCallback;
import com.meicam.sdk.NvsTimeline;
import d.v.h.c.b$a;
import d.v.v.q.h;

public final class h$a
implements NvsStreamingContext$CompileCallback {
    public final /* synthetic */ b$a a;
    public final /* synthetic */ String b;

    public h$a(b$a b$a, String string2) {
        this.a = b$a;
        this.b = string2;
    }

    public void onCompileFailed(NvsTimeline nvsTimeline) {
        b$a b$a = this.a;
        if (b$a != null) {
            String string2 = "compose fail";
            Exception exception = new Exception(string2);
            b$a.a(exception, string2);
        }
        h.d().removeTimeline(nvsTimeline);
    }

    public void onCompileFinished(NvsTimeline nvsTimeline) {
        b$a b$a = this.a;
        if (b$a != null) {
            String string2 = this.b;
            b$a.c(string2);
        }
        h.d().removeTimeline(nvsTimeline);
    }

    public void onCompileProgress(NvsTimeline object, int n10) {
        object = this.a;
        if (object != null) {
            object.b(n10);
        }
    }
}

