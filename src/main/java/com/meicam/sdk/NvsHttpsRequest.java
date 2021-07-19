/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

public class NvsHttpsRequest {
    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String httpsRequest(String object, Map object2) {
        boolean bl2;
        StringBuffer stringBuffer = new StringBuffer();
        Object object3 = new StringBuilder();
        ((StringBuilder)object3).append((String)object);
        ((StringBuilder)object3).append("?");
        object = ((StringBuilder)object3).toString();
        int n10 = object2.size();
        object2 = object2.entrySet().iterator();
        int n11 = 0;
        while (bl2 = object2.hasNext()) {
            Object object4 = object2.next();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object);
            object = (String)object4.getKey();
            stringBuilder.append((String)object);
            stringBuilder.append("=");
            object = (String)object4.getValue();
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            if (++n11 >= n10) continue;
            object4 = new StringBuilder();
            ((StringBuilder)object4).append((String)object);
            ((StringBuilder)object4).append("&");
            object = ((StringBuilder)object4).toString();
        }
        try {
            object2 = new URL((String)object);
            object = ((URL)object2).openConnection();
            object = FirebasePerfUrlConnection.instrument(object);
            object = (URLConnection)object;
            object = (HttpURLConnection)object;
            object2 = "GET";
            ((HttpURLConnection)object).setRequestMethod((String)object2);
            ((URLConnection)object).setUseCaches(false);
            int n12 = 3000;
            ((URLConnection)object).setConnectTimeout(n12);
            ((URLConnection)object).setReadTimeout(n12);
            ((URLConnection)object).connect();
            object = ((URLConnection)object).getInputStream();
            object3 = new InputStreamReader((InputStream)object);
            object2 = new BufferedReader((Reader)object3);
            while (true) {
                if ((object = ((BufferedReader)object2).readLine()) == null) {
                    ((BufferedReader)object2).close();
                    return stringBuffer.toString();
                }
                stringBuffer.append((String)object);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return stringBuffer.toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String postHttpsRequest(String object, Map object2, String object3) {
        int n10;
        StringBuffer stringBuffer = new StringBuffer();
        Object object4 = new StringBuilder();
        ((StringBuilder)object4).append((String)object);
        ((StringBuilder)object4).append("?");
        object = ((StringBuilder)object4).toString();
        int n11 = object2.size();
        object2 = object2.entrySet().iterator();
        int n12 = 0;
        while (true) {
            boolean bl2 = object2.hasNext();
            n10 = 1;
            if (!bl2) break;
            Object object5 = object2.next();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object);
            object = (String)object5.getKey();
            stringBuilder.append((String)object);
            stringBuilder.append("=");
            object = (String)object5.getValue();
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            if ((n12 += n10) >= n11) continue;
            object5 = new StringBuilder();
            ((StringBuilder)object5).append((String)object);
            ((StringBuilder)object5).append("&");
            object = ((StringBuilder)object5).toString();
        }
        try {
            object2 = new URL((String)object);
            object = ((URL)object2).openConnection();
            object = FirebasePerfUrlConnection.instrument(object);
            object = (URLConnection)object;
            object = (HttpURLConnection)object;
            object2 = "POST";
            ((HttpURLConnection)object).setRequestMethod((String)object2);
            ((URLConnection)object).setUseCaches(false);
            int n13 = 3000;
            ((URLConnection)object).setConnectTimeout(n13);
            ((URLConnection)object).setReadTimeout(n13);
            ((URLConnection)object).setDoOutput(n10 != 0);
            ((URLConnection)object).setDoInput(n10 != 0);
            object2 = "Content-Type";
            object4 = "application/json";
            ((URLConnection)object).setRequestProperty((String)object2, (String)object4);
            ((URLConnection)object).connect();
            object4 = ((URLConnection)object).getOutputStream();
            object2 = new DataOutputStream((OutputStream)object4);
            ((DataOutputStream)object2).writeBytes((String)object3);
            ((DataOutputStream)object2).flush();
            ((FilterOutputStream)object2).close();
            object = ((URLConnection)object).getInputStream();
            object3 = new InputStreamReader((InputStream)object);
            object2 = new BufferedReader((Reader)object3);
            while (true) {
                if ((object = ((BufferedReader)object2).readLine()) == null) {
                    ((BufferedReader)object2).close();
                    return stringBuffer.toString();
                }
                stringBuffer.append((String)object);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return stringBuffer.toString();
    }
}

