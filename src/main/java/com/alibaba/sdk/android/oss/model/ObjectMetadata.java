/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import com.alibaba.sdk.android.oss.common.utils.CaseInsensitiveHashMap;
import com.alibaba.sdk.android.oss.common.utils.DateUtil;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public class ObjectMetadata {
    public static final String AES_256_SERVER_SIDE_ENCRYPTION = "AES256";
    private Map metadata;
    private Map userMetadata;

    public ObjectMetadata() {
        CaseInsensitiveHashMap caseInsensitiveHashMap = new CaseInsensitiveHashMap();
        this.userMetadata = caseInsensitiveHashMap;
        caseInsensitiveHashMap = new CaseInsensitiveHashMap();
        this.metadata = caseInsensitiveHashMap;
    }

    public void addUserMetadata(String string2, String string3) {
        this.userMetadata.put(string2, string3);
    }

    public String getCacheControl() {
        return (String)this.metadata.get("Cache-Control");
    }

    public String getContentDisposition() {
        return (String)this.metadata.get("Content-Disposition");
    }

    public String getContentEncoding() {
        return (String)this.metadata.get("Content-Encoding");
    }

    public long getContentLength() {
        Object object = this.metadata;
        String string2 = "Content-Length";
        if ((object = (Long)object.get(string2)) == null) {
            return 0L;
        }
        return (Long)object;
    }

    public String getContentMD5() {
        return (String)this.metadata.get("Content-MD5");
    }

    public String getContentType() {
        return (String)this.metadata.get("Content-Type");
    }

    public String getETag() {
        return (String)this.metadata.get("ETag");
    }

    public Date getExpirationTime() {
        return DateUtil.parseRfc822Date((String)this.metadata.get("Expires"));
    }

    public Date getLastModified() {
        return (Date)this.metadata.get("Last-Modified");
    }

    public String getObjectType() {
        return (String)this.metadata.get("x-oss-object-type");
    }

    public String getRawExpiresValue() {
        return (String)this.metadata.get("Expires");
    }

    public Map getRawMetadata() {
        return Collections.unmodifiableMap(this.metadata);
    }

    public String getSHA1() {
        return (String)this.metadata.get("x-oss-hash-sha1");
    }

    public String getServerSideEncryption() {
        return (String)this.metadata.get("x-oss-server-side-encryption");
    }

    public Map getUserMetadata() {
        return this.userMetadata;
    }

    public void setCacheControl(String string2) {
        this.metadata.put("Cache-Control", string2);
    }

    public void setContentDisposition(String string2) {
        this.metadata.put("Content-Disposition", string2);
    }

    public void setContentEncoding(String string2) {
        this.metadata.put("Content-Encoding", string2);
    }

    public void setContentLength(long l10) {
        long l11 = 0x140000000L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object <= 0) {
            Map map = this.metadata;
            Long l13 = l10;
            map.put("Content-Length", l13);
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The content length could not be more than 5GB.");
        throw illegalArgumentException;
    }

    public void setContentMD5(String string2) {
        this.metadata.put("Content-MD5", string2);
    }

    public void setContentType(String string2) {
        this.metadata.put("Content-Type", string2);
    }

    public void setExpirationTime(Date object) {
        Map map = this.metadata;
        object = DateUtil.formatRfc822Date((Date)object);
        map.put("Expires", object);
    }

    public void setHeader(String string2, Object object) {
        this.metadata.put(string2, object);
    }

    public void setLastModified(Date date) {
        this.metadata.put("Last-Modified", date);
    }

    public void setSHA1(String string2) {
        this.metadata.put("x-oss-hash-sha1", string2);
    }

    public void setServerSideEncryption(String string2) {
        this.metadata.put("x-oss-server-side-encryption", string2);
    }

    public void setUserMetadata(Map map) {
        boolean bl2;
        Map map2 = this.userMetadata;
        map2.clear();
        if (map != null && !(bl2 = map.isEmpty())) {
            map2 = this.userMetadata;
            map2.putAll(map);
        }
    }

    public String toString() {
        Object object = this.getExpirationTime();
        try {
            object = ((Date)object).toString();
        }
        catch (Exception exception) {
            object = "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Last-Modified:");
        Object object2 = this.getLastModified();
        stringBuilder.append(object2);
        object2 = "\n";
        stringBuilder.append((String)object2);
        stringBuilder.append("Expires");
        String string2 = ":";
        stringBuilder.append(string2);
        stringBuilder.append((String)object);
        stringBuilder.append("\nrawExpires:");
        object = this.getRawExpiresValue();
        stringBuilder.append((String)object);
        stringBuilder.append((String)object2);
        stringBuilder.append("Content-MD5");
        stringBuilder.append(string2);
        object = this.getContentMD5();
        stringBuilder.append((String)object);
        stringBuilder.append((String)object2);
        stringBuilder.append("x-oss-object-type");
        stringBuilder.append(string2);
        object = this.getObjectType();
        stringBuilder.append((String)object);
        stringBuilder.append((String)object2);
        stringBuilder.append("x-oss-server-side-encryption");
        stringBuilder.append(string2);
        object = this.getServerSideEncryption();
        stringBuilder.append((String)object);
        stringBuilder.append((String)object2);
        stringBuilder.append("Content-Disposition");
        stringBuilder.append(string2);
        object = this.getContentDisposition();
        stringBuilder.append((String)object);
        stringBuilder.append((String)object2);
        stringBuilder.append("Content-Encoding");
        stringBuilder.append(string2);
        object = this.getContentEncoding();
        stringBuilder.append((String)object);
        stringBuilder.append((String)object2);
        stringBuilder.append("Cache-Control");
        stringBuilder.append(string2);
        object = this.getCacheControl();
        stringBuilder.append((String)object);
        stringBuilder.append((String)object2);
        stringBuilder.append("ETag");
        stringBuilder.append(string2);
        object = this.getETag();
        stringBuilder.append((String)object);
        stringBuilder.append((String)object2);
        return stringBuilder.toString();
    }
}

