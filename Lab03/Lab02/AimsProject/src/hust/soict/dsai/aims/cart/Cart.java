package hust.soict.dsai.aims.cart;
import java.util.Scanner;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] =
			new DigitalVideoDisc [MAX_NUMBERS_ORDERED];
	
    private int qtyOrdered = 0;
    public void addDigitalVideoDisc(DigitalVideoDisc dvd) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered++] = dvd;
            System.out.println("The disc has been added. ID: " + dvd.getId() +" Title: "+ dvd.getTitle());
        } else {
            System.out.println("The cart is almost full");
        }
    }
    
    public void removeDigitalVideoDisc(DigitalVideoDisc dvd) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == dvd) {
            	for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
            	--qtyOrdered;
                itemsOrdered[qtyOrdered] = null;
                System.out.println("dvd" + (i+1) + " has been removed");
                break;
            }
        }
    }
    
	public void addDigitalVideoDisc(DigitalVideoDisc [] divList) {
		for (DigitalVideoDisc dvd:divList) {
			addDigitalVideoDisc(dvd);
		}
	} 
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc1, DigitalVideoDisc disc2) {
		addDigitalVideoDisc(disc1);
		addDigitalVideoDisc(disc2);
	}
    
    public float totalCost() {
        float total = 0.0f;
        for (int i = 0; i < qtyOrdered; i++) {
            	total += itemsOrdered[i].getCost();
        }
        return total;
    }
    
    public void print() {
    	System.out.println("***********************CART***********************");
    	System.out.println("Ordered Items:");
    	for (int i = 0; i < qtyOrdered; i++) {
    		System.out.println(i+1 + itemsOrdered[i].toString());  
    	}
    	System.out.printf("Total cost: %.2f\n", totalCost());
    	System.out.println("***************************************************");
    }
    
    public void searchDvdById() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Search by ID: ");
		int id = scanner.nextInt();
		for (DigitalVideoDisc dvd: itemsOrdered) {
			if (dvd != null && dvd.getId() == id) {
				System.out.println(dvd.getId()+dvd.toString());
//				scanner.close();
				return;
			}
		}
		System.out.println("Not found!");
//		scanner.close();	
	}
    
    public void searchDvdByTitle() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Search by Title: ");
		String str = scanner.nextLine();
		boolean found = false;
		for (DigitalVideoDisc dvd: itemsOrdered) {
			 if (dvd != null && dvd.isMatch(str)) {
				System.out.println(dvd.getId()+dvd.toString());
				found = true;
			}
		}
		if (!found) System.out.println("Not found!");
//		scanner.close();
	}
    
}
