/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.Uri
 *  android.net.wifi.WifiManager
 *  android.os.Process
 *  android.text.TextUtils
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.xiaomi.push;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Process;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.aw;
import com.xiaomi.push.ay;
import com.xiaomi.push.az;
import com.xiaomi.push.bf;
import com.xiaomi.push.cv;
import com.xiaomi.push.cw;
import com.xiaomi.push.cy;
import com.xiaomi.push.cz$a;
import com.xiaomi.push.cz$b;
import com.xiaomi.push.db;
import com.xiaomi.push.service.a;
import com.xiaomi.push.service.module.PushChannelRegion;
import com.xiaomi.push.y;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class cz {
    public static Context a;
    private static cz$a a;
    private static cz a;
    public static boolean a;
    public static Map b;
    private static String c;
    private static String d;
    private long a;
    private cy a;
    public cz$b a;
    private String a;
    public Map a;
    private final long b;
    private String b;
    private long c;

    static {
        HashMap hashMap;
        b = hashMap = new HashMap();
        a = false;
    }

    public cz(Context context, cy cy2, cz$b cz$b, String string2) {
        this(context, cy2, cz$b, string2, null, null);
    }

    public cz(Context context, cy cy2, cz$b cz$b, String string2, String string3, String string4) {
        long l10;
        long l11;
        Object object = new HashMap();
        this.a = object;
        this.a = "0";
        this.a = l11 = 0L;
        this.b = l10 = (long)15;
        this.c = l11;
        this.b = object = "isp_prov_city_country_ip";
        this.a = cz$b;
        if (cy2 == null) {
            super(this);
        }
        this.a = cy2;
        this.a = string2;
        if (string3 == null) {
            string3 = context.getPackageName();
        }
        c = string3;
        if (string4 == null) {
            string4 = this.f();
        }
        d = string4;
    }

    public static cz a() {
        Class<cz> clazz = cz.class;
        synchronized (clazz) {
            Object object;
            block5: {
                object = a;
                if (object == null) break block5;
                return object;
            }
            String string2 = "the host manager is not initialized yet.";
            object = new IllegalStateException(string2);
            throw object;
        }
    }

    public static String a() {
        String string2;
        block22: {
            CharSequence charSequence;
            Object object;
            block21: {
                block20: {
                    block19: {
                        object = a;
                        string2 = "unknown";
                        if (object == null) {
                            return string2;
                        }
                        charSequence = "connectivity";
                        try {
                            object = object.getSystemService((String)charSequence);
                        }
                        catch (Throwable throwable) {}
                        object = (ConnectivityManager)object;
                        if (object != null) break block19;
                        return string2;
                    }
                    object = object.getActiveNetworkInfo();
                    if (object != null) break block20;
                    return string2;
                }
                int n10 = object.getType();
                int n11 = 1;
                if (n10 != n11) break block21;
                object = a;
                charSequence = "wifi";
                object = object.getSystemService((String)charSequence);
                object = (WifiManager)object;
                if (object == null) break block22;
                charSequence = object.getConnectionInfo();
                if (charSequence == null) break block22;
                charSequence = new StringBuilder();
                String string3 = "WIFI-";
                ((StringBuilder)charSequence).append(string3);
                object = object.getConnectionInfo();
                object = object.getSSID();
                ((StringBuilder)charSequence).append((String)object);
                return ((StringBuilder)charSequence).toString();
            }
            charSequence = new StringBuilder();
            String string4 = object.getTypeName();
            ((StringBuilder)charSequence).append(string4);
            string4 = "-";
            ((StringBuilder)charSequence).append(string4);
            object = object.getSubtypeName();
            ((StringBuilder)charSequence).append((String)object);
            return ((StringBuilder)charSequence).toString();
        }
        return string2;
    }

    public static String a(String string2) {
        int n10 = string2.length();
        Object object = "UTF-8";
        object = string2.getBytes((String)object);
        int n11 = 0;
        while (true) {
            block9: {
                Object object2 = ((Object)object).length;
                if (n11 >= object2) break;
                object2 = object[n11];
                int n12 = object2 & 0xF0;
                int n13 = 240;
                if (n12 == n13) break block9;
                n13 = (byte)((object2 >> 4) + n10 & 0xF);
                object2 = (byte)(object2 & 0xF ^ n13 | n12);
                object[n11] = object2;
            }
            ++n11;
        }
        try {
            String string3 = new String((byte[])object);
            return string3;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return string2;
        }
    }

    /*
     * Exception decompiling
     */
    private ArrayList a(ArrayList var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 104[TRYBLOCK] [114 : 1337->1340)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public static void a(Context object, cy cy2, cz$b cz$b, String string2, String string3, String string4) {
        Class<cz> clazz = cz.class;
        synchronized (clazz) {
            Object object2;
            a = object2 = object.getApplicationContext();
            if (object2 == null) {
                a = object;
            }
            if ((object2 = a) == null) {
                object2 = a;
                if (object2 == null) {
                    object2 = new cz((Context)object, cy2, cz$b, string2, string3, string4);
                    a = object2;
                } else {
                    object = object2.a((Context)object, cy2, cz$b, string2);
                    a = object;
                }
            }
            return;
        }
    }

    public static void a(cz$a cz$a) {
        Class<cz> clazz = cz.class;
        synchronized (clazz) {
            a = cz$a;
            cz$a = null;
            a = null;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(String string2, String object) {
        cv cv2 = (cv)b.get(string2);
        Map map = b;
        synchronized (map) {
            if (cv2 == null) {
                cv2 = new cv(string2);
                long l10 = 604800000L;
                cv2.a(l10);
                cv2.a((String)object);
                object = b;
                object.put(string2, cv2);
            } else {
                cv2.a((String)object);
            }
            return;
        }
    }

    private String f() {
        block7: {
            Context context;
            try {
                context = a;
            }
            catch (Exception exception) {}
            context = context.getPackageManager();
            Object object = a;
            object = object.getPackageName();
            int n10 = 16384;
            context = context.getPackageInfo((String)object, n10);
            if (context == null) break block7;
            return context.versionName;
        }
        return "0";
    }

    public cv a(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            URL uRL = new URL((String)object);
            object = uRL.getHost();
            return this.a((String)object, true);
        }
        object = new IllegalArgumentException("the url is empty");
        throw object;
    }

    public cv a(String object, boolean bl2) {
        boolean bl3 = TextUtils.isEmpty((CharSequence)object);
        if (!bl3) {
            Object object2;
            boolean bl4;
            Object object3 = this.a;
            bl3 = object3.a((String)object);
            if (!bl3) {
                return null;
            }
            object3 = this.c((String)object);
            if (object3 != null && (bl4 = ((cv)object3).b())) {
                return object3;
            }
            if (bl2 && (bl2 = az.b(object2 = a)) && (object2 = this.d((String)object)) != null) {
                return object2;
            }
            object2 = new db(this, (String)object, (cv)object3);
            return object2;
        }
        object = new IllegalArgumentException("the host is empty");
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String a(ArrayList iterator2, String object, String object2, boolean bl2) {
        Object object3;
        Object object4 = new ArrayList();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        String string2 = "type";
        Object object5 = new aw(string2, (String)object);
        arrayList.add(object5);
        object5 = "wap";
        boolean bl3 = ((String)object).equals(object5);
        if (bl3) {
            object5 = "conpt";
            string2 = cz.a(az.a(a));
            object = new aw((String)object5, string2);
            arrayList.add(object);
        }
        if (bl2) {
            object3 = "reserved";
            object5 = "1";
            object = new aw((String)object3, (String)object5);
            arrayList.add(object);
        }
        object = new aw("uuid", (String)object2);
        arrayList.add(object);
        object3 = ",";
        iterator2 = bf.a((Collection)((Object)iterator2), (String)object3);
        object = new aw("list", (String)((Object)iterator2));
        arrayList.add(object);
        object2 = com.xiaomi.push.service.a.a(a).b();
        iterator2 = new Iterator("countrycode", (String)object2);
        arrayList.add(iterator2);
        iterator2 = this.b();
        iterator2 = this.c((String)((Object)iterator2));
        object = Locale.US;
        object2 = "http://%1$s/gslb/?ver=4.0";
        bl2 = true;
        object5 = new Object[bl2];
        string2 = this.b();
        object5[0] = string2;
        object = String.format((Locale)object, (String)object2, object5);
        if (iterator2 == null) {
            ((ArrayList)object4).add(object);
            object2 = b;
            synchronized (object2) {
                iterator2 = b;
                object = "resolver.msg.xiaomi.net";
                iterator2 = iterator2.get(object);
                iterator2 = (cv)((Object)iterator2);
                if (iterator2 != null) {
                    iterator2 = ((cv)((Object)iterator2)).a(bl2);
                    iterator2 = ((ArrayList)((Object)iterator2)).iterator();
                    while (bl3 = iterator2.hasNext()) {
                        object = iterator2.next();
                        object = (String)object;
                        object5 = Locale.US;
                        string2 = "http://%1$s/gslb/?ver=4.0";
                        Object[] objectArray = new Object[bl2];
                        objectArray[0] = object;
                        object = String.format((Locale)object5, string2, objectArray);
                        ((ArrayList)object4).add(object);
                    }
                }
            }
        } else {
            object4 = ((cv)((Object)iterator2)).a((String)object);
        }
        iterator2 = ((ArrayList)object4).iterator();
        bl3 = false;
        object = null;
        object2 = null;
        while (bl2 = iterator2.hasNext()) {
            boolean bl4;
            object2 = Uri.parse((String)((String)iterator2.next())).buildUpon();
            object3 = arrayList.iterator();
            while (bl4 = object3.hasNext()) {
                object4 = (ay)object3.next();
                object5 = object4.a();
                object4 = object4.b();
                object2.appendQueryParameter((String)object5, (String)object4);
            }
            try {
                object3 = this.a;
                if (object3 == null) {
                    object3 = a;
                    object2 = object2.toString();
                    object4 = new URL((String)object2);
                    return az.a((Context)object3, (URL)object4);
                }
                object2 = object2.toString();
                return object3.a((String)object2);
            }
            catch (IOException iOException) {
            }
        }
        if (object2 == null) {
            return null;
        }
        iterator2 = new Iterator();
        ((StringBuilder)((Object)iterator2)).append("network exception: ");
        object = ((Throwable)object2).getMessage();
        ((StringBuilder)((Object)iterator2)).append((String)object);
        com.xiaomi.channel.commonutils.logger.b.a(((StringBuilder)((Object)iterator2)).toString());
        throw object2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public JSONObject a() {
        Map map = this.a;
        synchronized (map) {
            Object object;
            boolean bl2;
            JSONObject jSONObject = new JSONObject();
            String string2 = "ver";
            int n10 = 2;
            jSONObject.put(string2, n10);
            string2 = new JSONArray();
            Object object2 = this.a;
            object2 = object2.values();
            object2 = object2.iterator();
            while (bl2 = object2.hasNext()) {
                object = object2.next();
                object = (cw)object;
                object = ((cw)object).a();
                string2.put(object);
            }
            object2 = "data";
            jSONObject.put((String)object2, (Object)string2);
            string2 = new JSONArray();
            object2 = b;
            object2 = object2.values();
            object2 = object2.iterator();
            while (true) {
                if (!(bl2 = object2.hasNext())) {
                    object2 = "reserved";
                    jSONObject.put((String)object2, (Object)string2);
                    return jSONObject;
                }
                object = object2.next();
                object = (cv)object;
                object = ((cv)object).a();
                string2.put(object);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        Map map = this.a;
        synchronized (map) {
            Map map2 = this.a;
            map2.clear();
            return;
        }
    }

    public void a(String string2) {
        this.b = string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(String object, cv object2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2 && object2 != null) {
            Object object3 = this.a;
            bl2 = object3.a((String)object);
            if (bl2) {
                object3 = this.a;
                synchronized (object3) {
                    this.a();
                    Object object4 = this.a;
                    boolean bl3 = object4.containsKey(object);
                    if (bl3) {
                        object4 = this.a;
                        object = object4.get(object);
                        object = (cw)object;
                        ((cw)object).a((cv)object2);
                    } else {
                        object4 = new cw((String)object);
                        ((cw)object4).a((cv)object2);
                        object2 = this.a;
                        object2.put(object, object4);
                    }
                }
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("the argument is invalid ");
        stringBuilder.append((String)object);
        stringBuilder.append(", ");
        stringBuilder.append(object2);
        object = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean a() {
        Map map = this.a;
        synchronized (map) {
            boolean bl2 = a;
            boolean bl3 = true;
            if (bl2) {
                return bl3;
            }
            a = bl3;
            Object object = this.a;
            object.clear();
            try {
                object = this.d();
                boolean bl4 = TextUtils.isEmpty((CharSequence)object);
                if (!bl4) {
                    this.b((String)object);
                    object = "loading the new hosts succeed";
                    com.xiaomi.channel.commonutils.logger.b.b((String)object);
                    return bl3;
                }
            }
            catch (Throwable throwable) {
                StringBuilder stringBuilder = new StringBuilder();
                String string2 = "load bucket failure: ";
                stringBuilder.append(string2);
                String string3 = throwable.getMessage();
                stringBuilder.append(string3);
                string3 = stringBuilder.toString();
                com.xiaomi.channel.commonutils.logger.b.a(string3);
            }
            return false;
        }
    }

    public cv b(String string2) {
        return this.a(string2, true);
    }

    public String b() {
        String string2;
        boolean bl2;
        String string3 = com.xiaomi.push.service.a.a(a).a();
        boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
        String string4 = "resolver.msg.xiaomi.net";
        if (!bl3 && !(bl2 = (string2 = PushChannelRegion.China.name()).equals(string3))) {
            string4 = "resolver.msg.global.xiaomi.net";
        }
        return string4;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        Object object;
        Object object2;
        int n10;
        ArrayList arrayList;
        Object object3;
        Object object4 = this.a;
        synchronized (object4) {
            this.a();
            object3 = this.a;
            object3 = object3.keySet();
            arrayList = new ArrayList(object3);
            for (n10 = arrayList.size() + -1; n10 >= 0; n10 += -1) {
                object2 = this.a;
                object = arrayList.get(n10);
                object2 = object2.get(object);
                if ((object2 = (cw)object2) == null || (object2 = ((cw)object2).a()) == null) continue;
                arrayList.remove(n10);
            }
        }
        object4 = this.a(arrayList);
        n10 = 0;
        object3 = null;
        int n11;
        while (n10 < (n11 = arrayList.size())) {
            object2 = ((ArrayList)object4).get(n10);
            if (object2 != null) {
                object2 = (String)arrayList.get(n10);
                object = (cv)((ArrayList)object4).get(n10);
                this.a((String)object2, (cv)object);
            }
            ++n10;
        }
        return;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(String object) {
        Map map = this.a;
        synchronized (map) {
            int n10;
            Object object2;
            Object object3;
            Object object4 = this.a;
            object4.clear();
            object4 = new JSONObject(object);
            object = "ver";
            int n11 = object4.optInt(object);
            int n12 = 2;
            if (n11 != n12) {
                object4 = "Bad version";
                object = new JSONException((String)object4);
                throw object;
            }
            object = "data";
            object = object4.optJSONArray(object);
            n12 = 0;
            Object object5 = null;
            for (int n13 = 0; n13 < (n10 = object.length()); object3 = ((cw)object3).a((JSONObject)object2), ++n13) {
                object3 = new cw();
                object2 = object.getJSONObject(n13);
                object2 = this.a;
                String string2 = ((cw)object3).a();
                object2.put(string2, object3);
            }
            object = "reserved";
            object = object4.optJSONArray(object);
            int n14;
            while (n12 < (n14 = object.length())) {
                object5 = "";
                object4 = new cv((String)object5);
                object5 = object.getJSONObject(n12);
                object4 = ((cv)object4).a((JSONObject)object5);
                object5 = b;
                object3 = ((cv)object4).b;
                object5.put(object3, object4);
                ++n12;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public cv c(String object) {
        Map map = this.a;
        // MONITORENTER : map
        this.a();
        Map map2 = this.a;
        object = map2.get(object);
        object = (cw)object;
        // MONITOREXIT : map
        if (object == null) return null;
        if ((object = ((cw)object).a()) == null) return null;
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String c() {
        StringBuilder stringBuilder = new StringBuilder();
        Map map = this.a;
        synchronized (map) {
            Iterator iterator2 = this.a;
            iterator2 = iterator2.entrySet();
            iterator2 = iterator2.iterator();
            boolean bl2;
            while (bl2 = iterator2.hasNext()) {
                Object object = iterator2.next();
                object = (Map.Entry)object;
                Object object2 = object.getKey();
                object2 = (String)object2;
                stringBuilder.append((String)object2);
                object2 = ":\n";
                stringBuilder.append((String)object2);
                object = object.getValue();
                object = (cw)object;
                object = ((cw)object).toString();
                stringBuilder.append((String)object);
                object = "\n";
                stringBuilder.append((String)object);
            }
            return stringBuilder.toString();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c() {
        Map map = this.a;
        synchronized (map) {
            Throwable throwable2;
            block6: {
                try {
                    try {
                        Object object = a;
                        Object object2 = this.e();
                        boolean bl2 = false;
                        OutputStreamWriter outputStreamWriter = null;
                        object = object.openFileOutput((String)object2, 0);
                        outputStreamWriter = new OutputStreamWriter((OutputStream)object);
                        object2 = new BufferedWriter(outputStreamWriter);
                        object = this.a();
                        object = object.toString();
                        bl2 = TextUtils.isEmpty((CharSequence)object);
                        if (!bl2) {
                            ((Writer)object2).write((String)object);
                        }
                        ((BufferedWriter)object2).close();
                    }
                    catch (Exception exception) {
                        StringBuilder stringBuilder = new StringBuilder();
                        String string2 = "persist bucket failure: ";
                        stringBuilder.append(string2);
                        String string3 = exception.getMessage();
                        stringBuilder.append(string3);
                        string3 = stringBuilder.toString();
                        com.xiaomi.channel.commonutils.logger.b.a(string3);
                    }
                }
                catch (Throwable throwable2) {
                    break block6;
                }
                return;
            }
            throw throwable2;
        }
    }

    public cv d(String object) {
        long l10 = System.currentTimeMillis();
        long l11 = this.c;
        l10 -= l11;
        l11 = this.a * (long)60;
        long l12 = 1000L;
        long l13 = l10 - (l11 *= l12);
        Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object2 > 0) {
            this.c = l10 = System.currentTimeMillis();
            ArrayList<String> arrayList = new ArrayList<String>();
            arrayList.add((String)object);
            object = this.a(arrayList);
            object2 = 0;
            arrayList = null;
            object = (cv)((ArrayList)object).get(0);
            if (object != null) {
                this.a = 0L;
                return object;
            }
            l10 = this.a;
            l11 = 15;
            long l14 = l10 - l11;
            Object object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object3 < 0) {
                l11 = 1L;
                this.a = l10 += l11;
            }
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String d() {
        Object object;
        Object object2;
        Object object3;
        block9: {
            block8: {
                Comparable<File> comparable;
                String string2 = null;
                try {
                    object3 = a;
                    object3 = object3.getFilesDir();
                    object2 = this.e();
                    comparable = new Comparable<File>((File)object3, (String)object2);
                    boolean bl2 = ((File)comparable).isFile();
                    if (!bl2) break block8;
                    object = new FileInputStream((File)comparable);
                    object2 = new InputStreamReader((InputStream)object);
                    object3 = new BufferedReader((Reader)object2);
                }
                catch (Throwable throwable) {
                    boolean bl3 = false;
                    object3 = null;
                    break block9;
                }
                try {
                    comparable = new Comparable<File>();
                    while ((object2 = ((BufferedReader)object3).readLine()) != null) {
                        ((StringBuilder)comparable).append((String)object2);
                    }
                    string2 = ((StringBuilder)comparable).toString();
                }
                catch (Throwable throwable) {
                    break block9;
                }
                y.a((Closeable)object3);
                return string2;
            }
            y.a(null);
            return null;
        }
        try {
            String string3;
            object2 = new StringBuilder();
            object = "load host exception ";
            ((StringBuilder)object2).append((String)object);
            string3 = ((Throwable)((Object)string3)).getMessage();
            ((StringBuilder)object2).append(string3);
            string3 = ((StringBuilder)object2).toString();
            com.xiaomi.channel.commonutils.logger.b.a(string3);
            return null;
        }
        finally {
            y.a((Closeable)object3);
        }
    }

    /*
     * Exception decompiling
     */
    public void d() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 21[TRYBLOCK] [21 : 202->204)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public String e() {
        Object object = a;
        String string2 = "activity";
        if ((object = ((ActivityManager)object.getSystemService(string2)).getRunningAppProcesses()) != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                string2 = (ActivityManager.RunningAppProcessInfo)object.next();
                int n10 = ((ActivityManager.RunningAppProcessInfo)string2).pid;
                int n11 = Process.myPid();
                if (n10 != n11) continue;
                return ((ActivityManager.RunningAppProcessInfo)string2).processName;
            }
        }
        return "com.xiaomi";
    }
}

