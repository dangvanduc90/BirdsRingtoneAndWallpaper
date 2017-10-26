package com.changeringtone.birdrringtone.birdsringtoneandwallpaper.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaMetadataRetriever;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListAssetFiles {

    private Context mContext;

    public ListAssetFiles(Context mContext) {
        this.mContext = mContext;
    }

    public List<Song> listAssetFiles(String path) {
        String [] list;
        List<Song> danhsachSong = new ArrayList<>();
        try {
//            byte[] art;
            MediaMetadataRetriever metaRetriver = new MediaMetadataRetriever();
            list = mContext.getAssets().list(path);
            if (list.length > 0) {
//                MediaPlayer mp = new MediaPlayer();
                // This is a folder
                for (String file : list) {
                    AssetFileDescriptor afd = mContext.getAssets().openFd(file);
                    metaRetriver.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
//                    art = metaRetriver.getEmbeddedPicture();
//                    Bitmap songImage = BitmapFactory.decodeByteArray(art, 0, art.length);
//                    album_art.setImageBitmap(songImage);
                    String title = metaRetriver.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
                    long duration = Long.parseLong(metaRetriver.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION));
                    String timer = miliSecondsToTimer(duration);
                    Song song = new Song(title, timer);
                    danhsachSong.add(song);
                }
            }
        } catch (IOException e) {
            Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return danhsachSong;
    }

    private String miliSecondsToTimer(long miliSeconds) {
        int minute = (int) (miliSeconds % (1000*60*60)) / (1000*60);
        int seconds = (int) (miliSeconds % (1000*60*60)) % (1000*60) / 1000;
        return minute + ":" + seconds;
    }
}
