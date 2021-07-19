/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.im.v2.AVIMMessage;
import java.util.Comparator;

public final class AVIMConversation$16
implements Comparator {
    public int compare(AVIMMessage object, AVIMMessage object2) {
        long l10;
        long l11 = ((AVIMMessage)object).getTimestamp();
        long l12 = l11 - (l10 = ((AVIMMessage)object2).getTimestamp());
        Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object3 < 0) {
            return -1;
        }
        l11 = ((AVIMMessage)object).getTimestamp();
        long l13 = l11 - (l10 = ((AVIMMessage)object2).getTimestamp());
        object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object3 > 0) {
            return 1;
        }
        object = ((AVIMMessage)object).messageId;
        object2 = ((AVIMMessage)object2).messageId;
        return ((String)object).compareTo((String)object2);
    }
}

