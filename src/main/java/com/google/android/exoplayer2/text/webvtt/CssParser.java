/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.google.android.exoplayer2.text.webvtt;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.webvtt.WebvttCssStyle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ColorParser;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class CssParser {
    private static final String PROPERTY_BGCOLOR = "background-color";
    private static final String PROPERTY_COLOR = "color";
    private static final String PROPERTY_FONT_FAMILY = "font-family";
    private static final String PROPERTY_FONT_STYLE = "font-style";
    private static final String PROPERTY_FONT_WEIGHT = "font-weight";
    private static final String PROPERTY_RUBY_POSITION = "ruby-position";
    private static final String PROPERTY_TEXT_COMBINE_UPRIGHT = "text-combine-upright";
    private static final String PROPERTY_TEXT_DECORATION = "text-decoration";
    private static final String RULE_END = "}";
    private static final String RULE_START = "{";
    private static final String TAG = "CssParser";
    private static final String VALUE_ALL = "all";
    private static final String VALUE_BOLD = "bold";
    private static final String VALUE_DIGITS = "digits";
    private static final String VALUE_ITALIC = "italic";
    private static final String VALUE_OVER = "over";
    private static final String VALUE_UNDER = "under";
    private static final String VALUE_UNDERLINE = "underline";
    private static final Pattern VOICE_NAME_PATTERN = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private final StringBuilder stringBuilder;
    private final ParsableByteArray styleInput;

    public CssParser() {
        Object object = new ParsableByteArray();
        this.styleInput = object;
        this.stringBuilder = object = new StringBuilder();
    }

    private void applySelectorToStyle(WebvttCssStyle webvttCssStyle, String objectArray) {
        int n10;
        String string2 = "";
        int n11 = string2.equals(objectArray);
        if (n11 != 0) {
            return;
        }
        n11 = objectArray.indexOf(91);
        int n12 = -1;
        int n13 = 1;
        if (n11 != n12) {
            Object object = VOICE_NAME_PATTERN;
            String string3 = objectArray.substring(n11);
            boolean bl2 = ((Matcher)(object = ((Pattern)object).matcher(string3))).matches();
            if (bl2) {
                object = (String)Assertions.checkNotNull(((Matcher)object).group(n13));
                webvttCssStyle.setTargetVoice((String)object);
            }
            objectArray = objectArray.substring(0, n11);
        }
        if ((n10 = (string2 = (objectArray = Util.split((String)objectArray, "\\."))[0]).indexOf(35)) != n12) {
            String string4 = string2.substring(0, n10);
            webvttCssStyle.setTargetTagName(string4);
            string2 = string2.substring(n10 += n13);
            webvttCssStyle.setTargetId(string2);
        } else {
            webvttCssStyle.setTargetTagName(string2);
        }
        n11 = objectArray.length;
        if (n11 > n13) {
            n11 = objectArray.length;
            objectArray = (String[])Util.nullSafeArrayCopyOfRange(objectArray, n13, n11);
            webvttCssStyle.setTargetClasses((String[])objectArray);
        }
    }

    private static boolean maybeSkipComment(ParsableByteArray parsableByteArray) {
        int n10 = parsableByteArray.getPosition();
        int n11 = parsableByteArray.limit();
        byte[] byArray = parsableByteArray.getData();
        int n12 = n10 + 2;
        if (n12 <= n11) {
            n12 = n10 + 1;
            int n13 = 47;
            if ((n10 = byArray[n10]) == n13) {
                n10 = n12 + 1;
                int n14 = 42;
                if ((n12 = byArray[n12]) == n14) {
                    while ((n12 = n10 + 1) < n11) {
                        if ((n10 = (int)((char)byArray[n10])) == n14 && (n10 = (int)((char)byArray[n12])) == n13) {
                            n10 = ++n12;
                            n11 = n12;
                            continue;
                        }
                        n10 = n12;
                    }
                    n10 = parsableByteArray.getPosition();
                    parsableByteArray.skipBytes(n11 -= n10);
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean maybeSkipWhitespace(ParsableByteArray parsableByteArray) {
        int n10;
        int n11 = parsableByteArray.getPosition();
        if ((n11 = (int)CssParser.peekCharAtPosition(parsableByteArray, n11)) != (n10 = 9) && n11 != (n10 = 10) && n11 != (n10 = 12) && n11 != (n10 = 13) && n11 != (n10 = 32)) {
            return false;
        }
        n11 = 1;
        parsableByteArray.skipBytes(n11);
        return n11 != 0;
    }

    private static String parseIdentifier(ParsableByteArray parsableByteArray, StringBuilder stringBuilder) {
        int n10 = 0;
        stringBuilder.setLength(0);
        int n11 = parsableByteArray.getPosition();
        int n12 = parsableByteArray.limit();
        while (n11 < n12 && n10 == 0) {
            int n13;
            byte[] byArray = parsableByteArray.getData();
            int n14 = byArray[n11];
            if (!(n14 >= (n13 = 65) && n14 <= (n13 = 90) || n14 >= (n13 = 97) && n14 <= (n13 = 122) || n14 >= (n13 = 48) && n14 <= (n13 = 57) || n14 == (n13 = 35) || n14 == (n13 = 45) || n14 == (n13 = 46) || n14 == (n13 = 95))) {
                n10 = 1;
                continue;
            }
            ++n11;
            stringBuilder.append((char)n14);
        }
        n10 = parsableByteArray.getPosition();
        parsableByteArray.skipBytes(n11 -= n10);
        return stringBuilder.toString();
    }

    public static String parseNextToken(ParsableByteArray parsableByteArray, StringBuilder charSequence) {
        CssParser.skipWhitespaceAndComments(parsableByteArray);
        int n10 = parsableByteArray.bytesLeft();
        if (n10 == 0) {
            return null;
        }
        CharSequence charSequence2 = "";
        n10 = (int)(((String)charSequence2).equals(charSequence = CssParser.parseIdentifier(parsableByteArray, charSequence)) ? 1 : 0);
        if (n10 == 0) {
            return charSequence;
        }
        char c10 = (char)parsableByteArray.readUnsignedByte();
        charSequence2 = new StringBuilder(1);
        ((StringBuilder)charSequence2).append(c10);
        return ((StringBuilder)charSequence2).toString();
    }

    private static String parsePropertyValue(ParsableByteArray parsableByteArray, StringBuilder stringBuilder) {
        StringBuilder stringBuilder2 = new StringBuilder();
        boolean bl2 = false;
        while (!bl2) {
            int n10 = parsableByteArray.getPosition();
            String string2 = CssParser.parseNextToken(parsableByteArray, stringBuilder);
            if (string2 == null) {
                return null;
            }
            String string3 = RULE_END;
            boolean bl3 = string3.equals(string2);
            if (!bl3 && !(bl3 = (string3 = ";").equals(string2))) {
                stringBuilder2.append(string2);
                continue;
            }
            parsableByteArray.setPosition(n10);
            bl2 = true;
        }
        return stringBuilder2.toString();
    }

    private static String parseSelector(ParsableByteArray object, StringBuilder charSequence) {
        CssParser.skipWhitespaceAndComments((ParsableByteArray)object);
        int n10 = ((ParsableByteArray)object).bytesLeft();
        int n11 = 5;
        if (n10 < n11) {
            return null;
        }
        String string2 = "::cue";
        String string3 = ((ParsableByteArray)object).readString(n11);
        n10 = (int)(string2.equals(string3) ? 1 : 0);
        if (n10 == 0) {
            return null;
        }
        n10 = ((ParsableByteArray)object).getPosition();
        string2 = CssParser.parseNextToken((ParsableByteArray)object, (StringBuilder)charSequence);
        if (string2 == null) {
            return null;
        }
        String string4 = RULE_START;
        boolean bl2 = string4.equals(string2);
        if (bl2) {
            ((ParsableByteArray)object).setPosition(n10);
            return "";
        }
        string3 = "(";
        n10 = (int)(string3.equals(string2) ? 1 : 0);
        if (n10 != 0) {
            string3 = CssParser.readCueTarget((ParsableByteArray)object);
        } else {
            n10 = 0;
            string3 = null;
        }
        object = CssParser.parseNextToken((ParsableByteArray)object, (StringBuilder)charSequence);
        charSequence = ")";
        boolean bl3 = ((String)charSequence).equals(object);
        if (!bl3) {
            return null;
        }
        return string3;
    }

    private static void parseStyleDeclaration(ParsableByteArray object, WebvttCssStyle webvttCssStyle, StringBuilder charSequence) {
        block26: {
            int n10;
            boolean bl2;
            String string2;
            String string3;
            block27: {
                int n11;
                CssParser.skipWhitespaceAndComments((ParsableByteArray)object);
                string3 = CssParser.parseIdentifier((ParsableByteArray)object, charSequence);
                String string4 = "";
                boolean bl3 = string4.equals(string3);
                if (bl3) {
                    return;
                }
                String string5 = ":";
                string2 = CssParser.parseNextToken((ParsableByteArray)object, charSequence);
                bl3 = string5.equals(string2);
                if (!bl3) {
                    return;
                }
                CssParser.skipWhitespaceAndComments((ParsableByteArray)object);
                string2 = CssParser.parsePropertyValue((ParsableByteArray)object, charSequence);
                if (string2 == null || (n11 = string4.equals(string2)) != 0) break block26;
                n11 = ((ParsableByteArray)object).getPosition();
                string5 = ";";
                boolean bl4 = string5.equals(charSequence = CssParser.parseNextToken((ParsableByteArray)object, charSequence));
                if (bl4) break block27;
                string5 = RULE_END;
                bl2 = string5.equals(charSequence);
                if (!bl2) break block26;
                ((ParsableByteArray)object).setPosition(n11);
            }
            if ((n10 = ((String)(object = PROPERTY_COLOR)).equals(string3)) != 0) {
                n10 = ColorParser.parseCssColor(string2);
                webvttCssStyle.setFontColor(n10);
            } else {
                object = PROPERTY_BGCOLOR;
                n10 = (int)(((String)object).equals(string3) ? 1 : 0);
                if (n10 != 0) {
                    n10 = ColorParser.parseCssColor(string2);
                    webvttCssStyle.setBackgroundColor(n10);
                } else {
                    object = PROPERTY_RUBY_POSITION;
                    n10 = (int)(((String)object).equals(string3) ? 1 : 0);
                    bl2 = true;
                    if (n10 != 0) {
                        object = VALUE_OVER;
                        n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                        if (n10 != 0) {
                            webvttCssStyle.setRubyPosition((int)(bl2 ? 1 : 0));
                        } else {
                            object = VALUE_UNDER;
                            n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                            if (n10 != 0) {
                                n10 = 2;
                                webvttCssStyle.setRubyPosition(n10);
                            }
                        }
                    } else {
                        object = PROPERTY_TEXT_COMBINE_UPRIGHT;
                        n10 = (int)(((String)object).equals(string3) ? 1 : 0);
                        if (n10 != 0) {
                            object = VALUE_ALL;
                            n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                            if (n10 == 0 && (n10 = (int)(string2.startsWith((String)(object = VALUE_DIGITS)) ? 1 : 0)) == 0) {
                                bl2 = false;
                                charSequence = null;
                            }
                            webvttCssStyle.setCombineUpright(bl2);
                        } else {
                            object = PROPERTY_TEXT_DECORATION;
                            n10 = (int)(((String)object).equals(string3) ? 1 : 0);
                            if (n10 != 0) {
                                object = VALUE_UNDERLINE;
                                n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                                if (n10 != 0) {
                                    webvttCssStyle.setUnderline(bl2);
                                }
                            } else {
                                object = PROPERTY_FONT_FAMILY;
                                n10 = (int)(((String)object).equals(string3) ? 1 : 0);
                                if (n10 != 0) {
                                    webvttCssStyle.setFontFamily(string2);
                                } else {
                                    object = PROPERTY_FONT_WEIGHT;
                                    n10 = (int)(((String)object).equals(string3) ? 1 : 0);
                                    if (n10 != 0) {
                                        object = VALUE_BOLD;
                                        n10 = (int)(((String)object).equals(string2) ? 1 : 0);
                                        if (n10 != 0) {
                                            webvttCssStyle.setBold(bl2);
                                        }
                                    } else {
                                        object = PROPERTY_FONT_STYLE;
                                        n10 = (int)(((String)object).equals(string3) ? 1 : 0);
                                        if (n10 != 0 && (n10 = (int)(((String)(object = VALUE_ITALIC)).equals(string2) ? 1 : 0)) != 0) {
                                            webvttCssStyle.setItalic(bl2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static char peekCharAtPosition(ParsableByteArray parsableByteArray, int n10) {
        return (char)parsableByteArray.getData()[n10];
    }

    private static String readCueTarget(ParsableByteArray parsableByteArray) {
        int n10 = parsableByteArray.getPosition();
        int n11 = parsableByteArray.limit();
        int n12 = 0;
        byte[] byArray = null;
        while (n10 < n11 && n12 == 0) {
            byArray = parsableByteArray.getData();
            int n13 = n10 + 1;
            n12 = 41;
            if ((n10 = (int)((char)byArray[n10])) == n12) {
                n12 = n10 = 1;
            } else {
                n12 = 0;
                byArray = null;
            }
            n10 = n13;
        }
        n10 += -1;
        n11 = parsableByteArray.getPosition();
        return parsableByteArray.readString(n10 -= n11).trim();
    }

    public static void skipStyleBlock(ParsableByteArray parsableByteArray) {
        String string2;
        boolean bl2;
        while (!(bl2 = TextUtils.isEmpty((CharSequence)(string2 = parsableByteArray.readLine())))) {
        }
    }

    public static void skipWhitespaceAndComments(ParsableByteArray parsableByteArray) {
        boolean bl2 = true;
        block0: while (true) {
            int n10;
            boolean bl3 = bl2;
            while ((n10 = parsableByteArray.bytesLeft()) > 0 && bl3) {
                bl3 = CssParser.maybeSkipWhitespace(parsableByteArray);
                if (bl3 || (bl3 = CssParser.maybeSkipComment(parsableByteArray))) continue block0;
                bl3 = false;
            }
            break;
        }
    }

    public List parseBlock(ParsableByteArray arrayList) {
        Object object = this.stringBuilder;
        ((StringBuilder)object).setLength(0);
        int n10 = ((ParsableByteArray)((Object)arrayList)).getPosition();
        CssParser.skipStyleBlock((ParsableByteArray)((Object)arrayList));
        Object object2 = this.styleInput;
        Object object3 = ((ParsableByteArray)((Object)arrayList)).getData();
        int n11 = ((ParsableByteArray)((Object)arrayList)).getPosition();
        ((ParsableByteArray)object2).reset((byte[])object3, n11);
        this.styleInput.setPosition(n10);
        arrayList = new ArrayList<Object>();
        while (true) {
            String string2;
            object = this.styleInput;
            object2 = this.stringBuilder;
            if ((object = CssParser.parseSelector((ParsableByteArray)object, (StringBuilder)object2)) == null) break;
            object2 = this.styleInput;
            object3 = this.stringBuilder;
            object3 = RULE_START;
            boolean bl2 = ((String)object3).equals(object2 = CssParser.parseNextToken((ParsableByteArray)object2, (StringBuilder)object3));
            if (!bl2) {
                return arrayList;
            }
            object2 = new WebvttCssStyle();
            this.applySelectorToStyle((WebvttCssStyle)object2, (String)object);
            n10 = 0;
            object = null;
            boolean bl3 = false;
            object3 = null;
            while (true) {
                boolean bl4;
                string2 = RULE_END;
                if (bl3) break;
                object = this.styleInput;
                n10 = ((ParsableByteArray)object).getPosition();
                object3 = this.styleInput;
                StringBuilder stringBuilder = this.stringBuilder;
                if ((object3 = CssParser.parseNextToken((ParsableByteArray)object3, stringBuilder)) != null && !(bl4 = string2.equals(object3))) {
                    bl4 = false;
                    string2 = null;
                } else {
                    bl4 = true;
                }
                if (!bl4) {
                    this.styleInput.setPosition(n10);
                    object = this.styleInput;
                    stringBuilder = this.stringBuilder;
                    CssParser.parseStyleDeclaration((ParsableByteArray)object, (WebvttCssStyle)object2, stringBuilder);
                }
                object = object3;
                bl3 = bl4;
            }
            n10 = (int)(string2.equals(object) ? 1 : 0);
            if (n10 == 0) continue;
            arrayList.add(object2);
        }
        return arrayList;
    }
}

