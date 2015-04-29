package com.android.View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.yijiashuo.R;

/**
 * Created by Administrator on 2015/4/27 0027.
 *
 */
public class ActionBarItemView extends RelativeLayout implements OnClickListener {
	//tag
	public static final String RIGHT_IMG_TAG = "right_img_tag";
	public static final String LEFT_IMG_TAG = "left_img_tag";
	public static final String RIGHT_TEXT_TAG = "right_text_tag";
	public static final String LEFT_TEXT_TAG = "left_text_tag";
	//view
	private ImageView mActionBarLeftImageView;
	private ImageView mActionBaeRightImageView;
	private TextView mActionBarLeftTextView;
	private TextView mActionBarRightTextView;
	/**
	 * listener
	 */
	private OnActionBarClickListener mOnActionBarClickListener;

	public ActionBarItemView(Context context) {
		super(context);
		findViews();
	}

	public ActionBarItemView(Context context, AttributeSet attrs) {
		super(context, attrs);
		findViews();
	}

	public ActionBarItemView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		findViews();
	}

	public interface OnActionBarClickListener {
		void click(String tag);
	}

	public void setOnActionBarClickListener(OnActionBarClickListener listener){
		mOnActionBarClickListener = listener;
	}

	private void findViews(){
		View rootView = LayoutInflater.from(getContext()).inflate(R.layout.actionbar_item,null);

		//views
		mActionBarLeftImageView = (ImageView) rootView.findViewById(R.id.img_actionbar_left);
		mActionBaeRightImageView = (ImageView) rootView.findViewById(R.id.img_actionbar_right);
		mActionBarLeftTextView = (TextView) rootView.findViewById(R.id.tv_actionbar_left_text);
		mActionBarRightTextView = (TextView) rootView.findViewById(R.id.tv_actionbar_right_text);

		//click
		mActionBarLeftImageView.setOnClickListener(this);
		mActionBaeRightImageView.setOnClickListener(this);
		mActionBarLeftTextView.setOnClickListener(this);
		mActionBarRightTextView.setOnClickListener(this);

		addView(rootView);
	}

	public void setActionBarRightImageView(int resid){
		mActionBaeRightImageView.setBackgroundResource(resid);
	}

	public void setActionBarLeftImageView(int resid){
		mActionBarLeftImageView.setBackgroundResource(resid);
	}

	public void setmActionBarRightTextView(CharSequence charSequence){
		mActionBarRightTextView.setText(charSequence);
	}
	public void setmActionBarLeftTextView(CharSequence charSequence){
		mActionBarLeftTextView.setText(charSequence);
	}

	public void setTextViewSelected(String tag){
		if(RIGHT_TEXT_TAG.equals(tag)){
			mActionBarRightTextView.setSelected(true);
			mActionBarLeftTextView.setSelected(false);
		}else{
			mActionBarLeftTextView.setSelected(true);
			mActionBarRightTextView.setSelected(false);
		}
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
			case R.id.img_actionbar_left:
				if(mOnActionBarClickListener != null){
					mOnActionBarClickListener.click(LEFT_IMG_TAG);
				}
				break;
			case R.id.img_actionbar_right:
				if(mOnActionBarClickListener != null){
					mOnActionBarClickListener.click(RIGHT_IMG_TAG);
				}
				break;
			case R.id.tv_actionbar_left_text:
				setTextViewSelected(LEFT_TEXT_TAG);
				if(mOnActionBarClickListener != null){
					mOnActionBarClickListener.click(LEFT_TEXT_TAG);
				}
				break;
			case R.id.tv_actionbar_right_text:
				setTextViewSelected(RIGHT_TEXT_TAG);
				if(mOnActionBarClickListener != null){
					mOnActionBarClickListener.click(RIGHT_TEXT_TAG);
				}
				break;
			default:
				break;
		}
	}
}
