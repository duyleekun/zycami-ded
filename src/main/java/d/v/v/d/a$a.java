/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.d;

import com.meicam.sdk.NvsStreamingContext$CompileCallback;
import com.meicam.sdk.NvsTimeline;
import d.v.v.d.a;

public class a$a
implements NvsStreamingContext$CompileCallback {
    public final /* synthetic */ a a;

    public a$a(a a10) {
        this.a = a10;
    }

    public void onCompileFailed(NvsTimeline object) {
        object = new Exception("compose fail");
        d.v.v.d.a.j(this.a, (Exception)object);
        d.v.v.d.a.d(this.a);
    }

    public void onCompileFinished(NvsTimeline object) {
        object = this.a;
        boolean bl2 = d.v.v.d.a.b((a)object);
        if (!bl2) {
            object = this.a;
            d.v.v.d.a.c((a)object);
        }
        d.v.v.d.a.d(this.a);
    }

    public void onCompileProgress(NvsTimeline nvsTimeline, int n10) {
        d.v.v.d.a.a(this.a, n10);
    }
}

