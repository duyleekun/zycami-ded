/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.im.v2.AVIMMessageInterval$1;

public class AVIMMessageInterval$AVIMMessageIntervalBound {
    public boolean closed;
    public String messageId;
    public long timestamp;

    private AVIMMessageInterval$AVIMMessageIntervalBound(String string2, long l10, boolean bl2) {
        this.messageId = string2;
        this.timestamp = l10;
        this.closed = bl2;
    }

    public /* synthetic */ AVIMMessageInterval$AVIMMessageIntervalBound(String string2, long l10, boolean bl2, AVIMMessageInterval$1 aVIMMessageInterval$1) {
        this(string2, l10, bl2);
    }
}

