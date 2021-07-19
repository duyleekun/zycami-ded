/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils.futures;

import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.ListFuture$1;
import androidx.camera.core.impl.utils.futures.ListFuture$3;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;
import androidx.concurrent.futures.CallbackToFutureAdapter$Resolver;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ListFuture
implements ListenableFuture {
    private final boolean mAllMustSucceed;
    public List mFutures;
    private final AtomicInteger mRemaining;
    private final ListenableFuture mResult;
    public CallbackToFutureAdapter$Completer mResultNotifier;
    public List mValues;

    public ListFuture(List object, boolean bl2, Executor executor) {
        AtomicInteger atomicInteger;
        List list;
        this.mFutures = list = (List)Preconditions.checkNotNull(object);
        int n10 = object.size();
        super(n10);
        this.mValues = list;
        this.mAllMustSucceed = bl2;
        int n11 = object.size();
        this.mRemaining = atomicInteger = new AtomicInteger(n11);
        object = new ListFuture$1(this);
        this.mResult = object = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter$Resolver)object);
        this.init(executor);
    }

    private void callAllGets() {
        boolean bl2;
        Object object = this.mFutures;
        if (object != null && !(bl2 = this.isDone())) {
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                boolean bl3;
                ListenableFuture listenableFuture = (ListenableFuture)object.next();
                while (!(bl3 = listenableFuture.isDone())) {
                    try {
                        listenableFuture.get();
                    }
                    catch (Throwable throwable) {
                        bl3 = this.mAllMustSucceed;
                        if (!bl3) continue;
                        return;
                    }
                    catch (InterruptedException interruptedException) {
                        throw interruptedException;
                    }
                    catch (Error error) {
                        throw error;
                    }
                }
            }
        }
    }

    private void init(Executor object) {
        ListFuture$3 listFuture$3;
        Object object2;
        int n10;
        ArrayList arrayList = new ArrayList(this);
        Object object3 = CameraXExecutors.directExecutor();
        this.addListener((Runnable)((Object)arrayList), (Executor)object3);
        arrayList = this.mFutures;
        int n11 = arrayList.isEmpty();
        if (n11 != 0) {
            object = this.mResultNotifier;
            object3 = this.mValues;
            arrayList = new ArrayList(object3);
            ((CallbackToFutureAdapter$Completer)object).set(arrayList);
            return;
        }
        n11 = 0;
        arrayList = null;
        object3 = null;
        for (int i10 = 0; i10 < (n10 = (object2 = this.mFutures).size()); ++i10) {
            object2 = this.mValues;
            listFuture$3 = null;
            object2.add(null);
        }
        object3 = this.mFutures;
        while (n11 < (n10 = object3.size())) {
            object2 = (ListenableFuture)object3.get(n11);
            listFuture$3 = new ListFuture$3(this, n11, (ListenableFuture)object2);
            object2.addListener(listFuture$3, (Executor)object);
            ++n11;
        }
    }

    public void addListener(Runnable runnable, Executor executor) {
        this.mResult.addListener(runnable, executor);
    }

    public boolean cancel(boolean bl2) {
        Object object = this.mFutures;
        if (object != null) {
            boolean bl3;
            object = object.iterator();
            while (bl3 = object.hasNext()) {
                ListenableFuture listenableFuture = (ListenableFuture)object.next();
                listenableFuture.cancel(bl2);
            }
        }
        return this.mResult.cancel(bl2);
    }

    public List get() {
        this.callAllGets();
        return (List)this.mResult.get();
    }

    public List get(long l10, TimeUnit timeUnit) {
        return (List)this.mResult.get(l10, timeUnit);
    }

    public boolean isCancelled() {
        return this.mResult.isCancelled();
    }

    public boolean isDone() {
        return this.mResult.isDone();
    }

    /*
     * Exception decompiling
     */
    public void setOneValue(int var1_1, Future var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 3[TRYBLOCK] [20 : 151->155)] java.lang.Throwable
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

