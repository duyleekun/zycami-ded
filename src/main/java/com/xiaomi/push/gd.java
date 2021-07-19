/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.gm;
import com.xiaomi.push.gn;
import java.io.PrintStream;
import java.io.PrintWriter;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class gd
extends Exception {
    private gm a;
    private gn a;
    private Throwable a = null;

    public gd() {
    }

    public gd(gm gm2) {
        this.a = gm2;
    }

    public gd(String string2) {
        super(string2);
    }

    public gd(String string2, Throwable throwable) {
        super(string2);
        this.a = throwable;
    }

    public gd(Throwable throwable) {
        this.a = throwable;
    }

    public Throwable a() {
        return this.a;
    }

    public String getMessage() {
        Object object;
        String string2 = super.getMessage();
        if (string2 == null && (object = this.a) != null) {
            return ((gn)object).toString();
        }
        if (string2 == null && (object = this.a) != null) {
            string2 = ((gm)object).toString();
        }
        return string2;
    }

    public void printStackTrace() {
        PrintStream printStream = System.err;
        this.printStackTrace(printStream);
    }

    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        Throwable throwable = this.a;
        if (throwable != null) {
            printStream.println("Nested Exception: ");
            throwable = this.a;
            throwable.printStackTrace(printStream);
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        Throwable throwable = this.a;
        if (throwable != null) {
            printWriter.println("Nested Exception: ");
            throwable = this.a;
            throwable.printStackTrace(printWriter);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = super.getMessage();
        if (object != null) {
            stringBuilder.append((String)object);
            object = ": ";
            stringBuilder.append((String)object);
        }
        if ((object = this.a) != null) {
            stringBuilder.append(object);
        }
        if ((object = this.a) != null) {
            stringBuilder.append(object);
        }
        if ((object = this.a) != null) {
            stringBuilder.append("\n  -- caused by: ");
            object = this.a;
            stringBuilder.append(object);
        }
        return stringBuilder.toString();
    }
}

