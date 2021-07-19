/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Xml
 */
package cn.sharesdk.framework.utils;

import android.util.Xml;
import cn.sharesdk.framework.utils.k$a;
import java.util.HashMap;
import org.xml.sax.ContentHandler;

public class k {
    public HashMap a(String string2) {
        k$a k$a = new k$a();
        Xml.parse((String)string2, (ContentHandler)k$a);
        return k$a.a();
    }
}

