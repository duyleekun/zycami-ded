/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMConversation;
import java.util.Date;

public class AVIMTemporaryConversation
extends AVIMConversation {
    public AVIMTemporaryConversation(AVIMClient aVIMClient, String string2) {
        super(aVIMClient, string2);
        this.setTemporary(true);
    }

    public boolean isExpired() {
        long l10 = System.currentTimeMillis();
        long l11 = 1000L;
        int n10 = this.getTemporaryExpiredat();
        long l12 = n10;
        Date date = this.getCreatedAt();
        long l13 = date.getTime() / l11;
        long l14 = (l10 /= l11) - (l12 += l13);
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        object = object > 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }
}

