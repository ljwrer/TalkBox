package com.example.rmaiy.talkbox;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Rmaiy on 2015/5/10.
 */
public class TalkBoxAdapter extends ArrayAdapter<TalkBox> {
    public int resourceID;

    public TalkBoxAdapter(Context context, int resource, List<TalkBox> objects) {
        super(context, resource, objects);
        resourceID = resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TalkBox talkBox = getItem(position);
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceID, null);
            viewHolder = new ViewHolder();
            viewHolder.receiveMessage = (TextView) view.findViewById(R.id.receive_message);
            viewHolder.sendMessage = (TextView) view.findViewById(R.id.send_message);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        switch (talkBox.getStatus()) {
            case TalkBox.RECEIVE_MESSAGE:
                viewHolder.receiveMessage.setText(talkBox.getMessage());
                viewHolder.sendMessage.setVisibility(View.GONE);
                viewHolder.receiveMessage.setVisibility(View.VISIBLE);
                break;
            case TalkBox.SEND_MESSAGE:
                viewHolder.sendMessage.setText(talkBox.getMessage());
                viewHolder.receiveMessage.setVisibility(View.GONE);
                viewHolder.sendMessage.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
        return view;

    }

    class ViewHolder {
        TextView receiveMessage;
        TextView sendMessage;
    }
}
