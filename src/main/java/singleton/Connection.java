package singleton;

public class Connection {

  private static volatile Connection instance;

  private Connection() {
  }

  public static Connection getInstance() {
    if (instance == null) {
      synchronized (Connection.class) {
        if (instance == null) {
          instance = new Connection();
        }
      }
    }
    return instance;
  }
}
