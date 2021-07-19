/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.api.entity.template;

import com.zhiyun.editortemplate.data.api.entity.template.Global;
import java.util.List;

public class EditorProtocol {
    private Global global;
    private String resPath;
    private List slices;
    private int type;
    private int version;

    public EditorProtocol(int n10, int n11, Global global, List list) {
        this.version = n10;
        this.type = n11;
        this.global = global;
        this.slices = list;
    }

    public Global getGlobal() {
        return this.global;
    }

    public String getResPath() {
        return this.resPath;
    }

    public List getSlices() {
        return this.slices;
    }

    public int getType() {
        return this.type;
    }

    public int getVersion() {
        return this.version;
    }

    public void setGlobal(Global global) {
        this.global = global;
    }

    public void setResPath(String string2) {
        this.resPath = string2;
    }

    public void setSlices(List list) {
        this.slices = list;
    }

    public void setType(int n10) {
        this.type = n10;
    }

    public void setVersion(int n10) {
        this.version = n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("EditorProtocol{version=");
        int n10 = this.version;
        stringBuilder.append(n10);
        stringBuilder.append(", type=");
        n10 = this.type;
        stringBuilder.append(n10);
        stringBuilder.append(", global=");
        Object object = this.global;
        stringBuilder.append(object);
        stringBuilder.append(", slices=");
        object = this.slices;
        stringBuilder.append(object);
        stringBuilder.append(", resPath='");
        object = this.resPath;
        stringBuilder.append((String)object);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

