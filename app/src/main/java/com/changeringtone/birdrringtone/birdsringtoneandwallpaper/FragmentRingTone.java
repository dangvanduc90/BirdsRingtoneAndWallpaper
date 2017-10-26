package com.changeringtone.birdrringtone.birdsringtoneandwallpaper;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FragmentRingTone extends Fragment {

    ListView lvRecommend;
    ListViewRingToneAdapter adapter;
    List<Song> songList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ringtone, container, false);
        lvRecommend = view.findViewById(R.id.lvRecommend);

        songList = listAssetFiles("");
        adapter = new ListViewRingToneAdapter(getActivity(), R.layout.row_ringtone, songList);
        lvRecommend.setAdapter(adapter);
        return view;
    }

    private List<Song> listAssetFiles(String path) {
        String [] list;
        List<Song> danhsachSong = new ArrayList<>();
        try {
            list = getActivity().getAssets().list(path);
            if (list.length > 0) {
                MediaPlayer mp = new MediaPlayer();
                // This is a folder
                for (String file : list) {
                    AssetFileDescriptor afd = getActivity().getAssets().openFd(file);
                    mp.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                    int duration = mp.getDuration();
                    String timer = miliSecondsToTimer(duration);
                    Song song = new Song(file, timer);
                    danhsachSong.add(song);
                }
            }
        } catch (IOException e) {
            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return danhsachSong;
    }

    private String miliSecondsToTimer(long miliSeconds) {
        int minute = (int) (miliSeconds % (1000*60*60)) / (1000*60);
        int seconds = (int) (miliSeconds % (1000*60*60)) % (1000*60) / 1000;
        return minute + ":" + seconds;
    }
}
