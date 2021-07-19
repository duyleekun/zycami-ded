/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.Color
 *  android.text.TextUtils
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package l.a.j.a;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.text.TextUtils;
import java.util.ArrayList;
import l.a.j.a.a$a;
import l.a.j.a.e;
import l.a.j.a.f;
import org.json.JSONException;
import org.json.JSONObject;
import skin.support.exception.SkinCompatException;

public final class a {
    private static final String o = "ColorState";
    public boolean a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;

    public a(String object, String string2) {
        this.b = object;
        this.n = string2;
        this.a = true;
        object = "#";
        boolean bl2 = string2.startsWith((String)object);
        if (bl2) {
            return;
        }
        object = new SkinCompatException("Default color cannot be a reference, when only default color is available!");
        throw object;
    }

    public a(String object, String string2, String string3, String string4, String string5, String string6, String string7, String string8, String string9, String string10, String string11, String string12) {
        this.c = object;
        this.d = string2;
        this.e = string3;
        this.f = string4;
        this.g = string5;
        this.h = string6;
        this.i = string7;
        this.j = string8;
        this.k = string9;
        this.l = string10;
        this.m = string11;
        this.n = string12;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2 && (bl2 = TextUtils.isEmpty((CharSequence)string2)) && (bl2 = TextUtils.isEmpty((CharSequence)string3)) && (bl2 = TextUtils.isEmpty((CharSequence)string4)) && (bl2 = TextUtils.isEmpty((CharSequence)string5)) && (bl2 = TextUtils.isEmpty((CharSequence)string6)) && (bl2 = TextUtils.isEmpty((CharSequence)string7)) && (bl2 = TextUtils.isEmpty((CharSequence)string8)) && (bl2 = TextUtils.isEmpty((CharSequence)string9)) && (bl2 = TextUtils.isEmpty((CharSequence)string10)) && (bl2 = TextUtils.isEmpty((CharSequence)string11))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        this.a = bl2;
        if (bl2 && !(bl2 = string12.startsWith((String)(object = "#")))) {
            object = new SkinCompatException("Default color cannot be a reference, when only default color is available!");
            throw object;
        }
    }

