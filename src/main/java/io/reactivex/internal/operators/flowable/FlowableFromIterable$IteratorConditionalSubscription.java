/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.w0.c.a;
import io.reactivex.internal.operators.flowable.FlowableFromIterable$BaseRangeSubscription;
import java.util.Iterator;

public final class FlowableFromIterable$IteratorConditionalSubscription
extends FlowableFromIterable$BaseRangeSubscription {
    private static final long serialVersionUID = -6022804456014692607L;
    public final a downstream;

    public FlowableFromIterable$IteratorConditionalSubscription(a a10, Iterator iterator2) {
        super(iterator2);
        this.downstream = a10;
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

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void slowPath(long var1_1) {
        var3_2 = this.it;
        var4_3 = this.downstream;
        var5_4 = 0L;
        do {
            var7_6 = var5_4;
            while (true) lbl-1000:
            // 4 sources

            {
                if ((var9_7 /* !! */  = var7_6 == var1_1 ? 0 : (var7_6 < var1_1 ? -1 : 1)) != false) {
                    block12: {
                        var9_7 /* !! */  = (long)this.cancelled;
                        if (var9_7 /* !! */  != false) {
                            return;
                        }
                        try {
                            var10_8 = var3_2.next();
                            var11_9 = this.cancelled;
                            if (var11_9) {
                                return;
                            }
                            if (var10_8 != null) break block12;
                            var12_11 = new NullPointerException("Iterator.next() returned a null value");
                            var4_3.onError(var12_11);
                            return;
                        }
                        catch (Throwable var12_13) {
                            e.a.t0.a.b(var12_13);
                            var4_3.onError(var12_13);
                            return;
                        }
                    }
                    var9_7 /* !! */  = (long)var4_3.tryOnNext(var10_8);
                    var11_9 = this.cancelled;
                    if (var11_9) {
                        return;
                    }
                    try {
                        var11_9 = var3_2.hasNext();
                        if (!var11_9) {
                            var13_14 = this.cancelled;
                            if (!var13_14) {
                                var4_3.onComplete();
                            }
                            return;
                        }
                        if (var9_7 /* !! */  == false) ** GOTO lbl-1000
                        var14_10 = 1L;
                        var7_6 += var14_10;
                    }
                    catch (Throwable var12_12) {
                        e.a.t0.a.b(var12_12);
                        var4_3.onError(var12_12);
                        return;
                    }
                }
                var1_1 = this.get();
                cfr_temp_0 = var7_6 - var1_1;
                var9_7 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                if (var9_7 /* !! */  == false) break;
            }
            var1_1 = -var7_6;
        } while ((var16_5 = (cfr_temp_1 = (var1_1 = this.addAndGet(var1_1)) - var5_4) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) != false);
    }
}

