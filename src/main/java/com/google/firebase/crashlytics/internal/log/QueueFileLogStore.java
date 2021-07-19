/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.log;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.log.FileLogStore;
import com.google.firebase.crashlytics.internal.log.QueueFile;
import com.google.firebase.crashlytics.internal.log.QueueFile$ElementReader;
import com.google.firebase.crashlytics.internal.log.QueueFileLogStore$1;
import com.google.firebase.crashlytics.internal.log.QueueFileLogStore$LogBytes;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;

public class QueueFileLogStore
implements FileLogStore {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private QueueFile logFile;
    private final int maxLogSize;
    private final File workingFile;

    public QueueFileLogStore(File file, int n10) {
        this.workingFile = file;
        this.maxLogSize = n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void doWriteToLog(long l10, String string2) {
        Object object = " ";
        Object object2 = this.logFile;
        if (object2 == null) {
            return;
        }
        if (string2 == null) {
            string2 = "null";
        }
        try {
            int n10;
            Object object3;
            int n11;
            String string3;
            Object[] objectArray;
            int n12 = this.maxLogSize;
            int n13 = string2.length();
            if (n13 > (n12 /= 4)) {
                objectArray = new StringBuilder();
                string3 = "...";
                objectArray.append(string3);
                n11 = string2.length() - n12;
                string2 = string2.substring(n11);
                objectArray.append(string2);
                string2 = objectArray.toString();
            }
            object2 = "\r";
            string2 = string2.replaceAll((String)object2, (String)object);
            object2 = "\n";
            string2 = string2.replaceAll((String)object2, (String)object);
            object = Locale.US;
            object2 = "%d %s%n";
            n13 = 2;
            objectArray = new Object[n13];
            n11 = 0;
            string3 = null;
            objectArray[0] = object3 = Long.valueOf(l10);
            int n14 = 1;
            objectArray[n14] = string2;
            object3 = String.format((Locale)object, (String)object2, objectArray);
            Object object4 = UTF_8;
            object3 = ((String)object3).getBytes((Charset)object4);
            object4 = this.logFile;
            ((QueueFile)object4).add((byte[])object3);
            while ((n14 = (int)(((QueueFile)(object3 = this.logFile)).isEmpty() ? 1 : 0)) == 0 && (n14 = ((QueueFile)(object3 = this.logFile)).usedBytes()) > (n10 = this.maxLogSize)) {
                object3 = this.logFile;
                ((QueueFile)object3).remove();
            }
            return;
        }
        catch (IOException iOException) {
            Logger logger = Logger.getLogger();
            string2 = "There was a problem writing to the Crashlytics log.";
            logger.e(string2, iOException);
        }
    }

    private QueueFileLogStore$LogBytes getLogBytes() {
        Object object = this.workingFile;
        boolean n10 = ((File)object).exists();
        int n11 = 0;
        int[] nArray = null;
        if (!n10) {
            return null;
        }
        this.openLogFile();
        object = this.logFile;
        if (object == null) {
            return null;
        }
        n11 = 1;
        nArray = new int[n11];
        nArray[0] = 0;
        int n12 = ((QueueFile)object).usedBytes();
        object = new byte[n12];
        Object iOException = this.logFile;
        Object object2 = new QueueFileLogStore$1(this, (byte[])object, nArray);
        try {
            ((QueueFile)iOException).forEach((QueueFile$ElementReader)object2);
        }
        catch (IOException iOException2) {
            object2 = Logger.getLogger();
            String string2 = "A problem occurred while reading the Crashlytics log file.";
            ((Logger)object2).e(string2, iOException2);
        }
        n11 = nArray[0];
        iOException = new QueueFileLogStore$LogBytes((byte[])object, n11);
        return iOException;
    }

    private void openLogFile() {
        QueueFile queueFile = this.logFile;
        if (queueFile == null) {
            Object object = this.workingFile;
            queueFile = new QueueFile((File)object);
            try {
                this.logFile = queueFile;
            }
            catch (IOException iOException) {
                object = Logger.getLogger();
                CharSequence charSequence = new StringBuilder();
                charSequence.append("Could not open log file: ");
                File file = this.workingFile;
                charSequence.append(file);
                charSequence = charSequence.toString();
                ((Logger)object).e((String)charSequence, iOException);
            }
        }
    }

    public void closeLogFile() {
        CommonUtils.closeOrLog(this.logFile, "There was a problem closing the Crashlytics log file.");
        this.logFile = null;
    }

    public void deleteLogFile() {
        this.closeLogFile();
        this.workingFile.delete();
    }

    public byte[] getLogAsBytes() {
        QueueFileLogStore$LogBytes queueFileLogStore$LogBytes = this.getLogBytes();
        if (queueFileLogStore$LogBytes == null) {
            return null;
        }
        int n10 = queueFileLogStore$LogBytes.offset;
        byte[] byArray = new byte[n10];
        System.arraycopy(queueFileLogStore$LogBytes.bytes, 0, byArray, 0, n10);
        return byArray;
    }

    public String getLogAsString() {
        String string2;
        byte[] byArray = this.getLogAsBytes();
        if (byArray != null) {
            Charset charset = UTF_8;
            string2 = new String(byArray, charset);
        } else {
            string2 = null;
        }
        return string2;
    }

    public void writeToLog(long l10, String string2) {
        this.openLogFile();
        this.doWriteToLog(l10, string2);
    }
}

