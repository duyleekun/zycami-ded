/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 */
package com.google.android.exoplayer2.video;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.EGLSurfaceTexture;
import com.google.android.exoplayer2.video.DummySurface;

public class DummySurface$DummySurfaceThread
extends HandlerThread
implements Handler.Callback {
    private static final int MSG_INIT = 1;
    private static final int MSG_RELEASE = 2;
    private EGLSurfaceTexture eglSurfaceTexture;
    private Handler handler;
    private Error initError;
    private RuntimeException initException;
    private DummySurface surface;

    public DummySurface$DummySurfaceThread() {
        super("ExoPlayer:DummySurface");
    }

    private void initInternal(int n10) {
        DummySurface dummySurface;
        Assertions.checkNotNull(this.eglSurfaceTexture);
        this.eglSurfaceTexture.init(n10);
        SurfaceTexture surfaceTexture = this.eglSurfaceTexture.getSurfaceTexture();
        n10 = n10 != 0 ? 1 : 0;
        this.surface = dummySurface = new DummySurface(this, surfaceTexture, n10 != 0, null);
    }

    private void releaseInternal() {
        Assertions.checkNotNull(this.eglSurfaceTexture);
        this.eglSurfaceTexture.release();
    }

    /*
     * Exception decompiling
     */
    public boolean handleMessage(Message var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 5[TRYBLOCK] [10 : 89->91)] java.lang.Throwable
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
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public DummySurface init(int n10) {
        Object object;
        this.start();
        Looper looper = this.getLooper();
        this.handler = object = new Handler(looper, (Handler.Callback)this);
        looper = this.handler;
        object = new EGLSurfaceTexture((Handler)looper);
        this.eglSurfaceTexture = object;
        // MONITORENTER : this
        object = this.handler;
        int n11 = 1;
        int n12 = 0;
        Object object2 = object.obtainMessage(n11, n10, 0);
        object2.sendToTarget();
        while ((object2 = this.surface) == null && (object2 = this.initException) == null && (object2 = this.initError) == null) {
            try {
                ((Object)((Object)this)).wait();
            }
            catch (InterruptedException interruptedException) {
                n12 = n11;
            }
        }
        // MONITOREXIT : this
        if (n12 != 0) {
            object2 = Thread.currentThread();
            object2.interrupt();
        }
        if ((object2 = this.initException) != null) throw object2;
        object2 = this.initError;
        if (object2 != null) throw object2;
        return (DummySurface)((Object)Assertions.checkNotNull((Object)this.surface));
    }

    public void release() {
        Assertions.checkNotNull(this.handler);
        this.handler.sendEmptyMessage(2);
    }
}

