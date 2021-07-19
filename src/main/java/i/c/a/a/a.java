/*
 * Decompiled with CFR 0.151.
 */
package i.c.a.a;

public @interface a {
    public static final String k2 = "The method argument (if parameter was annotated) or this container (if instance method was annotated)";
    public static final String l2 = "this";
    public static final String m2 = "This container (if the parameter was annotated) or the return value (if instance method was annotated)";
    public static final String n2 = "The return value of this method";
    public static final String o2 = "this";

    public String source();

    public boolean sourceIsContainer();

    public String target();

    public boolean targetIsContainer();
}

