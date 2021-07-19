/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.log;

import com.google.firebase.crashlytics.internal.log.QueueFile$ElementReader;
import com.google.firebase.crashlytics.internal.log.QueueFileLogStore;
import java.io.InputStream;

public class QueueFileLogStore$1
implements QueueFile$ElementReader {
    public final /* synthetic */ QueueFileLogStore this$0;
    public final /* synthetic */ byte[] val$logBytes;
    public final /* synthetic */ int[] val$offsetHolder;

    public QueueFileLogStore$1(QueueFileLogStore queueFileLogStore, byte[] byArray, int[] nArray) {
        this.this$0 = queueFileLogStore;
        this.val$logBytes = byArray;
        this.val$offsetHolder = nArray;
    }

    public void read(InputStream inputStream, int n10) {
        try {
            Object[] objectArray = this.val$logBytes;
            int[] nArray = this.val$offsetHolder;
            int n11 = nArray[0];
            inputStream.read((byte[])objectArray, n11, n10);
            objectArray = this.val$offsetHolder;
            objectArray[0] = n11 = objectArray[0] + n10;
            return;
        }
        finally {
            inputStream.close();
        }
    }
}

