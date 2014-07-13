package courses.ex.try_resources2;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 29.10.13
 * Time: 13:25
 * To change this template use File | Settings | File Templates.
 */
public class FactoryFail implements AutoCloseableFactory {
    private final String name;
    public FactoryFail(String name) {
        this.name = name;
    }
    public AutoCloseable create() throws Throwable {
        System.err.println("create:" + name);
        throw new Error("create:" + name);
    }
}
