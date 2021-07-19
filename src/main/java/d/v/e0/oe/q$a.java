/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package d.v.e0.oe;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import j$.time.LocalDate;
import j$.time.format.DateTimeFormatter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class q$a
extends Handler {
    private static final int c = 0;
    private static final int d = 1;
    private BufferedWriter a;
    private File b;

    public q$a(File file, Looper looper) {
        super(looper);
        this.b = file;
    }

    private void b() {
        block17: {
            Object object = this.b;
            Object object2 = "log.txt";
            Object object3 = new File((File)object, (String)object2);
            boolean bl2 = true;
            object2 = new FileWriter((File)object3, bl2);
            object = new BufferedWriter((Writer)object2);
            this.a = object;
            boolean bl3 = ((File)object3).exists();
            if (!bl3) break block17;
            object3 = "yyyy-MM-dd HH:mm:ss";
            object3 = DateTimeFormatter.ofPattern((String)object3);
            object = LocalDate.now();
            object3 = ((LocalDate)object).format((DateTimeFormatter)object3);
            object = this.a;
            object2 = "\n";
            ((Writer)object).write((String)object2);
            object = this.a;
            object2 = "-----------------------";
            ((Writer)object).write((String)object2);
            object = this.a;
            try {
                ((Writer)object).write((String)object3);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
                object3 = this.a;
                if (object3 == null) break block17;
                try {
                    ((BufferedWriter)object3).close();
                }
                catch (IOException iOException2) {
                    iOException2.printStackTrace();
                }
            }
        }
    }

    private void c(String object) {
        BufferedWriter bufferedWriter = this.a;
        if (bufferedWriter != null) {
            bufferedWriter.append((CharSequence)object);
            object = this.a;
            ((BufferedWriter)object).newLine();
            object = this.a;
            try {
                ((BufferedWriter)object).close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    public void a(String string2) {
        string2 = this.obtainMessage(1, string2);
        this.sendMessage((Message)string2);
    }

    public void handleMessage(Message object) {
        int n10 = object.what;
        if (n10 != 0) {
            object = (String)object.obj;
            this.c((String)object);
        } else {
            this.b();
        }
    }
}

