/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Process
 */
package com.zhiyun.net.download;

import android.os.Handler;
import android.os.Process;
import com.zhiyun.net.api.entity.DownloadFile;
import com.zhiyun.net.download.DownLoadThreadPool;
import com.zhiyun.net.download.DownloadApi;
import com.zhiyun.net.download.DownloadListener;
import com.zhiyun.net.download.DownloadService;
import com.zhiyun.net.download.DownloadTask$1;
import com.zhiyun.net.download.DownloadTask$2;
import com.zhiyun.net.download.DownloadTask$3;
import com.zhiyun.net.download.DownloadTask$4;
import com.zhiyun.net.download.DownloadTask$5;
import g.d0;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.concurrent.atomic.AtomicInteger;
import k.r;
import m.a.a;

public class DownloadTask {
    private static final int MAX_THREAD_COUNT = 8;
    private static final String TAG = "DownloadTask";
    private volatile boolean cancel;
    private AtomicInteger childCancelCount;
    private AtomicInteger childFailCount;
    private AtomicInteger childFinishCount;
    private AtomicInteger childPauseCount;
    private DecimalFormat decimalFormat;
    private volatile boolean isDownloading = false;
    private File[] mCacheFiles;
    private DownloadFile mDownloadFile;
    private DownloadListener mDownloadListener;
    private long mFileLength;
    private Handler mHandler;
    private long[] mProgress;
    private volatile int mThreadCount = 3;
    private File mTmpFile;
    private volatile boolean pause;

    public DownloadTask(DownloadFile downloadFile) {
        this(downloadFile, null);
    }

    public DownloadTask(DownloadFile object, DownloadListener downloadListener) {
        AtomicInteger atomicInteger;
        this.childCancelCount = atomicInteger = new AtomicInteger(0);
        this.childPauseCount = atomicInteger = new AtomicInteger(0);
        this.childFinishCount = atomicInteger = new AtomicInteger(0);
        this.childFailCount = atomicInteger = new AtomicInteger(0);
        this.mDownloadFile = object;
        this.mDownloadListener = downloadListener;
        object = new long[this.mThreadCount];
        this.mProgress = (long[])object;
        object = new File[this.mThreadCount];
        this.mCacheFiles = object;
        object = new Handler();
        this.mHandler = object;
        super("0.00");
        this.decimalFormat = object;
        super();
        ((DecimalFormatSymbols)object).setDecimalSeparator('.');
        this.decimalFormat.setDecimalFormatSymbols((DecimalFormatSymbols)object);
    }

    public static /* synthetic */ void access$000(DownloadTask downloadTask) {
        downloadTask.startTask();
    }

    public static /* synthetic */ void access$100(DownloadTask downloadTask, long l10, long l11, int n10) {
        downloadTask.download(l10, l11, n10);
    }

    public static /* synthetic */ void access$200(DownloadTask downloadTask) {
        downloadTask.downloadSingle();
    }

    public static /* synthetic */ DownloadListener access$300(DownloadTask downloadTask) {
        return downloadTask.mDownloadListener;
    }

    private void calculationCancel() {
        AtomicInteger atomicInteger = this.childCancelCount;
        int n10 = atomicInteger.incrementAndGet();
        int n11 = this.childFinishCount.get();
        n10 += n11;
        AtomicInteger atomicInteger2 = this.childFailCount;
        n11 = atomicInteger2.get();
        n10 += n11;
        n11 = this.mThreadCount;
        if ((n10 %= n11) != 0) {
            return;
        }
        this.sendCancelCallback();
    }

    private void calculationProgress() {
        long[] lArray;
        int n10;
        long l10 = 0L;
        double d10 = 0.0;
        Object object = null;
        for (int i10 = 0; i10 < (n10 = (lArray = this.mProgress).length); ++i10) {
            long l11 = lArray[i10];
            l10 += l11;
        }
        object = this.mDownloadListener;
        if (object != null) {
            object = this.decimalFormat;
            float f10 = l10;
            long l12 = this.mFileLength;
            float f11 = l12;
            d10 = f10 / f11;
            Float f12 = Float.valueOf(((NumberFormat)object).format(d10));
            f10 = f12.floatValue();
            this.sendProgressCallback(f10);
        }
    }

