package com.pw.sdk.component.act;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 基础Activity
 */
public abstract class ActivityBase extends AppCompatActivity {

	protected Activity mActivitySelf;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mActivitySelf = this;

		onThemeSetup();

		onWindowSetup();

		Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
			@Override
			public boolean queueIdle() {
				onAfterUIInited();
				return false;
			}
		});
	}

	/**
	 * UI初始化成功后的回调
	 */
	protected void onAfterUIInited() {
	}

	/**
	 * 设置UI主题
	 */
	protected void onThemeSetup() {

	}

	/**
	 * 设置Window属性
	 */
	protected void onWindowSetup() {

	}
}
