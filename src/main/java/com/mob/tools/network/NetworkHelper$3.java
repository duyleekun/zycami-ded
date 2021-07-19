/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.network;

import com.mob.tools.network.HttpConnection;
import com.mob.tools.network.HttpResponseCallback;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Hashon;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.HashMap;

public class NetworkHelper$3
implements HttpResponseCallback {
    public final /* synthetic */ NetworkHelper this$0;
    public final /* synthetic */ HashMap val$tmpMap;

    public NetworkHelper$3(NetworkHelper networkHelper, HashMap hashMap) {
        this.this$0 = networkHelper;
        this.val$tmpMap = hashMap;
    }

    public void onResponse(HttpConnection object) {
        int n10 = object.getResponseCode();
        char c10 = '\n';
        Object object2 = "utf-8";
        int n11 = 200;
        if (n10 != n11 && n10 >= (n11 = 300)) {
            StringBuilder stringBuilder = new StringBuilder();
            object = object.getErrorStream();
            object2 = Charset.forName((String)object2);
            InputStreamReader inputStreamReader = new InputStreamReader((InputStream)object, (Charset)object2);
            object = new BufferedReader(inputStreamReader);
            object2 = ((BufferedReader)object).readLine();
            while (object2 != null) {
                int n12 = stringBuilder.length();
                if (n12 > 0) {
                    stringBuilder.append(c10);
                }
                stringBuilder.append((String)object2);
                object2 = ((BufferedReader)object).readLine();
            }
            ((BufferedReader)object).close();
            object = new HashMap();
            Object object3 = stringBuilder.toString();
            ((HashMap)object).put("error", object3);
            Serializable serializable = n10;
            ((HashMap)object).put("status", serializable);
            object3 = new Hashon();
            object = ((Hashon)object3).fromHashMap((HashMap)object);
            serializable = new Throwable((String)object);
            throw serializable;
        }
        CharSequence charSequence = new StringBuilder();
        object = object.getInputStream();
        object2 = Charset.forName((String)object2);
        InputStreamReader inputStreamReader = new InputStreamReader((InputStream)object, (Charset)object2);
        object = new BufferedReader(inputStreamReader);
        object2 = ((BufferedReader)object).readLine();
        while (object2 != null) {
            n11 = charSequence.length();
            if (n11 > 0) {
                charSequence.append(c10);
            }
            charSequence.append((String)object2);
            object2 = ((BufferedReader)object).readLine();
        }
        ((BufferedReader)object).close();
        object = this.val$tmpMap;
        charSequence = charSequence.toString();
        ((HashMap)object).put("resp", charSequence);
    }
}

