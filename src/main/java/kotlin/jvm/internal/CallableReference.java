/*
 * Decompiled with CFR 0.151.
 */
package kotlin.jvm.internal;

import f.h2.t.n0;
import f.m2.c;
import f.m2.h;
import f.m2.r;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.internal.CallableReference$NoReceiver;
import kotlin.reflect.KVisibility;

public abstract class CallableReference
implements c,
Serializable {
    public static final Object NO_RECEIVER = CallableReference$NoReceiver.access$000();
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    public final Object receiver;
    private transient c reflected;
    private final String signature;

    public CallableReference() {
        Object object = NO_RECEIVER;
        this(object);
    }

    public CallableReference(Object object) {
        this(object, null, null, null, false);
    }

    public CallableReference(Object object, Class clazz, String string2, String string3, boolean bl2) {
        this.receiver = object;
        this.owner = clazz;
        this.name = string2;
        this.signature = string3;
        this.isTopLevel = bl2;
    }

    public Object call(Object ... objectArray) {
        return this.getReflected().call(objectArray);
    }

    public Object callBy(Map map) {
        return this.getReflected().callBy(map);
    }

    public c compute() {
        c c10 = this.reflected;
        if (c10 == null) {
            this.reflected = c10 = this.computeReflected();
        }
        return c10;
    }

    public abstract c computeReflected();

    public List getAnnotations() {
        return this.getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public String getName() {
        return this.name;
    }

    public h getOwner() {
        boolean bl2;
        Object object = this.owner;
        object = object == null ? null : ((bl2 = this.isTopLevel) ? n0.g((Class)object) : n0.d((Class)object));
        return object;
    }

    public List getParameters() {
        return this.getReflected().getParameters();
    }

    public c getReflected() {
        Object object = this.compute();
        if (object != this) {
            return object;
        }
        object = new KotlinReflectionNotSupportedError();
        throw object;
    }

    public r getReturnType() {
        return this.getReflected().getReturnType();
    }

    public String getSignature() {
        return this.signature;
    }

    public List getTypeParameters() {
        return this.getReflected().getTypeParameters();
    }

    public KVisibility getVisibility() {
        return this.getReflected().getVisibility();
    }

    public boolean isAbstract() {
        return this.getReflected().isAbstract();
    }

    public boolean isFinal() {
        return this.getReflected().isFinal();
    }

    public boolean isOpen() {
        return this.getReflected().isOpen();
    }

    public boolean isSuspend() {
        return this.getReflected().isSuspend();
    }
}

