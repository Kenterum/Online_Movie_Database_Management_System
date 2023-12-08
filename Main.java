public class Main {
    public static void main(String[] args) {
        MovieTest mBase = new MovieTest();

        // Test Add
        MovieTest.testAdd(mBase);

        // Test Remove
        MovieTest.testRemove(mBase);

        // Test Retrieve
        MovieTest.testRetrieve(mBase);
    }
}
