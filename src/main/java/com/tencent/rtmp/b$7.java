/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp;

import com.tencent.liteav.p;
import com.tencent.rtmp.TXLivePusher$VideoCustomProcessListener;
import com.tencent.rtmp.b;

public class b$7
implements p {
    public final /* synthetic */ b a;

    public b$7(b b10) {
        this.a = b10;
    }

    public int a(int n10, int n11, int n12, int n13) {
        TXLivePusher$VideoCustomProcessListener tXLivePusher$VideoCustomProcessListener = b.b(this.a);
        if (tXLivePusher$VideoCustomProcessListener != null) {
            tXLivePusher$VideoCustomProcessListener = b.b(this.a);
            n10 = tXLivePusher$VideoCustomProcessListener.onTextureCustomProcess(n10, n11, n12);
        }
        return n10;
    }

    public void a() {
    }

    public void b() {
        TXLivePusher$VideoCustomProcessListener tXLivePusher$VideoCustomProcessListener = b.b(this.a);
        if (tXLivePusher$VideoCustomProcessListener != null) {
            tXLivePusher$VideoCustomProcessListener = b.b(this.a);
            tXLivePusher$VideoCustomProcessListener.onTextureDestoryed();
        }
    }
}

