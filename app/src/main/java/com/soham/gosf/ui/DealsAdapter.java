package com.soham.gosf.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.soham.gosf.R;
import com.soham.gosf.network.model.Collection1;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by sohammondal on 23/12/14.
 */
public class DealsAdapter extends BaseAdapter {
    private List<Collection1> collection1List;
    private Context context;
    private LayoutInflater layoutInflater;

    public DealsAdapter(List<Collection1> collection1List, Context context) {
        this.collection1List = collection1List;
        this.context = context;
    }

    @Override
    public int getCount() {
        if (collection1List != null) {
            return collection1List.size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        if (collection1List != null) {
            return collection1List.get(position);
        } else {
            return null;
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static class ViewHolder {
        ImageView image;
        TextView content;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            if(layoutInflater == null) {
                layoutInflater = LayoutInflater.from(context);
            }
            convertView = layoutInflater.inflate(R.layout.list_deals, parent, false);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.image = (ImageView) convertView.findViewById(R.id.image);
            viewHolder.content = (TextView) convertView.findViewById(R.id.content);
            convertView.setTag(viewHolder);
        }

        ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        Collection1 collection1 = (Collection1) getItem(position);
        if(collection1 != null) {
            Picasso.with(context).load(collection1.getImage().getSrc()).into(viewHolder.image);
            viewHolder.content.setText(collection1.getTitle().getText());
        }
        return convertView;
    }
}
