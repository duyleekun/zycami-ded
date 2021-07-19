/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.material.shape;

import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.EdgeTreatment;

public class ShapePathModel {
    private static final CornerTreatment DEFAULT_CORNER_TREATMENT;
    private static final EdgeTreatment DEFAULT_EDGE_TREATMENT;
    private EdgeTreatment bottomEdge;
    private CornerTreatment bottomLeftCorner;
    private CornerTreatment bottomRightCorner;
    private EdgeTreatment leftEdge;
    private EdgeTreatment rightEdge;
    private EdgeTreatment topEdge;
    private CornerTreatment topLeftCorner;
    private CornerTreatment topRightCorner;

    static {
        Object object = new CornerTreatment();
        DEFAULT_CORNER_TREATMENT = object;
        DEFAULT_EDGE_TREATMENT = object = new EdgeTreatment();
    }

    public ShapePathModel() {
        Object object = DEFAULT_CORNER_TREATMENT;
        this.topLeftCorner = object;
        this.topRightCorner = object;
        this.bottomRightCorner = object;
        this.bottomLeftCorner = object;
        this.topEdge = object = DEFAULT_EDGE_TREATMENT;
        this.rightEdge = object;
        this.bottomEdge = object;
        this.leftEdge = object;
    }

    public EdgeTreatment getBottomEdge() {
        return this.bottomEdge;
    }

    public CornerTreatment getBottomLeftCorner() {
        return this.bottomLeftCorner;
    }

    public CornerTreatment getBottomRightCorner() {
        return this.bottomRightCorner;
    }

    public EdgeTreatment getLeftEdge() {
        return this.leftEdge;
    }

    public EdgeTreatment getRightEdge() {
        return this.rightEdge;
    }

    public EdgeTreatment getTopEdge() {
        return this.topEdge;
    }

    public CornerTreatment getTopLeftCorner() {
        return this.topLeftCorner;
    }

    public CornerTreatment getTopRightCorner() {
        return this.topRightCorner;
    }

    public void setAllCorners(CornerTreatment cornerTreatment) {
        this.topLeftCorner = cornerTreatment;
        this.topRightCorner = cornerTreatment;
        this.bottomRightCorner = cornerTreatment;
        this.bottomLeftCorner = cornerTreatment;
    }

    public void setAllEdges(EdgeTreatment edgeTreatment) {
        this.leftEdge = edgeTreatment;
        this.topEdge = edgeTreatment;
        this.rightEdge = edgeTreatment;
        this.bottomEdge = edgeTreatment;
    }

    public void setBottomEdge(EdgeTreatment edgeTreatment) {
        this.bottomEdge = edgeTreatment;
    }

    public void setBottomLeftCorner(CornerTreatment cornerTreatment) {
        this.bottomLeftCorner = cornerTreatment;
    }

    public void setBottomRightCorner(CornerTreatment cornerTreatment) {
        this.bottomRightCorner = cornerTreatment;
    }

    public void setCornerTreatments(CornerTreatment cornerTreatment, CornerTreatment cornerTreatment2, CornerTreatment cornerTreatment3, CornerTreatment cornerTreatment4) {
        this.topLeftCorner = cornerTreatment;
        this.topRightCorner = cornerTreatment2;
        this.bottomRightCorner = cornerTreatment3;
        this.bottomLeftCorner = cornerTreatment4;
    }

    public void setEdgeTreatments(EdgeTreatment edgeTreatment, EdgeTreatment edgeTreatment2, EdgeTreatment edgeTreatment3, EdgeTreatment edgeTreatment4) {
        this.leftEdge = edgeTreatment;
        this.topEdge = edgeTreatment2;
        this.rightEdge = edgeTreatment3;
        this.bottomEdge = edgeTreatment4;
    }

    public void setLeftEdge(EdgeTreatment edgeTreatment) {
        this.leftEdge = edgeTreatment;
    }

    public void setRightEdge(EdgeTreatment edgeTreatment) {
        this.rightEdge = edgeTreatment;
    }

    public void setTopEdge(EdgeTreatment edgeTreatment) {
        this.topEdge = edgeTreatment;
    }

    public void setTopLeftCorner(CornerTreatment cornerTreatment) {
        this.topLeftCorner = cornerTreatment;
    }

    public void setTopRightCorner(CornerTreatment cornerTreatment) {
        this.topRightCorner = cornerTreatment;
    }
}

