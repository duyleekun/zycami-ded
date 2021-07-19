/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.upload;

import cn.leancloud.AVException;
import cn.leancloud.AVFile;
import cn.leancloud.AVLogger;
import cn.leancloud.callback.ProgressCallback;
import cn.leancloud.upload.Uploader;
import cn.leancloud.utils.LogUtil;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import g.a0;
import g.c0;
import g.e;
import g.p;
import g.z;
import g.z$a;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public abstract class HttpClientUploader
implements Uploader {
    public static final int DEFAULT_RETRY_TIMES = 6;
    private static AVLogger logger = LogUtil.getLogger(HttpClientUploader.class);
    public AVFile avFile;
    private volatile boolean cancelled;
    private z client;
    public ProgressCallback progressCallback;

    public HttpClientUploader(AVFile aVFile, ProgressCallback progressCallback) {
        Object object = new z$a();
        Object object2 = TimeUnit.SECONDS;
        object = ((z$a)object).k(15, (TimeUnit)((Object)object2));
        long l10 = 10;
        object = ((z$a)object).j0(l10, (TimeUnit)((Object)object2)).R0(l10, (TimeUnit)((Object)object2));
        this.client = object = ((z$a)object).q((p)object2).f();
        this.cancelled = false;
        this.avFile = null;
        this.avFile = aVFile;
        this.progressCallback = progressCallback;
        this.cancelled = false;
    }

    public boolean cancel(boolean bl2) {
        boolean bl3 = this.cancelled;
        if (bl3) {
            return false;
        }
        this.cancelled = bl3 = true;
        if (bl2) {
            this.interruptImmediately();
        }
        return bl3;
    }

    public c0 executeWithRetry(a0 object, int n10) {
        int n11;
        if (n10 > 0 && (n11 = this.isCancelled()) == 0) {
            Object object2;
            try {
                object2 = this.getOKHttpClient();
            }
            catch (IOException iOException) {
                return this.executeWithRetry((a0)object, n10 += -1);
            }
            object2 = ((z)object2).a((a0)object);
            object2 = FirebasePerfOkHttpClient.execute((e)object2);
            int n12 = ((c0)object2).v0();
            int n13 = 2;
            if ((n12 /= 100) == n13) {
                return object2;
            }
            n11 = n10 + -1;
            return this.executeWithRetry((a0)object, n11);
        }
        object = new AVException(-1, "Upload File failure");
        throw object;
    }

    public z getOKHttpClient() {
        synchronized (this) {
            z z10 = this.client;
            return z10;
        }
    }

    public void interruptImmediately() {
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void publishProgress(int n10) {
        ProgressCallback progressCallback = this.progressCallback;
        if (progressCallback != null) {
            Integer n11 = n10;
            progressCallback.internalDone(n11, null);
        }
    }
}

