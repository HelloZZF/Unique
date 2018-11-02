package com.unique.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;

import com.unique.R;

/**
 * Created by zzf on 2018/5/14.
 */
public class ShadowLayout extends RelativeLayout {
    public static final int ALL = 0x1111;
    public static final int LEFT = 0x0001;
    public static final int TOP = 0x0010;
    public static final int RIGHT = 0x0100;
    public static final int BOTTOM = 0x1000;
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private RectF mRectF = new RectF();
    /**
     * 阴影的颜色
     */
    private int mShadowColor = Color.TRANSPARENT;
    /**
     * 阴影的大小范围
     */
    private float mShadowRadius = 0;
    /**
     * 阴影 x 轴的偏移量
     */
    private float mShadowDx = 0;
    /**
     * 阴影 y 轴的偏移量
     */
    private float mShadowDy = 0;
    /**
     * 阴影显示的边界
     */
    private int mShadowSide = ALL;
    /**
     * 阴影的内边距
     */
    private float mShadowPaddingTop = 0;
    private float mShadowPaddingBottom = 0;
    private float mShadowPaddingLeft = 0;
    private float mShadowPaddingRight = 0;

    public ShadowLayout(Context context) {
        this(context, null);
    }
    public ShadowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public ShadowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }
    /**
     * 获取绘制阴影的位置，并为 ShadowLayout 设置 Padding 以为显示阴影留出空间
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        float effectTop = mShadowRadius + dip2px(mShadowPaddingTop);
        float effectBottom = mShadowRadius + dip2px(mShadowPaddingBottom);
        float effectLeft = mShadowRadius + dip2px(mShadowPaddingLeft);
        float effectRight = mShadowRadius + dip2px(mShadowPaddingRight);
        float rectLeft = 0;
        float rectTop = 0;
        float rectRight = this.getWidth();
        float rectBottom = this.getHeight();
        int paddingLeft = 0;
        int paddingTop = 0;
        int paddingRight = 0;
        int paddingBottom = 0;
        if (((mShadowSide & LEFT) == LEFT)) {
            rectLeft = effectLeft;
            paddingLeft = (int) effectLeft;
        }
        if (((mShadowSide & TOP) == TOP)) {
            rectTop = effectTop;
            paddingTop = (int) effectTop;
        }
        if (((mShadowSide & RIGHT) == RIGHT)) {
            rectRight = this.getWidth() - effectRight;
            paddingRight = (int) effectRight;
        }
        if (((mShadowSide & BOTTOM) == BOTTOM)) {
            rectBottom = this.getHeight() - effectBottom;
            paddingBottom = (int) effectBottom;
        }
        if (mShadowDy != 0.0f) {
            rectBottom = rectBottom - mShadowDy;
            paddingBottom = paddingBottom + (int) mShadowDy;
        }
        if (mShadowDx != 0.0f) {
            rectRight = rectRight - mShadowDx;
            paddingRight = paddingRight + (int) mShadowDx;
        }
        mRectF.left = rectLeft;
        mRectF.top = rectTop;
        mRectF.right = rectRight;
        mRectF.bottom = rectBottom;
        this.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }
    /**
     * 真正绘制阴影的方法
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(mRectF, mPaint);
    }
    /**
     * 读取设置的阴影的属性
     *
     * @param attrs 从其中获取设置的值
     */
    private void init(AttributeSet attrs) {
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);  // 关闭硬件加速
        this.setWillNotDraw(false);                    // 调用此方法后，才会执行 onDraw(Canvas) 方法
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.ShadowLayout);
        if (typedArray != null) {
            mShadowColor = typedArray.getColor(R.styleable.ShadowLayout_shadowColor,
                    ContextCompat.getColor(getContext(), android.R.color.black));
            mShadowRadius = typedArray.getDimension(R.styleable.ShadowLayout_shadowRadius, dip2px(0));
            mShadowDx = typedArray.getDimension(R.styleable.ShadowLayout_shadowDx, dip2px(0));
            mShadowDy = typedArray.getDimension(R.styleable.ShadowLayout_shadowDy, dip2px(0));
            mShadowSide = typedArray.getInt(R.styleable.ShadowLayout_shadowSide, ALL);
            mShadowPaddingTop = typedArray.getFloat(R.styleable.ShadowLayout_mShadowPaddingTop, 2f);
            mShadowPaddingBottom = typedArray.getFloat(R.styleable.ShadowLayout_mShadowPaddingBottom, 2f);
            mShadowPaddingLeft = typedArray.getFloat(R.styleable.ShadowLayout_mShadowPaddingLeft, 2f);
            mShadowPaddingRight = typedArray.getFloat(R.styleable.ShadowLayout_mShadowPaddingRight, 2f);
            typedArray.recycle();
        }
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.TRANSPARENT);
        mPaint.setShadowLayer(mShadowRadius, mShadowDx, mShadowDy, mShadowColor);
    }
    /**
     * dip2px dp 值转 px 值
     *
     * @param dpValue dp 值
     * @return px 值
     */
    private float dip2px(float dpValue) {
        DisplayMetrics dm = getContext().getResources().getDisplayMetrics();
        float scale = dm.density;
        return (dpValue * scale + 0.5F);
    }
}
