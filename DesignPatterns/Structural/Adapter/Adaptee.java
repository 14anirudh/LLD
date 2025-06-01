


public interface Adaptee {
    void play(String fileName);
}

 class VlcPlayer implements Adaptee {
    public void play(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }
}

 class Mp4Player implements Adaptee {
    public void play(String fileName) {
        System.out.println("Playing mp4 file. Name: " + fileName);
    }
}
