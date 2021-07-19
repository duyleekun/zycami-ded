/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.tencent.liteav;

import android.content.Context;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.l$1;
import com.tencent.liteav.l$a;
import com.tencent.liteav.l$b;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class l {
    private static volatile l d;
    private Context a;
    private Map b;
    private Map c;

    private l(Context context) {
        HashMap hashMap;
        this.b = hashMap = new HashMap();
        this.c = hashMap = new HashMap();
        this.a = context = context.getApplicationContext();
        this.a();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static l a(Context context) {
        Object object = d;
        if (object != null) return d;
        object = l.class;
        synchronized (object) {
            l l10 = d;
            if (l10 != null) return d;
            d = l10 = new l(context);
            return d;
        }
    }

    private String a(List object) {
        int n10;
        if (object == null) {
            return "";
        }
        JSONArray jSONArray = new JSONArray();
        int n11 = 0;
        String string2 = null;
        object = object.iterator();
        while ((n10 = object.hasNext()) != 0) {
            Object object2 = (l$b)object.next();
            Object object3 = new JSONObject();
            String string3 = ((l$b)object2).b;
            String string4 = "40302";
            boolean bl2 = string4.equals(string3);
            String string5 = "TXCVodPlayReportControl";
            if (bl2) {
                String string6;
                object2 = (l$a)object2;
                string3 = "appid";
                try {
                    string6 = ((l$b)object2).a;
                }
                catch (JSONException jSONException) {
                    object3 = new StringBuilder();
                    string3 = "controlDataListToString jsonObject.put\uff1a";
                    ((StringBuilder)object3).append(string3);
                    object2 = jSONException.toString();
                    ((StringBuilder)object3).append((String)object2);
                    object2 = ((StringBuilder)object3).toString();
                    TXCLog.e(string5, (String)object2);
                    continue;
                }
                object3.put(string3, (Object)string6);
                string3 = "eventid";
                string6 = ((l$b)object2).b;
                object3.put(string3, (Object)string6);
                object2 = ((l$a)object2).toString();
                object3.put(string4, object2);
            }
            n10 = n11 + 1;
            try {
                jSONArray.put(n11, object3);
            }
            catch (JSONException jSONException) {
                object3 = new StringBuilder();
                string3 = "jsonArray.put\uff1a ";
                ((StringBuilder)object3).append(string3);
                string2 = jSONException.toString();
                ((StringBuilder)object3).append(string2);
                string2 = ((StringBuilder)object3).toString();
                TXCLog.e(string5, string2);
            }
            n11 = n10;
        }
        return jSONArray.toString();
    }

    private void a() {
        block15: {
            Object object = this.a;
            CharSequence charSequence = "vod_report_config";
            if ((object = object.getSharedPreferences((String)charSequence, 0)) != null) {
                int n10;
                charSequence = "value";
                String string2 = "";
                boolean bl2 = ((String)(object = object.getString((String)charSequence, string2))).isEmpty();
                if (bl2) {
                    return;
                }
                try {
                    charSequence = new JSONArray((String)object);
                    n10 = 0;
                    object = null;
                }
                catch (JSONException jSONException) {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append(string2);
                    String string3 = jSONException.toString();
                    ((StringBuilder)charSequence).append(string3);
                    string3 = ((StringBuilder)charSequence).toString();
                    charSequence = "TXCVodPlayReportControl";
                    TXCLog.e((String)charSequence, string3);
                }
                while (true) {
                    block16: {
                        int n11 = charSequence.length();
                        if (n10 >= n11) break block15;
                        Object object2 = charSequence.optString(n10);
                        object2 = this.h((String)object2);
                        if (object2 == null) break block16;
                        int n12 = object2.size();
                        if (n12 <= 0) break block16;
                        Object object3 = object2.get(0);
                        object3 = (l$b)object3;
                        object3 = ((l$b)object3).a;
                        Map map = this.b;
                        map.put(object3, object2);
                    }
                    ++n10;
                }
            }
        }
    }

    public static /* synthetic */ void a(l l10) {
        l10.b();
    }

    public static /* synthetic */ void a(l l10, String string2) {
        l10.e(string2);
    }

    private void a(String string2, long l10) {
        Object object = this.c;
        Long l11 = l10;
        object.put(string2, l11);
        object = new StringBuilder();
        ((StringBuilder)object).append("SetReportExpireTime in mem appid= ");
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(" , time=");
        ((StringBuilder)object).append(l10);
        string2 = ((StringBuilder)object).toString();
        TXCLog.i("TXCVodPlayReportControl", string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(JSONObject object) {
        Object object2 = object.optJSONArray("controlInfos");
        Object object3 = "appId";
        int n10 = object.optInt((String)object3);
        if (n10 == 0) {
            TXCLog.i("TXCVodPlayReportControl", "response appid is zero!");
            return;
        }
        if (object2 == null) return;
        int n11 = object2.length();
        if (n11 == 0) return;
        object3 = new Object();
        int n12 = 0;
        CharSequence charSequence = null;
        while (true) {
            CharSequence charSequence2;
            String string2;
            Object object4;
            Object object5;
            int n13;
            if (n12 >= (n13 = object2.length())) {
                synchronized (this) {
                    int n14 = object3.size();
                    if (n14 == 0) return;
                    object2 = this.b;
                    charSequence = new StringBuilder();
                    object5 = "";
                    charSequence.append((String)object5);
                    charSequence.append(n10);
                    charSequence = charSequence.toString();
                    object2.put(charSequence, object3);
                    object2 = this.c;
                    object = n10;
                    object2.remove(object);
                    return;
                }
            }
            object5 = object2.optJSONObject(n12);
            if (object5 != null && (object4 = (string2 = "40302").equals(charSequence2 = object5.optString("eventId"))) != 0) {
                charSequence2 = "expireTime";
                long l10 = 0L;
                long l11 = object5.optLong((String)charSequence2, l10);
                long l12 = System.currentTimeMillis();
                long l13 = 1000L;
                long l14 = l11 - (l12 /= l13);
                object4 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                if (object4 > 0) {
                    charSequence2 = object5.optString("switch");
                    string2 = "frequency";
                    int n15 = 60;
                    n13 = object5.optInt(string2, n15);
                    int n16 = n13 < n15 ? n15 : n13;
                    boolean bl2 = "on".equalsIgnoreCase((String)charSequence2);
                    charSequence2 = new StringBuilder();
                    string2 = "";
                    ((StringBuilder)charSequence2).append(string2);
                    ((StringBuilder)charSequence2).append(n10);
                    String string3 = ((StringBuilder)charSequence2).toString();
                    object5 = new l$a(n16, bl2, l11, string3);
                    object3.add(object5);
                }
            }
            ++n12;
        }
    }

    private void b() {
        int n10;
        Context context = this.a;
        Object object = "vod_report_config";
        int n11 = 0;
        String string2 = null;
        if ((context = context.getSharedPreferences((String)object, 0)) != null && (context = context.edit()) != null && (n10 = (object = this.b).size()) > 0) {
            boolean bl2;
            object = new JSONArray();
            Iterator iterator2 = this.b.entrySet().iterator();
            while (bl2 = iterator2.hasNext()) {
                Object object2 = iterator2.next();
                int n12 = n11 + 1;
                object2 = object2.getValue();
                object2 = (List)object2;
                object2 = this.a((List)object2);
                try {
                    object.put(n11, object2);
                }
                catch (JSONException jSONException) {
                    object2 = new StringBuilder();
                    String string3 = "";
                    ((StringBuilder)object2).append(string3);
                    string2 = jSONException.toString();
                    ((StringBuilder)object2).append(string2);
                    string2 = ((StringBuilder)object2).toString();
                    object2 = "TXCVodPlayReportControl";
                    TXCLog.e((String)object2, string2);
                }
                n11 = n12;
            }
            object = object.toString();
            string2 = "value";
            context.putString(string2, (String)object);
            context.apply();
        }
    }

    private long d(String string2) {
        boolean bl2;
        if (string2 != null && !(bl2 = string2.isEmpty())) {
            Object object = this.c;
            bl2 = object.containsKey(string2);
            if (bl2) {
                return (Long)this.c.get(string2);
            }
            object = (List)this.b.get(string2);
            if (object != null) {
                boolean bl3;
                object = object.iterator();
                while (bl3 = object.hasNext()) {
                    l$b l$b = (l$b)object.next();
                    String string3 = "40302";
                    String string4 = l$b.b;
                    boolean bl4 = string3.equals(string4);
                    if (!bl4 || !(bl4 = string2.equalsIgnoreCase(string4 = l$b.a))) continue;
                    return l$a.a((l$a)l$b);
                }
            }
            return 0L;
        }
        return System.currentTimeMillis() / 1000L + 3600L;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void e(String object) {
        Object object2;
        Object object3;
        Object object4;
        String string2;
        String string3;
        block21: {
            String string4;
            block22: {
                Object object5;
                block20: {
                    block19: {
                        string3 = "bufferedReader.close :";
                        string2 = "TXCVodPlayReportControl";
                        object4 = null;
                        try {
                            object = this.g((String)object);
                            object3 = new URL((String)object);
                        }
                        catch (MalformedURLException malformedURLException) {
                            object3 = new StringBuilder();
                            object2 = "URL :";
                            ((StringBuilder)object3).append((String)object2);
                            object = malformedURLException.toString();
                            ((StringBuilder)object3).append((String)object);
                            object = ((StringBuilder)object3).toString();
                            TXCLog.i(string2, (String)object);
                            return;
                        }
                        if (object3 == null) {
                            return;
                        }
                        try {
                            object = ((URL)object3).openConnection();
                            object = FirebasePerfUrlConnection.instrument(object);
                            object = (URLConnection)object;
                            object = (HttpURLConnection)object;
                        }
                        catch (IOException iOException) {
                            object3 = new StringBuilder();
                            object2 = "openConnection :";
                            ((StringBuilder)object3).append((String)object2);
                            object = iOException.toString();
                            ((StringBuilder)object3).append((String)object);
                            object = ((StringBuilder)object3).toString();
                            TXCLog.i(string2, (String)object);
                            object = null;
                        }
                        if (object == null) return;
                        int n10 = 8000;
                        ((URLConnection)object).setConnectTimeout(n10);
                        ((URLConnection)object).setReadTimeout(n10);
                        object3 = "Accept-Encoding";
                        object2 = "identity";
                        ((URLConnection)object).setRequestProperty((String)object3, (String)object2);
                        n10 = 1;
                        ((HttpURLConnection)object).setInstanceFollowRedirects(n10 != 0);
                        ((URLConnection)object).connect();
                        n10 = ((HttpURLConnection)object).getResponseCode();
                        object2 = new StringBuilder();
                        object5 = "request report control response code : ";
                        ((StringBuilder)object2).append((String)object5);
                        ((StringBuilder)object2).append(n10);
                        object2 = ((StringBuilder)object2).toString();
                        TXCLog.i(string2, (String)object2);
                        int n11 = 200;
                        if (n11 != n10) break block19;
                        object3 = ((URLConnection)object).getInputStream();
                        object5 = new InputStreamReader((InputStream)object3);
                        object2 = new BufferedReader((Reader)object5);
                        try {
                            object4 = new StringBuilder();
                            while ((object3 = ((BufferedReader)object2).readLine()) != null) {
                                ((StringBuilder)object4).append((String)object3);
                            }
                            object4 = ((StringBuilder)object4).toString();
                            this.f((String)object4);
                            object4 = object2;
                        }
                        catch (IOException iOException) {
                            break block20;
                        }
                    }
                    ((HttpURLConnection)object).disconnect();
                    if (object4 == null) return;
                    try {
                        ((BufferedReader)object4).close();
                        return;
                    }
                    catch (IOException iOException) {
                        object4 = new StringBuilder();
                    }
                    break block22;
                    catch (Throwable throwable) {
                        boolean bl2 = false;
                        object2 = null;
                        object4 = throwable;
                        break block21;
                    }
                    catch (IOException iOException) {
                        boolean bl3 = false;
                        object2 = null;
                        object4 = iOException;
                    }
                }
                object3 = new StringBuilder();
                object5 = "connect or read: ";
                ((StringBuilder)object3).append((String)object5);
                object4 = ((Throwable)object4).toString();
                ((StringBuilder)object3).append((String)object4);
                object4 = ((StringBuilder)object3).toString();
                TXCLog.i(string2, (String)object4);
                ((HttpURLConnection)object).disconnect();
                if (object2 == null) return;
                try {
                    ((BufferedReader)object2).close();
                    return;
                }
                catch (IOException iOException) {
                    object4 = new StringBuilder();
                }
            }
            ((StringBuilder)object4).append(string3);
            string4 = ((Throwable)((Object)string4)).toString();
            ((StringBuilder)object4).append(string4);
            string4 = ((StringBuilder)object4).toString();
            TXCLog.i(string2, string4);
            return;
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        ((HttpURLConnection)object).disconnect();
        if (object2 == null) throw object4;
        try {
            ((BufferedReader)object2).close();
            throw object4;
        }
        catch (IOException iOException) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append(string3);
            String string5 = iOException.toString();
            ((StringBuilder)object3).append(string5);
            string5 = ((StringBuilder)object3).toString();
            TXCLog.i(string2, string5);
        }
        throw object4;
    }

    private void f(String string2) {
        boolean bl2;
        String string3 = "TXCVodPlayReportControl";
        if (string2 != null && !(bl2 = string2.isEmpty())) {
            block18: {
                Object object = new JSONObject(string2);
                string2 = "code";
                int n10 = object.getInt(string2);
                String string4 = "message";
                string4 = object.optString(string4);
                String string5 = "requestId";
                string5 = object.optString(string5);
                StringBuilder stringBuilder = new StringBuilder();
                String string6 = "code = ";
                stringBuilder.append(string6);
                stringBuilder.append(n10);
                string6 = " ,message = ";
                stringBuilder.append(string6);
                stringBuilder.append(string4);
                string4 = " , requestID= ";
                stringBuilder.append(string4);
                stringBuilder.append(string5);
                string4 = stringBuilder.toString();
                TXCLog.i(string3, string4);
                if (n10 != 0) break block18;
                string2 = "version";
                n10 = object.getInt(string2);
                int n11 = 1;
                if (n10 != n11) break block18;
                try {
                    this.a((JSONObject)object);
                }
                catch (JSONException jSONException) {
                    object = new StringBuilder();
                    string4 = "parseJson err: ";
                    ((StringBuilder)object).append(string4);
                    String string7 = jSONException.toString();
                    ((StringBuilder)object).append(string7);
                    string7 = ((StringBuilder)object).toString();
                    TXCLog.e(string3, string7);
                }
            }
            return;
        }
        TXCLog.i(string3, "response msg is empty");
    }

    private String g(String string2) {
        CharSequence charSequence = TXCCommonUtil.getSDKVersionStr();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://vodreport.qcloud.com/describeControlInfos/v1/");
        stringBuilder.append(string2);
        stringBuilder.append("?sdkVersion=");
        stringBuilder.append((String)charSequence);
        string2 = stringBuilder.toString();
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("makeUrl: ");
        ((StringBuilder)charSequence).append(string2);
        charSequence = ((StringBuilder)charSequence).toString();
        TXCLog.i("TXCVodPlayReportControl", (String)charSequence);
        return string2;
    }

    private List h(String string2) {
        ArrayList<Object> arrayList;
        block14: {
            int n10;
            JSONArray jSONArray;
            CharSequence charSequence = "40302";
            String string3 = "";
            arrayList = new ArrayList<Object>();
            try {
                jSONArray = new JSONArray(string2);
                n10 = 0;
                string2 = null;
            }
            catch (JSONException jSONException) {
                charSequence = new StringBuilder();
                string3 = "controlDataListParseFormString :";
                ((StringBuilder)charSequence).append(string3);
                String string4 = jSONException.toString();
                ((StringBuilder)charSequence).append(string4);
                string4 = ((StringBuilder)charSequence).toString();
                charSequence = "TXCVodPlayReportControl";
                TXCLog.e((String)charSequence, string4);
            }
            while (true) {
                block15: {
                    int n11 = jSONArray.length();
                    if (n10 >= n11) break block14;
                    Object object = jSONArray.optJSONObject(n10);
                    if (object == null) break block15;
                    Object object2 = "appid";
                    object.optString((String)object2, string3);
                    object2 = "eventid";
                    object2 = object.optString((String)object2, string3);
                    boolean bl2 = ((String)object2).equalsIgnoreCase((String)charSequence);
                    if (!bl2) break block15;
                    object = object.optString((String)charSequence, string3);
                    bl2 = ((String)object).isEmpty();
                    if (bl2) break block15;
                    object2 = new l$a((String)object);
                    arrayList.add(object2);
                }
                ++n10;
            }
        }
        return arrayList;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public int a(String string2) {
        int n10 = 60;
        if (string2 == null) return n10;
        boolean bl2 = string2.isEmpty();
        if (bl2) {
            return n10;
        }
        // MONITORENTER : this
        Iterator iterator2 = this.b;
        iterator2 = iterator2.get(string2);
        iterator2 = (List)((Object)iterator2);
        if (iterator2 != null) {
            boolean bl3;
            iterator2 = iterator2.iterator();
            while (bl3 = iterator2.hasNext()) {
                Object object = iterator2.next();
                object = (l$b)object;
                String string3 = "40302";
                String string4 = ((l$b)object).b;
                Object object2 = string3.equals(string4);
                if (object2 == 0 || (object2 = string2.equalsIgnoreCase(string3 = ((l$b)object).a)) == 0 || (object = (l$a)object) == null) continue;
                long l10 = l$a.a(object);
                long l11 = System.currentTimeMillis();
                long l12 = 1000L;
                long l13 = l10 - (l11 /= l12);
                object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                if (object2 <= 0) continue;
                int n11 = l$a.b(object);
                // MONITOREXIT : this
                return n11;
            }
        }
        // MONITOREXIT : this
        return n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public boolean b(String string2) {
        if (string2 == null) return false;
        boolean bl2 = string2.isEmpty();
        if (bl2) {
            return false;
        }
        // MONITORENTER : this
        Iterator iterator2 = this.b;
        iterator2 = iterator2.get(string2);
        iterator2 = (List)((Object)iterator2);
        if (iterator2 != null) {
            boolean bl3;
            iterator2 = iterator2.iterator();
            while (bl3 = iterator2.hasNext()) {
                Object object = iterator2.next();
                object = (l$b)object;
                String string3 = "40302";
                String string4 = ((l$b)object).b;
                Object object2 = string3.equals(string4);
                if (object2 == 0 || (object2 = string2.equalsIgnoreCase(string3 = ((l$b)object).a)) == 0 || (object = (l$a)object) == null) continue;
                long l10 = l$a.a(object);
                long l11 = System.currentTimeMillis();
                long l12 = 1000L;
                long l13 = l10 - (l11 /= l12);
                object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                if (object2 <= 0) continue;
                boolean bl4 = l$a.c(object);
                // MONITOREXIT : this
                return bl4;
            }
        }
        // MONITOREXIT : this
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c(String string2) {
        if (string2 == null) return;
        int n10 = string2.isEmpty();
        if (n10 != 0) {
            return;
        }
        synchronized (this) {
            long l10 = this.d(string2);
            long l11 = System.currentTimeMillis();
            long l12 = 1000L;
            long l13 = l10 - (l11 /= l12);
            n10 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (n10 >= 0) return;
            Object object = "TXCVodPlayReportControl";
            Object object2 = "RequestReportControl";
            TXCLog.i((String)object, (String)object2);
            l10 = System.currentTimeMillis();
            l10 /= l12;
            l11 = 3600L;
            this.a(string2, l10 += l11);
            object2 = new l$1(this, string2);
            string2 = "report_control";
            object = new Thread((Runnable)object2, string2);
            ((Thread)object).start();
            return;
        }
    }
}

