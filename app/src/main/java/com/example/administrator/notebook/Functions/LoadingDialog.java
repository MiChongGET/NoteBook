package com.example.administrator.notebook.Functions;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.notebook.R;

public class LoadingDialog extends Dialog {

	private View loading_layout;
	private ImageView iv_loading;

	public LoadingDialog(Context context) {
		this(context, R.style.LoadingDialog);
	}

	public LoadingDialog(Context context, int themeResId) {
		super(context, themeResId);
		init();
	}

	private void init() {
		loading_layout = View.inflate(getContext(), R.layout.loading_layout, null);
		iv_loading = (ImageView) loading_layout.findViewById(R.id.iv_loading);
		this.setCancelable(false);
		this.setContentView(loading_layout);
	}

	@Override
	public void show() {
		if (iv_loading != null) {
			iv_loading.setBackgroundResource(R.drawable.load_list);
			AnimationDrawable ad = (AnimationDrawable) iv_loading.getBackground();
			if (ad != null && !ad.isRunning()) {
				ad.start();
			}
		}
		super.show();
	}


	public void success() {
		if (iv_loading != null) {
			iv_loading.setBackgroundResource(R.drawable.success_list);
			AnimationDrawable ad = (AnimationDrawable) iv_loading.getBackground();
			if (ad != null && !ad.isRunning()) {
				ad.start();
				iv_loading.postDelayed(new Runnable() {

					@Override
					public void run() {
						dismiss();
					}
				}, 13 * 100);
			}
		}
	}

}
