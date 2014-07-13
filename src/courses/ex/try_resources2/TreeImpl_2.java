package courses.ex.try_resources2;

public class TreeImpl_2 implements Three{
    public void call(AutoCloseableFactory factoryA,
                     AutoCloseableFactory factoryB,
                     AutoCloseableFactory factoryC, TryBody body) throws Throwable {
        ///////////////////////////////////////////
        AutoCloseable resurceA = null;
        AutoCloseable resurceB = null;
        AutoCloseable resurceC = null;
        resurceA = factoryA.create();// crA -    Главарь_crAEx
        // crA +
        try {/*2 0*//////////////////////////////////////////
            resurceB = factoryB.create();
            // crB +
        } catch (Throwable crBEx) { // crB -    Главарь_crBEx
            try {/*2 1*/
                resurceA.close();
                // clA +
            } catch (Exception clAEx) {  // clA -   Подченённый_clAEx
                 crBEx.addSuppressed(clAEx);
            }
            throw  crBEx; // Всё хорошо после crBEx
        }
        try {/*3 0*//////////////////////////////////////////
            resurceC = factoryC.create();
            // crC +
        } catch (Throwable crCEx) { // crC -  Главарь_crCEx
            try {/*3 1*/
                resurceB.close();
                // clB +
            } catch (Exception clBEx) { // clB -  Подченённый_clBEx
                crCEx.addSuppressed(clBEx);
                try {/*3 2*/
                    resurceA.close();
                    // clA +
                } catch (Exception clAEx) { // clA -  Подченённый_clAEx
                    crCEx.addSuppressed(clAEx);
                }
                throw crCEx;
            }
            try {/*3 1 1*/// clB +
                resurceA.close();
                // clA +
            } catch (Exception clAEx) { // clA -  Подченённый_clAEx
                crCEx.addSuppressed(clAEx);
            }
            throw crCEx;  // Всё хорошо после crCEx
        }
        try {/*4*//////////////////////////////////////////
            body.runBody();
            // rB +
        } catch (Throwable rBEx) {     // rBEx -   Главарь_rBEx
            try {/*4 1*/
                resurceC.close();
                // clC +
            } catch (Exception clCEx) { // clCEx -     Подченённый_clCEx
                rBEx.addSuppressed(clCEx);
                try {/*4 2 */
                    resurceB.close();
                    // clB +
                } catch (Exception clBEx) {  // clBEx -     Подченённый_clBEx
                    rBEx.addSuppressed(clBEx);
                    try {/*4 3*/
                        resurceA.close();
                        // clA +
                    } catch (Exception clAEx) {  // clAEx -     Подченённый_clAEx
                        rBEx.addSuppressed(clAEx);
                    }
                    throw rBEx;
                }
                try { /*4 2 2*/
                    resurceA.close();
                    // clA +
                } catch (Exception clAEx) {  // clAEx -     Подченённый_clAEx
                    rBEx.addSuppressed(clAEx);
                }
                throw rBEx;
            }//clC +
            try {/*4 1 1*/// clC +
                resurceB.close();
                // clB +
            } catch (Exception clBEx) { // clBEx -     Подченённый_clBEx
                rBEx.addSuppressed(clBEx);
                try {/*4 1 2*/
                    resurceA.close();
                    // clA +
                } catch (Exception clAEx) { // clAEx -     Подченённый_clAEx
                    rBEx.addSuppressed(clAEx);
                }
                throw rBEx;
            }
            try { /*4 1 1 1*/
                resurceA.close();
                // clA +
            } catch (Exception clAEx) {  // clAEx -     Подченённый_clAEx
                rBEx.addSuppressed(rBEx);
            }
            throw rBEx;
        }
        //////////////////////////////////////////
        try {/*5*/
            resurceC.close();
            // clC +
        } catch (Exception clCEx) {   // clCEx -   Главарь_clCEx
            try { /*5 1*/
                resurceB.close();
                // clB +
            } catch (Exception clBEx) {    // clBEx -     Подченённый_clBEx
                clCEx.addSuppressed(clBEx);
                try {/*5 2*/
                    resurceA.close();
                    // clA +
                } catch (Exception clAEx) {    // clAEx -     Подченённый_clAEx
                    clCEx.addSuppressed(clAEx);
                }
                throw clCEx;
            }
            try {/*5 1 1*/
                resurceA.close();
                // clA +
            } catch (Exception clAEx) {  // clAEx -     Подченённый_clAEx
                clCEx.addSuppressed(clAEx);
            }
            throw clCEx;
        }
        try {/*6*//////////////////////////////////////////////
            resurceB.close();
            // clB +
        } catch (Exception clBEx) {    // clBEx -     Главарь_clBEx
            try {/*6 1*/
                resurceA.close();
                // clA +
            } catch (Exception clAEx) {     // clAEx -     Подченённый_clAEx
                clBEx.addSuppressed(clAEx);
            }
            throw clBEx;
        }
        /*7*/
        resurceA.close();  // clAEx -    Главарь_clAEx
    }
}
