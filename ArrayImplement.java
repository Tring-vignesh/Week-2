public class ArrayImplement {
    public static void main(String[] args) {
        //Declare Array called Array
        int[] array = {2,7,2,3,17,22};
        //print last element
        System.out.println("Last element: " + array[array.length-1]); 
        //print fourth element(ie at index 3)
        System.out.println("Fourth element: " + array[3]); 
        //update the element
        array[3] = 22; 
        //print updated element
        System.out.println("Updated Fourth element: " + array[3]);
        //print all elements in array
        System.out.println("Array Elements:");
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element at index " + i + ": " + array[i]);
        }
        //increase array
        int[] newArray = new int[6]; 
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i]; 
        }
        //add new element
        newArray[5] = 60;
        System.out.println("New element added: " + newArray[5]);
        //print all elements in new array
        System.out.println("New Array:");
        for (int i : newArray) {
            System.out.println("Element at index " + i + ": " + newArray[i]);
        }
    }
}