package phonebooklab;

import java.util.*;
//import java.util.HashMap;

public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = new LinkedHashMap<>(map); // make the map into a LinkedHashMap and pass the map through the parameters
    }

    public PhoneBook() {
        this(new LinkedHashMap<>());// new LinkedHashMap
    }

    /**
     * Key is a name of type String
     * Value is a list of phone numbers of type ArrayList
     * If Key exists then get back existing list & add phone number into that list
     * Else create a new list and add that phone number into list, then use put method to put key and phone number into the Map
     * @param name
     * @param phoneNumber
     */
    public void add(String name, String phoneNumber) {
       if (phonebook.containsKey(name)){ // check if map contains the specific key(name)
           List<String> phoneNumbers = phonebook.get(name); //
           phoneNumbers.add(phoneNumber);
       }else {
           List<String> newPhoneNumbers = new ArrayList<>();
           newPhoneNumbers.add(phoneNumber);
           phonebook.put(name,newPhoneNumbers);
       }
    }
    /**
     * If the name exists
     * correlate all the numbers that belong to that name
     * turn the phone numbers into a list (listOfNumbers)
     * add all numbers that correlate to the name, to the list of numbers you just created
     * @param name
     * @param phoneNumbers
     */

    public void addAll(String name, String... phoneNumbers) {
        if (phonebook.containsKey(name)){
            List<String> existingPhoneNumbers = phonebook.get(name);
            List<String> listOfNumbers = Arrays.asList(phoneNumbers);
            existingPhoneNumbers.addAll(listOfNumbers);
        }else {
            List<String> newPhoneNumbers = new ArrayList<>(Arrays.asList(phoneNumbers));
            phonebook.put(name,newPhoneNumbers);
        }
    }

    /**
     * if the name exists , remove the name
     * else the name doesn't exist, print name doesn't exist
     * @param name
     */
    public void remove(String name) {
        if(phonebook.containsKey(name)){
            phonebook.remove(name);
        }else {
            System.out.println("Name does not exist.");
        }
    }

    /**
     * if the key exists (name) then return true
     * else, return false
     * @param name
     * @return
     */
    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name); //Check if the phonebook contains the specific name and return true if it contains it, false if it does not
    }

    /**
     * lookup the key(name) and return all values(phone numbers) associated with that name.
     * @param name
     * @return
     */
    public List<String> lookup(String name) {
       return phonebook.get(name);
    }

    /**
     * Lookup the phone number in the map
     * if the map contains the number, return the name associated with the phone number
     * if the number doesn't exist return "Number not found"
     * @param phoneNumber
     * @return
     */
    public String reverseLookup(String phoneNumber)  {
        for(Map.Entry<String, List<String>> entry : phonebook.entrySet()){
            List<String> numbers = entry.getValue();
            if (numbers.contains(phoneNumber)){
                return entry.getKey();
            }else {
                System.out.println("Number not found");
            }
        }
        return null;
    }

    public List<String> getAllContactNames() {
        return new ArrayList<>(phonebook.keySet()); // Turns all Keys (names) into an ArrayList of names & returns that list.
    }

    public Map<String, List<String>> getMap() { //Return the map
         return phonebook;
    }
}
