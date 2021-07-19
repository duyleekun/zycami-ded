/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame$1;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame;

public final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame
extends CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame {
    private final String file;
    private final int importance;
    private final long offset;
    private final long pc;
    private final String symbol;

    private AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame(long l10, String string2, String string3, long l11, int n10) {
        this.pc = l10;
        this.symbol = string2;
        this.file = string3;
        this.offset = l11;
        this.importance = n10;
    }

    public /* synthetic */ AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame(long l10, String string2, String string3, long l11, int n10, AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame$1 autoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame$1) {
        this(l10, string2, string3, l11, n10);
    }

    public boolean equals(Object object) {
        block4: {
            boolean bl2;
            block6: {
                block5: {
                    int n10;
                    String string2;
                    String string3;
                    bl2 = true;
                    if (object == this) {
                        return bl2;
                    }
                    Object object2 = object instanceof CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame;
                    if (object2 == 0) break block4;
                    long l10 = this.pc;
                    long l11 = ((CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame)(object = (CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame)object)).getPc();
                    long l12 = l10 - l11;
                    object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                    if (object2 != 0 || (object2 = (string3 = this.symbol).equals(string2 = ((CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame)object).getSymbol())) == 0 || !((string3 = this.file) == null ? (string3 = ((CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame)object).getFile()) == null : (object2 = string3.equals(string2 = ((CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame)object).getFile())) != 0)) break block5;
                    l10 = this.offset;
                    l11 = ((CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame)object).getOffset();
                    object2 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                    if (object2 == 0 && (object2 = this.importance) == (n10 = ((CrashlyticsReport$Session$Event$Application$Execution$Thread$Frame)object).getImportance())) break block6;
                }
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getFile() {
        return this.file;
    }

    public int getImportance() {
        return this.importance;
    }

    public long getOffset() {
        return this.offset;
    }

    public long getPc() {
        return this.pc;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int hashCode() {
        long l10 = this.pc;
        int n10 = 32;
        long l11 = l10 >>> n10;
        int n11 = (int)(l10 ^= l11);
        int n12 = 1000003;
        n11 = (n11 ^ n12) * n12;
        int n13 = this.symbol.hashCode();
        n11 = (n11 ^ n13) * n12;
        String string2 = this.file;
        if (string2 == null) {
            n13 = 0;
            string2 = null;
        } else {
            n13 = string2.hashCode();
        }
        n11 = (n11 ^ n13) * n12;
        l11 = this.offset;
        n10 = (int)(l11 >>> n10 ^ l11);
        n11 = (n11 ^ n10) * n12;
        n12 = this.importance;
        return n11 ^ n12;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Frame{pc=");
        long l10 = this.pc;
        stringBuilder.append(l10);
        stringBuilder.append(", symbol=");
        String string2 = this.symbol;
        stringBuilder.append(string2);
        stringBuilder.append(", file=");
        string2 = this.file;
        stringBuilder.append(string2);
        stringBuilder.append(", offset=");
        l10 = this.offset;
        stringBuilder.append(l10);
        stringBuilder.append(", importance=");
        int n10 = this.importance;
        stringBuilder.append(n10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