    public static boolean a(String string2, String string3) {
        int n10;
        String string4;
        int n11 = TextUtils.isEmpty((CharSequence)string3);
        if (n11 == 0 && ((n11 = string3.startsWith(string4 = "#")) == 0 || (n11 = string3.length()) == (n10 = 7) || (n11 = string3.length()) == (n10 = 9))) {
            n11 = 1;
        } else {
            n11 = 0;
            string4 = null;
        }
        n10 = l.a.o.f.a;
        if (n10 != 0 && n11 == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String string5 = "Invalid color -> ";
            stringBuilder.append(string5);
            stringBuilder.append(string2);
            stringBuilder.append(": ");
            stringBuilder.append(string3);
            string2 = stringBuilder.toString();
            string3 = o;
            l.a.o.f.b(string3, string2);
        }
        return n11 != 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a b(JSONObject object) {
        String string2 = "colorDragHovered";
        String string3 = "colorDragCanAccept";
        String string4 = "colorHovered";
        String string5 = "colorAccelerated";
        String string6 = "colorActivated";
        String string7 = "colorChecked";
        String string8 = "colorPressed";
        String string9 = "colorEnabled";
        String string10 = "colorFocused";
        String string11 = "colorSelected";
        String string12 = "colorWindowFocused";
        String string13 = "colorName";
        boolean bl2 = object.has(string13);
        if (!bl2) return null;
        String string14 = "colorDefault";
        boolean bl3 = object.has(string14);
        if (!bl3) return null;
        Object object2 = "onlyDefaultColor";
        boolean bl4 = object.has((String)object2);
        if (!bl4) return null;
        try {
            boolean bl5;
            boolean bl6;
            boolean bl7;
            boolean bl8;
            boolean bl9;
            boolean bl10;
            boolean bl11;
            boolean bl12;
            boolean bl13;
            boolean bl14;
            bl3 = object.getBoolean((String)object2);
            string13 = object.getString(string13);
            string14 = object.getString(string14);
            if (bl3) {
                return new a(string13, string14);
            }
            object2 = new a$a();
            ((a$a)object2).i(string14);
            bl2 = object.has(string12);
            if (bl2) {
                string12 = object.getString(string12);
                ((a$a)object2).y(string12);
            }
            if (bl14 = object.has(string11)) {
                string11 = object.getString(string11);
                ((a$a)object2).w(string11);
            }
            if (bl13 = object.has(string10)) {
                string10 = object.getString(string10);
                ((a$a)object2).q(string10);
            }
            if (bl12 = object.has(string9)) {
                string9 = object.getString(string9);
                ((a$a)object2).o(string9);
            }
            if (bl11 = object.has(string8)) {
                string8 = object.getString(string8);
                ((a$a)object2).u(string8);
            }
            if (bl10 = object.has(string7)) {
                string7 = object.getString(string7);
                ((a$a)object2).g(string7);
            }
            if (bl9 = object.has(string6)) {
                string6 = object.getString(string6);
                ((a$a)object2).e(string6);
            }
            if (bl8 = object.has(string5)) {
                string5 = object.getString(string5);
                ((a$a)object2).c(string5);
            }
            if (bl7 = object.has(string4)) {
                string4 = object.getString(string4);
                ((a$a)object2).s(string4);
            }
            if (bl6 = object.has(string3)) {
                string3 = object.getString(string3);
                ((a$a)object2).k(string3);
            }
            if (bl5 = object.has(string2)) {
                String string15 = object.getString(string2);
                ((a$a)object2).m(string15);
            }
            a a10 = ((a$a)object2).a();
            a10.b = string13;
            return a10;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        return null;
    }

    private String o(String string2) {
        Object object = "#";
        boolean bl2 = string2.startsWith((String)object);
        if (bl2) {
            return string2;
        }
        object = l.a.j.a.f.n().r(string2);
        if (object != null) {
            boolean bl3 = ((a)object).q();
            if (bl3) {
                return ((a)object).n;
            }
            bl3 = l.a.o.f.a;
            if (bl3) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append(" cannot reference ");
                string2 = ((a)object).b;
                stringBuilder.append(string2);
                string2 = stringBuilder.toString();
                object = o;
                l.a.o.f.b((String)object, string2);
            }
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private ColorStateList s() {
        int[] nArray;
        boolean bl2;
        Object object;
        int n10;
        int n11;
        int n12;
        Object object2;
        Object object3;
        block50: {
            Object object4;
            block49: {
                object3 = new ArrayList();
                object2 = new ArrayList();
                object4 = this.c;
                n12 = TextUtils.isEmpty((CharSequence)object4);
                n11 = 0;
                if (n12 == 0) {
                    try {
                        object4 = this.c;
                        object4 = this.o((String)object4);
                        n10 = TextUtils.isEmpty((CharSequence)object4);
                        if (n10 != 0) break block49;
                        n12 = Color.parseColor((String)object4);
                        object = l.a.j.a.e.d;
                        object3.add(object);
                        object4 = n12;
                        object2.add(object4);
                        n12 = 1;
                        break block50;
                    }
                    catch (Exception exception) {}
                }
            }
            n12 = 0;
            object4 = null;
        }
        object = this.d;
        n10 = TextUtils.isEmpty((CharSequence)object);
        if (n10 == 0) {
            try {
                object = this.d;
                object = this.o((String)object);
                bl2 = TextUtils.isEmpty((CharSequence)object);
                if (!bl2) {
                    n10 = Color.parseColor((String)object);
                    nArray = l.a.j.a.e.m;
                    object3.add(nArray);
                    object = n10;
                    object2.add(object);
                    ++n12;
                }
            }
            catch (Exception exception) {}
        }
        if ((n10 = TextUtils.isEmpty((CharSequence)(object = this.e))) == 0) {
            try {
                object = this.e;
                object = this.o((String)object);
                bl2 = TextUtils.isEmpty((CharSequence)object);
                if (!bl2) {
                    n10 = Color.parseColor((String)object);
                    nArray = l.a.j.a.e.e;
                    object3.add(nArray);
                    object = n10;
                    object2.add(object);
                    ++n12;
                }
            }
            catch (Exception exception) {}
        }
        if ((n10 = TextUtils.isEmpty((CharSequence)(object = this.f))) == 0) {
            try {
                object = this.f;
                object = this.o((String)object);
                bl2 = TextUtils.isEmpty((CharSequence)object);
                if (!bl2) {
                    n10 = Color.parseColor((String)object);
                    nArray = l.a.j.a.e.c;
                    object3.add(nArray);
                    object = n10;
                    object2.add(object);
                    ++n12;
                }
            }
            catch (Exception exception) {}
        }
        if ((n10 = (int)(TextUtils.isEmpty((CharSequence)(object = this.g)) ? 1 : 0)) == 0) {
            try {
                object = this.g;
                object = this.o((String)object);
                bl2 = TextUtils.isEmpty((CharSequence)object);
                if (!bl2) {
                    n10 = Color.parseColor((String)object);
                    nArray = l.a.j.a.e.k;
                    object3.add(nArray);
                    object = n10;
                    object2.add(object);
                    ++n12;
                }
            }
            catch (Exception exception) {}
        }
        if ((n10 = (int)(TextUtils.isEmpty((CharSequence)(object = this.h)) ? 1 : 0)) == 0) {
            try {
                object = this.h;
                object = this.o((String)object);
                bl2 = TextUtils.isEmpty((CharSequence)object);
                if (!bl2) {
                    n10 = Color.parseColor((String)object);
                    nArray = l.a.j.a.e.l;
                    object3.add(nArray);
                    object = n10;
                    object2.add(object);
                    ++n12;
                }
            }
            catch (Exception exception) {}
        }
        if ((n10 = (int)(TextUtils.isEmpty((CharSequence)(object = this.i)) ? 1 : 0)) == 0) {
            try {
                object = this.i;
                object = this.o((String)object);
                bl2 = TextUtils.isEmpty((CharSequence)object);
                if (!bl2) {
                    n10 = Color.parseColor((String)object);
                    nArray = l.a.j.a.e.f;
                    object3.add(nArray);
                    object = n10;
                    object2.add(object);
                    ++n12;
                }
            }
            catch (Exception exception) {}
        }
        if ((n10 = (int)(TextUtils.isEmpty((CharSequence)(object = this.j)) ? 1 : 0)) == 0) {
            try {
                object = this.j;
                object = this.o((String)object);
                bl2 = TextUtils.isEmpty((CharSequence)object);
                if (!bl2) {
                    n10 = Color.parseColor((String)object);
                    nArray = l.a.j.a.e.g;
                    object3.add(nArray);
                    object = n10;
                    object2.add(object);
                    ++n12;
                }
            }
            catch (Exception exception) {}
        }
        if ((n10 = (int)(TextUtils.isEmpty((CharSequence)(object = this.k)) ? 1 : 0)) == 0) {
            try {
                object = this.k;
                object = this.o((String)object);
                bl2 = TextUtils.isEmpty((CharSequence)object);
                if (!bl2) {
                    n10 = Color.parseColor((String)object);
                    nArray = l.a.j.a.e.h;
                    object3.add(nArray);
                    object = n10;
                    object2.add(object);
                    ++n12;
                }
            }
            catch (Exception exception) {}
        }
        if ((n10 = (int)(TextUtils.isEmpty((CharSequence)(object = this.l)) ? 1 : 0)) == 0) {
            try {
                object = this.l;
                object = this.o((String)object);
                bl2 = TextUtils.isEmpty((CharSequence)object);
                if (!bl2) {
                    n10 = Color.parseColor((String)object);
                    nArray = l.a.j.a.e.i;
                    object3.add(nArray);
                    object = n10;
                    object2.add(object);
                    ++n12;
                }
            }
            catch (Exception exception) {}
        }
        if ((n10 = (int)(TextUtils.isEmpty((CharSequence)(object = this.m)) ? 1 : 0)) == 0) {
            try {
                object = this.m;
                object = this.o((String)object);
                bl2 = TextUtils.isEmpty((CharSequence)object);
                if (!bl2) {
                    n10 = Color.parseColor((String)object);
                    nArray = l.a.j.a.e.j;
                    object3.add(nArray);
                    object = n10;
                    object2.add(object);
                    ++n12;
                }
            }
            catch (Exception exception) {}
        }
        try {
            object = this.n;
            object = this.o((String)object);
            bl2 = TextUtils.isEmpty((CharSequence)object);
            if (!bl2) {
                n10 = Color.parseColor((String)object);
                nArray = l.a.j.a.e.o;
                object3.add(nArray);
                object = n10;
                object2.add(object);
                ++n12;
            }
            object = new int[n12][];
            nArray = new int[n12];
            while (true) {
                int n13;
                if (n11 >= n12) {
                    return new ColorStateList((int[][])object, nArray);
                }
                Object object5 = object3.get(n11);
                object[n11] = object5 = (Object)((int[])object5);
                object5 = object2.get(n11);
                object5 = (Integer)object5;
                nArray[n11] = n13 = ((Integer)object5).intValue();
                ++n11;
            }
        }
        catch (Exception exception) {
            boolean bl3 = l.a.o.f.a;
            if (bl3) {
                object3 = new StringBuilder();
                object2 = this.b;
                ((StringBuilder)object3).append((String)object2);
                ((StringBuilder)object3).append(" parse failure.");
                object3 = ((StringBuilder)object3).toString();
                object2 = o;
                l.a.o.f.b((String)object2, (String)object3);
            }
            object3 = l.a.j.a.f.n();
            object2 = this.b;
            ((f)object3).B((String)object2);
            return null;
        }
    }

    public static JSONObject t(a object) {
        JSONObject jSONObject = new JSONObject();
        boolean bl2 = ((a)object).a;
        String string2 = "onlyDefaultColor";
        String string3 = "colorDefault";
        String string4 = "colorName";
        if (bl2) {
            String string5 = ((a)object).b;
            string5 = jSONObject.putOpt(string4, (Object)string5);
            string4 = ((a)object).n;
            string5 = string5.putOpt(string3, (Object)string4);
            boolean bl3 = ((a)object).a;
            object = bl3;
            string5.putOpt(string2, object);
        } else {
            String string6 = ((a)object).b;
            string6 = jSONObject.putOpt(string4, (Object)string6);
            string4 = ((a)object).c;
            string6 = string6.putOpt("colorWindowFocused", (Object)string4);
            string4 = ((a)object).d;
            string6 = string6.putOpt("colorSelected", (Object)string4);
            string4 = ((a)object).e;
            string6 = string6.putOpt("colorFocused", (Object)string4);
            string4 = ((a)object).f;
            string6 = string6.putOpt("colorEnabled", (Object)string4);
            string4 = ((a)object).g;
            string6 = string6.putOpt("colorPressed", (Object)string4);
            string4 = ((a)object).h;
            string6 = string6.putOpt("colorChecked", (Object)string4);
            string4 = ((a)object).i;
            string6 = string6.putOpt("colorActivated", (Object)string4);
            string4 = ((a)object).j;
            string6 = string6.putOpt("colorAccelerated", (Object)string4);
            string4 = ((a)object).k;
            string6 = string6.putOpt("colorHovered", (Object)string4);
            string4 = ((a)object).l;
            string6 = string6.putOpt("colorDragCanAccept", (Object)string4);
            string4 = ((a)object).m;
            String string7 = "colorDragHovered";
            string6 = string6.putOpt(string7, (Object)string4);
            string4 = ((a)object).n;
            string6 = string6.putOpt(string3, (Object)string4);
            boolean bl4 = ((a)object).a;
            object = bl4;
            string6.putOpt(string2, object);
        }
        return jSONObject;
    }

    public String c() {
        return this.j;
    }

    public String d() {
        return this.i;
    }

    public String e() {
        return this.h;
    }

    public String f() {
        return this.n;
    }

    public String g() {
        return this.l;
    }

    public String h() {
        return this.m;
    }

    public String i() {
        return this.f;
    }

    public String j() {
        return this.e;
    }

    public String k() {
        return this.k;
    }

    public String l() {
        return this.b;
    }

    public String m() {
        return this.g;
    }

    public String n() {
        return this.d;
    }

    public String p() {
        return this.c;
    }

    public boolean q() {
        return this.a;
    }

    public ColorStateList r() {
        boolean bl2 = this.a;
        if (bl2) {
            return ColorStateList.valueOf((int)Color.parseColor((String)this.n));
        }
        return this.s();
    }
}

