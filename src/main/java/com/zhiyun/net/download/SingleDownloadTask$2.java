/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.net.download;

import com.zhiyun.net.download.DownloadListener;
import com.zhiyun.net.download.SingleDownloadTask;
import java.util.Iterator;

public class SingleDownloadTask$2
implements Runnable {
    public final /* synthetic */ SingleDownloadTask this$0;

    public SingleDownloadTask$2(SingleDownloadTask singleDownloadTask) {
        this.this$0 = singleDownloadTask;
    }

    public void run() {
        boolean bl2;
        Iterator iterator2 = SingleDownloadTask.access$100(this.this$0).iterator();
        while (bl2 = iterator2.hasNext()) {
            DownloadListener downloadListener = (DownloadListener)iterator2.next();
            downloadListener.onFail();
        }
    }
}

