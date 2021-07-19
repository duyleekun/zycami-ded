/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.a1.a;
import e.a.g0;
import e.a.i;
import e.a.s0.b;
import e.a.v0.c;
import e.a.v0.g;

public final class p0$a
implements i,
b {
    public final g0 a;
    public final c b;
    public final g c;
    public Object d;
    public volatile boolean e;
    public boolean f;
    public boolean g;

    public p0$a(g0 g02, c c10, g g10, Object object) {
        this.a = g02;
        this.b = c10;
        this.c = g10;
        this.d = object;
    }

    private void a(Object object) {
        g g10 = this.c;
        try {
            g10.accept(object);
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            e.a.a1.a.Y(throwable);
        }
    }

    /*
     * Exception decompiling
     */
    public void b() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[DOLOOP]], but top level block is 0[TRYBLOCK]
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

    public void dispose() {
        this.e = true;
    }

    public boolean isDisposed() {
        return this.e;
    }

    public void onComplete() {
        boolean bl2 = this.f;
        if (!bl2) {
            this.f = bl2 = true;
            g0 g02 = this.a;
            g02.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.f;
        if (bl2) {
            e.a.a1.a.Y(throwable);
        } else {
            Object object;
            if (throwable == null) {
                object = "onError called with null. Null values are generally not allowed in 2.x operators and sources.";
                throwable = new NullPointerException((String)object);
            }
            this.f = bl2 = true;
            object = this.a;
            object.onError(throwable);
        }
    }

    public void onNext(Object object) {
        boolean bl2 = this.f;
        if (!bl2) {
            bl2 = this.g;
            if (bl2) {
                String string2 = "onNext already called in this generate turn";
                object = new IllegalStateException(string2);
                this.onError((Throwable)object);
            } else if (object == null) {
                String string3 = "onNext called with null. Null values are generally not allowed in 2.x operators and sources.";
                object = new NullPointerException(string3);
                this.onError((Throwable)object);
            } else {
                this.g = bl2 = true;
                g0 g02 = this.a;
                g02.onNext(object);
            }
        }
    }
}

