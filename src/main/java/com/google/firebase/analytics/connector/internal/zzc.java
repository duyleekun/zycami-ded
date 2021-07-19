/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.measurement.internal.zzgh;
import com.google.android.gms.measurement.internal.zzgi;
import com.google.android.gms.measurement.internal.zzgk;
import com.google.android.gms.measurement.internal.zzht;
import com.google.firebase.analytics.connector.AnalyticsConnector$ConditionalUserProperty;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class zzc {
    private static final Set zza;
    private static final List zzb;
    private static final List zzc;
    private static final List zzd;
    private static final List zze;
    private static final List zzf;

    static {
        Object[][] objectArray;
        String[] stringArray = Arrays.asList("_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire");
        zza = objectArray = new HashSet(stringArray);
        zzb = Arrays.asList("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd");
        zzc = Arrays.asList("auto", "app", "am");
        zzd = Arrays.asList("_r", "_dbg");
        objectArray = new String[2][];
        stringArray = zzgk.zza;
        objectArray[0] = stringArray;
        stringArray = zzgk.zzb;
        objectArray[1] = stringArray;
        zze = Arrays.asList((String[])ArrayUtils.concat(objectArray));
        zzf = Arrays.asList("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");
    }

    public static boolean zza(String string2) {
        List list = zzc;
        boolean bl2 = list.contains(string2);
        return !bl2;
    }

    public static boolean zzb(String object, Bundle bundle) {
        boolean bl2 = zzb.contains(object);
        if (bl2) {
            return false;
        }
        if (bundle != null) {
            boolean bl3;
            object = zzd.iterator();
            while (bl3 = object.hasNext()) {
                String string2 = (String)object.next();
                bl3 = bundle.containsKey(string2);
                if (!bl3) continue;
                return false;
            }
        }
        return true;
    }

    public static boolean zzc(String string2) {
        Set set = zza;
        boolean bl2 = set.contains(string2);
        return !bl2;
    }

    public static boolean zzd(String object, String string2) {
        boolean bl2;
        String string3 = "_ce1";
        boolean bl3 = string3.equals(string2);
        String string4 = "fcm";
        boolean bl4 = true;
        if (!bl3 && !(bl3 = (string3 = "_ce2").equals(string2))) {
            string3 = "_ln";
            bl3 = string3.equals(string2);
            if (bl3) {
                boolean bl5;
                boolean bl6 = ((String)object).equals(string4);
                if (!bl6 && !(bl5 = ((String)object).equals(string2 = "fiam"))) {
                    return false;
                }
                return bl4;
            }
            object = zze;
            boolean bl7 = object.contains(string2);
            if (bl7) {
                return false;
            }
            object = zzf.iterator();
            while (bl3 = object.hasNext()) {
                string3 = (String)object.next();
                bl3 = string2.matches(string3);
                if (!bl3) continue;
                return false;
            }
            return bl4;
        }
        boolean bl8 = ((String)object).equals(string4);
        if (!bl8 && !(bl2 = ((String)object).equals(string2 = "frc"))) {
            return false;
        }
        return bl4;
    }

    public static boolean zze(AnalyticsConnector$ConditionalUserProperty analyticsConnector$ConditionalUserProperty) {
        boolean bl2;
        if (analyticsConnector$ConditionalUserProperty == null) {
            return false;
        }
        String string2 = analyticsConnector$ConditionalUserProperty.origin;
        if (string2 != null && !(bl2 = string2.isEmpty())) {
            Bundle bundle;
            Object object = analyticsConnector$ConditionalUserProperty.value;
            if (object != null && (object = zzht.zzc(object)) == null) {
                return false;
            }
            bl2 = com.google.firebase.analytics.connector.internal.zzc.zza(string2);
            if (!bl2) {
                return false;
            }
            object = analyticsConnector$ConditionalUserProperty.name;
            bl2 = com.google.firebase.analytics.connector.internal.zzc.zzd(string2, (String)object);
            if (!bl2) {
                return false;
            }
            object = analyticsConnector$ConditionalUserProperty.expiredEventName;
            if (object != null) {
                bundle = analyticsConnector$ConditionalUserProperty.expiredEventParams;
                bl2 = com.google.firebase.analytics.connector.internal.zzc.zzb((String)object, bundle);
                if (!bl2) {
                    return false;
                }
                object = analyticsConnector$ConditionalUserProperty.expiredEventName;
                bundle = analyticsConnector$ConditionalUserProperty.expiredEventParams;
                bl2 = com.google.firebase.analytics.connector.internal.zzc.zzf(string2, (String)object, bundle);
                if (!bl2) {
                    return false;
                }
            }
            if ((object = analyticsConnector$ConditionalUserProperty.triggeredEventName) != null) {
                bundle = analyticsConnector$ConditionalUserProperty.triggeredEventParams;
                bl2 = com.google.firebase.analytics.connector.internal.zzc.zzb((String)object, bundle);
                if (!bl2) {
                    return false;
                }
                object = analyticsConnector$ConditionalUserProperty.triggeredEventName;
                bundle = analyticsConnector$ConditionalUserProperty.triggeredEventParams;
                bl2 = com.google.firebase.analytics.connector.internal.zzc.zzf(string2, (String)object, bundle);
                if (!bl2) {
                    return false;
                }
            }
            if ((object = analyticsConnector$ConditionalUserProperty.timedOutEventName) != null) {
                bundle = analyticsConnector$ConditionalUserProperty.timedOutEventParams;
                bl2 = com.google.firebase.analytics.connector.internal.zzc.zzb((String)object, bundle);
                if (!bl2) {
                    return false;
                }
                object = analyticsConnector$ConditionalUserProperty.timedOutEventName;
                analyticsConnector$ConditionalUserProperty = analyticsConnector$ConditionalUserProperty.timedOutEventParams;
                boolean bl3 = com.google.firebase.analytics.connector.internal.zzc.zzf(string2, (String)object, (Bundle)analyticsConnector$ConditionalUserProperty);
                if (!bl3) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static boolean zzf(String var0, String var1_1, Bundle var2_2) {
        block11: {
            block9: {
                block10: {
                    var3_3 = "_cmp";
                    var4_4 = var3_3.equals(var1_1);
                    var5_5 = true;
                    if (var4_4 == 0) {
                        return var5_5;
                    }
                    var4_4 = com.google.firebase.analytics.connector.internal.zzc.zza(var0);
                    if (var4_4 == 0) {
                        return false;
                    }
                    if (var2_2 == null) {
                        return false;
                    }
                    var1_1 = com.google.firebase.analytics.connector.internal.zzc.zzd.iterator();
                    while ((var6_6 = var1_1.hasNext()) != 0) {
                        var7_7 = (String)var1_1.next();
                        var6_6 = (int)var2_2.containsKey(var7_7);
                        if (var6_6 == 0) continue;
                        return false;
                    }
                    var4_4 = var0.hashCode();
                    var6_6 = 101200;
                    var8_8 = 2 != 0;
                    if (var4_4 == var6_6) break block9;
                    var6_6 = 101230;
                    if (var4_4 == var6_6) break block10;
                    var6_6 = 0x2FF42F;
                    if (var4_4 != var6_6 || !(var9_9 = (boolean)var0.equals(var1_1 = "fiam"))) ** GOTO lbl-1000
                    var9_9 = var8_8;
                    break block11;
                }
                var1_1 = "fdl";
                var9_9 = var0.equals(var1_1);
                if (!var9_9) ** GOTO lbl-1000
                var9_9 = var5_5;
                break block11;
            }
            var1_1 = "fcm";
            var9_9 = var0.equals(var1_1);
            if (var9_9) {
                var9_9 = false;
                var0 = null;
            } else lbl-1000:
            // 3 sources

            {
                var9_9 = -1 != 0;
            }
        }
        var1_1 = "_cis";
        if (var9_9) {
            if (var9_9 != var5_5) {
                if (var9_9 != var8_8) {
                    return false;
                }
                var2_2.putString((String)var1_1, "fiam_integration");
                return var5_5;
            }
            var2_2.putString((String)var1_1, "fdl_integration");
            return var5_5;
        }
        var2_2.putString((String)var1_1, "fcm_integration");
        return var5_5;
    }

    public static Bundle zzg(AnalyticsConnector$ConditionalUserProperty analyticsConnector$ConditionalUserProperty) {
        String string2;
        Bundle bundle = new Bundle();
        Object object = analyticsConnector$ConditionalUserProperty.origin;
        if (object != null) {
            string2 = "origin";
            bundle.putString(string2, (String)object);
        }
        if ((object = analyticsConnector$ConditionalUserProperty.name) != null) {
            string2 = "name";
            bundle.putString(string2, (String)object);
        }
        if ((object = analyticsConnector$ConditionalUserProperty.value) != null) {
            zzgh.zza(bundle, object);
        }
        if ((object = analyticsConnector$ConditionalUserProperty.triggerEventName) != null) {
            string2 = "trigger_event_name";
            bundle.putString(string2, (String)object);
        }
        long l10 = analyticsConnector$ConditionalUserProperty.triggerTimeout;
        String string3 = "trigger_timeout";
        bundle.putLong(string3, l10);
        object = analyticsConnector$ConditionalUserProperty.timedOutEventName;
        if (object != null) {
            string2 = "timed_out_event_name";
            bundle.putString(string2, (String)object);
        }
        if ((object = analyticsConnector$ConditionalUserProperty.timedOutEventParams) != null) {
            string2 = "timed_out_event_params";
            bundle.putBundle(string2, (Bundle)object);
        }
        if ((object = analyticsConnector$ConditionalUserProperty.triggeredEventName) != null) {
            string2 = "triggered_event_name";
            bundle.putString(string2, (String)object);
        }
        if ((object = analyticsConnector$ConditionalUserProperty.triggeredEventParams) != null) {
            string2 = "triggered_event_params";
            bundle.putBundle(string2, (Bundle)object);
        }
        l10 = analyticsConnector$ConditionalUserProperty.timeToLive;
        string3 = "time_to_live";
        bundle.putLong(string3, l10);
        object = analyticsConnector$ConditionalUserProperty.expiredEventName;
        if (object != null) {
            string2 = "expired_event_name";
            bundle.putString(string2, (String)object);
        }
        if ((object = analyticsConnector$ConditionalUserProperty.expiredEventParams) != null) {
            string2 = "expired_event_params";
            bundle.putBundle(string2, (Bundle)object);
        }
        l10 = analyticsConnector$ConditionalUserProperty.creationTimestamp;
        bundle.putLong("creation_timestamp", l10);
        boolean bl2 = analyticsConnector$ConditionalUserProperty.active;
        bundle.putBoolean("active", bl2);
        l10 = analyticsConnector$ConditionalUserProperty.triggeredTimestamp;
        bundle.putLong("triggered_timestamp", l10);
        return bundle;
    }

    public static AnalyticsConnector$ConditionalUserProperty zzh(Bundle bundle) {
        long l10;
        long l11;
        boolean bl2;
        String string2;
        long l12;
        Class<Long> clazz = Long.class;
        Object object = String.class;
        Preconditions.checkNotNull(bundle);
        AnalyticsConnector$ConditionalUserProperty analyticsConnector$ConditionalUserProperty = new AnalyticsConnector$ConditionalUserProperty();
        Object object2 = (String)Preconditions.checkNotNull((String)zzgh.zzb(bundle, "origin", object, null));
        analyticsConnector$ConditionalUserProperty.origin = object2;
        object2 = (String)Preconditions.checkNotNull((String)zzgh.zzb(bundle, "name", object, null));
        analyticsConnector$ConditionalUserProperty.name = object2;
        analyticsConnector$ConditionalUserProperty.value = object2 = zzgh.zzb(bundle, "value", Object.class, null);
        analyticsConnector$ConditionalUserProperty.triggerEventName = object2 = (String)zzgh.zzb(bundle, "trigger_event_name", object, null);
        object2 = 0L;
        analyticsConnector$ConditionalUserProperty.triggerTimeout = l12 = ((Long)zzgh.zzb(bundle, "trigger_timeout", clazz, object2)).longValue();
        analyticsConnector$ConditionalUserProperty.timedOutEventName = string2 = (String)zzgh.zzb(bundle, "timed_out_event_name", object, null);
        string2 = (Bundle)zzgh.zzb(bundle, "timed_out_event_params", Bundle.class, null);
        analyticsConnector$ConditionalUserProperty.timedOutEventParams = string2;
        analyticsConnector$ConditionalUserProperty.triggeredEventName = string2 = (String)zzgh.zzb(bundle, "triggered_event_name", object, null);
        string2 = (Bundle)zzgh.zzb(bundle, "triggered_event_params", Bundle.class, null);
        analyticsConnector$ConditionalUserProperty.triggeredEventParams = string2;
        analyticsConnector$ConditionalUserProperty.timeToLive = l12 = ((Long)zzgh.zzb(bundle, "time_to_live", clazz, object2)).longValue();
        analyticsConnector$ConditionalUserProperty.expiredEventName = object = (String)zzgh.zzb(bundle, "expired_event_name", object, null);
        object = (Bundle)zzgh.zzb(bundle, "expired_event_params", Bundle.class, null);
        analyticsConnector$ConditionalUserProperty.expiredEventParams = object;
        Boolean bl3 = Boolean.FALSE;
        analyticsConnector$ConditionalUserProperty.active = bl2 = ((Boolean)zzgh.zzb(bundle, "active", Boolean.class, bl3)).booleanValue();
        analyticsConnector$ConditionalUserProperty.creationTimestamp = l11 = ((Long)zzgh.zzb(bundle, "creation_timestamp", clazz, object2)).longValue();
        analyticsConnector$ConditionalUserProperty.triggeredTimestamp = l10 = ((Long)zzgh.zzb(bundle, "triggered_timestamp", clazz, object2)).longValue();
        return analyticsConnector$ConditionalUserProperty;
    }

    public static boolean zzi(String string2) {
        int n10;
        if (string2 == null) {
            return false;
        }
        int n11 = string2.length();
        if (n11 == 0) {
            return false;
        }
        n11 = string2.codePointAt(0);
        int n12 = Character.isLetter(n11);
        if (n12 == 0) {
            return false;
        }
        n12 = string2.length();
        for (n11 = Character.charCount(n11); n11 < n12; n11 += n10) {
            int n13;
            n10 = string2.codePointAt(n11);
            if (n10 != (n13 = 95) && (n13 = (int)(Character.isLetterOrDigit(n10) ? 1 : 0)) == 0) {
                return false;
            }
            n10 = Character.charCount(n10);
        }
        return true;
    }

    public static boolean zzj(String string2) {
        int n10;
        if (string2 == null) {
            return false;
        }
        int n11 = string2.length();
        if (n11 == 0) {
            return false;
        }
        n11 = string2.codePointAt(0);
        int n12 = Character.isLetter(n11);
        int n13 = 95;
        if (n12 == 0 && n11 != n13) {
            return false;
        }
        n12 = string2.length();
        for (n11 = Character.charCount(n11); n11 < n12; n11 += n10) {
            boolean bl2;
            n10 = string2.codePointAt(n11);
            if (n10 != n13 && !(bl2 = Character.isLetterOrDigit(n10))) {
                return false;
            }
            n10 = Character.charCount(n10);
        }
        return true;
    }

    public static String zzk(String string2) {
        String string3 = zzgi.zza(string2);
        if (string3 != null) {
            return string3;
        }
        return string2;
    }

    public static String zzl(String string2) {
        String string3 = zzgi.zzb(string2);
        if (string3 != null) {
            return string3;
        }
        return string2;
    }

    public static void zzm(String string2, String string3, Bundle bundle) {
        String string4 = "clx";
        boolean bl2 = string4.equals(string2);
        if (bl2 && (bl2 = (string2 = "_ae").equals(string3))) {
            long l10 = 1L;
            string4 = "_r";
            bundle.putLong(string4, l10);
        }
    }
}

