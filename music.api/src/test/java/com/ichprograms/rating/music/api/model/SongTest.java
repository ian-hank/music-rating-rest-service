package com.ichprograms.rating.music.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SongTest {
    @DisplayName("Determines if the pass-by-value Song constructor intializes properly with the given values.")
    @Test
    public void SongConstructorAssignementTest() {
        ArrayList<String> setAuthors = new ArrayList<>(Arrays.asList("Virtual Riot","Space Jesus"));
        Genre setGenre = new Genre("Riddim", "Dubstep");
        int month = 9;
        int year = 2021;

        Song newSong = new Song("Login", "Simulation", setAuthors, setGenre, month, year);
        assertEquals("Login", newSong.getTitle());
        assertEquals("Simulation", newSong.getAlbum());
        assertEquals(setAuthors, newSong.getAuthors());
        assertEquals(setGenre, newSong.getGenre());
        assertEquals(month, newSong.getMonth());
        assertEquals(year, newSong.getYear());
    }
}
