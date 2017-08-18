package com.liao.wheelviewdemo;

/**
 * Created by Jane on 2017/8/18.
 */


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.liao.wheel.adapters.AbstractWheelTextAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Adapter for countries
 */
class ProvinceAdapter extends AbstractWheelTextAdapter {
    private List<String> provinces = new ArrayList<>();
//    private String provinces[] = new String[]{"湖南", "湖北", "江苏", "浙江"};

    /**
     * Constructor
     */
    protected ProvinceAdapter(Context context, int layout, int textResId) {
        super(context, layout, NO_RESOURCE);

        setItemTextResource(textResId);
    }

    @Override
    public View getItem(int index, View cachedView, ViewGroup parent) {
        return super.getItem(index, cachedView, parent);
    }

    @Override
    public int getItemsCount() {
        return provinces.size();
    }

    @Override
    protected CharSequence getItemText(int index) {
        return provinces.get(index);
    }
}
