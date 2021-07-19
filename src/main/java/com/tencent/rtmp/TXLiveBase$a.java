/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp;

import com.tencent.liteav.basic.log.TXCLog$a;
import com.tencent.rtmp.ITXLiveBaseListener;
import com.tencent.rtmp.TXLiveBase;
import com.tencent.rtmp.TXLiveBase$1;

public class TXLiveBase$a
implements TXCLog$a {
    private TXLiveBase$a() {
    }

    public /* synthetic */ TXLiveBase$a(TXLiveBase$1 tXLiveBase$1) {
        this();
    }

    public void a(int n10, String string2, String string3) {
        ITXLiveBaseListener iTXLiveBaseListener = TXLiveBase.access$100();
        if (iTXLiveBaseListener != null) {
            iTXLiveBaseListener = TXLiveBase.access$100();
            iTXLiveBaseListener.OnLog(n10, string2, string3);
        }
    }
}

