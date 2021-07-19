/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ChainingListenableFuture
extends FutureChain
implements Runnable {
    private AsyncFunction mFunction;
    private ListenableFuture mInputFuture;
    private final BlockingQueue mMayInterruptIfRunningChannel;
    private final CountDownLatch mOutputCreated;
    public volatile ListenableFuture mOutputFuture;

    public ChainingListenableFuture(AsyncFunction object, ListenableFuture listenableFuture) {
        int n10 = 1;
        Object object2 = new LinkedBlockingQueue(n10);
        this.mMayInterruptIfRunningChannel = object2;
        this.mOutputCreated = object2 = new CountDownLatch(n10);
        object = (AsyncFunction)Preconditions.checkNotNull(object);
        this.mFunction = object;
        this.mInputFuture = object = (ListenableFuture)Preconditions.checkNotNull(listenableFuture);
    }

    private void cancel(Future future, boolean bl2) {
        if (future != null) {
            future.cancel(bl2);
        }
    }

    private void putUninterruptibly(BlockingQueue object, Object object2) {
        boolean bl2 = false;
        while (true) {
            block5: {
                try {
                    object.put(object2);
                    if (!bl2) break block5;
                }
                catch (Throwable throwable) {
                    if (bl2) {
                        object2 = Thread.currentThread();
                        ((Thread)object2).interrupt();
                    }
                    throw throwable;
                }
                catch (InterruptedException interruptedException) {
                    bl2 = true;
                    continue;
                }
                object = Thread.currentThread();
                ((Thread)object).interrupt();
            }
            return;
            break;
        }
    }

    private Object takeUninterruptibly(BlockingQueue blockingQueue) {
        boolean bl2 = false;
        Thread thread = null;
        while (true) {
            block5: {
                try {
                    blockingQueue = blockingQueue.take();
                    if (!bl2) break block5;
                }
                catch (Throwable throwable) {
                    if (bl2) {
                        thread = Thread.currentThread();
                        thread.interrupt();
                    }
                    throw throwable;
                }
                catch (InterruptedException interruptedException) {
                    bl2 = true;
                    continue;
                }
                thread = Thread.currentThread();
                thread.interrupt();
            }
            return blockingQueue;
            break;
        }
    }

    public boolean cancel(boolean bl2) {
        boolean bl3 = super.cancel(bl2);
        if (bl3) {
            Object object = this.mMayInterruptIfRunningChannel;
            Boolean bl4 = bl2;
            this.putUninterruptibly((BlockingQueue)object, bl4);
            object = this.mInputFuture;
            this.cancel((Future)object, bl2);
            object = this.mOutputFuture;
            this.cancel((Future)object, bl2);
            return true;
        }
        return false;
    }

    public Object get() {
        boolean bl2 = this.isDone();
        if (!bl2) {
            ListenableFuture listenableFuture = this.mInputFuture;
            if (listenableFuture != null) {
                listenableFuture.get();
            }
            this.mOutputCreated.await();
            listenableFuture = this.mOutputFuture;
            if (listenableFuture != null) {
                listenableFuture.get();
            }
        }
        return super.get();
    }

    public Object get(long l10, TimeUnit timeUnit) {
        boolean bl2 = this.isDone();
        if (!bl2) {
            long l11;
            long l12;
            Object object = TimeUnit.NANOSECONDS;
            if (timeUnit != object) {
                l10 = object.convert(l10, timeUnit);
                timeUnit = object;
            }
            object = this.mInputFuture;
            long l13 = 0L;
            if (object != null) {
                l12 = System.nanoTime();
                object.get(l10, timeUnit);
                l11 = System.nanoTime() - l12;
                l12 = Math.max(l13, l11);
                l10 -= l12;
            }
            l12 = System.nanoTime();
            object = this.mOutputCreated;
            bl2 = ((CountDownLatch)object).await(l10, timeUnit);
            if (bl2) {
                l11 = System.nanoTime() - l12;
                long l14 = Math.max(l13, l11);
                l10 -= l14;
                object = this.mOutputFuture;
                if (object != null) {
                    object.get(l10, timeUnit);
                }
            } else {
                TimeoutException timeoutException = new TimeoutException();
                throw timeoutException;
            }
        }
        return super.get(l10, timeUnit);
    }

    /*
     * Exception decompiling
     */
    public void run() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 14[TRYBLOCK] [71, 70, 69, 68 : 139->143)] java.lang.Throwable
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
}

