/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.j;

import android.text.TextUtils;
import com.zhiyun.editorinterface.EditConfig$a;
import d.v.e.l.f1;
import d.v.e.l.s1;
import java.util.List;
import m.a.a;

public class b {
    public static boolean a(long l10, long l11, long l12) {
        long l13 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        int n10 = 1;
        l13 = l13 >= 0 && (l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1)) < 0 ? (long)0 : (long)n10;
        if (l13 != false) {
            Object object;
            int n11 = 3;
            Object[] objectArray = new Object[n11];
            objectArray[0] = object = Long.valueOf(l10);
            objectArray[n10] = object = Long.valueOf(l11);
            int n12 = 2;
            Long l14 = l12;
            objectArray[n12] = l14;
            object = "clip time out of range,clipTime:%d,startTime:%d,endTime:%d";
            a.i((String)object, objectArray);
        }
        return (boolean)l13;
    }

    public static boolean b(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        int n10 = 1;
        if (bl2) {
            object = new Object[]{};
            a.i("file path is empty", object);
            return n10 != 0;
        }
        bl2 = s1.q((String)object);
        if (bl2) {
            return false;
        }
        bl2 = s1.R((String)object);
        if (bl2) {
            return false;
        }
        String string2 = d.v.e.j.b.k(d.v.e.j.b.j((String)object));
        bl2 = f1.a(string2);
        if (!bl2) {
            Object[] objectArray = new Object[n10];
            objectArray[0] = object;
            object = "file not exit:%s";
            a.i((String)object, objectArray);
        }
        return bl2 ^ true;
    }

    public static boolean c(int n10) {
        int n11 = 100;
        int n12 = 1;
        int n13 = n10 >= 0 && n10 <= n11 ? 0 : n12;
        if (n13 != 0) {
            Object object;
            int n14 = 3;
            Object[] objectArray = new Object[n14];
            objectArray[0] = object = Integer.valueOf(n10);
            objectArray[n12] = object = Integer.valueOf(0);
            n10 = 2;
            Integer n15 = n11;
            objectArray[n10] = n15;
            object = "filter percent out of range,percent:%d,min:%d,max:%d";
            a.i((String)object, objectArray);
        }
        return n13 != 0;
    }

    public static boolean d(int n10) {
        String[] stringArray;
        int n11;
        int n12 = 1;
        if (n10 >= 0 && n10 < (n11 = (stringArray = EditConfig$a.m).length)) {
            n11 = 0;
            stringArray = null;
        } else {
            n11 = n12;
        }
        if (n11 != 0) {
            Object object;
            int n13 = 3;
            Object[] objectArray = new Object[n13];
            objectArray[0] = object = Integer.valueOf(n10);
            objectArray[n12] = object = Integer.valueOf(0);
            n10 = 2;
            n12 = EditConfig$a.m.length;
            Integer n14 = n12;
            objectArray[n10] = n14;
            object = "frame effect out of range,frame effect:%d,min:%d,max:%d";
            a.i((String)object, objectArray);
        }
        return n11 != 0;
    }

    public static boolean e(int n10) {
        Integer n11 = null;
        int n12 = 5;
        int n13 = 1;
        int n14 = -5;
        int n15 = n10 >= n14 && n10 <= n12 ? 0 : n13;
        if (n15 != 0) {
            Object object;
            int n16 = 3;
            Object[] objectArray = new Object[n16];
            objectArray[0] = object = Integer.valueOf(n10);
            objectArray[n13] = object = Integer.valueOf(n14);
            n10 = 2;
            n11 = n12;
            objectArray[n10] = n11;
            object = "frame value out of range,frame value:%d,min:%d,max:%d";
            a.i((String)object, objectArray);
        }
        return n15 != 0;
    }

    public static boolean f(List list) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            bl2 = false;
            list = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static boolean g(int n10) {
        float[] fArray;
        int n11;
        int n12 = 0;
        Integer n13 = null;
        int n14 = 1;
        if (n10 >= 0 && n10 < (n11 = (fArray = EditConfig$a.k).length)) {
            n11 = 0;
            fArray = null;
        } else {
            n11 = n14;
        }
        if (n11 != 0) {
            Object object;
            int n15 = 3;
            Object[] objectArray = new Object[n15];
            objectArray[0] = object = Integer.valueOf(n10);
            objectArray[n14] = object = Integer.valueOf(0);
            n10 = 2;
            n12 = EditConfig$a.k.length - n14;
            n13 = n12;
            objectArray[n10] = n13;
            object = "radioIndex out of range,radioIndex:%d,mim:%d,max:%d";
            a.i((String)object, objectArray);
        }
        return n11 != 0;
    }

    public static boolean h(int n10, List list) {
        int n11;
        int n12 = 1;
        if (list == null) {
            Object[] objectArray = new Object[]{};
            a.i("list is null", objectArray);
            return n12 != 0;
        }
        n11 = n10 >= 0 && n10 < (n11 = list.size()) ? 0 : n12;
        if (n11 != 0) {
            Object object;
            int n13 = 2;
            Object[] objectArray = new Object[n13];
            objectArray[0] = object = Integer.valueOf(n10);
            n10 = list.size();
            objectArray[n12] = object = Integer.valueOf(n10);
            object = "out of range,index:%d,list size:%d";
            a.i((String)object, objectArray);
        }
        return n11 != 0;
    }

    public static boolean i(int n10) {
        int n11 = 7;
        int n12 = 1;
        int n13 = n10 >= 0 && n10 <= n11 ? 0 : n12;
        if (n13 != 0) {
            Object object;
            int n14 = 3;
            Object[] objectArray = new Object[n14];
            objectArray[0] = object = Integer.valueOf(n10);
            objectArray[n12] = object = Integer.valueOf(0);
            n10 = 2;
            Integer n15 = n11;
            objectArray[n10] = n15;
            object = "rationMode out of range,rationMode:%d,mim:%d,max:%d";
            a.i((String)object, objectArray);
        }
        return n13 != 0;
    }

    public static boolean j(long l10, long l11, long l12) {
        long l13 = 0L;
        long l14 = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1);
        int n10 = 1;
        l14 = l14 >= 0 && (l14 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1)) < 0 && (l14 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1)) <= 0 ? (long)0 : (long)n10;
        if (l14 != false) {
            Object object;
            int n11 = 3;
            Object[] objectArray = new Object[n11];
            objectArray[0] = object = Long.valueOf(l10);
            objectArray[n10] = object = Long.valueOf(l11);
            int n12 = 2;
            Long l15 = l12;
            objectArray[n12] = l15;
            object = "time out of range,startTime:%d,endTime:%d,duration:%d";
            a.i((String)object, objectArray);
        }
        return (boolean)l14;
    }

    public static boolean k(float f10) {
        int n10 = Float.compare(f10, 0.0f);
        float f11 = 1.0f;
        int n11 = 1;
        n10 = n10 >= 0 && (n10 = Float.compare(f10, f11)) <= 0 ? 0 : n11;
        if (n10 != 0) {
            Object object;
            int n12 = 3;
            Object[] objectArray = new Object[n12];
            objectArray[0] = object = Float.valueOf(f10);
            objectArray[n11] = object = Integer.valueOf(0);
            int n13 = 2;
            f10 = 2.8E-45f;
            Float f12 = Float.valueOf(f11);
            objectArray[n13] = f12;
            object = "volume out of range,volume:%f,min volume:%f,max volume:%f";
            a.i((String)object, objectArray);
        }
        return n10 != 0;
    }

    public static boolean l(float f10, float f11, boolean n10) {
        int n11 = b.k(f10);
        int n12 = 1;
        if (n11 != 0) {
            return n12 != 0;
        }
        n11 = b.k(f11);
        if (n11 != 0) {
            return n12 != 0;
        }
        n11 = Float.compare(f10, f11);
        int n13 = 2;
        if (n11 == 0) {
            Object[] objectArray = new Object[n13];
            Float f12 = Float.valueOf(f10);
            objectArray[0] = f12;
            f12 = Float.valueOf(f11);
            objectArray[n12] = f12;
            a.i("startVolume:%s is same to endVolume:%s", objectArray);
            return false;
        }
        n11 = n11 > 0 ? n12 : 0;
        if ((n11 = n11 != n10 ? n12 : 0) != 0) {
            Object object;
            int n14 = 3;
            Object[] objectArray = new Object[n14];
            objectArray[0] = object = Float.valueOf(f10);
            objectArray[n12] = object = Float.valueOf(f11);
            objectArray[n13] = object = Boolean.valueOf(n10 != 0);
            object = "startVolume:%s and endVolume:%s is not equal to desc:%s";
            a.i((String)object, objectArray);
        }
        return n11 != 0;
    }

    public static boolean m(int n10) {
        int n11 = 6;
        int n12 = 1;
        int n13 = n10 >= 0 && n10 <= n11 ? 0 : n12;
        if (n13 != 0) {
            Object object;
            int n14 = 3;
            Object[] objectArray = new Object[n14];
            objectArray[0] = object = Integer.valueOf(n10);
            objectArray[n12] = object = Integer.valueOf(0);
            n10 = 2;
            Integer n15 = n11;
            objectArray[n10] = n15;
            object = "zoomMode out of range,zoomMode:%d,mim:%d,max:%d";
            a.i((String)object, objectArray);
        }
        return n13 != 0;
    }

    public static float n(int n10) {
        return (float)n10 * 1.0f / 5.0f;
    }

    public static int o(float f10) {
        return (int)(f10 * 5.0f);
    }

    public static String p(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            String string3 = "assets:/";
            String string4 = "file:///android_asset/";
            string2 = string2.replaceFirst(string3, string4);
        }
        return string2;
    }
}

