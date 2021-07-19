/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 *  org.xmlpull.v1.XmlPullParserFactory
 */
package com.xiaomi.push;

import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.fs;
import com.xiaomi.push.gd;
import com.xiaomi.push.gg;
import com.xiaomi.push.gh;
import com.xiaomi.push.gh$a;
import com.xiaomi.push.gi;
import com.xiaomi.push.gj;
import com.xiaomi.push.gl;
import com.xiaomi.push.gl$a;
import com.xiaomi.push.gl$b;
import com.xiaomi.push.gm;
import com.xiaomi.push.gn;
import com.xiaomi.push.gn$a;
import com.xiaomi.push.gq;
import com.xiaomi.push.gs;
import com.xiaomi.push.gt;
import com.xiaomi.push.service.ap;
import com.xiaomi.push.service.ap$b;
import com.xiaomi.push.service.ay;
import com.xiaomi.push.service.e;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class gr {
    private static XmlPullParser a;

    public static gg a(String object, String string2, XmlPullParser xmlPullParser) {
        boolean bl2;
        object = gq.a();
        string2 = "all";
        String string3 = "xm:chat";
        if ((object = ((gq)object).a(string2, string3)) != null && (bl2 = object instanceof e)) {
            return ((e)object).b(xmlPullParser);
        }
        return null;
    }

    public static gh a(XmlPullParser object, fs fs2) {
        Object object2;
        Object object3;
        int n10;
        int n11;
        String string2 = "";
        Object object4 = object.getAttributeValue(string2, "id");
        Object object5 = object.getAttributeValue(string2, "to");
        String string3 = object.getAttributeValue(string2, "from");
        String string4 = object.getAttributeValue(string2, "chid");
        gh$a gh$a = gh$a.a(object.getAttributeValue(string2, "type"));
        HashMap<String, String> hashMap = new HashMap<String, String>();
        boolean bl2 = false;
        gj gj2 = null;
        for (n11 = 0; n11 < (n10 = object.getAttributeCount()); ++n11) {
            object3 = object.getAttributeName(n11);
            object2 = object.getAttributeValue(string2, (String)object3);
            hashMap.put((String)object3, (String)object2);
        }
        string2 = null;
        n11 = 0;
        gj2 = null;
        n10 = 0;
        object3 = null;
        while (!bl2) {
            String string5;
            int n12;
            int n13 = object.next();
            if (n13 == (n12 = 2)) {
                object2 = object.getName();
                string5 = object.getNamespace();
                String string6 = "error";
                boolean bl3 = ((String)object2).equals(string6);
                if (bl3) {
                    object3 = gr.a((XmlPullParser)object);
                    continue;
                }
                gj2 = new gh();
                object2 = gr.a((String)object2, string5, (XmlPullParser)object);
                gj2.a((gg)object2);
                continue;
            }
            n12 = 3;
            if (n13 != n12 || (n13 = (int)(((String)(object2 = object.getName())).equals(string5 = "iq") ? 1 : 0)) == 0) continue;
            bl2 = true;
        }
        if (gj2 == null) {
            object = gh$a.a;
            if (object != gh$a && (object = gh$a.b) != gh$a) {
                gj2 = new gt();
            } else {
                object = new gs();
                ((gj)object).k((String)object4);
                ((gj)object).m(string3);
                ((gj)object).n((String)object5);
                object4 = gh$a.d;
                ((gh)object).a((gh$a)object4);
                ((gj)object).l(string4);
                object5 = gn$a.e;
                object4 = new gn((gn$a)object5);
                ((gj)object).a((gn)object4);
                fs2.a((gj)object);
                b.d("iq usage error. send packet in packet parser.");
                return null;
            }
        }
        gj2.k((String)object4);
        gj2.m((String)object5);
        gj2.l(string4);
        gj2.n(string3);
        ((gh)gj2).a(gh$a);
        gj2.a((gn)object3);
        ((gh)gj2).a(hashMap);
        return gj2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static gj a(XmlPullParser xmlPullParser) {
        int n10;
        String string2;
        Object object = xmlPullParser;
        Object object2 = "";
        Object object3 = "s";
        Object object4 = xmlPullParser.getAttributeValue((String)object2, (String)object3);
        int n11 = "1".equals(object4);
        String string3 = "message";
        int n12 = 2;
        Object object5 = "type";
        String string4 = "to";
        String string5 = "from";
        String string6 = "chid";
        Object object6 = "id";
        int n13 = 0;
        int n14 = 1;
        String string7 = null;
        if (n11 == 0) {
            boolean bl2;
            object3 = new gi();
            object4 = xmlPullParser.getAttributeValue((String)object2, (String)object6);
            if (object4 == null) {
                object4 = "ID_NOT_AVAILABLE";
            }
            ((gj)object3).k((String)object4);
            object4 = object.getAttributeValue((String)object2, string4);
            ((gj)object3).m((String)object4);
            object4 = object.getAttributeValue((String)object2, string5);
            ((gj)object3).n((String)object4);
            object4 = object.getAttributeValue((String)object2, string6);
            ((gj)object3).l((String)object4);
            object4 = object.getAttributeValue((String)object2, "appid");
            ((gi)object3).a((String)object4);
            object4 = "transient";
            try {
                object4 = object.getAttributeValue((String)object2, (String)object4);
            }
            catch (Exception exception) {
                n11 = 0;
                object4 = null;
            }
            string2 = "seq";
            try {
                string2 = object.getAttributeValue((String)object2, string2);
                bl2 = TextUtils.isEmpty((CharSequence)string2);
                if (!bl2) {
                    ((gi)object3).b(string2);
                }
            }
            catch (Exception exception) {}
            string2 = "mseq";
            try {
                string2 = object.getAttributeValue((String)object2, string2);
                bl2 = TextUtils.isEmpty((CharSequence)string2);
                if (!bl2) {
                    ((gi)object3).c(string2);
                }
            }
            catch (Exception exception) {}
            string2 = "fseq";
            try {
                string2 = object.getAttributeValue((String)object2, string2);
                bl2 = TextUtils.isEmpty((CharSequence)string2);
                if (!bl2) {
                    ((gi)object3).d(string2);
                }
            }
            catch (Exception exception) {}
            string2 = "status";
            try {
                string2 = object.getAttributeValue((String)object2, string2);
                bl2 = TextUtils.isEmpty((CharSequence)string2);
                if (!bl2) {
                    ((gi)object3).e(string2);
                }
            }
            catch (Exception exception) {}
            if ((n10 = TextUtils.isEmpty((CharSequence)object4)) == 0 && (n11 = ((String)object4).equalsIgnoreCase(string2 = "true")) != 0) {
                n11 = n14;
            } else {
                n11 = 0;
                object4 = null;
            }
            ((gi)object3).a(n11 != 0);
            object4 = object.getAttributeValue((String)object2, (String)object5);
            ((gi)object3).f((String)object4);
            object4 = gr.b(xmlPullParser);
            if (object4 != null && (n10 = ((String)object2).equals(string2 = ((String)object4).trim())) == 0) {
                ((gi)object3).j((String)object4);
            } else {
                gj.q();
            }
        } else {
            String string8;
            object4 = xmlPullParser.getAttributeValue((String)object2, string6);
            string6 = xmlPullParser.getAttributeValue((String)object2, (String)object6);
            string5 = xmlPullParser.getAttributeValue((String)object2, string5);
            string4 = xmlPullParser.getAttributeValue((String)object2, string4);
            object2 = xmlPullParser.getAttributeValue((String)object2, (String)object5);
            object5 = ap.a().a((String)object4, string4);
            if (object5 == null) {
                object5 = ap.a().a((String)object4, string5);
            }
            if (object5 == null) {
                object = new gd("the channel id is wrong while receiving a encrypted message");
                throw object;
            }
            int n15 = 0;
            object6 = null;
            while (true) {
                String string9;
                string8 = "error while receiving a encrypted message with wrong format";
                if (n13 != 0) break;
                int n16 = xmlPullParser.next();
                if (n16 == n12) {
                    string9 = xmlPullParser.getName();
                    n16 = (int)(((String)object3).equals(string9) ? 1 : 0);
                    if (n16 == 0) {
                        object = new gd(string8);
                        throw object;
                    }
                    n16 = xmlPullParser.next();
                    if (n16 != (n15 = 4)) {
                        object = new gd(string8);
                        throw object;
                    }
                    string9 = xmlPullParser.getText();
                    object6 = "5";
                    n15 = (int)(((String)object6).equals(object4) ? 1 : 0);
                    if (n15 == 0 && (n15 = (int)(((String)(object6 = "6")).equals(object4) ? 1 : 0)) == 0) {
                        gr.a(ay.a(ay.a(((ap$b)object5).h, string6), string9));
                        a.next();
                        string9 = a;
                        object6 = gr.a((XmlPullParser)string9);
                        continue;
                    }
                    object = new gi();
                    ((gj)object).l((String)object4);
                    ((gi)object).b(n14 != 0);
                    ((gj)object).n(string5);
                    ((gj)object).m(string4);
                    ((gj)object).k(string6);
                    ((gi)object).f((String)object2);
                    object2 = new gg((String)object3, null, null, null);
                    ((gg)object2).a(string9);
                    ((gj)object).a((gg)object2);
                    return object;
                }
                int n17 = 3;
                if (n16 != n17 || (n16 = (int)((string9 = xmlPullParser.getName()).equals(string3) ? 1 : 0)) == 0) continue;
                n13 = n14;
            }
            if (object6 != null) {
                return object6;
            }
            object = new gd(string8);
            throw object;
        }
        while (true) {
            if (n13 != 0) {
                ((gi)object3).i(string7);
                return object3;
            }
            n11 = xmlPullParser.next();
            if (n11 == n12) {
                object4 = xmlPullParser.getName();
                string2 = xmlPullParser.getNamespace();
                boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
                if (bl3) {
                    string2 = "xm";
                }
                if (bl3 = ((String)object4).equals(object5 = "subject")) {
                    object4 = gr.b(xmlPullParser);
                    object4 = gr.a(xmlPullParser);
                    ((gi)object3).g((String)object4);
                } else {
                    object5 = "body";
                    bl3 = ((String)object4).equals(object5);
                    if (bl3) {
                        object4 = object.getAttributeValue((String)object2, "encode");
                        string2 = gr.a(xmlPullParser);
                        bl3 = TextUtils.isEmpty((CharSequence)object4);
                        if (!bl3) {
                            ((gi)object3).a(string2, (String)object4);
                        } else {
                            ((gi)object3).h(string2);
                        }
                    } else {
                        object5 = "thread";
                        bl3 = ((String)object4).equals(object5);
                        if (bl3) {
                            if (string7 == null) {
                                string7 = xmlPullParser.nextText();
                            }
                        } else {
                            object5 = "error";
                            bl3 = ((String)object4).equals(object5);
                            if (bl3) {
                                object4 = gr.a(xmlPullParser);
                                ((gj)object3).a((gn)object4);
                            } else {
                                object4 = gr.a((String)object4, string2, (XmlPullParser)object);
                                ((gj)object3).a((gg)object4);
                            }
                        }
                    }
                }
                n10 = 3;
                continue;
            }
            n10 = 3;
            if (n11 != n10 || (n11 = (int)(((String)(object4 = xmlPullParser.getName())).equals(string3) ? 1 : 0)) == 0) continue;
            n13 = n14;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static gl a(XmlPullParser xmlPullParser) {
        CharSequence charSequence;
        Object object;
        Object object2;
        int n10;
        Object object3 = gl$b.a;
        String string2 = "";
        Object object4 = xmlPullParser.getAttributeValue(string2, "type");
        if (object4 != null && (n10 = ((String)object4).equals(string2)) == 0) {
            try {
                object3 = gl$b.valueOf((String)object4);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                object2 = System.err;
                object = new StringBuilder();
                charSequence = "Found invalid presence type ";
                ((StringBuilder)object).append((String)charSequence);
                ((StringBuilder)object).append((String)object4);
                object4 = ((StringBuilder)object).toString();
                ((PrintStream)object2).println((String)object4);
            }
        }
        object4 = new gl((gl$b)((Object)object3));
        object3 = xmlPullParser.getAttributeValue(string2, "to");
        ((gj)object4).m((String)object3);
        object3 = xmlPullParser.getAttributeValue(string2, "from");
        ((gj)object4).n((String)object3);
        object3 = xmlPullParser.getAttributeValue(string2, "chid");
        ((gj)object4).l((String)object3);
        object3 = xmlPullParser.getAttributeValue(string2, "id");
        if (object3 == null) {
            object3 = "ID_NOT_AVAILABLE";
        }
        ((gj)object4).k((String)object3);
        object3 = null;
        boolean bl2 = false;
        string2 = null;
        while (!bl2) {
            int n11;
            n10 = xmlPullParser.next();
            if (n10 == (n11 = 2)) {
                object2 = xmlPullParser.getName();
                object = xmlPullParser.getNamespace();
                charSequence = "status";
                boolean bl3 = ((String)object2).equals(charSequence);
                if (bl3) {
                    object2 = xmlPullParser.nextText();
                    ((gl)object4).a((String)object2);
                    continue;
                }
                charSequence = "priority";
                bl3 = ((String)object2).equals(charSequence);
                if (bl3) {
                    try {
                        object2 = xmlPullParser.nextText();
                        n10 = Integer.parseInt((String)object2);
                        ((gl)object4).a(n10);
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        ((gl)object4).a(0);
                    }
                    catch (NumberFormatException numberFormatException) {}
                    continue;
                }
                charSequence = "show";
                bl3 = ((String)object2).equals(charSequence);
                if (bl3) {
                    object2 = xmlPullParser.nextText();
                    try {
                        object = gl$a.valueOf((String)object2);
                        ((gl)object4).a((gl$a)((Object)object));
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        object = System.err;
                        charSequence = new StringBuilder();
                        String string3 = "Found invalid presence mode ";
                        ((StringBuilder)charSequence).append(string3);
                        ((StringBuilder)charSequence).append((String)object2);
                        object2 = ((StringBuilder)charSequence).toString();
                        ((PrintStream)object).println((String)object2);
                    }
                    continue;
                }
                charSequence = "error";
                bl3 = ((String)object2).equals(charSequence);
                if (bl3) {
                    object2 = gr.a(xmlPullParser);
                    ((gj)object4).a((gn)object2);
                    continue;
                }
                object2 = gr.a((String)object2, (String)object, xmlPullParser);
                ((gj)object4).a((gg)object2);
                continue;
            }
            n11 = 3;
            if (n10 != n11 || (n10 = (int)(((String)(object2 = xmlPullParser.getName())).equals(object = "presence") ? 1 : 0)) == 0) continue;
            bl2 = true;
        }
        return object4;
    }

    public static gm a(XmlPullParser xmlPullParser) {
        gm gm2 = null;
        boolean bl2 = false;
        while (!bl2) {
            String string2;
            String string3;
            int n10;
            int n11 = xmlPullParser.next();
            if (n11 == (n10 = 2)) {
                string3 = xmlPullParser.getName();
                gm2 = new gm(string3);
                continue;
            }
            n10 = 3;
            if (n11 != n10 || (n11 = (int)((string3 = xmlPullParser.getName()).equals(string2 = "error") ? 1 : 0)) == 0) continue;
            bl2 = true;
        }
        return gm2;
    }

    public static gn a(XmlPullParser object) {
        String string2;
        Object object2;
        String string3;
        int n10;
        int n11;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        boolean bl2 = false;
        int n12 = 0;
        Object object3 = null;
        String string4 = "-1";
        String string5 = null;
        String string6 = null;
        String string7 = null;
        for (n11 = 0; n11 < (n10 = object.getAttributeCount()); ++n11) {
            string3 = object.getAttributeName(n11);
            object2 = "code";
            n10 = (int)(string3.equals(object2) ? 1 : 0);
            string2 = "";
            if (n10 != 0) {
                string4 = object.getAttributeValue(string2, (String)object2);
            }
            if ((n10 = (int)((string3 = object.getAttributeName(n11)).equals(object2 = "type") ? 1 : 0)) != 0) {
                string7 = object.getAttributeValue(string2, (String)object2);
            }
            if ((n10 = (int)((string3 = object.getAttributeName(n11)).equals(object2 = "reason") ? 1 : 0)) == 0) continue;
            string6 = object.getAttributeValue(string2, (String)object2);
        }
        n11 = 0;
        string5 = null;
        n10 = 0;
        string3 = null;
        while (!bl2) {
            int n13;
            n12 = object.next();
            if (n12 == (n13 = 2)) {
                object3 = object.getName();
                n12 = (int)(((String)object3).equals(object2 = "text") ? 1 : 0);
                if (n12 != 0) {
                    string3 = object.nextText();
                    continue;
                }
                object3 = object.getName();
                string2 = "urn:ietf:params:xml:ns:xmpp-stanzas";
                object2 = object.getNamespace();
                boolean bl3 = string2.equals(object2);
                if (bl3) {
                    string5 = object3;
                    continue;
                }
                object3 = gr.a((String)object3, (String)object2, object);
                arrayList.add(object3);
                continue;
            }
            n13 = 3;
            if (n12 == n13) {
                object3 = object.getName();
                n12 = (int)(((String)object3).equals(object2 = "error") ? 1 : 0);
                if (n12 == 0) continue;
                bl2 = true;
                continue;
            }
            n13 = 4;
            if (n12 != n13) continue;
            string3 = object.getText();
        }
        object = string7 == null ? "cancel" : string7;
        n12 = Integer.parseInt(string4);
        string4 = object;
        string7 = string3;
        object2 = new gn(n12, (String)object, string6, string5, string3, arrayList);
        return object2;
    }

    private static String a(XmlPullParser xmlPullParser) {
        int n10 = xmlPullParser.getDepth();
        String string2 = "";
        int n11;
        int n12;
        while ((n12 = xmlPullParser.next()) != (n11 = 3) || (n12 = xmlPullParser.getDepth()) != n10) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            string2 = xmlPullParser.getText();
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
        }
        return string2;
    }

    private static void a(byte[] byArray) {
        Object object;
        XmlPullParser xmlPullParser = a;
        if (xmlPullParser == null) {
            xmlPullParser = XmlPullParserFactory.newInstance();
            xmlPullParser = xmlPullParser.newPullParser();
            a = xmlPullParser;
            object = "http://xmlpull.org/v1/doc/features.html#process-namespaces";
            boolean bl2 = true;
            try {
                xmlPullParser.setFeature((String)object, bl2);
            }
            catch (XmlPullParserException xmlPullParserException) {
                xmlPullParserException.printStackTrace();
            }
        }
        xmlPullParser = a;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byArray);
        object = new InputStreamReader(byteArrayInputStream);
        xmlPullParser.setInput((Reader)object);
    }

    private static String b(XmlPullParser xmlPullParser) {
        int n10;
        for (int i10 = 0; i10 < (n10 = xmlPullParser.getAttributeCount()); ++i10) {
            String string2 = "xml:lang";
            String string3 = xmlPullParser.getAttributeName(i10);
            boolean bl2 = string2.equals(string3);
            if (!(bl2 || (n10 = (int)((string2 = "lang").equals(string3) ? 1 : 0)) != 0 && (n10 = (int)((string2 = "xml").equals(string3 = xmlPullParser.getAttributePrefix(i10)) ? 1 : 0)) != 0)) {
                continue;
            }
            return xmlPullParser.getAttributeValue(i10);
        }
        return null;
    }
}

