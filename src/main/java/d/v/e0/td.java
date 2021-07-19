/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.constants.Model;
import d.v.e0.td$a;

public class td {
    public final String a;
    public final Model b;
    public final Model c;
    public final String d;
    public final String e;
    public final float f;
    public final float g;

    public td(float f10, String string2, String string3, Model model, Model model2, String string4, float f11) {
        this.f = f10;
        this.a = string2;
        this.d = string3;
        this.b = model;
        this.c = model2;
        this.e = string4;
        this.g = f11;
    }

    public float a() {
        int[] nArray = td$a.a;
        Model model = this.b;
        int n10 = model.ordinal();
        int n11 = nArray[n10];
        if (n11 != (n10 = 9)) {
            return this.f;
        }
        return this.g;
    }

    public boolean b() {
        int[] nArray = td$a.a;
        Model model = this.b;
        int n10 = model.ordinal();
        int n11 = nArray[n10];
        switch (n11) {
            default: {
                return false;
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
        }
        return true;
    }

    public boolean c() {
        int[] nArray = td$a.a;
        Model model = this.b;
        int n10 = model.ordinal();
        int n11 = nArray[n10];
        return n11 == (n10 = 9);
    }

    public boolean d() {
        int[] nArray = td$a.a;
        Model model = this.b;
        int n10 = model.ordinal();
        int n11 = nArray[n10];
        return n11 == (n10 = 6) || n11 == (n10 = 7) || n11 == (n10 = 9);
    }

    public boolean e() {
        int[] nArray = td$a.a;
        Model model = this.b;
        int n10 = model.ordinal();
        int n11 = nArray[n10];
        switch (n11) {
            default: {
                return false;
            }
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
        }
        return true;
    }

    public boolean f() {
        int[] nArray = td$a.a;
        Model model = this.b;
        int n10 = model.ordinal();
        int n11 = nArray[n10];
        return n11 == (n10 = 13);
    }

    public boolean g() {
        return this.d();
    }

    public boolean h() {
        int[] nArray = td$a.a;
        Model model = this.b;
        int n10 = model.ordinal();
        int n11 = nArray[n10];
        switch (n11) {
            default: {
                return true;
            }
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
            case 6: 
            case 7: 
        }
        return false;
    }

    public boolean i() {
        float f10 = this.f;
        float f11 = 1.6f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object >= 0) {
            object = true;
            f10 = Float.MIN_VALUE;
        } else {
            object = false;
            f10 = 0.0f;
        }
        return (boolean)object;
    }

    public boolean j() {
        int[] nArray = td$a.a;
        Model model = this.b;
        int n10 = model.ordinal();
        int n11 = nArray[n10];
        switch (n11) {
            default: {
                return false;
            }
            case 16: 
            case 17: 
            case 18: 
        }
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DeviceInfo{name='");
        String string2 = this.a;
        stringBuilder.append(string2);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", model=");
        Object object = this.b;
        stringBuilder.append(object);
        stringBuilder.append(", host=");
        object = this.c;
        stringBuilder.append(object);
        stringBuilder.append(", address='");
        object = this.d;
        stringBuilder.append((String)object);
        stringBuilder.append(c10);
        stringBuilder.append(", makeInfo='");
        object = this.e;
        stringBuilder.append((String)object);
        stringBuilder.append(c10);
        stringBuilder.append(", version=");
        float f10 = this.f;
        stringBuilder.append(f10);
        stringBuilder.append(", wifiVersion=");
        f10 = this.g;
        stringBuilder.append(f10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

