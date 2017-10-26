package com.changeringtone.birdrringtone.birdsringtoneandwallpaper.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.changeringtone.birdrringtone.birdsringtoneandwallpaper.DetailActivity;
import com.changeringtone.birdrringtone.birdsringtoneandwallpaper.R;
import com.changeringtone.birdrringtone.birdsringtoneandwallpaper.model.Song;

import java.io.IOException;
import java.util.List;

public class ListViewRingToneAdapter extends ArrayAdapter<Song> {
    private Context mContext;
    private int resource;
    private List<Song> arrContext;
    
    public ListViewRingToneAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Song> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.resource = resource;
        this.arrContext = objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.row_ringtone, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.titleRingTon = convertView.findViewById(R.id.titleRingTon);
            viewHolder.duringRingTon = convertView.findViewById(R.id.duringRingTon);
            viewHolder.iconPlay = convertView.findViewById(R.id.iconPlay);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Song Song = arrContext.get(position);

        viewHolder.titleRingTon.setText(Song.getTitle());
        viewHolder.duringRingTon.setText(Song.getDuring());
        viewHolder.iconPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer player = MediaPlayer.create(mContext, Uri.parse(arrContext.get(position).getTitle()));
                try {
                    player.prepare();
                    player.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.d("onclick", position + "");
            }
        });

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("position", position);
                mContext.startActivity(intent);
            }
        });

        return convertView;
    }

    private class ViewHolder {
        TextView titleRingTon, duringRingTon;
        ImageButton iconPlay;
    }
}
