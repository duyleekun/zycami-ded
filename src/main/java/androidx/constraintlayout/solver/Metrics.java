/*
 * Decompiled with CFR 0.151.
 */
package androidx.constraintlayout.solver;

import java.util.ArrayList;

public class Metrics {
    public long additionalMeasures;
    public long barrierConnectionResolved;
    public long bfs;
    public long centerConnectionResolved;
    public long chainConnectionResolved;
    public long constraints;
    public long determineGroups;
    public long errors;
    public long extravariables;
    public long fullySolved;
    public long graphOptimizer;
    public long graphSolved;
    public long grouping;
    public long infeasibleDetermineGroups;
    public long iterations;
    public long lastTableSize;
    public long layouts;
    public long linearSolved;
    public long matchConnectionResolved;
    public long maxRows;
    public long maxTableSize;
    public long maxVariables;
    public long measuredMatchWidgets;
    public long measuredWidgets;
    public long measures;
    public long measuresLayoutDuration;
    public long measuresWidgetsDuration;
    public long measuresWrap;
    public long measuresWrapInfeasible;
    public long minimize;
    public long minimizeGoal;
    public long nonresolvedWidgets;
    public long oldresolvedWidgets;
    public long optimize;
    public long pivots;
    public ArrayList problematicLayouts;
    public long resolutions;
    public long resolvedWidgets;
    public long simpleconstraints;
    public long slackvariables;
    public long tableSizeIncrease;
    public long variables;
    public long widgets;

    public Metrics() {
        ArrayList arrayList;
        this.problematicLayouts = arrayList = new ArrayList();
    }

    public void reset() {
        long l10;
        this.measures = l10 = 0L;
        this.widgets = l10;
        this.additionalMeasures = l10;
        this.resolutions = l10;
        this.tableSizeIncrease = l10;
        this.maxTableSize = l10;
        this.lastTableSize = l10;
        this.maxVariables = l10;
        this.maxRows = l10;
        this.minimize = l10;
        this.minimizeGoal = l10;
        this.constraints = l10;
        this.simpleconstraints = l10;
        this.optimize = l10;
        this.iterations = l10;
        this.pivots = l10;
        this.bfs = l10;
        this.variables = l10;
        this.errors = l10;
        this.slackvariables = l10;
        this.extravariables = l10;
        this.fullySolved = l10;
        this.graphOptimizer = l10;
        this.graphSolved = l10;
        this.resolvedWidgets = l10;
        this.oldresolvedWidgets = l10;
        this.nonresolvedWidgets = l10;
        this.centerConnectionResolved = l10;
        this.matchConnectionResolved = l10;
        this.chainConnectionResolved = l10;
        this.barrierConnectionResolved = l10;
        this.problematicLayouts.clear();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n*** Metrics ***\nmeasures: ");
        long l10 = this.measures;
        stringBuilder.append(l10);
        stringBuilder.append("\nmeasuresWrap: ");
        l10 = this.measuresWrap;
        stringBuilder.append(l10);
        stringBuilder.append("\nmeasuresWrapInfeasible: ");
        l10 = this.measuresWrapInfeasible;
        stringBuilder.append(l10);
        stringBuilder.append("\ndetermineGroups: ");
        l10 = this.determineGroups;
        stringBuilder.append(l10);
        stringBuilder.append("\ninfeasibleDetermineGroups: ");
        l10 = this.infeasibleDetermineGroups;
        stringBuilder.append(l10);
        stringBuilder.append("\ngraphOptimizer: ");
        l10 = this.graphOptimizer;
        stringBuilder.append(l10);
        stringBuilder.append("\nwidgets: ");
        l10 = this.widgets;
        stringBuilder.append(l10);
        stringBuilder.append("\ngraphSolved: ");
        l10 = this.graphSolved;
        stringBuilder.append(l10);
        stringBuilder.append("\nlinearSolved: ");
        l10 = this.linearSolved;
        stringBuilder.append(l10);
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}

