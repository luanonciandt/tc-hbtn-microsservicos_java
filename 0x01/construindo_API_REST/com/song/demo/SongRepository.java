package com.song.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class SongRepository {

    private List<Song> list =  new ArrayList<>();

    public List<Song> getAllSongs() {
        return list;
    }

    public Song getSongById(Integer id) {
        return list.stream().filter(song -> song.getId().equals(id)).collect(Collectors.toList()).get(0);
    }

    public void addSong(Song s) {
        list.add(s);
    }

    public void updateSong(Song s) {
        list = list.stream().map(song -> {
            if (song.getId().equals(s.getId())) {
                song = s;
            }
            return song;
        }).collect(Collectors.toList());
    }

    public void removeSong(Song s) {
        list.remove(s);
    }

}
