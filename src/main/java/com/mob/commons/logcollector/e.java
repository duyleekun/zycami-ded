/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.text.TextUtils
 *  android.util.Base64
 */
package com.mob.commons.logcollector;

import android.content.ContentValues;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.commons.logcollector.b;
import com.mob.commons.logcollector.d;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import java.util.ArrayList;
import java.util.HashMap;

public class e {
    public static long a(long l10, String string2, int n10, String string3) {
        Class<e> clazz = e.class;
        synchronized (clazz) {
            block15: {
                boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
                if (!bl2) break block15;
                return -1;
            }
            b b10 = b.a();
            ContentValues contentValues = new ContentValues();
            String string4 = "exception_time";
            Object object = l10;
            contentValues.put(string4, (Long)object);
            object = "exception_msg";
            Object object2 = string2.toString();
            contentValues.put((String)object, (String)object2);
            object = "exception_level";
            object2 = n10;
            contentValues.put((String)object, (Integer)object2);
            object = "exception_md5";
            contentValues.put((String)object, string3);
            object = "table_exception";
            l10 = b10.a((String)object, contentValues);
            return l10;
        }
    }

    public static long a(ArrayList object) {
        Class<e> clazz = e.class;
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
            String string6 = "table_exception";
            StringBuilder stringBuilder = new StringBuilder();
            String string7 = "exception_md5 in ( ";
            stringBuilder.append(string7);
            stringBuilder.append((String)object);
            object = " )";
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            Object var8_16 = null;
            int n13 = ((b)object2).a(string6, (String)object, null);
            object2 = MobLog.getInstance();
            String string8 = "delete COUNT == %s";
            objectArray = new Object[n10];
            Integer n14 = n13;
            objectArray[0] = n14;
            ((NLog)object2).i(string8, objectArray);
            long l10 = n13;
            return l10;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static ArrayList a(String object, String[] object2) {
        Class<e> clazz = e.class;
        synchronized (clazz) {
            int n10;
            Object object3;
            Cloneable cloneable;
            ArrayList<d> arrayList = new ArrayList<d>();
            d d10 = new d();
            Object object4 = b.a();
            Object object5 = " select exception_md5, exception_level, exception_time, exception_msg, sum(exception_counts) from table_exception group by exception_md5 having max(_id)";
            int n11 = TextUtils.isEmpty((CharSequence)object);
            if (n11 == 0 && cloneable != null && (n11 = ((void)cloneable).length) > 0) {
                object5 = new StringBuilder();
                object3 = " select exception_md5, exception_level, exception_time, exception_msg, sum(exception_counts) from table_exception where ";
                ((StringBuilder)object5).append((String)object3);
                ((StringBuilder)object5).append((String)object);
                object = " group by exception_md5 having max(_id)";
                ((StringBuilder)object5).append((String)object);
                object5 = ((StringBuilder)object5).toString();
            }
            object = ((b)object4).a((String)object5, (String[])cloneable);
            while (object != null && (n10 = object.moveToNext()) != 0) {
                cloneable = d10.b;
                int n12 = 0;
                object4 = null;
                object4 = object.getString(0);
                ((ArrayList)cloneable).add(object4);
                cloneable = new HashMap();
                object4 = "type";
                int n13 = 1;
                n13 = object.getInt(n13);
                object5 = n13;
                ((HashMap)cloneable).put(object4, object5);
                object4 = "errat";
                n13 = 2;
                long l10 = object.getLong(n13);
                object3 = l10;
                ((HashMap)cloneable).put(object4, object3);
                object4 = "msg";
                n11 = 3;
                object3 = object.getString(n11);
                object3 = ((String)object3).getBytes();
                object5 = Base64.encodeToString((byte[])object3, (int)n13);
                ((HashMap)cloneable).put(object4, object5);
                object4 = "times";
                n13 = 4;
                n13 = object.getInt(n13);
                object5 = n13;
                ((HashMap)cloneable).put(object4, object5);
                object4 = d10.a;
                ((ArrayList)object4).add(cloneable);
                cloneable = d10.b;
                n10 = ((ArrayList)cloneable).size();
                if (n10 != (n12 = 50)) continue;
                arrayList.add(d10);
                d10 = new d();
                break;
            }
            object.close();
            object = d10.b;
            int n14 = ((ArrayList)object).size();
            if (n14 != 0) {
                arrayList.add(d10);
            }
            return arrayList;
        }
    }

    public static ArrayList a(String[] object) {
        Class<e> clazz = e.class;
        synchronized (clazz) {
            b b10;
            int n10;
            String string2;
            block11: {
                string2 = "exception_level = ?";
                n10 = 0;
                b10 = null;
                if (object != null) {
                    int n11 = ((String[])object).length;
                    if (n11 > 0) break block11;
                }
                object = null;
                string2 = null;
            }
            try {
                b10 = b.a();
                String string3 = "table_exception";
                n10 = b10.a(string3);
                if (n10 > 0) {
                    object = e.a(string2, object);
                    return object;
                }
                object = new ArrayList();
                return object;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
            finally {
            }
        }
    }
}

