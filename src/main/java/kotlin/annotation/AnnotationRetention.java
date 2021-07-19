/*
 * Decompiled with CFR 0.151.
 */
package kotlin.annotation;

public final class AnnotationRetention
extends Enum {
    public static final /* enum */ AnnotationRetention BINARY;
    public static final /* enum */ AnnotationRetention RUNTIME;
    public static final /* enum */ AnnotationRetention SOURCE;
    private static final /* synthetic */ AnnotationRetention[] a;

    static {
        AnnotationRetention annotationRetention;
        AnnotationRetention[] annotationRetentionArray = new AnnotationRetention[3];
        SOURCE = annotationRetention = new AnnotationRetention("SOURCE", 0);
        annotationRetentionArray[0] = annotationRetention;
        int n10 = 1;
        BINARY = annotationRetention = new AnnotationRetention("BINARY", n10);
        annotationRetentionArray[n10] = annotationRetention;
        n10 = 2;
        RUNTIME = annotationRetention = new AnnotationRetention("RUNTIME", n10);
        annotationRetentionArray[n10] = annotationRetention;
        a = annotationRetentionArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private AnnotationRetention() {
        void var2_-1;
        void var1_-1;
    }

    public static AnnotationRetention valueOf(String string2) {
        return Enum.valueOf(AnnotationRetention.class, string2);
    }

    public static AnnotationRetention[] values() {
        return (AnnotationRetention[])a.clone();
    }
}

