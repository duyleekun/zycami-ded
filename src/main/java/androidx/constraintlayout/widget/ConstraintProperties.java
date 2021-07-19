/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.constraintlayout.widget;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;

public class ConstraintProperties {
    public static final int BASELINE = 5;
    public static final int BOTTOM = 4;
    public static final int END = 7;
    public static final int LEFT = 1;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int PARENT_ID = 0;
    public static final int RIGHT = 2;
    public static final int START = 6;
    public static final int TOP = 3;
    public static final int UNSET = 255;
    public static final int WRAP_CONTENT = 254;
    public ConstraintLayout$LayoutParams mParams;
    public View mView;

    public ConstraintProperties(View object) {
        Object object2 = object.getLayoutParams();
        boolean bl2 = object2 instanceof ConstraintLayout$LayoutParams;
        if (bl2) {
            object2 = (ConstraintLayout$LayoutParams)((Object)object2);
            this.mParams = object2;
            this.mView = object;
            return;
        }
        super("Only children of ConstraintLayout.LayoutParams supported");
        throw object;
    }

    private String sideToString(int n10) {
        switch (n10) {
            default: {
                return "undefined";
            }
            case 7: {
                return "end";
            }
            case 6: {
                return "start";
            }
            case 5: {
                return "baseline";
            }
            case 4: {
                return "bottom";
            }
            case 3: {
                return "top";
            }
            case 2: {
                return "right";
            }
            case 1: 
        }
        return "left";
    }

    public ConstraintProperties addToHorizontalChain(int n10, int n11) {
        View view;
        int n12 = 2;
        int n13 = 1;
        int n14 = n10 == 0 ? n13 : n12;
        this.connect(n13, n10, n14, 0);
        n14 = n11 == 0 ? n12 : n13;
        this.connect(n12, n11, n14, 0);
        if (n10 != 0) {
            view = ((ViewGroup)this.mView.getParent()).findViewById(n10);
            ConstraintProperties constraintProperties = new ConstraintProperties(view);
            view = this.mView;
            n10 = view.getId();
            constraintProperties.connect(n12, n10, n13, 0);
        }
        if (n11 != 0) {
            view = ((ViewGroup)this.mView.getParent()).findViewById(n11);
            ConstraintProperties constraintProperties = new ConstraintProperties(view);
            view = this.mView;
            n10 = view.getId();
            constraintProperties.connect(n13, n10, n12, 0);
        }
        return this;
    }

    public ConstraintProperties addToHorizontalChainRTL(int n10, int n11) {
        View view;
        int n12 = 7;
        int n13 = 6;
        int n14 = n10 == 0 ? n13 : n12;
        this.connect(n13, n10, n14, 0);
        n14 = n11 == 0 ? n12 : n13;
        this.connect(n12, n11, n14, 0);
        if (n10 != 0) {
            view = ((ViewGroup)this.mView.getParent()).findViewById(n10);
            ConstraintProperties constraintProperties = new ConstraintProperties(view);
            view = this.mView;
            n10 = view.getId();
            constraintProperties.connect(n12, n10, n13, 0);
        }
        if (n11 != 0) {
            view = ((ViewGroup)this.mView.getParent()).findViewById(n11);
            ConstraintProperties constraintProperties = new ConstraintProperties(view);
            view = this.mView;
            n10 = view.getId();
            constraintProperties.connect(n13, n10, n12, 0);
        }
        return this;
    }

    public ConstraintProperties addToVerticalChain(int n10, int n11) {
        View view;
        int n12 = 4;
        int n13 = 3;
        int n14 = n10 == 0 ? n13 : n12;
        this.connect(n13, n10, n14, 0);
        n14 = n11 == 0 ? n12 : n13;
        this.connect(n12, n11, n14, 0);
        if (n10 != 0) {
            view = ((ViewGroup)this.mView.getParent()).findViewById(n10);
            ConstraintProperties constraintProperties = new ConstraintProperties(view);
            view = this.mView;
            n10 = view.getId();
            constraintProperties.connect(n12, n10, n13, 0);
        }
        if (n11 != 0) {
            view = ((ViewGroup)this.mView.getParent()).findViewById(n11);
            ConstraintProperties constraintProperties = new ConstraintProperties(view);
            view = this.mView;
            n10 = view.getId();
            constraintProperties.connect(n13, n10, n12, 0);
        }
        return this;
    }

