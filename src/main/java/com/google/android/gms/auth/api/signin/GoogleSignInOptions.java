/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions$Builder;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.auth.api.signin.internal.HashAccumulator;
import com.google.android.gms.auth.api.signin.zac;
import com.google.android.gms.auth.api.signin.zad;
import com.google.android.gms.common.api.Api$ApiOptions$Optional;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInOptions
extends AbstractSafeParcelable
implements Api$ApiOptions$Optional,
ReflectedParcelable {
    public static final Parcelable.Creator CREATOR;
    public static final GoogleSignInOptions DEFAULT_GAMES_SIGN_IN;
    public static final GoogleSignInOptions DEFAULT_SIGN_IN;
    private static Comparator zaaf;
    public static final Scope zar;
    public static final Scope zas;
    public static final Scope zat;
    public static final Scope zau;
    public static final Scope zav;
    private final int versionCode;
    private final boolean zaaa;
    private String zaab;
    private String zaac;
    private ArrayList zaad;
    private Map zaae;
    private final ArrayList zaw;
    private Account zax;
    private boolean zay;
    private final boolean zaz;

    static {
        Object object = new Scope("profile");
        zar = object;
        object = new Scope("email");
        zas = object;
        object = new Scope("openid");
        zat = object;
        object = new Scope("https://www.googleapis.com/auth/games_lite");
        zau = object;
        Object object2 = new Scope("https://www.googleapis.com/auth/games");
        zav = object2;
        object2 = new GoogleSignInOptions$Builder();
        DEFAULT_SIGN_IN = ((GoogleSignInOptions$Builder)object2).requestId().requestProfile().build();
        object2 = new GoogleSignInOptions$Builder();
        Scope[] scopeArray = new Scope[]{};
        DEFAULT_GAMES_SIGN_IN = ((GoogleSignInOptions$Builder)object2).requestScopes((Scope)object, scopeArray).build();
        object = new zad();
        CREATOR = object;
        zaaf = object = new zac();
    }

    public GoogleSignInOptions(int n10, ArrayList arrayList, Account account, boolean bl2, boolean bl3, boolean bl4, String string2, String string3, ArrayList arrayList2) {
        Map map = GoogleSignInOptions.zaa(arrayList2);
        this(n10, arrayList, account, bl2, bl3, bl4, string2, string3, map);
    }

    private GoogleSignInOptions(int n10, ArrayList collection, Account account, boolean bl2, boolean bl3, boolean bl4, String string2, String string3, Map map) {
        ArrayList arrayList;
        this.versionCode = n10;
        this.zaw = collection;
        this.zax = account;
        this.zay = bl2;
        this.zaz = bl3;
        this.zaaa = bl4;
        this.zaab = string2;
        this.zaac = string3;
        collection = map.values();
        this.zaad = arrayList = new ArrayList(collection);
        this.zaae = map;
    }

    public /* synthetic */ GoogleSignInOptions(int n10, ArrayList arrayList, Account account, boolean bl2, boolean bl3, boolean bl4, String string2, String string3, Map map, zac zac2) {
        this(3, arrayList, account, bl2, bl3, bl4, string2, string3, map);
    }

    public static /* synthetic */ ArrayList zaa(GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.zaw;
    }

    private static Map zaa(List object) {
        boolean bl2;
        HashMap<Integer, GoogleSignInOptionsExtensionParcelable> hashMap = new HashMap<Integer, GoogleSignInOptionsExtensionParcelable>();
        if (object == null) {
            return hashMap;
        }
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable = (GoogleSignInOptionsExtensionParcelable)object.next();
            int n10 = googleSignInOptionsExtensionParcelable.getType();
            Integer n11 = n10;
            hashMap.put(n11, googleSignInOptionsExtensionParcelable);
        }
        return hashMap;
    }

    public static GoogleSignInOptions zab(String hashSet) {
        Account account;
        Scope scope;
        boolean bl2 = TextUtils.isEmpty((CharSequence)((Object)hashSet));
        if (bl2) {
            return null;
        }
        JSONObject jSONObject = new JSONObject((String)((Object)hashSet));
        hashSet = new HashSet<Scope>();
        Object object = jSONObject.getJSONArray("scopes");
        int n10 = object.length();
        String string2 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            String string3 = object.getString(i10);
            scope = new Scope(string3);
            hashSet.add(scope);
        }
        object = jSONObject.optString("accountName", null);
        n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
        if (n10 == 0) {
            Account account2;
            string2 = "com.google";
            account = account2 = new Account((String)object, string2);
        } else {
            account = null;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        boolean bl3 = jSONObject.getBoolean("idTokenRequested");
        boolean bl4 = jSONObject.getBoolean("serverAuthRequested");
        boolean bl5 = jSONObject.getBoolean("forceCodeForRefreshToken");
        String string4 = jSONObject.optString("serverClientId", null);
        String string5 = jSONObject.optString("hostedDomain", null);
        HashMap hashMap = new HashMap();
        scope = object;
        object = new GoogleSignInOptions(3, arrayList, account, bl3, bl4, bl5, string4, string5, hashMap);
        return object;
    }

    public static /* synthetic */ Map zab(List list) {
        return GoogleSignInOptions.zaa(list);
    }

    public static /* synthetic */ boolean zab(GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.zaz;
    }

    public static /* synthetic */ boolean zac(GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.zaaa;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final JSONObject zad() {
        JSONObject jSONObject = new JSONObject();
        try {
            String string2;
            Object object;
            JSONArray jSONArray = new JSONArray();
            Object object2 = this.zaw;
            Comparator comparator = zaaf;
            Collections.sort(object2, comparator);
            object2 = this.zaw;
            int n10 = ((ArrayList)object2).size();
            for (int i10 = 0; i10 < n10; ++i10, object = ((Scope)object).getScopeUri()) {
                object = ((ArrayList)object2).get(i10);
                object = (Scope)object;
                jSONArray.put(object);
            }
            object2 = "scopes";
            jSONObject.put((String)object2, (Object)jSONArray);
            Account account = this.zax;
            if (account != null) {
                object2 = "accountName";
                String string3 = account.name;
                jSONObject.put((String)object2, (Object)string3);
            }
            String string4 = "idTokenRequested";
            boolean bl2 = this.zay;
            jSONObject.put(string4, bl2);
            String string5 = "forceCodeForRefreshToken";
            bl2 = this.zaaa;
            jSONObject.put(string5, bl2);
            String string6 = "serverAuthRequested";
            bl2 = this.zaz;
            jSONObject.put(string6, bl2);
            String string7 = this.zaab;
            boolean bl3 = TextUtils.isEmpty((CharSequence)string7);
            if (!bl3) {
                String string8 = "serverClientId";
                object2 = this.zaab;
                jSONObject.put(string8, object2);
            }
            if (!(bl3 = TextUtils.isEmpty((CharSequence)(string2 = this.zaac)))) {
                String string9 = "hostedDomain";
                object2 = this.zaac;
                jSONObject.put(string9, object2);
            }
            return jSONObject;
        }
        catch (JSONException jSONException) {
            RuntimeException runtimeException = new RuntimeException(jSONException);
            throw runtimeException;
        }
    }

    public static /* synthetic */ boolean zad(GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.zay;
    }

    public static /* synthetic */ String zae(GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.zaab;
    }

    public static /* synthetic */ Account zaf(GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.zax;
    }

    public static /* synthetic */ String zag(GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.zaac;
    }

    public static /* synthetic */ ArrayList zah(GoogleSignInOptions googleSignInOptions) {
        return googleSignInOptions.zaad;
    }

    public boolean equals(Object object) {
        block32: {
            int n10;
            int n11;
            block36: {
                Object object2;
                Object object3;
                block35: {
                    block34: {
                        block33: {
                            if (object == null) {
                                return false;
                            }
                            try {
                                object = (GoogleSignInOptions)object;
                            }
                            catch (ClassCastException classCastException) {}
                            object3 = this.zaad;
                            n11 = ((ArrayList)object3).size();
                            if (n11 > 0) break block32;
                            object3 = ((GoogleSignInOptions)object).zaad;
                            n11 = ((ArrayList)object3).size();
                            if (n11 > 0) break block32;
                            object3 = this.zaw;
                            n11 = ((ArrayList)object3).size();
                            object2 = ((GoogleSignInOptions)object).getScopes();
                            n10 = ((ArrayList)object2).size();
                            if (n11 != n10) break block32;
                            object3 = this.zaw;
                            object2 = ((GoogleSignInOptions)object).getScopes();
                            n11 = (int)(((AbstractCollection)object3).containsAll((Collection<?>)object2) ? 1 : 0);
                            if (n11 == 0) break block32;
                            object3 = this.zax;
                            if (object3 != null) break block33;
                            object3 = ((GoogleSignInOptions)object).getAccount();
                            if (object3 != null) break block32;
                            break block34;
                        }
                        object2 = ((GoogleSignInOptions)object).getAccount();
                        n11 = (int)(object3.equals(object2) ? 1 : 0);
                        if (n11 == 0) break block32;
                    }
                    object3 = this.zaab;
                    n11 = (int)(TextUtils.isEmpty((CharSequence)object3) ? 1 : 0);
                    if (n11 == 0) break block35;
                    object3 = ((GoogleSignInOptions)object).getServerClientId();
                    n11 = (int)(TextUtils.isEmpty((CharSequence)object3) ? 1 : 0);
                    if (n11 == 0) break block32;
                    break block36;
                }
                object3 = this.zaab;
                object2 = ((GoogleSignInOptions)object).getServerClientId();
                n11 = (int)(((String)object3).equals(object2) ? 1 : 0);
                if (n11 == 0) break block32;
            }
            n11 = (int)(this.zaaa ? 1 : 0);
            n10 = (int)(((GoogleSignInOptions)object).isForceCodeForRefreshToken() ? 1 : 0);
            if (n11 != n10) break block32;
            n11 = (int)(this.zay ? 1 : 0);
            n10 = (int)(((GoogleSignInOptions)object).isIdTokenRequested() ? 1 : 0);
            if (n11 != n10) break block32;
            n11 = (int)(this.zaz ? 1 : 0);
            int n12 = ((GoogleSignInOptions)object).isServerAuthCodeRequested();
            if (n11 == n12) {
                return true;
            }
        }
        return false;
    }

    public Account getAccount() {
        return this.zax;
    }

    public ArrayList getExtensions() {
        return this.zaad;
    }

    public Scope[] getScopeArray() {
        ArrayList arrayList = this.zaw;
        Scope[] scopeArray = new Scope[arrayList.size()];
        return arrayList.toArray(scopeArray);
    }

    public ArrayList getScopes() {
        ArrayList arrayList = this.zaw;
        ArrayList arrayList2 = new ArrayList(arrayList);
        return arrayList2;
    }

    public String getServerClientId() {
        return this.zaab;
    }

    public int hashCode() {
        Object object = new ArrayList();
        Object object2 = this.zaw;
        int n10 = ((ArrayList)object2).size();
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object3 = ((ArrayList)object2).get(i10);
            object3 = ((Scope)object3).getScopeUri();
            ((ArrayList)object).add(object3);
        }
        Collections.sort(object);
        object2 = new HashAccumulator();
        object = ((HashAccumulator)object2).addObject(object);
        object2 = this.zax;
        object = ((HashAccumulator)object).addObject(object2);
        object2 = this.zaab;
        object = ((HashAccumulator)object).addObject(object2);
        boolean bl2 = this.zaaa;
        object = ((HashAccumulator)object).zaa(bl2);
        bl2 = this.zay;
        object = ((HashAccumulator)object).zaa(bl2);
        bl2 = this.zaz;
        return ((HashAccumulator)object).zaa(bl2).hash();
    }

    public boolean isForceCodeForRefreshToken() {
        return this.zaaa;
    }

    public boolean isIdTokenRequested() {
        return this.zay;
    }

    public boolean isServerAuthCodeRequested() {
        return this.zaz;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        int n11 = SafeParcelWriter.beginObjectHeader(parcel);
        int n12 = this.versionCode;
        SafeParcelWriter.writeInt(parcel, 1, n12);
        ArrayList arrayList = this.getScopes();
        SafeParcelWriter.writeTypedList(parcel, 2, arrayList, false);
        arrayList = this.getAccount();
        SafeParcelWriter.writeParcelable(parcel, 3, (Parcelable)arrayList, n10, false);
        n10 = (int)(this.isIdTokenRequested() ? 1 : 0);
        SafeParcelWriter.writeBoolean(parcel, 4, n10 != 0);
        n10 = (int)(this.isServerAuthCodeRequested() ? 1 : 0);
        SafeParcelWriter.writeBoolean(parcel, 5, n10 != 0);
        n10 = (int)(this.isForceCodeForRefreshToken() ? 1 : 0);
        SafeParcelWriter.writeBoolean(parcel, 6, n10 != 0);
        Object object = this.getServerClientId();
        SafeParcelWriter.writeString(parcel, 7, (String)object, false);
        object = this.zaac;
        SafeParcelWriter.writeString(parcel, 8, (String)object, false);
        object = this.getExtensions();
        SafeParcelWriter.writeTypedList(parcel, 9, (List)object, false);
        SafeParcelWriter.finishObjectHeader(parcel, n11);
    }

    public final String zae() {
        return this.zad().toString();
    }
}

