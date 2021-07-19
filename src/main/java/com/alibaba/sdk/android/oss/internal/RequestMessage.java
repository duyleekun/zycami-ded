/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.alibaba.sdk.android.oss.internal;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.HttpMethod;
import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider;
import com.alibaba.sdk.android.oss.common.utils.HttpUtil;
import com.alibaba.sdk.android.oss.common.utils.HttpdnsMini;
import com.alibaba.sdk.android.oss.common.utils.OSSUtils;
import com.alibaba.sdk.android.oss.internal.HttpMessage;
import com.alibaba.sdk.android.oss.model.BucketLifecycleRule;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RequestMessage
extends HttpMessage {
    private String bucketName;
    private boolean checkCRC64;
    private OSSCredentialProvider credentialProvider;
    private URI endpoint;
    private boolean httpDnsEnable;
    private String ipWithHeader;
    private boolean isAuthorizationRequired = true;
    private boolean isInCustomCnameExcludeList;
    private HttpMethod method;
    private String objectKey;
    private Map parameters;
    private URI service;
    private byte[] uploadData;
    private String uploadFilePath;

    public RequestMessage() {
        LinkedHashMap linkedHashMap;
        this.parameters = linkedHashMap = new LinkedHashMap();
        this.httpDnsEnable = false;
        this.isInCustomCnameExcludeList = false;
    }

    public String buildCanonicalURL() {
        boolean bl2;
        Object object;
        CharSequence charSequence;
        CharSequence charSequence2;
        Object object2;
        boolean bl3;
        Object object3 = this.endpoint;
        if (object3 != null) {
            bl3 = true;
        } else {
            bl3 = false;
            object3 = null;
        }
        OSSUtils.assertTrue(bl3, "Endpoint haven't been set!");
        object3 = this.endpoint.getScheme();
        CharSequence charSequence3 = this.endpoint.getHost();
        Iterator iterator2 = this.endpoint;
        int n10 = ((URI)((Object)iterator2)).getPort();
        int n11 = -1;
        String string2 = null;
        if (n10 != n11) {
            iterator2 = String.valueOf(n10);
        } else {
            n10 = 0;
            iterator2 = null;
        }
        n11 = (int)(TextUtils.isEmpty((CharSequence)charSequence3) ? 1 : 0);
        if (n11 != 0) {
            object2 = this.endpoint.toString();
            charSequence2 = new StringBuilder();
            charSequence = "endpoint url : ";
            charSequence2.append((String)charSequence);
            charSequence2.append((String)object2);
            object2 = charSequence2.toString();
            OSSLog.logDebug((String)object2);
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append(" scheme : ");
        ((StringBuilder)object2).append((String)object3);
        OSSLog.logDebug(((StringBuilder)object2).toString());
        object2 = new StringBuilder();
        ((StringBuilder)object2).append(" originHost : ");
        ((StringBuilder)object2).append((String)charSequence3);
        OSSLog.logDebug(((StringBuilder)object2).toString());
        object2 = new StringBuilder();
        ((StringBuilder)object2).append(" port : ");
        ((StringBuilder)object2).append((String)((Object)iterator2));
        OSSLog.logDebug(((StringBuilder)object2).toString());
        object2 = new StringBuilder();
        ((StringBuilder)object2).append((String)object3);
        charSequence2 = "://";
        ((StringBuilder)object2).append((String)charSequence2);
        ((StringBuilder)object2).append((String)charSequence3);
        object2 = ((StringBuilder)object2).toString();
        boolean bl4 = TextUtils.isEmpty((CharSequence)((Object)iterator2));
        if (!bl4) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)object2);
            ((StringBuilder)charSequence).append(":");
            ((StringBuilder)charSequence).append((String)((Object)iterator2));
            object2 = ((StringBuilder)charSequence).toString();
        }
        iterator2 = this.bucketName;
        n10 = (int)(TextUtils.isEmpty((CharSequence)((Object)iterator2)) ? 1 : 0);
        charSequence = "/";
        if (n10 == 0) {
            n10 = (int)(OSSUtils.isOssOriginHost((String)charSequence3) ? 1 : 0);
            object = "Host";
            if (n10 != 0) {
                iterator2 = new Iterator();
                object2 = this.bucketName;
                ((StringBuilder)((Object)iterator2)).append((String)object2);
                object2 = ".";
                ((StringBuilder)((Object)iterator2)).append((String)object2);
                ((StringBuilder)((Object)iterator2)).append((String)charSequence3);
                charSequence3 = ((StringBuilder)((Object)iterator2)).toString();
                n10 = (int)(this.isHttpDnsEnable() ? 1 : 0);
                if (n10 != 0) {
                    iterator2 = HttpdnsMini.getInstance();
                    string2 = ((HttpdnsMini)((Object)iterator2)).getIpByHostAsync((String)charSequence3);
                } else {
                    iterator2 = "[buildCannonicalURL], disable httpdns";
                    OSSLog.logDebug((String)((Object)iterator2));
                }
                this.addHeader((String)object, (String)charSequence3);
                n10 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
                if (n10 == 0) {
                    charSequence3 = new StringBuilder();
                    ((StringBuilder)charSequence3).append((String)object3);
                    ((StringBuilder)charSequence3).append((String)charSequence2);
                    ((StringBuilder)charSequence3).append(string2);
                    object3 = ((StringBuilder)charSequence3).toString();
                } else {
                    iterator2 = new Iterator();
                    ((StringBuilder)((Object)iterator2)).append((String)object3);
                    ((StringBuilder)((Object)iterator2)).append((String)charSequence2);
                    ((StringBuilder)((Object)iterator2)).append((String)charSequence3);
                    object3 = ((StringBuilder)((Object)iterator2)).toString();
                }
                object2 = object3;
            } else {
                bl3 = OSSUtils.isValidateIP((String)charSequence3);
                if (bl3) {
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append((String)object2);
                    ((StringBuilder)object3).append((String)charSequence);
                    object2 = ((StringBuilder)object3).toString();
                    object3 = this.getIpWithHeader();
                    this.addHeader((String)object, (String)object3);
                }
            }
        }
        object3 = this.objectKey;
        bl3 = TextUtils.isEmpty((CharSequence)object3);
        charSequence3 = "utf-8";
        if (!bl3) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append((String)object2);
            ((StringBuilder)object3).append((String)charSequence);
            iterator2 = HttpUtil.urlEncode(this.objectKey, (String)charSequence3);
            ((StringBuilder)object3).append((String)((Object)iterator2));
            object2 = ((StringBuilder)object3).toString();
        }
        object3 = OSSUtils.paramToQueryString(this.parameters, (String)charSequence3);
        charSequence3 = new StringBuilder();
        ((StringBuilder)charSequence3).append("request---------------------\n");
        iterator2 = new Iterator();
        ((StringBuilder)((Object)iterator2)).append("request url=");
        ((StringBuilder)((Object)iterator2)).append((String)object2);
        string2 = "\n";
        ((StringBuilder)((Object)iterator2)).append(string2);
        iterator2 = ((StringBuilder)((Object)iterator2)).toString();
        ((StringBuilder)charSequence3).append((String)((Object)iterator2));
        iterator2 = new Iterator();
        charSequence2 = "request params=";
        ((StringBuilder)((Object)iterator2)).append((String)charSequence2);
        ((StringBuilder)((Object)iterator2)).append((String)object3);
        ((StringBuilder)((Object)iterator2)).append(string2);
        iterator2 = ((StringBuilder)((Object)iterator2)).toString();
        ((StringBuilder)charSequence3).append((String)((Object)iterator2));
        iterator2 = this.getHeaders().keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            charSequence2 = (String)iterator2.next();
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("requestHeader [");
            ((StringBuilder)charSequence).append((String)charSequence2);
            ((StringBuilder)charSequence).append("]: ");
            charSequence = ((StringBuilder)charSequence).toString();
            ((StringBuilder)charSequence3).append((String)charSequence);
            charSequence = new StringBuilder();
            object = this.getHeaders();
            charSequence2 = (String)object.get(charSequence2);
            ((StringBuilder)charSequence).append((String)charSequence2);
            ((StringBuilder)charSequence).append(string2);
            charSequence2 = ((StringBuilder)charSequence).toString();
            ((StringBuilder)charSequence3).append((String)charSequence2);
        }
        charSequence3 = ((StringBuilder)charSequence3).toString();
        OSSLog.logDebug((String)charSequence3);
        boolean bl5 = OSSUtils.isEmptyString((String)object3);
        if (bl5) {
            return object2;
        }
        charSequence3 = new StringBuilder();
        ((StringBuilder)charSequence3).append((String)object2);
        ((StringBuilder)charSequence3).append("?");
        ((StringBuilder)charSequence3).append((String)object3);
        return ((StringBuilder)charSequence3).toString();
    }

    public String buildOSSServiceURL() {
        Object object;
        boolean bl2;
        Object object2 = this.service;
        if (object2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object2 = null;
        }
        OSSUtils.assertTrue(bl2, "Service haven't been set!");
        object2 = this.service.getHost();
        Object object3 = this.service.getScheme();
        boolean bl3 = false;
        Object object4 = null;
        boolean bl4 = this.isHttpDnsEnable();
        if (bl4 && (bl4 = ((String)object3).equalsIgnoreCase((String)(object = "http")))) {
            object4 = HttpdnsMini.getInstance().getIpByHostAsync((String)object2);
        } else {
            object = "[buildOSSServiceURL], disable httpdns or http is not need httpdns";
            OSSLog.logDebug((String)object);
        }
        if (object4 == null) {
            object4 = object2;
        }
        object = this.getHeaders();
        String string2 = "Host";
        object.put(string2, object2);
        object2 = new StringBuilder();
        ((StringBuilder)object2).append((String)object3);
        ((StringBuilder)object2).append("://");
        ((StringBuilder)object2).append((String)object4);
        object2 = ((StringBuilder)object2).toString();
        object3 = this.parameters;
        object4 = "utf-8";
        object3 = OSSUtils.paramToQueryString((Map)object3, (String)object4);
        bl3 = OSSUtils.isEmptyString((String)object3);
        if (bl3) {
            return object2;
        }
        object4 = new StringBuilder();
        ((StringBuilder)object4).append((String)object2);
        ((StringBuilder)object4).append("?");
        ((StringBuilder)object4).append((String)object3);
        return ((StringBuilder)object4).toString();
    }

    public void createBucketRequestBodyMarshall(Map object) {
        CharSequence charSequence = new StringBuffer();
        if (object != null) {
            Object object2;
            boolean bl2;
            Object object3 = "<CreateBucketConfiguration>";
            ((StringBuffer)charSequence).append((String)object3);
            object = object.entrySet().iterator();
            while (bl2 = object.hasNext()) {
                object3 = (Map.Entry)object.next();
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("<");
                String string2 = (String)object3.getKey();
                ((StringBuilder)object2).append(string2);
                string2 = ">";
                ((StringBuilder)object2).append(string2);
                String string3 = (String)object3.getValue();
                ((StringBuilder)object2).append(string3);
                string3 = "</";
                ((StringBuilder)object2).append(string3);
                object3 = (String)object3.getKey();
                ((StringBuilder)object2).append((String)object3);
                ((StringBuilder)object2).append(string2);
                object3 = ((StringBuilder)object2).toString();
                ((StringBuffer)charSequence).append((String)object3);
            }
            ((StringBuffer)charSequence).append("</CreateBucketConfiguration>");
            object = ((StringBuffer)charSequence).toString();
            charSequence = "utf-8";
            object = ((String)object).getBytes((String)charSequence);
            int n10 = ((Object)object).length;
            long l10 = n10;
            object2 = new ByteArrayInputStream((byte[])object);
            this.setContent((InputStream)object2);
            this.setContentLength(l10);
        }
    }

    public byte[] deleteMultipleObjectRequestBodyMarshall(List object, boolean bl2) {
        Object object2;
        StringBuffer stringBuffer = new StringBuffer();
        String string2 = "<Delete>";
        stringBuffer.append(string2);
        if (bl2) {
            object2 = "<Quiet>true</Quiet>";
            stringBuffer.append((String)object2);
        } else {
            object2 = "<Quiet>false</Quiet>";
            stringBuffer.append((String)object2);
        }
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (String)object.next();
            stringBuffer.append("<Object>");
            string2 = "<Key>";
            stringBuffer.append(string2);
            stringBuffer.append((String)object2);
            stringBuffer.append("</Key>");
            object2 = "</Object>";
            stringBuffer.append((String)object2);
        }
        stringBuffer.append("</Delete>");
        object = stringBuffer.toString().getBytes("utf-8");
        long l10 = ((Object)object).length;
        object2 = new ByteArrayInputStream((byte[])object);
        this.setContent((InputStream)object2);
        this.setContentLength(l10);
        return object;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public OSSCredentialProvider getCredentialProvider() {
        return this.credentialProvider;
    }

    public URI getEndpoint() {
        return this.endpoint;
    }

    public String getIpWithHeader() {
        return this.ipWithHeader;
    }

    public HttpMethod getMethod() {
        return this.method;
    }

    public String getObjectKey() {
        return this.objectKey;
    }

    public Map getParameters() {
        return this.parameters;
    }

    public URI getService() {
        return this.service;
    }

    public byte[] getUploadData() {
        return this.uploadData;
    }

    public String getUploadFilePath() {
        return this.uploadFilePath;
    }

    public boolean isAuthorizationRequired() {
        return this.isAuthorizationRequired;
    }

    public boolean isCheckCRC64() {
        return this.checkCRC64;
    }

    public boolean isHttpDnsEnable() {
        return this.httpDnsEnable;
    }

    public boolean isInCustomCnameExcludeList() {
        return this.isInCustomCnameExcludeList;
    }

    public void putBucketLifecycleRequestBodyMarshall(ArrayList object) {
        Object object2;
        boolean bl2;
        StringBuffer stringBuffer = new StringBuffer();
        Object object3 = "<LifecycleConfiguration>";
        stringBuffer.append((String)object3);
        object = ((ArrayList)object).iterator();
        while (bl2 = object.hasNext()) {
            String string2;
            object3 = (BucketLifecycleRule)object.next();
            stringBuffer.append("<Rule>");
            object2 = ((BucketLifecycleRule)object3).getIdentifier();
            if (object2 != null) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("<ID>");
                string2 = ((BucketLifecycleRule)object3).getIdentifier();
                ((StringBuilder)object2).append(string2);
                string2 = "</ID>";
                ((StringBuilder)object2).append(string2);
                object2 = ((StringBuilder)object2).toString();
                stringBuffer.append((String)object2);
            }
            if ((object2 = ((BucketLifecycleRule)object3).getPrefix()) != null) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("<Prefix>");
                string2 = ((BucketLifecycleRule)object3).getPrefix();
                ((StringBuilder)object2).append(string2);
                string2 = "</Prefix>";
                ((StringBuilder)object2).append(string2);
                object2 = ((StringBuilder)object2).toString();
                stringBuffer.append((String)object2);
            }
            object2 = new StringBuilder();
            string2 = "<Status>";
            ((StringBuilder)object2).append(string2);
            boolean bl3 = ((BucketLifecycleRule)object3).getStatus();
            string2 = bl3 ? "Enabled" : "Disabled";
            ((StringBuilder)object2).append(string2);
            string2 = "</Status>";
            ((StringBuilder)object2).append(string2);
            object2 = ((StringBuilder)object2).toString();
            stringBuffer.append((String)object2);
            object2 = ((BucketLifecycleRule)object3).getDays();
            if (object2 != null) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("<Days>");
                string2 = ((BucketLifecycleRule)object3).getDays();
                ((StringBuilder)object2).append(string2);
                string2 = "</Days>";
                ((StringBuilder)object2).append(string2);
                object2 = ((StringBuilder)object2).toString();
                stringBuffer.append((String)object2);
            } else {
                object2 = ((BucketLifecycleRule)object3).getExpireDate();
                if (object2 != null) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("<Date>");
                    string2 = ((BucketLifecycleRule)object3).getExpireDate();
                    ((StringBuilder)object2).append(string2);
                    string2 = "</Date>";
                    ((StringBuilder)object2).append(string2);
                    object2 = ((StringBuilder)object2).toString();
                    stringBuffer.append((String)object2);
                }
            }
            object2 = ((BucketLifecycleRule)object3).getMultipartDays();
            if (object2 != null) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("<AbortMultipartUpload><Days>");
                string2 = ((BucketLifecycleRule)object3).getMultipartDays();
                ((StringBuilder)object2).append(string2);
                string2 = "</Days></AbortMultipartUpload>";
                ((StringBuilder)object2).append(string2);
                object2 = ((StringBuilder)object2).toString();
                stringBuffer.append((String)object2);
            } else {
                object2 = ((BucketLifecycleRule)object3).getMultipartExpireDate();
                if (object2 != null) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("<AbortMultipartUpload><Date>");
                    string2 = ((BucketLifecycleRule)object3).getMultipartDays();
                    ((StringBuilder)object2).append(string2);
                    string2 = "</Date></AbortMultipartUpload>";
                    ((StringBuilder)object2).append(string2);
                    object2 = ((StringBuilder)object2).toString();
                    stringBuffer.append((String)object2);
                }
            }
            object2 = ((BucketLifecycleRule)object3).getIADays();
            string2 = "<Transition><Days>";
            if (object2 != null) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(string2);
                object3 = ((BucketLifecycleRule)object3).getIADays();
                ((StringBuilder)object2).append((String)object3);
                ((StringBuilder)object2).append("</Days><StorageClass>IA</StorageClass></Transition>");
                object3 = ((StringBuilder)object2).toString();
                stringBuffer.append((String)object3);
            } else {
                object2 = ((BucketLifecycleRule)object3).getIAExpireDate();
                String string3 = "<Transition><Date>";
                if (object2 != null) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append(string3);
                    object3 = ((BucketLifecycleRule)object3).getIAExpireDate();
                    ((StringBuilder)object2).append((String)object3);
                    ((StringBuilder)object2).append("</Date><StorageClass>IA</StorageClass></Transition>");
                    object3 = ((StringBuilder)object2).toString();
                    stringBuffer.append((String)object3);
                } else {
                    object2 = ((BucketLifecycleRule)object3).getArchiveDays();
                    if (object2 != null) {
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append(string2);
                        object3 = ((BucketLifecycleRule)object3).getArchiveDays();
                        ((StringBuilder)object2).append((String)object3);
                        ((StringBuilder)object2).append("</Days><StorageClass>Archive</StorageClass></Transition>");
                        object3 = ((StringBuilder)object2).toString();
                        stringBuffer.append((String)object3);
                    } else {
                        object2 = ((BucketLifecycleRule)object3).getArchiveExpireDate();
                        if (object2 != null) {
                            object2 = new StringBuilder();
                            ((StringBuilder)object2).append(string3);
                            object3 = ((BucketLifecycleRule)object3).getArchiveExpireDate();
                            ((StringBuilder)object2).append((String)object3);
                            ((StringBuilder)object2).append("</Date><StorageClass>Archive</StorageClass></Transition>");
                            object3 = ((StringBuilder)object2).toString();
                            stringBuffer.append((String)object3);
                        }
                    }
                }
            }
            object3 = "</Rule>";
            stringBuffer.append((String)object3);
        }
        stringBuffer.append("</LifecycleConfiguration>");
        object = stringBuffer.toString().getBytes("utf-8");
        long l10 = ((Object)object).length;
        object2 = new ByteArrayInputStream((byte[])object);
        this.setContent((InputStream)object2);
        this.setContentLength(l10);
    }

    public void putBucketLoggingRequestBodyMarshall(String object, String object2) {
        StringBuffer stringBuffer = new StringBuffer();
        CharSequence charSequence = "<BucketLoggingStatus>";
        stringBuffer.append((String)charSequence);
        if (object != null) {
            charSequence = new StringBuilder();
            String string2 = "<LoggingEnabled><TargetBucket>";
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append("</TargetBucket>");
            object = ((StringBuilder)charSequence).toString();
            stringBuffer.append((String)object);
            if (object2 != null) {
                object = new StringBuilder();
                charSequence = "<TargetPrefix>";
                ((StringBuilder)object).append((String)charSequence);
                ((StringBuilder)object).append((String)object2);
                object2 = "</TargetPrefix>";
                ((StringBuilder)object).append((String)object2);
                object = ((StringBuilder)object).toString();
                stringBuffer.append((String)object);
            }
            object = "</LoggingEnabled>";
            stringBuffer.append((String)object);
        }
        stringBuffer.append("</BucketLoggingStatus>");
        object = stringBuffer.toString().getBytes("utf-8");
        long l10 = ((Object)object).length;
        object2 = new ByteArrayInputStream((byte[])object);
        this.setContent((InputStream)object2);
        this.setContentLength(l10);
    }

    public void putBucketRefererRequestBodyMarshall(ArrayList object, boolean n10) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<RefererConfiguration>");
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "<AllowEmptyReferer>";
        stringBuilder.append(string2);
        Object object2 = n10 != 0 ? "true" : "false";
        stringBuilder.append((String)object2);
        stringBuilder.append("</AllowEmptyReferer>");
        object2 = stringBuilder.toString();
        stringBuffer.append((String)object2);
        if (object != null && (n10 = ((ArrayList)object).size()) > 0) {
            object2 = "<RefererList>";
            stringBuffer.append((String)object2);
            object = ((ArrayList)object).iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                object2 = (String)object.next();
                stringBuilder = new StringBuilder();
                string2 = "<Referer>";
                stringBuilder.append(string2);
                stringBuilder.append((String)object2);
                stringBuilder.append("</Referer>");
                object2 = stringBuilder.toString();
                stringBuffer.append((String)object2);
            }
            object = "</RefererList>";
            stringBuffer.append((String)object);
        }
        stringBuffer.append("</RefererConfiguration>");
        object = stringBuffer.toString().getBytes("utf-8");
        long l10 = ((Object)object).length;
        object2 = new ByteArrayInputStream((byte[])object);
        this.setContent((InputStream)object2);
        this.setContentLength(l10);
    }

    public void setBucketName(String string2) {
        this.bucketName = string2;
    }

    public void setCheckCRC64(boolean bl2) {
        this.checkCRC64 = bl2;
    }

    public void setCredentialProvider(OSSCredentialProvider oSSCredentialProvider) {
        this.credentialProvider = oSSCredentialProvider;
    }

    public void setEndpoint(URI uRI) {
        this.endpoint = uRI;
    }

    public void setHttpDnsEnable(boolean bl2) {
        this.httpDnsEnable = bl2;
    }

    public void setIpWithHeader(String string2) {
        this.ipWithHeader = string2;
    }

    public void setIsAuthorizationRequired(boolean bl2) {
        this.isAuthorizationRequired = bl2;
    }

    public void setIsInCustomCnameExcludeList(boolean bl2) {
        this.isInCustomCnameExcludeList = bl2;
    }

    public void setMethod(HttpMethod httpMethod) {
        this.method = httpMethod;
    }

    public void setObjectKey(String string2) {
        this.objectKey = string2;
    }

    public void setParameters(Map map) {
        this.parameters = map;
    }

    public void setService(URI uRI) {
        this.service = uRI;
    }

    public void setUploadData(byte[] byArray) {
        this.uploadData = byArray;
    }

    public void setUploadFilePath(String string2) {
        this.uploadFilePath = string2;
    }
}

