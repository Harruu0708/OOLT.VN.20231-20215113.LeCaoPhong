package Classes;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if(qtyOrdered != 20) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        }
        else {
            System.out.println("The cart is almost full");
        }
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for(int i = 0; i < qtyOrdered; i++) {
            if(itemsOrdered[i].getTitle() == disc.getTitle()) {
                for(int j = i; j < qtyOrdered; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                i--;
                qtyOrdered--;
                System.out.println("The disc has been removed");
            }
        }
    }
    public float totalCost() {
        float total = 0;
        for(int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
    //public void addDigitalVideoDisc(DigitalVideoDisc dvdList){
        //     for (int i = 0 ; i < dvdList.length ; i++){
        //         this.addDigitalVideoDisc(dvdList[i]);
        //     }
        // }
        public void addDigitalVideoDisc(DigitalVideoDisc[] list){
            for (int i = 0 ; i < list.length ; i++){
                this.addDigitalVideoDisc(list[i]);
            }
        }
        public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2){
            this.addDigitalVideoDisc(dvd1);
            this.addDigitalVideoDisc(dvd2);
        }

        public int getQuatity (){
            return this.qtyOrdered;
        }

    }
