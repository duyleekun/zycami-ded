/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.xiaomi.push;

import com.xiaomi.push.cu;
import java.util.AbstractSequentialList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class de
implements Comparable {
    public int a;
    private long a;
    public String a;
    private final LinkedList a;

    public de() {
        this(null, 0);
    }

    public de(String string2) {
        this(string2, 0);
    }

    public de(String string2, int n10) {
        LinkedList linkedList;
        this.a = linkedList = new LinkedList();
        this.a = 0L;
        this.a = string2;
        this.a = n10;
    }

    public int a(de de2) {
        if (de2 == null) {
            return 1;
        }
        int n10 = de2.a;
        int n11 = this.a;
        return n10 - n11;
    }

    public de a(JSONObject jSONObject) {
        synchronized (this) {
            String string2 = "tt";
            long l10 = jSONObject.getLong(string2);
            this.a = l10;
            string2 = "wt";
            int n10 = jSONObject.getInt(string2);
            this.a = n10;
            string2 = "host";
            string2 = jSONObject.getString(string2);
            this.a = string2;
            string2 = "ah";
            jSONObject = jSONObject.getJSONArray(string2);
            n10 = 0;
            string2 = null;
            while (true) {
                int n11 = jSONObject.length();
                if (n10 >= n11) break;
                Object object = jSONObject.getJSONObject(n10);
                LinkedList linkedList = this.a;
                cu cu2 = new cu();
                object = cu2.a((JSONObject)object);
                linkedList.add(object);
                ++n10;
                continue;
                break;
            }
            return this;
        }
    }

    public JSONObject a() {
        synchronized (this) {
            JSONObject jSONObject = new JSONObject();
            String string2 = "tt";
            long l10 = this.a;
            jSONObject.put(string2, l10);
            string2 = "wt";
            int n10 = this.a;
            jSONObject.put(string2, n10);
            string2 = "host";
            Object object = this.a;
            jSONObject.put(string2, object);
            string2 = new JSONArray();
            object = this.a;
            object = ((AbstractSequentialList)object).iterator();
            while (true) {
                boolean bl2 = object.hasNext();
                if (!bl2) break;
                Object object2 = object.next();
                object2 = (cu)object2;
                object2 = ((cu)object2).a();
                string2.put(object2);
                continue;
                break;
            }
            object = "ah";
            jSONObject.put((String)object, (Object)string2);
            return jSONObject;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(cu object) {
        synchronized (this) {
            if (object != null) {
                int n10;
                LinkedList linkedList = this.a;
                linkedList.add(object);
                int n11 = ((cu)object).a();
                if (n11 > 0) {
                    n11 = this.a;
                    n10 = ((cu)object).a();
                    this.a = n11 += n10;
                } else {
                    int n12;
                    n10 = 0;
                    object = null;
                    LinkedList linkedList2 = this.a;
                    for (n12 = linkedList2.size() + -1; n12 >= 0; ++n10, n12 += -1) {
                        Object object2 = this.a;
                        object2 = ((LinkedList)object2).get(n12);
                        int n13 = ((cu)(object2 = (cu)object2)).a();
                        if (n13 >= 0) break;
                    }
                    n12 = this.a;
                    this.a = n12 += (n11 *= n10);
                }
                object = this.a;
                n10 = ((LinkedList)object).size();
                n11 = 30;
                if (n10 > n11) {
                    object = this.a;
                    object = ((LinkedList)object).remove();
                    object = (cu)object;
                    n11 = this.a;
                    n10 = ((cu)object).a();
                    this.a = n11 -= n10;
                }
            }
            return;
        }
    }

    public /* synthetic */ int compareTo(Object object) {
        object = (de)object;
        return this.a((de)object);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.a;
        stringBuilder.append(string2);
        stringBuilder.append(":");
        int n10 = this.a;
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }
}

