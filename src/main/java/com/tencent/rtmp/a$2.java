/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp;

import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.r;
import com.tencent.rtmp.TXLivePlayer$TXLiteAVTexture;
import com.tencent.rtmp.a;

public class a$2
implements r {
    public final /* synthetic */ a a;

    public a$2(a a10) {
        this.a = a10;
    }

    public void a(String object, int n10, TXSVideoFrame object2) {
        int n11;
        if (object2 != null && (n11 = ((TXSVideoFrame)object2).width) > 0 && (n11 = ((TXSVideoFrame)object2).height) > 0 && (object = com.tencent.rtmp.a.e(this.a)) != null) {
            int n12;
            TXLivePlayer$TXLiteAVTexture tXLivePlayer$TXLiteAVTexture = new TXLivePlayer$TXLiteAVTexture();
            tXLivePlayer$TXLiteAVTexture.textureId = n12 = ((TXSVideoFrame)object2).textureId;
            tXLivePlayer$TXLiteAVTexture.width = n12 = ((TXSVideoFrame)object2).width;
            tXLivePlayer$TXLiteAVTexture.height = n12 = ((TXSVideoFrame)object2).height;
            tXLivePlayer$TXLiteAVTexture.eglContext = object2 = ((TXSVideoFrame)object2).eglContext;
            object.onRenderVideoFrame(tXLivePlayer$TXLiteAVTexture);
        }
    }
}

