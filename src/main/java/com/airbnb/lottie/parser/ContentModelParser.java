/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.CircleShape;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.content.GradientFill;
import com.airbnb.lottie.model.content.GradientStroke;
import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.model.content.Repeater;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.model.content.ShapePath;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.parser.AnimatableTransformParser;
import com.airbnb.lottie.parser.CircleShapeParser;
import com.airbnb.lottie.parser.GradientFillParser;
import com.airbnb.lottie.parser.GradientStrokeParser;
import com.airbnb.lottie.parser.MergePathsParser;
import com.airbnb.lottie.parser.PolystarShapeParser;
import com.airbnb.lottie.parser.RectangleShapeParser;
import com.airbnb.lottie.parser.RepeaterParser;
import com.airbnb.lottie.parser.ShapeFillParser;
import com.airbnb.lottie.parser.ShapeGroupParser;
import com.airbnb.lottie.parser.ShapePathParser;
import com.airbnb.lottie.parser.ShapeStrokeParser;
import com.airbnb.lottie.parser.ShapeTrimPathParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonReader$Options;
import com.airbnb.lottie.utils.Logger;

public class ContentModelParser {
    private static JsonReader$Options NAMES = JsonReader$Options.of("ty", "d");

    private ContentModelParser() {
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public static ContentModel parse(JsonReader jsonReader, LottieComposition object) {
        String string2;
        Object object2;
        int n10;
        int n11;
        block36: {
            block37: {
                int n12;
                jsonReader.beginObject();
                n10 = n11 = 2;
                while (true) {
                    int n13 = jsonReader.hasNext();
                    n12 = 1;
                    float f10 = Float.MIN_VALUE;
                    Object var7_7 = null;
                    if (n13 == 0) return null;
                    object2 = NAMES;
                    n13 = jsonReader.selectName((JsonReader$Options)object2);
                    if (n13 == 0) break;
                    if (n13 != n12) {
                        jsonReader.skipName();
                        jsonReader.skipValue();
                        continue;
                    }
                    n10 = jsonReader.nextInt();
                }
                object2 = jsonReader.nextString();
                if (object2 == null) {
                    return null;
                }
                ((String)object2).hashCode();
                int n14 = -1;
                float f11 = 0.0f / 0.0f;
                int n15 = ((String)object2).hashCode();
                switch (n15) {
                    case 3710: {
                        string2 = "tr";
                        n11 = (int)(((String)object2).equals(string2) ? 1 : 0);
                        if (n11 == 0) break;
                        n11 = 12;
                        break block36;
                    }
                    case 3705: {
                        string2 = "tm";
                        n11 = (int)(((String)object2).equals(string2) ? 1 : 0);
                        if (n11 == 0) break;
                        n11 = 11;
                        break block36;
                    }
                    case 3681: {
                        string2 = "st";
                        n11 = (int)(((String)object2).equals(string2) ? 1 : 0);
                        if (n11 == 0) break;
                        n11 = 10;
                        break block36;
                    }
                    case 3679: {
                        string2 = "sr";
                        n11 = (int)(((String)object2).equals(string2) ? 1 : 0);
                        if (n11 == 0) break;
                        n11 = 9;
                        break block36;
                    }
                    case 3669: {
                        string2 = "sh";
                        n11 = (int)(((String)object2).equals(string2) ? 1 : 0);
                        if (n11 == 0) break;
                        n11 = 8;
                        break block36;
                    }
                    case 3646: {
                        string2 = "rp";
                        n11 = (int)(((String)object2).equals(string2) ? 1 : 0);
                        if (n11 == 0) break;
                        n11 = 7;
                        break block36;
                    }
                    case 3633: {
                        string2 = "rc";
                        n11 = (int)(((String)object2).equals(string2) ? 1 : 0);
                        if (n11 == 0) break;
                        n11 = 6;
                        break block36;
                    }
                    case 3488: {
                        string2 = "mm";
                        n11 = (int)(((String)object2).equals(string2) ? 1 : 0);
                        if (n11 == 0) break;
                        n11 = 5;
                        break block36;
                    }
                    case 3308: {
                        string2 = "gs";
                        n11 = (int)(((String)object2).equals(string2) ? 1 : 0);
                        if (n11 == 0) break;
                        n11 = 4;
                        break block36;
                    }
                    case 3307: {
                        string2 = "gr";
                        n11 = (int)(((String)object2).equals(string2) ? 1 : 0);
                        if (n11 == 0) break;
                        n11 = 3;
                        break block36;
                    }
                    case 3295: {
                        String string3 = "gf";
                        n12 = (int)(((String)object2).equals(string3) ? 1 : 0);
                        if (n12 == 0) {
                            break;
                        }
                        break block36;
                    }
                    case 3270: {
                        string2 = "fl";
                        n11 = (int)(((String)object2).equals(string2) ? 1 : 0);
                        if (n11 == 0) break;
                        n11 = n12;
                        break block36;
                    }
                    case 3239: {
                        string2 = "el";
                        n11 = (int)(((String)object2).equals(string2) ? 1 : 0);
                        if (n11 != 0) break block37;
                    }
                }
                n11 = n14;
                break block36;
            }
            n11 = 0;
            string2 = null;
        }
        switch (n11) {
            default: {
                object = new StringBuilder();
                string2 = "Unknown shape type ";
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append((String)object2);
                object = ((StringBuilder)object).toString();
                Logger.warning((String)object);
                break;
            }
            case 12: {
                AnimatableTransform animatableTransform = AnimatableTransformParser.parse(jsonReader, (LottieComposition)object);
                break;
            }
            case 11: {
                ShapeTrimPath shapeTrimPath = ShapeTrimPathParser.parse(jsonReader, (LottieComposition)object);
                break;
            }
            case 10: {
                ShapeStroke shapeStroke = ShapeStrokeParser.parse(jsonReader, (LottieComposition)object);
                break;
            }
            case 9: {
                PolystarShape polystarShape = PolystarShapeParser.parse(jsonReader, (LottieComposition)object);
                break;
            }
            case 8: {
                ShapePath shapePath = ShapePathParser.parse(jsonReader, (LottieComposition)object);
                break;
            }
            case 7: {
                Repeater repeater = RepeaterParser.parse(jsonReader, (LottieComposition)object);
                break;
            }
            case 6: {
                RectangleShape rectangleShape = RectangleShapeParser.parse(jsonReader, (LottieComposition)object);
                break;
            }
            case 5: {
                MergePaths mergePaths = MergePathsParser.parse(jsonReader);
                string2 = "Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().";
                ((LottieComposition)object).addWarning(string2);
                break;
            }
            case 4: {
                GradientStroke gradientStroke = GradientStrokeParser.parse(jsonReader, (LottieComposition)object);
                break;
            }
            case 3: {
                ShapeGroup shapeGroup = ShapeGroupParser.parse(jsonReader, (LottieComposition)object);
                break;
            }
            case 2: {
                GradientFill gradientFill = GradientFillParser.parse(jsonReader, (LottieComposition)object);
                break;
            }
            case 1: {
                ShapeFill shapeFill = ShapeFillParser.parse(jsonReader, (LottieComposition)object);
                break;
            }
            case 0: {
                CircleShape circleShape = CircleShapeParser.parse(jsonReader, (LottieComposition)object, n10);
            }
        }
        while (true) {
            boolean bl2;
            if (!(bl2 = jsonReader.hasNext())) {
                void var7_21;
                jsonReader.endObject();
                return var7_21;
            }
            jsonReader.skipValue();
        }
    }
}

