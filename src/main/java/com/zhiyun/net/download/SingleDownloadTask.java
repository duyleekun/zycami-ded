/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.Looper
 */
package com.zhiyun.net.download;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.zhiyun.net.api.entity.DownloadFile;
import com.zhiyun.net.download.DownLoadThreadPool;
import com.zhiyun.net.download.DownloadApi;
import com.zhiyun.net.download.DownloadListener;
import com.zhiyun.net.download.DownloadService;
import com.zhiyun.net.download.SingleDownloadTask$1;
import com.zhiyun.net.download.SingleDownloadTask$2;
import com.zhiyun.net.download.SingleDownloadTask$3;
import g.d0;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k.r;
import m.a.a;

public class SingleDownloadTask {
    private static final String TAG = "SingleDownloadTask";
    private volatile boolean cancel;
    private DecimalFormat decimalFormat;
    private volatile boolean isDownloading = false;
    private Context mContext;
    private boolean mContinueDownload;
    private DownloadFile mDownloadFile;
    private final List mDownloadListenerList;
    private File mFile;
    private Handler mHandler;
    private boolean mPartitionStorage;
    private Uri mUri;
    private volatile boolean pause;

    public SingleDownloadTask(Context object, DownloadFile downloadFile) {
        ArrayList arrayList;
        this.mDownloadListenerList = arrayList = new ArrayList();
        this.mDownloadFile = downloadFile;
        this.mContext = object;
        downloadFile = Looper.getMainLooper();
        super((Looper)downloadFile);
        this.mHandler = object;
        super("0.00");
        this.decimalFormat = object;
        super();
        ((DecimalFormatSymbols)object).setDecimalSeparator('.');
        this.decimalFormat.setDecimalFormatSymbols((DecimalFormatSymbols)object);
    }

    public SingleDownloadTask(Context object, DownloadFile downloadFile, DownloadListener downloadListener) {
        this((Context)object, downloadFile);
        if (downloadListener != null) {
            object = this.mDownloadListenerList;
            object.add(downloadListener);
        }
    }

    public static /* synthetic */ void access$000(SingleDownloadTask singleDownloadTask) {
        singleDownloadTask.startDownload();
    }

    public static /* synthetic */ List access$100(SingleDownloadTask singleDownloadTask) {
        return singleDownloadTask.mDownloadListenerList;
    }

    private void checkFileExitsState() {
        Object object = this.mFile;
        Object object2 = object.exists();
        long l10 = 0L;
        if (object2 != 0) {
            long l11 = this.getDownloadFileLength();
            long l12 = l11 - l10;
            object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 != 0) {
                object = this.mFile;
                long l13 = object.length();
                long l14 = l13 - l11;
                object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                if (object2 == 0) {
                    object = this.mFile.getAbsolutePath();
                    this.sendSuccessCallback((String)object);
                } else {
                    object2 = this.mContinueDownload;
                    if (object2 == 0) {
                        File file;
                        object2 = 1;
                        object = new File[object2];
                        object[0] = file = this.mFile;
                        this.cleanFile((File)object);
                    }
                    object = this.mFile;
                    l13 = object.length();
                    this.startDownload(l13);
                }
            }
        } else {
            this.startDownload(l10);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void checkUriExitsState() {
        long l10 = 0L;
        try {
            Object object = this.mContext;
            object = object.getContentResolver();
            Uri uri = this.mUri;
            object = object.openInputStream(uri);
            int n10 = ((InputStream)object).available();
            long l11 = n10;
            long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
            if (l12 == false) {
                this.startDownload(l10);
                return;
            }
            long l13 = this.getDownloadFileLength();
            long l14 = l13 - l10;
            Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object2 == false) return;
            Object object3 = l13 == l11 ? 0 : (l13 < l11 ? -1 : 1);
            if (object3 == false) {
                object = this.mUri;
                object = object.toString();
                this.sendSuccessCallback((String)object);
                return;
            }
            boolean bl2 = this.mContinueDownload;
            if (!bl2) {
                l11 = l10;
            }
            this.startDownload(l11);
            return;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            this.startDownload(l10);
        }
    }

