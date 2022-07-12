package wishlistUnterricht;

public class PresentSorter {
    public void sortPresentsByDesire(Present[] presents) {
//Äußere Schleife
        for (int i = 1; i < presents.length ; i++) {
//Innere Schleife
            for (int j = i; j > 0 ; j--) {
                //Prüfen, ob Vergangen größer ist
                if (presents[j-1].desire > presents[j].desire){
                    Present temp = presents[j];
                    presents[j] = presents[j-1];
                    presents[j-1] = temp;
                }
                // Wnn nicht, kann innere Schleife abgebrochen werden
                else{
                    break;
                }
            }
        }
    }
}