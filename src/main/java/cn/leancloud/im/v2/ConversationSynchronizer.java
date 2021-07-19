/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.im.v2.AVIMConversation;
import cn.leancloud.json.JSONObject;
import cn.leancloud.utils.StringUtil;
import java.util.List;
import java.util.Map;

public class ConversationSynchronizer {
    public static void changeUpdatedTime(AVIMConversation aVIMConversation, String string2) {
        boolean bl2;
        if (aVIMConversation != null && !(bl2 = StringUtil.isEmpty(string2))) {
            aVIMConversation.setUpdatedAt(string2);
        }
    }

    public static void mergeConversationFromJsonObject(AVIMConversation aVIMConversation, JSONObject object, JSONObject iterator2) {
        if (aVIMConversation != null && (object != null || iterator2 != null)) {
            long l10;
            if (object == null) {
                boolean bl2;
                object = iterator2.entrySet().iterator();
                while (bl2 = object.hasNext()) {
                    iterator2 = (Map.Entry)object.next();
                    Map map = aVIMConversation.instanceData;
                    iterator2 = iterator2.getKey();
                    map.remove(iterator2);
                }
            } else {
                Object object2;
                boolean bl3;
                Object object3 = object.entrySet().iterator();
                while (bl3 = object3.hasNext()) {
                    object2 = object3.next();
                    String string2 = (String)object2.getKey();
                    Map map = aVIMConversation.instanceData;
                    object2 = object2.getValue();
                    map.put(string2, object2);
                }
                if (iterator2 != null) {
                    boolean bl4;
                    iterator2 = iterator2.entrySet().iterator();
                    while (bl4 = iterator2.hasNext()) {
                        object3 = (String)iterator2.next().getKey();
                        bl3 = object.containsKey(object3);
                        if (bl3) continue;
                        object2 = aVIMConversation.instanceData;
                        object2.remove(object3);
                    }
                }
            }
            aVIMConversation.latestConversationFetch = l10 = System.currentTimeMillis();
        }
    }

    public static void mergeMembers(AVIMConversation aVIMConversation, List list) {
        if (aVIMConversation == null) {
            return;
        }
        aVIMConversation.internalMergeMembers(list);
    }

    public static void removeMembers(AVIMConversation aVIMConversation, List list) {
        if (aVIMConversation == null) {
            return;
        }
        aVIMConversation.internalRemoveMembers(list);
    }
}

