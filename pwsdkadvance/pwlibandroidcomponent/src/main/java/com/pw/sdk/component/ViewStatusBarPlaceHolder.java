package com.pw.sdk.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.pw.sdk.advance.ui.SystemUIUtil;

/**
 * 为实现沉浸式状态栏使用的占位View
 */
public class ViewStatusBarPlaceHolder extends View {

	private static int mStatusBarHeight;

	public ViewStatusBarPlaceHolder(Context context) {
		this(context, null);
		mStatusBarHeight = SystemUIUtil.getStatusBarHeight(context);
	}

	public ViewStatusBarPlaceHolder(Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		mStatusBarHeight = SystemUIUtil.getStatusBarHeight(context);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), mStatusBarHeight);
	}
}
