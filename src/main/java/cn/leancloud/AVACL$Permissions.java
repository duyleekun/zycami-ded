/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import java.util.HashMap;

public class AVACL$Permissions
extends HashMap {
    public AVACL$Permissions() {
    }

    public AVACL$Permissions(AVACL$Permissions object) {
        boolean bl2;
        Boolean bl3 = Boolean.TRUE;
        if (object == null) {
            return;
        }
        boolean bl4 = ((AVACL$Permissions)object).getReadPermission();
        if (bl4) {
            String string2 = "read";
            this.put(string2, bl3);
        }
        if (bl2 = ((AVACL$Permissions)object).getWritePermission()) {
            object = "write";
            this.put(object, bl3);
        }
    }

    public AVACL$Permissions(HashMap serializable) {
        boolean bl2;
        boolean bl3;
        Boolean bl4 = Boolean.FALSE;
        if (serializable == null) {
            return;
        }
        String string2 = "read";
        Object object = serializable.get(string2);
        String string3 = "write";
        serializable = serializable.get(string3);
        if (object != null && (bl3 = object instanceof Boolean)) {
            object = (Boolean)object;
            this.put(string2, object);
        } else {
            this.put(string2, bl4);
        }
        if (serializable != null && (bl2 = serializable instanceof Boolean)) {
            serializable = (Boolean)serializable;
            this.put(string3, serializable);
        } else {
            this.put(string3, bl4);
        }
    }

    public AVACL$Permissions(boolean bl2, boolean bl3) {
        Boolean bl4;
        if (bl2) {
            bl4 = bl2;
            String string2 = "read";
            this.put(string2, bl4);
        }
        if (bl3) {
            bl4 = bl3;
            String string3 = "write";
            this.put(string3, bl4);
        }
    }

    public boolean getReadPermission() {
        String string2 = "read";
        boolean bl2 = this.containsKey(string2);
        if (bl2) {
            return (Boolean)this.get(string2);
        }
        return false;
    }

    public boolean getWritePermission() {
        String string2 = "write";
        boolean bl2 = this.containsKey(string2);
        if (bl2) {
            return (Boolean)this.get(string2);
        }
        return false;
    }
}

