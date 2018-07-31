import java.util.ArrayList;
import java.util.List;

/**
 * Zone class will specifies the operations on the specified zone
 * @author Rachna Jadam
 */
public class Zone 
{
    private AnimalFamily zoneType; 
    private final int capacity;
    private List<Cage> listOfCages = new ArrayList<>();
    private boolean hasPark, hasCanteen;
	
    /**
     * This Zone constructor initializes the zone properties
     * @param zoneType
     * @param capacity
     * @param hasPark
     * @param hasCanteen
     * Here getter setter are present to access properties
     */
    public Zone(AnimalFamily zoneType, int capacity, boolean hasPark, boolean hasCanteen){
        this.zoneType = zoneType;
        this.capacity = capacity;
        this.hasPark = hasPark;
        this.hasCanteen = hasCanteen;
    }

    public AnimalFamily getZoneType() {
        return zoneType;
    }

    public void setZoneType(AnimalFamily zoneType) {
        this.zoneType = zoneType;
    }

    public List<Cage> getNoOfCages() {
        return listOfCages;
    }

    public boolean isHasPark() {
        return hasPark;
    }

    public void setHasPark(boolean hasPark) {
        this.hasPark = hasPark;
    }

    public boolean isHasCanteen() {
        return hasCanteen;
    }

    public void setHasCanteen(boolean hasCanteen) {
        this.hasCanteen = hasCanteen;
    }

    public int getCapacity() {
        return capacity;
    }
	
    public int spareCapacity() {
        return capacity - listOfCages.size();
    }
	
    /**
     * The addCage method add the cage for a specific zone
     * @param cage
     */
    public void addCage(Cage cage)
    {
        if(spareCapacity() != 0){
            listOfCages.add(cage);
        }
        else{
            throw new AssertionError("Capacity of the zone is full! Cannot add cage!");
        }
    }
	
    /**
     * This method will add animal to a specific cage
     * @param animal
     * @return true if animal added successfully, otherwise false
     */
    public boolean addAnimal(Animal animal)
    {
        boolean flag = false;
        for(Cage cage: listOfCages){
            if(cage.spareCapacity() != 0){
                flag = true;
                cage.addAnimal(animal);
                break;
            }	
        }
        if(!flag){
            throw new AssertionError("Capacity of the zone is full! Cannot add animal!");
        }				
        return flag;
    }
	
    /**
     * This method will remove the animal from specific cage
     * @param animal
     * @return true if remove successfully, otherwise false
     */
    public boolean removeAnimal(AnimalName animal){
        boolean removed = false;
        for(Cage cage: listOfCages){
            if(cage.getAnimalType().equals(animal))
                removed = cage.removeAnimal();
        }
        return removed;
   }
}