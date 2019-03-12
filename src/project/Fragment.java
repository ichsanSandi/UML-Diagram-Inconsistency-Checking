package project;

import java.util.ArrayList;
import java.util.List;

public class Fragment {
    private String id;
    private String covered;
    static ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();

    public void setCovered(String covered) {
        this.covered = covered;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCovered() {
        return this.covered;
    }

    public String getId() {
        return this.id;
    }

    public void addFragmentList(Fragment fragment){
        fragmentList.add(fragment);
    }

    public static void printFragmentList(){
        Fragment fragment = new Fragment();
        System.out.println("\nFRAGMENT");
        for (int fragmentCounter = 0; fragmentCounter < fragmentList.size(); fragmentCounter++){
            fragment = fragmentList.get(fragmentCounter);
            System.out.println("id" + (fragmentCounter + 1) + ": " + fragment.getId());
            System.out.println("covered" + (fragmentCounter + 1) + ": " + fragment.getCovered());
        }
    }


}
