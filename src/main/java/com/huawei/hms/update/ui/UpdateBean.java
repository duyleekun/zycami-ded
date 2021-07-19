/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.update.ui;

import java.io.Serializable;
import java.util.ArrayList;

public class UpdateBean
implements Serializable {
    public boolean a;
    public String b;
    public int c;
    public String d;
    public String e;
    public ArrayList f;
    public boolean g = true;

    public static Object a(Object object) {
        return object;
    }

    public String a() {
        return (String)UpdateBean.a(this.d);
    }

    public String b() {
        return (String)UpdateBean.a(this.b);
    }

    public int c() {
        return (Integer)UpdateBean.a(this.c);
    }

    public boolean d() {
        return (Boolean)UpdateBean.a(this.a);
    }

    public String getClientAppName() {
        return (String)UpdateBean.a(this.e);
    }

    public ArrayList getTypeList() {
        return (ArrayList)UpdateBean.a(this.f);
    }

    public boolean isNeedConfirm() {
        return (Boolean)UpdateBean.a(this.g);
    }

    public void setClientAppId(String string2) {
        this.d = string2;
    }

    public void setClientAppName(String string2) {
        this.e = string2;
    }

    public void setClientPackageName(String string2) {
        this.b = string2;
    }

    public void setClientVersionCode(int n10) {
        this.c = n10;
    }

    public void setHmsOrApkUpgrade(boolean bl2) {
        this.a = bl2;
    }

    public void setNeedConfirm(boolean bl2) {
        this.g = bl2;
    }

    public void setTypeList(ArrayList arrayList) {
        this.f = arrayList;
    }
}

