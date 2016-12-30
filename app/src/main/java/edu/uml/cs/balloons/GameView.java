package edu.uml.cs.balloons;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;

/**
 * Created by csrobot on 12/30/16.
 */

public class GameView extends View {

    private final GameElements gameElements;
    private final Paint paint;

    public final Bitmap blue_bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.balloon_blue);
    public final Bitmap green_bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.balloon_green);
    public final Bitmap pink_bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.balloon_pink);
    public final Bitmap red_bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.balloon_red);
    public final Bitmap yellow_bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.balloon_yellow);

    public GameView(Context context) {
        super(context);
        gameElements = new GameElements();
        paint = new Paint();
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        for(Balloon balloon : gameElements.getBalloonList()) {
            Bitmap bitmap = getBalloonBitmap(balloon.color());
            canvas.drawBitmap(bitmap, balloon.x(), balloon.y(), paint);
        }
        gameElements.update();

        Log.d("Balloons", "trying to do it");

        //calls next draw
        invalidate();
    }

    public Bitmap getBalloonBitmap(Balloon.BalloonColor balloonColor) {
        switch (balloonColor) {
            case BLUE:
                return blue_bmp;
            case GREEN:
                return green_bmp;
            case PINK:
                return pink_bmp;
            case RED:
                return red_bmp;
            case YELLOW:
                return yellow_bmp;
            default:
                return null;
        }
    }
}
