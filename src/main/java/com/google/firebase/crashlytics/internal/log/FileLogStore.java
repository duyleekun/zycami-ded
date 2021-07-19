/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.log;

public interface FileLogStore {
    public void closeLogFile();

    public void deleteLogFile();

    public byte[] getLogAsBytes();

    public String getLogAsString();

    public void writeToLog(long var1, String var3);
}

