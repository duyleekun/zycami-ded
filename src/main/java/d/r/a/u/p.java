/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package d.r.a.u;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class p {
    public static Map a(JSONObject jSONObject) {
        boolean bl2;
        HashMap<String, String> hashMap = new HashMap<String, String>();
        Iterator iterator2 = jSONObject.keys();
        while (bl2 = iterator2.hasNext()) {
            String string2 = (String)iterator2.next();
            String string3 = jSONObject.getString(string2);
            hashMap.put(string2, string3);
        }
        return hashMap;
    }
}

