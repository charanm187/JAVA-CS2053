
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<String> playlist = new LinkedList<>();
        int choice;

        do {
            System.out.println("\n🎵 --- Music Playlist Menu ---");
            System.out.println("1. Add song at the beginning");
            System.out.println("2. Add song at the end");
            System.out.println("3. Remove first song");
            System.out.println("4. Remove last song");
            System.out.println("5. Replace a song at given index");
            System.out.println("6. Display complete playlist");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter song name to add at beginning: ");
                    String firstSong = sc.nextLine();
                    playlist.addFirst(firstSong);
                    System.out.println("✅ Song added at beginning!");
                    break;

                case 2:
                    System.out.print("Enter song name to add at end: ");
                    String lastSong = sc.nextLine();
                    playlist.addLast(lastSong);
                    System.out.println("✅ Song added at end!");
                    break;

                case 3:
                    if (!playlist.isEmpty()) {
                        System.out.println("🎶 Removed: " + playlist.removeFirst());
                    } else {
                        System.out.println("❌ Playlist is empty!");
                    }
                    break;

                case 4:
                    if (!playlist.isEmpty()) {
                        System.out.println("🎶 Removed: " + playlist.removeLast());
                    } else {
                        System.out.println("❌ Playlist is empty!");
                    }
                    break;

                case 5:
                    System.out.print("Enter index to replace: ");
                    int index = sc.nextInt();
                    sc.nextLine();
                    if (index >= 0 && index < playlist.size()) {
                        System.out.print("Enter new song name: ");
                        String newSong = sc.nextLine();
                        playlist.set(index, newSong);
                        System.out.println("✅ Song replaced successfully!");
                    } else {
                        System.out.println("❌ Invalid index!");
                    }
                    break;

                case 6:
                    System.out.println("\n🎧 Complete Playlist:");
                    if (playlist.isEmpty()) {
                        System.out.println("No songs in playlist.");
                    } else {
                        for (int i = 0; i < playlist.size(); i++) {
                            System.out.println(i + ". " + playlist.get(i));
                        }
                    }
                    break;

                case 0:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("❌ Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}






//OUTPUT:

🎵 --- Music Playlist Menu ---
1. Add song at the beginning
2. Add song at the end
3. Remove first song
4. Remove last song
5. Replace a song at given index
6. Display complete playlist
0. Exit
Enter your choice: 











