/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk;

public class az {
    public Object a;
    public Object b;

    public az(Object object, Object object2) {
        this.a = object;
        this.b = object2;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof az;
        if (!bl3) {
            return false;
        }
        try {
            boolean bl4;
            object = (az)object;
            Object object2 = this.a;
            Object object3 = ((az)object).a;
            bl3 = object2.equals(object3);
            if (!bl3 || !(bl4 = (object2 = this.b).equals(object = ((az)object).b))) {
                bl2 = false;
            }
            return bl2;
        }
        catch (Exception exception) {
            return false;
        }
    }

    public int hashCode() {
        int n10 = (this.a.hashCode() + 527) * 31;
        int n11 = this.b.hashCode();
        return n10 + n11;
    }
}

