package Back_end;


import java.lang.reflect.Type;

public class FriendsHandler<T> {
    private final Type type;

    public FriendsHandler(Type type) {
        this.type = type;
    }

    public void save(T data, String filePath) {
        FriendSaver<T> saver = new FriendSaver<>();
        saver.saveToFile(data, filePath);
    }

    public T load(String filePath) {
        FriendLoader<T> loader = new FriendLoader<>();
        return loader.loadFromFile(filePath, type);
    }
}