/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.net.Uri
 *  android.os.Binder
 *  android.os.Build$VERSION
 *  android.os.UserManager
 *  android.util.Log
 */
package com.google.android.gms.internal.clearcut;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.UserManager;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import com.google.android.gms.internal.clearcut.zzab;
import com.google.android.gms.internal.clearcut.zzaf;
import com.google.android.gms.internal.clearcut.zzag;
import com.google.android.gms.internal.clearcut.zzah;
import com.google.android.gms.internal.clearcut.zzai;
import com.google.android.gms.internal.clearcut.zzaj;
import com.google.android.gms.internal.clearcut.zzak;
import com.google.android.gms.internal.clearcut.zzal;
import com.google.android.gms.internal.clearcut.zzam;
import com.google.android.gms.internal.clearcut.zzan;
import com.google.android.gms.internal.clearcut.zzao;
import com.google.android.gms.internal.clearcut.zzy;

public abstract class zzae {
    private static final Object zzdn;
    private static boolean zzdo = false;
    private static volatile Boolean zzdp;
    private static volatile Boolean zzdq;
    private static Context zzh;
    private final zzao zzdr;
    public final String zzds;
    private final String zzdt;
    private final Object zzdu;
    private Object zzdv;
    private volatile zzab zzdw;
    private volatile SharedPreferences zzdx;

    static {
        Object object;
        zzdn = object = new Object();
    }

    private zzae(zzao object, String string2, Object object2) {
        int n10 = 0;
        this.zzdv = null;
        this.zzdw = null;
        this.zzdx = null;
        String string3 = zzao.zza((zzao)object);
        if (string3 == null && (string3 = zzao.zzb((zzao)object)) == null) {
            object = new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
            throw object;
        }
        string3 = zzao.zza((zzao)object);
        if (string3 != null && (string3 = zzao.zzb((zzao)object)) != null) {
            object = new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
            throw object;
        }
        this.zzdr = object;
        string3 = String.valueOf(zzao.zzc((zzao)object));
        String string4 = String.valueOf(string2);
        int n11 = string4.length();
        string3 = n11 != 0 ? string3.concat(string4) : (string4 = new String(string3));
        this.zzdt = string3;
        object = String.valueOf(zzao.zzd((zzao)object));
        string2 = String.valueOf(string2);
        n10 = string2.length();
        if (n10 != 0) {
            object = ((String)object).concat(string2);
        } else {
            string2 = new String((String)object);
            object = string2;
        }
        this.zzds = object;
        this.zzdu = object2;
    }

