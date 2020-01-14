package ctci.inheritance;

import java.io.UncheckedIOException;

class A {
    public void testHiding() {
        hideMe();
    }

    private void hideMe() {
        System.out.println("A.hideMe");
    }
}

class B extends A {
    @Override
    public void testHiding() {
        hideMe();
        super.testHiding();
    }

    private void hideMe() {
        System.out.println("B.hideMe");
    }
}

class C extends B {
}

class Test {

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        C c = new C();

        Test t = new Test();
        t.handleA(a); // expect a
        t.handleA(c); // expect c
        t.handleA(b); // expect a
        t.handleA((A) c); // expect a

        Object o = c;
        t.handleA(o);

        a.testHiding();
        b.testHiding();
    }

    public void handleA(Object o) throws RuntimeException {
        System.out.println("Got o " + o);
    }

    public void handleA(A a) throws IndexOutOfBoundsException {
        System.out.println("Got a " + a);
    }

    public void handleA(C c) throws UncheckedIOException {
        System.out.println("Got c " + c);
    }

}