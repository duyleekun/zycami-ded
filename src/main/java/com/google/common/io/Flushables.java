/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import java.io.Flushable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Flushables {
    private static final Logger logger = Logger.getLogger(Flushables.class.getName());

    private Flushables() {
    }

    public static void flush(Flushable flushable, boolean bl2) {
        IOException iOException2;
        block2: {
            try {
                flushable.flush();
            }
            catch (IOException iOException2) {
                if (!bl2) break block2;
                Logger logger = Flushables.logger;
                Level level = Level.WARNING;
                String string2 = "IOException thrown while flushing Flushable.";
                logger.log(level, string2, iOException2);
            }
            return;
        }
        throw iOException2;
    }

    public static void flushQuietly(Flushable flushable) {
        boolean bl2 = true;
        try {
            Flushables.flush(flushable, bl2);
        }
        catch (IOException iOException) {
            Logger logger = Flushables.logger;
            Level level = Level.SEVERE;
            String string2 = "IOException should not have been thrown.";
            logger.log(level, string2, iOException);
        }
    }
}

