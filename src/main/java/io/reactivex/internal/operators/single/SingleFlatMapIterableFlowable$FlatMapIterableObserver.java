/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.l0;
import e.a.v0.o;
import e.a.w0.b.a;
import e.a.w0.i.b;
import i.g.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;

public final class SingleFlatMapIterableFlowable$FlatMapIterableObserver
extends BasicIntQueueSubscription
implements l0 {
    private static final long serialVersionUID = -8938804753851907758L;
    public volatile boolean cancelled;
    public final d downstream;
    public volatile Iterator it;
    public final o mapper;
    public boolean outputFused;
    public final AtomicLong requested;
    public e.a.s0.b upstream;

    public SingleFlatMapIterableFlowable$FlatMapIterableObserver(d object, o o10) {
        this.downstream = object;
        this.mapper = o10;
        this.requested = object = new AtomicLong();
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.dispose();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.upstream = disposableHelper;
    }

    public void clear() {
        this.it = null;
    }

    public void drain() {
        int n10 = this.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        d d10 = this.downstream;
        Iterator iterator2 = this.it;
        int n11 = (int)(this.outputFused ? 1 : 0);
        if (n11 != 0 && iterator2 != null) {
            d10.onNext(null);
            d10.onComplete();
            return;
        }
        n11 = 1;
        while (true) {
            if (iterator2 != null) {
                long l10;
                long l11;
                AtomicLong atomicLong = this.requested;
                long l12 = atomicLong.get();
                long l13 = l12 - (l11 = Long.MAX_VALUE);
                Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                if (object == false) {
                    this.slowPath(d10, iterator2);
                    return;
                }
                long l14 = l11 = 0L;
                while ((l10 = l14 == l12 ? 0 : (l14 < l12 ? -1 : 1)) != false) {
                    String string2;
                    Object object2;
                    l10 = (long)this.cancelled;
                    if (l10 != false) {
                        return;
                    }
                    try {
                        object2 = iterator2.next();
                        string2 = "The iterator returned a null value";
                    }
                    catch (Throwable throwable) {
                        e.a.t0.a.b(throwable);
                        d10.onError(throwable);
                        return;
                    }
                    object2 = a.g(object2, string2);
                    d10.onNext(object2);
                    l10 = (long)this.cancelled;
                    if (l10 != false) {
                        return;
                    }
                    long l15 = 1L;
                    l14 += l15;
                    try {
                        l10 = (long)iterator2.hasNext();
                        if (l10 != false) continue;
                        d10.onComplete();
                        return;
                    }
                    catch (Throwable throwable) {
                        e.a.t0.a.b(throwable);
                        d10.onError(throwable);
                        return;
                    }
                }
                Object object3 = l14 == l11 ? 0 : (l14 < l11 ? -1 : 1);
                if (object3 != false) {
                    atomicLong = this.requested;
                    b.e(atomicLong, l14);
                }
            }
            n11 = -n11;
            if ((n11 = this.addAndGet(n11)) == 0) {
                return;
            }
            if (iterator2 != null) continue;
            iterator2 = this.it;
        }
    }

    public boolean isEmpty() {
        boolean bl2;
        Iterator iterator2 = this.it;
        if (iterator2 == null) {
            bl2 = true;
        } else {
            bl2 = false;
            iterator2 = null;
        }
        return bl2;
    }

    public void onError(Throwable throwable) {
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.upstream = disposableHelper;
        this.downstream.onError(throwable);
    }

    public void onSubscribe(e.a.s0.b object) {
        e.a.s0.b b10 = this.upstream;
        boolean bl2 = DisposableHelper.validate(b10, (e.a.s0.b)object);
        if (bl2) {
            this.upstream = object;
            object = this.downstream;
            object.onSubscribe(this);
        }
    }

    public void onSuccess(Object iterator2) {
        o o10;
        try {
            o10 = this.mapper;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.downstream.onError(throwable);
            return;
        }
        iterator2 = o10.apply(iterator2);
        iterator2 = (Iterable)((Object)iterator2);
        iterator2 = iterator2.iterator();
        boolean bl2 = iterator2.hasNext();
        if (!bl2) {
            this.downstream.onComplete();
            return;
        }
        this.it = iterator2;
        this.drain();
    }

    public Object poll() {
        Iterator iterator2 = this.it;
        if (iterator2 != null) {
            Object object = iterator2.next();
            String string2 = "The iterator returned a null value";
            object = a.g(object, string2);
            boolean bl2 = iterator2.hasNext();
            if (!bl2) {
                this.it = null;
            }
            return object;
        }
        return null;
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            AtomicLong atomicLong = this.requested;
            b.a(atomicLong, l10);
            this.drain();
        }
    }

    public int requestFusion(int n10) {
        int n11 = 2;
        if ((n10 &= n11) != 0) {
            this.outputFused = true;
            return n11;
        }
        return 0;
    }

    /*
     * Exception decompiling
     */
    public void slowPath(d var1_1, Iterator var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [4[DOLOOP]], but top level block is 1[TRYBLOCK]
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