    private void cleanFile(Uri ... uriArray) {
        for (Uri uri : uriArray) {
            if (uri == null) continue;
            Context context = this.mContext;
            context = context.getContentResolver();
            try {
                context.delete(uri, null, null);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    private void cleanFile(File ... fileArray) {
        for (File file : fileArray) {
            if (file == null) continue;
            file.delete();
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void close(Closeable ... closeableArray) {
        int n10;
        Throwable throwable2222222;
        block9: {
            int n11 = closeableArray.length;
            for (int i10 = 0; i10 < n11; ++i10) {
                Closeable closeable = closeableArray[i10];
                if (closeable == null) continue;
                closeable.close();
            }
            {
                int n12;
                catch (Throwable throwable2222222) {
                    break block9;
                }
                catch (Exception exception) {}
                {
                    exception.printStackTrace();
                }
                for (n10 = 0; n10 < (n12 = closeableArray.length); ++n10) {
                    closeableArray[n10] = null;
                }
                return;
            }
            while (n10 < (n11 = closeableArray.length)) {
                closeableArray[n10] = null;
                ++n10;
            }
            return;
        }
        while (true) {
            int n13;
            if (n10 >= (n13 = closeableArray.length)) {
                throw throwable2222222;
            }
            closeableArray[n10] = null;
            ++n10;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private long getDownloadFileLength() {
        Object object = this.mDownloadFile.getUrl();
        int n10 = 20;
        object = (DownloadApi)DownloadService.getDownloadRetrofit((String)object, n10).g(DownloadApi.class);
        String string2 = this.mDownloadFile.getUrl();
        object = object.download(string2);
        long l10 = 0L;
        try {
            object = object.execute();
            Object object2 = "code = %s";
            int n11 = 1;
            Object[] objectArray = new Object[n11];
            int n12 = ((r)object).b();
            Integer n13 = n12;
            objectArray[0] = n13;
            a.b((String)object2, objectArray);
            int n14 = ((r)object).b();
            int n15 = 200;
            if (n14 == n15 && (object2 = ((r)object).a()) != null) {
                object2 = ((r)object).a();
                object2 = (d0)object2;
                l10 = ((d0)object2).contentLength();
                object2 = new Closeable[n11];
                object = ((r)object).a();
                object2[0] = object = (Closeable)object;
                this.close((Closeable[])object2);
                return l10;
            }
            object2 = new Closeable[n11];
            object = ((r)object).a();
            object2[0] = object = (Closeable)object;
            this.close((Closeable[])object2);
            this.sendFailedCallback();
            return l10;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            this.sendFailedCallback();
        }
        return l10;
    }

    private void resetStatus() {
        this.pause = false;
        this.cancel = false;
        this.isDownloading = false;
    }

    private void sendCancelCallback() {
        boolean bl2;
        this.resetStatus();
        Iterator iterator2 = this.mDownloadListenerList.iterator();
        while (bl2 = iterator2.hasNext()) {
            DownloadListener downloadListener = (DownloadListener)iterator2.next();
            downloadListener.onCancel();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void sendFailedCallback() {
        Object object;
        SingleDownloadTask$2 singleDownloadTask$2;
        block6: {
            this.resetStatus();
            boolean bl2 = this.mContinueDownload;
            if (!bl2) {
                try {
                    bl2 = this.mPartitionStorage;
                    singleDownloadTask$2 = null;
                    if (bl2) {
                        object = this.mUri;
                        if (object != null) {
                            object = this.mContext;
                            object = object.getContentResolver();
                            Uri uri = this.mUri;
                            object.delete(uri, null, null);
                            this.mUri = null;
                        }
                        break block6;
                    }
                    object = this.mFile;
                    if (object != null) {
                        ((File)object).delete();
                        this.mFile = null;
                    }
                }
                catch (Exception exception) {}
            }
        }
        object = this.mHandler;
        singleDownloadTask$2 = new SingleDownloadTask$2(this);
        object.post((Runnable)singleDownloadTask$2);
    }

    private void sendPauseCallback() {
        boolean bl2;
        this.resetStatus();
        Iterator iterator2 = this.mDownloadListenerList.iterator();
        while (bl2 = iterator2.hasNext()) {
            DownloadListener downloadListener = (DownloadListener)iterator2.next();
            downloadListener.onPause();
        }
    }

    private void sendProgressCallback(float f10) {
        boolean bl2;
        Iterator iterator2 = this.mDownloadListenerList.iterator();
        while (bl2 = iterator2.hasNext()) {
            DownloadListener downloadListener = (DownloadListener)iterator2.next();
            downloadListener.onProgress(f10);
        }
    }

    private void sendSuccessCallback(String object) {
        Object object2;
        this.resetStatus();
        Object object3 = this.mDownloadFile.getCacheDir();
        if (object3 != null) {
            object3 = this.mDownloadFile.getFilePath();
            object2 = this.mDownloadFile.getFileName();
            object = new File((String)object3, (String)object2);
            object3 = this.mFile;
            ((File)object3).renameTo((File)object);
            object = ((File)object).getAbsolutePath();
        }
        object3 = this.mHandler;
        object2 = new SingleDownloadTask$3(this, (String)object);
        object3.post((Runnable)object2);
    }

    private void startDownload() {
        boolean bl2;
        Object object = this.mDownloadFile.getFileUri();
        if (object != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        this.mPartitionStorage = bl2;
        if (bl2) {
            object = this.mDownloadFile.getFileUri();
            this.mUri = object;
            this.checkUriExitsState();
        } else {
            File file;
            object = this.mDownloadFile.getCacheDir();
            object = object != null ? this.mDownloadFile.getCacheDir() : this.mDownloadFile.getFilePath();
            String string2 = this.mDownloadFile.getFileName();
            this.mFile = file = new File((String)object, string2);
            object = file.getParentFile();
            ((File)object).mkdirs();
            this.checkFileExitsState();
        }
    }

    /*
     * Exception decompiling
     */
    private void startDownload(long var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [56[UNCONDITIONALDOLOOP]], but top level block is 42[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public void addDownloadListener(DownloadListener downloadListener) {
        if (downloadListener == null) {
            return;
        }
        List list = this.mDownloadListenerList;
        boolean bl2 = list.contains(downloadListener);
        if (!bl2) {
            list = this.mDownloadListenerList;
            list.add(downloadListener);
        }
    }

    public void cancel() {
        boolean bl2 = this.isDownloading;
        if (bl2) {
            this.cancel = bl2 = true;
        }
    }

    public DownloadFile getDownloadFile() {
        return this.mDownloadFile;
    }

    public boolean isDownloading() {
        return this.isDownloading;
    }

    public void pause() {
        boolean bl2 = this.isDownloading;
        if (bl2) {
            this.pause = bl2 = true;
        }
    }

    public void removeListener(DownloadListener downloadListener) {
        this.mDownloadListenerList.remove(downloadListener);
    }

    public void start(boolean bl2) {
        synchronized (this) {
            boolean bl3;
            block9: {
                bl3 = this.isDownloading;
                if (!bl3) break block9;
                return;
            }
            this.resetStatus();
            bl3 = true;
            this.isDownloading = bl3;
            this.mContinueDownload = bl2;
            DownLoadThreadPool downLoadThreadPool = DownLoadThreadPool.getInstance();
            SingleDownloadTask$1 singleDownloadTask$1 = new SingleDownloadTask$1(this);
            downLoadThreadPool.execute(singleDownloadTask$1);
            return;
        }
    }
}

