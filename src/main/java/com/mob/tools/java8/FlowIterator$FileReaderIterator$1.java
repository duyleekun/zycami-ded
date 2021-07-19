/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Closure$IClosure;
import com.mob.tools.java8.FlowIterator$FileReaderIterator;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

public class FlowIterator$FileReaderIterator$1
implements Closure$IClosure {
    public final /* synthetic */ FlowIterator$FileReaderIterator this$0;

    public FlowIterator$FileReaderIterator$1(FlowIterator$FileReaderIterator flowIterator$FileReaderIterator) {
        this.this$0 = flowIterator$FileReaderIterator;
    }

    public BufferedReader call() {
        long l10;
        Object object = FlowIterator$FileReaderIterator.access$100(this.this$0);
        Closeable closeable = new FileInputStream((File)object);
        object = FlowIterator$FileReaderIterator.access$100(this.this$0);
        long l11 = ((File)object).length();
        long l12 = l11 - (l10 = 0x100000L);
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 < 0) {
            Charset charset = FlowIterator$FileReaderIterator.access$200(this.this$0);
            object = new InputStreamReader((InputStream)closeable, charset);
        } else {
            int n10 = 0x100000;
            object = new BufferedInputStream((InputStream)closeable, n10);
            Charset charset = FlowIterator$FileReaderIterator.access$200(this.this$0);
            closeable = new InputStreamReader((InputStream)object, charset);
            object = closeable;
        }
        closeable = new BufferedReader((Reader)object);
        return closeable;
    }
}

