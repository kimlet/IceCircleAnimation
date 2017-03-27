package cndroid.com.icecircleanimation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by jinbangzhu on 09/12/2016.
 */

public class CircleLineView extends View {

    private Paint mPaintLine;


    // left big circle
    float leftBigCircleX;
    float leftBigCircleY;
    float leftBigCircleRadius;

    // left small circle
    float leftSmallCircleX;
    float leftSmallCircleY;
    float leftSmallCircleRadius;

    // right big circle
    float rightBigCircleX;
    float rightBigCircleY;
    float rightBigCircleRadius;

    // right small circle
    float rightSmallCircleX;
    float rightSmallCircleY;
    float rightSmallCircleRadius;

    public CircleLineView(Context context) {
        this(context, null);
    }

    public CircleLineView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleLineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaintLine = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintLine.setAntiAlias(true);
        mPaintLine.setStyle(Paint.Style.STROKE);
        mPaintLine.setStrokeCap(Paint.Cap.ROUND);
        mPaintLine.setStrokeJoin(Paint.Join.ROUND);
        mPaintLine.setStrokeMiter(1);
        mPaintLine.setStrokeWidth(1);
        mPaintLine.setAlpha(180);
        mPaintLine.setColor(Color.parseColor("#A8E5F6"));

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();

        initialPosition(width, height);


        canvas.drawCircle(leftBigCircleX, leftBigCircleY, leftBigCircleRadius, mPaintLine);

        canvas.drawCircle(leftSmallCircleX, leftSmallCircleY, leftSmallCircleRadius, mPaintLine);

        canvas.drawCircle(rightBigCircleX, rightBigCircleY, rightBigCircleRadius, mPaintLine);

        canvas.drawCircle(rightSmallCircleX, rightSmallCircleY, rightSmallCircleRadius, mPaintLine);
    }


    public float[] getLeftBigCirclePathWithDegree(int degree) {
        double cos = Math.cos(Math.toRadians(degree));
        double sin = Math.sin(Math.toRadians(degree));

        float targetX = (float) (leftBigCircleRadius * cos + leftBigCircleX);
        float targetY = (float) (leftBigCircleRadius * sin + leftBigCircleY);

        return new float[]{targetX, targetY};
    }

    public float[] getLeftSmallCirclePathWithDegree(int degree) {
        double cos = Math.cos(Math.toRadians(degree));
        double sin = Math.sin(Math.toRadians(degree));

        float targetX = (float) (leftSmallCircleRadius * cos + leftSmallCircleX);
        float targetY = (float) (leftSmallCircleRadius * sin + leftSmallCircleY);

        return new float[]{targetX, targetY};
    }

    public float[] getRightSmallCirclePathWithDegree(int degree) {
        double cos = Math.cos(Math.toRadians(degree));
        double sin = Math.sin(Math.toRadians(degree));

        float targetX = (float) (rightSmallCircleRadius * cos + rightSmallCircleX);
        float targetY = (float) (rightSmallCircleRadius * sin + rightSmallCircleY);

        return new float[]{targetX, targetY};
    }


    public float[] getGreenCirclePosition() {
        return getLeftBigCirclePathWithDegree(-75);
    }

    public float[] getYellowCirclePosition() {
        double cos = Math.cos(Math.toRadians(105));
        double sin = Math.sin(Math.toRadians(105));

        float targetX = (float) (leftSmallCircleRadius * cos + leftSmallCircleX);
        float targetY = (float) (leftSmallCircleRadius * sin + leftSmallCircleY);

        return new float[]{targetX, targetY};
    }

    public float[] getBlueCirclePosition() {
        double cos = Math.cos(Math.toRadians(310));
        double sin = Math.sin(Math.toRadians(310));

        float targetX = (float) (rightSmallCircleRadius * cos + rightSmallCircleX);
        float targetY = (float) (rightSmallCircleRadius * sin + rightSmallCircleY);

        return new float[]{targetX, targetY};
    }

    private void initialPosition(int width, int height) {
        // left big circle
        leftBigCircleX = width * 0.11f;
        leftBigCircleY = height / 2 * 1.08f;
        leftBigCircleRadius = height / 2;

        // left small circle
        leftSmallCircleX = width * 0.2f;
        leftSmallCircleY = height / 2.1f;
        leftSmallCircleRadius = width * 0.5f;

        // right big circle
        rightBigCircleX = width;
        rightBigCircleY = height / 2;
        rightBigCircleRadius = height * 0.45f;

        // right small circle
        rightSmallCircleX = width * 0.6f;
        rightSmallCircleY = height / 1.9f;
        rightSmallCircleRadius = height * 0.35f;
    }
}
