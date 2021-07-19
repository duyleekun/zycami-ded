/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.common.HttpMethod;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GeneratePresignedUrlRequest {
    private String bucketName;
    private String contentMD5;
    private String contentType;
    private long expiration;
    private String key;
    private HttpMethod method;
    private String process;
    private Map queryParam;

    public GeneratePresignedUrlRequest(String string2, String string3) {
        this(string2, string3, 3600L);
    }

    public GeneratePresignedUrlRequest(String string2, String string3, long l10) {
        HttpMethod httpMethod = HttpMethod.GET;
        this(string2, string3, 3600L, httpMethod);
    }

    public GeneratePresignedUrlRequest(String string2, String string3, long l10, HttpMethod httpMethod) {
        HashMap hashMap;
        this.queryParam = hashMap = new HashMap();
        this.bucketName = string2;
        this.key = string3;
        this.expiration = l10;
        this.method = httpMethod;
    }

    public void addQueryParameter(String string2, String string3) {
        this.queryParam.put(string2, string3);
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getContentMD5() {
        return this.contentMD5;
    }

    public String getContentType() {
        return this.contentType;
    }

    public long getExpiration() {
        return this.expiration;
    }

    public String getKey() {
        return this.key;
    }

    public HttpMethod getMethod() {
        return this.method;
    }

    public String getProcess() {
        return this.process;
    }

    public Map getQueryParameter() {
        return this.queryParam;
    }

    public void setBucketName(String string2) {
        this.bucketName = string2;
    }

    public void setContentMD5(String string2) {
        this.contentMD5 = string2;
    }

    public void setContentType(String string2) {
        this.contentType = string2;
    }

    public void setExpiration(long l10) {
        this.expiration = l10;
    }

    public void setKey(String string2) {
        this.key = string2;
    }

    public void setMethod(HttpMethod object) {
        HttpMethod httpMethod = HttpMethod.GET;
        if (object != httpMethod && object != (httpMethod = HttpMethod.PUT)) {
            object = new IllegalArgumentException("Only GET or PUT is supported!");
            throw object;
        }
        this.method = object;
    }

    public void setProcess(String string2) {
        this.process = string2;
    }

    public void setQueryParameter(Map map) {
        int n10;
        Objects.requireNonNull(map, "The argument 'queryParameter' is null.");
        Map map2 = this.queryParam;
        if (map2 != null && (n10 = map2.size()) > 0) {
            map2 = this.queryParam;
            map2.clear();
        }
        this.queryParam.putAll(map);
    }
}

