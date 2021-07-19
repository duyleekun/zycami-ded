/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Pair
 */
package com.huawei.hms.hatool;

import android.content.Context;
import android.util.Pair;
import com.huawei.hms.hatool.b;
import com.huawei.hms.hatool.m0;
import com.huawei.hms.hatool.s0;
import com.huawei.hms.hatool.t;
import java.util.List;

public class k0
implements m0 {
    public Context a;
    public String b;
    public String c;
    public String d;

    public k0(String string2, String string3, String string4) {
        Context context;
        this.a = context = com.huawei.hms.hatool.b.f();
        this.b = string2;
        this.c = string3;
        this.d = string4;
    }

    public final void a(String string2, List list) {
        string2 = s0.a(string2);
        String string3 = (String)((Pair)string2).first;
        string2 = (String)((Pair)string2).second;
        String string4 = this.d;
        t t10 = new t(list, string3, string2, string4);
        t10.a();
    }

    /*
     * Exception decompiling
     */
    public void run() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 20[TRYBLOCK] [63 : 504->507)] java.lang.Throwable
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

