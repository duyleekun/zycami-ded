/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.huawei.hms.ui;

import android.os.Bundle;
import com.huawei.hms.base.ui.a;

public class SafeBundle {
    public final Bundle a;

    public SafeBundle() {
        Bundle bundle = new Bundle();
        this(bundle);
    }

    public SafeBundle(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        this.a = bundle;
    }

    public boolean containsKey(String string2) {
        Bundle bundle;
        try {
            bundle = this.a;
        }
        catch (Exception exception) {
            com.huawei.hms.base.ui.a.a("SafeBundle", "containsKey exception. key:");
            return false;
        }
        return bundle.containsKey(string2);
    }

    public Object get(String string2) {
        Object object;
        try {
            object = this.a;
        }
        catch (Exception exception) {
            object = new StringBuilder();
            ((StringBuilder)object).append("get exception: ");
            String string3 = exception.getMessage();
            ((StringBuilder)object).append(string3);
            string3 = ((StringBuilder)object).toString();
            com.huawei.hms.base.ui.a.a("SafeBundle", string3, true);
            return null;
        }
        return object.get(string2);
    }

    public Bundle getBundle() {
        return this.a;
    }

    public int getInt(String string2) {
        return this.getInt(string2, 0);
    }

    public int getInt(String string2, int n10) {
        Object object;
        try {
            object = this.a;
        }
        catch (Exception exception) {
            object = new StringBuilder();
            ((StringBuilder)object).append("getInt exception: ");
            String string3 = exception.getMessage();
            ((StringBuilder)object).append(string3);
            string3 = ((StringBuilder)object).toString();
            com.huawei.hms.base.ui.a.a("SafeBundle", string3, true);
            return n10;
        }
        return object.getInt(string2, n10);
    }

    public String getString(String string2) {
        Object object;
        try {
            object = this.a;
        }
        catch (Exception exception) {
            object = new StringBuilder();
            ((StringBuilder)object).append("getString exception: ");
            String string3 = exception.getMessage();
            ((StringBuilder)object).append(string3);
            string3 = ((StringBuilder)object).toString();
            com.huawei.hms.base.ui.a.a("SafeBundle", string3, true);
            return "";
        }
        return object.getString(string2);
    }

    public String getString(String string2, String string3) {
        Object object;
        try {
            object = this.a;
        }
        catch (Exception exception) {
            object = new StringBuilder();
            ((StringBuilder)object).append("getString exception: ");
            String string4 = exception.getMessage();
            ((StringBuilder)object).append(string4);
            string4 = ((StringBuilder)object).toString();
            com.huawei.hms.base.ui.a.a("SafeBundle", string4, true);
            return string3;
        }
        return object.getString(string2, string3);
    }

    public boolean isEmpty() {
        Bundle bundle;
        try {
            bundle = this.a;
        }
        catch (Exception exception) {
            com.huawei.hms.base.ui.a.a("SafeBundle", "isEmpty exception");
            return true;
        }
        return bundle.isEmpty();
    }

    public int size() {
        Bundle bundle;
        try {
            bundle = this.a;
        }
        catch (Exception exception) {
            com.huawei.hms.base.ui.a.a("SafeBundle", "size exception");
            return 0;
        }
        return bundle.size();
    }

    public String toString() {
        return this.a.toString();
    }
}

