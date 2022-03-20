public enum PlaneType {

    BOEING747(370),
    AIRBUSA320(150),
    CRJ200(50),
    CESSNA172(4);

    private final int capacity;

    PlaneType(int capacity) {
        this.capacity = capacity;
    }

    public int returnCapacity(){
        return this.capacity;
    }
}
