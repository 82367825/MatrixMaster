package com.zero.matrixmaster;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by linzewu on 2016/12/30.
 */

public class MatrixActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix);
        
        MatrixView matrixView = (MatrixView) findViewById(R.id.matrix_view);
        matrixView.setImageResource(R.drawable.pic);
    }
}
