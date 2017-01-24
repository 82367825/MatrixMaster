package com.zero.matrixmaster;

import android.content.Context;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;


/**
 * Created by linzewu on 2017/1/3.
 */

public class MatrixView extends ImageView {
    
    public MatrixView(Context context) {
        super(context);
        init();
    }

    public MatrixView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MatrixView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    
    private ScaleGestureDetector mScaleGestureDetector;
    
    private void init() {
        mScaleGestureDetector = new ScaleGestureDetector(getContext(), new 
                MatrixScaleGestureDetector());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mScaleGestureDetector.onTouchEvent(event);
    }

    private class MatrixScaleGestureDetector implements android.view.ScaleGestureDetector
            .OnScaleGestureListener {

        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            Matrix matrix = getImageMatrix();
            matrix.postScale(detector.getScaleFactor(), detector.getScaleFactor(), 
                    getWidth() / 2, getHeight() / 2);
            setImageMatrix(matrix);
            invalidate();
            return true;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            return true;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {

        }
    }
}
