/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger;

import com.google.common.flogger.LogSite;
import com.google.common.flogger.LogSite$1;
import com.google.common.flogger.util.Checks;

public final class LogSite$InjectedLogSite
extends LogSite {
    private final int encodedLineNumber;
    private int hashcode = 0;
    private final String internalClassName;
    private final String methodName;
    private final String sourceFileName;

    private LogSite$InjectedLogSite(String string2, String string3, int n10, String string4) {
        this.internalClassName = string2 = (String)Checks.checkNotNull(string2, "class name");
        this.methodName = string2 = (String)Checks.checkNotNull(string3, "method name");
        this.encodedLineNumber = n10;
        this.sourceFileName = string4;
    }

    public /* synthetic */ LogSite$InjectedLogSite(String string2, String string3, int n10, String string4, LogSite$1 logSite$1) {
        this(string2, string3, n10, string4);
    }

    public boolean equals(Object object) {
        int n10 = object instanceof LogSite$InjectedLogSite;
        boolean bl2 = false;
        if (n10 != 0) {
            int n11;
            object = (LogSite$InjectedLogSite)object;
            String string2 = this.internalClassName;
            String string3 = ((LogSite$InjectedLogSite)object).internalClassName;
            n10 = string2.equals(string3);
            if (n10 != 0 && (n10 = (string2 = this.methodName).equals(string3 = ((LogSite$InjectedLogSite)object).methodName)) != 0 && (n10 = this.encodedLineNumber) == (n11 = ((LogSite$InjectedLogSite)object).encodedLineNumber)) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public String getClassName() {
        return this.internalClassName.replace('/', '.');
    }

    public String getFileName() {
        return this.sourceFileName;
    }

    public int getLineNumber() {
        return this.encodedLineNumber & (char)-1;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public int hashCode() {
        int n10 = this.hashcode;
        if (n10 == 0) {
            int n11 = this.internalClassName.hashCode();
            n10 = (4867 + n11) * 31;
            String string2 = this.methodName;
            n11 = string2.hashCode();
            n10 = (n10 + n11) * 31;
            n11 = this.encodedLineNumber;
            this.hashcode = n10 += n11;
        }
        return this.hashcode;
    }
}

