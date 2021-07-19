/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.p1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.zhiyun.editorsdk.MainUseCase;
import com.zhiyun.editorsdk.frame.FrameSizeUseCase;
import d.v.c.p1.e$a;
import d.v.c.x1.p.c;
import d.v.e.h.a;
import d.v.e.i.h;
import d.v.h.e.b;
import java.io.Serializable;
import java.util.HashMap;

public class e
extends ViewModel {
    private MutableLiveData a;
    private c b;
    private MutableLiveData c;
    private MutableLiveData d;
    private MainUseCase e;
    private FrameSizeUseCase f;
    private b g;

    public e(MainUseCase object) {
        Serializable serializable = new Serializable();
        Object object2 = new MutableLiveData(serializable);
        this.a = object2;
        this.b = object2 = new c();
        serializable = Boolean.FALSE;
        this.c = object2 = new MutableLiveData(serializable);
        this.d = object2 = new MutableLiveData();
        this.e = object;
        this.f = object = (FrameSizeUseCase)((MainUseCase)object).K(FrameSizeUseCase.class);
        this.g = object = new e$a(this);
        this.e.f((b)object);
    }

    public e(Object object) {
        object = (MainUseCase)object;
        this((MainUseCase)object);
    }

    public e(Object ... object) {
        object = object[0];
        this(object);
    }

    public static /* synthetic */ MutableLiveData b(e e10) {
        return e10.d;
    }

    public static /* synthetic */ FrameSizeUseCase c(e e10) {
        return e10.f;
    }

    public int d(int n10, int n11) {
        if (n10 != 0) {
            int n12 = 3;
            int n13 = 1;
            if (n10 != n13) {
                int n14 = 2;
                if (n10 != n14) {
                    if (n10 != n12) {
                        return 0;
                    }
                    if (n11 == n13) {
                        return n14;
                    }
                    return n13;
                }
                if (n11 == n13) {
                    return n12;
                }
                return 0;
            }
            if (n11 == n13) {
                return 0;
            }
            return n12;
        }
        return n11;
    }

    public int e(int n10, int n11) {
        if ((n10 += n11) > (n11 = 180)) {
            n10 += -360;
        }
        if (n10 < (n11 = -180)) {
            n10 += 360;
        }
        return n10;
    }

    /*
     * Exception decompiling
     */
    public int f(int var1_1, int var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[CASE]], but top level block is 10[SWITCH]
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

    public MutableLiveData g() {
        return this.c;
    }

    public MutableLiveData i() {
        return this.a;
    }

    public HashMap j() {
        Object object = this.a;
        object = object != null && (object = ((LiveData)object).getValue()) != null ? (HashMap)this.a.getValue() : null;
        return object;
    }

    public boolean k(int n10) {
        Object object = this.a;
        if (object != null && (object = ((LiveData)object).getValue()) != null) {
            object = (HashMap)this.a.getValue();
            Integer n11 = n10;
            return d.v.e.h.a.c((Boolean)((HashMap)object).get(n11));
        }
        return false;
    }

    public MutableLiveData l() {
        return this.d;
    }

    public int m() {
        int n10;
        Object object = this.d;
        if (object != null && (object = ((LiveData)object).getValue()) != null) {
            object = (Integer)this.d.getValue();
            n10 = (Integer)object;
        } else {
            n10 = 0;
            object = null;
        }
        return n10;
    }

    public d.v.c.q0.e n() {
        return (d.v.c.q0.e)this.b.a();
    }

    public void o(int n10) {
        MutableLiveData mutableLiveData = this.c;
        Boolean bl2 = this.k(n10);
        h.g(mutableLiveData, bl2);
    }

    public void onCleared() {
        super.onCleared();
        MainUseCase mainUseCase = this.e;
        b b10 = this.g;
        mainUseCase.a0(b10);
    }

    public void p(HashMap hashMap) {
        h.g(this.a, hashMap);
    }

    public void r(int n10, boolean bl2) {
        Serializable serializable;
        Object object = this.a;
        if (object == null) {
            serializable = new Serializable();
            this.a = object = new MutableLiveData(serializable);
        }
        if ((object = this.a.getValue()) == null) {
            object = this.a;
            serializable = new Serializable();
            ((MutableLiveData)object).setValue(serializable);
        }
        object = (HashMap)this.a.getValue();
        Object object2 = n10;
        serializable = bl2;
        ((HashMap)object).put(object2, serializable);
        this.p((HashMap)object);
        object2 = this.c;
        Boolean bl3 = bl2;
        h.g((MutableLiveData)object2, bl3);
    }

    public void s(int n10) {
        MutableLiveData mutableLiveData = this.d;
        Integer n11 = n10;
        h.g(mutableLiveData, n11);
    }

    public void t(d.v.c.q0.e e10) {
        this.b.b(e10);
    }
}

