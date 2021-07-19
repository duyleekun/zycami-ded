/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.network;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.a;
import com.tencent.liteav.network.TXCFLVDownloader;
import com.tencent.liteav.network.TXIStreamDownloader;
import com.tencent.liteav.network.d$a;
import com.tencent.liteav.network.d$b;
import com.tencent.liteav.network.e;
import com.tencent.liteav.network.h;
import java.util.Vector;

public class d
implements h {
    private h a = null;
    private d$b b = null;
    private long c;
    private long d;
    private d$b e;
    private d$a f;
    private long g;
    private long h;

    public d(d$a d$a) {
        long l10;
        this.c = l10 = 0L;
        this.d = l10;
        this.e = null;
        this.g = l10;
        this.h = l10;
        this.f = d$a;
    }

    public static /* synthetic */ long a(d d10) {
        return d10.d;
    }

    public void a() {
        d$b d$b = this.b;
        long l10 = 0L;
        if (d$b != null) {
            d$b.b(l10);
        }
        if ((d$b = this.e) != null) {
            d$b.b(l10);
        }
    }

    public void a(long l10) {
        this.g = l10;
    }

    public void a(TXIStreamDownloader object, TXIStreamDownloader tXIStreamDownloader, long l10, long l11, String string2) {
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("[SwitchStream] old downloader:");
        int bl2 = object.hashCode();
        ((StringBuilder)object2).append(bl2);
        ((StringBuilder)object2).append(" new downloader:");
        int n10 = tXIStreamDownloader.hashCode();
        ((StringBuilder)object2).append(n10);
        object2 = ((StringBuilder)object2).toString();
        TXCLog.i("TXCMultiStreamDownloader", (String)object2);
        this.c = l10 = ((TXIStreamDownloader)object).getCurrentTS();
        this.d = l10 = ((TXIStreamDownloader)object).getLastIFrameTS();
        this.b = object2 = new d$b((TXIStreamDownloader)object, this);
        ((d$b)object2).a(this);
        object2 = object;
        object2 = (TXCFLVDownloader)object;
        boolean bl3 = true;
        ((TXCFLVDownloader)object2).recvData(bl3);
        Vector<Object> vector = new Vector<Object>();
        object2 = new e(string2, false);
        vector.add(object2);
        tXIStreamDownloader.setOriginUrl(string2);
        object2 = tXIStreamDownloader;
        ((TXCFLVDownloader)tXIStreamDownloader).recvData(bl3);
        boolean bl4 = ((TXIStreamDownloader)object).mEnableMessage;
        boolean bl5 = ((TXIStreamDownloader)object).mEnableMetaData;
        tXIStreamDownloader.startDownload(vector, false, false, bl4, bl5);
        this.e = object = new d$b(tXIStreamDownloader, this);
        long l12 = this.c;
        ((d$b)object).a(l12);
    }

    public void a(TXIStreamDownloader tXIStreamDownloader, boolean bl2) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("[SwitchStream] switch stream finish. result:");
        ((StringBuilder)object).append(bl2);
        object = ((StringBuilder)object).toString();
        String string2 = "TXCMultiStreamDownloader";
        TXCLog.i(string2, (String)object);
        object = this.f;
        if (object != null) {
            object.onSwitchFinish(tXIStreamDownloader, bl2);
        }
    }

    public void a(h h10) {
        this.a = h10;
    }

    public void b() {
        this.b.a((h)null);
        this.e.a(this);
        Object object = this.e;
        this.b = object;
        this.e = null;
        object = new StringBuilder();
        ((StringBuilder)object).append("[SwitchStream] end at ");
        long l10 = this.c;
        ((StringBuilder)object).append(l10);
        ((StringBuilder)object).append(" stop ts ");
        l10 = this.h;
        ((StringBuilder)object).append(l10);
        ((StringBuilder)object).append(" start ts ");
        l10 = this.g;
        ((StringBuilder)object).append(l10);
        String string2 = " diff ts ";
        ((StringBuilder)object).append(string2);
        l10 = this.h;
        long l11 = this.g;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        l10 = l12 > 0 ? (l10 -= l11) : l11 - l10;
        ((StringBuilder)object).append(l10);
        object = ((StringBuilder)object).toString();
        TXCLog.w("TXCMultiStreamDownloader", (String)object);
    }

    public void b(long l10) {
        this.h = l10;
    }

    public long c() {
        long l10;
        Object object = this.b;
        if (object != null) {
            l10 = this.c;
            ((d$b)object).b(l10);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("[SwitchStream] stop original downloader, when video ts is");
        l10 = this.c;
        ((StringBuilder)object).append(l10);
        object = ((StringBuilder)object).toString();
        TXCLog.i("TXCMultiStreamDownloader", (String)object);
        return this.c;
    }

    public void onPullAudio(a a10) {
        h h10 = this.a;
        if (h10 != null) {
            h10.onPullAudio(a10);
        }
    }

    public void onPullNAL(TXSNALPacket tXSNALPacket) {
        h h10;
        long l10;
        this.c = l10 = tXSNALPacket.pts;
        int n10 = tXSNALPacket.nalType;
        if (n10 == 0) {
            this.d = l10;
        }
        if ((h10 = this.a) != null) {
            h10.onPullNAL(tXSNALPacket);
        }
    }
}

