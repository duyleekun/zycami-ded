/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.u;

import d.c.a.u.m;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

public class d
extends InputStream {
    private static final Queue c = m.f(0);
    private InputStream a;
    private IOException b;

    public static void a() {
        Queue queue;
        boolean bl2;
        while (!(bl2 = (queue = c).isEmpty())) {
            queue.remove();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static d q(InputStream inputStream) {
        Queue queue = c;
        // MONITORENTER : queue
        Object object = queue.poll();
        object = (d)object;
        // MONITOREXIT : queue
        if (object == null) {
            object = new Object();
        }
        ((d)object).C(inputStream);
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void B() {
        this.b = null;
        this.a = null;
        Queue queue = c;
        synchronized (queue) {
            queue.offer(this);
            return;
        }
    }

    public void C(InputStream inputStream) {
        this.a = inputStream;
    }

    public int available() {
        return this.a.available();
    }

    public void close() {
        this.a.close();
    }

    public IOException h() {
        return this.b;
    }

    public void mark(int n10) {
        this.a.mark(n10);
    }

    public boolean markSupported() {
        return this.a.markSupported();
    }

    public int read() {
        int n10;
        InputStream inputStream = this.a;
        try {
            n10 = inputStream.read();
        }
        catch (IOException iOException) {
            this.b = iOException;
            n10 = -1;
        }
        return n10;
    }

    public int read(byte[] byArray) {
        int n10;
        InputStream inputStream = this.a;
        try {
            n10 = inputStream.read(byArray);
        }
        catch (IOException iOException) {
            this.b = iOException;
            n10 = -1;
        }
        return n10;
    }

    public int read(byte[] byArray, int n10, int n11) {
        int n12;
        InputStream inputStream = this.a;
        try {
            n12 = inputStream.read(byArray, n10, n11);
        }
        catch (IOException iOException) {
            this.b = iOException;
            n12 = -1;
        }
        return n12;
    }

    public void reset() {
        synchronized (this) {
            InputStream inputStream = this.a;
            inputStream.reset();
            return;
        }
    }

    public long skip(long l10) {
        InputStream inputStream = this.a;
        try {
            l10 = inputStream.skip(l10);
        }
        catch (IOException iOException) {
            this.b = iOException;
            l10 = 0L;
        }
        return l10;
    }
}

