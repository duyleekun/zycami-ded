/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.alibaba.sdk.android.oss.common.auth;

import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.common.auth.OSSAuthCredentialsProvider$AuthDecoder;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationToken;
import com.alibaba.sdk.android.oss.common.utils.IOUtils;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONObject;

public class OSSAuthCredentialsProvider
extends OSSFederationCredentialProvider {
    private String mAuthServerUrl;
    private OSSAuthCredentialsProvider$AuthDecoder mDecoder;

    public OSSAuthCredentialsProvider(String string2) {
        this.mAuthServerUrl = string2;
    }

    public OSSFederationToken getFederationToken() {
        Object object;
        Object object2;
        block31: {
            block30: {
                try {
                    object2 = this.mAuthServerUrl;
                }
                catch (Exception exception) {
                    object2 = new ClientException(exception);
                    throw object2;
                }
                object = new URL((String)object2);
                object = ((URL)object).openConnection();
                object = FirebasePerfUrlConnection.instrument(object);
                object = (URLConnection)object;
                object = (HttpURLConnection)object;
                int n10 = 10000;
                ((URLConnection)object).setConnectTimeout(n10);
                object = ((URLConnection)object).getInputStream();
                object2 = "utf-8";
                object = IOUtils.readStreamAsString((InputStream)object, (String)object2);
                object2 = this.mDecoder;
                if (object2 == null) break block30;
                object = object2.decode((String)object);
            }
            object2 = new JSONObject((String)object);
            object = "StatusCode";
            int n11 = object2.getInt((String)object);
            int n12 = 200;
            if (n11 != n12) break block31;
            object = "AccessKeyId";
            object = object2.getString((String)object);
            String string2 = "AccessKeySecret";
            string2 = object2.getString(string2);
            String string3 = "SecurityToken";
            string3 = object2.getString(string3);
            Object object3 = "Expiration";
            object2 = object2.getString((String)object3);
            object3 = new OSSFederationToken((String)object, string2, string3, (String)object2);
            return object3;
        }
        object = "ErrorCode";
        object = object2.getString((String)object);
        Object object4 = "ErrorMessage";
        object2 = object2.getString((String)object4);
        StringBuilder stringBuilder = new StringBuilder();
        String string4 = "ErrorCode: ";
        stringBuilder.append(string4);
        stringBuilder.append((String)object);
        object = "| ErrorMessage: ";
        stringBuilder.append((String)object);
        stringBuilder.append((String)object2);
        object = stringBuilder.toString();
        object4 = new ClientException((String)object);
        throw object4;
    }

    public void setAuthServerUrl(String string2) {
        this.mAuthServerUrl = string2;
    }

    public void setDecoder(OSSAuthCredentialsProvider$AuthDecoder oSSAuthCredentialsProvider$AuthDecoder) {
        this.mDecoder = oSSAuthCredentialsProvider$AuthDecoder;
    }
}

