package project;

import java.util.ArrayList;

public class Fragment {
    private String id;
    private String covered;
    static ArrayList<Fragment> fragmentList = new ArrayList<>();

    void setCovered(String covered) {
        this.covered = covered;
    }

    void setId(String id) {
        this.id = id;
    }

    String getCovered() {
        return this.covered;
    }

    String getId() {
        return this.id;
    }

    void addFragmentList(Fragment fragment){
        fragmentList.add(fragment);
    }

    public static void printFragmentList(){
        Fragment fragment;
        System.out.println("\nFRAGMENT");
        for (int fragmentCounter = 0; fragmentCounter < fragmentList.size(); fragmentCounter++){
            fragment = fragmentList.get(fragmentCounter);
            System.out.println("id" + (fragmentCounter + 1) + ": " + fragment.getId());
            System.out.println("covered" + (fragmentCounter + 1) + ": " + fragment.getCovered());
        }
    }


}
