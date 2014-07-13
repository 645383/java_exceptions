package courses.ex.try_resources2;


/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 29.10.13
 * Time: 13:28
 * To change this template use File | Settings | File Templates.
 */
public class FactoryOkFail implements AutoCloseableFactory {
    private final String name;
    public FactoryOkFail(String name) {
        this.name = name;
    }
    @Override
    public AutoCloseable create() throws Throwable {
        System.err.println("create:" + name);
        return new CloseableFail(name);
    }
}