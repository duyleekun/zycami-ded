/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Closure;
import com.mob.tools.java8.Closure$IClosure;
import com.mob.tools.java8.Closure$IClosureV;
import com.mob.tools.java8.FlowIterator;
import com.mob.tools.java8.FlowIterator$BufferedReaderIterator;
import com.mob.tools.java8.FlowIterator$FileReaderIterator$1;
import com.mob.tools.java8.FlowIterator$FileReaderIterator$2;
import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.Charset;

public class FlowIterator$FileReaderIterator
implements FlowIterator {
    private BufferedReader br;
    private Charset charset;
    private File file;
    private FlowIterator$BufferedReaderIterator it;

    public FlowIterator$FileReaderIterator(File file, Charset charset) {
        this.file = file;
        this.charset = charset;
    }

    public static /* synthetic */ File access$100(FlowIterator$FileReaderIterator flowIterator$FileReaderIterator) {
        return flowIterator$FileReaderIterator.file;
    }

    public static /* synthetic */ Charset access$200(FlowIterator$FileReaderIterator flowIterator$FileReaderIterator) {
        return flowIterator$FileReaderIterator.charset;
    }

    public static /* synthetic */ BufferedReader access$300(FlowIterator$FileReaderIterator flowIterator$FileReaderIterator) {
        return flowIterator$FileReaderIterator.br;
    }

    public static /* synthetic */ BufferedReader access$302(FlowIterator$FileReaderIterator flowIterator$FileReaderIterator, BufferedReader bufferedReader) {
        flowIterator$FileReaderIterator.br = bufferedReader;
        return bufferedReader;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void finish() {
        synchronized (this) {
            Object object = null;
            this.it = null;
            object = this.br;
            if (object != null) {
                object = new FlowIterator$FileReaderIterator$2(this);
                Closure.uncheck((Closure$IClosureV)object);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean hasNext() {
        synchronized (this) {
            Object object = this.br;
            if (object == null) {
                FlowIterator$BufferedReaderIterator flowIterator$BufferedReaderIterator;
                object = new FlowIterator$FileReaderIterator$1(this);
                object = Closure.uncheck((Closure$IClosure)object);
                this.br = object = (BufferedReader)object;
                this.it = flowIterator$BufferedReaderIterator = new FlowIterator$BufferedReaderIterator((BufferedReader)object);
            }
            if ((object = this.it) == null) return false;
            boolean bl2 = ((FlowIterator$BufferedReaderIterator)object).hasNext();
            if (!bl2) return false;
            return true;
        }
    }

    public String next() {
        Object object = this.it;
        object = object == null ? null : ((FlowIterator$BufferedReaderIterator)object).next();
        return object;
    }
}

