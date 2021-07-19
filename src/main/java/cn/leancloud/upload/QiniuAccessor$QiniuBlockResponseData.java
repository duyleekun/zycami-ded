/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.upload;

public class QiniuAccessor$QiniuBlockResponseData {
    private String checksum;
    private long crc32;
    private String ctx;
    private String host;
    private int offset;

    public static /* synthetic */ String access$000(QiniuAccessor$QiniuBlockResponseData qiniuAccessor$QiniuBlockResponseData) {
        return qiniuAccessor$QiniuBlockResponseData.ctx;
    }

    public static /* synthetic */ int access$100(QiniuAccessor$QiniuBlockResponseData qiniuAccessor$QiniuBlockResponseData) {
        return qiniuAccessor$QiniuBlockResponseData.offset;
    }

    public static /* synthetic */ long access$200(QiniuAccessor$QiniuBlockResponseData qiniuAccessor$QiniuBlockResponseData) {
        return qiniuAccessor$QiniuBlockResponseData.crc32;
    }

    public String getChecksum() {
        return this.checksum;
    }

    public long getCrc32() {
        return this.crc32;
    }

    public String getCtx() {
        return this.ctx;
    }

    public String getHost() {
        return this.host;
    }

    public int getOffset() {
        return this.offset;
    }

    public void setChecksum(String string2) {
        this.checksum = string2;
    }

    public void setCrc32(long l10) {
        this.crc32 = l10;
    }

    public void setCtx(String string2) {
        this.ctx = string2;
    }

    public void setHost(String string2) {
        this.host = string2;
    }

    public void setOffset(int n10) {
        this.offset = n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("QiniuBlockResponseData{ctx='");
        String string2 = this.ctx;
        stringBuilder.append(string2);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", crc32=");
        long l10 = this.crc32;
        stringBuilder.append(l10);
        stringBuilder.append(", offset=");
        int n10 = this.offset;
        stringBuilder.append(n10);
        stringBuilder.append(", host='");
        String string3 = this.host;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", checksum='");
        string3 = this.checksum;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

