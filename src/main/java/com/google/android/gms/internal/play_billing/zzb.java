/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.util.Log
 *  org.json.JSONException
 */
package com.google.android.gms.internal.play_billing;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.android.billingclient.api.Purchase;
import d.b.a.b.b;
import d.b.a.b.g;
import d.b.a.b.h;
import d.b.a.b.h$a;
import d.b.a.b.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;

public final class zzb {
    public static int zza = Runtime.getRuntime().availableProcessors();

    public static int zza(Intent intent, String string2) {
        return zzb.zzb(intent, string2).b();
    }

    public static int zza(Bundle object, String string2) {
        int n10 = 6;
        if (object == null) {
            zzb.zzb(string2, "Unexpected null bundle received!");
            return n10;
        }
        String string3 = "RESPONSE_CODE";
        if ((object = object.get(string3)) == null) {
            zzb.zza(string2, "getResponseCodeFromBundle() got null response code, assuming OK");
            return 0;
        }
        boolean bl2 = object instanceof Integer;
        if (bl2) {
            return (Integer)object;
        }
        string3 = "Unexpected type for bundle response code: ";
        int n11 = ((String)(object = String.valueOf(object.getClass().getName()))).length();
        object = n11 != 0 ? string3.concat((String)object) : new String(string3);
        zzb.zzb(string2, (String)object);
        return n10;
    }

    public static Bundle zza(b b10, String string2) {
        b10 = new Bundle();
        b10.putString("playBillingLibraryVersion", string2);
        return b10;
    }

    public static Bundle zza(g object, boolean bl2, boolean bl3, String arrayList) {
        Bundle bundle = new Bundle();
        String string2 = "playBillingLibraryVersion";
        bundle.putString(string2, (String)((Object)arrayList));
        int n10 = ((g)object).c();
        if (n10 != 0) {
            n10 = ((g)object).c();
            string2 = "prorationMode";
            bundle.putInt(string2, n10);
        }
        if ((n10 = (int)(TextUtils.isEmpty((CharSequence)((Object)(arrayList = ((g)object).n()))) ? 1 : 0)) == 0) {
            arrayList = ((g)object).n();
            string2 = "accountId";
            bundle.putString(string2, (String)((Object)arrayList));
        }
        if ((n10 = (int)(TextUtils.isEmpty((CharSequence)((Object)(arrayList = ((g)object).r()))) ? 1 : 0)) == 0) {
            arrayList = ((g)object).r();
            string2 = "obfuscatedProfileId";
            bundle.putString(string2, (String)((Object)arrayList));
        }
        n10 = (int)(((g)object).g() ? 1 : 0);
        boolean bl4 = true;
        if (n10 != 0) {
            arrayList = "vr";
            bundle.putBoolean((String)((Object)arrayList), bl4);
        }
        if ((n10 = (int)(TextUtils.isEmpty((CharSequence)((Object)(arrayList = ((g)object).a()))) ? 1 : 0)) == 0) {
            String string3;
            Object object2 = new String[bl4];
            object2[0] = string3 = ((g)object).a();
            object2 = Arrays.asList(object2);
            arrayList = new ArrayList(object2);
            object2 = "skusToReplace";
            bundle.putStringArrayList((String)object2, arrayList);
        }
        if ((n10 = (int)(TextUtils.isEmpty((CharSequence)((Object)(arrayList = ((g)object).b()))) ? 1 : 0)) == 0) {
            object = ((g)object).b();
            arrayList = "oldSkuPurchaseToken";
            bundle.putString((String)((Object)arrayList), (String)object);
        }
        if (bl2 && bl3) {
            object = "enablePendingPurchases";
            bundle.putBoolean((String)object, bl4);
        }
        return bundle;
    }

    public static Bundle zza(i i10, boolean bl2, String string2) {
        i10 = new Bundle();
        if (bl2) {
            String string3 = "playBillingLibraryVersion";
            i10.putString(string3, string2);
        }
        return i10;
    }

    public static Bundle zza(boolean bl2, boolean bl3, String string2) {
        Bundle bundle = new Bundle();
        String string3 = "playBillingLibraryVersion";
        bundle.putString(string3, string2);
        if (bl2 && bl3) {
            bl2 = true;
            String string4 = "enablePendingPurchases";
            bundle.putBoolean(string4, bl2);
        }
        return bundle;
    }

