/*
 * Decompiled with CFR 0.151.
 */
package okhttp3.logging;

public final class HttpLoggingInterceptor$Level
extends Enum {
    public static final /* enum */ HttpLoggingInterceptor$Level BASIC;
    public static final /* enum */ HttpLoggingInterceptor$Level BODY;
    public static final /* enum */ HttpLoggingInterceptor$Level HEADERS;
    public static final /* enum */ HttpLoggingInterceptor$Level NONE;
    private static final /* synthetic */ HttpLoggingInterceptor$Level[] a;

    static {
        HttpLoggingInterceptor$Level httpLoggingInterceptor$Level;
        HttpLoggingInterceptor$Level[] httpLoggingInterceptor$LevelArray = new HttpLoggingInterceptor$Level[4];
        NONE = httpLoggingInterceptor$Level = new HttpLoggingInterceptor$Level("NONE", 0);
        httpLoggingInterceptor$LevelArray[0] = httpLoggingInterceptor$Level;
        int n10 = 1;
        BASIC = httpLoggingInterceptor$Level = new HttpLoggingInterceptor$Level("BASIC", n10);
        httpLoggingInterceptor$LevelArray[n10] = httpLoggingInterceptor$Level;
        n10 = 2;
        HEADERS = httpLoggingInterceptor$Level = new HttpLoggingInterceptor$Level("HEADERS", n10);
        httpLoggingInterceptor$LevelArray[n10] = httpLoggingInterceptor$Level;
        n10 = 3;
        BODY = httpLoggingInterceptor$Level = new HttpLoggingInterceptor$Level("BODY", n10);
        httpLoggingInterceptor$LevelArray[n10] = httpLoggingInterceptor$Level;
        a = httpLoggingInterceptor$LevelArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private HttpLoggingInterceptor$Level() {
        void var2_-1;
        void var1_-1;
    }

    public static HttpLoggingInterceptor$Level valueOf(String string2) {
        return Enum.valueOf(HttpLoggingInterceptor$Level.class, string2);
    }

    public static HttpLoggingInterceptor$Level[] values() {
        return (HttpLoggingInterceptor$Level[])a.clone();
    }
}

