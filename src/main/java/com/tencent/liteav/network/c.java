/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.tencent.liteav.network;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.network.a;
import com.tencent.liteav.network.b;
import com.tencent.liteav.network.c$1;
import com.tencent.liteav.network.m;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    public b a;
    public int b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final int j;
    private final int k;
    private Thread l;

    public c() {
        int n10;
        this.c = "https://tcdns.myqcloud.com/queryip";
        this.d = "https://tcdnsipv6.myqcloud.com/queryip";
        this.e = "forward_stream";
        this.f = "forward_num";
        this.g = "request_type";
        this.h = "sdk_version";
        this.i = "51451748-d8f2-4629-9071-db2983aa7251";
        this.j = n10 = 5;
        this.k = 2;
        this.a = null;
        this.b = n10;
        this.l = null;
    }

    private a a(JSONObject jSONObject) {
        a a10;
        block12: {
            String string2 = "type";
            a10 = new a();
            String string3 = "ip";
            try {
                string3 = jSONObject.getString(string3);
            }
            catch (JSONException jSONException) {
                TXCLog.e("TXCIntelligentRoute", "get ip record from json object failed.", jSONException);
                return null;
            }
            a10.a = string3;
            string3 = "port";
            string3 = jSONObject.getString(string3);
            a10.b = string3;
            boolean bl2 = false;
            string3 = null;
            a10.e = 0;
            a10.c = false;
            string3 = a10.a;
            bl2 = this.c(string3);
            a10.d = bl2;
            bl2 = jSONObject.has(string2);
            if (!bl2) break block12;
            int n10 = jSONObject.getInt(string2);
            int n11 = 2;
            if (n10 != n11) break block12;
            n10 = 1;
            a10.c = n10;
        }
        return a10;
    }

    public static /* synthetic */ String a(c c10, String string2, int n10, String string3) {
        return c10.a(string2, n10, string3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String a(String object, int n10, String object2) {
        String string2 = "";
        StringBuffer stringBuffer = new StringBuffer(string2);
        try {
            object = this.b((String)object, n10, (String)object2);
            if (object == null) {
                return string2;
            }
            object2 = new InputStreamReader((InputStream)object);
            BufferedReader bufferedReader = new BufferedReader((Reader)object2);
            while ((object = bufferedReader.readLine()) != null) {
                stringBuffer.append((String)object);
            }
            return stringBuffer.toString();
        }
        catch (IOException iOException) {
            String string3 = "TXCIntelligentRoute";
            object2 = "get json string from url failed.";
            TXCLog.e(string3, (String)object2, iOException);
        }
        return stringBuffer.toString();
    }

    public static /* synthetic */ ArrayList a(c c10, String string2) {
        return c10.a(string2);
    }

    private ArrayList a(String object) {
        long l10;
        long l11;
        String string2;
        int n10;
        ArrayList arrayList;
        String string3;
        String string4;
        block41: {
            boolean bl2;
            Object object2;
            int n11;
            string4 = "51451748-d8f2-4629-9071-db2983aa7251";
            string3 = "Network";
            arrayList = new ArrayList();
            Object object3 = new JSONObject((String)object);
            object = "state";
            n10 = object3.getInt((String)object);
            int n12 = 0;
            string2 = null;
            if (n10 != 0) {
                return null;
            }
            object = "content";
            object = object3.getJSONObject((String)object);
            object3 = "list";
            object = object.getJSONArray((String)object3);
            if (object == null) {
                return null;
            }
            object3 = null;
            n12 = 0;
            string2 = null;
            while (true) {
                block39: {
                    n11 = object.length();
                    if (n12 >= n11) break;
                    object2 = object.opt(n12);
                    object2 = (JSONObject)object2;
                    object2 = this.a((JSONObject)object2);
                    if (object2 == null) break block39;
                    bl2 = ((a)object2).c;
                    if (!bl2) break block39;
                    arrayList.add(object2);
                }
                ++n12;
            }
            n12 = 0;
            string2 = null;
            while (true) {
                block40: {
                    n11 = object.length();
                    if (n12 >= n11) break;
                    object2 = object.opt(n12);
                    object2 = (JSONObject)object2;
                    object2 = this.a((JSONObject)object2);
                    if (object2 == null) break block40;
                    bl2 = ((a)object2).c;
                    if (bl2) break block40;
                    arrayList.add(object2);
                }
                ++n12;
            }
            try {
                object = com.tencent.liteav.basic.c.c.a();
                string2 = "EnableRouteOptimize";
            }
            catch (JSONException jSONException) {
                TXCLog.e("TXCIntelligentRoute", "get records from json string failed.", jSONException);
                return arrayList;
            }
            l11 = ((com.tencent.liteav.basic.c.c)object).a(string3, string2);
            l10 = 1L;
            n10 = (int)(l11 == l10 ? 0 : (l11 < l10 ? -1 : 1));
            if (n10 == 0) {
                object = m.a();
                n10 = (int)(((m)object).c() ? 1 : 0);
                if (n10 == 0) break block41;
                n10 = 1;
                arrayList = this.a(arrayList, n10 != 0);
                this.a(arrayList);
                return arrayList;
            }
        }
        object = com.tencent.liteav.basic.c.c.a();
        string2 = "RouteSamplingMaxCount";
        l11 = ((com.tencent.liteav.basic.c.c)object).a(string3, string2);
        n10 = (int)(l11 == l10 ? 0 : (l11 < l10 ? -1 : 1));
        if (n10 >= 0) {
            object = m.a();
            long l12 = ((m)object).a(string4);
            n10 = (int)(l12 == l11 ? 0 : (l12 < l11 ? -1 : 1));
            if (n10 <= 0) {
                arrayList = this.a(arrayList, false);
                object = m.a();
                l12 += l10;
                ((m)object).a(string4, l12);
            }
        }
        this.a(arrayList);
        return arrayList;
    }

    private ArrayList a(ArrayList arrayList, boolean n10) {
        int n11;
        int n12 = 0;
        a a10 = null;
        if (arrayList != null && (n11 = arrayList.size()) != 0) {
            int n13;
            a a11;
            ArrayList<a> arrayList2 = new ArrayList<a>();
            ArrayList<a> arrayList3 = new ArrayList<a>();
            arrayList = arrayList.iterator();
            block0: while (true) {
                a11 = a10;
                while ((n12 = arrayList.hasNext()) != 0) {
                    a10 = (a)arrayList.next();
                    n13 = a10.c;
                    if (n13 != 0) {
                        arrayList2.add(a10);
                        continue;
                    }
                    n13 = a10.d;
                    if (n13 != 0) continue block0;
                    arrayList3.add(a10);
                }
                break;
            }
            arrayList = new ArrayList<a>();
            while (true) {
                Object e10;
                if ((n12 = arrayList2.size()) <= 0 && (n12 = arrayList3.size()) <= 0) {
                    Object object;
                    n10 = arrayList.size();
                    if (n10 > 0 && (object = (a)arrayList.get(n10 += -1)) != null && (n10 = (int)(this.c((String)(object = ((a)object).a)) ? 1 : 0)) == 0 && a11 != null) {
                        arrayList.add(a11);
                    }
                    return arrayList;
                }
                n12 = 0;
                a10 = null;
                if (n10 != 0) {
                    if (a11 != null) {
                        arrayList.add(a11);
                    }
                    if ((n13 = arrayList2.size()) > 0) {
                        e10 = arrayList2.get(0);
                        arrayList.add((a)e10);
                        arrayList2.remove(0);
                    }
                } else {
                    n13 = arrayList2.size();
                    if (n13 > 0) {
                        e10 = arrayList2.get(0);
                        arrayList.add((a)e10);
                        arrayList2.remove(0);
                    }
                    if (a11 != null) {
                        arrayList.add(a11);
                    }
                }
                if ((n13 = arrayList3.size()) <= 0) continue;
                e10 = arrayList3.get(0);
                arrayList.add((a)e10);
                arrayList3.remove(0);
            }
        }
        return null;
    }

    private void a(ArrayList object) {
        boolean bl2;
        if (object != null && (bl2 = ((ArrayList)object).size()) > false) {
            boolean bl3;
            object = ((ArrayList)object).iterator();
            String string2 = "";
            while (bl3 = object.hasNext()) {
                a a10 = (a)object.next();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append(" \n Nearest IP: ");
                string2 = a10.a;
                stringBuilder.append(string2);
                stringBuilder.append(" Port: ");
                string2 = a10.b;
                stringBuilder.append(string2);
                stringBuilder.append(" Q Channel: ");
                bl2 = a10.c;
                stringBuilder.append(bl2);
                string2 = stringBuilder.toString();
            }
            object = "TXCIntelligentRoute";
            TXCLog.e((String)object, string2);
        }
    }

    /*
     * Unable to fully structure code
     */
    private InputStream b(String var1_1, int var2_3, String var3_4) {
        block14: {
            block15: {
                block13: {
                    var4_5 = "2";
                    var5_6 = new URL((String)var3_4);
                    var3_4 = (URLConnection)FirebasePerfUrlConnection.instrument(var5_6.openConnection());
                    var5_6 = null;
                    var3_4 = (HttpURLConnection)var3_4;
                    var6_7 = "GET";
                    var3_4.setRequestMethod(var6_7);
                    var6_7 = "forward_stream";
                    var3_4.setRequestProperty(var6_7, var1_1);
                    var1_1 = "forward_num";
                    var3_4.setRequestProperty(var1_1, var4_5);
                    var1_1 = "sdk_version";
                    var6_7 = TXCCommonUtil.getSDKVersionStr();
                    var3_4.setRequestProperty(var1_1, var6_7);
                    var7_8 = 1;
                    var6_7 = "request_type";
                    if (var2_3 != var7_8) break block13;
                    var1_1 = "1";
                    var3_4.setRequestProperty(var6_7, var1_1);
                    ** GOTO lbl38
                }
                var7_8 = 2;
                if (var2_3 != var7_8) break block15;
                var3_4.setRequestProperty(var6_7, var4_5);
                ** GOTO lbl38
            }
            var1_1 = "3";
            var3_4.setRequestProperty(var6_7, var1_1);
lbl38:
            // 3 sources

            var7_8 = this.b;
            if (var7_8 <= 0) ** GOTO lbl46
            var7_8 *= 1000;
            var3_4.setConnectTimeout(var7_8);
            var7_8 = this.b * 1000;
            var3_4.setReadTimeout(var7_8);
lbl46:
            // 2 sources

            var3_4.connect();
            var7_8 = var3_4.getResponseCode();
            var2_3 = 200;
            if (var7_8 != var2_3) break block14;
            try {
                var5_6 = var3_4.getInputStream();
            }
            catch (Exception var1_2) {
                var8_9 = "TXCIntelligentRoute";
                var3_4 = "http failed.";
                TXCLog.e(var8_9, (String)var3_4, var1_2);
            }
        }
        return var5_6;
    }

    private boolean b(String stringArray) {
        boolean bl2;
        String string2 = ":";
        boolean bl3 = (stringArray = stringArray.split(string2)).length;
        if (bl3 > (bl2 = true)) {
            return bl2;
        }
        return false;
    }

    private boolean c(String stringArray) {
        int n10 = this.b((String)stringArray);
        if (n10 != 0) {
            return false;
        }
        if (stringArray != null) {
            String string2 = "[.]";
            for (String string3 : stringArray.split(string2)) {
                boolean bl2 = this.d(string3);
                if (bl2) continue;
                return true;
            }
        }
        return false;
    }

    private boolean d(String string2) {
        return Pattern.compile("[0-9]*").matcher(string2).matches();
    }

    public void a(String string2, int n10) {
        c$1 c$1 = new c$1(this, "TXCPushRoute", string2, n10);
        this.l = c$1;
        c$1.start();
    }
}

