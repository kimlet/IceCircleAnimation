package cndroid.com.icecircleanimation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.animation.Animation.INFINITE;
import static android.view.animation.Animation.RESTART;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private View centerCircle, circleGreen, circleYellow, circleBlue;
    private TextView tvYueHua, tvHuoDong, tvBingQuan, tvZhiBo, tvHuiZhang, tvYueKe;
    private CircleLineView circleLine;

    private static final int APPEAR_ANIMATION_TIME = 1000;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialView();

        circleGreen.postDelayed(new Runnable() {
            @Override
            public void run() {
                startCenterCircleAnimation();

                startYueHuaAnimation();
                startHuoDongAnimation();

                startZhiBoAnimation();
                startBingQuanAnimation();

                startYueKeAnimation();
                startHuiZhangAnimation();


                circleYellow.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        setColorfulCirclePosition();

                    }
                }, APPEAR_ANIMATION_TIME);

            }
        }, 500);
    }

    private void initialView() {
        centerCircle = findViewById(R.id.view_center);
        circleGreen = findViewById(R.id.circleGreen);
        circleYellow = findViewById(R.id.circleYellow);
        circleBlue = findViewById(R.id.circleBlue);

        tvYueHua = (TextView) findViewById(R.id.tv_yuehua);
        tvHuoDong = (TextView) findViewById(R.id.tv_huodong);
        tvBingQuan = (TextView) findViewById(R.id.tv_bingquan);
        tvZhiBo = (TextView) findViewById(R.id.tv_zhibo);
        tvHuiZhang = (TextView) findViewById(R.id.tv_huizhang);
        tvYueKe = (TextView) findViewById(R.id.tv_yueke);

        tvYueHua.setOnClickListener(this);
        tvHuoDong.setOnClickListener(this);
        tvBingQuan.setOnClickListener(this);
        tvZhiBo.setOnClickListener(this);
        tvHuiZhang.setOnClickListener(this);
        tvYueKe.setOnClickListener(this);

        circleLine = (CircleLineView) findViewById(R.id.circleLine);
    }

    private void startYueHuaAnimation() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(-110, 45);
        valueAnimator.setDuration(APPEAR_ANIMATION_TIME);
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int degree = (int) animation.getAnimatedValue();
                final float[] yueHuaPosition = circleLine.getLeftBigCirclePathWithDegree(degree);
                tvYueHua.setVisibility(View.VISIBLE);
                float positionX = yueHuaPosition[0] - tvYueHua.getWidth() / 2;
                float positionY = yueHuaPosition[1] - tvYueHua.getHeight() / 2;
                tvYueHua.setX(positionX);
                tvYueHua.setY(positionY);
            }
        });
        valueAnimator.start();
    }

    private void startHuoDongAnimation() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(-150, 10);
        valueAnimator.setDuration(APPEAR_ANIMATION_TIME);
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int degree = (int) animation.getAnimatedValue();
                final float[] yueHuaPosition = circleLine.getLeftBigCirclePathWithDegree(degree);
                tvHuoDong.setVisibility(View.VISIBLE);
                float positionX = yueHuaPosition[0] - tvHuoDong.getWidth() / 2;
                float positionY = yueHuaPosition[1] - tvHuoDong.getHeight() / 2;
                tvHuoDong.setX(positionX);
                tvHuoDong.setY(positionY);
            }
        });
        valueAnimator.start();
    }


    private void startBingQuanAnimation() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(120, -90);
        valueAnimator.setDuration(APPEAR_ANIMATION_TIME);
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int degree = (int) animation.getAnimatedValue();
                final float[] position = circleLine.getLeftSmallCirclePathWithDegree(degree);
                tvBingQuan.setVisibility(View.VISIBLE);
                float positionX = position[0] - tvBingQuan.getWidth() / 2;
                float positionY = position[1] - tvBingQuan.getHeight() / 2;
                tvBingQuan.setX(positionX);
                tvBingQuan.setY(positionY);
            }
        });
        valueAnimator.start();
    }

    private void startZhiBoAnimation() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(-120, 80);
        valueAnimator.setDuration(APPEAR_ANIMATION_TIME);
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int degree = (int) animation.getAnimatedValue();
                final float[] position = circleLine.getLeftSmallCirclePathWithDegree(degree);
                tvZhiBo.setVisibility(View.VISIBLE);
                float positionX = position[0] - tvZhiBo.getWidth() / 2;
                float positionY = position[1] - tvZhiBo.getHeight() / 2;
                tvZhiBo.setX(positionX);
                tvZhiBo.setY(positionY);
            }
        });
        valueAnimator.start();
    }


    private void startYueKeAnimation() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(-20, 275);
        valueAnimator.setDuration(APPEAR_ANIMATION_TIME);
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int degree = (int) animation.getAnimatedValue();
                final float[] position = circleLine.getRightSmallCirclePathWithDegree(degree);
                tvYueKe.setVisibility(View.VISIBLE);
                float positionX = position[0] - tvYueKe.getWidth() / 2;
                float positionY = position[1] - tvYueKe.getHeight() / 2;
                tvYueKe.setX(positionX);
                tvYueKe.setY(positionY);
            }
        });
        valueAnimator.start();
    }

    private void startHuiZhangAnimation() {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setIntValues(0, 210);
        valueAnimator.setDuration(APPEAR_ANIMATION_TIME);
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int degree = (int) animation.getAnimatedValue();
                final float[] position = circleLine.getRightSmallCirclePathWithDegree(degree);
                tvHuiZhang.setVisibility(View.VISIBLE);
                float positionX = position[0] - tvHuiZhang.getWidth() / 2;
                float positionY = position[1] - tvHuiZhang.getHeight() / 2;
                tvHuiZhang.setX(positionX);
                tvHuiZhang.setY(positionY);
            }
        });
        valueAnimator.start();
    }


    /**
     * 设置三个彩色小圆点的位置及颜色
     */
    private void setColorfulCirclePosition() {
        float[] circleGreenPosition = circleLine.getGreenCirclePosition();
        float[] circleYellowPosition = circleLine.getYellowCirclePosition();
        float[] circleBluePosition = circleLine.getBlueCirclePosition();
        circleGreen.setVisibility(View.VISIBLE);
        circleYellow.setVisibility(View.VISIBLE);
        circleBlue.setVisibility(View.VISIBLE);

        circleGreen.setX(circleGreenPosition[0] - circleGreen.getWidth() / 2);
        circleGreen.setY(circleGreenPosition[1] - circleGreen.getHeight() / 2);

        circleYellow.setX(circleYellowPosition[0] - circleYellow.getWidth() / 2);
        circleYellow.setY(circleYellowPosition[1] - circleYellow.getHeight() / 2);

        circleBlue.setX(circleBluePosition[0] - circleBlue.getWidth() / 2);
        circleBlue.setY(circleBluePosition[1] - circleBlue.getHeight() / 2);


        ObjectAnimator.ofFloat(circleGreen, "scaleX", 0, 1.1f, 1).setDuration(1000).start();
        ObjectAnimator.ofFloat(circleGreen, "scaleY", 0, 1.1f, 1).setDuration(1000).start();

        ObjectAnimator.ofFloat(circleYellow, "scaleX", 0, 1.1f, 1).setDuration(1000).start();
        ObjectAnimator.ofFloat(circleYellow, "scaleY", 0, 1.1f, 1).setDuration(1000).start();

        ObjectAnimator.ofFloat(circleBlue, "scaleX", 0, 1.1f, 1).setDuration(1000).start();
        ObjectAnimator.ofFloat(circleBlue, "scaleY", 0, 1.1f, 1).setDuration(1000).start();
    }

    /**
     * 中间圆的动画
     */
    private void startCenterCircleAnimation() {
        final AnimationSet animationSet = new AnimationSet(true);
        Animation animationScale = new ScaleAnimation(0f, 1, 0f, 1,
                Animation.RELATIVE_TO_SELF, 0.5f, // Pivot point of X scaling
                Animation.RELATIVE_TO_SELF, 0.5f);
        Animation animationAlpha = new AlphaAnimation(1, 0f);
        animationScale.setRepeatCount(INFINITE);
        animationScale.setRepeatMode(RESTART);
        animationAlpha.setRepeatCount(INFINITE);
        animationAlpha.setRepeatMode(RESTART);


        animationSet.addAnimation(animationScale);
        animationSet.addAnimation(animationAlpha);
        animationSet.setDuration(1000);
        animationSet.setStartOffset(1000);


        centerCircle.setAnimation(animationSet);
        centerCircle.setVisibility(View.VISIBLE);
        animationSet.start();
    }

    @Override
    public void onClick(View v) {
        if (v instanceof TextView) {
            TextView textView = (TextView) v;
            Toast.makeText(this, textView.getText(), Toast.LENGTH_SHORT).show();
        }
    }
}
