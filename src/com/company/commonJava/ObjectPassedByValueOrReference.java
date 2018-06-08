package com.company.commonJava;

/**
 * Created by tripti on 08/06/18.
 */

public class ObjectPassedByValueOrReference {

        int a, b;

        ObjectPassedByValueOrReference(int i, int j)
        {
            a = i;
            b = j;
        }

        // return true if o is equal to the invoking
        // object notice an object is passed as an
        // argument to method
        static boolean equalTo(ObjectPassedByValueOrReference o, ObjectPassedByValueOrReference c)
        {
            return (o == c);
        }

        static void swap(ObjectPassedByValueOrReference o, ObjectPassedByValueOrReference c)
        {
            ObjectPassedByValueOrReference temp = o;
            o = c;
            c = temp;
            System.out.println("ob2 = : " + o.toStringValue());
            System.out.println("ob3 = : " + c.toStringValue());
        }

        String toStringValue() {
            return "{a = " + a + ", b = "+ b + "}";
        }

    // Driver class
    public static class Test
    {
        public static void main(String args[])
        {
            ObjectPassedByValueOrReference ob1 = new ObjectPassedByValueOrReference(100, 22);
            ObjectPassedByValueOrReference ob2 = new ObjectPassedByValueOrReference(100, 22);
            ObjectPassedByValueOrReference ob3 = new ObjectPassedByValueOrReference(-1, -1);

            System.out.println("ob1 == ob2: " + ObjectPassedByValueOrReference.equalTo(ob2, ob1));
            System.out.println("ob1 == ob3: " + ObjectPassedByValueOrReference.equalTo(ob3, ob1));
            ObjectPassedByValueOrReference.swap(ob2,ob3);
            System.out.println("ob2 = : " + ob2.toStringValue());
            System.out.println("ob3 = : " + ob3.toStringValue());

            //When an object reference is passed to a method, the reference itself is passed by use of call-by-value.
            //However, since the value being passed refers to an object, the copy of that value will still refer to the same object that its corresponding argument does.
            // That’s why we said that java is strictly pass-by-value.


        }
    }
}
