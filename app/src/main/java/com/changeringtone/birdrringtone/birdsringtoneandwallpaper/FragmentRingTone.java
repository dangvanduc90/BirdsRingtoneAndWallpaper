package com.changeringtone.birdrringtone.birdsringtoneandwallpaper;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.changeringtone.birdrringtone.birdsringtoneandwallpaper.adapter.ListViewRingToneAdapter;
import com.changeringtone.birdrringtone.birdsringtoneandwallpaper.model.ListAssetFiles;
import com.changeringtone.birdrringtone.birdsringtoneandwallpaper.model.Song;

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

        ListAssetFiles listAssetFiles = new ListAssetFiles(getActivity());
        songList = listAssetFiles.listAssetFiles("");
        adapter = new ListViewRingToneAdapter(getActivity(), R.layout.row_ringtone, songList);
        lvRecommend.setAdapter(adapter);
        return view;
    }
}
