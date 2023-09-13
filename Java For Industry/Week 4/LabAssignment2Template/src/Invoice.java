public class Invoice {

    int id;
    String description;
    int quantity;
    double unitPrice;
    private boolean Paid; // Made private for the getter and setter methods

    public Invoice(int id, String description, int quantity, double unitPrice)
    {
        this.id = id;
        this.description = description;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        Paid = false;  // might not be this.paid
    }

    public String toString() // We're overriding the internal toString() method
    {
       //format "InvoiceItem[id=?, description=?, quantity=?, uniPrice= ?, paid=?]”

        return "InvoiceItem[id="+id+", description='"+description+"'" +
                ", quantity="+quantity+", unitPrice=$"+unitPrice+", paid="+Paid+"]";
    }

    public boolean getPaid() // Getter
    {
        return Paid;
    }

    public void setPaid(boolean flag) // Setter
    {
        this.Paid = flag;
    }

}
