/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetFileDescriptor
 *  android.graphics.SurfaceTexture
 *  android.graphics.SurfaceTexture$OnFrameAvailableListener
 *  android.media.MediaCodec
 *  android.media.MediaExtractor
 *  android.os.Handler
 *  android.os.Looper
 */
package com.tencent.liteav.beauty.b;

import android.content.res.AssetFileDescriptor;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.beauty.b.w$1;

public class w {
    private static final String b = "w";
    public SurfaceTexture.OnFrameAvailableListener a;
    private SurfaceTexture c;
    private int d;
    private boolean e;
    private MediaExtractor f;
    private AssetFileDescriptor g;
    private int h;
    private int i;
    private int j;
    private int k;
    private long l;
    private MediaCodec m;
    private boolean n;
    private boolean o;
    private Handler p;
    private Object q;

    public w() {
        Object object;
        int n10;
        this.d = n10 = -1;
        this.e = false;
        this.h = n10;
        this.i = n10;
        this.j = n10;
        this.k = n10;
        this.n = false;
        this.q = object = new Object();
    }

    public static /* synthetic */ Object a(w w10) {
        return w10.q;
    }

    /*
     * Exception decompiling
     */
    private void b() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 4[TRYBLOCK] [8 : 68->71)] java.lang.Throwable
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

    public static /* synthetic */ void b(w w10) {
        w10.c();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void c() {
        long l10;
        this.b();
        Object var1_1 = null;
        this.a = null;
        this.l = l10 = 0L;
        this.o = false;
        Object object = this.c;
        if (object != null) {
            object.release();
            this.c = null;
        }
        object = this.q;
        synchronized (object) {
            Object object2 = this.p;
            if (object2 != null) {
                object2.removeCallbacksAndMessages(null);
                object2 = this.p;
                object2 = object2.getLooper();
                object2.quit();
                this.p = null;
                object2 = this.q;
                object2.notify();
            }
        }
        object = this.g;
        if (object != null) {
            try {
                object.close();
            }
            catch (Exception exception) {}
            this.g = null;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        synchronized (this) {
            var1_1 = this.q;
            synchronized (var1_1) {
                block9: {
                    var2_2 = this.p;
                    if (var2_2 == null) ** GOTO lbl25
                    var2_2 = Looper.myLooper();
                    var3_3 = this.p;
                    if (var2_2 != (var3_3 = var3_3.getLooper())) break block9;
                    this.c();
                    ** GOTO lbl25
                }
                var2_2 = new w$1(this);
                var3_3 = this.p;
                var3_3.removeCallbacksAndMessages(null);
                var3_3 = this.p;
                var3_3.post((Runnable)var2_2);
                var2_2 = this.p;
                var2_2 = var2_2.getLooper();
                var2_2.quitSafely();
                while (true) {
                    try {
                        var2_2 = this.q;
                        var2_2.wait();
lbl25:
                        // 3 sources

                        return;
                    }
                    catch (InterruptedException v0) {
                        continue;
                    }
                    break;
                }
            }
        }
    }
}

