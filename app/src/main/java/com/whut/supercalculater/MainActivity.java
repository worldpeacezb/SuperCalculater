package com.whut.supercalculater;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.app.Activity;
import android.graphics.Color;

public class MainActivity extends Activity {

    private ViewPager pager;
    private List<View> viewList = new ArrayList<View>();//数据源
    private PagerAdapter viewAdapter;

    private List<String> titles = new ArrayList<String>();//标题



    private LayoutInflater inflater;

    private PagerTabStrip pagerTitle;//ViewPager的标题


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取ViewPager
        pager = (ViewPager) findViewById(R.id.view_pager);

        //获取pagerTitle
        pagerTitle = (PagerTabStrip) findViewById(R.id.pager_title);

        //为标题设置属性，比如背景，颜色线等
        pagerTitle.setBackgroundColor(Color.green(255));//设置背景颜色
        pagerTitle.setTextColor(Color.BLACK);//设置标题文字的颜色
        pagerTitle.setDrawFullUnderline(false);//将标题下的长分割线去掉
        pagerTitle.setTabIndicatorColor(Color.BLUE);//设置标题下粗一点的短分割线的颜色

        //添加标题
        titles.add("计算器");
        titles.add("亲戚关系");
        titles.add("个税计算");




        inflater = LayoutInflater.from(this);

        //获取四个view
        View view1 = inflater.inflate(R.layout.basic, null);
        View view2 = inflater.inflate(R.layout.relative, null);
        View view3 = inflater.inflate(R.layout.personal_tax, null);

        //将四个View加入到集合
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);

        //实例化适配器
        viewAdapter = new ViewAdapter(viewList,titles);

        //设置适配器
        pager.setAdapter(viewAdapter);
    }


}
