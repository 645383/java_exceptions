package courses.ex.try_resources2;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 28.10.13
 * Time: 15:51
 * To change this template use File | Settings | File Templates.
 */
public interface AutoCloseableFactory {
    public AutoCloseable create() throws Throwable;
}
