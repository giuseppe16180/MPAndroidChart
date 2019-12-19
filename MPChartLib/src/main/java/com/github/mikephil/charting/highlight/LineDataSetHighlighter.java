package com.github.mikephil.charting.highlight;

import android.util.Log;

import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.utils.MPPointD;

public class LineDataSetHighlighter<T extends LineDataProvider> implements IDataSetHighlighter {

    /**
     * instance of the data-provider
     */
    protected T mChart;

    public LineDataSetHighlighter(T chart) {
        this.mChart = chart;
    }

    @Override
    public int getDataSetIndexHighlight(float x, float y) {

        MPPointD pos = getValsForTouch(x, y);
        Log.i("LineDataSetHighlighter", pos.toString());
        float xVal = (float) pos.x;
        MPPointD.recycleInstance(pos);

        return 0;
    }


    /**
     * Returns a recyclable MPPointD instance.
     * Returns the corresponding xPos for a given touch-position in pixels.
     *
     * @param x
     * @param y
     * @return
     */
    protected MPPointD getValsForTouch(float x, float y) {

        // take any transformer to determine the x-axis value
        MPPointD pos = mChart.getTransformer(YAxis.AxisDependency.LEFT).getValuesByTouchPoint(x, y);
        return pos;
    }
}
