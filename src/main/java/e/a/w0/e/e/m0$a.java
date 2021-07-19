/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.w0.b.a;
import e.a.w0.d.b;
import java.util.Iterator;

public final class m0$a
extends b {
    public final g0 a;
    public final Iterator b;
    public volatile boolean c;
    public boolean d;
    public boolean e;
    public boolean f;

    public m0$a(g0 g02, Iterator iterator2) {
        this.a = g02;
        this.b = iterator2;
    }

    /*
     * Exception decompiling
     */
    public void a() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [7[DOLOOP]], but top level block is 4[TRYBLOCK]
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

    public void clear() {
        this.e = true;
    }

    public void dispose() {
        this.c = true;
    }

    public boolean isDisposed() {
        return this.c;
    }

    public boolean isEmpty() {
        return this.e;
    }

    public Object poll() {
        boolean bl2 = this.e;
        if (bl2) {
            return null;
        }
        bl2 = this.f;
        boolean bl3 = true;
        if (bl2) {
            Iterator iterator2 = this.b;
            bl2 = iterator2.hasNext();
            if (!bl2) {
                this.e = bl3;
                return null;
            }
        } else {
            this.f = bl3;
        }
        return e.a.w0.b.a.g(this.b.next(), "The iterator returned a null value");
    }

    public int requestFusion(int n10) {
        int n11 = 1;
        if ((n10 &= n11) != 0) {
            this.d = n11;
            return n11;
        }
        return 0;
    }
}

