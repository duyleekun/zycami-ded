/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.network;

import com.tencent.liteav.network.TXCRTMPDownloader;
import com.tencent.liteav.network.TXCStreamDownloader$DownloadStats;

public class TXCRTMPDownloader$a
extends Thread {
    public final /* synthetic */ TXCRTMPDownloader a;
    private long b;
    private String c;
    private boolean d;

    public TXCRTMPDownloader$a(TXCRTMPDownloader tXCRTMPDownloader, String string2, boolean bl2) {
        this.a = tXCRTMPDownloader;
        super("RTMPDownLoad");
        this.b = 0L;
        this.c = string2;
        this.d = bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        synchronized (this) {
            long l10 = this.b;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 != false) {
                TXCRTMPDownloader tXCRTMPDownloader = this.a;
                TXCRTMPDownloader.access$300(tXCRTMPDownloader, l10);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(String string2) {
        synchronized (this) {
            long l10 = this.b;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 != false) {
                TXCRTMPDownloader tXCRTMPDownloader = this.a;
                TXCRTMPDownloader.access$500(tXCRTMPDownloader, l10, string2);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public TXCStreamDownloader.DownloadStats b() {
        synchronized (this) {
            long l10 = this.b;
            long l11 = 0L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 == false) return null;
            TXCRTMPDownloader tXCRTMPDownloader = this.a;
            return TXCRTMPDownloader.access$400(tXCRTMPDownloader, l10);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        long l10;
        Object object;
        TXCRTMPDownloader tXCRTMPDownloader;
        synchronized (this) {
            tXCRTMPDownloader = this.a;
            String string2 = tXCRTMPDownloader.mUserID;
            object = tXCRTMPDownloader.mOriginUrl;
            String string3 = this.c;
            boolean bl2 = this.d;
            boolean bl3 = tXCRTMPDownloader.mEnableMessage;
            boolean bl4 = tXCRTMPDownloader.mEnableMetaData;
            this.b = l10 = TXCRTMPDownloader.access$000(tXCRTMPDownloader, string2, (String)object, string3, bl2, bl3, bl4);
        }
        object = this.a;
        TXCRTMPDownloader.access$100((TXCRTMPDownloader)object, l10);
        synchronized (this) {
            tXCRTMPDownloader = this.a;
            long l11 = this.b;
            TXCRTMPDownloader.access$200(tXCRTMPDownloader, l11);
            this.b = l10 = 0L;
            return;
        }
    }
}

