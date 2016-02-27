package com.okawa.pedro.toolbarpagerview.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.okawa.pedro.toolbarpagerview.R;
import com.okawa.pedro.toolbarpagerview.adapter.ToolbarPagerAdapter;

/**
 * Created by pokawa on 27/02/16.
 */
public class ToolbarPagerView extends RelativeLayout {

    private static final @IdRes int MENU_ID = 0x0042;
    private static final @IdRes int PAGER_ID = 0x0666;

    private int totalPages;
    private int currentPage;
    private @ColorInt int toolbarColor;
    private @ColorInt int itemColor;
    private ToolbarPagerAdapter toolbarPagerAdapter;
    private LinearLayout menu;
    private ViewPager viewPager;
    private View marker;

    public ToolbarPagerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize(context, attrs);
    }

    public ToolbarPagerView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
        initialize(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ToolbarPagerView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initialize(context, attrs);
    }

    private void initialize(Context context, AttributeSet attrs) {
        /* RETRIEVE MAX PAGES */
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.ToolbarPagerView);
        try {
            toolbarColor = attributes.getInteger(R.styleable.ToolbarPagerView_toolbar_color, R.color.color_primary_dark);
            itemColor = attributes.getInteger(R.styleable.ToolbarPagerView_item_color, R.color.color_accent);
        } finally {
            attributes.recycle();
            setViews(context);
        }
    }

    private void setViews(Context context) {
        /* MENU */
        menu = new LinearLayout(context);
        menu.setId(MENU_ID);
        menu.setOrientation(LinearLayout.HORIZONTAL);
        menu.setBackgroundColor(toolbarColor);
        menu.setGravity(Gravity.CENTER);

        addView(menu);

        LayoutParams menuParams = (LayoutParams) menu.getLayoutParams();

        TypedArray toolbarAttributes = context.getTheme().obtainStyledAttributes(new int[] { android.R.attr.actionBarSize });
        menuParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        menuParams.height = (int) toolbarAttributes.getDimension(0, 0);

        /* PAGES */
        viewPager = new ViewPager(context);
        viewPager.setId(PAGER_ID);

        addView(viewPager);

        LayoutParams pagerParams = (LayoutParams) viewPager.getLayoutParams();
        pagerParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        pagerParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
        pagerParams.addRule(BELOW, MENU_ID);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                marker.setX((positionOffsetPixels / totalPages) + (marker.getMeasuredWidth() * position));
            }

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        /* SHADOW */
        View shadow = new View(context);
        shadow.setBackgroundResource(R.drawable.shadow);

        addView(shadow);

        LayoutParams shadowParams = (LayoutParams) shadow.getLayoutParams();

        shadowParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        shadowParams.height = (int) context.getResources().getDimension(R.dimen.shadow_height);

        shadowParams.addRule(BELOW, MENU_ID);

        /* MARKER */
        marker = new View(context);
        marker.setBackgroundColor(itemColor);

        addView(marker);

        LayoutParams markerParams = (LayoutParams) marker.getLayoutParams();
        markerParams.height = (int) context.getResources().getDimension(R.dimen.marker_height);
        markerParams.addRule(ALIGN_BOTTOM, MENU_ID);

        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.JELLY_BEAN) {
                    getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }

                LayoutParams markerParams = (LayoutParams) marker.getLayoutParams();
                markerParams.width = menu.getMeasuredWidth() / totalPages;
                marker.setX(currentPage * markerParams.width);
            }
        });
    }

    public void setAdapter(FragmentManager fragmentManager) {
        toolbarPagerAdapter = new ToolbarPagerAdapter(fragmentManager);
        viewPager.setAdapter(toolbarPagerAdapter);
    }

    public void addPage(Fragment fragment) {
        addPage(R.mipmap.ic_star, fragment);
    }

    public void addPage(@DrawableRes int icon, Fragment fragment) {
        ImageView item = new ImageView(getContext());

        item.setImageResource(icon);
        item.setTag(totalPages);
        item.setColorFilter(itemColor);

        TypedArray selectAttributes = getContext().obtainStyledAttributes(new int[]{android.R.attr.selectableItemBackground});

        if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.JELLY_BEAN) {
            item.setBackgroundDrawable(selectAttributes.getDrawable(0));
        } else {
            item.setBackground(selectAttributes.getDrawable(0));
        }

        menu.setWeightSum(++totalPages);
        menu.addView(item);

        item.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer itemPosition = (Integer) v.getTag();
                viewPager.setCurrentItem(itemPosition);
            }
        });

        LinearLayout.LayoutParams itemParams = (LinearLayout.LayoutParams) item.getLayoutParams();

        itemParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        itemParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
        itemParams.weight = 1;

        toolbarPagerAdapter.addPage(fragment);
    }

}
