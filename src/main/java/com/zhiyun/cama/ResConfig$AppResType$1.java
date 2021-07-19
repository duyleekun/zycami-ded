/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama;

import com.zhiyun.cama.ResConfig$AppResType;
import java.io.File;

public final class ResConfig$AppResType$1
extends ResConfig$AppResType {
    public ResConfig$AppResType$1(String string3) {
    }

    public String getDirName() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("app_assets");
        String string2 = File.separator;
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

