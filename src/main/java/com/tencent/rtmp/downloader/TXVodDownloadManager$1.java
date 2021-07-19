/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp.downloader;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.network.f;
import com.tencent.liteav.network.g;
import com.tencent.liteav.network.i;
import com.tencent.liteav.network.j;
import com.tencent.rtmp.downloader.TXVodDownloadDataSource;
import com.tencent.rtmp.downloader.TXVodDownloadManager;
import com.tencent.rtmp.downloader.TXVodDownloadMediaInfo;
import java.util.ArrayList;

public class TXVodDownloadManager$1
implements g {
    public final /* synthetic */ TXVodDownloadMediaInfo a;
    public final /* synthetic */ TXVodDownloadDataSource b;
    public final /* synthetic */ TXVodDownloadManager c;

    public TXVodDownloadManager$1(TXVodDownloadManager tXVodDownloadManager, TXVodDownloadMediaInfo tXVodDownloadMediaInfo, TXVodDownloadDataSource tXVodDownloadDataSource) {
        this.c = tXVodDownloadManager;
        this.a = tXVodDownloadMediaInfo;
        this.b = tXVodDownloadDataSource;
    }

    public void onNetFailed(f object, String string2, int n10) {
        object = this.c.mMediaInfoArray;
        TXVodDownloadMediaInfo tXVodDownloadMediaInfo = this.a;
        ((ArrayList)object).remove(tXVodDownloadMediaInfo);
        object = this.c.mListener;
        if (object != null) {
            tXVodDownloadMediaInfo = this.a;
            int n11 = -5001;
            object.onDownloadError(tXVodDownloadMediaInfo, n11, string2);
        }
    }

    public void onNetSuccess(f object) {
        Object object2 = this.a;
        int n10 = ((TXVodDownloadMediaInfo)object2).isStop;
        if (n10 != 0) {
            this.c.mMediaInfoArray.remove(object2);
            object = this.c.mListener;
            if (object != null) {
                object2 = this.a;
                object.onDownloadStop((TXVodDownloadMediaInfo)object2);
            }
            TXCLog.w("TXVodDownloadManager", "Download task canceled");
            return;
        }
        object = ((f)object).a();
        int n11 = 0;
        object2 = null;
        Object object3 = this.b;
        int n12 = ((TXVodDownloadDataSource)object3).quality;
        int n13 = 1000;
        if (n12 != n13) {
            object2 = this.c.getClassificationSource((i)object, n12);
        } else {
            object3 = ((TXVodDownloadDataSource)object3).templateName;
            if (object3 != null) {
                object2 = this.c.getTemplateSource((i)object, (String)object3);
            }
        }
        if (object2 == null) {
            object = this.c.mMediaInfoArray;
            object2 = this.a;
            ((ArrayList)object).remove(object2);
            object = this.c.mListener;
            if (object != null) {
                object2 = this.a;
                n10 = -5003;
                String string2 = "No such resolution";
                object.onDownloadError((TXVodDownloadMediaInfo)object2, n10, string2);
            }
            return;
        }
        object = this.a;
        ((TXVodDownloadMediaInfo)object).url = object3 = ((j)object2).b();
        object = this.a;
        ((TXVodDownloadMediaInfo)object).size = n10 = ((j)object2).d();
        object = this.a;
        ((TXVodDownloadMediaInfo)object).duration = n11 = ((j)object2).c();
        object = this.c;
        object2 = this.a;
        ((TXVodDownloadManager)object).downloadMedia((TXVodDownloadMediaInfo)object2);
    }
}

