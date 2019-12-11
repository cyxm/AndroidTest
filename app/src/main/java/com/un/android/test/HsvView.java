package com.un.android.test;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2018/8/3.
 */

public class HsvView extends View {

	/**
	 * HSV圆盘图像
	 */
	private Bitmap mHsvBitmap = null;

	/**
	 * 背景颜色
	 */
	private int mBackgroudColor = Color.TRANSPARENT;

	public HsvView(Context context) {
		super(context);
	}

	public HsvView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public HsvView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		if (mHsvBitmap == null) {
			return;
		}
		canvas.drawBitmap(mHsvBitmap, 0, 0, null);
	}

	@Override
	protected void onAttachedToWindow() {
		super.onAttachedToWindow();
	}

	@Override
	protected void onDetachedFromWindow() {
		//释放HSV图像
		clearHsvBitmap();
		super.onDetachedFromWindow();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		//创建HSV图像
		clearHsvBitmap();
		initHsvBitmap(w, h);
	}

	/**
	 * 释放HSV图像
	 */
	private void clearHsvBitmap() {
		if (mHsvBitmap != null) {
			mHsvBitmap.recycle();
			mHsvBitmap = null;
		}
	}

	/**
	 * 创建HSV图像
	 */
	private void initHsvBitmap(int w, int h) {
		//确保长宽相同
		int l = Math.min(w, h);
		//HS颜色的半径
		float r = l/2;
		//中心点
		float centerX = l/2;
		float centerY = l/2;
		//创建图像
		mHsvBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
		//缓存的hsv数据
		float[] hsv = new float[3];
		hsv[2] = 1;
		//遍历像素
		for (int ch = 0; ch < h; ch++) {
			for (int cw = 0; cw < w; cw++) {
				//计算到中心点的距离
				float dis = calPointDistance(centerX, centerY, cw, ch);
				//背景颜色
				if (dis > r) {
					mHsvBitmap.setPixel(cw, ch, mBackgroudColor);
				} else {
					float angle = calPointAngle(centerX, centerY, cw, ch, dis);
					hsv[0] = angle;
					hsv[1] = dis/r;
					int color = Color.HSVToColor(hsv);
					mHsvBitmap.setPixel(cw, ch, color);
				}
			}
		}
	}

	private float calPointDistance(float oriX, float oriY, float desX, float desY) {
		float dis = (float) Math.sqrt(Math.pow(oriX - desX, 2) + Math.pow(oriY - desY, 2));
		return dis;
	}

	private float calPointAngle(float oriX, float oriY, float desX, float desY, float r) {
		float radian = (float) Math.asin((desY - oriY)/r);
		float angle = (float) (radian*180/Math.PI);
		if (angle <= 180) {
			if (desX - oriX >= 0) {
			} else {
				angle = 180 - angle;
			}
		} else {
			if (desX - oriX >= 0) {
				angle = 540 - angle;
			} else {
			}
		}
		return angle;
	}
}
