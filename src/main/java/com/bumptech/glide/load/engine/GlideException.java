/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException$a;
import d.c.a.o.c;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class GlideException
extends Exception {
    private static final StackTraceElement[] a = new StackTraceElement[0];
    private static final long serialVersionUID = 1L;
    private final List causes;
    private Class dataClass;
    private DataSource dataSource;
    private String detailMessage;
    private Exception exception;
    private c key;

    public GlideException(String string2) {
        List list = Collections.emptyList();
        this(string2, list);
    }

    public GlideException(String string2, Throwable object) {
        object = Collections.singletonList(object);
        this(string2, (List)object);
    }

    public GlideException(String stackTraceElementArray, List list) {
        this.detailMessage = stackTraceElementArray;
        stackTraceElementArray = a;
        this.setStackTrace(stackTraceElementArray);
        this.causes = list;
    }

    private void a(Throwable object, List list) {
        boolean bl2 = object instanceof GlideException;
        if (bl2) {
            object = ((GlideException)object).getCauses().iterator();
            while (bl2 = object.hasNext()) {
                Throwable throwable = (Throwable)object.next();
                this.a(throwable, list);
            }
        } else {
            list.add(object);
        }
    }

    private static void b(List list, Appendable object) {
        try {
            GlideException.c(list, (Appendable)object);
            return;
        }
        catch (IOException iOException) {
            object = new RuntimeException(iOException);
            throw object;
        }
    }

    private static void c(List list, Appendable appendable) {
        int n10 = list.size();
        int n11 = 0;
        Throwable throwable = null;
        while (n11 < n10) {
            Appendable appendable2 = appendable.append("Cause (");
            int n12 = n11 + 1;
            String string2 = String.valueOf(n12);
            appendable2 = appendable2.append(string2).append(" of ");
            string2 = String.valueOf(n10);
            appendable2 = appendable2.append(string2);
            string2 = "): ";
            appendable2.append(string2);
            throwable = (Throwable)list.get(n11);
            boolean bl2 = throwable instanceof GlideException;
            if (bl2) {
                throwable = (GlideException)throwable;
                super.e(appendable);
            } else {
                GlideException.d(throwable, appendable);
            }
            n11 = n12;
        }
    }

    private static void d(Throwable throwable, Appendable object) {
        Object object2;
        try {
            object2 = throwable.getClass();
        }
        catch (IOException iOException) {
            object = new RuntimeException(throwable);
            throw object;
        }
        object2 = ((Class)object2).toString();
        object = object.append((CharSequence)object2);
        object2 = ": ";
        object = object.append((CharSequence)object2);
        object2 = throwable.getMessage();
        object = object.append((CharSequence)object2);
        char c10 = '\n';
        object.append(c10);
    }

    private void e(Appendable appendable) {
        GlideException.d(this, appendable);
        List list = this.getCauses();
        GlideException$a glideException$a = new GlideException$a(appendable);
        GlideException.b(list, glideException$a);
    }

    public Throwable fillInStackTrace() {
        return this;
    }

    public List getCauses() {
        return this.causes;
    }

    public String getMessage() {
        int n10;
        Object object;
        int n11 = 71;
        StringBuilder stringBuilder = new StringBuilder(n11);
        Object object2 = this.detailMessage;
        stringBuilder.append((String)object2);
        object2 = this.dataClass;
        Object object3 = ", ";
        String string2 = "";
        if (object2 != null) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object3);
            object = this.dataClass;
            ((StringBuilder)object2).append(object);
            object2 = ((StringBuilder)object2).toString();
        } else {
            object2 = string2;
        }
        stringBuilder.append((String)object2);
        object2 = this.dataSource;
        if (object2 != null) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object3);
            object = this.dataSource;
            ((StringBuilder)object2).append(object);
            object2 = ((StringBuilder)object2).toString();
        } else {
            object2 = string2;
        }
        stringBuilder.append((String)object2);
        object2 = this.key;
        if (object2 != null) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object3);
            object3 = this.key;
            ((StringBuilder)object2).append(object3);
            string2 = ((StringBuilder)object2).toString();
        }
        stringBuilder.append(string2);
        object2 = this.getRootCauses();
        int n12 = object2.isEmpty();
        if (n12 != 0) {
            return stringBuilder.toString();
        }
        n12 = object2.size();
        if (n12 == (n10 = 1)) {
            object3 = "\nThere was 1 cause:";
            stringBuilder.append((String)object3);
        } else {
            stringBuilder.append("\nThere were ");
            n12 = object2.size();
            stringBuilder.append(n12);
            object3 = " causes:";
            stringBuilder.append((String)object3);
        }
        object2 = object2.iterator();
        while ((n12 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
            object3 = (Throwable)object2.next();
            stringBuilder.append('\n');
            string2 = object3.getClass().getName();
            stringBuilder.append(string2);
            n10 = 40;
            stringBuilder.append((char)n10);
            object3 = ((Throwable)object3).getMessage();
            stringBuilder.append((String)object3);
            n12 = 41;
            stringBuilder.append((char)n12);
        }
        stringBuilder.append("\n call GlideException#logRootCauses(String) for more detail");
        return stringBuilder.toString();
    }

    public Exception getOrigin() {
        return this.exception;
    }

    public List getRootCauses() {
        ArrayList arrayList = new ArrayList();
        this.a(this, arrayList);
        return arrayList;
    }

    public void logRootCauses(String string2) {
        List list = this.getRootCauses();
        int n10 = list.size();
        int n11 = 0;
        Throwable throwable = null;
        while (n11 < n10) {
            CharSequence charSequence = new StringBuilder();
            String string3 = "Root cause (";
            charSequence.append(string3);
            int n12 = n11 + 1;
            charSequence.append(n12);
            charSequence.append(" of ");
            charSequence.append(n10);
            String string4 = ")";
            charSequence.append(string4);
            charSequence = charSequence.toString();
            throwable = (Throwable)list.get(n11);
            Log.i((String)string2, (String)charSequence, (Throwable)throwable);
            n11 = n12;
        }
    }

    public void printStackTrace() {
        PrintStream printStream = System.err;
        this.printStackTrace(printStream);
    }

    public void printStackTrace(PrintStream printStream) {
        this.e(printStream);
    }

    public void printStackTrace(PrintWriter printWriter) {
        this.e(printWriter);
    }

    public void setLoggingDetails(c c10, DataSource dataSource) {
        this.setLoggingDetails(c10, dataSource, null);
    }

    public void setLoggingDetails(c c10, DataSource dataSource, Class clazz) {
        this.key = c10;
        this.dataSource = dataSource;
        this.dataClass = clazz;
    }

    public void setOrigin(Exception exception) {
        this.exception = exception;
    }
}

