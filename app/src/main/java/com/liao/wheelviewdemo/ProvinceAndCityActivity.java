package com.liao.wheelviewdemo;

import android.app.Activity;
import android.os.Bundle;

import com.liao.wheel.OnWheelChangedListener;
import com.liao.wheel.OnWheelScrollListener;
import com.liao.wheel.WheelView;
import com.liao.wheel.adapters.ArrayWheelAdapter;

/**
 * Created by Jane on 2017/8/17.
 */

public class ProvinceAndCityActivity extends Activity {
    private boolean scrolling = false;


    private String cities[][] = new String[][]{
            new String[]{"长沙", "衡阳", "张家界", "Atlanta", "Orlando"},
            new String[]{"Ottawa", "Vancouver", "Toronto", "Windsor", "Montreal"},
            new String[]{"Kiev", "Dnipro", "Lviv", "Kharkiv"},
            new String[]{"Paris", "Bordeaux"},
    };

    private WheelView province;
    private WheelView city;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.province_and_city_layout);
        province = (WheelView) findViewById(R.id.province);
        city = (WheelView) findViewById(R.id.city);

        province.setViewAdapter(new ProvinceAdapter(this, R.layout.province_layout, R.id.province_name));
        province.addChangingListener(new OnWheelChangedListener() {
            @Override
            public void onChanged(WheelView wheel, int oldValue, int newValue) {
                if (!scrolling) {
                    updateCities(city, cities, newValue);
                }
            }
        });


        province.addScrollingListener(new OnWheelScrollListener() {
            @Override
            public void onScrollingStarted(WheelView wheel) {
                scrolling = true;
            }

            @Override
            public void onScrollingFinished(WheelView wheel) {
                scrolling = false;
                updateCities(city, cities, province.getCurrentItem());
            }
        });
        province.setCurrentItem(0);
    }

    /**
     * Updates the city wheel
     */
    private void updateCities(WheelView city, String cities[][], int index) {
        ArrayWheelAdapter<String> adapter = new ArrayWheelAdapter<>(this, cities[index]);
        adapter.setTextSize(18);
        city.setViewAdapter(adapter);
        city.setCurrentItem(cities[index].length / 2);
    }

}
