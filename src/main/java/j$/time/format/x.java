/*
 * Decompiled with CFR 0.151.
 */
package j$.time.format;

import j$.time.format.C;
import j$.time.format.y;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class x {
    private final Map a;

    x(Map object) {
        boolean bl2;
        this.a = object;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            boolean bl3;
            Object object2 = (Map.Entry)object.next();
            Object object3 = new HashMap();
            ArrayList arrayList2 = ((Map)object2.getValue()).entrySet().iterator();
            while (bl3 = arrayList2.hasNext()) {
                Object object4 = arrayList2.next();
                String string2 = (String)object4.getValue();
                String string3 = (String)object4.getValue();
                object4 = (Long)object4.getKey();
                AbstractMap.SimpleImmutableEntry<String, Object> simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry<String, Object>(string3, object4);
                ((HashMap)object3).put(string2, simpleImmutableEntry);
            }
            object3 = ((HashMap)object3).values();
            arrayList2 = new ArrayList(object3);
            object3 = y.a();
            Collections.sort(arrayList2, object3);
            object2 = (C)((Object)object2.getKey());
            hashMap.put((Map.Entry)object2, arrayList2);
            arrayList.addAll(arrayList2);
            bl2 = false;
            object2 = null;
            hashMap.put(null, arrayList);
        }
        object = y.a();
        Collections.sort(arrayList, object);
    }

    String a(long l10, C object) {
        Object object2;
        Map map = this.a;
        if ((object = (Map)map.get(object)) != null) {
            object2 = l10;
            object2 = (String)object.get(object2);
        } else {
            object2 = null;
        }
        return object2;
    }
}

