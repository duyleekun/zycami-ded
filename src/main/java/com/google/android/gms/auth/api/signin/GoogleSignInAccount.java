/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.accounts.Account
 *  android.net.Uri
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
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.zaa;
import com.google.android.gms.auth.api.signin.zab;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInAccount
extends AbstractSafeParcelable
implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR;
    private static Clock zae;
    private String mId;
    private final int versionCode;
    private String zaf;
    private String zag;
    private String zah;
    private Uri zai;
    private String zaj;
    private long zak;
    private String zal;
    private List zam;
    private String zan;
    private String zao;
    private Set zap;

    static {
        zab zab2 = new zab();
        CREATOR = zab2;
        zae = DefaultClock.getInstance();
    }

    public GoogleSignInAccount(int n10, String string2, String string3, String string4, String string5, Uri uri, String string6, long l10, String string7, List list, String string8, String string9) {
        HashSet hashSet;
        this.zap = hashSet = new HashSet();
        this.versionCode = n10;
        this.mId = string2;
        this.zaf = string3;
        this.zag = string4;
        this.zah = string5;
        this.zai = uri;
        this.zaj = string6;
        this.zak = l10;
        this.zal = string7;
        this.zam = list;
        this.zan = string8;
        this.zao = string9;
    }

    public static GoogleSignInAccount createDefault() {
        Account account = new Account("<<default account>>", "com.google");
        HashSet hashSet = new HashSet();
        String string2 = account.name;
        Long l10 = 0L;
        String string3 = account.name;
        return GoogleSignInAccount.zaa(null, null, string2, null, null, null, null, l10, string3, hashSet);
    }

    public static final /* synthetic */ int zaa(Scope object, Scope object2) {
        object = ((Scope)object).getScopeUri();
        object2 = ((Scope)object2).getScopeUri();
        return ((String)object).compareTo((String)object2);
    }

    public static GoogleSignInAccount zaa(String object) {
        Object object2;
        String string2;
        String string3;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            return null;
        }
        Object object3 = new JSONObject((String)object);
        boolean bl3 = TextUtils.isEmpty((CharSequence)(object = object3.optString("photoUrl", null)));
        if (!bl3) {
            object = Uri.parse((String)object);
            string3 = object;
        } else {
            string3 = null;
        }
        long l10 = Long.parseLong(object3.getString("expirationTime"));
        HashSet<Scope> hashSet = new HashSet<Scope>();
        object = object3.getJSONArray("grantedScopes");
        int n10 = object.length();
        Object object4 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            string2 = object.getString(i10);
            object2 = new Scope(string2);
            hashSet.add((Scope)object2);
        }
        object = object3.optString("id");
        String string4 = object3.optString("tokenId", null);
        object4 = object3.optString("email", null);
        object2 = object3.optString("displayName", null);
        string2 = object3.optString("givenName", null);
        Object object5 = object3.optString("familyName", null);
        Object object6 = l10;
        String string5 = object3.getString("obfuscatedIdentifier");
        String string6 = string4;
        string4 = object4;
        object4 = object2;
        object2 = string2;
        string2 = object5;
        object5 = object6;
        object6 = string5;
        object = GoogleSignInAccount.zaa((String)object, string6, string4, (String)object4, (String)object2, string2, (Uri)string3, (Long)object5, string5, hashSet);
        object3 = object3.optString("serverAuthCode", null);
        ((GoogleSignInAccount)object).zaj = object3;
        return object;
    }

    private static GoogleSignInAccount zaa(String string2, String string3, String string4, String string5, String string6, String string7, Uri uri, Long l10, String string8, Set set) {
        Object object;
        if (l10 == null) {
            long l11 = zae.currentTimeMillis();
            long l12 = 1000L;
            object = l11 /= l12;
        } else {
            object = l10;
        }
        long l13 = (Long)object;
        String string9 = Preconditions.checkNotEmpty(string8);
        object = (Collection)Preconditions.checkNotNull(set);
        ArrayList arrayList = new ArrayList(object);
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, string2, string3, string4, string5, uri, null, l13, string9, arrayList, string6, string7);
        return googleSignInAccount;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final JSONObject zad() {
        JSONObject jSONObject = new JSONObject();
        try {
            Scope[] scopeArray;
            String string2 = this.getId();
            if (string2 != null) {
                string2 = "id";
                String string3 = this.getId();
                jSONObject.put(string2, (Object)string3);
            }
            if ((string2 = this.getIdToken()) != null) {
                string2 = "tokenId";
                String string4 = this.getIdToken();
                jSONObject.put(string2, (Object)string4);
            }
            if ((string2 = this.getEmail()) != null) {
                string2 = "email";
                String string5 = this.getEmail();
                jSONObject.put(string2, (Object)string5);
            }
            if ((string2 = this.getDisplayName()) != null) {
                string2 = "displayName";
                String string6 = this.getDisplayName();
                jSONObject.put(string2, (Object)string6);
            }
            if ((string2 = this.getGivenName()) != null) {
                string2 = "givenName";
                String string7 = this.getGivenName();
                jSONObject.put(string2, (Object)string7);
            }
            if ((string2 = this.getFamilyName()) != null) {
                string2 = "familyName";
                String string8 = this.getFamilyName();
                jSONObject.put(string2, (Object)string8);
            }
            if ((string2 = this.getPhotoUrl()) != null) {
                string2 = "photoUrl";
                Uri uri = this.getPhotoUrl();
                String string9 = uri.toString();
                jSONObject.put(string2, (Object)string9);
            }
            if ((string2 = this.getServerAuthCode()) != null) {
                string2 = "serverAuthCode";
                String string10 = this.getServerAuthCode();
                jSONObject.put(string2, (Object)string10);
            }
            string2 = "expirationTime";
            long l10 = this.zak;
            jSONObject.put(string2, l10);
            string2 = "obfuscatedIdentifier";
            String string11 = this.zal;
            jSONObject.put(string2, (Object)string11);
            string2 = new JSONArray();
            List list = this.zam;
            int n10 = list.size();
            Scope[] scopeArray2 = new Scope[n10];
            Scope[] scopeArray3 = scopeArray = list.toArray(scopeArray2);
            Comparator comparator = zaa.zaq;
            Arrays.sort(scopeArray3, comparator);
            n10 = scopeArray3.length;
            int n11 = 0;
            while (true) {
                if (n11 >= n10) {
                    String string12 = "grantedScopes";
                    jSONObject.put(string12, (Object)string2);
                    return jSONObject;
                }
                Object object = scopeArray3[n11];
                object = ((Scope)object).getScopeUri();
                string2.put(object);
                ++n11;
            }
        }
        catch (JSONException jSONException) {
            RuntimeException runtimeException = new RuntimeException(jSONException);
            throw runtimeException;
        }
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = true;
        if (object == this) {
            return bl3;
        }
        boolean bl4 = object instanceof GoogleSignInAccount;
        if (!bl4) {
            return false;
        }
        object = (GoogleSignInAccount)object;
        Object object2 = ((GoogleSignInAccount)object).zal;
        String string2 = this.zal;
        bl4 = ((String)object2).equals(string2);
        if (bl4 && (bl2 = (object = ((GoogleSignInAccount)object).getRequestedScopes()).equals(object2 = this.getRequestedScopes()))) {
            return bl3;
        }
        return false;
    }

    public Account getAccount() {
        String string2 = this.zag;
        if (string2 == null) {
            return null;
        }
        String string3 = this.zag;
        string2 = new Account(string3, "com.google");
        return string2;
    }

    public String getDisplayName() {
        return this.zah;
    }

    public String getEmail() {
        return this.zag;
    }

    public String getFamilyName() {
        return this.zao;
    }

    public String getGivenName() {
        return this.zan;
    }

    public Set getGrantedScopes() {
        List list = this.zam;
        HashSet hashSet = new HashSet(list);
        return hashSet;
    }

    public String getId() {
        return this.mId;
    }

    public String getIdToken() {
        return this.zaf;
    }

    public Uri getPhotoUrl() {
        return this.zai;
    }

    public Set getRequestedScopes() {
        Collection collection = this.zam;
        HashSet hashSet = new HashSet(collection);
        collection = this.zap;
        hashSet.addAll(collection);
        return hashSet;
    }

    public String getServerAuthCode() {
        return this.zaj;
    }

    public int hashCode() {
        int n10 = (this.zal.hashCode() + 527) * 31;
        int n11 = this.getRequestedScopes().hashCode();
        return n10 + n11;
    }

    public boolean isExpired() {
        Clock clock = zae;
        long l10 = clock.currentTimeMillis() / 1000L;
        long l11 = this.zak;
        long l12 = 300L;
        long l13 = l10 - (l11 -= l12);
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        return object >= 0;
    }

    public GoogleSignInAccount requestExtraScopes(Scope ... scopeArray) {
        if (scopeArray != null) {
            Set set = this.zap;
            Collections.addAll(set, scopeArray);
        }
        return this;
    }

    public void writeToParcel(Parcel parcel, int n10) {
        int n11 = SafeParcelWriter.beginObjectHeader(parcel);
        int n12 = this.versionCode;
        SafeParcelWriter.writeInt(parcel, 1, n12);
        String string2 = this.getId();
        SafeParcelWriter.writeString(parcel, 2, string2, false);
        string2 = this.getIdToken();
        SafeParcelWriter.writeString(parcel, 3, string2, false);
        string2 = this.getEmail();
        SafeParcelWriter.writeString(parcel, 4, string2, false);
        string2 = this.getDisplayName();
        SafeParcelWriter.writeString(parcel, 5, string2, false);
        string2 = this.getPhotoUrl();
        SafeParcelWriter.writeParcelable(parcel, 6, (Parcelable)string2, n10, false);
        Object object = this.getServerAuthCode();
        SafeParcelWriter.writeString(parcel, 7, (String)object, false);
        long l10 = this.zak;
        SafeParcelWriter.writeLong(parcel, 8, l10);
        object = this.zal;
        SafeParcelWriter.writeString(parcel, 9, (String)object, false);
        object = this.zam;
        SafeParcelWriter.writeTypedList(parcel, 10, (List)object, false);
        object = this.getGivenName();
        SafeParcelWriter.writeString(parcel, 11, (String)object, false);
        object = this.getFamilyName();
        SafeParcelWriter.writeString(parcel, 12, (String)object, false);
        SafeParcelWriter.finishObjectHeader(parcel, n11);
    }

    public final String zab() {
        return this.zal;
    }

    public final String zac() {
        JSONObject jSONObject = this.zad();
        jSONObject.remove("serverAuthCode");
        return jSONObject.toString();
    }
}

