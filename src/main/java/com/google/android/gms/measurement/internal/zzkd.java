/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.database.Cursor
 *  android.database.sqlite.SQLiteDatabase
 *  android.database.sqlite.SQLiteException
 *  android.net.Uri$Builder
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzda;
import com.google.android.gms.internal.measurement.zzdb;
import com.google.android.gms.internal.measurement.zzde;
import com.google.android.gms.internal.measurement.zzdf;
import com.google.android.gms.internal.measurement.zzdi;
import com.google.android.gms.internal.measurement.zzdt;
import com.google.android.gms.internal.measurement.zzdu;
import com.google.android.gms.internal.measurement.zzho;
import com.google.android.gms.internal.measurement.zzlc;
import com.google.android.gms.internal.measurement.zzlu;
import com.google.android.gms.internal.measurement.zzmg;
import com.google.android.gms.measurement.internal.zzaa;
import com.google.android.gms.measurement.internal.zzad;
import com.google.android.gms.measurement.internal.zzae;
import com.google.android.gms.measurement.internal.zzaf;
import com.google.android.gms.measurement.internal.zzai;
import com.google.android.gms.measurement.internal.zzam;
import com.google.android.gms.measurement.internal.zzao;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzas;
import com.google.android.gms.measurement.internal.zzdv;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzea;
import com.google.android.gms.measurement.internal.zzed;
import com.google.android.gms.measurement.internal.zzeg;
import com.google.android.gms.measurement.internal.zzei;
import com.google.android.gms.measurement.internal.zzej;
import com.google.android.gms.measurement.internal.zzen;
import com.google.android.gms.measurement.internal.zzeo;
import com.google.android.gms.measurement.internal.zzeq;
import com.google.android.gms.measurement.internal.zzeu;
import com.google.android.gms.measurement.internal.zzex;
import com.google.android.gms.measurement.internal.zzfa;
import com.google.android.gms.measurement.internal.zzfc;
import com.google.android.gms.measurement.internal.zzfi;
import com.google.android.gms.measurement.internal.zzfl;
import com.google.android.gms.measurement.internal.zzg;
import com.google.android.gms.measurement.internal.zzge;
import com.google.android.gms.measurement.internal.zzgf;
import com.google.android.gms.measurement.internal.zzgg;
import com.google.android.gms.measurement.internal.zzhs;
import com.google.android.gms.measurement.internal.zzjc;
import com.google.android.gms.measurement.internal.zzjt;
import com.google.android.gms.measurement.internal.zzjv;
import com.google.android.gms.measurement.internal.zzjw;
import com.google.android.gms.measurement.internal.zzjy;
import com.google.android.gms.measurement.internal.zzjz;
import com.google.android.gms.measurement.internal.zzkb;
import com.google.android.gms.measurement.internal.zzke;
import com.google.android.gms.measurement.internal.zzkf;
import com.google.android.gms.measurement.internal.zzkg;
import com.google.android.gms.measurement.internal.zzki;
import com.google.android.gms.measurement.internal.zzkj;
import com.google.android.gms.measurement.internal.zzkk;
import com.google.android.gms.measurement.internal.zzp;
import com.google.android.gms.measurement.internal.zzy;
import com.google.android.gms.measurement.internal.zzz;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class zzkd
implements zzgg {
    private static volatile zzkd zzb;
    private final zzkj zzA;
    public long zza;
    private final zzfc zzc;
    private final zzeo zzd;
    private zzai zze;
    private zzeq zzf;
    private zzjt zzg;
    private zzy zzh;
    private final zzkf zzi;
    private zzhs zzj;
    private zzjc zzk;
    private final zzfl zzl;
    private boolean zzm = false;
    private boolean zzn;
    private List zzo;
    private int zzp;
    private int zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private FileLock zzu;
    private FileChannel zzv;
    private List zzw;
    private List zzx;
    private long zzy;
    private final Map zzz;

    public zzkd(zzke zzke2, zzfl object) {
        this.zzA = object = new zzkb(this);
        Preconditions.checkNotNull(zzke2);
        this.zzl = object = zzfl.zzC(zzke2.zza, null, null);
        this.zzy = -1;
        Object object2 = new zzkf(this);
        ((zzjv)object2).zzY();
        this.zzi = object2;
        super(this);
        ((zzjv)object2).zzY();
        this.zzd = object2;
        super(this);
        ((zzjv)object2).zzY();
        this.zzc = object2;
        object2 = new HashMap();
        this.zzz = object2;
        object = ((zzfl)object).zzau();
        object2 = new zzjw(this, zzke2);
        ((zzfi)object).zzh((Runnable)object2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static zzkd zza(Context object) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object.getApplicationContext());
        Object object2 = zzb;
        if (object2 != null) return zzb;
        object2 = zzkd.class;
        synchronized (object2) {
            Object object3 = zzb;
            if (object3 != null) return zzb;
            object3 = new zzke((Context)object);
            object = new zzkd((zzke)object3, null);
            zzb = object;
            return zzb;
        }
    }

    public static /* synthetic */ void zzaa(zzkd zzkd2, zzke object) {
        ((zzge)zzkd2.zzl.zzau()).zzg();
        object = new zzai(zzkd2);
        ((zzjv)object).zzY();
        zzkd2.zze = object;
        object = zzkd2.zzl.zzc();
        Object object2 = zzkd2.zzc;
        ((zzae)object).zza((zzad)object2);
        object = new zzjc(zzkd2);
        ((zzjv)object).zzY();
        zzkd2.zzk = object;
        object = new zzy(zzkd2);
        ((zzjv)object).zzY();
        zzkd2.zzh = object;
        object = new zzhs(zzkd2);
        ((zzjv)object).zzY();
        zzkd2.zzj = object;
        object = new zzjt(zzkd2);
        ((zzjv)object).zzY();
        zzkd2.zzg = object;
        object = new zzeq(zzkd2);
        zzkd2.zzf = object;
        int n10 = zzkd2.zzp;
        int n11 = zzkd2.zzq;
        if (n10 != n11) {
            object = zzkd2.zzl.zzat().zzb();
            n11 = zzkd2.zzp;
            object2 = n11;
            int n12 = zzkd2.zzq;
            Integer n13 = n12;
            String string2 = "Not all upload components initialized";
            ((zzeg)object).zzc(string2, object2, n13);
        }
        zzkd2.zzm = true;
    }

    public static /* synthetic */ zzfl zzab(zzkd zzkd2) {
        return zzkd2.zzl;
    }

    public static final void zzac(zzda zzda2, int n10, String object) {
        String string2;
        Object object2 = zzda2.zza();
        int n11 = 0;
        while (true) {
            int n12 = object2.size();
            string2 = "_err";
            if (n11 >= n12) break;
            String string3 = ((zzdf)object2.get(n11)).zzb();
            n12 = (int)(string2.equals(string3) ? 1 : 0);
            if (n12 != 0) {
                return;
            }
            ++n11;
        }
        object2 = zzdf.zzn();
        ((zzde)object2).zza(string2);
        long l10 = n10;
        ((zzde)object2).zzd(l10);
        zzdf zzdf2 = (zzdf)((zzho)object2).zzaA();
        object2 = zzdf.zzn();
        ((zzde)object2).zza("_ev");
        ((zzde)object2).zzb((String)object);
        object = (zzdf)((zzho)object2).zzaA();
        zzda2.zzf(zzdf2);
        zzda2.zzf((zzdf)object);
    }

    public static final void zzad(zzda zzda2, String string2) {
        int n10;
        List list = zzda2.zza();
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            String string3 = ((zzdf)list.get(i10)).zzb();
            n10 = (int)(string2.equals(string3) ? 1 : 0);
            if (n10 == 0) continue;
            zzda2.zzj(i10);
            return;
        }
    }

    /*
     * Exception decompiling
     */
    private final boolean zzae(String var1_1, long var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [719[SIMPLE_IF_TAKEN]], but top level block is 173[TRYBLOCK]
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

    private final void zzaf(zzdi object, long l10, boolean bl2) {
        zzki zzki2;
        boolean bl3 = true;
        String string2 = bl3 != bl2 ? "_lte" : "_se";
        Object object2 = this.zzi();
        Object object3 = ((zzdi)object).zzG();
        if ((object2 = ((zzai)object2).zzk((String)object3, string2)) != null && (object3 = ((zzki)object2).zze) != null) {
            object3 = ((zzdi)object).zzG();
            long l11 = this.zzl.zzax().currentTimeMillis();
            long l12 = (Long)((zzki)object2).zze + l10;
            Long l13 = l12;
            String string3 = "auto";
            object2 = zzki2;
            zzki2 = new zzki((String)object3, string3, string2, l11, l13);
        } else {
            object3 = ((zzdi)object).zzG();
            long l14 = this.zzl.zzax().currentTimeMillis();
            Long l15 = l10;
            String string4 = "auto";
            object2 = zzki2;
            zzki2 = new zzki((String)object3, string4, string2, l14, l15);
        }
        object2 = zzdu.zzj();
        ((zzdt)object2).zzb(string2);
        long l16 = this.zzl.zzax().currentTimeMillis();
        ((zzdt)object2).zza(l16);
        object3 = (Long)zzki2.zze;
        l16 = (Long)object3;
        ((zzdt)object2).zze(l16);
        object2 = (zzdu)((zzho)object2).zzaA();
        int n10 = zzkf.zzu((zzdi)object, string2);
        if (n10 >= 0) {
            ((zzdi)object).zzm(n10, (zzdu)object2);
        } else {
            ((zzdi)object).zzn((zzdu)object2);
        }
        long l17 = 0L;
        long l18 = l10 == l17 ? 0 : (l10 < l17 ? -1 : 1);
        if (l18 > 0) {
            object = this.zzi();
            ((zzai)object).zzj(zzki2);
            object = bl3 != bl2 ? "lifetime" : "session-scoped";
            zzeg zzeg2 = this.zzl.zzat().zzk();
            Object object4 = zzki2.zze;
            String string5 = "Updated engagement user property. scope, value";
            zzeg2.zzc(string5, object, object4);
        }
    }

    private final boolean zzag(zzda zzda2, zzda zzda3) {
        Object object = zzda2.zzk();
        boolean bl2 = "_e".equals(object);
        Preconditions.checkArgument(bl2);
        this.zzn();
        object = zzkf.zzz((zzdb)zzda2.zzaA(), "_sc");
        String string2 = null;
        if (object == null) {
            bl2 = false;
            object = null;
        } else {
            object = ((zzdf)object).zzd();
        }
        this.zzn();
        com.google.android.gms.internal.measurement.zzhs zzhs2 = (zzdb)zzda3.zzaA();
        String string3 = "_pc";
        zzhs2 = zzkf.zzz((zzdb)zzhs2, string3);
        if (zzhs2 != null) {
            string2 = ((zzdf)zzhs2).zzd();
        }
        if (string2 != null && (bl2 = string2.equals(object))) {
            this.zzah(zzda2, zzda3);
            return true;
        }
        return false;
    }

    private final void zzah(zzda zzda2, zzda object) {
        long l10;
        long l11;
        long l12;
        long l13;
        Object object2 = zzda2.zzk();
        boolean bl2 = "_e".equals(object2);
        Preconditions.checkArgument(bl2);
        this.zzn();
        object2 = (zzdb)zzda2.zzaA();
        String string2 = "_et";
        object2 = zzkf.zzz((zzdb)object2, string2);
        boolean n10 = ((zzdf)object2).zze();
        if (n10 && (l13 = (l12 = (l11 = ((zzdf)object2).zzf()) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
            long l14;
            long l15;
            long l16;
            l11 = ((zzdf)object2).zzf();
            this.zzn();
            object2 = zzkf.zzz((zzdb)((zzho)object).zzaA(), string2);
            if (object2 != null && (l16 = (l15 = (l14 = ((zzdf)object2).zzf()) - l10) == 0L ? 0 : (l15 < 0L ? -1 : 1)) > 0) {
                l10 = ((zzdf)object2).zzf();
                l11 += l10;
            }
            this.zzn();
            object2 = l11;
            zzkf.zzx((zzda)object, string2, object2);
            this.zzn();
            long l17 = 1L;
            object = l17;
            object2 = "_fr";
            zzkf.zzx(zzda2, (String)object2, object);
        }
    }

    private final boolean zzai() {
        ((zzge)this.zzl.zzau()).zzg();
        this.zzs();
        Object object = this.zzi();
        boolean bl2 = ((zzai)object).zzE();
        return bl2 || !(bl2 = TextUtils.isEmpty((CharSequence)(object = this.zzi().zzw())));
        {
        }
    }

    /*
     * Handled impossible loop by adding 'first' condition
     * Enabled aggressive block sorting
     */
    private final void zzaj() {
        long l10;
        long l11;
        Object object;
        zzkd zzkd2 = this;
        Object object2 = this.zzl.zzau();
        ((zzge)object2).zzg();
        this.zzs();
        long l12 = this.zza;
        long l13 = 0L;
        Object object3 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        if (object3 > 0) {
            object = this.zzl.zzax();
            l11 = object.elapsedRealtime();
            l10 = this.zza;
            l12 = 3600000L - (l11 = Math.abs(l11 - l10));
            long l14 = l12 - l13;
            Object object4 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object4 > 0) {
                zzeg zzeg2 = this.zzl.zzat().zzk();
                object2 = l12;
                zzeg2.zzb("Upload has been suspended. Will update scheduling later in approximately ms", object2);
                this.zzj().zzb();
                this.zzk().zzd();
                return;
            }
            this.zza = l13;
        }
        if ((object3 = (Object)((zzfl)(object2 = zzkd2.zzl)).zzL()) != false && (object3 = (Object)this.zzai()) != false) {
            int n10;
            Object object5;
            block19: {
                long l15;
                String string2;
                boolean bl2;
                boolean bl3;
                object2 = zzkd2.zzl.zzax();
                l12 = object2.currentTimeMillis();
                zzkd2.zzl.zzc();
                l10 = (Long)zzdw.zzz.zzb(null);
                l10 = Math.max(l13, l10);
                object = this.zzi();
                boolean bl4 = ((zzai)object).zzF();
                boolean bl5 = true;
                if (!bl4 && !(bl3 = ((zzai)(object = this.zzi())).zzx())) {
                    bl5 = false;
                }
                if (bl5) {
                    boolean bl6;
                    object = zzkd2.zzl.zzc().zzu();
                    bl2 = TextUtils.isEmpty((CharSequence)object);
                    if (!bl2 && !(bl6 = (string2 = ".none.").equals(object))) {
                        zzkd2.zzl.zzc();
                        object = (Long)zzdw.zzu.zzb(null);
                        l15 = (Long)object;
                        l15 = Math.max(l13, l15);
                    } else {
                        zzkd2.zzl.zzc();
                        object = (Long)zzdw.zzt.zzb(null);
                        l15 = (Long)object;
                        l15 = Math.max(l13, l15);
                    }
                } else {
                    zzkd2.zzl.zzc();
                    object = (Long)zzdw.zzs.zzb(null);
                    l15 = (Long)object;
                    l15 = Math.max(l13, l15);
                }
                long l16 = zzkd2.zzl.zzd().zzc.zza();
                long l17 = zzkd2.zzl.zzd().zzd.zza();
                long l18 = this.zzi().zzB();
                object = this.zzi();
                long l19 = l10;
                long l20 = ((zzai)object).zzD();
                l11 = Math.max(l18, l20);
                long l21 = l11 == l13 ? 0 : (l11 < l13 ? -1 : 1);
                if (l21 != false) {
                    zzkf zzkf2;
                    long l22;
                    l11 = Math.abs(l11 - l12);
                    l11 = l12 - l11;
                    l10 = Math.abs(l16 -= l12);
                    l18 = Math.abs(l17 -= l12);
                    l18 = l12 - l18;
                    l12 = Math.max(l12 - l10, l18);
                    l10 = l11 + l19;
                    if (bl5 && (l22 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1)) > 0) {
                        l10 = Math.min(l11, l12) + l15;
                    }
                    if ((l22 = (long)(zzkf2 = this.zzn()).zzq(l12, l15)) == false) {
                        l10 = l12 + l15;
                    }
                    boolean bl7 = true;
                    while (true) {
                        if (bl7 && !(bl7 = false)) {
                            object3 = l18 == l13 ? 0 : (l18 < l13 ? -1 : 1);
                            if (object3 == false || (object3 = l18 == l11 ? 0 : (l18 < l11 ? -1 : 1)) < 0) break block19;
                            object3 = 0;
                            object2 = null;
                        }
                        object5 = zzkd2.zzl;
                        ((zzfl)object5).zzc();
                        object = (Integer)zzdw.zzB.zzb(null);
                        int n11 = (Integer)object;
                        bl2 = false;
                        string2 = null;
                        n10 = Math.min(20, n11 = Math.max(0, n11));
                        if (object3 >= n10) break;
                        zzkd2.zzl.zzc();
                        object5 = (Long)zzdw.zzA.zzb(null);
                        l11 = (Long)object5;
                        l11 = Math.max(l13, l11);
                        long l23 = 1L << object3;
                        long l24 = (l10 += (l11 *= l23)) - l18;
                        n10 = (int)(l24 == 0L ? 0 : (l24 < 0L ? -1 : 1));
                        if (n10 <= 0) {
                            ++object3;
                            continue;
                        }
                        break block19;
                        break;
                    }
                }
                l10 = l13;
            }
            if ((object3 = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1)) == false) {
                zzkd2.zzl.zzat().zzk().zza("Next upload time is 0");
                this.zzj().zzb();
                this.zzk().zzd();
                return;
            }
            object2 = this.zzh();
            object3 = ((zzeo)object2).zzb();
            if (object3 == false) {
                zzkd2.zzl.zzat().zzk().zza("No network");
                this.zzj().zza();
                this.zzk().zzd();
                return;
            }
            object2 = zzkd2.zzl.zzd().zze;
            l12 = ((zzeu)object2).zza();
            zzkd2.zzl.zzc();
            object = (Long)zzdw.zzq.zzb(null);
            l11 = (Long)object;
            l11 = Math.max(l13, l11);
            zzkf zzkf3 = this.zzn();
            boolean bl8 = zzkf3.zzq(l12, l11);
            if (!bl8) {
                l10 = Math.max(l10, l12 += l11);
            }
            this.zzj().zzb();
            object2 = zzkd2.zzl.zzax();
            l12 = object2.currentTimeMillis();
            long l25 = (l10 -= l12) - l13;
            object3 = l25 == 0L ? 0 : (l25 < 0L ? -1 : 1);
            if (object3 <= 0) {
                zzkd2.zzl.zzc();
                object2 = zzdw.zzv;
                n10 = 0;
                l12 = (Long)((zzdv)object2).zzb(null);
                l10 = Math.max(l13, l12);
                object2 = zzkd2.zzl.zzd().zzc;
                object5 = zzkd2.zzl.zzax();
                long l26 = object5.currentTimeMillis();
                ((zzeu)object2).zzb(l26);
            }
            object2 = zzkd2.zzl.zzat().zzk();
            object5 = l10;
            ((zzeg)object2).zzb("Upload scheduled in approximately ms", object5);
            this.zzk().zzc(l10);
            return;
        }
        zzkd2.zzl.zzat().zzk().zza("Nothing to upload or uploading impossible");
        this.zzj().zzb();
        this.zzk().zzd();
    }

    private final void zzak() {
        Iterator iterator2 = this.zzl.zzau();
        ((zzge)((Object)iterator2)).zzg();
        boolean bl2 = this.zzr;
        if (!(bl2 || (bl2 = this.zzs) || (bl2 = this.zzt))) {
            boolean bl3;
            iterator2 = this.zzl.zzat().zzk();
            Object object = "Stopping uploading service(s)";
            ((zzeg)((Object)iterator2)).zza((String)object);
            iterator2 = this.zzo;
            if (iterator2 == null) {
                return;
            }
            iterator2 = iterator2.iterator();
            while (bl3 = iterator2.hasNext()) {
                object = (Runnable)iterator2.next();
                object.run();
            }
            this.zzo.clear();
            return;
        }
        iterator2 = this.zzl.zzat().zzk();
        Boolean bl4 = this.zzr;
        Boolean bl5 = this.zzs;
        Boolean bl6 = this.zzt;
        ((zzeg)((Object)iterator2)).zzd("Not stopping services. fetch, network, upload", bl4, bl5, bl6);
    }

    private final Boolean zzal(zzg object) {
        block20: {
            String string2;
            Boolean bl2;
            block19: {
                long l10;
                bl2 = Boolean.TRUE;
                try {
                    long l11 = ((zzg)object).zzv();
                    long l12 = 0x80000000L;
                    l10 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
                    string2 = null;
                    if (l10 == false) break block19;
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    return null;
                }
                Object object2 = this.zzl;
                object2 = ((zzfl)object2).zzaw();
                object2 = Wrappers.packageManager((Context)object2);
                String string3 = ((zzg)object).zzc();
                object2 = ((PackageManagerWrapper)object2).getPackageInfo(string3, 0);
                l10 = ((PackageInfo)object2).versionCode;
                long l13 = ((zzg)object).zzv();
                long l14 = l10;
                long l15 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
                if (l15 == false) {
                    return bl2;
                }
                break block20;
            }
            Object object3 = this.zzl;
            object3 = ((zzfl)object3).zzaw();
            object3 = Wrappers.packageManager((Context)object3);
            String string4 = ((zzg)object).zzc();
            object3 = ((PackageManagerWrapper)object3).getPackageInfo(string4, 0);
            object3 = ((PackageInfo)object3).versionName;
            string2 = ((zzg)object).zzt();
            if (string2 == null) break block20;
            object = ((zzg)object).zzt();
            boolean bl3 = ((String)object).equals(object3);
            if (!bl3) break block20;
            return bl2;
        }
        return Boolean.FALSE;
    }

    private final zzp zzam(String string2) {
        Object object;
        boolean bl2;
        zzkd zzkd2 = this;
        Object object2 = string2;
        Object object3 = this.zzi().zzs(string2);
        Object object4 = null;
        if (object3 != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object = ((zzg)object3).zzt())))) {
            zzp zzp2;
            object = this.zzal((zzg)object3);
            if (object != null && !(bl2 = ((Boolean)object).booleanValue())) {
                object3 = this.zzl.zzat().zzb();
                object2 = zzei.zzl(string2);
                ((zzeg)object3).zzb("App version does not match; dropping. appId", object2);
                return null;
            }
            object = ((zzg)object3).zzf();
            String string3 = ((zzg)object3).zzt();
            long l10 = ((zzg)object3).zzv();
            String string4 = ((zzg)object3).zzx();
            long l11 = ((zzg)object3).zzz();
            long l12 = ((zzg)object3).zzB();
            boolean bl3 = ((zzg)object3).zzF();
            String string5 = ((zzg)object3).zzn();
            long l13 = ((zzg)object3).zzad();
            boolean bl4 = ((zzg)object3).zzaf();
            String string6 = ((zzg)object3).zzh();
            Boolean bl5 = ((zzg)object3).zzah();
            long l14 = ((zzg)object3).zzD();
            Object object5 = ((zzg)object3).zzaj();
            zzmg.zzb();
            Object object6 = zzkd2.zzl.zzc();
            zzdv zzdv2 = zzdw.zzah;
            boolean bl6 = ((zzae)object6).zzn((String)object2, zzdv2);
            Object object7 = bl6 ? (object3 = ((zzg)object3).zzj()) : null;
            zzlc.zzb();
            object3 = zzkd2.zzl.zzc();
            object6 = zzdw.zzay;
            boolean bl7 = ((zzae)object3).zzn(null, (zzdv)object6);
            object3 = bl7 ? this.zzx(string2).zzd() : "";
            Object object8 = object3;
            object3 = zzp2;
            object2 = string2;
            object4 = object;
            object = string3;
            List list = object5;
            object5 = object8;
            zzp2 = new zzp(string2, (String)object4, string3, l10, string4, l11, l12, null, bl3, false, string5, l13, 0L, 0, bl4, false, string6, bl5, l14, list, (String)object7, (String)object8);
            return zzp2;
        }
        zzkd2.zzl.zzat().zzj().zzb("No app data available; dropping", object2);
        return null;
    }

    private final boolean zzan(zzp object) {
        boolean bl2;
        zzmg.zzb();
        Object object2 = this.zzl.zzc();
        String string2 = ((zzp)object).zza;
        zzdv zzdv2 = zzdw.zzah;
        boolean bl3 = ((zzae)object2).zzn(string2, zzdv2);
        string2 = null;
        boolean bl4 = true;
        if (bl3) {
            boolean bl5;
            object2 = ((zzp)object).zzb;
            bl3 = TextUtils.isEmpty((CharSequence)object2);
            if (bl3 && (bl3 = TextUtils.isEmpty((CharSequence)(object2 = ((zzp)object).zzu))) && (bl5 = TextUtils.isEmpty((CharSequence)(object = ((zzp)object).zzq)))) {
                return false;
            }
            return bl4;
        }
        object2 = ((zzp)object).zzb;
        bl3 = TextUtils.isEmpty((CharSequence)object2);
        if (bl3 && (bl2 = TextUtils.isEmpty((CharSequence)(object = ((zzp)object).zzq)))) {
            return false;
        }
        return bl4;
    }

    private static final void zzao(zzjv object) {
        if (object != null) {
            boolean bl2 = ((zzjv)object).zzW();
            if (bl2) {
                return;
            }
            object = String.valueOf(object.getClass());
            int n10 = String.valueOf(object).length();
            StringBuilder stringBuilder = new StringBuilder(n10 += 27);
            stringBuilder.append("Component not initialized: ");
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            IllegalStateException illegalStateException = new IllegalStateException((String)object);
            throw illegalStateException;
        }
        object = new IllegalStateException("Upload Component not created");
        throw object;
    }

    public final void zzA(zzas object, zzp zzp2) {
        String string2;
        object = zzej.zza((zzas)object);
        Object object2 = this.zzl.zzl();
        Object object3 = ((zzej)object).zzd;
        Object object4 = this.zzi();
        String string3 = zzp2.zza;
        object4 = ((zzai)object4).zzI(string3);
        ((zzkk)object2).zzH((Bundle)object3, (Bundle)object4);
        object2 = this.zzl.zzl();
        object3 = this.zzl.zzc();
        object4 = zzp2.zza;
        int n10 = ((zzae)object3).zzd((String)object4);
        ((zzkk)object2).zzG((zzej)object, n10);
        object = ((zzej)object).zzb();
        object2 = this.zzl.zzc();
        object3 = zzdw.zzac;
        object4 = null;
        boolean bl2 = ((zzae)object2).zzn(null, (zzdv)object3);
        if (bl2 && (bl2 = ((String)(object3 = "_cmp")).equals(object2 = ((zzas)object).zza)) && (bl2 = ((String)(object3 = "referrer API v2")).equals(object2 = ((zzas)object).zzb.zzd("_cis"))) && !(bl2 = TextUtils.isEmpty((CharSequence)(string2 = ((zzaq)(object2 = ((zzas)object).zzb)).zzd((String)(object3 = "gclid")))))) {
            long l10 = ((zzas)object).zzd;
            string3 = "_lgclid";
            String string4 = "auto";
            object4 = object2;
            object2 = new zzkg(string3, l10, string2, string4);
            this.zzN((zzkg)object2, zzp2);
        }
        this.zzB((zzas)object, zzp2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zzB(zzas zzas2, zzp zzp2) {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        long l10;
        Object object5;
        zzkd zzkd2 = this;
        Object object6 = zzas2;
        Object object7 = zzp2;
        Preconditions.checkNotNull(zzp2);
        Preconditions.checkNotEmpty(zzp2.zza);
        ((zzge)this.zzl.zzau()).zzg();
        this.zzs();
        Object object8 = zzp2.zza;
        long l11 = zzas2.zzd;
        this.zzn();
        int n10 = zzkf.zzy(zzas2, zzp2);
        if (n10 == 0) {
            return;
        }
        n10 = zzp2.zzh;
        if (n10 == 0) {
            this.zzX(zzp2);
            return;
        }
        Object object9 = zzp2.zzt;
        if (object9 != null) {
            object5 = zzas2.zza;
            n10 = object9.contains(object5);
            if (n10 == 0) {
                object7 = this.zzl.zzat().zzj();
                object9 = zzas2.zza;
                object6 = zzas2.zzc;
                ((zzeg)object7).zzd("Dropping non-safelisted event. appId, event name, origin", object8, object9, object6);
                return;
            }
            object9 = zzas2.zzb.zzf();
            l10 = 1L;
            object4 = "ga_safelisted";
            object9.putLong((String)object4, l10);
            object3 = zzas2.zza;
            object2 = new zzaq((Bundle)object9);
            object9 = zzas2.zzc;
            long l12 = zzas2.zzd;
            object = object5;
            object6 = object5 = new zzas((String)object3, (zzaq)object2, (String)object9, l12);
        }
        object9 = this.zzi();
        ((zzai)object9).zzb();
        try {
            int n11;
            boolean bl2;
            Object object10;
            Object object11;
            Object object12;
            object9 = this.zzi();
            Preconditions.checkNotEmpty((String)object8);
            ((zzge)object9).zzg();
            ((zzjv)object9).zzX();
            l10 = 0L;
            long l13 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
            int n12 = 0;
            Object object13 = null;
            int n13 = 2;
            int n14 = 1;
            if (l13 < 0) {
                object9 = ((zzge)object9).zzx;
                object9 = ((zzfl)object9).zzat();
                object9 = ((zzei)object9).zze();
                object12 = "Invalid time querying timed out conditional properties";
                object11 = zzei.zzl((String)object8);
                object10 = l11;
                ((zzeg)object9).zzc((String)object12, object11, object10);
                object9 = Collections.emptyList();
            } else {
                object12 = new String[n13];
                object12[0] = object8;
                object11 = String.valueOf(l11);
                object12[n14] = object11;
                object11 = "active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout";
                object9 = ((zzai)object9).zzr((String)object11, (String[])object12);
            }
            object9 = object9.iterator();
            while (bl2 = object9.hasNext()) {
                object12 = object9.next();
                if ((object12 = (zzaa)object12) == null) continue;
                object11 = zzkd2.zzl;
                object11 = ((zzfl)object11).zzat();
                object11 = ((zzei)object11).zzk();
                object10 = "User property timed out";
                object3 = ((zzaa)object12).zza;
                object2 = zzkd2.zzl;
                object2 = ((zzfl)object2).zzm();
                object = ((zzaa)object12).zzc;
                object = ((zzkg)object).zzb;
                object = ((zzed)object2).zze((String)object);
                object2 = ((zzaa)object12).zzc;
                object2 = ((zzkg)object2).zza();
                ((zzeg)object11).zzd((String)object10, object3, object, object2);
                object11 = ((zzaa)object12).zzg;
                if (object11 != null) {
                    object10 = new zzas((zzas)object11, l11);
                    zzkd2.zzC((zzas)object10, (zzp)object7);
                }
                object11 = this.zzi();
                object12 = ((zzaa)object12).zzc;
                object12 = ((zzkg)object12).zzb;
                ((zzai)object11).zzp((String)object8, (String)object12);
                n14 = 1;
            }
            object9 = this.zzi();
            Preconditions.checkNotEmpty((String)object8);
            ((zzge)object9).zzg();
            ((zzjv)object9).zzX();
            if (l13 < 0) {
                object9 = ((zzge)object9).zzx;
                object9 = ((zzfl)object9).zzat();
                object9 = ((zzei)object9).zze();
                object12 = "Invalid time querying expired conditional properties";
                object11 = zzei.zzl((String)object8);
                object10 = l11;
                ((zzeg)object9).zzc((String)object12, object11, object10);
                object9 = Collections.emptyList();
            } else {
                object12 = new String[n13];
                object12[0] = object8;
                object11 = String.valueOf(l11);
                int n15 = 1;
                object12[n15] = object11;
                object11 = "active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live";
                object9 = ((zzai)object9).zzr((String)object11, (String[])object12);
            }
            int n16 = object9.size();
            object12 = new ArrayList(n16);
            object9 = object9.iterator();
            while ((n16 = (int)(object9.hasNext() ? 1 : 0)) != 0) {
                object11 = object9.next();
                if ((object11 = (zzaa)object11) == null) continue;
                object10 = zzkd2.zzl;
                object10 = ((zzfl)object10).zzat();
                object10 = ((zzei)object10).zzk();
                object = "User property expired";
                object3 = ((zzaa)object11).zza;
                object2 = zzkd2.zzl;
                object2 = ((zzfl)object2).zzm();
                object4 = ((zzaa)object11).zzc;
                object4 = ((zzkg)object4).zzb;
                object4 = ((zzed)object2).zze((String)object4);
                object2 = ((zzaa)object11).zzc;
                object2 = ((zzkg)object2).zza();
                ((zzeg)object10).zzd((String)object, object3, object4, object2);
                object4 = this.zzi();
                object10 = ((zzaa)object11).zzc;
                object10 = ((zzkg)object10).zzb;
                ((zzai)object4).zzi((String)object8, (String)object10);
                object4 = ((zzaa)object11).zzk;
                if (object4 != null) {
                    object12.add(object4);
                }
                object4 = this.zzi();
                object11 = ((zzaa)object11).zzc;
                object11 = ((zzkg)object11).zzb;
                ((zzai)object4).zzp((String)object8, (String)object11);
                n13 = 2;
            }
            object9 = object12.iterator();
            while ((n13 = (int)(object9.hasNext() ? 1 : 0)) != 0) {
                object4 = object9.next();
                object4 = (zzas)object4;
                object12 = new zzas((zzas)object4, l11);
                zzkd2.zzC((zzas)object12, (zzp)object7);
            }
            object9 = this.zzi();
            object4 = ((zzas)object6).zza;
            Preconditions.checkNotEmpty((String)object8);
            Preconditions.checkNotEmpty((String)object4);
            ((zzge)object9).zzg();
            ((zzjv)object9).zzX();
            if (l13 < 0) {
                object5 = ((zzge)object9).zzx;
                object5 = ((zzfl)object5).zzat();
                object5 = ((zzei)object5).zze();
                object13 = "Invalid time querying triggered conditional properties";
                object8 = zzei.zzl((String)object8);
                object9 = ((zzge)object9).zzx;
                object9 = ((zzfl)object9).zzm();
                object9 = ((zzed)object9).zzc((String)object4);
                object4 = l11;
                ((zzeg)object5).zzd((String)object13, object8, object9, object4);
                object8 = Collections.emptyList();
            } else {
                l13 = 3;
                object5 = new String[l13];
                object5[0] = object8;
                n11 = 1;
                object5[n11] = object4;
                object8 = String.valueOf(l11);
                n12 = 2;
                object5[n12] = object8;
                object8 = "active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout";
                object8 = ((zzai)object9).zzr((String)object8, (String[])object5);
            }
            n10 = object8.size();
            object = new ArrayList(n10);
            object8 = object8.iterator();
            while ((n10 = (int)(object8.hasNext() ? 1 : 0)) != 0) {
                object3 = object9 = object8.next();
                object3 = (zzaa)object9;
                if (object3 == null) continue;
                object9 = ((zzaa)object3).zzc;
                object5 = ((zzaa)object3).zza;
                object13 = ((zzaa)object3).zzb;
                object4 = ((zzkg)object9).zzb;
                object10 = ((zzkg)object9).zza();
                object9 = object2;
                object2 = new zzki((String)object5, (String)object13, (String)object4, l11, object10);
                object9 = this.zzi();
                n10 = (int)(((zzai)object9).zzj((zzki)object2) ? 1 : 0);
                if (n10 != 0) {
                    object9 = zzkd2.zzl;
                    object9 = ((zzfl)object9).zzat();
                    object9 = ((zzei)object9).zzk();
                    object5 = "User property triggered";
                    object13 = ((zzaa)object3).zza;
                    object4 = zzkd2.zzl;
                    object4 = ((zzfl)object4).zzm();
                    object12 = ((zzki)object2).zzc;
                    object4 = ((zzed)object4).zze((String)object12);
                    object12 = ((zzki)object2).zze;
                    ((zzeg)object9).zzd((String)object5, object13, object4, object12);
                } else {
                    object9 = zzkd2.zzl;
                    object9 = ((zzfl)object9).zzat();
                    object9 = ((zzei)object9).zzb();
                    object5 = "Too many active user properties, ignoring";
                    object13 = ((zzaa)object3).zza;
                    object13 = zzei.zzl((String)object13);
                    object4 = zzkd2.zzl;
                    object4 = ((zzfl)object4).zzm();
                    object12 = ((zzki)object2).zzc;
                    object4 = ((zzed)object4).zze((String)object12);
                    object12 = ((zzki)object2).zze;
                    ((zzeg)object9).zzd((String)object5, object13, object4, object12);
                }
                object9 = ((zzaa)object3).zzi;
                if (object9 != null) {
                    object.add(object9);
                }
                ((zzaa)object3).zzc = object9 = new zzkg((zzki)object2);
                n10 = 1;
                ((zzaa)object3).zze = n10;
                object5 = this.zzi();
                ((zzai)object5).zzn((zzaa)object3);
            }
            zzkd2.zzC((zzas)object6, (zzp)object7);
            object6 = object.iterator();
            while ((n11 = (int)(object6.hasNext() ? 1 : 0)) != 0) {
                object8 = object6.next();
                object8 = (zzas)object8;
                object9 = new zzas((zzas)object8, l11);
                zzkd2.zzC((zzas)object9, (zzp)object7);
            }
            object6 = this.zzi();
            ((zzai)object6).zzc();
            return;
        }
        finally {
            this.zzi().zzd();
        }
    }

    /*
     * Exception decompiling
     */
    public final void zzC(zzas var1_1, zzp var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [530[UNCONDITIONALDOLOOP], 522[CATCHBLOCK]], but top level block is 328[TRYBLOCK]
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

    public final String zzD(zzaf zzaf2) {
        boolean bl2;
        zzlc.zzb();
        zzae zzae2 = this.zzl.zzc();
        zzdv zzdv2 = zzdw.zzay;
        boolean bl3 = zzae2.zzn(null, zzdv2);
        if (bl3 && !(bl2 = zzaf2.zzh())) {
            return null;
        }
        return this.zzE();
    }

    public final String zzE() {
        byte[] byArray = new byte[16];
        this.zzl.zzl().zzf().nextBytes(byArray);
        Locale locale = Locale.US;
        int n10 = 1;
        Object[] objectArray = new Object[n10];
        BigInteger bigInteger = new BigInteger(n10, byArray);
        objectArray[0] = bigInteger;
        return String.format(locale, "%032x", objectArray);
    }

    /*
     * Unable to fully structure code
     */
    public final void zzF() {
        block316: {
            block315: {
                block314: {
                    block313: {
                        block312: {
                            var1_1 = this;
                            var2_2 = this.zzl.zzau();
                            var2_2.zzg();
                            this.zzs();
                            var3_26 = 1;
                            this.zzt = var3_26;
                            var4_27 = 0;
                            var5_28 = null;
                            var2_2 = this.zzl;
                            var2_2.zzas();
                            var2_2 = this.zzl;
                            var2_2 = var2_2.zzy();
                            var2_2 = var2_2.zzC();
                            if (var2_2 != null) break block312;
                            var2_2 = this.zzl;
                            var2_2 = var2_2.zzat();
                            var2_2 = var2_2.zze();
                            var6_29 = "Upload data called on the client side before use of service was decided";
                            var2_2.zza((String)var6_29);
                            this.zzt = false;
lbl30:
                            // 5 sources

                            while (true) {
                                this.zzak();
                                return;
                            }
                        }
                        try {
                            var7_30 = var2_2.booleanValue();
                            if (var7_30 == 0) break block313;
                        }
                        catch (Throwable var2_24) {}
                        var2_2 = this.zzl;
                        var2_2 = var2_2.zzat();
                        var2_2 = var2_2.zzb();
                        var6_29 = "Upload called in the client side when service should be used";
                        var2_2.zza((String)var6_29);
                        this.zzt = false;
                        ** GOTO lbl30
                    }
                    var8_31 = this.zza;
                    var10_32 = 0L;
                    var7_30 = var8_31 == var10_32 ? 0 : (var8_31 < var10_32 ? -1 : 1);
                    if (var7_30 <= 0) break block314;
                    this.zzaj();
                    this.zzt = false;
                    ** GOTO lbl30
                }
                var2_2 = this.zzl;
                var2_2 = var2_2.zzau();
                var2_2.zzg();
                var2_2 = this.zzw;
                if (var2_2 == null) break block315;
                var2_2 = this.zzl;
                var2_2 = var2_2.zzat();
                var2_2 = var2_2.zzk();
                var6_29 = "Uploading requested multiple times";
                var2_2.zza((String)var6_29);
                this.zzt = false;
                ** GOTO lbl30
            }
            var2_2 = this.zzh();
            var7_30 = (int)var2_2.zzb();
            if (var7_30 != 0) break block316;
            var2_2 = this.zzl;
            var2_2 = var2_2.zzat();
            var2_2 = var2_2.zzk();
            var6_29 = "Network not connected, ignoring upload request";
            var2_2.zza((String)var6_29);
            this.zzaj();
            this.zzt = false;
            ** continue;
        }
        try {
            var2_2 = this.zzl;
            var2_2 = var2_2.zzax();
            var8_31 = var2_2.currentTimeMillis();
            var2_2 = this.zzl;
            var2_2 = var2_2.zzc();
            var12_33 = zzdw.zzP;
        }
        finally {
            var3_26 = 0;
            var6_29 = null;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zzG(int var1_1, Throwable var2_2, byte[] var3_3, String var4_5) {
        block19: {
            block18: {
                this.zzl.zzau().zzg();
                this.zzs();
                if (var3_3 /* !! */  != null) ** GOTO lbl6
                var3_3 /* !! */  = new byte[]{};
lbl6:
                // 2 sources

                var5_6 /* !! */  = this.zzw;
                var6_8 = null;
                this.zzw = null;
                var7_9 = 200;
                var8_10 = 204;
                if (var1_1 == var7_9) break block18;
                if (var1_1 != var8_10) ** GOTO lbl43
                var1_1 = var8_10;
            }
            if (var2_2 != null) ** GOTO lbl43
            var2_2 = this.zzl;
            var2_2 = var2_2.zzd();
            var2_2 = var2_2.zzc;
            var9_11 = this.zzl;
            var9_11 = var9_11.zzax();
            var10_13 = var9_11.currentTimeMillis();
            var2_2.zzb(var10_13);
            var2_2 = this.zzl;
            var2_2 = var2_2.zzd();
            var2_2 = var2_2.zzd;
            var10_13 = 0L;
            var2_2.zzb(var10_13);
            this.zzaj();
            var2_2 = this.zzl;
            var2_2 = var2_2.zzat();
            var2_2 = var2_2.zzk();
            var12_14 = "Successful upload. Got network response. code, size";
            var13_15 = var1_1;
            var14_21 = var3_3 /* !! */ .length;
            var3_3 /* !! */  = var14_21;
            var2_2.zzc(var12_14, var13_15, var3_3 /* !! */ );
            var13_15 = this.zzi();
            var13_15.zzb();
            var13_15 = var5_6 /* !! */ .iterator();
            break block19;
lbl43:
            // 2 sources

            var3_3 /* !! */  = (byte[])this.zzl;
            var3_3 /* !! */  = var3_3 /* !! */ .zzat();
            var3_3 /* !! */  = var3_3 /* !! */ .zzk();
            var6_8 = "Network upload failed. Will retry later. code, error";
            var9_12 = var1_1;
            var3_3 /* !! */ .zzc(var6_8, var9_12, var2_2);
            var2_2 = this.zzl;
            var2_2 = var2_2.zzd();
            var2_2 = var2_2.zzd;
            var3_3 /* !! */  = this.zzl;
            var3_3 /* !! */  = var3_3 /* !! */ .zzax();
            var26_32 = var3_3 /* !! */ .currentTimeMillis();
            var2_2.zzb(var26_32);
            var15_23 = 503;
            if (var1_1 == var15_23 || var1_1 == (var15_23 = 429)) {
                var13_19 = this.zzl;
                var13_19 = var13_19.zzd();
                var13_19 = var13_19.zze;
                var2_2 = this.zzl;
                var2_2 = var2_2.zzax();
                var28_33 = var2_2.currentTimeMillis();
                var13_19.zzb(var28_33);
            }
            var13_19 = this.zzi();
            var13_19.zzz(var5_6 /* !! */ );
            this.zzaj();
            return;
        }
        while (var15_22 = var13_15.hasNext()) {
            var2_2 = var13_15.next();
            var2_2 = (Long)var2_2;
            var3_3 /* !! */  = this.zzi();
            var16_24 = var2_2.longValue();
            var3_3 /* !! */ .zzg();
            var3_3 /* !! */ .zzX();
            var5_6 /* !! */  = var3_3 /* !! */ .zze();
            var18_25 = 1;
            var19_26 = new String[var18_25];
            var19_26[0] = var12_14 = String.valueOf(var16_24);
            var12_14 = "queue";
            var20_27 = "rowid=?";
            {
                catch (SQLiteException var3_4) {
                    var5_6 /* !! */  = this.zzx;
                    if (var5_6 /* !! */  == null) throw var3_4;
                    var15_22 = var5_6 /* !! */ .contains(var2_2);
                    if (var15_22 == false) throw var3_4;
                    continue;
                }
            }
            try {
                var21_28 = var5_6 /* !! */ .delete(var12_14, var20_27, var19_26);
                if (var21_28 == var18_25) continue;
                var12_14 = "Deleted fewer rows from queue than expected";
                var5_6 /* !! */  = new SQLiteException(var12_14);
                throw var5_6 /* !! */ ;
            }
            catch (SQLiteException var5_7) {
                var3_3 /* !! */  = var3_3 /* !! */ .zzx;
                var3_3 /* !! */  = var3_3 /* !! */ .zzat();
                var3_3 /* !! */  = var3_3 /* !! */ .zzb();
                var12_14 = "Failed to delete a bundle in a queue table";
                var3_3 /* !! */ .zzb(var12_14, (Object)var5_7);
                throw var5_7;
            }
        }
        var13_15 = this.zzi();
        var13_15.zzc();
        try {
            var13_15 = this.zzi();
            var13_15.zzd();
            this.zzx = null;
            var13_15 = this.zzh();
            var1_1 = (int)var13_15.zzb();
            if (var1_1 != 0 && (var1_1 = (int)this.zzai()) != 0) {
                this.zzF();
            } else {
                this.zzy = var22_29 = (long)-1;
                this.zzaj();
            }
            this.zza = var10_13;
            return;
            catch (Throwable var13_16) {
                var2_2 = this.zzi();
                var2_2.zzd();
                throw var13_16;
            }
        }
        catch (SQLiteException var13_17) {
            var2_2 = this.zzl;
            var2_2 = var2_2.zzat();
            var2_2 = var2_2.zzb();
            var3_3 /* !! */  = "Database error while trying to delete uploaded bundles";
            var2_2.zzb((String)var3_3 /* !! */ , (Object)var13_17);
            var13_18 = this.zzl;
            var13_18 = var13_18.zzax();
            this.zza = var22_30 = var13_18.elapsedRealtime();
            var13_18 = this.zzl;
            var13_18 = var13_18.zzat();
            var13_18 = var13_18.zzk();
            var2_2 = "Disable upload, time";
            var24_31 = this.zza;
            var3_3 /* !! */  = var24_31;
            var13_18.zzb((String)var2_2, var3_3 /* !! */ );
            return;
        }
    }

    public final void zzH(zzg object) {
        boolean bl2;
        URL uRL;
        Object object2;
        Object object3;
        Object object4;
        Object object5;
        block32: {
            ((zzge)this.zzl.zzau()).zzg();
            zzmg.zzb();
            Object object6 = this.zzl.zzc();
            object5 = ((zzg)object).zzc();
            object4 = zzdw.zzah;
            boolean bl3 = ((zzae)object6).zzn((String)object5, (zzdv)object4);
            if (bl3) {
                object6 = ((zzg)object).zzf();
                bl3 = TextUtils.isEmpty((CharSequence)object6);
                if (bl3 && (bl3 = TextUtils.isEmpty((CharSequence)(object6 = ((zzg)object).zzj()))) && (bl3 = TextUtils.isEmpty((CharSequence)(object6 = ((zzg)object).zzh())))) {
                    String string2 = ((zzg)object).zzc();
                    zzkd zzkd2 = this;
                    this.zzI(string2, 204, null, null, null);
                    return;
                }
            } else {
                object6 = ((zzg)object).zzf();
                bl3 = TextUtils.isEmpty((CharSequence)object6);
                if (bl3 && (bl3 = TextUtils.isEmpty((CharSequence)(object6 = ((zzg)object).zzh())))) {
                    String string3 = ((zzg)object).zzc();
                    zzkd zzkd3 = this;
                    this.zzI(string3, 204, null, null, null);
                    return;
                }
            }
            object6 = this.zzl.zzc();
            object5 = new Uri.Builder();
            Object object7 = ((zzg)object).zzf();
            boolean bl4 = TextUtils.isEmpty((CharSequence)object7);
            if (bl4) {
                zzmg.zzb();
                object7 = ((zzge)object6).zzx.zzc();
                object3 = ((zzg)object).zzc();
                boolean bl5 = ((zzae)object7).zzn((String)object3, (zzdv)object4);
                if (bl5) {
                    object7 = ((zzg)object).zzj();
                    bl5 = TextUtils.isEmpty((CharSequence)object7);
                    if (bl5) {
                        object7 = ((zzg)object).zzh();
                    }
                } else {
                    object7 = ((zzg)object).zzh();
                }
            }
            object4 = zzdw.zzd;
            bl4 = false;
            object3 = null;
            object4 = (String)((zzdv)object4).zzb(null);
            object4 = object5.scheme((String)object4);
            object2 = (String)zzdw.zze.zzb(null);
            object4 = object4.encodedAuthority((String)object2);
            object7 = String.valueOf(object7);
            object2 = "config/app/";
            int n10 = ((String)object7).length();
            object7 = n10 != 0 ? ((String)object2).concat((String)object7) : new String((String)object2);
            object4 = object4.path((String)object7);
            object7 = ((zzg)object).zzd();
            object4 = object4.appendQueryParameter("app_instance_id", (String)object7);
            object2 = "android";
            object4 = object4.appendQueryParameter("platform", (String)object2);
            ((zzae)object6).zzf();
            long l10 = 39000L;
            object6 = String.valueOf(l10);
            object7 = "gmp_version";
            object4.appendQueryParameter((String)object7, (String)object6);
            object6 = object5.build().toString();
            try {
                uRL = new URL((String)object6);
                object5 = this.zzl;
            }
            catch (MalformedURLException malformedURLException) {
                object5 = this.zzl.zzat().zzb();
                object = zzei.zzl(((zzg)object).zzc());
                ((zzeg)object5).zzc("Failed to parse config URL. Not fetching. appId", object, object6);
                return;
            }
            object5 = ((zzfl)object5).zzat();
            object5 = ((zzei)object5).zzk();
            object4 = "Fetching remote configuration";
            object7 = ((zzg)object).zzc();
            ((zzeg)object5).zzb((String)object4, object7);
            object5 = this.zzf();
            object4 = ((zzg)object).zzc();
            object5 = ((zzfc)object5).zzb((String)object4);
            object4 = this.zzf();
            object7 = ((zzg)object).zzc();
            object4 = ((zzfc)object4).zzc((String)object7);
            if (object5 == null) break block32;
            bl2 = TextUtils.isEmpty((CharSequence)object4);
            if (bl2) break block32;
            object3 = new ArrayMap();
            object5 = "If-Modified-Since";
            object3.put(object5, object4);
        }
        bl2 = true;
        this.zzr = bl2;
        zzeo zzeo2 = this.zzh();
        String string4 = ((zzg)object).zzc();
        zzjy zzjy2 = new zzjy(this);
        zzeo2.zzg();
        zzeo2.zzX();
        Preconditions.checkNotNull(uRL);
        Preconditions.checkNotNull(zzjy2);
        object5 = zzeo2.zzx;
        object5 = ((zzfl)object5).zzau();
        object2 = object4;
        object4 = new zzen(zzeo2, string4, uRL, null, (Map)object3, zzjy2);
        ((zzfi)object5).zzk((Runnable)object4);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void zzI(String var1_1, int var2_4, Throwable var3_5, byte[] var4_6, Map var5_7) {
        block87: {
            block84: {
                block83: {
                    block86: {
                        block82: {
                            block85: {
                                this.zzl.zzau().zzg();
                                this.zzs();
                                Preconditions.checkNotEmpty((String)var1_1);
                                if (var4_6 /* !! */  == null) {
                                    var4_6 /* !! */  = new byte[]{};
                                }
                                var6_8 = this.zzl;
                                var6_8 = var6_8.zzat();
                                var6_8 = var6_8.zzk();
                                var7_9 = var4_6 /* !! */ .length;
                                var8_10 = var7_9;
                                var9_11 = "onConfigFetched. Response size";
                                var6_8.zzb(var9_11, var8_10);
                                var6_8 = this.zzi();
                                var6_8.zzb();
                                var6_8 = this.zzi();
                                var6_8 = var6_8.zzs((String)var1_1);
                                var10_12 = 200;
                                var11_13 = 304;
                                if (var2_4 == var10_12 || var2_4 == (var10_12 = 204)) break block85;
                                if (var2_4 != var11_13) ** GOTO lbl-1000
                                var2_4 = var11_13;
                            }
                            if (var3_5 == null) {
                                var10_12 = 1;
                            } else lbl-1000:
                            // 2 sources

                            {
                                var10_12 = 0;
                                var9_11 = null;
                            }
                            if (var6_8 != null) break block82;
                            var12_14 = this.zzl;
                            var12_14 = var12_14.zzat();
                            var12_14 = var12_14.zze();
                            var3_5 = "App does not exist in onConfigFetched. appId";
                            var1_1 = zzei.zzl((String)var1_1);
                            var12_14.zzb((String)var3_5, var1_1);
                            ** GOTO lbl202
                        }
                        var13_15 = 404;
                        if (var10_12 != 0 || var2_4 == var13_15) break block86;
                        var4_6 /* !! */  = (byte[])this.zzl;
                        var4_6 /* !! */  = var4_6 /* !! */ .zzax();
                        var14_16 = var4_6 /* !! */ .currentTimeMillis();
                        var6_8.zzM(var14_16);
                        var4_6 /* !! */  = this.zzi();
                        var4_6 /* !! */ .zzt((zzg)var6_8);
                        var4_6 /* !! */  = this.zzl;
                        var4_6 /* !! */  = var4_6 /* !! */ .zzat();
                        var4_6 /* !! */  = var4_6 /* !! */ .zzk();
                        var5_7 = "Fetching config failed. code, error";
                        var6_8 = var2_4;
                        var4_6 /* !! */ .zzc((String)var5_7, var6_8, var3_5);
                        var3_5 = this.zzf();
                        var3_5.zzd((String)var1_1);
                        var1_1 = this.zzl;
                        var1_1 = var1_1.zzd();
                        var1_1 = var1_1.zzd;
                        var3_5 = this.zzl;
                        var3_5 = var3_5.zzax();
                        var16_17 = var3_5.currentTimeMillis();
                        var1_1.zzb(var16_17);
                        var18_19 = 503;
                        if (var2_4 != var18_19 && var2_4 != (var18_19 = 429)) ** GOTO lbl108
                        var1_1 = this.zzl;
                        var1_1 = var1_1.zzd();
                        var1_1 = var1_1.zze;
                        var12_14 = this.zzl;
                        var12_14 = var12_14.zzax();
                        var19_21 = var12_14.currentTimeMillis();
                        var1_1.zzb(var19_21);
lbl108:
                        // 2 sources

                        this.zzaj();
                        ** GOTO lbl202
                    }
                    var21_22 = false;
                    var3_5 = null;
                    if (var5_7 != null) {
                        var9_11 = "Last-Modified";
                        var5_7 = var5_7.get(var9_11);
                        var5_7 = (List)var5_7;
                    }
                    var5_7 = null;
                    if (var5_7 != null) {
                        var10_12 = var5_7.size();
                        if (var10_12 <= 0) break block83;
                        var5_7 = var5_7.get(0);
                        var5_7 = (String)var5_7;
                    }
                }
                var5_7 = null;
                if (var2_4 != var13_15 && var2_4 != var11_13) {
                    var3_5 = this.zzf();
                    var21_22 = var3_5.zzh((String)var1_1, var4_6 /* !! */ , (String)var5_7);
                    if (var21_22) break block84;
                    var1_1 = this.zzi();
lbl140:
                    // 3 sources

                    while (true) {
                        var1_1.zzd();
                        return;
                    }
                }
                var4_6 /* !! */  = this.zzf();
                var4_6 /* !! */  = var4_6 /* !! */ .zzb((String)var1_1);
                if (var4_6 /* !! */  != null) break block84;
                var4_6 /* !! */  = this.zzf();
                var21_22 = var4_6 /* !! */ .zzh((String)var1_1, null, null);
                if (var21_22) break block84;
                var1_1 = this.zzi();
                ** GOTO lbl140
                {
                    catch (Throwable var1_3) {
                        throw var1_3;
                    }
                }
            }
            var3_5 = this.zzl;
            var3_5 = var3_5.zzax();
            var16_18 = var3_5.currentTimeMillis();
            var6_8.zzK(var16_18);
            var3_5 = this.zzi();
            var3_5.zzt((zzg)var6_8);
            if (var2_4 != var13_15) ** GOTO lbl181
            var12_14 = this.zzl;
            var12_14 = var12_14.zzat();
            var12_14 = var12_14.zzh();
            var3_5 = "Config not found. Using empty config. appId";
            var12_14.zzb((String)var3_5, var1_1);
            ** GOTO lbl191
lbl181:
            // 1 sources

            var1_1 = this.zzl;
            var1_1 = var1_1.zzat();
            var1_1 = var1_1.zzk();
            var3_5 = "Successfully fetched config. Got network response. code, size";
            var12_14 = var2_4;
            var1_1.zzc((String)var3_5, var12_14, var8_10);
lbl191:
            // 2 sources

            var1_1 = this.zzh();
            var18_20 = var1_1.zzb();
            if (!var18_20) ** GOTO lbl201
            var18_20 = this.zzai();
            if (!var18_20) ** GOTO lbl201
            this.zzF();
            break block87;
lbl201:
            // 2 sources

            this.zzaj();
        }
        var1_1 = this.zzi();
        var1_1.zzc();
        var1_1 = this.zzi();
        ** continue;
        catch (Throwable var1_2) {
            var12_14 = this.zzi();
            var12_14.zzd();
            throw var1_2;
        }
        finally {
            this.zzr = false;
            this.zzak();
        }
    }

    public final void zzJ(Runnable runnable) {
        ((zzge)this.zzl.zzau()).zzg();
        ArrayList arrayList = this.zzo;
        if (arrayList == null) {
            this.zzo = arrayList = new ArrayList();
        }
        this.zzo.add(runnable);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zzK() {
        Object object = this.zzl.zzau();
        ((zzge)object).zzg();
        this.zzs();
        boolean bl2 = this.zzn;
        if (!bl2) {
            this.zzn = bl2 = true;
            int n10 = this.zzL();
            if (n10 != 0) {
                Object object2;
                Object object3;
                int n11;
                int n12;
                long l10;
                Object object4;
                Object object5;
                block15: {
                    int n13;
                    object5 = this.zzv;
                    ((zzge)this.zzl.zzau()).zzg();
                    object4 = "Bad channel to read from";
                    l10 = 0L;
                    n12 = 4;
                    n11 = 0;
                    if (object5 != null && (n13 = ((AbstractInterruptibleChannel)object5).isOpen()) != 0) {
                        object3 = ByteBuffer.allocate(n12);
                        try {
                            ((FileChannel)object5).position(l10);
                            n10 = ((FileChannel)object5).read((ByteBuffer)object3);
                            if (n10 != n12) {
                                n13 = -1;
                                if (n10 != n13) {
                                    object3 = this.zzl;
                                    object3 = ((zzfl)object3).zzat();
                                    object3 = ((zzei)object3).zze();
                                    object2 = "Unexpected data length. Bytes read";
                                    object5 = n10;
                                    ((zzeg)object3).zzb((String)object2, object5);
                                }
                                break block15;
                            }
                            ((ByteBuffer)object3).flip();
                            n11 = ((ByteBuffer)object3).getInt();
                        }
                        catch (IOException iOException) {
                            object3 = this.zzl.zzat().zzb();
                            object2 = "Failed to read from channel";
                            ((zzeg)object3).zzb((String)object2, iOException);
                        }
                    } else {
                        object5 = this.zzl.zzat().zzb();
                        ((zzeg)object5).zza((String)object4);
                    }
                }
                object5 = this.zzl.zzA();
                n10 = ((zzea)object5).zzm();
                object3 = this.zzl.zzau();
                ((zzge)object3).zzg();
                if (n11 > n10) {
                    object = this.zzl.zzat().zzb();
                    object4 = n11;
                    object5 = n10;
                    ((zzeg)object).zzc("Panic: can't downgrade version. Previous, current version", object4, object5);
                    return;
                }
                if (n11 < n10) {
                    String string2;
                    block16: {
                        int n14;
                        object3 = this.zzv;
                        object2 = this.zzl.zzau();
                        ((zzge)object2).zzg();
                        if (object3 != null && (n14 = ((AbstractInterruptibleChannel)object3).isOpen()) != 0) {
                            object4 = ByteBuffer.allocate(n12);
                            ((ByteBuffer)object4).putInt(n10);
                            ((ByteBuffer)object4).flip();
                            try {
                                ((FileChannel)object3).truncate(l10);
                                zzgg zzgg2 = this.zzl;
                                zzgg2 = ((zzfl)zzgg2).zzc();
                                object2 = zzdw.zzaq;
                                n12 = (int)(((zzae)zzgg2).zzn(null, (zzdv)object2) ? 1 : 0);
                                if (n12 != 0 && (n12 = Build.VERSION.SDK_INT) <= (n14 = 19)) {
                                    ((FileChannel)object3).position(l10);
                                }
                                ((FileChannel)object3).write((ByteBuffer)object4);
                                ((FileChannel)object3).force(bl2);
                                long l11 = ((FileChannel)object3).size();
                                long l12 = 4;
                                bl2 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
                                if (bl2) {
                                    object = this.zzl;
                                    object = ((zzfl)object).zzat();
                                    object = ((zzei)object).zzb();
                                    object4 = "Error writing to channel. Bytes written";
                                    l10 = ((FileChannel)object3).size();
                                    Long l13 = l10;
                                    ((zzeg)object).zzb((String)object4, l13);
                                }
                                object = this.zzl.zzat().zzk();
                            }
                            catch (IOException iOException) {
                                object4 = this.zzl.zzat().zzb();
                                string2 = "Failed to write to channel";
                                ((zzeg)object4).zzb(string2, iOException);
                                break block16;
                            }
                            object4 = n11;
                            object5 = n10;
                            ((zzeg)object).zzc("Storage version upgraded. Previous, current version", object4, object5);
                            return;
                        }
                        object = this.zzl.zzat().zzb();
                        ((zzeg)object).zza((String)object4);
                    }
                    object = this.zzl.zzat().zzb();
                    object4 = n11;
                    object5 = n10;
                    string2 = "Storage version upgrade failed. Previous, current version";
                    ((zzeg)object).zzc(string2, object4, object5);
                }
            }
        }
    }

    public final boolean zzL() {
        String string2;
        Object object;
        Object object2;
        block16: {
            ((zzge)this.zzl.zzau()).zzg();
            object2 = this.zzl.zzc();
            object = zzdw.zzag;
            boolean bl2 = ((zzae)object2).zzn(null, (zzdv)object);
            boolean bl3 = true;
            string2 = "Storage concurrent access okay";
            if (bl2 && (object2 = this.zzu) != null && (bl2 = ((FileLock)object2).isValid())) {
                this.zzl.zzat().zzk().zza(string2);
                return bl3;
            }
            this.zze.zzx.zzc();
            object2 = this.zzl.zzaw().getFilesDir();
            String string3 = "google_app_measurement.db";
            File file = new File((File)object2, string3);
            string3 = "rw";
            object2 = new RandomAccessFile(file, string3);
            object2 = ((RandomAccessFile)object2).getChannel();
            this.zzv = object2;
            object2 = ((FileChannel)object2).tryLock();
            this.zzu = object2;
            if (object2 == null) break block16;
            object2 = this.zzl;
            object2 = ((zzfl)object2).zzat();
            object2 = ((zzei)object2).zzk();
            ((zzeg)object2).zza(string2);
            return bl3;
        }
        object2 = this.zzl;
        object2 = ((zzfl)object2).zzat();
        object2 = ((zzei)object2).zzb();
        object = "Storage concurrent data access panic";
        try {
            ((zzeg)object2).zza((String)object);
        }
        catch (OverlappingFileLockException overlappingFileLockException) {
            object = this.zzl.zzat().zze();
            string2 = "Storage lock already acquired";
            ((zzeg)object).zzb(string2, overlappingFileLockException);
        }
        catch (IOException iOException) {
            object = this.zzl.zzat().zzb();
            string2 = "Failed to access storage lock file";
            ((zzeg)object).zzb(string2, iOException);
        }
        catch (FileNotFoundException fileNotFoundException) {
            object = this.zzl.zzat().zzb();
            string2 = "Failed to acquire storage lock";
            ((zzeg)object).zzb(string2, fileNotFoundException);
        }
        return false;
    }

    public final void zzM(zzp zzp2) {
        int n10;
        block21: {
            Object object;
            Object object2 = "app_id=?";
            ArrayList arrayList = this.zzw;
            if (arrayList != null) {
                this.zzx = arrayList = new ArrayList();
                object = this.zzw;
                arrayList.addAll(object);
            }
            arrayList = this.zzi();
            object = zzp2.zza;
            Preconditions.checkNotEmpty((String)object);
            ((zzge)((Object)arrayList)).zzg();
            ((zzjv)((Object)arrayList)).zzX();
            Object object3 = ((zzai)((Object)arrayList)).zze();
            int n11 = 1;
            Object object4 = new String[n11];
            int n12 = 0;
            String string2 = null;
            object4[0] = object;
            string2 = "apps";
            n12 = object3.delete(string2, (String)object2, object4);
            String string3 = "events";
            int n13 = object3.delete(string3, (String)object2, object4);
            n12 += n13;
            string3 = "user_attributes";
            n13 = object3.delete(string3, (String)object2, object4);
            n12 += n13;
            string3 = "conditional_properties";
            n13 = object3.delete(string3, (String)object2, object4);
            n12 += n13;
            string3 = "raw_events";
            n13 = object3.delete(string3, (String)object2, object4);
            n12 += n13;
            string3 = "raw_events_metadata";
            n13 = object3.delete(string3, (String)object2, object4);
            n12 += n13;
            string3 = "queue";
            n13 = object3.delete(string3, (String)object2, object4);
            n12 += n13;
            string3 = "audience_filter_values";
            n13 = object3.delete(string3, (String)object2, object4);
            n12 += n13;
            string3 = "main_event_params";
            n13 = object3.delete(string3, (String)object2, object4);
            n12 += n13;
            string3 = "default_event_params";
            n10 = object3.delete(string3, (String)object2, object4);
            if ((n12 += n10) <= 0) break block21;
            object2 = ((zzge)arrayList).zzx;
            object2 = ((zzfl)object2).zzat();
            object2 = ((zzei)object2).zzk();
            object3 = "Reset analytics data. app, records";
            object4 = n12;
            try {
                ((zzeg)object2).zzc((String)object3, object, object4);
            }
            catch (SQLiteException sQLiteException) {
                arrayList = ((zzge)arrayList).zzx.zzat().zzb();
                object = zzei.zzl((String)object);
                object3 = "Error resetting analytics data. appId, error";
                ((zzeg)((Object)arrayList)).zzc((String)object3, object, (Object)sQLiteException);
            }
        }
        if ((n10 = zzp2.zzh) != 0) {
            this.zzS(zzp2);
        }
    }

    public final void zzN(zzkg object, zzp zzp2) {
        Object object2 = this.zzl.zzau();
        ((zzge)object2).zzg();
        this.zzs();
        boolean bl2 = this.zzan(zzp2);
        if (!bl2) {
            return;
        }
        bl2 = zzp2.zzh;
        if (bl2) {
            block33: {
                Object object3;
                int n10;
                Object object4;
                String string2;
                object2 = this.zzl.zzl();
                Object object5 = ((zzkg)object).zzb;
                int n11 = ((zzkk)object2).zzo((String)object5);
                bl2 = true;
                int n12 = 24;
                int n13 = 0;
                Object object6 = null;
                if (n11 != 0) {
                    int n14;
                    Object object7 = this.zzl.zzl();
                    String string3 = ((zzkg)object).zzb;
                    zzfl zzfl2 = this.zzl;
                    zzfl2.zzc();
                    String string4 = ((zzkk)object7).zzC(string3, n12, bl2);
                    object = ((zzkg)object).zzb;
                    if (object != null) {
                        int n15;
                        n14 = n15 = ((String)object).length();
                    } else {
                        n14 = 0;
                        Object var16_24 = null;
                    }
                    object6 = this.zzl.zzl();
                    object7 = this.zzA;
                    string3 = zzp2.zza;
                    ((zzkk)object6).zzM((zzkj)object7, string3, n11, "_ev", string4, n14);
                    return;
                }
                Object object8 = this.zzl.zzl();
                int n16 = ((zzkk)object8).zzJ(string2 = ((zzkg)object).zzb, object4 = ((zzkg)object).zza());
                if (n16 != 0) {
                    object8 = this.zzl.zzl();
                    string2 = ((zzkg)object).zzb;
                    object4 = this.zzl;
                    ((zzfl)object4).zzc();
                    String string5 = ((zzkk)object8).zzC(string2, n12, bl2);
                    object = ((zzkg)object).zza();
                    if (object != null && ((bl2 = object instanceof String) || (bl2 = object instanceof CharSequence))) {
                        object = String.valueOf(object);
                        n13 = ((String)object).length();
                    }
                    zzkk zzkk2 = this.zzl.zzl();
                    zzkj zzkj2 = this.zzA;
                    String string6 = zzp2.zza;
                    zzkk2.zzM(zzkj2, string6, n16, "_ev", string5, n13);
                    return;
                }
                object2 = this.zzl.zzl();
                object5 = ((zzkg)object).zzb;
                object6 = ((zzkg)object).zza();
                if ((object2 = ((zzkk)object2).zzK((String)object5, object6)) == null) {
                    return;
                }
                object6 = "_sid";
                object5 = ((zzkg)object).zzb;
                n12 = (int)(((String)object6).equals(object5) ? 1 : 0);
                if (n12 != 0) {
                    Object object9;
                    long l10;
                    long l11 = ((zzkg)object).zzc;
                    String string7 = ((zzkg)object).zzf;
                    object5 = this.zzi();
                    object6 = zzp2.zza;
                    object8 = "_sno";
                    if ((object5 = ((zzai)object5).zzk((String)object6, (String)object8)) != null && (n10 = (object6 = ((zzki)object5).zze) instanceof Long) != 0) {
                        object6 = (Long)object6;
                        l10 = (Long)object6;
                    } else {
                        if (object5 != null) {
                            object6 = this.zzl.zzat().zze();
                            object5 = ((zzki)object5).zze;
                            object8 = "Retrieved last session number from database does not contain a valid (long) value";
                            ((zzeg)object6).zzb((String)object8, object5);
                        }
                        object5 = this.zzi();
                        object6 = zzp2.zza;
                        object8 = "_s";
                        if ((object5 = ((zzai)object5).zzf((String)object6, (String)object8)) != null) {
                            l10 = ((zzao)object5).zzc;
                            object8 = this.zzl.zzat().zzk();
                            object3 = l10;
                            object9 = "Backfill the session number. Last used session number";
                            ((zzeg)object8).zzb((String)object9, object3);
                        } else {
                            l10 = 0L;
                        }
                    }
                    long l12 = 1L;
                    object3 = l10 += l12;
                    object8 = "_sno";
                    object6 = object9;
                    object9 = new zzkg((String)object8, l11, object3, string7);
                    this.zzN((zzkg)object9, zzp2);
                }
                string2 = zzp2.zza;
                object4 = ((zzkg)object).zzf;
                object3 = ((zzkg)object).zzb;
                long l13 = ((zzkg)object).zzc;
                object8 = object5;
                object5 = new zzki(string2, (String)object4, (String)object3, l13, object2);
                object = this.zzl.zzat().zzk();
                object6 = this.zzl.zzm();
                object8 = ((zzki)object5).zzc;
                object6 = ((zzed)object6).zze((String)object8);
                object8 = "Setting user property";
                ((zzeg)object).zzc((String)object8, object6, object2);
                object = this.zzi();
                ((zzai)object).zzb();
                this.zzX(zzp2);
                object = this.zzi();
                boolean bl3 = ((zzai)object).zzj((zzki)object5);
                object2 = this.zzi();
                ((zzai)object2).zzc();
                if (bl3) break block33;
                object = this.zzl;
                object = ((zzfl)object).zzat();
                object = ((zzei)object).zzb();
                object2 = "Too many unique user properties are set. Ignoring user property";
                object6 = this.zzl;
                object6 = ((zzfl)object6).zzm();
                object8 = ((zzki)object5).zzc;
                object6 = ((zzed)object6).zze((String)object8);
                object5 = ((zzki)object5).zze;
                ((zzeg)object).zzc((String)object2, object6, object5);
                object = this.zzl;
                object2 = ((zzfl)object).zzl();
                object5 = this.zzA;
                object6 = zzp2.zza;
                n10 = 9;
                string2 = null;
                n11 = 0;
                object4 = null;
                object3 = null;
                ((zzkk)object2).zzM((zzkj)object5, (String)object6, n10, null, null, 0);
            }
            return;
            finally {
                this.zzi().zzd();
            }
        }
        this.zzX(zzp2);
    }

    public final void zzO(zzkg object, zzp object2) {
        Object object3 = this.zzl.zzau();
        ((zzge)object3).zzg();
        this.zzs();
        boolean bl2 = this.zzan((zzp)object2);
        if (!bl2) {
            return;
        }
        bl2 = ((zzp)object2).zzh;
        if (!bl2) {
            this.zzX((zzp)object2);
            return;
        }
        Object object4 = "_npa";
        object3 = ((zzkg)object).zzb;
        bl2 = ((String)object4).equals(object3);
        if (bl2 && (object3 = ((zzp)object2).zzr) != null) {
            this.zzl.zzat().zzj().zza("Falling back to manifest metadata value for ad personalization");
            object3 = this.zzl.zzax();
            long l10 = object3.currentTimeMillis();
            bl2 = true;
            object4 = ((zzp)object2).zzr;
            boolean bl3 = (Boolean)object4;
            long l11 = bl2 != bl3 ? 0L : 1L;
            Long l12 = l11;
            object4 = object;
            object = new zzkg("_npa", l10, l12, "auto");
            this.zzN((zzkg)object, (zzp)object2);
            return;
        }
        object3 = this.zzl.zzat().zzj();
        object4 = this.zzl.zzm();
        String string2 = ((zzkg)object).zzb;
        object4 = ((zzed)object4).zze(string2);
        string2 = "Removing user property";
        ((zzeg)object3).zzb(string2, object4);
        object3 = this.zzi();
        ((zzai)object3).zzb();
        try {
            this.zzX((zzp)object2);
            object3 = this.zzi();
            object2 = ((zzp)object2).zza;
            object4 = ((zzkg)object).zzb;
            ((zzai)object3).zzi((String)object2, (String)object4);
            object2 = this.zzi();
            ((zzai)object2).zzc();
            object2 = this.zzl;
            object2 = ((zzfl)object2).zzat();
            object2 = ((zzei)object2).zzj();
            object3 = "User property removed";
            object4 = this.zzl;
            object4 = ((zzfl)object4).zzm();
            object = ((zzkg)object).zzb;
            object = ((zzed)object4).zze((String)object);
            ((zzeg)object2).zzb((String)object3, object);
            return;
        }
        finally {
            this.zzi().zzd();
        }
    }

    public final void zzP() {
        int n10;
        this.zzp = n10 = this.zzp + 1;
    }

    public final void zzQ() {
        int n10;
        this.zzq = n10 = this.zzq + 1;
    }

    public final zzfl zzR() {
        return this.zzl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zzS(zzp zzp2) {
        long l10;
        long l11;
        Object object;
        int n10;
        Object object2;
        String string2;
        Long l12;
        long l13;
        Object object3;
        String[] stringArray;
        boolean bl2;
        String[] stringArray2;
        int n11;
        Object object4;
        Object object5;
        Object object6;
        int n12;
        long l14;
        long l15;
        String[] stringArray3;
        Object object7;
        Object object8;
        Object object9;
        Object object10;
        Object object11;
        Object object12;
        Object object13;
        zzp zzp3;
        zzkd zzkd2;
        block56: {
            block52: {
                block55: {
                    block54: {
                        block53: {
                            boolean bl3;
                            String string3;
                            boolean bl4;
                            zzkd2 = this;
                            zzp3 = zzp2;
                            object13 = "_sysu";
                            object12 = "_sys";
                            object11 = "_pfo";
                            object10 = "_uwa";
                            object9 = "app_id=?";
                            ((zzge)this.zzl.zzau()).zzg();
                            this.zzs();
                            Preconditions.checkNotNull(zzp2);
                            object8 = zzp2.zza;
                            Preconditions.checkNotEmpty((String)object8);
                            object7 = this.zzan(zzp2);
                            if (object7 == 0) {
                                return;
                            }
                            object8 = this.zzi();
                            stringArray3 = zzp2.zza;
                            object8 = ((zzai)object8).zzs((String)stringArray3);
                            l15 = 0L;
                            if (object8 != null && (bl4 = TextUtils.isEmpty((CharSequence)(string3 = ((zzg)object8).zzf()))) && !(bl4 = TextUtils.isEmpty((CharSequence)(string3 = zzp2.zzb)))) {
                                ((zzg)object8).zzK(l15);
                                this.zzi().zzt((zzg)object8);
                                object8 = this.zzf();
                                string3 = zzp2.zza;
                                ((zzfc)object8).zze(string3);
                            }
                            if ((object7 = zzp3.zzh) == 0) {
                                this.zzX(zzp2);
                                return;
                            }
                            l14 = zzp3.zzm;
                            long l16 = l14 - l15;
                            object7 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                            if (object7 == 0) {
                                object8 = zzkd2.zzl.zzax();
                                l14 = object8.currentTimeMillis();
                            }
                            object8 = zzkd2.zzl.zzz();
                            ((zzam)object8).zze();
                            object7 = zzp3.zzn;
                            n12 = 1;
                            if (object7 != 0) {
                                if (object7 != n12) {
                                    object6 = zzkd2.zzl.zzat().zze();
                                    object5 = zzei.zzl(zzp3.zza);
                                    object8 = object7;
                                    object4 = "Incorrect app type, assuming installed app. appId, appType";
                                    ((zzeg)object6).zzc((String)object4, object5, object8);
                                    object7 = 0;
                                    object8 = null;
                                } else {
                                    object7 = n12;
                                }
                            }
                            object6 = this.zzi();
                            ((zzai)object6).zzb();
                            object6 = this.zzi();
                            object5 = zzp3.zza;
                            object4 = "_npa";
                            object4 = ((zzai)object6).zzk((String)object5, (String)object4);
                            if (object4 != null && (n11 = ((String)(object6 = "auto")).equals(object5 = ((zzki)object4).zzb)) == 0) {
                                stringArray2 = object13;
                                bl2 = false;
                                object13 = null;
                            } else {
                                object6 = zzp3.zzr;
                                if (object6 != null) {
                                    stringArray2 = "_npa";
                                    n11 = ((Boolean)object6).booleanValue();
                                    long l17 = n12 != n11 ? l15 : 1L;
                                    stringArray = l17;
                                    String string4 = "auto";
                                    l15 = 1L;
                                    object6 = object5;
                                    stringArray3 = object5;
                                    object5 = stringArray2;
                                    stringArray2 = object13;
                                    object3 = object4;
                                    bl2 = false;
                                    object13 = null;
                                    l13 = l14;
                                    l12 = stringArray;
                                    string2 = string4;
                                    ((zzkg)object6)((String)object5, l14, stringArray, string4);
                                    if (object4 == null || !(bl3 = (object3 = ((zzki)object4).zze).equals(object6 = ((zzkg)object6).zzd))) {
                                        zzkd2.zzN((zzkg)stringArray3, zzp3);
                                    }
                                } else {
                                    stringArray2 = object13;
                                    object3 = object4;
                                    bl2 = false;
                                    object13 = null;
                                    if (object4 != null) {
                                        object5 = "_npa";
                                        l12 = null;
                                        string2 = "auto";
                                        object6 = stringArray3;
                                        l13 = l14;
                                        stringArray3 = new zzkg((String)object5, l14, null, string2);
                                        zzkd2.zzO((zzkg)stringArray3, zzp3);
                                    }
                                }
                            }
                            stringArray3 = this.zzi();
                            object3 = zzp3.zza;
                            stringArray3 = stringArray3.zzs((String)object3);
                            if (stringArray3 != null) {
                                object6 = zzkd2.zzl;
                                bl3 = ((zzkk)(object6 = ((zzfl)object6).zzl())).zzB((String)(object5 = zzp3.zzb), (String)(object2 = stringArray3.zzf()), (String)(object4 = zzp3.zzq), (String)(object3 = stringArray3.zzh()));
                                if (bl3) {
                                    object3 = zzkd2.zzl;
                                    object3 = ((zzfl)object3).zzat();
                                    object3 = ((zzei)object3).zze();
                                    object6 = "New GMP App Id passed in. Removing cached database data. appId";
                                    object5 = stringArray3.zzc();
                                    object5 = zzei.zzl((String)object5);
                                    ((zzeg)object3).zzb((String)object6, object5);
                                    object3 = this.zzi();
                                    stringArray3 = stringArray3.zzc();
                                    ((zzjv)object3).zzX();
                                    ((zzge)object3).zzg();
                                    Preconditions.checkNotEmpty((String)stringArray3);
                                    try {
                                        object6 = ((zzai)object3).zze();
                                        n10 = 1;
                                        object2 = new String[n10];
                                        object2[0] = stringArray3;
                                        object5 = "events";
                                        n10 = object6.delete((String)object5, (String)object9, object2);
                                        object4 = "user_attributes";
                                        int n13 = object6.delete((String)object4, (String)object9, object2);
                                        n10 += n13;
                                        object4 = "conditional_properties";
                                        n13 = object6.delete((String)object4, (String)object9, object2);
                                        n10 += n13;
                                        object4 = "apps";
                                        n13 = object6.delete((String)object4, (String)object9, object2);
                                        n10 += n13;
                                        object4 = "raw_events";
                                        n13 = object6.delete((String)object4, (String)object9, object2);
                                        n10 += n13;
                                        object4 = "raw_events_metadata";
                                        n13 = object6.delete((String)object4, (String)object9, object2);
                                        n10 += n13;
                                        object4 = "event_filters";
                                        n13 = object6.delete((String)object4, (String)object9, object2);
                                        n10 += n13;
                                        object4 = "property_filters";
                                        n13 = object6.delete((String)object4, (String)object9, object2);
                                        n10 += n13;
                                        object4 = "audience_filter_values";
                                        n13 = object6.delete((String)object4, (String)object9, object2);
                                        n10 += n13;
                                        object4 = "consent_settings";
                                        object = object6.delete((String)object4, (String)object9, object2);
                                        if ((n10 += object) > 0) {
                                            object9 = ((zzge)object3).zzx;
                                            object9 = ((zzfl)object9).zzat();
                                            object9 = ((zzei)object9).zzk();
                                            object6 = "Deleted application data. app, records";
                                            object5 = n10;
                                            ((zzeg)object9).zzc((String)object6, stringArray3, object5);
                                        }
                                    }
                                    catch (SQLiteException sQLiteException) {
                                        object3 = ((zzge)object3).zzx;
                                        object3 = ((zzfl)object3).zzat();
                                        object3 = ((zzei)object3).zzb();
                                        object6 = "Error deleting application data. appId, error";
                                        stringArray3 = zzei.zzl((String)stringArray3);
                                        ((zzeg)object3).zzc((String)object6, stringArray3, (Object)sQLiteException);
                                    }
                                    stringArray3 = null;
                                }
                            }
                            if (stringArray3 == null) break block52;
                            l11 = stringArray3.zzv();
                            long l18 = l11 - (l13 = 0x80000000L);
                            object = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
                            if (object == false) break block53;
                            l11 = stringArray3.zzv();
                            object3 = object12;
                            l10 = zzp3.zzj;
                            long l19 = l11 - l10;
                            object = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
                            if (object == false) break block54;
                            object = 1;
                            break block55;
                        }
                        object3 = object12;
                    }
                    object = 0;
                    object9 = null;
                }
                l10 = stringArray3.zzv();
                bl2 = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1);
                if (!bl2 && (object13 = stringArray3.zzt()) != null && !(bl2 = ((String)(object13 = stringArray3.zzt())).equals(object12 = zzp3.zzc))) {
                    n12 = 1;
                } else {
                    n12 = 0;
                    object2 = null;
                }
                object = object | n12;
                if (object != false) {
                    object9 = new Bundle();
                    object13 = "_pv";
                    object12 = stringArray3.zzt();
                    object9.putString((String)object13, (String)object12);
                    object5 = "_au";
                    object2 = new zzaq((Bundle)object9);
                    object4 = "auto";
                    object6 = object13;
                    object13 = new zzas((String)object5, (zzaq)object2, (String)object4, l14);
                    zzkd2.zzB((zzas)object13, zzp3);
                }
                break block56;
            }
            object3 = object12;
        }
        this.zzX(zzp2);
        if (object7 == 0) {
            object9 = this.zzi();
            object13 = zzp3.zza;
            object12 = "_f";
            object9 = ((zzai)object9).zzf((String)object13, (String)object12);
            n12 = 0;
            object2 = null;
        } else {
            object9 = this.zzi();
            object13 = zzp3.zza;
            object12 = "_v";
            object9 = ((zzai)object9).zzf((String)object13, (String)object12);
            n12 = 1;
        }
        if (object9 == null) {
            l10 = 3600000L;
            long l20 = l14 / l10;
            l11 = 1L;
            l20 = (l20 + l11) * l10;
            object9 = "_dac";
            object13 = "_r";
            object12 = "_c";
            object4 = "_et";
            if (n12 == 0) {
                object5 = "_fot";
                l12 = l20;
                string2 = "auto";
                object6 = object2;
                object8 = object2;
                stringArray3 = object4;
                l13 = l14;
                object2 = new zzkg((String)object5, l14, l12, string2);
                zzkd2.zzN((zzkg)object2, zzp3);
                object8 = zzkd2.zzl;
                object8 = ((zzfl)object8).zzau();
                ((zzge)object8).zzg();
                object8 = zzkd2.zzl;
                object8 = ((zzfl)object8).zzi();
                object6 = zzp3.zza;
                ((zzfa)object8).zza((String)object6);
                object8 = zzkd2.zzl;
                object8 = ((zzfl)object8).zzau();
                ((zzge)object8).zzg();
                this.zzs();
                object8 = new Bundle();
                l11 = 1L;
                object8.putLong((String)object12, l11);
                object8.putLong((String)object13, l11);
                l10 = 0L;
                object8.putLong((String)object10, l10);
                object8.putLong((String)object11, l10);
                object8.putLong((String)object3, l10);
                object2 = stringArray2;
                object8.putLong((String)stringArray2, l10);
                l10 = 1L;
                object8.putLong((String)object4, l10);
                n11 = (int)(zzp3.zzp ? 1 : 0);
                if (n11 != 0) {
                    object8.putLong((String)object9, l10);
                }
                object9 = this.zzi();
                object13 = zzp3.zza;
                Preconditions.checkNotEmpty((String)object13);
                ((zzge)object9).zzg();
                ((zzjv)object9).zzX();
                object12 = "first_open_count";
                l10 = ((zzai)object9).zzC((String)object13, (String)object12);
                object9 = zzkd2.zzl;
                object9 = ((zzfl)object9).zzaw();
                object9 = object9.getPackageManager();
                if (object9 == null) {
                    object9 = zzkd2.zzl;
                    object9 = ((zzfl)object9).zzat();
                    object9 = ((zzei)object9).zzb();
                    object10 = "PackageManager is null, first open report might be inaccurate. appId";
                    object3 = zzp3.zza;
                    object3 = zzei.zzl((String)object3);
                    ((zzeg)object9).zzb((String)object10, object3);
                    stringArray = stringArray3;
                } else {
                    long l21;
                    long l22;
                    long l23;
                    try {
                        object9 = zzkd2.zzl;
                        object9 = ((zzfl)object9).zzaw();
                        object9 = Wrappers.packageManager((Context)object9);
                        object6 = zzp3.zza;
                        n10 = 0;
                        object5 = null;
                        object9 = ((PackageManagerWrapper)object9).getPackageInfo((String)object6, 0);
                    }
                    catch (PackageManager.NameNotFoundException nameNotFoundException) {
                        object6 = zzkd2.zzl;
                        object6 = ((zzfl)object6).zzat();
                        object6 = ((zzei)object6).zzb();
                        object5 = "Package info is null, first open report might be inaccurate. appId";
                        object4 = zzp3.zza;
                        object4 = zzei.zzl((String)object4);
                        ((zzeg)object6).zzc((String)object5, object4, (Object)nameNotFoundException);
                        object = 0;
                        object9 = null;
                    }
                    if (object9 != null && (l23 = (l22 = (l11 = ((PackageInfo)object9).firstInstallTime) - (l21 = 0L)) == 0L ? 0 : (l22 < 0L ? -1 : 1)) != false) {
                        stringArray2 = object2;
                        l13 = ((PackageInfo)object9).lastUpdateTime;
                        long l24 = l11 - l13;
                        object = l24 == 0L ? 0 : (l24 < 0L ? -1 : 1);
                        if (object != false) {
                            object9 = zzkd2.zzl;
                            object9 = ((zzfl)object9).zzc();
                            object6 = zzdw.zzal;
                            n12 = 0;
                            object2 = null;
                            object = ((zzae)object9).zzn(null, (zzdv)object6);
                            if (object != false) {
                                l11 = 0L;
                                long l25 = l10 - l11;
                                object = l25 == 0L ? 0 : (l25 < 0L ? -1 : 1);
                                if (object == false) {
                                    l11 = 1L;
                                    object8.putLong((String)object10, l11);
                                }
                            } else {
                                l11 = 1L;
                                object8.putLong((String)object10, l11);
                            }
                            object = 0;
                            object9 = null;
                        } else {
                            n12 = 0;
                            object2 = null;
                            object = 1;
                        }
                        object5 = "_fi";
                        n11 = 1;
                        l21 = n11 != object ? 0L : 1L;
                        l12 = l21;
                        string2 = "auto";
                        object6 = object10;
                        stringArray = stringArray3;
                        stringArray3 = stringArray2;
                        stringArray2 = null;
                        l13 = l14;
                        object10 = new zzkg((String)object5, l14, l12, string2);
                        zzkd2.zzN((zzkg)object10, zzp3);
                    } else {
                        stringArray = stringArray3;
                        stringArray3 = object2;
                        stringArray2 = null;
                    }
                    try {
                        object9 = zzkd2.zzl;
                        object9 = ((zzfl)object9).zzaw();
                        object9 = Wrappers.packageManager((Context)object9);
                        object10 = zzp3.zza;
                        n11 = 0;
                        object6 = null;
                        object9 = ((PackageManagerWrapper)object9).getApplicationInfo((String)object10, 0);
                    }
                    catch (PackageManager.NameNotFoundException nameNotFoundException) {
                        object10 = zzkd2.zzl;
                        object10 = ((zzfl)object10).zzat();
                        object10 = ((zzei)object10).zzb();
                        object6 = "Application info is null, first open report might be inaccurate. appId";
                        object5 = zzp3.zza;
                        object5 = zzei.zzl((String)object5);
                        ((zzeg)object10).zzc((String)object6, object5, (Object)nameNotFoundException);
                        object = 0;
                        object9 = null;
                    }
                    if (object9 != null) {
                        int n14 = ((ApplicationInfo)object9).flags;
                        n11 = 1;
                        if ((n14 &= n11) != 0) {
                            l11 = 1L;
                            object8.putLong((String)object3, l11);
                        }
                        if ((object = (Object)(((ApplicationInfo)object9).flags & 0x80)) != false) {
                            l11 = 1L;
                            object8.putLong((String)stringArray3, l11);
                        }
                    }
                }
                l15 = 0L;
                object = l10 == l15 ? 0 : (l10 < l15 ? -1 : 1);
                if (object >= 0) {
                    object8.putLong((String)object11, l10);
                }
                object5 = "_f";
                object2 = new zzaq((Bundle)object8);
                object4 = "auto";
                object6 = object9;
                object9 = new zzas((String)object5, (zzaq)object2, (String)object4, l14);
                zzkd2.zzA((zzas)object9, zzp3);
                object11 = stringArray;
            } else {
                object11 = object4;
                object5 = "_fvt";
                l12 = l20;
                string2 = "auto";
                object6 = object10;
                l13 = l14;
                object10 = new zzkg((String)object5, l14, l12, string2);
                zzkd2.zzN((zzkg)object10, zzp3);
                object10 = zzkd2.zzl;
                object10 = ((zzfl)object10).zzau();
                ((zzge)object10).zzg();
                this.zzs();
                object10 = new Bundle();
                l20 = 1L;
                object10.putLong((String)object12, l20);
                object10.putLong((String)object13, l20);
                object10.putLong((String)object4, l20);
                bl2 = zzp3.zzp;
                if (bl2) {
                    object10.putLong((String)object9, l20);
                }
                object5 = "_v";
                object2 = new zzaq((Bundle)object10);
                object4 = "auto";
                object6 = object9;
                object9 = new zzas((String)object5, (zzaq)object2, (String)object4, l14);
                zzkd2.zzA((zzas)object9, zzp3);
            }
            object9 = zzkd2.zzl;
            object9 = ((zzfl)object9).zzc();
            object13 = zzp3.zza;
            object12 = zzdw.zzT;
            object = ((zzae)object9).zzn((String)object13, (zzdv)object12);
            if (object == false) {
                object9 = new Bundle();
                l10 = 1L;
                object9.putLong((String)object11, l10);
                object11 = "_fr";
                object9.putLong((String)object11, l10);
                object5 = "_e";
                object2 = new zzaq((Bundle)object9);
                object4 = "auto";
                object6 = object13;
                object13 = new zzas((String)object5, (zzaq)object2, (String)object4, l14);
                zzkd2.zzA((zzas)object13, zzp3);
            }
        } else {
            object = zzp3.zzi;
            if (object != false) {
                object9 = new Bundle();
                object5 = "_cd";
                object2 = new zzaq((Bundle)object9);
                object4 = "auto";
                object6 = object13;
                object13 = new zzas((String)object5, (zzaq)object2, (String)object4, l14);
                zzkd2.zzA((zzas)object13, zzp3);
            }
        }
        object9 = this.zzi();
        ((zzai)object9).zzc();
        return;
    }

    public final void zzT(zzaa zzaa2) {
        Object object = zzaa2.zza;
        if ((object = this.zzam((String)object)) != null) {
            this.zzU(zzaa2, (zzp)object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zzU(zzaa object, zzp object2) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotEmpty(((zzaa)object).zza);
        Preconditions.checkNotNull(((zzaa)object).zzb);
        Preconditions.checkNotNull(((zzaa)object).zzc);
        Preconditions.checkNotEmpty(object.zzc.zzb);
        Object object3 = this.zzl.zzau();
        ((zzge)object3).zzg();
        this.zzs();
        boolean bl2 = this.zzan((zzp)object2);
        if (!bl2) {
            return;
        }
        bl2 = ((zzp)object2).zzh;
        if (!bl2) {
            this.zzX((zzp)object2);
            return;
        }
        object3 = new zzaa((zzaa)object);
        boolean bl3 = false;
        object = null;
        ((zzaa)object3).zze = false;
        Object object4 = this.zzi();
        ((zzai)object4).zzb();
        try {
            boolean bl4;
            Object object5;
            Object object6;
            long l10;
            boolean bl5;
            Object object7;
            Object object8;
            boolean bl6;
            object4 = this.zzi();
            Object object9 = ((zzaa)object3).zza;
            Object object10 = ((zzaa)object3).zzc;
            object10 = ((zzkg)object10).zzb;
            object4 = ((zzai)object4).zzo((String)object9, (String)object10);
            if (object4 != null && !(bl6 = ((String)(object9 = ((zzaa)object4).zzb)).equals(object10 = ((zzaa)object3).zzb))) {
                object9 = this.zzl;
                object9 = ((zzfl)object9).zzat();
                object9 = ((zzei)object9).zze();
                object10 = "Updating a conditional user property with different origin. name, origin, origin (from DB)";
                object8 = this.zzl;
                object8 = ((zzfl)object8).zzm();
                object7 = ((zzaa)object3).zzc;
                object7 = ((zzkg)object7).zzb;
                object8 = ((zzed)object8).zze((String)object7);
                object7 = ((zzaa)object3).zzb;
                String string2 = ((zzaa)object4).zzb;
                ((zzeg)object9).zzd((String)object10, object8, object7, string2);
            }
            bl6 = true;
            if (object4 != null && (bl5 = ((zzaa)object4).zze)) {
                long l11;
                ((zzaa)object3).zzb = object10 = ((zzaa)object4).zzb;
                ((zzaa)object3).zzd = l11 = ((zzaa)object4).zzd;
                ((zzaa)object3).zzh = l11 = ((zzaa)object4).zzh;
                ((zzaa)object3).zzf = object10 = ((zzaa)object4).zzf;
                ((zzaa)object3).zzi = object10 = ((zzaa)object4).zzi;
                ((zzaa)object3).zze = bl6;
                object10 = ((zzaa)object3).zzc;
                object7 = ((zzkg)object10).zzb;
                object8 = ((zzaa)object4).zzc;
                l10 = ((zzkg)object8).zzc;
                object6 = ((zzkg)object10).zza();
                object4 = ((zzaa)object4).zzc;
                object5 = ((zzkg)object4).zzf;
                object8 = object9;
                ((zzaa)object3).zzc = object9 = new zzkg((String)object7, l10, object6, (String)object5);
            } else {
                object4 = ((zzaa)object3).zzf;
                bl4 = TextUtils.isEmpty((CharSequence)object4);
                if (bl4) {
                    object4 = ((zzaa)object3).zzc;
                    object8 = ((zzkg)object4).zzb;
                    long l12 = ((zzaa)object3).zzd;
                    Object object11 = ((zzkg)object4).zza();
                    object4 = ((zzaa)object3).zzc;
                    object6 = ((zzkg)object4).zzf;
                    object10 = object;
                    ((zzaa)object3).zzc = object = new zzkg((String)object8, l12, object11, (String)object6);
                    ((zzaa)object3).zze = bl6;
                    bl3 = bl6;
                }
            }
            bl4 = ((zzaa)object3).zze;
            if (bl4) {
                object4 = ((zzaa)object3).zzc;
                object10 = ((zzaa)object3).zza;
                object8 = ((zzaa)object3).zzb;
                object7 = ((zzkg)object4).zzb;
                l10 = ((zzkg)object4).zzc;
                object6 = ((zzkg)object4).zza();
                object9 = object5;
                object5 = new zzki((String)object10, (String)object8, (String)object7, l10, object6);
                object4 = this.zzi();
                bl4 = ((zzai)object4).zzj((zzki)object5);
                if (bl4) {
                    object4 = this.zzl;
                    object4 = ((zzfl)object4).zzat();
                    object4 = ((zzei)object4).zzj();
                    object9 = "User property updated immediately";
                    object10 = ((zzaa)object3).zza;
                    object8 = this.zzl;
                    object8 = ((zzfl)object8).zzm();
                    object7 = ((zzki)object5).zzc;
                    object8 = ((zzed)object8).zze((String)object7);
                    object7 = ((zzki)object5).zze;
                    ((zzeg)object4).zzd((String)object9, object10, object8, object7);
                } else {
                    object4 = this.zzl;
                    object4 = ((zzfl)object4).zzat();
                    object4 = ((zzei)object4).zzb();
                    object9 = "(2)Too many active user properties, ignoring";
                    object10 = ((zzaa)object3).zza;
                    object10 = zzei.zzl((String)object10);
                    object8 = this.zzl;
                    object8 = ((zzfl)object8).zzm();
                    object7 = ((zzki)object5).zzc;
                    object8 = ((zzed)object8).zze((String)object7);
                    object7 = ((zzki)object5).zze;
                    ((zzeg)object4).zzd((String)object9, object10, object8, object7);
                }
                if (bl3 && (object = ((zzaa)object3).zzi) != null) {
                    long l13 = ((zzaa)object3).zzd;
                    object4 = new zzas((zzas)object, l13);
                    this.zzC((zzas)object4, (zzp)object2);
                }
            }
            if (bl3 = ((zzai)(object = this.zzi())).zzn((zzaa)object3)) {
                object = this.zzl;
                object = ((zzfl)object).zzat();
                object = ((zzei)object).zzj();
                object2 = "Conditional property added";
                object4 = ((zzaa)object3).zza;
                object9 = this.zzl;
                object9 = ((zzfl)object9).zzm();
                object10 = ((zzaa)object3).zzc;
                object10 = ((zzkg)object10).zzb;
                object9 = ((zzed)object9).zze((String)object10);
                object3 = ((zzaa)object3).zzc;
                object3 = ((zzkg)object3).zza();
                ((zzeg)object).zzd((String)object2, object4, object9, object3);
            } else {
                object = this.zzl;
                object = ((zzfl)object).zzat();
                object = ((zzei)object).zzb();
                object2 = "Too many conditional properties, ignoring";
                object4 = ((zzaa)object3).zza;
                object4 = zzei.zzl((String)object4);
                object9 = this.zzl;
                object9 = ((zzfl)object9).zzm();
                object10 = ((zzaa)object3).zzc;
                object10 = ((zzkg)object10).zzb;
                object9 = ((zzed)object9).zze((String)object10);
                object3 = ((zzaa)object3).zzc;
                object3 = ((zzkg)object3).zza();
                ((zzeg)object).zzd((String)object2, object4, object9, object3);
            }
            object = this.zzi();
            ((zzai)object).zzc();
            return;
        }
        finally {
            this.zzi().zzd();
        }
    }

    public final void zzV(zzaa zzaa2) {
        Object object = zzaa2.zza;
        if ((object = this.zzam((String)object)) != null) {
            this.zzW(zzaa2, (zzp)object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zzW(zzaa object, zzp object2) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotEmpty(((zzaa)object).zza);
        Preconditions.checkNotNull(((zzaa)object).zzc);
        Preconditions.checkNotEmpty(object.zzc.zzb);
        Object object3 = this.zzl.zzau();
        ((zzge)object3).zzg();
        this.zzs();
        boolean bl2 = this.zzan((zzp)object2);
        if (!bl2) {
            return;
        }
        bl2 = ((zzp)object2).zzh;
        if (!bl2) {
            this.zzX((zzp)object2);
            return;
        }
        object3 = this.zzi();
        ((zzai)object3).zzb();
        try {
            this.zzX((zzp)object2);
            object3 = this.zzi();
            Object object4 = ((zzaa)object).zza;
            Object object5 = ((zzaa)object).zzc;
            object5 = ((zzkg)object5).zzb;
            object3 = ((zzai)object3).zzo((String)object4, (String)object5);
            if (object3 != null) {
                object4 = this.zzl;
                object4 = ((zzfl)object4).zzat();
                object4 = ((zzei)object4).zzj();
                object5 = "Removing conditional user property";
                Object object6 = ((zzaa)object).zza;
                Object object7 = this.zzl;
                object7 = ((zzfl)object7).zzm();
                Object object8 = ((zzaa)object).zzc;
                object8 = ((zzkg)object8).zzb;
                object7 = ((zzed)object7).zze((String)object8);
                ((zzeg)object4).zzc((String)object5, object6, object7);
                object4 = this.zzi();
                object5 = ((zzaa)object).zza;
                object6 = ((zzaa)object).zzc;
                object6 = ((zzkg)object6).zzb;
                ((zzai)object4).zzp((String)object5, (String)object6);
                boolean bl3 = ((zzaa)object3).zze;
                if (bl3) {
                    object4 = this.zzi();
                    object5 = ((zzaa)object).zza;
                    object6 = ((zzaa)object).zzc;
                    object6 = ((zzkg)object6).zzb;
                    ((zzai)object4).zzi((String)object5, (String)object6);
                }
                if ((object4 = ((zzaa)object).zzk) != null) {
                    object4 = ((zzas)object4).zzb;
                    if (object4 != null) {
                        object4 = ((zzaq)object4).zzf();
                    } else {
                        bl3 = false;
                        object4 = null;
                    }
                    object8 = object4;
                    object4 = this.zzl;
                    object5 = ((zzfl)object4).zzl();
                    object6 = ((zzaa)object).zza;
                    object = ((zzaa)object).zzk;
                    object7 = ((zzas)object).zza;
                    String string2 = ((zzaa)object3).zzb;
                    long l10 = ((zzas)object).zzd;
                    boolean bl4 = true;
                    object = ((zzkk)object5).zzV((String)object6, (String)object7, (Bundle)object8, string2, l10, bl4, false);
                    this.zzC((zzas)object, (zzp)object2);
                }
            } else {
                object2 = this.zzl;
                object2 = ((zzfl)object2).zzat();
                object2 = ((zzei)object2).zze();
                object3 = "Conditional user property doesn't exist";
                object4 = ((zzaa)object).zza;
                object4 = zzei.zzl((String)object4);
                object5 = this.zzl;
                object5 = ((zzfl)object5).zzm();
                object = ((zzaa)object).zzc;
                object = ((zzkg)object).zzb;
                object = ((zzed)object5).zze((String)object);
                ((zzeg)object2).zzc((String)object3, object4, object);
            }
            object = this.zzi();
            ((zzai)object).zzc();
            return;
        }
        finally {
            this.zzi().zzd();
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public final zzg zzX(zzp object) {
        Object object2;
        block63: {
            block62: {
                boolean bl2;
                block61: {
                    long l10;
                    long l11;
                    long l12;
                    long l13;
                    long l14;
                    long l15;
                    long l16;
                    long l17;
                    long l18;
                    long l19;
                    boolean bl3;
                    boolean bl4;
                    float f10;
                    float f11;
                    long l20;
                    Object object3;
                    boolean bl5;
                    Object object4;
                    Object object5;
                    block60: {
                        block58: {
                            block59: {
                                Object object6;
                                block57: {
                                    block55: {
                                        long l21;
                                        long l22;
                                        long l23;
                                        boolean bl6;
                                        block54: {
                                            block56: {
                                                Object object7;
                                                ((zzge)this.zzl.zzau()).zzg();
                                                this.zzs();
                                                Preconditions.checkNotNull(object);
                                                Preconditions.checkNotEmpty(((zzp)object).zza);
                                                object2 = this.zzi();
                                                object5 = ((zzp)object).zza;
                                                object2 = ((zzai)object2).zzs((String)object5);
                                                object5 = zzaf.zza;
                                                zzlc.zzb();
                                                object6 = this.zzl.zzc();
                                                object4 = zzdw.zzay;
                                                bl5 = ((zzae)object6).zzn(null, (zzdv)object4);
                                                if (bl5) {
                                                    object6 = ((zzp)object).zza;
                                                    object6 = this.zzx((String)object6);
                                                    object3 = zzaf.zzc(((zzp)object).zzv);
                                                    object6 = ((zzaf)object6).zzk((zzaf)object3);
                                                } else {
                                                    object6 = object5;
                                                }
                                                zzlc.zzb();
                                                object3 = this.zzl.zzc();
                                                boolean bl7 = ((zzae)object3).zzn(null, (zzdv)object4);
                                                if (bl7 && !(bl7 = ((zzaf)object6).zzf())) {
                                                    object3 = "";
                                                } else {
                                                    object3 = this.zzk;
                                                    object7 = ((zzp)object).zza;
                                                    object3 = ((zzjc)object3).zzf((String)object7);
                                                }
                                                zzlu.zzb();
                                                object7 = this.zzl.zzc();
                                                zzdv zzdv2 = zzdw.zzam;
                                                bl2 = ((zzae)object7).zzn(null, zzdv2);
                                                l20 = 0L;
                                                if (!bl2) break block55;
                                                if (object2 != null) break block56;
                                                object5 = this.zzl;
                                                object7 = ((zzp)object).zza;
                                                object2 = new zzg((zzfl)object5, (String)object7);
                                                zzlc.zzb();
                                                object5 = this.zzl.zzc();
                                                bl6 = ((zzae)object5).zzn(null, (zzdv)object4);
                                                if (bl6) {
                                                    bl6 = ((zzaf)object6).zzh();
                                                    if (bl6) {
                                                        object5 = this.zzD((zzaf)object6);
                                                        ((zzg)object2).zze((String)object5);
                                                    }
                                                    if (bl6 = ((zzaf)object6).zzf()) {
                                                        ((zzg)object2).zzm((String)object3);
                                                    }
                                                    break block54;
                                                } else {
                                                    object5 = this.zzE();
                                                    ((zzg)object2).zze((String)object5);
                                                    ((zzg)object2).zzm((String)object3);
                                                }
                                                break block54;
                                            }
                                            zzlc.zzb();
                                            object5 = this.zzl.zzc();
                                            bl6 = ((zzae)object5).zzn(null, (zzdv)object4);
                                            if (!(bl6 && !(bl6 = ((zzaf)object6).zzf()) || (bl6 = ((String)object3).equals(object5 = ((zzg)object2).zzl())))) {
                                                ((zzg)object2).zzm((String)object3);
                                                zzlc.zzb();
                                                object5 = this.zzl.zzc();
                                                bl6 = ((zzae)object5).zzn(null, (zzdv)object4);
                                                if (bl6) {
                                                    object5 = this.zzD((zzaf)object6);
                                                    ((zzg)object2).zze((String)object5);
                                                } else {
                                                    object5 = this.zzE();
                                                    ((zzg)object2).zze((String)object5);
                                                }
                                            } else {
                                                zzlc.zzb();
                                                object5 = this.zzl.zzc();
                                                bl6 = ((zzae)object5).zzn(null, (zzdv)object4);
                                                if (bl6 && (bl6 = TextUtils.isEmpty((CharSequence)(object5 = ((zzg)object2).zzd()))) && (bl6 = ((zzaf)object6).zzh())) {
                                                    object5 = this.zzD((zzaf)object6);
                                                    ((zzg)object2).zze((String)object5);
                                                }
                                            }
                                        }
                                        object5 = ((zzp)object).zzb;
                                        ((zzg)object2).zzg((String)object5);
                                        object5 = ((zzp)object).zzq;
                                        ((zzg)object2).zzi((String)object5);
                                        zzmg.zzb();
                                        object5 = this.zzl.zzc();
                                        object6 = ((zzg)object2).zzc();
                                        object4 = zzdw.zzah;
                                        bl6 = ((zzae)object5).zzn((String)object6, (zzdv)object4);
                                        if (bl6) {
                                            object5 = ((zzp)object).zzu;
                                            ((zzg)object2).zzk((String)object5);
                                        }
                                        if (!(bl6 = TextUtils.isEmpty((CharSequence)(object5 = ((zzp)object).zzk)))) {
                                            object5 = ((zzp)object).zzk;
                                            ((zzg)object2).zzo((String)object5);
                                        }
                                        if ((l23 = (l22 = (l21 = ((zzp)object).zze) - l20) == 0L ? 0 : (l22 < 0L ? -1 : 1)) != false) {
                                            ((zzg)object2).zzA(l21);
                                        }
                                        if (!(bl6 = TextUtils.isEmpty((CharSequence)(object5 = ((zzp)object).zzc)))) {
                                            object5 = ((zzp)object).zzc;
                                            ((zzg)object2).zzu((String)object5);
                                        }
                                        l21 = ((zzp)object).zzj;
                                        ((zzg)object2).zzw(l21);
                                        object5 = ((zzp)object).zzd;
                                        if (object5 != null) {
                                            ((zzg)object2).zzy((String)object5);
                                        }
                                        l21 = ((zzp)object).zzf;
                                        ((zzg)object2).zzC(l21);
                                        bl6 = ((zzp)object).zzh;
                                        ((zzg)object2).zzG(bl6);
                                        object5 = ((zzp)object).zzg;
                                        bl6 = TextUtils.isEmpty((CharSequence)object5);
                                        if (!bl6) {
                                            object5 = ((zzp)object).zzg;
                                            ((zzg)object2).zzac((String)object5);
                                        }
                                        if (!(bl6 = ((zzae)(object5 = this.zzl.zzc())).zzn(null, (zzdv)(object6 = zzdw.zzav)))) {
                                            l21 = ((zzp)object).zzl;
                                            ((zzg)object2).zzae(l21);
                                        }
                                        bl6 = ((zzp)object).zzo;
                                        ((zzg)object2).zzag(bl6);
                                        object5 = ((zzp)object).zzr;
                                        ((zzg)object2).zzai((Boolean)object5);
                                        l21 = ((zzp)object).zzs;
                                        ((zzg)object2).zzE(l21);
                                        boolean bl8 = ((zzg)object2).zza();
                                        if (bl8) {
                                            object = this.zzi();
                                            ((zzai)object).zzt((zzg)object2);
                                        }
                                        return object2;
                                    }
                                    zzlc.zzb();
                                    object6 = this.zzl.zzc();
                                    bl5 = ((zzae)object6).zzn(null, (zzdv)object4);
                                    if (bl5) {
                                        object5 = ((zzp)object).zza;
                                        object5 = this.zzx((String)object5);
                                        object6 = zzaf.zzc(((zzp)object).zzv);
                                        object5 = ((zzaf)object5).zzk((zzaf)object6);
                                    }
                                    bl5 = false;
                                    f11 = 0.0f;
                                    object6 = null;
                                    bl2 = true;
                                    f10 = Float.MIN_VALUE;
                                    if (object2 != null) break block57;
                                    object6 = this.zzl;
                                    String string2 = ((zzp)object).zza;
                                    object2 = new zzg((zzfl)object6, string2);
                                    zzlc.zzb();
                                    object6 = this.zzl.zzc();
                                    bl5 = ((zzae)object6).zzn(null, (zzdv)object4);
                                    if (bl5) {
                                        bl5 = ((zzaf)object5).zzh();
                                        if (bl5) {
                                            object6 = this.zzD((zzaf)object5);
                                            ((zzg)object2).zze((String)object6);
                                        }
                                        if (bl4 = ((zzaf)object5).zzf()) {
                                            ((zzg)object2).zzm((String)object3);
                                        }
                                        break block58;
                                    } else {
                                        object5 = this.zzE();
                                        ((zzg)object2).zze((String)object5);
                                        ((zzg)object2).zzm((String)object3);
                                    }
                                    break block58;
                                }
                                zzlc.zzb();
                                Object object8 = this.zzl.zzc();
                                boolean bl9 = ((zzae)object8).zzn(null, (zzdv)object4);
                                if (bl9 && !(bl9 = ((zzaf)object5).zzf()) || (bl9 = ((String)object3).equals(object8 = ((zzg)object2).zzl()))) break block59;
                                ((zzg)object2).zzm((String)object3);
                                zzlc.zzb();
                                object6 = this.zzl.zzc();
                                bl5 = ((zzae)object6).zzn(null, (zzdv)object4);
                                if (bl5) {
                                    bl5 = ((zzaf)object5).zzh();
                                    if (bl5) {
                                        object5 = this.zzD((zzaf)object5);
                                        ((zzg)object2).zze((String)object5);
                                    }
                                    break block58;
                                } else {
                                    object5 = this.zzE();
                                    ((zzg)object2).zze((String)object5);
                                }
                                break block58;
                            }
                            zzlc.zzb();
                            object3 = this.zzl.zzc();
                            bl3 = ((zzae)object3).zzn(null, (zzdv)object4);
                            if (!bl3 || !(bl3 = TextUtils.isEmpty((CharSequence)(object4 = ((zzg)object2).zzd()))) || !(bl3 = ((zzaf)object5).zzh())) break block60;
                            object5 = this.zzD((zzaf)object5);
                            ((zzg)object2).zze((String)object5);
                        }
                        bl5 = bl2;
                        f11 = f10;
                    }
                    if (!(bl4 = TextUtils.equals((CharSequence)(object5 = ((zzp)object).zzb), (CharSequence)(object4 = ((zzg)object2).zzf())))) {
                        object5 = ((zzp)object).zzb;
                        ((zzg)object2).zzg((String)object5);
                        bl5 = bl2;
                        f11 = f10;
                    }
                    if (!(bl4 = TextUtils.equals((CharSequence)(object5 = ((zzp)object).zzq), (CharSequence)(object4 = ((zzg)object2).zzh())))) {
                        object5 = ((zzp)object).zzq;
                        ((zzg)object2).zzi((String)object5);
                        bl5 = bl2;
                        f11 = f10;
                    }
                    zzmg.zzb();
                    object5 = this.zzl.zzc();
                    object4 = ((zzg)object2).zzc();
                    object3 = zzdw.zzah;
                    bl4 = ((zzae)object5).zzn((String)object4, (zzdv)object3);
                    if (bl4 && !(bl4 = TextUtils.equals((CharSequence)(object5 = ((zzp)object).zzu), (CharSequence)(object4 = ((zzg)object2).zzj())))) {
                        object5 = ((zzp)object).zzu;
                        ((zzg)object2).zzk((String)object5);
                        bl5 = bl2;
                        f11 = f10;
                    }
                    if (!(bl4 = TextUtils.isEmpty((CharSequence)(object5 = ((zzp)object).zzk))) && !(bl4 = ((String)(object5 = ((zzp)object).zzk)).equals(object4 = ((zzg)object2).zzn()))) {
                        object5 = ((zzp)object).zzk;
                        ((zzg)object2).zzo((String)object5);
                        bl5 = bl2;
                        f11 = f10;
                    }
                    if ((bl4 = (l19 = (l18 = ((zzp)object).zze) - l20) == 0L ? 0 : (l19 < 0L ? -1 : 1)) && (bl4 = (l17 = l18 - (l16 = ((zzg)object2).zzz())) == 0L ? 0 : (l17 < 0L ? -1 : 1))) {
                        l15 = ((zzp)object).zze;
                        ((zzg)object2).zzA(l15);
                        bl5 = bl2;
                        f11 = f10;
                    }
                    if (!(bl4 = TextUtils.isEmpty((CharSequence)(object5 = ((zzp)object).zzc))) && !(bl4 = ((String)(object5 = ((zzp)object).zzc)).equals(object4 = ((zzg)object2).zzt()))) {
                        object5 = ((zzp)object).zzc;
                        ((zzg)object2).zzu((String)object5);
                        bl5 = bl2;
                        f11 = f10;
                    }
                    if (bl4 = (l14 = (l18 = ((zzp)object).zzj) - (l16 = ((zzg)object2).zzv())) == 0L ? 0 : (l14 < 0L ? -1 : 1)) {
                        l15 = ((zzp)object).zzj;
                        ((zzg)object2).zzw(l15);
                        bl5 = bl2;
                        f11 = f10;
                    }
                    if ((object5 = ((zzp)object).zzd) != null && !(bl4 = ((String)object5).equals(object4 = ((zzg)object2).zzx()))) {
                        object5 = ((zzp)object).zzd;
                        ((zzg)object2).zzy((String)object5);
                        bl5 = bl2;
                        f11 = f10;
                    }
                    if (bl4 = (l13 = (l18 = ((zzp)object).zzf) - (l16 = ((zzg)object2).zzB())) == 0L ? 0 : (l13 < 0L ? -1 : 1)) {
                        l15 = ((zzp)object).zzf;
                        ((zzg)object2).zzC(l15);
                        bl5 = bl2;
                        f11 = f10;
                    }
                    if ((bl4 = ((zzp)object).zzh) != (bl3 = ((zzg)object2).zzF())) {
                        bl4 = ((zzp)object).zzh;
                        ((zzg)object2).zzG(bl4);
                        bl5 = bl2;
                        f11 = f10;
                    }
                    if (!(bl4 = TextUtils.isEmpty((CharSequence)(object5 = ((zzp)object).zzg))) && !(bl4 = ((String)(object5 = ((zzp)object).zzg)).equals(object4 = ((zzg)object2).zzaa()))) {
                        object5 = ((zzp)object).zzg;
                        ((zzg)object2).zzac((String)object5);
                        bl5 = bl2;
                        f11 = f10;
                    }
                    if (!(bl4 = ((zzae)(object5 = this.zzl.zzc())).zzn(null, (zzdv)(object4 = zzdw.zzav))) && (bl4 = (l12 = (l11 = ((zzp)object).zzl) - (l18 = ((zzg)object2).zzad())) == 0L ? 0 : (l12 < 0L ? -1 : 1))) {
                        l15 = ((zzp)object).zzl;
                        ((zzg)object2).zzae(l15);
                        bl5 = bl2;
                        f11 = f10;
                    }
                    if ((bl4 = ((zzp)object).zzo) != (bl3 = ((zzg)object2).zzaf())) {
                        bl4 = ((zzp)object).zzo;
                        ((zzg)object2).zzag(bl4);
                        bl5 = bl2;
                        f11 = f10;
                    }
                    if ((object5 = ((zzp)object).zzr) != (object4 = ((zzg)object2).zzah())) {
                        object5 = ((zzp)object).zzr;
                        ((zzg)object2).zzai((Boolean)object5);
                    } else {
                        bl2 = bl5;
                        f10 = f11;
                    }
                    l15 = ((zzp)object).zzs;
                    bl3 = l15 == l20 ? 0 : (l15 < l20 ? -1 : 1);
                    if (!bl3 || !(bl4 = (l10 = l15 - (l11 = ((zzg)object2).zzD())) == 0L ? 0 : (l10 < 0L ? -1 : 1))) break block61;
                    l15 = ((zzp)object).zzs;
                    ((zzg)object2).zzE(l15);
                    break block62;
                }
                if (!bl2) break block63;
            }
            object = this.zzi();
            ((zzai)object).zzt((zzg)object2);
        }
        return object2;
    }

    /*
     * WARNING - void declaration
     */
    public final String zzY(zzp object) {
        void var2_6;
        Object object2 = this.zzl.zzau();
        Object object3 = new zzjz(this, (zzp)object);
        object2 = ((zzfi)object2).zze((Callable)object3);
        long l10 = 30000L;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        object2 = object2.get(l10, timeUnit);
        try {
            return (String)object2;
        }
        catch (ExecutionException executionException) {
        }
        catch (InterruptedException interruptedException) {
        }
        catch (TimeoutException timeoutException) {
            // empty catch block
        }
        object3 = this.zzl.zzat().zzb();
        object = zzei.zzl(((zzp)object).zza);
        ((zzeg)object3).zzc("Failed to get app instance id. appId", object, var2_6);
        return null;
    }

    public final void zzZ(boolean bl2) {
        this.zzaj();
    }

    public final zzz zzas() {
        throw null;
    }

    public final zzei zzat() {
        return this.zzl.zzat();
    }

    public final zzfi zzau() {
        return this.zzl.zzau();
    }

    public final Context zzaw() {
        return this.zzl.zzaw();
    }

    public final Clock zzax() {
        return this.zzl.zzax();
    }

    public final void zzc() {
        ((zzge)this.zzl.zzau()).zzg();
        this.zzi().zzy();
        zzeu zzeu2 = this.zzl.zzd().zzc;
        long l10 = zzeu2.zza();
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false) {
            zzeu2 = this.zzl.zzd().zzc;
            Clock clock = this.zzl.zzax();
            long l13 = clock.currentTimeMillis();
            zzeu2.zzb(l13);
        }
        this.zzaj();
    }

    public final zzae zzd() {
        return this.zzl.zzc();
    }

    public final zzfc zzf() {
        zzkd.zzao(this.zzc);
        return this.zzc;
    }

    public final zzeo zzh() {
        zzkd.zzao(this.zzd);
        return this.zzd;
    }

    public final zzai zzi() {
        zzkd.zzao(this.zze);
        return this.zze;
    }

    public final zzeq zzj() {
        Object object = this.zzf;
        if (object != null) {
            return object;
        }
        object = new IllegalStateException("Network broadcast receiver not created");
        throw object;
    }

    public final zzjt zzk() {
        zzkd.zzao(this.zzg);
        return this.zzg;
    }

    public final zzy zzl() {
        zzkd.zzao(this.zzh);
        return this.zzh;
    }

    public final zzhs zzm() {
        zzkd.zzao(this.zzj);
        return this.zzj;
    }

    public final zzkf zzn() {
        zzkd.zzao(this.zzi);
        return this.zzi;
    }

    public final zzjc zzo() {
        return this.zzk;
    }

    public final zzed zzq() {
        return this.zzl.zzm();
    }

    public final zzkk zzr() {
        return this.zzl.zzl();
    }

    public final void zzs() {
        boolean bl2 = this.zzm;
        if (bl2) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("UploadController is not initialized");
        throw illegalStateException;
    }

    public final void zzt(zzp zzp2) {
        ((zzge)this.zzl.zzau()).zzg();
        this.zzs();
        Preconditions.checkNotEmpty(zzp2.zza);
        this.zzX(zzp2);
    }

    public final void zzu(zzp zzp2) {
        zzlc.zzb();
        Object object = this.zzl.zzc();
        Object object2 = zzdw.zzay;
        Object object3 = null;
        boolean bl2 = ((zzae)object).zzn(null, (zzdv)object2);
        if (bl2) {
            ((zzge)this.zzl.zzau()).zzg();
            this.zzs();
            Preconditions.checkNotEmpty(zzp2.zza);
            object = zzaf.zzc(zzp2.zzv);
            object2 = zzp2.zza;
            object2 = this.zzx((String)object2);
            object3 = this.zzl.zzat().zzk();
            String string2 = zzp2.zza;
            String string3 = "Setting consent, package, consent";
            ((zzeg)object3).zzc(string3, string2, object);
            object3 = zzp2.zza;
            this.zzv((String)object3, (zzaf)object);
            bl2 = ((zzaf)object).zzi((zzaf)object2);
            if (bl2) {
                this.zzM(zzp2);
            }
        }
    }

    public final void zzv(String object, zzaf object2) {
        block8: {
            zzlc.zzb();
            Object object3 = this.zzl.zzc();
            Object object4 = zzdw.zzay;
            Object object5 = null;
            boolean bl2 = ((zzae)object3).zzn(null, (zzdv)object4);
            if (!bl2) break block8;
            ((zzge)this.zzl.zzau()).zzg();
            this.zzs();
            this.zzz.put(object, object2);
            object3 = this.zzi();
            zzlc.zzb();
            Object object6 = ((zzge)object3).zzx.zzc();
            boolean bl3 = ((zzae)object6).zzn(null, (zzdv)object4);
            if (!bl3) break block8;
            Preconditions.checkNotNull(object);
            Preconditions.checkNotNull(object2);
            ((zzge)object3).zzg();
            ((zzjv)object3).zzX();
            object4 = new ContentValues();
            object4.put("app_id", (String)object);
            object2 = ((zzaf)object2).zzd();
            object6 = "consent_state";
            object4.put((String)object6, (String)object2);
            object2 = ((zzai)object3).zze();
            object6 = "consent_settings";
            int n10 = 5;
            long l10 = object2.insertWithOnConflict((String)object6, null, (ContentValues)object4, n10);
            long l11 = -1;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 != false) break block8;
            object2 = ((zzge)object3).zzx;
            object2 = ((zzfl)object2).zzat();
            object2 = ((zzei)object2).zzb();
            object4 = "Failed to insert/update consent setting (got -1). appId";
            object5 = zzei.zzl((String)object);
            try {
                ((zzeg)object2).zzb((String)object4, object5);
                return;
            }
            catch (SQLiteException sQLiteException) {
                object3 = ((zzge)object3).zzx.zzat().zzb();
                object = zzei.zzl((String)object);
                object4 = "Error storing consent setting. appId, error";
                ((zzeg)object3).zzc((String)object4, object, (Object)sQLiteException);
            }
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final zzaf zzx(String string2) {
        Object object;
        block9: {
            Throwable throwable2;
            Cursor cursor;
            block8: {
                block7: {
                    block6: {
                        object = zzaf.zza;
                        zzlc.zzb();
                        Object object2 = this.zzl.zzc();
                        zzdv zzdv2 = zzdw.zzay;
                        cursor = null;
                        int n10 = object2.zzn(null, zzdv2);
                        if (n10 == 0) break block9;
                        ((zzge)this.zzl.zzau()).zzg();
                        this.zzs();
                        object = (zzaf)this.zzz.get(string2);
                        if (object != null) break block9;
                        object = this.zzi();
                        Preconditions.checkNotNull(string2);
                        ((zzge)object).zzg();
                        ((zzjv)object).zzX();
                        n10 = 1;
                        object2 = new String[n10];
                        zzdv2 = null;
                        object2[0] = string2;
                        SQLiteDatabase sQLiteDatabase = ((zzai)object).zze();
                        String string3 = "select consent_state from consent_settings where app_id=? limit 1;";
                        cursor = sQLiteDatabase.rawQuery(string3, object2);
                        n10 = (int)(cursor.moveToFirst() ? 1 : 0);
                        if (n10 == 0) break block6;
                        object = cursor.getString(0);
                        if (cursor == null) break block7;
                        {
                            catch (Throwable throwable2) {
                                break block8;
                            }
                            catch (SQLiteException sQLiteException) {}
                            {
                                object = ((zzge)object).zzx;
                                object = ((zzfl)object).zzat();
                                object = ((zzei)object).zzb();
                                object2 = "Database error";
                                ((zzeg)object).zzc((String)object2, string3, (Object)sQLiteException);
                                throw sQLiteException;
                            }
                        }
                        cursor.close();
                        break block7;
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    object = "G1";
                }
                object = zzaf.zzc((String)object);
                this.zzv(string2, (zzaf)object);
                return object;
            }
            if (cursor != null) {
                cursor.close();
            }
            throw throwable2;
        }
        return object;
    }

    public final long zzy() {
        Clock clock = this.zzl.zzax();
        long l10 = clock.currentTimeMillis();
        Object object = this.zzl.zzd();
        ((zzgf)object).zzv();
        ((zzge)object).zzg();
        Object object2 = ((zzex)object).zzg;
        long l11 = ((zzeu)object2).zza();
        long l12 = 0L;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (l13 == false) {
            object2 = ((zzge)object).zzx.zzl().zzf();
            int n10 = 86400000;
            int n11 = ((Random)object2).nextInt(n10);
            l11 = n11;
            l12 = 1L;
            object = ((zzex)object).zzg;
            ((zzeu)object).zzb(l11 += l12);
        }
        l10 = (l10 + l11) / 1000L;
        long l14 = 60;
        return l10 / l14 / l14 / (long)24;
    }

    public final void zzz(zzas zzas2, String string2) {
        Object object;
        boolean bl2;
        zzkd zzkd2 = this;
        Object object2 = zzas2;
        String string3 = string2;
        Object object3 = this.zzi().zzs(string2);
        if (object3 != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object = ((zzg)object3).zzt())))) {
            zzp zzp2;
            Object object4;
            object = this.zzal((zzg)object3);
            if (object == null) {
                object4 = "_ui";
                object = zzas2.zza;
                bl2 = ((String)object4).equals(object);
                if (!bl2) {
                    object = this.zzl.zzat().zze();
                    object4 = zzei.zzl(string2);
                    String string4 = "Could not find package. appId";
                    ((zzeg)object).zzb(string4, object4);
                }
            } else {
                bl2 = (Boolean)object;
                if (!bl2) {
                    object2 = this.zzl.zzat().zzb();
                    object3 = zzei.zzl(string2);
                    ((zzeg)object2).zzb("App version does not match; dropping event. appId", object3);
                    return;
                }
            }
            object = ((zzg)object3).zzf();
            object4 = ((zzg)object3).zzt();
            long l10 = ((zzg)object3).zzv();
            String string5 = ((zzg)object3).zzx();
            long l11 = ((zzg)object3).zzz();
            long l12 = ((zzg)object3).zzB();
            boolean bl3 = ((zzg)object3).zzF();
            String string6 = ((zzg)object3).zzn();
            long l13 = ((zzg)object3).zzad();
            boolean bl4 = ((zzg)object3).zzaf();
            String string7 = ((zzg)object3).zzh();
            Boolean bl5 = ((zzg)object3).zzah();
            long l14 = ((zzg)object3).zzD();
            Object object5 = ((zzg)object3).zzaj();
            zzmg.zzb();
            zzae zzae2 = zzkd2.zzl.zzc();
            Object object6 = ((zzg)object3).zzc();
            object2 = zzdw.zzah;
            boolean bl6 = zzae2.zzn((String)object6, (zzdv)object2);
            zzae2 = null;
            if (bl6) {
                object2 = ((zzg)object3).zzj();
            } else {
                bl6 = false;
                object2 = null;
            }
            zzlc.zzb();
            object3 = zzkd2.zzl.zzc();
            object6 = zzdw.zzay;
            boolean bl7 = ((zzae)object3).zzn(null, (zzdv)object6);
            object3 = bl7 ? zzkd2.zzx(string3).zzd() : "";
            Object object7 = object3;
            object3 = zzp2;
            string3 = string2;
            List list = object5;
            object5 = object7;
            zzp2 = new zzp(string2, (String)object, (String)object4, l10, string5, l11, l12, null, bl3, false, string6, l13, 0L, 0, bl4, false, string7, bl5, l14, list, (String)object2, (String)object7);
            object2 = zzas2;
            zzkd2.zzA(zzas2, zzp2);
            return;
        }
        zzkd2.zzl.zzat().zzj().zzb("No app data available; dropping event", string3);
    }
}

