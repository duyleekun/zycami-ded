/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.net.download;

import com.zhiyun.net.download.DownLoadHelper;
import com.zhiyun.net.download.DownLoadHelper$CancelControl;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadFileCallback;
import k.d;
import k.f;
import k.r;

public class DownLoadHelper$6
implements f {
    public final /* synthetic */ DownLoadHelper this$0;
    public final /* synthetic */ boolean val$bCallbackSwitchToMainThread;
    public final /* synthetic */ DownLoadHelper$OnDownloadFileCallback val$callback;
    public final /* synthetic */ DownLoadHelper$CancelControl val$cancelControl;
    public final /* synthetic */ String val$destFileDir;
    public final /* synthetic */ String val$fileName;

    public DownLoadHelper$6(DownLoadHelper downLoadHelper, DownLoadHelper$OnDownloadFileCallback downLoadHelper$OnDownloadFileCallback, boolean bl2, String string2, String string3, DownLoadHelper$CancelControl downLoadHelper$CancelControl) {
        this.this$0 = downLoadHelper;
        this.val$callback = downLoadHelper$OnDownloadFileCallback;
        this.val$bCallbackSwitchToMainThread = bl2;
        this.val$fileName = string2;
        this.val$destFileDir = string3;
        this.val$cancelControl = downLoadHelper$CancelControl;
    }

    public void onFailure(d object, Throwable throwable) {
        object = this.this$0;
        DownLoadHelper$OnDownloadFileCallback downLoadHelper$OnDownloadFileCallback = this.val$callback;
        boolean bl2 = this.val$bCallbackSwitchToMainThread;
        DownLoadHelper.access$200((DownLoadHelper)object, throwable, downLoadHelper$OnDownloadFileCallback, bl2);
    }

    /*
     * Exception decompiling
     */
    public void onResponse(d var1_1, r var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [59[UNCONDITIONALDOLOOP]], but top level block is 42[TRYBLOCK]
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
}

