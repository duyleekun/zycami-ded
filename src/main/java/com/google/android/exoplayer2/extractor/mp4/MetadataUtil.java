/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class MetadataUtil {
    private static final String LANGUAGE_UNDEFINED = "und";
    private static final int PICTURE_TYPE_FRONT_COVER = 3;
    private static final int SHORT_TYPE_ALBUM = 6384738;
    private static final int SHORT_TYPE_ARTIST = 4280916;
    private static final int SHORT_TYPE_COMMENT = 6516084;
    private static final int SHORT_TYPE_COMPOSER_1 = 6516589;
    private static final int SHORT_TYPE_COMPOSER_2 = 0x777274;
    private static final int SHORT_TYPE_ENCODER = 7630703;
    private static final int SHORT_TYPE_GENRE = 6776174;
    private static final int SHORT_TYPE_LYRICS = 7108978;
    private static final int SHORT_TYPE_NAME_1 = 7233901;
    private static final int SHORT_TYPE_NAME_2 = 7631467;
    private static final int SHORT_TYPE_YEAR = 6578553;
    public static final String[] STANDARD_GENRES = new String[]{"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};
    private static final String TAG = "MetadataUtil";
    private static final int TYPE_ALBUM_ARTIST = 1631670868;
    private static final int TYPE_COMPILATION = 1668311404;
    private static final int TYPE_COVER_ART = 1668249202;
    private static final int TYPE_DISK_NUMBER = 1684632427;
    private static final int TYPE_GAPLESS_ALBUM = 1885823344;
    private static final int TYPE_GENRE = 1735291493;
    private static final int TYPE_GROUPING = 6779504;
    private static final int TYPE_INTERNAL = 0x2D2D2D2D;
    private static final int TYPE_RATING = 1920233063;
    private static final int TYPE_SORT_ALBUM = 1936679276;
    private static final int TYPE_SORT_ALBUM_ARTIST = 1936679265;
    private static final int TYPE_SORT_ARTIST = 1936679282;
    private static final int TYPE_SORT_COMPOSER = 1936679791;
    private static final int TYPE_SORT_TRACK_NAME = 1936682605;
    private static final int TYPE_TEMPO = 1953329263;
    private static final int TYPE_TOP_BYTE_COPYRIGHT = 169;
    private static final int TYPE_TOP_BYTE_REPLACEMENT = 253;
    private static final int TYPE_TRACK_NUMBER = 1953655662;
    private static final int TYPE_TV_SHOW = 1953919848;
    private static final int TYPE_TV_SORT_SHOW = 1936683886;

    private MetadataUtil() {
    }

    private static CommentFrame parseCommentAttribute(int n10, ParsableByteArray object) {
        int n11;
        int n12 = ((ParsableByteArray)object).readInt();
        int n13 = ((ParsableByteArray)object).readInt();
        if (n13 == (n11 = 1684108385)) {
            ((ParsableByteArray)object).skipBytes(8);
            String string2 = ((ParsableByteArray)object).readNullTerminatedString(n12 += -16);
            object = new CommentFrame(LANGUAGE_UNDEFINED, string2, string2);
            return object;
        }
        object = "Failed to parse comment attribute: ";
        String string3 = String.valueOf(Atom.getAtomTypeString(n10));
        n12 = string3.length();
        string3 = n12 != 0 ? ((String)object).concat(string3) : new String((String)object);
        Log.w(TAG, string3);
        return null;
    }

    private static ApicFrame parseCoverArt(ParsableByteArray object) {
        int n10 = ((ParsableByteArray)object).readInt();
        int n11 = ((ParsableByteArray)object).readInt();
        String string2 = TAG;
        int n12 = 1684108385;
        if (n11 == n12) {
            String string3;
            n11 = Atom.parseFullAtomFlags(((ParsableByteArray)object).readInt());
            if (n11 == (n12 = 13)) {
                string3 = "image/jpeg";
            } else {
                n12 = 14;
                if (n11 == n12) {
                    string3 = "image/png";
                } else {
                    n12 = 0;
                    string3 = null;
                }
            }
            if (string3 == null) {
                StringBuilder stringBuilder = new StringBuilder(41);
                stringBuilder.append("Unrecognized cover art flags: ");
                stringBuilder.append(n11);
                object = stringBuilder.toString();
                Log.w(string2, (String)object);
                return null;
            }
            ((ParsableByteArray)object).skipBytes(4);
            byte[] byArray = new byte[n10 += -16];
            ((ParsableByteArray)object).readBytes(byArray, 0, n10);
            object = new ApicFrame(string3, null, 3, byArray);
            return object;
        }
        Log.w(string2, "Failed to parse cover art attribute");
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Metadata$Entry parseIlstElement(ParsableByteArray parsableByteArray) {
        Throwable throwable2;
        int n10;
        int n11;
        block55: {
            block56: {
                boolean bl2;
                String string2;
                block54: {
                    int n12;
                    int n13;
                    block53: {
                        n11 = parsableByteArray.getPosition();
                        n10 = parsableByteArray.readInt();
                        n11 += n10;
                        n10 = parsableByteArray.readInt();
                        n13 = n10 >> 24 & 0xFF;
                        if (n13 == (n12 = 169) || n13 == (n12 = 253)) break block53;
                        n13 = 1735291493;
                        if (n10 == n13) {
                            TextInformationFrame textInformationFrame = MetadataUtil.parseStandardGenreAttribute(parsableByteArray);
                            parsableByteArray.setPosition(n11);
                            return textInformationFrame;
                        }
                        n13 = 1684632427;
                        if (n10 == n13) {
                            String string3 = "TPOS";
                            TextInformationFrame textInformationFrame = MetadataUtil.parseIndexAndCountAttribute(n10, string3, parsableByteArray);
                            parsableByteArray.setPosition(n11);
                            return textInformationFrame;
                        }
                        n13 = 1953655662;
                        if (n10 == n13) {
                            String string4 = "TRCK";
                            TextInformationFrame textInformationFrame = MetadataUtil.parseIndexAndCountAttribute(n10, string4, parsableByteArray);
                            parsableByteArray.setPosition(n11);
                            return textInformationFrame;
                        }
                        n13 = 1953329263;
                        n12 = 0;
                        string2 = null;
                        bl2 = true;
                        if (n10 == n13) {
                            String string5 = "TBPM";
                            Id3Frame id3Frame = MetadataUtil.parseUint8Attribute(n10, string5, parsableByteArray, bl2, false);
                            parsableByteArray.setPosition(n11);
                            return id3Frame;
                        }
                        n13 = 1668311404;
                        if (n10 == n13) {
                            String string6 = "TCMP";
                            Id3Frame id3Frame = MetadataUtil.parseUint8Attribute(n10, string6, parsableByteArray, bl2, bl2);
                            parsableByteArray.setPosition(n11);
                            return id3Frame;
                        }
                        n13 = 1668249202;
                        if (n10 == n13) {
                            ApicFrame apicFrame = MetadataUtil.parseCoverArt(parsableByteArray);
                            parsableByteArray.setPosition(n11);
                            return apicFrame;
                        }
                        n13 = 1631670868;
                        if (n10 == n13) {
                            String string7 = "TPE2";
                            TextInformationFrame textInformationFrame = MetadataUtil.parseTextAttribute(n10, string7, parsableByteArray);
                            parsableByteArray.setPosition(n11);
                            return textInformationFrame;
                        }
                        n13 = 1936682605;
                        if (n10 == n13) {
                            String string8 = "TSOT";
                            TextInformationFrame textInformationFrame = MetadataUtil.parseTextAttribute(n10, string8, parsableByteArray);
                            parsableByteArray.setPosition(n11);
                            return textInformationFrame;
                        }
                        n13 = 1936679276;
                        if (n10 == n13) {
                            String string9 = "TSO2";
                            TextInformationFrame textInformationFrame = MetadataUtil.parseTextAttribute(n10, string9, parsableByteArray);
                            parsableByteArray.setPosition(n11);
                            return textInformationFrame;
                        }
                        n13 = 1936679282;
                        if (n10 == n13) {
                            String string10 = "TSOA";
                            TextInformationFrame textInformationFrame = MetadataUtil.parseTextAttribute(n10, string10, parsableByteArray);
                            parsableByteArray.setPosition(n11);
                            return textInformationFrame;
                        }
                        n13 = 1936679265;
                        if (n10 == n13) {
                            String string11 = "TSOP";
                            TextInformationFrame textInformationFrame = MetadataUtil.parseTextAttribute(n10, string11, parsableByteArray);
                            parsableByteArray.setPosition(n11);
                            return textInformationFrame;
                        }
                        n13 = 1936679791;
                        if (n10 == n13) {
                            String string12 = "TSOC";
                            TextInformationFrame textInformationFrame = MetadataUtil.parseTextAttribute(n10, string12, parsableByteArray);
                            parsableByteArray.setPosition(n11);
                            return textInformationFrame;
                        }
                        n13 = 1920233063;
                        if (n10 == n13) {
                            String string13 = "ITUNESADVISORY";
                            Id3Frame id3Frame = MetadataUtil.parseUint8Attribute(n10, string13, parsableByteArray, false, false);
                            parsableByteArray.setPosition(n11);
                            return id3Frame;
                        }
                        n13 = 1885823344;
                        if (n10 == n13) {
                            String string14 = "ITUNESGAPLESS";
                            Id3Frame id3Frame = MetadataUtil.parseUint8Attribute(n10, string14, parsableByteArray, false, bl2);
                            parsableByteArray.setPosition(n11);
                            return id3Frame;
                        }
                        n13 = 1936683886;
                        if (n10 == n13) {
                            String string15 = "TVSHOWSORT";
                            TextInformationFrame textInformationFrame = MetadataUtil.parseTextAttribute(n10, string15, parsableByteArray);
                            parsableByteArray.setPosition(n11);
                            return textInformationFrame;
                        }
                        n13 = 1953919848;
                        if (n10 == n13) {
                            String string16 = "TVSHOW";
                            TextInformationFrame textInformationFrame = MetadataUtil.parseTextAttribute(n10, string16, parsableByteArray);
                            parsableByteArray.setPosition(n11);
                            return textInformationFrame;
                        }
                        n13 = 0x2D2D2D2D;
                        if (n10 != n13) break block54;
                        try {
                            Id3Frame id3Frame = MetadataUtil.parseInternalAttribute(parsableByteArray, n11);
                            parsableByteArray.setPosition(n11);
                            return id3Frame;
                        }
                        catch (Throwable throwable2) {}
                    }
                    n13 = 0xFFFFFF & n10;
                    n12 = 6516084;
                    if (n13 == n12) {
                        CommentFrame commentFrame = MetadataUtil.parseCommentAttribute(n10, parsableByteArray);
                        parsableByteArray.setPosition(n11);
                        return commentFrame;
                    }
                    n12 = 7233901;
                    if (n13 == n12 || n13 == (n12 = 7631467)) break block55;
                    n12 = 6516589;
                    if (n13 == n12 || n13 == (n12 = 0x777274)) break block56;
                    n12 = 6578553;
                    if (n13 == n12) {
                        String string17 = "TDRC";
                        TextInformationFrame textInformationFrame = MetadataUtil.parseTextAttribute(n10, string17, parsableByteArray);
                        parsableByteArray.setPosition(n11);
                        return textInformationFrame;
                    }
                    n12 = 4280916;
                    if (n13 == n12) {
                        String string18 = "TPE1";
                        TextInformationFrame textInformationFrame = MetadataUtil.parseTextAttribute(n10, string18, parsableByteArray);
                        parsableByteArray.setPosition(n11);
                        return textInformationFrame;
                    }
                    n12 = 7630703;
                    if (n13 == n12) {
                        String string19 = "TSSE";
                        TextInformationFrame textInformationFrame = MetadataUtil.parseTextAttribute(n10, string19, parsableByteArray);
                        parsableByteArray.setPosition(n11);
                        return textInformationFrame;
                    }
                    n12 = 6384738;
                    if (n13 == n12) {
                        String string20 = "TALB";
                        TextInformationFrame textInformationFrame = MetadataUtil.parseTextAttribute(n10, string20, parsableByteArray);
                        parsableByteArray.setPosition(n11);
                        return textInformationFrame;
                    }
                    n12 = 7108978;
                    if (n13 == n12) {
                        String string21 = "USLT";
                        TextInformationFrame textInformationFrame = MetadataUtil.parseTextAttribute(n10, string21, parsableByteArray);
                        parsableByteArray.setPosition(n11);
                        return textInformationFrame;
                    }
                    n12 = 6776174;
                    if (n13 == n12) {
                        String string22 = "TCON";
                        TextInformationFrame textInformationFrame = MetadataUtil.parseTextAttribute(n10, string22, parsableByteArray);
                        parsableByteArray.setPosition(n11);
                        return textInformationFrame;
                    }
                    n12 = 6779504;
                    if (n13 == n12) {
                        String string23 = "TIT1";
                        TextInformationFrame textInformationFrame = MetadataUtil.parseTextAttribute(n10, string23, parsableByteArray);
                        parsableByteArray.setPosition(n11);
                        return textInformationFrame;
                    }
                }
                String string24 = TAG;
                string2 = "Skipped unknown metadata entry: ";
                String string25 = Atom.getAtomTypeString(n10);
                string25 = String.valueOf(string25);
                bl2 = string25.length();
                string25 = bl2 ? string2.concat(string25) : new String(string2);
                Log.d(string24, string25);
                parsableByteArray.setPosition(n11);
                return null;
            }
            String string26 = "TCOM";
            TextInformationFrame textInformationFrame = MetadataUtil.parseTextAttribute(n10, string26, parsableByteArray);
            parsableByteArray.setPosition(n11);
            return textInformationFrame;
        }
        String string27 = "TIT2";
        TextInformationFrame textInformationFrame = MetadataUtil.parseTextAttribute(n10, string27, parsableByteArray);
        parsableByteArray.setPosition(n11);
        return textInformationFrame;
        parsableByteArray.setPosition(n11);
        throw throwable2;
    }

    private static TextInformationFrame parseIndexAndCountAttribute(int n10, String string2, ParsableByteArray object) {
        int n11;
        int n12 = ((ParsableByteArray)object).readInt();
        int n13 = ((ParsableByteArray)object).readInt();
        if (n13 == (n11 = 1684108385) && n12 >= (n13 = 22)) {
            ((ParsableByteArray)object).skipBytes(10);
            n12 = ((ParsableByteArray)object).readUnsignedShort();
            if (n12 > 0) {
                n10 = 11;
                StringBuilder stringBuilder = new StringBuilder(n10);
                stringBuilder.append(n12);
                String string3 = stringBuilder.toString();
                int n14 = ((ParsableByteArray)object).readUnsignedShort();
                if (n14 > 0) {
                    string3 = String.valueOf(string3);
                    String string4 = String.valueOf(string3);
                    n12 = string4.length() + 12;
                    stringBuilder = new StringBuilder(n12);
                    stringBuilder.append(string3);
                    stringBuilder.append("/");
                    stringBuilder.append(n14);
                    string3 = stringBuilder.toString();
                }
                object = new TextInformationFrame(string2, null, string3);
                return object;
            }
        }
        string2 = "Failed to parse index/count attribute: ";
        String string5 = String.valueOf(Atom.getAtomTypeString(n10));
        int n15 = string5.length();
        string5 = n15 != 0 ? string2.concat(string5) : new String(string2);
        Log.w(TAG, string5);
        return null;
    }

    private static Id3Frame parseInternalAttribute(ParsableByteArray object, int n10) {
        int n11;
        int n12;
        int n13 = n12 = -1;
        int n14 = n12;
        String string2 = null;
        String string3 = null;
        while ((n11 = ((ParsableByteArray)object).getPosition()) < n10) {
            n11 = ((ParsableByteArray)object).getPosition();
            int n15 = ((ParsableByteArray)object).readInt();
            int n16 = ((ParsableByteArray)object).readInt();
            ((ParsableByteArray)object).skipBytes(4);
            int n17 = 1835360622;
            if (n16 == n17) {
                string2 = ((ParsableByteArray)object).readNullTerminatedString(n15 += -12);
                continue;
            }
            n17 = 1851878757;
            if (n16 == n17) {
                string3 = ((ParsableByteArray)object).readNullTerminatedString(n15 += -12);
                continue;
            }
            n17 = 1684108385;
            if (n16 == n17) {
                n13 = n11;
                n14 = n15;
            }
            ((ParsableByteArray)object).skipBytes(n15 += -12);
        }
        if (string2 != null && string3 != null && n13 != n12) {
            ((ParsableByteArray)object).setPosition(n13);
            n10 = 16;
            ((ParsableByteArray)object).skipBytes(n10);
            object = ((ParsableByteArray)object).readNullTerminatedString(n14 -= n10);
            InternalFrame internalFrame = new InternalFrame(string2, string3, (String)object);
            return internalFrame;
        }
        return null;
    }

    public static MdtaMetadataEntry parseMdtaMetadataEntryFromIlst(ParsableByteArray object, int n10, String string2) {
        int n11;
        while ((n11 = ((ParsableByteArray)object).getPosition()) < n10) {
            int n12;
            int n13 = ((ParsableByteArray)object).readInt();
            int n14 = ((ParsableByteArray)object).readInt();
            if (n14 == (n12 = 1684108385)) {
                n10 = ((ParsableByteArray)object).readInt();
                n11 = ((ParsableByteArray)object).readInt();
                byte[] byArray = new byte[n13 += -16];
                ((ParsableByteArray)object).readBytes(byArray, 0, n13);
                object = new MdtaMetadataEntry(string2, byArray, n11, n10);
                return object;
            }
            ((ParsableByteArray)object).setPosition(n11 += n13);
        }
        return null;
    }

    private static TextInformationFrame parseStandardGenreAttribute(ParsableByteArray object) {
        Object object2;
        int n10;
        int n11 = MetadataUtil.parseUint8AttributeValue((ParsableByteArray)object);
        if (n11 > 0 && n11 <= (n10 = ((String[])(object2 = STANDARD_GENRES)).length)) {
            object = object2[n11 += -1];
        } else {
            n11 = 0;
            object = null;
        }
        if (object != null) {
            object2 = new TextInformationFrame("TCON", null, (String)object);
            return object2;
        }
        Log.w(TAG, "Failed to parse standard genre code");
        return null;
    }

    private static TextInformationFrame parseTextAttribute(int n10, String string2, ParsableByteArray object) {
        int n11;
        int n12 = ((ParsableByteArray)object).readInt();
        int n13 = ((ParsableByteArray)object).readInt();
        if (n13 == (n11 = 1684108385)) {
            ((ParsableByteArray)object).skipBytes(8);
            String string3 = ((ParsableByteArray)object).readNullTerminatedString(n12 += -16);
            object = new TextInformationFrame(string2, null, string3);
            return object;
        }
        string2 = "Failed to parse text attribute: ";
        String string4 = String.valueOf(Atom.getAtomTypeString(n10));
        int n14 = string4.length();
        string4 = n14 != 0 ? string2.concat(string4) : new String(string2);
        Log.w(TAG, string4);
        return null;
    }

    private static Id3Frame parseUint8Attribute(int n10, String string2, ParsableByteArray object, boolean bl2, boolean bl3) {
        int n11 = MetadataUtil.parseUint8AttributeValue((ParsableByteArray)object);
        if (bl3) {
            bl3 = true;
            n11 = Math.min((int)(bl3 ? 1 : 0), n11);
        }
        bl3 = false;
        if (n11 >= 0) {
            Id3Frame id3Frame;
            if (bl2) {
                object = Integer.toString(n11);
                id3Frame = new TextInformationFrame(string2, null, (String)object);
            } else {
                object = Integer.toString(n11);
                String string3 = LANGUAGE_UNDEFINED;
                id3Frame = new CommentFrame(string3, string2, (String)object);
            }
            return id3Frame;
        }
        string2 = "Failed to parse uint8 attribute: ";
        String string4 = String.valueOf(Atom.getAtomTypeString(n10));
        n11 = string4.length();
        string4 = n11 != 0 ? string2.concat(string4) : new String(string2);
        Log.w(TAG, string4);
        return null;
    }

    private static int parseUint8AttributeValue(ParsableByteArray parsableByteArray) {
        parsableByteArray.skipBytes(4);
        int n10 = parsableByteArray.readInt();
        int n11 = 1684108385;
        if (n10 == n11) {
            parsableByteArray.skipBytes(8);
            return parsableByteArray.readUnsignedByte();
        }
        Log.w(TAG, "Failed to parse uint8 attribute value");
        return -1;
    }

    public static void setFormatGaplessInfo(int n10, GaplessInfoHolder gaplessInfoHolder, Format$Builder format$Builder) {
        int n11 = 1;
        if (n10 == n11 && (n10 = (int)(gaplessInfoHolder.hasGaplessInfo() ? 1 : 0)) != 0) {
            n10 = gaplessInfoHolder.encoderDelay;
            Format$Builder format$Builder2 = format$Builder.setEncoderDelay(n10);
            int n12 = gaplessInfoHolder.encoderPadding;
            format$Builder2.setEncoderPadding(n12);
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static void setFormatMetadata(int var0, Metadata var1_1, Metadata var2_2, Format$Builder var3_3, Metadata ... var4_4) {
        block6: {
            block5: {
                var6_6 = 0;
                var7_7 = new Metadata$Entry[]{};
                var5_5 = new Metadata(var7_7);
                var8_8 = 1;
                if (var0 != var8_8) break block5;
                if (var1_1 /* !! */  == null) ** GOTO lbl-1000
                break block6;
            }
            var9_9 = 2;
            if (var0 == var9_9 && var2_2 != null) {
                var10_10 = null;
                for (var0 = 0; var0 < (var9_9 = var2_2.length()); ++var0) {
                    var1_1 /* !! */  = var2_2.get(var0);
                    var11_11 = var1_1 /* !! */  instanceof MdtaMetadataEntry;
                    if (!var11_11) continue;
                    var1_1 /* !! */  = (MdtaMetadataEntry)var1_1 /* !! */ ;
                    var13_13 = "com.android.capture.fps";
                    var12_12 = var1_1 /* !! */ .key;
                    var11_11 = var13_13.equals(var12_12);
                    if (!var11_11) continue;
                    var2_2 = new Metadata$Entry[var8_8];
                    var2_2[0] = var1_1 /* !! */ ;
                    var1_1 /* !! */  = var10_10 = new Metadata(var2_2);
                    break;
                }
            } else lbl-1000:
            // 3 sources

            {
                var1_1 /* !! */  = var5_5;
            }
        }
        var0 = var4_4.length;
        while (var6_6 < var0) {
            var2_2 = var4_4[var6_6];
            var1_1 /* !! */  = var1_1 /* !! */ .copyWithAppendedEntriesFrom((Metadata)var2_2);
            ++var6_6;
        }
        var0 = var1_1 /* !! */ .length();
        if (var0 > 0) {
            var3_3.setMetadata(var1_1 /* !! */ );
        }
    }
}