    private void cleanCacheFile() {
        int n10;
        for (int i10 = 0; i10 < (n10 = this.mThreadCount); ++i10) {
            String string2 = this.mDownloadFile.getFilePath();
            CharSequence charSequence = new StringBuilder();
            charSequence.append("thread");
            charSequence.append(i10);
            charSequence.append("_");
            String string3 = this.mDownloadFile.getFileName();
            charSequence.append(string3);
            string3 = ".cache";
            charSequence.append(string3);
            charSequence = charSequence.toString();
            File file = new File(string2, (String)charSequence);
            boolean bl2 = file.exists();
            if (!bl2) continue;
            file.delete();
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
                catch (IOException iOException) {}
                {
                    iOException.printStackTrace();
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
     * Exception decompiling
     */
    private void download(long var1_1, long var3_2, int var5_3) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 20[TRYBLOCK] [45, 46 : 746->751)] java.io.IOException
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
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

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    private void downloadSingle() {
        void var2_10;
        Object object;
        int n10;
        Object object2;
        DownloadTask downloadTask;
        block71: {
            block73: {
                FileOutputStream fileOutputStream;
                float f10;
                int n11;
                float f11;
                int n12;
                Object object3;
                block72: {
                    Object object4;
                    block70: {
                        boolean bl2;
                        long l10;
                        byte[] byArray;
                        long l11;
                        Object object5;
                        int n13;
                        block66: {
                            block67: {
                                downloadTask = this;
                                object3 = (DownloadApi)DownloadService.getDownloadRetrofit(this.mDownloadFile.getUrl(), 200).g(DownloadApi.class);
                                object2 = this.mDownloadFile.getUrl();
                                object3 = object3.download((String)object2);
                                n12 = 0;
                                f11 = 0.0f;
                                object2 = null;
                                n10 = 3;
                                n11 = 2;
                                f10 = 2.8E-45f;
                                n13 = 1;
                                object5 = object3.execute();
                                l11 = 0L;
                                int n14 = 2048;
                                byArray = new byte[n14];
                                object = ((r)object5).a();
                                object = (d0)object;
                                object = ((d0)object).byteStream();
                                object4 = "code = %s";
                                Object object6 = new Object[n13];
                                int n15 = ((r)object5).b();
                                Object object7 = n15;
                                object6[0] = object7;
                                a.b((String)object4, (Object[])object6);
                                object6 = this.mDownloadFile;
                                object6 = ((DownloadFile)object6).getFilePath();
                                object7 = this.mDownloadFile;
                                object7 = ((DownloadFile)object7).getFileName();
                                object4 = new File((String)object6, (String)object7);
                                object6 = ((r)object5).a();
                                object6 = (d0)object6;
                                l10 = ((d0)object6).contentLength();
                                bl2 = ((File)object4).exists();
                                if (!bl2) break block66;
                                long l12 = ((File)object4).length();
                                bl2 = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1);
                                if (bl2) break block67;
                                String string2 = ((File)object4).getAbsolutePath();
                                this.sendSuccessCallback(string2);
                                object3.cancel();
                                object3 = new Closeable[n11];
                                object3[0] = object;
                                object5 = ((r)object5).a();
                                object5 = (Closeable)object5;
                                object3[n13] = object5;
                                this.close((Closeable[])object3);
                                object3 = new Closeable[n10];
                                object3[0] = null;
                                object3[n13] = object;
                                object3[n11] = null;
                                this.close((Closeable[])object3);
                                return;
                            }
                            ((File)object4).delete();
                        }
                        fileOutputStream = new FileOutputStream((File)object4);
                        while (true) {
                            int n16;
                            block69: {
                                block68: {
                                    n16 = ((InputStream)object).read(byArray);
                                    n12 = -1;
                                    f11 = 0.0f / 0.0f;
                                    if (n16 == n12) break;
                                    n12 = (int)(downloadTask.cancel ? 1 : 0);
                                    if (n12 == 0) break block68;
                                    object3 = new Closeable[n10];
                                    object3[0] = fileOutputStream;
                                    object3[n13] = object;
                                    object2 = ((r)object5).a();
                                    object2 = (Closeable)object2;
                                    object3[n11] = object2;
                                    downloadTask.close((Closeable[])object3);
                                    object3 = new File[n13];
                                    object3[0] = object4;
                                    downloadTask.cleanFile((File[])object3);
                                    this.sendCancelCallback();
                                    object3 = new Closeable[n10];
                                    object3[0] = fileOutputStream;
                                    object3[n13] = object;
                                    object3[n11] = fileOutputStream;
                                    downloadTask.close((Closeable[])object3);
                                    return;
                                }
                                n12 = (int)(downloadTask.pause ? 1 : 0);
                                if (n12 == 0) break block69;
                                object3 = new Closeable[n10];
                                object3[0] = fileOutputStream;
                                object3[n13] = object;
                                object2 = ((r)object5).a();
                                object2 = (Closeable)object2;
                                object3[n11] = object2;
                                downloadTask.close((Closeable[])object3);
                                this.sendPauseCallback();
                                object3 = new Closeable[n10];
                                object3[0] = fileOutputStream;
                                object3[n13] = object;
                                object3[n11] = fileOutputStream;
                                downloadTask.close((Closeable[])object3);
                                return;
                            }
                            fileOutputStream.write(byArray, 0, n16);
                            long l13 = n16;
                            l11 += l13;
                            object3 = downloadTask.decimalFormat;
                            f11 = l11;
                            f10 = l10;
                            double d10 = f11 /= f10;
                            object3 = ((NumberFormat)object3).format(d10);
                            object3 = Float.valueOf((String)object3);
                            float f12 = ((Float)object3).floatValue();
                            downloadTask.sendProgressCallback(f12);
                            n11 = 2;
                            f10 = 2.8E-45f;
                            n13 = 1;
                            continue;
                            break;
                        }
                        fileOutputStream.flush();
                        object3 = ((File)object4).getAbsolutePath();
                        try {
                            downloadTask.sendSuccessCallback((String)object3);
                        }
                        catch (Exception exception) {
                            break block70;
                        }
                        object3 = new Closeable[n10];
                        object3[0] = fileOutputStream;
                        object3[1] = object;
                        n12 = 2;
                        f11 = 2.8E-45f;
                        object3[n12] = fileOutputStream;
                        downloadTask.close((Closeable[])object3);
                        break block73;
                        {
                            catch (Exception exception) {
                                bl2 = false;
                                fileOutputStream = null;
                            }
                        }
                    }
                    object2 = object4;
                    break block72;
                    catch (Throwable throwable) {}
                    {
                        break block71;
                        catch (Exception exception) {
                            boolean bl3 = false;
                            fileOutputStream = null;
                            break block72;
                        }
                    }
                    catch (Throwable throwable) {
                        object = null;
                        break block71;
                    }
                    catch (Exception exception) {
                        object = null;
                        boolean bl4 = false;
                        fileOutputStream = null;
                    }
                }
                ((Throwable)object3).printStackTrace();
                n11 = 1;
                f10 = Float.MIN_VALUE;
                object3 = new File[n11];
                object3[0] = object2;
                try {
                    downloadTask.cleanFile((File[])object3);
                    this.sendFailedCallback();
                }
                catch (Throwable throwable) {
                    object2 = fileOutputStream;
                }
                object3 = new Closeable[n10];
                object3[0] = fileOutputStream;
                object3[n11] = object;
                n12 = 2;
                f11 = 2.8E-45f;
                object3[n12] = fileOutputStream;
                downloadTask.close((Closeable[])object3);
            }
            return;
        }
        Closeable[] closeableArray = new Closeable[n10];
        closeableArray[0] = object2;
        closeableArray[1] = object;
        closeableArray[2] = object2;
        downloadTask.close(closeableArray);
        throw var2_10;
    }

    private void resetStatus() {
        AtomicInteger atomicInteger;
        this.pause = false;
        this.cancel = false;
        this.isDownloading = false;
        this.childPauseCount = atomicInteger = new AtomicInteger(0);
        this.childFailCount = atomicInteger = new AtomicInteger(0);
        this.childCancelCount = atomicInteger = new AtomicInteger(0);
        this.childFinishCount = atomicInteger = new AtomicInteger(0);
        long[] lArray = new long[this.mThreadCount];
        this.mProgress = lArray;
    }

    private void sendCancelCallback() {
        this.resetStatus();
        this.cleanCacheFile();
        int n10 = this.mThreadCount;
        Object object = new long[n10];
        this.mProgress = object;
        object = this.mDownloadListener;
        if (object != null) {
            object.onCancel();
        }
    }

    private void sendFailedCallback() {
        this.resetStatus();
        Handler handler = this.mHandler;
        DownloadTask$4 downloadTask$4 = new DownloadTask$4(this);
        handler.post((Runnable)downloadTask$4);
    }

    private void sendPauseCallback() {
        Object object = this.childPauseCount;
        boolean bl2 = this.confirmStatus((AtomicInteger)object);
        if (bl2) {
            return;
        }
        this.resetStatus();
        object = this.mDownloadListener;
        if (object != null) {
            object.onPause();
        }
    }

    private void sendProgressCallback(float f10) {
        DownloadListener downloadListener = this.mDownloadListener;
        if (downloadListener != null) {
            downloadListener.onProgress(f10);
        }
    }

    private void sendSuccessCallback(String string2) {
        Handler handler = this.mCacheFiles;
        this.cleanFile((File[])handler);
        this.resetStatus();
        handler = this.mHandler;
        DownloadTask$5 downloadTask$5 = new DownloadTask$5(this, string2);
        handler.post((Runnable)downloadTask$5);
    }

    private void singleDownloadFail() {
        Object object = new Object[1];
        Number number = Process.myTid();
        object[0] = number;
        a.b("single download fail%s", (Object[])object);
        object = this.childFailCount;
        int n10 = ((AtomicInteger)object).incrementAndGet();
        number = this.childFinishCount;
        int n11 = ((AtomicInteger)number).get();
        n10 += n11;
        n11 = this.mThreadCount;
        if ((n10 %= n11) != 0) {
            return;
        }
        this.sendFailedCallback();
    }

    private void singleDownloadSuccess() {
        Object object = new Object[1];
        int n10 = Process.myTid();
        Object object2 = n10;
        String string2 = null;
        object[0] = object2;
        object2 = "single download success%s";
        a.b((String)object2, (Object[])object);
        object = this.childFinishCount;
        boolean bl2 = this.confirmStatus((AtomicInteger)object);
        if (bl2) {
            return;
        }
        object2 = this.mDownloadFile.getFilePath();
        string2 = this.mDownloadFile.getFileName();
        object = new File((String)object2, string2);
        this.mTmpFile.renameTo((File)object);
        object = ((File)object).getAbsolutePath();
        this.sendSuccessCallback((String)object);
    }

    private void startDownload(long l10, long l11, int n10) {
        DownLoadThreadPool downLoadThreadPool = DownLoadThreadPool.getInstance();
        DownloadTask$2 downloadTask$2 = new DownloadTask$2(this, l10, l11, n10);
        downLoadThreadPool.execute(downloadTask$2);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void startTask() {
        block16: {
            block20: {
                block18: {
                    block19: {
                        block17: {
                            var1_1 = (DownloadApi)DownloadService.getDownloadRetrofit(this.mDownloadFile.getUrl(), 20).g(DownloadApi.class);
                            var2_4 = this.mDownloadFile.getUrl();
                            var1_1 = var1_1.download(var2_4);
                            var2_4 = null;
                            var3_5 = 1;
                            var4_6 = null;
                            try {
                                var5_7 = var1_1.execute();
                                var6_8 = var5_7.g();
                                if (var6_8 == 0 || (var7_9 = var5_7.a()) == null) ** GOTO lbl-1000
                                var7_9 = var5_7.a();
                                var7_9 = (d0)var7_9;
                                this.mFileLength = var8_10 = var7_9.contentLength();
                                var1_1.cancel();
                                var10_11 = 2;
                                var1_1 = new Closeable[var10_11];
                                var7_9 = var5_7.a();
                                var1_1[0] = var7_9 = (Closeable)var7_9;
                                var5_7 = var5_7.a();
                                var5_7 = (d0)var5_7;
                                var5_7 = var5_7.byteStream();
                                var1_1[var3_5] = var5_7;
                                this.close((Closeable[])var1_1);
                                var5_7 = this.mDownloadFile;
                                var5_7 = var5_7.getFilePath();
                                var7_9 = this.mDownloadFile;
                                var7_9 = var7_9.getFileName();
                                var1_1 = new File((String)var5_7, (String)var7_9);
                                var11_12 = var1_1.exists();
                                if (var11_12 && !(var11_12 = (cfr_temp_0 = (var12_13 = var1_1.length()) - (var14_14 = this.mFileLength)) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1))) {
                                    var1_1 = var1_1.getAbsolutePath();
                                    this.sendSuccessCallback((String)var1_1);
                                }
                                ** GOTO lbl-1000
                            }
                            catch (Throwable var1_2) {
                                break block16;
                            }
                            catch (IOException var1_3) {
                                // empty catch block
                                ** GOTO lbl-1000
                            }
                            var1_1 = new Closeable[var3_5];
                            var1_1[0] = null;
                            this.close((Closeable[])var1_1);
                            return;
lbl-1000:
                            // 1 sources

                            {
                                var5_7 = this.mDownloadFile;
                                var5_7 = var5_7.getFilePath();
                                var7_9 = new StringBuilder();
                                var16_15 = this.mDownloadFile;
                                var16_15 = var16_15.getFileName();
                                var7_9.append((String)var16_15);
                                var16_15 = ".tmp";
                                var7_9.append((String)var16_15);
                                var7_9 = var7_9.toString();
                                this.mTmpFile = var1_1 = new File((String)var5_7, (String)var7_9);
                                var10_11 = (int)var1_1.exists();
                                if (var10_11 != 0 && (var10_11 = (int)((cfr_temp_1 = (var12_13 = (var1_1 = this.mTmpFile).length()) - (var14_14 = this.mFileLength)) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1))) != 0) {
                                    var1_1 = "exist same name file";
                                    var5_7 = new Object[]{};
                                    a.b((String)var1_1, var5_7);
                                    this.cleanCacheFile();
                                }
                                var1_1 = this.mTmpFile;
                                var10_11 = (int)(var1_1 = var1_1.getParentFile()).exists();
                                if (var10_11 == 0) {
                                    var1_1 = this.mTmpFile;
                                    var1_1 = var1_1.getParentFile();
                                    var1_1.mkdirs();
                                }
                                var5_7 = this.mTmpFile;
                                var7_9 = "rw";
                                var1_1 = new RandomAccessFile((File)var5_7, (String)var7_9);
                            }
                            try {
                                var17_16 = this.mFileLength;
                                var1_1.setLength(var17_16);
                                var17_16 = this.mFileLength;
                                var6_8 = this.mThreadCount;
                                var8_10 = var6_8;
                                var17_16 /= var8_10;
                                var19_17 = 0;
lbl80:
                                // 2 sources

                                while (var19_17 < (var6_8 = this.mThreadCount)) {
                                    break block17;
                                }
                                break block18;
                            }
                            catch (Throwable var25_21) {
                                var4_6 = var1_1;
                                var1_1 = var25_21;
                                break block16;
                            }
                            catch (IOException var25_22) {
                                var4_6 = var1_1;
                                var1_1 = var25_22;
                                ** GOTO lbl-1000
                            }
                        }
                        var8_10 = var19_17;
                        var14_14 = var8_10 * var17_16;
                        var20_18 = var19_17 + 1;
                        var21_19 = (long)var20_18 * var17_16;
                        var23_20 = 1L;
                        var21_19 -= var23_20;
                        {
                            var6_8 = this.mThreadCount - var3_5;
                            if (var19_17 != var6_8) break block19;
                        }
                        {
                            var21_19 = this.mFileLength - var23_20;
                        }
                    }
                    var7_9 = this;
                    {
                        this.startDownload(var14_14, var21_19, var19_17);
                        var19_17 = var20_18;
                        ** GOTO lbl80
                    }
                }
                var4_6 = var1_1;
                break block20;
lbl-1000:
                // 1 sources

                {
                    this.sendFailedCallback();
                }
            }
            var1_1 = new Closeable[var3_5];
            var1_1[0] = var4_6;
            this.close((Closeable[])var1_1);
            return;
lbl-1000:
            // 2 sources

            {
                this.sendFailedCallback();
                var1_1.printStackTrace();
            }
            var1_1 = new Closeable[var3_5];
            var1_1[0] = var4_6;
            this.close((Closeable[])var1_1);
            return;
        }
        var26_23 = new Closeable[var3_5];
        var26_23[0] = var4_6;
        this.close(var26_23);
        throw var1_1;
    }