    public /* synthetic */ zzae(zzao zzao2, String string2, Object object, zzai zzai2) {
        this(zzao2, string2, object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void maybeInit(Context context) {
        Object object = zzh;
        if (object != null) return;
        object = zzdn;
        synchronized (object) {
            Context context2;
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 24;
            if ((n10 < n11 || (n10 = (int)(context.isDeviceProtectedStorage() ? 1 : 0)) == 0) && (context2 = context.getApplicationContext()) != null) {
                context = context2;
            }
            if ((context2 = zzh) != context) {
                n10 = 0;
                context2 = null;
                zzdp = null;
            }
            zzh = context;
        }
        context = null;
        zzdo = false;
    }

    private static zzae zza(zzao zzao2, String string2, Object object, zzan zzan2) {
        zzal zzal2 = new zzal(zzao2, string2, object, zzan2);
        return zzal2;
    }

    private static zzae zza(zzao zzao2, String string2, String string3) {
        zzak zzak2 = new zzak(zzao2, string2, string3);
        return zzak2;
    }

    private static zzae zza(zzao zzao2, String string2, boolean bl2) {
        Boolean bl3 = bl2;
        zzaj zzaj2 = new zzaj(zzao2, string2, bl3);
        return zzaj2;
    }

    private static Object zza(zzam object) {
        long l10;
        try {
            object = object.zzp();
        }
        catch (SecurityException securityException) {
            l10 = Binder.clearCallingIdentity();
            object = object.zzp();
            return object;
        }
        return object;
        {
            finally {
                Binder.restoreCallingIdentity((long)l10);
            }
        }
    }

    public static boolean zza(String string2, boolean bl2) {
        bl2 = zzae.zzn();
        if (bl2) {
            zzah zzah2 = new zzah(string2, false);
            return (Boolean)zzae.zza(zzah2);
        }
        return false;
    }

    public static /* synthetic */ zzae zzb(zzao zzao2, String string2, Object object, zzan zzan2) {
        return zzae.zza(zzao2, string2, object, zzan2);
    }

    public static /* synthetic */ zzae zzb(zzao zzao2, String string2, String string3) {
        return zzae.zza(zzao2, string2, null);
    }

    public static /* synthetic */ zzae zzb(zzao zzao2, String string2, boolean bl2) {
        return zzae.zza(zzao2, string2, false);
    }

    public static final /* synthetic */ Boolean zzb(String string2, boolean bl2) {
        return zzy.zza(zzh.getContentResolver(), string2, bl2);
    }

    private final Object zzl() {
        Object object = "gms:phenotype:phenotype_flag:debug_bypass_phenotype";
        boolean bl2 = false;
        Object object2 = null;
        int n10 = zzae.zza((String)object, false);
        if (!n10) {
            object = zzao.zzb(this.zzdr);
            if (object != null) {
                object = this.zzdw;
                if (object == null) {
                    object = zzh.getContentResolver();
                    object2 = zzao.zzb(this.zzdr);
                    this.zzdw = object = zzab.zza((ContentResolver)object, (Uri)object2);
                }
                object = this.zzdw;
                object2 = new zzaf(this, (zzab)object);
                if ((object = (String)zzae.zza((zzam)object2)) != null) {
                    return this.zzb((String)object);
                }
            } else {
                object = zzao.zza(this.zzdr);
                if (object != null) {
                    Object object3;
                    n10 = Build.VERSION.SDK_INT;
                    int n11 = 24;
                    if (n10 >= n11 && !(n10 = (int)((object = zzh).isDeviceProtectedStorage() ? 1 : 0))) {
                        object = zzdq;
                        if (object == null || !(n10 = (int)(((Boolean)(object = zzdq)).booleanValue() ? 1 : 0))) {
                            object = zzh;
                            object3 = UserManager.class;
                            n10 = (int)(((UserManager)object.getSystemService((Class)object3)).isUserUnlocked() ? 1 : 0);
                            zzdq = object = Boolean.valueOf(n10 != 0);
                        }
                        object = zzdq;
                        n10 = (int)(((Boolean)object).booleanValue() ? 1 : 0);
                    } else {
                        n10 = 1;
                    }
                    if (!n10) {
                        return null;
                    }
                    object = this.zzdx;
                    if (object == null) {
                        object = zzh;
                        object3 = zzao.zza(this.zzdr);
                        object = object.getSharedPreferences((String)object3, 0);
                        this.zzdx = object;
                    }
                    if (bl2 = (object = this.zzdx).contains((String)(object2 = this.zzds))) {
                        return this.zza((SharedPreferences)object);
                    }
                }
            }
        } else {
            object = "Bypass reading Phenotype values for flag: ";
            object2 = String.valueOf(this.zzds);
            int n12 = ((String)object2).length();
            object = n12 != 0 ? ((String)object).concat((String)object2) : (object2 = new String((String)object));
            object2 = "PhenotypeFlag";
            Log.w((String)object2, (String)object);
        }
        return null;
    }

    private final Object zzm() {
        Object object = this.zzdr;
        boolean bl2 = zzao.zzf((zzao)object);
        if (!bl2 && (bl2 = zzae.zzn())) {
            object = new zzag(this);
            if ((object = (String)zzae.zza((zzam)object)) != null) {
                return this.zzb((String)object);
            }
        }
        return null;
    }

    private static boolean zzn() {
        Boolean bl2 = zzdp;
        if (bl2 == null) {
            bl2 = zzh;
            boolean bl3 = false;
            if (bl2 != null) {
                String string2 = "com.google.android.providers.gsf.permission.READ_GSERVICES";
                int n10 = PermissionChecker.checkCallingOrSelfPermission((Context)bl2, string2);
                if (n10 == 0) {
                    bl3 = true;
                }
                zzdp = bl2 = Boolean.valueOf(bl3);
            } else {
                return false;
            }
        }
        return zzdp;
    }

    public final Object get() {
        Object object = zzh;
        if (object != null) {
            object = this.zzdr;
            boolean bl2 = zzao.zze((zzao)object);
            if (bl2) {
                object = this.zzm();
                if (object != null) {
                    return object;
                }
                object = this.zzl();
                if (object != null) {
                    return object;
                }
            } else {
                object = this.zzl();
                if (object != null) {
                    return object;
                }
                object = this.zzm();
                if (object != null) {
                    return object;
                }
            }
            return this.zzdu;
        }
        object = new IllegalStateException("Must call PhenotypeFlag.init() first");
        throw object;
    }

    public abstract Object zza(SharedPreferences var1);

    public abstract Object zzb(String var1);

    public final /* synthetic */ String zzo() {
        ContentResolver contentResolver = zzh.getContentResolver();
        String string2 = this.zzdt;
        return zzy.zza(contentResolver, string2, null);
    }
}

