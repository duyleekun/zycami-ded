/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  android.util.Pair
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.tencent.liteav.basic.c;

import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.liteav.basic.log.TXCLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b {
    private final Map a;
    private JSONObject b;

    public b() {
        HashMap hashMap;
        this.a = hashMap = new HashMap();
        this.b = null;
    }

    private int a(JSONObject object) {
        int n10;
        if (object == null) {
            return 0;
        }
        ArrayList<Pair> arrayList = new ArrayList<Pair>();
        CharSequence charSequence = Build.MANUFACTURER;
        String string2 = object.optString("MANUFACTURER");
        Object object2 = new Pair((Object)charSequence, (Object)string2);
        arrayList.add((Pair)object2);
        charSequence = Build.MODEL;
        string2 = object.optString("MODEL");
        object2 = new Pair((Object)charSequence, (Object)string2);
        arrayList.add((Pair)object2);
        int n11 = Build.VERSION.SDK_INT;
        charSequence = String.valueOf(n11);
        string2 = object.optString("VERSION");
        object2 = new Pair((Object)charSequence, (Object)string2);
        arrayList.add((Pair)object2);
        charSequence = Build.VERSION.INCREMENTAL;
        string2 = object.optString("VERSION_INCREMENTAL");
        object2 = new Pair((Object)charSequence, (Object)string2);
        arrayList.add((Pair)object2);
        charSequence = Build.DISPLAY;
        string2 = "DISPLAY";
        object = object.optString(string2);
        object2 = new Pair((Object)charSequence, object);
        arrayList.add((Pair)object2);
        object = null;
        for (int i10 = 0; i10 < (n10 = arrayList.size()); ++i10) {
            object2 = (Pair)arrayList.get(i10);
            charSequence = (CharSequence)object2.second;
            n11 = (int)(TextUtils.isEmpty((CharSequence)charSequence) ? 1 : 0);
            if (n11 != 0) {
                return i10;
            }
            charSequence = (String)object2.first;
            object2 = (String)object2.second;
            n10 = (int)(((String)charSequence).equalsIgnoreCase((String)object2) ? 1 : 0);
            if (n10 != 0) continue;
            return 0;
        }
        return arrayList.size();
    }

    private void a(Map map, String string2, JSONObject jSONObject) {
        boolean bl2;
        Iterator iterator2 = jSONObject.keys();
        while (bl2 = iterator2.hasNext()) {
            StringBuilder stringBuilder;
            String string3 = (String)iterator2.next();
            Object object = jSONObject.opt(string3);
            boolean bl3 = object instanceof JSONObject;
            String string4 = ".";
            if (bl3) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append(string4);
                stringBuilder.append(string3);
                string3 = stringBuilder.toString();
                object = (JSONObject)object;
                this.a(map, string3, (JSONObject)object);
                continue;
            }
            if (object == null) continue;
            stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(string4);
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
            object = object.toString();
            map.put(string3, object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private JSONObject b(JSONArray objectArray) {
        String string2 = "CompatibleConfig";
        JSONObject jSONObject = null;
        if (objectArray == null) return jSONObject;
        int n10 = objectArray.length();
        if (n10 == 0) {
            return jSONObject;
        }
        n10 = 0;
        String string3 = null;
        JSONObject jSONObject2 = null;
        Object object = null;
        int n11 = 0;
        try {
            int n13;
            for (int n12 = 0; n12 < (n13 = objectArray.length()); ++n12) {
                JSONObject jSONObject3 = objectArray.getJSONObject(n12);
                String string4 = "deviceinfo";
                string4 = jSONObject3.optJSONObject(string4);
                int n14 = this.a((JSONObject)string4);
                String string5 = "deviceconfig";
                jSONObject3 = jSONObject3.optJSONObject(string5);
                if (n14 <= n11 || jSONObject3 == null) continue;
                jSONObject2 = jSONObject3;
                n11 = n14;
            }
        }
        catch (JSONException jSONException) {
            object = "Find best match value failed.";
            TXCLog.e(string2, (String)object, jSONException);
        }
        int n15 = 1;
        objectArray = new Object[n15];
        objectArray[0] = object = Integer.valueOf(n11);
        string3 = "bestMatchLevel: %d";
        TXCLog.i(string2, string3, objectArray);
        if (n11 <= 0) return jSONObject;
        return jSONObject2;
    }

    private void b() {
        boolean bl2;
        CharSequence charSequence = new StringBuilder();
        Iterator iterator2 = this.a.entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = iterator2.next();
            String string2 = (String)object.getKey();
            ((StringBuilder)charSequence).append(string2);
            string2 = " : ";
            ((StringBuilder)charSequence).append(string2);
            object = (String)object.getValue();
            ((StringBuilder)charSequence).append((String)object);
            object = "\n";
            ((StringBuilder)charSequence).append((String)object);
        }
        charSequence = ((StringBuilder)charSequence).toString();
        TXCLog.i("CompatibleConfig", (String)charSequence);
    }

    /*
     * WARNING - void declaration
     */
    public long a(String string2, long l10) {
        synchronized (this) {
            void var2_6;
            block9: {
                Map map = this.a;
                Object v10 = map.get(string2);
                String string3 = (String)v10;
                boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
                if (bl2) break block9;
                try {
                    long l11 = Long.parseLong(string3);
                    return l11;
                }
                catch (NumberFormatException numberFormatException) {
                    return (long)var2_6;
                }
            }
            return (long)var2_6;
            finally {
            }
        }
    }

    public JSONObject a() {
        synchronized (this) {
            JSONObject jSONObject = this.b;
            return jSONObject;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void a(String object) {
        synchronized (this) {
            String string2;
            Object object2;
            block11: {
                boolean bl2 = TextUtils.isEmpty((CharSequence)object);
                if (!bl2) break block11;
                return;
            }
            try {
                object2 = this.a;
                object2.clear();
                object2 = new JSONObject((String)object);
                this.b = object2;
                object = this.a;
                string2 = "";
                this.a((Map)object, string2, (JSONObject)object2);
                this.b();
                return;
            }
            catch (JSONException jSONException) {
                object2 = "CompatibleConfig";
                string2 = "parse best match value failed.";
                TXCLog.e((String)object2, string2, jSONException);
                return;
            }
            finally {
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(JSONArray object) {
        synchronized (this) {
            JSONObject jSONObject;
            Object object2 = this.a;
            object2.clear();
            this.b = jSONObject = this.b((JSONArray)object);
            if (jSONObject == null) {
                String string2 = "CompatibleConfig";
                object2 = "can't find best match value";
                TXCLog.i(string2, (String)object2);
                return;
            }
            object2 = this.a;
            String string3 = "";
            this.a((Map)object2, string3, jSONObject);
            this.b();
            return;
        }
    }
}

