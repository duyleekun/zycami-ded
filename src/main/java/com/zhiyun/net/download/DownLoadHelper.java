/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.text.TextUtils
 */
package com.zhiyun.net.download;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.arch.core.util.Function;
import com.zhiyun.net.api.entity.DownloadEntity;
import com.zhiyun.net.download.DownLoadHelper$1;
import com.zhiyun.net.download.DownLoadHelper$2;
import com.zhiyun.net.download.DownLoadHelper$3;
import com.zhiyun.net.download.DownLoadHelper$4;
import com.zhiyun.net.download.DownLoadHelper$5;
import com.zhiyun.net.download.DownLoadHelper$6;
import com.zhiyun.net.download.DownLoadHelper$7;
import com.zhiyun.net.download.DownLoadHelper$8;
import com.zhiyun.net.download.DownLoadHelper$9;
import com.zhiyun.net.download.DownLoadHelper$CancelControl;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadCallback;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadFileCallback;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadFileEntityCallback;
import com.zhiyun.net.download.DownLoadThreadPool;
import com.zhiyun.net.download.DownloadApi;
import com.zhiyun.net.download.DownloadService;
import com.zhiyun.net.download.SequentialDownLoadThreadPool;
import d.v.u.a.b;
import d.v.u.a.c;
import d.v.u.a.d;
import d.v.u.a.e;
import d.v.u.a.f;
import d.v.u.a.g;
import d.v.u.a.h;
import d.v.u.a.i;
import d.v.u.a.j;
import d.v.u.a.k;
import d.v.u.a.l;
import d.v.u.a.m;
import d.v.u.a.n;
import d.v.u.a.o;
import d.v.u.a.p;
import g.a0;
import g.c0;
import g.t;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import k.r;
import m.a.a;

public class DownLoadHelper {
    private static volatile DownLoadHelper mInstance;
    private final String HOST;
    private Handler mHandler;
    private long preTime;

    private DownLoadHelper() {
        Handler handler;
        this.HOST = "https://www.zhiyun-tech.com/";
        Looper looper = Looper.getMainLooper();
        this.mHandler = handler = new Handler(looper);
    }

    public static /* synthetic */ Void a(DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback, DownloadEntity downloadEntity, Void void_) {
        if (downLoadHelper$OnDownloadFileEntityCallback != null) {
            downLoadHelper$OnDownloadFileEntityCallback.cancel(downloadEntity);
        }
        return null;
    }

    public static /* synthetic */ void access$000(DownLoadHelper downLoadHelper, String string2, String string3, String string4, DownLoadHelper$OnDownloadCallback downLoadHelper$OnDownloadCallback) {
        downLoadHelper.download(string2, string3, string4, downLoadHelper$OnDownloadCallback);
    }

    public static /* synthetic */ void access$1000(DownLoadHelper downLoadHelper, DownloadEntity downloadEntity, DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback, boolean bl2) {
        downLoadHelper.sendSuccessCallback(downloadEntity, downLoadHelper$OnDownloadFileEntityCallback, bl2);
    }

    public static /* synthetic */ void access$1100(DownLoadHelper downLoadHelper, DownloadEntity downloadEntity, Throwable throwable, DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback, boolean bl2) {
        downLoadHelper.sendDownloadFailedCallback(downloadEntity, throwable, downLoadHelper$OnDownloadFileEntityCallback, bl2);
    }

    public static /* synthetic */ void access$1200(DownLoadHelper downLoadHelper, DownloadEntity downloadEntity, Throwable throwable, DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback, boolean bl2) {
        downLoadHelper.sendSaveFailedCallback(downloadEntity, throwable, downLoadHelper$OnDownloadFileEntityCallback, bl2);
    }

    public static /* synthetic */ void access$1300(DownLoadHelper downLoadHelper, DownloadEntity downloadEntity, int n10, long l10, long l11, DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback, boolean bl2) {
        downLoadHelper.sendProgressCallback(downloadEntity, n10, l10, l11, downLoadHelper$OnDownloadFileEntityCallback, bl2);
    }

