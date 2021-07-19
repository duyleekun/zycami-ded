/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.AsyncTask
 */
package d.r.a.u;

import android.content.Context;
import android.os.AsyncTask;
import d.r.a.i.l$b;
import d.r.a.r.a;
import d.r.a.u.a0;
import d.r.a.u.d;
import d.r.a.u.f;
import d.r.a.u.s;
import java.util.List;

public final class o
extends AsyncTask {
    private Context a;
    private a b;
    private long c;
    private boolean d;
    private int e = 0;
    private l$b f;

    public o(Context context, a a10, long l10, boolean bl2, l$b l$b) {
        this.a = context;
        this.b = a10;
        this.c = l10;
        this.d = bl2;
        this.f = l$b;
    }

    /*
     * Exception decompiling
     */
    private List a(String ... var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
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

    public final /* synthetic */ Object doInBackground(Object[] objectArray) {
        objectArray = (String[])objectArray;
        return this.a((String[])objectArray);
    }

    public final /* synthetic */ void onPostExecute(Object object) {
        Object object2 = object;
        object2 = (List)object;
        super.onPostExecute(object2);
        String string2 = "onPostExecute";
        s.k("ImageDownTask", string2);
        object = this.b;
        if (object != null) {
            object = a0.m();
            long l10 = this.c;
            ((f)object).f("com.vivo.push.notify_key", l10);
            string2 = this.a;
            a a10 = this.b;
            long l11 = this.c;
            int n10 = this.e;
            l$b l$b = this.f;
            d.r.a.u.d.e((Context)string2, (List)object2, a10, l11, n10, l$b);
        }
    }
}

