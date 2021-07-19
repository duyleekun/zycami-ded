/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.xiaomi.miui.pushads.sdk.f
 *  com.xiaomi.miui.pushads.sdk.k$a
 *  org.apache.http.HttpEntity
 *  org.apache.http.client.ClientProtocolException
 *  org.apache.http.client.entity.UrlEncodedFormEntity
 *  org.apache.http.client.methods.HttpPost
 *  org.apache.http.client.methods.HttpUriRequest
 *  org.apache.http.impl.client.DefaultHttpClient
 *  org.apache.http.message.BasicNameValuePair
 */
package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.miui.pushads.sdk.f;
import com.xiaomi.miui.pushads.sdk.k;
import com.xiaomi.push.cm;
import com.xiaomi.push.cr;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class cq {
    public static int a(String string2, String string3, cm object) {
        LinkedList<Object> linkedList = new LinkedList<Object>();
        String string4 = ((cm)object).a;
        String string5 = "logValue";
        Object object2 = new BasicNameValuePair(string5, string4);
        linkedList.add(object2);
        string4 = "appId";
        object2 = new BasicNameValuePair(string4, string2);
        linkedList.add(object2);
        object2 = new StringBuilder();
        int n10 = ((cm)object).a;
        ((StringBuilder)object2).append(n10);
        ((StringBuilder)object2).append("");
        object = ((StringBuilder)object2).toString();
        object2 = "showType";
        string2 = new BasicNameValuePair((String)object2, (String)object);
        linkedList.add(string2);
        string2 = cr.a(linkedList, string3);
        object = "s";
        string3 = new BasicNameValuePair((String)object, string2);
        linkedList.add(string3);
        string3 = "http://new.api.ad.xiaomi.com/logNotificationAdActions";
        string2 = new HttpPost(string3);
        object = "UTF-8";
        string3 = new UrlEncodedFormEntity(linkedList, (String)object);
        string2.setEntity((HttpEntity)string3);
        string3 = new DefaultHttpClient();
        string2 = string3.execute((HttpUriRequest)string2);
        int n11 = 200;
        string2 = string2.getStatusLine();
        try {
            int n12 = string2.getStatusCode();
            if (n11 == n12) {
                return 0;
            }
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
        catch (ClientProtocolException clientProtocolException) {
            clientProtocolException.printStackTrace();
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
        }
        return 1;
    }

    public static boolean a(Context context) {
        boolean bl2;
        k.a a10 = k.a.a;
        if (a10 == (context = f.a((Context)context))) {
            bl2 = false;
            context = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }
}