    public static /* synthetic */ void access$1400(DownLoadHelper downLoadHelper, DownloadEntity downloadEntity, DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback, boolean bl2) {
        downLoadHelper.sendCancelCallback(downloadEntity, downLoadHelper$OnDownloadFileEntityCallback, bl2);
    }

    public static /* synthetic */ void access$200(DownLoadHelper downLoadHelper, Throwable throwable, DownLoadHelper$OnDownloadCallback downLoadHelper$OnDownloadCallback, boolean bl2) {
        downLoadHelper.sendFailedCallback(throwable, downLoadHelper$OnDownloadCallback, bl2);
    }

    public static /* synthetic */ void access$300(DownLoadHelper downLoadHelper, Throwable throwable, DownLoadHelper$OnDownloadFileCallback onDownloadFileCallback, boolean bl2) {
        downLoadHelper.sendFileFailedCallback(throwable, onDownloadFileCallback, bl2);
    }

    public static /* synthetic */ void access$400(DownLoadHelper downLoadHelper, String string2, DownLoadHelper$OnDownloadCallback downLoadHelper$OnDownloadCallback, boolean bl2) {
        downLoadHelper.sendSuccessCallback(string2, downLoadHelper$OnDownloadCallback, bl2);
    }

    public static /* synthetic */ void access$500(DownLoadHelper downLoadHelper, String string2) {
        downLoadHelper.printTime(string2);
    }

    public static /* synthetic */ void access$600(DownLoadHelper downLoadHelper, DownLoadHelper$OnDownloadFileCallback onDownloadFileCallback, boolean bl2) {
        downLoadHelper.sendCancelCallback(onDownloadFileCallback, bl2);
    }

    public static /* synthetic */ void access$700(DownLoadHelper downLoadHelper, int n10, DownLoadHelper$OnDownloadCallback downLoadHelper$OnDownloadCallback, boolean bl2) {
        downLoadHelper.sendProgressCallback(n10, downLoadHelper$OnDownloadCallback, bl2);
    }

    public static /* synthetic */ void access$800(DownLoadHelper downLoadHelper, int n10, DownLoadHelper$OnDownloadFileCallback onDownloadFileCallback, boolean bl2) {
        downLoadHelper.sendProgressCountCallback(n10, onDownloadFileCallback, bl2);
    }

    public static /* synthetic */ void access$900(DownLoadHelper downLoadHelper, DownloadEntity downloadEntity, int n10, int n11, DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback, boolean bl2) {
        downLoadHelper.sendCountCallback(downloadEntity, n10, n11, downLoadHelper$OnDownloadFileEntityCallback, bl2);
    }

    public static /* synthetic */ Void b(DownLoadHelper$OnDownloadFileCallback downLoadHelper$OnDownloadFileCallback, Void void_) {
        if (downLoadHelper$OnDownloadFileCallback != null) {
            downLoadHelper$OnDownloadFileCallback.cancel();
        }
        return null;
    }

    public static /* synthetic */ Void c(DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback, DownloadEntity downloadEntity, int n10, int n11, Void void_) {
        if (downLoadHelper$OnDownloadFileEntityCallback != null) {
            downLoadHelper$OnDownloadFileEntityCallback.downloadCount(downloadEntity, n10, n11);
        }
        return null;
    }

    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    public static /* synthetic */ Void d(DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback, DownloadEntity downloadEntity, Throwable throwable, Void void_) {
        if (downLoadHelper$OnDownloadFileEntityCallback != null) {
            downLoadHelper$OnDownloadFileEntityCallback.downloadFailed(downloadEntity, throwable);
        }
        return null;
    }

    /*
     * Exception decompiling
     */
    private void download(String var1_1, String var2_11, String var3_12, DownLoadHelper$OnDownloadCallback var4_13) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [29[UNCONDITIONALDOLOOP]], but top level block is 19[TRYBLOCK]
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

