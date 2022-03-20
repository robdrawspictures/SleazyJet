public class Plane {

    PlaneType planeType;
    Double totalWeight;

    public Plane(PlaneType planeType, Double totalWeight) {
        this.planeType = planeType;
        this.totalWeight = totalWeight;
    }

    public double calculateBaggageAllowance(){
        return totalWeight/2;
    }

    public double calculateIndividualBagAllowance(){
        double totalAllowance = calculateBaggageAllowance();
        return totalAllowance/this.planeType.returnCapacity();
    }


}
