/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.model;

import java.io.Serializable;

public class Owner
implements Serializable {
    private static final long serialVersionUID = -1942759024112448066L;
    private String displayName;
    private String id;

    public Owner() {
        this(null, null);
    }

    public Owner(String string2, String string3) {
        this.id = string2;
        this.displayName = string3;
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof Owner;
        boolean bl4 = false;
        if (!bl3) {
            return false;
        }
        object = (Owner)object;
        String string2 = ((Owner)object).getId();
        object = ((Owner)object).getDisplayName();
        String string3 = this.getId();
        String string4 = this.getDisplayName();
        String string5 = "";
        if (string2 == null) {
            string2 = string5;
        }
        if (object == null) {
            object = string5;
        }
        if (string3 == null) {
            string3 = string5;
        }
        if (string4 == null) {
            string4 = string5;
        }
        if ((bl3 = string2.equals(string3)) && (bl2 = ((String)object).equals(string4))) {
            bl4 = true;
        }
        return bl4;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getId() {
        return this.id;
    }

    public int hashCode() {
        String string2 = this.id;
        if (string2 != null) {
            return string2.hashCode();
        }
        return 0;
    }

    public void setDisplayName(String string2) {
        this.displayName = string2;
    }

    public void setId(String string2) {
        this.id = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Owner [name=");
        String string2 = this.getDisplayName();
        stringBuilder.append(string2);
        stringBuilder.append(",id=");
        string2 = this.getId();
        stringBuilder.append(string2);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

