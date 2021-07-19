/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.tencent.liteav.network;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.network.i$a;
import com.tencent.liteav.network.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class i {
    public JSONObject a;

    public i(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    public j a(String object, String string2) {
        boolean bl2;
        Object object2;
        Object object3;
        boolean bl3;
        Iterator iterator2 = this.i();
        if (object != null && iterator2 != null) {
            iterator2 = iterator2.iterator();
            while (bl3 = iterator2.hasNext()) {
                object3 = (i$a)iterator2.next();
                object2 = ((i$a)object3).a;
                bl2 = ((String)object2).equals(object);
                if (!bl2) continue;
                object = ((i$a)object3).c;
                break;
            }
        } else {
            object = null;
        }
        if (object != null) {
            iterator2 = this.c().iterator();
            while (bl3 = iterator2.hasNext()) {
                object3 = (j)iterator2.next();
                object2 = ((j)object3).i;
                bl2 = object.contains(object2);
                if (!bl2 || (object2 = ((j)object3).e()) != null && !(bl2 = ((String)(object2 = ((j)object3).e())).contains(string2))) continue;
                return object3;
            }
        }
        return null;
    }

    public String a() {
        Object object = this.e();
        if (object != null) {
            return this.e().a;
        }
        object = this.c();
        int n10 = object.size();
        if (n10 != 0) {
            object = this.j();
            if (object != null) {
                boolean bl2;
                Iterator iterator2 = this.c().iterator();
                while (bl2 = iterator2.hasNext()) {
                    j j10 = (j)iterator2.next();
                    Integer n11 = j10.a();
                    boolean bl3 = object.contains(n11);
                    if (!bl3) continue;
                    return j10.a;
                }
            }
            return ((j)this.c().get((int)0)).a;
        }
        object = this.d();
        if (object != null) {
            return this.d().a;
        }
        return null;
    }

    public j b(String string2, String string3) {
        boolean bl2;
        if (string2 == null) {
            return null;
        }
        Iterator iterator2 = this.c().iterator();
        while (bl2 = iterator2.hasNext()) {
            j j10 = (j)iterator2.next();
            String string4 = j10.f();
            boolean bl3 = string2.equals(string4);
            if (!bl3 || (string4 = j10.e()) != null && !(bl3 = (string4 = j10.e()).contains(string3))) continue;
            return j10;
        }
        return null;
    }

    public String b() {
        block4: {
            JSONObject jSONObject = this.a;
            String string2 = "coverInfo";
            jSONObject = jSONObject.getJSONObject(string2);
            if (jSONObject == null) break block4;
            string2 = "coverUrl";
            try {
                return jSONObject.getString(string2);
            }
            catch (JSONException jSONException) {
                string2 = "TXPlayInfoResponse";
                String string3 = "get cover url failed.";
                TXCLog.e(string2, string3, jSONException);
            }
        }
        return null;
    }

    public List c() {
        ArrayList<j> arrayList;
        block30: {
            int n10;
            arrayList = new ArrayList<j>();
            JSONObject jSONObject = this.a;
            String string2 = "videoInfo";
            jSONObject = jSONObject.getJSONObject(string2);
            string2 = "transcodeList";
            try {
                jSONObject = jSONObject.getJSONArray(string2);
                if (jSONObject == null) break block30;
                n10 = 0;
                string2 = null;
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
            }
            while (true) {
                int n11 = jSONObject.length();
                if (n10 >= n11) break;
                Object object = jSONObject.getJSONObject(n10);
                j j10 = new j();
                String string3 = "url";
                string3 = object.getString(string3);
                j10.a = string3;
                string3 = "duration";
                int n12 = object.getInt(string3);
                j10.e = n12;
                string3 = "width";
                n12 = object.getInt(string3);
                j10.c = n12;
                string3 = "height";
                n12 = object.getInt(string3);
                j10.b = n12;
                string3 = "totalSize";
                n12 = object.getInt(string3);
                String string4 = "size";
                int n13 = object.getInt(string4);
                n12 = Math.max(n12, n13);
                j10.d = n12;
                string3 = "bitrate";
                n12 = object.getInt(string3);
                j10.f = n12;
                string3 = "definition";
                n12 = object.getInt(string3);
                j10.i = n12;
                string3 = "container";
                string3 = object.getString(string3);
                j10.g = string3;
                string3 = "templateName";
                object = object.getString(string3);
                j10.h = object;
                arrayList.add(j10);
                ++n10;
                continue;
                break;
            }
        }
        return arrayList;
    }

    public j d() {
        Object object;
        JSONObject jSONObject;
        try {
            jSONObject = this.a;
            object = "videoInfo";
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return null;
        }
        jSONObject = jSONObject.getJSONObject((String)object);
        object = "sourceVideo";
        jSONObject = jSONObject.getJSONObject((String)object);
        object = new j();
        String string2 = "url";
        string2 = jSONObject.getString(string2);
        ((j)object).a = string2;
        string2 = "duration";
        int n10 = jSONObject.getInt(string2);
        ((j)object).e = n10;
        string2 = "width";
        n10 = jSONObject.getInt(string2);
        ((j)object).c = n10;
        string2 = "height";
        n10 = jSONObject.getInt(string2);
        ((j)object).b = n10;
        string2 = "size";
        n10 = jSONObject.getInt(string2);
        String string3 = "totalSize";
        int n11 = jSONObject.getInt(string3);
        n10 = Math.max(n10, n11);
        ((j)object).d = n10;
        string2 = "bitrate";
        int n12 = jSONObject.getInt(string2);
        ((j)object).f = n12;
        return object;
    }

    public j e() {
        Object object;
        Object object2;
        try {
            object2 = this.a;
            object = "videoInfo";
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return null;
        }
        object2 = object2.getJSONObject((String)object);
        object = "masterPlayList";
        object2 = object2.getJSONObject((String)object);
        object = new j();
        String string2 = "url";
        object2 = object2.getString(string2);
        ((j)object).a = object2;
        return object;
    }

    public String f() {
        block5: {
            JSONObject jSONObject = this.a;
            String string2 = "videoInfo";
            jSONObject = jSONObject.getJSONObject(string2);
            string2 = "basicInfo";
            jSONObject = jSONObject.getJSONObject(string2);
            if (jSONObject == null) break block5;
            string2 = "name";
            try {
                return jSONObject.getString(string2);
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
            }
        }
        return null;
    }

    public String g() {
        block5: {
            JSONObject jSONObject = this.a;
            String string2 = "videoInfo";
            jSONObject = jSONObject.getJSONObject(string2);
            string2 = "basicInfo";
            jSONObject = jSONObject.getJSONObject(string2);
            if (jSONObject == null) break block5;
            string2 = "description";
            try {
                return jSONObject.getString(string2);
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
            }
        }
        return null;
    }

    public String h() {
        String string2;
        JSONObject jSONObject;
        try {
            jSONObject = this.a;
            string2 = "playerInfo";
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return null;
        }
        jSONObject = jSONObject.getJSONObject(string2);
        string2 = "defaultVideoClassification";
        return jSONObject.getString(string2);
    }

    public List i() {
        int n10;
        ArrayList<i$a> arrayList = new ArrayList<i$a>();
        JSONObject jSONObject = this.a;
        String string2 = "playerInfo";
        jSONObject = jSONObject.getJSONObject(string2);
        string2 = "videoClassification";
        try {
            jSONObject = jSONObject.getJSONArray(string2);
            string2 = null;
            n10 = 0;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
            return null;
        }
        while (true) {
            int n11 = jSONObject.length();
            if (n10 >= n11) break;
            i$a i$a = new i$a();
            Object object = jSONObject.getJSONObject(n10);
            String string3 = "id";
            object = object.getString(string3);
            i$a.a = object;
            object = jSONObject.getJSONObject(n10);
            string3 = "name";
            object = object.getString(string3);
            i$a.b = object;
            object = new ArrayList();
            i$a.c = object;
            object = jSONObject.getJSONObject(n10);
            string3 = "definitionList";
            object = object.getJSONArray(string3);
            int n12 = 0;
            string3 = null;
            while (true) {
                int n13 = object.length();
                if (n12 >= n13) break;
                List list = i$a.c;
                int n14 = object.getInt(n12);
                Integer n15 = n14;
                list.add(n15);
                ++n12;
                continue;
                break;
            }
            arrayList.add(i$a);
            ++n10;
            continue;
            break;
        }
        return arrayList;
    }

    public List j() {
        Object object = this.i();
        String string2 = this.h();
        if (string2 != null && object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                i$a i$a = (i$a)object.next();
                String string3 = i$a.a;
                boolean bl3 = string3.equals(string2);
                if (!bl3) continue;
                return i$a.c;
            }
        }
        return null;
    }
}

