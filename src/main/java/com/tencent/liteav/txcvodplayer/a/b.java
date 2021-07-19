/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.util.Log
 */
package com.tencent.liteav.txcvodplayer.a;

import android.net.Uri;
import android.util.Log;
import com.tencent.liteav.txcvodplayer.a.a;
import com.tencent.liteav.txcvodplayer.a.b$1;
import com.tencent.liteav.txcvodplayer.a.b$a;
import java.io.File;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Node;

public class b {
    private static final String a = "b";
    private static b b;
    private ArrayList c;
    private HashSet d;
    private String e;
    private int f;
    private String g;

    static {
        b b10;
        b = b10 = new b();
    }

    public static b a() {
        return b;
    }

    private void a(String string2, String string3) {
        Object object = new StringBuilder();
        Object object2 = this.e;
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append("/");
        ((StringBuilder)object).append(string2);
        string2 = ((StringBuilder)object).toString();
        object2 = new b$1(this, string2, string3);
        object = new Thread((Runnable)object2, "vodCacheMgrDelfile");
        ((Thread)object).start();
    }

    private void b(b$a object) {
        String string2 = ((b$a)object).b();
        object = ((b$a)object).d();
        this.a(string2, (String)object);
    }

    public static /* synthetic */ String d() {
        return a;
    }

    private void e() {
        CharSequence charSequence = this.e;
        Object object = new File((String)charSequence);
        int n10 = ((File[])(object = object.listFiles())).length;
        if (n10 > 0) {
            object = a;
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("!!!Warning: TXVodPlayer cache directory is not empty ");
            String string2 = this.e;
            ((StringBuilder)charSequence).append(string2);
            string2 = "!!!";
            ((StringBuilder)charSequence).append(string2);
            charSequence = ((StringBuilder)charSequence).toString();
            Log.w((String)object, (String)charSequence);
        }
    }

