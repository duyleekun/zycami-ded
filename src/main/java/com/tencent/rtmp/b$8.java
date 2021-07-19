/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp;

import com.tencent.liteav.audio.g;
import com.tencent.rtmp.TXLivePusher$OnBGMNotify;
import com.tencent.rtmp.b;

public class b$8
implements g {
    public final /* synthetic */ b a;

    public b$8(b b10) {
        this.a = b10;
    }

    public void a() {
        TXLivePusher$OnBGMNotify tXLivePusher$OnBGMNotify = this.a.a;
        if (tXLivePusher$OnBGMNotify != null) {
            tXLivePusher$OnBGMNotify.onBGMStart();
        }
    }

    public void a(int n10) {
        TXLivePusher$OnBGMNotify tXLivePusher$OnBGMNotify = this.a.a;
        if (tXLivePusher$OnBGMNotify != null) {
            tXLivePusher$OnBGMNotify.onBGMComplete(n10);
        }
    }

    public void a(long l10, long l11) {
        TXLivePusher$OnBGMNotify tXLivePusher$OnBGMNotify = this.a.a;
        if (tXLivePusher$OnBGMNotify != null) {
            tXLivePusher$OnBGMNotify.onBGMProgress(l10, l11);
        }
    }
}

