/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.java8;

import com.mob.tools.java8.Closure;
import com.mob.tools.java8.Closure$IClosure;
import com.mob.tools.java8.FlowIterator;
import com.mob.tools.java8.FlowIterator$BufferedReaderIterator$1;
import java.io.BufferedReader;

public class FlowIterator$BufferedReaderIterator
implements FlowIterator {
    private BufferedReader br;
    private String nextLine;

    public FlowIterator$BufferedReaderIterator(BufferedReader bufferedReader) {
        this.br = bufferedReader;
        this.readNext();
    }

    public static /* synthetic */ BufferedReader access$000(FlowIterator$BufferedReaderIterator flowIterator$BufferedReaderIterator) {
        return flowIterator$BufferedReaderIterator.br;
    }

    private void readNext() {
        Object object = new FlowIterator$BufferedReaderIterator$1(this);
        this.nextLine = object = (String)Closure.uncheck((Closure$IClosure)object);
    }

    public void finish() {
    }

    public boolean hasNext() {
        boolean bl2;
        String string2 = this.nextLine;
        if (string2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public String next() {
        String string2 = this.nextLine;
        this.readNext();
        return string2;
    }
}

