package com.example.daimhim.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;

import com.example.daimhim.R;


/**
 * Created by Administrator on 2017/4/6.
 */
public class RadioGroupFlowLayout extends LinearLayout {
    //    private String TAG = getClass().getName();
    // holds the checked id; the selection is empty by default
    private int mCheckedId = -1;
    private int mChildId = -1;
    private boolean mRadioOrMultipleChoice;  //true 多选 false单选
    // tracks children radio buttons checked state
    private CompoundButton.OnCheckedChangeListener mChildOnCheckedChangeListener;
    // when true, mOnCheckedChangeListener discards events
    private boolean mProtectFromCheckedChange = false;
    private OnCheckedChangeListener mOnCheckedChangeListener;
    private PassThroughHierarchyChangeListener mPassThroughListener;

    public RadioGroupFlowLayout(Context context) {
        this(context, null);
    }

    public RadioGroupFlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RadioGroupFlowLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        final TypedArray a = context.obtainStyledAttributes(
                attrs, R.styleable.CompoundButton, defStyle, 0);
        final boolean checked = a.getBoolean(
                R.styleable.CompoundButton_checked, false);

        setChecked(checked);
        init();
    }

    private void init() {
        mChildOnCheckedChangeListener = new CheckedStateTracker();
        mPassThroughListener = new PassThroughHierarchyChangeListener();
        super.setOnHierarchyChangeListener(mPassThroughListener);
    }

    public CompoundButton getCompoundButton(int Id) {
        if (Id == -1 || null == findViewById(Id) && !(findViewById(Id) instanceof CompoundButton)) {
            return null;
        }
        return (CompoundButton) findViewById(Id);
    }

    @Override
    public void setOnHierarchyChangeListener(OnHierarchyChangeListener listener) {
        // the user listener is delegated to our pass-through listener
        mPassThroughListener.mOnHierarchyChangeListener = listener;
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        // checks the appropriate radio button as requested in the XML file
        if (mCheckedId != -1) {
            mProtectFromCheckedChange = true;
            setCheckedStateForView(mCheckedId, true);
            mProtectFromCheckedChange = false;
            setCheckedId(mCheckedId);
        }
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        checkViewType(false,child);
        super.addView(child, index, params);
    }

    private void checkViewType(boolean isChild,View child){
        if (child instanceof CompoundButton) {
            setChildAttribute(true,child);
        } else if (child instanceof RadioGroupFlowLayout){
            return;
        }else if(child instanceof ViewGroup) {
            ViewGroup linearLayout = (ViewGroup) child;
            int childCount = linearLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View view = linearLayout.getChildAt(i);
                checkViewType(true,view);
            }
        }
    }

    public void check(int id) {
        // don't even bother
        if (id != -1 && (id == mCheckedId)) {
            return;
        }

        if (mCheckedId != -1) {
            setCheckedStateForView(mCheckedId, false);
        }

        if (id != -1) {
            setCheckedStateForView(id, true);
        }

        setCheckedId(id);
    }

    private void setCheckedId(int id) {
        mCheckedId = id;
        if (mOnCheckedChangeListener != null) {
            mOnCheckedChangeListener.onCheckedChanged(this, mCheckedId);
        }
    }

    private void setCheckedStateForView(int viewId, boolean checked) {
        View checkedView = findViewById(viewId);
        if (checkedView != null && checkedView instanceof CompoundButton) {
            if (mCheckedId != mChildId && !mRadioOrMultipleChoice) {
                ((CompoundButton) checkedView).setChecked(checked);
                if (null!=mOnCheckedChangeListener){
                    mOnCheckedChangeListener.onCheckedChanged(this,viewId);
                }
            }
        }
    }

    private void setChildAttribute(boolean isChild,View child) {
        int id = child.getId();
        if (child instanceof RadioButton) {
            final RadioButton button = (RadioButton) child;
            if (isChild){
                if (id == View.NO_ID) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                        id = View.generateViewId();
                    }else {
                        id = child.hashCode();
                    }
                    child.setId(id);
                }
                button.setOnCheckedChangeListener(mChildOnCheckedChangeListener);
            }
            if (button.isChecked()) {
                mProtectFromCheckedChange = true;
                if (mCheckedId != -1) {
                    setCheckedStateForView(mCheckedId, false);
                }
                mProtectFromCheckedChange = false;
                setCheckedId(button.getId());
            }
        } else if (child instanceof CheckBox) {
            final CheckBox button = (CheckBox) child;
            if (isChild) {
                if (id == View.NO_ID) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                        id = View.generateViewId();
                    }else {
                        id = child.hashCode();
                    }
                    child.setId(id);
                }
                button.setOnCheckedChangeListener(mChildOnCheckedChangeListener);
            }
            if (button.isChecked()) {
                mProtectFromCheckedChange = true;
                if (mCheckedId != -1) {
                    setCheckedStateForView(mCheckedId, false);
                }
                mProtectFromCheckedChange = false;
                setCheckedId(button.getId());
            }
        } else {
            final CompoundButton button = (CompoundButton) child;
            if (isChild) {
                if (id == View.NO_ID) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                        id = View.generateViewId();
                    }else {
                        id = child.hashCode();
                    }
                    child.setId(id);
                }
                button.setOnCheckedChangeListener(mChildOnCheckedChangeListener);
            }
            if (button.isChecked()) {
                mProtectFromCheckedChange = true;
                if (mCheckedId != -1) {
                    setCheckedStateForView(mCheckedId, false);
                }
                mProtectFromCheckedChange = false;
                setCheckedId(button.getId());
            }
        }
    }

    public int getCheckedCompoundButtonId() {
        return mCheckedId;
    }


    public void clearCheck() {
        check(-1);
    }


    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        mOnCheckedChangeListener = listener;
    }


    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }


    @Override
    protected boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof LayoutParams;
    }

    @Override
    protected LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onInitializeAccessibilityEvent(AccessibilityEvent event) {
        super.onInitializeAccessibilityEvent(event);
        event.setClassName(RadioGroupFlowLayout.class.getName());
    }

    @SuppressLint("NewApi")
    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName(RadioGroupFlowLayout.class.getName());
    }

    public void setChecked(boolean checked) {
        mRadioOrMultipleChoice = checked;
    }

    public boolean isChecked() {
        return mRadioOrMultipleChoice;
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }


        public LayoutParams(int w, int h) {
            super(w, h);
        }


        public LayoutParams(int w, int h, float initWeight) {
            super(w, h, initWeight);
        }


        public LayoutParams(ViewGroup.LayoutParams p) {
            super(p);
        }


        public LayoutParams(MarginLayoutParams source) {
            super(source);
        }


        @Override
        protected void setBaseAttributes(TypedArray a,
                                         int widthAttr, int heightAttr) {

            if (a.hasValue(widthAttr)) {
                width = a.getLayoutDimension(widthAttr, "layout_width");
            } else {
                width = WRAP_CONTENT;
            }

            if (a.hasValue(heightAttr)) {
                height = a.getLayoutDimension(heightAttr, "layout_height");
            } else {
                height = WRAP_CONTENT;
            }
        }
    }


    public interface OnCheckedChangeListener {

        public void onCheckedChanged(RadioGroupFlowLayout group, int checkedId);
    }

    private class CheckedStateTracker implements CompoundButton.OnCheckedChangeListener {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            // prevents from infinite recursion
            if (mProtectFromCheckedChange) {
                return;
            }
            mChildId = buttonView.getId();
            mProtectFromCheckedChange = true;
            if (mCheckedId != -1) {
                setCheckedStateForView(mCheckedId, false);
            }
            mProtectFromCheckedChange = false;
            setCheckedId(buttonView.getId());
        }
    }

    private class PassThroughHierarchyChangeListener implements
            OnHierarchyChangeListener {
        private OnHierarchyChangeListener mOnHierarchyChangeListener;


        public void onChildViewAdded(View parent, View child) {
            if (parent instanceof ViewGroup && child instanceof CompoundButton) {
                int id = child.getId();
                // generates an id if it's missing

                if (id == View.NO_ID) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                        id = View.generateViewId();
                    }else {
                        id = child.hashCode();
                    }
                    child.setId(id);
                }
                ((CompoundButton) child).setOnCheckedChangeListener(
                        mChildOnCheckedChangeListener);
            }

            if (mOnHierarchyChangeListener != null) {
                mOnHierarchyChangeListener.onChildViewAdded(parent, child);
            }
        }


        public void onChildViewRemoved(View parent, View child) {
            if (parent instanceof ViewGroup && child instanceof CompoundButton) {
                ((CompoundButton) child).setOnCheckedChangeListener(null);
            }

            if (mOnHierarchyChangeListener != null) {
                mOnHierarchyChangeListener.onChildViewRemoved(parent, child);
            }
        }
    }
}
/**
 *
 * ━━━━━━神兽出没━━━━━━
 *   ┏━┓      ┏━┓
 * ┏━┛ ┻━━━━━━┛ ┻━┓
 * ┃              ┃
 * ┃     ━━       ┃
 * ┃  ━┳┛   ┗┳━   ┃
 * ┃              ┃
 * ┃      ┻       ┃
 * ┃              ┃
 * ┗━━━┓      ┏━━━┛Code is far away from bug with the animal protecting
 *     ┃      ┃    神兽保佑,代码无bug
 *     ┃      ┃
 *     ┃      ┗━━━━━━━━━━┓
 *     ┃                 ┣┓
 *     ┃                 ┏┛
 *     ┗━━┓┓ ┏━━━━━┳┓ ┏━━┛
 *        ┃┫ ┫     ┃┫ ┫
 *        ┗┻━┛     ┗┻━┛
 *
 * ━━━━━━感觉萌萌哒━━━━━━
 */