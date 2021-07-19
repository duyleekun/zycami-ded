/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav;

import com.tencent.liteav.b.a$b;
import com.tencent.liteav.f;
import com.tencent.liteav.renderer.a$a;
import com.tencent.liteav.renderer.g;
import com.tencent.ugc.TXRecordCommon$ITXVideoRecordListener;
import com.tencent.ugc.TXRecordCommon$TXRecordResult;

public class f$2
implements a$b {
    public final /* synthetic */ f a;

    public f$2(f f10) {
        this.a = f10;
    }

    public void a(int n10, String string2, String string3, String string4) {
        Object object = f.a(this.a);
        if (object != null) {
            TXRecordCommon$ITXVideoRecordListener tXRecordCommon$ITXVideoRecordListener;
            object = new TXRecordCommon$TXRecordResult();
            if (n10 == 0) {
                n10 = 0;
                tXRecordCommon$ITXVideoRecordListener = null;
                ((TXRecordCommon$TXRecordResult)object).retCode = 0;
            } else {
                ((TXRecordCommon$TXRecordResult)object).retCode = n10 = -1;
            }
            ((TXRecordCommon$TXRecordResult)object).descMsg = string2;
            ((TXRecordCommon$TXRecordResult)object).videoPath = string3;
            ((TXRecordCommon$TXRecordResult)object).coverPath = string4;
            tXRecordCommon$ITXVideoRecordListener = f.a(this.a);
            tXRecordCommon$ITXVideoRecordListener.onRecordComplete((TXRecordCommon$TXRecordResult)object);
        }
        f.b(this.a).a((g)null);
        f.b(this.a).a((a$a)null);
    }

    public void a(long l10) {
        TXRecordCommon$ITXVideoRecordListener tXRecordCommon$ITXVideoRecordListener = f.a(this.a);
        if (tXRecordCommon$ITXVideoRecordListener != null) {
            tXRecordCommon$ITXVideoRecordListener = f.a(this.a);
            tXRecordCommon$ITXVideoRecordListener.onRecordProgress(l10);
        }
    }
}

