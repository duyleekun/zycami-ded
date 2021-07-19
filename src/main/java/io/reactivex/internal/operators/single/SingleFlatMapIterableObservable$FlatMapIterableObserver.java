/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.g0;
import e.a.l0;
import e.a.s0.b;
import e.a.v0.o;
import e.a.w0.b.a;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import java.util.Iterator;

public final class SingleFlatMapIterableObservable$FlatMapIterableObserver
extends BasicIntQueueDisposable
implements l0 {
    private static final long serialVersionUID = -8938804753851907758L;
    public volatile boolean cancelled;
    public final g0 downstream;
    public volatile Iterator it;
    public final o mapper;
    public boolean outputFused;
    public b upstream;

    public SingleFlatMapIterableObservable$FlatMapIterableObserver(g0 g02, o o10) {
        this.downstream = g02;
        this.mapper = o10;
    }

    public void clear() {
        this.it = null;
    }

    public void dispose() {
        this.cancelled = true;
        this.upstream.dispose();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.upstream = disposableHelper;
    }

    public boolean isDisposed() {
        return this.cancelled;
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

    public void onSubscribe(b object) {
        b b10 = this.upstream;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.upstream = object;
            object = this.downstream;
            object.onSubscribe(this);
        }
    }

    /*
     * Exception decompiling
     */
    public void onSuccess(Object var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [10[DOLOOP]], but top level block is 6[TRYBLOCK]
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

    public int requestFusion(int n10) {
        int n11 = 2;
        if ((n10 &= n11) != 0) {
            this.outputFused = true;
            return n11;
        }
        return 0;
    }
}