    public static Bundle zza(boolean bl2, boolean bl3, boolean bl4, String string2, String string3) {
        Bundle bundle = new Bundle();
        if (bl2) {
            String string4 = "playBillingLibraryVersion";
            bundle.putString(string4, string2);
        }
        if (bl2 && bl4) {
            bl2 = true;
            String string5 = "enablePendingPurchases";
            bundle.putBoolean(string5, bl2);
        }
        if (bl3 && string3 != null) {
            String string6 = "SKU_PACKAGE_NAME";
            bundle.putString(string6, string3);
        }
        return bundle;
    }

    public static List zza(Bundle object) {
        int n10 = 0;
        Object object2 = null;
        if (object == null) {
            return null;
        }
        Object object3 = object.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
        Object object4 = object.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
        ArrayList<Object> arrayList = new ArrayList<Object>();
        if (object3 != null && object4 != null) {
            object = null;
            for (int i10 = 0; i10 < (n10 = object3.size()) && i10 < (n10 = object4.size()); ++i10) {
                object2 = (String)object3.get(i10);
                String string2 = (String)object4.get(i10);
                if ((object2 = zzb.zzc((String)object2, string2)) == null) continue;
                arrayList.add(object2);
            }
        } else {
            object3 = "BillingHelper";
            zzb.zzb((String)object3, "Couldn't find purchase lists, trying to find single data.");
            object4 = object.getString("INAPP_PURCHASE_DATA");
            String string3 = "INAPP_DATA_SIGNATURE";
            object = object.getString(string3);
            object = zzb.zzc((String)object4, (String)object);
            if (object == null) {
                zzb.zzb((String)object3, "Couldn't find single purchase data as well.");
                return null;
            }
            arrayList.add(object);
        }
        return arrayList;
    }

    public static void zza(String string2, String string3) {
        boolean bl2 = Log.isLoggable((String)string2, (int)2);
        if (bl2) {
            Log.v((String)string2, (String)string3);
        }
    }

    public static h zzb(Intent object, String string2) {
        if (object == null) {
            zzb.zzb("BillingHelper", "Got null intent!");
            return h.c().c(6).b("An internal error occurred.").a();
        }
        h$a h$a = h.c();
        int n10 = zzb.zza(object.getExtras(), string2);
        h$a = h$a.c(n10);
        object = zzb.zzb(object.getExtras(), string2);
        return h$a.b((String)object).a();
    }

    public static String zzb(Bundle object, String string2) {
        String string3 = "";
        if (object == null) {
            zzb.zzb(string2, "Unexpected null bundle received!");
            return string3;
        }
        String string4 = "DEBUG_MESSAGE";
        if ((object = object.get(string4)) == null) {
            zzb.zza(string2, "getDebugMessageFromBundle() got null response code, assuming OK");
            return string3;
        }
        boolean bl2 = object instanceof String;
        if (bl2) {
            return (String)object;
        }
        string4 = "Unexpected type for debug message: ";
        int n10 = ((String)(object = String.valueOf(object.getClass().getName()))).length();
        object = n10 != 0 ? string4.concat((String)object) : new String(string4);
        zzb.zzb(string2, (String)object);
        return string3;
    }

    public static void zzb(String string2, String string3) {
        boolean bl2 = Log.isLoggable((String)string2, (int)5);
        if (bl2) {
            Log.w((String)string2, (String)string3);
        }
    }

    private static Purchase zzc(String string2, String string3) {
        Purchase purchase = null;
        String string4 = "BillingHelper";
        if (string2 != null && string3 != null) {
            Object object;
            try {
                object = new Purchase(string2, string3);
                purchase = object;
            }
            catch (JSONException jSONException) {
                string2 = String.valueOf((Object)jSONException);
                int n10 = String.valueOf(string2).length() + 47;
                object = new StringBuilder(n10);
                string3 = "Got JSONException while parsing purchase data: ";
                ((StringBuilder)object).append(string3);
                ((StringBuilder)object).append(string2);
                string2 = ((StringBuilder)object).toString();
                zzb.zzb(string4, string2);
            }
            return purchase;
        }
        zzb.zzb(string4, "Received a bad purchase data.");
        return null;
    }
}

