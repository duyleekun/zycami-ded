/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.upload;

import cn.leancloud.upload.FileUploader$FileUploadProgressCallback;
import cn.leancloud.upload.QCloudUploader;

public class QCloudUploader$1
implements FileUploader$FileUploadProgressCallback {
    public final /* synthetic */ QCloudUploader this$0;

    public QCloudUploader$1(QCloudUploader qCloudUploader) {
        this.this$0 = qCloudUploader;
    }

    public void onProgress(int n10) {
        this.this$0.publishProgress(n10);
    }
}

