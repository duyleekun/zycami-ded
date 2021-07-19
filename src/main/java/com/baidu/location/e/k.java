/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteDatabase
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.baidu.location.e;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.location.Jni;
import com.baidu.location.e.k$a;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class k {
    private static final String d;
    private static final String e;
    private String a;
    private final SQLiteDatabase b;
    private final k$a c;

    static {
        Locale locale = Locale.US;
        int n10 = 1;
        Object object = new Object[n10];
        Integer n11 = 3000;
        object[0] = n11;
        d = String.format(locale, "DELETE FROM LOG WHERE timestamp NOT IN (SELECT timestamp FROM LOG ORDER BY timestamp DESC LIMIT %d);", object);
        Object[] objectArray = new Object[n10];
        objectArray[0] = object = Integer.valueOf(3);
        e = String.format(locale, "SELECT * FROM LOG ORDER BY timestamp DESC LIMIT %d;", objectArray);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public k(SQLiteDatabase sQLiteDatabase) {
        boolean bl2 = false;
        this.a = null;
        this.b = sQLiteDatabase;
        Object object = new k$a(this, this);
        this.c = object;
        if (sQLiteDatabase == null) return;
        bl2 = sQLiteDatabase.isOpen();
        if (!bl2) return;
        object = "CREATE TABLE IF NOT EXISTS LOG(timestamp LONG PRIMARY KEY, log VARCHAR(4000))";
        try {
            sQLiteDatabase.execSQL((String)object);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public static /* synthetic */ String a(k k10) {
        return k10.b();
    }

    public static /* synthetic */ void a(k k10, boolean bl2) {
        k10.a(bl2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(boolean bl2) {
        String string2;
        if (bl2 && (string2 = this.a) != null) {
            int n10 = 1;
            Object object = new Object[n10];
            object[0] = string2;
            string2 = String.format("DELETE FROM LOG WHERE timestamp in (%s);", (Object[])object);
            try {
                object = this.a;
                n10 = ((String)object).length();
                if (n10 > 0) {
                    object = this.b;
                    object.execSQL(string2);
                }
            }
            catch (Exception exception) {}
        }
        this.a = null;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String b() {
        SQLiteDatabase sQLiteDatabase;
        JSONArray jSONArray;
        Object object;
        block16: {
            CharSequence charSequence;
            block17: {
                block19: {
                    void var1_4;
                    block18: {
                        object = new JSONArray();
                        JSONObject jSONObject = new JSONObject();
                        jSONArray = null;
                        sQLiteDatabase = this.b;
                        charSequence = e;
                        sQLiteDatabase = sQLiteDatabase.rawQuery((String)charSequence, null);
                        if (sQLiteDatabase == null) break block16;
                        try {
                            String string2;
                            int n10;
                            int n11 = sQLiteDatabase.getCount();
                            if (n11 <= 0) break block16;
                            charSequence = new StringBuffer();
                            sQLiteDatabase.moveToFirst();
                            while ((n10 = sQLiteDatabase.isAfterLast()) == 0) {
                                n10 = 1;
                                string2 = sQLiteDatabase.getString(n10);
                                object.put((Object)string2);
                                n10 = ((StringBuffer)charSequence).length();
                                if (n10 != 0) {
                                    string2 = ",";
                                    ((StringBuffer)charSequence).append(string2);
                                }
                                n10 = 0;
                                string2 = null;
                                long l10 = sQLiteDatabase.getLong(0);
                                ((StringBuffer)charSequence).append(l10);
                                sQLiteDatabase.moveToNext();
                            }
                            string2 = "ofloc";
                            jSONObject.put(string2, object);
                            jSONArray = object = jSONObject.toString();
                            break block17;
                        }
                        catch (Throwable throwable) {
                            jSONArray = sQLiteDatabase;
                            break block18;
                        }
                        catch (Exception exception) {
                            object = jSONArray;
                            jSONArray = sQLiteDatabase;
                            break block19;
                        }
                        catch (Throwable throwable) {
                            // empty catch block
                        }
                    }
                    if (jSONArray == null) throw var1_4;
                    try {
                        jSONArray.close();
                    }
                    catch (Exception exception) {
                        throw var1_4;
                    }
                    throw var1_4;
                    catch (Exception exception) {
                        object = null;
                    }
                }
                if (jSONArray == null) return object;
                try {
                    jSONArray.close();
                    return object;
                }
                catch (Exception exception) {}
                catch (JSONException jSONException) {}
            }
            object = ((StringBuffer)charSequence).toString();
            this.a = object;
        }
        if (sQLiteDatabase == null) return jSONArray;
        try {
            sQLiteDatabase.close();
            return jSONArray;
        }
        catch (Exception exception) {
            return jSONArray;
        }
        return object;
    }

    public void a() {
        k$a.a(this.c);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void a(String string2) {
        string2 = Jni.encodeOfflineLocationUpdateRequest(string2);
        Object object = Locale.US;
        int n10 = 2;
        Object[] objectArray = new Object[n10];
        long l10 = System.currentTimeMillis();
        Long l11 = l10;
        objectArray[0] = l11;
        int n11 = 1;
        objectArray[n11] = string2;
        string2 = String.format((Locale)object, "INSERT OR IGNORE INTO LOG VALUES (%d,\"%s\");", objectArray);
        try {
            object = this.b;
        }
        catch (Exception exception) {
            return;
        }
        object.execSQL(string2);
        string2 = this.b;
        object = d;
        string2.execSQL((String)object);
    }
}

