import java.util.HashMap;

public class MobileStore {
    public static void main(String[] args) {
        HashMap<String, Integer> mobileStore = new HashMap<>();
        mobileStore.put("iPhone 14", 100000);
        mobileStore.put("Galaxy S23",90000);
        mobileStore.put("Pixel 7",76000);
        System.out.println(" Mobiles List: " + mobileStore);
        // Search  a mobile
        String searchModel = "Galaxy S23";
        if (mobileStore.containsKey(searchModel)) {
            System.out.println("Mobile : "+searchModel + "-  Price: Rs." + mobileStore.get(searchModel));
        } else {
            System.out.println("Mobile not found.");
        }
        // Remove a mobile
        mobileStore.remove("Pixel 7");
        System.out.println("After Remove : " + mobileStore);
    }
}
 