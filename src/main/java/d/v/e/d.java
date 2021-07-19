/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.KeyCharacterMap$UnavailableException
 */
package d.v.e;

import android.content.Context;
import android.view.KeyCharacterMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class d {
    public static void a(Context context, String string2) {
        context = context.getSharedPreferences(string2, 0).edit();
        context.clear();
        context.apply();
    }

    public static boolean b(Context context, String string2, String string3) {
        return context.getSharedPreferences(string2, 0).contains(string3);
    }

    public static boolean c(Context context, String string2, String string3) {
        return d.d(context, string2, string3, false);
    }

    public static boolean d(Context context, String string2, String string3, boolean bl2) {
        return context.getSharedPreferences(string2, 0).getBoolean(string3, bl2);
    }

    public static float e(Context context, String string2, String string3) {
        return d.f(context, string2, string3, 0.0f);
    }

    public static float f(Context context, String string2, String string3, float f10) {
        return context.getSharedPreferences(string2, 0).getFloat(string3, f10);
    }

    public static int g(Context context, String string2, String string3) {
        return d.h(context, string2, string3, 0);
    }

    public static int h(Context context, String string2, String string3, int n10) {
        return context.getSharedPreferences(string2, 0).getInt(string3, n10);
    }

    public static long i(Context context, String string2, String string3) {
        return d.j(context, string2, string3, 0L);
    }

    public static long j(Context context, String string2, String string3, long l10) {
        return context.getSharedPreferences(string2, 0).getLong(string3, l10);
    }

    public static String l(Context context, String string2, String string3) {
        return d.m(context, string2, string3, null);
    }

    public static String m(Context context, String string2, String string3, String string4) {
        return context.getSharedPreferences(string2, 0).getString(string3, string4);
    }

    public static Set n(Context context, String string2, String string3) {
        return d.o(context, string2, string3, null);
    }

    public static Set o(Context context, String string2, String string3, Set set) {
        return context.getSharedPreferences(string2, 0).getStringSet(string3, set);
    }

    public static void q(Context context, String string2, String string3) {
        context = context.getSharedPreferences(string2, 0).edit();
        context.remove(string3);
        context.apply();
    }

    public static void s(Context context, String string2, String string3, boolean bl2) {
        context = context.getSharedPreferences(string2, 0).edit();
        context.putBoolean(string3, bl2);
        context.apply();
    }

    public static void t(Context context, String string2, String string3, float f10) {
        context = context.getSharedPreferences(string2, 0).edit();
        context.putFloat(string3, f10);
        context.apply();
    }

    public static void u(Context context, String string2, String string3, int n10) {
        context = context.getSharedPreferences(string2, 0).edit();
        context.putInt(string3, n10);
        context.apply();
    }

    public static void v(Context context, String string2, String string3, long l10) {
        context = context.getSharedPreferences(string2, 0).edit();
        context.putLong(string3, l10);
        context.apply();
    }

    public static void w(Context context, String object, Map map) {
        boolean bl2 = false;
        String string2 = null;
        context = context.getSharedPreferences((String)((Object)object), 0).edit();
        object = map.keySet().iterator();
        while (bl2 = object.hasNext()) {
            int n10;
            string2 = (String)object.next();
            Object object2 = map.get(string2);
            boolean bl3 = object2 instanceof Boolean;
            if (bl3) {
                object2 = (Boolean)object2;
                n10 = ((Boolean)object2).booleanValue();
                context.putBoolean(string2, n10 != 0);
                continue;
            }
            bl3 = object2 instanceof String;
            if (bl3) {
                object2 = (String)object2;
                context.putString(string2, (String)object2);
                continue;
            }
            bl3 = object2 instanceof Integer;
            if (bl3) {
                object2 = (Integer)object2;
                n10 = (Integer)object2;
                context.putInt(string2, n10);
                continue;
            }
            bl3 = object2 instanceof Long;
            if (bl3) {
                object2 = (Long)object2;
                long l10 = (Long)object2;
                context.putLong(string2, l10);
                continue;
            }
            bl3 = object2 instanceof Float;
            if (bl3) {
                object2 = (Float)object2;
                float f10 = ((Float)object2).floatValue();
                context.putFloat(string2, f10);
                continue;
            }
            bl3 = object2 instanceof Set;
            if (bl3) {
                object2 = (Set)object2;
                context.putStringSet(string2, (Set)object2);
                continue;
            }
            context = new KeyCharacterMap.UnavailableException("unvalid param:keyValue");
            throw context;
        }
        context.apply();
    }

    public static void x(Context context, String string2, String string3, String string4) {
        context = context.getSharedPreferences(string2, 0).edit();
        context.putString(string3, string4);
        context.apply();
    }

    public static void y(Context context, String string2, String string3, Set set) {
        context = context.getSharedPreferences(string2, 0).edit();
        context.putStringSet(string3, set);
        context.apply();
    }

    public List k(Context context, String string2, String string3) {
        ArrayList<StringBuilder> arrayList = new ArrayList<StringBuilder>();
        CharSequence charSequence = new StringBuilder();
        charSequence.append(string3);
        charSequence.append("size");
        charSequence = charSequence.toString();
        int n10 = d.h(context, string2, (String)charSequence, 0);
        for (int i10 = 0; i10 < n10; ++i10) {
            CharSequence charSequence2 = new StringBuilder();
            charSequence2.append(string3);
            charSequence2.append(i10);
            charSequence2 = charSequence2.toString();
            charSequence2 = d.m(context, string2, (String)charSequence2, null);
            arrayList.add((StringBuilder)charSequence2);
        }
        return arrayList;
    }

    public void p(Context context, String string2, String string3, List list) {
        if (list == null) {
            return;
        }
        this.r(context, string2, string3);
        int n10 = list.size();
        CharSequence charSequence = new StringBuilder();
        charSequence.append(string3);
        CharSequence charSequence2 = "size";
        charSequence.append((String)charSequence2);
        charSequence = charSequence.toString();
        d.u(context, string2, (String)charSequence, n10);
        charSequence = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append(string3);
            ((StringBuilder)charSequence2).append(i10);
            charSequence2 = ((StringBuilder)charSequence2).toString();
            String string4 = (String)list.get(i10);
            d.x(context, string2, (String)charSequence2, string4);
        }
    }

    public void r(Context context, String string2, String string3) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append(string3);
        CharSequence charSequence2 = "size";
        charSequence.append((String)charSequence2);
        charSequence = charSequence.toString();
        int n10 = d.h(context, string2, (String)charSequence, 0);
        if (n10 == 0) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string3);
        stringBuilder.append((String)charSequence2);
        charSequence2 = stringBuilder.toString();
        d.q(context, string2, (String)charSequence2);
        for (int i10 = 0; i10 < n10; ++i10) {
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append(string3);
            ((StringBuilder)charSequence2).append(i10);
            charSequence2 = ((StringBuilder)charSequence2).toString();
            d.q(context, string2, (String)charSequence2);
        }
    }
}