    public void addDownloadListener(DownloadListener downloadListener) {
        this.mDownloadListener = downloadListener;
    }

    public void cancel() {
        File file;
        int n10 = 1;
        this.cancel = n10;
        File[] fileArray = new File[n10];
        fileArray[0] = file = this.mTmpFile;
        this.cleanFile(fileArray);
        n10 = (int)(this.isDownloading ? 1 : 0);
        if (n10 == 0 && (fileArray = this.mDownloadListener) != null) {
            fileArray = this.mCacheFiles;
            this.cleanFile(fileArray);
            this.sendCancelCallback();
        }
    }

    public void cleanAllFile() {
        File file = this.mTmpFile;
        File[] fileArray = new File[]{file};
        this.cleanFile(fileArray);
        this.cleanCacheFile();
    }

    /*
     * WARNING - void declaration
     */
    public boolean confirmStatus(AtomicInteger atomicInteger) {
        void var2_6;
        int n10;
        int n11 = atomicInteger.incrementAndGet();
        n11 = n11 % (n10 = this.mThreadCount);
        if (n11 != 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            atomicInteger = null;
        }
        return (boolean)var2_6;
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

    public void removeListener() {
        this.mDownloadListener = null;
    }

    public void setThreadCount(int n10) {
        int n11 = 8;
        if (n10 > n11) {
            n10 = n11;
        }
        this.mThreadCount = n10;
    }

    public void start() {
        synchronized (this) {
            boolean bl2;
            block8: {
                bl2 = this.isDownloading;
                if (!bl2) break block8;
                return;
            }
            this.resetStatus();
            bl2 = true;
            this.isDownloading = bl2;
            DownLoadThreadPool downLoadThreadPool = DownLoadThreadPool.getInstance();
            DownloadTask$1 downloadTask$1 = new DownloadTask$1(this);
            downLoadThreadPool.execute(downloadTask$1);
            return;
        }
    }

    public void startSingleDownload() {
        synchronized (this) {
            boolean bl2;
            block7: {
                bl2 = this.isDownloading;
                if (!bl2) break block7;
                return;
            }
            bl2 = true;
            this.isDownloading = bl2;
            DownLoadThreadPool downLoadThreadPool = DownLoadThreadPool.getInstance();
            DownloadTask$3 downloadTask$3 = new DownloadTask$3(this);
            downLoadThreadPool.execute(downloadTask$3);
            return;
        }
    }
}

