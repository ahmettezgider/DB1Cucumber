package enumUsage;

import com.guidersoft.pageobjects.Menu;

public class TestTempMenu {

    public static void main(String[] args) {
        new TempMenu();

        TempMenu.HOME.click();
        TempMenu.AA.click();
        Menu.HOME.click();
    }
}
