package courses.ex.try_resources2;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 28.10.13
 * Time: 15:50
 * To change this template use File | Settings | File Templates.
 */
public class ThreeTWR implements Three {
    public void call(AutoCloseableFactory factoryA, AutoCloseableFactory factoryB,
                     AutoCloseableFactory factoryC, TryBody body) throws Throwable {
        try (AutoCloseable resourceA = factoryA.create();
             AutoCloseable resourceB = factoryB.create();
             AutoCloseable resourceC = factoryC.create())
        {
            body.runBody();
        }
    }
}
