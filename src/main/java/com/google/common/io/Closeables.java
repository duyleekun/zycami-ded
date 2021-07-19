/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Closeables {
    public static final Logger logger = Logger.getLogger(Closeables.class.getName());

    private Closeables() {
    }

    public static void close(Closeable closeable, boolean bl2) {
        IOException iOException2;
        block3: {
            if (closeable == null) {
                return;
            }
            try {
                closeable.close();
            }
            catch (IOException iOException2) {
                if (!bl2) break block3;
                Logger logger = Closeables.logger;
                Level level = Level.WARNING;
                String string2 = "IOException thrown while closing Closeable.";
                logger.log(level, string2, iOException2);
            }
            return;
        }
        throw iOException2;
    }

    public static void closeQuietly(InputStream inputStream) {
        boolean bl2 = true;
        try {
            Closeables.close(inputStream, bl2);
            return;
        }
        catch (IOException iOException) {
            AssertionError assertionError = new AssertionError((Object)iOException);
            throw assertionError;
        }
    }

    public static void closeQuietly(Reader reader) {
        boolean bl2 = true;
        try {
            Closeables.close(reader, bl2);
            return;
        }
        catch (IOException iOException) {
            AssertionError assertionError = new AssertionError((Object)iOException);
            throw assertionError;
        }
    }
}

