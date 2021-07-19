/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.push.cv;
import com.xiaomi.push.cz;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class cw {
    private String a;
    private final ArrayList a;

    public cw() {
        ArrayList arrayList;
        this.a = arrayList = new ArrayList();
    }

    public cw(String object) {
        ArrayList arrayList;
        this.a = arrayList = new ArrayList();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            this.a = object;
            return;
        }
        object = new IllegalArgumentException("the host is empty");
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public cv a() {
        synchronized (this) {
            Object object = this.a;
            int n10 = ((ArrayList)object).size() + -1;
            while (n10 >= 0) {
                Object object2 = this.a;
                object2 = ((ArrayList)object2).get(n10);
                boolean bl2 = ((cv)(object2 = (cv)object2)).a();
                if (bl2) {
                    object = cz.a();
                    String string2 = ((cv)object2).a();
                    ((cz)object).a(string2);
                    return object2;
                }
                n10 += -1;
            }
            return null;
        }
    }

    public cw a(JSONObject jSONObject) {
        synchronized (this) {
            String string2 = "host";
            string2 = jSONObject.getString(string2);
            this.a = string2;
            string2 = "fbs";
            jSONObject = jSONObject.getJSONArray(string2);
            int n10 = 0;
            string2 = null;
            while (true) {
                int n11 = jSONObject.length();
                if (n10 >= n11) break;
                ArrayList arrayList = this.a;
                String string3 = this.a;
                cv cv2 = new cv(string3);
                string3 = jSONObject.getJSONObject(n10);
                cv2 = cv2.a((JSONObject)string3);
                arrayList.add(cv2);
                ++n10;
                continue;
                break;
            }
            return this;
        }
    }

    public String a() {
        return this.a;
    }

    public ArrayList a() {
        return this.a;
    }

    public JSONObject a() {
        synchronized (this) {
            JSONObject jSONObject = new JSONObject();
            String string2 = "host";
            Object object = this.a;
            jSONObject.put(string2, object);
            string2 = new JSONArray();
            object = this.a;
            object = ((ArrayList)object).iterator();
            while (true) {
                boolean bl2 = object.hasNext();
                if (!bl2) break;
                Object object2 = object.next();
                object2 = (cv)object2;
                object2 = ((cv)object2).a();
                string2.put(object2);
                continue;
                break;
            }
            object = "fbs";
            jSONObject.put((String)object, (Object)string2);
            return jSONObject;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(cv cv2) {
        synchronized (this) {
            Object object;
            int n10;
            int n11;
            ArrayList arrayList = null;
            for (n11 = 0; n11 < (n10 = ((ArrayList)(object = this.a)).size()); ++n11) {
                object = this.a;
                object = ((ArrayList)object).get(n11);
                n10 = (int)(((cv)(object = (cv)object)).a(cv2) ? 1 : 0);
                if (n10 == 0) continue;
                object = this.a;
                ((ArrayList)object).set(n11, cv2);
                break;
            }
            if (n11 >= (n10 = ((ArrayList)(object = this.a)).size())) {
                arrayList = this.a;
                arrayList.add(cv2);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(boolean bl2) {
        synchronized (this) {
            ArrayList arrayList = this.a;
            int n10 = arrayList.size() + -1;
            while (true) {
                block8: {
                    Object object;
                    block9: {
                        boolean bl3;
                        block7: {
                            if (n10 < 0) {
                                return;
                            }
                            object = this.a;
                            object = ((ArrayList)object).get(n10);
                            object = (cv)object;
                            if (!bl2) break block7;
                            bl3 = ((cv)object).c();
                            if (!bl3) break block8;
                            object = this.a;
                            break block9;
                        }
                        bl3 = ((cv)object).b();
                        if (bl3) break block8;
                        object = this.a;
                    }
                    ((ArrayList)object).remove(n10);
                }
                n10 += -1;
            }
        }
    }

    public String toString() {
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.a;
        stringBuilder.append((String)object);
        stringBuilder.append("\n");
        object = this.a.iterator();
        while (bl2 = object.hasNext()) {
            cv cv2 = (cv)object.next();
            stringBuilder.append(cv2);
        }
        return stringBuilder.toString();
    }
}

