/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.gson;

import cn.leancloud.gson.GSONParser;
import cn.leancloud.gson.GsonWrapper;
import cn.leancloud.json.ConverterFactory;
import cn.leancloud.json.JSONParser;
import k.h$a;
import k.y.a.a;

public class GSONConverterFactory
implements ConverterFactory {
    public JSONParser createJSONParser() {
        GSONParser gSONParser = new GSONParser();
        return gSONParser;
    }

    public h$a generateRetrofitConverterFactory() {
        return a.b(GsonWrapper.getGsonInstance());
    }
}

