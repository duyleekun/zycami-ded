/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.a.f.b;

import android.content.Context;
import com.zhiyun.net.BaseEntity;
import com.zhiyun.net.NetCallback;
import com.zhiyun.net.Punish;
import k.d;
import k.f;
import k.r;

public abstract class a
implements f,
NetCallback {
    private static final int ERROR_NET = 255;
    private static final int ERROR_SERVER = 254;

    /*
     * Exception decompiling
     */
    public static String fromErrCodeToMessage(Context var0, int var1_1, String var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Extractable last case doesn't follow previous, and can't clone.
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.examineSwitchContiguity(SwitchReplacer.java:611)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.SwitchReplacer.replaceRawSwitches(SwitchReplacer.java:94)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:512)
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

    public void onFailure(d d10, Throwable throwable) {
        this.onError(throwable, -1, "");
    }

    public void onResponse(d object, r object2) {
        String string2;
        int n10;
        BaseEntity baseEntity = (BaseEntity)((r)object2).a();
        if (baseEntity != null) {
            n10 = baseEntity.errcode;
            string2 = baseEntity.errmsg;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            string2 = ((r)object2).toString();
            stringBuilder.append(string2);
            stringBuilder.append(",isSuccessful = ");
            boolean bl2 = ((r)object2).g();
            stringBuilder.append(bl2);
            string2 = stringBuilder.toString();
            n10 = -2;
        }
        if (n10 == 0) {
            object = ((r)object2).a();
            this.onSuccess(object);
        } else {
            object2 = d.v.a.f.c.d.d.F();
            boolean n11 = ((d.v.a.f.c.d.d)object2).A(n10);
            String string3 = "";
            if (n11) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(n10);
                ((StringBuilder)object2).append(string2);
                object2 = ((StringBuilder)object2).toString();
                object = new Throwable((String)object2);
                this.onError((Throwable)object, n10, string3);
            } else {
                int n12;
                int n13 = 10184;
                if (n13 != n10 && (n12 = 10185) != n10) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append(n10);
                    ((StringBuilder)object2).append(string2);
                    object2 = ((StringBuilder)object2).toString();
                    object = new Throwable((String)object2);
                    this.onError((Throwable)object, n10, string2);
                } else {
                    object2 = baseEntity.punish;
                    if (object2 != null) {
                        object = object.C().q().x();
                        ((Punish)object2).setPath((String)object);
                    }
                    if ((object = d.v.a.f.c.d.d.F().I()) != null) {
                        object.a(baseEntity);
                    }
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append(n10);
                    ((StringBuilder)object2).append(string2);
                    object2 = ((StringBuilder)object2).toString();
                    object = new Throwable((String)object2);
                    this.onError((Throwable)object, n10, string3);
                }
            }
        }
    }
}

