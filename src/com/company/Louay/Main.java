package com.company.Louay;

import java.util.*;

public class Main {

    private static List<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        Album album = new Album("Fight Back", "Neffex");
        album.addSong("Fight Back", 3.21);
        album.addSong("Make It", 4.14);
        album.addSong("Failure", 5.17);
        album.addSong("Unstoppable", 3.24);
        album.addSong("Crown", 3.55);
        album.addSong("What's Up", 2.13);
        album.addSong("Solider", 3.36);
        album.addSong("Never Give Up", 4.11);
        album.addSong("Graveyard", 2.53);
        albums.add(album);

        album = new Album("Unleashed", "Skillet");
        album.addSong("Feel Invincible", 3.49);
        album.addSong("Stars", 3.47);
        album.addSong("Undefeated", 3.36);
        album.addSong("Lions", 3.25);
        album.addSong("Burn It Down", 3.16);
        album.addSong("Back From The Dead", 3.33);
        album.addSong("I want to live", 3.28);
        album.addSong("Famous", 3.18);
        album.addSong("Out Of Hell", 3.34);
        albums.add(album);

        List<Song> playList = new Vector<>();
        albums.get(0).addToPlayList("Unstoppable", playList);
        albums.get(0).addToPlayList("Make It", playList);
        albums.get(0).addToPlayList("Lemon Fight", playList); // Does not exist
        albums.get(0).addToPlayList(9, playList);
        albums.get(1).addToPlayList(8, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(24, playList); // There is no track 24

        play(playList);


    }


    private static void play(List<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("No song in playlist");
            return;
        } else {
            System.out.println("Now Playing " + listIterator.next().toString());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;

                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now Playing " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;

                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now Playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                    break;

                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now replaying " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;

                case 4:
                    printList(playList);
                    break;

                case 5:
                    printMenu();
                    break;

                case 6:
                    if (playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing " + listIterator.next());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions.\n" +
                "6 - delete current song from playlist");
    }


    private static void printList(List<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("=============================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("=============================");

    }
}