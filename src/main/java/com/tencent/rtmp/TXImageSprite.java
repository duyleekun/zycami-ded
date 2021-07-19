/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 */
package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.rtmp.a.a;
import com.tencent.rtmp.a.b;
import java.util.List;

public class TXImageSprite
implements a {
    private Context mContext;
    private a mImageSprite;

    public TXImageSprite(Context context) {
        Context context2;
        this.mContext = context2 = context.getApplicationContext();
        TXCDRApi.initCrashReport(context);
    }

    public Bitmap getThumbnail(float f10) {
        Bitmap bitmap;
        a a10 = this.mImageSprite;
        if (a10 != null) {
            bitmap = a10.getThumbnail(f10);
        } else {
            f10 = 0.0f;
            bitmap = null;
        }
        return bitmap;
    }

    public void release() {
        a a10 = this.mImageSprite;
        if (a10 != null) {
            a10.release();
            a10 = null;
            this.mImageSprite = null;
        }
    }

    public void setVTTUrlAndImageUrls(String string2, List list) {
        int n10;
        a a10 = this.mImageSprite;
        if (a10 != null) {
            this.release();
        }
        if (string2 != null && list != null && (n10 = list.size()) != 0) {
            a10 = this.mContext;
            int n11 = com.tencent.liteav.basic.datareport.a.bD;
            TXCDRApi.txReportDAU((Context)a10, n11);
            this.mImageSprite = a10 = new b();
            a10.setVTTUrlAndImageUrls(string2, list);
        }
    }
}

