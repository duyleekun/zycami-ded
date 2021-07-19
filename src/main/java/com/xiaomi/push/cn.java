/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.cm;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class cn {
    private File a;
    private StringBuilder a;

    public void a() {
        Object object = this.a;
        int n10 = 1;
        Appendable appendable = new FileWriter((File)object, n10 != 0);
        object = this.a;
        object = ((StringBuilder)object).toString();
        ((Writer)appendable).write((String)object);
        ((OutputStreamWriter)appendable).flush();
        ((OutputStreamWriter)appendable).close();
        appendable = this.a;
        object = null;
        n10 = ((StringBuilder)appendable).length();
        try {
            ((StringBuilder)appendable).delete(0, n10);
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }

    public void a(cm object) {
        StringBuilder stringBuilder = this.a;
        CharSequence charSequence = new StringBuilder();
        int n10 = ((cm)object).a;
        ((StringBuilder)charSequence).append(n10);
        String string2 = "\t";
        ((StringBuilder)charSequence).append(string2);
        charSequence = ((StringBuilder)charSequence).toString();
        stringBuilder.append((String)charSequence);
        stringBuilder = this.a;
        charSequence = new StringBuilder();
        String string3 = ((cm)object).a;
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append(string2);
        object = ((cm)object).b;
        ((StringBuilder)charSequence).append((String)object);
        object = ((StringBuilder)charSequence).toString();
        stringBuilder.append((String)object);
        this.a.append("\r\n");
    }
}

