/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.tencent.liteav.network;

import android.content.Context;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.datareport.a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.liteav.network.TXIStreamDownloader;
import com.tencent.liteav.network.e;
import com.tencent.liteav.network.k$a;
import java.util.Vector;

public class TXCStreamDownloader$2
implements k$a {
    public final /* synthetic */ String a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ TXCStreamDownloader d;

    public TXCStreamDownloader$2(TXCStreamDownloader tXCStreamDownloader, String string2, boolean bl2, boolean bl3) {
        this.d = tXCStreamDownloader;
        this.a = string2;
        this.b = bl2;
        this.c = bl3;
    }

    public void a(int n10, String object, Vector object2) {
        int n11;
        if (n10 == 0 && object2 != null && (n11 = ((Vector)object2).isEmpty()) == 0) {
            object = this.d;
            int n12 = TXCStreamDownloader.access$500((TXCStreamDownloader)object);
            if (n12 != 0) {
                object = TXCStreamDownloader.access$600(this.d);
                if (object != null) {
                    boolean bl2;
                    Object object3;
                    int n13;
                    n12 = 0;
                    object = null;
                    Object object4 = ((Vector)object2).iterator();
                    while ((n13 = object4.hasNext()) != 0) {
                        object3 = (e)object4.next();
                        if (object3 == null || !(bl2 = ((e)object3).b) || (object3 = ((e)object3).a) == null || (n13 = ((String)object3).length()) <= 0) continue;
                        ++n12;
                    }
                    object4 = this.d;
                    n13 = 7113;
                    long l10 = n12;
                    object = l10;
                    ((com.tencent.liteav.basic.module.a)object4).setStatusValue(n13, object);
                    object = this.d;
                    n11 = 7112;
                    long l11 = 2;
                    object3 = l11;
                    ((com.tencent.liteav.basic.module.a)object).setStatusValue(n11, object3);
                    object = TXCStreamDownloader.access$600(this.d);
                    object4 = this.a;
                    ((TXIStreamDownloader)object).setOriginUrl((String)object4);
                    object = this.d;
                    object4 = TXCStreamDownloader.access$600((TXCStreamDownloader)object);
                    bl2 = true;
                    boolean bl3 = true;
                    boolean bl4 = this.b;
                    boolean bl5 = this.c;
                    object3 = object2;
                    ((TXIStreamDownloader)object4).startDownload((Vector)object2, bl2, bl3, bl4, bl5);
                }
                if ((object = TXCStreamDownloader.access$700(this.d)) != null) {
                    object = TXCStreamDownloader.access$700(this.d);
                    object2 = TXCStreamDownloader.access$800(this.d);
                    long l12 = 2000L;
                    object.postDelayed((Runnable)object2, l12);
                }
                object = TXCStreamDownloader.access$900(this.d).b();
                object2 = TXCStreamDownloader.access$1000(this.d);
                n11 = com.tencent.liteav.basic.datareport.a.au;
                TXCDRApi.txReportDAU((Context)object2, n11, n10, (String)object);
            } else {
                Context context = TXCStreamDownloader.access$1000(this.d);
                n12 = com.tencent.liteav.basic.datareport.a.au;
                int n14 = -4;
                String string2 = "livePlayer have been stopped";
                TXCDRApi.txReportDAU(context, n12, n14, string2);
            }
        } else {
            object2 = this.d;
            boolean bl6 = false;
            Object var8_12 = null;
            ((TXCStreamDownloader)object2).onNotifyEvent(-2302, null);
            object2 = TXCStreamDownloader.access$1000(this.d);
            n11 = com.tencent.liteav.basic.datareport.a.au;
            TXCDRApi.txReportDAU((Context)object2, n11, n10, (String)object);
            object = "getAccelerateStreamPlayUrl failed, play stream with raw url";
            TXCLog.e("TXCStreamDownloader", (String)object);
            TXCStreamDownloader tXCStreamDownloader = this.d;
            n10 = (int)(TXCStreamDownloader.access$500(tXCStreamDownloader) ? 1 : 0);
            if (n10 != 0) {
                tXCStreamDownloader = this.d;
                int n15 = -2301;
                tXCStreamDownloader.onNotifyEvent(n15, null);
            }
        }
    }
}

