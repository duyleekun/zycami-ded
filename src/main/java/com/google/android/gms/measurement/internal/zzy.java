/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.zzjv;
import com.google.android.gms.measurement.internal.zzkd;
import com.google.android.gms.measurement.internal.zzt;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class zzy
extends zzjv {
    private String zzb;
    private Set zzc;
    private Map zzd;
    private Long zze;
    private Long zzf;

    public zzy(zzkd zzkd2) {
        super(zzkd2);
    }

    private final zzt zzc(Integer n10) {
        Object object = this.zzd;
        boolean bl2 = object.containsKey(n10);
        if (bl2) {
            return (zzt)this.zzd.get(n10);
        }
        String string2 = this.zzb;
        object = new zzt(this, string2, null);
        this.zzd.put(n10, object);
        return object;
    }

    private final boolean zzd(int n10, int n11) {
        Map map = this.zzd;
        Object object = n10;
        if ((object = (zzt)map.get(object)) == null) {
            return false;
        }
        return zzt.zzc((zzt)object).get(n11);
    }

    public final boolean zzaz() {
        return false;
    }

    /*
     * Exception decompiling
     */
    public final List zzb(String var1_1, List var2_2, List var3_3, Long var4_4, Long var5_5) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 30[TRYBLOCK] [63 : 814->819)] java.lang.Throwable
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

