/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.query.QueryConditions;
import cn.leancloud.utils.StringUtil;
import java.util.List;
import java.util.Map;

public final class AVIMConversationQueryConditions
extends QueryConditions {
    private static final int Flag_Compact = 1;
    private static final int Flag_WithLastMessage = 2;
    private boolean isCompact = false;
    private boolean isWithLastMessageRefreshed = false;
    private List tempConvIds = null;

    public static Map assembleParameters(Map map, int n10) {
        if (map == null) {
            return null;
        }
        int n11 = n10 & 1;
        String string2 = "compact";
        int n12 = 1;
        if (n11 == n12) {
            String string3 = Boolean.toString(n12 != 0);
            map.put(string2, string3);
        } else {
            map.remove(string2);
        }
        n11 = 2;
        string2 = "last_message";
        if ((n10 &= n11) == n11) {
            String string4 = Boolean.toString(n12 != 0);
            map.put(string2, string4);
        } else {
            map.remove(string2);
        }
        return map;
    }

    public static boolean isWithLastMessagesRefreshed(int n10) {
        int n11 = 2;
        n10 = (n10 &= n11) == n11 ? 1 : 0;
        return n10 != 0;
    }

    public Map assembleParameters() {
        int n10;
        Map map = super.assembleParameters();
        Object object = this.tempConvIds;
        if (object != null && (n10 = object.isEmpty()) == 0) {
            object = this.tempConvIds;
            object = StringUtil.join(",", (Iterable)object);
            String string2 = "temp_id";
            map.put(string2, object);
        }
        n10 = 0;
        object = null;
        boolean bl2 = this.isWithLastMessageRefreshed;
        if (bl2) {
            n10 = 2;
        }
        if (bl2 = this.isCompact) {
            ++n10;
        }
        return AVIMConversationQueryConditions.assembleParameters(map, n10);
    }

    public boolean isWithLastMessagesRefreshed() {
        return this.isWithLastMessageRefreshed;
    }

    public void setCompact(boolean bl2) {
        this.isCompact = bl2;
    }

    public void setTempConversationIds(List list) {
        this.tempConvIds = list;
    }

    public void setWithLastMessagesRefreshed(boolean bl2) {
        this.isWithLastMessageRefreshed = bl2;
    }
}

