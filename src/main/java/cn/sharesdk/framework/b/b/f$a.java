/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package cn.sharesdk.framework.b.b;

import android.text.TextUtils;
import com.mob.tools.utils.Hashon;
import java.util.ArrayList;
import java.util.HashMap;

public class f$a {
    public String a = "";
    public String b;
    public ArrayList c;
    public ArrayList d;
    public ArrayList e;
    public ArrayList f;
    public HashMap g;

    public f$a() {
        ArrayList arrayList;
        this.c = arrayList = new ArrayList();
        this.d = arrayList = new ArrayList();
        this.e = arrayList = new ArrayList();
        this.f = arrayList = new ArrayList();
    }

    public String toString() {
        Object object;
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        Object object2 = this.b;
        int n10 = TextUtils.isEmpty((CharSequence)object2);
        if (n10 == 0) {
            object2 = this.b.trim();
            String string2 = "";
            this.b = object2 = ((String)object2).replaceAll("\r", string2);
            this.b = object2 = ((String)object2).trim().replaceAll("\n", string2);
            object2 = ((String)object2).trim();
            object = "\r\n";
            this.b = object2 = ((String)object2).replaceAll((String)object, string2);
        }
        object2 = this.b;
        hashMap.put("text", object2);
        object2 = this.c;
        object = "url";
        hashMap.put(object, object2);
        object2 = this.d;
        if (object2 != null && (n10 = ((ArrayList)object2).size()) > 0) {
            object2 = this.d;
            object = "imgs";
            hashMap.put(object, object2);
        }
        if ((object2 = this.g) != null) {
            object2 = new Hashon();
            object = this.g;
            object2 = ((Hashon)object2).fromHashMap((HashMap)object);
            object = "attch";
            hashMap.put(object, object2);
        }
        object2 = new Hashon();
        return ((Hashon)object2).fromHashMap(hashMap);
    }
}

