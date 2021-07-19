/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.text.TextUtils
 *  org.json.JSONException
 */
package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class Storage {
    private static final Lock zaaj;
    private static Storage zaak;
    private final Lock zaal;
    private final SharedPreferences zaam;

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        zaaj = reentrantLock;
    }

    private Storage(Context context) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.zaal = reentrantLock;
        context = context.getSharedPreferences("com.google.android.gms.signin", 0);
        this.zaam = context;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Storage getInstance(Context object) {
        Preconditions.checkNotNull(object);
        Lock lock = zaaj;
        lock.lock();
        try {
            Storage storage = zaak;
            if (storage == null) {
                Context context = object.getApplicationContext();
                zaak = storage = new Storage(context);
            }
            Storage storage2 = zaak;
            lock.unlock();
            return storage2;
        }
        catch (Throwable throwable) {
            zaaj.unlock();
            throw throwable;
        }
    }

    private final void zaa(String string2, String string3) {
        Lock lock = this.zaal;
        lock.lock();
        try {
            lock = this.zaam;
            lock = lock.edit();
            string2 = lock.putString(string2, string3);
            string2.apply();
            return;
        }
        finally {
            this.zaal.unlock();
        }
    }

    private static String zab(String string2, String string3) {
        int n10 = String.valueOf(string2).length() + 1;
        int n11 = String.valueOf(string3).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += n11);
        stringBuilder.append(string2);
        stringBuilder.append(":");
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    private final GoogleSignInAccount zad(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return null;
        }
        String string3 = "googleSignInAccount";
        string2 = Storage.zab(string3, string2);
        if ((string2 = this.zaf(string2)) != null) {
            try {
                return GoogleSignInAccount.zaa(string2);
            }
            catch (JSONException jSONException) {}
        }
        return null;
    }

    private final GoogleSignInOptions zae(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return null;
        }
        String string3 = "googleSignInOptions";
        string2 = Storage.zab(string3, string2);
        if ((string2 = this.zaf(string2)) != null) {
            try {
                return GoogleSignInOptions.zab(string2);
            }
            catch (JSONException jSONException) {}
        }
        return null;
    }

    private final String zaf(String string2) {
        Lock lock = this.zaal;
        lock.lock();
        try {
            lock = this.zaam;
            string2 = lock.getString(string2, null);
            return string2;
        }
        finally {
            this.zaal.unlock();
        }
    }

    private final void zag(String string2) {
        Lock lock = this.zaal;
        lock.lock();
        try {
            lock = this.zaam;
            lock = lock.edit();
            string2 = lock.remove(string2);
            string2.apply();
            return;
        }
        finally {
            this.zaal.unlock();
        }
    }

    public void clear() {
        Lock lock = this.zaal;
        lock.lock();
        try {
            lock = this.zaam;
            lock = lock.edit();
            lock = lock.clear();
            lock.apply();
            return;
        }
        finally {
            this.zaal.unlock();
        }
    }

    public GoogleSignInAccount getSavedDefaultGoogleSignInAccount() {
        String string2 = this.zaf("defaultGoogleSignInAccount");
        return this.zad(string2);
    }

    public GoogleSignInOptions getSavedDefaultGoogleSignInOptions() {
        String string2 = this.zaf("defaultGoogleSignInAccount");
        return this.zae(string2);
    }

    public String getSavedRefreshToken() {
        return this.zaf("refreshToken");
    }

    public void saveDefaultGoogleSignInAccount(GoogleSignInAccount object, GoogleSignInOptions object2) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        String string2 = ((GoogleSignInAccount)object).zab();
        this.zaa("defaultGoogleSignInAccount", string2);
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        string2 = ((GoogleSignInAccount)object).zab();
        String string3 = Storage.zab("googleSignInAccount", string2);
        object = ((GoogleSignInAccount)object).zac();
        this.zaa(string3, (String)object);
        object = Storage.zab("googleSignInOptions", string2);
        object2 = ((GoogleSignInOptions)object2).zae();
        this.zaa((String)object, (String)object2);
    }

    public final void zaf() {
        String string2 = "defaultGoogleSignInAccount";
        String string3 = this.zaf(string2);
        this.zag(string2);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (!bl2) {
            string2 = Storage.zab("googleSignInAccount", string3);
            this.zag(string2);
            string2 = Storage.zab("googleSignInOptions", string3);
            this.zag(string2);
        }
    }
}

