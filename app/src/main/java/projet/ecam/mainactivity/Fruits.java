package projet.ecam.mainactivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by windows 7 on 08/05/2016.
 */
public class Fruits extends View {
    Bitmap ph;
    int x,y;
    private float mCommand = 100;
    private int mScore = 0;
    private boolean mOver = false;
    private static final String TAG = "GameView";
    public Fruits(Context context){
        super(context);
        ph= BitmapFactory.decodeResource(getResources(),R.drawable.ph4);
        x=0;
        y=0;
        Log.v(TAG, "Game created");
    }
@Override
    public void onDraw (Canvas canvas){
    super.onDraw(canvas);
    Rect monRect=new Rect();
    monRect.set(0,0,canvas.getWidth(),canvas.getHeight());
    Paint blue=new Paint();
    blue.setStyle(Paint.Style.FILL);
    canvas.drawRect(monRect,blue);
    if(x<canvas.getWidth())
    x+=20;
    else
    x=0;
    if(y<canvas.getHeight())
    y+=15;
    else
        y=0;
    canvas.drawBitmap(ph,x,y,new Paint());
    invalidate();
}
    public void score(){
        //incrémenter le score si on clique sur l'objet ph
        mScore++;
    }
    public boolean isOver() {
        return mOver;
    }

    public int getScore() {
        return mScore;
    }
    @Override
    public Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();

        Bundle state = new Bundle();

        state.putParcelable("super", superState);
        state.putInt("score", mScore);
        Log.v(TAG, "State Saved");

        return state;
    }
    @Override
    public void onRestoreInstanceState(Parcelable s) {
        Bundle state = (Bundle) s;
        super.onRestoreInstanceState(state.getParcelable("super"));
        mScore = state.getInt("score");
        Log.v(TAG, "State Restored");
    }
    }
