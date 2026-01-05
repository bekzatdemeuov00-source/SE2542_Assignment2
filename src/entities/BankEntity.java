package entities;

abstract class BankEntity {
    private String id;
    public BankEntity(String id) {this.id = id;}
    public String getId() {return id;}
    public abstract void show();
    @Override
    public abstract boolean equals(Object obj);
    @Override
    public abstract int hashCode();
}
