/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.io.ByteSource;
import com.google.common.io.CharSource;
import com.google.common.io.LineProcessor;
import com.google.common.io.Resources$1;
import com.google.common.io.Resources$UrlByteSource;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

public final class Resources {
    private Resources() {
    }

    public static ByteSource asByteSource(URL uRL) {
        Resources$UrlByteSource resources$UrlByteSource = new Resources$UrlByteSource(uRL, null);
        return resources$UrlByteSource;
    }

    public static CharSource asCharSource(URL uRL, Charset charset) {
        return Resources.asByteSource(uRL).asCharSource(charset);
    }

    public static void copy(URL uRL, OutputStream outputStream) {
        Resources.asByteSource(uRL).copyTo(outputStream);
    }

    public static URL getResource(Class object, String string2) {
        URL uRL = ((Class)object).getResource(string2);
        boolean bl2 = uRL != null;
        object = ((Class)object).getName();
        Preconditions.checkArgument(bl2, "resource %s relative to %s not found.", (Object)string2, object);
        return uRL;
    }

    public static URL getResource(String string2) {
        boolean bl2;
        Object object = Thread.currentThread().getContextClassLoader();
        ClassLoader classLoader = Resources.class.getClassLoader();
        if ((object = ((ClassLoader)MoreObjects.firstNonNull(object, classLoader)).getResource(string2)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            classLoader = null;
        }
        Preconditions.checkArgument(bl2, "resource %s not found.", (Object)string2);
        return object;
    }

    public static Object readLines(URL uRL, Charset charset, LineProcessor lineProcessor) {
        return Resources.asCharSource(uRL, charset).readLines(lineProcessor);
    }

    public static List readLines(URL uRL, Charset charset) {
        Resources$1 resources$1 = new Resources$1();
        return (List)Resources.readLines(uRL, charset, resources$1);
    }

    public static byte[] toByteArray(URL uRL) {
        return Resources.asByteSource(uRL).read();
    }

    public static String toString(URL uRL, Charset charset) {
        return Resources.asCharSource(uRL, charset).read();
    }
}

