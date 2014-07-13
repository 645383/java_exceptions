package courses.ex.try_resources2;

/**
 * Created with IntelliJ IDEA.
 * User: User
 * Date: 29.10.13
 * Time: 12:58
 * To change this template use File | Settings | File Templates.
 */
public class ThreeImpl implements Three {

    public void call(AutoCloseableFactory factoryA, AutoCloseableFactory factoryB,
                     AutoCloseableFactory factoryC, TryBody body) throws Throwable {

        // --- create A ---
        AutoCloseable resourceA = factoryA.create();

        //--- create B and check for exceptions thrown ---
        try {
            AutoCloseable resourceB = factoryB.create();

            //--- create C and check for exceptions thrown---
            try {
                AutoCloseable resourceC = factoryC.create();

                //--- run body ---
                try {
                    body.runBody();
                } catch (Throwable bodyEx) {
                    try {
                        resourceC.close();
                    } catch (Throwable closeExC) {
                        bodyEx.addSuppressed(closeExC);
                    }
                    try {
                        resourceB.close();
                    } catch (Throwable closeExB) {
                        bodyEx.addSuppressed(closeExB);
                    }
                    try {
                        resourceA.close();
                    } catch (Throwable closeExA) {
                        bodyEx.addSuppressed(closeExA);
                    }
                    throw bodyEx;
                }

                //--- resourceC.close();

                try {
                    resourceC.close();
                } catch (Throwable closeEx_C) {
                    try {
                        resourceB.close();
                    } catch (Throwable closeExB) {
                        closeEx_C.addSuppressed(closeExB);
                    }
                    try {
                        resourceA.close();
                    } catch (Throwable closeExA) {
                        closeEx_C.addSuppressed(closeExA);
                    }
                    throw closeEx_C;
                }

                //--- resourceB.close();

                try {
                    resourceB.close();
                } catch (Throwable closeEx_B) {
                    try {
                        resourceA.close();
                    } catch (Throwable closeExA) {
                        closeEx_B.addSuppressed(closeExA);
                    }
                    throw closeEx_B;
                }

                //--- resourceA.close();

                try {
                    resourceA.close();
                } catch (Throwable closeEx_A) {
                    throw closeEx_A;
                }

            //--- catch create C exception

            } catch (Throwable createExC) {
                try {
                    if (factoryC.getClass().toString().endsWith("FactoryFail") == true)
                        resourceB.close();
                } catch (Throwable closeExB) {
                    createExC.addSuppressed(closeExB);
                }
                try {
                    if (factoryC.getClass().toString().endsWith("FactoryFail") == true)
                        resourceA.close();
                } catch (Throwable closeExA) {
                    createExC.addSuppressed(closeExA);
                }
                throw createExC;
            }

        //--- catch create B exception

        } catch (Throwable createExB) {
            try {
                if (factoryB.getClass().toString().endsWith("FactoryFail") == true)
                    resourceA.close();
            } catch (Throwable closeExA) {
                createExB.addSuppressed(closeExA);
            }
            throw createExB;
        }
    }
}

