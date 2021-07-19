/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.upload;

import cn.leancloud.AVException;
import cn.leancloud.AVFile;
import cn.leancloud.callback.ProgressCallback;
import cn.leancloud.upload.FileUploader;
import cn.leancloud.upload.HttpClientUploader;
import cn.leancloud.utils.FileUtil;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import g.a0;
import g.a0$a;
import g.b0;
import g.c0;
import g.e;
import g.v;
import g.z;
import g.z$a;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class S3Uploader
extends HttpClientUploader {
    private static String DEFAULT_HEADER_CACHE_CONTROL = "Cache-Control";
    private static String DEFAULT_HEADER_CACHE_CONTROL_VALUE = "public, max-age=31536000";
    private static final int DEFAULT_MAX_WRITE_TIMEOUT = 240;
    private static final int DEFAULT_MIN_UPLOAD_RATE = 51200;
    private static final int DEFAULT_MIN_WRITE_TIMEOUT = 30;
    private static int writeTimeout;
    private volatile e call;
    private int retryTimes = 6;
    private String uploadUrl;

    public S3Uploader(AVFile aVFile, String string2, ProgressCallback progressCallback) {
        super(aVFile, progressCallback);
        this.uploadUrl = string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private AVException executeWithRetry(byte[] object) {
        if (object == null) return null;
        int n10 = ((byte[])object).length;
        if (n10 <= 0) return null;
        Object object2 = this.getOKHttpClient().c0();
        int n11 = writeTimeout;
        if (n11 <= 0) {
            n11 = ((byte[])object).length;
            n11 = this.getWriteTimeoutByLength(n11);
        }
        long l10 = n11;
        Object object3 = TimeUnit.SECONDS;
        ((z$a)object2).R0(l10, (TimeUnit)((Object)object3));
        object2 = ((z$a)object2).f();
        try {
            Object object4;
            boolean bl2;
            Object object5 = this.avFile;
            object5 = FileUtil.getFileMimeType((AVFile)object5);
            a0$a a0$a = new a0$a();
            object3 = this.uploadUrl;
            a0$a.B((String)object3);
            object3 = v.j((String)object5);
            object3 = b0.create((v)object3, object);
            a0$a.s((b0)object3);
            object3 = "Content-Type";
            a0$a.a((String)object3, (String)object5);
            object5 = FileUploader.UPLOAD_HEADERS;
            object3 = DEFAULT_HEADER_CACHE_CONTROL;
            n11 = (int)(((HashMap)object5).containsKey(object3) ? 1 : 0);
            if (n11 == 0) {
                object5 = DEFAULT_HEADER_CACHE_CONTROL;
                object3 = DEFAULT_HEADER_CACHE_CONTROL_VALUE;
                a0$a.a((String)object5, (String)object3);
            }
            object5 = FileUploader.UPLOAD_HEADERS;
            object5 = ((HashMap)object5).entrySet();
            object5 = object5.iterator();
            while (bl2 = object5.hasNext()) {
                object3 = object5.next();
                object3 = (Map.Entry)object3;
                object4 = object3.getKey();
                object4 = (String)object4;
                object3 = object3.getValue();
                object3 = (String)object3;
                a0$a.a((String)object4, (String)object3);
            }
            object5 = a0$a.b();
            object2 = this.call = (object2 = ((z)object2).a((a0)object5));
            object2 = FirebasePerfOkHttpClient.execute((e)object2);
            n11 = 2;
            int n12 = ((c0)object2).v0();
            if (n11 == (n12 /= 100)) return null;
            n11 = this.retryTimes;
            if (n11 > 0) {
                this.retryTimes = n11 += -1;
                this.executeWithRetry((byte[])object);
                return null;
            }
            n12 = -1;
            object3 = new StringBuilder();
            object4 = "upload file failure:";
            ((StringBuilder)object3).append((String)object4);
            n10 = ((c0)object2).v0();
            ((StringBuilder)object3).append(n10);
            object2 = ((StringBuilder)object3).toString();
            return new AVException(n12, (String)object2);
        }
        catch (IOException iOException) {
            n11 = this.retryTimes;
            if (n11 > 0) {
                this.retryTimes = n11 += -1;
                return this.executeWithRetry((byte[])object);
            }
            object = new AVException;
            Throwable throwable = iOException.getCause();
            object(throwable);
            return object;
        }
    }

    private int getWriteTimeoutByLength(int n10) {
        int n11 = 240;
        int n12 = 30;
        if ((n10 /= 51200) < n12) {
            n10 = n12;
        } else if (n10 > n11) {
            n10 = n11;
        }
        return n10;
    }

    public static void setWriteTimeout(int n10) {
        if (n10 > 0) {
            int n11 = 3600;
            if (n10 <= n11) {
                writeTimeout = n10;
                return;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Timeout too large");
            AVException aVException = new AVException(illegalArgumentException);
            throw aVException;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Timeout too small");
        AVException aVException = new AVException(illegalArgumentException);
        throw aVException;
    }

    public AVException execute() {
        Object object;
        try {
            object = this.avFile;
        }
        catch (Exception exception) {
            Throwable throwable = exception.getCause();
            AVException aVException = new AVException(throwable);
            return aVException;
        }
        object = ((AVFile)object).getData();
        return this.executeWithRetry((byte[])object);
    }
}

