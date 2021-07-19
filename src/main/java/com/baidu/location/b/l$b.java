/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.b;

import com.baidu.location.Jni;
import com.baidu.location.b.aa;
import com.baidu.location.b.ac;
import com.baidu.location.b.l;
import com.baidu.location.b.m;
import com.baidu.location.h.f;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ExecutorService;

public class l$b
extends f {
    public String a = null;
    public String b = null;
    public long c;
    public long d;
    public final /* synthetic */ l e;

    public l$b(l hashMap) {
        long l10;
        this.e = hashMap;
        this.c = l10 = 0L;
        this.d = l10;
        this.k = hashMap = new HashMap();
    }

    public void a(String object, long l10) {
        long l11;
        this.b = object;
        this.d = l11 = System.currentTimeMillis();
        this.c = l10;
        object = aa.a().b();
        boolean bl2 = com.baidu.location.h.l.b();
        if (bl2) {
            bl2 = false;
            Object var7_5 = null;
            this.a((ExecutorService)object, false, null);
        } else if (object != null) {
            String string2 = com.baidu.location.h.l.f;
            this.a((ExecutorService)object, string2);
        } else {
            object = com.baidu.location.h.l.f;
            this.e((String)object);
        }
    }

    /*
     * Exception decompiling
     */
    public void a(boolean var1_1) {
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

    public void b() {
        Object[] objectArray;
        Object object;
        Object object2 = com.baidu.location.h.l.e();
        this.h = object2;
        boolean bl2 = com.baidu.location.h.l.h;
        int n10 = 1;
        if ((bl2 || (bl2 = com.baidu.location.h.l.j)) && (object2 = com.baidu.location.b.l.a(this.e)) != null && (object2 = com.baidu.location.b.l.b(this.e)) != null) {
            object2 = new StringBuilder();
            object = this.b;
            ((StringBuilder)object2).append((String)object);
            object = Locale.CHINA;
            int n11 = 2;
            objectArray = new Object[n11];
            String string2 = com.baidu.location.b.l.a(this.e);
            objectArray[0] = string2;
            string2 = com.baidu.location.b.l.b(this.e);
            objectArray[n10] = string2;
            string2 = "&ki=%s&sn=%s";
            object = String.format((Locale)object, string2, objectArray);
            ((StringBuilder)object2).append((String)object);
            this.b = object2 = ((StringBuilder)object2).toString();
        }
        if (bl2 = ((m)(object2 = com.baidu.location.b.m.a())).b()) {
            object2 = new StringBuilder();
            object = this.b;
            ((StringBuilder)object2).append((String)object);
            object = "&enc=2";
            ((StringBuilder)object2).append((String)object);
            this.b = object2 = ((StringBuilder)object2).toString();
        }
        object2 = Jni.encodeTp4(this.b);
        this.b = null;
        object = this.a;
        if (object == null) {
            this.a = object = ac.b();
        }
        object = this.k;
        objectArray = "bloc";
        object.put(objectArray, object2);
        object2 = this.a;
        if (object2 != null) {
            object = this.k;
            objectArray = "up";
            object.put(objectArray, object2);
        }
        object2 = Locale.CHINA;
        Object[] objectArray2 = new Object[n10];
        objectArray2[0] = object = Long.valueOf(System.currentTimeMillis());
        object2 = String.format((Locale)object2, "%d", objectArray2);
        this.k.put("trtm", object2);
    }
}

