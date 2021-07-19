/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.v.z.o;

import android.text.TextUtils;
import com.zhiyun.remoteprotocol.constant.HeadCode;
import com.zhiyun.remoteprotocol.constant.ProtoType;
import d.v.z.o.a;
import d.v.z.o.b;
import d.v.z.o.c;
import d.v.z.o.d;
import d.v.z.o.e;
import d.v.z.o.h;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class i {
    public static ProtoType a(byte[] byArray) {
        int n10;
        int n11;
        if (byArray != null && (n11 = byArray.length) >= (n10 = 8)) {
            return ProtoType.getValue(h.d(byArray, n10, 2));
        }
        return ProtoType.NO_PROTO;
    }

    public static d.v.z.k.d b(byte[] byArray) {
        int n10;
        int n11;
        if (byArray != null && (n11 = byArray.length) >= (n10 = 4)) {
            n11 = 2;
            return d.v.z.k.d.c(h.d(byArray, n11, n11));
        }
        return null;
    }

    public static Optional c(Enum[] object, int n10) {
        int n11;
        if (object != null && (n11 = ((Enum[])object).length) != 0) {
            object = Arrays.stream(object);
            d d10 = new d(n10);
            return object.filter(d10).findFirst();
        }
        return Optional.empty();
    }

    public static Optional d(Enum[] object, byte[] byArray) {
        int n10;
        if (object != null && (n10 = ((Enum[])object).length) != 0) {
            object = Arrays.stream(object);
            a a10 = new a(byArray);
            return object.filter(a10).findFirst();
        }
        return Optional.empty();
    }

    public static boolean e(byte[] byArray) {
        int n10;
        int n11;
        if (byArray != null && (n11 = byArray.length) >= (n10 = 4)) {
            n11 = 2;
            byArray = h.d(byArray, n11, n11);
            byte[] byArray2 = d.v.z.k.d.a().getCodeByte();
            return Arrays.equals(byArray, byArray2);
        }
        return false;
    }

    public static boolean f(byte[] byArray) {
        int n10;
        int n11;
        byte[] byArray2 = null;
        if (byArray != null && (n11 = byArray.length) >= (n10 = 2)) {
            byArray = h.d(byArray, 0, n10);
            byArray2 = HeadCode.RECEIVER_CODE.getCodeByte();
            return Arrays.equals(byArray, byArray2);
        }
        return false;
    }

    public static /* synthetic */ boolean g(int n10, Enum object) {
        int n11 = (object = (d.v.z.k.c)object).getCode();
        n10 = n11 == n10 ? 1 : 0;
        return n10 != 0;
    }

    public static /* synthetic */ boolean h(byte[] byArray, Enum enum_) {
        return Arrays.equals(((d.v.z.k.c)((Object)enum_)).getCodeByte(), byArray);
    }

    public static /* synthetic */ void i(HashMap hashMap, String object) {
        int n10;
        String string2 = ":";
        int n11 = ((String[])(object = object.split(string2))).length;
        if (n11 == (n10 = 2)) {
            n11 = 0;
            string2 = object[0];
            n10 = 1;
            object = object[n10];
            hashMap.put(string2, object);
        }
    }

    public static /* synthetic */ void j(HashMap hashMap, String object) {
        int n10;
        Object object2 = ":";
        int n11 = ((String[])(object = object.split((String)object2))).length;
        if (n11 == (n10 = 2)) {
            n11 = 1;
            float f10 = Float.MIN_VALUE;
            object2 = object[n11];
            f10 = Float.parseFloat((String)object2);
            n10 = 0;
            object = object[0];
            object2 = Float.valueOf(f10);
            try {
                hashMap.put(object, object2);
            }
            catch (NumberFormatException numberFormatException) {
                numberFormatException.printStackTrace();
            }
        }
    }

    public static /* synthetic */ void k(HashMap hashMap, String object) {
        int n10;
        Object object2 = ":";
        int n11 = ((String[])(object = object.split((String)object2))).length;
        if (n11 == (n10 = 2)) {
            n11 = 1;
            object2 = object[n11];
            long l10 = Long.parseLong((String)object2);
            object = object[0];
            object2 = l10;
            try {
                hashMap.put(object, object2);
            }
            catch (NumberFormatException numberFormatException) {
                numberFormatException.printStackTrace();
            }
        }
    }

    public static Float l(String string2) {
        Float f10;
        block4: {
            f10 = null;
            try {
                boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
                if (bl2) break block4;
            }
            catch (NumberFormatException numberFormatException) {
                Object[] objectArray = new Object[]{string2};
                m.a.a.g(numberFormatException, "\u6570\u636e\u89e3\u6790\u5f02\u5e38\uff1a%s", objectArray);
                return null;
            }
            float f11 = Float.parseFloat(string2);
            f10 = Float.valueOf(f11);
        }
        return f10;
    }

    public static Integer m(String string2) {
        Integer n10;
        block4: {
            int n11;
            n10 = null;
            try {
                n11 = TextUtils.isEmpty((CharSequence)string2);
                if (n11 != 0) break block4;
            }
            catch (NumberFormatException numberFormatException) {
                Object[] objectArray = new Object[]{string2};
                m.a.a.e("\u6570\u636e\u89e3\u6790\u5f02\u5e38\uff1a%s", objectArray);
                return null;
            }
            n11 = Integer.parseInt(string2);
            n10 = n11;
        }
        return n10;
    }

    public static Long n(String string2) {
        Long l10;
        block4: {
            l10 = null;
            try {
                boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
                if (bl2) break block4;
            }
            catch (NumberFormatException numberFormatException) {
                Object[] objectArray = new Object[]{string2};
                m.a.a.e("\u6570\u636e\u89e3\u6790\u5f02\u5e38\uff1a%s", objectArray);
                return null;
            }
            long l11 = Long.parseLong(string2);
            l10 = l11;
        }
        return l10;
    }

    public static Map o(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        object = Arrays.stream(((String)object).split(","));
        e e10 = new e(hashMap);
        object.forEach(e10);
        return hashMap;
    }

    public static Map p(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        object = Arrays.stream(((String)object).split(","));
        b b10 = new b(hashMap);
        object.forEach(b10);
        return hashMap;
    }

    public static Map q(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        object = Arrays.stream(((String)object).split(","));
        c c10 = new c(hashMap);
        object.forEach(c10);
        return hashMap;
    }
}

