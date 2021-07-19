/*
 * Decompiled with CFR 0.151.
 */
package okhttp3.logging;

import okhttp3.logging.HttpLoggingInterceptor$a$a;
import okhttp3.logging.HttpLoggingInterceptor$a$a$a;

public interface HttpLoggingInterceptor$a {
    public static final HttpLoggingInterceptor$a a;
    public static final HttpLoggingInterceptor$a$a b;

    static {
        Object object = new HttpLoggingInterceptor$a$a(null);
        b = object;
        a = object = new HttpLoggingInterceptor$a$a$a();
    }

    public void log(String var1);
}

