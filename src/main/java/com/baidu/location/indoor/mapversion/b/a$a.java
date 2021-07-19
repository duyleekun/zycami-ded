/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.indoor.mapversion.b;

public class a$a {
    public double a;
    public double b;
    public double c;
    public double d;
    public double e;
    public double f;
    public double g;
    public double h;

    public a$a(String string2) {
        this.a(string2);
    }

    public void a(String stringArray) {
        double d10;
        stringArray = stringArray.trim().split("\\|");
        this.a = d10 = Double.valueOf(stringArray[0]).doubleValue();
        this.b = d10 = Double.valueOf(stringArray[1]).doubleValue();
        this.c = d10 = Double.valueOf(stringArray[2]).doubleValue();
        this.d = d10 = Double.valueOf(stringArray[3]).doubleValue();
        this.e = d10 = Double.valueOf(stringArray[4]).doubleValue();
        this.f = d10 = Double.valueOf(stringArray[5]).doubleValue();
        this.g = d10 = Double.valueOf(stringArray[6]).doubleValue();
        this.h = d10 = Double.valueOf(stringArray[7]).doubleValue();
    }
}

