/*
 * Decompiled with CFR 0.151.
 */
package g;

import g.c0;
import g.f0;
import okio.ByteString;

public abstract class g0 {
    public void onClosed(f0 f02, int n10, String string2) {
        f.h2.t.f0.p(f02, "webSocket");
        f.h2.t.f0.p(string2, "reason");
    }

    public void onClosing(f0 f02, int n10, String string2) {
        f.h2.t.f0.p(f02, "webSocket");
        f.h2.t.f0.p(string2, "reason");
    }

    public void onFailure(f0 f02, Throwable throwable, c0 c02) {
        f.h2.t.f0.p(f02, "webSocket");
        f.h2.t.f0.p(throwable, "t");
    }

    public void onMessage(f0 f02, String string2) {
        f.h2.t.f0.p(f02, "webSocket");
        f.h2.t.f0.p(string2, "text");
    }

    public void onMessage(f0 f02, ByteString byteString) {
        f.h2.t.f0.p(f02, "webSocket");
        f.h2.t.f0.p(byteString, "bytes");
    }

    public void onOpen(f0 f02, c0 c02) {
        f.h2.t.f0.p(f02, "webSocket");
        f.h2.t.f0.p(c02, "response");
    }
}

