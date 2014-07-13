package courses.ex.try_resources2;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 29.10.13
 * Time: 13:18
 * To change this template use File | Settings | File Templates.
 */
public class CloseableOk implements AutoCloseable {
    private final String name;
    public CloseableOk(String name) {
        this.name = name;
    }
    public void close() throws Exception {
        System.err.println("close:" + name);
    }
}