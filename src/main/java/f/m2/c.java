/*
 * Decompiled with CFR 0.151.
 */
package f.m2;

import f.m2.b;
import f.m2.r;
import java.util.List;
import java.util.Map;
import kotlin.reflect.KVisibility;

public interface c
extends b {
    public Object call(Object ... var1);

    public Object callBy(Map var1);

    public String getName();

    public List getParameters();

    public r getReturnType();

    public List getTypeParameters();

    public KVisibility getVisibility();

    public boolean isAbstract();

    public boolean isFinal();

    public boolean isOpen();

    public boolean isSuspend();
}

