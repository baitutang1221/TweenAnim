package com.xiazhenjie.anim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.*
import android.widget.Button
import android.widget.ImageView

/**
 * 补间动画
 */
class TweenAnimationActivity : AppCompatActivity() {

    private lateinit var image1:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tween_anim)

        image1 = findViewById(R.id.image1)

        //平移 (xml)
        findViewById<Button>(R.id.tween_btn1).setOnClickListener {
            val translate =
                AnimationUtils.loadAnimation(this@TweenAnimationActivity, R.anim.common_translate)
            image1.startAnimation(translate)
        }

        //透明度(xml)
        findViewById<Button>(R.id.tween_btn2).setOnClickListener {
            val alpha =
                AnimationUtils.loadAnimation(this@TweenAnimationActivity, R.anim.common_alpha)
            image1.startAnimation(alpha)
        }

        //缩放(xml)
        findViewById<Button>(R.id.tween_btn3).setOnClickListener {
            val scale =
                AnimationUtils.loadAnimation(this@TweenAnimationActivity, R.anim.common_scale)
            image1.startAnimation(scale)
        }

        //旋转(xml)
        findViewById<Button>(R.id.tween_btn4).setOnClickListener {
            val rotate =
                AnimationUtils.loadAnimation(this@TweenAnimationActivity, R.anim.common_rotate)
            image1.startAnimation(rotate)
        }

        //复合动画(xml)
        findViewById<Button>(R.id.tween_btn5).setOnClickListener {
            val more =
                AnimationUtils.loadAnimation(this@TweenAnimationActivity, R.anim.common_more_set)
            image1.startAnimation(more)
        }

        //平移 (Java)
        findViewById<Button>(R.id.tween_btn6).setOnClickListener {
            val translate = TranslateAnimation(0f,200f,0f,200f)
            translate.duration = 1000L
            translate.fillAfter = true
            image1.startAnimation(translate)
        }

        //透明度(Java)
        findViewById<Button>(R.id.tween_btn7).setOnClickListener {
            val alpha = AlphaAnimation(1.0f,0.3f)
            alpha.duration = 200L
            alpha.fillAfter = true
            alpha.repeatCount = 10
            alpha.repeatMode = Animation.REVERSE
            image1.startAnimation(alpha)
        }

        //缩放(Java)
        findViewById<Button>(R.id.tween_btn8).setOnClickListener {
            val scale = ScaleAnimation(
                1.0f,
                2.0f,
                1.0f,
                2.0f,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f)
            scale.duration = 200L
            scale.fillAfter = true
            scale.repeatCount = 10
            scale.repeatMode = Animation.REVERSE
            image1.startAnimation(scale)
        }

        //旋转(Java)
        findViewById<Button>(R.id.tween_btn9).setOnClickListener {
            val rotate = RotateAnimation(
                0f,
                720f,
                RotateAnimation.RELATIVE_TO_SELF,
                0.5f,
                RotateAnimation.RELATIVE_TO_SELF,
                0.5f
            )
            rotate.duration = 800L
            rotate.fillAfter = true
            rotate.repeatCount = 3
            rotate.repeatMode = Animation.REVERSE
            image1.startAnimation(rotate)
        }

        //复合动画(Java)
        findViewById<Button>(R.id.tween_btn10).setOnClickListener {
            val translate = TranslateAnimation(0f,200f,0f,200f)
            translate.duration = 1000L
            translate.fillAfter = true

            val alpha = AlphaAnimation(1.0f,0.3f)
            alpha.duration = 200L
            alpha.fillAfter = true
            alpha.repeatCount = 10
            alpha.repeatMode = Animation.REVERSE

            val scale = ScaleAnimation(
                1.0f,
                2.0f,
                1.0f,
                2.0f,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0.5f)
            scale.duration = 200L
            scale.fillAfter = true
            scale.repeatCount = 10
            scale.repeatMode = Animation.REVERSE

            val rotate = RotateAnimation(
                0f,
                720f,
                RotateAnimation.RELATIVE_TO_SELF,
                0.5f,
                RotateAnimation.RELATIVE_TO_SELF,
                0.5f
            )
            rotate.duration = 800L
            rotate.fillAfter = true
            rotate.repeatCount = 3
            rotate.repeatMode = Animation.REVERSE

            val animSet = AnimationSet(true)
            animSet.addAnimation(translate)
            animSet.addAnimation(alpha)
            animSet.addAnimation(scale)
            animSet.addAnimation(rotate)

            //插值器
//            BaseInterpolator，一个抽象的插值器，用来作为扩展的基类（2-11是其子类）。
//            AccelerateDecelerateInterpolator，数值按照默认变化方向先快后慢。
//            AccelerateInterpolator，数值按照默认变化方向一直加快。
//            AnticipateInterpolator，数值先与默认变化方向相反，后与默认变化方向相同。
//            AnticipateOvershootInterpolator，数值先与默认变化的方向相反，后与默认变化的方向相同，接着与默认变化的方向相反。
//            BounceInterpolator，值的变化模仿小球调到地面上的弹跳变化。
//            CycleInterpolator，值的变化模仿正选函数，010-10。
//            DecelerateInterpolator，数值按照默认变化方向一直减慢。
//            LinearInterpolator，数值按照默认变化方向匀速变化。
//            OvershootInterpolator，数值先与默认变化方向相同，后与默认变化方向相反。
//            PathInterpolator，值的变化由规划的路径控制。
//            FastOutLinearInInterpolator，值的变化符合(0,0) (0.4,0) (1.0,1.0) (1.0,1.0)控制的贝塞尔曲线。
//            FastOutSlowInInterpolator，值的变化符合(0,0) (0.4,0) (0.2,1.0) (1.0,1.0)控制的贝塞尔曲线。
//            LinearOutSlowInInterpolator，值的变化符合(0,0) (0,0) (0.2,1.0) (1.0,1.0)控制的贝塞尔曲线。

//            animSet.interpolator = BounceInterpolator()
            image1.startAnimation(animSet)
        }

        //清除动画
        findViewById<Button>(R.id.tween_btn11).setOnClickListener {
            image1.clearAnimation()
        }

    }
}