package lt.kaunascoding.view;

import lt.kaunascoding.model.DBSingleton;

import java.util.Scanner;

public class DBView {

    public void dirbam() {
        Scanner sc = new Scanner(System.in);
        boolean arTesti = true;
        String uzklausa="";
        while (arTesti) {
            showMenu();
            int pasirinkimas = sc.nextInt();
            switch (pasirinkimas) {
                case 0:
                    arTesti = false;
                    break;
                case 1:
                    uzklausa = "SELEC * FROM `students` ORDER BY `name` ASC;";
                    DBSingleton.getInstance().printQueryResult(uzklausa);
                    break;
            }
        }

    }

    private void showMenu() {
        System.out.println("Iveskite pasirinkima kokia operacija atliekam");
        System.out.println("0 - Baigti darba");
        System.out.println("1 - surikiuoti studentus abeceles tvarka");
    }
}
