/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.log;

import com.google.firebase.crashlytics.internal.log.QueueFile;
import com.google.firebase.crashlytics.internal.log.QueueFile$1;
import com.google.firebase.crashlytics.internal.log.QueueFile$Element;
import java.io.InputStream;
import java.io.RandomAccessFile;

public final class QueueFile$ElementInputStream
extends InputStream {
    private int position;
    private int remaining;
    public final /* synthetic */ QueueFile this$0;

    private QueueFile$ElementInputStream(QueueFile queueFile, QueueFile$Element queueFile$Element) {
        int n10;
        this.this$0 = queueFile;
        int n11 = queueFile$Element.position + 4;
        this.position = n10 = QueueFile.access$100(queueFile, n11);
        this.remaining = n10 = queueFile$Element.length;
    }

    public /* synthetic */ QueueFile$ElementInputStream(QueueFile queueFile, QueueFile$Element queueFile$Element, QueueFile.1 var3_3) {
        this(queueFile, queueFile$Element);
    }

    public int read() {
        int n10;
        int n11 = this.remaining;
        if (n11 == 0) {
            return -1;
        }
        RandomAccessFile randomAccessFile = QueueFile.access$400(this.this$0);
        long l10 = this.position;
        randomAccessFile.seek(l10);
        n11 = QueueFile.access$400(this.this$0).read();
        QueueFile queueFile = this.this$0;
        int n12 = this.position + 1;
        this.position = n10 = QueueFile.access$100(queueFile, n12);
        this.remaining = n10 = this.remaining + -1;
        return n11;
    }

    public int read(byte[] object, int n10, int n11) {
        Object object2 = "buffer";
        QueueFile.access$200(object, (String)object2);
        int n12 = n10 | n11;
        if (n12 >= 0 && n11 <= (n12 = ((byte[])object).length - n10)) {
            n12 = this.remaining;
            if (n12 > 0) {
                int n13;
                if (n11 > n12) {
                    n11 = n12;
                }
                object2 = this.this$0;
                int n14 = this.position;
                QueueFile.access$300((QueueFile)object2, n14, object, n10, n11);
                object = this.this$0;
                n10 = this.position + n11;
                this.position = n13 = QueueFile.access$100((QueueFile)object, n10);
                this.remaining = n13 = this.remaining - n11;
                return n11;
            }
            return -1;
        }
        object = new ArrayIndexOutOfBoundsException;
        object();
        throw object;
    }
}

