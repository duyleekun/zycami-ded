/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.net.stringconvert;

import com.zhiyun.net.stringconvert.StringRequestBodyConverter;
import com.zhiyun.net.stringconvert.StringResponseBodyConverter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import k.h;
import k.h$a;
import k.s;

public class StringConverterFactory
extends h$a {
    private StringConverterFactory() {
    }

    public static StringConverterFactory create() {
        StringConverterFactory stringConverterFactory = new StringConverterFactory();
        return stringConverterFactory;
    }

    public h requestBodyConverter(Type object, Annotation[] annotationArray, Annotation[] annotationArray2, s s10) {
        object = new StringRequestBodyConverter();
        return object;
    }

    public h responseBodyConverter(Type object, Annotation[] annotationArray, s s10) {
        object = new StringResponseBodyConverter();
        return object;
    }
}

