/*
 * Decompiled with CFR 0.151.
 */
package d.i.a.a.c;

import d.i.a.a.c.a;

public class b
extends a {
    private String a;
    private String b;
    private String c = "";
    private String d;
    private String e;
    private String f;
    private int g;

    public int getType() {
        return 4103;
    }

    public String i() {
        return this.b;
    }

    public String j() {
        return this.e;
    }

    public String k() {
        return this.f;
    }

    public String l() {
        return this.a;
    }

    public int m() {
        return this.g;
    }

    public String n() {
        return this.c;
    }

    public String o() {
        return this.d;
    }

    public void p(String string2) {
        this.b = string2;
    }

    public void q(String string2) {
        this.e = string2;
    }

    public void r(String string2) {
        this.f = string2;
    }

    public void s(String string2) {
        this.a = string2;
    }

    public void t(int n10) {
        this.g = n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataMessage{mMessageID='");
        String string2 = this.a;
        stringBuilder.append(string2);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append("mAppPackage='");
        String string3 = this.b;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", mTaskID='");
        string3 = this.c;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append("mTitle='");
        string3 = this.d;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append("mNotifyID='");
        int n10 = this.g;
        stringBuilder.append(n10);
        stringBuilder.append(c10);
        stringBuilder.append(", mContent='");
        string3 = this.e;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", mDescription='");
        string3 = this.f;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void u(int n10) {
        String string2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n10);
        stringBuilder.append("");
        this.c = string2 = stringBuilder.toString();
    }

    public void v(String string2) {
        this.c = string2;
    }

    public void w(String string2) {
        this.d = string2;
    }
}

