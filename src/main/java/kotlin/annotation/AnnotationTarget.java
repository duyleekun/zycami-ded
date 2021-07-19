/*
 * Decompiled with CFR 0.151.
 */
package kotlin.annotation;

public final class AnnotationTarget
extends Enum {
    public static final /* enum */ AnnotationTarget ANNOTATION_CLASS;
    public static final /* enum */ AnnotationTarget CLASS;
    public static final /* enum */ AnnotationTarget CONSTRUCTOR;
    public static final /* enum */ AnnotationTarget EXPRESSION;
    public static final /* enum */ AnnotationTarget FIELD;
    public static final /* enum */ AnnotationTarget FILE;
    public static final /* enum */ AnnotationTarget FUNCTION;
    public static final /* enum */ AnnotationTarget LOCAL_VARIABLE;
    public static final /* enum */ AnnotationTarget PROPERTY;
    public static final /* enum */ AnnotationTarget PROPERTY_GETTER;
    public static final /* enum */ AnnotationTarget PROPERTY_SETTER;
    public static final /* enum */ AnnotationTarget TYPE;
    public static final /* enum */ AnnotationTarget TYPEALIAS;
    public static final /* enum */ AnnotationTarget TYPE_PARAMETER;
    public static final /* enum */ AnnotationTarget VALUE_PARAMETER;
    private static final /* synthetic */ AnnotationTarget[] a;

    static {
        AnnotationTarget annotationTarget;
        AnnotationTarget[] annotationTargetArray = new AnnotationTarget[15];
        CLASS = annotationTarget = new AnnotationTarget("CLASS", 0);
        annotationTargetArray[0] = annotationTarget;
        int n10 = 1;
        ANNOTATION_CLASS = annotationTarget = new AnnotationTarget("ANNOTATION_CLASS", n10);
        annotationTargetArray[n10] = annotationTarget;
        n10 = 2;
        TYPE_PARAMETER = annotationTarget = new AnnotationTarget("TYPE_PARAMETER", n10);
        annotationTargetArray[n10] = annotationTarget;
        n10 = 3;
        PROPERTY = annotationTarget = new AnnotationTarget("PROPERTY", n10);
        annotationTargetArray[n10] = annotationTarget;
        n10 = 4;
        FIELD = annotationTarget = new AnnotationTarget("FIELD", n10);
        annotationTargetArray[n10] = annotationTarget;
        n10 = 5;
        LOCAL_VARIABLE = annotationTarget = new AnnotationTarget("LOCAL_VARIABLE", n10);
        annotationTargetArray[n10] = annotationTarget;
        n10 = 6;
        VALUE_PARAMETER = annotationTarget = new AnnotationTarget("VALUE_PARAMETER", n10);
        annotationTargetArray[n10] = annotationTarget;
        n10 = 7;
        CONSTRUCTOR = annotationTarget = new AnnotationTarget("CONSTRUCTOR", n10);
        annotationTargetArray[n10] = annotationTarget;
        n10 = 8;
        FUNCTION = annotationTarget = new AnnotationTarget("FUNCTION", n10);
        annotationTargetArray[n10] = annotationTarget;
        n10 = 9;
        PROPERTY_GETTER = annotationTarget = new AnnotationTarget("PROPERTY_GETTER", n10);
        annotationTargetArray[n10] = annotationTarget;
        n10 = 10;
        PROPERTY_SETTER = annotationTarget = new AnnotationTarget("PROPERTY_SETTER", n10);
        annotationTargetArray[n10] = annotationTarget;
        n10 = 11;
        TYPE = annotationTarget = new AnnotationTarget("TYPE", n10);
        annotationTargetArray[n10] = annotationTarget;
        n10 = 12;
        EXPRESSION = annotationTarget = new AnnotationTarget("EXPRESSION", n10);
        annotationTargetArray[n10] = annotationTarget;
        n10 = 13;
        FILE = annotationTarget = new AnnotationTarget("FILE", n10);
        annotationTargetArray[n10] = annotationTarget;
        n10 = 14;
        TYPEALIAS = annotationTarget = new AnnotationTarget("TYPEALIAS", n10);
        annotationTargetArray[n10] = annotationTarget;
        a = annotationTargetArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private AnnotationTarget() {
        void var2_-1;
        void var1_-1;
    }

    public static AnnotationTarget valueOf(String string2) {
        return Enum.valueOf(AnnotationTarget.class, string2);
    }

    public static AnnotationTarget[] values() {
        return (AnnotationTarget[])a.clone();
    }
}

