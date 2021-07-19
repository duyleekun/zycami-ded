/*
 * Decompiled with CFR 0.151.
 */
package androidx.navigation;

import java.util.ArrayList;

public class NavDeepLink$ParamQuery {
    private ArrayList mArguments;
    private String mParamRegex;

    public NavDeepLink$ParamQuery() {
        ArrayList arrayList;
        this.mArguments = arrayList = new ArrayList();
    }

    public void addArgumentName(String string2) {
        this.mArguments.add(string2);
    }

    public String getArgumentName(int n10) {
        return (String)this.mArguments.get(n10);
    }

    public String getParamRegex() {
        return this.mParamRegex;
    }

    public void setParamRegex(String string2) {
        this.mParamRegex = string2;
    }

    public int size() {
        return this.mArguments.size();
    }
}

