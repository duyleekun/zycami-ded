/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.upload;

import cn.leancloud.upload.FileUploader$FileUploadProgressCallback;
import cn.leancloud.upload.QiniuSlicingUploader;

public class QiniuSlicingUploader$1
implements FileUploader$FileUploadProgressCallback {
    public final /* synthetic */ QiniuSlicingUploader this$0;

    public QiniuSlicingUploader$1(QiniuSlicingUploader qiniuSlicingUploader) {
        this.this$0 = qiniuSlicingUploader;
    }

    public void onProgress(int n10) {
        this.this$0.publishProgress(n10);
    }
}

