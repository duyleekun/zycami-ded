/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.google.android.exoplayer2.text.webvtt;

import android.text.TextUtils;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.webvtt.CssParser;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.google.android.exoplayer2.text.webvtt.WebvttParserUtil;
import com.google.android.exoplayer2.text.webvtt.WebvttSubtitle;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.List;

public final class WebvttDecoder
extends SimpleSubtitleDecoder {
    private static final String COMMENT_START = "NOTE";
    private static final int EVENT_COMMENT = 1;
    private static final int EVENT_CUE = 3;
    private static final int EVENT_END_OF_FILE = 0;
    private static final int EVENT_NONE = 255;
    private static final int EVENT_STYLE_BLOCK = 2;
    private static final String STYLE_START = "STYLE";
    private final CssParser cssParser;
    private final ParsableByteArray parsableWebvttData;

    public WebvttDecoder() {
        super("WebvttDecoder");
        Object object = new ParsableByteArray();
        this.parsableWebvttData = object;
        this.cssParser = object = new CssParser();
    }

    private static int getNextEvent(ParsableByteArray parsableByteArray) {
        int n10 = -1;
        int n11 = 0;
        int n12 = n10;
        while (n12 == n10) {
            n11 = parsableByteArray.getPosition();
            String string2 = parsableByteArray.readLine();
            if (string2 == null) {
                n12 = 0;
                string2 = null;
                continue;
            }
            String string3 = STYLE_START;
            boolean bl2 = string3.equals(string2);
            if (bl2) {
                n12 = 2;
                continue;
            }
            string3 = COMMENT_START;
            n12 = (int)(string2.startsWith(string3) ? 1 : 0);
            if (n12 != 0) {
                n12 = 1;
                continue;
            }
            n12 = 3;
        }
        parsableByteArray.setPosition(n11);
        return n12;
    }

    private static void skipComment(ParsableByteArray parsableByteArray) {
        String string2;
        boolean bl2;
        while (!(bl2 = TextUtils.isEmpty((CharSequence)(string2 = parsableByteArray.readLine())))) {
        }
    }

    public Subtitle decode(byte[] object, int n10, boolean n11) {
        Object object2 = this.parsableWebvttData;
        ((ParsableByteArray)object2).reset((byte[])object, n10);
        object = new ArrayList;
        ((ArrayList)object)();
        ArrayList<Object> arrayList = this.parsableWebvttData;
        try {
            WebvttParserUtil.validateWebvttHeaderLine((ParsableByteArray)((Object)arrayList));
        }
        catch (ParserException parserException) {
            arrayList = new ArrayList<Object>((Throwable)parserException);
            throw arrayList;
        }
        while ((n10 = (int)(TextUtils.isEmpty((CharSequence)((Object)(arrayList = this.parsableWebvttData.readLine()))) ? 1 : 0)) == 0) {
        }
        arrayList = new ArrayList<Object>();
        while ((n11 = WebvttDecoder.getNextEvent((ParsableByteArray)(object2 = this.parsableWebvttData))) != 0) {
            int n12 = 1;
            if (n11 == n12) {
                object2 = this.parsableWebvttData;
                WebvttDecoder.skipComment((ParsableByteArray)object2);
                continue;
            }
            n12 = 2;
            if (n11 == n12) {
                n11 = (int)(arrayList.isEmpty() ? 1 : 0);
                if (n11 != 0) {
                    this.parsableWebvttData.readLine();
                    object2 = this.cssParser;
                    ParsableByteArray parsableByteArray = this.parsableWebvttData;
                    object2 = ((CssParser)object2).parseBlock(parsableByteArray);
                    object.addAll(object2);
                    continue;
                }
                object = new SubtitleDecoderException;
                ((SubtitleDecoderException)object)("A style block was found after the first cue.");
                throw object;
            }
            n12 = 3;
            if (n11 != n12 || (object2 = WebvttCueParser.parseCue(this.parsableWebvttData, (List)object)) == null) continue;
            arrayList.add(object2);
        }
        object = new WebvttSubtitle;
        ((WebvttSubtitle)object)(arrayList);
        return object;
    }
}

