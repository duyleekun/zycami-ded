/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.net.Uri
 *  android.util.Log
 */
package com.google.android.gms.internal.clearcut;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.google.android.gms.clearcut.ClearcutLogger$zza;
import com.google.android.gms.clearcut.zze;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.clearcut.zzae;
import com.google.android.gms.internal.clearcut.zzan;
import com.google.android.gms.internal.clearcut.zzao;
import com.google.android.gms.internal.clearcut.zzgw$zza;
import com.google.android.gms.internal.clearcut.zzgw$zza$zzb;
import com.google.android.gms.internal.clearcut.zzha;
import com.google.android.gms.internal.clearcut.zzk;
import com.google.android.gms.internal.clearcut.zzq;
import com.google.android.gms.internal.clearcut.zzr;
import com.google.android.gms.internal.clearcut.zzy;
import com.google.android.gms.phenotype.Phenotype;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public final class zzp
implements ClearcutLogger$zza {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final zzao zzaq;
    private static final zzao zzar;
    private static final ConcurrentHashMap zzas;
    private static final HashMap zzat;
    private static Boolean zzau;
    private static Long zzav;
    private static final zzae zzaw;
    private final Context zzh;

    static {
        AbstractMap abstractMap = "com.google.android.gms.clearcut.public";
        Object object = Phenotype.getContentProviderUri((String)((Object)abstractMap));
        zzao zzao2 = new zzao((Uri)object);
        zzaq = zzao2 = zzao2.zzc("gms:playlog:service:samplingrules_").zzd("LogSamplingRules__");
        abstractMap = Phenotype.getContentProviderUri((String)((Object)abstractMap));
        object = new zzao((Uri)abstractMap);
        zzar = ((zzao)object).zzc("gms:playlog:service:sampling_").zzd("LogSampling__");
        zzas = abstractMap = new AbstractMap();
        abstractMap = new AbstractMap();
        zzat = abstractMap;
        zzau = null;
        zzav = null;
        zzaw = zzao2.zzc("enable_log_sampling_rules", false);
    }

    public zzp(Context context) {
        this.zzh = context;
        if (context != null) {
            zzae.maybeInit(context);
        }
    }

    private static long zza(String object, long l10) {
        boolean bl2;
        int n10 = 8;
        if (object != null && !(bl2 = ((String)object).isEmpty())) {
            Charset charset = UTF_8;
            object = ((String)object).getBytes(charset);
            ByteBuffer byteBuffer = ByteBuffer.allocate(((Object)object).length + n10);
            byteBuffer.put((byte[])object);
            byteBuffer.putLong(l10);
            return zzk.zza(byteBuffer.array());
        }
        return zzk.zza(ByteBuffer.allocate(n10).putLong(l10).array());
    }

    private static zzgw$zza$zzb zza(String string2) {
        long l10;
        long l11;
        String string3;
        CharSequence charSequence;
        block9: {
            if (string2 == null) {
                return null;
            }
            int n10 = string2.indexOf(44);
            int n11 = 0;
            String string4 = null;
            if (n10 >= 0) {
                string4 = string2.substring(0, n10);
                n11 = ++n10;
                charSequence = string4;
            } else {
                charSequence = "";
            }
            int n12 = string2.indexOf(47, n11);
            string3 = "LogSamplerImpl";
            if (n12 <= 0) {
                charSequence = "Failed to parse the rule: ";
                n11 = (string2 = String.valueOf(string2)).length();
                string2 = n11 != 0 ? ((String)charSequence).concat(string2) : new String((String)charSequence);
                Log.e((String)string3, (String)string2);
                return null;
            }
            try {
                string4 = string2.substring(n11, n12);
            }
            catch (NumberFormatException numberFormatException) {
                string4 = "parseLong() failed while parsing: ";
                string2 = String.valueOf(string2);
                n12 = string2.length();
                string2 = n12 != 0 ? string4.concat(string2) : new String(string4);
                Log.e((String)string3, (String)string2, (Throwable)numberFormatException);
                return null;
            }
            l11 = Long.parseLong(string4);
            ++n12;
            string4 = string2.substring(n12);
            l10 = Long.parseLong(string4);
            long l12 = 0L;
            long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
            if (l13 < 0 || (l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1)) < 0) break block9;
            return (zzgw$zza$zzb)zzgw$zza$zzb.zzfz().zzn((String)charSequence).zzr(l11).zzs(l10).zzbh();
        }
        charSequence = new StringBuilder(72);
        ((StringBuilder)charSequence).append("negative values not supported: ");
        ((StringBuilder)charSequence).append(l11);
        ((StringBuilder)charSequence).append("/");
        ((StringBuilder)charSequence).append(l10);
        string2 = ((StringBuilder)charSequence).toString();
        Log.e((String)string3, (String)string2);
        return null;
    }

    private static boolean zzb(long l10, long l11, long l12) {
        long l13 = 0L;
        long l14 = l11 - l13;
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object >= 0 && (object = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1)) > 0) {
            Object object2 = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1);
            if (object2 >= 0) {
                l10 %= l12;
            } else {
                l13 = Long.MAX_VALUE;
                long l15 = l13 % l12;
                long l16 = 1L;
                l15 += l16;
                l10 = (l10 & l13) % l12;
                l15 += l10;
                l10 = l15 % l12;
            }
            long l17 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l17 >= 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzc(Context object) {
        Object object2 = zzau;
        if (object2 == null) {
            int n10 = ((PackageManagerWrapper)(object = Wrappers.packageManager((Context)object))).checkCallingOrSelfPermission((String)(object2 = "com.google.android.providers.gsf.permission.READ_GSERVICES"));
            if (!n10) {
                n10 = 1;
            } else {
                n10 = 0;
                object = null;
            }
            zzau = object = Boolean.valueOf(n10 != 0);
        }
        return zzau;
    }

    private static long zzd(Context object) {
        Long l10 = zzav;
        if (l10 == null) {
            long l11 = 0L;
            if (object != null) {
                boolean bl2 = zzp.zzc(object);
                if (bl2) {
                    object = object.getContentResolver();
                    String string2 = "android_id";
                    l11 = zzy.getLong((ContentResolver)object, string2, l11);
                }
                object = l11;
                zzav = object;
            } else {
                return l11;
            }
        }
        return zzav;
    }

    public final boolean zza(zze object) {
        int n10;
        Object object2 = ((zze)object).zzag;
        Object object3 = ((zzr)object2).zzj;
        int n11 = ((zzr)object2).zzk;
        object = ((zze)object).zzaa;
        if (object != null) {
            n10 = ((zzha)object).zzbji;
        } else {
            n10 = 0;
            object = null;
        }
        Object object4 = (Boolean)zzaw.get();
        boolean n12 = (Boolean)object4;
        Object object5 = null;
        if (!n12) {
            if (object3 == null || (n10 = (int)(((String)object3).isEmpty() ? 1 : 0)) != 0) {
                if (n11 >= 0) {
                    object3 = String.valueOf(n11);
                } else {
                    boolean bl2 = false;
                    object3 = null;
                }
            }
            if (object3 != null) {
                object = this.zzh;
                if (object != null && (n10 = (int)(zzp.zzc((Context)object) ? 1 : 0)) != 0) {
                    object = zzat;
                    object2 = (zzae)((HashMap)object).get(object3);
                    if (object2 == null) {
                        object2 = zzar.zza((String)object3, null);
                        ((HashMap)object).put(object3, object2);
                    }
                    object5 = object = ((zzae)object2).get();
                    object5 = (String)object;
                }
                if ((object = zzp.zza(object5)) != null) {
                    object2 = ((zzgw$zza$zzb)object).zzfw();
                    long l10 = zzp.zzd(this.zzh);
                    long l11 = zzp.zza((String)object2, l10);
                    long l12 = ((zzgw$zza$zzb)object).zzfx();
                    long l13 = ((zzgw$zza$zzb)object).zzfy();
                    return zzp.zzb(l11, l12, l13);
                }
            }
        } else {
            boolean bl3;
            boolean bl4;
            if (object3 == null || (bl4 = ((String)object3).isEmpty())) {
                if (n11 >= 0) {
                    object3 = String.valueOf(n11);
                } else {
                    bl3 = false;
                    object3 = null;
                }
            }
            if (object3 != null) {
                object2 = this.zzh;
                if (object2 == null) {
                    object2 = Collections.emptyList();
                } else {
                    object2 = zzas;
                    object4 = (zzae)((ConcurrentHashMap)object2).get(object3);
                    if (object4 == null) {
                        zzan zzan2;
                        object4 = zzaq;
                        object5 = zzgw$zza.zzft();
                        if ((object2 = (zzae)((ConcurrentHashMap)object2).putIfAbsent(object3, object4 = ((zzao)object4).zza((String)object3, object5, zzan2 = zzq.zzax))) != null) {
                            object4 = object2;
                        }
                    }
                    object2 = ((zzgw$zza)((zzae)object4).get()).zzfs();
                }
                object2 = object2.iterator();
                while (bl3 = object2.hasNext()) {
                    long l14;
                    long l15;
                    long l16;
                    long l17;
                    object3 = (zzgw$zza$zzb)object2.next();
                    int n13 = ((zzgw$zza$zzb)object3).zzfv();
                    if (n13 != 0 && (n13 = ((zzgw$zza$zzb)object3).getEventCode()) != 0 && (n13 = ((zzgw$zza$zzb)object3).getEventCode()) != n10 || (bl3 = zzp.zzb(l17 = zzp.zza((String)(object4 = ((zzgw$zza$zzb)object3).zzfw()), l16 = zzp.zzd((Context)(object5 = this.zzh))), l15 = ((zzgw$zza$zzb)object3).zzfx(), l14 = ((zzgw$zza$zzb)object3).zzfy()))) continue;
                    return false;
                }
            }
        }
        return true;
    }
}

