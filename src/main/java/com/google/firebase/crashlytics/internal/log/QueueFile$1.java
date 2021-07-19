/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.log;

import com.google.firebase.crashlytics.internal.log.QueueFile;
import com.google.firebase.crashlytics.internal.log.QueueFile$ElementReader;
import java.io.InputStream;

public class QueueFile$1
implements QueueFile$ElementReader {
    public boolean first = true;
    public final /* synthetic */ QueueFile this$0;
    public final /* synthetic */ StringBuilder val$builder;

    public QueueFile$1(QueueFile queueFile, StringBuilder stringBuilder) {
        this.this$0 = queueFile;
        this.val$builder = stringBuilder;
    }

    public void read(InputStream object, int n10) {
        boolean bl2 = this.first;
        if (bl2) {
            bl2 = false;
            object = null;
            this.first = false;
        } else {
            object = this.val$builder;
            String string2 = ", ";
            ((StringBuilder)object).append(string2);
        }
        this.val$builder.append(n10);
    }
}

