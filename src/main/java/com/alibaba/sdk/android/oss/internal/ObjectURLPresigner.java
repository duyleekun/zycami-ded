/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.internal;

import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.common.HttpMethod;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSCustomSignerCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSFederationToken;
import com.alibaba.sdk.android.oss.common.auth.OSSPlainTextAKSKCredentialProvider;
import com.alibaba.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider;
import com.alibaba.sdk.android.oss.common.utils.DateUtil;
import com.alibaba.sdk.android.oss.common.utils.HttpUtil;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.alibaba.sdk.android.oss.internal.RequestMessage;
import com.alibaba.sdk.android.oss.model.GeneratePresignedUrlRequest;
import java.net.URI;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ObjectURLPresigner {
    private ClientConfiguration conf;
    private OSSCredentialProvider credentialProvider;
    private URI endpoint;

    public ObjectURLPresigner(URI uRI, OSSCredentialProvider oSSCredentialProvider, ClientConfiguration clientConfiguration) {
        this.endpoint = uRI;
        this.credentialProvider = oSSCredentialProvider;
        this.conf = clientConfiguration;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public String presignConstrainedURL(GeneratePresignedUrlRequest object) {
        void var9_54;
        void var1_15;
        String string2;
        String string3;
        boolean bl2;
        Map map;
        Map map2;
        String string4;
        String string5;
        Object object2;
        Object object3;
        String string6;
        int n10;
        void var9_29;
        Object object4 = ((GeneratePresignedUrlRequest)object).getBucketName();
        String string7 = ((GeneratePresignedUrlRequest)object).getKey();
        long l10 = DateUtil.getFixedSkewedTimeMillis() / 1000L;
        long l11 = ((GeneratePresignedUrlRequest)object).getExpiration();
        CharSequence charSequence = String.valueOf(l10 += l11);
        HttpMethod httpMethod = ((GeneratePresignedUrlRequest)object).getMethod();
        if (httpMethod != null) {
            HttpMethod httpMethod2 = ((GeneratePresignedUrlRequest)object).getMethod();
        } else {
            HttpMethod httpMethod3 = HttpMethod.GET;
        }
        Object object5 = new RequestMessage();
        Object object6 = this.endpoint;
        ((RequestMessage)object5).setEndpoint((URI)object6);
        ((RequestMessage)object5).setMethod((HttpMethod)var9_29);
        ((RequestMessage)object5).setBucketName((String)object4);
        ((RequestMessage)object5).setObjectKey(string7);
        ((RequestMessage)object5).getHeaders().put("Date", charSequence);
        String string8 = ((GeneratePresignedUrlRequest)object).getContentType();
        object6 = "";
        if (string8 != null && (n10 = (string6 = ((GeneratePresignedUrlRequest)object).getContentType().trim()).equals(object6)) == 0) {
            Map map3 = ((RequestMessage)object5).getHeaders();
            object3 = ((GeneratePresignedUrlRequest)object).getContentType();
            object2 = "Content-Type";
            map3.put(object2, object3);
        }
        if ((string5 = ((GeneratePresignedUrlRequest)object).getContentMD5()) != null && (n10 = (string4 = ((GeneratePresignedUrlRequest)object).getContentMD5().trim()).equals(object6)) == 0) {
            Map map4 = ((RequestMessage)object5).getHeaders();
            object3 = ((GeneratePresignedUrlRequest)object).getContentMD5();
            object2 = "Content-MD5";
            map4.put(object2, object3);
        }
        if ((map2 = ((GeneratePresignedUrlRequest)object).getQueryParameter()) != null && (n10 = (map = ((GeneratePresignedUrlRequest)object).getQueryParameter()).size()) > 0) {
            Iterator iterator2 = ((GeneratePresignedUrlRequest)object).getQueryParameter().entrySet().iterator();
            while (bl2 = iterator2.hasNext()) {
                object3 = iterator2.next();
                object2 = ((RequestMessage)object5).getParameters();
                Object k10 = object3.getKey();
                object3 = object3.getValue();
                object2.put(k10, object3);
            }
        }
        if ((string3 = ((GeneratePresignedUrlRequest)object).getProcess()) != null && (n10 = (int)((string2 = ((GeneratePresignedUrlRequest)object).getProcess().trim()).equals(object6) ? 1 : 0)) == 0) {
            Map map5 = ((RequestMessage)object5).getParameters();
            String string9 = ((GeneratePresignedUrlRequest)object).getProcess();
            object6 = "x-oss-process";
            map5.put(object6, string9);
        }
        boolean bl3 = false;
        Object var1_4 = null;
        OSSCredentialProvider oSSCredentialProvider = this.credentialProvider;
        boolean bl4 = oSSCredentialProvider instanceof OSSFederationCredentialProvider;
        object3 = "security-token";
        if (bl4) {
            OSSFederationToken oSSFederationToken = ((OSSFederationCredentialProvider)oSSCredentialProvider).getValidFederationToken();
            Map map6 = ((RequestMessage)object5).getParameters();
            object6 = oSSFederationToken.getSecurityToken();
            map6.put(object3, object6);
            if (oSSFederationToken == null) {
                ClientException clientException = new ClientException("Can not get a federation token!");
                throw clientException;
            }
        } else {
            bl4 = oSSCredentialProvider instanceof OSSStsTokenCredentialProvider;
            if (bl4) {
                OSSFederationToken oSSFederationToken = ((OSSStsTokenCredentialProvider)oSSCredentialProvider).getFederationToken();
                Map map7 = ((RequestMessage)object5).getParameters();
                object6 = oSSFederationToken.getSecurityToken();
                map7.put(object3, object6);
            }
        }
        String string10 = OSSUtils.buildCanonicalString((RequestMessage)object5);
        object6 = this.credentialProvider;
        bl2 = object6 instanceof OSSFederationCredentialProvider;
        if (!bl2 && !(bl2 = object6 instanceof OSSStsTokenCredentialProvider)) {
            bl3 = object6 instanceof OSSPlainTextAKSKCredentialProvider;
            if (bl3) {
                String string11 = ((OSSPlainTextAKSKCredentialProvider)object6).getAccessKeyId();
                object6 = ((OSSPlainTextAKSKCredentialProvider)this.credentialProvider).getAccessKeySecret();
                String string12 = OSSUtils.sign(string11, (String)object6, string10);
            } else {
                bl3 = object6 instanceof OSSCustomSignerCredentialProvider;
                if (!bl3) {
                    ClientException clientException = new ClientException("Unknown credentialProvider!");
                    throw clientException;
                }
                object6 = (OSSCustomSignerCredentialProvider)object6;
                String string13 = ((OSSCustomSignerCredentialProvider)object6).signContent(string10);
            }
        } else {
            void var1_8;
            object6 = var1_8.getTempAK();
            String string15 = var1_8.getTempSK();
            string15 = OSSUtils.sign((String)object6, string15, string10);
        }
        String string16 = ":";
        object6 = var1_15.split(string16);
        object3 = null;
        object6 = ((String)object6[0]).substring(4);
        String[] stringArray = var1_15.split(string16);
        n10 = 1;
        String string17 = stringArray[n10];
        String string18 = this.endpoint.getHost();
        bl2 = OSSUtils.isCname(string18);
        if (!bl2 || (bl2 = OSSUtils.isInCustomCnameExcludeList(string18, (List)(object3 = this.conf.getCustomCnameExcludeList())))) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append((String)object4);
            object4 = ".";
            ((StringBuilder)object3).append((String)object4);
            ((StringBuilder)object3).append(string18);
            String string19 = ((StringBuilder)object3).toString();
        }
        object4 = new LinkedHashMap();
        object4.put("Expires", charSequence);
        object4.put("OSSAccessKeyId", object6);
        object4.put("Signature", string17);
        Map map8 = ((RequestMessage)object5).getParameters();
        object4.putAll(map8);
        String string20 = "utf-8";
        object4 = HttpUtil.paramToQueryString(object4, string20);
        charSequence = new StringBuilder();
        object5 = this.endpoint.getScheme();
        ((StringBuilder)charSequence).append((String)object5);
        ((StringBuilder)charSequence).append("://");
        ((StringBuilder)charSequence).append((String)var9_54);
        ((StringBuilder)charSequence).append("/");
        String string21 = HttpUtil.urlEncode(string7, string20);
        ((StringBuilder)charSequence).append(string21);
        ((StringBuilder)charSequence).append("?");
        ((StringBuilder)charSequence).append((String)object4);
        return ((StringBuilder)charSequence).toString();
    }

    public String presignConstrainedURL(String string2, String string3, long l10) {
        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(string2, string3);
        generatePresignedUrlRequest.setExpiration(l10);
        return this.presignConstrainedURL(generatePresignedUrlRequest);
    }

    public String presignPublicURL(String charSequence, String string2) {
        Object object;
        String string3 = this.endpoint.getHost();
        boolean bl2 = OSSUtils.isCname(string3);
        if (!bl2 || (bl2 = OSSUtils.isInCustomCnameExcludeList(string3, (List)(object = this.conf.getCustomCnameExcludeList())))) {
            object = new StringBuilder();
            ((StringBuilder)object).append((String)charSequence);
            charSequence = ".";
            ((StringBuilder)object).append((String)charSequence);
            ((StringBuilder)object).append(string3);
            string3 = ((StringBuilder)object).toString();
        }
        charSequence = new StringBuilder();
        object = this.endpoint.getScheme();
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append("://");
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append("/");
        string2 = HttpUtil.urlEncode(string2, "utf-8");
        ((StringBuilder)charSequence).append(string2);
        return ((StringBuilder)charSequence).toString();
    }
}

