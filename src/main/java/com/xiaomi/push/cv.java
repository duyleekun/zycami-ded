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
import com.xiaomi.push.bf;
import com.xiaomi.push.cu;
import com.xiaomi.push.cx;
import com.xiaomi.push.cz;
import com.xiaomi.push.de;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class cv {
    private double a;
    private long a;
    public String a;
    private ArrayList a = "";
    private long b;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    private String i;
    private String j;

    public cv(String object) {
        long l10;
        Object object2 = new ArrayList();
        this.a = object2;
        this.a = 0.1;
        this.j = object2 = "s.mi1.cc";
        this.b = l10 = 86400000L;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            this.a = l10 = System.currentTimeMillis();
            object2 = this.a;
            de de2 = new de((String)object, -1);
            ((ArrayList)object2).add(de2);
            this.a = object2 = cz.a();
            this.b = object;
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
    private void c(String string2) {
        synchronized (this) {
            Object object = this.a;
            object = ((ArrayList)object).iterator();
            boolean bl2;
            while (bl2 = object.hasNext()) {
                Object object2 = object.next();
                object2 = (de)object2;
                object2 = ((de)object2).a;
                bl2 = TextUtils.equals(object2, (CharSequence)string2);
                if (!bl2) continue;
                object.remove();
            }
            return;
        }
    }

    public cv a(JSONObject jSONObject) {
        synchronized (this) {
            String string2 = "net";
            string2 = jSONObject.optString(string2);
            this.a = string2;
            string2 = "ttl";
            long l10 = jSONObject.getLong(string2);
            this.b = l10;
            string2 = "pct";
            double d10 = jSONObject.getDouble(string2);
            this.a = d10;
            string2 = "ts";
            l10 = jSONObject.getLong(string2);
            this.a = l10;
            string2 = "city";
            string2 = jSONObject.optString(string2);
            this.d = string2;
            string2 = "prv";
            string2 = jSONObject.optString(string2);
            this.c = string2;
            string2 = "cty";
            string2 = jSONObject.optString(string2);
            this.g = string2;
            string2 = "isp";
            string2 = jSONObject.optString(string2);
            this.e = string2;
            string2 = "ip";
            string2 = jSONObject.optString(string2);
            this.f = string2;
            string2 = "host";
            string2 = jSONObject.optString(string2);
            this.b = string2;
            string2 = "xf";
            string2 = jSONObject.optString(string2);
            this.h = string2;
            string2 = "fbs";
            jSONObject = jSONObject.getJSONArray(string2);
            int n10 = 0;
            string2 = null;
            while (true) {
                int n11 = jSONObject.length();
                if (n10 >= n11) break;
                de de2 = new de();
                JSONObject jSONObject2 = jSONObject.getJSONObject(n10);
                de2 = de2.a(jSONObject2);
                this.a(de2);
                ++n10;
                continue;
                break;
            }
            return this;
        }
    }

    public String a() {
        synchronized (this) {
            int n10;
            Object object;
            block22: {
                block21: {
                    object = this.i;
                    n10 = TextUtils.isEmpty((CharSequence)object);
                    if (n10 != 0) break block21;
                    object = this.i;
                    return object;
                }
                object = this.e;
                n10 = TextUtils.isEmpty((CharSequence)object);
                if (n10 == 0) break block22;
                return "hardcode_isp";
            }
            n10 = 5;
            object = new String[n10];
            int n11 = 0;
            String string2 = null;
            String string3 = this.e;
            object[0] = string3;
            n11 = 1;
            string3 = this.c;
            object[n11] = string3;
            n11 = 2;
            string3 = this.d;
            object[n11] = string3;
            n11 = 3;
            string3 = this.g;
            object[n11] = string3;
            n11 = 4;
            string3 = this.f;
            object[n11] = string3;
            string2 = "_";
            object = bf.a(object, string2);
            this.i = object;
            return object;
        }
    }

    public ArrayList a() {
        synchronized (this) {
            ArrayList arrayList = null;
            arrayList = this.a(false);
            return arrayList;
        }
    }

    public ArrayList a(String arrayList) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)((Object)arrayList));
        if (!bl2) {
            Object object;
            URL uRL = new URL((String)((Object)arrayList));
            boolean bl3 = TextUtils.equals((CharSequence)((Object)(arrayList = uRL.getHost())), (CharSequence)(object = this.b));
            if (bl3) {
                int n10;
                arrayList = new ArrayList<Object>();
                boolean bl4 = true;
                object = this.a(bl4).iterator();
                while ((n10 = object.hasNext()) != 0) {
                    Object object2 = (String)object.next();
                    int n11 = uRL.getPort();
                    object2 = cx.a((String)object2, n11);
                    String string2 = uRL.getProtocol();
                    String string3 = ((cx)object2).a();
                    n10 = ((cx)object2).a();
                    String string4 = uRL.getFile();
                    URL uRL2 = new URL(string2, string3, n10, string4);
                    object2 = uRL2.toString();
                    arrayList.add(object2);
                }
                return arrayList;
            }
            arrayList = new ArrayList<Object>("the url is not supported by the fallback");
            throw arrayList;
        }
        arrayList = new ArrayList<Object>("the url is empty.");
        throw arrayList;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public ArrayList a(boolean bl2) {
        synchronized (this) {
            ArrayList arrayList = this.a;
            int n10 = arrayList.size();
            Object[] objectArray = new de[n10];
            ArrayList<Object> arrayList2 = this.a;
            arrayList2.toArray(objectArray);
            Arrays.sort(objectArray);
            arrayList2 = new ArrayList<Object>();
            int n11 = 0;
            while (n11 < n10) {
                Object object = objectArray[n11];
                if (bl2) {
                    object = ((de)object).a;
                } else {
                    int n12;
                    String string2 = ((de)object).a;
                    String string3 = ":";
                    int n13 = string2.indexOf(string3);
                    if (n13 != (n12 = -1)) {
                        object = ((de)object).a;
                        object = ((String)object).substring(0, n13);
                    } else {
                        object = ((de)object).a;
                    }
                }
                arrayList2.add(object);
                ++n11;
            }
            return arrayList2;
        }
    }

    public JSONObject a() {
        synchronized (this) {
            JSONObject jSONObject = new JSONObject();
            String string2 = "net";
            Object object = this.a;
            jSONObject.put(string2, object);
            string2 = "ttl";
            long l10 = this.b;
            jSONObject.put(string2, l10);
            string2 = "pct";
            double d10 = this.a;
            jSONObject.put(string2, d10);
            string2 = "ts";
            l10 = this.a;
            jSONObject.put(string2, l10);
            string2 = "city";
            object = this.d;
            jSONObject.put(string2, object);
            string2 = "prv";
            object = this.c;
            jSONObject.put(string2, object);
            string2 = "cty";
            object = this.g;
            jSONObject.put(string2, object);
            string2 = "isp";
            object = this.e;
            jSONObject.put(string2, object);
            string2 = "ip";
            object = this.f;
            jSONObject.put(string2, object);
            string2 = "host";
            object = this.b;
            jSONObject.put(string2, object);
            string2 = "xf";
            object = this.h;
            jSONObject.put(string2, object);
            string2 = new JSONArray();
            object = this.a;
            object = ((ArrayList)object).iterator();
            while (true) {
                boolean bl2 = object.hasNext();
                if (!bl2) break;
                Object object2 = object.next();
                object2 = (de)object2;
                object2 = ((de)object2).a();
                string2.put(object2);
                continue;
                break;
            }
            object = "fbs";
            jSONObject.put((String)object, (Object)string2);
            return jSONObject;
        }
    }

    public void a(double d10) {
        this.a = d10;
    }

    public void a(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            this.b = l10;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("the duration is invalid ");
        stringBuilder.append(l10);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public void a(de de2) {
        synchronized (this) {
            Object object = de2.a;
            this.c((String)object);
            object = this.a;
            ((ArrayList)object).add(de2);
            return;
        }
    }

    public void a(String string2) {
        synchronized (this) {
            de de2 = new de(string2);
            this.a(de2);
            return;
        }
    }

    public void a(String string2, int n10, long l10, long l11, Exception exception) {
        cu cu2 = new cu(n10, l10, l11, exception);
        this.a(string2, cu2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void a(String string2, long l10, long l11) {
        String string3;
        try {
            URL uRL = new URL(string2);
            string3 = uRL.getHost();
        }
        catch (MalformedURLException malformedURLException) {
            return;
        }
        this.b(string3, l10, l11);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void a(String string2, long l10, long l11, Exception exception) {
        String string3;
        try {
            URL uRL = new URL(string2);
            string3 = uRL.getHost();
        }
        catch (MalformedURLException malformedURLException) {
            return;
        }
        this.b(string3, l10, l11, exception);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(String string2, cu cu2) {
        synchronized (this) {
            boolean bl2;
            Object object = this.a;
            object = ((ArrayList)object).iterator();
            while (bl2 = object.hasNext()) {
                void var2_2;
                Object object2 = object.next();
                object2 = (de)object2;
                String string3 = ((de)object2).a;
                boolean bl3 = TextUtils.equals((CharSequence)string2, (CharSequence)string3);
                if (!bl3) continue;
                ((de)object2).a((cu)var2_2);
                break;
            }
            return;
        }
    }

    public void a(String[] stringArray) {
        synchronized (this) {
            int n10;
            Object object;
            int n11;
            int n12;
            Object object2 = this.a;
            int n13 = ((ArrayList)object2).size() + -1;
            while (true) {
                ArrayList arrayList = null;
                if (n13 < 0) break;
                n12 = stringArray.length;
                for (n11 = 0; n11 < n12; ++n11) {
                    object = stringArray[n11];
                    Object object3 = this.a;
                    object3 = ((ArrayList)object3).get(n13);
                    object3 = (de)object3;
                    object3 = ((de)object3).a;
                    n10 = (int)(TextUtils.equals((CharSequence)object3, (CharSequence)object) ? 1 : 0);
                    if (n10 == 0) continue;
                    arrayList = this.a;
                    arrayList.remove(n13);
                    break;
                }
                n13 += -1;
            }
            object2 = this.a;
            object2 = ((ArrayList)object2).iterator();
            n12 = 0;
            while (true) {
                n10 = object2.hasNext();
                if (n10 == 0) break;
                object = object2.next();
                object = (de)object;
                n10 = ((de)object).a;
                if (n10 <= n12) continue;
                n12 = n10;
                continue;
                break;
            }
            while (true) {
                n13 = stringArray.length;
                if (n11 >= n13) break;
                object = stringArray[n11];
                int n14 = stringArray.length + n12 - n11;
                object2 = new de((String)object, n14);
                this.a((de)object2);
                ++n11;
                continue;
                break;
            }
            return;
        }
    }

    public boolean a() {
        String string2 = this.a;
        String string3 = cz.a();
        return TextUtils.equals((CharSequence)string2, (CharSequence)string3);
    }

    public boolean a(cv object) {
        String string2 = this.a;
        object = ((cv)object).a;
        return TextUtils.equals((CharSequence)string2, (CharSequence)object);
    }

    public void b(String string2) {
        this.j = string2;
    }

    public void b(String string2, long l10, long l11) {
        this.a(string2, 0, l10, l11, null);
    }

    public void b(String string2, long l10, long l11, Exception exception) {
        this.a(string2, -1, l10, l11, exception);
    }

    public boolean b() {
        long l10 = System.currentTimeMillis();
        long l11 = this.a;
        long l12 = (l10 -= l11) - (l11 = this.b);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object < 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public boolean c() {
        String string2;
        String string3;
        long l10;
        long l11 = 864000000L;
        long l12 = this.b;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object >= 0) {
            l12 = l11;
        }
        l11 = System.currentTimeMillis();
        long l14 = this.a;
        long l15 = l11 - l14;
        long l16 = l15 == l12 ? 0 : (l15 < l12 ? -1 : 1);
        if (l16 <= 0 && ((l16 = (l10 = (l11 -= l14) - (l12 = this.b)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) <= 0 || (l16 = (long)(string3 = this.a).startsWith(string2 = "WIFI-")) == false)) {
            l16 = 0;
            string3 = null;
        } else {
            l16 = 1;
        }
        return (boolean)l16;
    }

    public String toString() {
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.a;
        stringBuilder.append(string2);
        string2 = "\n";
        stringBuilder.append(string2);
        Object object = this.a();
        stringBuilder.append((String)object);
        object = this.a.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (de)object.next();
            stringBuilder.append(string2);
            object2 = ((de)object2).toString();
            stringBuilder.append((String)object2);
        }
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