    public ConstraintProperties alpha(float f10) {
        this.mView.setAlpha(f10);
        return this;
    }

    public void apply() {
    }

    public ConstraintProperties center(int n10, int n11, int n12, int n13, int n14, int n15, float f10) {
        String string2 = "margin must be > 0";
        if (n12 >= 0) {
            if (n15 >= 0) {
                float f11;
                float f12 = 0.0f;
                string2 = null;
                float f13 = f10 - 0.0f;
                float f14 = f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1);
                if (f14 > 0 && (f14 = (f11 = f10 - (f12 = 1.0f)) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) <= 0) {
                    f14 = 2;
                    f12 = 2.8E-45f;
                    int n16 = 1;
                    if (n11 != n16 && n11 != f14) {
                        f14 = 7;
                        f12 = 9.8E-45f;
                        n16 = 6;
                        if (n11 != n16 && n11 != f14) {
                            f14 = 3;
                            f12 = 4.2E-45f;
                            this.connect((int)f14, n10, n11, n12);
                            n10 = 4;
                            this.connect(n10, n13, n14, n15);
                            ConstraintLayout$LayoutParams constraintLayout$LayoutParams = this.mParams;
                            constraintLayout$LayoutParams.verticalBias = f10;
                        } else {
                            this.connect(n16, n10, n11, n12);
                            this.connect((int)f14, n13, n14, n15);
                            ConstraintLayout$LayoutParams constraintLayout$LayoutParams = this.mParams;
                            constraintLayout$LayoutParams.horizontalBias = f10;
                        }
                    } else {
                        this.connect(n16, n10, n11, n12);
                        this.connect((int)f14, n13, n14, n15);
                        ConstraintLayout$LayoutParams constraintLayout$LayoutParams = this.mParams;
                        constraintLayout$LayoutParams.horizontalBias = f10;
                    }
                    return this;
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("bias must be between 0 and 1 inclusive");
                throw illegalArgumentException;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
            throw illegalArgumentException;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public ConstraintProperties centerHorizontally(int n10) {
        if (n10 == 0) {
            int n11 = 1;
            int n12 = 2;
            float f10 = 0.5f;
            this.center(0, n11, 0, 0, n12, 0, f10);
        } else {
            int n13 = 2;
            int n14 = 1;
            float f11 = 0.5f;
            this.center(n10, n13, 0, n10, n14, 0, f11);
        }
        return this;
    }

    public ConstraintProperties centerHorizontally(int n10, int n11, int n12, int n13, int n14, int n15, float f10) {
        this.connect(1, n10, n11, n12);
        this.connect(2, n13, n14, n15);
        this.mParams.horizontalBias = f10;
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int n10) {
        if (n10 == 0) {
            int n11 = 6;
            int n12 = 7;
            float f10 = 0.5f;
            this.center(0, n11, 0, 0, n12, 0, f10);
        } else {
            int n13 = 7;
            int n14 = 6;
            float f11 = 0.5f;
            this.center(n10, n13, 0, n10, n14, 0, f11);
        }
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int n10, int n11, int n12, int n13, int n14, int n15, float f10) {
        this.connect(6, n10, n11, n12);
        this.connect(7, n13, n14, n15);
        this.mParams.horizontalBias = f10;
        return this;
    }

    public ConstraintProperties centerVertically(int n10) {
        if (n10 == 0) {
            int n11 = 3;
            int n12 = 4;
            float f10 = 0.5f;
            this.center(0, n11, 0, 0, n12, 0, f10);
        } else {
            int n13 = 4;
            int n14 = 3;
            float f11 = 0.5f;
            this.center(n10, n13, 0, n10, n14, 0, f11);
        }
        return this;
    }

    public ConstraintProperties centerVertically(int n10, int n11, int n12, int n13, int n14, int n15, float f10) {
        this.connect(3, n10, n11, n12);
        this.connect(4, n13, n14, n15);
        this.mParams.verticalBias = f10;
        return this;
    }

    /*
     * Enabled aggressive block sorting
     */
    public ConstraintProperties connect(int n10, int n11, int n12, int n13) {
        String string2;
        block30: {
            ConstraintLayout$LayoutParams constraintLayout$LayoutParams;
            block29: {
                int n14;
                int n15;
                block28: {
                    int n16 = Build.VERSION.SDK_INT;
                    int n17 = 17;
                    n15 = 2;
                    int n18 = 7;
                    int n19 = 6;
                    int n20 = 4;
                    int n21 = 3;
                    int n22 = 1;
                    String string3 = "right to ";
                    string2 = " undefined";
                    n14 = -1;
                    switch (n10) {
                        default: {
                            StringBuilder stringBuilder = new StringBuilder();
                            String string4 = this.sideToString(n10);
                            stringBuilder.append(string4);
                            stringBuilder.append(" to ");
                            string4 = this.sideToString(n12);
                            stringBuilder.append(string4);
                            stringBuilder.append(" unknown");
                            string4 = stringBuilder.toString();
                            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string4);
                            throw illegalArgumentException;
                        }
                        case 7: {
                            ConstraintLayout$LayoutParams constraintLayout$LayoutParams2;
                            if (n12 == n18) {
                                constraintLayout$LayoutParams2 = this.mParams;
                                constraintLayout$LayoutParams2.endToEnd = n11;
                                constraintLayout$LayoutParams2.endToStart = n14;
                            } else {
                                if (n12 != n19) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append(string3);
                                    String string5 = this.sideToString(n12);
                                    stringBuilder.append(string5);
                                    stringBuilder.append(string2);
                                    String string6 = stringBuilder.toString();
                                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string6);
                                    throw illegalArgumentException;
                                }
                                constraintLayout$LayoutParams2 = this.mParams;
                                constraintLayout$LayoutParams2.endToStart = n11;
                                constraintLayout$LayoutParams2.endToEnd = n14;
                            }
                            if (n16 < n17) return this;
                            constraintLayout$LayoutParams2 = this.mParams;
                            constraintLayout$LayoutParams2.setMarginEnd(n13);
                            return this;
                        }
                        case 6: {
                            ConstraintLayout$LayoutParams constraintLayout$LayoutParams3;
                            if (n12 == n19) {
                                constraintLayout$LayoutParams3 = this.mParams;
                                constraintLayout$LayoutParams3.startToStart = n11;
                                constraintLayout$LayoutParams3.startToEnd = n14;
                            } else {
                                if (n12 != n18) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append(string3);
                                    String string7 = this.sideToString(n12);
                                    stringBuilder.append(string7);
                                    stringBuilder.append(string2);
                                    String string8 = stringBuilder.toString();
                                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string8);
                                    throw illegalArgumentException;
                                }
                                constraintLayout$LayoutParams3 = this.mParams;
                                constraintLayout$LayoutParams3.startToEnd = n11;
                                constraintLayout$LayoutParams3.startToStart = n14;
                            }
                            if (n16 < n17) return this;
                            constraintLayout$LayoutParams3 = this.mParams;
                            constraintLayout$LayoutParams3.setMarginStart(n13);
                            return this;
                        }
                        case 5: {
                            n10 = 5;
                            if (n12 == n10) {
                                ConstraintLayout$LayoutParams constraintLayout$LayoutParams4 = this.mParams;
                                constraintLayout$LayoutParams4.baselineToBaseline = n11;
                                constraintLayout$LayoutParams4.bottomToBottom = n14;
                                constraintLayout$LayoutParams4.bottomToTop = n14;
                                constraintLayout$LayoutParams4.topToTop = n14;
                                constraintLayout$LayoutParams4.topToBottom = n14;
                                return this;
                            }
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(string3);
                            String string9 = this.sideToString(n12);
                            stringBuilder.append(string9);
                            stringBuilder.append(string2);
                            String string10 = stringBuilder.toString();
                            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string10);
                            throw illegalArgumentException;
                        }
                        case 4: {
                            ConstraintLayout$LayoutParams constraintLayout$LayoutParams5;
                            if (n12 == n20) {
                                constraintLayout$LayoutParams5 = this.mParams;
                                constraintLayout$LayoutParams5.bottomToBottom = n11;
                                constraintLayout$LayoutParams5.bottomToTop = n14;
                                constraintLayout$LayoutParams5.baselineToBaseline = n14;
                            } else {
                                if (n12 != n21) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append(string3);
                                    String string11 = this.sideToString(n12);
                                    stringBuilder.append(string11);
                                    stringBuilder.append(string2);
                                    String string12 = stringBuilder.toString();
                                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string12);
                                    throw illegalArgumentException;
                                }
                                constraintLayout$LayoutParams5 = this.mParams;
                                constraintLayout$LayoutParams5.bottomToTop = n11;
                                constraintLayout$LayoutParams5.bottomToBottom = n14;
                                constraintLayout$LayoutParams5.baselineToBaseline = n14;
                            }
                            constraintLayout$LayoutParams5 = this.mParams;
                            constraintLayout$LayoutParams5.bottomMargin = n13;
                            return this;
                        }
                        case 3: {
                            ConstraintLayout$LayoutParams constraintLayout$LayoutParams6;
                            if (n12 == n21) {
                                constraintLayout$LayoutParams6 = this.mParams;
                                constraintLayout$LayoutParams6.topToTop = n11;
                                constraintLayout$LayoutParams6.topToBottom = n14;
                                constraintLayout$LayoutParams6.baselineToBaseline = n14;
                            } else {
                                if (n12 != n20) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append(string3);
                                    String string13 = this.sideToString(n12);
                                    stringBuilder.append(string13);
                                    stringBuilder.append(string2);
                                    String string14 = stringBuilder.toString();
                                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string14);
                                    throw illegalArgumentException;
                                }
                                constraintLayout$LayoutParams6 = this.mParams;
                                constraintLayout$LayoutParams6.topToBottom = n11;
                                constraintLayout$LayoutParams6.topToTop = n14;
                                constraintLayout$LayoutParams6.baselineToBaseline = n14;
                            }
                            constraintLayout$LayoutParams6 = this.mParams;
                            constraintLayout$LayoutParams6.topMargin = n13;
                            return this;
                        }
                        case 2: {
                            ConstraintLayout$LayoutParams constraintLayout$LayoutParams7;
                            if (n12 == n22) {
                                constraintLayout$LayoutParams7 = this.mParams;
                                constraintLayout$LayoutParams7.rightToLeft = n11;
                                constraintLayout$LayoutParams7.rightToRight = n14;
                            } else {
                                if (n12 != n15) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append(string3);
                                    String string15 = this.sideToString(n12);
                                    stringBuilder.append(string15);
                                    stringBuilder.append(string2);
                                    String string16 = stringBuilder.toString();
                                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string16);
                                    throw illegalArgumentException;
                                }
                                constraintLayout$LayoutParams7 = this.mParams;
                                constraintLayout$LayoutParams7.rightToRight = n11;
                                constraintLayout$LayoutParams7.rightToLeft = n14;
                            }
                            constraintLayout$LayoutParams7 = this.mParams;
                            constraintLayout$LayoutParams7.rightMargin = n13;
                            return this;
                        }
                        case 1: 
                    }
                    if (n12 != n22) break block28;
                    constraintLayout$LayoutParams = this.mParams;
                    constraintLayout$LayoutParams.leftToLeft = n11;
                    constraintLayout$LayoutParams.leftToRight = n14;
                    break block29;
                }
                if (n12 != n15) break block30;
                constraintLayout$LayoutParams = this.mParams;
                constraintLayout$LayoutParams.leftToRight = n11;
                constraintLayout$LayoutParams.leftToLeft = n14;
            }
            constraintLayout$LayoutParams = this.mParams;
            constraintLayout$LayoutParams.leftMargin = n13;
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Left to ");
        String string17 = this.sideToString(n12);
        stringBuilder.append(string17);
        stringBuilder.append(string2);
        String string18 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string18);
        throw illegalArgumentException;
    }

    public ConstraintProperties constrainDefaultHeight(int n10) {
        this.mParams.matchConstraintDefaultHeight = n10;
        return this;
    }

    public ConstraintProperties constrainDefaultWidth(int n10) {
        this.mParams.matchConstraintDefaultWidth = n10;
        return this;
    }

    public ConstraintProperties constrainHeight(int n10) {
        this.mParams.height = n10;
        return this;
    }

    public ConstraintProperties constrainMaxHeight(int n10) {
        this.mParams.matchConstraintMaxHeight = n10;
        return this;
    }

    public ConstraintProperties constrainMaxWidth(int n10) {
        this.mParams.matchConstraintMaxWidth = n10;
        return this;
    }

    public ConstraintProperties constrainMinHeight(int n10) {
        this.mParams.matchConstraintMinHeight = n10;
        return this;
    }

    public ConstraintProperties constrainMinWidth(int n10) {
        this.mParams.matchConstraintMinWidth = n10;
        return this;
    }

    public ConstraintProperties constrainWidth(int n10) {
        this.mParams.width = n10;
        return this;
    }

    public ConstraintProperties dimensionRatio(String string2) {
        this.mParams.dimensionRatio = string2;
        return this;
    }

    public ConstraintProperties elevation(float f10) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            View view = this.mView;
            view.setElevation(f10);
        }
        return this;
    }

    public ConstraintProperties goneMargin(int n10, int n11) {
        switch (n10) {
            default: {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("unknown constraint");
                throw illegalArgumentException;
            }
            case 7: {
                ConstraintLayout$LayoutParams constraintLayout$LayoutParams = this.mParams;
                constraintLayout$LayoutParams.goneEndMargin = n11;
                break;
            }
            case 6: {
                ConstraintLayout$LayoutParams constraintLayout$LayoutParams = this.mParams;
                constraintLayout$LayoutParams.goneStartMargin = n11;
                break;
            }
            case 5: {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("baseline does not support margins");
                throw illegalArgumentException;
            }
            case 4: {
                ConstraintLayout$LayoutParams constraintLayout$LayoutParams = this.mParams;
                constraintLayout$LayoutParams.goneBottomMargin = n11;
                break;
            }
            case 3: {
                ConstraintLayout$LayoutParams constraintLayout$LayoutParams = this.mParams;
                constraintLayout$LayoutParams.goneTopMargin = n11;
                break;
            }
            case 2: {
                ConstraintLayout$LayoutParams constraintLayout$LayoutParams = this.mParams;
                constraintLayout$LayoutParams.goneRightMargin = n11;
                break;
            }
            case 1: {
                ConstraintLayout$LayoutParams constraintLayout$LayoutParams = this.mParams;
                constraintLayout$LayoutParams.goneLeftMargin = n11;
            }
        }
        return this;
    }

    public ConstraintProperties horizontalBias(float f10) {
        this.mParams.horizontalBias = f10;
        return this;
    }

    public ConstraintProperties horizontalChainStyle(int n10) {
        this.mParams.horizontalChainStyle = n10;
        return this;
    }

    public ConstraintProperties horizontalWeight(float f10) {
        this.mParams.horizontalWeight = f10;
        return this;
    }

    public ConstraintProperties margin(int n10, int n11) {
        switch (n10) {
            default: {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("unknown constraint");
                throw illegalArgumentException;
            }
            case 7: {
                ConstraintLayout$LayoutParams constraintLayout$LayoutParams = this.mParams;
                constraintLayout$LayoutParams.setMarginEnd(n11);
                break;
            }
            case 6: {
                ConstraintLayout$LayoutParams constraintLayout$LayoutParams = this.mParams;
                constraintLayout$LayoutParams.setMarginStart(n11);
                break;
            }
            case 5: {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("baseline does not support margins");
                throw illegalArgumentException;
            }
            case 4: {
                ConstraintLayout$LayoutParams constraintLayout$LayoutParams = this.mParams;
                constraintLayout$LayoutParams.bottomMargin = n11;
                break;
            }
            case 3: {
                ConstraintLayout$LayoutParams constraintLayout$LayoutParams = this.mParams;
                constraintLayout$LayoutParams.topMargin = n11;
                break;
            }
            case 2: {
                ConstraintLayout$LayoutParams constraintLayout$LayoutParams = this.mParams;
                constraintLayout$LayoutParams.rightMargin = n11;
                break;
            }
            case 1: {
                ConstraintLayout$LayoutParams constraintLayout$LayoutParams = this.mParams;
                constraintLayout$LayoutParams.leftMargin = n11;
            }
        }
        return this;
    }

    public ConstraintProperties removeConstraints(int n10) {
        int n11 = -1;
        switch (n10) {
            default: {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("unknown constraint");
                throw illegalArgumentException;
            }
            case 7: {
                ConstraintLayout$LayoutParams constraintLayout$LayoutParams = this.mParams;
                constraintLayout$LayoutParams.endToStart = n11;
                constraintLayout$LayoutParams.endToEnd = n11;
                constraintLayout$LayoutParams.setMarginEnd(n11);
                constraintLayout$LayoutParams = this.mParams;
                constraintLayout$LayoutParams.goneEndMargin = n11;
                break;
            }
            case 6: {
                ConstraintLayout$LayoutParams constraintLayout$LayoutParams = this.mParams;
                constraintLayout$LayoutParams.startToEnd = n11;
                constraintLayout$LayoutParams.startToStart = n11;
                constraintLayout$LayoutParams.setMarginStart(n11);
                constraintLayout$LayoutParams = this.mParams;
                constraintLayout$LayoutParams.goneStartMargin = n11;
                break;
            }
            case 5: {
                ConstraintLayout$LayoutParams constraintLayout$LayoutParams = this.mParams;
                constraintLayout$LayoutParams.baselineToBaseline = n11;
                break;
            }
            case 4: {
                ConstraintLayout$LayoutParams constraintLayout$LayoutParams = this.mParams;
                constraintLayout$LayoutParams.bottomToTop = n11;
                constraintLayout$LayoutParams.bottomToBottom = n11;
                constraintLayout$LayoutParams.bottomMargin = n11;
                constraintLayout$LayoutParams.goneBottomMargin = n11;
                break;
            }
            case 3: {
                ConstraintLayout$LayoutParams constraintLayout$LayoutParams = this.mParams;
                constraintLayout$LayoutParams.topToBottom = n11;
                constraintLayout$LayoutParams.topToTop = n11;
                constraintLayout$LayoutParams.topMargin = n11;
                constraintLayout$LayoutParams.goneTopMargin = n11;
                break;
            }
            case 2: {
                ConstraintLayout$LayoutParams constraintLayout$LayoutParams = this.mParams;
                constraintLayout$LayoutParams.rightToRight = n11;
                constraintLayout$LayoutParams.rightToLeft = n11;
                constraintLayout$LayoutParams.rightMargin = n11;
                constraintLayout$LayoutParams.goneRightMargin = n11;
                break;
            }
            case 1: {
                ConstraintLayout$LayoutParams constraintLayout$LayoutParams = this.mParams;
                constraintLayout$LayoutParams.leftToRight = n11;
                constraintLayout$LayoutParams.leftToLeft = n11;
                constraintLayout$LayoutParams.leftMargin = n11;
                constraintLayout$LayoutParams.goneLeftMargin = n11;
            }
        }
        return this;
    }

    public ConstraintProperties removeFromHorizontalChain() {
        ConstraintLayout$LayoutParams constraintLayout$LayoutParams = this.mParams;
        int n10 = constraintLayout$LayoutParams.leftToRight;
        int n11 = constraintLayout$LayoutParams.rightToLeft;
        int n12 = -1;
        if (n10 == n12 && n11 == n12) {
            n11 = constraintLayout$LayoutParams.startToEnd;
            int n13 = constraintLayout$LayoutParams.endToStart;
            int n14 = 7;
            int n15 = 6;
            if (n11 != n12 || n13 != n12) {
                Object object = ((ViewGroup)this.mView.getParent()).findViewById(n11);
                ConstraintProperties constraintProperties = new ConstraintProperties((View)object);
                object = ((ViewGroup)this.mView.getParent()).findViewById(n13);
                ConstraintProperties constraintProperties2 = new ConstraintProperties((View)object);
                object = this.mParams;
                if (n11 != n12 && n13 != n12) {
                    constraintProperties.connect(n14, n13, n15, 0);
                    constraintProperties2.connect(n15, n10, n14, 0);
                } else if (n10 != n12 || n13 != n12) {
                    n13 = object.rightToRight;
                    if (n13 != n12) {
                        constraintProperties.connect(n14, n13, n14, 0);
                    } else {
                        n13 = object.leftToLeft;
                        if (n13 != n12) {
                            constraintProperties2.connect(n15, n13, n15, 0);
                        }
                    }
                }
            }
            this.removeConstraints(n15);
            this.removeConstraints(n14);
        } else {
            constraintLayout$LayoutParams = ((ViewGroup)this.mView.getParent()).findViewById(n10);
            ConstraintProperties constraintProperties = new ConstraintProperties((View)constraintLayout$LayoutParams);
            constraintLayout$LayoutParams = ((ViewGroup)this.mView.getParent()).findViewById(n11);
            ConstraintProperties constraintProperties3 = new ConstraintProperties((View)constraintLayout$LayoutParams);
            constraintLayout$LayoutParams = this.mParams;
            int n16 = 1;
            int n17 = 2;
            if (n10 != n12 && n11 != n12) {
                constraintProperties.connect(n17, n11, n16, 0);
                constraintProperties3.connect(n16, n10, n17, 0);
            } else if (n10 != n12 || n11 != n12) {
                n10 = constraintLayout$LayoutParams.rightToRight;
                if (n10 != n12) {
                    constraintProperties.connect(n17, n10, n17, 0);
                } else {
                    int n18 = constraintLayout$LayoutParams.leftToLeft;
                    if (n18 != n12) {
                        constraintProperties3.connect(n16, n18, n16, 0);
                    }
                }
            }
            this.removeConstraints(n16);
            this.removeConstraints(n17);
        }
        return this;
    }

    public ConstraintProperties removeFromVerticalChain() {
        ConstraintLayout$LayoutParams constraintLayout$LayoutParams = this.mParams;
        int n10 = constraintLayout$LayoutParams.topToBottom;
        int n11 = constraintLayout$LayoutParams.bottomToTop;
        int n12 = 4;
        int n13 = 3;
        int n14 = -1;
        if (n10 != n14 || n11 != n14) {
            Object object = ((ViewGroup)this.mView.getParent()).findViewById(n10);
            ConstraintProperties constraintProperties = new ConstraintProperties((View)object);
            object = ((ViewGroup)this.mView.getParent()).findViewById(n11);
            ConstraintProperties constraintProperties2 = new ConstraintProperties((View)object);
            object = this.mParams;
            if (n10 != n14 && n11 != n14) {
                constraintProperties.connect(n12, n11, n13, 0);
                constraintProperties2.connect(n13, n10, n12, 0);
            } else if (n10 != n14 || n11 != n14) {
                n11 = object.bottomToBottom;
                if (n11 != n14) {
                    constraintProperties.connect(n12, n11, n12, 0);
                } else {
                    n11 = object.topToTop;
                    if (n11 != n14) {
                        constraintProperties2.connect(n13, n11, n13, 0);
                    }
                }
            }
        }
        this.removeConstraints(n13);
        this.removeConstraints(n12);
        return this;
    }

    public ConstraintProperties rotation(float f10) {
        this.mView.setRotation(f10);
        return this;
    }

    public ConstraintProperties rotationX(float f10) {
        this.mView.setRotationX(f10);
        return this;
    }

    public ConstraintProperties rotationY(float f10) {
        this.mView.setRotationY(f10);
        return this;
    }

    public ConstraintProperties scaleX(float f10) {
        this.mView.setScaleY(f10);
        return this;
    }

    public ConstraintProperties scaleY(float f10) {
        return this;
    }

    public ConstraintProperties transformPivot(float f10, float f11) {
        this.mView.setPivotX(f10);
        this.mView.setPivotY(f11);
        return this;
    }

    public ConstraintProperties transformPivotX(float f10) {
        this.mView.setPivotX(f10);
        return this;
    }

    public ConstraintProperties transformPivotY(float f10) {
        this.mView.setPivotY(f10);
        return this;
    }

    public ConstraintProperties translation(float f10, float f11) {
        this.mView.setTranslationX(f10);
        this.mView.setTranslationY(f11);
        return this;
    }

    public ConstraintProperties translationX(float f10) {
        this.mView.setTranslationX(f10);
        return this;
    }

    public ConstraintProperties translationY(float f10) {
        this.mView.setTranslationY(f10);
        return this;
    }

    public ConstraintProperties translationZ(float f10) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            View view = this.mView;
            view.setTranslationZ(f10);
        }
        return this;
    }

    public ConstraintProperties verticalBias(float f10) {
        this.mParams.verticalBias = f10;
        return this;
    }

    public ConstraintProperties verticalChainStyle(int n10) {
        this.mParams.verticalChainStyle = n10;
        return this;
    }

    public ConstraintProperties verticalWeight(float f10) {
        this.mParams.verticalWeight = f10;
        return this;
    }

    public ConstraintProperties visibility(int n10) {
        this.mView.setVisibility(n10);
        return this;
    }
}

