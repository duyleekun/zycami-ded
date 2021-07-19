/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service;

import com.xiaomi.push.bf;
import com.xiaomi.push.service.XMPushService;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class ac {
    private static Object a;
    private static Map a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        a = hashMap = new HashMap();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean a(XMPushService xMPushService, String string2, String string3) {
        Object object = a;
        synchronized (object) {
            int n10;
            Object object2 = "push_message_ids";
            xMPushService = xMPushService.getSharedPreferences((String)object2, 0);
            object2 = a;
            object2 = object2.get(string2);
            object2 = (Queue)object2;
            if (object2 == null) {
                object2 = "";
                object2 = xMPushService.getString(string2, (String)object2);
                LinkedList<String> linkedList = ",";
                object2 = ((String)object2).split((String)((Object)linkedList));
                linkedList = new LinkedList<String>();
                for (String string4 : object2) {
                    linkedList.add(string4);
                }
                object2 = a;
                object2.put(string2, linkedList);
                object2 = linkedList;
            }
            if ((n10 = object2.contains(string3)) != 0) {
                return true;
            }
            object2.add(string3);
            int n11 = object2.size();
            n10 = 25;
            if (n11 > n10) {
                object2.poll();
            }
            string3 = ",";
            string3 = bf.a((Collection)object2, string3);
            xMPushService = xMPushService.edit();
            xMPushService.putString(string2, string3);
            xMPushService.commit();
            return false;
        }
    }
}

