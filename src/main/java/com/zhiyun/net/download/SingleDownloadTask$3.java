/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.net.download;

import com.zhiyun.net.download.DownloadListener;
import com.zhiyun.net.download.SingleDownloadTask;
import java.util.Iterator;

public class SingleDownloadTask$3
implements Runnable {
    public final /* synthetic */ SingleDownloadTask this$0;
    public final /* synthetic */ String val$finalPath;

    public SingleDownloadTask$3(SingleDownloadTask singleDownloadTask, String string2) {
        this.this$0 = singleDownloadTask;
        this.val$finalPath = string2;
    }

    public void run() {
        boolean bl2;
        Iterator iterator2 = SingleDownloadTask.access$100(this.this$0).iterator();
        while (bl2 = iterator2.hasNext()) {
            DownloadListener downloadListener = (DownloadListener)iterator2.next();
            String string2 = this.val$finalPath;
            downloadListener.onSuccess(string2);
        }
    }
}

