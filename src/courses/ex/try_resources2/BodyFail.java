package courses.ex.try_resources2;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 29.10.13
 * Time: 13:18
 * To change this template use File | Settings | File Templates.
 */
public class BodyFail implements TryBody {
    public void runBody() throws Throwable {
        System.err.println("body");
        throw new Error("body");
    }
}