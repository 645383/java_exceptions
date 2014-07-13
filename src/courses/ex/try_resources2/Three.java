package courses.ex.try_resources2;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 28.10.13
 * Time: 15:50
 * To change this template use File | Settings | File Templates.
 */
public interface Three {
    public void call(AutoCloseableFactory factoryA, AutoCloseableFactory factoryB,
                     AutoCloseableFactory factoryC, TryBody body) throws Throwable;
}