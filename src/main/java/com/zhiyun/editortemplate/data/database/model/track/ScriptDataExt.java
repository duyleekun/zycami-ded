/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.database.model.track;

import com.zhiyun.editortemplate.data.database.model.track.AutoValue_ScriptDataExt;

public abstract class ScriptDataExt {
    public static ScriptDataExt create(int n10, int n11, int n12) {
        AutoValue_ScriptDataExt autoValue_ScriptDataExt = new AutoValue_ScriptDataExt(n10, n11, n12);
        return autoValue_ScriptDataExt;
    }

    public ScriptDataExt clone() {
        int n10 = this.getStatus();
        int n11 = this.getProtocol();
        int n12 = this.getVersion();
        return ScriptDataExt.create(n10, n11, n12);
    }

    public abstract int getProtocol();

    public abstract int getStatus();

    public abstract int getVersion();
}

