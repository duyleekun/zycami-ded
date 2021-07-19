/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  android.net.Uri
 *  android.os.AsyncTask
 */
package com.huawei.updatesdk.service.otaupdate;

import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import com.huawei.updatesdk.a.a.a;
import com.huawei.updatesdk.service.otaupdate.c;
import com.huawei.updatesdk.service.otaupdate.c$a;

public class c$b
extends AsyncTask {
    public c$a a;

    public c$b(c$a c$a) {
        this.a = c$a;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Boolean a(Void ... object) {
        Throwable throwable2;
        Cursor cursor;
        String string2;
        block11: {
            int n10;
            object = "cursor Execption";
            string2 = "AutoUpdateUtil";
            cursor = null;
            boolean bl2 = false;
            Object var5_5 = null;
            Object object2 = com.huawei.updatesdk.a.b.a.a.c();
            object2 = ((com.huawei.updatesdk.a.b.a.a)object2).a();
            Object object3 = c.a();
            Uri uri = Uri.parse((String)object3);
            Object object4 = object2.getContentResolver();
            cursor = object4.query(uri, null, null, null, null);
            if (cursor != null && (n10 = cursor.moveToFirst()) != 0) {
                object2 = "isagree";
                n10 = cursor.getColumnIndex((String)object2);
                object2 = cursor.getString(n10);
                object2 = Boolean.valueOf((String)object2);
                n10 = (int)(((Boolean)object2).booleanValue() ? 1 : 0);
                object3 = "isopenautoupdate";
                int n11 = cursor.getColumnIndex((String)object3);
                object3 = cursor.getString(n11);
                object3 = Boolean.valueOf((String)object3);
                n11 = (int)(((Boolean)object3).booleanValue() ? 1 : 0);
                object4 = "isneverreminder";
                int n12 = cursor.getColumnIndex((String)object4);
                object4 = cursor.getString(n12);
                object4 = Boolean.valueOf((String)object4);
                n12 = (int)(((Boolean)object4).booleanValue() ? 1 : 0);
                if (n10 != 0 && n11 == 0 && n12 == 0) {
                    bl2 = true;
                }
            } else {
                object2 = "cursor == null";
                com.huawei.updatesdk.a.a.a.a(string2, (String)object2);
            }
            if (cursor == null) return bl2;
            {
                catch (Throwable throwable2) {
                    break block11;
                }
                catch (Exception exception) {}
                {
                    StringBuilder stringBuilder = new StringBuilder();
                    String string3 = "close cursor error: ";
                    stringBuilder.append(string3);
                    String string4 = exception.toString();
                    stringBuilder.append(string4);
                    string4 = stringBuilder.toString();
                    com.huawei.updatesdk.a.a.a.a(string2, string4);
                    if (cursor == null) return bl2;
                }
            }
            try {
                cursor.close();
                return bl2;
            }
            catch (Exception exception) {
                com.huawei.updatesdk.a.a.c.a.a.a.b(string2, (String)object);
            }
            return bl2;
        }
        if (cursor == null) throw throwable2;
        try {
            cursor.close();
            throw throwable2;
        }
        catch (Exception exception) {
            com.huawei.updatesdk.a.a.c.a.a.a.b(string2, (String)object);
        }
        throw throwable2;
    }

    public void a(Boolean bl2) {
        c$a c$a = this.a;
        if (c$a != null) {
            c$a.a(bl2);
        }
    }
}

