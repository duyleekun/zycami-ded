/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.c;

import e.a.g0;
import e.a.t;
import e.a.v0.o;
import e.a.w0.b.a;
import e.a.w0.d.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.Iterator;

public final class o$a
extends b
implements t {
    public final g0 a;
    public final o b;
    public e.a.s0.b c;
    public volatile Iterator d;
    public volatile boolean e;
    public boolean f;

    public o$a(g0 g02, o o10) {
        this.a = g02;
        this.b = o10;
    }

    public void clear() {
        this.d = null;
    }

    public void dispose() {
        this.e = true;
        this.c.dispose();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.c = disposableHelper;
    }

    public boolean isDisposed() {
        return this.e;
    }

    public boolean isEmpty() {
        boolean bl2;
        Iterator iterator2 = this.d;
        if (iterator2 == null) {
            bl2 = true;
        } else {
            bl2 = false;
            iterator2 = null;
        }
        return bl2;
    }

    public void onComplete() {
        this.a.onComplete();
    }

    public void onError(Throwable throwable) {
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        this.c = disposableHelper;
        this.a.onError(throwable);
    }

    public void onSubscribe(e.a.s0.b object) {
        e.a.s0.b b10 = this.c;
        boolean bl2 = DisposableHelper.validate(b10, (e.a.s0.b)object);
        if (bl2) {
            this.c = object;
            object = this.a;
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
        Iterator iterator2 = this.d;
        if (iterator2 != null) {
            Object object = iterator2.next();
            String string2 = "The iterator returned a null value";
            object = e.a.w0.b.a.g(object, string2);
            boolean bl2 = iterator2.hasNext();
            if (!bl2) {
                this.d = null;
            }
            return object;
        }
        return null;
    }

    public int requestFusion(int n10) {
        int n11 = 2;
        if ((n10 &= n11) != 0) {
            this.f = true;
            return n11;
        }
        return 0;
    }
}

