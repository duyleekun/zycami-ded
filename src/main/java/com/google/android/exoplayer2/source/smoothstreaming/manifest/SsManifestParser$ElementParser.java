/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 *  org.xmlpull.v1.XmlPullParser
 */
package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser$MissingFieldException;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser$ProtectionParser;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser$QualityLevelParser;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser$StreamIndexParser;
import java.util.LinkedList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public abstract class SsManifestParser$ElementParser {
    private final String baseUri;
    private final List normalizedAttributes;
    private final SsManifestParser$ElementParser parent;
    private final String tag;

    public SsManifestParser$ElementParser(SsManifestParser$ElementParser linkedList, String string2, String string3) {
        this.parent = linkedList;
        this.baseUri = string2;
        this.tag = string3;
        this.normalizedAttributes = linkedList = new LinkedList();
    }

    private SsManifestParser$ElementParser newChildParser(SsManifestParser$ElementParser ssManifestParser$ElementParser, String object, String string2) {
        String string3 = "QualityLevel";
        boolean bl2 = string3.equals(object);
        if (bl2) {
            object = new SsManifestParser$QualityLevelParser(ssManifestParser$ElementParser, string2);
            return object;
        }
        string3 = "Protection";
        bl2 = string3.equals(object);
        if (bl2) {
            object = new SsManifestParser$ProtectionParser(ssManifestParser$ElementParser, string2);
            return object;
        }
        string3 = "StreamIndex";
        boolean bl3 = string3.equals(object);
        if (bl3) {
            object = new SsManifestParser$StreamIndexParser(ssManifestParser$ElementParser, string2);
            return object;
        }
        return null;
    }

    public void addChild(Object object) {
    }

    public abstract Object build();

    public final Object getNormalizedAttribute(String object) {
        List list;
        int n10;
        SsManifestParser$ElementParser ssManifestParser$ElementParser = null;
        for (int i10 = 0; i10 < (n10 = (list = this.normalizedAttributes).size()); ++i10) {
            list = (Pair)this.normalizedAttributes.get(i10);
            String string2 = (String)((Pair)list).first;
            boolean bl2 = string2.equals(object);
            if (!bl2) continue;
            return ((Pair)list).second;
        }
        ssManifestParser$ElementParser = this.parent;
        object = ssManifestParser$ElementParser == null ? null : ssManifestParser$ElementParser.getNormalizedAttribute((String)object);
        return object;
    }

    public boolean handleChildInline(String string2) {
        return false;
    }

    public final Object parse(XmlPullParser xmlPullParser) {
        int n10;
        int n11;
        int n12 = 0;
        int n13 = 0;
        while ((n11 = xmlPullParser.getEventType()) != (n10 = 1)) {
            Object object;
            int n14 = 2;
            if (n11 != n14) {
                n10 = 3;
                if (n11 != n10) {
                    n10 = 4;
                    if (n11 == n10 && n12 != 0 && n13 == 0) {
                        this.parseText(xmlPullParser);
                    }
                } else if (n12 != 0) {
                    if (n13 > 0) {
                        n13 += -1;
                    } else {
                        object = xmlPullParser.getName();
                        this.parseEndTag(xmlPullParser);
                        n11 = (int)(this.handleChildInline((String)object) ? 1 : 0);
                        if (n11 == 0) {
                            return this.build();
                        }
                    }
                }
            } else {
                String string2 = this.tag;
                object = xmlPullParser.getName();
                n14 = (int)(string2.equals(object) ? 1 : 0);
                if (n14 != 0) {
                    this.parseStartTag(xmlPullParser);
                    n12 = n10;
                } else if (n12 != 0) {
                    if (n13 > 0) {
                        ++n13;
                    } else {
                        n14 = (int)(this.handleChildInline((String)object) ? 1 : 0);
                        if (n14 != 0) {
                            this.parseStartTag(xmlPullParser);
                        } else {
                            string2 = this.baseUri;
                            if ((object = this.newChildParser(this, (String)object, string2)) == null) {
                                n13 = n10;
                            } else {
                                object = ((SsManifestParser$ElementParser)object).parse(xmlPullParser);
                                this.addChild(object);
                            }
                        }
                    }
                }
            }
            xmlPullParser.next();
        }
        return null;
    }

    public final boolean parseBoolean(XmlPullParser object, String string2, boolean bl2) {
        if ((object = object.getAttributeValue(null, string2)) != null) {
            return Boolean.parseBoolean((String)object);
        }
        return bl2;
    }

    public void parseEndTag(XmlPullParser xmlPullParser) {
    }

    public final int parseInt(XmlPullParser object, String object2, int n10) {
        if ((object = object.getAttributeValue(null, (String)object2)) != null) {
            try {
                return Integer.parseInt((String)object);
            }
            catch (NumberFormatException numberFormatException) {
                object2 = new ParserException(numberFormatException);
                throw object2;
            }
        }
        return n10;
    }

    public final long parseLong(XmlPullParser object, String object2, long l10) {
        if ((object = object.getAttributeValue(null, (String)object2)) != null) {
            try {
                return Long.parseLong((String)object);
            }
            catch (NumberFormatException numberFormatException) {
                object2 = new ParserException(numberFormatException);
                throw object2;
            }
        }
        return l10;
    }

    public final int parseRequiredInt(XmlPullParser object, String object2) {
        if ((object = object.getAttributeValue(null, (String)object2)) != null) {
            try {
                return Integer.parseInt((String)object);
            }
            catch (NumberFormatException numberFormatException) {
                object2 = new ParserException(numberFormatException);
                throw object2;
            }
        }
        object = new SsManifestParser$MissingFieldException((String)object2);
        throw object;
    }

    public final long parseRequiredLong(XmlPullParser object, String object2) {
        if ((object = object.getAttributeValue(null, (String)object2)) != null) {
            try {
                return Long.parseLong((String)object);
            }
            catch (NumberFormatException numberFormatException) {
                object2 = new ParserException(numberFormatException);
                throw object2;
            }
        }
        object = new SsManifestParser$MissingFieldException((String)object2);
        throw object;
    }

    public final String parseRequiredString(XmlPullParser object, String string2) {
        if ((object = object.getAttributeValue(null, string2)) != null) {
            return object;
        }
        object = new SsManifestParser$MissingFieldException(string2);
        throw object;
    }

    public void parseStartTag(XmlPullParser xmlPullParser) {
    }

    public void parseText(XmlPullParser xmlPullParser) {
    }

    public final void putNormalizedAttribute(String string2, Object object) {
        List list = this.normalizedAttributes;
        string2 = Pair.create((Object)string2, (Object)object);
        list.add(string2);
    }
}

