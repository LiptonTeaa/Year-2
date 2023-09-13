public class Q1Main {
    public static void main(String[] args) {

        // InvoiceItem[id=?, description=?, quantity=?, uniPrice= ?, paid=?]
        Invoice xItem = new Invoice (20, "BreadLoaf", 1, 5.00);
        Invoice yItem = new Invoice (12, "Toaster", 1, 50.00);

        xItem.setPaid(true);
        yItem.setPaid(true);

        System.out.println(xItem);
        System.out.println(yItem);
    }
}
