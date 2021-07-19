/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im;

import java.util.Collections;
import java.util.List;

public class Signature {
    private String nonce;
    private String signature;
    private List signedPeerIds;
    private long timestamp;

    public String getNonce() {
        return this.nonce;
    }

    public String getSignature() {
        return this.signature;
    }

    public List getSignedPeerIds() {
        List list = this.signedPeerIds;
        if (list == null) {
            this.signedPeerIds = list = Collections.emptyList();
        }
        return this.signedPeerIds;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public boolean isExpired() {
        long l10 = this.timestamp + 14400L;
        long l11 = System.currentTimeMillis();
        long l12 = 1000L;
        long l13 = l10 - (l11 /= l12);
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        object = object < 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public void setNonce(String string2) {
        this.nonce = string2;
    }

    public void setSignature(String string2) {
        this.signature = string2;
    }

    public void setSignedPeerIds(List list) {
        this.signedPeerIds = list;
    }

    public void setTimestamp(long l10) {
        this.timestamp = l10;
    }
}