    public static String g(String object) {
        StringBuilder stringBuilder = null;
        Object object2 = "MD5";
        object2 = MessageDigest.getInstance((String)object2);
        String string2 = "UTF-8";
        object = ((String)object).getBytes(string2);
        try {
            object = ((MessageDigest)object2).digest((byte[])object);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
            return null;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            noSuchAlgorithmException.printStackTrace();
            return null;
        }
        int n10 = ((Object)object).length * 2;
        stringBuilder = new StringBuilder(n10);
        n10 = ((Object)object).length;
        string2 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = object[i10] & 0xFF;
            int n12 = 16;
            if (n11 < n12) {
                String string3 = "0";
                stringBuilder.append(string3);
            }
            String string4 = Integer.toHexString(n11);
            stringBuilder.append(string4);
        }
        return stringBuilder.toString();
    }

    public void a(int n10) {
        this.f = n10;
    }

    public void a(b$a b$a) {
        Long l10;
        b$a.time = l10 = Long.valueOf(System.currentTimeMillis());
        this.c.remove(b$a);
        this.c.add(b$a);
        this.c();
    }

    public void a(String string2) {
        this.g = string2;
    }

    public void a(String string2, boolean bl2) {
        boolean bl3;
        Iterator iterator2 = this.d.iterator();
        while (bl3 = iterator2.hasNext()) {
            b$a b$a = (b$a)iterator2.next();
            Object object = b$a.b();
            boolean bl4 = ((String)object).equals(string2);
            if (!bl4) continue;
            iterator2.remove();
            if (!bl2) continue;
            this.b(b$a);
            object = this.c;
            ((ArrayList)object).remove(b$a);
            this.c();
        }
    }

    public void b(String object) {
        String string2 = "/";
        boolean bl2 = ((String)object).endsWith(string2);
        if (bl2) {
            string2 = "txvodcache";
            object = ((String)object).concat(string2);
        } else {
            string2 = "/txvodcache";
            object = ((String)object).concat(string2);
        }
        string2 = this.e;
        if (string2 != null && (bl2 = string2.equals(object))) {
            return;
        }
        this.e = object;
        if (object == null) {
            return;
        }
        string2 = this.e;
        object = new File(string2);
        ((File)object).mkdirs();
        boolean bl3 = this.b();
        if (!bl3) {
            this.e();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean b() {
        Object object = new ArrayList();
        this.c = object;
        object = new HashSet();
        this.d = object;
        object = new StringBuilder();
        Object object2 = this.e;
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append("/");
        object2 = "tx_cache.xml";
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        try {
            object2 = DocumentBuilderFactory.newInstance();
            object2 = ((DocumentBuilderFactory)object2).newDocumentBuilder();
            Object object3 = new File((String)object);
            object = ((DocumentBuilder)object2).parse((File)object3);
            object2 = "caches";
            object = object.getElementsByTagName((String)object2);
            object2 = null;
            object = object.item(0);
            for (object = object.getFirstChild(); object != null; object = object.getNextSibling()) {
                object2 = new b$a();
                for (object3 = object.getFirstChild(); object3 != null; object3 = object3.getNextSibling()) {
                    String string2;
                    Object object4 = object3.getNodeName();
                    boolean bl2 = ((String)object4).equals(string2 = "path");
                    if (bl2) {
                        object4 = object3.getFirstChild();
                        object4 = object4.getNodeValue();
                        ((b$a)object2).b((String)object4);
                        continue;
                    }
                    object4 = object3.getNodeName();
                    bl2 = ((String)object4).equals(string2 = "time");
                    if (bl2) {
                        object4 = object3.getFirstChild();
                        object4 = object4.getNodeValue();
                        long l10 = Long.parseLong((String)object4);
                        object4 = l10;
                        ((b$a)object2).a((Long)object4);
                        continue;
                    }
                    object4 = object3.getNodeName();
                    bl2 = ((String)object4).equals(string2 = "url");
                    if (bl2) {
                        object4 = object3.getFirstChild();
                        object4 = object4.getNodeValue();
                        ((b$a)object2).a((String)object4);
                        continue;
                    }
                    object4 = object3.getNodeName();
                    bl2 = ((String)object4).equals(string2 = "fileType");
                    if (!bl2) continue;
                    object4 = object3.getFirstChild();
                    object4 = object4.getNodeValue();
                    ((b$a)object2).c((String)object4);
                }
                object3 = this.c;
                ((ArrayList)object3).add(object2);
            }
            return true;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return true;
    }

    public String c(String string2) {
        int n10;
        String string3 = "voddrm.token.";
        int n11 = string2.indexOf(string3);
        if (n11 > (n10 = -1)) {
            int n12;
            int n13 = n11 + 13;
            CharSequence charSequence = ".";
            if ((n13 = string2.indexOf((String)charSequence, n13)) > n10 && n13 < (n12 = string2.length() + -1)) {
                charSequence = new StringBuilder();
                string3 = string2.substring(0, n11);
                ((StringBuilder)charSequence).append(string3);
                string2 = string2.substring(++n13);
                ((StringBuilder)charSequence).append(string2);
                string2 = ((StringBuilder)charSequence).toString();
            }
        }
        if ((n11 = string2.indexOf(string3 = "?")) > n10) {
            string2 = string2.substring(0, n11);
        }
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c() {
        try {
            Object object = DocumentBuilderFactory.newInstance();
            object = ((DocumentBuilderFactory)object).newDocumentBuilder();
            object = ((DocumentBuilder)object).newDocument();
            Object object2 = "caches";
            object2 = object.createElement((String)object2);
            object.appendChild((Node)object2);
            Object object3 = this.c;
            object3 = ((ArrayList)object3).iterator();
            while (true) {
                Object object4;
                Object object5;
                Object object6;
                boolean bl2;
                if (!(bl2 = object3.hasNext())) {
                    object2 = TransformerFactory.newInstance();
                    object2 = ((TransformerFactory)object2).newTransformer();
                    object3 = new DOMSource((Node)object);
                    object = new StreamResult();
                    object6 = this.e;
                    object5 = "tx_cache.xml";
                    object4 = new File((String)object6, (String)object5);
                    object4 = ((File)object4).getAbsolutePath();
                    ((StreamResult)object).setSystemId((String)object4);
                    ((Transformer)object2).transform((Source)object3, (Result)object);
                    object = System.out;
                    object2 = "File saved!";
                    ((PrintStream)object).println((String)object2);
                    return;
                }
                object4 = object3.next();
                object4 = (b$a)object4;
                object6 = "cache";
                object6 = object.createElement((String)object6);
                object2.appendChild((Node)object6);
                object5 = "path";
                object5 = object.createElement((String)object5);
                Object object7 = ((b$a)object4).b();
                object7 = object.createTextNode((String)object7);
                object5.appendChild((Node)object7);
                object6.appendChild((Node)object5);
                object5 = "time";
                object5 = object.createElement((String)object5);
                object7 = ((b$a)object4).c();
                object7 = ((Long)object7).toString();
                object7 = object.createTextNode((String)object7);
                object5.appendChild((Node)object7);
                object6.appendChild((Node)object5);
                object5 = "url";
                object5 = object.createElement((String)object5);
                object7 = ((b$a)object4).a();
                object7 = object.createTextNode((String)object7);
                object5.appendChild((Node)object7);
                object6.appendChild((Node)object5);
                object5 = "fileType";
                object5 = object.createElement((String)object5);
                object4 = ((b$a)object4).d();
                object4 = object.createTextNode((String)object4);
                object5.appendChild((Node)object4);
                object6.appendChild((Node)object5);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public a d(String object) {
        Object object2 = this.e;
        String string2 = null;
        if (object2 != null && object != null) {
            int n10;
            int n11;
            Object object3;
            boolean bl2;
            boolean bl3;
            object = this.c((String)object);
            Object object4 = this.e;
            object2 = new File((String)object4);
            boolean n112 = ((File)object2).mkdirs();
            if (!n112 && !(bl3 = ((File)object2).isDirectory())) {
                return null;
            }
            object2 = this.c.iterator();
            while (bl2 = object2.hasNext()) {
                object4 = (b$a)object2.next();
                object3 = ((b$a)object4).url;
                boolean bl4 = ((String)object3).equals(object);
                if (!bl4) continue;
                this.a((b$a)object4);
                this.d.add(object4);
                object2 = ((b$a)object4).path;
                string2 = this.e;
                object4 = ((b$a)object4).fileType;
                object = new a((String)object2, string2, (String)object4);
                return object;
            }
            object2 = this.c.iterator();
            while ((n11 = object2.hasNext()) != 0 && (n11 = ((ArrayList)(object4 = this.c)).size()) > (n10 = this.f)) {
                object3 = this.d;
                object4 = (b$a)object2.next();
                n10 = (int)(((HashSet)object3).contains(object4) ? 1 : 0);
                if (n10 != 0) continue;
                this.b((b$a)object4);
                object2.remove();
            }
            if ((object = this.f((String)object)) != null) {
                this.d.add(object);
                string2 = ((b$a)object).path;
                object4 = this.e;
                object = ((b$a)object).fileType;
                object2 = new a(string2, (String)object4, (String)object);
                return object2;
            }
        }
        return null;
    }

    public boolean e(String string2) {
        String string3;
        string2 = Uri.parse((String)string2);
        boolean bl2 = false;
        if (string2 != null && (string3 = string2.getPath()) != null && (string3 = string2.getScheme()) != null) {
            boolean bl3;
            String string4;
            string3 = string2.getScheme();
            boolean bl4 = string3.startsWith(string4 = "http");
            if (!bl4) {
                return false;
            }
            string3 = string2.getPath();
            bl4 = string3.endsWith(string4 = ".mp4");
            if (bl4 || (bl4 = (string3 = string2.getPath()).endsWith(string4 = "m3u8")) || (bl4 = (string3 = string2.getPath()).endsWith(string4 = ".MP4")) || (bl3 = (string2 = string2.getPath()).endsWith(string3 = "M3U8"))) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public b$a f(String charSequence) {
        String string2;
        String string3;
        b$a b$a = new b$a();
        b$a.url = charSequence;
        long l10 = System.currentTimeMillis();
        Object object = l10;
        b$a.time = object;
        object = com.tencent.liteav.txcvodplayer.a.b.g((String)charSequence);
        String string4 = (charSequence = Uri.parse((String)charSequence)).getPath();
        boolean bl2 = string4.endsWith(string3 = ".mp4");
        if (!bl2 && !(bl2 = (string4 = charSequence.getPath()).endsWith(string2 = ".MP4"))) {
            boolean bl3;
            string4 = charSequence.getPath();
            bl2 = string4.endsWith(string3 = ".m3u8");
            if (!bl2 && !(bl3 = ((String)(charSequence = charSequence.getPath())).endsWith(string4 = ".M3U8"))) {
                return null;
            }
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)object);
            object = ".m3u8.sqlite";
            ((StringBuilder)charSequence).append((String)object);
            charSequence = ((StringBuilder)charSequence).toString();
            b$a.b((String)charSequence);
            charSequence = "m3u8";
            b$a.c((String)charSequence);
        } else {
            charSequence = this.g;
            if (charSequence != null) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append((String)object);
                ((StringBuilder)charSequence).append(".");
                object = this.g;
                ((StringBuilder)charSequence).append((String)object);
                charSequence = ((StringBuilder)charSequence).toString();
                b$a.b((String)charSequence);
            } else {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append((String)object);
                ((StringBuilder)charSequence).append(string3);
                charSequence = ((StringBuilder)charSequence).toString();
                b$a.b((String)charSequence);
            }
            charSequence = "mp4";
            b$a.c((String)charSequence);
        }
        this.c.add(b$a);
        this.c();
        return b$a;
    }
}

