public enum City {
    HANTY("Ханты-Мансийск",150),
    NYAGAN("Нягань",150)
    ;

    private final String s;
    private final int price;
    City(String s, int price) {
        this.s = s;
        this.price = price;
    }

    public String getS() {
        return s;
    }

    public int getPrice() {
        return price;
    }

    public static City getByCity(String aCity){
        for (City str:City.values()) {
            if(str.getS().equals(aCity)){
                return str;
            }
        }
        return null;
    }
}
