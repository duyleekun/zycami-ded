/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.exceptions;

import io.reactivex.exceptions.CompositeException$CompositeExceptionCausalChain;
import io.reactivex.exceptions.CompositeException$a;
import io.reactivex.exceptions.CompositeException$b;
import io.reactivex.exceptions.CompositeException$c;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

public final class CompositeException
extends RuntimeException {
    private static final long serialVersionUID = 3026362227162912146L;
    private Throwable cause;
    private final List exceptions;
    private final String message;

    public CompositeException(Iterable object) {
        int n10;
        Serializable serializable = new LinkedHashSet();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                Object object2 = (Throwable)object.next();
                boolean bl3 = object2 instanceof CompositeException;
                if (bl3) {
                    object2 = ((CompositeException)object2).getExceptions();
                    serializable.addAll(object2);
                    continue;
                }
                if (object2 != null) {
                    serializable.add(object2);
                    continue;
                }
                String string2 = "Throwable was null!";
                object2 = new NullPointerException(string2);
                serializable.add(object2);
            }
        } else {
            String string3 = "errors was null";
            super(string3);
            serializable.add(object);
        }
        if ((n10 = serializable.isEmpty()) == 0) {
            arrayList.addAll((Collection<Object>)((Object)serializable));
            object = Collections.unmodifiableList(arrayList);
            this.exceptions = object;
            super();
            n10 = object.size();
            ((StringBuilder)serializable).append(n10);
            ((StringBuilder)serializable).append(" exceptions occurred. ");
            this.message = object = ((StringBuilder)serializable).toString();
            return;
        }
        object = new IllegalArgumentException("errors is empty");
        throw object;
    }

    public CompositeException(Throwable ... object) {
        if (object == null) {
            String string2 = "exceptions was null";
            super(string2);
            object = Collections.singletonList(object);
        } else {
            object = Arrays.asList(object);
        }
        this((Iterable)object);
    }

    private void a(StringBuilder stringBuilder, Throwable throwable, String object) {
        stringBuilder.append((String)object);
        stringBuilder.append(throwable);
        char c10 = '\n';
        stringBuilder.append(c10);
        for (StackTraceElement stackTraceElement : throwable.getStackTrace()) {
            String string2 = "\t\tat ";
            stringBuilder.append(string2);
            stringBuilder.append(stackTraceElement);
            stringBuilder.append(c10);
        }
        object = throwable.getCause();
        if (object != null) {
            stringBuilder.append("\tCaused by: ");
            throwable = throwable.getCause();
            object = "";
            this.a(stringBuilder, throwable, (String)object);
        }
    }

    private List b(Throwable throwable) {
        ArrayList<Throwable> arrayList = new ArrayList<Throwable>();
        Throwable throwable2 = throwable.getCause();
        if (throwable2 != null && throwable2 != throwable) {
            while (true) {
                arrayList.add(throwable2);
                throwable = throwable2.getCause();
                if (throwable == null || throwable == throwable2) break;
                throwable2 = throwable;
            }
        }
        return arrayList;
    }

    private void c(CompositeException$a compositeException$a) {
        int n10;
        Object object;
        int n11;
        CharSequence charSequence = new StringBuilder(128);
        ((StringBuilder)charSequence).append(this);
        char c10 = '\n';
        ((StringBuilder)charSequence).append(c10);
        StackTraceElement[] stackTraceElementArray = this.getStackTrace();
        int n12 = stackTraceElementArray.length;
        Throwable throwable = null;
        for (n11 = 0; n11 < n12; ++n11) {
            object = stackTraceElementArray[n11];
            String string2 = "\tat ";
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(object);
            ((StringBuilder)charSequence).append(c10);
        }
        Iterator iterator2 = this.exceptions.iterator();
        n12 = n10 = 1;
        while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            throwable = (Throwable)iterator2.next();
            ((StringBuilder)charSequence).append("  ComposedException ");
            ((StringBuilder)charSequence).append(n12);
            ((StringBuilder)charSequence).append(" :\n");
            object = "\t";
            this.a((StringBuilder)charSequence, throwable, (String)object);
            n12 += n10;
        }
        charSequence = ((StringBuilder)charSequence).toString();
        compositeException$a.a(charSequence);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Throwable getCause() {
        synchronized (this) {
            Throwable throwable = this.cause;
            if (throwable != null) return this.cause;
            throwable = new CompositeException$CompositeExceptionCausalChain();
            HashSet<Throwable> hashSet = new HashSet<Throwable>();
            Object object = this.exceptions;
            object = object.iterator();
            Throwable throwable2 = throwable;
            while (true) {
                boolean bl2;
                Object object2;
                boolean bl3;
                if (bl3 = object.hasNext()) {
                    Object e10 = object.next();
                    Throwable throwable3 = (Throwable)e10;
                    boolean bl4 = hashSet.contains(throwable3);
                    if (bl4) continue;
                    hashSet.add(throwable3);
                    object2 = this.b(throwable3);
                    object2 = object2.iterator();
                } else {
                    this.cause = throwable;
                    return this.cause;
                }
                while (bl2 = object2.hasNext()) {
                    Object e11 = object2.next();
                    Throwable throwable4 = (Throwable)e11;
                    boolean bl5 = hashSet.contains(throwable4);
                    if (bl5) {
                        String string2 = "Duplicate found in causal chain so cropping to prevent loop ...";
                        RuntimeException runtimeException = new RuntimeException(string2);
                        continue;
                    }
                    hashSet.add(throwable4);
                }
                try {
                    void var6_6;
                    throwable2.initCause((Throwable)var6_6);
                }
                catch (Throwable throwable5) {}
                throwable2 = this.getRootCause(throwable2);
            }
        }
    }

    public List getExceptions() {
        return this.exceptions;
    }

    public String getMessage() {
        return this.message;
    }

    public Throwable getRootCause(Throwable throwable) {
        Throwable throwable2 = throwable.getCause();
        if (throwable2 != null && throwable != throwable2) {
            while ((throwable = throwable2.getCause()) != null && throwable != throwable2) {
                throwable2 = throwable;
            }
            return throwable2;
        }
        return throwable;
    }

    public void printStackTrace() {
        PrintStream printStream = System.err;
        this.printStackTrace(printStream);
    }

    public void printStackTrace(PrintStream printStream) {
        CompositeException$b compositeException$b = new CompositeException$b(printStream);
        this.c(compositeException$b);
    }

    public void printStackTrace(PrintWriter printWriter) {
        CompositeException$c compositeException$c = new CompositeException$c(printWriter);
        this.c(compositeException$c);
    }

    public int size() {
        return this.exceptions.size();
    }
}

