package com.example.property_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button,button2;

    AnimatorSet animatorSet=new AnimatorSet();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.a666);
        button=findViewById(R.id.a555);
        button2=findViewById(R.id.a5555);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator = ObjectAnimator.ofFloat(textView, "alpha", 1f, 0f, 1f);
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(textView, "rotation", 1f, 360f);
                float curTranslationX = textView.getTranslationX();
                ObjectAnimator animator3 = ObjectAnimator.ofFloat(textView, "translationY", curTranslationX, 500f, curTranslationX);
                ObjectAnimator animator4 = ObjectAnimator.ofFloat(textView, "scaleY", 1f, 3f, 1f);

                animatorSet.play(animator2).with(animator).before(animator4).after(animator3);
                animatorSet.setDuration(5000);
                animatorSet.start();

//
//                ValueAnimator anim = ValueAnimator.ofFloat(0f, 10f,5f,1f);
//                anim.setDuration(1000);
//                anim.setStartDelay(10000);
//                anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                    @Override
//                    public void onAnimationUpdate(ValueAnimator animation) {
//                        float currentValue = (float) animation.getAnimatedValue();
//                        Log.d("TAG", "cuurent value is " + currentValue);
//                    }
//                });
//                anim.start();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator = ObjectAnimator.ofFloat(textView, "alpha", 1f, 0f, 1f);
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(textView, "rotation", 1f, 360f);
                float curTranslationX = textView.getTranslationX();
                ObjectAnimator animator3 = ObjectAnimator.ofFloat(textView, "translationY", curTranslationX, 500f, curTranslationX);
                ObjectAnimator animator4 = ObjectAnimator.ofFloat(textView, "scaleY", 1f, 3f, 1f);

                animatorSet.play(animator2).with(animator).before(animator4).after(animator3);
                animatorSet.setDuration(5000);
                animatorSet.start();
            }
        });
        animatorSet.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                Toast.makeText(getApplication(),"小巴狗、汪汪汪",Toast.LENGTH_SHORT).show();
            }


        });
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Toast.makeText(getApplication(),"小巴狗、刚开始",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Toast.makeText(getApplication(),"小巴狗、已结束",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Toast.makeText(getApplication(),"小巴狗、取消了",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Toast.makeText(getApplication(),"小巴狗、重复执行",Toast.LENGTH_SHORT).show();
            }
        });
    }
}