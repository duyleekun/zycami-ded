/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.editortemplate.data.api.entity.track;

import com.zhiyun.editortemplate.data.api.entity.template.TemplateInfoData;

public class ScriptInfoData
extends TemplateInfoData {
    private int protocol;
    private int status;
    private int version;

    public int getProtocol() {
        return this.protocol;
    }

    public int getStatus() {
        return this.status;
    }

    public int getVersion() {
        return this.version;
    }

    public ScriptInfoData setProtocol(int n10) {
        this.protocol = n10;
        return this;
    }

    public ScriptInfoData setStatus(int n10) {
        this.status = n10;
        return this;
    }

    public ScriptInfoData setVersion(int n10) {
        this.version = n10;
        return this;
    }
}

