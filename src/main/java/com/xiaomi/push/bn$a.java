/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.bn;
import com.xiaomi.push.fl;
import com.xiaomi.push.fx;
import com.xiaomi.push.gf;
import com.xiaomi.push.gj;
import java.text.DateFormat;
import java.util.Date;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class bn$a
implements fx,
gf {
    public final /* synthetic */ bn a;
    public String a;

    public bn$a(bn object, boolean bl2) {
        this.a = object;
        object = bl2 ? " RCV " : " Sent ";
        this.a = object;
    }

    public void a(fl object) {
        StringBuilder stringBuilder;
        boolean bl2 = bn.a;
        Object object2 = "[Slim] ";
        if (bl2) {
            stringBuilder = new StringBuilder();
            stringBuilder.append((String)object2);
            object2 = bn.a(this.a);
            Date date = new Date();
            object2 = ((DateFormat)object2).format(date);
            stringBuilder.append((String)object2);
            object2 = this.a;
            stringBuilder.append((String)object2);
            object = ((fl)object).toString();
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append((String)object2);
            object2 = bn.a(this.a);
            Date date = new Date();
            object2 = ((DateFormat)object2).format(date);
            stringBuilder.append((String)object2);
            object2 = this.a;
            stringBuilder.append((String)object2);
            stringBuilder.append(" Blob [");
            object2 = ((fl)object).a();
            stringBuilder.append((String)object2);
            object2 = ",";
            stringBuilder.append((String)object2);
            int n10 = ((fl)object).a();
            stringBuilder.append(n10);
            stringBuilder.append((String)object2);
            object = ((fl)object).e();
            stringBuilder.append((String)object);
            object = "]";
        }
        stringBuilder.append((String)object);
        b.c(stringBuilder.toString());
    }

    public void a(gj object) {
        StringBuilder stringBuilder;
        boolean bl2 = bn.a;
        Object object2 = "[Slim] ";
        if (bl2) {
            stringBuilder = new StringBuilder();
            stringBuilder.append((String)object2);
            object2 = bn.a(this.a);
            Date date = new Date();
            object2 = ((DateFormat)object2).format(date);
            stringBuilder.append((String)object2);
            object2 = this.a;
            stringBuilder.append((String)object2);
            object2 = " PKT ";
            stringBuilder.append((String)object2);
            object = ((gj)object).a();
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append((String)object2);
            object2 = bn.a(this.a);
            Date date = new Date();
            object2 = ((DateFormat)object2).format(date);
            stringBuilder.append((String)object2);
            object2 = this.a;
            stringBuilder.append((String)object2);
            stringBuilder.append(" PKT [");
            object2 = ((gj)object).k();
            stringBuilder.append((String)object2);
            object2 = ",";
            stringBuilder.append((String)object2);
            object = ((gj)object).j();
            stringBuilder.append((String)object);
            object = "]";
        }
        stringBuilder.append((String)object);
        b.c(stringBuilder.toString());
    }

    public boolean a(gj gj2) {
        return true;
    }
}

