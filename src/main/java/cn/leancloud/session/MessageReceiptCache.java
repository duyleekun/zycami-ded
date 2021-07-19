/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.cache.SystemSetting;
import cn.leancloud.core.AppConfiguration;
import cn.leancloud.json.JSON;
import cn.leancloud.utils.StringUtil;

public class MessageReceiptCache {
    private static final String MESSAGE_ZONE = "com.avoscloud.chat.receipt.";
    private static final String QUEUE_KEY = "com.avoscloud.chat.message.receipt";

    public static void add(String string2, String string3, Object object) {
        object = JSON.toJSONString(object);
        SystemSetting systemSetting = AppConfiguration.getDefaultSetting();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MESSAGE_ZONE);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        stringBuilder = new StringBuilder();
        stringBuilder.append(QUEUE_KEY);
        stringBuilder.append(string3);
        string3 = stringBuilder.toString();
        systemSetting.saveString(string2, string3, (String)object);
    }

    public static void clean(String string2) {
        SystemSetting systemSetting = AppConfiguration.getDefaultSetting();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MESSAGE_ZONE);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        systemSetting.removeKeyZone(string2);
    }

    public static Object get(String string2, String string3) {
        SystemSetting systemSetting = AppConfiguration.getDefaultSetting();
        CharSequence charSequence = new StringBuilder();
        String string4 = MESSAGE_ZONE;
        ((StringBuilder)charSequence).append(string4);
        ((StringBuilder)charSequence).append(string2);
        string2 = ((StringBuilder)charSequence).toString();
        charSequence = new StringBuilder();
        String string5 = QUEUE_KEY;
        ((StringBuilder)charSequence).append(string5);
        ((StringBuilder)charSequence).append(string3);
        charSequence = ((StringBuilder)charSequence).toString();
        string2 = systemSetting.getString(string2, (String)charSequence, null);
        systemSetting = AppConfiguration.getDefaultSetting();
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(string5);
        ((StringBuilder)charSequence).append(string3);
        string3 = ((StringBuilder)charSequence).toString();
        systemSetting.removeKey(string4, string3);
        boolean bl2 = StringUtil.isEmpty(string2);
        if (bl2) {
            return null;
        }
        return JSON.parse(string2);
    }
}

