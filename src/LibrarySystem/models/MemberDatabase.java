package LibrarySystem.models;

import java.util.ArrayList;
import java.util.List;

public class MemberDatabase {
    private List<Reader> readers;


    public MemberDatabase() {
        this.readers = new ArrayList<>();
    }

    public void addReader(Reader reader) {
        readers.add(reader);
        System.out.println("Üye veri tabanına okuyucu eklendi: " + reader.getName());
    }

    public Reader searchReaderByName(String name) {
        for (Reader reader : readers) {
            if (reader.getName().equalsIgnoreCase(name)) {
                return reader;
            }
        }
        return null;
    }

    public List<Reader> getAllReaders() {
        return new ArrayList<>(readers); // Kopyayı döndürerek dışarıdan değişiklik yapılmasını engelle
    }
}