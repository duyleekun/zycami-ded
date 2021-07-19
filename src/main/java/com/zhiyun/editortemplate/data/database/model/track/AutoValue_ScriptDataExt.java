/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.track;

import com.zhiyun.editortemplate.data.database.model.track.ScriptDataExt;

public final class AutoValue_ScriptDataExt
extends ScriptDataExt {
    private final int protocol;
    private final int status;
    private final int version;

    public AutoValue_ScriptDataExt(int n10, int n11, int n12) {
        this.status = n10;
        this.protocol = n11;
        this.version = n12;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n10 = object instanceof ScriptDataExt;
        if (n10 != 0) {
            int n11;
            n10 = this.status;
            int n12 = ((ScriptDataExt)(object = (ScriptDataExt)object)).getStatus();
            if (n10 != n12 || (n10 = this.protocol) != (n12 = ((ScriptDataExt)object).getProtocol()) || (n10 = this.version) != (n11 = ((ScriptDataExt)object).getVersion())) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public int getProtocol() {
        return this.protocol;
    }

    public int getStatus() {
        return this.status;
    }

    public int getVersion() {
        return this.version;
    }

    public int hashCode() {
        int n10 = this.status;
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        int n12 = this.protocol;
        n10 = (n10 ^ n12) * n11;
        n11 = this.version;
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ScriptDataExt{status=");
        int n10 = this.status;
        stringBuilder.append(n10);
        stringBuilder.append(", protocol=");
        n10 = this.protocol;
        stringBuilder.append(n10);
        stringBuilder.append(", version=");
        n10 = this.version;
        stringBuilder.append(n10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

