/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 */
package cn.sharesdk.framework.b.a;

import android.content.ContentValues;
import cn.sharesdk.framework.b.a.b;
import cn.sharesdk.framework.b.a.c;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.log.NLog;
import java.util.ArrayList;

public class d {
    public static long a(String string2, long l10) {
        Class<d> clazz = d.class;
        synchronized (clazz) {
            block13: {
                if (string2 != null) {
                    Object object = string2.trim();
                    String string3 = "";
                    if (object == string3) break block13;
                    object = b.a();
                    string3 = new ContentValues();
                    String string4 = "post_time";
                    Object object2 = l10;
                    string3.put(string4, (Long)object2);
                    object2 = "message_data";
                    string2 = string2.toString();
                    string3.put((String)object2, string2);
                    string2 = "message";
                    long l11 = ((b)object).a(string2, (ContentValues)string3);
                    return l11;
                }
            }
            return -1;
        }
    }

    public static long a(ArrayList object) {
        Class<d> clazz = d.class;
        synchronized (clazz) {
            if (object == null) {
                return 0L;
            }
            Object object2 = new StringBuilder();
            int n10 = 0;
            Object[] objectArray = null;
            while (true) {
                int n11 = ((ArrayList)object).size();
                if (n10 >= n11) break;
                String string2 = "'";
                ((StringBuilder)object2).append(string2);
                Object e10 = ((ArrayList)object).get(n10);
                String string3 = (String)e10;
                ((StringBuilder)object2).append(string3);
                String string4 = "'";
                ((StringBuilder)object2).append(string4);
                String string5 = ",";
                ((StringBuilder)object2).append(string5);
                ++n10;
                continue;
                break;
            }
            object = ((StringBuilder)object2).toString();
            int n12 = ((StringBuilder)object2).length();
            n10 = 1;
            n12 -= n10;
            object = ((String)object).substring(0, n12);
            object2 = b.a();
            String string6 = "message";
            StringBuilder stringBuilder = new StringBuilder();
            String string7 = "_id in ( ";
            stringBuilder.append(string7);
            stringBuilder.append((String)object);
            object = " )";
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            Object var8_16 = null;
            int n13 = ((b)object2).a(string6, (String)object, null);
            object2 = SSDKLog.b();
            String string8 = "delete COUNT == %s";
            objectArray = new Object[n10];
            Integer n14 = n13;
            objectArray[0] = n14;
            ((NLog)object2).i(string8, objectArray);
            long l10 = n13;
            return l10;
        }
    }

    public static ArrayList a() {
        Class<d> clazz = d.class;
        synchronized (clazz) {
            ArrayList arrayList;
            block8: {
                arrayList = b.a();
                String string2 = "message";
                int n10 = ((b)((Object)arrayList)).a(string2);
                if (n10 <= 0) break block8;
                n10 = 0;
                arrayList = null;
                arrayList = d.a(null, null);
                return arrayList;
            }
            arrayList = new ArrayList();
            return arrayList;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static ArrayList a(String object, String[] object2) {
        Class<d> clazz = d.class;
        synchronized (clazz) {
            Object object3;
            ArrayList<c> arrayList = new ArrayList<c>();
            c c10 = new c();
            StringBuilder stringBuilder = new StringBuilder();
            Object object4 = b.a();
            String string2 = "message";
            String[] stringArray = "_id";
            Object object5 = "post_time";
            String string3 = "message_data";
            stringArray = new String[]{stringArray, object5, string3};
            object5 = object;
            string3 = object3;
            object = ((b)object4).a(string2, stringArray, (String)object, (String[])object3, null);
            while (true) {
                int n10;
                int n11 = 0;
                object3 = null;
                if (object == null || (n10 = object.moveToNext()) == 0) break;
                object4 = c10.b;
                object3 = object.getString(0);
                ((ArrayList)object4).add(object3);
                object3 = c10.b;
                n11 = ((ArrayList)object3).size();
                n10 = 100;
                int n12 = 2;
                if (n11 == n10) {
                    object3 = object.getString(n12);
                    stringBuilder.append((String)object3);
                    c10.a = object3 = stringBuilder.toString();
                    arrayList.add(c10);
                    c10 = new c();
                    stringBuilder = new StringBuilder();
                    continue;
                }
                object3 = new StringBuilder();
                object4 = object.getString(n12);
                ((StringBuilder)object3).append((String)object4);
                object4 = "\n";
                ((StringBuilder)object3).append((String)object4);
                object3 = ((StringBuilder)object3).toString();
                stringBuilder.append((String)object3);
            }
            object.close();
            object = c10.b;
            int n13 = ((ArrayList)object).size();
            if (n13 != 0) {
                object = stringBuilder.toString();
                int n14 = stringBuilder.length() + -1;
                c10.a = object = ((String)object).substring(0, n14);
                arrayList.add(c10);
            }
            return arrayList;
        }
    }
}

