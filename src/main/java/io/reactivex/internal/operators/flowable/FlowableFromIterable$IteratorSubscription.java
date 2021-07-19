/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.t0.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableFromIterable$BaseRangeSubscription;
import java.util.Iterator;

public final class FlowableFromIterable$IteratorSubscription
extends FlowableFromIterable$BaseRangeSubscription {
    private static final long serialVersionUID = -6022804456014692607L;
    public final d downstream;

    public FlowableFromIterable$IteratorSubscription(d d10, Iterator iterator2) {
        super(iterator2);
        this.downstream = d10;
    }

    /*
     * Exception decompiling
     */
    public void fastPath() {
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

    public void slowPath(long l10) {
        long l11;
        long l12;
        Iterator iterator2 = this.it;
        d d10 = this.downstream;
        long l13 = 0L;
        do {
            long l14 = l13;
            while (true) {
                Object object;
                if ((object = l14 == l10 ? 0 : (l14 < l10 ? -1 : 1)) != false) {
                    object = this.cancelled;
                    if (object != false) {
                        return;
                    }
                    try {
                        Object e10 = iterator2.next();
                        boolean bl2 = this.cancelled;
                        if (bl2) {
                            return;
                        }
                        if (e10 == null) {
                            NullPointerException nullPointerException = new NullPointerException("Iterator.next() returned a null value");
                            d10.onError(nullPointerException);
                            return;
                        }
                        d10.onNext(e10);
                    }
                    catch (Throwable throwable) {
                        a.b(throwable);
                        d10.onError(throwable);
                        return;
                    }
                    object = this.cancelled;
                    if (object != false) {
                        return;
                    }
                    try {
                        object = iterator2.hasNext();
                        if (object == false) {
                            boolean bl3 = this.cancelled;
                            if (!bl3) {
                                d10.onComplete();
                            }
                            return;
                        }
                        long l15 = 1L;
                        l14 += l15;
                    }
                    catch (Throwable throwable) {
                        a.b(throwable);
                        d10.onError(throwable);
                        return;
                    }
                }
                l10 = this.get();
                long l16 = l14 - l10;
                object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                if (object == false) break;
            }
            l10 = -l14;
        } while ((l12 = (l11 = (l10 = this.addAndGet(l10)) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false);
    }
}

