/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp.downloader;

import com.tencent.ijk.media.player.IjkDownloadCenter;
import com.tencent.ijk.media.player.IjkDownloadCenter$OnDownloadListener;
import com.tencent.ijk.media.player.IjkDownloadMedia;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.rtmp.downloader.TXVodDownloadManager;
import com.tencent.rtmp.downloader.TXVodDownloadMediaInfo;
import java.io.File;
import java.util.ArrayList;

public class TXVodDownloadManager$2
implements IjkDownloadCenter$OnDownloadListener {
    public final /* synthetic */ TXVodDownloadManager a;

    public TXVodDownloadManager$2(TXVodDownloadManager tXVodDownloadManager) {
        this.a = tXVodDownloadManager;
    }

    public void downloadBegin(IjkDownloadCenter object, IjkDownloadMedia object2) {
        object = this.a.convertMedia((IjkDownloadMedia)object2);
        if (object != null) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("downloadBegin ");
            String string2 = ((TXVodDownloadMediaInfo)object).playPath;
            ((StringBuilder)object2).append(string2);
            object2 = ((StringBuilder)object2).toString();
            string2 = "TXVodDownloadManager";
            TXCLog.i(string2, (String)object2);
            this.a.mListener.onDownloadStart((TXVodDownloadMediaInfo)object);
            object = ((TXVodDownloadMediaInfo)object).playPath;
            object2 = new File((String)object);
            boolean bl2 = ((File)object2).isFile();
            if (bl2) {
                object = "file state ok";
                TXCLog.d(string2, (String)object);
            } else {
                object = "file not create!";
                TXCLog.e(string2, (String)object);
            }
        }
    }

    public void downloadEnd(IjkDownloadCenter object, IjkDownloadMedia object2) {
        object = this.a.convertMedia((IjkDownloadMedia)object2);
        if (object != null) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("downloadEnd ");
            String string2 = ((TXVodDownloadMediaInfo)object).playPath;
            ((StringBuilder)object2).append(string2);
            object2 = ((StringBuilder)object2).toString();
            string2 = "TXVodDownloadManager";
            TXCLog.i(string2, (String)object2);
            this.a.mMediaInfoArray.remove(object);
            object2 = this.a.mListener;
            object2.onDownloadStop((TXVodDownloadMediaInfo)object);
        }
    }

    public void downloadError(IjkDownloadCenter object, IjkDownloadMedia object2, int n10, String string2) {
        object = this.a.convertMedia((IjkDownloadMedia)object2);
        if (object != null) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("downloadError ");
            String string3 = ((TXVodDownloadMediaInfo)object).playPath;
            ((StringBuilder)object2).append(string3);
            ((StringBuilder)object2).append(" ");
            ((StringBuilder)object2).append(string2);
            object2 = ((StringBuilder)object2).toString();
            string3 = "TXVodDownloadManager";
            TXCLog.e(string3, (String)object2);
            object2 = this.a.mMediaInfoArray;
            ((ArrayList)object2).remove(object);
            int n11 = ((TXVodDownloadMediaInfo)object).isStop;
            if (n11 != 0) {
                object2 = this.a.mListener;
                object2.onDownloadStop((TXVodDownloadMediaInfo)object);
            } else {
                n11 = 1008;
                if (n10 == n11) {
                    object2 = this.a.mListener;
                    n10 = -5006;
                    object2.onDownloadError((TXVodDownloadMediaInfo)object, n10, string2);
                } else {
                    object2 = this.a.mListener;
                    n10 = -5005;
                    object2.onDownloadError((TXVodDownloadMediaInfo)object, n10, string2);
                }
            }
        }
    }

    public void downloadFinish(IjkDownloadCenter object, IjkDownloadMedia object2) {
        object = this.a.convertMedia((IjkDownloadMedia)object2);
        if (object != null) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("downloadFinish ");
            String string2 = ((TXVodDownloadMediaInfo)object).playPath;
            ((StringBuilder)object2).append(string2);
            object2 = ((StringBuilder)object2).toString();
            TXCLog.i("TXVodDownloadManager", (String)object2);
            this.a.mMediaInfoArray.remove(object);
            string2 = ((TXVodDownloadMediaInfo)object).playPath;
            object2 = new File(string2);
            boolean bl2 = ((File)object2).isFile();
            if (bl2) {
                object2 = this.a.mListener;
                object2.onDownloadFinish((TXVodDownloadMediaInfo)object);
            } else {
                object2 = this.a.mListener;
                int n10 = -5003;
                String string3 = "The file has been deleted";
                object2.onDownloadError((TXVodDownloadMediaInfo)object, n10, string3);
            }
        }
    }

    public void downloadProgress(IjkDownloadCenter object, IjkDownloadMedia object2) {
        object = this.a.convertMedia((IjkDownloadMedia)object2);
        if (object != null) {
            object2 = this.a.mListener;
            object2.onDownloadProgress((TXVodDownloadMediaInfo)object);
        }
    }

    public int hlsKeyVerify(IjkDownloadCenter object, IjkDownloadMedia ijkDownloadMedia, String string2, byte[] byArray) {
        object = this.a.convertMedia(ijkDownloadMedia);
        if (object != null) {
            return this.a.mListener.hlsKeyVerify((TXVodDownloadMediaInfo)object, string2, byArray);
        }
        return 0;
    }
}

