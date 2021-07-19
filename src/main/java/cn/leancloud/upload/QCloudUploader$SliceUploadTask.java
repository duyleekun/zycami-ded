/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.upload;

import cn.leancloud.upload.FileUploader$ProgressCalculator;
import cn.leancloud.upload.HttpClientUploader;
import cn.leancloud.upload.QCloudUploader;
import cn.leancloud.utils.StringUtil;
import g.a0;
import g.a0$a;
import g.b0;
import g.c0;
import g.d0;
import g.v;
import g.w$a;
import java.util.concurrent.CountDownLatch;

public class QCloudUploader$SliceUploadTask
implements Runnable {
    public byte[] data;
    public String key;
    public CountDownLatch latch;
    public QCloudUploader parent;
    public FileUploader$ProgressCalculator progress;
    public String session;
    public int sliceOffset;
    public String token;
    public String url;

    public QCloudUploader$SliceUploadTask(QCloudUploader qCloudUploader, String string2, String string3, String string4, byte[] byArray, int n10, String string5, FileUploader$ProgressCalculator fileUploader$ProgressCalculator, CountDownLatch countDownLatch) {
        this.data = byArray;
        this.sliceOffset = n10;
        this.progress = fileUploader$ProgressCalculator;
        this.session = string5;
        this.latch = countDownLatch;
        this.token = string3;
        this.url = string4;
        this.key = string2;
        this.parent = qCloudUploader;
    }

    public void run() {
        this.upload();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String upload() {
        int n10;
        String string2;
        Object object;
        Object object2;
        Object object3;
        block32: {
            object3 = "multipart/form-data";
            object2 = new w$a();
            object = "application/octet-stream";
            object = v.j((String)object);
            byte[] byArray = this.data;
            int n11 = this.sliceOffset;
            int n12 = 524288;
            int n13 = n11 * n12;
            int n14 = byArray.length;
            n11 = QCloudUploader.access$000(n11, n14);
            object = b0.create((v)object, byArray, n13, n11);
            String string3 = "filecontent";
            string2 = this.key;
            ((w$a)object2).b(string3, string2, (b0)object);
            object = "op";
            String string4 = "upload_slice";
            ((w$a)object2).a((String)object, string4);
            object = "offset";
            n10 = this.sliceOffset * n12;
            String string5 = String.valueOf(n10);
            ((w$a)object2).a((String)object, string5);
            object = "session";
            String string6 = this.session;
            ((w$a)object2).a((String)object, string6);
            object = v.j((String)object3);
            if (object == null) break block32;
            ((w$a)object2).g((v)object);
        }
        object = new a0$a();
        String string7 = this.url;
        ((a0$a)object).B(string7);
        String string8 = "Authorization";
        string2 = this.token;
        ((a0$a)object).n(string8, string2);
        String string9 = "Content-Type";
        ((a0$a)object).n(string9, (String)object3);
        object3 = ((w$a)object2).f();
        ((a0$a)object).r((b0)object3);
        object3 = ((a0$a)object).b();
        object2 = this.parent;
        long l10 = 5;
        object3 = ((HttpClientUploader)object2).executeWithRetry((a0)object3, (int)l10);
        if (object3 == null) return null;
        object3 = ((c0)object3).r0();
        object3 = ((d0)object3).bytes();
        object2 = this.progress;
        if (object2 == null) return StringUtil.stringFromBytes((byte[])object3);
        l10 = this.sliceOffset;
        n10 = 100;
        try {
            ((FileUploader$ProgressCalculator)object2).publishProgress((int)l10, n10);
            return StringUtil.stringFromBytes((byte[])object3);
        }
        catch (Exception exception) {
            long l11;
            long l12;
            object3 = this.latch;
            if (object3 == null) return null;
            long l13 = ((CountDownLatch)object3).getCount();
            while ((l10 = (l12 = l13 - (l11 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
                object = this.latch;
                ((CountDownLatch)object).countDown();
                l11 = 1L;
                l13 -= l11;
            }
        }
        return null;
    }
}

