/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.upload;

import cn.leancloud.upload.FileUploader$FileUploadProgressCallback;
import java.util.HashMap;
import java.util.Map;

public class FileUploader$ProgressCalculator {
    public Map blockProgress;
    public FileUploader$FileUploadProgressCallback callback;
    public int fileBlockCount;

    public FileUploader$ProgressCalculator(int n10, FileUploader$FileUploadProgressCallback fileUploader$FileUploadProgressCallback) {
        HashMap hashMap;
        this.blockProgress = hashMap = new HashMap();
        this.fileBlockCount = 0;
        this.callback = fileUploader$FileUploadProgressCallback;
        this.fileBlockCount = n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void publishProgress(int n10, int n11) {
        synchronized (this) {
            Object object = this.blockProgress;
            Object object2 = n10;
            Object object3 = n11;
            object.put(object2, object3);
            object2 = this.callback;
            if (object2 != null) {
                int n12;
                n10 = 0;
                object2 = null;
                object3 = this.blockProgress;
                object3 = object3.entrySet();
                object3 = object3.iterator();
                while ((n12 = object3.hasNext()) != 0) {
                    object = object3.next();
                    object = (Map.Entry)object;
                    object = object.getValue();
                    object = (Integer)object;
                    n12 = (Integer)object;
                    n10 += n12;
                }
                object3 = this.callback;
                n10 *= 80;
                n12 = this.fileBlockCount * 100;
                n10 = n10 / n12 + 10;
                object3.onProgress(n10);
            }
            return;
        }
    }
}

