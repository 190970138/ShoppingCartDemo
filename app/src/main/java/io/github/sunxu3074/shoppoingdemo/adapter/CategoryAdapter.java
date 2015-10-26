package io.github.sunxu3074.shoppoingdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.github.sunxu3074.shoppoingdemo.Entity.CategoryEntity;
import io.github.sunxu3074.shoppoingdemo.R;

/**
 * Created by zhangyan on 2015/10/21.
 */
public class CategoryAdapter extends BaseAdapter {

    private LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<CategoryEntity> mDatas = new ArrayList<>();

    public CategoryAdapter(Context context,List<CategoryEntity> mDatas) {
        mLayoutInflater = LayoutInflater.from(context);
        this.mContext = context;
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder ;
        if(convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_category, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.label = (TextView) convertView.findViewById(R.id.item_category_name);
            viewHolder.more = (TextView) convertView.findViewById(R.id.item_category_more);
            viewHolder.details = (TextView) convertView.findViewById(R.id.item_category_details);
            viewHolder.image = (ImageView) convertView.findViewById(R.id.item_category_img);
            viewHolder.number = (TextView) convertView.findViewById(R.id.item_category_number);
            viewHolder.price = (TextView) convertView.findViewById(R.id.item_category_price);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        CategoryEntity entity = (CategoryEntity) getItem(position);
        viewHolder.label.setText(entity.getName());
        viewHolder.details.setText(entity.getDetails());
        viewHolder.image.setImageResource(R.drawable.category);
        viewHolder.number.setText("已售出"+entity.getNumber()+"件");
        viewHolder.price.setText("￥"+entity.getPrice());
        return convertView;
    }
   static class ViewHolder{
        TextView label,more,details,number,price;
        ImageView image;
    }
}