    /*
     * Exception decompiling
     */
    private void download(String var1_1, String var2_12, String var3_13, DownLoadHelper$OnDownloadFileCallback var4_14, DownLoadHelper$CancelControl var5_15, boolean var6_16) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [47[UNCONDITIONALDOLOOP]], but top level block is 34[TRYBLOCK]
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

    /*
     * Exception decompiling
     */
    private boolean download(DownloadEntity var1_1, DownLoadHelper$OnDownloadFileEntityCallback var2_2, DownLoadHelper$CancelControl var3_3, boolean var4_4) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 14[TRYBLOCK] [37, 36 : 291->296)] java.lang.Throwable
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

    private void downloadSyn(String object, String string2, String string3, DownLoadHelper$OnDownloadFileCallback downLoadHelper$OnDownloadFileCallback, DownLoadHelper$CancelControl downLoadHelper$CancelControl, boolean bl2) {
        object = ((DownloadApi)DownloadService.getDownloadRetrofit("https://www.zhiyun-tech.com/", 20).g(DownloadApi.class)).download((String)object);
        DownLoadHelper$6 downLoadHelper$6 = new DownLoadHelper$6(this, downLoadHelper$OnDownloadFileCallback, bl2, string3, string2, downLoadHelper$CancelControl);
        object.h(downLoadHelper$6);
    }

    public static /* synthetic */ Void e(DownLoadHelper$OnDownloadCallback downLoadHelper$OnDownloadCallback, Throwable throwable, Void void_) {
        if (downLoadHelper$OnDownloadCallback != null) {
            downLoadHelper$OnDownloadCallback.downloadFailed(throwable);
        }
        return null;
    }

    public static /* synthetic */ Void f(DownLoadHelper$OnDownloadFileCallback downLoadHelper$OnDownloadFileCallback, Throwable throwable, Void void_) {
        if (downLoadHelper$OnDownloadFileCallback != null) {
            downLoadHelper$OnDownloadFileCallback.saveFailed(throwable);
        }
        return null;
    }

    public static /* synthetic */ void g(Function function) {
        function.apply(null);
    }

    private static String getFileName(r object, String object2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = DownLoadHelper.getHeaderFileName((r)object)));
        if (!bl2) {
            object2 = object;
        }
        return object2;
    }

    private static String getFileNameHasSuffix(String string2) {
        String string3 = File.separator;
        int n10 = string2.lastIndexOf(string3) + 1;
        return string2.substring(n10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String getHeaderFileName(r object) {
        try {
            Object object2;
            object = ((r)object).i();
            for (object = ((c0)object).F0(); object != null && (object2 = ((c0)object).F0()) != null; object = ((c0)object).F0()) {
            }
            if (object == null) return "";
            object2 = DownLoadHelper.getHeaderFileNameFromHeaders((c0)object);
            boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
            if (!bl2) return object2;
            object = ((c0)object).L0();
            object = ((a0)object).q();
            object = ((t)object).a0();
            object = ((URL)object).toString();
            object2 = StandardCharsets.UTF_8;
            object2 = ((Charset)object2).toString();
            object = URLDecoder.decode((String)object, (String)object2);
            return DownLoadHelper.getFileNameHasSuffix((String)object);
        }
        catch (Exception exception) {}
        return "";
    }

    private static String getHeaderFileNameFromHeaders(c0 stringArray) {
        stringArray = stringArray.C0();
        String string2 = "Content-Disposition";
        stringArray = stringArray.e(string2);
        int n10 = TextUtils.isEmpty((CharSequence)stringArray);
        String string3 = "";
        if (n10 == 0) {
            stringArray.replace("attachment;filename=", string3);
            stringArray.replace("filename*=utf-8", string3);
            string2 = ";";
            stringArray = stringArray.split(string2);
            n10 = stringArray.length;
            int n11 = 1;
            if (n10 > n11) {
                return stringArray[n11].replace("filename=", string3).replace("\"", string3);
            }
        }
        return string3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static DownLoadHelper getInstance() {
        Object object = mInstance;
        if (object != null) return mInstance;
        object = DownLoadHelper.class;
        synchronized (object) {
            DownLoadHelper downLoadHelper = mInstance;
            if (downLoadHelper != null) return mInstance;
            mInstance = downLoadHelper = new DownLoadHelper();
            return mInstance;
        }
    }

    public static int getProgress(int n10, int n11, int n12) {
        double d10 = (double)n11 * 1.0;
        double d11 = n12;
        double d12 = n10;
        double d13 = 100.0;
        d12 = d12 / d13 / d11;
        return (int)(((d10 /= d11) + d12) * d13);
    }

    public static /* synthetic */ Void h(DownLoadHelper$OnDownloadCallback downLoadHelper$OnDownloadCallback, int n10, Void void_) {
        if (downLoadHelper$OnDownloadCallback != null) {
            downLoadHelper$OnDownloadCallback.downloadProgress(n10);
        }
        return null;
    }

    public static /* synthetic */ Void i(DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback, DownloadEntity downloadEntity, int n10, long l10, long l11, Void void_) {
        if (downLoadHelper$OnDownloadFileEntityCallback != null) {
            downLoadHelper$OnDownloadFileEntityCallback.downloadProgress(downloadEntity, n10, l10, l11);
        }
        return null;
    }

    public static /* synthetic */ Void j(DownLoadHelper$OnDownloadFileCallback downLoadHelper$OnDownloadFileCallback, int n10, Void void_) {
        if (downLoadHelper$OnDownloadFileCallback != null) {
            downLoadHelper$OnDownloadFileCallback.downloadCount(n10);
        }
        return null;
    }

    public static /* synthetic */ Void k(DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback, DownloadEntity downloadEntity, Throwable throwable, Void void_) {
        if (downLoadHelper$OnDownloadFileEntityCallback != null) {
            downLoadHelper$OnDownloadFileEntityCallback.saveFailed(downloadEntity, throwable);
        }
        return null;
    }

    public static /* synthetic */ Void l(DownLoadHelper$OnDownloadCallback downLoadHelper$OnDownloadCallback, String string2, Void void_) {
        if (downLoadHelper$OnDownloadCallback != null) {
            downLoadHelper$OnDownloadCallback.downloadSuccess(string2);
        }
        return null;
    }

    public static /* synthetic */ Void m(DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback, DownloadEntity downloadEntity, Void void_) {
        if (downLoadHelper$OnDownloadFileEntityCallback != null) {
            downLoadHelper$OnDownloadFileEntityCallback.downloadSuccess(downloadEntity);
        }
        return null;
    }

    private /* synthetic */ void n(DownloadEntity downloadEntity, DownLoadHelper$OnDownloadFileCallback downLoadHelper$OnDownloadFileCallback, DownLoadHelper$CancelControl downLoadHelper$CancelControl, boolean bl2) {
        String string2 = downloadEntity.getUrl();
        String string3 = downloadEntity.getDestFileDir();
        String string4 = downloadEntity.getFileName();
        this.download(string2, string3, string4, downLoadHelper$OnDownloadFileCallback, downLoadHelper$CancelControl, bl2);
    }

    private /* synthetic */ void p(DownloadEntity downloadEntity, DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback, DownLoadHelper$CancelControl downLoadHelper$CancelControl, boolean bl2) {
        this.download(downloadEntity, downLoadHelper$OnDownloadFileEntityCallback, downLoadHelper$CancelControl, bl2);
    }

    private void printTime(String string2) {
        long l10 = this.preTime;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            Object[] objectArray = new StringBuilder();
            objectArray.append(string2);
            objectArray.append(":");
            long l13 = System.currentTimeMillis();
            long l14 = this.preTime;
            objectArray.append(l13 -= l14);
            string2 = objectArray.toString();
            object = 0;
            objectArray = new Object[]{};
            a.i(string2, objectArray);
        }
        this.preTime = l10 = System.currentTimeMillis();
    }

    private /* synthetic */ void r(List object, DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback, DownLoadHelper$CancelControl downLoadHelper$CancelControl, boolean bl2) {
        DownloadEntity downloadEntity;
        String string2;
        boolean bl3;
        boolean bl4;
        object = object.iterator();
        while ((bl4 = object.hasNext()) && ((bl3 = TextUtils.isEmpty((CharSequence)(string2 = (downloadEntity = (DownloadEntity)object.next()).getUrl()))) || (bl4 = this.download(downloadEntity, downLoadHelper$OnDownloadFileEntityCallback, downLoadHelper$CancelControl, bl2)))) {
        }
    }

    private void sendCancelCallback(DownloadEntity downloadEntity, DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback, boolean bl2) {
        f f10 = new f(downLoadHelper$OnDownloadFileEntityCallback, downloadEntity);
        this.sendMessage(bl2, f10);
    }

    private void sendCancelCallback(DownLoadHelper$OnDownloadFileCallback downLoadHelper$OnDownloadFileCallback, boolean bl2) {
        h h10 = new h(downLoadHelper$OnDownloadFileCallback);
        this.sendMessage(bl2, h10);
    }

    private void sendCountCallback(DownloadEntity downloadEntity, int n10, int n11, DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback, boolean bl2) {
        n n12 = new n(downLoadHelper$OnDownloadFileEntityCallback, downloadEntity, n10, n11);
        this.sendMessage(bl2, n12);
    }

    private void sendDownloadFailedCallback(DownloadEntity downloadEntity, Throwable throwable, DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback, boolean bl2) {
        c c10 = new c(downLoadHelper$OnDownloadFileEntityCallback, downloadEntity, throwable);
        this.sendMessage(bl2, c10);
    }

    private void sendFailedCallback(Throwable throwable, DownLoadHelper$OnDownloadCallback downLoadHelper$OnDownloadCallback) {
        Handler handler = this.mHandler;
        DownLoadHelper$1 downLoadHelper$1 = new DownLoadHelper$1(this, downLoadHelper$OnDownloadCallback, throwable);
        handler.post((Runnable)downLoadHelper$1);
    }

    private void sendFailedCallback(Throwable throwable, DownLoadHelper$OnDownloadCallback downLoadHelper$OnDownloadCallback, boolean bl2) {
        k k10 = new k(downLoadHelper$OnDownloadCallback, throwable);
        this.sendMessage(bl2, k10);
    }

    private void sendFileFailedCallback(Throwable throwable, DownLoadHelper$OnDownloadFileCallback downLoadHelper$OnDownloadFileCallback, boolean bl2) {
        o o10 = new o(downLoadHelper$OnDownloadFileCallback, throwable);
        this.sendMessage(bl2, o10);
    }

    private void sendMessage(boolean bl2, Function function) {
        if (bl2) {
            Handler handler = this.mHandler;
            l l10 = new l(function);
            handler.post((Runnable)l10);
        } else {
            bl2 = false;
            Object var3_4 = null;
            function.apply(null);
        }
    }

    private void sendProgressCallback(int n10, DownLoadHelper$OnDownloadCallback downLoadHelper$OnDownloadCallback) {
        Handler handler = this.mHandler;
        DownLoadHelper$3 downLoadHelper$3 = new DownLoadHelper$3(this, downLoadHelper$OnDownloadCallback, n10);
        handler.post((Runnable)downLoadHelper$3);
    }

    private void sendProgressCallback(int n10, DownLoadHelper$OnDownloadCallback downLoadHelper$OnDownloadCallback, boolean bl2) {
        g g10 = new g(downLoadHelper$OnDownloadCallback, n10);
        this.sendMessage(bl2, g10);
    }

    private void sendProgressCallback(DownloadEntity downloadEntity, int n10, long l10, long l11, DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback, boolean bl2) {
        b b10 = new b(downLoadHelper$OnDownloadFileEntityCallback, downloadEntity, n10, l10, l11);
        this.sendMessage(bl2, b10);
    }

    private void sendProgressCountCallback(int n10, DownLoadHelper$OnDownloadFileCallback downLoadHelper$OnDownloadFileCallback, boolean bl2) {
        m m10 = new m(downLoadHelper$OnDownloadFileCallback, n10);
        this.sendMessage(bl2, m10);
    }

    private void sendSaveFailedCallback(DownloadEntity downloadEntity, Throwable throwable, DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback, boolean bl2) {
        j j10 = new j(downLoadHelper$OnDownloadFileEntityCallback, downloadEntity, throwable);
        this.sendMessage(bl2, j10);
    }

    private void sendSuccessCallback(DownloadEntity downloadEntity, DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback, boolean bl2) {
        p p10 = new p(downLoadHelper$OnDownloadFileEntityCallback, downloadEntity);
        this.sendMessage(bl2, p10);
    }

    private void sendSuccessCallback(String string2, DownLoadHelper$OnDownloadCallback downLoadHelper$OnDownloadCallback) {
        Handler handler = this.mHandler;
        DownLoadHelper$2 downLoadHelper$2 = new DownLoadHelper$2(this, downLoadHelper$OnDownloadCallback, string2);
        handler.post((Runnable)downLoadHelper$2);
    }

    private void sendSuccessCallback(String string2, DownLoadHelper$OnDownloadCallback downLoadHelper$OnDownloadCallback, boolean bl2) {
        d d10 = new d(downLoadHelper$OnDownloadCallback, string2);
        this.sendMessage(bl2, d10);
    }

    public /* synthetic */ void o(DownloadEntity downloadEntity, DownLoadHelper$OnDownloadFileCallback downLoadHelper$OnDownloadFileCallback, DownLoadHelper$CancelControl downLoadHelper$CancelControl, boolean bl2) {
        this.n(downloadEntity, downLoadHelper$OnDownloadFileCallback, downLoadHelper$CancelControl, bl2);
    }

    public /* synthetic */ void q(DownloadEntity downloadEntity, DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback, DownLoadHelper$CancelControl downLoadHelper$CancelControl, boolean bl2) {
        this.p(downloadEntity, downLoadHelper$OnDownloadFileEntityCallback, downLoadHelper$CancelControl, bl2);
    }

    public /* synthetic */ void s(List list, DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback, DownLoadHelper$CancelControl downLoadHelper$CancelControl, boolean bl2) {
        this.r(list, downLoadHelper$OnDownloadFileEntityCallback, downLoadHelper$CancelControl, bl2);
    }

    public void startDownLoad(String string2, String string3, String string4, DownLoadHelper$OnDownloadCallback downLoadHelper$OnDownloadCallback) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            DownLoadHelper$4 downLoadHelper$4 = new DownLoadHelper$4(this, string2, string3, string4, downLoadHelper$OnDownloadCallback);
            Thread thread = new Thread(downLoadHelper$4);
            thread.start();
        }
    }

    public void startThreadPoolDownLoad(DownloadEntity downloadEntity, DownLoadHelper$OnDownloadFileCallback downLoadHelper$OnDownloadFileCallback, DownLoadHelper$CancelControl downLoadHelper$CancelControl) {
        this.startThreadPoolDownLoad(downloadEntity, downLoadHelper$OnDownloadFileCallback, downLoadHelper$CancelControl, false);
    }

    public void startThreadPoolDownLoad(DownloadEntity downloadEntity, DownLoadHelper$OnDownloadFileCallback downLoadHelper$OnDownloadFileCallback, DownLoadHelper$CancelControl downLoadHelper$CancelControl, boolean bl2) {
        Object object = downloadEntity.getUrl();
        boolean bl3 = TextUtils.isEmpty((CharSequence)object);
        if (!bl3) {
            object = SequentialDownLoadThreadPool.getInstance();
            d.v.u.a.a a10 = new d.v.u.a.a(this, downloadEntity, downLoadHelper$OnDownloadFileCallback, downLoadHelper$CancelControl, bl2);
            ((SequentialDownLoadThreadPool)object).execute(a10);
        }
    }

    public void startThreadPoolDownLoad(DownloadEntity downloadEntity, DownLoadHelper$OnDownloadFileEntityCallback downLoadHelper$OnDownloadFileEntityCallback, DownLoadHelper$CancelControl downLoadHelper$CancelControl, boolean bl2) {
        Object object = downloadEntity.getUrl();
        boolean bl3 = TextUtils.isEmpty((CharSequence)object);
        if (!bl3) {
            object = SequentialDownLoadThreadPool.getInstance();
            i i10 = new i(this, downloadEntity, downLoadHelper$OnDownloadFileEntityCallback, downLoadHelper$CancelControl, bl2);
            ((SequentialDownLoadThreadPool)object).execute(i10);
        }
    }

    public void startThreadPoolDownLoad(String string2, String string3, String string4, DownLoadHelper$OnDownloadCallback downLoadHelper$OnDownloadCallback) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            DownLoadThreadPool downLoadThreadPool = DownLoadThreadPool.getInstance();
            DownLoadHelper$5 downLoadHelper$5 = new DownLoadHelper$5(this, string2, string3, string4, downLoadHelper$OnDownloadCallback);
            downLoadThreadPool.execute(downLoadHelper$5);
        }
    }

    public void startThreadPoolDownLoad(List list, DownLoadHelper$OnDownloadFileCallback downLoadHelper$OnDownloadFileCallback, DownLoadHelper$CancelControl downLoadHelper$CancelControl) {
        this.startThreadPoolDownLoad(list, downLoadHelper$OnDownloadFileCallback, downLoadHelper$CancelControl, false);
    }

    public void startThreadPoolDownLoad(List object, DownLoadHelper$OnDownloadFileCallback object2, DownLoadHelper$CancelControl downLoadHelper$CancelControl, boolean bl2) {
        boolean bl3;
        int n10 = object.size();
        DownLoadHelper$7 downLoadHelper$7 = new DownLoadHelper$7(this, (DownLoadHelper$OnDownloadFileCallback)object2, bl2, n10);
        object = object.iterator();
        while (bl3 = object.hasNext()) {
            object2 = (DownloadEntity)object.next();
            this.startThreadPoolDownLoad((DownloadEntity)object2, (DownLoadHelper$OnDownloadFileCallback)downLoadHelper$7, downLoadHelper$CancelControl, bl2);
        }
    }

    public void startThreadPoolDownLoad(List object, DownLoadHelper$OnDownloadFileEntityCallback object2, DownLoadHelper$CancelControl downLoadHelper$CancelControl, boolean bl2) {
        boolean bl3;
        DownLoadHelper$8 downLoadHelper$8 = new DownLoadHelper$8(this, (List)object, (DownLoadHelper$OnDownloadFileEntityCallback)object2, bl2);
        object = object.iterator();
        while (bl3 = object.hasNext()) {
            object2 = (DownloadEntity)object.next();
            this.startThreadPoolDownLoad((DownloadEntity)object2, (DownLoadHelper$OnDownloadFileEntityCallback)downLoadHelper$8, downLoadHelper$CancelControl, bl2);
        }
    }

    public void startThreadPoolDownLoadAnyFail(List list, DownLoadHelper$OnDownloadFileEntityCallback object, DownLoadHelper$CancelControl downLoadHelper$CancelControl, boolean bl2) {
        DownLoadHelper$9 downLoadHelper$9 = new DownLoadHelper$9(this, list, (DownLoadHelper$OnDownloadFileEntityCallback)object, bl2);
        object = SequentialDownLoadThreadPool.getInstance();
        e e10 = new e(this, list, downLoadHelper$9, downLoadHelper$CancelControl, bl2);
        ((SequentialDownLoadThreadPool)object).execute(e10);
    }
}

