/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.json;

import cn.leancloud.json.JSONParser;
import k.h$a;

public interface ConverterFactory {
    public JSONParser createJSONParser();

    public h$a generateRetrofitConverterFactory();
}

