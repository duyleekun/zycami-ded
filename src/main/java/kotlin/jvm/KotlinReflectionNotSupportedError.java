/*
 * Decompiled with CFR 0.151.
 */
package kotlin.jvm;

public class KotlinReflectionNotSupportedError
extends Error {
    public KotlinReflectionNotSupportedError() {
        super("Kotlin reflection implementation is not found at runtime. Make sure you have kotlin-reflect.jar in the classpath");
    }

    public KotlinReflectionNotSupportedError(String string2) {
        super(string2);
    }

    public KotlinReflectionNotSupportedError(String string2, Throwable throwable) {
        super(string2, throwable);
    }

    public KotlinReflectionNotSupportedError(Throwable throwable) {
        super(throwable);
    }
}

