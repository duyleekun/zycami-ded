/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVCloudQuery$1;
import cn.leancloud.AVObject;
import cn.leancloud.AVUser;
import cn.leancloud.core.PaasClient;
import cn.leancloud.utils.AVUtils;
import cn.leancloud.utils.StringUtil;
import e.a.v0.o;
import e.a.z;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class AVCloudQuery {
    private AVCloudQuery() {
    }

    public static z executeInBackground(AVUser aVUser, String string2) {
        return AVCloudQuery.executeInBackground(aVUser, string2, AVObject.class);
    }

    public static z executeInBackground(AVUser aVUser, String string2, Class clazz) {
        return AVCloudQuery.executeInBackground(aVUser, string2, clazz, null);
    }

    public static z executeInBackground(AVUser object, String object2, Class object3, Object ... object4) {
        int n10 = StringUtil.isEmpty((String)object2);
        if (n10 == 0) {
            if (object3 != null) {
                object3 = new LinkedList();
                if (object4 != null) {
                    for (Object object5 : object4) {
                        object3.add(object5);
                    }
                }
                object4 = new HashMap();
                String string2 = "cql";
                object4.put(string2, object2);
                boolean bl2 = object3.isEmpty();
                if (!bl2) {
                    object2 = AVUtils.jsonStringFromObjectWithNull(object3);
                    object3 = "pvalues";
                    object4.put(object3, object2);
                }
                object = PaasClient.getStorageClient().cloudQuery((AVUser)object, (Map)object4);
                object2 = new AVCloudQuery$1();
                return ((z)object).H3((o)object2);
            }
            object = new IllegalArgumentException("target class is null");
            throw object;
        }
        object = new IllegalArgumentException("cql is empty");
        throw object;
    }

    public static z executeInBackground(AVUser aVUser, String string2, Object ... objectArray) {
        return AVCloudQuery.executeInBackground(aVUser, string2, AVObject.class, objectArray);
    }

    public static z executeInBackground(String string2) {
        return AVCloudQuery.executeInBackground(null, string2);
    }

    public static z executeInBackground(String string2, Class clazz) {
        return AVCloudQuery.executeInBackground(null, string2, clazz);
    }

    public static z executeInBackground(String string2, Class clazz, Object ... objectArray) {
        return AVCloudQuery.executeInBackground(null, string2, clazz, objectArray);
    }

    public static z executeInBackground(String string2, Object ... objectArray) {
        return AVCloudQuery.executeInBackground(null, string2, objectArray);
    }
}

