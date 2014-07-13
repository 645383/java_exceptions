package courses.ex.try_resources2;



/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 29.10.13
 * Time: 12:59
 * To change this template use File | Settings | File Templates.
 */
//public class Example {
//    public static void main(String[] args) throws Throwable {
//        new ThreeTWR().call(new FactoryOkFail("A"), new FactoryOkFail("B"), new FactoryOkOk("C"), new BodyFail());
//    }
//}

public class Example {
    public static void main(String[] args) throws Throwable {
        new TreeImpl_2().call(new FactoryOkOk("A"), new FactoryOkFail("B"), new FactoryOkFail("C"), new BodyFail());
    }
}


