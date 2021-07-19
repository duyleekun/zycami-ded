/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.util.Log
 */
package com.google.android.gms.ads.identifier;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.zzc;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public final class zza
extends Thread {
    private final /* synthetic */ Map zzl;

    public zza(AdvertisingIdClient advertisingIdClient, Map map) {
        this.zzl = map;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void run() {
        void var4_7;
        CharSequence charSequence;
        String string2;
        Object object;
        Object object2;
        String string3;
        String string4;
        block11: {
            int n10;
            block10: {
                string4 = ". ";
                string3 = "HttpUrlPinger";
                new zzc();
                object2 = this.zzl;
                Object object3 = Uri.parse((String)"https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
                object = object2.keySet().iterator();
                while ((n10 = object.hasNext()) != 0) {
                    string2 = (String)object.next();
                    charSequence = (String)object2.get(string2);
                    object3.appendQueryParameter(string2, (String)charSequence);
                }
                object2 = object3.build().toString();
                try {
                    object3 = new URL((String)object2);
                    object3 = ((URL)object3).openConnection();
                    object3 = (HttpURLConnection)object3;
                }
                catch (RuntimeException runtimeException) {
                    break block10;
                }
                catch (IOException iOException) {
                    // empty catch block
                    break block10;
                }
                catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                    object = indexOutOfBoundsException.getMessage();
                    n10 = String.valueOf(object2).length() + 32;
                    int n11 = String.valueOf(object).length();
                    charSequence = new StringBuilder(n10 += n11);
                    string2 = "Error while parsing ping URL: ";
                    break block11;
                }
                try {
                    int n12 = ((HttpURLConnection)object3).getResponseCode();
                    n10 = 200;
                    if (n12 >= n10 && n12 < (n10 = 300)) return;
                    string2 = String.valueOf(object2);
                    n10 = string2.length() + 65;
                    charSequence = new StringBuilder(n10);
                    string2 = "Received non-success response code ";
                    ((StringBuilder)charSequence).append(string2);
                    ((StringBuilder)charSequence).append(n12);
                    object = " from pinging URL: ";
                    ((StringBuilder)charSequence).append((String)object);
                    ((StringBuilder)charSequence).append((String)object2);
                    object = ((StringBuilder)charSequence).toString();
                    Log.w((String)string3, (String)object);
                    return;
                }
                finally {
                    ((HttpURLConnection)object3).disconnect();
                }
            }
            object = var4_7.getMessage();
            n10 = String.valueOf(object2).length() + 27;
            int n13 = String.valueOf(object).length();
            charSequence = new StringBuilder(n10 += n13);
            string2 = "Error while pinging URL: ";
        }
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append((String)object2);
        ((StringBuilder)charSequence).append(string4);
        ((StringBuilder)charSequence).append((String)object);
        string4 = ((StringBuilder)charSequence).toString();
        Log.w((String)string3, (String)string4, (Throwable)var4_7);
    }
}

