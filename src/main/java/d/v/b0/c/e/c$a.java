/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package d.v.b0.c.e;

import android.graphics.Bitmap;
import d.v.b0.b.a;

public class c$a {
    public String a;
    public String b = "";
    public int c;
    public int d;
    public Bitmap e;

    public c$a(String string2, String string3, int n10, int n11) {
        this.a = string2;
        this.b = string3;
        this.c = n10;
        this.d = n11;
    }

    public static a a(c$a c$a) {
        int n10;
        int n11;
        String string2;
        a a10 = new a();
        a10.a = string2 = c$a.b;
        a10.b = n11 = c$a.c;
        a10.c = n10 = c$a.d;
        return a10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LutInfo{displayName='");
        String string2 = this.a;
        stringBuilder.append(string2);
        int n10 = 39;
        stringBuilder.append((char)n10);
        stringBuilder.append(", lutImageName='");
        String string3 = this.b;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append(", lutWidth=");
        n10 = this.c;
        stringBuilder.append(n10);
        stringBuilder.append(", lutHeight=");
        n10 = this.d;
        stringBuilder.append(n10);
        stringBuilder.append(", maskBitmap=");
        string2 = this.e;
        stringBuilder.append((Object)string2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

