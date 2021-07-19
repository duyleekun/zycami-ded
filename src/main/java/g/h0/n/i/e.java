/*
 * Decompiled with CFR 0.151.
 */
package g.h0.n.i;

import java.util.logging.Level;
import java.util.logging.LogRecord;

public final class e {
    public static final /* synthetic */ int a(LogRecord logRecord) {
        return e.b(logRecord);
    }

    private static final int b(LogRecord serializable) {
        int n10;
        Level level;
        int n11;
        Level level2 = ((LogRecord)serializable).getLevel();
        int n12 = level2.intValue();
        n10 = n12 > (n11 = (level = Level.INFO).intValue()) ? 5 : ((n10 = ((Level)(serializable = ((LogRecord)serializable).getLevel())).intValue()) == (n12 = (level2 = Level.INFO).intValue()) ? 4 : 3);
        return n10;
    }
}

