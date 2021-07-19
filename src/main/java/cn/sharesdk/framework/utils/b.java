/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 */
package cn.sharesdk.framework.utils;

import android.util.Base64;
import cn.sharesdk.framework.utils.b$1;
import cn.sharesdk.framework.utils.b$a;
import cn.sharesdk.framework.utils.b$b;
import cn.sharesdk.framework.utils.c;
import com.mob.tools.network.KVPair;
import java.security.Key;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class b {
    private b$b a;
    private c b;

    public b() {
        Object object = new b$b();
        this.a = object;
        this.b = object = new c("-._~", false);
    }

    private ArrayList a(long l10, String object) {
        int n10;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        String string2 = this.a.a;
        String string3 = "oauth_consumer_key";
        Object object2 = new KVPair(string3, string2);
        arrayList.add(object2);
        object2 = new KVPair("oauth_signature_method", object);
        arrayList.add(object2);
        long l11 = l10 / 1000L;
        object2 = String.valueOf(l11);
        string2 = "oauth_timestamp";
        object = new KVPair(string2, object2);
        arrayList.add(object);
        Object object3 = String.valueOf(l10);
        object = new KVPair("oauth_nonce", object3);
        arrayList.add(object);
        Object object4 = "oauth_version";
        object = "1.0";
        object3 = new KVPair((String)object4, object);
        arrayList.add(object3);
        object3 = this.a.c;
        if (object3 != null && (n10 = ((String)object3).length()) > 0) {
            object = "oauth_token";
            object4 = new KVPair((String)object, object3);
            arrayList.add(object4);
        }
        return arrayList;
    }

    private ArrayList a(long l10, ArrayList arrayList, String string2) {
        boolean bl2;
        Object object;
        Object object2;
        Object object3;
        Object object4;
        int n10;
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        if (arrayList != null) {
            arrayList = arrayList.iterator();
            while ((n10 = arrayList.hasNext()) != 0) {
                object4 = (KVPair)arrayList.next();
                object3 = ((KVPair)object4).name;
                object3 = this.a((String)object3);
                object4 = (String)((KVPair)object4).value;
                object4 = this.a((String)object4);
                hashMap.put(object3, object4);
            }
        }
        if ((object2 = this.a(l10, string2)) != null) {
            boolean bl3;
            object2 = ((ArrayList)object2).iterator();
            while (bl3 = object2.hasNext()) {
                object = (KVPair)object2.next();
                arrayList = object.name;
                arrayList = this.a((String)((Object)arrayList));
                object = (String)object.value;
                object = this.a((String)object);
                hashMap.put(arrayList, object);
            }
        }
        int n11 = hashMap.size();
        object = new String[n11];
        arrayList = hashMap.entrySet().iterator();
        int n12 = 0;
        string2 = null;
        n10 = 0;
        object4 = null;
        while (bl2 = arrayList.hasNext()) {
            object3 = (String)((Map.Entry)arrayList.next()).getKey();
            object[n10] = object3;
            ++n10;
        }
        Arrays.sort(object);
        arrayList = new ArrayList<Object>();
        while (n12 < n11) {
            object4 = object[n12];
            Object v10 = hashMap.get(object4);
            object3 = new KVPair((String)object4, v10);
            arrayList.add(object3);
            ++n12;
        }
        return arrayList;
    }

    private ArrayList a(String object, String object2, ArrayList object3, b$a object4) {
        long l10 = System.currentTimeMillis();
        Object object5 = b$1.a;
        int n10 = ((Enum)object4).ordinal();
        n10 = object5[n10];
        int n11 = 1;
        Object object6 = null;
        String string2 = "HMAC-SHA1";
        char c10 = '&';
        if (n10 != n11) {
            int n12 = 2;
            if (n10 != n12) {
                n12 = 0;
                object = null;
            } else {
                object = new StringBuilder();
                object2 = this.a.b;
                object2 = this.a((String)object2);
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append(c10);
                object2 = this.a.d;
                object2 = this.a((String)object2);
                ((StringBuilder)object).append((String)object2);
                String string3 = ((StringBuilder)object).toString();
                object6 = "PLAINTEXT";
                object = string3;
            }
        } else {
            object4 = new StringBuilder();
            object5 = this.a.b;
            object5 = this.a((String)object5);
            ((StringBuilder)object4).append((String)object5);
            ((StringBuilder)object4).append(c10);
            object5 = this.a.d;
            object5 = this.a((String)object5);
            ((StringBuilder)object4).append((String)object5);
            object4 = ((StringBuilder)object4).toString();
            object5 = "utf-8";
            object4 = ((String)object4).getBytes((String)object5);
            object6 = new SecretKeySpec((byte[])object4, string2);
            object4 = Mac.getInstance(string2);
            ((Mac)object4).init((Key)object6);
            object3 = this.a(l10, (ArrayList)object3, string2);
            object3 = this.b((ArrayList)object3);
            object6 = new StringBuilder();
            ((StringBuilder)object6).append((String)object2);
            ((StringBuilder)object6).append(c10);
            object = this.a((String)object);
            ((StringBuilder)object6).append((String)object);
            ((StringBuilder)object6).append(c10);
            object = this.a((String)object3);
            ((StringBuilder)object6).append((String)object);
            object = ((StringBuilder)object6).toString().getBytes((String)object5);
            object = ((Mac)object4).doFinal((byte[])object);
            object3 = null;
            object = Base64.encode((byte[])object, (int)0);
            object2 = new String((byte[])object);
            object = ((String)object2).trim();
            object6 = string2;
        }
        object2 = this.a(l10, (String)object6);
        object3 = new KVPair("oauth_signature", object);
        ((ArrayList)object2).add(object3);
        return object2;
    }

    private String b(ArrayList object) {
        int n10;
        if (object != null && (n10 = ((ArrayList)object).size()) > 0) {
            boolean bl2;
            StringBuilder stringBuilder = new StringBuilder();
            int n11 = 0;
            object = ((ArrayList)object).iterator();
            while (bl2 = object.hasNext()) {
                char c10;
                Object object2 = (KVPair)object.next();
                if (n11 > 0) {
                    c10 = '&';
                    stringBuilder.append(c10);
                }
                String string2 = ((KVPair)object2).name;
                stringBuilder.append(string2);
                c10 = '=';
                stringBuilder.append(c10);
                object2 = (String)((KVPair)object2).value;
                stringBuilder.append((String)object2);
                ++n11;
            }
            return stringBuilder.toString();
        }
        return "";
    }

    public b$b a() {
        return this.a;
    }

    public String a(String string2) {
        if (string2 == null) {
            return "";
        }
        return this.b.escape(string2);
    }

    public ArrayList a(String string2, ArrayList arrayList) {
        b$a b$a = b$a.a;
        return this.a(string2, arrayList, b$a);
    }

    public ArrayList a(String string2, ArrayList arrayList, b$a b$a) {
        return this.a(string2, "POST", arrayList, b$a);
    }

    public ArrayList a(ArrayList arrayList) {
        boolean bl2;
        Object object = new StringBuilder("OAuth ");
        arrayList = arrayList.iterator();
        int n10 = 0;
        KVPair kVPair = null;
        while (bl2 = arrayList.hasNext()) {
            Object object2 = (KVPair)arrayList.next();
            if (n10 > 0) {
                char c10 = ',';
                ((StringBuilder)object).append(c10);
            }
            String string2 = (String)((KVPair)object2).value;
            string2 = this.a(string2);
            object2 = ((KVPair)object2).name;
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append("=\"");
            ((StringBuilder)object).append(string2);
            object2 = "\"";
            ((StringBuilder)object).append((String)object2);
            ++n10;
        }
        arrayList = new ArrayList<KVPair>();
        object = ((StringBuilder)object).toString();
        kVPair = new KVPair("Authorization", object);
        arrayList.add(kVPair);
        object = new KVPair("Content-Type", "application/x-www-form-urlencoded");
        arrayList.add((KVPair)object);
        return arrayList;
    }

    public void a(String string2, String string3) {
        b$b b$b = this.a;
        b$b.c = string2;
        b$b.d = string3;
    }

    public void a(String string2, String string3, String string4) {
        b$b b$b = this.a;
        b$b.a = string2;
        b$b.b = string3;
        b$b.e = string4;
    }

    public ArrayList b(String string2, ArrayList arrayList) {
        b$a b$a = b$a.a;
        return this.b(string2, arrayList, b$a);
    }

    public ArrayList b(String string2, ArrayList arrayList, b$a b$a) {
        return this.a(string2, "GET", arrayList, b$a);
    }

    public ArrayList c(String string2, ArrayList arrayList, b$a b$a) {
        return this.a(string2, "PUT", arrayList, b$a);
    }
}

