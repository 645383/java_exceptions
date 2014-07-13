package courses.ex.try_resources2;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 29.10.13
 * Time: 13:24
 * To change this template use File | Settings | File Templates.
 */
public class CloseableFail implements AutoCloseable {
    private final String name;
    public CloseableFail(String name) {
        this.name = name;
    }
    public void close() throws Exception {
        System.err.println("close:" + name);
        throw new Error("close:" + name);
    }
}
