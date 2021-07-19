/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Handler
 *  android.util.Base64
 *  org.json.JSONObject
 */
package com.baidu.location.indoor;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.util.Base64;
import com.baidu.location.b.aa;
import com.baidu.location.h.b;
import com.baidu.location.h.f;
import com.baidu.location.h.l;
import com.baidu.location.indoor.a$a;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

public class a
extends f {
    private static HashMap a;
    private static Object v;
    private static a w;
    private String b = "https://loc.map.baidu.com/indoorlocbuildinginfo.php";
    private final SimpleDateFormat c;
    private Context d;
    private boolean e;
    private String f;
    private HashSet q;
    private a$a r;
    private String s;
    private Handler t;
    private Runnable u;

    static {
        Object object = new HashMap();
        a = object;
        v = object = new Object();
        w = null;
    }

    public a(Context object) {
        SimpleDateFormat simpleDateFormat;
        this.c = simpleDateFormat = new SimpleDateFormat("yyyyMM");
        this.s = null;
        this.d = object;
        this.q = object;
        this.e = false;
        super();
        this.k = object;
        super();
        this.t = object;
        super(this);
        this.u = object;
    }

    public static /* synthetic */ String a(a a10) {
        return a10.s;
    }

    public static /* synthetic */ String a(a a10, String string2) {
        a10.f = string2;
        return string2;
    }

    private String a(Date object) {
        block19: {
            Object object2 = new StringBuilder();
            Object object3 = this.f;
            ((StringBuilder)object2).append((String)object3);
            object = this.c.format((Date)object);
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString().getBytes();
            object2 = null;
            object = com.baidu.location.h.l.a((byte[])object, false);
            File file = this.d.getCacheDir();
            object3 = new File(file, (String)object);
            boolean bl2 = ((File)object3).isFile();
            file = null;
            if (!bl2) {
                return null;
            }
            Object object4 = new FileReader((File)object3);
            object = new BufferedReader((Reader)object4);
            object4 = object3 = "";
            while (true) {
                String string2 = ((BufferedReader)object).readLine();
                if (string2 == null) break;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((String)object4);
                stringBuilder.append(string2);
                object4 = "\n";
                stringBuilder.append((String)object4);
                object4 = stringBuilder.toString();
                continue;
                break;
            }
            try {
                ((BufferedReader)object).close();
            }
            catch (Exception exception) {}
            bl2 = ((String)object4).equals(object3);
            if (bl2) break block19;
            object3 = ((String)object4).getBytes();
            object2 = Base64.decode((byte[])object3, (int)0);
            object = new String((byte[])object2);
            return object;
        }
        return null;
    }

    public static /* synthetic */ String b(a a10) {
        return a10.b;
    }

    private void c(String stringArray) {
        String string2 = ",";
        for (String string3 : stringArray.split(string2)) {
            HashSet hashSet = this.q;
            string3 = string3.toLowerCase();
            hashSet.add(string3);
        }
    }

    private Date d() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(2, -1);
        return calendar.getTime();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void d(String object) {
        Object object2 = new StringBuilder();
        Object object3 = this.f;
        ((StringBuilder)object2).append((String)object3);
        object3 = this.c;
        Object object4 = new Date();
        object3 = ((DateFormat)object3).format((Date)object4);
        ((StringBuilder)object2).append((String)object3);
        object2 = ((StringBuilder)object2).toString().getBytes();
        object3 = null;
        object2 = com.baidu.location.h.l.a((byte[])object2, false);
        File file = this.d.getCacheDir();
        object4 = new File(file, (String)object2);
        try {
            object2 = new FileWriter((File)object4);
        }
        catch (IOException iOException) {
            return;
        }
        object = ((String)object).getBytes();
        object = Base64.encode((byte[])object, (int)0);
        object3 = "UTF-8";
        object4 = new String((byte[])object, (String)object3);
        ((Writer)object2).write((String)object4);
        ((OutputStreamWriter)object2).flush();
        ((OutputStreamWriter)object2).close();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void e() {
        Comparable<StringBuilder> comparable;
        block15: {
            Object object;
            try {
                object = this.d();
            }
            catch (Exception exception) {
                return;
            }
            comparable = new Comparable<StringBuilder>();
            Object object2 = this.f;
            ((StringBuilder)comparable).append((String)object2);
            object2 = this.c;
            object = ((DateFormat)object2).format((Date)object);
            ((StringBuilder)comparable).append((String)object);
            object = ((StringBuilder)comparable).toString();
            object = ((String)object).getBytes();
            comparable = null;
            object = com.baidu.location.h.l.a((byte[])object, false);
            object2 = this.d;
            object2 = object2.getCacheDir();
            comparable = new Comparable<StringBuilder>((File)object2, (String)object);
            boolean bl2 = ((File)comparable).isFile();
            if (bl2) break block15;
            return;
        }
        ((File)comparable).delete();
    }

    private void f(String string2) {
        Object object = this.d.getCacheDir();
        String string3 = "buildings";
        Comparable<File> comparable = new Comparable<File>((File)object, string3);
        boolean bl2 = true;
        object = new FileWriter((File)comparable, bl2);
        comparable = new Comparable<File>();
        ((StringBuilder)comparable).append(string2);
        string2 = "\n";
        ((StringBuilder)comparable).append(string2);
        string2 = ((StringBuilder)comparable).toString();
        try {
            ((Writer)object).write(string2);
            ((OutputStreamWriter)object).flush();
            ((OutputStreamWriter)object).close();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(boolean bl2) {
        boolean bl3;
        String string2;
        boolean bl4;
        Object object;
        block14: {
            block13: {
                Object object2;
                block12: {
                    object = "anchorinfo";
                    bl4 = true;
                    if (bl2 && (object2 = this.j) != null) {
                        try {
                            object2 = ((String)object2).getBytes();
                            object2 = Base64.decode((byte[])object2, (int)0);
                            string2 = new String((byte[])object2);
                            object2 = new JSONObject(string2);
                            boolean bl5 = object2.has((String)object);
                            if (!bl5 || (object2 = object2.optString((String)object)) == null || (bl3 = ((String)object2).equals(object = ""))) break block12;
                            object = this.q;
                            ((HashSet)object).clear();
                            this.c((String)object2);
                            this.d((String)object2);
                        }
                        catch (Exception exception) {}
                        this.e();
                        break block13;
                    }
                }
                bl2 = false;
                object2 = null;
                break block14;
                catch (Exception exception) {}
            }
            bl2 = bl4;
        }
        if (!bl2 && (object = this.s) == null) {
            object = this.f;
            this.s = object;
            object = this.t;
            Runnable runnable = this.u;
            long l10 = 60000L;
            object.postDelayed(runnable, l10);
        } else {
            bl3 = false;
            object = null;
            if (bl2) {
                this.s = null;
            } else {
                string2 = this.s;
                this.f(string2);
                this.s = null;
                object = this.d();
                object = this.a((Date)object);
                if (object != null) {
                    this.c((String)object);
                    object = this.r;
                    if (object != null) {
                        object.a(bl4);
                    }
                }
            }
        }
        this.e = false;
        object = this.r;
        if (object != null) {
            object.a(bl2);
        }
    }

    public boolean a() {
        boolean bl2;
        HashSet hashSet = this.q;
        if (hashSet != null && !(bl2 = hashSet.isEmpty())) {
            bl2 = true;
        } else {
            bl2 = false;
            hashSet = null;
        }
        return bl2;
    }

    public boolean a(String object) {
        boolean bl2;
        String string2 = this.f;
        return string2 != null && (bl2 = string2.equalsIgnoreCase((String)object)) && !(bl2 = ((HashSet)(object = this.q)).isEmpty());
        {
        }
    }

    public boolean a(String object, a$a object2) {
        block23: {
            boolean bl2 = this.e;
            if (!bl2) {
                block24: {
                    Object object3;
                    int n10;
                    block21: {
                        long l10;
                        block22: {
                            this.r = object2;
                            this.e = n10 = 1;
                            this.f = object;
                            object3 = new Date();
                            object3 = this.a((Date)object3);
                            if (object3 != null) break block21;
                            l10 = System.currentTimeMillis();
                            object2 = a;
                            object2 = ((HashMap)object2).get(object);
                            if (object2 == null) break block22;
                            object2 = a;
                            object2 = ((HashMap)object2).get(object);
                            object2 = (Long)object2;
                            long l11 = (Long)object2;
                            l11 = l10 - l11;
                            long l12 = 86400000L;
                            n10 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
                            if (n10 <= 0) break block23;
                        }
                        object2 = a;
                        object3 = l10;
                        ((HashMap)object2).put(object, object3);
                        object = aa.a();
                        object = ((aa)object).c();
                        object2 = this.b;
                        this.a((ExecutorService)object, (String)object2);
                    }
                    this.c((String)object3);
                    object = this.r;
                    if (object == null) break block24;
                    object.a(n10 != 0);
                }
                try {
                    this.e = false;
                }
                catch (Exception exception) {
                    this.e = false;
                }
            }
        }
        return false;
    }

    public void b() {
        Object object = this.b;
        this.h = object;
        this.k.clear();
        this.k.put("bid", "none");
        object = this.k;
        String string2 = this.f;
        object.put("bldg", string2);
        object = this.k;
        string2 = Build.MODEL;
        object.put("mb", string2);
        this.k.put("msdk", "2.0");
        object = this.k;
        string2 = com.baidu.location.h.b.a().c;
        object.put("cuid", string2);
        this.k.put("anchors", "v1");
    }

    public boolean b(String string2) {
        boolean bl2;
        boolean bl3;
        Object object = this.f;
        return object != null && (object = this.q) != null && !(bl3 = ((HashSet)object).isEmpty()) && (bl2 = ((HashSet)(object = this.q)).contains(string2));
    }

    public void c() {
        this.f = null;
        this.q.clear();
    }
}

