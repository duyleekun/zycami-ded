/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.database.sqlite.SQLiteDatabase
 *  android.os.Bundle
 *  org.json.JSONObject
 */
package com.baidu.location.b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.baidu.location.Jni;
import com.baidu.location.b.b;
import com.baidu.location.b.k$a;
import com.baidu.location.f.a;
import com.baidu.location.f.f;
import com.baidu.location.f.h;
import com.baidu.location.f.i;
import com.baidu.location.h.l;
import java.io.File;
import org.json.JSONObject;

public class k {
    private static Object c;
    private static k d;
    private static final String e;
    public k$a a = null;
    public k$a b = null;
    private SQLiteDatabase f = null;
    private boolean g = false;
    private String h = null;
    private int i = -2;

    static {
        Object object;
        c = object = new Object();
        object = new StringBuilder();
        String string2 = l.j();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append("/hst.db");
        e = ((StringBuilder)object).toString();
    }

    public static /* synthetic */ SQLiteDatabase a(k k10) {
        return k10.f;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static k a() {
        Object object = c;
        synchronized (object) {
            k k10 = d;
            if (k10 != null) return d;
            d = k10 = new k();
            return d;
        }
    }

    private String a(boolean bl2) {
        String string2;
        StringBuffer stringBuffer;
        block7: {
            Object object;
            block6: {
                block5: {
                    int n10;
                    object = com.baidu.location.f.b.a().f();
                    h h10 = com.baidu.location.f.i.a().p();
                    int n11 = 1024;
                    stringBuffer = new StringBuffer(n11);
                    if (object != null && (n11 = (int)(((a)object).b() ? 1 : 0)) != 0) {
                        object = ((a)object).i();
                        stringBuffer.append((String)object);
                    }
                    if (h10 == null || (n10 = h10.a()) <= (n11 = 1)) break block5;
                    n10 = 15;
                    object = h10.a(n10);
                    break block6;
                }
                object = com.baidu.location.f.i.a().m();
                if (object == null) break block7;
                object = com.baidu.location.f.i.a().m();
            }
            stringBuffer.append((String)object);
        }
        if (bl2) {
            string2 = "&imo=1";
            stringBuffer.append(string2);
        }
        string2 = com.baidu.location.f.f.a().m();
        stringBuffer.append(string2);
        string2 = com.baidu.location.h.b.a().a(false);
        stringBuffer.append(string2);
        string2 = com.baidu.location.b.b.a().d();
        stringBuffer.append(string2);
        return stringBuffer.toString();
    }

    private void a(Bundle bundle) {
        com.baidu.location.b.b.a().a(bundle, 406);
    }

    public static /* synthetic */ void a(k k10, Bundle bundle) {
        k10.a(bundle);
    }

    public static /* synthetic */ boolean a(k k10, boolean bl2) {
        k10.g = bl2;
        return bl2;
    }

    public static /* synthetic */ void b(k k10) {
        k10.f();
    }

    public static /* synthetic */ boolean c(k k10) {
        return k10.g;
    }

    private void f() {
        Bundle bundle = new Bundle();
        bundle.putInt("hotspot", -1);
        this.a(bundle);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(String object) {
        String string2 = "hstdata";
        Object object2 = "content";
        String string3 = "imo";
        boolean bl2 = this.g;
        if (bl2) {
            return;
        }
        try {
            Object object3 = new JSONObject((String)object);
            int n10 = object3.has((String)object2);
            if (n10 != 0) {
                object = object3.getJSONObject((String)object2);
            } else {
                n10 = 0;
                object = null;
            }
            if (object == null) return;
            boolean bl3 = object.has(string3);
            if (!bl3) return;
            object2 = object.getJSONObject(string3);
            object3 = "mac";
            object2 = object2.getString((String)object3);
            object2 = Long.valueOf((String)object2);
            object = object.getJSONObject(string3);
            string3 = "mv";
            n10 = object.getInt(string3);
            string3 = new ContentValues();
            object3 = "tt";
            long l10 = System.currentTimeMillis();
            long l11 = 1000L;
            int n11 = (int)(l10 /= l11);
            Object object4 = n11;
            string3.put((String)object3, (Integer)object4);
            object3 = "hst";
            object = n10;
            string3.put((String)object3, (Integer)object);
            object = this.f;
            object3 = new StringBuilder();
            object4 = "id = \"";
            ((StringBuilder)object3).append((String)object4);
            ((StringBuilder)object3).append(object2);
            object4 = "\"";
            ((StringBuilder)object3).append((String)object4);
            object3 = ((StringBuilder)object3).toString();
            n10 = object.update(string2, (ContentValues)string3, (String)object3, null);
            if (n10 > 0) return;
            object = "id";
            string3.put((String)object, (Long)object2);
            object = this.f;
            object.insert(string2, null, (ContentValues)string3);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        try {
            boolean bl2;
            String string2 = e;
            File file = new File(string2);
            boolean bl3 = file.exists();
            if (!bl3) {
                file.createNewFile();
            }
            if (!(bl2 = file.exists())) return;
            file = SQLiteDatabase.openOrCreateDatabase((File)file, null);
            this.f = file;
            string2 = "CREATE TABLE IF NOT EXISTS hstdata(id Long PRIMARY KEY,hst INT,tt INT);";
            file.execSQL(string2);
            file = this.f;
            int n10 = 1;
            file.setVersion(n10);
            return;
        }
        catch (Exception exception) {
            this.f = null;
        }
    }

    public void c() {
        SQLiteDatabase sQLiteDatabase = this.f;
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.close();
            }
            catch (Throwable throwable) {
                this.f = null;
                throw throwable;
            }
            catch (Exception exception) {}
            this.f = null;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int d() {
        synchronized (this) {
            block20: {
                var1_1 = -3;
                var2_2 = this.g;
                if (var2_2) {
                    return var1_1;
                }
                var3_3 = com.baidu.location.f.i.a();
                var2_2 = var3_3.j();
                if (!var2_2 || (var3_3 = this.f) == null) ** GOTO lbl61
                var3_3 = com.baidu.location.f.i.a();
                if ((var3_3 = var3_3.l()) == null || (var4_5 = var3_3.getBSSID()) == null) ** GOTO lbl61
                var3_3 = var3_3.getBSSID();
                var4_5 = ":";
                var5_6 = "";
                var3_3 = var3_3.replace((CharSequence)var4_5, var5_6);
                var4_5 = Jni.encode3((String)var3_3);
                var5_6 = this.h;
                var6_7 = -2;
                if (var5_6 == null || (var7_8 = var3_3.equals(var5_6)) == 0 || (var7_8 = this.i) <= var6_7) break block20;
                var1_1 = var7_8;
                ** GOTO lbl61
            }
            var7_8 = 0;
            var5_6 = null;
            try {
                var8_9 = this.f;
                var9_10 = new StringBuilder();
                var10_11 = "select * from hstdata where id = \"";
                var9_10.append(var10_11);
                var9_10.append(var4_5);
                var4_5 = "\";";
                var9_10.append((String)var4_5);
                var4_5 = var9_10.toString();
                var5_6 = var8_9.rawQuery((String)var4_5, null);
                if (var5_6 != null && (var11_12 = var5_6.moveToFirst()) != 0) {
                    var11_12 = 1;
                    var1_1 = var5_6.getInt(var11_12);
                    this.h = var3_3;
                    this.i = var1_1;
                } else {
                    var1_1 = var6_7;
                }
                if (var5_6 == null) ** GOTO lbl61
                ** GOTO lbl-1000
            }
            catch (Throwable var3_4) {
                if (var5_6 != null) {
                    var5_6.close();
                }
lbl51:
                // 4 sources

                while (true) {
                    try {
                        throw var3_4;
                    }
                    catch (Exception v0) {}
                    ** GOTO lbl61
                    break;
                }
lbl-1000:
                // 2 sources

                {
                    while (true) {
                        var5_6.close();
                        ** GOTO lbl61
                        break;
                    }
                }
lbl59:
                // 1 sources

                while (true) {
                    if (var5_6 != null) ** continue;
lbl61:
                    // 7 sources

                    this.i = var1_1;
                    return var1_1;
                }
                catch (Exception v1) {
                    ** continue;
                }
            }
            catch (Exception v2) {
                ** continue;
            }
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void e() {
        block51: {
            block50: {
                var1_1 = this.g;
                if (var1_1) {
                    return;
                }
                var2_2 = com.baidu.location.f.i.a();
                var1_1 = var2_2.j();
                if (!var1_1) ** GOTO lbl117
                var2_2 = this.f;
                if (var2_2 == null) ** GOTO lbl117
                var2_2 = com.baidu.location.f.i.a();
                var2_2 = var2_2.l();
                if (var2_2 == null) ** GOTO lbl117
                var3_4 = var2_2.getBSSID();
                if (var3_4 == null) ** GOTO lbl117
                var2_2 = var2_2.getBSSID();
                var3_4 = ":";
                var4_5 = "";
                var2_2 = var2_2.replace((CharSequence)var3_4, var4_5);
                var3_4 = Jni.encode3((String)var2_2);
                var5_6 = 0;
                var4_5 = null;
                var6_7 = null;
                var7_8 = 1;
                var8_9 = this.f;
                var9_10 /* !! */  = new StringBuilder();
                var10_11 = "select * from hstdata where id = \"";
                var9_10 /* !! */ .append((String)var10_11);
                var9_10 /* !! */ .append(var3_4);
                var3_4 = "\";";
                var9_10 /* !! */ .append((String)var3_4);
                var3_4 = var9_10 /* !! */ .toString();
                var6_7 = var8_9.rawQuery((String)var3_4, null);
                if (var6_7 == null) ** GOTO lbl-1000
                var11_12 = var6_7.moveToFirst();
                if (var11_12 == 0) ** GOTO lbl-1000
                var11_12 = var6_7.getInt(var7_8);
                var12_13 = 2;
                var12_13 = var6_7.getInt(var12_13);
                var13_14 = System.currentTimeMillis();
                var15_15 = 1000L;
                try {
                    var13_14 /= var15_15;
                }
                catch (Throwable var2_3) {
                    if (var6_7 != null) {
                        var6_7.close();
                    }
lbl92:
                    // 4 sources

                    while (true) {
                        throw var2_3;
                        break;
                    }
                }
                var15_15 = var12_13;
                var13_14 -= var15_15;
                var15_15 = 259200L;
                var12_13 = (int)(var13_14 == var15_15 ? 0 : (var13_14 < var15_15 ? -1 : 1));
                if (var12_13 <= 0) {
                    var8_9 = new Bundle();
                    var9_10 /* !! */  = "mac";
                    var10_11 = var2_2.getBytes();
                    var8_9.putByteArray((String)var9_10 /* !! */ , (byte[])var10_11);
                    var9_10 /* !! */  = "hotspot";
                    var8_9.putInt((String)var9_10 /* !! */ , var11_12);
                    this.a((Bundle)var8_9);
                } else lbl-1000:
                // 3 sources

                {
                    var5_6 = var7_8;
                }
                if (var6_7 == null) break block50;
lbl84:
                // 2 sources

                while (true) {
                    var6_7.close();
                    break block50;
                    break;
                }
lbl95:
                // 1 sources

                while (true) {
                    if (var6_7 != null) {
                        ** continue;
                    }
                    break block50;
                    break;
                }
                catch (Exception v0) {}
            }
            if (var5_6 == 0) ** GOTO lbl118
            var3_4 = this.a;
            if (var3_4 != null) ** GOTO lbl111
            {
                catch (Exception v1) {
                    ** continue;
                }
            }
            var3_4 = new k$a(this);
            this.a = var3_4;
lbl111:
            // 2 sources

            if ((var3_4 = this.a) == null) ** GOTO lbl118
            var4_5 = this.a((boolean)var7_8);
            var3_4.a((String)var2_2, var4_5);
            break block51;
lbl117:
            // 4 sources

            this.f();
        }
        return;
        {
            catch (Exception v2) {
                ** continue;
            }
        }
        catch (Exception v3) {
            ** continue;
        }
    }
}

