/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.live.data.api.entity;

import com.zhiyun.live.data.api.entity.BaseReStreamInfo;
import com.zhiyun.live.data.api.entity.ReStreamPlatform$Images;

public class ReStreamPlatform
extends BaseReStreamInfo {
    public int id;
    public ReStreamPlatform$Images image;
    public String name;
    public String url;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ReStreamPlatform{id=");
        int c10 = this.id;
        stringBuilder.append(c10);
        stringBuilder.append(", name='");
        Object object = this.name;
        stringBuilder.append((String)object);
        char c11 = '\'';
        stringBuilder.append(c11);
        stringBuilder.append(", url='");
        String string2 = this.url;
        stringBuilder.append(string2);
        stringBuilder.append(c11);
        stringBuilder.append(", image=");
        object = this.image;
        stringBuilder.append(object);
        stringBuilder.append(", error=");
        object = this.error;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

