/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzcv;
import com.google.android.gms.internal.measurement.zzcx;
import com.google.android.gms.internal.measurement.zzdb;
import com.google.android.gms.internal.measurement.zzdi;
import com.google.android.gms.internal.measurement.zzdo;
import com.google.android.gms.internal.measurement.zzdu;
import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzhs;
import com.google.android.gms.internal.measurement.zzhx;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zziy;
import java.util.List;

public final class zzdj
extends zzhs
implements zziy {
    private static final zzdj zzZ;
    public static final /* synthetic */ int zza;
    private String zzA;
    private long zzB;
    private int zzC;
    private String zzD;
    private String zzE;
    private boolean zzF;
    private zzhz zzG;
    private String zzH;
    private int zzI;
    private int zzJ;
    private int zzK;
    private String zzL;
    private long zzM;
    private long zzN;
    private String zzO;
    private String zzP;
    private int zzQ;
    private String zzR;
    private zzdo zzS;
    private zzhx zzT;
    private long zzU;
    private long zzV;
    private String zzW;
    private String zzX;
    private int zzY;
    private int zze;
    private int zzf;
    private int zzg;
    private zzhz zzh;
    private zzhz zzi;
    private long zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private String zzo;
    private String zzp;
    private String zzq;
    private String zzr;
    private int zzs;
    private String zzt;
    private String zzu;
    private String zzv;
    private long zzw;
    private long zzx;
    private String zzy;
    private boolean zzz;

    static {
        zzdj zzdj2;
        zzZ = zzdj2 = new zzdj();
        zzhs.zzby(zzdj.class, zzdj2);
    }

    private zzdj() {
        zzhz zzhz2;
        Object object = zzhs.zzbE();
        this.zzh = object;
        object = zzhs.zzbE();
        this.zzi = object;
        this.zzo = object = "";
        this.zzp = object;
        this.zzq = object;
        this.zzr = object;
        this.zzt = object;
        this.zzu = object;
        this.zzv = object;
        this.zzy = object;
        this.zzA = object;
        this.zzD = object;
        this.zzE = object;
        this.zzG = zzhz2 = zzhs.zzbE();
        this.zzH = object;
        this.zzL = object;
        this.zzO = object;
        this.zzP = object;
        this.zzR = object;
        zzhz2 = zzhs.zzbB();
        this.zzT = zzhz2;
        this.zzW = object;
        this.zzX = object;
    }

    public static /* synthetic */ void zzaA(zzdj zzdj2, long l10) {
        int n10;
        zzdj2.zze = n10 = zzdj2.zze | 0x20;
        zzdj2.zzn = l10;
    }

    public static /* synthetic */ void zzaB(zzdj zzdj2) {
        int n10;
        zzdj2.zze = n10 = zzdj2.zze & 0xFFFFFFDF;
        zzdj2.zzn = 0L;
    }

    public static /* synthetic */ void zzaC(zzdj zzdj2, String string2) {
        int n10;
        zzdj2.zze = n10 = zzdj2.zze | 0x40;
        zzdj2.zzo = "android";
    }

    public static /* synthetic */ void zzaD(zzdj zzdj2, String string2) {
        int n10;
        string2.getClass();
        zzdj2.zze = n10 = zzdj2.zze | 0x80;
        zzdj2.zzp = string2;
    }

    public static /* synthetic */ void zzaE(zzdj zzdj2, String string2) {
        int n10;
        string2.getClass();
        zzdj2.zze = n10 = zzdj2.zze | 0x100;
        zzdj2.zzq = string2;
    }

    public static /* synthetic */ void zzaF(zzdj zzdj2, String string2) {
        int n10;
        string2.getClass();
        zzdj2.zze = n10 = zzdj2.zze | 0x200;
        zzdj2.zzr = string2;
    }

    public static /* synthetic */ void zzaG(zzdj zzdj2, int n10) {
        int n11;
        zzdj2.zze = n11 = zzdj2.zze | 0x400;
        zzdj2.zzs = n10;
    }

    public static /* synthetic */ void zzaH(zzdj zzdj2, String string2) {
        int n10;
        string2.getClass();
        zzdj2.zze = n10 = zzdj2.zze | 0x800;
        zzdj2.zzt = string2;
    }

    public static /* synthetic */ void zzaI(zzdj zzdj2, String string2) {
        int n10;
        string2.getClass();
        zzdj2.zze = n10 = zzdj2.zze | 0x1000;
        zzdj2.zzu = string2;
    }

    public static /* synthetic */ void zzaJ(zzdj zzdj2, String string2) {
        int n10;
        string2.getClass();
        zzdj2.zze = n10 = zzdj2.zze | 0x2000;
        zzdj2.zzv = string2;
    }

    public static /* synthetic */ void zzaK(zzdj zzdj2, long l10) {
        int n10;
        zzdj2.zze = n10 = zzdj2.zze | 0x4000;
        zzdj2.zzw = l10;
    }

    public static /* synthetic */ void zzaL(zzdj zzdj2, long l10) {
        int n10;
        zzdj2.zze = n10 = zzdj2.zze | 0x8000;
        zzdj2.zzx = 39000L;
    }

    public static /* synthetic */ void zzaM(zzdj zzdj2, String string2) {
        int n10;
        string2.getClass();
        zzdj2.zze = n10 = zzdj2.zze | 0x10000;
        zzdj2.zzy = string2;
    }

    public static /* synthetic */ void zzaN(zzdj zzdj2) {
        String string2;
        int n10;
        zzdj2.zze = n10 = zzdj2.zze & 0xFFFEFFFF;
        zzdj2.zzy = string2 = zzdj.zzZ.zzy;
    }

    public static /* synthetic */ void zzaO(zzdj zzdj2, boolean bl2) {
        int n10;
        zzdj2.zze = n10 = zzdj2.zze | 0x20000;
        zzdj2.zzz = bl2;
    }

    public static /* synthetic */ void zzaP(zzdj zzdj2) {
        int n10;
        zzdj2.zze = n10 = zzdj2.zze & 0xFFFDFFFF;
        zzdj2.zzz = false;
    }

    public static /* synthetic */ void zzaQ(zzdj zzdj2, String string2) {
        int n10;
        string2.getClass();
        zzdj2.zze = n10 = zzdj2.zze | 0x40000;
        zzdj2.zzA = string2;
    }

    public static /* synthetic */ void zzaR(zzdj zzdj2) {
        String string2;
        int n10;
        zzdj2.zze = n10 = zzdj2.zze & 0xFFFBFFFF;
        zzdj2.zzA = string2 = zzdj.zzZ.zzA;
    }

    public static /* synthetic */ void zzaS(zzdj zzdj2, long l10) {
        int n10;
        zzdj2.zze = n10 = zzdj2.zze | 0x80000;
        zzdj2.zzB = l10;
    }

    public static /* synthetic */ void zzaT(zzdj zzdj2, int n10) {
        int n11;
        zzdj2.zze = n11 = zzdj2.zze | 0x100000;
        zzdj2.zzC = n10;
    }

    public static /* synthetic */ void zzaU(zzdj zzdj2, String string2) {
        int n10;
        zzdj2.zze = n10 = zzdj2.zze | 0x200000;
        zzdj2.zzD = string2;
    }

    public static /* synthetic */ void zzaV(zzdj zzdj2) {
        String string2;
        int n10;
        zzdj2.zze = n10 = zzdj2.zze & 0xFFDFFFFF;
        zzdj2.zzD = string2 = zzdj.zzZ.zzD;
    }

    public static /* synthetic */ void zzaW(zzdj zzdj2, String string2) {
        int n10;
        string2.getClass();
        zzdj2.zze = n10 = zzdj2.zze | 0x400000;
        zzdj2.zzE = string2;
    }

    public static /* synthetic */ void zzaX(zzdj zzdj2, boolean bl2) {
        int n10;
        zzdj2.zze = n10 = zzdj2.zze | 0x800000;
        zzdj2.zzF = bl2;
    }

    public static /* synthetic */ void zzaY(zzdj object, Iterable iterable) {
        zzhz zzhz2 = ((zzdj)object).zzG;
        boolean bl2 = zzhz2.zza();
        if (!bl2) {
            ((zzdj)object).zzG = zzhz2 = zzhs.zzbF(zzhz2);
        }
        object = ((zzdj)object).zzG;
        zzgb.zzbs(iterable, (List)object);
    }

    public static /* synthetic */ void zzaZ(zzdj zzdj2) {
        zzhz zzhz2;
        zzdj2.zzG = zzhz2 = zzhs.zzbE();
    }

    public static zzdi zzaj() {
        return (zzdi)zzZ.zzbt();
    }

    public static /* synthetic */ zzdj zzak() {
        return zzZ;
    }

    public static /* synthetic */ void zzal(zzdj zzdj2, int n10) {
        n10 = zzdj2.zze;
        int n11 = 1;
        zzdj2.zze = n10 |= n11;
        zzdj2.zzg = n11;
    }

    public static /* synthetic */ void zzam(zzdj zzdj2, int n10, zzdb zzdb2) {
        zzdb2.getClass();
        zzdj2.zzbI();
        zzdj2.zzh.set(n10, zzdb2);
    }

    public static /* synthetic */ void zzan(zzdj zzdj2, zzdb zzdb2) {
        zzdb2.getClass();
        zzdj2.zzbI();
        zzdj2.zzh.add(zzdb2);
    }

    public static /* synthetic */ void zzao(zzdj object, Iterable iterable) {
        ((zzdj)object).zzbI();
        object = ((zzdj)object).zzh;
        zzgb.zzbs(iterable, (List)object);
    }

    public static /* synthetic */ void zzap(zzdj zzdj2) {
        zzhz zzhz2;
        zzdj2.zzh = zzhz2 = zzhs.zzbE();
    }

    public static /* synthetic */ void zzaq(zzdj zzdj2, int n10) {
        zzdj2.zzbI();
        zzdj2.zzh.remove(n10);
    }

    public static /* synthetic */ void zzar(zzdj zzdj2, int n10, zzdu zzdu2) {
        zzdu2.getClass();
        zzdj2.zzbJ();
        zzdj2.zzi.set(n10, zzdu2);
    }

    public static /* synthetic */ void zzas(zzdj zzdj2, zzdu zzdu2) {
        zzdu2.getClass();
        zzdj2.zzbJ();
        zzdj2.zzi.add(zzdu2);
    }

    public static /* synthetic */ void zzat(zzdj object, Iterable iterable) {
        ((zzdj)object).zzbJ();
        object = ((zzdj)object).zzi;
        zzgb.zzbs(iterable, (List)object);
    }

    public static /* synthetic */ void zzau(zzdj zzdj2, int n10) {
        zzdj2.zzbJ();
        zzdj2.zzi.remove(n10);
    }

    public static /* synthetic */ void zzav(zzdj zzdj2, long l10) {
        int n10;
        zzdj2.zze = n10 = zzdj2.zze | 2;
        zzdj2.zzj = l10;
    }

    public static /* synthetic */ void zzaw(zzdj zzdj2, long l10) {
        int n10;
        zzdj2.zze = n10 = zzdj2.zze | 4;
        zzdj2.zzk = l10;
    }

    public static /* synthetic */ void zzax(zzdj zzdj2, long l10) {
        int n10;
        zzdj2.zze = n10 = zzdj2.zze | 8;
        zzdj2.zzl = l10;
    }

    public static /* synthetic */ void zzay(zzdj zzdj2, long l10) {
        int n10;
        zzdj2.zze = n10 = zzdj2.zze | 0x10;
        zzdj2.zzm = l10;
    }

    public static /* synthetic */ void zzaz(zzdj zzdj2) {
        int n10;
        zzdj2.zze = n10 = zzdj2.zze & 0xFFFFFFEF;
        zzdj2.zzm = 0L;
    }

    private final void zzbI() {
        zzhz zzhz2 = this.zzh;
        boolean bl2 = zzhz2.zza();
        if (!bl2) {
            this.zzh = zzhz2 = zzhs.zzbF(zzhz2);
        }
    }

    private final void zzbJ() {
        zzhz zzhz2 = this.zzi;
        boolean bl2 = zzhz2.zza();
        if (!bl2) {
            this.zzi = zzhz2 = zzhs.zzbF(zzhz2);
        }
    }

    public static /* synthetic */ void zzba(zzdj zzdj2, String string2) {
        int n10;
        string2.getClass();
        zzdj2.zze = n10 = zzdj2.zze | 0x1000000;
        zzdj2.zzH = string2;
    }

    public static /* synthetic */ void zzbb(zzdj zzdj2, int n10) {
        int n11;
        zzdj2.zze = n11 = zzdj2.zze | 0x2000000;
        zzdj2.zzI = n10;
    }

    public static /* synthetic */ void zzbc(zzdj zzdj2) {
        String string2;
        int n10;
        zzdj2.zze = n10 = zzdj2.zze & 0xEFFFFFFF;
        zzdj2.zzL = string2 = zzdj.zzZ.zzL;
    }

    public static /* synthetic */ void zzbd(zzdj zzdj2, long l10) {
        int n10;
        zzdj2.zze = n10 = zzdj2.zze | 0x20000000;
        zzdj2.zzM = l10;
    }

    public static /* synthetic */ void zzbe(zzdj zzdj2, long l10) {
        int n10;
        zzdj2.zze = n10 = zzdj2.zze | 0x40000000;
        zzdj2.zzN = l10;
    }

    public static /* synthetic */ void zzbf(zzdj zzdj2) {
        String string2;
        int n10;
        zzdj2.zze = n10 = zzdj2.zze & -1 >>> 1;
        zzdj2.zzO = string2 = zzdj.zzZ.zzO;
    }

    public static /* synthetic */ void zzbg(zzdj zzdj2, int n10) {
        int n11;
        zzdj2.zzf = n11 = zzdj2.zzf | 2;
        zzdj2.zzQ = n10;
    }

    public static /* synthetic */ void zzbh(zzdj zzdj2, String string2) {
        int n10;
        string2.getClass();
        zzdj2.zzf = n10 = zzdj2.zzf | 4;
        zzdj2.zzR = string2;
    }

    public static /* synthetic */ void zzbi(zzdj zzdj2, zzdo zzdo2) {
        int n10;
        zzdo2.getClass();
        zzdj2.zzS = zzdo2;
        zzdj2.zzf = n10 = zzdj2.zzf | 8;
    }

    public static /* synthetic */ void zzbj(zzdj object, Iterable iterable) {
        zzhx zzhx2 = ((zzdj)object).zzT;
        int n10 = zzhx2.zza();
        if (n10 == 0) {
            n10 = zzhx2.size();
            n10 = n10 == 0 ? 10 : (n10 += n10);
            ((zzdj)object).zzT = zzhx2 = zzhx2.zzf(n10);
        }
        object = ((zzdj)object).zzT;
        zzgb.zzbs(iterable, (List)object);
    }

    public static /* synthetic */ void zzbk(zzdj zzdj2, long l10) {
        int n10;
        zzdj2.zzf = n10 = zzdj2.zzf | 0x10;
        zzdj2.zzU = l10;
    }

    public static /* synthetic */ void zzbl(zzdj zzdj2, long l10) {
        int n10;
        zzdj2.zzf = n10 = zzdj2.zzf | 0x20;
        zzdj2.zzV = l10;
    }

    public static /* synthetic */ void zzbm(zzdj zzdj2, String string2) {
        int n10;
        string2.getClass();
        zzdj2.zzf = n10 = zzdj2.zzf | 0x40;
        zzdj2.zzW = string2;
    }

    public static /* synthetic */ void zzbn(zzdj zzdj2, String string2) {
        int n10;
        string2.getClass();
        zzdj2.zzf = n10 = zzdj2.zzf | 0x80;
        zzdj2.zzX = string2;
    }

    public final String zzA() {
        return this.zzu;
    }

    public final String zzB() {
        return this.zzv;
    }

    public final boolean zzC() {
        int n10 = this.zze & 0x4000;
        return n10 != 0;
    }

    public final long zzD() {
        return this.zzw;
    }

    public final boolean zzE() {
        int n10 = this.zze;
        int n11 = 32768;
        return (n10 &= n11) != 0;
    }

    public final long zzF() {
        return this.zzx;
    }

    public final String zzG() {
        return this.zzy;
    }

    public final boolean zzH() {
        int n10 = this.zze;
        int n11 = 131072;
        return (n10 &= n11) != 0;
    }

    public final boolean zzI() {
        return this.zzz;
    }

    public final String zzJ() {
        return this.zzA;
    }

    public final boolean zzK() {
        int n10 = this.zze;
        int n11 = 524288;
        return (n10 &= n11) != 0;
    }

    public final long zzL() {
        return this.zzB;
    }

    public final boolean zzM() {
        int n10 = this.zze;
        int n11 = 0x100000;
        return (n10 &= n11) != 0;
    }

    public final int zzN() {
        return this.zzC;
    }

    public final String zzO() {
        return this.zzD;
    }

    public final String zzP() {
        return this.zzE;
    }

    public final boolean zzQ() {
        int n10 = this.zze;
        int n11 = 0x800000;
        return (n10 &= n11) != 0;
    }

    public final boolean zzR() {
        return this.zzF;
    }

    public final List zzS() {
        return this.zzG;
    }

    public final String zzT() {
        return this.zzH;
    }

    public final boolean zzU() {
        int n10 = this.zze;
        int n11 = 0x2000000;
        return (n10 &= n11) != 0;
    }

    public final int zzV() {
        return this.zzI;
    }

    public final boolean zzW() {
        int n10 = this.zze;
        int n11 = 0x20000000;
        return (n10 &= n11) != 0;
    }

    public final long zzX() {
        return this.zzM;
    }

    public final boolean zzY() {
        int n10 = this.zze;
        int n11 = 0x40000000;
        return (n10 &= n11) != 0;
    }

    public final long zzZ() {
        return this.zzN;
    }

    public final boolean zza() {
        int n10 = this.zze;
        int n11 = 1;
        if ((n10 &= n11) != 0) {
            return n11 != 0;
        }
        return false;
    }

    public final String zzaa() {
        return this.zzO;
    }

    public final boolean zzab() {
        int n10 = this.zzf & 2;
        return n10 != 0;
    }

    public final int zzac() {
        return this.zzQ;
    }

    public final String zzad() {
        return this.zzR;
    }

    public final boolean zzae() {
        int n10 = this.zzf & 0x10;
        return n10 != 0;
    }

    public final long zzaf() {
        return this.zzU;
    }

    public final String zzag() {
        return this.zzW;
    }

    public final boolean zzah() {
        int n10 = this.zzf & 0x80;
        return n10 != 0;
    }

    public final String zzai() {
        return this.zzX;
    }

    public final int zzb() {
        return this.zzg;
    }

    public final List zzc() {
        return this.zzh;
    }

    public final int zzd() {
        return this.zzh.size();
    }

    public final zzdb zze(int n10) {
        return (zzdb)this.zzh.get(n10);
    }

    public final List zzf() {
        return this.zzi;
    }

    public final int zzg() {
        return this.zzi.size();
    }

    public final zzdu zzh(int n10) {
        return (zzdu)this.zzi.get(n10);
    }

    public final boolean zzi() {
        int n10 = this.zze & 2;
        return n10 != 0;
    }

    public final long zzj() {
        return this.zzj;
    }

    public final boolean zzk() {
        int n10 = this.zze & 4;
        return n10 != 0;
    }

    public final Object zzl(int n10, Object object, Object object2) {
        byte by2 = 1;
        if ((n10 += -1) != 0) {
            int n11 = 5;
            int n12 = 4;
            int n13 = 3;
            int n14 = 2;
            if (n10 != n14) {
                if (n10 != n13) {
                    by2 = 0;
                    object = null;
                    if (n10 != n12) {
                        if (n10 != n11) {
                            return null;
                        }
                        return zzZ;
                    }
                    zzdi zzdi2 = new zzdi(null);
                    return zzdi2;
                }
                zzdj zzdj2 = new zzdj();
                return zzdj2;
            }
            Object[] objectArray = new Object[51];
            objectArray[0] = "zze";
            objectArray[by2] = "zzf";
            objectArray[n14] = "zzg";
            objectArray[n13] = "zzh";
            objectArray[n12] = zzdb.class;
            objectArray[n11] = "zzi";
            objectArray[6] = zzdu.class;
            objectArray[7] = "zzj";
            objectArray[8] = "zzk";
            objectArray[9] = "zzl";
            objectArray[10] = "zzn";
            objectArray[11] = "zzo";
            objectArray[12] = "zzp";
            objectArray[13] = "zzq";
            objectArray[14] = "zzr";
            objectArray[15] = "zzs";
            objectArray[16] = "zzt";
            objectArray[17] = "zzu";
            objectArray[18] = "zzv";
            objectArray[19] = "zzw";
            objectArray[20] = "zzx";
            objectArray[21] = "zzy";
            objectArray[22] = "zzz";
            objectArray[23] = "zzA";
            objectArray[24] = "zzB";
            objectArray[25] = "zzC";
            objectArray[26] = "zzD";
            objectArray[27] = "zzE";
            objectArray[28] = "zzm";
            objectArray[29] = "zzF";
            objectArray[30] = "zzG";
            objectArray[31] = zzcx.class;
            objectArray[32] = "zzH";
            objectArray[33] = "zzI";
            objectArray[34] = "zzJ";
            objectArray[35] = "zzK";
            objectArray[36] = "zzL";
            objectArray[37] = "zzM";
            objectArray[38] = "zzN";
            objectArray[39] = "zzO";
            objectArray[40] = "zzP";
            objectArray[41] = "zzQ";
            objectArray[42] = "zzR";
            objectArray[43] = "zzS";
            objectArray[44] = "zzT";
            objectArray[45] = "zzU";
            objectArray[46] = "zzV";
            objectArray[47] = "zzW";
            objectArray[48] = "zzX";
            objectArray[49] = "zzY";
            objectArray[50] = object = zzcv.zzb();
            return zzhs.zzbz(zzZ, "\u0001-\u0000\u0002\u00015-\u0000\u0004\u0000\u0001\u1004\u0000\u0002\u001b\u0003\u001b\u0004\u1002\u0001\u0005\u1002\u0002\u0006\u1002\u0003\u0007\u1002\u0005\b\u1008\u0006\t\u1008\u0007\n\u1008\b\u000b\u1008\t\f\u1004\n\r\u1008\u000b\u000e\u1008\f\u0010\u1008\r\u0011\u1002\u000e\u0012\u1002\u000f\u0013\u1008\u0010\u0014\u1007\u0011\u0015\u1008\u0012\u0016\u1002\u0013\u0017\u1004\u0014\u0018\u1008\u0015\u0019\u1008\u0016\u001a\u1002\u0004\u001c\u1007\u0017\u001d\u001b\u001e\u1008\u0018\u001f\u1004\u0019 \u1004\u001a!\u1004\u001b\"\u1008\u001c#\u1002\u001d$\u1002\u001e%\u1008\u001f&\u1008 '\u1004!)\u1008\",\u1009#-\u001d.\u1002$/\u1002%2\u1008&4\u1008'5\u100c(", objectArray);
        }
        return by2;
    }

    public final long zzm() {
        return this.zzk;
    }

    public final boolean zzn() {
        int n10 = this.zze & 8;
        return n10 != 0;
    }

    public final long zzo() {
        return this.zzl;
    }

    public final boolean zzp() {
        int n10 = this.zze & 0x10;
        return n10 != 0;
    }

    public final long zzq() {
        return this.zzm;
    }

    public final boolean zzr() {
        int n10 = this.zze & 0x20;
        return n10 != 0;
    }

    public final long zzs() {
        return this.zzn;
    }

    public final String zzt() {
        return this.zzo;
    }

    public final String zzu() {
        return this.zzp;
    }

    public final String zzv() {
        return this.zzq;
    }

    public final String zzw() {
        return this.zzr;
    }

    public final boolean zzx() {
        int n10 = this.zze & 0x400;
        return n10 != 0;
    }

    public final int zzy() {
        return this.zzs;
    }

    public final String zzz() {
        return this.zzt;
    }
}

